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
import com.nic.hrms.pension.model.PensionApplicationForm2MstDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNotVerifyServDao;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationValidateForm2Service;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class PensionApplicationValidateForm2Action extends BaseAction {

	
	/**
	 * Validate Pension Application Form 2 
	 */
	private static final long serialVersionUID = -2897326384067247059L;
	
	private PensionApplicationValidateForm2Service penappvalservice;	
	private CommonSearchModel penAppVal;
	
	
	private int penAppValHiddenEmpId;
	private OfficeId_service officeIdservice;
	private State_service stateservice;
	private PensionerPaymentOfficeService paymentservice1;
	private List<State_dao> stateList;
	private List<PensionPaymentOffice_dao> payOfficeList;
	
	private PensionApplicationForm2Dao valpenappdata;
	private List<PensionApplicationNomineeDao> valpenappnom;
	private List<PensionApplicationNotVerifyServDetailsDao> valpenappnvser;
	
	private UpdatedUserIdService updateservice;	
	private PensionApplicationForm2MstDao valpenappco;
	
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
	private List<PensionApplicationForm2MstNomineeDao> nomineeList1;
	private ReligionService religionService;
	private List<ReligionDao> religionCombo;
	
	
	private List<String> notVerifyServFromDate;
	private List<String> notVerifyServToDate;
	private List<String> notVerifyServiceReason;
	private List<Integer> notVerifyYear;
	private List<Integer> notVerifyMonth;
	private List<Integer> notVerifyDays;
	private List<PensionApplicationForm2MstNotVerifyServDao> notVerifyList2;
	
	private String empDesign=null;
	private String empOfficeName=null; 
	public String validateSearch()
	{
		String option=penAppVal.getSearchOption().trim();
		String keyword=penAppVal.getSearchKeyword().trim();		
		boolean mypenAppFlag = false;
		
		List<Object[]> myList1;
		int empId=0;				
		System.out.println("inside action VALIDATE .....");
		try
			{			
				StringBuffer xmlString = new StringBuffer();
				PrintWriter out = getResponse().getWriter();
				xmlString.append("<response>");			
			
				HttpSession session=getRequest().getSession();
				UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
				empId=empProfile.getEmployeeId();							
					
				myList1=penappvalservice.getEmpDetails(option, keyword, empId);		
				 xmlString.append("<command>validatesearch</command>");
				
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
			
			catch(Exception e)
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
			/*HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();				    
		   int officeId = officeIdservice.getOfficeId(empId);	*/
			stateList=stateservice.getListOfstates();			 
			payOfficeList = paymentservice1.getListOfPayOffice();
			religionCombo=religionService.getReligionList();
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
				
	}
	

	public String loadValidateData()
	{	
		try
		{
			loadCombo();
			valpenappdata=penappvalservice.getExistingData(penAppValHiddenEmpId);	
			valpenappnom=penappvalservice.getListOfValidNominee(penAppValHiddenEmpId);
			valpenappnvser=penappvalservice.getListOfValidNotVerSer(penAppValHiddenEmpId);
			empDesign=penappvalservice.getDesignation(penAppValHiddenEmpId);
			empOfficeName=penappvalservice.getOffice(penAppValHiddenEmpId);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}

	
	@SuppressWarnings("unchecked")
	public String saveValidateData()
	{
		boolean myFlag=false;
		boolean myFlag1=false;
		try
		{
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();
		    String updatedId=updateservice.getUpdateId(empId);
		    
			valpenappco.setProcessStatus("VALIDATE");
			valpenappco.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			valpenappco.setUpdatedUser(updatedId);
			
			myFlag=penappvalservice.saveOrUpdateData(valpenappco);
			
			if(familyMembers!=null && familyMembers.size()>0)
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
				
				PensionApplicationForm2MstNomineeDao multidata1=null;
				nomineeList1 = new ArrayList<PensionApplicationForm2MstNomineeDao>();
			    
			     while(iter.hasNext())
			     {
			    	multidata1 = new PensionApplicationForm2MstNomineeDao();	
			    	multidata1.setEmpNo(valpenappco.getEmpNo());
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
			    	multidata1.setProcessStatus("VALIDATE");
			    	nomineeList1.add(multidata1);			    	
		        }
			   
			     penappvalservice.saveAddnominee(nomineeList1);
				
			
			}
			
			
			if(notVerifyServFromDate!=null && notVerifyServFromDate.size()>0)
			{
				
				Iterator it1=notVerifyServFromDate.iterator();
				Iterator it2=notVerifyServToDate.iterator();
				Iterator it3=notVerifyServiceReason.iterator();
				Iterator it4=notVerifyYear.iterator();
				Iterator it5=notVerifyMonth.iterator();
				Iterator it6=notVerifyDays.iterator();
				
			
				PensionApplicationForm2MstNotVerifyServDao multidata3=null;
				notVerifyList2 = new ArrayList<PensionApplicationForm2MstNotVerifyServDao>();
		
				while(it1.hasNext())
				{
					multidata3=new PensionApplicationForm2MstNotVerifyServDao();
					multidata3.setEmpNo(valpenappco.getEmpNo());
					multidata3.setNotVerifyServFromDate((String) it1.next());
					multidata3.setNotVerifyServToDate((String) it2.next());
					multidata3.setNotVerifyServiceReason((String)it3.next());
					multidata3.setNotVerifyYear((Integer)it4.next());
					multidata3.setNotVerifyMonth((Integer)it5.next());
					multidata3.setNotVerifyDays((Integer)it6.next());							
					
					multidata3.setUpdatedUserId(updatedId);
			    	multidata3.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidata3.setProcessStatus("VALIDATE");
			    	notVerifyList2.add(multidata3);
				}
				
				penappvalservice.saveNotVerifyService(notVerifyList2);
					
				
				boolean delFlag1=penappvalservice.deleteNomineeCo(valpenappco.getEmpNo());
				boolean delFlag2=penappvalservice.deleteNVServiceCo(valpenappco.getEmpNo());
				
				
			}
			
			myFlag1=penappvalservice.setMstProcessStatus(valpenappco.getEmpNo());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		
		if(!myFlag || !myFlag1)
			return ERROR;
		else
			return SUCCESS;
	}
	 

	public PensionApplicationValidateForm2Service getPenappvalservice() {
		return penappvalservice;
	}

	public void setPenappvalservice(
			PensionApplicationValidateForm2Service penappvalservice) {
		this.penappvalservice = penappvalservice;
	}

	public void setPenAppVal(CommonSearchModel penAppVal) {
		this.penAppVal = penAppVal;
	}


	public CommonSearchModel getPenAppVal() {
		return penAppVal;
	}

	public void setPenAppValHiddenEmpId(int penAppValHiddenEmpId) {
		this.penAppValHiddenEmpId = penAppValHiddenEmpId;
	}

	public int getPenAppValHiddenEmpId() {
		return penAppValHiddenEmpId;
	}


	public void setPayOfficeList(List<PensionPaymentOffice_dao> payOfficeList) {
		this.payOfficeList = payOfficeList;
	}


	public List<PensionPaymentOffice_dao> getPayOfficeList() {
		return payOfficeList;
	}


	public void setStateList(List<State_dao> stateList) {
		this.stateList = stateList;
	}


	public List<State_dao> getStateList() {
		return stateList;
	}


	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}


	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}


	public State_service getStateservice() {
		return stateservice;
	}


	public void setStateservice(State_service stateservice) {
		this.stateservice = stateservice;
	}


	public PensionerPaymentOfficeService getPaymentservice1() {
		return paymentservice1;
	}


	public void setPaymentservice1(PensionerPaymentOfficeService paymentservice1) {
		this.paymentservice1 = paymentservice1;
	}


	public PensionApplicationForm2Dao getValpenappdata() {
		return valpenappdata;
	}


	public void setValpenappdata(PensionApplicationForm2Dao valpenappdata) {
		this.valpenappdata = valpenappdata;
	}


	public List<PensionApplicationNomineeDao> getValpenappnom() {
		return valpenappnom;
	}


	public void setValpenappnom(List<PensionApplicationNomineeDao> valpenappnom) {
		this.valpenappnom = valpenappnom;
	}


	public List<PensionApplicationNotVerifyServDetailsDao> getValpenappnvser() {
		return valpenappnvser;
	}


	public void setValpenappnvser(
			List<PensionApplicationNotVerifyServDetailsDao> valpenappnvser) {
		this.valpenappnvser = valpenappnvser;
	}


	

	public PensionApplicationForm2MstDao getValpenappco() {
		return valpenappco;
	}


	public void setValpenappco(PensionApplicationForm2MstDao valpenappco) {
		this.valpenappco = valpenappco;
	}


	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}


	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
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


	public List<PensionApplicationForm2MstNomineeDao> getNomineeList1() {
		return nomineeList1;
	}


	public void setNomineeList1(
			List<PensionApplicationForm2MstNomineeDao> nomineeList1) {
		this.nomineeList1 = nomineeList1;
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


	public List<PensionApplicationForm2MstNotVerifyServDao> getNotVerifyList2() {
		return notVerifyList2;
	}


	public void setNotVerifyList2(
			List<PensionApplicationForm2MstNotVerifyServDao> notVerifyList2) {
		this.notVerifyList2 = notVerifyList2;
	}


	public void setEmpOfficeName(String empOfficeName) {
		this.empOfficeName = empOfficeName;
	}


	public String getEmpOfficeName() {
		return empOfficeName;
	}


	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}


	public String getEmpDesign() {
		return empDesign;
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

