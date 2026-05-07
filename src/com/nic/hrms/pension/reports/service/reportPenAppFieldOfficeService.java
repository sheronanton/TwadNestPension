
package com.nic.hrms.pension.reports.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.pensionCalcDetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG1DetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG2DetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG3DetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
public interface reportPenAppFieldOfficeService {

	List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeSpecSignDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeDescRollDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeAttJoinPhotDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeConsLetDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeConsLetRecDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeFormOfDeclarationDetails(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG1DetailsDao> getPenAppFieldOfficeDcrg1Details(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG2DetailsDao> getPenAppFieldOfficeDcrg2Details(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG1DetailsDao> getPenAppFieldOfficeFormAssPenGratuityDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDao> getPenAppFieldOfficeFormAssPenGratuity2Details(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDao> getFieldOfficeAvgValDetails(HttpServletRequest request, int empId);	
	List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeFormAssPenGratuity3Details(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG3DetailsDao> getFieldOfficeNomineeDetails(HttpServletRequest request, int empId);	
	List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeDetailsOfFamily(HttpServletRequest request, int empId);
	List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeNoDueCertificate(HttpServletRequest request, int empId);	
	List<pensionCalcDetailsDao> getFieldOfficeRecoveryDetails(HttpServletRequest request, int empId);
}