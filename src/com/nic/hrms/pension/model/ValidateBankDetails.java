package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ValidateBankDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8358477052779245897L;
	
	
	private int ppoNo;
	private int branchId;
	private int bankId;
	private String bankAcNo;
	private String processStatus;
	private String bankPaymentMode;
	private String updatedId;
	private Timestamp updatedDate;
	
	
	
	
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankAcNo() {
		return bankAcNo;
	}
	public void setBankAcNo(String bankAcNo) {
		this.bankAcNo = bankAcNo;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public void setBankPaymentMode(String bankPaymentMode) {
		this.bankPaymentMode = bankPaymentMode;
	}
	public String getBankPaymentMode() {
		return bankPaymentMode;
	}
	public void setUpdatedId(String updatedId) {
		this.updatedId = updatedId;
	}
	public String getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	
	
	
	
	
	

}
