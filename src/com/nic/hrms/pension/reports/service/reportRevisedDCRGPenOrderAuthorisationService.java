package com.nic.hrms.pension.reports.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.PensionerOrderDao;

public interface reportRevisedDCRGPenOrderAuthorisationService {
	List<PensionerOrderDao> getRevisedDCRGPenOrderDetails(HttpServletRequest request, int empId);
	
}
