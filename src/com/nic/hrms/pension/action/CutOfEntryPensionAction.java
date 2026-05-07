package com.nic.hrms.pension.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.AddNominee_dao;
import com.nic.hrms.pension.model.AjaxLoad_dao;
import com.nic.hrms.pension.model.CurrentAcMainOffice_dao;
import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.model.Grade_dao;
import com.nic.hrms.pension.model.LastWorkingOffice_dao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.AjaxLoad_service;
import com.nic.hrms.pension.service.CutOfEntryPension_service;
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


public class CutOfEntryPensionAction extends BaseAction{

	/**
	 * Add New Pensioner Cut Off Entry save Action  
	 * 
	 */
	private static final long serialVersionUID = -2488328207919138173L;
	
	private CutOfEntryPension_service cutOffEntry;
	
	private CutOffEntryPension_dao mstcutoffentry;
	private AjaxLoad_service ajaxservice;
	private List<AjaxLoad_dao> ajaxload;
	private Grade_service gradeservice;
	private List<Grade_dao> gradeload;
	private List<LastWorkingOffice_dao> lastworkingload;
	private LastWorkingOfficeCombo_service lastservice;
	private List<ClassOfpensionCombo_dao> classload;
	private ClassPensionCombo_service classpenservice;
	private AddNominee_service addnomineeservice;
	private AddNominee_dao addmoninee;
	private List<CurrentAcMainOffice_dao> officeload;
	private CurrentAcMainOffice_service officeservice;
	private List<State_dao> stateload;
	private State_service stateservice;
	private List<PensionPaymentOffice_dao> paymentload;
	private PensionPaymentOffice_service paymentservice;
	private OfficeId_service officeIdservice;
	private UpdatedUserIdService updateservice;

	
	private File familyPhoto;
	private File signatureAttachment;
	private File otherAttachment;
	private List<String> familyMembers;
	private List<String> relation;
	private List<String> dob;
	private List<Integer> age;
	private List<String> martialStatus;
	private List<String> handicapped;
	private String nominationDate;
	private List<AddNominee_dao> multidatlist;
	private List<String> nomineeInitial;
	private String checkStatus;

		
	public String load() {
		try{
			
			    HttpSession session=getRequest().getSession();
		        UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		        int empId=empProfile.getEmployeeId();
			
			    int officeId = officeIdservice.getOfficeId(empId);
			    
			   	ajaxload = ajaxservice.getListOfBank();
				gradeload = gradeservice.getGrade();
				lastworkingload = lastservice.getListWorkingOffice();
				classload = classpenservice.getClassOfPension();
				officeload = officeservice.getListOfOffice(); 
				stateload = stateservice.getListOfstate();
				paymentload = paymentservice.getListOfPayOffice(officeId);
				
							
				
		 }catch(Exception e){
			e.printStackTrace();
		  }

		return SUCCESS;
	}
	

	
@SuppressWarnings("unchecked")
public String saveCutOffOnSubmit(){		
	    boolean nomflag = false;
	 
	    int cutempId=0;
		try{
			
			
				HttpSession session=getRequest().getSession();
				UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
				cutempId=empProfile.getEmployeeId();		
				String updatedId=updateservice.getUpdateId(cutempId);
				mstcutoffentry.setUpdatedUserId(updatedId);
				mstcutoffentry.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));		
			
						
			if(familyMembers != null){
				
				Iterator iter = familyMembers.iterator();
				Iterator iter1 = dob.iterator();
				Iterator iter2 = age.iterator();
				Iterator iter3 = relation.iterator();
				Iterator iter4 = martialStatus.iterator();
				Iterator iter5 = handicapped.iterator();
				Iterator iter6 = age.iterator();
				Iterator iter7 = nomineeInitial.iterator();
				
				AddNominee_dao multidata=null;
			    multidatlist = new ArrayList<AddNominee_dao>();
			    
			    while(iter.hasNext()){
			    		multidata = new AddNominee_dao();
			    		multidata.setNomineeInitial((String)iter7.next());
			    		multidata.setNominationDate((String)nominationDate);		    	
			    		multidata.setFamilyMembers((String)iter.next());
			    		multidata.setPpoNo(mstcutoffentry.getPpoNo());
			    	  	multidata.setDob((String) iter1.next());
			    	  	
			    	  	if(iter6.next() == null){
			    	  		multidata.setAge(0);
			    	  	}else{
			    	        multidata.setAge((Integer) iter2.next());
			    	  	}
			         	
			    	  	multidata.setRelation((String) iter3.next());
			            multidata.setMartialStatus((String) iter4.next());			    	
			    	    multidata.setHandicapped((String) iter5.next());		  
			    	    multidata.setUpdatedUserId(updatedId);
			    	    multidata.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	    
			    	multidatlist.add(multidata);			    	
			     }			   
			    nomflag=addnomineeservice.saveAddnominee(multidatlist);
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
				System.out.println("------------->The value is not been the same");
			}
			
			
		boolean flag1=cutOffEntry.saveCutOff(mstcutoffentry);		
		
		
		if(!flag1)
		{
			return ERROR;
		}
		
		load();
		
		}
		
		catch (Exception e) 		
		{
			e.printStackTrace();			
		}
		
		return SUCCESS;
		
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


	public AddNominee_dao getAddmoninee() {
		return addmoninee;
	}


	public void setAddmoninee(AddNominee_dao addmoninee) {
		this.addmoninee = addmoninee;
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


	public List<AddNominee_dao> getMultidatlist() {
		return multidatlist;
	}


	public void setMultidatlist(List<AddNominee_dao> multidatlist) {
		this.multidatlist = multidatlist;
	}


	public File getFamilyPhoto() {
		return familyPhoto;
	}

	public void setFamilyPhoto(File familyPhoto) {
		this.familyPhoto = familyPhoto;
	}

	public File getSignatureAttachment() {
		return signatureAttachment;
	}

	public void setSignatureAttachment(File signatureAttachment) {
		this.signatureAttachment = signatureAttachment;
	}

	public File getOtherAttachment() {
		return otherAttachment;
	}

	public void setOtherAttachment(File otherAttachment) {
		this.otherAttachment = otherAttachment;
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

	public CutOffEntryPension_dao getMstcutoffentry() {
		return mstcutoffentry;
	}

	public void setMstcutoffentry(CutOffEntryPension_dao mstcutoffentry) {
		this.mstcutoffentry = mstcutoffentry;
	}

	public CutOfEntryPension_service getCutOffEntry() {
		return cutOffEntry;
	}

	public void setCutOffEntry(CutOfEntryPension_service cutOffEntry) {
		this.cutOffEntry = cutOffEntry;
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


	public List<String> getDob() {
		return dob;
	}

	public void setDob(List<String> dob) {
		this.dob = dob;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public List<String> getNomineeInitial() {
		return nomineeInitial;
	}

	public void setNomineeInitial(List<String> nomineeInitial) {
		this.nomineeInitial = nomineeInitial;
	}

	public String getNominationDate() {
		return nominationDate;
	}

	public void setNominationDate(String nominationDate) {
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
