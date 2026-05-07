	package com.nic.hrms.pension.service;
	
	import java.util.List;
	
	
	public interface PensionApplicationHeadOfficeForm1SearchService 
	{
		List<Object[]> FetchPensionApplicationHeadOfficeForm1Search(String SearchScreenKeyword,String SearchScreenOptions,int empId);
		List<Object[]> FetchPensionApplicationHeadOfficeForm1ValSearch(String SearchScreenKeyword,String SearchScreenOptions,int empId);
		
		
	}
