package com.nic.hrms.pension.service;

import java.util.List;

public interface MstNomineeSearchService {
	List<Object[]> SearchThings(String searchText,String options,int empId );
	List<Object[]> ChangedSearchThings(String searchText,String options,int empId );

}
