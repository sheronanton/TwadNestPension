package com.nic.hrms.pension.reports.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;
import com.nic.hrms.pension.model.RevisedPensionReportModel;
import com.nic.hrms.pension.reports.model.RevisedPensionReportOrderModel;


public interface ReportRevisedPensionOrderService 
{
	List<RevisedPensionReportOrderModel> getRevisedpaypensionDetails_Note(HttpServletRequest request, int empId);
	//List<PensionAuthorisedOfficer_dao> getListOfAythorisedOfficer();	
	//List<RevisedPensionReportOrderModel> getOneManCommDetails_Note(HttpServletRequest request, int empId,String lett_no,String date_on,String reference);
	List<RevisedPensionReportOrderModel> getRevisedPensionDetails(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getRevisedPensionDCRGDetails(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getRevisedPensionDetailssubreport(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getRevisedPensionDetailssubreport1(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getonemancommisionDetails(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getonemancommisionDetailssubreport(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getonmancommisionDetailssubreport1(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getonemancommisionDCRGDetails(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getspecialgradeDetails(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getspecialgradeDetailssubreport(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getspecialgradeDetailssubreport1(HttpServletRequest request, int empId);
	List<RevisedPensionReportOrderModel> getspecialgradeDCRGDetails(HttpServletRequest request, int empId);
	
}
