package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.AjaxLoad_service;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationAddForm2Service;
import com.nic.hrms.pension.service.PensionApplicationEditForm2Service;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class PensionApplicationEditForm2Action extends BaseAction {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3956176743506793809L;
	private CommonSearchModel penAppEdit;
	private PensionApplicationEditForm2Service penAppEditService;
	private int penAppEditHiddenEmpId;
	
	
	
	private OfficeId_service officeIdservice;
	private AjaxLoad_service ajaxservice;
	private List<State_dao> stateList;
	private State_service stateservice;
	private List<PensionPaymentOffice_dao> payOfficeList;
	private UpdatedUserIdService updateservice;
	private PensionerPaymentOfficeService paymentservice1;

	private PensionApplicationForm2Dao editpenappdata;
	private List<PensionApplicationNomineeDao> editpenappnom;
	private List<PensionApplicationNotVerifyServDetailsDao> editpenappnvs;
	
	private PensionApplicationForm2Dao editpenappco;
	private Integer empNo;
	private String checkStatus;
	private PensionApplicationAddForm2Service penappform2service;
	private ReligionService religionService;
	private List<ReligionDao> religionCombo;
	
	
	private List<String> nomineeInitial;
	private List<String> familyMembers;	
	private List<String> relation;	
	private List<String> nomineeDob;	
	private List<Integer> nomineeAge;
	private List<String> handicapped;
	private List<String> martialStatus;
	private List<String> nominationDate;
	private List<String> activeStatus;
	private List<String> nominReason;	
	private List<PensionApplicationNomineeDao> nomineeList1;
	
	private List<String> notVerifyServFromDate;
	private List<String> notVerifyServToDate;
	private List<String> notVerifyServiceReason;
	private List<Integer> notVerifyYear;
	private List<Integer> notVerifyMonth;
	private List<Integer> notVerifyDays;
	private List<PensionApplicationNotVerifyServDetailsDao> notVerifyList1;
	
	private String empDesig=null;
	private String officeName=null;
	public String SearchOperation()
	{
		
		List<Object[]> myList1;
		int empId=0;
		boolean mypenAppFlag = false;
		try
		{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId=empProfile.getEmployeeId();
				
			String opt=penAppEdit.getSearchOption();
			String key=penAppEdit.getSearchKeyword();
			
			myList1=penAppEditService.getListEmp(opt,key,empId);
			
			
			xmlString.append("<command>search</command>");
		
		    
		    for(Object[] tl: myList1)
			 {
				Object[] temp=tl;
	   	     	 xmlString.append("<record>");				 
				 xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
				 xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");				
				 xmlString.append("<processStatus>" +temp[2]+ "</processStatus>");
				 xmlString.append("</record>");	
				 mypenAppFlag=true;
	      }
		    
		    if(mypenAppFlag)
		    {
		    	xmlString.append("<flag>success</flag>");
		    }
		    else
		    {
		    	xmlString.append("<flag>fail</flag>");
		    }
		    
		     xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 System.out.println(xmlString.toString());
			 out.println(xmlString.toString());
			 out.flush();
			 out.close();
			 
			
		}
		catch (Exception e) 
		{
				e.printStackTrace();
				return ERROR;
		}
		
		return SUCCESS;
	}


	public void loadCombo()
	{		
		try
		{
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();			
		    
		    int officeId = officeIdservice.getOfficeId(empId);			    
			stateList=stateservice.getListOfstate();
			//payOfficeList = paymentservice.getListOfPayOffice(officeId);				 
			payOfficeList = paymentservice1.getListOfPayOffice();
			religionCombo=religionService.getReligionList();
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
				
	}
	
	
	public String loadEditData()
	{
		
		loadCombo();		
		editpenappdata=penAppEditService.getExistingData(penAppEditHiddenEmpId);				
		editpenappnom=penAppEditService.getListOfEditNominee(penAppEditHiddenEmpId);		
		editpenappnvs=penAppEditService.getListOfEditNotVerSer(penAppEditHiddenEmpId);
		empDesig=penAppEditService.getDesignation(penAppEditHiddenEmpId);
		officeName=penAppEditService.getOffice(penAppEditHiddenEmpId);	
	
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	public String saveEditData()
	{
		
	    boolean Flag=false;	    
		try
		{
			
			deleteNominee();
			deleteNotVerify();
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();
		    String updatedId=updateservice.getUpdateId(empId);
		    
			if(checkStatus.equalsIgnoreCase("yes"))
			{				
				editpenappco.setProcessStatus("PARTIAL");						
			}
			
			else if(checkStatus.equalsIgnoreCase("no"))
			{
				editpenappco.setProcessStatus("ENTERED");
			}
			
		
			editpenappco.setUpdatedUser(updatedId);
			editpenappco.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		    
		Flag=penappform2service.saveOrUpdateData(editpenappco);
		    
			  
			 
			if(familyMembers != null && familyMembers.size()!= 0)
			{
				
				Iterator iter1 = nomineeInitial.iterator();
				Iterator iter = familyMembers.iterator();
				Iterator iter3 = relation.iterator();				
				Iterator iter4 = nomineeDob.iterator();
				Iterator iter5 = nomineeAge.iterator();
				Iterator iter6 = handicapped.iterator();
				Iterator iter7 = martialStatus.iterator();
				Iterator iter8 = nominationDate.iterator();
				Iterator iter9 = activeStatus.iterator();
				Iterator iter10 = nominReason.iterator();
			    
				PensionApplicationNomineeDao multidata1=null;
				nomineeList1 = new ArrayList<PensionApplicationNomineeDao>();
			    
			     while(iter.hasNext()){
			    	multidata1 = new PensionApplicationNomineeDao();	
			    	multidata1.setEmpNo(editpenappco.getEmpNo());
			    	multidata1.setFamilyMembers((String)iter.next());
			    	multidata1.setNomineeInitial((String)iter1.next());
			    	multidata1.setRelation((String)iter3.next());
			    	multidata1.setNomineeDob((String)iter4.next());
			    	multidata1.setNomineeAge((Integer)iter5.next());
			    	multidata1.setHandicapped((String)iter6.next());
			    	multidata1.setMartialStatus((String)iter7.next());
			    	multidata1.setNominationDate((String)iter8.next());
			    	multidata1.setActiveStatus((String)iter9.next());			    	
			    	multidata1.setNominReason((String)iter10.next());
			    
			    	multidata1.setUpdatedUserId(updatedId);
			    	multidata1.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidata1.setProcessStatus("ENTERED");
			    	nomineeList1.add(multidata1);
			    	
		        }
			    penappform2service.saveAddnominee(nomineeList1);
			     
			}
			
			if(notVerifyServFromDate!=null && notVerifyServFromDate.size()>0)
			{
				
				Iterator it1=notVerifyServFromDate.iterator();
				Iterator it2=notVerifyServToDate.iterator();
				Iterator it3=notVerifyServiceReason.iterator();
				Iterator it4=notVerifyYear.iterator();
				Iterator it5=notVerifyMonth.iterator();
				Iterator it6=notVerifyDays.iterator();
				
			
				PensionApplicationNotVerifyServDetailsDao multidata3=null;
				notVerifyList1 = new ArrayList<PensionApplicationNotVerifyServDetailsDao>();
		
				while(it1.hasNext())
				{
					multidata3=new PensionApplicationNotVerifyServDetailsDao();
					multidata3.setEmpNo(editpenappco.getEmpNo());
					multidata3.setNotVerifyServFromDate((String) it1.next());
					multidata3.setNotVerifyServToDate((String) it2.next());
					multidata3.setNotVerifyServiceReason((String)it3.next());
					multidata3.setNotVerifyYear((Integer)it4.next());
					multidata3.setNotVerifyMonth((Integer)it5.next());
					multidata3.setNotVerifyDays((Integer)it6.next());							
					
					multidata3.setUpdatedUserId(updatedId);
			    	multidata3.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidata3.setProcessStatus("ENTERED");
			    	notVerifyList1.add(multidata3);
				}
				
				penappform2service.saveNotVerifyService(notVerifyList1);
			}
			
			 
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
		
		
		if(Flag)
		{
		return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
	
	
	public void deleteNominee()
	{	
		try
		{			
			penappform2service.addNomineeDelete(editpenappco.getEmpNo());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void deleteNotVerify()
	{
		try
		{
			penappform2service.deleteNotVerify(editpenappco.getEmpNo());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setPenAppEdit(CommonSearchModel penAppEdit) {
		this.penAppEdit = penAppEdit;
	}


	public CommonSearchModel getPenAppEdit() {
		return penAppEdit;
	}


	public PensionApplicationEditForm2Service getPenAppEditService() {
		return penAppEditService;
	}


	public void setPenAppEditService(
			PensionApplicationEditForm2Service penAppEditService) {
		this.penAppEditService = penAppEditService;
	}



	public void setPenAppEditHiddenEmpId(int penAppEditHiddenEmpId) {
		this.penAppEditHiddenEmpId = penAppEditHiddenEmpId;
	}



	public int getPenAppEditHiddenEmpId() {
		return penAppEditHiddenEmpId;
	}


	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}


	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}


	public AjaxLoad_service getAjaxservice() {
		return ajaxservice;
	}


	public void setAjaxservice(AjaxLoad_service ajaxservice) {
		this.ajaxservice = ajaxservice;
	}


	public List<State_dao> getStateList() {
		return stateList;
	}


	public void setStateList(List<State_dao> stateList) {
		this.stateList = stateList;
	}


	public State_service getStateservice() {
		return stateservice;
	}


	public void setStateservice(State_service stateservice) {
		this.stateservice = stateservice;
	}


	public List<PensionPaymentOffice_dao> getPayOfficeList() {
		return payOfficeList;
	}


	public void setPayOfficeList(List<PensionPaymentOffice_dao> payOfficeList) {
		this.payOfficeList = payOfficeList;
	}



	/*public PensionPaymentOffice_service getPaymentservice() {
		return paymentservice;
	}


	public void setPaymentservice(PensionPaymentOffice_service paymentservice) {
		this.paymentservice = paymentservice;
	}*/


	public void setEditpenappdata(PensionApplicationForm2Dao editpenappdata) {
		this.editpenappdata = editpenappdata;
	}




	public PensionerPaymentOfficeService getPaymentservice1() {
		return paymentservice1;
	}


	public void setPaymentservice1(PensionerPaymentOfficeService paymentservice1) {
		this.paymentservice1 = paymentservice1;
	}


	public PensionApplicationForm2Dao getEditpenappdata() {
		return editpenappdata;
	}


	public void setEditpenappnom(List<PensionApplicationNomineeDao> editpenappnom) {
		this.editpenappnom = editpenappnom;
	}


	public List<PensionApplicationNomineeDao> getEditpenappnom() {
		return editpenappnom;
	}


	public void setEditpenappnvs(List<PensionApplicationNotVerifyServDetailsDao> editpenappnvs) {
		this.editpenappnvs = editpenappnvs;
	}


	public List<PensionApplicationNotVerifyServDetailsDao> getEditpenappnvs() {
		return editpenappnvs;
	}


	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}


	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}


	public void setEditpenappco(PensionApplicationForm2Dao editpenappco) {
		this.editpenappco = editpenappco;
	}


	public PensionApplicationForm2Dao getEditpenappco() {
		return editpenappco;
	}


	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}


	public Integer getEmpNo() {
		return empNo;
	}


	public PensionApplicationAddForm2Service getPenappform2service() {
		return penappform2service;
	}


	public void setPenappform2service(
			PensionApplicationAddForm2Service penappform2service) {
		this.penappform2service = penappform2service;
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


	public List<String> getNomineeDob() {
		return nomineeDob;
	}


	public void setNomineeDob(List<String> nomineeDob) {
		this.nomineeDob = nomineeDob;
	}


	public List<Integer> getNomineeAge() {
		return nomineeAge;
	}


	public void setNomineeAge(List<Integer> nomineeAge) {
		this.nomineeAge = nomineeAge;
	}


	public List<String> getHandicapped() {
		return handicapped;
	}


	public void setHandicapped(List<String> handicapped) {
		this.handicapped = handicapped;
	}


	public List<String> getMartialStatus() {
		return martialStatus;
	}


	public void setMartialStatus(List<String> martialStatus) {
		this.martialStatus = martialStatus;
	}


	public List<String> getNominationDate() {
		return nominationDate;
	}


	public void setNominationDate(List<String> nominationDate) {
		this.nominationDate = nominationDate;
	}


	public List<String> getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(List<String> activeStatus) {
		this.activeStatus = activeStatus;
	}


	public List<String> getNominReason() {
		return nominReason;
	}


	public void setNominReason(List<String> nominReason) {
		this.nominReason = nominReason;
	}


	public List<String> getNotVerifyServFromDate() {
		return notVerifyServFromDate;
	}


	public void setNotVerifyServFromDate(List<String> notVerifyServFromDate) {
		this.notVerifyServFromDate = notVerifyServFromDate;
	}


	public List<String> getNotVerifyServToDate() {
		return notVerifyServToDate;
	}


	public void setNotVerifyServToDate(List<String> notVerifyServToDate) {
		this.notVerifyServToDate = notVerifyServToDate;
	}


	public List<String> getNotVerifyServiceReason() {
		return notVerifyServiceReason;
	}


	public void setNotVerifyServiceReason(List<String> notVerifyServiceReason) {
		this.notVerifyServiceReason = notVerifyServiceReason;
	}


	public List<Integer> getNotVerifyYear() {
		return notVerifyYear;
	}


	public void setNotVerifyYear(List<Integer> notVerifyYear) {
		this.notVerifyYear = notVerifyYear;
	}


	public List<Integer> getNotVerifyMonth() {
		return notVerifyMonth;
	}


	public void setNotVerifyMonth(List<Integer> notVerifyMonth) {
		this.notVerifyMonth = notVerifyMonth;
	}


	public List<Integer> getNotVerifyDays() {
		return notVerifyDays;
	}


	public void setNotVerifyDays(List<Integer> notVerifyDays) {
		this.notVerifyDays = notVerifyDays;
	}


	public void setNomineeList1(List<PensionApplicationNomineeDao> nomineeList1) {
		this.nomineeList1 = nomineeList1;
	}


	public List<PensionApplicationNomineeDao> getNomineeList1() {
		return nomineeList1;
	}


	public void setNotVerifyList1(List<PensionApplicationNotVerifyServDetailsDao> notVerifyList1) {
		this.notVerifyList1 = notVerifyList1;
	}


	public List<PensionApplicationNotVerifyServDetailsDao> getNotVerifyList1() {
		return notVerifyList1;
	}


	public String getEmpDesig() {
		return empDesig;
	}


	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}


	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}


	public String getOfficeName() {
		return officeName;
	}


	public ReligionService getReligionService() {
		return religionService;
	}


	public void setReligionService(ReligionService religionService) {
		this.religionService = religionService;
	}


	public List<ReligionDao> getReligionCombo() {
		return religionCombo;
	}


	public void setReligionCombo(List<ReligionDao> religionCombo) {
		this.religionCombo = religionCombo;
	}

	
}
