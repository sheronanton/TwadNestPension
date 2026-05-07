package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1ValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsDao;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceDao;


public interface PensionApplicationForm1CalcMstValDataService {

	List<Object []> penAppForm1MstValData(int loginEmpId,int curloginEmpId);
	List<Object []> penAppForm1CalcSettingValData();
	List<Object []> penAppForm1CalcAvgSettingValData();
	int penAppForm1CalcdaSettingValData(String dadate);
	Double penAppForm1CalcComSettingValData(int age);
	List<Object []> penAppForm1CalcEmpStatusValData(int empId);
	List<Object []> penAppForm1CalcOldMstValData(int loginEmpId);
	
	
	
	boolean savePensionAppForm1ValCalculation(PensionApplicationForm1ValDao pensionValform1);
	public boolean saveAddAverageEmolumentsVal(List <PensionApplicationForm1AverageEmolumentsValDao> valform1averageemoluments );
	public boolean saveForm1RecoveriesVal(List <PensionApplicationForm1RecoveriesValDao> valform1pensionrecoveries );
	public boolean deleteForm1AvgemolumentsVal(int emp_id);
	public boolean deleteForm1RecoveriesVal(int emp_id);
	public boolean deleteForm1Avgemoluments(int emp_id);
	public boolean deleteForm1Recoveries(int emp_id);
	public boolean deleteForm1Details(int emp_id);
	public boolean deleteForm1othdeptservice(int emp_id);
	public boolean deleteForm1OtherdeptserviceVal(int emp_id);
	public boolean saveAddOtherDepartmentServiceVal(List<PensionApplicationForm1OthDeptServiceValDao> penform1otherdepartmentserviceval);
	

	/*public List<PensionApplicationForm1AverageEmolumentsValDao> loadForm1OldAeVal(int emp_id);
	public List<PensionApplicationForm1RecoveriesValDao> loadForm1OldRecoveriesVal(int emp_id);*/
	public List<PensionApplicationForm1AverageEmolumentsDao> loadForm1OldAeVal(int emp_id);
	public List<PensionApplicationForm1RecoveriesDao> loadForm1OldRecoveriesVal(int emp_id);
	public List<PensionApplicationForm1OthDeptServiceDao> loadForm1OldOtherDepServiceVal(int emp_id);
}
