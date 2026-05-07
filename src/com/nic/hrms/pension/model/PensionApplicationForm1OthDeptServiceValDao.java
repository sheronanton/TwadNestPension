package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PensionApplicationForm1OthDeptServiceValDao implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6678782340706179006L;
	
	
	private PensionApplicationForm1OthDeptServiceValPK compositePK;
	
	private String DepartmentName;
	private String Remarks;
	private String todate;
	private Date todate1;
	private String todate2;
	
	private Integer OthServiceYear;
	private Integer OthServiceMonth;
	private Integer OtherServiceDay;
	
	private String updatedUser;
	private Timestamp updateDate;
	private Timestamp unlockedDate;
	private String unlockedBy;
		
	
	
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		
		if(todate.trim() != null && todate.trim().length() >0){
			try{
	            System.out.println("------------------------>todate"+todate);
	            DateFormat tdate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setTodate1(tdate.parse(todate));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of todate"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.todate = todate;
	}
	public Date getTodate1() {
		return todate1;
	}
	public void setTodate1(Date todate1) {
		
		if(todate1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String tdate = formatter.format(todate1);
		         setTodate2(tdate);
		        } 
			
			catch (Exception e)
		    {
				e.printStackTrace(); 
		    
		    }
		}
		this.todate1 = todate1;
	}
	public String getTodate2() {
		return todate2;
	}
	public void setTodate2(String todate2) {
		this.todate2 = todate2;
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
	
	public Integer getOthServiceYear() {
		return OthServiceYear;
	}
	public void setOthServiceYear(Integer othServiceYear) {
		OthServiceYear = othServiceYear;
	}
	public Integer getOthServiceMonth() {
		return OthServiceMonth;
	}
	public void setOthServiceMonth(Integer othServiceMonth) {
		OthServiceMonth = othServiceMonth;
	}
	public Integer getOtherServiceDay() {
		return OtherServiceDay;
	}
	public void setOtherServiceDay(Integer otherServiceDay) {
		OtherServiceDay = otherServiceDay;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public PensionApplicationForm1OthDeptServiceValPK getCompositePK() {
		return compositePK;
	}
	public void setCompositePK(
			PensionApplicationForm1OthDeptServiceValPK compositePK) {
		this.compositePK = compositePK;
	}
	

}