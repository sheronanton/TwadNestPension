package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsDao;
import com.nic.hrms.pension.model.PensionApplicationForm1Dao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesDao;

public interface PensionApplicationForm1CalcMstDataService {

	List<Object []> penAppForm1MstData(int loginEmpId,int curloginEmpId);
	List<Object []> penAppForm1MstCheckValData(int loginEmpId,int curloginEmpId);
	List<Object []> penAppForm1CalcSettingData();
	List<Object []> penAppForm1CalcAvgSettingData();
	int penAppForm1CalcdaSettingData(String dadate);
	Double penAppForm1CalcComSettingData(int age);
	//String penAppForm1CalcEmpStatusData(int typepension,int empId);
	List<Object []> penAppForm1CalcEmpStatusData(int empId);
	List<Object []> penAppForm1CalcOldMstData(int loginEmpId);
	
	
	boolean savePensionAppForm1Calculation(PensionApplicationForm1Dao pensionform1);
	public boolean saveAddAverageEmoluments(List <PensionApplicationForm1AverageEmolumentsDao> form1averageemoluments );
	public boolean saveAddOtherDepartmentService(List<PensionApplicationForm1OthDeptServiceDao> penform1otherdepartmentservice);
	public boolean saveForm1Recoveries(List <PensionApplicationForm1RecoveriesDao> form1pensionrecoveries );
	public boolean deleteForm1Avgemoluments(int emp_id);
	public boolean deleteForm1Recoveries(int emp_id);	
	public boolean deleteForm1Otherdeptservice(int emp_id);
	

	public List<PensionApplicationForm1AverageEmolumentsDao> loadForm1OldAe(int emp_id);
	public List<PensionApplicationForm1RecoveriesDao> loadForm1OldRecoveries(int emp_id);
	
	public List<PensionApplicationForm1OthDeptServiceDao> loadForm1OldOtherDepService(int emp_id);
	
	
}
