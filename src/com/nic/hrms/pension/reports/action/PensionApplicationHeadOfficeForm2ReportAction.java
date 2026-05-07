package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeForm2ReportDao;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNomineeForm2;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNotVerServForm2;
import com.nic.hrms.pension.reports.service.PensionApplicationHeadOfficeForm2ReportService;
import com.nic.hrms.pension.service.OfficeId_service;

public class PensionApplicationHeadOfficeForm2ReportAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OfficeId_service officeIdservice;
	private PensionApplicationHeadOfficeForm2ReportService penAppHeadOfficeReportForm2Service;
	private List<PensionApplicationFieldOfficeForm2ReportDao> penAppHeadOfficeDetails;
	private List<PensionApplicationFieldOfficeNomineeForm2> penAppHeadOfficeNominee;
	private List<PensionApplicationFieldOfficeNotVerServForm2> penHeadOfficeApplication;
	
	HashMap<String, String> reportParams=new HashMap<String,String>();

	
	@SuppressWarnings("deprecation")
	public String printPenAppHeadOffice()
	{
		try
		{
			   int empId2=Integer.parseInt(getRequest().getParameter("empId"));
			   HttpSession session=getRequest().getSession();
		       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		       int empId=empProfile.getEmployeeId();		       
			   int officeId = officeIdservice.getOfficeId(empId);	  
			   
			   penAppHeadOfficeDetails=penAppHeadOfficeReportForm2Service.printHeadOfficeDetails(getRequest(), empId2, officeId);
			   penAppHeadOfficeNominee=penAppHeadOfficeReportForm2Service.printHeadOfficeNominee(getRequest(), empId2);
			   penHeadOfficeApplication=penAppHeadOfficeReportForm2Service.printHeadOfficeNVServ(getRequest(), empId2);
			  			
			   reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationHeadOfficeNomineeForm2.jasper"));
			   reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationHeadOfficeServiceForm2.jasper"));
			   
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	
	
	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}
	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}	
	public PensionApplicationHeadOfficeForm2ReportService getPenAppHeadOfficeReportForm2Service() {
		return penAppHeadOfficeReportForm2Service;
	}
	public void setPenAppHeadOfficeReportForm2Service(
			PensionApplicationHeadOfficeForm2ReportService penAppHeadOfficeReportForm2Service) {
		this.penAppHeadOfficeReportForm2Service = penAppHeadOfficeReportForm2Service;
	}	
	public List<PensionApplicationFieldOfficeForm2ReportDao> getPenAppHeadOfficeDetails() {
		return penAppHeadOfficeDetails;
	}
	public void setPenAppHeadOfficeDetails(
			List<PensionApplicationFieldOfficeForm2ReportDao> penAppHeadOfficeDetails) {
		this.penAppHeadOfficeDetails = penAppHeadOfficeDetails;
	}	
	public List<PensionApplicationFieldOfficeNomineeForm2> getPenAppHeadOfficeNominee() {
		return penAppHeadOfficeNominee;
	}
	public void setPenAppHeadOfficeNominee(
			List<PensionApplicationFieldOfficeNomineeForm2> penAppHeadOfficeNominee) {
		this.penAppHeadOfficeNominee = penAppHeadOfficeNominee;
	}
	public List<PensionApplicationFieldOfficeNotVerServForm2> getPenHeadOfficeApplication() {
		return penHeadOfficeApplication;
	}
	public void setPenHeadOfficeApplication(
			List<PensionApplicationFieldOfficeNotVerServForm2> penHeadOfficeApplication) {
		this.penHeadOfficeApplication = penHeadOfficeApplication;
	}
	public HashMap<String, String> getReportParams() {
		return reportParams;
	}
	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}
	

	
}
