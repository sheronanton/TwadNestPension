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
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstDetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2NomineeCo;
import com.nic.hrms.pension.model.FamilyPensionApplicationMstData;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathFieldForm2ValidateService;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class FamilyPensionApplicationDeathFieldForm2ValidateAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FamilyPensionApplicationDeathFieldForm2ValidateService fpenAppDeathService;
	private CommonSearchModel fpenappf2;
	
	private PensionerPaymentOfficeService paymentservice1;	
	private State_service stateservice;
	private ReligionService religionService;
	private UpdatedUserIdService updateservice;

	
	private List<ReligionDao> religionCombo;
	private List<State_dao> stateList;	
	private List<PensionPaymentOffice_dao> payOfficeList;
	
	private int HiddenSelectedNo;
	private FamilyPensionApplicationDeathFieldForm2DetailsDao fpenappdeathco;
	private FamilyPensionApplicationMstData fpenappdeathmst;
	private List<FamilyPensionApplicationDeathFieldForm2NomineeCo> nominList;
	
	private FamilyPensionApplicationDeathFieldForm2MstDetailsDao penAppFamDeathMst;
	
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
	private List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> fnomineeMstList;
	
	
	public String searchData()
	{
		StringBuffer strBuf=new StringBuffer();
		List<Object[]> searchList=null;
		try
		{
			String key=fpenappf2.getSearchKeyword();
			String opt=fpenappf2.getSearchOption();
			int empId=0;
			
			PrintWriter out=getResponse().getWriter();
			strBuf.append("<response>");
			strBuf.append("<command>fpenValidateSearch</command>");

			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId=empProfile.getEmployeeId();			
			searchList=fpenAppDeathService.searchData(key, opt, empId);
								
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
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String loadExistData()
	{
		List<Object[]> myObj=null;
		
		try
		{
			loadCombo();
			
			System.out.println("HiddenSelectedNo..."+HiddenSelectedNo);
			fpenappdeathco=fpenAppDeathService.getDetails(HiddenSelectedNo);
			
			int officeId=0;		
			
			myObj=fpenAppDeathService.getMstData(HiddenSelectedNo);
			nominList=fpenAppDeathService.getNomineeList(HiddenSelectedNo, officeId);
			
			System.out.println("nominList size...........>>>>>>>>>.."+nominList.size());
				for(Object[] obj:myObj)
				{
					fpenappdeathmst=new FamilyPensionApplicationMstData(); 
					fpenappdeathmst.setEmpNo(Integer.parseInt(obj[0]+""));
					fpenappdeathmst.setEmpName(obj[1]+"");
					fpenappdeathmst.setEmpInitial(obj[2]+"");
					fpenappdeathmst.setGpfNo(Integer.parseInt(obj[3]+""));
					
					if(obj[4]!=null)
					{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String dobStr=df.format(obj[4]);									
					fpenappdeathmst.setDob2(dobStr);
					}
					
					
					
					fpenappdeathmst.setGender(obj[5]+"");
					fpenappdeathmst.setOffice(obj[6]+"");
					fpenappdeathmst.setDesignation(obj[7]+"");
					fpenappdeathmst.setOfficeId(Integer.parseInt(obj[8]+""));
					fpenappdeathmst.setDesigId(Integer.parseInt(obj[9]+""));
					fpenappdeathmst.setDesigServiceGrp(Integer.parseInt(obj[10]+""));
					fpenappdeathmst.setGrade(obj[11]+"");
					
					if(obj[12]!=null)
					{
					DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					String dojStr=df.format(obj[12]);											
					fpenappdeathmst.setDoj2(dojStr);
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

	
	public String saveMethod()
	{
		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId);
			
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
			    
				FamilyPensionApplicationDeathFieldForm2MstNomineeDao multidata=null;
				fnomineeMstList = new ArrayList<FamilyPensionApplicationDeathFieldForm2MstNomineeDao>();
			    
			     while(iter.hasNext()){
			    	multidata = new FamilyPensionApplicationDeathFieldForm2MstNomineeDao();	
			    	multidata.setEmpNo(penAppFamDeathMst.getEmpNo());
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
			    	fnomineeMstList.add(multidata);
			    	
		        }
			     fpenAppDeathService.deleteNominee(penAppFamDeathMst.getEmpNo());
			     fpenAppDeathService.saveNominee(fnomineeMstList);
			     
			     penAppFamDeathMst.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));			
			     penAppFamDeathMst.setUpdatedUser(updatedId);
			     penAppFamDeathMst.setProcessStatus("VALIDATE");
		
			
			    fpenAppDeathService.saveDetails(penAppFamDeathMst);		
				fpenAppDeathService.deleteCoDetails(penAppFamDeathMst.getEmpNo());
				fpenAppDeathService.deleteCoNominee(penAppFamDeathMst.getEmpNo());
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public void setFpenAppDeathService(FamilyPensionApplicationDeathFieldForm2ValidateService fpenAppDeathService) {
		this.fpenAppDeathService = fpenAppDeathService;
	}

	public FamilyPensionApplicationDeathFieldForm2ValidateService getFpenAppDeathService() {
		return fpenAppDeathService;
	}

	public void setFpenappf2(CommonSearchModel fpenappf2) {
		this.fpenappf2 = fpenappf2;
	}

	public CommonSearchModel getFpenappf2() {
		return fpenappf2;
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

	public void setHiddenSelectedNo(int hiddenSelectedNo) {
		HiddenSelectedNo = hiddenSelectedNo;
	}

	public int getHiddenSelectedNo() {
		return HiddenSelectedNo;
	}

	public void setFpenappdeathco(FamilyPensionApplicationDeathFieldForm2DetailsDao fpenappdeathco) {
		this.fpenappdeathco = fpenappdeathco;
	}

	public FamilyPensionApplicationDeathFieldForm2DetailsDao getFpenappdeathco() {
		return fpenappdeathco;
	}

	public void setFpenappdeathmst(FamilyPensionApplicationMstData fpenappdeathmst) {
		this.fpenappdeathmst = fpenappdeathmst;
	}

	public FamilyPensionApplicationMstData getFpenappdeathmst() {
		return fpenappdeathmst;
	}

	public void setNominList(List<FamilyPensionApplicationDeathFieldForm2NomineeCo> nominList) {
		this.nominList = nominList;
	}

	public List<FamilyPensionApplicationDeathFieldForm2NomineeCo> getNominList() {
		return nominList;
	}

	public void setPenAppFamDeathMst(FamilyPensionApplicationDeathFieldForm2MstDetailsDao penAppFamDeathMst) {
		this.penAppFamDeathMst = penAppFamDeathMst;
	}

	public FamilyPensionApplicationDeathFieldForm2MstDetailsDao getPenAppFamDeathMst() {
		return penAppFamDeathMst;
	}

	public void setFnomineeMstList(List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> fnomineeMstList) {
		this.fnomineeMstList = fnomineeMstList;
	}

	public List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> getFnomineeMstList() {
		return fnomineeMstList;
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

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}

	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}

	
	
	
}
