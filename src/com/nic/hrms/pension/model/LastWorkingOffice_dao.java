package com.nic.hrms.pension.model;

import java.io.Serializable;

public class LastWorkingOffice_dao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7902205463738866499L;
	
	
	private String LastWorkingOfficeLevel;
	private String LastWorkingOfficeName;
	
	
	
	public String getLastWorkingOfficeLevel() {
		return LastWorkingOfficeLevel;
	}
	public void setLastWorkingOfficeLevel(String lastWorkingOfficeLevel) {
		LastWorkingOfficeLevel = lastWorkingOfficeLevel;
	}
	public String getLastWorkingOfficeName() {
		return LastWorkingOfficeName;
	}
	public void setLastWorkingOfficeName(String lastWorkingOfficeName) {
		LastWorkingOfficeName = lastWorkingOfficeName;
	}
	
	
		

}
