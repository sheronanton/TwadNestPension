	package com.nic.hrms.pension.service;
	
	import java.util.List;
	
	
	public interface RevisedPensionCalculationSearchService 
	{
		List<Object[]> FetchRevisedPensionCalculationSearch(String SearchScreenKeyword,String SearchScreenOptions,int empId);
		List<Object[]> FetchRevisedPensionCalculationValSearch(String SearchScreenKeyword,String SearchScreenOptions,int empId);
		
		
	}
