	package com.nic.hrms.pension.service;
	
	import java.util.List;
	
	
	public interface PensionApplicationForm1SearchService 
	{
		List<Object[]> FetchPensionApplicationForm1Search(String SearchScreenKeyword,String SearchScreenOptions,int empId);
		List<Object[]> FetchPensionApplicationForm1ValSearch(String SearchScreenKeyword,String SearchScreenOptions,int empId);
		
		
	}
