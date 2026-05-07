package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeForm2ReportDao;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNomineeForm2;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNotVerServForm2;
import com.nic.hrms.pension.reports.service.PensionApplicationFieldOfficeForm2ReportService;
import com.nic.hrms.pension.service.OfficeId_service;

public class PensionApplicationFieldOfficeForm2ReportAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OfficeId_service officeIdservice;
	private PensionApplicationFieldOfficeForm2ReportService penAppFieldOfficeReportForm2Service;
	private List<PensionApplicationFieldOfficeForm2ReportDao> penAppFieldOfficeDetails;
	private List<PensionApplicationFieldOfficeNomineeForm2> penAppFieldOfficeNominee;
	private List<PensionApplicationFieldOfficeNotVerServForm2> penFieldOfficeApplication;
	
	HashMap<String, String> reportParams=new HashMap<String,String>();

	
	@SuppressWarnings("deprecation")
	public String printPenAppFieldOffice()
	{
		try
		{
			   int empId2=Integer.parseInt(getRequest().getParameter("empId"));
			   HttpSession session=getRequest().getSession();
		       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		       int empId=empProfile.getEmployeeId();		       
			   int officeId = officeIdservice.getOfficeId(empId);	  
			   
			   penAppFieldOfficeDetails=penAppFieldOfficeReportForm2Service.printFieldOfficeDetails(getRequest(), empId2, officeId);
			   penAppFieldOfficeNominee=penAppFieldOfficeReportForm2Service.printFieldOfficeNominee(getRequest(), empId2);
			   penFieldOfficeApplication=penAppFieldOfficeReportForm2Service.printFieldOfficeNVServ(getRequest(), empId2);
			  			
			   reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeNomineeForm2.jasper"));
			   reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeServiceForm2.jasper"));
			   
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


	public PensionApplicationFieldOfficeForm2ReportService getPenAppFieldOfficeReportForm2Service() {
		return penAppFieldOfficeReportForm2Service;
	}



	public void setPenAppFieldOfficeReportForm2Service(
			PensionApplicationFieldOfficeForm2ReportService penAppFieldOfficeReportForm2Service) {
		this.penAppFieldOfficeReportForm2Service = penAppFieldOfficeReportForm2Service;
	}



	public List<PensionApplicationFieldOfficeForm2ReportDao> getPenAppFieldOfficeDetails() {
		return penAppFieldOfficeDetails;
	}



	public void setPenAppFieldOfficeDetails(
			List<PensionApplicationFieldOfficeForm2ReportDao> penAppFieldOfficeDetails) {
		this.penAppFieldOfficeDetails = penAppFieldOfficeDetails;
	}



	public List<PensionApplicationFieldOfficeNomineeForm2> getPenAppFieldOfficeNominee() {
		return penAppFieldOfficeNominee;
	}



	public void setPenAppFieldOfficeNominee(
			List<PensionApplicationFieldOfficeNomineeForm2> penAppFieldOfficeNominee) {
		this.penAppFieldOfficeNominee = penAppFieldOfficeNominee;
	}



	public List<PensionApplicationFieldOfficeNotVerServForm2> getPenFieldOfficeApplication() {
		return penFieldOfficeApplication;
	}



	public void setPenFieldOfficeApplication(
			List<PensionApplicationFieldOfficeNotVerServForm2> penFieldOfficeApplication) {
		this.penFieldOfficeApplication = penFieldOfficeApplication;
	}



	public HashMap<String, String> getReportParams() {
		return reportParams;
	}



	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}



	

	
}
