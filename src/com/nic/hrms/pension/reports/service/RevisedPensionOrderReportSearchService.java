package com.nic.hrms.pension.reports.service;

import java.util.List;

public interface RevisedPensionOrderReportSearchService {
	List<Object[]> revisedPenOrderReportUserSearch(int empId );
	List<Object[]> revPenOrderReportUserSearch1(String penOrderReportSearchOptions,String penOrderReportSearchKeyword,int empId );

}
