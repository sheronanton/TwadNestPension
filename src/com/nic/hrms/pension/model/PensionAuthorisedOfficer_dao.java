package com.nic.hrms.pension.model;

import java.io.Serializable;

public class PensionAuthorisedOfficer_dao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 519504845092857768L;
	
	private int authorisedOfficerId;
	private String authorisedOfficerDesc;
	
	
	
	public int getAuthorisedOfficerId() {
		return authorisedOfficerId;
	}
	public void setAuthorisedOfficerId(int authorisedOfficerId) {
		this.authorisedOfficerId = authorisedOfficerId;
	}
	public String getAuthorisedOfficerDesc() {
		return authorisedOfficerDesc;
	}
	public void setAuthorisedOfficerDesc(String authorisedOfficerDesc) {
		this.authorisedOfficerDesc = authorisedOfficerDesc;
	}
	
	
	
	
	
	
	
	

}
