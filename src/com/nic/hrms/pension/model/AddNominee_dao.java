package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddNominee_dao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6678782340706179006L;
	
	private int nomineeID;
	private int ppoNo;
	private String familyMembers;
	private String relation;
	private String dob;
	private Integer age;
	private String martialStatus;
	private String handicapped;
	private String nomineeInitial;                                                                       ;
	private String nominationDate;
	private Date nominationDate1;
	private String nominationDate2;
	private Date dob1;
	private String dob2;
	private String updatedUserId; 
	private Timestamp updatedDate;

	
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		
		if(dob.trim() != null && dob.trim().length() >0){
		try{
            System.out.println("------------------------>dob"+dob);
            DateFormat datebirth = new SimpleDateFormat("dd/MM/yyyy");
            
            setDob1(datebirth.parse(dob));
         	}catch(Exception e){
                 System.out.println("-------------------->inside exception block of date of dob"+e);
                 e.printStackTrace();
        
         	}
		}
		this.dob = dob;
	}
	public String getNominationDate() {
		return nominationDate;
	}
	public void setNominationDate(String nominationDate) {
		if( nominationDate.trim() != null && nominationDate.trim().length() >0){
		try{
            System.out.println("------------------------>nominationDate"+nominationDate);
            DateFormat nomineedate = new SimpleDateFormat("dd/MM/yyyy");            
            setNominationDate1(nomineedate.parse(nominationDate));
         	}catch(Exception e){                 
                 e.printStackTrace();
        
         	}
		}
		this.nominationDate = nominationDate;
	}
	public Date getNominationDate1() {
		return nominationDate1;
	}
	public void setNominationDate1(Date nominationDate1) {
		if(nominationDate1 != null){
		try {
	         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	         String nomdate = formatter.format(nominationDate1);
	         setNominationDate2(nomdate);
	        } 
		
		catch (Exception e)
	    {
			e.printStackTrace(); 
	    
	    }
		}
		this.nominationDate1 = nominationDate1;
	}
	public String getNominationDate2() {
		return nominationDate2;
	}
	public void setNominationDate2(String nominationDate2) {
		this.nominationDate2 = nominationDate2;
	}
	public Date getDob1() {
		return dob1;
	}
	public void setDob1(Date dob1) {
		if(dob1 != null){
		try {
	         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	         String datefbirth = formatter.format(dob1);
	         setDob2(datefbirth);
	        }
		catch (Exception e)
	    {
	    e.printStackTrace();
	    }
		}
		this.dob1 = dob1;
	}
	public String getDob2() {
		return dob2;
	}
	public void setDob2(String dob2) {
		this.dob2 = dob2;
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
	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
	public String getUpdatedUserId() {
		return updatedUserId;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	

}