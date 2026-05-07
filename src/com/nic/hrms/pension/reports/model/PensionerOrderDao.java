package com.nic.hrms.pension.reports.model;

import java.io.Serializable;

public class PensionerOrderDao implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	
	
	java.math.BigDecimal EMP_NO; 
	java.lang.String EMP_NAME;
	//java.math.BigDecimal PPO_NO; 
	//java.math.BigDecimal GPO_NO;
	java.lang.String FROM_ADDRESS; 
	java.lang.String NAME_FROM_ADDRESS;
	java.lang.String SERVICE_BOOK_ADDRESS;
	java.lang.String TO_ADDRESS;
	java.lang.String TO_ADDRESS1; 
	java.lang.String TO_ADDRESS2; 
	java.lang.String TO_ADDRESS3; 
	java.lang.String CIRCLE_HO_OFFICE_STATUS; 
	java.lang.String PENSION_PAY_OFFICE_ADDRESS; 
	java.lang.String LETTER_NO; 
	java.lang.String DATED_ON; 
	java.lang.String REFERENCE;
	java.lang.String AUTHORIZED_OFFICER; 
	java.lang.String AUTHORIZED_OFFICER_ADDRESS; 
	java.lang.String COPY_TO1; 
	java.lang.String COPY_TO2; 
	java.lang.String SUBJECT;
	java.lang.String CONTENT;
	java.util.Date DATE_OF_RETIREMENT;
	java.lang.String LAST_WORK_OFFICE_ADDRESS;
	java.lang.String CONTENT1;
	java.lang.String CONTENT2;
	java.lang.String CONTENT3;
	java.lang.String CONTENT4;
	java.lang.String FORWARD;
	java.lang.String FORWARD_OFFICER;
	java.lang.String FORWARD_OFFICER1;
	java.lang.String FORWARD_OFFICER2;
	java.lang.String VRS_CONTENT;
	java.lang.String IDMARK1;
	java.lang.String IDMARK2;
	java.lang.String DESIGNATION;
	java.util.Date DATE_OF_BIRTH;
	java.lang.String HEIGHT;
	java.lang.String NATIONALITY;
	java.lang.String RELIGION;
	java.lang.String RESIDENT_ADDRESS;
	java.lang.String AUTH;
	
	
	java.math.BigDecimal PENSION_AMOUNT;
	java.math.BigDecimal FAMILY_PENSION_AMOUNT_UPTO_SEVEN;
	java.math.BigDecimal FAMILY_PENSION_AMOUNT_AFTER_SEVEN;
	java.util.Date FAMILY_PENSION_UPTO_SEVEN;
	java.util.Date FAMILY_PENSION_AFTER_SEVEN;
	
	java.lang.String PENSION_CONTENT;
	java.lang.String FAMILY_PENSION_CONTENT;
	
	java.lang.String PENSION_TYPE;
	java.lang.String PROCESS_STATUS;
	
	
	java.lang.String PPO_NO; 
	java.lang.String GPO_NO;
	java.lang.String ECODE;
	java.lang.String REFERENCE_LETTERNO;
	java.lang.String SIGNATURE;
	
	
	
	
	
	
	
	public java.lang.String getREFERENCE_LETTERNO() {
		return REFERENCE_LETTERNO;
	}
	public void setREFERENCE_LETTERNO(java.lang.String reference_letterno) {
		REFERENCE_LETTERNO = reference_letterno;
	}
	public java.math.BigDecimal getEMP_NO() {
		return EMP_NO;
	}
	public void setEMP_NO(java.math.BigDecimal emp_no) {
		EMP_NO = emp_no;
	}
	/*public java.math.BigDecimal getPPO_NO() {
		return PPO_NO;
	}
	public void setPPO_NO(java.math.BigDecimal ppo_no) {
		PPO_NO = ppo_no;
	}*/
	public java.lang.String getFROM_ADDRESS() {
		return FROM_ADDRESS;
	}
	public void setFROM_ADDRESS(java.lang.String from_address) {
		FROM_ADDRESS = from_address;
	}
	public java.lang.String getTO_ADDRESS() {
		return TO_ADDRESS;
	}
	public void setTO_ADDRESS(java.lang.String to_address) {
		TO_ADDRESS = to_address;
	}
	public java.lang.String getCIRCLE_HO_OFFICE_STATUS() {
		return CIRCLE_HO_OFFICE_STATUS;
	}
	public void setCIRCLE_HO_OFFICE_STATUS(java.lang.String circle_ho_office_status) {
		CIRCLE_HO_OFFICE_STATUS = circle_ho_office_status;
	}
	public java.lang.String getPENSION_PAY_OFFICE_ADDRESS() {
		return PENSION_PAY_OFFICE_ADDRESS;
	}
	public void setPENSION_PAY_OFFICE_ADDRESS(
			java.lang.String pension_pay_office_address) {
		PENSION_PAY_OFFICE_ADDRESS = pension_pay_office_address;
	}
	public java.lang.String getLETTER_NO() {
		return LETTER_NO;
	}
	public void setLETTER_NO(java.lang.String letter_no) {
		LETTER_NO = letter_no;
	}
	public java.lang.String getDATED_ON() {
		return DATED_ON;
	}
	public void setDATED_ON(java.lang.String dated_on) {
		DATED_ON = dated_on;
	}
	public java.lang.String getREFERENCE() {
		return REFERENCE;
	}
	public void setREFERENCE(java.lang.String reference) {
		REFERENCE = reference;
	}
	public java.lang.String getAUTHORIZED_OFFICER() {
		return AUTHORIZED_OFFICER;
	}
	public void setAUTHORIZED_OFFICER(java.lang.String authorized_officer) {
		AUTHORIZED_OFFICER = authorized_officer;
	}
	public java.lang.String getAUTHORIZED_OFFICER_ADDRESS() {
		return AUTHORIZED_OFFICER_ADDRESS;
	}
	public void setAUTHORIZED_OFFICER_ADDRESS(
			java.lang.String authorized_officer_address) {
		AUTHORIZED_OFFICER_ADDRESS = authorized_officer_address;
	}
	public java.lang.String getCOPY_TO1() {
		return COPY_TO1;
	}
	public void setCOPY_TO1(java.lang.String copy_to1) {
		COPY_TO1 = copy_to1;
	}
	public java.lang.String getCOPY_TO2() {
		return COPY_TO2;
	}
	public void setCOPY_TO2(java.lang.String copy_to2) {
		COPY_TO2 = copy_to2;
	}
	public java.lang.String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(java.lang.String subject) {
		SUBJECT = subject;
	}
	public java.lang.String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(java.lang.String content) {
		CONTENT = content;
	}	
	public java.lang.String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(java.lang.String emp_name) {
		EMP_NAME = emp_name;
	}
	public java.util.Date getDATE_OF_RETIREMENT() {
		return DATE_OF_RETIREMENT;
	}
	public void setDATE_OF_RETIREMENT(java.util.Date date_of_retirement) {
		DATE_OF_RETIREMENT = date_of_retirement;
	}	
	public java.lang.String getLAST_WORK_OFFICE_ADDRESS() {
		return LAST_WORK_OFFICE_ADDRESS;
	}
	public void setLAST_WORK_OFFICE_ADDRESS(
			java.lang.String last_work_office_address) {
		LAST_WORK_OFFICE_ADDRESS = last_work_office_address;
	}	
	public java.lang.String getCONTENT1() {
		return CONTENT1;
	}
	public void setCONTENT1(java.lang.String content1) {
		CONTENT1 = content1;
	}
	public java.lang.String getCONTENT2() {
		return CONTENT2;
	}
	public void setCONTENT2(java.lang.String content2) {
		CONTENT2 = content2;
	}
	public java.lang.String getCONTENT3() {
		return CONTENT3;
	}
	public void setCONTENT3(java.lang.String content3) {
		CONTENT3 = content3;
	}
	public java.lang.String getCONTENT4() {
		return CONTENT4;
	}
	public void setCONTENT4(java.lang.String content4) {
		CONTENT4 = content4;
	}	
	public java.lang.String getIDMARK1() {
		return IDMARK1;
	}
	public void setIDMARK1(java.lang.String idmark1) {
		IDMARK1 = idmark1;
	}
	public java.lang.String getIDMARK2() {
		return IDMARK2;
	}
	public void setIDMARK2(java.lang.String idmark2) {
		IDMARK2 = idmark2;
	}
	public java.lang.String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(java.lang.String designation) {
		DESIGNATION = designation;
	}	
	public java.util.Date getDATE_OF_BIRTH() {
		return DATE_OF_BIRTH;
	}
	public void setDATE_OF_BIRTH(java.util.Date date_of_birth) {
		DATE_OF_BIRTH = date_of_birth;
	}
	public java.lang.String getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(java.lang.String height) {
		HEIGHT = height;
	}
	public java.lang.String getNATIONALITY() {
		return NATIONALITY;
	}
	public void setNATIONALITY(java.lang.String nationality) {
		NATIONALITY = nationality;
	}
	public java.lang.String getRELIGION() {
		return RELIGION;
	}
	public void setRELIGION(java.lang.String religion) {
		RELIGION = religion;
	}
	public java.lang.String getRESIDENT_ADDRESS() {
		return RESIDENT_ADDRESS;
	}
	public void setRESIDENT_ADDRESS(java.lang.String resident_address) {
		RESIDENT_ADDRESS = resident_address;
	}	
	public java.math.BigDecimal getPENSION_AMOUNT() {
		return PENSION_AMOUNT;
	}
	public void setPENSION_AMOUNT(java.math.BigDecimal pension_amount) {
		PENSION_AMOUNT = pension_amount;
	}
	public java.math.BigDecimal getFAMILY_PENSION_AMOUNT_UPTO_SEVEN() {
		return FAMILY_PENSION_AMOUNT_UPTO_SEVEN;
	}
	public void setFAMILY_PENSION_AMOUNT_UPTO_SEVEN(
			java.math.BigDecimal family_pension_amount_upto_seven) {
		FAMILY_PENSION_AMOUNT_UPTO_SEVEN = family_pension_amount_upto_seven;
	}
	public java.math.BigDecimal getFAMILY_PENSION_AMOUNT_AFTER_SEVEN() {
		return FAMILY_PENSION_AMOUNT_AFTER_SEVEN;
	}
	public void setFAMILY_PENSION_AMOUNT_AFTER_SEVEN(
			java.math.BigDecimal family_pension_amount_after_seven) {
		FAMILY_PENSION_AMOUNT_AFTER_SEVEN = family_pension_amount_after_seven;
	}
	public java.util.Date getFAMILY_PENSION_UPTO_SEVEN() {
		return FAMILY_PENSION_UPTO_SEVEN;
	}
	public void setFAMILY_PENSION_UPTO_SEVEN(
			java.util.Date family_pension_upto_seven) {
		FAMILY_PENSION_UPTO_SEVEN = family_pension_upto_seven;
	}
	public java.util.Date getFAMILY_PENSION_AFTER_SEVEN() {
		return FAMILY_PENSION_AFTER_SEVEN;
	}
	public void setFAMILY_PENSION_AFTER_SEVEN(
			java.util.Date family_pension_after_seven) {
		FAMILY_PENSION_AFTER_SEVEN = family_pension_after_seven;
	}
	public java.lang.String getPENSION_CONTENT() {
		return PENSION_CONTENT;
	}
	public void setPENSION_CONTENT(java.lang.String pension_content) {
		PENSION_CONTENT = pension_content;
	}
	public java.lang.String getFAMILY_PENSION_CONTENT() {
		return FAMILY_PENSION_CONTENT;
	}
	public void setFAMILY_PENSION_CONTENT(java.lang.String family_pension_content) {
		FAMILY_PENSION_CONTENT = family_pension_content;
	}	
	public java.lang.String getPENSION_TYPE() {
		return PENSION_TYPE;
	}
	public void setPENSION_TYPE(java.lang.String pension_type) {
		PENSION_TYPE = pension_type;
	}	
	/*public java.math.BigDecimal getGPO_NO() {
		return GPO_NO;
	}
	public void setGPO_NO(java.math.BigDecimal gpo_no) {
		GPO_NO = gpo_no;
	}*/
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public java.lang.String getPROCESS_STATUS() {
		return PROCESS_STATUS;
	}
	public void setPROCESS_STATUS(java.lang.String process_status) {
		PROCESS_STATUS = process_status;
	}
	public java.lang.String getPPO_NO() {
		return PPO_NO;
	}
	public void setPPO_NO(java.lang.String ppo_no) {
		PPO_NO = ppo_no;
	}
	public java.lang.String getGPO_NO() {
		return GPO_NO;
	}
	public void setGPO_NO(java.lang.String gpo_no) {
		GPO_NO = gpo_no;
	}
	public java.lang.String getECODE() {
		return ECODE;
	}
	public void setECODE(java.lang.String ecode) {
		ECODE = ecode;
	}
	public java.lang.String getNAME_FROM_ADDRESS() {
		return NAME_FROM_ADDRESS;
	}
	public void setNAME_FROM_ADDRESS(java.lang.String name_from_address) {
		NAME_FROM_ADDRESS = name_from_address;
	}
	public java.lang.String getSERVICE_BOOK_ADDRESS() {
		return SERVICE_BOOK_ADDRESS;
	}
	public void setSERVICE_BOOK_ADDRESS(java.lang.String service_book_address) {
		SERVICE_BOOK_ADDRESS = service_book_address;
	}
	public java.lang.String getFORWARD() {
		return FORWARD;
	}
	public void setFORWARD(java.lang.String forward) {
		FORWARD = forward;
	}
	public java.lang.String getFORWARD_OFFICER() {
		return FORWARD_OFFICER;
	}
	public void setFORWARD_OFFICER(java.lang.String forward_officer) {
		FORWARD_OFFICER = forward_officer;
	}
	public java.lang.String getFORWARD_OFFICER1() {
		return FORWARD_OFFICER1;
	}
	public void setFORWARD_OFFICER1(java.lang.String forward_officer1) {
		FORWARD_OFFICER1 = forward_officer1;
	}
	public java.lang.String getFORWARD_OFFICER2() {
		return FORWARD_OFFICER2;
	}
	public void setFORWARD_OFFICER2(java.lang.String forward_officer2) {
		FORWARD_OFFICER2 = forward_officer2;
	}
	public java.lang.String getAUTH() {
		return AUTH;
	}
	public void setAUTH(java.lang.String auth) {
		AUTH = auth;
	}
	public java.lang.String getTO_ADDRESS1() {
		return TO_ADDRESS1;
	}
	public void setTO_ADDRESS1(java.lang.String to_address1) {
		TO_ADDRESS1 = to_address1;
	}
	public java.lang.String getTO_ADDRESS2() {
		return TO_ADDRESS2;
	}
	public void setTO_ADDRESS2(java.lang.String to_address2) {
		TO_ADDRESS2 = to_address2;
	}
	public java.lang.String getTO_ADDRESS3() {
		return TO_ADDRESS3;
	}
	public void setTO_ADDRESS3(java.lang.String to_address3) {
		TO_ADDRESS3 = to_address3;
	}
	public java.lang.String getVRS_CONTENT() {
		return VRS_CONTENT;
	}
	public void setVRS_CONTENT(java.lang.String vrs_content) {
		VRS_CONTENT = vrs_content;
	}
	public java.lang.String getSIGNATURE() {
		return SIGNATURE;
	}
	public void setSIGNATURE(java.lang.String signature) {
		SIGNATURE = signature;
	}
	
	
}
