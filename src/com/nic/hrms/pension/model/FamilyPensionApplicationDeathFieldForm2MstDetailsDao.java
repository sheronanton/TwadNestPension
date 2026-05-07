package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FamilyPensionApplicationDeathFieldForm2MstDetailsDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer empNo;
	private Integer religionId;
	private String religionIdStr;
	private String nationality;
	private String idMark1;
	private String idMark2;
	private String presentAddress;
	private Integer stateId;
	private String stateIdStr;
	private Integer paymentOfficeId;
	private String paymentOfficeIdStr;
	private String claimentName;
	private String claimentDob1;
	private Date claimentDob2;
	private String claimentDob3;
	private String height;
	private Integer claimentAge;
	private String guardianName;
	
	private String guardianDob1;	
	private Date guardianDob2;
	private String guardianDob3;
	
	private String guardianRelationMinor;
	private String guardianRelationEmp;
	private String employeeDeathDate1 ;
	private Date employeeDeathDate2 ;
	private String employeeDeathDate3 ;
	private String address;
	private String updatedUser;
	private Timestamp updatedDate;
	private String processStatus;
	private String unlockedUser;
	private Timestamp unlockedDate;
	
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public Integer getReligionId() {
		return religionId;
	}
	public void setReligionId(Integer religionId) {
		setReligionIdStr(religionId+"");
		this.religionId = religionId;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIdMark1() {
		return idMark1;
	}
	public void setIdMark1(String idMark1) {
		this.idMark1 = idMark1;
	}
	public String getIdMark2() {
		return idMark2;
	}
	public void setIdMark2(String idMark2) {
		this.idMark2 = idMark2;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		setStateIdStr(stateId+"");
		this.stateId = stateId;
	}
	public Integer getPaymentOfficeId() {
		return paymentOfficeId;
	}
	public void setPaymentOfficeId(Integer paymentOfficeId) {
		setPaymentOfficeIdStr(paymentOfficeId+"");
		this.paymentOfficeId = paymentOfficeId;
	}
	public String getClaimentName() {
		return claimentName;
	}
	public void setClaimentName(String claimentName) {
		this.claimentName = claimentName;
	}
	public Integer getClaimentAge() {
		return claimentAge;
	}
	public void setClaimentAge(Integer claimentAge) {
		this.claimentAge = claimentAge;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	
	public String getGuardianRelationMinor() {
		return guardianRelationMinor;
	}
	public void setGuardianRelationMinor(String guardianRelationMinor) {
		this.guardianRelationMinor = guardianRelationMinor;
	}
	public String getGuardianRelationEmp() {
		return guardianRelationEmp;
	}
	public void setGuardianRelationEmp(String guardianRelationEmp) {
		this.guardianRelationEmp = guardianRelationEmp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getUnlockedUser() {
		return unlockedUser;
	}
	public void setUnlockedUser(String unlockedUser) {
		this.unlockedUser = unlockedUser;
	}
	public Timestamp getUnlockedDate() {
		return unlockedDate;
	}
	public void setUnlockedDate(Timestamp unlockedDate) {
		this.unlockedDate = unlockedDate;
	}
	
	public String getClaimentDob1() {
		return claimentDob1;
	}
	public void setClaimentDob1(String claimentDob1) {
		
		if(claimentDob1.trim() != null && claimentDob1.trim().length() > 0)
		{
			try
			{
			    DateFormat dob1 = new SimpleDateFormat("dd/MM/yyyy");
			    setClaimentDob2(dob1.parse(claimentDob1));
	        }
			catch(Exception e)
			{       
	                 e.printStackTrace();        
	        }
		}
		this.claimentDob1 = claimentDob1;
	}
	public Date getClaimentDob2() {
		return claimentDob2;
	}
	public void setClaimentDob2(Date claimentDob2) {		
		if(claimentDob2 != null )
		{
			try 
			{
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String dob2 = formatter.format(claimentDob2);
		         setClaimentDob3(dob2);
		    } 
			catch (Exception e)
		    {   
		        	e.printStackTrace();
		    }
		}
		this.claimentDob2 = claimentDob2;
	}
	public String getClaimentDob3() {
		return claimentDob3;
	}
	public void setClaimentDob3(String claimentDob3) {		
		this.claimentDob3 = claimentDob3;
	}
	public String getEmployeeDeathDate1() {
		return employeeDeathDate1;
	}
	public void setEmployeeDeathDate1(String employeeDeathDate1) {
		
		if(employeeDeathDate1.trim() != null && employeeDeathDate1.trim().length() > 0)
		{
			try
			{
			    DateFormat dod1 = new SimpleDateFormat("dd/MM/yyyy");
			    setEmployeeDeathDate2(dod1.parse(employeeDeathDate1));
	        }
			catch(Exception e)
			{       
	                 e.printStackTrace();        
	        }
		}
		this.employeeDeathDate1 = employeeDeathDate1;
	}
	public Date getEmployeeDeathDate2() {
		return employeeDeathDate2;
	}
	public void setEmployeeDeathDate2(Date employeeDeathDate2) {
		if(employeeDeathDate2 != null )
		{
			try 
			{
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String dod2 = formatter.format(employeeDeathDate2);
		         setEmployeeDeathDate3(dod2);
		    } 
			catch (Exception e)
		    {   
		        	e.printStackTrace();
		    }
		}
		this.employeeDeathDate2 = employeeDeathDate2;
	}
	public String getEmployeeDeathDate3() {
		return employeeDeathDate3;
	}
	public void setEmployeeDeathDate3(String employeeDeathDate3) {
		this.employeeDeathDate3 = employeeDeathDate3;
	}
	
	public String getGuardianDob1() {
		return guardianDob1;
	}
	public void setGuardianDob1(String guardianDob1) {
		if(guardianDob1.trim() != null && guardianDob1.trim().length() > 0)
		{
			try
			{
			    DateFormat gdob1 = new SimpleDateFormat("dd/MM/yyyy");
			    setGuardianDob2(gdob1.parse(guardianDob1));
	        }
			catch(Exception e)
			{       
	                 e.printStackTrace();        
	        }
		}
		this.guardianDob1 = guardianDob1;
	}
	public Date getGuardianDob2() {
		return guardianDob2;
	}
	public void setGuardianDob2(Date guardianDob2) {
		if(guardianDob2 != null )
		{
			try 
			{
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String gdob2 = formatter.format(guardianDob2);
		         setGuardianDob3(gdob2);
		    } 
			catch (Exception e)
		    {   
		        	e.printStackTrace();
		    }
		}
		this.guardianDob2 = guardianDob2;
	}
	public String getGuardianDob3() {
		return guardianDob3;
	}
	public void setGuardianDob3(String guardianDob3) {
		this.guardianDob3 = guardianDob3;
	}
	public void setReligionIdStr(String religionIdStr) {
		this.religionIdStr = religionIdStr;
	}
	public String getReligionIdStr() {
		return religionIdStr;
	}
	public void setStateIdStr(String stateIdStr) {
		this.stateIdStr = stateIdStr;
	}
	public String getStateIdStr() {
		return stateIdStr;
	}
	public void setPaymentOfficeIdStr(String paymentOfficeIdStr) {
		this.paymentOfficeIdStr = paymentOfficeIdStr;
	}
	public String getPaymentOfficeIdStr() {
		return paymentOfficeIdStr;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	
}
