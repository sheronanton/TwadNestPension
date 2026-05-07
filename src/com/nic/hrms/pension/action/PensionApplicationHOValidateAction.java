package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.PensionApplicationHODetailsCoDao;
import com.nic.hrms.pension.model.PensionApplicationHODetailsValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeCoDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceCoDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceValidateDao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationHOValidateService;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class PensionApplicationHOValidateAction extends BaseAction {

	/**
	 * Pension Application HO Validate Class
	 */
	private static final long serialVersionUID = 1L;
	private PensionApplicationHOValidateService penapphovalservice;
	private List<Object[]> loadAllData=null;
	private List<Object[]> searchData=null;

	private CommonSearchModel penappho;
	private int HiddenSelectedNo;
	
	private PensionerPaymentOfficeService paymentservice1;	
	private List<PensionPaymentOffice_dao> payOfficeList;
	private State_service stateservice;
	private List<State_dao> stateList;	
	private ReligionService religionService;
	private List<ReligionDao> religionCombo;
	private PensionApplicationHODetailsCoDao penapphoco;
	private List<PensionApplicationHONomineeCoDao> penapphonom;
	private List<PensionApplicationHOServiceCoDao> penapphoser;	
	private PensionApplicationHODetailsValidateDao penapphoval;
	private PensionApplicationHONomineeValidateDao penapphonomval;
	private PensionApplicationHOServiceValidateDao penapphoserval;
	
	
	private OfficeId_service officeIdservice;
	private UpdatedUserIdService updateservice;
	
	
	private List<PensionApplicationHONomineeValidateDao> nomineeList;
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
	
	private List<PensionApplicationHOServiceValidateDao> notVerifyList;
	private List<String> notVerifyServFromDate;
	private List<String> notVerifyServToDate;
	private List<String> notVerifyServiceReason;
	private List<Integer> notVerifyYear;
	private List<Integer> notVerifyMonth;
	private List<Integer> notVerifyDays;
	
	private String designStr;
	private String officeStr;
	private Integer DesiginationId;
	private String penapfrzchk;
	
	public String searchOperation()
	{
		
		try
		{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			boolean penAppFlag=false;
			
			loadAllData=penapphovalservice.getListEmp();
			System.out.println("LOAD ALL DATA....>>>>"+loadAllData.size());			
			xmlString.append("<command>PenAppValidate</command>");		    
		    for(Object[] tl: loadAllData)
			 {
				Object[] temp=tl;
	   	     	 xmlString.append("<record>");				 
				 xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
				 xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");				
				 xmlString.append("<design>" +temp[2]+ "</design>");
				 xmlString.append("<office>" +temp[3]+ "</office>");
				 xmlString.append("</record>");	
				 penAppFlag=true;
			 }		    
		    if(penAppFlag)
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
			
		}
		return SUCCESS;
	}
	
	
	public String searchOperation2()
	{		
		try
		{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			boolean penAppFlag=false;			
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();
		
		    String keyword =penappho.getSearchKeyword().trim();
		    String option =penappho.getSearchOption().trim();
			
		    searchData=penapphovalservice.getSearchList(keyword, option, empId);
			System.out.println("LOAD ALL DATA....>>>>"+searchData.size());			
			xmlString.append("<command>PenAppValidateSearch</command>");		    
		    for(Object[] tl: searchData)
			 {
				Object[] temp=tl;
	   	     	 xmlString.append("<record>");				 
				 xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
				 xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");				
				 xmlString.append("<design>" +temp[2]+ "</design>");
				 xmlString.append("<office>" +temp[3]+ "</office>");
				 xmlString.append("</record>");	
				 penAppFlag=true;
			 }		    
		    if(penAppFlag)
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

	public String loadEditData()
	{
		try
		{
			System.out.println("...>>>><<<<>>>><>>><<<>>"+HiddenSelectedNo);
			loadCombo();
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int loginEmpId=empProfile.getEmployeeId();
		    int officeId = officeIdservice.getOfficeId(loginEmpId);	
		    
		    String penapfrzchk = penapphovalservice.getFreezdata(HiddenSelectedNo);
		    System.out.println("...===>"+penapfrzchk);
		    penapphoco=penapphovalservice.commonData(HiddenSelectedNo,loginEmpId,officeId);
			penapphonom=penapphovalservice.listHOEditNominee(HiddenSelectedNo,loginEmpId,officeId);
			penapphoser=penapphovalservice.listHOEditService(HiddenSelectedNo,loginEmpId,officeId);
			int siz=penapphonom.size();
			System.out.println(".size of I..===>"+siz);
			//Integer designationid=
			DesiginationId=penapphovalservice.penAppEmpdesigination(HiddenSelectedNo,officeId);
			if(DesiginationId!=null && DesiginationId!=0)
			{
				designStr=penapphovalservice.getDesignation(DesiginationId);
			}
			/*if(penapphoco.getDesigId()!=null)
			{
				designStr=penapphovalservice.getDesignation(penapphoco.getDesigId());
			}*/
			if(penapphoco.getOfficeId()!=null)
			{
				officeStr=penapphovalservice.getOfficeName(penapphoco.getOfficeId());
			}
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
			stateList=stateservice.getListOfstates();			
			payOfficeList = paymentservice1.getListOfPayOffice();
			religionCombo=religionService.getReligionList();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	public String saveFreezeData()
	{
		System.out.println("........................>>>>>>>>.Save Validate \n");
		  
		
		HttpSession session=getRequest().getSession();
	       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
	       int empId=empProfile.getEmployeeId();
	       
		   int officeId = officeIdservice.getOfficeId(empId);				
		   String updatedId=updateservice.getUpdateId(empId);	
		
		try
		{
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
		    
			PensionApplicationHONomineeValidateDao multidata=null;
			nomineeList = new ArrayList<PensionApplicationHONomineeValidateDao>();
		    
		     while(iter.hasNext()){
		    	multidata = new PensionApplicationHONomineeValidateDao();	
		    	multidata.setEmpNo(penapphoco.getEmpNo());
		    	multidata.setFamilyMembers((String)iter.next());
		    	multidata.setNomineeInitial((String)iter1.next());
		    	multidata.setRelation((String)iter3.next());
		    	multidata.setNomineeDob((String)iter4.next());
		    	multidata.setNomineeAge((Integer)iter5.next());
		    	multidata.setHandicapped((String)iter6.next());
		    	multidata.setMartialStatus((String)iter7.next());
		    	multidata.setNominationDate((String)iter8.next());
		    	multidata.setActiveStatus((String)iter9.next());
		    	multidata.setNominReason((String)iter10.next());
		    
		    	multidata.setUpdatedUserId(updatedId);
		    	multidata.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		    	multidata.setProcessStatus("VALIDATE");
		    	nomineeList.add(multidata);
		    	
	        }
		     
		     
		     penapphovalservice.saveNominee(nomineeList);
		}
		
		if(notVerifyServFromDate!=null && notVerifyServFromDate.size()>0)
		{
			
			Iterator it1=notVerifyServFromDate.iterator();
			Iterator it2=notVerifyServToDate.iterator();
			Iterator it3=notVerifyServiceReason.iterator();
			Iterator it4=notVerifyYear.iterator();
			Iterator it5=notVerifyMonth.iterator();
			Iterator it6=notVerifyDays.iterator();
			
		
			PensionApplicationHOServiceValidateDao multidata2=null;
			notVerifyList = new ArrayList<PensionApplicationHOServiceValidateDao>();
	
			while(it1.hasNext())
			{
				multidata2=new PensionApplicationHOServiceValidateDao();
				multidata2.setEmpNo(penapphoco.getEmpNo());
				multidata2.setNotVerifyServFromDate((String) it1.next());
				multidata2.setNotVerifyServToDate((String) it2.next());
				multidata2.setNotVerifyServiceReason((String)it3.next());
				multidata2.setNotVerifyYear((Integer)it4.next());
				multidata2.setNotVerifyMonth((Integer)it5.next());
				multidata2.setNotVerifyDays((Integer)it6.next());							
				
				multidata2.setUpdatedUserId(updatedId);
		    	multidata2.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		    	multidata2.setProcessStatus("VALIDATE");
		    	notVerifyList.add(multidata2);
			}
			
			penapphovalservice.saveNotVerifyService(notVerifyList);
		}
		
		penapphoval.setUpdatedUser(updatedId);
		penapphoval.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		penapphoval.setProcessStatus("VALIDATE");
		penapphovalservice.saveorUpdateData(penapphoval);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
			
		}
		
		
		return SUCCESS;
		
	}
	
	public void setPenapphovalservice(PensionApplicationHOValidateService penapphovalservice) {
		this.penapphovalservice = penapphovalservice;
	}

	public PensionApplicationHOValidateService getPenapphovalservice() {
		return penapphovalservice;
	}


	public List<Object[]> getLoadAllData() {
		return loadAllData;
	}


	public void setLoadAllData(List<Object[]> loadAllData) {
		this.loadAllData = loadAllData;
	}


	public CommonSearchModel getPenappho() {
		return penappho;
	}


	public void setPenappho(CommonSearchModel penappho) {
		this.penappho = penappho;
	}


	public List<Object[]> getSearchData() {
		return searchData;
	}


	public void setSearchData(List<Object[]> searchData) {
		this.searchData = searchData;
	}


	public void setHiddenSelectedNo(int hiddenSelectedNo) {
		HiddenSelectedNo = hiddenSelectedNo;
	}


	public int getHiddenSelectedNo() {
		return HiddenSelectedNo;
	}


	public PensionerPaymentOfficeService getPaymentservice1() {
		return paymentservice1;
	}


	public void setPaymentservice1(PensionerPaymentOfficeService paymentservice1) {
		this.paymentservice1 = paymentservice1;
	}


	public List<PensionPaymentOffice_dao> getPayOfficeList() {
		return payOfficeList;
	}


	public void setPayOfficeList(List<PensionPaymentOffice_dao> payOfficeList) {
		this.payOfficeList = payOfficeList;
	}


	public State_service getStateservice() {
		return stateservice;
	}


	public void setStateservice(State_service stateservice) {
		this.stateservice = stateservice;
	}


	public List<State_dao> getStateList() {
		return stateList;
	}


	public void setStateList(List<State_dao> stateList) {
		this.stateList = stateList;
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


	public void setPenapphoco(PensionApplicationHODetailsCoDao penapphoco) {
		this.penapphoco = penapphoco;
	}


	public PensionApplicationHODetailsCoDao getPenapphoco() {
		return penapphoco;
	}


	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}


	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}


	public void setPenapphonom(List<PensionApplicationHONomineeCoDao> penapphonom) {
		this.penapphonom = penapphonom;
	}


	public List<PensionApplicationHONomineeCoDao> getPenapphonom() {
		return penapphonom;
	}


	public void setPenapphoser(List<PensionApplicationHOServiceCoDao> penapphoser) {
		this.penapphoser = penapphoser;
	}


	public List<PensionApplicationHOServiceCoDao> getPenapphoser() {
		return penapphoser;
	}


	public void setPenapphoval(PensionApplicationHODetailsValidateDao penapphoval) {
		this.penapphoval = penapphoval;
	}


	public PensionApplicationHODetailsValidateDao getPenapphoval() {
		return penapphoval;
	}


	public PensionApplicationHONomineeValidateDao getPenapphonomval() {
		return penapphonomval;
	}


	public void setPenapphonomval(
			PensionApplicationHONomineeValidateDao penapphonomval) {
		this.penapphonomval = penapphonomval;
	}


	public PensionApplicationHOServiceValidateDao getPenapphoserval() {
		return penapphoserval;
	}


	public void setPenapphoserval(
			PensionApplicationHOServiceValidateDao penapphoserval) {
		this.penapphoserval = penapphoserval;
	}


	public List<PensionApplicationHONomineeValidateDao> getNomineeList() {
		return nomineeList;
	}


	public void setNomineeList(
			List<PensionApplicationHONomineeValidateDao> nomineeList) {
		this.nomineeList = nomineeList;
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


	public List<PensionApplicationHOServiceValidateDao> getNotVerifyList() {
		return notVerifyList;
	}


	public void setNotVerifyList(
			List<PensionApplicationHOServiceValidateDao> notVerifyList) {
		this.notVerifyList = notVerifyList;
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


	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}


	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}


	public String getDesignStr() {
		return designStr;
	}


	public void setDesignStr(String designStr) {
		this.designStr = designStr;
	}

	public String getPenApFrzChek() {
		return penapfrzchk;
	}


	public void setPenApFrzChek(String penapfrzchk) {
		this.penapfrzchk = penapfrzchk;
	}

	public String getOfficeStr() {
		return officeStr;
	}


	public void setOfficeStr(String officeStr) {
		this.officeStr = officeStr;
	}


	public Integer getDesiginationId() {
		return DesiginationId;
	}


	public void setDesiginationId(Integer desiginationId) {
		DesiginationId = desiginationId;
	}
	
}
