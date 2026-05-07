package com.nic.hrms.pension.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeForm2ReportDao;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNomineeForm2;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNotVerServForm2;

public interface PensionApplicationHeadOfficeForm2ReportService {

		List<PensionApplicationFieldOfficeForm2ReportDao> printHeadOfficeDetails(HttpServletRequest request,int empId,int officeId);
		List<PensionApplicationFieldOfficeNomineeForm2> printHeadOfficeNominee(HttpServletRequest request,int empIdList);
		List<PensionApplicationFieldOfficeNotVerServForm2> printHeadOfficeNVServ(HttpServletRequest request,int empIdList);

}
