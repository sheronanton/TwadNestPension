package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MstOfficeStatusModel implements Serializable {

	
	
	// pojo class for office status table
	
	private static final long serialVersionUID = 1L;
	
	private char office_status_id;
	private String office_status_desc;
	private String remarks;
	private String updated_by_user_id;
	private Timestamp  updated_date;
	
	
	public char getOffice_status_id() {
		return office_status_id;
	}
	public void setOffice_status_id(char office_status_id) {
		this.office_status_id = office_status_id;
	}
	public String getOffice_status_desc() {
		return office_status_desc;
	}
	public void setOffice_status_desc(String office_status_desc) {
		this.office_status_desc = office_status_desc;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUpdated_by_user_id() {
		return updated_by_user_id;
	}
	public void setUpdated_by_user_id(String updated_by_user_id) {
		this.updated_by_user_id = updated_by_user_id;
	}
	public Timestamp getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}
	
	
	
}
