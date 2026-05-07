package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2NomineeCo;


public interface FamilyPensionApplicationDeathFieldForm2Service {

	List<Object[]> getMstData(int empNo,int loginEmpId);
	List<Object[]> getCoDetails(int empNo,int loginEmpId);
	List<FamilyPensionApplicationDeathFieldForm2NomineeCo> getNomineeList(int empNo,int loginEmpId);

	boolean saveRecord(Object obj);
	boolean saveAddnominee(List<FamilyPensionApplicationDeathFieldForm2NomineeCo> penappnomin);
	boolean deleteNominee(int empNo);
	
	List<Object[]> searchMethod(String option,String keyword,int loginEmpId);
	List<Object[]> chkAvailablity2(int searchEmpId, int loginId);
	List<Object[]> chkAvailablity1(int searchEmpId, int loginId);
	
}
