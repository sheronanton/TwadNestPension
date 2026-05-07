package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2MstDetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2NomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationMstData;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathHOForm2ValidateService;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class FamilyPensionApplicationDeathHOForm2ValidateAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PensionerPaymentOfficeService paymentservice1;	
	private State_service stateservice;
	private ReligionService religionService;
	private UpdatedUserIdService updateservice;
	private FamilyPensionApplicationDeathHOForm2ValidateService fampenappvalser;


	private List<ReligionDao> religionCombo;
	private List<State_dao> stateList;	
	private List<PensionPaymentOffice_dao> payOfficeList;
	private CommonSearchModel fpenapphoval;
	private FamilyPensionApplicationDeathHOForm2DetailsDao famPenAppHoData;
	private FamilyPensionApplicationMstData famPenAppMstdata;
	private List<FamilyPensionApplicationDeathHOForm2NomineeDao> nomineeObj;

	private Integer famPenHOValidateEmpNo;

	private FamilyPensionApplicationDeathHOForm2MstDetailsDao famPenAppHeadVal;
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
	private List<FamilyPensionApplicationDeathHOForm2MstNomineeDao> famNomineeList;


	public String searchData()
	{
		List<Object[]> valSearchList=null;
		try
		{
			PrintWriter out=getResponse().getWriter();
			StringBuffer buf=new StringBuffer();
			buf.append("<response>");
			buf.append("<command>famPenHOValidateSearch</command>");
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			int loginEmpId=empProfile.getEmployeeId();			

			String option=fpenapphoval.getSearchOption();
			String keyword=fpenapphoval.getSearchKeyword().toLowerCase();

			valSearchList=fampenappvalser.searchData(option, keyword, loginEmpId);

			for(Object[] tmp: valSearchList)
			{
				buf.append("<record>");
				buf.append("<empId>"+tmp[0]+"</empId>");
				buf.append("<empName>"+tmp[1]+"</empName>");
				buf.append("<designation>"+tmp[2]+"</designation>");
				buf.append("<officeName>"+tmp[3]+"</officeName>");
				buf.append("</record>");				
			}

			buf.append("</response>");
			getResponse().setContentType("text/xml");
			out.println(buf.toString());
			System.out.println(buf.toString());
			out.flush();
			out.close();


		}


		catch(Exception e)
		{
			return ERROR;
		}

		return SUCCESS;
	}

	public void loadCombo()
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
		}

	}


	public String loadData()
	{
		try
		{
			loadCombo();
			System.out.println("INSIDE LOAD DATA:::::"+famPenHOValidateEmpNo);
			famPenAppHoData=fampenappvalser.getCoDetails(famPenHOValidateEmpNo);			
			nomineeObj=fampenappvalser.getHoNomineeList(famPenHOValidateEmpNo);			
			List<Object[]> commonObj=fampenappvalser.getMstDataCheck(famPenHOValidateEmpNo);

			for(Object[] mstObj: commonObj)
			{		
				famPenAppMstdata=new FamilyPensionApplicationMstData();
				famPenAppMstdata.setEmpNo(Integer.parseInt(mstObj[0]+""));
				famPenAppMstdata.setEmpName(mstObj[1]+"");
				famPenAppMstdata.setEmpInitial(mstObj[2]+"");
				famPenAppMstdata.setGpfNo(Integer.parseInt(mstObj[3]+""));

				if(mstObj[4]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String dobStr=df.format(mstObj[4]);									
					famPenAppMstdata.setDob2(dobStr);		
				}

				famPenAppMstdata.setGender(mstObj[5]+"");
				famPenAppMstdata.setOffice(mstObj[6]+"");				
				famPenAppMstdata.setDesignation(mstObj[7]+"");
				if(mstObj[8]!=null)
				{
					famPenAppMstdata.setOfficeId(Integer.parseInt(mstObj[8]+""));
				}
				famPenAppMstdata.setDesigId(Integer.parseInt(mstObj[9]+""));
				famPenAppMstdata.setDesigServiceGrp(Integer.parseInt(mstObj[10]+""));
				famPenAppMstdata.setGrade(mstObj[11]+"");			

				if(mstObj[12]!=null)
				{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String dojStr=df.format(mstObj[12]);									
					famPenAppMstdata.setDoj2(dojStr);	
				}


			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;
	}


	public String saveData()
	{
		int empId=0;
		boolean detailFlag=false;

		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId);

			famPenAppHeadVal.setProcessStatus("VALIDATE");
			famPenAppHeadVal.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			famPenAppHeadVal.setUpdatedUser(updatedId);


			detailFlag=fampenappvalser.saveDetails(famPenAppHeadVal);

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

				FamilyPensionApplicationDeathHOForm2MstNomineeDao multidata=null;
				famNomineeList = new ArrayList<FamilyPensionApplicationDeathHOForm2MstNomineeDao>();

				while(iter.hasNext())
				{
					multidata = new FamilyPensionApplicationDeathHOForm2MstNomineeDao();	
					multidata.setEmpNo(famPenAppHeadVal.getEmpNo());
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
					multidata.setProcessStatus("VALIDATE");
					famNomineeList.add(multidata);

				}


				fampenappvalser.deleteNominee(famPenAppHeadVal.getEmpNo());
				fampenappvalser.saveAddnominee(famNomineeList);

				if(detailFlag)
				{
					fampenappvalser.deleteHoCoDetails(famPenAppHeadVal.getEmpNo());
				}
			}



		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
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


	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}


	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
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


	public void setFampenappvalser(FamilyPensionApplicationDeathHOForm2ValidateService fampenappvalser) {
		this.fampenappvalser = fampenappvalser;
	}


	public FamilyPensionApplicationDeathHOForm2ValidateService getFampenappvalser() {
		return fampenappvalser;
	}

	public void setFpenapphoval(CommonSearchModel fpenapphoval) {
		this.fpenapphoval = fpenapphoval;
	}

	public CommonSearchModel getFpenapphoval() {
		return fpenapphoval;
	}

	public void setFamPenHOValidateEmpNo(Integer famPenHOValidateEmpNo) {
		this.famPenHOValidateEmpNo = famPenHOValidateEmpNo;
	}

	public Integer getFamPenHOValidateEmpNo() {
		return famPenHOValidateEmpNo;
	}

	public void setFamPenAppHoData(FamilyPensionApplicationDeathHOForm2DetailsDao famPenAppHoData) {
		this.famPenAppHoData = famPenAppHoData;
	}

	public FamilyPensionApplicationDeathHOForm2DetailsDao getFamPenAppHoData() {
		return famPenAppHoData;
	}

	public void setFamPenAppMstdata(FamilyPensionApplicationMstData famPenAppMstdata) {
		this.famPenAppMstdata = famPenAppMstdata;
	}

	public FamilyPensionApplicationMstData getFamPenAppMstdata() {
		return famPenAppMstdata;
	}

	public void setNomineeObj(List<FamilyPensionApplicationDeathHOForm2NomineeDao> nomineeObj) {
		this.nomineeObj = nomineeObj;
	}

	public List<FamilyPensionApplicationDeathHOForm2NomineeDao> getNomineeObj() {
		return nomineeObj;
	}

	public void setFamPenAppHeadVal(FamilyPensionApplicationDeathHOForm2MstDetailsDao famPenAppHeadVal) {
		this.famPenAppHeadVal = famPenAppHeadVal;
	}

	public FamilyPensionApplicationDeathHOForm2MstDetailsDao getFamPenAppHeadVal() {
		return famPenAppHeadVal;
	}

	public void setFamNomineeList(List<FamilyPensionApplicationDeathHOForm2MstNomineeDao> famNomineeList) {
		this.famNomineeList = famNomineeList;
	}

	public List<FamilyPensionApplicationDeathHOForm2MstNomineeDao> getFamNomineeList() {
		return famNomineeList;
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



}
