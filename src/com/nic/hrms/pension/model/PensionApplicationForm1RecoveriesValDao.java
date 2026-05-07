package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PensionApplicationForm1RecoveriesValDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6678782340706179006L;
	
	private Integer recID;
	private Integer empNo;
	private String rec_description;	
	private Integer rec_amount;
	
	
	private String processStatus;
	private String updatedUser;
	private Timestamp updateDate;
	private Timestamp unlockedDate;
	private String unlockedBy;
	
	
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public Integer getRecID() {
		return recID;
	}
	public void setRecID(Integer recID) {
		this.recID = recID;
	}
	public String getRec_description() {
		return rec_description;
	}
	public void setRec_description(String rec_description) {
		this.rec_description = rec_description;
	}
	public Integer getRec_amount() {
		return rec_amount;
	}
	public void setRec_amount(Integer rec_amount) {
		this.rec_amount = rec_amount;
	}
	
	
	
	
	
	
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public Timestamp getUnlockedDate() {
		return unlockedDate;
	}
	public void setUnlockedDate(Timestamp unlockedDate) {
		this.unlockedDate = unlockedDate;
	}
	public String getUnlockedBy() {
		return unlockedBy;
	}
	public void setUnlockedBy(String unlockedBy) {
		this.unlockedBy = unlockedBy;
	}
	
	
	
		
	

}