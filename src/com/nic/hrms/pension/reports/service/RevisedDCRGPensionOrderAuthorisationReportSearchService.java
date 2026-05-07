package com.nic.hrms.pension.reports.service;

import java.util.List;

public interface RevisedDCRGPensionOrderAuthorisationReportSearchService {
	List<Object[]> revisedDCRGPenOrderAuthorisationReportUserSearch(int empId );
	List<Object[]> revDCRGPenOrderAuthorisationReportUserSearch1(String penOrderReportSearchOptions,String penOrderReportSearchKeyword,int empId );

}
