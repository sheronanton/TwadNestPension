package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstDetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2NomineeCo;

public interface FamilyPensionApplicationDeathFieldForm2ValidateService {

	List<Object[]> searchData(String searchKey,String searchOption,int empNo);
	FamilyPensionApplicationDeathFieldForm2DetailsDao getDetails(int empNo);
	List<Object[]> getMstData(int empNo);
	List<FamilyPensionApplicationDeathFieldForm2NomineeCo> getNomineeList(int empNo,int officeId);	
	boolean saveDetails(FamilyPensionApplicationDeathFieldForm2MstDetailsDao detailsObj);
	boolean saveNominee(List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> nomineeObj);
	boolean deleteNominee(int empNo);
	boolean deleteCoDetails(int empNo);
	boolean deleteCoNominee(int empNo);
	
}
