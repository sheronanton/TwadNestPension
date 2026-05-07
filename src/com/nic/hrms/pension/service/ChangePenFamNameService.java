package com.nic.hrms.pension.service;

import java.util.List;
import com.nic.hrms.pension.model.ChangePenFamNameModel;

public interface ChangePenFamNameService {

	List<Object[]> itRecoverySearch(String keyword, String options, int empId);

	public int getIdName(int empno, int empId);

	public boolean upadatepenfamname(String initial, String changeName, Integer empNo);

	List<Object[]> getNmpName(int empno, int empId);
	
	

}
