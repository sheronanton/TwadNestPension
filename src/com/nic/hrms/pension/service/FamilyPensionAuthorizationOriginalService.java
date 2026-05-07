package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.FamilyPensionAuthorizationOriginalDao;
import com.nic.hrms.pension.model.PensionAuthorizationOriginalDao;
import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;


public interface FamilyPensionAuthorizationOriginalService {
	
	List<Object[]> getMasterDetails(int empNo);	
	boolean saveRecord(FamilyPensionAuthorizationOriginalDao penAppAuthOri);
	//List<Object[]> getExistingDetails(int empNo);	
	List<Object[]> searchOperation(String option,String keyword);
	List<Object[]> getAddress(int officeId);
	List<Object[]> checkPpoNo(int ppoNo);
	List<Object[]> getNominee(int empNo);
	List<Object[]> getNominDetails(int empNo,int nomId);
	boolean deleteHoCoDetails(int empNo);
	List<PensionAuthorisedOfficer_dao> getListOfAythorisedOfficer();
}
