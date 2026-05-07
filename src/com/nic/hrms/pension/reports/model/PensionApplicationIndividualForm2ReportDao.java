package com.nic.hrms.pension.reports.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PensionApplicationIndividualForm2ReportDao implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal EMP_NO;	
	private String EMP_NAME;	
	private String GENDER;	
	private BigDecimal DESIG_SERVICE_GRP;	
	private BigDecimal DESIG_ID;	
	private String GRADE;	
	private BigDecimal OFFICE_ID;	
	private BigDecimal GPF_NO;
	private String FATHER_NAME;
	private String HUSBAND_NAME;
	private String RELIGION;
	private String NATIONALITY;
	private String EMP_HEIGHT;
	private String ID_MARK1;
	private String ID_MARK2;
	private String PRESENT_ADDRESS;
	private String PERMANENT_ADDRESS;
	private String ADDRESS_AFTER_RETIRE;
	private BigDecimal STATE;
	private String CHARGES_FLAG;
	private String CHARGES_DETAILS;
	private BigDecimal PAYMENT_OFFICE_ID;
	private Date APPLICATION_DATE;
	private String DCRG_NOMINEE_NAME;
	private Date DCRG_NOMINEE_DOB;
	private String DCRG_NOMINEE_RELATION;
	private String DCRG_NOMINEE_ADDRESS;
	private BigDecimal NOT_VERIFY_SERVICE_TOT_YEARS;
	private BigDecimal NOT_VERIFY_SERVICE_TOT_MONTHS;
	private BigDecimal NOT_VERIFY_SERVICE_TOT_DAYS;
	private String DESIGNATION;
	private String OFFICE_NAME;
	private String PAY_OFFICE_NAME;
	private String STATE_NAME;

	
	public String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(String designation) {
		DESIGNATION = designation;
	}
	public String getOFFICE_NAME() {
		return OFFICE_NAME;
	}
	public void setOFFICE_NAME(String office_name) {
		OFFICE_NAME = office_name;
	}
	public BigDecimal getEMP_NO() {
		return EMP_NO;
	}
	public void setEMP_NO(BigDecimal emp_no) {
		EMP_NO = emp_no;
	}
	public String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(String emp_name) {
		EMP_NAME = emp_name;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gender) {
		GENDER = gender;
	}
	public BigDecimal getDESIG_SERVICE_GRP() {
		return DESIG_SERVICE_GRP;
	}
	public void setDESIG_SERVICE_GRP(BigDecimal desig_service_grp) {
		DESIG_SERVICE_GRP = desig_service_grp;
	}
	public BigDecimal getDESIG_ID() {
		return DESIG_ID;
	}
	public void setDESIG_ID(BigDecimal desig_id) {
		DESIG_ID = desig_id;
	}
	public String getGRADE() {
		return GRADE;
	}
	public void setGRADE(String grade) {
		GRADE = grade;
	}
	public BigDecimal getOFFICE_ID() {
		return OFFICE_ID;
	}
	public void setOFFICE_ID(BigDecimal office_id) {
		OFFICE_ID = office_id;
	}
	public BigDecimal getGPF_NO() {
		return GPF_NO;
	}
	public void setGPF_NO(BigDecimal gpf_no) {
		GPF_NO = gpf_no;
	}
	public String getFATHER_NAME() {
		return FATHER_NAME;
	}
	public void setFATHER_NAME(String father_name) {
		FATHER_NAME = father_name;
	}
	public String getHUSBAND_NAME() {
		return HUSBAND_NAME;
	}
	public void setHUSBAND_NAME(String husband_name) {
		HUSBAND_NAME = husband_name;
	}
	public String getRELIGION() {
		return RELIGION;
	}
	public void setRELIGION(String religion) {
		RELIGION = religion;
	}
	public String getNATIONALITY() {
		return NATIONALITY;
	}
	public void setNATIONALITY(String nationality) {
		NATIONALITY = nationality;
	}
	public String getEMP_HEIGHT() {
		return EMP_HEIGHT;
	}
	public void setEMP_HEIGHT(String emp_height) {
		EMP_HEIGHT = emp_height;
	}
	public String getID_MARK1() {
		return ID_MARK1;
	}
	public void setID_MARK1(String id_mark1) {
		ID_MARK1 = id_mark1;
	}
	public String getID_MARK2() {
		return ID_MARK2;
	}
	public void setID_MARK2(String id_mark2) {
		ID_MARK2 = id_mark2;
	}
	public String getPRESENT_ADDRESS() {
		return PRESENT_ADDRESS;
	}
	public void setPRESENT_ADDRESS(String present_address) {
		PRESENT_ADDRESS = present_address;
	}
	public String getPERMANENT_ADDRESS() {
		return PERMANENT_ADDRESS;
	}
	public void setPERMANENT_ADDRESS(String permanent_address) {
		PERMANENT_ADDRESS = permanent_address;
	}
	public String getADDRESS_AFTER_RETIRE() {
		return ADDRESS_AFTER_RETIRE;
	}
	public void setADDRESS_AFTER_RETIRE(String address_after_retire) {
		ADDRESS_AFTER_RETIRE = address_after_retire;
	}
	public BigDecimal getSTATE() {
		return STATE;
	}
	public void setSTATE(BigDecimal state) {
		STATE = state;
	}
	public String getCHARGES_FLAG() {
		return CHARGES_FLAG;
	}
	public void setCHARGES_FLAG(String charges_flag) {
		CHARGES_FLAG = charges_flag;
	}
	public String getCHARGES_DETAILS() {
		return CHARGES_DETAILS;
	}
	public void setCHARGES_DETAILS(String charges_details) {
		CHARGES_DETAILS = charges_details;
	}
	public BigDecimal getPAYMENT_OFFICE_ID() {
		return PAYMENT_OFFICE_ID;
	}
	public void setPAYMENT_OFFICE_ID(BigDecimal payment_office_id) {
		PAYMENT_OFFICE_ID = payment_office_id;
	}
	
	public String getDCRG_NOMINEE_NAME() {
		return DCRG_NOMINEE_NAME;
	}
	public void setDCRG_NOMINEE_NAME(String dcrg_nominee_name) {
		DCRG_NOMINEE_NAME = dcrg_nominee_name;
	}
	
	public Date getAPPLICATION_DATE() {
		return APPLICATION_DATE;
	}
	public void setAPPLICATION_DATE(Date application_date) {
		APPLICATION_DATE = application_date;
	}
	public Date getDCRG_NOMINEE_DOB() {
		return DCRG_NOMINEE_DOB;
	}
	public void setDCRG_NOMINEE_DOB(Date dcrg_nominee_dob) {
		DCRG_NOMINEE_DOB = dcrg_nominee_dob;
	}
	public String getDCRG_NOMINEE_RELATION() {
		return DCRG_NOMINEE_RELATION;
	}
	public void setDCRG_NOMINEE_RELATION(String dcrg_nominee_relation) {
		DCRG_NOMINEE_RELATION = dcrg_nominee_relation;
	}
	public String getDCRG_NOMINEE_ADDRESS() {
		return DCRG_NOMINEE_ADDRESS;
	}
	public void setDCRG_NOMINEE_ADDRESS(String dcrg_nominee_address) {
		DCRG_NOMINEE_ADDRESS = dcrg_nominee_address;
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
	public void setPAY_OFFICE_NAME(String pAY_OFFICE_NAME) {
		PAY_OFFICE_NAME = pAY_OFFICE_NAME;
	}
	public String getPAY_OFFICE_NAME() {
		return PAY_OFFICE_NAME;
	}
	public void setSTATE_NAME(String sTATE_NAME) {
		STATE_NAME = sTATE_NAME;
	}
	public String getSTATE_NAME() {
		return STATE_NAME;
	}
	
	


	
	
}
