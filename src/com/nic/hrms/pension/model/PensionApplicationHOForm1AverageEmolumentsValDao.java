package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PensionApplicationHOForm1AverageEmolumentsValDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6678782340706179006L;
	
	private Integer avgID;
	private Integer empNo;
	private String maxcheck_value;
	
	private String fromdate;
	private Date fromdate1;
	private String fromdate2;
	
	private String todate;
	private Date todate1;
	private String todate2;
	
	
	private Integer tmonth;
	private Integer tday;
	
	private Integer basic_pay;
	private Integer grade_pay;
	private Integer special_pay;
	private Integer optionpay1;
	private Integer optionpay2;
	private Integer optionpay3;
	//private Integer ppamount;
	//private BigDecimal ppamount;
	private float ppamount;
	
	
	
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
	public Integer getAvgID() {
		return avgID;
	}
	public void setAvgID(Integer avgID) {
		this.avgID = avgID;
	}
	
	
	public String getMaxcheck_value() {
		return maxcheck_value;
	}
	public void setMaxcheck_value(String maxcheck_value) {
		this.maxcheck_value = maxcheck_value;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		
		if(fromdate.trim() != null && fromdate.trim().length() >0){
			try{
	            System.out.println("------------------------>fromdate"+fromdate);
	            DateFormat fdate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setFromdate1(fdate.parse(fromdate));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of fromdate"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.fromdate = fromdate;
	}
	public Date getFromdate1() {
		return fromdate1;
	}
	public void setFromdate1(Date fromdate1) {
		if(fromdate1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String fdate = formatter.format(fromdate1);
		         setFromdate2(fdate);
		        } 
			
			catch (Exception e)
		    {
				e.printStackTrace(); 
		    
		    }
		}
		
		this.fromdate1 = fromdate1;
	}
	public String getFromdate2() {
		return fromdate2;
	}
	public void setFromdate2(String fromdate2) {
		this.fromdate2 = fromdate2;
	}
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
	public Integer getTmonth() {
		return tmonth;
	}
	public void setTmonth(Integer tmonth) {
		this.tmonth = tmonth;
	}
	public Integer getTday() {
		return tday;
	}
	public void setTday(Integer tday) {
		this.tday = tday;
	}
	public Integer getBasic_pay() {
		return basic_pay;
	}
	public void setBasic_pay(Integer basic_pay) {
		this.basic_pay = basic_pay;
	}
	public Integer getGrade_pay() {
		return grade_pay;
	}
	public void setGrade_pay(Integer grade_pay) {
		this.grade_pay = grade_pay;
	}
	public Integer getSpecial_pay() {
		return special_pay;
	}
	public void setSpecial_pay(Integer special_pay) {
		this.special_pay = special_pay;
	}
	public Integer getOptionpay1() {
		return optionpay1;
	}
	public void setOptionpay1(Integer optionpay1) {
		this.optionpay1 = optionpay1;
	}
	public Integer getOptionpay2() {
		return optionpay2;
	}
	public void setOptionpay2(Integer optionpay2) {
		this.optionpay2 = optionpay2;
	}
	public Integer getOptionpay3() {
		return optionpay3;
	}
	public void setOptionpay3(Integer optionpay3) {
		this.optionpay3 = optionpay3;
	}
	
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public float getPpamount() {
		return ppamount;
	}
	public void setPpamount(float ppamount) {
		this.ppamount = ppamount;
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