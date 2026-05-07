package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.model.PensionAuthorizationOriginalDao;
import com.nic.hrms.pension.model.RevisedPensionAuthorizationDao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;
import com.nic.hrms.pension.model.RevisedPensionReportModel;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationHOForm1CalcMstValDataService;
import com.nic.hrms.pension.service.RevisedPensionAuthorizationService;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class RevisedPensionAuthorizationAction extends BaseAction
{
	private static final long serialVersionUID = -7169781054760780933L;
	private RevisedPensionAuthorizationService revisedPenAuthService;
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
	
	RevisedPensionAuthorizationDao revisedPenAppAuthOri;
	private CommonSearchModel revPenAuthSearch;
	
	private OfficeId_service officeIdservice;
	private UpdatedUserIdService updateservice;
	private PensionerPaymentOfficeService paymentservice1;
	private List<PensionPaymentOffice_dao> payOfficeList;
	private List<PensionAuthorisedOfficer_dao> penAuthorisedOfficerList;
	private String saveStatus;
	private int reportformId; 
	private String status;
	private String pen_option;
	private int empno;
	private int ppono;
	private int gpono;
	private int officeid;
	private String LetterNo;
	private String residentAddress;
	private String date_on;
	private String officeaddress;
	private String from_address;
	private String namefromaddress;
	private String servicebookaddress;
	private String reference;
	private int lastworkofficeid;
	private String lastworkofficeaddress;
	private String authoffaddress;
	private int authoffid;
	private String nominee_name;
	private int nominee_id;
	private int nominee_relationId;
	private String nominee_relationDesc;
	
	/*
	private int authorizedofficer;	
	*/
		
	
	HashMap <String, String> reportParams = new HashMap<String, String>();
	
	List<RevisedPensionReportModel> revisedpensionnotedetails;
	List<RevisedPensionReportModel> onemancommisionnotedetails;
	List<RevisedPensionReportModel> revisedpensionorderdetails;
	List<RevisedPensionReportModel> revisedpensiondcrgdetails;
	List<RevisedPensionReportModel> revisedpension_subreport_details;
	List<RevisedPensionReportModel> revisedpension_subreport_details1;
			
	
	public String loadCombo()
	{
		try
		{
			payOfficeList = paymentservice1.getListOfPayOffice();
			penAuthorisedOfficerList = revisedPenAuthService.getListOfAythorisedOfficer();
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
			//System.out.println("Inside PPO NO check Action ");
			
			int ppoNo=searchModel4.getEmpId();
			checkPpoList=revisedPenAuthService.checkPpoNo(ppoNo);
			
			for(Object[] obj:checkPpoList)
			{
				xmlString.append("<record>");
				xmlString.append("<empId>"+obj[0]+"</empId>");
				xmlString.append("<ppoNo>"+obj[1]+"</ppoNo>");
				xmlString.append("</record>");
			}
			 xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 //System.out.println(xmlString.toString());
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
			addressList=revisedPenAuthService.getAddress(officeId);
				
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
		 //System.out.println(xmlString.toString());
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
				mstDataList=revisedPenAuthService.getMasterDetails(empNo);
				nomineeList=revisedPenAuthService.getNominee(empNo);
				
				for(Object[] tmp: mstDataList)
				{
					xmlString.append("<record>");
					xmlString.append("<empId>"+tmp[0]+"</empId>");
					xmlString.append("<empName>"+tmp[1]+"</empName>");
					//xmlString.append("<empInitial>"+tmp[2]+"</empInitial>");
					xmlString.append("<gpfNo>"+tmp[2]+"</gpfNo>");
					if(tmp[3]!=null)
					{
						SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
						String dobStr=sdf.format(tmp[3]);
						xmlString.append("<dob>"+dobStr+"</dob>");
					}
					xmlString.append("<dob>"+tmp[3]+"</dob>");					
					xmlString.append("<gender>"+tmp[4]+"</gender>");
					xmlString.append("<officeName>"+tmp[5]+"</officeName>");
					xmlString.append("<designation>"+tmp[6]+"</designation>");
					xmlString.append("<officeId>"+tmp[7]+"</officeId>");
					xmlString.append("<desigId>"+tmp[8]+"</desigId>");
					xmlString.append("<desigGrpId>"+tmp[9]+"</desigGrpId>");	
					
					xmlString.append("<ppoNo>"+tmp[10]+"</ppoNo>");
					xmlString.append("<residentAddress>"+tmp[11]+"</residentAddress>");					
					xmlString.append("<fromAddress>"+tmp[12]+"</fromAddress>");
					xmlString.append("<officeStatus>"+tmp[13]+"</officeStatus>");	
					
					xmlString.append("<lastOfficeId>"+tmp[14]+"</lastOfficeId>");
					xmlString.append("<lastOfficeAddress>"+tmp[15]+"</lastOfficeAddress>");
					xmlString.append("<payOfficeId>"+tmp[16]+"</payOfficeId>");
					xmlString.append("<payOfficeAddress>"+tmp[17]+"</payOfficeAddress>");
				
					xmlString.append("<letterNo>"+tmp[18]+"</letterNo>");
					
					if(tmp[19]!=null)
					{
						SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
						String dateStr=sdf.format(tmp[19]);
						xmlString.append("<datedOn>"+dateStr+"</datedOn>");	
					}
					xmlString.append("<datedOn>"+tmp[19]+"</datedOn>");					

					xmlString.append("<ref>"+tmp[20]+"</ref>");					
					xmlString.append("<authOfficer>"+tmp[21]+"</authOfficer>");
					xmlString.append("<authOfficerAddress>"+tmp[22]+"</authOfficerAddress>");					
					xmlString.append("<lastOffice>"+tmp[23]+"</lastOffice>");							
					xmlString.append("<gpono>"+tmp[24]+"</gpono>");
					
					xmlString.append("<nominId>"+tmp[25]+"</nominId>");
					xmlString.append("<nominName>"+tmp[26]+"</nominName>");
					xmlString.append("<relId>"+tmp[27]+"</relId>");
					xmlString.append("<relDesc>"+tmp[28]+"</relDesc>");
					xmlString.append("<nameFromAddress>"+tmp[29]+"</nameFromAddress>");
					xmlString.append("<serviceBookAddress>"+tmp[30]+"</serviceBookAddress>");
					
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
			 //System.out.println(xmlString.toString());
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
			//System.out.println(empNo+"<<<<<emp....>>>NomId"+nomId);
			nomineeDetailList=revisedPenAuthService.getNominDetails(empNo, nomId);
			
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
			 //System.out.println(xmlString.toString());
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
	
	@SuppressWarnings("deprecation")
	public String printRevisedpensionOrder() throws JRException
	{
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		//System.out.println("in Action ----"+nameforfromaddress);
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		
		revisedpensionorderdetails=revisedPenAuthService.getRevisedPensionDetails(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getRevisedPensionDetailssubreport(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);
		revisedpension_subreport_details1=revisedPenAuthService.getRevisedPensionDetailssubreport1(getRequest(), empId);
		//System.out.println("-----------Calling Sub Report 1-----------");
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport_order.jasper"));
		//System.out.println("-----------Calling Sub Report 2-----------");
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport1_order.jasper"));
		
		
		return SUCCESS;
	}
	public String printOneManCommisionOrder() throws JRException
	{
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		//System.out.println("in Action ----"+nameforfromaddress);
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		
		onemancommisionnotedetails=revisedPenAuthService.getOneManCommisionDetails(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getOneManCommisionDetailssubreport(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);
		revisedpension_subreport_details1=revisedPenAuthService.getOneManCommisionDetailssubreport1(getRequest(), empId);
		//System.out.println("-----------Calling Sub Report 1-----------");
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/OneMan_Commision_Due_to_Incr_pay_supreport_order.jasper"));
		//System.out.println("-----------Calling Sub Report 2-----------");
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/OneMan_Commision_Due_to_Incr_pay_supreport1_order.jasper"));
		
		
		return SUCCESS;
	}
	public String printGradePay_order() throws JRException
	{
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		//System.out.println("in Action ----"+nameforfromaddress);
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		
		onemancommisionnotedetails=revisedPenAuthService.getGradePayDetails(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getGradePayDetailssubreport(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);
		revisedpension_subreport_details1=revisedPenAuthService.getGradePayDetailssubreport1(getRequest(), empId);
		//System.out.println("-----------Calling Sub Report 1-----------");
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Grade_Pay_Due_to_Incr_pay_supreport_order.jasper"));
		//System.out.println("-----------Calling Sub Report 2-----------");
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Grade_pay_Due_to_Incr_pay_supreport1_order.jasper"));
		
		
		
		return SUCCESS;
	}
	public String printSpecialGradeOrder() throws JRException
	{
		
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		//System.out.println("in Action ----"+nameforfromaddress);
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		
		onemancommisionnotedetails=revisedPenAuthService.getSpecialGradeDetails(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getSpecialGradeDetailssubreport(getRequest(), empId,letter_number,dated_on,reference,ppono,nameforfromaddress);
		revisedpension_subreport_details1=revisedPenAuthService.getSpecialGradeDetailssubreport1(getRequest(), empId);
		//System.out.println("-----------Calling Sub Report 1-----------");
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Special_Grade_Due_to_Incr_pay_supreport_order.jasper"));
		//System.out.println("-----------Calling Sub Report 2-----------");
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Special_Grade_Due_to_Incr_pay_supreport1_order.jasper"));
		
		
		return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	public String printRevisedpensionDcrg() throws JRException
	{
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		revisedpensiondcrgdetails=revisedPenAuthService.getRevisedPensionDCRGDetails(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getRevisedPensionDetailssubreport(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);
		//reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/OneMan_Commision_Due_to_Incr_pay_supreport_order.jasper"));
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport_order.jasper"));
		
		return SUCCESS;
	}

	public String printOneManCommisionDcrg() throws JRException
	{
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		onemancommisionnotedetails=revisedPenAuthService.getOneManCommisionDCRGDetails(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getOneManCommisionDetailssubreport(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);
		//reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport_order.jasper"));
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/OneMan_Commision_Due_to_Incr_pay_supreport_order.jasper"));
		
		return SUCCESS;
	}
	public String printgradepayDcrg() throws JRException
	{
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		onemancommisionnotedetails=revisedPenAuthService.getGradePayDCRGDetails(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getGradePayDetailssubreport(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);
		//reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport_order.jasper"));
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Grade_Pay_Due_to_Incr_pay_supreport_order.jasper"));
		
		return SUCCESS;
	}
	
	public String printSpecialGradeDcrg()
	{
		int empId=0;
		int empId1=0;
		String ppono=null;
		String nameforfromaddress=null;
		String letter_number=null;
		String dated_on=null;
		String reference=null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		ppono=getRequest().getParameter("ppono");
		nameforfromaddress=getRequest().getParameter("FromAddress");
		letter_number=getRequest().getParameter("LetterNo");		
		dated_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		onemancommisionnotedetails=revisedPenAuthService.getSpecialGradeDCRGDetails(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);		
		revisedpension_subreport_details=revisedPenAuthService.getSpecialGradeDetailssubreport(getRequest(), empId, letter_number, dated_on,reference,ppono,nameforfromaddress);
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Special_Grade_Due_to_Incr_pay_supreport_order.jasper"));
		
		return SUCCESS;
	}
	public String SaveRecordAsDraft()throws Exception
	{
		//System.out.println("DRAFT DATA SAVING ACTION");
		int empId=0;
		int empId1=0;
		String flag="error";
		boolean succflag=false;
		revisedPenAppAuthOri = new RevisedPensionAuthorizationDao();
		try
		{			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    empId1=empProfile.getEmployeeId();
		    //System.out.println("Emp_id1 is ::: "+empId1);		
		    empId=Integer.parseInt(getRequest().getParameter("empId"));	   
		    //empId=getEmpno();
		    //System.out.println("empId :::"+empId);
		    revisedPenAppAuthOri.setEmpNo(empId); 		    
		    
		    revisedPenAppAuthOri.setPpoNo(getPpono());		    
		    revisedPenAppAuthOri.setGpoNo(getGpono());
		    revisedPenAppAuthOri.setResidentialAddress(getResidentAddress());
		    revisedPenAppAuthOri.setDatedOn(getDate_on());
		    revisedPenAppAuthOri.setPaymentOfficeId(getOfficeid());
		    revisedPenAppAuthOri.setPaymentOfficeAddress(getOfficeaddress());		    
		    revisedPenAppAuthOri.setFromAddress(getFrom_address());
		    revisedPenAppAuthOri.setServiceBookAddress(getServicebookaddress());
		    revisedPenAppAuthOri.setNamefromAddress(getNamefromaddress());
		    revisedPenAppAuthOri.setReference(getReference());
		    revisedPenAppAuthOri.setLastWorkOfficeId(getLastworkofficeid());
		    revisedPenAppAuthOri.setLastWorkOfficeAddress(getLastworkofficeaddress());
		    revisedPenAppAuthOri.setLastWorkOffice(getLastworkofficeaddress());			
			revisedPenAppAuthOri.setAuthorizedOfficer(getAuthoffid());
			revisedPenAppAuthOri.setAuthorizedOfficerAddress(getAuthoffaddress());
			revisedPenAppAuthOri.setNomineeId(getNominee_id());
			revisedPenAppAuthOri.setNomineeName(getNominee_name());
			revisedPenAppAuthOri.setNomineeRelationId(getNominee_relationId());
			revisedPenAppAuthOri.setNomineeRelationDesc(getNominee_relationDesc());		
			String letter=getLetterNo();			
			//System.out.println(letter);  
		    
			String updateUser=updateservice.getUpdateId(empId1);	
			
			//revisedPenAppAuthOri.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			revisedPenAppAuthOri.setUpdateUser(updateUser);
			revisedPenAppAuthOri.setLetterNo(letter);
			//String saveStatus=getRequest().getParameter("Status");
			String saveStatus = getStatus();
			//System.out.println("saveStatus === " +saveStatus);			
			
			if(saveStatus.equals("Draft"))
			{				   
				revisedPenAppAuthOri.setProcessStatus(getStatus());	
				//System.out.println("------------------------Status is Draft---------------------");
				
				succflag=revisedPenAuthService.deleteRecord(empId);
				//System.out.println(succflag);
				if(succflag==true)
				{
					revisedPenAuthService.saveRecord(revisedPenAppAuthOri);
				}
				flag="success";
			}
		}
				
		catch(Exception e)
		{
			e.printStackTrace();
			return flag;			
		}
		return flag;
	}
	
	
	public String saveRecord()
	{
		//System.out.println("SAVING DATA ACTION");
		String actionflag="error";
		String flag="";
		try
		{
			  HttpSession session=getRequest().getSession();
		       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		       int empId=empProfile.getEmployeeId();
		       
			   int officeId = officeIdservice.getOfficeId(empId);
				
			   String updatedId=updateservice.getUpdateId(empId);
			   
			   int empidd=revisedPenAppAuthOri.getEmpNo();
			   
			   String letter=revisedPenAppAuthOri.getLetterNo();
			   //System.out.println(letter);
				   //request.getParameter("letterNo");
			   
			   
			   
			  // revisedPenAppAuthOri.setLetterNo(letter);
			
			   if(saveStatus.equals("Draft"))
			   {				   
				   revisedPenAppAuthOri.setProcessStatus("Draft");	
				   //System.out.println("------------------------Status is Draft---------------------");
				   revisedPenAuthService.saveRecord(revisedPenAppAuthOri);
			   }
				   
			   if(saveStatus.equals("Final"))
			   {
				   revisedPenAppAuthOri.setProcessStatus("Final");
				   //System.out.println("pen_option--------"+pen_option);
				   if(pen_option.equals("Revised_Pension"))
				   {
					   flag="DUE TO PAY REVISED PENSION";
				   }
				   else if(pen_option.equals("OneMan_Commision"))
				   {
					   flag="DUE TO PAY ONEMAN COMMISION";
				   }
				   else if(pen_option.equals("Special_Grade"))
				   {
					   flag="DUE TO PAY SPECIAL GRADE";
				   }
				  // System.out.println("pen_option--------"+flag);
				   //System.out.println("------------------------Status is Final---------------------");
				   //penappHeadOfficeform1calcValservice.deleteHOForm1Avgemoluments(empidd);
				   //penappHeadOfficeform1calcValservice.deleteHOForm1Details(empidd);
				   //penappHeadOfficeform1calcValservice.deleteHOForm1Recoveries(empidd);
				   //revisedPenAuthService.deleteHoCoDetails(empidd);	
				   boolean test=revisedPenAuthService.moveRevisedDetails(empidd,flag);
					//System.out.println(test);
					actionflag="success";
			   }
				
			revisedPenAppAuthOri.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			revisedPenAppAuthOri.setUpdateUser(updatedId);
			
//			if(revisedPenAuthService.saveRecord(revisedPenAppAuthOri)==true && saveStatus.equals("Final"))
//			{
//				System.out.println("------------------------Status is Final & Calling saveRecord method---------------------");
//				boolean test=revisedPenAuthService.moveRevisedDetails(empidd);
//				System.out.println(test);
//				actionflag="success";				
//			}
		}
				
		catch(Exception e)
		{
			e.printStackTrace();
			return actionflag;			
		}
		
		return actionflag;
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
			
			
			String key=revPenAuthSearch.getSearchKeyword();
			String opt=revPenAuthSearch.getSearchOption();
			searchList=revisedPenAuthService.searchOperation(opt, key);
			
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
		 //System.out.println(xmlString.toString());
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


	public String printRevisedpensionNote() throws JRException
	{
		int empId=0;
		int empId1=0;
		String lett_no=null;
		String date_on=null; 
		String reference = null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
			//System.out.println("The emp id is "+empId);			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
				
		lett_no=getRequest().getParameter("LetterNo");		
		date_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		revisedpensionnotedetails=revisedPenAuthService.getRevisedpensionDetails_Note(getRequest(), empId,lett_no,date_on,reference);
		//reportrevisedpenParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revisedpaypensiontest.jasper"));
		
		return SUCCESS;
	}
	
	
	public String printOneManCommisionNote() throws JRException
	{
		int empId=0;
		int empId1=0;
		String lett_no=null;
		String date_on=null; 
		String reference = null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
			//System.out.println("The emp id is "+empId);			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
				
		lett_no=getRequest().getParameter("LetterNo");		
		date_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		onemancommisionnotedetails=revisedPenAuthService.getOneManCommDetails_Note(getRequest(), empId,lett_no,date_on,reference);
		//reportrevisedpenParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revisedpaypensiontest.jasper"));
		
		return SUCCESS;
	}
public String printsplgradeNote()
{
	
	int empId=0;
	int empId1=0;
	String lett_no=null;
	String date_on=null; 
	String reference = null;
	try
	{
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		empId1=empProfile.getEmployeeId();
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		//System.out.println("The emp id is "+empId);			
	}
	catch(Exception e)
	{
		System.out.println("Error in Getting Session Value");
	}
			
	lett_no=getRequest().getParameter("LetterNo");		
	date_on=getRequest().getParameter("date_on");
	reference=getRequest().getParameter("reference");
	onemancommisionnotedetails=revisedPenAuthService.getSplGrade_Note(getRequest(), empId,lett_no,date_on,reference);
	//reportrevisedpenParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revisedpaypensiontest.jasper"));
	return SUCCESS;
}
	public String printgradepayNote()
	{
		
		int empId=0;
		int empId1=0;
		String lett_no=null;
		String date_on=null; 
		String reference = null;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
			//System.out.println("The emp id is "+empId);			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
				
		lett_no=getRequest().getParameter("LetterNo");		
		date_on=getRequest().getParameter("date_on");
		reference=getRequest().getParameter("reference");
		onemancommisionnotedetails=revisedPenAuthService.getGradePay_Note(getRequest(), empId,lett_no,date_on,reference);
		//reportrevisedpenParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revisedpaypensiontest.jasper"));
		return SUCCESS;
	}
	
	public List<RevisedPensionReportModel> getOnemancommisionnotedetails() {
		return onemancommisionnotedetails;
	}

	public void setOnemancommisionnotedetails(
			List<RevisedPensionReportModel> onemancommisionnotedetails) {
		this.onemancommisionnotedetails = onemancommisionnotedetails;
	}

	public RevisedPensionAuthorizationService getRevisedPenAuthService() {
		return revisedPenAuthService;
	}
	public void setRevisedPenAuthService(
			RevisedPensionAuthorizationService revisedPenAuthService) {
		this.revisedPenAuthService = revisedPenAuthService;
	}
	public void setSearchModel(PensionApplicationSearchModel searchModel) {
		this.searchModel = searchModel;
	}
	public PensionApplicationSearchModel getSearchModel() {
		return searchModel;
	}
	public void setMstDataList(List<Object[]> mstDataList) {
		this.mstDataList = mstDataList;
	}
	public List<Object[]> getMstDataList() {
		return mstDataList;
	}		
	
	public RevisedPensionAuthorizationDao getRevisedPenAppAuthOri() {
		return revisedPenAppAuthOri;
	}

	public void setRevisedPenAppAuthOri(
			RevisedPensionAuthorizationDao revisedPenAppAuthOri) {
		this.revisedPenAppAuthOri = revisedPenAppAuthOri;
	}

	public void setSearchModel2(PensionApplicationSearchModel searchModel2) {
		this.searchModel2 = searchModel2;
	}
	public PensionApplicationSearchModel getSearchModel2() {
		return searchModel2;
	}
	public void setMstDataList2(List<Object[]> mstDataList2) {
		this.mstDataList2 = mstDataList2;
	}
	public List<Object[]> getMstDataList2() {
		return mstDataList2;
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
	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
	}
	public String getSaveStatus() {
		return saveStatus;
	}	
	public CommonSearchModel getRevPenAuthSearch() {
		return revPenAuthSearch;
	}
	public void setRevPenAuthSearch(CommonSearchModel revPenAuthSearch) {
		this.revPenAuthSearch = revPenAuthSearch;
	}
	public void setSearchList(List<Object[]> searchList) {
		this.searchList = searchList;
	}
	public List<Object[]> getSearchList() {
		return searchList;
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
	public void setSearchModel3(PensionApplicationSearchModel searchModel3) {
		this.searchModel3 = searchModel3;
	}
	public PensionApplicationSearchModel getSearchModel3() {
		return searchModel3;
	}
	public void setAddressList(List<Object[]> addressList) {
		this.addressList = addressList;
	}
	public List<Object[]> getAddressList() {
		return addressList;
	}
	public void setSearchModel4(PensionApplicationSearchModel searchModel4) {
		this.searchModel4 = searchModel4;
	}
	public PensionApplicationSearchModel getSearchModel4() {
		return searchModel4;
	}
	public void setCheckPpoList(List<Object[]> checkPpoList) {
		this.checkPpoList = checkPpoList;
	}
	public List<Object[]> getCheckPpoList() {
		return checkPpoList;
	}
	public void setNomineeList(List<Object[]> nomineeList) {
		this.nomineeList = nomineeList;
	}
	public List<Object[]> getNomineeList() {
		return nomineeList;
	}
	public void setSearchModel5(PensionApplicationSearchModel searchModel5) {
		this.searchModel5 = searchModel5;
	}
	public PensionApplicationSearchModel getSearchModel5() {
		return searchModel5;
	}
	public void setNomineeDetailList(List<Object[]> nomineeDetailList) {
		this.nomineeDetailList = nomineeDetailList;
	}
	public List<Object[]> getNomineeDetailList() {
		return nomineeDetailList;
	}
	public PensionApplicationHOForm1CalcMstValDataService getPenappHeadOfficeform1calcValservice() {
		return penappHeadOfficeform1calcValservice;
	}
	public void setPenappHeadOfficeform1calcValservice(
			PensionApplicationHOForm1CalcMstValDataService penappHeadOfficeform1calcValservice) {
		this.penappHeadOfficeform1calcValservice = penappHeadOfficeform1calcValservice;
	}
	public List<PensionAuthorisedOfficer_dao> getPenAuthorisedOfficerList() {
		return penAuthorisedOfficerList;
	}
	public void setPenAuthorisedOfficerList(
			List<PensionAuthorisedOfficer_dao> penAuthorisedOfficerList) {
		this.penAuthorisedOfficerList = penAuthorisedOfficerList;
	}

	public int getReportformId() {
		return reportformId;
	}

	public void setReportformId(int reportformId) {
		this.reportformId = reportformId;
	}

	public HashMap<String, String> getReportParams() {
		return reportParams;
	}

	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}

	public List<RevisedPensionReportModel> getRevisedpensionorderdetails() {
		return revisedpensionorderdetails;
	}

	public void setRevisedpensionorderdetails(
			List<RevisedPensionReportModel> revisedpensionorderdetails) {
		this.revisedpensionorderdetails = revisedpensionorderdetails;
	}

	public List<RevisedPensionReportModel> getRevisedpension_subreport_details() {
		return revisedpension_subreport_details;
	}

	public void setRevisedpension_subreport_details(
			List<RevisedPensionReportModel> revisedpension_subreport_details) {
		this.revisedpension_subreport_details = revisedpension_subreport_details;
	}

	public List<RevisedPensionReportModel> getRevisedpension_subreport_details1() {
		return revisedpension_subreport_details1;
	}

	public void setRevisedpension_subreport_details1(
			List<RevisedPensionReportModel> revisedpension_subreport_details1) {
		this.revisedpension_subreport_details1 = revisedpension_subreport_details1;
	}

	public List<RevisedPensionReportModel> getRevisedpensionnotedetails() {
		return revisedpensionnotedetails;
	}

	public void setRevisedpensionnotedetails(
			List<RevisedPensionReportModel> revisedpensionnotedetails) {
		this.revisedpensionnotedetails = revisedpensionnotedetails;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<RevisedPensionReportModel> getRevisedpensiondcrgdetails() {
		return revisedpensiondcrgdetails;
	}

	public void setRevisedpensiondcrgdetails(
			List<RevisedPensionReportModel> revisedpensiondcrgdetails) {
		this.revisedpensiondcrgdetails = revisedpensiondcrgdetails;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getLetterNo() {
		return LetterNo;
	}

	public void setLetterNo(String letterNo) {
		LetterNo = letterNo;
	}

	public int getPpono() {
		return ppono;
	}

	public void setPpono(int ppono) {
		this.ppono = ppono;
	}

	public int getGpono() {
		return gpono;
	}

	public void setGpono(int gpono) {
		this.gpono = gpono;
	}

	public String getResidentAddress() {
		return residentAddress;
	}

	public void setResidentAddress(String residentAddress) {
		this.residentAddress = residentAddress;
	}

	public String getDate_on() {
		return date_on;
	}

	public void setDate_on(String date_on) {
		this.date_on = date_on;
	}

	public int getOfficeid() {
		return officeid;
	}

	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}

	public String getOfficeaddress() {
		return officeaddress;
	}

	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}

	public String getFrom_address() {
		return from_address;
	}

	public void setFrom_address(String from_address) {
		this.from_address = from_address;
	}

	public String getNamefromaddress() {
		return namefromaddress;
	}

	public void setNamefromaddress(String namefromaddress) {
		this.namefromaddress = namefromaddress;
	}

	public String getServicebookaddress() {
		return servicebookaddress;
	}

	public void setServicebookaddress(String servicebookaddress) {
		this.servicebookaddress = servicebookaddress;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getLastworkofficeid() {
		return lastworkofficeid;
	}

	public void setLastworkofficeid(int lastworkofficeid) {
		this.lastworkofficeid = lastworkofficeid;
	}

	public String getLastworkofficeaddress() {
		return lastworkofficeaddress;
	}

	public void setLastworkofficeaddress(String lastworkofficeaddress) {
		this.lastworkofficeaddress = lastworkofficeaddress;
	}

	public String getAuthoffaddress() {
		return authoffaddress;
	}

	public void setAuthoffaddress(String authoffaddress) {
		this.authoffaddress = authoffaddress;
	}

	public int getAuthoffid() {
		return authoffid;
	}

	public void setAuthoffid(int authoffid) {
		this.authoffid = authoffid;
	}

	public String getNominee_name() {
		return nominee_name;
	}

	public void setNominee_name(String nominee_name) {
		this.nominee_name = nominee_name;
	}

	public int getNominee_id() {
		return nominee_id;
	}

	public void setNominee_id(int nominee_id) {
		this.nominee_id = nominee_id;
	}

	public int getNominee_relationId() {
		return nominee_relationId;
	}

	public void setNominee_relationId(int nominee_relationId) {
		this.nominee_relationId = nominee_relationId;
	}

	public String getNominee_relationDesc() {
		return nominee_relationDesc;
	}

	public void setNominee_relationDesc(String nominee_relationDesc) {
		this.nominee_relationDesc = nominee_relationDesc;
	}

	public String getPen_option() {
		return pen_option;
	}

	public void setPen_option(String pen_option) {
		this.pen_option = pen_option;
	}
	
	
	
}

