package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.reports.model.PensionerOrderDao;

import com.nic.hrms.pension.reports.service.reportPenOrderAuthorisationService;


public class reportPenOrderAuthorisationAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	
	List <PensionerOrderDao> penOrderDetails;	
	List <PensionerOrderDao> penOrder1Details;
	List <PensionerOrderDao> penOrder2Details;
	List <PensionerOrderDao> penOrder3Details;
	List <PensionerOrderDao> penOrder4Details;
	
	
	private reportPenOrderAuthorisationService reportPenOrderAuthoService;
	HashMap<String, String> reportOrderAuthoParams=new HashMap<String,String>();
	
	private CommonSearchModel reportPenOrderAutho;
	
	
	
	
	public String printPensionOrder1() throws JRException
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
		penOrderDetails=reportPenOrderAuthoService.getPenOrder1Details(getRequest(), empId);
		penOrder1Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm1_I.jasper"));
		
		return SUCCESS;
	}
	
	
	
	
	
	
	public String printPensionOrder2() throws JRException
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
		penOrderDetails=reportPenOrderAuthoService.getPenOrder2Details(getRequest(), empId);
		penOrder3Details=reportPenOrderAuthoService.getPenOrder2PersonDetails(getRequest(), empId);
		penOrder2Details=reportPenOrderAuthoService.getPenOrder2_IPersonDetails(getRequest(), empId);
		penOrder1Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm2_I.jasper"));
		reportOrderAuthoParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm2_II.jasper"));
		reportOrderAuthoParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm2_III.jasper"));
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	public String printPensionOrder3() throws JRException
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
		penOrderDetails=reportPenOrderAuthoService.getPenOrder3Details(getRequest(), empId);
		penOrder3Details=reportPenOrderAuthoService.getPenOrder3PersonDetails(getRequest(), empId);
		penOrder1Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm3_I.jasper"));
		reportOrderAuthoParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm3_II.jasper"));
		
		return SUCCESS;
	}
	
	
	public String printPensionOrder4() throws JRException
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
		System.out.println("---------Entering into getPenOrder4Details() Method---------");
		penOrderDetails=reportPenOrderAuthoService.getPenOrder4Details(getRequest(), empId);
		penOrder4Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm4_I.jasper"));
		
		return SUCCESS;
	}
	
	
	public String printPensionOrder5() throws JRException
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
		
				
		penOrderDetails=reportPenOrderAuthoService.getPenOrder5Details(getRequest(),empId);			
		return SUCCESS;
		
	}
	

	public List<PensionerOrderDao> getPenOrderDetails() {
		return penOrderDetails;
	}
	public void setPenOrderDetails(List<PensionerOrderDao> penOrderDetails) {
		this.penOrderDetails = penOrderDetails;
	}
	public reportPenOrderAuthorisationService getReportPenOrderAuthoService() {
		return reportPenOrderAuthoService;
	}
	public void setReportPenOrderAuthoService(
			reportPenOrderAuthorisationService reportPenOrderAuthoService) {
		this.reportPenOrderAuthoService = reportPenOrderAuthoService;
	}
	public CommonSearchModel getReportPenOrderAutho() {
		return reportPenOrderAutho;
	}
	public void setReportPenOrderAutho(CommonSearchModel reportPenOrderAutho) {
		this.reportPenOrderAutho = reportPenOrderAutho;
	}
	public HashMap<String, String> getReportOrderAuthoParams() {
		return reportOrderAuthoParams;
	}
	public void setReportOrderAuthoParams(
			HashMap<String, String> reportOrderAuthoParams) {
		this.reportOrderAuthoParams = reportOrderAuthoParams;
	}
	public List<PensionerOrderDao> getPenOrder4Details() {
		return penOrder4Details;
	}
	public void setPenOrder4Details(List<PensionerOrderDao> penOrder4Details) {
		this.penOrder4Details = penOrder4Details;
	}
	public List<PensionerOrderDao> getPenOrder1Details() {
		return penOrder1Details;
	}
	public void setPenOrder1Details(List<PensionerOrderDao> penOrder1Details) {
		this.penOrder1Details = penOrder1Details;
	}
	public List<PensionerOrderDao> getPenOrder3Details() {
		return penOrder3Details;
	}
	public void setPenOrder3Details(List<PensionerOrderDao> penOrder3Details) {
		this.penOrder3Details = penOrder3Details;
	}
	public List<PensionerOrderDao> getPenOrder2Details() {
		return penOrder2Details;
	}
	public void setPenOrder2Details(List<PensionerOrderDao> penOrder2Details) {
		this.penOrder2Details = penOrder2Details;
	}
	
	
	
	
	

	
	

}
