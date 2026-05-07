package com.nic.hrms.pension.model;

import java.io.Serializable;

public class PensionApplicationSearchModel implements Serializable
{

	/**
	 * Pension Application - Common Search Model
	 */
	private static final long serialVersionUID = -5905067822764696760L;

	private int empId;
	private String keyword;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
