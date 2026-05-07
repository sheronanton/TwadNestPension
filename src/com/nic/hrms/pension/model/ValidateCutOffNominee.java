package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateCutOffNominee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2735013794602518670L;
	
	private int nomineeID;
	private int ppoNo;
	private String familyMembers;
	private String relation;
	private String dob;
	private Integer age;
	private String martialStatus;
	private String handicapped;
	private String nomineeInitial;                                                                       
	private String nominationDate;
	private Date dob1;
	private Date nominationDate1;	
	private String updatedId;
	private Timestamp updatedDate;
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) 
	{
		if(dob.trim() != null && dob.trim().length() > 0)
		{
			try
			{
				DateFormat datebirth = new SimpleDateFormat("dd/MM/yyyy");            
				setDob1(datebirth.parse(dob));
         	}
			catch(Exception e)
			{          
                 e.printStackTrace();        
         	}
		}
		this.dob = dob;
	}
	
	public String getNominationDate() {
		return nominationDate;
	}
	
	public void setNominationDate(String nominationDate) {
	   if(nominationDate.trim() != null && nominationDate.trim().length() >0)
	   {	
			try
			{
	            DateFormat nomineedate = new SimpleDateFormat("dd/MM/yyyy");            
	            setNominationDate1(nomineedate.parse(nominationDate));
	         }
			catch(Exception e)
			{
	             e.printStackTrace();        
			}
	   }
		this.nominationDate = nominationDate;
	}
	
	public Date getNominationDate1() {
		return nominationDate1;
	}
	public void setNominationDate1(Date nominationDate1) {
	
		this.nominationDate1 = nominationDate1;
	}
	
	public Date getDob1() {
		return dob1;
	}
	public void setDob1(Date dob1) {
		
		this.dob1 = dob1;
	}
	
	public String getNomineeInitial() {
		return nomineeInitial;
	}
	public void setNomineeInitial(String nomineeInitial) {
		this.nomineeInitial = nomineeInitial;
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
	public String getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
