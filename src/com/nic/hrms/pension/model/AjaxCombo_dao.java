package com.nic.hrms.pension.model;

import java.io.Serializable;

public class AjaxCombo_dao implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 4413253754306165300L;
	 
	 private int bankId;
	 private int branchId;
	 private String branchId1;
	 private String branchName;
	 private int officeId;
	
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
		setBranchId1(""+branchId);
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public void setBranchId1(String branchId1) {
		this.branchId1 = branchId1;
	}
	public String getBranchId1() {
		return branchId1;
	}
	
	 
	 
}
