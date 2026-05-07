package com.nic.hrms.pension.reports.service;

import java.util.List;

public interface RevisedFamilyPensionOrderReportSearchService {
	List<Object[]> revisedFamilyPenOrderReportUserSearch(int empId );
	List<Object[]> revFamilyPenOrderReportUserSearch1(String penOrderReportSearchOptions,String penOrderReportSearchKeyword,int empId );

}
