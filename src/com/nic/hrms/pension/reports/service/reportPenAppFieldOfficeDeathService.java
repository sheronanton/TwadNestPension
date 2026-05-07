package com.nic.hrms.pension.reports.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.pensionCalcDetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDeathDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
public interface reportPenAppFieldOfficeDeathService {

	List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathForm12Details(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathForm14Details(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathSpecSignDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathDescRollDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathConsLetDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeDeathConsLetRecDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathFormOfDeclarationDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDeathDetailsDao> getFieldOfficeDeathNomineeDetails(HttpServletRequest request, int empId);	
}
