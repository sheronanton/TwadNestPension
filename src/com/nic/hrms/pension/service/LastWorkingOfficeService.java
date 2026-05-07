package com.nic.hrms.pension.service;

import java.util.List;

public interface LastWorkingOfficeService {

	List<Object[]> getOffice();
	List<Object[]> getOfficeDetails(int id);
	
	
}
 