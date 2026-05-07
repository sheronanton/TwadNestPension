package com.nic.hrms.pension.reports.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.PensionerOrderDao;

public interface reportPenOrderAuthorisationService {
	List<PensionerOrderDao> getPenOrder1Details(HttpServletRequest request, int empId);
	List<PensionerOrderDao> getPenOrder2Details(HttpServletRequest request, int empId);
	List<PensionerOrderDao> getPenOrder2PersonDetails(HttpServletRequest request, int empId);
	List<PensionerOrderDao> getPenOrder2_IPersonDetails(HttpServletRequest request, int empId);
	List<PensionerOrderDao> getPenOrder3Details(HttpServletRequest request, int empId);
	List<PensionerOrderDao> getPenOrder3PersonDetails(HttpServletRequest request, int empId);
	List<PensionerOrderDao> getPenOrder4Details(HttpServletRequest request, int empId);
	List<PensionerOrderDao> getPenOrder5Details(HttpServletRequest request, int empId);
}
