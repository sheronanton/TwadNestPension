package com.nic.hrms.pension.reports.model;

import java.io.Serializable;

public class pensionForm1CalcValDetailsDeathDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5838908475144013991L;
	java.math.BigDecimal EMP_ID;
	java.math.BigDecimal OFFICE_ID;
	java.math.BigDecimal PENSION_TYPE;
	java.lang.String EMP_INITIAL;
	java.lang.String EMP_NAME;
	java.lang.String DESIGNATION_NAME;
	
	java.math.BigDecimal DESIG_SERVICE_GRP;
	 java.math.BigDecimal DESIGNATION_ID;
	 java.util.Date DATE_OF_BIRTH;
	 java.util.Date DATE_OF_APP;
	 java.util.Date DATE_OF_PROVINC;
	 java.util.Date DATE_OF_REG_ESTAB;
	 java.util.Date DATE_OF_SELECTION;
	 java.util.Date DATE_OF_SPECIAL;
	 java.util.Date DATE_OF_RETIRE;
	 java.util.Date DATE_OF_VRS;
	 java.lang.String COMM_OPTED;
	 java.lang.String COMM_FACTOR_ONRTHIRD;
	 java.math.BigDecimal COM_FACTOR_PERT;
	 
	 /*java.math.BigDecimal WCE_SERV_DAYS;
	 java.math.BigDecimal WCE_SERV_MONTH;
	 java.math.BigDecimal WCE_SERV_YEAR;*/
	java.lang.String WCE_SERV_DAYS;
	 java.lang.String WCE_SERV_MONTH;
	 java.lang.String WCE_SERV_YEAR;
	 java.lang.String WCE_SERV_FLAG;
	 java.lang.String WCE_SERV_COUNT_FLAG;
	 
	 java.lang.String CONTINGENT_SERV_FLAG;
	 /*java.math.BigDecimal CONTINGENT_SERV_DAYS;	 
	 java.math.BigDecimal CONTINGENT_SERV_MONTH;
	 java.math.BigDecimal CONTINGENT_SERV_YEAR;*/
	 
	 java.lang.String CONTINGENT_SERV_DAYS;	 
	 java.lang.String CONTINGENT_SERV_MONTH;
	 java.lang.String CONTINGENT_SERV_YEAR;
	 
	 java.lang.String WEIGHTAGE_SERV_DAYS;	 
	 java.lang.String WEIGHTAGE_SERV_MONTH;
	 java.lang.String WEIGHTAGE_SERV_YEAR;
	 java.lang.String WEIGHTAGELABLE;
	 
	 java.math.BigDecimal NON_PROV_SERV_DAYS;
	 java.math.BigDecimal NON_PROV_SERV_MONTH;
	 java.math.BigDecimal NON_PROV_SERV_YEAR;
	 java.math.BigDecimal EOL_DAYS;
	 java.math.BigDecimal EOL_MONTH;
	 java.math.BigDecimal EOL_YEAR;
	 java.math.BigDecimal SUSPENSION_DAYS;
	 java.math.BigDecimal SUSPENSION_MONTH;
	 java.math.BigDecimal SUSPENSION_YEAR;
	 java.math.BigDecimal BOY_SERV_DAYS;
	 java.math.BigDecimal BOY_SERV_MONTH;
	 java.math.BigDecimal BOY_SERV_YEAR;
	 java.math.BigDecimal OVERSTAY_LEAVE_DAYS;
	 java.math.BigDecimal OVERSTAY_LEAVE_MONTH;
	 java.math.BigDecimal OVERSTAY_LEAVE_YEAR;
	 java.math.BigDecimal NOT_REG_LEAVE_DAYS;
	 java.math.BigDecimal NOT_REG_LEAVE_MONTH;
	 java.math.BigDecimal NOT_REG_LEAVE_YEAR;
	 java.math.BigDecimal APPRENTICE_DAYS;
	 java.math.BigDecimal APPRENTICE_MONTH;
	 java.math.BigDecimal APPRENTICE_YEAR;
	 java.math.BigDecimal NOT_SERV_VERIFY_DAYS;
	 java.math.BigDecimal NOT_SERV_VERIFY_MONTH;
	 java.math.BigDecimal NOT_SERV_VERIFY_YEAR;
	 java.math.BigDecimal FOREIGN_SERV_DAYS;
	 java.math.BigDecimal FOREIGN_SERV_MONTH;
	 java.math.BigDecimal FOREIGN_SERV_YEAR;
	 java.util.Date ACTUAL_RET_DATE;
	 java.lang.String RETIREMENT_LABLE;
	 java.lang.String SUBJECT_CONTENT;
	 
	 java.lang.String DCRG_RECOVERIES;
	 java.lang.String NET_DCRG;
	 
	 /*java.math.BigDecimal LAST_BASIC_PAY;
	 java.math.BigDecimal LAST_SPECIAL_PAY;
	 java.math.BigDecimal LAST_GRADE_PAY;
	 java.math.BigDecimal LAST_OTHER_PAY1;
	 java.math.BigDecimal LAST_OTHER_PAY2;
	 java.math.BigDecimal LAST_OTHER_PAY3;*/
	 
	 
	 java.lang.String LAST_BASIC_PAY;
	 java.lang.String LAST_SPECIAL_PAY;
	 java.lang.String LAST_GRADE_PAY;
	 java.lang.String LAST_OTHER_PAY1;
	 java.lang.String LAST_OTHER_PAY2;
	 java.lang.String LAST_OTHER_PAY3;
	 
	 
	 java.math.BigDecimal PENSION_AMOUNT;
	 java.math.BigDecimal DCRG_AMOUNT;
	 java.math.BigDecimal NO_OF_HALFYEAR_PENSION;
	 java.math.BigDecimal NO_OF_HALFYEAR_DCRG;
	 java.math.BigDecimal TOTAL_COMMUTED_AMOUNT;
	 java.math.BigDecimal REDUCED_PENSION_AMOUNT;
	 java.math.BigDecimal FAMILY_PENSION_50_AMT;
	 java.math.BigDecimal FAMILY_PENSION_30_AMT;
	 java.math.BigDecimal LPD;
	 java.math.BigDecimal COMMUTEDAMOUNT;
	 java.math.BigDecimal COMMUTEDVAL;
	 java.math.BigDecimal DAMOUNT;	 
	 
	 java.math.BigDecimal ACTUALSERVICEYEAR;
	 java.math.BigDecimal ACTUALSERVICEMONTH;
	 java.math.BigDecimal ACTUALSERVICEDAYS;	 
	 
	 java.math.BigDecimal NONQUALSERVICEYEAR;
	 java.math.BigDecimal NONQUALSERVICEMONTH;
	 java.math.BigDecimal NONQUALSERVICEDAYS;
	
	 java.math.BigDecimal NETQUALSERVICEYEAR;
	 java.math.BigDecimal NETQUALSERVICEMONTH;
	 java.math.BigDecimal NETQUALSERVICEDAYS;
	
	 java.lang.String WCESERVICELABLE;
	 java.lang.String CONTSERVICELABLE;
	 java.lang.String SCALEOFPAY;
	 java.lang.String TYPEOFPENSION;
	 
	 java.lang.String LASTBASICLABLE;
	 java.lang.String LASTGRADELABLE;
	 java.lang.String LASTSPECIALLABLE;
	 java.lang.String LASTOTHER1LABLE;
	 java.lang.String LASTOTHER2LABLE;
	 java.lang.String LASTOTHER3LABLE;
	 
	 java.util.Date FAM_UPTO_DATE;
	 java.util.Date FAM_AFTER_DATE;
	 java.math.BigDecimal LASTPAYDRAWNAMOUNT;
	 
	 java.math.BigDecimal DAPERCENTAGE;
	 java.math.BigDecimal AVGEMOULMENTSAMOUNT;
	 java.math.BigDecimal RECOVERYAMOUNT;
	 
	 java.lang.String AVGBASICLABLE;
	 java.lang.String AVGGRADELABLE;
	 java.lang.String AVGSPECIALLABLE;
	 java.lang.String AVGOTHER1LABLE;
	 java.lang.String AVGOTHER2LABLE;
	 java.lang.String AVGOTHER3LABLE;
	 
	 
	 java.lang.String DCRGRECAMTLABLE;
	 java.lang.String DCRGDISAMT;
	 java.lang.String DCRGDISMINUSLABLE;
	 java.lang.String RECAMOUNTDIS;
	 java.lang.String DCRGAMOUNTEQUALLABLE;
	 java.lang.String DCRGRECFINALDISAMT;
	 
	 
	 java.lang.String COMMURECAMTLABLE;
	 java.lang.String COMMUDISAMT;
	 java.lang.String COMMUDISMINUSLABLE;
	 java.lang.String COMMURECAMOUNTDIS;
	 java.lang.String COMMUAMOUNTEQUALLABLE;
	 java.lang.String COMMURECFINALDISAMT;
	 
	 
	
	   java.math.BigDecimal AVG_ID;
	   java.lang.String NOT_CONSIDERED;
	   java.util.Date DATE_FROM;
	   java.util.Date DATE_TO;
	   java.math.BigDecimal TOT_MONTHS;
	   java.math.BigDecimal TOT_DAYS; 
	   /*java.math.BigDecimal BASIC_PAY;
	   java.math.BigDecimal GRADE_PAY;
	   java.math.BigDecimal SPECIAL_PAY;
	   java.math.BigDecimal OTHER1_PAY;
	   java.math.BigDecimal OTHER2_PAY;
	   java.math.BigDecimal OTHER3_PAY;*/
	   java.lang.String BASIC_PAY;
	   java.lang.String GRADE_PAY;
	   java.lang.String SPECIAL_PAY;
	   java.lang.String OTHER1_PAY;
	   java.lang.String OTHER2_PAY;
	   java.lang.String OTHER3_PAY;
	   java.math.BigDecimal PROP_PAY;
	   java.math.BigDecimal AVGPAYDRWAN;
	   
	   
	   
	   java.math.BigDecimal REC_ID;
	   java.lang.String REC_DESC;
	   java.math.BigDecimal REC_AMOUNT;
	   java.math.BigDecimal RECOVERY_TOTAL_AMOUNT;
	   
	   java.lang.String RESTRICT_ORG_PEN;
	   java.math.BigDecimal MAX_PEN_HALF_YR;
	   java.lang.String VRS_FAM_PEN_TEXT;	   
	   java.lang.String FAM_UPTO_DATE_TEXT;
	   java.lang.String FAM_AFTER_DATE_TEXT;
	   java.lang.String RESTRICT_PENSION_TEXT;
	   
	   
	   java.lang.String DCRG_TITLE_LABLE;
	   java.lang.String DCRG_AMOUNT_LABLE;
	   
	   
	   /*Other DepartmentService */

       java.lang.String OTHDEPTSERVICE;
	   java.lang.String OTHDEPTYEAR;
	   java.lang.String OTHDEPTMONTH;
	   java.lang.String OTHDEPTDAY;
	   
	    java.util.Date DATE_OF_JOINING;
		java.util.Date DATE_OF_RELIEVING;
		java.math.BigDecimal TOT_YEAR_SERVICE;
		java.math.BigDecimal TOT_MONTH_SERVICE;
		java.math.BigDecimal TOT_DAY_SERVICE;
		java.lang.String DEPATMENT_NAME;
		java.lang.String REMARKS;
		java.lang.String SUBJECT_CONTENT1;
		java.lang.String SUBJECT_CONTENT5;
	
	
	public java.lang.String getSUBJECT_CONTENT1() {
			return SUBJECT_CONTENT1;
		}
		public void setSUBJECT_CONTENT1(java.lang.String subject_content1) {
			SUBJECT_CONTENT1 = subject_content1;
		}
	public java.math.BigDecimal getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(java.math.BigDecimal emp_id) {
		EMP_ID = emp_id;
	}
	public java.math.BigDecimal getOFFICE_ID() {
		return OFFICE_ID;
	}
	public void setOFFICE_ID(java.math.BigDecimal office_id) {
		OFFICE_ID = office_id;
	}
	public java.math.BigDecimal getPENSION_TYPE() {
		return PENSION_TYPE;
	}
	public void setPENSION_TYPE(java.math.BigDecimal pension_type) {
		PENSION_TYPE = pension_type;
	}
	public java.lang.String getEMP_INITIAL() {
		return EMP_INITIAL;
	}
	public void setEMP_INITIAL(java.lang.String emp_initial) {
		EMP_INITIAL = emp_initial;
	}
	public java.lang.String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(java.lang.String emp_name) {
		EMP_NAME = emp_name;
	}
	
	public java.lang.String getDESIGNATION_NAME() {
		return DESIGNATION_NAME;
	}
	public void setDESIGNATION_NAME(java.lang.String designation_name) {
		DESIGNATION_NAME = designation_name;
	}
	public java.math.BigDecimal getDESIG_SERVICE_GRP() {
		return DESIG_SERVICE_GRP;
	}
	public void setDESIG_SERVICE_GRP(java.math.BigDecimal desig_service_grp) {
		DESIG_SERVICE_GRP = desig_service_grp;
	}
	public java.math.BigDecimal getDESIGNATION_ID() {
		return DESIGNATION_ID;
	}
	public void setDESIGNATION_ID(java.math.BigDecimal designation_id) {
		DESIGNATION_ID = designation_id;
	}
	public java.util.Date getDATE_OF_BIRTH() {
		return DATE_OF_BIRTH;
	}
	public void setDATE_OF_BIRTH(java.util.Date date_of_birth) {
		DATE_OF_BIRTH = date_of_birth;
	}
	public java.util.Date getDATE_OF_APP() {
		return DATE_OF_APP;
	}
	public void setDATE_OF_APP(java.util.Date date_of_app) {
		DATE_OF_APP = date_of_app;
	}
	public java.util.Date getDATE_OF_PROVINC() {
		return DATE_OF_PROVINC;
	}
	public void setDATE_OF_PROVINC(java.util.Date date_of_provinc) {
		DATE_OF_PROVINC = date_of_provinc;
	}
	public java.util.Date getDATE_OF_REG_ESTAB() {
		return DATE_OF_REG_ESTAB;
	}
	public void setDATE_OF_REG_ESTAB(java.util.Date date_of_reg_estab) {
		DATE_OF_REG_ESTAB = date_of_reg_estab;
	}
	public java.util.Date getDATE_OF_SELECTION() {
		return DATE_OF_SELECTION;
	}
	public void setDATE_OF_SELECTION(java.util.Date date_of_selection) {
		DATE_OF_SELECTION = date_of_selection;
	}
	public java.util.Date getDATE_OF_SPECIAL() {
		return DATE_OF_SPECIAL;
	}
	public void setDATE_OF_SPECIAL(java.util.Date date_of_special) {
		DATE_OF_SPECIAL = date_of_special;
	}
	public java.util.Date getDATE_OF_RETIRE() {
		return DATE_OF_RETIRE;
	}
	public void setDATE_OF_RETIRE(java.util.Date date_of_retire) {
		DATE_OF_RETIRE = date_of_retire;
	}
	public java.util.Date getDATE_OF_VRS() {
		return DATE_OF_VRS;
	}
	public void setDATE_OF_VRS(java.util.Date date_of_vrs) {
		DATE_OF_VRS = date_of_vrs;
	}
	public java.lang.String getCOMM_OPTED() {
		return COMM_OPTED;
	}
	public void setCOMM_OPTED(java.lang.String comm_opted) {
		COMM_OPTED = comm_opted;
	}
	public java.lang.String getCOMM_FACTOR_ONRTHIRD() {
		return COMM_FACTOR_ONRTHIRD;
	}
	public void setCOMM_FACTOR_ONRTHIRD(java.lang.String comm_factor_onrthird) {
		COMM_FACTOR_ONRTHIRD = comm_factor_onrthird;
	}
	public java.math.BigDecimal getCOM_FACTOR_PERT() {
		return COM_FACTOR_PERT;
	}
	public void setCOM_FACTOR_PERT(java.math.BigDecimal com_factor_pert) {
		COM_FACTOR_PERT = com_factor_pert;
	}
	/*public java.math.BigDecimal getWCE_SERV_DAYS() {
		return WCE_SERV_DAYS;
	}
	public void setWCE_SERV_DAYS(java.math.BigDecimal wce_serv_days) {
		WCE_SERV_DAYS = wce_serv_days;
	}
	public java.math.BigDecimal getWCE_SERV_MONTH() {
		return WCE_SERV_MONTH;
	}
	public void setWCE_SERV_MONTH(java.math.BigDecimal wce_serv_month) {
		WCE_SERV_MONTH = wce_serv_month;
	}
	public java.math.BigDecimal getWCE_SERV_YEAR() {
		return WCE_SERV_YEAR;
	}
	public void setWCE_SERV_YEAR(java.math.BigDecimal wce_serv_year) {
		WCE_SERV_YEAR = wce_serv_year;
	}*/
	public java.lang.String getWCE_SERV_DAYS() {
	return WCE_SERV_DAYS;
	}
	public void setWCE_SERV_DAYS(java.lang.String wce_serv_days) {
		WCE_SERV_DAYS = wce_serv_days;
	}
	public java.lang.String getWCE_SERV_MONTH() {
		return WCE_SERV_MONTH;
	}
	public void setWCE_SERV_MONTH(java.lang.String wce_serv_month) {
		WCE_SERV_MONTH = wce_serv_month;
	}
	public java.lang.String getWCE_SERV_YEAR() {
		return WCE_SERV_YEAR;
	}
	public void setWCE_SERV_YEAR(java.lang.String wce_serv_year) {
		WCE_SERV_YEAR = wce_serv_year;
	}
	public java.lang.String getWCE_SERV_FLAG() {
		return WCE_SERV_FLAG;
	}
	
	public void setWCE_SERV_FLAG(java.lang.String wce_serv_flag) {
		WCE_SERV_FLAG = wce_serv_flag;
	}
	public java.lang.String getWCE_SERV_COUNT_FLAG() {
		return WCE_SERV_COUNT_FLAG;
	}
	public void setWCE_SERV_COUNT_FLAG(java.lang.String wce_serv_count_flag) {
		WCE_SERV_COUNT_FLAG = wce_serv_count_flag;
	}
	public java.lang.String getCONTINGENT_SERV_FLAG() {
		return CONTINGENT_SERV_FLAG;
	}
	public void setCONTINGENT_SERV_FLAG(java.lang.String contingent_serv_flag) {
		CONTINGENT_SERV_FLAG = contingent_serv_flag;
	}
	/*public java.math.BigDecimal getCONTINGENT_SERV_DAYS() {
		return CONTINGENT_SERV_DAYS;
	}
	public void setCONTINGENT_SERV_DAYS(java.math.BigDecimal contingent_serv_days) {
		CONTINGENT_SERV_DAYS = contingent_serv_days;
	}
	public java.math.BigDecimal getCONTINGENT_SERV_MONTH() {
		return CONTINGENT_SERV_MONTH;
	}
	public void setCONTINGENT_SERV_MONTH(java.math.BigDecimal contingent_serv_month) {
		CONTINGENT_SERV_MONTH = contingent_serv_month;
	}
	public java.math.BigDecimal getCONTINGENT_SERV_YEAR() {
		return CONTINGENT_SERV_YEAR;
	}
	public void setCONTINGENT_SERV_YEAR(java.math.BigDecimal contingent_serv_year) {
		CONTINGENT_SERV_YEAR = contingent_serv_year;
	}*/
	
	public java.math.BigDecimal getNON_PROV_SERV_DAYS() {
		return NON_PROV_SERV_DAYS;
	}
	public java.lang.String getCONTINGENT_SERV_DAYS() {
		return CONTINGENT_SERV_DAYS;
	}
	public void setCONTINGENT_SERV_DAYS(java.lang.String contingent_serv_days) {
		CONTINGENT_SERV_DAYS = contingent_serv_days;
	}
	public java.lang.String getCONTINGENT_SERV_MONTH() {
		return CONTINGENT_SERV_MONTH;
	}
	public void setCONTINGENT_SERV_MONTH(java.lang.String contingent_serv_month) {
		CONTINGENT_SERV_MONTH = contingent_serv_month;
	}
	public java.lang.String getCONTINGENT_SERV_YEAR() {
		return CONTINGENT_SERV_YEAR;
	}
	public void setCONTINGENT_SERV_YEAR(java.lang.String contingent_serv_year) {
		CONTINGENT_SERV_YEAR = contingent_serv_year;
	}
	
	
	
	
	
	public void setNON_PROV_SERV_DAYS(java.math.BigDecimal non_prov_serv_days) {
		NON_PROV_SERV_DAYS = non_prov_serv_days;
	}
	public java.math.BigDecimal getNON_PROV_SERV_MONTH() {
		return NON_PROV_SERV_MONTH;
	}
	public void setNON_PROV_SERV_MONTH(java.math.BigDecimal non_prov_serv_month) {
		NON_PROV_SERV_MONTH = non_prov_serv_month;
	}
	public java.math.BigDecimal getNON_PROV_SERV_YEAR() {
		return NON_PROV_SERV_YEAR;
	}
	public void setNON_PROV_SERV_YEAR(java.math.BigDecimal non_prov_serv_year) {
		NON_PROV_SERV_YEAR = non_prov_serv_year;
	}
	public java.math.BigDecimal getEOL_DAYS() {
		return EOL_DAYS;
	}
	public void setEOL_DAYS(java.math.BigDecimal eol_days) {
		EOL_DAYS = eol_days;
	}
	public java.math.BigDecimal getEOL_MONTH() {
		return EOL_MONTH;
	}
	public void setEOL_MONTH(java.math.BigDecimal eol_month) {
		EOL_MONTH = eol_month;
	}
	public java.math.BigDecimal getEOL_YEAR() {
		return EOL_YEAR;
	}
	public void setEOL_YEAR(java.math.BigDecimal eol_year) {
		EOL_YEAR = eol_year;
	}
	public java.math.BigDecimal getSUSPENSION_DAYS() {
		return SUSPENSION_DAYS;
	}
	public void setSUSPENSION_DAYS(java.math.BigDecimal suspension_days) {
		SUSPENSION_DAYS = suspension_days;
	}
	public java.math.BigDecimal getSUSPENSION_MONTH() {
		return SUSPENSION_MONTH;
	}
	public void setSUSPENSION_MONTH(java.math.BigDecimal suspension_month) {
		SUSPENSION_MONTH = suspension_month;
	}
	public java.math.BigDecimal getSUSPENSION_YEAR() {
		return SUSPENSION_YEAR;
	}
	public void setSUSPENSION_YEAR(java.math.BigDecimal suspension_year) {
		SUSPENSION_YEAR = suspension_year;
	}
	public java.math.BigDecimal getBOY_SERV_DAYS() {
		return BOY_SERV_DAYS;
	}
	public void setBOY_SERV_DAYS(java.math.BigDecimal boy_serv_days) {
		BOY_SERV_DAYS = boy_serv_days;
	}
	public java.math.BigDecimal getBOY_SERV_MONTH() {
		return BOY_SERV_MONTH;
	}
	public void setBOY_SERV_MONTH(java.math.BigDecimal boy_serv_month) {
		BOY_SERV_MONTH = boy_serv_month;
	}
	public java.math.BigDecimal getBOY_SERV_YEAR() {
		return BOY_SERV_YEAR;
	}
	public void setBOY_SERV_YEAR(java.math.BigDecimal boy_serv_year) {
		BOY_SERV_YEAR = boy_serv_year;
	}
	public java.math.BigDecimal getOVERSTAY_LEAVE_DAYS() {
		return OVERSTAY_LEAVE_DAYS;
	}
	public void setOVERSTAY_LEAVE_DAYS(java.math.BigDecimal overstay_leave_days) {
		OVERSTAY_LEAVE_DAYS = overstay_leave_days;
	}
	public java.math.BigDecimal getOVERSTAY_LEAVE_MONTH() {
		return OVERSTAY_LEAVE_MONTH;
	}
	public void setOVERSTAY_LEAVE_MONTH(java.math.BigDecimal overstay_leave_month) {
		OVERSTAY_LEAVE_MONTH = overstay_leave_month;
	}
	public java.math.BigDecimal getOVERSTAY_LEAVE_YEAR() {
		return OVERSTAY_LEAVE_YEAR;
	}
	public void setOVERSTAY_LEAVE_YEAR(java.math.BigDecimal overstay_leave_year) {
		OVERSTAY_LEAVE_YEAR = overstay_leave_year;
	}
	public java.math.BigDecimal getNOT_REG_LEAVE_DAYS() {
		return NOT_REG_LEAVE_DAYS;
	}
	public void setNOT_REG_LEAVE_DAYS(java.math.BigDecimal not_reg_leave_days) {
		NOT_REG_LEAVE_DAYS = not_reg_leave_days;
	}
	public java.math.BigDecimal getNOT_REG_LEAVE_MONTH() {
		return NOT_REG_LEAVE_MONTH;
	}
	public void setNOT_REG_LEAVE_MONTH(java.math.BigDecimal not_reg_leave_month) {
		NOT_REG_LEAVE_MONTH = not_reg_leave_month;
	}
	public java.math.BigDecimal getNOT_REG_LEAVE_YEAR() {
		return NOT_REG_LEAVE_YEAR;
	}
	public void setNOT_REG_LEAVE_YEAR(java.math.BigDecimal not_reg_leave_year) {
		NOT_REG_LEAVE_YEAR = not_reg_leave_year;
	}
	public java.math.BigDecimal getAPPRENTICE_DAYS() {
		return APPRENTICE_DAYS;
	}
	public void setAPPRENTICE_DAYS(java.math.BigDecimal apprentice_days) {
		APPRENTICE_DAYS = apprentice_days;
	}
	public java.math.BigDecimal getAPPRENTICE_MONTH() {
		return APPRENTICE_MONTH;
	}
	public void setAPPRENTICE_MONTH(java.math.BigDecimal apprentice_month) {
		APPRENTICE_MONTH = apprentice_month;
	}
	public java.math.BigDecimal getAPPRENTICE_YEAR() {
		return APPRENTICE_YEAR;
	}
	public void setAPPRENTICE_YEAR(java.math.BigDecimal apprentice_year) {
		APPRENTICE_YEAR = apprentice_year;
	}
	public java.math.BigDecimal getNOT_SERV_VERIFY_DAYS() {
		return NOT_SERV_VERIFY_DAYS;
	}
	public void setNOT_SERV_VERIFY_DAYS(java.math.BigDecimal not_serv_verify_days) {
		NOT_SERV_VERIFY_DAYS = not_serv_verify_days;
	}
	public java.math.BigDecimal getNOT_SERV_VERIFY_MONTH() {
		return NOT_SERV_VERIFY_MONTH;
	}
	public void setNOT_SERV_VERIFY_MONTH(java.math.BigDecimal not_serv_verify_month) {
		NOT_SERV_VERIFY_MONTH = not_serv_verify_month;
	}
	public java.math.BigDecimal getNOT_SERV_VERIFY_YEAR() {
		return NOT_SERV_VERIFY_YEAR;
	}
	public void setNOT_SERV_VERIFY_YEAR(java.math.BigDecimal not_serv_verify_year) {
		NOT_SERV_VERIFY_YEAR = not_serv_verify_year;
	}
	public java.math.BigDecimal getFOREIGN_SERV_DAYS() {
		return FOREIGN_SERV_DAYS;
	}
	public void setFOREIGN_SERV_DAYS(java.math.BigDecimal foreign_serv_days) {
		FOREIGN_SERV_DAYS = foreign_serv_days;
	}
	public java.math.BigDecimal getFOREIGN_SERV_MONTH() {
		return FOREIGN_SERV_MONTH;
	}
	public void setFOREIGN_SERV_MONTH(java.math.BigDecimal foreign_serv_month) {
		FOREIGN_SERV_MONTH = foreign_serv_month;
	}
	public java.math.BigDecimal getFOREIGN_SERV_YEAR() {
		return FOREIGN_SERV_YEAR;
	}
	public void setFOREIGN_SERV_YEAR(java.math.BigDecimal foreign_serv_year) {
		FOREIGN_SERV_YEAR = foreign_serv_year;
	}
	/*public java.math.BigDecimal getLAST_BASIC_PAY() {
		return LAST_BASIC_PAY;
	}
	public void setLAST_BASIC_PAY(java.math.BigDecimal last_basic_pay) {
		LAST_BASIC_PAY = last_basic_pay;
	}
	public java.math.BigDecimal getLAST_SPECIAL_PAY() {
		return LAST_SPECIAL_PAY;
	}
	public void setLAST_SPECIAL_PAY(java.math.BigDecimal last_special_pay) {
		LAST_SPECIAL_PAY = last_special_pay;
	}
	public java.math.BigDecimal getLAST_GRADE_PAY() {
		return LAST_GRADE_PAY;
	}
	public void setLAST_GRADE_PAY(java.math.BigDecimal last_grade_pay) {
		LAST_GRADE_PAY = last_grade_pay;
	}
	public java.math.BigDecimal getLAST_OTHER_PAY1() {
		return LAST_OTHER_PAY1;
	}
	public void setLAST_OTHER_PAY1(java.math.BigDecimal last_other_pay1) {
		LAST_OTHER_PAY1 = last_other_pay1;
	}
	public java.math.BigDecimal getLAST_OTHER_PAY2() {
		return LAST_OTHER_PAY2;
	}
	public void setLAST_OTHER_PAY2(java.math.BigDecimal last_other_pay2) {
		LAST_OTHER_PAY2 = last_other_pay2;
	}
	public java.math.BigDecimal getLAST_OTHER_PAY3() {
		return LAST_OTHER_PAY3;
	}
	public void setLAST_OTHER_PAY3(java.math.BigDecimal last_other_pay3) {
		LAST_OTHER_PAY3 = last_other_pay3;
	}*/
	
	
	public java.lang.String getLAST_BASIC_PAY() {
		return LAST_BASIC_PAY;
	}
	public void setLAST_BASIC_PAY(java.lang.String last_basic_pay) {
		LAST_BASIC_PAY = last_basic_pay;
	}
	public java.lang.String getLAST_SPECIAL_PAY() {
		return LAST_SPECIAL_PAY;
	}
	public void setLAST_SPECIAL_PAY(java.lang.String last_special_pay) {
		LAST_SPECIAL_PAY = last_special_pay;
	}
	public java.lang.String getLAST_GRADE_PAY() {
		return LAST_GRADE_PAY;
	}
	public void setLAST_GRADE_PAY(java.lang.String last_grade_pay) {
		LAST_GRADE_PAY = last_grade_pay;
	}
	public java.lang.String getLAST_OTHER_PAY1() {
		return LAST_OTHER_PAY1;
	}
	public void setLAST_OTHER_PAY1(java.lang.String last_other_pay1) {
		LAST_OTHER_PAY1 = last_other_pay1;
	}
	public java.lang.String getLAST_OTHER_PAY2() {
		return LAST_OTHER_PAY2;
	}
	public void setLAST_OTHER_PAY2(java.lang.String last_other_pay2) {
		LAST_OTHER_PAY2 = last_other_pay2;
	}
	public java.lang.String getLAST_OTHER_PAY3() {
		return LAST_OTHER_PAY3;
	}
	public void setLAST_OTHER_PAY3(java.lang.String last_other_pay3) {
		LAST_OTHER_PAY3 = last_other_pay3;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public java.math.BigDecimal getPENSION_AMOUNT() {
		return PENSION_AMOUNT;
	}	
	public void setPENSION_AMOUNT(java.math.BigDecimal pension_amount) {
		PENSION_AMOUNT = pension_amount;
	}
	public java.math.BigDecimal getDCRG_AMOUNT() {
		return DCRG_AMOUNT;
	}
	public void setDCRG_AMOUNT(java.math.BigDecimal dcrg_amount) {
		DCRG_AMOUNT = dcrg_amount;
	}
	public java.math.BigDecimal getNO_OF_HALFYEAR_PENSION() {
		return NO_OF_HALFYEAR_PENSION;
	}
	public void setNO_OF_HALFYEAR_PENSION(
			java.math.BigDecimal no_of_halfyear_pension) {
		NO_OF_HALFYEAR_PENSION = no_of_halfyear_pension;
	}
	public java.math.BigDecimal getNO_OF_HALFYEAR_DCRG() {
		return NO_OF_HALFYEAR_DCRG;
	}
	public void setNO_OF_HALFYEAR_DCRG(java.math.BigDecimal no_of_halfyear_dcrg) {
		NO_OF_HALFYEAR_DCRG = no_of_halfyear_dcrg;
	}
	public java.math.BigDecimal getTOTAL_COMMUTED_AMOUNT() {
		return TOTAL_COMMUTED_AMOUNT;
	}
	public void setTOTAL_COMMUTED_AMOUNT(java.math.BigDecimal total_commuted_amount) {
		TOTAL_COMMUTED_AMOUNT = total_commuted_amount;
	}
	public java.math.BigDecimal getREDUCED_PENSION_AMOUNT() {
		return REDUCED_PENSION_AMOUNT;
	}
	public void setREDUCED_PENSION_AMOUNT(
			java.math.BigDecimal reduced_pension_amount) {
		REDUCED_PENSION_AMOUNT = reduced_pension_amount;
	}
	public java.math.BigDecimal getFAMILY_PENSION_50_AMT() {
		return FAMILY_PENSION_50_AMT;
	}
	public void setFAMILY_PENSION_50_AMT(java.math.BigDecimal family_pension_50_amt) {
		FAMILY_PENSION_50_AMT = family_pension_50_amt;
	}
	public java.math.BigDecimal getFAMILY_PENSION_30_AMT() {
		return FAMILY_PENSION_30_AMT;
	}
	public void setFAMILY_PENSION_30_AMT(java.math.BigDecimal family_pension_30_amt) {
		FAMILY_PENSION_30_AMT = family_pension_30_amt;
	}
	public java.math.BigDecimal getLPD() {
		return LPD;
	}
	public void setLPD(java.math.BigDecimal lpd) {
		LPD = lpd;
	}
	public java.math.BigDecimal getCOMMUTEDAMOUNT() {
		return COMMUTEDAMOUNT;
	}
	public void setCOMMUTEDAMOUNT(java.math.BigDecimal commutedamount) {
		COMMUTEDAMOUNT = commutedamount;
	}
	
	public java.math.BigDecimal getCOMMUTEDVAL() {
		return COMMUTEDVAL;
	}
	public void setCOMMUTEDVAL(java.math.BigDecimal commutedval) {
		COMMUTEDVAL = commutedval;
	}
	public java.math.BigDecimal getDAMOUNT() {
		return DAMOUNT;
	}
	public void setDAMOUNT(java.math.BigDecimal damount) {
		DAMOUNT = damount;
	}	
	public java.math.BigDecimal getACTUALSERVICEYEAR() {
		return ACTUALSERVICEYEAR;
	}
	public void setACTUALSERVICEYEAR(java.math.BigDecimal actualserviceyear) {
		ACTUALSERVICEYEAR = actualserviceyear;
	}
	public java.math.BigDecimal getACTUALSERVICEMONTH() {
		return ACTUALSERVICEMONTH;
	}
	public void setACTUALSERVICEMONTH(java.math.BigDecimal actualservicemonth) {
		ACTUALSERVICEMONTH = actualservicemonth;
	}
	public java.math.BigDecimal getACTUALSERVICEDAYS() {
		return ACTUALSERVICEDAYS;
	}
	public void setACTUALSERVICEDAYS(java.math.BigDecimal actualservicedays) {
		ACTUALSERVICEDAYS = actualservicedays;
	}
	public java.math.BigDecimal getNONQUALSERVICEYEAR() {
		return NONQUALSERVICEYEAR;
	}
	public void setNONQUALSERVICEYEAR(java.math.BigDecimal nonqualserviceyear) {
		NONQUALSERVICEYEAR = nonqualserviceyear;
	}
	public java.math.BigDecimal getNONQUALSERVICEMONTH() {
		return NONQUALSERVICEMONTH;
	}
	public void setNONQUALSERVICEMONTH(java.math.BigDecimal nonqualservicemonth) {
		NONQUALSERVICEMONTH = nonqualservicemonth;
	}
	public java.math.BigDecimal getNONQUALSERVICEDAYS() {
		return NONQUALSERVICEDAYS;
	}
	public void setNONQUALSERVICEDAYS(java.math.BigDecimal nonqualservicedays) {
		NONQUALSERVICEDAYS = nonqualservicedays;
	}
	public java.math.BigDecimal getNETQUALSERVICEYEAR() {
		return NETQUALSERVICEYEAR;
	}
	public void setNETQUALSERVICEYEAR(java.math.BigDecimal netqualserviceyear) {
		NETQUALSERVICEYEAR = netqualserviceyear;
	}
	public java.math.BigDecimal getNETQUALSERVICEMONTH() {
		return NETQUALSERVICEMONTH;
	}
	public void setNETQUALSERVICEMONTH(java.math.BigDecimal netqualservicemonth) {
		NETQUALSERVICEMONTH = netqualservicemonth;
	}
	public java.math.BigDecimal getNETQUALSERVICEDAYS() {
		return NETQUALSERVICEDAYS;
	}
	public void setNETQUALSERVICEDAYS(java.math.BigDecimal netqualservicedays) {
		NETQUALSERVICEDAYS = netqualservicedays;
	}	
	public java.lang.String getWCESERVICELABLE() {
		return WCESERVICELABLE;
	}
	public void setWCESERVICELABLE(java.lang.String wceservicelable) {
		WCESERVICELABLE = wceservicelable;
	}
	
	public java.lang.String getCONTSERVICELABLE() {
		return CONTSERVICELABLE;
	}
	public void setCONTSERVICELABLE(java.lang.String contservicelable) {
		CONTSERVICELABLE = contservicelable;
	}
	public java.lang.String getSCALEOFPAY() {
		return SCALEOFPAY;
	}
	public void setSCALEOFPAY(java.lang.String scaleofpay) {
		SCALEOFPAY = scaleofpay;
	}	
	public java.lang.String getTYPEOFPENSION() {
		return TYPEOFPENSION;
	}
	public void setTYPEOFPENSION(java.lang.String typeofpension) {
		TYPEOFPENSION = typeofpension;
	}	
	public java.lang.String getWEIGHTAGE_SERV_DAYS() {
		return WEIGHTAGE_SERV_DAYS;
	}
	public void setWEIGHTAGE_SERV_DAYS(java.lang.String weightage_serv_days) {
		WEIGHTAGE_SERV_DAYS = weightage_serv_days;
	}
	public java.lang.String getWEIGHTAGE_SERV_MONTH() {
		return WEIGHTAGE_SERV_MONTH;
	}
	public void setWEIGHTAGE_SERV_MONTH(java.lang.String weightage_serv_month) {
		WEIGHTAGE_SERV_MONTH = weightage_serv_month;
	}
	public java.lang.String getWEIGHTAGE_SERV_YEAR() {
		return WEIGHTAGE_SERV_YEAR;
	}
	public void setWEIGHTAGE_SERV_YEAR(java.lang.String weightage_serv_year) {
		WEIGHTAGE_SERV_YEAR = weightage_serv_year;
	}
	public java.lang.String getWEIGHTAGELABLE() {
		return WEIGHTAGELABLE;
	}
	public void setWEIGHTAGELABLE(java.lang.String weightagelable) {
		WEIGHTAGELABLE = weightagelable;
	}	
	public java.lang.String getLASTBASICLABLE() {
		return LASTBASICLABLE;
	}
	public void setLASTBASICLABLE(java.lang.String lastbasiclable) {
		LASTBASICLABLE = lastbasiclable;
	}
	public java.lang.String getLASTGRADELABLE() {
		return LASTGRADELABLE;
	}
	public void setLASTGRADELABLE(java.lang.String lastgradelable) {
		LASTGRADELABLE = lastgradelable;
	}
	public java.lang.String getLASTSPECIALLABLE() {
		return LASTSPECIALLABLE;
	}
	public void setLASTSPECIALLABLE(java.lang.String lastspeciallable) {
		LASTSPECIALLABLE = lastspeciallable;
	}
	public java.lang.String getLASTOTHER1LABLE() {
		return LASTOTHER1LABLE;
	}
	public void setLASTOTHER1LABLE(java.lang.String lastother1lable) {
		LASTOTHER1LABLE = lastother1lable;
	}
	public java.lang.String getLASTOTHER2LABLE() {
		return LASTOTHER2LABLE;
	}
	public void setLASTOTHER2LABLE(java.lang.String lastother2lable) {
		LASTOTHER2LABLE = lastother2lable;
	}
	public java.lang.String getLASTOTHER3LABLE() {
		return LASTOTHER3LABLE;
	}
	public void setLASTOTHER3LABLE(java.lang.String lastother3lable) {
		LASTOTHER3LABLE = lastother3lable;
	}
	
	public java.util.Date getFAM_UPTO_DATE() {
		return FAM_UPTO_DATE;
	}
	public void setFAM_UPTO_DATE(java.util.Date fam_upto_date) {
		FAM_UPTO_DATE = fam_upto_date;
	}
	public java.util.Date getFAM_AFTER_DATE() {
		return FAM_AFTER_DATE;
	}
	public void setFAM_AFTER_DATE(java.util.Date fam_after_date) {
		FAM_AFTER_DATE = fam_after_date;
	}	
	public java.math.BigDecimal getLASTPAYDRAWNAMOUNT() {
		return LASTPAYDRAWNAMOUNT;
	}
	public void setLASTPAYDRAWNAMOUNT(java.math.BigDecimal lastpaydrawnamount) {
		LASTPAYDRAWNAMOUNT = lastpaydrawnamount;
	}	
	public java.math.BigDecimal getDAPERCENTAGE() {
		return DAPERCENTAGE;
	}
	public void setDAPERCENTAGE(java.math.BigDecimal dapercentage) {
		DAPERCENTAGE = dapercentage;
	}
	public java.math.BigDecimal getAVGEMOULMENTSAMOUNT() {
		return AVGEMOULMENTSAMOUNT;
	}
	public void setAVGEMOULMENTSAMOUNT(java.math.BigDecimal avgemoulmentsamount) {
		AVGEMOULMENTSAMOUNT = avgemoulmentsamount;
	}
	public java.math.BigDecimal getRECOVERYAMOUNT() {
		return RECOVERYAMOUNT;
	}
	public void setRECOVERYAMOUNT(java.math.BigDecimal recoveryamount) {
		RECOVERYAMOUNT = recoveryamount;
	}	
	
	public java.lang.String getDCRGRECAMTLABLE() {
		return DCRGRECAMTLABLE;
	}
	public void setDCRGRECAMTLABLE(java.lang.String dcrgrecamtlable) {
		DCRGRECAMTLABLE = dcrgrecamtlable;
	}
	public java.lang.String getDCRGDISAMT() {
		return DCRGDISAMT;
	}
	public void setDCRGDISAMT(java.lang.String dcrgdisamt) {
		DCRGDISAMT = dcrgdisamt;
	}
	public java.lang.String getDCRGDISMINUSLABLE() {
		return DCRGDISMINUSLABLE;
	}
	public void setDCRGDISMINUSLABLE(java.lang.String dcrgdisminuslable) {
		DCRGDISMINUSLABLE = dcrgdisminuslable;
	}
	public java.lang.String getRECAMOUNTDIS() {
		return RECAMOUNTDIS;
	}
	public void setRECAMOUNTDIS(java.lang.String recamountdis) {
		RECAMOUNTDIS = recamountdis;
	}
	public java.lang.String getDCRGAMOUNTEQUALLABLE() {
		return DCRGAMOUNTEQUALLABLE;
	}
	public void setDCRGAMOUNTEQUALLABLE(java.lang.String dcrgamountequallable) {
		DCRGAMOUNTEQUALLABLE = dcrgamountequallable;
	}
	public java.lang.String getDCRGRECFINALDISAMT() {
		return DCRGRECFINALDISAMT;
	}
	public void setDCRGRECFINALDISAMT(java.lang.String dcrgrecfinaldisamt) {
		DCRGRECFINALDISAMT = dcrgrecfinaldisamt;
	}
	public java.lang.String getCOMMURECAMTLABLE() {
		return COMMURECAMTLABLE;
	}
	public void setCOMMURECAMTLABLE(java.lang.String commurecamtlable) {
		COMMURECAMTLABLE = commurecamtlable;
	}
	public java.lang.String getCOMMUDISAMT() {
		return COMMUDISAMT;
	}
	public void setCOMMUDISAMT(java.lang.String commudisamt) {
		COMMUDISAMT = commudisamt;
	}
	public java.lang.String getCOMMUDISMINUSLABLE() {
		return COMMUDISMINUSLABLE;
	}
	public void setCOMMUDISMINUSLABLE(java.lang.String commudisminuslable) {
		COMMUDISMINUSLABLE = commudisminuslable;
	}
	public java.lang.String getCOMMURECAMOUNTDIS() {
		return COMMURECAMOUNTDIS;
	}
	public void setCOMMURECAMOUNTDIS(java.lang.String commurecamountdis) {
		COMMURECAMOUNTDIS = commurecamountdis;
	}
	public java.lang.String getCOMMUAMOUNTEQUALLABLE() {
		return COMMUAMOUNTEQUALLABLE;
	}
	public void setCOMMUAMOUNTEQUALLABLE(java.lang.String commuamountequallable) {
		COMMUAMOUNTEQUALLABLE = commuamountequallable;
	}
	public java.lang.String getCOMMURECFINALDISAMT() {
		return COMMURECFINALDISAMT;
	}
	public void setCOMMURECFINALDISAMT(java.lang.String commurecfinaldisamt) {
		COMMURECFINALDISAMT = commurecfinaldisamt;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	
	
	
	public java.math.BigDecimal getAVG_ID() {
		return AVG_ID;
	}
	public void setAVG_ID(java.math.BigDecimal avg_id) {
		AVG_ID = avg_id;
	}
	public java.lang.String getNOT_CONSIDERED() {
		return NOT_CONSIDERED;
	}
	public void setNOT_CONSIDERED(java.lang.String not_considered) {
		NOT_CONSIDERED = not_considered;
	}
	
	public java.util.Date getDATE_FROM() {
		return DATE_FROM;
	}
	public void setDATE_FROM(java.util.Date date_from) {
		DATE_FROM = date_from;
	}
	public java.util.Date getDATE_TO() {
		return DATE_TO;
	}
	public void setDATE_TO(java.util.Date date_to) {
		DATE_TO = date_to;
	}
	public java.math.BigDecimal getTOT_MONTHS() {
		return TOT_MONTHS;
	}
	public void setTOT_MONTHS(java.math.BigDecimal tot_months) {
		TOT_MONTHS = tot_months;
	}
	public java.math.BigDecimal getTOT_DAYS() {
		return TOT_DAYS;
	}
	public void setTOT_DAYS(java.math.BigDecimal tot_days) {
		TOT_DAYS = tot_days;
	}
	/*public java.math.BigDecimal getBASIC_PAY() {
		return BASIC_PAY;
	}
	public void setBASIC_PAY(java.math.BigDecimal basic_pay) {
		BASIC_PAY = basic_pay;
	}
	public java.math.BigDecimal getGRADE_PAY() {
		return GRADE_PAY;
	}
	public void setGRADE_PAY(java.math.BigDecimal grade_pay) {
		GRADE_PAY = grade_pay;
	}
	public java.math.BigDecimal getSPECIAL_PAY() {
		return SPECIAL_PAY;
	}
	public void setSPECIAL_PAY(java.math.BigDecimal special_pay) {
		SPECIAL_PAY = special_pay;
	}
	public java.math.BigDecimal getOTHER1_PAY() {
		return OTHER1_PAY;
	}
	public void setOTHER1_PAY(java.math.BigDecimal other1_pay) {
		OTHER1_PAY = other1_pay;
	}
	public java.math.BigDecimal getOTHER2_PAY() {
		return OTHER2_PAY;
	}
	public void setOTHER2_PAY(java.math.BigDecimal other2_pay) {
		OTHER2_PAY = other2_pay;
	}
	public java.math.BigDecimal getOTHER3_PAY() {
		return OTHER3_PAY;
	}
	public void setOTHER3_PAY(java.math.BigDecimal other3_pay) {
		OTHER3_PAY = other3_pay;
	}*/
	
	
	
	public java.lang.String getBASIC_PAY() {
		return BASIC_PAY;
	}
	public void setBASIC_PAY(java.lang.String basic_pay) {
		BASIC_PAY = basic_pay;
	}
	public java.lang.String getGRADE_PAY() {
		return GRADE_PAY;
	}
	public void setGRADE_PAY(java.lang.String grade_pay) {
		GRADE_PAY = grade_pay;
	}
	public java.lang.String getSPECIAL_PAY() {
		return SPECIAL_PAY;
	}
	public void setSPECIAL_PAY(java.lang.String special_pay) {
		SPECIAL_PAY = special_pay;
	}
	public java.lang.String getOTHER1_PAY() {
		return OTHER1_PAY;
	}
	public void setOTHER1_PAY(java.lang.String other1_pay) {
		OTHER1_PAY = other1_pay;
	}
	public java.lang.String getOTHER2_PAY() {
		return OTHER2_PAY;
	}
	public void setOTHER2_PAY(java.lang.String other2_pay) {
		OTHER2_PAY = other2_pay;
	}
	public java.lang.String getOTHER3_PAY() {
		return OTHER3_PAY;
	}
	public void setOTHER3_PAY(java.lang.String other3_pay) {
		OTHER3_PAY = other3_pay;
	}
	public java.math.BigDecimal getPROP_PAY() {
		return PROP_PAY;
	}
	public void setPROP_PAY(java.math.BigDecimal prop_pay) {
		PROP_PAY = prop_pay;
	}	
	public java.lang.String getAVGBASICLABLE() {
		return AVGBASICLABLE;
	}
	public void setAVGBASICLABLE(java.lang.String avgbasiclable) {
		AVGBASICLABLE = avgbasiclable;
	}
	public java.lang.String getAVGGRADELABLE() {
		return AVGGRADELABLE;
	}
	public void setAVGGRADELABLE(java.lang.String avggradelable) {
		AVGGRADELABLE = avggradelable;
	}
	public java.lang.String getAVGSPECIALLABLE() {
		return AVGSPECIALLABLE;
	}
	public void setAVGSPECIALLABLE(java.lang.String avgspeciallable) {
		AVGSPECIALLABLE = avgspeciallable;
	}
	public java.lang.String getAVGOTHER1LABLE() {
		return AVGOTHER1LABLE;
	}
	public void setAVGOTHER1LABLE(java.lang.String avgother1lable) {
		AVGOTHER1LABLE = avgother1lable;
	}
	public java.lang.String getAVGOTHER2LABLE() {
		return AVGOTHER2LABLE;
	}
	public void setAVGOTHER2LABLE(java.lang.String avgother2lable) {
		AVGOTHER2LABLE = avgother2lable;
	}
	public java.lang.String getAVGOTHER3LABLE() {
		return AVGOTHER3LABLE;
	}
	public void setAVGOTHER3LABLE(java.lang.String avgother3lable) {
		AVGOTHER3LABLE = avgother3lable;
	}	
	public java.math.BigDecimal getAVGPAYDRWAN() {
		return AVGPAYDRWAN;
	}
	public void setAVGPAYDRWAN(java.math.BigDecimal avgpaydrwan) {
		AVGPAYDRWAN = avgpaydrwan;
	}
	
	
	
	
	public java.math.BigDecimal getREC_ID() {
		return REC_ID;
	}
	public void setREC_ID(java.math.BigDecimal rec_id) {
		REC_ID = rec_id;
	}
	public java.lang.String getREC_DESC() {
		return REC_DESC;
	}
	public void setREC_DESC(java.lang.String rec_desc) {
		REC_DESC = rec_desc;
	}
	public java.math.BigDecimal getREC_AMOUNT() {
		return REC_AMOUNT;
	}
	public void setREC_AMOUNT(java.math.BigDecimal rec_amount) {
		REC_AMOUNT = rec_amount;
	}
	public java.math.BigDecimal getRECOVERY_TOTAL_AMOUNT() {
		return RECOVERY_TOTAL_AMOUNT;
	}
	public void setRECOVERY_TOTAL_AMOUNT(java.math.BigDecimal recovery_total_amount) {
		RECOVERY_TOTAL_AMOUNT = recovery_total_amount;
	}
	public java.lang.String getRESTRICT_ORG_PEN() {
		return RESTRICT_ORG_PEN;
	}
	public void setRESTRICT_ORG_PEN(java.lang.String restrict_org_pen) {
		RESTRICT_ORG_PEN = restrict_org_pen;
	}
	public java.math.BigDecimal getMAX_PEN_HALF_YR() {
		return MAX_PEN_HALF_YR;
	}
	public void setMAX_PEN_HALF_YR(java.math.BigDecimal max_pen_half_yr) {
		MAX_PEN_HALF_YR = max_pen_half_yr;
	}
	public java.lang.String getVRS_FAM_PEN_TEXT() {
		return VRS_FAM_PEN_TEXT;
	}
	public void setVRS_FAM_PEN_TEXT(java.lang.String vrs_fam_pen_text) {
		VRS_FAM_PEN_TEXT = vrs_fam_pen_text;
	}
	public java.lang.String getFAM_UPTO_DATE_TEXT() {
		return FAM_UPTO_DATE_TEXT;
	}
	public void setFAM_UPTO_DATE_TEXT(java.lang.String fam_upto_date_text) {
		FAM_UPTO_DATE_TEXT = fam_upto_date_text;
	}
	public java.lang.String getFAM_AFTER_DATE_TEXT() {
		return FAM_AFTER_DATE_TEXT;
	}
	public void setFAM_AFTER_DATE_TEXT(java.lang.String fam_after_date_text) {
		FAM_AFTER_DATE_TEXT = fam_after_date_text;
	}
	public java.lang.String getRESTRICT_PENSION_TEXT() {
		return RESTRICT_PENSION_TEXT;
	}
	public void setRESTRICT_PENSION_TEXT(java.lang.String restrict_pension_text) {
		RESTRICT_PENSION_TEXT = restrict_pension_text;
	}
	public java.lang.String getDCRG_TITLE_LABLE() {
		return DCRG_TITLE_LABLE;
	}
	public void setDCRG_TITLE_LABLE(java.lang.String dcrg_title_lable) {
		DCRG_TITLE_LABLE = dcrg_title_lable;
	}
	public java.lang.String getDCRG_AMOUNT_LABLE() {
		return DCRG_AMOUNT_LABLE;
	}
	public void setDCRG_AMOUNT_LABLE(java.lang.String dcrg_amount_lable) {
		DCRG_AMOUNT_LABLE = dcrg_amount_lable;
	}
	public java.util.Date getACTUAL_RET_DATE() {
		return ACTUAL_RET_DATE;
	}
	public void setACTUAL_RET_DATE(java.util.Date actual_ret_date) {
		ACTUAL_RET_DATE = actual_ret_date;
	}
	public java.lang.String getRETIREMENT_LABLE() {
		return RETIREMENT_LABLE;
	}
	public void setRETIREMENT_LABLE(java.lang.String retirement_lable) {
		RETIREMENT_LABLE = retirement_lable;
	}
	public java.lang.String getSUBJECT_CONTENT() {
		return SUBJECT_CONTENT;
	}
	public void setSUBJECT_CONTENT(java.lang.String subject_content) {
		SUBJECT_CONTENT = subject_content;
	}
	public java.lang.String getDCRG_RECOVERIES() {
		return DCRG_RECOVERIES;
	}
	public void setDCRG_RECOVERIES(java.lang.String dcrg_recoveries) {
		DCRG_RECOVERIES = dcrg_recoveries;
	}
	public java.lang.String getNET_DCRG() {
		return NET_DCRG;
	}
	public void setNET_DCRG(java.lang.String net_dcrg) {
		NET_DCRG = net_dcrg;
	}
	public java.lang.String getOTHDEPTSERVICE() {
		return OTHDEPTSERVICE;
	}
	public void setOTHDEPTSERVICE(java.lang.String othdeptservice) {
		OTHDEPTSERVICE = othdeptservice;
	}
	public java.lang.String getOTHDEPTYEAR() {
		return OTHDEPTYEAR;
	}
	public void setOTHDEPTYEAR(java.lang.String othdeptyear) {
		OTHDEPTYEAR = othdeptyear;
	}
	public java.lang.String getOTHDEPTMONTH() {
		return OTHDEPTMONTH;
	}
	public void setOTHDEPTMONTH(java.lang.String othdeptmonth) {
		OTHDEPTMONTH = othdeptmonth;
	}
	public java.lang.String getOTHDEPTDAY() {
		return OTHDEPTDAY;
	}
	public void setOTHDEPTDAY(java.lang.String othdeptday) {
		OTHDEPTDAY = othdeptday;
	}
	public java.util.Date getDATE_OF_JOINING() {
		return DATE_OF_JOINING;
	}
	public void setDATE_OF_JOINING(java.util.Date date_of_joining) {
		DATE_OF_JOINING = date_of_joining;
	}
	public java.util.Date getDATE_OF_RELIEVING() {
		return DATE_OF_RELIEVING;
	}
	public void setDATE_OF_RELIEVING(java.util.Date date_of_relieving) {
		DATE_OF_RELIEVING = date_of_relieving;
	}
	public java.math.BigDecimal getTOT_YEAR_SERVICE() {
		return TOT_YEAR_SERVICE;
	}
	public void setTOT_YEAR_SERVICE(java.math.BigDecimal tot_year_service) {
		TOT_YEAR_SERVICE = tot_year_service;
	}
	public java.math.BigDecimal getTOT_MONTH_SERVICE() {
		return TOT_MONTH_SERVICE;
	}
	public void setTOT_MONTH_SERVICE(java.math.BigDecimal tot_month_service) {
		TOT_MONTH_SERVICE = tot_month_service;
	}
	public java.math.BigDecimal getTOT_DAY_SERVICE() {
		return TOT_DAY_SERVICE;
	}
	public void setTOT_DAY_SERVICE(java.math.BigDecimal tot_day_service) {
		TOT_DAY_SERVICE = tot_day_service;
	}
	public java.lang.String getDEPATMENT_NAME() {
		return DEPATMENT_NAME;
	}
	public void setDEPATMENT_NAME(java.lang.String depatment_name) {
		DEPATMENT_NAME = depatment_name;
	}
	public java.lang.String getREMARKS() {
		return REMARKS;
	}
	public void setREMARKS(java.lang.String remarks) {
		REMARKS = remarks;
	}
	public java.lang.String getSUBJECT_CONTENT5() {
		return SUBJECT_CONTENT5;
	}
	public void setSUBJECT_CONTENT5(java.lang.String subject_content5) {
		SUBJECT_CONTENT5 = subject_content5;
	}
	
	
	
	
	
	
	
	
	

}
