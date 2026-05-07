package com.nic.hrms.pension.reports.model;
import java.io.Serializable;

public class RevisedDCRGnoteDao implements Serializable
{
	
	private static long serialVersionUID = 1L;
	
	java.util.Date DATE_OF_RETIRE;
	java.util.Date  DEATH_DATE;
	java.util.Date  DATE_OF_VRS;
	java.lang.String SUBJECT;
	java.lang.String CONTENT;
	java.lang.String CONTENT1;
	java.math.BigDecimal  PENSIONAMOUNT;
	java.math.BigDecimal  PROPAMOUNT;
	java.math.BigDecimal  DAAMOUNT;
	java.math.BigDecimal  LPDAMOUNT;
	java.math.BigDecimal  NEWDCRGAMOUNT;
	java.math.BigDecimal  OLDDCRGAMOUNT;
	java.math.BigDecimal  BASICPAY;
	java.math.BigDecimal  GRADEPAY;
	java.math.BigDecimal  SPECIALPAY;
	java.math.BigDecimal  OTHERPAY;
	java.lang.String REFERENCE;
	java.lang.String LETTERNO;
	java.util.Date  DATEDON;
	java.math.BigDecimal  EMPNO;
	java.lang.String PENSION_TYPE;
	java.lang.String  NOTE;
	java.lang.String NEWDAPERCENTAGE;
	java.math.BigDecimal diffdcrgamount;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		RevisedDCRGnoteDao.serialVersionUID = serialVersionUID;
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
	public java.lang.String getCONTENT1() {
		return CONTENT1;
	}
	public void setCONTENT1(java.lang.String content1) {
		CONTENT1 = content1;
	}
	public java.math.BigDecimal getPENSIONAMOUNT() {
		return PENSIONAMOUNT;
	}
	public void setPENSIONAMOUNT(java.math.BigDecimal pensionamount) {
		PENSIONAMOUNT = pensionamount;
	}
	public java.math.BigDecimal getPROPAMOUNT() {
		return PROPAMOUNT;
	}
	public void setPROPAMOUNT(java.math.BigDecimal propamount) {
		PROPAMOUNT = propamount;
	}
	public java.math.BigDecimal getDAAMOUNT() {
		return DAAMOUNT;
	}
	public void setDAAMOUNT(java.math.BigDecimal daamount) {
		DAAMOUNT = daamount;
	}
	public java.math.BigDecimal getLPDAMOUNT() {
		return LPDAMOUNT;
	}
	public void setLPDAMOUNT(java.math.BigDecimal lpdamount) {
		LPDAMOUNT = lpdamount;
	}
	public java.math.BigDecimal getNEWDCRGAMOUNT() {
		return NEWDCRGAMOUNT;
	}
	public void setNEWDCRGAMOUNT(java.math.BigDecimal newdcrgamount) {
		NEWDCRGAMOUNT = newdcrgamount;
	}
	public java.math.BigDecimal getOLDDCRGAMOUNT() {
		return OLDDCRGAMOUNT;
	}
	public void setOLDDCRGAMOUNT(java.math.BigDecimal olddcrgamount) {
		OLDDCRGAMOUNT = olddcrgamount;
	}
	public java.math.BigDecimal getBASICPAY() {
		return BASICPAY;
	}
	public void setBASICPAY(java.math.BigDecimal basicpay) {
		BASICPAY = basicpay;
	}
	public java.math.BigDecimal getGRADEPAY() {
		return GRADEPAY;
	}
	public void setGRADEPAY(java.math.BigDecimal gradepay) {
		GRADEPAY = gradepay;
	}
	public java.math.BigDecimal getSPECIALPAY() {
		return SPECIALPAY;
	}
	public void setSPECIALPAY(java.math.BigDecimal specialpay) {
		SPECIALPAY = specialpay;
	}
	public java.math.BigDecimal getOTHERPAY() {
		return OTHERPAY;
	}
	public void setOTHERPAY(java.math.BigDecimal otherpay) {
		OTHERPAY = otherpay;
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
	public java.lang.String getPENSION_TYPE() {
		return PENSION_TYPE;
	}
	public void setPENSION_TYPE(java.lang.String pension_type) {
		PENSION_TYPE = pension_type;
	}
	public java.lang.String getNOTE() {
		return NOTE;
	}
	public void setNOTE(java.lang.String note) {
		NOTE = note;
	}
	public java.lang.String getNEWDAPERCENTAGE() {
		return NEWDAPERCENTAGE;
	}
	public void setNEWDAPERCENTAGE(java.lang.String newdapercentage) {
		NEWDAPERCENTAGE = newdapercentage;
	}
	public java.math.BigDecimal getDiffdcrgamount() {
		return diffdcrgamount;
	}
	public void setDiffdcrgamount(java.math.BigDecimal diffdcrgamount) {
		this.diffdcrgamount = diffdcrgamount;
	}
	
	
	
	
	 

	
	
	

	
	
	
	
}
