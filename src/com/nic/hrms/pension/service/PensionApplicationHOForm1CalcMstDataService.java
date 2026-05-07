package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationHOForm1AverageEmolumentsDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1Dao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1RecoveriesDao;

import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesValDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceValDao;

public interface PensionApplicationHOForm1CalcMstDataService {

	List<Object []> penAppHOForm1MstData(int loginEmpId,int curloginEmpId);
	List<Object []> penAppHOForm1MstCheckValData(int loginEmpId,int curloginEmpId);
	List<Object []> penAppHOForm1CalcSettingData();
	List<Object []> penAppHOForm1CalcAvgSettingData();
	int penAppHOForm1CalcdaSettingData(String dadate);
	Double penAppHOForm1CalcComSettingData(int age);
	List<Object []> penAppHOForm1CalcEmpStatusData(int empId);
	List<Object []> penAppHOForm1CalcOldMstData(int loginEmpId);
	
	
	boolean savePensionAppHOForm1Calculation(PensionApplicationHOForm1Dao ho_pensionform1);
	public boolean saveAddHOAverageEmoluments(List <PensionApplicationHOForm1AverageEmolumentsDao> ho_form1averageemoluments );
	public boolean saveHOForm1Recoveries(List <PensionApplicationHOForm1RecoveriesDao> ho_form1pensionrecoveries );
	public boolean saveAddHOOtherDepartmentService(List<PensionApplicationHOForm1OthDeptServiceDao> ho_form1othdeptservices);
	public boolean deleteHOForm1Avgemoluments(int emp_id);
	public boolean deleteHOForm1Recoveries(int emp_id);	
	public boolean deleteHOForm1Othdeptservice(int emp_id);
	

	public List<PensionApplicationHOForm1AverageEmolumentsDao> loadHOForm1OldAe(int emp_id);
	public List<PensionApplicationHOForm1RecoveriesDao> loadHOForm1OldRecoveries(int emp_id);
	public List<PensionApplicationHOForm1OthDeptServiceDao> loadHOOfficeForm1OldOtherDepServiceVal(int emp_id);
	
	
	
	
	//FIELD OFFICE VALIDATED RECORD FETCHING START
	
	List<Object []> penAppHOForm1CalcFieldOfficeOldMstData(int loginEmpId);
	public List<PensionApplicationForm1AverageEmolumentsValDao> loadHOForm1FieldOfficeOldAe(int emp_id);
	public List<PensionApplicationForm1RecoveriesValDao> loadHOForm1FieldOfficeOldRecoveries(int emp_id);
	public List<PensionApplicationForm1OthDeptServiceValDao> loadForm1OldOtherDepServiceVal(int emp_id);
	
	//FIELD OFFICE VALIDATED RECORD FETCHING END
	
}
