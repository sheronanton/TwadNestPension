package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionApplicationHOForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.RevisedPensionAuthorizationDao;

public interface RevisedDCRGPenLoadHeadOfficeDataService {

	List<Object[]> loadAllData();
	List<Object[]> LoadEmployeeData(int empid);
	List<Object[]> searchData(String option,String keyword,int empId);	
	List<Object[]> penAppHOForm1MstValData(int loginEmpId,String searchEmpId);
	int penAppHOForm1CalcdaSettingValData(String dadate);
	List<Object[]> revpenAppHOOldMstValData(String searchEmpId);
	public List<PensionApplicationHOForm1AverageEmolumentsValDao> loadHOForm1OldAeVal(int emp_id);
	boolean moveOldDCRGIntoHistory(int empId);
	Double penAppHOForm1CalcComSettingValData(int age);
	String getdaorderno(String retiredate);
	String getdaeffectdate(String retiredate);
	boolean updateNewDCRGIntoHeadOfficeData(float dcrgpensionamount, int damount, int dapercentage, String empId, String updatedId);
	public boolean saveRecord(RevisedPensionAuthorizationDao revisedPenAppAuthOrg);
}
