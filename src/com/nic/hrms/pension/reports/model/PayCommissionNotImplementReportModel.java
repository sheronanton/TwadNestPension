package com.nic.hrms.pension.reports.model;

import java.io.Serializable;

public class PayCommissionNotImplementReportModel implements Serializable
{
	java.lang.Integer SNO;
	java.math.BigDecimal EMPLOYEE_ID;
	java.lang.String CDATE;
	java.math.BigDecimal PPO_NO;
	//java.lang.String FPENSIONER_NAME;
	java.math.BigDecimal FSF_AMOUNT;
	java.lang.String pen_flag;
	java.lang.String OFFICE_NAME;
	java.math.BigDecimal OFFICE_ID;
	java.lang.String PENSIONER_NAME;
	java.lang.String PENSIONER;
	java.lang.String PENSIONERLAB;
	java.lang.String DATE_OF_RETIREMENT;
	java.util.Date DOB;
	
	public java.lang.Integer getSNO() {
		return SNO;
	}
	public void setSNO(java.lang.Integer sno) {
		SNO = sno;
	}
	public java.math.BigDecimal getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(java.math.BigDecimal employee_id) {
		EMPLOYEE_ID = employee_id;
	}
	public java.lang.String getCDATE() {
		return CDATE;
	}
	public void setCDATE(java.lang.String cdate) {
		CDATE = cdate;
	}
	public java.math.BigDecimal getPPO_NO() {
		return PPO_NO;
	}
	public void setPPO_NO(java.math.BigDecimal ppo_no) {
		PPO_NO = ppo_no;
	}
	
	public java.math.BigDecimal getFSF_AMOUNT() {
		return FSF_AMOUNT;
	}
	public void setFSF_AMOUNT(java.math.BigDecimal fsf_amount) {
		FSF_AMOUNT = fsf_amount;
	}
	public java.lang.String getPen_flag() {
		return pen_flag;
	}
	public void setPen_flag(java.lang.String pen_flag) {
		this.pen_flag = pen_flag;
	}
	public java.lang.String getOFFICE_NAME() {
		return OFFICE_NAME;
	}
	public void setOFFICE_NAME(java.lang.String office_name) {
		OFFICE_NAME = office_name;
	}
	public java.math.BigDecimal getOFFICE_ID() {
		return OFFICE_ID;
	}
	public void setOFFICE_ID(java.math.BigDecimal office_id) {
		OFFICE_ID = office_id;
	}
	public java.lang.String getPENSIONER_NAME() {
		return PENSIONER_NAME;
	}
	public void setPENSIONER_NAME(java.lang.String pensioner_name) {
		PENSIONER_NAME = pensioner_name;
	}
	public java.lang.String getPENSIONER() {
		return PENSIONER;
	}
	public void setPENSIONER(java.lang.String pensioner) {
		PENSIONER = pensioner;
	}
	public java.lang.String getDATE_OF_RETIREMENT() {
		return DATE_OF_RETIREMENT;
	}
	public void setDATE_OF_RETIREMENT(java.lang.String date_of_retirement) {
		DATE_OF_RETIREMENT = date_of_retirement;
	}
	public java.util.Date getDOB() {
		return DOB;
	}
	public void setDOB(java.util.Date dob) {
		DOB = dob;
	}
	public java.lang.String getPENSIONERLAB() {
		return PENSIONERLAB;
	}
	public void setPENSIONERLAB(java.lang.String pensionerlab) {
		PENSIONERLAB = pensionerlab;
	}
	
	
	
}
