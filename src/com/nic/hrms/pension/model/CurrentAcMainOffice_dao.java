package com.nic.hrms.pension.model;

import java.io.Serializable;

public class CurrentAcMainOffice_dao implements Serializable{

	
	
	private static final long serialVersionUID = -3871097541393L;
	
	private Integer currAccountOfficeId;
	private String currAccountOfficeName;
	private char accUnit;
	private String currAccountOfficeId1;
	
	
	
	public Integer getCurrAccountOfficeId() {
		return currAccountOfficeId;
	}
	public void setCurrAccountOfficeId(Integer currAccountOfficeId) {
		this.currAccountOfficeId = currAccountOfficeId;
		setCurrAccountOfficeId1(""+currAccountOfficeId);
		
		
	}
	public String getCurrAccountOfficeName() {
		return currAccountOfficeName;
	}
	public void setCurrAccountOfficeName(String currAccountOfficeName) {
		this.currAccountOfficeName = currAccountOfficeName;
	}
	public char getAccUnit() {
		return accUnit;
	}
	public void setAccUnit(char accUnit) {
		this.accUnit = accUnit;
	}
	public void setCurrAccountOfficeId1(String currAccountOfficeId1) {
		this.currAccountOfficeId1 = currAccountOfficeId1;
	}
	public String getCurrAccountOfficeId1() {
		return currAccountOfficeId1;
	}
	

	
}
