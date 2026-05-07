package com.nic.hrms.pension.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDeathDao;

public interface reportRevisedPensionCalcValService {

	List<pensionForm1CalcDetailsDao> getRevisedPensionCalcDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDeathDao> getRevisedPensionCalcDeathDetails(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDao> getRevisedChangeAvgDetails(HttpServletRequest request,int empId);
	List<pensionForm1CalcDetailsDao> getHOForm1RecoveryDetails(HttpServletRequest request, int empId);
	//List<pensionForm1CalcDetailsDao> getHOForm1OtherDeptService(HttpServletRequest request, int empId);
	List<pensionForm1CalcDetailsDao> getHOForm1OtherDeptServiceVal(HttpServletRequest request, int empId);

}
