package com.nic.hrms.pension.reports.service;

import java.util.List;

public interface PensionApplicationFeildOfficeReportSearchService {
	List<Object[]> penAppFieldOfficeReportUserSearch(String penappreportSearchOptions,String penappreportSearchKeyword,int empId );
	List<Object[]> penAppFieldOfficeReportUserSearch1(String penappreportSearchKeyword,int empId );

}
