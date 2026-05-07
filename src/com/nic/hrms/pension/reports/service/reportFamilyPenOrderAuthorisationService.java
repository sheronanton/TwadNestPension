package com.nic.hrms.pension.reports.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.FamilyPensionerOrderDao;
import com.nic.hrms.pension.reports.model.PensionerOrderDao;

public interface reportFamilyPenOrderAuthorisationService {
	List<FamilyPensionerOrderDao> getPenOrder1Details(HttpServletRequest request, int empId);
	List<FamilyPensionerOrderDao> getPenOrder2Details(HttpServletRequest request, int empId);
	List<FamilyPensionerOrderDao> getPenOrder2PersonDetails(HttpServletRequest request, int empId);
	List<FamilyPensionerOrderDao> getPenOrder2_IPersonDetails(HttpServletRequest request, int empId);
	List<FamilyPensionerOrderDao> getPenOrder3Details(HttpServletRequest request, int empId);
	List<FamilyPensionerOrderDao> getPenOrder3PersonDetails(HttpServletRequest request, int empId);
	List<FamilyPensionerOrderDao> getPenOrder4Details(HttpServletRequest request, int empId);
	List<FamilyPensionerOrderDao> getPenOrder5Details(HttpServletRequest request, int empId);
	List<Object[]> penOrderAuthorisationReportUserSearch(int empId );
	List<Object[]> getPenOrder2_IPersonNomineeDetails(int empId);
	
}
