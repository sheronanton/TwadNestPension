package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FamilyPensionApplicationDeathHOForm2NomineeDao implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int empNo;
	private int nomineeId;
	private String nomineeInitial;
	private String familyMembers;	
	private String relation;	
	private String nomineeDob;
	private Integer nomineeAge;
	private String handicapped;
	private String martialStatus;
	private String nominationDate;
	private Date nominationDate1;
	private String nominationDate2;
	private Date nomineeDob1;
	private String nomineeDob2;
	private String activeStatus;
	private String address;
	
	private String processStatus;
	private String updatedUserId; 
	private Timestamp updatedDate;
	
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getNomineeId() {
		return nomineeId;
	}
	public void setNomineeId(int nomineeId) {
		this.nomineeId = nomineeId;
	}
	public String getNomineeInitial() {
		return nomineeInitial;
	}
	public void setNomineeInitial(String nomineeInitial) {
		this.nomineeInitial = nomineeInitial;
	}
	public String getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(String familyMembers) {
		this.familyMembers = familyMembers;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getNomineeDob() {
		return nomineeDob;
	}
	public void setNomineeDob(String nomineeDob) {
		
		if(nomineeDob.trim() != null && nomineeDob.trim().length() >0)
		{
			try
			{	            
	            DateFormat datebirth = new SimpleDateFormat("dd/MM/yyyy");	            
	            setNomineeDob1(datebirth.parse(nomineeDob));
	        }
			catch(Exception e)
			{
	            e.printStackTrace();
	        }
		}
		
		this.nomineeDob = nomineeDob;
	}
	public Integer getNomineeAge() {
		return nomineeAge;
	}
	public void setNomineeAge(Integer nomineeAge) {
		this.nomineeAge = nomineeAge;
	}
	public String getHandicapped() {
		return handicapped;
	}
	public void setHandicapped(String handicapped) {
		this.handicapped = handicapped;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}
	public String getNominationDate() {
		return nominationDate;
	}
	public void setNominationDate(String nominationDate) {
		
		if(nominationDate.trim() != null && nominationDate.trim().length() >0){
			try
			{
	            DateFormat nomindate = new SimpleDateFormat("dd/MM/yyyy");	            
	            setNominationDate1(nomindate.parse(nominationDate));
	        }
			catch(Exception e)
			{
	             System.out.println("-------------------->inside exception block of date of dob"+e);
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
		         	String nomindate = formatter.format(nominationDate1);
		         	setNominationDate2(nomindate);
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
	public Date getNomineeDob1() {
		return nomineeDob1;
	}
	public void setNomineeDob1(Date nomineeDob1) {		
		if(nomineeDob1 != null){
			try {
		         	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         	String datefbirth = formatter.format(nomineeDob1);
		         	setNomineeDob2(datefbirth);
		        }
			catch (Exception e)
		    {
				e.printStackTrace();
		    }
		}
		
		this.nomineeDob1 = nomineeDob1;
	}
	public String getNomineeDob2() {
		return nomineeDob2;
	}
	public void setNomineeDob2(String nomineeDob2) {
		this.nomineeDob2 = nomineeDob2;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getUpdatedUserId() {
		return updatedUserId;
	}
	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
