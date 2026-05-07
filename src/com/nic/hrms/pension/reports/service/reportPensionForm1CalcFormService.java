package com.nic.hrms.pension.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDeathDao;

public interface reportPensionForm1CalcFormService {

	List<pensionForm1CalcDetailsDao> getPensionForm1CalcDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDeathDao> getPensionForm1CalcDeathDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDao> getForm1AvgDetails(HttpServletRequest request,int empId);
	List<pensionForm1CalcDetailsDao> getForm1RecoveryDetails(HttpServletRequest request, int empId);
    List<pensionForm1CalcDetailsDao> getForm1OtherDeptService(HttpServletRequest request, int empId);
	

}
