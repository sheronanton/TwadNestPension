package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationHOForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.RevisedPensionCalcOthDeptService;
import com.nic.hrms.pension.model.RevisedPensionCalcOthDeptServiceDao;
import com.nic.hrms.pension.model.RevisedPensionCalculationAverageEmolumentsDao;
import com.nic.hrms.pension.model.RevisedPensionCalculationDao;

public interface RevisedPensionCalculationMstDataValService {

	List<Object []> revisedPenCalculationMstChangeData(int loginEmpId,int curloginEmpId);
	List<Object []> revisedPenCalcChangeData(int loginEmpId,int curloginEmpId);
	List<Object []> revPenCalcSettingData();
	List<Object []> revPenCalcAvgSettingData();
	int revPenCalcdaSettingData(String dadate);
	Double revPenCalcComSettingData(int age);
	List<Object []> revPenCalcEmpStatusData(int empId);
	List<Object []> revisedPenCalculationChangeData(int loginEmpId);
	
	
	boolean saveRevisedPensionValCalculation(RevisedPensionCalculationDao revisedpensionvalcalc);
	public boolean saveRevisedPenValAverageEmoluments(List <RevisedPensionCalculationAverageEmolumentsDao> revPenaemultidata );
	public boolean deleteRevisedAvgemoluments(int emp_id);	

	public List<RevisedPensionCalculationAverageEmolumentsDao> loadRevisedChangeAe(int emp_id);	
	boolean moveOldPensionDetailsIntoHistory(int empId);
	public List<RevisedPensionCalcOthDeptService> loadHOOfficeForm1OldOtherDepServiceVal(Integer empId);
	boolean deleteHOForm1OthdeptdetailsVal(Integer empNo);
	boolean saveAddHOOtherDepartmentServiceVal(List<RevisedPensionCalcOthDeptServiceDao> revvalotherdao);
	
	
}
