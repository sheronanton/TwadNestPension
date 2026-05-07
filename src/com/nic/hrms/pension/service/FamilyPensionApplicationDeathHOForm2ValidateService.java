package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2NomineeDao;

public interface FamilyPensionApplicationDeathHOForm2ValidateService {

	List<Object[]> searchData(String option,String keyword,int loginEmpId);
	List<Object[]> getMstDataCheck(int empNo);
	
	List<Object[]> getMstData(int empNo);
	FamilyPensionApplicationDeathHOForm2DetailsDao getCoDetails(int empId);
	List<FamilyPensionApplicationDeathHOForm2NomineeDao> getHoNomineeList(int empNo);
	
	boolean saveDetails(Object obj);
	boolean saveAddnominee(List<FamilyPensionApplicationDeathHOForm2MstNomineeDao> famPenAppHeadNomMst);
	boolean deleteNominee(int empNo);
	boolean deleteHoCoDetails(int empNo);
	
}
