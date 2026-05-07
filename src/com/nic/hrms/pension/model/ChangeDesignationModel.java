package com.nic.hrms.pension.model;

import java.io.Serializable;

public class ChangeDesignationModel implements Serializable {
	
private static final long serialVersionUID = 1394429004586193977L;
	
	private int empNo;
	private String changedesig;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getChangedesig() {
		return changedesig;
	}
	public void setChangedesig(String changedesig) {
		this.changedesig = changedesig;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	

}
