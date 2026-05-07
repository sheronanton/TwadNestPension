package com.nic.hrms.pension.model;

import java.io.Serializable;

public class ValidateMstCuttOff_dao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7135240706440536950L;
	
	private int ppoNo;
	private String processStatus;
	
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	
	

}
