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
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDeathDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.service.reportPenAppFieldOfficeDeathService;


public class reportPenAppFieldOfficeDeathAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	
	List <penAppFieldOfficeDetailsDao> penAppFieldOfficeDetails;
	List <penAppFieldOfficeDeathDetailsDao> penAppFieldOfficeDeathDetails;
	List <pensionForm1CalcValDetailsDao> penAppFieldOfficeCalcDetails;
	List <pensionForm1CalcValDetailsDao> fieldOfficeAvgDetails;
	List <penAppFieldOfficeDeathDetailsDao> fieldOfficeNomineeDeathDetails;
	List <penAppFieldOfficeDeathDetailsDao> fieldOfficeForm14ContentDetails;
	List <pensionCalcDetailsDao> fieldOfficeRecoveryDetails;
	private reportPenAppFieldOfficeDeathService reportPenAppFieldOfficeDeathService;
	HashMap<String, String> reportFieldOffParams=new HashMap<String,String>();
	
	private CommonSearchModel reportFieldOffForm1;
	
		
	
	
	@SuppressWarnings("deprecation")
	public String deathform12print() throws JRException
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
		
		penAppFieldOfficeDeathDetails=reportPenAppFieldOfficeDeathService.getPenAppFieldOfficeDeathForm12Details(getRequest(),empId);		
		fieldOfficeNomineeDeathDetails=reportPenAppFieldOfficeDeathService.getFieldOfficeDeathNomineeDetails(getRequest(),empId);		    
		
		reportFieldOffParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeDeathNominee.jasper"));
		
		return SUCCESS;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public String deathform14print() throws JRException
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
		
		penAppFieldOfficeDeathDetails=reportPenAppFieldOfficeDeathService.getPenAppFieldOfficeDeathForm14Details(getRequest(),empId);		
		fieldOfficeNomineeDeathDetails=reportPenAppFieldOfficeDeathService.getFieldOfficeDeathNomineeDetails(getRequest(),empId);		    
		fieldOfficeForm14ContentDetails=fieldOfficeNomineeDeathDetails;
		reportFieldOffParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeDeathNominee.jasper"));
		reportFieldOffParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/pen_app_field_off_report_form14_I.jasper"));
		
		return SUCCESS;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public String deathspecisignprint() throws JRException
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
		
		penAppFieldOfficeDeathDetails=reportPenAppFieldOfficeDeathService.getPenAppFieldOfficeDeathSpecSignDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String deathconsletprint() throws JRException
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
		
		penAppFieldOfficeDeathDetails=reportPenAppFieldOfficeDeathService.getPenAppFieldOfficeDeathConsLetDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String deathconsletrecprint() throws JRException
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
		
		penAppFieldOfficeDetails=reportPenAppFieldOfficeDeathService.getPenAppFieldOfficeDeathConsLetRecDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public String deathformofdeclarationprint() throws JRException
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
		
		penAppFieldOfficeDeathDetails=reportPenAppFieldOfficeDeathService.getPenAppFieldOfficeDeathFormOfDeclarationDetails(getRequest(),empId);	
		
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
		
		penAppFieldOfficeDeathDetails=reportPenAppFieldOfficeDeathService.getFieldOfficeDeathNomineeDetails(getRequest(),empId);		    
				
		return SUCCESS;
		
	}
	
	
	@SuppressWarnings("deprecation")
	public String deathdescrollprint() throws JRException
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
		
		penAppFieldOfficeDeathDetails=reportPenAppFieldOfficeDeathService.getPenAppFieldOfficeDeathDescRollDetails(getRequest(),empId);	
		
		return SUCCESS;
		
	}
	
	
	
	
	
	
		
	public List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeDetails() {
		return penAppFieldOfficeDetails;
	}
	public void setPenAppFieldOfficeDetails(
			List<penAppFieldOfficeDetailsDao> penAppFieldOfficeDetails) {
		this.penAppFieldOfficeDetails = penAppFieldOfficeDetails;
	}		
	public reportPenAppFieldOfficeDeathService getReportPenAppFieldOfficeDeathService() {
		return reportPenAppFieldOfficeDeathService;
	}
	public void setReportPenAppFieldOfficeDeathService(
			reportPenAppFieldOfficeDeathService reportPenAppFieldOfficeDeathService) {
		this.reportPenAppFieldOfficeDeathService = reportPenAppFieldOfficeDeathService;
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
	public List<pensionCalcDetailsDao> getFieldOfficeRecoveryDetails() {
		return fieldOfficeRecoveryDetails;
	}
	public void setFieldOfficeRecoveryDetails(
			List<pensionCalcDetailsDao> fieldOfficeRecoveryDetails) {
		this.fieldOfficeRecoveryDetails = fieldOfficeRecoveryDetails;
	}
	public List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathDetails() {
		return penAppFieldOfficeDeathDetails;
	}
	public void setPenAppFieldOfficeDeathDetails(
			List<penAppFieldOfficeDeathDetailsDao> penAppFieldOfficeDeathDetails) {
		this.penAppFieldOfficeDeathDetails = penAppFieldOfficeDeathDetails;
	}
	public List<penAppFieldOfficeDeathDetailsDao> getFieldOfficeNomineeDeathDetails() {
		return fieldOfficeNomineeDeathDetails;
	}
	public void setFieldOfficeNomineeDeathDetails(
			List<penAppFieldOfficeDeathDetailsDao> fieldOfficeNomineeDeathDetails) {
		this.fieldOfficeNomineeDeathDetails = fieldOfficeNomineeDeathDetails;
	}
	public List<penAppFieldOfficeDeathDetailsDao> getFieldOfficeForm14ContentDetails() {
		return fieldOfficeForm14ContentDetails;
	}
	public void setFieldOfficeForm14ContentDetails(
			List<penAppFieldOfficeDeathDetailsDao> fieldOfficeForm14ContentDetails) {
		this.fieldOfficeForm14ContentDetails = fieldOfficeForm14ContentDetails;
	}
	
	
	

	
	

}
