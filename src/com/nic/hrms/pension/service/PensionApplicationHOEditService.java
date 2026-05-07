package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationHODetailsCoDao;
import com.nic.hrms.pension.model.PensionApplicationHODetailsValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeCoDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceCoDao;

public interface PensionApplicationHOEditService {

	
	boolean saveCommonData(PensionApplicationHODetailsCoDao coData);	
	boolean saveNominee(List<PensionApplicationHONomineeCoDao> coNominee);
	boolean saveNotVerifyService(List<PensionApplicationHOServiceCoDao> coService);
	boolean addNomineeDelete(int empId);
	boolean deleteNotVerify(int empId);
		
	PensionApplicationHODetailsCoDao getFullData(int empId,int officeId,int selectedId);	
	List<PensionApplicationHONomineeCoDao> loadNominee(int empId,int officeId,int SearchId);
	List<PensionApplicationHOServiceCoDao> loadService(int empId,int officeId,int SearchId);	
	String getDesignation(Integer desigId);
	String getOfficeName(Integer officeId);
	List<Object []> getMasterData(int empId );
	String getEmpIdFrz(Integer empId);
	
}
