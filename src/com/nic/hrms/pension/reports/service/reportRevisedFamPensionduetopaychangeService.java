package com.nic.hrms.pension.reports.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.RevisedpayPensionDao;
import com.nic.hrms.pension.reports.model.reportRevisedPensionduetopaychangeDao;

public interface reportRevisedFamPensionduetopaychangeService {
	List<reportRevisedPensionduetopaychangeDao> getreportRevisedFamPensionduetopayDetails(HttpServletRequest request, int empId);
	List<reportRevisedPensionduetopaychangeDao> getreportRevisedFamPensionduetopayDetailssubreport(HttpServletRequest request, int empId);
	List<reportRevisedPensionduetopaychangeDao> getreportRevisedFamPensionduetopayDetailssubreport1(HttpServletRequest request, int empId);		
	List<reportRevisedPensionduetopaychangeDao> getreportRevisedFamPensionduetoDCRGpayDetails(HttpServletRequest request, int empId);
	List<RevisedpayPensionDao> getRevisedpayFampensionDetails(HttpServletRequest request, int empId);
	
}
