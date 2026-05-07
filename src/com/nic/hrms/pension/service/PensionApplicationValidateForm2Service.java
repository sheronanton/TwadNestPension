package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNotVerifyServDao;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;

public interface PensionApplicationValidateForm2Service {

	List<Object[]> getEmpDetails(String option,String keyword,int empId);
	PensionApplicationForm2Dao getExistingData(int empId);
	List<PensionApplicationNomineeDao> getListOfValidNominee(int empIdList);
	List<PensionApplicationNotVerifyServDetailsDao> getListOfValidNotVerSer(int empIdList1);
	String getDesignation(int empId);
	String getOffice(int empId);
	
	boolean saveOrUpdateData(Object obj);
	boolean saveAddnominee(List<PensionApplicationForm2MstNomineeDao> penappnom);
	boolean saveNotVerifyService(List<PensionApplicationForm2MstNotVerifyServDao> notverservice);
	boolean setMstProcessStatus(int empId);
	boolean deleteNomineeCo(int empId);
	boolean deleteNVServiceCo(int empId);
}
