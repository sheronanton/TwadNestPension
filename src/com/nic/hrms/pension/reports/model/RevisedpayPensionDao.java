package com.nic.hrms.pension.reports.model;
import java.io.Serializable;

public class RevisedpayPensionDao implements Serializable
{
	
	private static long serialVersionUID = 1L;
	java.lang.String  EMP_NAME;
	java.util.Date DATE_OF_RETIRE;
	java.util.Date  DEATH_DATE;
	java.util.Date  DATE_OF_VRS;
	java.lang.String subject;
	java.math.BigDecimal  NEWPENSIONAMOUNT;
	java.math.BigDecimal  NEWDCRGAMOUNT;
	java.math.BigDecimal  NEWCOMMPENAMT;
	java.math.BigDecimal  NEWREDPENAMT;
	java.math.BigDecimal  NEWFAMPEN50AMT;
	java.math.BigDecimal   NEWFAMPEN30AMT;
	
	
	java.math.BigDecimal  OLDPENSIONAMOUNT;
	java.math.BigDecimal  OLDDCRGAMOUNT;
	java.math.BigDecimal  OLDCOMMPENAMT;
	java.math.BigDecimal  OLDREDPENAMT;
	java.math.BigDecimal  OLDFAMPEN50AMT;
	java.math.BigDecimal  OLDFAMPEN30AMT;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		RevisedpayPensionDao.serialVersionUID = serialVersionUID;
	}
	public java.lang.String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(java.lang.String emp_name) {
		EMP_NAME = emp_name;
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
	public java.lang.String getSubject() {
		return subject;
	}
	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}
	public java.math.BigDecimal getNEWPENSIONAMOUNT() {
		return NEWPENSIONAMOUNT;
	}
	public void setNEWPENSIONAMOUNT(java.math.BigDecimal newpensionamount) {
		NEWPENSIONAMOUNT = newpensionamount;
	}
	public java.math.BigDecimal getNEWDCRGAMOUNT() {
		return NEWDCRGAMOUNT;
	}
	public void setNEWDCRGAMOUNT(java.math.BigDecimal newdcrgamount) {
		NEWDCRGAMOUNT = newdcrgamount;
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
	public java.math.BigDecimal getOLDPENSIONAMOUNT() {
		return OLDPENSIONAMOUNT;
	}
	public void setOLDPENSIONAMOUNT(java.math.BigDecimal oldpensionamount) {
		OLDPENSIONAMOUNT = oldpensionamount;
	}
	public java.math.BigDecimal getOLDDCRGAMOUNT() {
		return OLDDCRGAMOUNT;
	}
	public void setOLDDCRGAMOUNT(java.math.BigDecimal olddcrgamount) {
		OLDDCRGAMOUNT = olddcrgamount;
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
	
	

	
	
	
	
}
