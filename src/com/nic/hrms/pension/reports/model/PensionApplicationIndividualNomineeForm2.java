package com.nic.hrms.pension.reports.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PensionApplicationIndividualNomineeForm2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal EMP_NO;	
	private BigDecimal NOMINEE_ID;
	private String NOMINEE_INITIAL;
	private String NOMINEE_NAME;
	private String RELATIONSHIP_ID;
	private Date DOB;
	private BigDecimal AGE;
	private String HANDICAPPED;
	private String MARITAL_STATUS;
	private Date NOMINATION_DATE;
	private String ACTIVE_STATUS;
	private String REASON;
	
	public BigDecimal getEMP_NO() {
		return EMP_NO;
	}
	public void setEMP_NO(BigDecimal emp_no) {
		EMP_NO = emp_no;
	}
	public BigDecimal getNOMINEE_ID() {
		return NOMINEE_ID;
	}
	public void setNOMINEE_ID(BigDecimal nominee_id) {
		NOMINEE_ID = nominee_id;
	}
	public String getNOMINEE_INITIAL() {
		return NOMINEE_INITIAL;
	}
	public void setNOMINEE_INITIAL(String nominee_initial) {
		NOMINEE_INITIAL = nominee_initial;
	}
	public String getNOMINEE_NAME() {
		return NOMINEE_NAME;
	}
	public void setNOMINEE_NAME(String nominee_name) {
		NOMINEE_NAME = nominee_name;
	}
	public String getRELATIONSHIP_ID() {
		return RELATIONSHIP_ID;
	}
	public void setRELATIONSHIP_ID(String relationship_id) {
		RELATIONSHIP_ID = relationship_id;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dob) {
		DOB = dob;
	}
	public BigDecimal getAGE() {
		return AGE;
	}
	public void setAGE(BigDecimal age) {
		AGE = age;
	}
	public String getHANDICAPPED() {
		return HANDICAPPED;
	}
	public void setHANDICAPPED(String handicapped) {
		HANDICAPPED = handicapped;
	}
	public String getMARITAL_STATUS() {
		return MARITAL_STATUS;
	}
	public void setMARITAL_STATUS(String marital_status) {
		MARITAL_STATUS = marital_status;
	}
	public Date getNOMINATION_DATE() {
		return NOMINATION_DATE;
	}
	public void setNOMINATION_DATE(Date nomination_date) {
		NOMINATION_DATE = nomination_date;
	}
	public String getACTIVE_STATUS() {
		return ACTIVE_STATUS;
	}
	public void setACTIVE_STATUS(String active_status) {
		ACTIVE_STATUS = active_status;
	}
	public String getREASON() {
		return REASON;
	}
	public void setREASON(String reason) {
		REASON = reason;
	}
	
	
}
