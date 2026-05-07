package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.action.ChangeDesignationAction;

public interface ChangeDesignationService {

	List<Object[]> designationSearch(String keyword, String options, int empId);

	List<Object[]> getIdName(int empno, int empId);

	public boolean upadatedesignation(int changedesig, int empno);
 
}
