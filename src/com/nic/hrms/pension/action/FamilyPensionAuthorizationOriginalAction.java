package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.FamilyPensionAuthorizationOriginalDao;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.model.PensionAuthorizationOriginalDao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;
import com.nic.hrms.pension.service.FamilyPensionAuthorizationOriginalService;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationHOForm1CalcMstValDataService;
import com.nic.hrms.pension.service.PensionAuthorizationOriginalService;
import com.nic.hrms.pension.service.PensionPaymentOffice_service;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class FamilyPensionAuthorizationOriginalAction extends BaseAction{

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7169781054760780933L;
	private FamilyPensionAuthorizationOriginalService familyPenAuthOriService;
	private PensionApplicationHOForm1CalcMstValDataService penappHeadOfficeform1calcValservice;
	private PensionApplicationSearchModel searchModel;
	private PensionApplicationSearchModel searchModel2;
	private PensionApplicationSearchModel searchModel3;
	private PensionApplicationSearchModel searchModel4;
	private PensionApplicationSearchModel searchModel5;
	private List<Object[]> mstDataList=null;
	private List<Object[]> mstDataList2=null;
	private List<Object[]> searchList=null;
	private List<Object[]> addressList=null;
	private List<Object[]> checkPpoList=null;
	private List<Object[]> nomineeList=null;
	private List<Object[]> nomineeDetailList=null;
	
	private FamilyPensionAuthorizationOriginalDao penAppAuthOri;
	private CommonSearchModel penAuthSearch;
	
	private OfficeId_service officeIdservice;
	private UpdatedUserIdService updateservice;
	private PensionerPaymentOfficeService paymentservice1;
	private List<PensionPaymentOffice_dao> payOfficeList;
	private List<PensionAuthorisedOfficer_dao> penAuthorisedOfficerList;
	private String saveStatus;
	
	public String loadCombo()
	{
		try
		{
			payOfficeList = paymentservice1.getListOfPayOffice();
			penAuthorisedOfficerList = familyPenAuthOriService.getListOfAythorisedOfficer();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String checkPpoNo()
	{
		
		try
		{
			PrintWriter out=getResponse().getWriter();
			StringBuffer xmlString=new StringBuffer();
			xmlString.append("<response>");
			xmlString.append("<command>checkPpoNo</command>");							
		System.out.println("Inside PPO NO check Action ");
			
			int ppoNo=searchModel4.getEmpId();
			checkPpoList=familyPenAuthOriService.checkPpoNo(ppoNo);
			
			for(Object[] obj:checkPpoList)
			{
				xmlString.append("<record>");
				xmlString.append("<empId>"+obj[0]+"</empId>");
				xmlString.append("<ppoNo>"+obj[1]+"</ppoNo>");
				xmlString.append("</record>");
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
		
		}
		return SUCCESS;
	}
	
	public String loadOfficeAddress()
	{
		try
		{
			
			PrintWriter out=getResponse().getWriter();
			StringBuffer xmlString=new StringBuffer();
			xmlString.append("<response>");
			xmlString.append("<command>addressData</command>");							
			
			int officeId=searchModel3.getEmpId();
			addressList=familyPenAuthOriService.getAddress(officeId);
				
			for(Object[] tmp: addressList)
			{
				xmlString.append("<record>");
				xmlString.append("<officeID>"+tmp[0]+"</officeID>");
				xmlString.append("<address1>"+tmp[1]+"</address1>");
				xmlString.append("<address2>"+tmp[2]+"</address2>");
				xmlString.append("<city>"+tmp[3]+"</city>");			
				xmlString.append("<pincode>"+tmp[4]+"</pincode>");	
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
		}
		return SUCCESS;
	}
	
	public String getMstData()
	{
		try
		{
			PrintWriter out=getResponse().getWriter();
			StringBuffer xmlString=new StringBuffer();
			xmlString.append("<response>");
			xmlString.append("<command>getMstData</command>");
						
			Integer empNo=searchModel.getEmpId();			
			if(empNo!=null)
			{			
				mstDataList=familyPenAuthOriService.getMasterDetails(empNo);
				nomineeList=familyPenAuthOriService.getNominee(empNo);
				
				for(Object[] tmp: mstDataList)
				{
					xmlString.append("<record>");
					xmlString.append("<empId>"+tmp[0]+"</empId>");
					xmlString.append("<empName>"+tmp[1]+"</empName>");
					xmlString.append("<empInitial>"+tmp[2]+"</empInitial>");
					xmlString.append("<gpfNo>"+tmp[3]+"</gpfNo>");
					if(tmp[4]!=null)
					{
						SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
						String dobStr=sdf.format(tmp[4]);
						xmlString.append("<dob>"+dobStr+"</dob>");
					}
					xmlString.append("<dob>"+tmp[4]+"</dob>");					
					xmlString.append("<gender>"+tmp[5]+"</gender>");
					xmlString.append("<officeName>"+tmp[6]+"</officeName>");
					xmlString.append("<designation>"+tmp[7]+"</designation>");
					xmlString.append("<officeId>"+tmp[8]+"</officeId>");
					xmlString.append("<desigId>"+tmp[9]+"</desigId>");
					xmlString.append("<desigGrpId>"+tmp[10]+"</desigGrpId>");	
					
					xmlString.append("<ppoNo>"+tmp[11]+"</ppoNo>");
					xmlString.append("<residentAddress>"+tmp[12]+"</residentAddress>");					
					xmlString.append("<fromAddress>"+tmp[13]+"</fromAddress>");
					xmlString.append("<officeStatus>"+tmp[14]+"</officeStatus>");	
					
					xmlString.append("<lastOfficeId>"+tmp[15]+"</lastOfficeId>");
					xmlString.append("<lastOfficeAddress>"+tmp[16]+"</lastOfficeAddress>");
					xmlString.append("<payOfficeId>"+tmp[17]+"</payOfficeId>");
					xmlString.append("<payOfficeAddress>"+tmp[18]+"</payOfficeAddress>");
				
					xmlString.append("<letterNo>"+tmp[19]+"</letterNo>");
					
					if(tmp[20]!=null)
					{
						SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
						String dateStr=sdf.format(tmp[20]);
						xmlString.append("<datedOn>"+dateStr+"</datedOn>");	
					}
					xmlString.append("<datedOn>"+tmp[20]+"</datedOn>");					

					xmlString.append("<ref>"+tmp[21]+"</ref>");					
					xmlString.append("<authOfficer>"+tmp[22]+"</authOfficer>");
					xmlString.append("<authOfficerAddress>"+tmp[23]+"</authOfficerAddress>");					
					xmlString.append("<lastOffice>"+tmp[24]+"</lastOffice>");							
					xmlString.append("<gpono>"+tmp[25]+"</gpono>");
					
					xmlString.append("<nominId>"+tmp[26]+"</nominId>");
					xmlString.append("<nominName>"+tmp[27]+"</nominName>");
					xmlString.append("<relId>"+tmp[28]+"</relId>");
					xmlString.append("<relDesc>"+tmp[29]+"</relDesc>");
					xmlString.append("<nameFromAddress>"+tmp[30]+"</nameFromAddress>");
					xmlString.append("<serviceBookAddress>"+tmp[31]+"</serviceBookAddress>");
					xmlString.append("<oldPermanentAddress>"+tmp[32]+"</oldPermanentAddress>");
					
					xmlString.append("</record>");
				}
				
				
				for(Object[] tmp2: nomineeList)
				{
					xmlString.append("<nominee>");
					xmlString.append("<nomId>"+tmp2[0]+"</nomId>");
					xmlString.append("<nomName>"+tmp2[1]+"</nomName>");					
					xmlString.append("</nominee>");
					
				}
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
	
	/*public String getExistingData()
	{
		try
		{
			PrintWriter out=getResponse().getWriter();
			StringBuffer xmlString=new StringBuffer();
			xmlString.append("<response>");
			xmlString.append("<command>getExistingData</command>");
						
			Integer empNo2=searchModel2.getEmpId();			
			if(empNo2!=null)
			{			
				mstDataList2=penAuthOriService.getExistingDetails(empNo2);
				for(Object[] tmp: mstDataList2)
				{
					xmlString.append("<record>");
					xmlString.append("<empNo>"+tmp[0]+"</empNo>");
					xmlString.append("<ppoNo>"+tmp[1]+"</ppoNo>");
					xmlString.append("<fromAddress>"+tmp[2]+"</fromAddress>");
					xmlString.append("<toAddress>"+tmp[3]+"</toAddress>");					
					xmlString.append("<officeStatus>"+tmp[4]+"</officeStatus>");	
					
					xmlString.append("<payOffice>"+tmp[5]+"</payOffice>");
					xmlString.append("<letterNo>"+tmp[6]+"</letterNo>");
					xmlString.append("<datedOn>"+tmp[7]+"</datedOn>");					
					xmlString.append("<ref>"+tmp[8]+"</ref>");					
					xmlString.append("<authOfficer>"+tmp[9]+"</authOfficer>");
					xmlString.append("<authOfficerAddress>"+tmp[10]+"</authOfficerAddress>");					
					xmlString.append("<copyTo1>"+tmp[11]+"</copyTo1>");
					xmlString.append("<copyTo2>"+tmp[12]+"</copyTo2>");
					xmlString.append("<lastOfficeAddress>"+tmp[13]+"</lastOfficeAddress>");
					
					xmlString.append("</record>");
				}
				
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
		
	}*/
	
	public String getRelation()
	{
		try
		{
			PrintWriter out=getResponse().getWriter();
			StringBuffer xmlString=new StringBuffer();
			xmlString.append("<response>");
			xmlString.append("<command>nomineeDeatils</command>");
						
	
			
			int empNo=searchModel5.getEmpId();
			int nomId=Integer.parseInt(searchModel5.getKeyword());
			System.out.println(empNo+"<<<<<emp....>>>NomId"+nomId);
			nomineeDetailList=familyPenAuthOriService.getNominDetails(empNo, nomId);
			
			for(Object[] tmp: nomineeDetailList)
			{
				xmlString.append("<record>");
				xmlString.append("<nomID>"+tmp[0]+"</nomID>");
				xmlString.append("<nomName>"+tmp[1]+"</nomName>");
				xmlString.append("<relID>"+tmp[2]+"</relID>");
				xmlString.append("<relDesc>"+tmp[3]+"</relDesc>");					
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
	
	public String saveRecord()
	{
		System.out.println("SAVING DATA ACTION");
		try
		{
			  HttpSession session=getRequest().getSession();
		       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		       int empId=empProfile.getEmployeeId();
		       
			   int officeId = officeIdservice.getOfficeId(empId);
				
			   String updatedId=updateservice.getUpdateId(empId);
			   
			   int empidd=penAppAuthOri.getEmpNo();
			
			   if(saveStatus.equals("Draft"))
			   {
				   penAppAuthOri.setProcessStatus("Draft");	   
			   }
				   
			   if(saveStatus.equals("Final"))
			   {
				   penAppAuthOri.setProcessStatus("Final");	
				   penappHeadOfficeform1calcValservice.deleteHOForm1Avgemoluments(empidd);
				   penappHeadOfficeform1calcValservice.deleteHOForm1Details(empidd);
				   penappHeadOfficeform1calcValservice.deleteHOForm1Recoveries(empidd);
				   familyPenAuthOriService.deleteHoCoDetails(empidd);
			   }
			System.out.println("NOMINEE NAME IS:::::"+nomineeList);
			penAppAuthOri.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			penAppAuthOri.setUpdateUser(updatedId);
			
			familyPenAuthOriService.saveRecord(penAppAuthOri);	
		}
				
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;			
		}
		
		return SUCCESS;
	}
	
	public String searchAction()
	{
		try
		{	
		
			PrintWriter out=getResponse().getWriter();
			StringBuffer xmlString=new StringBuffer();
			xmlString.append("<response>");
			xmlString.append("<command>searchData</command>");							
			boolean myFlag=false;
			
			
			String key=penAuthSearch.getSearchKeyword();
			String opt=penAuthSearch.getSearchOption();
			searchList=familyPenAuthOriService.searchOperation(opt, key);
			
			for(Object[] tmp: searchList)
			{
				xmlString.append("<record>");
				xmlString.append("<empNo>"+tmp[0]+"</empNo>");
				xmlString.append("<empName>"+tmp[1]+"</empName>");
				xmlString.append("<designation>"+tmp[2]+"</designation>");
				xmlString.append("<officeName>"+tmp[3]+"</officeName>");					
				xmlString.append("</record>");
				myFlag=true;
			}
					
			xmlString.append("<flag>"+myFlag+"</flag>");	
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

	public FamilyPensionAuthorizationOriginalService getFamilyPenAuthOriService() {
		return familyPenAuthOriService;
	}

	public void setFamilyPenAuthOriService(
			FamilyPensionAuthorizationOriginalService familyPenAuthOriService) {
		this.familyPenAuthOriService = familyPenAuthOriService;
	}

	public PensionApplicationHOForm1CalcMstValDataService getPenappHeadOfficeform1calcValservice() {
		return penappHeadOfficeform1calcValservice;
	}

	public void setPenappHeadOfficeform1calcValservice(
			PensionApplicationHOForm1CalcMstValDataService penappHeadOfficeform1calcValservice) {
		this.penappHeadOfficeform1calcValservice = penappHeadOfficeform1calcValservice;
	}

	public PensionApplicationSearchModel getSearchModel() {
		return searchModel;
	}

	public void setSearchModel(PensionApplicationSearchModel searchModel) {
		this.searchModel = searchModel;
	}

	public PensionApplicationSearchModel getSearchModel2() {
		return searchModel2;
	}

	public void setSearchModel2(PensionApplicationSearchModel searchModel2) {
		this.searchModel2 = searchModel2;
	}

	public PensionApplicationSearchModel getSearchModel3() {
		return searchModel3;
	}

	public void setSearchModel3(PensionApplicationSearchModel searchModel3) {
		this.searchModel3 = searchModel3;
	}

	public PensionApplicationSearchModel getSearchModel4() {
		return searchModel4;
	}

	public void setSearchModel4(PensionApplicationSearchModel searchModel4) {
		this.searchModel4 = searchModel4;
	}

	public PensionApplicationSearchModel getSearchModel5() {
		return searchModel5;
	}

	public void setSearchModel5(PensionApplicationSearchModel searchModel5) {
		this.searchModel5 = searchModel5;
	}

	public List<Object[]> getMstDataList() {
		return mstDataList;
	}

	public void setMstDataList(List<Object[]> mstDataList) {
		this.mstDataList = mstDataList;
	}

	public List<Object[]> getMstDataList2() {
		return mstDataList2;
	}

	public void setMstDataList2(List<Object[]> mstDataList2) {
		this.mstDataList2 = mstDataList2;
	}

	public List<Object[]> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<Object[]> searchList) {
		this.searchList = searchList;
	}

	public List<Object[]> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Object[]> addressList) {
		this.addressList = addressList;
	}

	public List<Object[]> getCheckPpoList() {
		return checkPpoList;
	}

	public void setCheckPpoList(List<Object[]> checkPpoList) {
		this.checkPpoList = checkPpoList;
	}

	public List<Object[]> getNomineeList() {
		return nomineeList;
	}

	public void setNomineeList(List<Object[]> nomineeList) {
		this.nomineeList = nomineeList;
	}

	public List<Object[]> getNomineeDetailList() {
		return nomineeDetailList;
	}

	public void setNomineeDetailList(List<Object[]> nomineeDetailList) {
		this.nomineeDetailList = nomineeDetailList;
	}

	public FamilyPensionAuthorizationOriginalDao getPenAppAuthOri() {
		return penAppAuthOri;
	}

	public void setPenAppAuthOri(FamilyPensionAuthorizationOriginalDao penAppAuthOri) {
		this.penAppAuthOri = penAppAuthOri;
	}

	public CommonSearchModel getPenAuthSearch() {
		return penAuthSearch;
	}

	public void setPenAuthSearch(CommonSearchModel penAuthSearch) {
		this.penAuthSearch = penAuthSearch;
	}

	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}

	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}

	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
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

	public List<PensionAuthorisedOfficer_dao> getPenAuthorisedOfficerList() {
		return penAuthorisedOfficerList;
	}

	public void setPenAuthorisedOfficerList(
			List<PensionAuthorisedOfficer_dao> penAuthorisedOfficerList) {
		this.penAuthorisedOfficerList = penAuthorisedOfficerList;
	}

	public String getSaveStatus() {
		return saveStatus;
	}

	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
		
}

