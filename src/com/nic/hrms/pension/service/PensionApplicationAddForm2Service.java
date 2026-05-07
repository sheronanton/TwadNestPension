package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationIndividualNominee;
import com.nic.hrms.pension.model.PensionApplicationIndividualNotVerServ;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;

public interface PensionApplicationAddForm2Service {

	boolean saveOrUpdateData(Object obj) ;
	boolean saveAddnominee(List<PensionApplicationNomineeDao> penappnomin);
	boolean saveNotVerifyService(List<PensionApplicationNotVerifyServDetailsDao> notverserv);
	boolean addNomineeDelete(int empId);
	boolean deleteNotVerify(int empId);
	
	List<Object[]> getIndividualPersonnelData(int empId,int officeId);
	List<PensionApplicationIndividualNominee> getIndividualNominee(int empId);
	List<PensionApplicationIndividualNotVerServ> getIndividualNVService(int empId);
	
}

