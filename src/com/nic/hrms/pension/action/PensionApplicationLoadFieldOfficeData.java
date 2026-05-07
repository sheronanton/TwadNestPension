package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNotVerifyServDao;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationLoadFieldOfficeDataService;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;

public class PensionApplicationLoadFieldOfficeData extends BaseAction{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4086182780693420924L;
	private PensionApplicationLoadFieldOfficeDataService penappfielddataservice;
	private List<Object[]> fieldOffDataList;
	private List<Object[]> fieldOffDataList2;
	private CommonSearchModel fielddata;
	
	private String HiddenSelectedNo;	
	private PensionerPaymentOfficeService paymentservice1;	
	private State_service stateservice;
	private OfficeId_service officeIdservice;
	private List<State_dao> stateList;	
	private List<PensionPaymentOffice_dao> payOfficeList;
	private ReligionService religionService;
	private List<ReligionDao> religionCombo;
	private List<Object[]> fieldDataDetails;
	private PensionApplicationForm2MstDao loadFieldOfficeData;
	private List<PensionApplicationForm2MstNomineeDao> loadFieldOfficeNominee;
	private List<PensionApplicationForm2MstNotVerifyServDao> loadFieldOfficeService;
	private String strDesignation;
	private String strOfficeName;
	private PensionApplicationSearchModel penappsearch;
	
	public String loadData()
	{
		System.out.println("Inside Load Data Method");		
		StringBuffer xmlString = new StringBuffer();		
		xmlString.append("<response>");
		xmlString.append("<command>LoadAllData</command>");		
		boolean flag=false;
		try
		{
		
		PrintWriter out = getResponse().getWriter();	
		fieldOffDataList=penappfielddataservice.loadAllData();		
	
		for(Object[] tl: fieldOffDataList)
		 {
			Object[] temp=tl;
			xmlString.append("<record>");					
			xmlString.append("<empNo>"+temp[0]+"</empNo>");				
			xmlString.append("<empName>"+temp[1]+"</empName>");
			xmlString.append("<design>"+temp[2]+"</design>");
			xmlString.append("<office>"+temp[3]+"</office>");						
			xmlString.append("</record>");	
			flag=true;
			System.out.println("loading data ----->>>>>"+temp[0]+"-"+temp[1]+"-"+temp[2]+"-"+temp[3]);	
		 }
		
		if(flag)
		{
			xmlString.append("<flag>true</flag>");	
		}
		else
		{
			xmlString.append("<flag>false</flag>");	
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
		}
		
		
		return SUCCESS;
		
	}
	
	

	public String searchData()
	{
		System.out.println("Inside Search Data Method");		
		StringBuffer xmlString = new StringBuffer();		
		xmlString.append("<response>");
		xmlString.append("<command>LoadSearchData</command>");		
		boolean flag=false;
		try
		{
		
		PrintWriter out = getResponse().getWriter();			
		HttpSession session=getRequest().getSession();
	    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
	    int empId=empProfile.getEmployeeId();
	
	    String keyword =fielddata.getSearchKeyword().trim();
	    String option =fielddata.getSearchOption().trim();
	   
		fieldOffDataList2=penappfielddataservice.searchData(option, keyword, empId);		
	System.out.println("SIZE22==="+fieldOffDataList2.size());
		for(Object[] tl: fieldOffDataList2)
		 {
			Object[] temp=tl;
			xmlString.append("<record>");					
			xmlString.append("<empNo>"+temp[0]+"</empNo>");				
			xmlString.append("<empName>"+temp[1]+"</empName>");
			xmlString.append("<design>"+temp[2]+"</design>");
			xmlString.append("<office>"+temp[3]+"</office>");						
			xmlString.append("</record>");	
			flag=true;
		 }
		
		if(flag)
		{
			xmlString.append("<flag>true</flag>");	
		}
		else
		{
			xmlString.append("<flag>false</flag>");	
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
		}
			
		return SUCCESS;
		
	}
	
	public String loadApplicationData()
	{
		System.out.println("SERACH FORM SUBMIT.....>>>>>>>>>"+HiddenSelectedNo);
		try
		{
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();					    
		    
			stateList=stateservice.getListOfstates();			
			payOfficeList = paymentservice1.getListOfPayOffice();
			religionCombo=religionService.getReligionList();
			
			System.out.println("stateList-> "+stateList);
			System.out.println("payOfficeList-> "+payOfficeList);
			
		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String loadFieldOfficeData()
	{
		
		try
		{
			System.out.println("Selected EMP...");
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();					    
		    
			int officeId = officeIdservice.getOfficeId(empId);
		    int selectedId=penappsearch.getEmpId();

			loadFieldOfficeData=penappfielddataservice.loadFieldOfficeData(empId,officeId,selectedId);
			loadFieldOfficeNominee=penappfielddataservice.loadFieldOfficeNominee(empId, officeId, selectedId);
			loadFieldOfficeService=penappfielddataservice.loadFieldOfficeService(empId, officeId, selectedId);
			
			
				
			//System.out.println("Am inside load filed off datas"+loadFieldOfficeData.getEmpName());
			
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();		
			xmlString.append("<response>");
			
			xmlString.append("<command>fieldOfficeData</command>");
			
 	          if(loadFieldOfficeData!=null)
		           { 	        	
 	        	
 	        	  Integer designId=loadFieldOfficeData.getDesigId()==null?0:loadFieldOfficeData.getDesigId();
 	        	  strDesignation=penappfielddataservice.getDesignation(designId);
 				
 	        	  Integer officeId1=loadFieldOfficeData.getOfficeId()==null?0:loadFieldOfficeData.getOfficeId();
 	        	  strOfficeName=penappfielddataservice.getOfficeName(officeId1);
 			
 	        	  
 	        	  	xmlString.append("<details>");		        	
			        xmlString.append("<empNo>"+loadFieldOfficeData.getEmpNo()+"</empNo>");
			        xmlString.append("<empName>"+loadFieldOfficeData.getEmpName()+"</empName>");
			        xmlString.append("<gender>"+loadFieldOfficeData.getGender()+ "</gender>");
			        xmlString.append("<desigServiceGrp>"+loadFieldOfficeData.getDesigServiceGrp()+"</desigServiceGrp>");
			        xmlString.append("<desigId>"+loadFieldOfficeData.getDesigId()+ "</desigId>");	
			        
			        xmlString.append("<designStr>"+strDesignation+ "</designStr>");	
			        
			        xmlString.append("<gradeId>"+loadFieldOfficeData.getGradeId()+ "</gradeId>");
			        
			        xmlString.append("<officeId>"+loadFieldOfficeData.getOfficeId()+ "</officeId>");
			        xmlString.append("<officeStr>"+strOfficeName+ "</officeStr>");
			        
			        xmlString.append("<gpfNo>"+loadFieldOfficeData.getGpfNo()+ "</gpfNo>");
			        xmlString.append("<fatherName>"+loadFieldOfficeData.getFatherName()+ "</fatherName>");
			        xmlString.append("<husbandName>"+loadFieldOfficeData.getHusbandName()+ "</husbandName>");
			        xmlString.append("<religion>"+loadFieldOfficeData.getReligion()+ "</religion>");
			        xmlString.append("<nationality>"+loadFieldOfficeData.getNationality()+ "</nationality>");			        
			        xmlString.append("<empHeight>" +loadFieldOfficeData.getEmpHeight()+ "</empHeight>");
			        xmlString.append("<idMark1>" +loadFieldOfficeData.getIdMark1()+ "</idMark1>");			        
			        xmlString.append("<idMark2>" +loadFieldOfficeData.getIdMark2()+ "</idMark2>");	
			        System.out.println("loadFieldOfficeData.getPresentAddress()---------------->"+loadFieldOfficeData.getPresentAddress());
			        xmlString.append("<presentAddress>" +loadFieldOfficeData.getPresentAddress()+ "</presentAddress>");
			        xmlString.append("<permanentAddress>" +loadFieldOfficeData.getPermanentAddress()+ "</permanentAddress>");
			        xmlString.append("<addressAfterRetire>" +loadFieldOfficeData.getAddressAfterRetire()+ "</addressAfterRetire>"); 
			        xmlString.append("<stateId>" +loadFieldOfficeData.getStateId()+ "</stateId>"); 
			        xmlString.append("<chargesFlag>" +loadFieldOfficeData.getChargesFlag()+ "</chargesFlag>");
			        xmlString.append("<chargeDetails>" +loadFieldOfficeData.getChargeDetails()+ "</chargeDetails>");
			        xmlString.append("<pensionPayOfficeId>" +loadFieldOfficeData.getPensionPayOfficeId()+ "</pensionPayOfficeId>");
			        xmlString.append("<appliedDate2>" +loadFieldOfficeData.getAppliedDate2()+ "</appliedDate2>");			        
			        xmlString.append("<dcrgNomineeName>" +loadFieldOfficeData.getDcrgNomineeName()+ "</dcrgNomineeName>");
			        xmlString.append("<dcrgNomineeDob>" +loadFieldOfficeData.getDcrgNomineeDob2()+ "</dcrgNomineeDob>");
			        xmlString.append("<dcrgRelation>" +loadFieldOfficeData.getDcrgRelation()+ "</dcrgRelation>");
			        xmlString.append("<dcrgAddress>" +loadFieldOfficeData.getDcrgAddress()+ "</dcrgAddress>");			   
			        xmlString.append("<notVerifyServiceTotYears>" +loadFieldOfficeData.getNotVerifyServiceTotYears()+ "</notVerifyServiceTotYears>");
			        xmlString.append("<notVerifyServiceTotMonths>" +loadFieldOfficeData.getNotVerifyServiceTotMonths()+ "</notVerifyServiceTotMonths>");
			        xmlString.append("<notVerifyServiceTotDays>" +loadFieldOfficeData.getNotVerifyServiceTotDays()+ "</notVerifyServiceTotDays>");
			        xmlString.append("</details>");					      
                }
 	          
 	          
 	          for(PensionApplicationForm2MstNomineeDao tmp:loadFieldOfficeNominee)
 	          {
 	        		xmlString.append("<nominee>");		        	
			        xmlString.append("<empNo>"+tmp.getEmpNo()+"</empNo>");
			        xmlString.append("<nominId>"+tmp.getNomineeId()+"</nominId>");
			        xmlString.append("<name>"+tmp.getFamilyMembers()+ "</name>");			        
			        xmlString.append("<initial>"+tmp.getNomineeInitial()+"</initial>");			        
			        xmlString.append("<relation>"+tmp.getRelation()+"</relation>");
			        /*System.out.println("date of birth of field office nominee="+tmp.getNomineeDob());
			        System.out.println("date of birth of field office nominee1="+tmp.getNomineeDob1());
			        System.out.println("date of birth of field office nominee2="+tmp.getNomineeDob2());*/
			        xmlString.append("<dob>"+tmp.getNomineeDob2()+"</dob>");
			        xmlString.append("<age>"+tmp.getNomineeAge()+"</age>");
			        xmlString.append("<handicapped>"+tmp.getHandicapped()+"</handicapped>");
			        xmlString.append("<martialStatus>"+tmp.getMartialStatus()+"</martialStatus>");
			        xmlString.append("<nominDate>"+tmp.getNominationDate2()+"</nominDate>");
			        xmlString.append("<activeStatus>"+tmp.getActiveStatus()+"</activeStatus>");
			        xmlString.append("<nominReason>"+tmp.getNominReason()+"</nominReason>");
			        xmlString.append("</nominee>");	
 	          }
 	          
 	          for(PensionApplicationForm2MstNotVerifyServDao tmp2:loadFieldOfficeService)
 	          {
 	        	  	xmlString.append("<service>");	
 	        	  	xmlString.append("<ServiceId>"+tmp2.getId()+"</ServiceId>");
 	        	  	xmlString.append("<empNo>"+tmp2.getEmpNo()+"</empNo>");
 	        	  	xmlString.append("<fromDate>"+tmp2.getNotVerifyServFromDate2()+"</fromDate>");
 	        	  	xmlString.append("<toDate>"+tmp2.getNotVerifyServToDate2()+"</toDate>");
 	        	  	xmlString.append("<reason>"+tmp2.getNotVerifyServiceReason()+"</reason>");
 	        	  	xmlString.append("<year>"+tmp2.getNotVerifyYear()+"</year>");
 	        	  	xmlString.append("<month>"+tmp2.getNotVerifyMonth()+"</month>");
 	        	  	xmlString.append("<days>"+tmp2.getNotVerifyDays()+"</days>"); 	        	
 	        	  	xmlString.append("</service>");	
 	        	 
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
		}
		
		return SUCCESS;
	}
	
	

	public void setPenappfielddataservice(PensionApplicationLoadFieldOfficeDataService penappfielddataservice) {
		this.penappfielddataservice = penappfielddataservice;
	}

	public PensionApplicationLoadFieldOfficeDataService getPenappfielddataservice() {
		return penappfielddataservice;
	}

	public void setFieldOffDataList(List<Object[]> fieldOffDataList) {
		this.fieldOffDataList = fieldOffDataList;
	}

	public List<Object[]> getFieldOffDataList() {
		return fieldOffDataList;
	}



	public void setFieldOffDataList2(List<Object[]> fieldOffDataList2) {
		this.fieldOffDataList2 = fieldOffDataList2;
	}



	public List<Object[]> getFieldOffDataList2() {
		return fieldOffDataList2;
	}



	public void setFielddata(CommonSearchModel fielddata) {
		this.fielddata = fielddata;
	}



	public CommonSearchModel getFielddata() {
		return fielddata;
	}



	public void setHiddenSelectedNo(String hiddenSelectedNo) {
		HiddenSelectedNo = hiddenSelectedNo;
	}



	public String getHiddenSelectedNo() {
		return HiddenSelectedNo;
	}
	public List<State_dao> getStateList() {
		return stateList;
	}



	public void setStateList(List<State_dao> stateList) {
		this.stateList = stateList;
	}



	public List<PensionPaymentOffice_dao> getPayOfficeList() {
		return payOfficeList;
	}



	public void setPayOfficeList(List<PensionPaymentOffice_dao> payOfficeList) {
		this.payOfficeList = payOfficeList;
	}



	public PensionerPaymentOfficeService getPaymentservice1() {
		return paymentservice1;
	}



	public void setPaymentservice1(PensionerPaymentOfficeService paymentservice1) {
		this.paymentservice1 = paymentservice1;
	}



	public State_service getStateservice() {
		return stateservice;
	}



	public void setStateservice(State_service stateservice) {
		this.stateservice = stateservice;
	}



	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}



	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}



	public void setReligionService(ReligionService religionService) {
		this.religionService = religionService;
	}



	public ReligionService getReligionService() {
		return religionService;
	}



	public void setReligionCombo(List<ReligionDao> religionCombo) {
		this.religionCombo = religionCombo;
	}



	public List<ReligionDao> getReligionCombo() {
		return religionCombo;
	}



	public void setFieldDataDetails(List<Object[]> fieldDataDetails) {
		this.fieldDataDetails = fieldDataDetails;
	}



	public List<Object[]> getFieldDataDetails() {
		return fieldDataDetails;
	}



	




	public PensionApplicationForm2MstDao getLoadFieldOfficeData() {
		return loadFieldOfficeData;
	}



	public void setLoadFieldOfficeData(
			PensionApplicationForm2MstDao loadFieldOfficeData) {
		this.loadFieldOfficeData = loadFieldOfficeData;
	}



	public void setLoadFieldOfficeNominee(List<PensionApplicationForm2MstNomineeDao> loadFieldOfficeNominee) {
		this.loadFieldOfficeNominee = loadFieldOfficeNominee;
	}



	public List<PensionApplicationForm2MstNomineeDao> getLoadFieldOfficeNominee() {
		return loadFieldOfficeNominee;
	}



	public void setLoadFieldOfficeService(List<PensionApplicationForm2MstNotVerifyServDao> loadFieldOfficeService) {
		this.loadFieldOfficeService = loadFieldOfficeService;
	}



	public List<PensionApplicationForm2MstNotVerifyServDao> getLoadFieldOfficeService() {
		return loadFieldOfficeService;
	}



	public void setStrDesignation(String strDesignation) {
		this.strDesignation = strDesignation;
	}



	public String getStrDesignation() {
		return strDesignation;
	}



	public void setStrOfficeName(String strOfficeName) {
		this.strOfficeName = strOfficeName;
	}



	public String getStrOfficeName() {
		return strOfficeName;
	}



	public void setPenappsearch(PensionApplicationSearchModel penappsearch) {
		this.penappsearch = penappsearch;
	}



	public PensionApplicationSearchModel getPenappsearch() {
		return penappsearch;
	}



	


	



	



}
