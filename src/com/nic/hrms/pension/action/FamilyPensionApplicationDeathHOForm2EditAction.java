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
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2NomineeDao;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathHOForm2EditService;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class FamilyPensionApplicationDeathHOForm2EditAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FamilyPensionApplicationDeathHOForm2EditService fpenapphoservice;
	private CommonSearchModel fpenapphoedit;
	private PensionApplicationSearchModel fpenho1;
	private PensionApplicationSearchModel fpenho2;
	private PensionApplicationSearchModel fpenho3;

	
	private PensionerPaymentOfficeService paymentservice1;	
	private State_service stateservice;
	private ReligionService religionService;
	private UpdatedUserIdService updateservice;

	
	private List<ReligionDao> religionCombo;
	private List<State_dao> stateList;	
	private List<PensionPaymentOffice_dao> payOfficeList;
	
	private List<Object[]> getDetailsList=null;
	private List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> getNomineeList=null;
	
	
	
	private FamilyPensionApplicationDeathHOForm2DetailsDao famPenAppHeadCo;
	
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
	private List<FamilyPensionApplicationDeathHOForm2NomineeDao> fnomineeList;
	
	
	public String editSearch()
	{
		System.out.println("HAI TET SEACH .......>>>>");
		int loginEmpId=0;
		StringBuffer strBuf=new StringBuffer();	
		List<Object[]> searchList=null;
		try
		{
			String option=fpenapphoedit.getSearchOption().toLowerCase();
			String keyword=fpenapphoedit.getSearchKeyword().toLowerCase();			
			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			loginEmpId=empProfile.getEmployeeId();
			
			PrintWriter out=getResponse().getWriter();
			strBuf.append("<response>");
			strBuf.append("<command>famPenHOEditSearch</command>");
			
			searchList=fpenapphoservice.editSearch(option, keyword, loginEmpId);
		
			for(Object[] tmp: searchList)
			{
				strBuf.append("<record>");
				strBuf.append("<empId>"+tmp[0]+"</empId>");
				strBuf.append("<empName>"+tmp[1]+"</empName>");
				strBuf.append("<designation>"+tmp[2]+"</designation>");
				strBuf.append("<officeName>"+tmp[3]+"</officeName>");
				strBuf.append("</record>");				
			}
			
			strBuf.append("</response>");
			getResponse().setContentType("text/xml");
			out.println(strBuf.toString());
			System.out.println(strBuf.toString());
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
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public String loadMstDataChk()
	{
		List<Object[]> mstDataChk=null;
		try
		{
			PrintWriter put=getResponse().getWriter();
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("<response>");
			strBuf.append("<command>famPenAppMstData</command>");	
			
			mstDataChk=fpenapphoservice.getMstDataCheck(fpenho3.getEmpId());
			
			for(Object[] tmp: mstDataChk)
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
	
	
	
	public String loadFieldData() //loadEditData
	{			
		System.out.println("INSIDE LOAD EDIT DATA...>>>>");
		try
		{
			System.out.println("INSIDE LOAD EDIT DATA...>>>>"+fpenho1.getEmpId());	
			
			getDetailsList=fpenapphoservice.getFieldMstData(fpenho1.getEmpId());
			getNomineeList=fpenapphoservice.getNomineeList(fpenho1.getEmpId());
			
			
			PrintWriter put=getResponse().getWriter();
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("<response>");
			strBuf.append("<command>famPenAppForm2FieldData</command>");
			for(Object[] tmp: getDetailsList)
			{
				strBuf.append("<record>");
				strBuf.append("<empId>"+tmp[0]+"</empId>");				
				strBuf.append("<religionID>"+tmp[1]+"</religionID>");
				strBuf.append("<nation>"+tmp[2]+"</nation>");
				strBuf.append("<id1>"+tmp[3]+"</id1>");
				strBuf.append("<id2>"+tmp[4]+"</id2>");
				strBuf.append("<presentAddress>"+tmp[5]+"</presentAddress>");
				strBuf.append("<stateId>"+tmp[6]+"</stateId>");
				strBuf.append("<paymentOfficeId>"+tmp[7]+"</paymentOfficeId>");
				strBuf.append("<claimentName>"+tmp[8]+"</claimentName>");
				
				if(tmp[9]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String claimDobStr=df.format(tmp[9]);
					strBuf.append("<claimentDob>"+claimDobStr+"</claimentDob>");
				}
				else
				{
					strBuf.append("<claimentDob>"+tmp[9]+"</claimentDob>");
				}
				
				
				strBuf.append("<claimentAge>"+tmp[10]+"</claimentAge>");
				strBuf.append("<guardName>"+tmp[11]+"</guardName>");
				
				if(tmp[12]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String guardDobStr=df.format(tmp[12]);
					strBuf.append("<guardDob>"+guardDobStr+"</guardDob>");
				}
				else
				{
					strBuf.append("<guardDob>"+tmp[12]+"</guardDob>");
				}
				
				
				
				strBuf.append("<guardRelMinor>"+tmp[13]+"</guardRelMinor>");
				strBuf.append("<guardRelEmp>"+tmp[14]+"</guardRelEmp>");
				
				if(tmp[15]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String deathStr=df.format(tmp[15]);
					strBuf.append("<empDeath>"+deathStr+"</empDeath>");
					
				}
				else
				{
					strBuf.append("<empDeath>"+tmp[15]+"</empDeath>");					
				}
				
				
				
				strBuf.append("<address>"+tmp[16]+"</address>");
							
				strBuf.append("</record>");
			}
			
			
			for(FamilyPensionApplicationDeathFieldForm2MstNomineeDao tmp:getNomineeList)
			{
				strBuf.append("<NomineeDetails>");
				strBuf.append("<nomId>"+tmp.getNomineeId()+"</nomId>");
				strBuf.append("<empNo>"+tmp.getEmpNo()+"</empNo>");
				strBuf.append("<nomInit>"+tmp.getNomineeInitial()+"</nomInit>");
				strBuf.append("<nomName>"+tmp.getFamilyMembers()+"</nomName>");
				strBuf.append("<relation>"+tmp.getRelation()+"</relation>");
				System.out.println("Nominee Relation:::"+tmp.getRelation());
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
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	public String loadHOData()
	{
		int empNo=0;
		List<Object[]> hodataDetList=null;
		List<FamilyPensionApplicationDeathHOForm2NomineeDao> hodataNominee=null;
		try
		{			
			empNo=fpenho2.getEmpId();
			
			hodataDetList=fpenapphoservice.getHoDetails(empNo);
			hodataNominee=fpenapphoservice.getHoNomineeList(empNo);
			
			System.out.println("HO DATA ACTION>>>>>>>>>>>>>>>>>>>>");
			
			PrintWriter put=getResponse().getWriter();
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("<response>");
			strBuf.append("<command>famPenAppForm2HOData</command>");
			
			for(Object[] tmp: hodataDetList)
			{
				strBuf.append("<record>");				
				strBuf.append("<empNo>"+tmp[0]+"</empNo>");
				strBuf.append("<religionID>"+tmp[1]+"</religionID>");
				strBuf.append("<nation>"+tmp[2]+"</nation>");
				strBuf.append("<id1>"+tmp[3]+"</id1>");
				strBuf.append("<id2>"+tmp[4]+"</id2>");
				strBuf.append("<presentAddress>"+tmp[5]+"</presentAddress>");
				strBuf.append("<stateId>"+tmp[6]+"</stateId>");
				strBuf.append("<paymentOfficeId>"+tmp[7]+"</paymentOfficeId>");
				strBuf.append("<claimentName>"+tmp[8]+"</claimentName>");
				
				if(tmp[9]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String claimDobStr=df.format(tmp[9]);
					strBuf.append("<claimentDob>"+claimDobStr+"</claimentDob>");
				}
				else
				{
					strBuf.append("<claimentDob>"+tmp[9]+"</claimentDob>");
				}				
				
				strBuf.append("<claimentAge>"+tmp[10]+"</claimentAge>");
				strBuf.append("<guardName>"+tmp[11]+"</guardName>");
				
				if(tmp[12]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String guardDobStr=df.format(tmp[12]);
					strBuf.append("<guardDob>"+guardDobStr+"</guardDob>");
				}
				else
				{
					strBuf.append("<guardDob>"+tmp[12]+"</guardDob>");
				}
				
				
				
				strBuf.append("<guardRelMinor>"+tmp[13]+"</guardRelMinor>");
				strBuf.append("<guardRelEmp>"+tmp[14]+"</guardRelEmp>");
				
				if(tmp[15]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String deathStr=df.format(tmp[15]);
					strBuf.append("<empDeath>"+deathStr+"</empDeath>");
					
				}
				else
				{
					strBuf.append("<empDeath>"+tmp[15]+"</empDeath>");					
				}
				
				
				
				strBuf.append("<address>"+tmp[16]+"</address>");
							
				strBuf.append("</record>");
			}
			
			
			for(FamilyPensionApplicationDeathHOForm2NomineeDao tmp: hodataNominee)
			{
				System.out.println("tmp.getNomineeId()----->"+tmp.getNomineeId());
				strBuf.append("<NomineeDetails>");
				strBuf.append("<nomId>"+tmp.getNomineeId()+"</nomId>");
				strBuf.append("<empNo>"+tmp.getEmpNo()+"</empNo>");
				strBuf.append("<nomInit>"+tmp.getNomineeInitial()+"</nomInit>");
				strBuf.append("<nomName>"+tmp.getFamilyMembers()+"</nomName>");
				System.out.println("RELATIOOOOO:"+tmp.getRelation());
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
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	
	public String saveRecord()
	{
		int empId=0;		
		try
		{
			System.out.println("SAVE RECORD...>>>>>>>>");
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId);
			
			famPenAppHeadCo.setProcessStatus("ENTERED");
			famPenAppHeadCo.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			famPenAppHeadCo.setUpdatedUser(updatedId);
			
			fpenapphoservice.saveDetails(famPenAppHeadCo);		
			
			
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
			    
				FamilyPensionApplicationDeathHOForm2NomineeDao multidata=null;
				fnomineeList = new ArrayList<FamilyPensionApplicationDeathHOForm2NomineeDao>();
			    
			     while(iter.hasNext())
			     {
			    	multidata = new FamilyPensionApplicationDeathHOForm2NomineeDao();	
			    	multidata.setEmpNo(famPenAppHeadCo.getEmpNo());
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
			
			
			fpenapphoservice.deleteNominee(famPenAppHeadCo.getEmpNo());
			fpenapphoservice.saveAddnominee(fnomineeList);
			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}	
		
		return SUCCESS;
	}
	

	public void setFpenapphoservice(FamilyPensionApplicationDeathHOForm2EditService fpenapphoservice) {
		this.fpenapphoservice = fpenapphoservice;
	}


	public FamilyPensionApplicationDeathHOForm2EditService getFpenapphoservice() {
		return fpenapphoservice;
	}


	public void setFpenapphoedit(CommonSearchModel fpenapphoedit) {
		this.fpenapphoedit = fpenapphoedit;
	}


	public CommonSearchModel getFpenapphoedit() {
		return fpenapphoedit;
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

	public PensionApplicationSearchModel getFpenho1() {
		return fpenho1;
	}

	public void setFpenho1(PensionApplicationSearchModel fpenho1) {
		this.fpenho1 = fpenho1;
	}

	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}

	public List<Object[]> getGetDetailsList() {
		return getDetailsList;
	}

	public void setGetDetailsList(List<Object[]> getDetailsList) {
		this.getDetailsList = getDetailsList;
	}

	public List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> getGetNomineeList() {
		return getNomineeList;
	}

	public void setGetNomineeList(
			List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> getNomineeList) {
		this.getNomineeList = getNomineeList;
	}

	public FamilyPensionApplicationDeathHOForm2DetailsDao getFamPenAppHeadCo() {
		return famPenAppHeadCo;
	}

	public void setFamPenAppHeadCo(
			FamilyPensionApplicationDeathHOForm2DetailsDao famPenAppHeadCo) {
		this.famPenAppHeadCo = famPenAppHeadCo;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
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

	public List<FamilyPensionApplicationDeathHOForm2NomineeDao> getFnomineeList() {
		return fnomineeList;
	}

	public void setFnomineeList(
			List<FamilyPensionApplicationDeathHOForm2NomineeDao> fnomineeList) {
		this.fnomineeList = fnomineeList;
	}

	public void setFpenho2(PensionApplicationSearchModel fpenho2) {
		this.fpenho2 = fpenho2;
	}

	public PensionApplicationSearchModel getFpenho2() {
		return fpenho2;
	}

	public void setFpenho3(PensionApplicationSearchModel fpenho3) {
		this.fpenho3 = fpenho3;
	}

	public PensionApplicationSearchModel getFpenho3() {
		return fpenho3;
	}

	



	
}
