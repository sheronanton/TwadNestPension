package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationHOForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1OthDeptServiceValDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1ValDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1RecoveriesValDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1AverageEmolumentsDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1RecoveriesDao;

public interface PensionApplicationHOForm1CalcMstValDataService {

	List<Object []> penAppHOForm1MstValData(int loginEmpId,int curloginEmpId);
	List<Object []> penAppHOForm1CalcSettingValData();
	List<Object []> penAppHOForm1CalcAvgSettingValData();
	int penAppHOForm1CalcdaSettingValData(String dadate);
	Double penAppHOForm1CalcComSettingValData(int age);
	List<Object []> penAppHOForm1CalcEmpStatusValData(int empId);
	List<Object []> penAppHOForm1CalcOldMstValData(int loginEmpId);
	
	
	
	boolean savePensionAppHOForm1ValCalculation(PensionApplicationHOForm1ValDao pensionValHOform1);
	public boolean saveAddHOAverageEmolumentsVal(List <PensionApplicationHOForm1AverageEmolumentsValDao> valHOform1averageemoluments );
	public boolean saveHOForm1RecoveriesVal(List <PensionApplicationHOForm1RecoveriesValDao> valHOform1pensionrecoveries );
	public boolean saveAddHOOtherDepartmentServiceVal(List<PensionApplicationHOForm1OthDeptServiceValDao> valHOform1OthdeptService);
	
	public boolean deleteHOForm1AvgemolumentsVal(int emp_id);
	public boolean deleteHOForm1RecoveriesVal(int emp_id);
	public boolean deleteHOForm1Avgemoluments(int emp_id);
	public boolean deleteHOForm1Recoveries(int emp_id);
	public boolean deleteHOForm1Details(int emp_id);	
	public boolean deleteHOForm1OthdeptdetailsVal(int emp_id);
	public List<PensionApplicationHOForm1AverageEmolumentsDao> loadHOForm1OldAeVal(int emp_id);
	public List<PensionApplicationHOForm1RecoveriesDao> loadHOForm1OldRecoveriesVal(int emp_id);
	public List<PensionApplicationHOForm1OthDeptServiceDao>loadHOOfficeForm1OldOtherDepServiceVal(int emp_id);
}
