package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateSignatureDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8037589821722462258L;
	
	private int ppoNo;
	private String pensionStatus;
	private String lastSignatureDate;
	private String pensionNotPaidFrmMon;
	private String pensionNotPaidFrmYear;
	private String processStatus;
	private Date lastSignatureDate1;
	private String updatedId;
	private Timestamp updatedDate;
	
	
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	public String getPensionStatus() {
		return pensionStatus;
	}
	public void setPensionStatus(String pensionStatus) {
		this.pensionStatus = pensionStatus;
	}
	public String getLastSignatureDate() {
		
		return lastSignatureDate;
	}
	public void setLastSignatureDate(String lastSignatureDate) 
	{		
		if(lastSignatureDate!=null && lastSignatureDate.length()>0)
		{
			try
			{            
				DateFormat lastdate = new SimpleDateFormat("dd/MM/yyyy");            
				setLastSignatureDate1(lastdate.parse(lastSignatureDate));
         	}
			catch(Exception e)
			{
                e.printStackTrace();        
         	}
		}
		
		this.lastSignatureDate = lastSignatureDate;
	}
	
	
	public String getPensionNotPaidFrmMon() {
		return pensionNotPaidFrmMon;
	}
	public void setPensionNotPaidFrmMon(String pensionNotPaidFrmMon) {
		this.pensionNotPaidFrmMon = pensionNotPaidFrmMon;
	}
	public String getPensionNotPaidFrmYear() {
		return pensionNotPaidFrmYear;
	}
	public void setPensionNotPaidFrmYear(String pensionNotPaidFrmYear) {
		this.pensionNotPaidFrmYear = pensionNotPaidFrmYear;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public Date getLastSignatureDate1() {
		return lastSignatureDate1;
	}
	public void setLastSignatureDate1(Date lastSignatureDate1) {		
		this.lastSignatureDate1 = lastSignatureDate1;
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
