package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


public class MstNominee_dao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6678782340706179006L;
	
	private int nomineeID;
	private int ppoNo;
	private String familyMembers;
	private String nomineeInitial;
	private String relation;
	private Date dob;
	private Integer age;
	private String maritalStatus;
	private String handicapped;
	private Date nominationDate;
	private Timestamp updatedDate;
	private String updatedBy;
	
	
	
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
	public Date getNominationDate() {
		return nominationDate;
	}
	public void setNominationDate(Date nominationDate) {
		this.nominationDate = nominationDate;
	}
	public int getNomineeID() {
		return nomineeID;
	}
	public void setNomineeID(int nomineeID) {
		this.nomineeID = nomineeID;
	}
	public String getHandicapped() {
		return handicapped;
	}
	public void setHandicapped(String handicapped) {
		this.handicapped = handicapped;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	
	public String getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(String familyMembers) {
		this.familyMembers = familyMembers;
	}
	
	public String getNomineeInitial() {
		return nomineeInitial;
	}
	public void setNomineeInitial(String nomineeInitial) {
		this.nomineeInitial = nomineeInitial;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		
		this.dob = dob;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}