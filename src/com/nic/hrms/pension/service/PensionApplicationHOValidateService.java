package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationHODetailsCoDao;
import com.nic.hrms.pension.model.PensionApplicationHODetailsValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeCoDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceCoDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceValidateDao;

public interface PensionApplicationHOValidateService 
{
	List<Object[]> getListEmp();
	List<Object[]> getSearchList(String Keyword,String option,int empId);
	PensionApplicationHODetailsCoDao commonData(int searchEmpNo,int loginEmpNo,int loginEmpOfficeId);
	List<PensionApplicationHONomineeCoDao> listHOEditNominee(int searchEmpNo,int loginEmpNo,int loginEmpOfficeId);
	List<PensionApplicationHOServiceCoDao> listHOEditService(int searchEmpNo,int loginEmpNo,int loginEmpOfficeId);
	boolean saveorUpdateData(PensionApplicationHODetailsValidateDao penapphoval);	
	boolean saveNominee(List<PensionApplicationHONomineeValidateDao> penapphovalnom);	
	boolean saveNotVerifyService(List<PensionApplicationHOServiceValidateDao> penapphovalser);
	Integer penAppEmpdesigination(int empId,int loginEmpOfficeId);
	String getDesignation(Integer desigId);
	String getOfficeName(Integer officeId);
	String getFreezdata(Integer loginEmpId);
	
	//boolean addNomineeDelete(int empId);
	//boolean deleteNotVerify(int empId);
	
}
