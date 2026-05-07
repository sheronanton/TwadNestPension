package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.reports.model.pensionCalcDetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG1DetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG2DetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG3DetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.service.reportPenAppFieldOfficeService;


public class reportPenAppFieldOfficeAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	
	List <penAppFieldOfficeDetailsDao> penAppFieldOfficeDetails;
	List <penAppFieldOfficeDCRG1DetailsDao> penAppFieldOfficeDcrg1Details;
	List <penAppFieldOfficeDCRG2DetailsDao> penAppFieldOfficeDcrg2Details;
	List <penAppFieldOfficeDCRG3DetailsDao> penAppFieldOfficeDcrg3Details;
	List <pensionForm1CalcValDetailsDao> penAppFieldOfficeCalcDetails;
	List <pensionForm1CalcValDetailsDao> fieldOfficeAvgDetails;
	List <penAppFieldOfficeDCRG3DetailsDao> fieldOfficeNomineeDetails;
	List <pensionCalcDetailsDao> fieldOfficeRecoveryDetails;
	private reportPenAppFieldOfficeService reportPenAppFieldOfficeService;
	HashMap<String, String> reportFieldOffParams=new HashMap<String,String>();
	
	private CommonSearchModel reportFieldOffForm1;
	
	public String print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));	
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		penAppFieldOfficeDetails=reportPenAppFieldOfficeService.getPenAppFieldOfficeDetails(getRequest(),empId);			
		return SUCCESS;
		
	}
	
	
	
	public String print1() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));	
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		penAppFieldOfficeDetails=reportPenAppFieldOfficeService.getPenAppFieldOfficeDetails(getRequest(),empId);			
		return SUCCESS;
		
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public String specisignprint() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));		
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDetails=reportPenAppFieldOfficeService.getPenAppFieldOfficeSpecSignDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public String descrollprint() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));	
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg3Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeDescRollDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String attjoinphotprint() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDetails=reportPenAppFieldOfficeService.getPenAppFieldOfficeAttJoinPhotDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String consletprint() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));				
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg3Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeConsLetDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String consletrecprint() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));	
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDetails=reportPenAppFieldOfficeService.getPenAppFieldOfficeConsLetRecDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public String formofdeclarationprint() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));	
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg3Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeFormOfDeclarationDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String apppendcrg1print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));				
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg1Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeDcrg1Details(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public String apppendcrg2print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));				
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg2Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeDcrg2Details(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String form_pen_gratuity1_print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));				
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg1Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeFormAssPenGratuityDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String form_pen_gratuity2_print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));				
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeCalcDetails=reportPenAppFieldOfficeService.getPenAppFieldOfficeFormAssPenGratuity2Details(getRequest(),empId);		
		fieldOfficeAvgDetails=reportPenAppFieldOfficeService.getFieldOfficeAvgValDetails(getRequest(),empId);		    
		
		reportFieldOffParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Field_office_Average_Emoulment.jasper"));
		
		return SUCCESS;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public String form_pen_gratuity3_print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));	
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg3Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeFormAssPenGratuity3Details(getRequest(),empId);		
		fieldOfficeNomineeDetails=reportPenAppFieldOfficeService.getFieldOfficeNomineeDetails(getRequest(),empId);		    
		
		reportFieldOffParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeNominee.jasper"));
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String details_of_family_print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg3Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeDetailsOfFamily(getRequest(),empId);		
		fieldOfficeNomineeDetails=reportPenAppFieldOfficeService.getFieldOfficeNomineeDetails(getRequest(),empId);		    
		
		reportFieldOffParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeNominee.jasper"));
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String no_due_certificate_print() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		penAppFieldOfficeDcrg3Details=reportPenAppFieldOfficeService.getPenAppFieldOfficeNoDueCertificate(getRequest(),empId);		
		fieldOfficeRecoveryDetails=reportPenAppFieldOfficeService.getFieldOfficeRecoveryDetails(getRequest(),empId);		    
		
		reportFieldOffParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Field_Office_Recoveries.jasper"));
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	
	
	
		
	public List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeDetails() {
		return penAppFieldOfficeDetails;
	}
	public void setPenAppFieldOfficeDetails(
			List<penAppFieldOfficeDetailsDao> penAppFieldOfficeDetails) {
		this.penAppFieldOfficeDetails = penAppFieldOfficeDetails;
	}	
	public reportPenAppFieldOfficeService getReportPenAppFieldOfficeService() {
		return reportPenAppFieldOfficeService;
	}
	public void setReportPenAppFieldOfficeService(
			reportPenAppFieldOfficeService reportPenAppFieldOfficeService) {
		this.reportPenAppFieldOfficeService = reportPenAppFieldOfficeService;
	}	
	public CommonSearchModel getReportFieldOffForm1() {
		return reportFieldOffForm1;
	}
	public void setReportFieldOffForm1(CommonSearchModel reportFieldOffForm1) {
		this.reportFieldOffForm1 = reportFieldOffForm1;
	}
	public HashMap<String, String> getReportFieldOffParams() {
		return reportFieldOffParams;
	}
	public void setReportFieldOffParams(HashMap<String, String> reportFieldOffParams) {
		this.reportFieldOffParams = reportFieldOffParams;
	}
	public List<penAppFieldOfficeDCRG1DetailsDao> getPenAppFieldOfficeDcrg1Details() {
		return penAppFieldOfficeDcrg1Details;
	}
	public void setPenAppFieldOfficeDcrg1Details(
			List<penAppFieldOfficeDCRG1DetailsDao> penAppFieldOfficeDcrg1Details) {
		this.penAppFieldOfficeDcrg1Details = penAppFieldOfficeDcrg1Details;
	}
	public List<penAppFieldOfficeDCRG2DetailsDao> getPenAppFieldOfficeDcrg2Details() {
		return penAppFieldOfficeDcrg2Details;
	}
	public void setPenAppFieldOfficeDcrg2Details(
			List<penAppFieldOfficeDCRG2DetailsDao> penAppFieldOfficeDcrg2Details) {
		this.penAppFieldOfficeDcrg2Details = penAppFieldOfficeDcrg2Details;
	}
	public List<pensionForm1CalcValDetailsDao> getPenAppFieldOfficeCalcDetails() {
		return penAppFieldOfficeCalcDetails;
	}
	public void setPenAppFieldOfficeCalcDetails(
			List<pensionForm1CalcValDetailsDao> penAppFieldOfficeCalcDetails) {
		this.penAppFieldOfficeCalcDetails = penAppFieldOfficeCalcDetails;
	}
	public List<pensionForm1CalcValDetailsDao> getFieldOfficeAvgDetails() {
		return fieldOfficeAvgDetails;
	}

	public void setFieldOfficeAvgDetails(
			List<pensionForm1CalcValDetailsDao> fieldOfficeAvgDetails) {
		this.fieldOfficeAvgDetails = fieldOfficeAvgDetails;
	}
	public List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeDcrg3Details() {
		return penAppFieldOfficeDcrg3Details;
	}
	public void setPenAppFieldOfficeDcrg3Details(
			List<penAppFieldOfficeDCRG3DetailsDao> penAppFieldOfficeDcrg3Details) {
		this.penAppFieldOfficeDcrg3Details = penAppFieldOfficeDcrg3Details;
	}
	public List<penAppFieldOfficeDCRG3DetailsDao> getFieldOfficeNomineeDetails() {
		return fieldOfficeNomineeDetails;
	}
	public void setFieldOfficeNomineeDetails(
			List<penAppFieldOfficeDCRG3DetailsDao> fieldOfficeNomineeDetails) {
		this.fieldOfficeNomineeDetails = fieldOfficeNomineeDetails;
	}
	public List<pensionCalcDetailsDao> getFieldOfficeRecoveryDetails() {
		return fieldOfficeRecoveryDetails;
	}
	public void setFieldOfficeRecoveryDetails(
			List<pensionCalcDetailsDao> fieldOfficeRecoveryDetails) {
		this.fieldOfficeRecoveryDetails = fieldOfficeRecoveryDetails;
	}
	
	
	

	
	

}
