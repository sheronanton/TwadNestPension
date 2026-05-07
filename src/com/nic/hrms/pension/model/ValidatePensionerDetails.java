package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatePensionerDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5122443227366984374L;
	
	
	private int ppoNo;
	private int originalPensionAmt;
	private int reducedPensionAmt;
	private int dearnessPay;
	private int provisionalPensionAmt;
	private int dcrgAmt;
	private int dcrgPertReceived;
	private char commOpted;
	private String commReceived;
	private String commfactorOnethird;
	private int commFactorPert;
	private int commAmt;
	private String commPayDate;
	private String pshfSubscribed;
	private String familyPensionTillDate;
	private int familyPensionTillDateAmt;
	private int familyPensionAtferDateAmt;
	private String payCommissionRevisonFlag;
	private String processStatus;
	private Date commPayDate1;
	private Date familyPensionTillDate1;
	private String updatedId;
	private Timestamp updatedDate;
	
	
	
	
	
	
	public Date getCommPayDate1() {
		return commPayDate1;
	}
	public void setCommPayDate1(Date commPayDate1) {
		this.commPayDate1 = commPayDate1;
	}
	public Date getFamilyPensionTillDate1() {
		return familyPensionTillDate1;
	}
	public void setFamilyPensionTillDate1(Date familyPensionTillDate1) {
		this.familyPensionTillDate1 = familyPensionTillDate1;
	}
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	public char getCommOpted() {
		return commOpted;
	}
	public void setCommOpted(char commOpted) {
		this.commOpted = commOpted;
	}
	
	public String getCommReceived() {
		return commReceived;
	}
	public void setCommReceived(String commReceived) {
		this.commReceived = commReceived;
	}
	public String getCommfactorOnethird() {
		return commfactorOnethird;
	}
	public void setCommfactorOnethird(String commfactorOnethird) {
		this.commfactorOnethird = commfactorOnethird;
	}
	
	
	public void setCommPayDate(String commPayDate) 
	{		
		if(commPayDate!=null && commPayDate.length()>0)
		{
			try
			{
                DateFormat compaydate = new SimpleDateFormat("dd/MM/yyyy");         
                setCommPayDate1(compaydate.parse(commPayDate));
         	}
			catch(Exception e)
			{           
				e.printStackTrace();        
         	}
		
		}
		this.commPayDate = commPayDate;
	}
	public String getPshfSubscribed() {
		return pshfSubscribed;
	}
	public void setPshfSubscribed(String pshfSubscribed) {
		this.pshfSubscribed = pshfSubscribed;
	}
	public String getFamilyPensionTillDate() {
		return familyPensionTillDate;
	}
	public void setFamilyPensionTillDate(String familyPensionTillDate) 
	{
		if(familyPensionTillDate!=null && familyPensionTillDate.length()>0 )
		{
			try
			{         
				DateFormat familydate = new SimpleDateFormat("dd/MM/yyyy");          
				setFamilyPensionTillDate1(familydate.parse(familyPensionTillDate));
         	}
			catch(Exception e)
			{
                e.printStackTrace();        
         	}
		}
		
		this.familyPensionTillDate = familyPensionTillDate;
	}
	
	
	public String getPayCommissionRevisonFlag() {
		return payCommissionRevisonFlag;
	}
	public void setPayCommissionRevisonFlag(String payCommissionRevisonFlag) {
		this.payCommissionRevisonFlag = payCommissionRevisonFlag;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public int getOriginalPensionAmt() {
		return originalPensionAmt;
	}
	public void setOriginalPensionAmt(int originalPensionAmt) {
		this.originalPensionAmt = originalPensionAmt;
	}
	public int getReducedPensionAmt() {
		return reducedPensionAmt;
	}
	public void setReducedPensionAmt(int reducedPensionAmt) {
		this.reducedPensionAmt = reducedPensionAmt;
	}
	public int getDearnessPay() {
		return dearnessPay;
	}
	public void setDearnessPay(int dearnessPay) {
		this.dearnessPay = dearnessPay;
	}
	public int getProvisionalPensionAmt() {
		return provisionalPensionAmt;
	}
	public void setProvisionalPensionAmt(int provisionalPensionAmt) {
		this.provisionalPensionAmt = provisionalPensionAmt;
	}
	public int getDcrgAmt() {
		return dcrgAmt;
	}
	public void setDcrgAmt(int dcrgAmt) {
		this.dcrgAmt = dcrgAmt;
	}
	public int getDcrgPertReceived() {
		return dcrgPertReceived;
	}
	public void setDcrgPertReceived(int dcrgPertReceived) {
		this.dcrgPertReceived = dcrgPertReceived;
	}
	public int getCommFactorPert() {
		return commFactorPert;
	}
	public void setCommFactorPert(int commFactorPert) {
		this.commFactorPert = commFactorPert;
	}
	public int getCommAmt() {
		return commAmt;
	}
	public void setCommAmt(int commAmt) {
		this.commAmt = commAmt;
	}
	public int getFamilyPensionTillDateAmt() {
		return familyPensionTillDateAmt;
	}
	public void setFamilyPensionTillDateAmt(int familyPensionTillDateAmt) {
		this.familyPensionTillDateAmt = familyPensionTillDateAmt;
	}
	public int getFamilyPensionAtferDateAmt() {
		return familyPensionAtferDateAmt;
	}
	public void setFamilyPensionAtferDateAmt(int familyPensionAtferDateAmt) {
		this.familyPensionAtferDateAmt = familyPensionAtferDateAmt;
	}
	public String getCommPayDate() {
		return commPayDate;
	}
	public void setUpdatedId(String updatedId) {
		this.updatedId = updatedId;
	}
	public String getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	
	
	

}
