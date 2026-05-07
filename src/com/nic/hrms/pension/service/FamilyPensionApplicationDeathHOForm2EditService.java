package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2NomineeDao;

public interface FamilyPensionApplicationDeathHOForm2EditService
{
	List<Object[]> editSearch(String option,String keyword,int loginEmpId);
	List<Object[]> getMstData(int empNo);
	List<Object[]> getFieldMstData(int empNo);
	
	List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> getNomineeList(int empNo);	
	boolean  saveDetails(FamilyPensionApplicationDeathHOForm2DetailsDao famPenAppHeadCo);
	boolean saveAddnominee(List<FamilyPensionApplicationDeathHOForm2NomineeDao> famPenAppHeadNomCo);
	boolean deleteNominee(int empNo);
	
	List<Object[]> getHoDetails(int empNo);
	List<FamilyPensionApplicationDeathHOForm2NomineeDao> getHoNomineeList(int empNo);
	
	List<Object[]> getMstDataCheck(int empNo);
}
