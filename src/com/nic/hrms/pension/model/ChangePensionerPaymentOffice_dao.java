package com.nic.hrms.pension.model;

import java.sql.Timestamp;

public class ChangePensionerPaymentOffice_dao {
	private int ppoNo;
	private int paymentOfficeId;
	private String reason;
	private Timestamp updatedDate;
	private String updatedBy;
	
	private String processStatus;	
	private String unlockedBy;
	private Timestamp unlockedDate;
	
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	public int getPaymentOfficeId() {
		return paymentOfficeId;
	}
	public void setPaymentOfficeId(int paymentOfficeId) {
		this.paymentOfficeId = paymentOfficeId;
		System.out.println("paymentOfficeId--"+paymentOfficeId);
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
		System.out.println("Reason--"+reason);
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		System.out.println("Updatedby--"+updatedBy);
	}
	
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getUnlockedBy() {
		return unlockedBy;
	}
	public void setUnlockedBy(String unlockedBy) {
		this.unlockedBy = unlockedBy;
	}
	public Timestamp getUnlockedDate() {
		return unlockedDate;
	}
	public void setUnlockedDate(Timestamp unlockedDate) {
		this.unlockedDate = unlockedDate;
	}
	

}
