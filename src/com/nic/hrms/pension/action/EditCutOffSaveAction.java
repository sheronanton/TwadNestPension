

package com.nic.hrms.pension.action;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.AddNominee_dao;
import com.nic.hrms.pension.model.AjaxCombo_dao;
import com.nic.hrms.pension.model.AjaxLoad_dao;
import com.nic.hrms.pension.model.CurrentAcMainOffice_dao;
import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.model.DesignationCombo_dao;
import com.nic.hrms.pension.model.Grade_dao;
import com.nic.hrms.pension.model.LastWorkingOffice_dao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.AddNomineeDelete_service;
import com.nic.hrms.pension.service.AjaxLoad_service;
import com.nic.hrms.pension.service.BranchList_service;
import com.nic.hrms.pension.service.Desiggroup_service;
import com.nic.hrms.pension.service.EditAddNominee_service;
import com.nic.hrms.pension.service.EditCutOffSave_service;
import com.nic.hrms.pension.service.Grade_service;
import com.nic.hrms.pension.service.LastWorkingOfficeCombo_service;
import com.nic.hrms.pension.service.ClassPensionCombo_service;
import com.nic.hrms.pension.service.AddNominee_service;
import com.nic.hrms.pension.service.PensionPaymentOffice_service;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;
import com.nic.hrms.pension.model.ClassOfpensionCombo_dao;
import com.nic.hrms.pension.service.CurrentAcMainOffice_service;
import com.nic.hrms.pension.service.OfficeId_service;


public class EditCutOffSaveAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2488328207919138173L;
	
	private CutOffEntryPension_dao mstcutoffentry;
	private EditCutOffSave_service editcutoffsave;
	private CutOffEntryPension_dao mstcutoff;
	private AjaxLoad_service ajaxservice;
	private List<AjaxLoad_dao> ajaxload;
	private Grade_service gradeservice;
	private List<Grade_dao> gradeload;
	private List<LastWorkingOffice_dao> lastworkingload;
	private LastWorkingOfficeCombo_service lastservice;
	private List<ClassOfpensionCombo_dao> classload;
	private ClassPensionCombo_service classpenservice;
	private List<DesignationCombo_dao> desigload;
	private Desiggroup_service desiservice;
	private List<AjaxCombo_dao> branchload;
	private BranchList_service branchservice;
	private List<AddNominee_dao> NomineeLoad;
	private EditAddNominee_service nomineeservice;
	private List<PensionPaymentOffice_dao> paymentload;
	private PensionPaymentOffice_service paymentservice;
	private AddNominee_service addnomineeservice;
	private UpdatedUserIdService updateservice;

	private List<CurrentAcMainOffice_dao> officeload;
	private CurrentAcMainOffice_service officeservice;
	private List<State_dao> stateload;
	private State_service stateservice;
	private AddNomineeDelete_service deleteservice;
	private OfficeId_service officeIdservice;
	
	
	private List<String> familyMembers;
	private List<String> relation;
	private List<String> dob;
	private List<Integer> age;
	private List<String> martialStatus;
	private List<String> handicapped;
	private List<AddNominee_dao> multidatlist1;
	private List<String> nominationDate;
	private List<String> nomineeInitial;
	private String checkStatus;

	
	public String load(int loadPpoNo,int officeId) {
		try
		{
			ajaxload = ajaxservice.getListOfBank();
			gradeload = gradeservice.getGrade();
			lastworkingload = lastservice.getListWorkingOffice();
			classload = classpenservice.getClassOfPension();
			officeload = officeservice.getListOfOffice(); 
			stateload = stateservice.getListOfstate();
			desigload = desiservice.getListOfDesig(loadPpoNo);
			branchload = branchservice.getBranchList(loadPpoNo,officeId);
			paymentload = paymentservice.getListOfPayOffice(officeId);
								
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	
	
	
@SuppressWarnings("unchecked")
public String editSaveCutOffSubmit(){
	
		try{
			addNomineeDelete();

			   HttpSession session=getRequest().getSession();
		       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		       int empId=empProfile.getEmployeeId();
		       
			   int officeId = officeIdservice.getOfficeId(empId);
				
			   String updatedId=updateservice.getUpdateId(empId);
			   mstcutoffentry.setUpdatedUserId(updatedId);
			   mstcutoffentry.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			   
			   
			   
			   
			if(familyMembers != null && familyMembers.size()!= 0){
				Iterator iter = familyMembers.iterator();
				Iterator iter1 = dob.iterator();
				Iterator iter2 = age.iterator();
				Iterator iter3 = relation.iterator();
				Iterator iter4 = martialStatus.iterator();
				Iterator iter5 = handicapped.iterator();
				Iterator iter6 = nominationDate.iterator();
				Iterator iter7 = nomineeInitial.iterator();
			    
				AddNominee_dao multidata=null;
			    multidatlist1 = new ArrayList<AddNominee_dao>();
			    
			     while(iter.hasNext()){
			    	multidata = new AddNominee_dao();			
			    	multidata.setFamilyMembers((String)iter.next());
			    	multidata.setPpoNo( mstcutoffentry.getPpoNo());
			    	multidata.setDob((String) iter1.next());
			    	multidata.setAge((Integer) iter2.next());
			    	multidata.setRelation((String) iter3.next());
			    	multidata.setMartialStatus((String) iter4.next());
			    	multidata.setHandicapped((String) iter5.next());
			    	multidata.setNominationDate((String)iter6.next());
			    	multidata.setNomineeInitial((String)iter7.next());
			    	multidata.setUpdatedUserId(updatedId);
			    	multidata.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidatlist1.add(multidata);
		        }
			   
			    addnomineeservice.saveAddnominee(multidatlist1);
			}

		
		   
		   
			if(checkStatus.equalsIgnoreCase("yes"))
			{
				mstcutoffentry.setProcessStatus("PARTIAL");
			}
			
			else if(checkStatus.equalsIgnoreCase("no"))
			{
				mstcutoffentry.setProcessStatus("ENTERED");	
			}
			else
			{
				System.out.println("------------------------------>error in check status");
			}
			
			boolean flag1=editcutoffsave.editSaveCutOff(mstcutoffentry);			
			
			if(!flag1)
			{
				return ERROR;
			}
			
			load(mstcutoffentry.getPpoNo(),officeId);
					
			}
		
		
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("------------------------------------->error in saving the file");
			
		}
		
		return SUCCESS;
		}
	
	
		public void addNomineeDelete(){
			try
			{
			    deleteservice.addNomineeDelete(mstcutoffentry.getPpoNo());
			}
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	
	
	public List<String> getNomineeInitial() {
			return nomineeInitial;
		}

	public void setNomineeInitial(List<String> nomineeInitial) {
			this.nomineeInitial = nomineeInitial;
		}

	public AddNomineeDelete_service getDeleteservice() {
			return deleteservice;
		}

	public void setDeleteservice(AddNomineeDelete_service deleteservice) {
			this.deleteservice = deleteservice;
		}

	public List<PensionPaymentOffice_dao> getPaymentload() {
		return paymentload;
	}


	public void setPaymentload(List<PensionPaymentOffice_dao> paymentload) {
		this.paymentload = paymentload;
	}


	public PensionPaymentOffice_service getPaymentservice() {
		return paymentservice;
	}


	public void setPaymentservice(PensionPaymentOffice_service paymentservice) {
		this.paymentservice = paymentservice;
	}


	public AddNominee_service getAddnomineeservice() {
		return addnomineeservice;
	}


	public void setAddnomineeservice(AddNominee_service addnomineeservice) {
		this.addnomineeservice = addnomineeservice;
	}


	public List<String> getFamilyMembers() {
		return familyMembers;
	}


	public void setFamilyMembers(List<String> familyMembers) {
		this.familyMembers = familyMembers;
	}


	public List<String> getRelation() {
		return relation;
	}


	public void setRelation(List<String> relation) {
		this.relation = relation;
	}


	public List<Integer> getAge() {
		return age;
	}


	public void setAge(List<Integer> age) {
		this.age = age;
	}


	public List<String> getMartialStatus() {
		return martialStatus;
	}


	public void setMartialStatus(List<String> martialStatus) {
		this.martialStatus = martialStatus;
	}


	public List<String> getHandicapped() {
		return handicapped;
	}


	public void setHandicapped(List<String> handicapped) {
		this.handicapped = handicapped;
	}


	public List<AddNominee_dao> getMultidatlist1() {
		return multidatlist1;
	}


	public void setMultidatlist1(List<AddNominee_dao> multidatlist1) {
		this.multidatlist1 = multidatlist1;
	}

	public List<ClassOfpensionCombo_dao> getClassload() {
		return classload;
	}

	public void setClassload(List<ClassOfpensionCombo_dao> classload) {
		this.classload = classload;
	}

	public ClassPensionCombo_service getClasspenservice() {
		return classpenservice;
	}

	public void setClasspenservice(ClassPensionCombo_service classpenservice) {
		this.classpenservice = classpenservice;
	}

	public List<AjaxLoad_dao> getAjaxload() {
		return ajaxload;
	}

	public void setAjaxload(List<AjaxLoad_dao> ajaxload) {
		this.ajaxload = ajaxload;
	}

	public List<LastWorkingOffice_dao> getLastworkingload() {
		return lastworkingload;
	}

	public void setLastworkingload(List<LastWorkingOffice_dao> lastworkingload) {
		this.lastworkingload = lastworkingload;
	}



	public List<Grade_dao> getGradeload() {
		return gradeload;
	}

	public void setGradeload(List<Grade_dao> gradeload) {
		this.gradeload = gradeload;
	}

	public Grade_service getGradeservice() {
		return gradeservice;
	}

	public void setGradeservice(Grade_service gradeservice) {
		this.gradeservice = gradeservice;
	}

	public AjaxLoad_service getAjaxservice() {
		return ajaxservice;
	}

	public void setAjaxservice(AjaxLoad_service ajaxservice) {
		this.ajaxservice = ajaxservice;
	}


	public LastWorkingOfficeCombo_service getLastservice() {
		return lastservice;
	}


	public void setLastservice(LastWorkingOfficeCombo_service lastservice) {
		this.lastservice = lastservice;
	}


	public List<CurrentAcMainOffice_dao> getOfficeload() {
		return officeload;
	}


	public void setOfficeload(List<CurrentAcMainOffice_dao> officeload) {
		this.officeload = officeload;
	}


	public CurrentAcMainOffice_service getOfficeservice() {
		return officeservice;
	}


	public void setOfficeservice(CurrentAcMainOffice_service officeservice) {
		this.officeservice = officeservice;
	}


	public List<State_dao> getStateload() {
		return stateload;
	}


	public void setStateload(List<State_dao> stateload) {
		this.stateload = stateload;
	}


	public State_service getStateservice() {
		return stateservice;
	}

	public void setStateservice(State_service stateservice) {
		this.stateservice = stateservice;
	}

	public CutOffEntryPension_dao getMstcutoff() {
		return mstcutoff;
	}


	public void setMstcutoff(CutOffEntryPension_dao mstcutoff) {
		this.mstcutoff = mstcutoff;
	}


	public List<DesignationCombo_dao> getDesigload() {
		return desigload;
	}


	public void setDesigload(List<DesignationCombo_dao> desigload) {
		this.desigload = desigload;
	}


	public Desiggroup_service getDesiservice() {
		return desiservice;
	}


	public void setDesiservice(Desiggroup_service desiservice) {
		this.desiservice = desiservice;
	}


	public List<AjaxCombo_dao> getBranchload() {
		return branchload;
	}


	public void setBranchload(List<AjaxCombo_dao> branchload) {
		this.branchload = branchload;
	}


	public BranchList_service getBranchservice() {
		return branchservice;
	}


	public void setBranchservice(BranchList_service branchservice) {
		this.branchservice = branchservice;
	}


	public List<AddNominee_dao> getNomineeLoad() {
		return NomineeLoad;
	}


	public void setNomineeLoad(List<AddNominee_dao> nomineeLoad) {
		NomineeLoad = nomineeLoad;
	}


	public EditAddNominee_service getNomineeservice() {
		return nomineeservice;
	}


	public void setNomineeservice(EditAddNominee_service nomineeservice) {
		this.nomineeservice = nomineeservice;
	}


	public EditCutOffSave_service getEditcutoffsave() {
		return editcutoffsave;
	}

	public void setEditcutoffsave(EditCutOffSave_service editcutoffsave) {
		this.editcutoffsave = editcutoffsave;
	}


	public CutOffEntryPension_dao getMstcutoffentry() {
		return mstcutoffentry;
	}


	public void setMstcutoffentry(CutOffEntryPension_dao mstcutoffentry) {
		this.mstcutoffentry = mstcutoffentry;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public List<String> getDob() {
		return dob;
	}

	public void setDob(List<String> dob) {
		this.dob = dob;
	}


	public List<String> getNominationDate() {
		return nominationDate;
	}

	public void setNominationDate(List<String> nominationDate) {
		this.nominationDate = nominationDate;
	}

	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}

	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}
	
	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}


	

}
