package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.RevisedPensionReportOrderModel;
import com.nic.hrms.pension.reports.service.ReportRevisedPensionOrderService;

public class ReportRevisedPensionOrderAction extends BaseAction 
{	
	private static final long serialVersionUID = 1L;

	List <RevisedPensionReportOrderModel> RevisedpaypensionDetails;
	
	List<RevisedPensionReportOrderModel> revisedpensionnotedetails;
	List<RevisedPensionReportOrderModel> onemancommisionnotedetails;
	List<RevisedPensionReportOrderModel> revisedpensionorderdetails;
	List<RevisedPensionReportOrderModel> revisedpensiondcrgdetails;
	List<RevisedPensionReportOrderModel> revisedpension_subreport_details;
	List<RevisedPensionReportOrderModel> revisedpension_subreport_details1;
	
	private ReportRevisedPensionOrderService reportRevisedpaypensionService;
	
	HashMap <String, String> reportParams = new HashMap<String, String>();

	
	
	public String printRevisedpaypension_note() throws JRException
	{
		int empId=0;
		int empId1=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
			//System.out.println("The emp id is"+empId);
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		RevisedpaypensionDetails=reportRevisedpaypensionService.getRevisedpaypensionDetails_Note(getRequest(), empId);
		//reportrevisedpenParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revisedpaypensiontest.jasper"));
		
		return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	public String printRevisedpaypension_order() throws JRException
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
		
		revisedpensionorderdetails=reportRevisedpaypensionService.getRevisedPensionDetails(getRequest(), empId);		
		revisedpension_subreport_details=reportRevisedpaypensionService.getRevisedPensionDetailssubreport(getRequest(), empId);
		revisedpension_subreport_details1=reportRevisedpaypensionService.getRevisedPensionDetailssubreport1(getRequest(), empId);
		//System.out.println("-----------Calling Sub Report 1-----------");
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport_order.jasper"));
		//System.out.println("-----------Calling Sub Report 2-----------");
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport1_order.jasper"));
		
		
		return SUCCESS;
	}
	public String printonemancommision_order() throws JRException
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
		
		onemancommisionnotedetails=reportRevisedpaypensionService.getonemancommisionDetails(getRequest(), empId);		
		revisedpension_subreport_details=reportRevisedpaypensionService.getonemancommisionDetailssubreport(getRequest(), empId);
		revisedpension_subreport_details1=reportRevisedpaypensionService.getonmancommisionDetailssubreport1(getRequest(), empId);
		//System.out.println("-----------Calling Sub Report 1-----------");
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/OneMan_Commision_Due_to_Incr_pay_supreport_order.jasper"));
		//System.out.println("-----------Calling Sub Report 2-----------");
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/OneMan_Commision_Due_to_Incr_pay_supreport1_order.jasper"));
		
		
		return SUCCESS;
	}
	public String printspecialgrade_order() throws JRException
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
		
		onemancommisionnotedetails=reportRevisedpaypensionService.getspecialgradeDetails(getRequest(), empId);		
		revisedpension_subreport_details=reportRevisedpaypensionService.getspecialgradeDetailssubreport(getRequest(), empId);
		revisedpension_subreport_details1=reportRevisedpaypensionService.getspecialgradeDetailssubreport1(getRequest(), empId);
		//System.out.println("-----------Calling Sub Report 1-----------");
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Special_Grade_Due_to_Incr_pay_supreport_order.jasper"));
		//System.out.println("-----------Calling Sub Report 2-----------");
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Special_Grade_Due_to_Incr_pay_supreport1_order.jasper"));
		
		return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	public String printRevisedpaypension_dcrg() throws JRException
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
		revisedpensiondcrgdetails=reportRevisedpaypensionService.getRevisedPensionDCRGDetails(getRequest(), empId);		
		revisedpension_subreport_details=reportRevisedpaypensionService.getRevisedPensionDetailssubreport(getRequest(), empId);
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_pay_supreport_order.jasper"));
		
		
		return SUCCESS;
	}
	@SuppressWarnings("deprecation")
	public String printonmancommision_dcrg() throws JRException
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
		onemancommisionnotedetails=reportRevisedpaypensionService.getonemancommisionDCRGDetails(getRequest(), empId);		
		revisedpension_subreport_details=reportRevisedpaypensionService.getonemancommisionDetailssubreport(getRequest(), empId);
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/OneMan_Commision_Due_to_Incr_pay_supreport_order.jasper"));
		
		
		return SUCCESS;
	}

	public String printspecialgrade_dcrg() throws JRException
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
		onemancommisionnotedetails=reportRevisedpaypensionService.getspecialgradeDCRGDetails(getRequest(), empId);		
		revisedpension_subreport_details=reportRevisedpaypensionService.getspecialgradeDetailssubreport(getRequest(), empId);
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Special_Grade_Due_to_Incr_pay_supreport_order.jasper"));
		
		
		return SUCCESS;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}	

	public ReportRevisedPensionOrderService getReportRevisedpaypensionService() {
		return reportRevisedpaypensionService;
	}

	public void setReportRevisedpaypensionService(
			ReportRevisedPensionOrderService reportRevisedpaypensionService) {
		this.reportRevisedpaypensionService = reportRevisedpaypensionService;
	}


	public List<RevisedPensionReportOrderModel> getRevisedpaypensionDetails() {
		return RevisedpaypensionDetails;
	}


	public void setRevisedpaypensionDetails(
			List<RevisedPensionReportOrderModel> revisedpaypensionDetails) {
		RevisedpaypensionDetails = revisedpaypensionDetails;
	}

	public List<RevisedPensionReportOrderModel> getRevisedpensionnotedetails() {
		return revisedpensionnotedetails;
	}

	public void setRevisedpensionnotedetails(
			List<RevisedPensionReportOrderModel> revisedpensionnotedetails) {
		this.revisedpensionnotedetails = revisedpensionnotedetails;
	}

	public List<RevisedPensionReportOrderModel> getOnemancommisionnotedetails() {
		return onemancommisionnotedetails;
	}

	public void setOnemancommisionnotedetails(
			List<RevisedPensionReportOrderModel> onemancommisionnotedetails) {
		this.onemancommisionnotedetails = onemancommisionnotedetails;
	}

	public List<RevisedPensionReportOrderModel> getRevisedpensionorderdetails() {
		return revisedpensionorderdetails;
	}

	public void setRevisedpensionorderdetails(
			List<RevisedPensionReportOrderModel> revisedpensionorderdetails) {
		this.revisedpensionorderdetails = revisedpensionorderdetails;
	}

	public List<RevisedPensionReportOrderModel> getRevisedpensiondcrgdetails() {
		return revisedpensiondcrgdetails;
	}

	public void setRevisedpensiondcrgdetails(
			List<RevisedPensionReportOrderModel> revisedpensiondcrgdetails) {
		this.revisedpensiondcrgdetails = revisedpensiondcrgdetails;
	}

	public List<RevisedPensionReportOrderModel> getRevisedpension_subreport_details() {
		return revisedpension_subreport_details;
	}

	public void setRevisedpension_subreport_details(
			List<RevisedPensionReportOrderModel> revisedpension_subreport_details) {
		this.revisedpension_subreport_details = revisedpension_subreport_details;
	}

	public List<RevisedPensionReportOrderModel> getRevisedpension_subreport_details1() {
		return revisedpension_subreport_details1;
	}

	public void setRevisedpension_subreport_details1(
			List<RevisedPensionReportOrderModel> revisedpension_subreport_details1) {
		this.revisedpension_subreport_details1 = revisedpension_subreport_details1;
	}

	public HashMap<String, String> getReportParams() {
		return reportParams;
	}

	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}
	

}
