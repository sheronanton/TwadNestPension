package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationHOForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.RevisedPensionCalcOthDeptService;
import com.nic.hrms.pension.model.RevisedPensionCalcOthDeptServiceDao;
import com.nic.hrms.pension.model.RevisedPensionCalculationAverageEmolumentsDao;
import com.nic.hrms.pension.model.RevisedPensionCalculationDao;

public interface RevisedPensionCalculationMstDataService {

	List<Object []> revisedPenCalculationMstData(int loginEmpId,int curloginEmpId);
	List<Object []> revisedPenCalcCheckValData(int loginEmpId,int curloginEmpId);
	List<Object []> revPenCalcSettingData();
	List<Object []> revPenCalcAvgSettingData();
	int revPenCalcdaSettingData(String dadate);
	Double revPenCalcComSettingData(int age);
	List<Object []> revPenCalcEmpStatusData(int empId);
	List<Object []> revisedPenCalculationOldData(int loginEmpId);
	
	
	boolean saveRevisedPensionCalculation(RevisedPensionCalculationDao revisedpensioncalc);
	public boolean saveRevisedPenAverageEmoluments(List <RevisedPensionCalculationAverageEmolumentsDao> revPenaemultidata );
	public boolean deleteRevisedAvgemoluments(int emp_id);	

	public List<RevisedPensionCalculationAverageEmolumentsDao> loadRevisedOldAe(int emp_id);
	public List<RevisedPensionCalcOthDeptServiceDao> loadHOOfficeForm1OldOtherDepServiceVal(Integer empId);
	public boolean deleteothertdeptmst(int empNo);
	public boolean saveothherdeptservice(List<RevisedPensionCalcOthDeptService> revOtherservicelist);	
	
	
}
