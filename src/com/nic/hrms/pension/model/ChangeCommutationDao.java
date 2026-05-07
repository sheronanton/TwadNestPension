package com.nic.hrms.pension.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeCommutationDao {
	private int ppoNo;
	private char commOpted;
	private String commRecd;
	private String commFactorOneThird;
	private int commFactorPert; //f
	private int commAmt; //f
	private Date commPayDate;
	private String commPayDate1;
	private int ReducedPensionAmt; //f
	private String reason;
	private Timestamp updatedDate;
	private String updatedBy;
	
	private String processStatus;	
	private String unlockedBy;
	private Timestamp unlockedDate;
	
	
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getUnlockedBy() {
		return unlockedBy;
	}
	public void setUnlockedBy(String unlockedBy) {
		this.unlockedBy = unlockedBy;
	}
	public Timestamp getUnlockedDate() {
		return unlockedDate;
	}
	public void setUnlockedDate(Timestamp unlockedDate) {
		this.unlockedDate = unlockedDate;
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
	public String getCommRecd() {
		return commRecd;
	}
	public void setCommRecd(String commRecd) {
		this.commRecd = commRecd;
	}
	public String getCommFactorOneThird() {
		return commFactorOneThird;
	}
	public void setCommFactorOneThird(String commFactorOneThird) {
		this.commFactorOneThird = commFactorOneThird;
	}
	
	
	public Date getCommPayDate() {
		return commPayDate;
	}
	public void setCommPayDate(Date commPayDate) {
		this.commPayDate = commPayDate;
	}
	
	
	public String getCommPayDate1() {
		return commPayDate1;
	}
	public void setCommPayDate1(String commPayDate1) {
		if(commPayDate1.trim() != null && commPayDate1.trim().length() >0 ){
			try{
	            System.out.println("------------------------>commPayDate"+commPayDate);
	            DateFormat compaydate = new SimpleDateFormat("dd/MM/yyyy");
	            setCommPayDate(compaydate.parse(commPayDate1));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of commPayDate");
	                 e.printStackTrace();
	        
	         	}
			}
		this.commPayDate1 = commPayDate1;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public void setCommFactorPert(int commFactorPert) {
		this.commFactorPert = commFactorPert;
	}
	public int getCommFactorPert() {
		return commFactorPert;
	}
	public void setCommAmt(int commAmt) {
		this.commAmt = commAmt;
	}
	public int getCommAmt() {
		return commAmt;
	}
	public void setReducedPensionAmt(int reducedPensionAmt) {
		ReducedPensionAmt = reducedPensionAmt;
	}
	public int getReducedPensionAmt() {
		return ReducedPensionAmt;
	}
	
	
	
	

}
