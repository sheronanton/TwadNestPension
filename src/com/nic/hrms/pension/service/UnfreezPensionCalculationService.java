package com.nic.hrms.pension.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface UnfreezPensionCalculationService {

	boolean unfreezepensioncalculation(HttpServletRequest request, Integer empNo);

	List<Object[]> getempName(int empno, int empId);

	List<Object[]> getempRevisedName(int empno, int empId);

	boolean unfreezepensioncalculationrevised(HttpServletRequest request,
			Integer empNo);

}
