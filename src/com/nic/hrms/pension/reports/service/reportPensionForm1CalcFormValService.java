package com.nic.hrms.pension.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDeathDao;

public interface reportPensionForm1CalcFormValService {

	List<pensionForm1CalcValDetailsDao> getPensionForm1CalcValDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDeathDao> getPensionForm1CalcDeathValDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDao> getForm1AvgValDetails(HttpServletRequest request,int empId);
	List<pensionForm1CalcValDetailsDao> getForm1RecoveryValDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDao> getForm1OtherDeptServiceVal(HttpServletRequest request, int empId);
	

}
