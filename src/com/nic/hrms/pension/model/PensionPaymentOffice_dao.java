package com.nic.hrms.pension.model;

import java.io.Serializable;

public class PensionPaymentOffice_dao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 519504845092857768L;
	
	private int currAccountOfficeId;
	private String currAccountOfficeId1;
	private String currAccountOfficeName;
	private char PenisonPaymentOffice;
	
	public int getCurrAccountOfficeId() {
		return currAccountOfficeId;
	}
	public void setCurrAccountOfficeId(int currAccountOfficeId) {
		this.currAccountOfficeId = currAccountOfficeId;
		setCurrAccountOfficeId1(""+currAccountOfficeId);
	}
	public String getCurrAccountOfficeName() {
		return currAccountOfficeName;
	}
	public void setCurrAccountOfficeName(String currAccountOfficeName) {
		this.currAccountOfficeName = currAccountOfficeName;
	}
	public char getPenisonPaymentOffice() {
		return PenisonPaymentOffice;
	}
	public void setPenisonPaymentOffice(char penisonPaymentOffice) {
		PenisonPaymentOffice = penisonPaymentOffice;
	}
	public String getCurrAccountOfficeId1() {
		return currAccountOfficeId1;
	}
	public void setCurrAccountOfficeId1(String currAccountOfficeId1) {
		this.currAccountOfficeId1 = currAccountOfficeId1;
	}
	
	
	
	
	
	

}
