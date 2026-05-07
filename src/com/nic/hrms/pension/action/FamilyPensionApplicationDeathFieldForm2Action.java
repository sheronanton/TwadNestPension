package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2NomineeCo;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathFieldForm2Service;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class FamilyPensionApplicationDeathFieldForm2Action extends BaseAction {

	
	/**
	 * Family Pension Application Death Action
	 */
	private static final long serialVersionUID = 1L;
	
	private PensionApplicationSearchModel getMstSearch;
	private PensionerPaymentOfficeService paymentservice1;	
	private State_service stateservice;
	private ReligionService religionService;
	private UpdatedUserIdService updateservice;
	
	
	private List<ReligionDao> religionCombo;
	private List<State_dao> stateList;	
	private List<PensionPaymentOffice_dao> payOfficeList;
	private Integer empNo;
	private List<String> nomineeInitial;
	private List<String> familyMembers;	
	private List<String> relation;	
	private List<String> nomineeDob;	
	private List<Integer> nomineeAge;
	private List<String> handicapped;
	private List<String> martialStatus;
	private List<String> nominationDate;
	private List<String> activeStatus;
	private List<String> address;	
	private List<FamilyPensionApplicationDeathFieldForm2NomineeCo> fnomineeList;
	
	private FamilyPensionApplicationDeathFieldForm2Service famPenAppDeathForm2Service;
	private FamilyPensionApplicationDeathFieldForm2DetailsDao penAppFamDeathCo;
	private List<FamilyPensionApplicationDeathFieldForm2NomineeCo> nomList;
	private CommonSearchModel fpenappeditf2;
	private PensionApplicationSearchModel fchkavail;
	

	public String loadCombo()
	{
		try
		{
			stateList=stateservice.getListOfstate();			
			payOfficeList = paymentservice1.getListOfPayOffice();
			religionCombo=religionService.getReligionList();
		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}

	public String checkAvailability2()
	{
		int searchEmpId=0,loginEmpId=0;
		System.out.println("checkAvailability.....Form 2");
		List<Object[]> chkAvList=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			loginEmpId=empProfile.getEmployeeId();
			
			PrintWriter put=getResponse().getWriter();
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("<response>");
			strBuf.append("<command>CheckAvailForm2</command>");
			
			searchEmpId=fchkavail.getEmpId();
			chkAvList=famPenAppDeathForm2Service.chkAvailablity2(searchEmpId, loginEmpId);
			
			for(Object[] tmp:chkAvList)
			{
				strBuf.append("<record>");
				strBuf.append("<empId>"+tmp[0]+"</empId>");
				strBuf.append("<empName>"+tmp[1]+"</empName>");
				strBuf.append("</record>");
			}

			strBuf.append("</response>");
			getResponse().setContentType("text/xml");
			put.println(strBuf.toString());		
			System.out.println(strBuf.toString());
			put.flush();
			put.close();
			
			
		}
		catch(Exception e)
		{
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	
	public String checkAvailability1()
	{
		int searchEmpId=0,loginEmpId=0;
		System.out.println("checkAvailability.....Form 1");
		List<Object[]> chkAvList1=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			loginEmpId=empProfile.getEmployeeId();
			
			PrintWriter put=getResponse().getWriter();
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("<response>");
			strBuf.append("<command>CheckAvailForm1</command>");
			
			searchEmpId=fchkavail.getEmpId();
			chkAvList1=famPenAppDeathForm2Service.chkAvailablity1(searchEmpId, loginEmpId);
			
			for(Object[] tmp:chkAvList1)
			{
				strBuf.append("<record>");
				strBuf.append("<empId>"+tmp[0]+"</empId>");
				strBuf.append("<empName>"+tmp[1]+"</empName>");
				strBuf.append("</record>");
			}

			strBuf.append("</response>");
			getResponse().setContentType("text/xml");
			put.println(strBuf.toString());		
			System.out.println(strBuf.toString());
			put.flush();
			put.close();
			
			
		}
		catch(Exception e)
		{
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	public String getMstData()
	{
		List<Object[]> mstList=null;
		
		try
		{
			int empNo=getMstSearch.getEmpId();
			int loginEmpId=0;		
			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			loginEmpId=empProfile.getEmployeeId();
			
			mstList=famPenAppDeathForm2Service.getMstData(empNo, loginEmpId);
			nomList=famPenAppDeathForm2Service.getNomineeList(empNo, loginEmpId);
			
			System.out.println(mstList.size());
			PrintWriter put=getResponse().getWriter();
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("<response>");
			strBuf.append("<command>getMstData</command>");
			for(Object[] tmp: mstList)
			{
				strBuf.append("<record>");
				strBuf.append("<empId>"+tmp[0]+"</empId>");
				strBuf.append("<empName>"+tmp[1]+"</empName>");
				strBuf.append("<empInit>"+tmp[2]+"</empInit>");				
				strBuf.append("<gpfNo>"+tmp[3]+"</gpfNo>");
				
				if(tmp[4]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String dobStr=df.format(tmp[4]);
					strBuf.append("<dob>"+dobStr+"</dob>");
				}
				else
				{
				strBuf.append("<dob>"+tmp[4]+"</dob>");
				}
				strBuf.append("<gender>"+tmp[5]+"</gender>");
				strBuf.append("<officeName>"+tmp[6]+"</officeName>");
				strBuf.append("<desigStr>"+tmp[7]+"</desigStr>");
				strBuf.append("<officeId>"+tmp[8]+"</officeId>");
				strBuf.append("<desigId>"+tmp[9]+"</desigId>");
				strBuf.append("<desigSerGrpId>"+tmp[10]+"</desigSerGrpId>");
				strBuf.append("<grade>"+tmp[11]+"</grade>");
				if(tmp[12]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String dojStr=df.format(tmp[12]);
					strBuf.append("<doj>"+dojStr+"</doj>");					
				}
				else
				{
					strBuf.append("<doj>"+tmp[12]+"</doj>");
				}
				
				strBuf.append("<religionID>"+tmp[13]+"</religionID>");
				strBuf.append("<nation>"+tmp[14]+"</nation>");
				strBuf.append("<id1>"+tmp[15]+"</id1>");
				strBuf.append("<id2>"+tmp[16]+"</id2>");
				strBuf.append("<presentAddress>"+tmp[17]+"</presentAddress>");
				strBuf.append("<stateId>"+tmp[18]+"</stateId>");
				strBuf.append("<paymentOfficeId>"+tmp[19]+"</paymentOfficeId>");
				strBuf.append("<claimentName>"+tmp[20]+"</claimentName>");
				
				if(tmp[21]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String claimDobStr=df.format(tmp[21]);
					strBuf.append("<claimentDob>"+claimDobStr+"</claimentDob>");
				}
				else
				{
					strBuf.append("<claimentDob>"+tmp[21]+"</claimentDob>");
				}
				
				
				strBuf.append("<claimentAge>"+tmp[22]+"</claimentAge>");
				strBuf.append("<guardName>"+tmp[23]+"</guardName>");
				
				if(tmp[24]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String guardDobStr=df.format(tmp[24]);
					strBuf.append("<guardDob>"+guardDobStr+"</guardDob>");
				}
				else
				{
					strBuf.append("<guardDob>"+tmp[24]+"</guardDob>");
				}
				
				
				
				strBuf.append("<guardRelMinor>"+tmp[25]+"</guardRelMinor>");
				strBuf.append("<guardRelEmp>"+tmp[26]+"</guardRelEmp>");
				
				if(tmp[27]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String deathStr=df.format(tmp[27]);
					strBuf.append("<empDeath>"+deathStr+"</empDeath>");
					
				}
				else
				{
					strBuf.append("<empDeath>"+tmp[27]+"</empDeath>");					
				}
				
				
				
				strBuf.append("<address>"+tmp[28]+"</address>");
							
				strBuf.append("</record>");
			}
			
			
			for(FamilyPensionApplicationDeathFieldForm2NomineeCo tmp:nomList)
			{
				strBuf.append("<NomineeDetails>");
				strBuf.append("<nomId>"+tmp.getNomineeId()+"</nomId>");
				strBuf.append("<empNo>"+tmp.getEmpNo()+"</empNo>");
				strBuf.append("<nomInit>"+tmp.getNomineeInitial()+"</nomInit>");
				strBuf.append("<nomName>"+tmp.getFamilyMembers()+"</nomName>");
				strBuf.append("<relation>"+tmp.getRelation()+"</relation>");
				strBuf.append("<nomDob>"+tmp.getNomineeDob2()+"</nomDob>");
				strBuf.append("<nomAge>"+tmp.getNomineeAge()+"</nomAge>");
				strBuf.append("<handy>"+tmp.getHandicapped()+"</handy>");
				strBuf.append("<martialStatus>"+tmp.getMartialStatus()+"</martialStatus>");
				strBuf.append("<nomDate>"+tmp.getNominationDate2()+"</nomDate>");
				strBuf.append("<nomStatus>"+tmp.getActiveStatus()+"</nomStatus>");
				strBuf.append("<nomAddress>"+tmp.getAddress()+"</nomAddress>");
				strBuf.append("</NomineeDetails>");
			}
			
			strBuf.append("</response>");
			getResponse().setContentType("text/xml");
			put.println(strBuf.toString());		
			System.out.println(strBuf.toString());
			put.flush();
			put.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}


	@SuppressWarnings("unchecked")
	public String saveData()
	{		
		System.out.println("TEST SAVE ACTION >>>>>>>>>>>>>>>>>>>>>");
	
		int empId=0;
		try
		{			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId);
			   System.out.println("TEST 2......"+updatedId);
			
			penAppFamDeathCo.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));			
			penAppFamDeathCo.setUpdatedUser(updatedId);
			penAppFamDeathCo.setProcessStatus("ENTERED");	
			System.out.println("TEST 4 ......");
			   
			famPenAppDeathForm2Service.saveRecord(penAppFamDeathCo);
			     
			     
			     
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
				Iterator iter10 = address.iterator();
			    
				FamilyPensionApplicationDeathFieldForm2NomineeCo multidata=null;
				fnomineeList = new ArrayList<FamilyPensionApplicationDeathFieldForm2NomineeCo>();
			    
			     while(iter.hasNext()){
			    	multidata = new FamilyPensionApplicationDeathFieldForm2NomineeCo();	
			    	multidata.setEmpNo(penAppFamDeathCo.getEmpNo());
			    	multidata.setFamilyMembers((String)iter.next());
			    	multidata.setNomineeInitial((String)iter1.next());
			    	multidata.setRelation((String)iter3.next());
			    	multidata.setNomineeDob((String)iter4.next());
			    	multidata.setNomineeAge((Integer)iter5.next());
			    	multidata.setHandicapped((String)iter6.next());
			    	multidata.setMartialStatus((String)iter7.next());
			    	multidata.setNominationDate((String)iter8.next());
			    	multidata.setActiveStatus((String)iter9.next());
			    	multidata.setAddress((String)iter10.next());
			    
			    	multidata.setUpdatedUserId(updatedId);
			    	multidata.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidata.setProcessStatus("ENTERED");
			    	fnomineeList.add(multidata);
			    	
		        }
			 	
			     System.out.println("TEST 3 ......");
			   
			     System.out.println("TEST 5 ......");
			   famPenAppDeathForm2Service.deleteNominee(penAppFamDeathCo.getEmpNo());
			     famPenAppDeathForm2Service.saveAddnominee(fnomineeList);
			     
			     
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
		
		return SUCCESS;
		
	}

	
	
	public String searchData()
	{		
		String option=fpenappeditf2.getSearchOption();
		String keyword=fpenappeditf2.getSearchKeyword();
		int loginEmpId=0;
		
		List<Object[]> searchList=null;
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		loginEmpId=empProfile.getEmployeeId();
		
		try
		{
			
			searchList=famPenAppDeathForm2Service.searchMethod(option, keyword, loginEmpId);
			
			PrintWriter put=getResponse().getWriter();
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("<response>");
			strBuf.append("<command>editSearch</command>");
			for(Object[] tmp: searchList)
			{
				strBuf.append("<record>");
				strBuf.append("<empId>"+tmp[0]+"</empId>");
				strBuf.append("<empName>"+tmp[1]+"</empName>");
				strBuf.append("<claimName>"+tmp[2]+"</claimName>");				
				strBuf.append("<officeName>"+tmp[3]+"</officeName>");
				strBuf.append("</record>");

			}
			
			strBuf.append("</response>");
			getResponse().setContentType("text/xml");
			put.println(strBuf.toString());		
			System.out.println(strBuf.toString());
			put.flush();
			put.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}


	public void setGetMstSearch(PensionApplicationSearchModel getMstSearch) {
		this.getMstSearch = getMstSearch;
	}



	public PensionApplicationSearchModel getGetMstSearch() {
		return getMstSearch;
	}






	public void setFamPenAppDeathForm2Service(FamilyPensionApplicationDeathFieldForm2Service famPenAppDeathForm2Service) {
		this.famPenAppDeathForm2Service = famPenAppDeathForm2Service;
	}






	public FamilyPensionApplicationDeathFieldForm2Service getFamPenAppDeathForm2Service() {
		return famPenAppDeathForm2Service;
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

	public void setPenAppFamDeathCo(FamilyPensionApplicationDeathFieldForm2DetailsDao penAppFamDeathCo) {
		this.penAppFamDeathCo = penAppFamDeathCo;
	}

	public FamilyPensionApplicationDeathFieldForm2DetailsDao getPenAppFamDeathCo() {
		return penAppFamDeathCo;
	}

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}

	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getEmpNo() {
		return empNo;
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

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public List<FamilyPensionApplicationDeathFieldForm2NomineeCo> getFnomineeList() {
		return fnomineeList;
	}

	public void setFnomineeList(
			List<FamilyPensionApplicationDeathFieldForm2NomineeCo> fnomineeList) {
		this.fnomineeList = fnomineeList;
	}

	public void setNomList(List<FamilyPensionApplicationDeathFieldForm2NomineeCo> nomList) {
		this.nomList = nomList;
	}

	public List<FamilyPensionApplicationDeathFieldForm2NomineeCo> getNomList() {
		return nomList;
	}

	public void setFpenappeditf2(CommonSearchModel fpenappeditf2) {
		this.fpenappeditf2 = fpenappeditf2;
	}

	public CommonSearchModel getFpenappeditf2() {
		return fpenappeditf2;
	}

	public void setFchkavail(PensionApplicationSearchModel fchkavail) {
		this.fchkavail = fchkavail;
	}

	public PensionApplicationSearchModel getFchkavail() {
		return fchkavail;
	}
	
	
	
}
