package com.nic.hrms.pension.action;

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
import com.nic.hrms.pension.service.AjaxLoad_service;
import com.nic.hrms.pension.service.BranchList_service;
import com.nic.hrms.pension.service.Desiggroup_service;
import com.nic.hrms.pension.service.EditAddNominee_service;
import com.nic.hrms.pension.service.EditCutOfEntryPension_service;
import com.nic.hrms.pension.service.Grade_service;
import com.nic.hrms.pension.service.LastWorkingOfficeCombo_service;
import com.nic.hrms.pension.service.ClassPensionCombo_service;
import com.nic.hrms.pension.service.LastWorkingOfficeService;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionPaymentOffice_service;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.model.ClassOfpensionCombo_dao;
import com.nic.hrms.pension.service.CurrentAcMainOffice_service;






public class EditCutOfEntryAction extends BaseAction  {

	/**
	 *  Edit Cut Off Entry Action 
	 */
	private static final long serialVersionUID = -1026915019583213776L;
	
	private List<CutOffEntryPension_dao> mstcutoffentry;
	private CutOffEntryPension_dao mstcutoff;
	private AjaxLoad_service ajaxservice;
	private List<AjaxLoad_dao> ajaxload;
	private Grade_service gradeservice;
	private List<Grade_dao> gradeload;
	private List<LastWorkingOffice_dao> lastworkingload;
	private LastWorkingOfficeCombo_service lastservice;
	private List<ClassOfpensionCombo_dao> classload;
	private ClassPensionCombo_service classpenservice;
	private EditCutOfEntryPension_service editcutservice;
	private List<DesignationCombo_dao> desigload;
	private Desiggroup_service desiservice;
	private List<AjaxCombo_dao> branchload;
	private BranchList_service branchservice;
	private List<AddNominee_dao> NomineeLoad;
	private EditAddNominee_service nomineeservice;
	private List<PensionPaymentOffice_dao> paymentload;
	private PensionPaymentOffice_service paymentservice;
	private OfficeId_service officeIdservice;
	

	private List<CurrentAcMainOffice_dao> officeload;
	private CurrentAcMainOffice_service officeservice;
	private List<State_dao> stateload;
	private State_service stateservice;
	private String officeIdList;
	private int searchPpoNo;
	private UserProfile somethings;
	private PensionPaymentOffice_dao paytest;
	
	
	
	private LastWorkingOfficeService officeService;
	List<Object[]> listoffice;
	
	

	public void load(int officeIdNo){
		  
		 	ajaxload = ajaxservice.getListOfBank();
			gradeload = gradeservice.getGrade();
			lastworkingload = lastservice.getListWorkingOffice();
			classload = classpenservice.getClassOfPension();
			officeload = officeservice.getListOfOffice(); 
			stateload = stateservice.getListOfstate();
			desigload = desiservice.getListOfDesig(searchPpoNo);
			branchload = branchservice.getBranchList(searchPpoNo,officeIdNo);
			paymentload = paymentservice.getListOfPayOffice(officeIdNo);
		
			System.out.println("....>>>>>paymentload......>>>>"+paymentload.size());
	}
			

	
	public String editCutOfEntry(){
	
		try{
			
			int empId=0;
			try
			{
			HttpSession session=getRequest().getSession();
			System.out.println("Attrib list baabu:"+session.getAttributeNames());
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			
		    empId=empProfile.getEmployeeId();
			
			
			}
			catch(Exception e)
			{
				System.out.println("Error in Getting Session Value");
			}
			int officeId = officeIdservice.getOfficeId(empId);
			System.out.println("inside action call value for office id is..."+officeId);
			//System.out.println("------------------------------->current session value="+getRequest().getSession().getAttribute("UserId").toString());
			load(officeId);
			
			int ppoNo=searchPpoNo;			
			mstcutoff = editcutservice.getListOfEdit(ppoNo);
			//System.out.println("------------------------------->payment office id ="+mstcutoff.getPaymentOfficeId());
				
			//editLastworkingoffice(mstcutoff.getLastWorkingOfficeId());
			
			editLastworkingoffice(mstcutoff.getLastWorkingOfficeId()==null?0:mstcutoff.getLastWorkingOfficeId());
			
			
			//System.out.println("------------------------------------>lastworking office id -"+mstcutoff.getLastWorkingOfficeId());
			//System.out.println("Current Acnt ofc id--"+mstcutoff.getCurrAccountOfficeId());	
			
			editAddNominee(searchPpoNo);	
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in getting the value for edit"+e);
		}
		
		return SUCCESS;
	}
	
	
	public void editAddNominee(int ppoNoList){
		
	  try{
		  NomineeLoad = nomineeservice.getListOfEditNominee(ppoNoList);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	
	}

	


	public void editLastworkingoffice(int workingOfficeId){
		try {
			  //System.out.println("------------------------------------->lastworking office id"+workingOfficeId);
			  
			  listoffice=officeService.getOfficeDetails(workingOfficeId);			  
			  for(Object[] tl: listoffice)
				 {					
				  officeIdList =""+tl[1];							
					////System.out.println("------------------------------>officeid"+tl);					
					//System.out.println("------------------------------>officeid"+officeIdList);
				 }
			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
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

	public BranchList_service getBranchservice() {
		return branchservice;
	}

	public void setBranchservice(BranchList_service branchservice) {
		this.branchservice = branchservice;
	}

	public List<AjaxCombo_dao> getBranchload() {
		return branchload;
	}

	public void setBranchload(List<AjaxCombo_dao> branchload) {
		this.branchload = branchload;
	}

	public EditCutOfEntryPension_service getEditcutservice() {
		return editcutservice;
	}

	public void setEditcutservice(EditCutOfEntryPension_service editcutservice) {
		this.editcutservice = editcutservice;
	}

	public List<CutOffEntryPension_dao> getMstcutoffentry() {
		return mstcutoffentry;
	}

	public void setMstcutoffentry(List<CutOffEntryPension_dao> mstcutoffentry) {
		this.mstcutoffentry = mstcutoffentry;
	}

	public AjaxLoad_service getAjaxservice() {
		return ajaxservice;
	}

	public void setAjaxservice(AjaxLoad_service ajaxservice) {
		this.ajaxservice = ajaxservice;
	}

	public List<AjaxLoad_dao> getAjaxload() {
		return ajaxload;
	}

	public void setAjaxload(List<AjaxLoad_dao> ajaxload) {
		this.ajaxload = ajaxload;
	}

	public Grade_service getGradeservice() {
		return gradeservice;
	}

	public void setGradeservice(Grade_service gradeservice) {
		this.gradeservice = gradeservice;
	}

	public List<Grade_dao> getGradeload() {
		return gradeload;
	}

	public void setGradeload(List<Grade_dao> gradeload) {
		this.gradeload = gradeload;
	}

	public List<LastWorkingOffice_dao> getLastworkingload() {
		return lastworkingload;
	}

	public void setLastworkingload(List<LastWorkingOffice_dao> lastworkingload) {
		this.lastworkingload = lastworkingload;
	}

	public LastWorkingOfficeCombo_service getLastservice() {
		return lastservice;
	}

	public void setLastservice(LastWorkingOfficeCombo_service lastservice) {
		this.lastservice = lastservice;
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

	
	public Desiggroup_service getDesiservice() {
		return desiservice;
	}

	public void setDesiservice(Desiggroup_service desiservice) {
		this.desiservice = desiservice;
	}

	public List<DesignationCombo_dao> getDesigload() {
		return desigload;
	}

	public void setDesigload(List<DesignationCombo_dao> desigload) {
		this.desigload = desigload;
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

	public void setOfficeService(LastWorkingOfficeService officeService) {
		this.officeService = officeService;
	}

	public LastWorkingOfficeService getOfficeService() {
		return officeService;
	}

	public List<Object[]> getListoffice() {
		return listoffice;
	}

	public void setListoffice(List<Object[]> listoffice) {
		this.listoffice = listoffice;
	}

	public String getOfficeIdList() {
		return officeIdList;
	}

	public void setOfficeIdList(String officeIdList) {
		this.officeIdList = officeIdList;
	}

	public int getSearchPpoNo() {
		return searchPpoNo;
	}

	public void setSearchPpoNo(int searchPpoNo) {
		this.searchPpoNo = searchPpoNo;
	}

	public UserProfile getSomethings() {
		return somethings;
	}

	public void setSomethings(UserProfile somethings) {
		this.somethings = somethings;
	}

	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}

	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}

	public PensionPaymentOffice_dao getPaytest() {
		return paytest;
	}

	public void setPaytest(PensionPaymentOffice_dao paytest) {
		this.paytest = paytest;
	}

	
}

	