package com.nic.hrms.pension.model;


public class MstPension implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7281303323175331433L;
	private String classId;
	private String classDesc;
	public MstPension()
	{
		
	}
	
	
	
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassDesc() {
		return classDesc;
	}
	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}
	
	

}
