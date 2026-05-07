package com.nic.hrms.pension.reports.model;

import java.io.Serializable;

public class reportRevisedPensionduetopaychangeDao implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	
	
	/*java.math.BigDecimal EMP_NO; 
	java.lang.String EMP_NAME;*/
	//
	//java.math.BigDecimal GPO_NO;
	/*java.lang.String FROM_ADDRESS; */
	
	java.lang.String NAME_FROM_ADDRESS;
	java.lang.String AUTHORIZED_OFFICER; 
	java.lang.String LAST_WORK_OFFICE_ADDRESS;
	java.lang.String LETTER_NO;
	java.lang.String DATED_ON;
	java.lang.String SUBJECT;
	java.util.Date DATE_OF_RETIRE;
	java.util.Date  DEATH_DATE;
	java.util.Date  DATE_OF_VRS;
	java.lang.String  EMP_NAME;
	java.lang.String DESIGNATION;
	java.lang.String CONTENT;
	java.math.BigDecimal  OLDPENSIONAMOUNT;
	java.math.BigDecimal  OLDCOMMPENAMT;
	java.math.BigDecimal  OLDREDPENAMT;
	java.math.BigDecimal  OLDFAMPEN50AMT;
	java.math.BigDecimal  OLDFAMPEN30AMT;
	java.math.BigDecimal PPO_NO; 
	java.lang.String CONTENT1;
	java.lang.String CONTENT2;
	java.lang.String CONTENT4;
	
	java.math.BigDecimal  NEWPENSIONAMOUNT;
	java.math.BigDecimal  NEWCOMMPENAMT;
	java.math.BigDecimal  NEWREDPENAMT;
	java.math.BigDecimal  NEWFAMPEN50AMT;
	java.math.BigDecimal   NEWFAMPEN30AMT;

	java.lang.String WEFDATE;
	java.lang.String DIFFCOMMAMT;
	java.lang.String CONTENT3;
	java.lang.String COPY;
	
	java.lang.String REFERENCE;
	java.lang.String LETTERNO;
	java.util.Date  DATEDON;
	java.math.BigDecimal  EMPNO;
	java.lang.String LETTERNO1;
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
	public java.lang.String getCONTENT4() {
		return CONTENT4;
	}
	public void setCONTENT4(java.lang.String content4) {
		CONTENT4 = content4;
	}
	public java.lang.String getCOPY() {
		return COPY;
	}
	public void setCOPY(java.lang.String copy) {
		COPY = copy;
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
	public java.util.Date getDATEDON() {
		return DATEDON;
	}
	public void setDATEDON(java.util.Date datedon) {
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
	
	
	
	
	
	
	
	



	
	

}
