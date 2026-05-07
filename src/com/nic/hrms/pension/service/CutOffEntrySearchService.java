package com.nic.hrms.pension.service;

import java.util.List;




public interface CutOffEntrySearchService {
	//int check(int empId);
	List<Object[]> searchuser1(String searchText,String options,int empId );

}

