package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PensionApplicationHOForm1OthDeptServiceValDaoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer empNo;
	private String fromdate;
	private Date fromdate1;
	private String fromdate2;
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
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
}
