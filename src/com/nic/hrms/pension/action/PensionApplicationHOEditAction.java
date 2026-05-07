package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.PensionApplicationHODetailsCoDao;
import com.nic.hrms.pension.model.PensionApplicationHODetailsValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeCoDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceCoDao;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationHOEditService;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class PensionApplicationHOEditAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PensionApplicationHOEditService headEditService;
	private List<PensionApplicationHONomineeCoDao> headOffNominee;
	private List<PensionApplicationHOServiceCoDao> headOffService;
	private OfficeId_service officeIdservice;
	private UpdatedUserIdService updateservice;
	
	private PensionApplicationSearchModel penappsearch1;
	private PensionApplicationSearchModel penappsearch2;
	private PensionApplicationHODetailsCoDao headOffData;
	
	private State_service stateservice;
	private List<State_dao> stateList;	

	private PensionerPaymentOfficeService paymentservice1;
	private List<PensionPaymentOffice_dao> payOfficeList;
//	private PensionApplicationHODetailsValidateDao frzdata;

	private ReligionService religionService;
	private List<ReligionDao> religionCombo;
	
	private String strDesignation;
	private String strEmpIdFrz;
	private String strOfficeName;
	
	private PensionApplicationHONomineeValidateDao penapphonomval;
	//private PensionApplicationHONomineeValidateDao frzdata1;
	private PensionApplicationHODetailsCoDao addpenappho;
	private List<PensionApplicationHONomineeCoDao> nomineeList;
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
	
	private List<PensionApplicationHOServiceCoDao> notVerifyList;
	private List<String> notVerifyServFromDate;
	private List<String> notVerifyServToDate;
	private List<String> notVerifyServiceReason;
	private List<Integer> notVerifyYear;
	private List<Integer> notVerifyMonth;
	private List<Integer> notVerifyDays;
	
	@SuppressWarnings("unchecked")
	public String saveHeadOfficeData()
	{
		try
		{
			
			   HttpSession session=getRequest().getSession();
		       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		       int empId=empProfile.getEmployeeId();
		       
			   int officeId = officeIdservice.getOfficeId(empId);				
			   String updatedId=updateservice.getUpdateId(empId);	
			   
			  
			   //deleteNominee();
			 //  deleteNotVerify();
					
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
				
//				while(iter1.hasNext()){
//					System.out.println("--iterator--"+iter1.next());
//					System.out.println("--iterator-*-"+iter.next());
//				}
				
				PensionApplicationHONomineeCoDao multidata=null;
				nomineeList = new ArrayList<PensionApplicationHONomineeCoDao>();
			    
			     while(iter.hasNext()){
			    	multidata = new PensionApplicationHONomineeCoDao();	
			    	multidata.setEmpNo(addpenappho.getEmpNo());
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
			    	multidata.setProcessStatus("ENTERED");
			    	nomineeList.add(multidata);
			    	
		        }
			     
			     
			     headEditService.saveNominee(nomineeList);
			}
			
			if(notVerifyServFromDate!=null && notVerifyServFromDate.size()>0)
			{
				
				Iterator it1=notVerifyServFromDate.iterator();
				Iterator it2=notVerifyServToDate.iterator();
				Iterator it3=notVerifyServiceReason.iterator();
				Iterator it4=notVerifyYear.iterator();
				Iterator it5=notVerifyMonth.iterator();
				Iterator it6=notVerifyDays.iterator();
				
				while(it1.hasNext()){
					System.out.println("--iterator-2-"+it1.next());
				}
				PensionApplicationHOServiceCoDao multidata2=null;
				notVerifyList = new ArrayList<PensionApplicationHOServiceCoDao>();
		
				while(it1.hasNext())
				{
					multidata2=new PensionApplicationHOServiceCoDao();
					multidata2.setEmpNo(addpenappho.getEmpNo());
					multidata2.setNotVerifyServFromDate((String) it1.next());
					multidata2.setNotVerifyServToDate((String) it2.next());
					multidata2.setNotVerifyServiceReason((String)it3.next());
					multidata2.setNotVerifyYear((Integer)it4.next());
					multidata2.setNotVerifyMonth((Integer)it5.next());
					multidata2.setNotVerifyDays((Integer)it6.next());							
					
					multidata2.setUpdatedUserId(updatedId);
			    	multidata2.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidata2.setProcessStatus("ENTERED");
			    	notVerifyList.add(multidata2);
				}
				
				headEditService.saveNotVerifyService(notVerifyList);
			}
			
			
			addpenappho.setUpdatedUser(updatedId);
			addpenappho.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			addpenappho.setProcessStatus("ENTERED");
			
			boolean saveFlag=headEditService.saveCommonData(addpenappho);
				
			
			System.out.println("SAVING HO RECORDS...."+saveFlag);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public void deleteNominee()
	{	
		try
		{			
			headEditService.addNomineeDelete(addpenappho.getEmpNo());
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
			headEditService.deleteNotVerify(addpenappho.getEmpNo());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public String getMstData()
	{
		System.out.println("Am in action MST DATA...");
		List<Object[]> myMstData=null;
		try
		{
			int selectedNo=penappsearch2.getEmpId();
			myMstData=headEditService.getMasterData(selectedNo);
			System.out.println("GET MST DATA.............");
			
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();		
			xmlString.append("<response>");
			
			xmlString.append("<command>masterData</command>");
		
			for(Object[] tmp:myMstData)
			{
				System.out.println(tmp[0]);
				xmlString.append("<record>");
				xmlString.append("<empNo>"+tmp[0]+"</empNo>");
		        xmlString.append("<empName>"+tmp[1]+"</empName>");
		        xmlString.append("<empInitial>"+tmp[2]+ "</empInitial>");
		        xmlString.append("<gpfNo>"+tmp[3]+"</gpfNo>");
		        xmlString.append("<dob>"+tmp[4]+"</dob>");
		        xmlString.append("<gender>"+tmp[5]+ "</gender>");
		        xmlString.append("<officeStr>"+tmp[6]+ "</officeStr>");	
		        xmlString.append("<designStr>"+tmp[7]+ "</designStr>");			
		        xmlString.append("<doj>"+tmp[8]+"</doj>");
		        xmlString.append("<officeId>"+tmp[9]+ "</officeId>");
		        xmlString.append("<desigId>"+tmp[10]+ "</desigId>");			
		        xmlString.append("<desigServiceGrp>"+tmp[11]+"</desigServiceGrp>");
		        xmlString.append("<gradeId>"+tmp[12]+"</gradeId>");			        
				xmlString.append("</record>");

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
	
	public String getHeadOfficeData()
	{
		try
		{			
			
			System.out.println("Inside HEAD Office Action");
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();					    
		    
			int officeId = officeIdservice.getOfficeId(empId);
		    int selectedId=penappsearch1.getEmpId();
		    System.out.println("selectedId..........."+selectedId);
		    
		    strEmpIdFrz= headEditService.getEmpIdFrz(selectedId);
		    
		    System.out.println("the data already exist.?.........."+strEmpIdFrz);
		    
		 	stateList=stateservice.getListOfstates();			
			payOfficeList = paymentservice1.getListOfPayOffice();
			religionCombo=religionService.getReligionList();
		
			
		    headOffData=headEditService.getFullData(empId, officeId, selectedId);
		    headOffNominee=headEditService.loadNominee(empId, officeId, selectedId);
		    headOffService=headEditService.loadService(empId, officeId, selectedId);
		    
		    System.out.println("headOffData...null check......."+headOffData);
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();		
			xmlString.append("<response>");
			
			xmlString.append("<command>headOfficeData</command>");
			
 	          if(headOffData!=null)
		           {
 	        	  
 	        	  Integer designId=headOffData.getDesigId()==null?0:headOffData.getDesigId();		  
 	  		      strDesignation= headEditService.getDesignation(designId);
 	  		    
 	  		      Integer officeId1=headOffData.getOfficeId()==null?0:headOffData.getOfficeId();
 	  		      strOfficeName=headEditService.getOfficeName(officeId1);
 	  		  
 	  		    
 	        	  	xmlString.append("<HOdetails>");	
 	        	  	xmlString.append("<frzdata>"+strEmpIdFrz+"</frzdata>");
			        xmlString.append("<empNo>"+headOffData.getEmpNo()+"</empNo>");
			        xmlString.append("<empName>"+headOffData.getEmpName()+"</empName>");
			        xmlString.append("<gender>"+headOffData.getGender()+ "</gender>");
			        xmlString.append("<desigServiceGrp>"+headOffData.getDesigServiceGrp()+"</desigServiceGrp>");
			        xmlString.append("<desigId>"+headOffData.getDesigId()+ "</desigId>");				        
			        xmlString.append("<designStr>"+strDesignation+ "</designStr>");			        
			        xmlString.append("<gradeId>"+headOffData.getGradeId()+ "</gradeId>");			        
			        xmlString.append("<officeId>"+headOffData.getOfficeId()+ "</officeId>");
			        xmlString.append("<officeStr>"+strOfficeName+ "</officeStr>");			        
			        xmlString.append("<gpfNo>"+headOffData.getGpfNo()+ "</gpfNo>");
			        xmlString.append("<fatherName>"+headOffData.getFatherName()+ "</fatherName>");
			        xmlString.append("<husbandName>"+headOffData.getHusbandName()+ "</husbandName>");
			        xmlString.append("<religion>"+headOffData.getReligion()+ "</religion>");
			        xmlString.append("<nationality>"+headOffData.getNationality()+ "</nationality>");			        
			        xmlString.append("<empHeight>" +headOffData.getEmpHeight()+ "</empHeight>");
			        xmlString.append("<idMark1>" +headOffData.getIdMark1()+ "</idMark1>");			        
			        xmlString.append("<idMark2>" +headOffData.getIdMark2()+ "</idMark2>");			        
			        xmlString.append("<presentAddress>" +headOffData.getPresentAddress()+ "</presentAddress>");
			        xmlString.append("<permanentAddress>" +headOffData.getPermanentAddress()+ "</permanentAddress>");
			        xmlString.append("<addressAfterRetire>" +headOffData.getAddressAfterRetire()+ "</addressAfterRetire>"); 
			        xmlString.append("<stateId>" +headOffData.getStateId()+ "</stateId>"); 
			        xmlString.append("<chargesFlag>" +headOffData.getChargesFlag()+ "</chargesFlag>");
			        xmlString.append("<chargeDetails>" +headOffData.getChargeDetails()+ "</chargeDetails>");
			        xmlString.append("<pensionPayOfficeId>" +headOffData.getPensionPayOfficeId()+ "</pensionPayOfficeId>");
			        xmlString.append("<appliedDate2>" +headOffData.getAppliedDate2()+ "</appliedDate2>");			        
			        xmlString.append("<dcrgNomineeName>" +headOffData.getDcrgNomineeName()+ "</dcrgNomineeName>");
			        xmlString.append("<dcrgNomineeDob>" +headOffData.getDcrgNomineeDob2()+ "</dcrgNomineeDob>");
			        xmlString.append("<dcrgRelation>" +headOffData.getDcrgRelation()+ "</dcrgRelation>");
			        xmlString.append("<dcrgAddress>" +headOffData.getDcrgAddress()+ "</dcrgAddress>");			   
			        xmlString.append("<notVerifyServiceTotYears>" +headOffData.getNotVerifyServiceTotYears()+ "</notVerifyServiceTotYears>");
			        xmlString.append("<notVerifyServiceTotMonths>" +headOffData.getNotVerifyServiceTotMonths()+ "</notVerifyServiceTotMonths>");
			        xmlString.append("<notVerifyServiceTotDays>" +headOffData.getNotVerifyServiceTotDays()+ "</notVerifyServiceTotDays>");
			        
			        xmlString.append("<famDeathFlag>" +headOffData.getDcfpDeathCertFlag()+ "</famDeathFlag>");
			        xmlString.append("<famDeathRemarks>" +headOffData.getDcfpDeathCertRemarks()+ "</famDeathRemarks>");
			        xmlString.append("<famHeirFlag>" +headOffData.getDcfpHeirCertFlag()+ "</famHeirFlag>");
			        xmlString.append("<famHeirRemarks>" +headOffData.getDcfpHeirCertRemarks()+ "</famHeirRemarks>");
			        xmlString.append("<famServiceFlag>" +headOffData.getDcfpServiceBookFlag()+ "</famServiceFlag>");
			        xmlString.append("<famServiceRemarks>" +headOffData.getDcfpServiceBookRemarks()+ "</famServiceRemarks>");
			        xmlString.append("<famLpd>" +headOffData.getDcfpLastPayDrwan()+ "</famLpd>");
			        xmlString.append("<famPensionFlag>" +headOffData.getDcfpFamilyPensionFlag()+ "</famPensionFlag>");
			        xmlString.append("<famPensionRemarks>" +headOffData.getDcfpFamilyPensionRemarks()+ "</famPensionRemarks>");
			        xmlString.append("<famPhotoFlag>" +headOffData.getDcfpPhotoAttachFlag()+ "</famPhotoFlag>");
			        xmlString.append("<famPhotoRemarks>" +headOffData.getDcfpPhotoAttachRemarks()+ "</famPhotoRemarks>");
			        xmlString.append("<famSignFlag>" +headOffData.getDcfpSignAttachFlag()+ "</famSignFlag>");
			        xmlString.append("<famSignRemarks>" +headOffData.getDcfpSignAttachRemarks()+ "</famSignRemarks>");
			        xmlString.append("<famDueFlag>" +headOffData.getDcfpNoDueCertFlag()+ "</famDueFlag>");
			        xmlString.append("<famDueRemarks>" +headOffData.getDcfpNoDueCertRemarks()+ "</famDueRemarks>");
			        xmlString.append("<famMembersList>" +headOffData.getFamilyMembersList()+ "</famMembersList>");
			        xmlString.append("<famPensionAmount>" +headOffData.getDcfpPensionAmount()+ "</famPensionAmount>");
			        xmlString.append("<famDcrgAmount>" +headOffData.getDcfpGratuityAmount()+ "</famDcrgAmount>");
			        xmlString.append("<appliedDate>" +headOffData.getAppliedDate2()+ "</appliedDate>");
			        xmlString.append("<penFamFlag>" +headOffData.getPenFamilyPensionFlag()+ "</penFamFlag>");
			        xmlString.append("<penFamRemarks>" +headOffData.getPenFamilyPensionRemarks()+ "</penFamRemarks>");
			        xmlString.append("<penPhotoFlag>" +headOffData.getPenPhotoAttachFlag()+ "</penPhotoFlag>");
			        xmlString.append("<penPhotoRemarks>" +headOffData.getPenPhotoAttachRemarks()+ "</penPhotoRemarks>");
			        xmlString.append("<penSignFlag>" +headOffData.getPenSignAttachFlag()+ "</penSignFlag>");
			        xmlString.append("<penSignRemarks>" +headOffData.getPenSignAttachRemarks()+ "</penSignRemarks>");
			        xmlString.append("<penDueFlag>" +headOffData.getPenNoDueCertFlag()+ "</penDueFlag>");
			        xmlString.append("<penDueRemarks>" +headOffData.getPenNoDueCertRemarks()+ "</penDueRemarks>");
			        xmlString.append("<penConRecoverFlag>" +headOffData.getPenConsentRecoverFlag()+ "</penConRecoverFlag>");
			        xmlString.append("<penConRecoverRemarks>" +headOffData.getPenConsentRecoverRemarks()+ "</penConRecoverRemarks>");
			        xmlString.append("<penDeathFlag>" +headOffData.getPenDeathCertFlag()+ "</penDeathFlag>");
			        xmlString.append("<penDeathRemarks>" +headOffData.getPenDeathCertRemarks()+ "</penDeathRemarks>");
			        xmlString.append("<penHeirFlag>" +headOffData.getPenHeirCertFlag() + "</penHeirFlag>");
			        xmlString.append("<penHeirRemarks>" +headOffData.getPenHeirCertRemarks() + "</penHeirRemarks>");
			       
			        xmlString.append("<penServiceFlag>" +headOffData.getPenServiceBookFlag() + "</penServiceFlag>");
			        xmlString.append("<penServiceRemarks>" +headOffData.getPenServiceBookRemarks() + "</penServiceRemarks>");
			      
			        
			        xmlString.append("<penDeclareFlag>" +headOffData.getPenDeclareFlag() + "</penDeclareFlag>");
			        xmlString.append("<penDeclareRemarks>" +headOffData.getPenDeclareRemarks() + "</penDeclareRemarks>");
			        xmlString.append("<penRegardFlag>" +headOffData.getPenRegardDateFlag() + "</penRegardFlag>");
			        xmlString.append("<penRegardRemarks>" +headOffData.getPenRegardDateRemarks() + "</penRegardRemarks>");
			        xmlString.append("<penSancDateFlag>" +headOffData.getPenSanctionUptoDateFlag() + "</penSancDateFlag>");
			        xmlString.append("<penSancDateRemarks>" +headOffData.getPenSanctionUptoDateRemarks() + "</penSancDateRemarks>");
			        xmlString.append("<penPaymentPlace>" +headOffData.getPensionPaymentPlace() + "</penPaymentPlace>");
			        xmlString.append("<dcrgPaymentPlace>" +headOffData.getDcrgPaymentPlace() + "</dcrgPaymentPlace>");
			        xmlString.append("<recoverFlag>" +headOffData.getRecoveriesIfAny() + "</recoverFlag>");
			        xmlString.append("<retireFlag>" +headOffData.getRetireOrderFlag() + "</retireFlag>");
			        xmlString.append("<retireOrderRemarks>" +headOffData.getRetireOrderRemarks() + "</retireOrderRemarks>");
			        xmlString.append("<deputation>" +headOffData.getDeputationIfAny() + "</deputation>");
			        xmlString.append("</HOdetails>");					      
                }
 	          
 	          
 	          for(PensionApplicationHONomineeCoDao tmp: headOffNominee)
 	          {
 	        		xmlString.append("<HOnominee>");		        	
			        xmlString.append("<empNo>"+tmp.getEmpNo()+"</empNo>");
			        xmlString.append("<nominId>"+tmp.getNomineeId()+"</nominId>");
			        xmlString.append("<name>"+tmp.getFamilyMembers()+ "</name>");			        
			        xmlString.append("<initial>"+tmp.getNomineeInitial()+"</initial>");			        
			        xmlString.append("<relation>"+tmp.getRelation()+"</relation>");
			        xmlString.append("<dob>"+tmp.getNomineeDob2()+"</dob>");
			        xmlString.append("<age>"+tmp.getNomineeAge()+"</age>");
			        xmlString.append("<handicapped>"+tmp.getHandicapped()+"</handicapped>");
			        xmlString.append("<martialStatus>"+tmp.getMartialStatus()+"</martialStatus>");
			        xmlString.append("<nominDate>"+tmp.getNominationDate2()+"</nominDate>");
			        xmlString.append("<activeStatus>"+tmp.getActiveStatus()+"</activeStatus>");
			        xmlString.append("<nominReason>"+tmp.getNominReason()+"</nominReason>");
			        xmlString.append("</HOnominee>");	
 	          }
 	          
 	          
 	          
 	        
 	          for(PensionApplicationHOServiceCoDao tmp2: headOffService)
 	          {
 	        	  	xmlString.append("<HOservice>");	
 	        	  	xmlString.append("<ServiceId>"+tmp2.getId()+"</ServiceId>");
 	        	  	xmlString.append("<empNo>"+tmp2.getEmpNo()+"</empNo>");
 	        	  	xmlString.append("<fromDate>"+tmp2.getNotVerifyServFromDate2()+"</fromDate>");
 	        	  	xmlString.append("<toDate>"+tmp2.getNotVerifyServToDate2()+"</toDate>");
 	        	  	xmlString.append("<reason>"+tmp2.getNotVerifyServiceReason()+"</reason>");
 	        	  	xmlString.append("<year>"+tmp2.getNotVerifyYear()+"</year>");
 	        	  	xmlString.append("<month>"+tmp2.getNotVerifyMonth()+"</month>");
 	        	  	xmlString.append("<days>"+tmp2.getNotVerifyDays()+"</days>"); 	        	
 	        	  	xmlString.append("</HOservice>");	
 	        	 
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

	public PensionApplicationHOEditService getHeadEditService() {
		return headEditService;
	}

	public void setHeadEditService(PensionApplicationHOEditService headEditService) {
		this.headEditService = headEditService;
	}

	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}

	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}

	public PensionApplicationSearchModel getPenappsearch1() {
		return penappsearch1;
	}

	public void setPenappsearch1(PensionApplicationSearchModel penappsearch1) {
		this.penappsearch1 = penappsearch1;
	}

	public void setHeadOffData(PensionApplicationHODetailsCoDao headOffData) {
		this.headOffData = headOffData;
	}

	public PensionApplicationHODetailsCoDao getHeadOffData() {
		return headOffData;
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

	public void setHeadOffNominee(List<PensionApplicationHONomineeCoDao> headOffNominee) {
		this.headOffNominee = headOffNominee;
	}

	public List<PensionApplicationHONomineeCoDao> getHeadOffNominee() {
		return headOffNominee;
	}

	public void setHeadOffService(List<PensionApplicationHOServiceCoDao> headOffService) {
		this.headOffService = headOffService;
	}

	public List<PensionApplicationHOServiceCoDao> getHeadOffService() {
		return headOffService;
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

	public void setAddpenappho(PensionApplicationHODetailsCoDao addpenappho) {
		this.addpenappho = addpenappho;
	}

	public PensionApplicationHODetailsCoDao getAddpenappho() {
		return addpenappho;
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

	public List<PensionApplicationHONomineeCoDao> getNomineeList() {
		return nomineeList;
	}

	public void setNomineeList(List<PensionApplicationHONomineeCoDao> nomineeList) {
		this.nomineeList = nomineeList;
	}

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}

	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}

	public List<PensionApplicationHOServiceCoDao> getNotVerifyList() {
		return notVerifyList;
	}

	public void setNotVerifyList(
			List<PensionApplicationHOServiceCoDao> notVerifyList) {
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

	public void setPenappsearch2(PensionApplicationSearchModel penappsearch2) {
		this.penappsearch2 = penappsearch2;
	}

	public PensionApplicationSearchModel getPenappsearch2() {
		return penappsearch2;
	}

	
	
	
	

	
}
