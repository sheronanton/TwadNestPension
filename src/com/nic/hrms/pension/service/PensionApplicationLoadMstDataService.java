package com.nic.hrms.pension.service;

import java.util.List;

public interface PensionApplicationLoadMstDataService {

	List<Object []> penAppMstData(int searchEmpId,int loginEmpId);
	List<Object []> chkAvailablity(int searchEmpId,int loginId);
	List<Object []> chkAvailablityForm1(int searchEmpId,int loginId);
	List<Object []> penAppFreezeCheck2(int empid);
}
