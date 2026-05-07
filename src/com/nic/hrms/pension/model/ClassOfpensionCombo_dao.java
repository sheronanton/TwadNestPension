package com.nic.hrms.pension.model;

import java.io.Serializable;

public class ClassOfpensionCombo_dao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3920769217158914846L;
	
	
	private int classId;
	private String classDesc;
	
	
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassDesc() {
		return classDesc;
	}
	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}
	
	

}
