package com.nic.hrms.pension.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDeathDao;

public interface reportPensionHOForm1CalcFormService {

	List<pensionForm1CalcDetailsDao> getPensionHOForm1CalcDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDeathDao> getPensionHOForm1CalcDeathDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDao> getHOForm1AvgDetails(HttpServletRequest request,int empId);
	List<pensionForm1CalcDetailsDao> getHOForm1RecoveryDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDao> getHOForm1OtherDeptService(HttpServletRequest request, int empId);

}
