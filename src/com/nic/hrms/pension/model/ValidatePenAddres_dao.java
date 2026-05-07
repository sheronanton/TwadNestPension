package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ValidatePenAddres_dao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7225647217253713575L;
	
	private int ppoNo;
	private String address;
	private String district;
	private String state;
	private String pincode;
	private String contactLandline;
	private String contactCell;
	private String faxNo;
	private String contactEmailId;
	private String processStatus;
	private String updatedId;
	private Timestamp updatedDate;
	
	public String getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(String updatedId) {
		this.updatedId = updatedId;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getContactLandline() {
		return contactLandline;
	}
	public void setContactLandline(String contactLandline) {
		this.contactLandline = contactLandline;
	}
	public String getContactCell() {
		return contactCell;
	}
	public void setContactCell(String contactCell) {
		this.contactCell = contactCell;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getContactEmailId() {
		return contactEmailId;
	}
	public void setContactEmailId(String contactEmailId) {
		this.contactEmailId = contactEmailId;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	


}
