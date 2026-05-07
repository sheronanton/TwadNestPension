package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationForm2MstDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNotVerifyServDao;

public interface PensionApplicationLoadFieldOfficeDataService {

	List<Object[]> loadAllData();
	List<Object[]> searchData(String option,String keyword,int empId);
	
	PensionApplicationForm2MstDao loadFieldOfficeData(int empId,int officeId,int SearchId);
	List<PensionApplicationForm2MstNomineeDao> loadFieldOfficeNominee(int empId,int officeId,int SearchId);
	List<PensionApplicationForm2MstNotVerifyServDao> loadFieldOfficeService(int empId,int officeId,int SearchId);
	
	String getDesignation(int desigId);
	String getOfficeName(int officeId);
	
}
