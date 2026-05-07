package com.nic.hrms.pension.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDeathDao;

public interface reportPensionHOForm1CalcFormValService {

	List<pensionForm1CalcValDetailsDao> getPensionHOForm1CalcValDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDeathDao> getPensionHOForm1CalcDeathValDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDao> getHOForm1AvgValDetails(HttpServletRequest request,int empId);
	List<pensionForm1CalcValDetailsDao> getHOForm1RecoveryValDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcValDetailsDao>getHOForm1OtherDeptServiceVal(HttpServletRequest request, int empId);

}
