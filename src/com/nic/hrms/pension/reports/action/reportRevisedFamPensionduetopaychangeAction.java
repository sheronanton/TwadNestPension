package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.RevisedpayPensionDao;
import com.nic.hrms.pension.reports.model.reportRevisedPensionduetopaychangeDao;

import com.nic.hrms.pension.reports.service.reportRevisedFamPensionduetopaychangeService;


public class reportRevisedFamPensionduetopaychangeAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	HashMap<String, String> reportParams=new HashMap<String,String>();
	
	List <reportRevisedPensionduetopaychangeDao> revdutopayfamilypensionDetails;
	List <reportRevisedPensionduetopaychangeDao> Revisedpenduetopaychange;
	List <reportRevisedPensionduetopaychangeDao> Revisedpenduetopaychangesub;
	List <RevisedpayPensionDao> RevisedpayFamilypensionDetails;
	private reportRevisedFamPensionduetopaychangeService reportRevisedfamPensionduetopaychangeService;
	
	
	
	
	public String printRevisedpayFamilypension() throws JRException
	{
		int empId=0;
		int empId1=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));
			System.out.println("The emp id is"+empId);
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		RevisedpayFamilypensionDetails=reportRevisedfamPensionduetopaychangeService.getRevisedpayFampensionDetails(getRequest(), empId);
		
		return SUCCESS;
	}
	
	
	
	public String printRevisedFamilyPensionduetopaychange() throws JRException
	{
		int empId=0;
		int empId1=0;
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
		revdutopayfamilypensionDetails=reportRevisedfamPensionduetopaychangeService.getreportRevisedFamPensionduetopayDetails(getRequest(), empId);		
		Revisedpenduetopaychange=reportRevisedfamPensionduetopaychangeService.getreportRevisedFamPensionduetopayDetailssubreport(getRequest(), empId);
		Revisedpenduetopaychangesub=reportRevisedfamPensionduetopaychangeService.getreportRevisedFamPensionduetopayDetailssubreport1(getRequest(), empId);
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_FamPen_Due_to_pay_Change.jasper"));
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_FamPen_Due_to_Incr_pay_Change1.jasper"));
		
		
		return SUCCESS;
	}

	
	
	
	public String printRevisedFamilyPensionduetopaychange1() throws JRException
	{
		int empId=0;
		int empId1=0;
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
		revdutopayfamilypensionDetails=reportRevisedfamPensionduetopaychangeService.getreportRevisedFamPensionduetoDCRGpayDetails(getRequest(), empId);		
		Revisedpenduetopaychange=reportRevisedfamPensionduetopaychangeService.getreportRevisedFamPensionduetopayDetailssubreport(getRequest(), empId);
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_FamPen_Due_to_pay_Change.jasper"));
		
		
		return SUCCESS;
	}

	
	
	
	
	public HashMap<String, String> getReportParams() {
		return reportParams;
	}

	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}
	public List<reportRevisedPensionduetopaychangeDao> getRevdutopayfamilypensionDetails() {
		return revdutopayfamilypensionDetails;
	}
	public void setRevdutopayfamilypensionDetails(
			List<reportRevisedPensionduetopaychangeDao> revdutopayfamilypensionDetails) {
		this.revdutopayfamilypensionDetails = revdutopayfamilypensionDetails;
	}
	public List<reportRevisedPensionduetopaychangeDao> getRevisedpenduetopaychange() {
		return Revisedpenduetopaychange;
	}

	public void setRevisedpenduetopaychange(
			List<reportRevisedPensionduetopaychangeDao> revisedpenduetopaychange) {
		Revisedpenduetopaychange = revisedpenduetopaychange;
	}

	public List<reportRevisedPensionduetopaychangeDao> getRevisedpenduetopaychangesub() {
		return Revisedpenduetopaychangesub;
	}

	public void setRevisedpenduetopaychangesub(
			List<reportRevisedPensionduetopaychangeDao> revisedpenduetopaychangesub) {
		Revisedpenduetopaychangesub = revisedpenduetopaychangesub;
	}

	public reportRevisedFamPensionduetopaychangeService getReportRevisedfamPensionduetopaychangeService() {
		return reportRevisedfamPensionduetopaychangeService;
	}
	public void setReportRevisedfamPensionduetopaychangeService(
			reportRevisedFamPensionduetopaychangeService reportRevisedfamPensionduetopaychangeService) {
		this.reportRevisedfamPensionduetopaychangeService = reportRevisedfamPensionduetopaychangeService;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public List<RevisedpayPensionDao> getRevisedpayFamilypensionDetails() {
		return RevisedpayFamilypensionDetails;
	}
	
	public void setRevisedpayFamilypensionDetails(
			List<RevisedpayPensionDao> revisedpayFamilypensionDetails) {
		RevisedpayFamilypensionDetails = revisedpayFamilypensionDetails;
	}

	
	


	
	
	

	
	

}
