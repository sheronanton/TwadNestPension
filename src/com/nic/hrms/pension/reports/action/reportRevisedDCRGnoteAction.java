package com.nic.hrms.pension.reports.action;

import java.util.List;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;

import com.nic.hrms.pension.reports.model.RevisedDCRGnoteDao;
import com.nic.hrms.pension.reports.service.reportRevisedDCRGnoteService;

public class reportRevisedDCRGnoteAction extends BaseAction {
	
	private static long serialVersionUID = 7988931778640042309L;
	

	List <RevisedDCRGnoteDao> RevisedDCRGnoteDetails;	
	/*List <RevisedDCRGnoteDao> RevisedDCRGnoteDetailssub;	
	*/
	private reportRevisedDCRGnoteService reportRevisedDCRGnoteService;
	HashMap<String, String> reportParams=new HashMap<String,String>();
	
	public String printRevisedDCRGnote() throws JRException
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
		RevisedDCRGnoteDetails=reportRevisedDCRGnoteService.getRevisedDCRGnoteDetails(getRequest(), empId);
		
		
		/*RevisedDCRGnoteDetailssub=reportRevisedDCRGnoteService.getRevisedDCRGnoteDetailssubreport(getRequest(), empId);
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Revision_Due_to_Incr_DA_supreport.jasper"));*/
		
		return SUCCESS;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		reportRevisedDCRGnoteAction.serialVersionUID = serialVersionUID;
	}

	public List<RevisedDCRGnoteDao> getRevisedDCRGnoteDetails() {
		return RevisedDCRGnoteDetails;
	}

	public void setRevisedDCRGnoteDetails(
			List<RevisedDCRGnoteDao> revisedDCRGnoteDetails) {
		RevisedDCRGnoteDetails = revisedDCRGnoteDetails;
	}

	/*public List<RevisedDCRGnoteDao> getRevisedDCRGnoteDetailssub() {
		return RevisedDCRGnoteDetailssub;
	}

	public void setRevisedDCRGnoteDetailssub(
			List<RevisedDCRGnoteDao> revisedDCRGnoteDetailssub) {
		RevisedDCRGnoteDetailssub = revisedDCRGnoteDetailssub;
	}*/

	public reportRevisedDCRGnoteService getReportRevisedDCRGnoteService() {
		return reportRevisedDCRGnoteService;
	}

	public void setReportRevisedDCRGnoteService(
			reportRevisedDCRGnoteService reportRevisedDCRGnoteService) {
		this.reportRevisedDCRGnoteService = reportRevisedDCRGnoteService;
	}

	public HashMap<String, String> getReportParams() {
		return reportParams;
	}

	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}

	

	
	
	
	
	

}
