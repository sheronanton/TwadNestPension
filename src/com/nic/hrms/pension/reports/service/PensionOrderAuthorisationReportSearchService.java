package com.nic.hrms.pension.reports.service;

import java.util.List;

public interface PensionOrderAuthorisationReportSearchService {
	List<Object[]> penOrderAuthorisationReportUserSearch(int empId );
	List<Object[]> penOrderAuthorisationReportUserSearch1(String penOrderReportSearchOptions,String penOrderReportSearchKeyword,int empId );

}
