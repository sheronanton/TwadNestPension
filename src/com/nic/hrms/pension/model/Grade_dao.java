package com.nic.hrms.pension.model;

import java.io.Serializable;

public class Grade_dao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8881445691843999476L;
	
	
	private int gradeId;
	private String GradeName;
	
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return GradeName;
	}
	public void setGradeName(String gradeName) {
		GradeName = gradeName;
	}


}
