package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;


public class PfsfSubDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4150266328441861146L;

	private Integer ppoNo;
	private String updatedUsedId;
	private Timestamp updatedDate;
	private String processStatus;
	private String unlockedBy;
	private Timestamp unlockedDate;
	
	public Integer getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(Integer ppoNo) {
		this.ppoNo = ppoNo;
	}
	public String getUpdatedUsedId() {
		return updatedUsedId;
	}
	public void setUpdatedUsedId(String updatedUsedId) {
		this.updatedUsedId = updatedUsedId;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
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
