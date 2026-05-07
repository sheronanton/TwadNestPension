package com.nic.hrms.pension.model;

import java.io.Serializable;

public class ChangePenFamNameModel implements Serializable {
	
	
private static final long serialVersionUID = 1394429004586193977L;
	
	private int empNo;
	private String initial;
	private String changeName;
	
	
	
	
	public int getEmpNo() {
		return empNo;
	}




	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}



	public String getChangeName() {
		return changeName;
	}




	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}




	public static long getSerialVersionUID() {
		return serialVersionUID;
	}




	public String getInitial() {
		return initial;
	}




	public void setInitial(String initial) {
		this.initial = initial;
	}
	
	
	

}
