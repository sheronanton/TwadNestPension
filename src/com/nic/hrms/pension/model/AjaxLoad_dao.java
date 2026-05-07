package com.nic.hrms.pension.model;

import java.io.Serializable;


public class AjaxLoad_dao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7939918044041238990L;
	 
	private int bankId;
	private String bankName;
	
	
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
	

}
