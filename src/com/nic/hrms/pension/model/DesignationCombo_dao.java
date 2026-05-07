package com.nic.hrms.pension.model;

import java.io.Serializable;

public class DesignationCombo_dao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4161553976078733401L;
	
	private int designationId;
	private String designationId1;
	private String designationName;
	private int gradeId;
	private int orderSeqNo;
	
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
		setDesignationId1(""+designationId);
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public void setDesignationId1(String designationId1) {
		this.designationId1 = designationId1;
	}
	public String getDesignationId1() {
		return designationId1;
	}
	public void setOrderSeqNo(int orderSeqNo) {
		this.orderSeqNo = orderSeqNo;
	}
	public int getOrderSeqNo() {
		return orderSeqNo;
	}
	
	
	
	

}
