package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.io.*;

public class RevisedPensionReportModel implements Serializable 
{	
	
	private static final long serialVersionUID = 1L;
	
	java.lang.String NAME_FROM_ADDRESS;
	java.lang.String AUTHORIZED_OFFICER; 
	java.lang.String LAST_WORK_OFFICE_ADDRESS;
	java.lang.String PENSION_PAY_OFFICE_ADDRESS;
	java.lang.String LETTER_NO;
	java.lang.String DATED_ON;
	java.lang.String SUBJECT;
	java.util.Date DATE_OF_RETIRE;
	java.util.Date  DEATH_DATE;
	java.util.Date  DATE_OF_VRS;
	java.lang.String  EMP_NAME;
	java.lang.String DESIGNATION;
	java.lang.String CONTENT;	
	java.lang.String subject;
	java.lang.String sub;	
	java.lang.String ref;
	java.lang.String note_content1;
	java.lang.String note_content2;
	java.lang.String note_content3;
	java.lang.String note_content4;
	java.lang.String EMPNAME_CONTENT;
	
	
	
	
	
	
	java.math.BigDecimal  OLDPENSIONAMOUNT;
	java.math.BigDecimal  OLDCOMMPENAMT;
	java.math.BigDecimal  OLDREDPENAMT;
	java.math.BigDecimal  OLDFAMPEN50AMT;
	java.math.BigDecimal  OLDFAMPEN30AMT;	
	java.math.BigDecimal  OLDDCRGAMOUNT;
	
	
	java.math.BigDecimal PPO_NO; 
	java.lang.String CONTENT1;
	java.lang.String CONTENT2;
	java.lang.String CONTENT3;	
	java.lang.String CONTENT4;	
	java.lang.String CONTENT5;
	
	java.math.BigDecimal  NEWPENSIONAMOUNT;
	java.math.BigDecimal  NEWCOMMPENAMT;
	java.math.BigDecimal  NEWREDPENAMT;
	java.math.BigDecimal  NEWFAMPEN50AMT;
	java.math.BigDecimal   NEWFAMPEN30AMT;	
	java.math.BigDecimal  NEWDCRGAMOUNT;
	

	java.lang.String WEFDATE;
	java.lang.String DIFFCOMMAMT;	
	java.lang.String COPY1;
	java.lang.String COPY2;
	
	java.lang.String REFERENCE;
	java.lang.String LETTERNO;
	//java.util.Date  DATEDON;
	java.lang.String  DATEDON;
	//java.math.BigDecimal  EMPNO;
	java.math.BigDecimal EMPNO;
	java.lang.String LETTERNO1;
	java.lang.String REFERENCE1;
	
	
	
	
	public java.lang.String getEMPNAME_CONTENT() {
		return EMPNAME_CONTENT;
	}
	public void setEMPNAME_CONTENT(java.lang.String empname_content) {
		EMPNAME_CONTENT = empname_content;
	}
	public java.lang.String getPENSION_PAY_OFFICE_ADDRESS() {
		return PENSION_PAY_OFFICE_ADDRESS;
	}
	public void setPENSION_PAY_OFFICE_ADDRESS(
			java.lang.String pension_pay_office_address) {
		PENSION_PAY_OFFICE_ADDRESS = pension_pay_office_address;
	}
	public java.lang.String getNote_content3() {
		return note_content3;
	}
	public void setNote_content3(java.lang.String note_content3) {
		this.note_content3 = note_content3;
	}
	public java.lang.String getNote_content2() {
		return note_content2;
	}
	public void setNote_content2(java.lang.String note_content2) {
		this.note_content2 = note_content2;
	}
	public java.lang.String getNote_content1() {
		return note_content1;
	}
	public void setNote_content1(java.lang.String note_content1) {
		this.note_content1 = note_content1;
	}
	public java.lang.String getSub() {
		return sub;
	}
	public void setSub(java.lang.String sub) {
		this.sub = sub;
	}
	public java.lang.String getRef() {
		return ref;
	}
	public void setRef(java.lang.String ref) {
		this.ref = ref;
	}
	public java.lang.String getNAME_FROM_ADDRESS() {
		return NAME_FROM_ADDRESS;
	}
	public void setNAME_FROM_ADDRESS(java.lang.String name_from_address) {
		NAME_FROM_ADDRESS = name_from_address;
	}
	public java.lang.String getAUTHORIZED_OFFICER() {
		return AUTHORIZED_OFFICER;
	}
	public void setAUTHORIZED_OFFICER(java.lang.String authorized_officer) {
		AUTHORIZED_OFFICER = authorized_officer;
	}
	public java.lang.String getLAST_WORK_OFFICE_ADDRESS() {
		return LAST_WORK_OFFICE_ADDRESS;
	}
	public void setLAST_WORK_OFFICE_ADDRESS(
			java.lang.String last_work_office_address) {
		LAST_WORK_OFFICE_ADDRESS = last_work_office_address;
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
	public java.lang.String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(java.lang.String subject) {
		SUBJECT = subject;
	}
	public java.util.Date getDATE_OF_RETIRE() {
		return DATE_OF_RETIRE;
	}
	public void setDATE_OF_RETIRE(java.util.Date date_of_retire) {
		DATE_OF_RETIRE = date_of_retire;
	}
	public java.util.Date getDEATH_DATE() {
		return DEATH_DATE;
	}
	public void setDEATH_DATE(java.util.Date death_date) {
		DEATH_DATE = death_date;
	}
	public java.util.Date getDATE_OF_VRS() {
		return DATE_OF_VRS;
	}
	public void setDATE_OF_VRS(java.util.Date date_of_vrs) {
		DATE_OF_VRS = date_of_vrs;
	}
	public java.lang.String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(java.lang.String emp_name) {
		EMP_NAME = emp_name;
	}
	public java.lang.String getDESIGNATION() {
		return DESIGNATION;
	}
	public void setDESIGNATION(java.lang.String designation) {
		DESIGNATION = designation;
	}
	public java.lang.String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(java.lang.String content) {
		CONTENT = content;
	}
	public java.lang.String getSubject() {
		return subject;
	}
	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}
	public java.math.BigDecimal getOLDPENSIONAMOUNT() {
		return OLDPENSIONAMOUNT;
	}
	public void setOLDPENSIONAMOUNT(java.math.BigDecimal oldpensionamount) {
		OLDPENSIONAMOUNT = oldpensionamount;
	}
	public java.math.BigDecimal getOLDCOMMPENAMT() {
		return OLDCOMMPENAMT;
	}
	public void setOLDCOMMPENAMT(java.math.BigDecimal oldcommpenamt) {
		OLDCOMMPENAMT = oldcommpenamt;
	}
	public java.math.BigDecimal getOLDREDPENAMT() {
		return OLDREDPENAMT;
	}
	public void setOLDREDPENAMT(java.math.BigDecimal oldredpenamt) {
		OLDREDPENAMT = oldredpenamt;
	}
	public java.math.BigDecimal getOLDFAMPEN50AMT() {
		return OLDFAMPEN50AMT;
	}
	public void setOLDFAMPEN50AMT(java.math.BigDecimal oldfampen50amt) {
		OLDFAMPEN50AMT = oldfampen50amt;
	}
	public java.math.BigDecimal getOLDFAMPEN30AMT() {
		return OLDFAMPEN30AMT;
	}
	public void setOLDFAMPEN30AMT(java.math.BigDecimal oldfampen30amt) {
		OLDFAMPEN30AMT = oldfampen30amt;
	}
	public java.math.BigDecimal getOLDDCRGAMOUNT() {
		return OLDDCRGAMOUNT;
	}
	public void setOLDDCRGAMOUNT(java.math.BigDecimal olddcrgamount) {
		OLDDCRGAMOUNT = olddcrgamount;
	}
	public java.math.BigDecimal getPPO_NO() {
		return PPO_NO;
	}
	public void setPPO_NO(java.math.BigDecimal ppo_no) {
		PPO_NO = ppo_no;
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
	public java.lang.String getCONTENT4() {
		return CONTENT4;
	}
	public void setCONTENT4(java.lang.String content4) {
		CONTENT4 = content4;
	}
	public java.math.BigDecimal getNEWPENSIONAMOUNT() {
		return NEWPENSIONAMOUNT;
	}
	public void setNEWPENSIONAMOUNT(java.math.BigDecimal newpensionamount) {
		NEWPENSIONAMOUNT = newpensionamount;
	}
	public java.math.BigDecimal getNEWCOMMPENAMT() {
		return NEWCOMMPENAMT;
	}
	public void setNEWCOMMPENAMT(java.math.BigDecimal newcommpenamt) {
		NEWCOMMPENAMT = newcommpenamt;
	}
	public java.math.BigDecimal getNEWREDPENAMT() {
		return NEWREDPENAMT;
	}
	public void setNEWREDPENAMT(java.math.BigDecimal newredpenamt) {
		NEWREDPENAMT = newredpenamt;
	}
	public java.math.BigDecimal getNEWFAMPEN50AMT() {
		return NEWFAMPEN50AMT;
	}
	public void setNEWFAMPEN50AMT(java.math.BigDecimal newfampen50amt) {
		NEWFAMPEN50AMT = newfampen50amt;
	}
	public java.math.BigDecimal getNEWFAMPEN30AMT() {
		return NEWFAMPEN30AMT;
	}
	public void setNEWFAMPEN30AMT(java.math.BigDecimal newfampen30amt) {
		NEWFAMPEN30AMT = newfampen30amt;
	}
	public java.math.BigDecimal getNEWDCRGAMOUNT() {
		return NEWDCRGAMOUNT;
	}
	public void setNEWDCRGAMOUNT(java.math.BigDecimal newdcrgamount) {
		NEWDCRGAMOUNT = newdcrgamount;
	}
	public java.lang.String getWEFDATE() {
		return WEFDATE;
	}
	public void setWEFDATE(java.lang.String wefdate) {
		WEFDATE = wefdate;
	}
	public java.lang.String getDIFFCOMMAMT() {
		return DIFFCOMMAMT;
	}
	public void setDIFFCOMMAMT(java.lang.String diffcommamt) {
		DIFFCOMMAMT = diffcommamt;
	}
	public java.lang.String getCONTENT3() {
		return CONTENT3;
	}
	public void setCONTENT3(java.lang.String content3) {
		CONTENT3 = content3;
	}
		
	public java.lang.String getCONTENT5() {
		return CONTENT5;
	}
	public void setCONTENT5(java.lang.String content5) {
		CONTENT5 = content5;
	}
	
	public java.lang.String getCOPY1() {
		return COPY1;
	}
	public void setCOPY1(java.lang.String copy1) {
		COPY1 = copy1;
	}
	public java.lang.String getCOPY2() {
		return COPY2;
	}
	public void setCOPY2(java.lang.String copy2) {
		COPY2 = copy2;
	}
	public java.lang.String getREFERENCE() {
		return REFERENCE;
	}
	public void setREFERENCE(java.lang.String reference) {
		REFERENCE = reference;
	}
	public java.lang.String getLETTERNO() {
		return LETTERNO;
	}
	public void setLETTERNO(java.lang.String letterno) {
		LETTERNO = letterno;
	}
	
	public java.lang.String getDATEDON() {
		return DATEDON;
	}
	public void setDATEDON(java.lang.String datedon) {
		DATEDON = datedon;
	}
	
	
	
	public java.math.BigDecimal getEMPNO() {
		return EMPNO;
	}
	public void setEMPNO(java.math.BigDecimal empno) {
		EMPNO = empno;
	}
	public java.lang.String getLETTERNO1() {
		return LETTERNO1;
	}
	public void setLETTERNO1(java.lang.String letterno1) {
		LETTERNO1 = letterno1;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public java.lang.String getNote_content4() {
		return note_content4;
	}
	public void setNote_content4(java.lang.String note_content4) {
		this.note_content4 = note_content4;
	}
	public java.lang.String getREFERENCE1() {
		return REFERENCE1;
	}
	public void setREFERENCE1(java.lang.String rEFERENCE1) {
		REFERENCE1 = rEFERENCE1;
	}
	
	
	
		
}
