	package com.nic.hrms.pension.service;
	
	import java.util.List;
	
	
	public interface RevisedPensionCalculationSearchValService 
	{
		List<Object[]> FetchRevisedPensionCalculationValSearch(String SearchScreenKeyword,String SearchScreenOptions,int empId);	
		
	}
