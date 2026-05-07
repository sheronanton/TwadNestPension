package com.nic.hrms.pension.reports.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.PensionerOrderDao;

import com.nic.hrms.pension.reports.service.reportRevisedDCRGPenOrderAuthorisationService;


public class reportRevisedDCRGPenOrderAuthorisationAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	
	List <PensionerOrderDao> revDCRGPenOrderDetails;
	private reportRevisedDCRGPenOrderAuthorisationService reportRevisedDCRGPenOrderAuthoService;
	
		
	public String printRevisedDCRGPensionOrder() throws JRException
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
		revDCRGPenOrderDetails=reportRevisedDCRGPenOrderAuthoService.getRevisedDCRGPenOrderDetails(getRequest(), empId);		
		return SUCCESS;
	}
	
	

	
	public List<PensionerOrderDao> getRevDCRGPenOrderDetails() {
		return revDCRGPenOrderDetails;
	}
	public void setRevDCRGPenOrderDetails(
			List<PensionerOrderDao> revDCRGPenOrderDetails) {
		this.revDCRGPenOrderDetails = revDCRGPenOrderDetails;
	}
	public reportRevisedDCRGPenOrderAuthorisationService getReportRevisedDCRGPenOrderAuthoService() {
		return reportRevisedDCRGPenOrderAuthoService;
	}
	public void setReportRevisedDCRGPenOrderAuthoService(
			reportRevisedDCRGPenOrderAuthorisationService reportRevisedDCRGPenOrderAuthoService) {
		this.reportRevisedDCRGPenOrderAuthoService = reportRevisedDCRGPenOrderAuthoService;
	}
	
	

}
