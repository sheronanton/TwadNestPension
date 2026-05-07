package com.nic.hrms.pension.model;

import java.io.Serializable;

public class ReligionDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer religionCode;
	private String religionName;
	private String religionCode1;
	
	public Integer getReligionCode() {
		return religionCode;
	}
	public void setReligionCode(Integer religionCode) {
		setReligionCode1(religionCode+"");
		this.religionCode = religionCode;
	}
	public String getReligionName() {
		return religionName;
	}
	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}
	public void setReligionCode1(String religionCode1) {
		this.religionCode1 = religionCode1;
	}
	public String getReligionCode1() {
		return religionCode1;
	}
	
	
	
}
