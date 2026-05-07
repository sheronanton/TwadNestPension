package com.nic.hrms.pension.reports.service;

import java.util.List;

public interface PensionApplicationFeildOfficeDeathReportSearchService {
	List<Object[]> penAppFieldOfficeDeathReportUserSearch(String penappreportSearchOptions,String penappreportSearchKeyword,int empId );
	List<Object[]> penAppFieldOfficeDeathReportUserSearch1(String penappreportSearchKeyword,int empId );

}
