package com.nic.hrms.pension.reports.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PensionApplicationFieldOfficeNotVerServForm2 implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal ID;
	private BigDecimal EMP_NO;
	private BigDecimal NOT_VERIFY_YEARS;
	private BigDecimal NOT_VERIFY_MONTHS;
	private BigDecimal NOT_VERIFY_DAYS;	
	private Date START_DATE;
	private Date END_DATE;	
	private String REASON;
	
	private BigDecimal NOT_VERIFY_SERVICE_TOT_YEARS;
	private BigDecimal NOT_VERIFY_SERVICE_TOT_MONTHS;
	private BigDecimal NOT_VERIFY_SERVICE_TOT_DAYS;
	
	public BigDecimal getID() {
		return ID;
	}
	public void setID(BigDecimal id) {
		ID = id;
	}
	public BigDecimal getEMP_NO() {
		return EMP_NO;
	}
	public void setEMP_NO(BigDecimal emp_no) {
		EMP_NO = emp_no;
	}
	public BigDecimal getNOT_VERIFY_YEARS() {
		return NOT_VERIFY_YEARS;
	}
	public void setNOT_VERIFY_YEARS(BigDecimal not_verify_years) {
		NOT_VERIFY_YEARS = not_verify_years;
	}
	public BigDecimal getNOT_VERIFY_MONTHS() {
		return NOT_VERIFY_MONTHS;
	}
	public void setNOT_VERIFY_MONTHS(BigDecimal not_verify_months) {
		NOT_VERIFY_MONTHS = not_verify_months;
	}
	public BigDecimal getNOT_VERIFY_DAYS() {
		return NOT_VERIFY_DAYS;
	}
	public void setNOT_VERIFY_DAYS(BigDecimal not_verify_days) {
		NOT_VERIFY_DAYS = not_verify_days;
	}
	public Date getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(Date start_date) {
		START_DATE = start_date;
	}
	public Date getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(Date end_date) {
		END_DATE = end_date;
	}
	public String getREASON() {
		return REASON;
	}
	public void setREASON(String reason) {
		REASON = reason;
	}
	public BigDecimal getNOT_VERIFY_SERVICE_TOT_YEARS() {
		return NOT_VERIFY_SERVICE_TOT_YEARS;
	}
	public void setNOT_VERIFY_SERVICE_TOT_YEARS(
			BigDecimal not_verify_service_tot_years) {
		NOT_VERIFY_SERVICE_TOT_YEARS = not_verify_service_tot_years;
	}
	public BigDecimal getNOT_VERIFY_SERVICE_TOT_MONTHS() {
		return NOT_VERIFY_SERVICE_TOT_MONTHS;
	}
	public void setNOT_VERIFY_SERVICE_TOT_MONTHS(
			BigDecimal not_verify_service_tot_months) {
		NOT_VERIFY_SERVICE_TOT_MONTHS = not_verify_service_tot_months;
	}
	public BigDecimal getNOT_VERIFY_SERVICE_TOT_DAYS() {
		return NOT_VERIFY_SERVICE_TOT_DAYS;
	}
	public void setNOT_VERIFY_SERVICE_TOT_DAYS(
			BigDecimal not_verify_service_tot_days) {
		NOT_VERIFY_SERVICE_TOT_DAYS = not_verify_service_tot_days;
	}
	
	


}
