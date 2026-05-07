package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;



public interface PensionApplicationEditForm2Service 
{
	List<Object[]> getListEmp(String option,String keywors,int empId);
	PensionApplicationForm2Dao getExistingData(int empId);
	
	List<PensionApplicationNomineeDao> getListOfEditNominee(int empIdList);
	List<PensionApplicationNotVerifyServDetailsDao> getListOfEditNotVerSer(int empIdList1);
	List<Object[]> getListEmpAdd(String option,String keywors,int empId);
	String getDesignation(int empId);
	String getOffice(int empId);
	
}
