package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.HrPenPensionerCutOffFetchModel;


public interface HrPenPensionerCutOffFetchService {
	List<HrPenPensionerCutOffFetchModel>fetch(int employeeId);
	

}
