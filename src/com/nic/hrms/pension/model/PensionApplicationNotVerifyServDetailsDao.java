package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PensionApplicationNotVerifyServDetailsDao implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3358902748145108358L;

	private Integer id;	
	private Integer empNo;
	private String notVerifyServFromDate;
	private String notVerifyServToDate;	
	private String notVerifyServiceReason;
	private Integer notVerifyYear;
	private Integer notVerifyMonth;
	private Integer notVerifyDays;
	
	private Date notVerifyServFromDate1;
	private String notVerifyServFromDate2;	
	
	private Date notVerifyServToDate1;	
	private String notVerifyServToDate2;
	
	private String processStatus;
	
	private String updatedUserId;
	private Timestamp updatedDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	

	
	public String getNotVerifyServiceReason() {
		return notVerifyServiceReason;
	}
	public void setNotVerifyServiceReason(String notVerifyServiceReason) {
		this.notVerifyServiceReason = notVerifyServiceReason;
	}
	public Integer getNotVerifyYear() {
		return notVerifyYear;
	}
	public void setNotVerifyYear(Integer notVerifyYear) {
		this.notVerifyYear = notVerifyYear;
	}
	public Integer getNotVerifyMonth() {
		return notVerifyMonth;
	}
	public void setNotVerifyMonth(Integer notVerifyMonth) {
		this.notVerifyMonth = notVerifyMonth;
	}
	public Integer getNotVerifyDays() {
		return notVerifyDays;
	}
	public void setNotVerifyDays(Integer notVerifyDays) {
		this.notVerifyDays = notVerifyDays;
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
	
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	
	
	
	public String getNotVerifyServFromDate() {
		return notVerifyServFromDate;
	}
	public void setNotVerifyServFromDate(String notVerifyServFromDate) {
		if(notVerifyServFromDate.trim()!=null && notVerifyServFromDate.trim().length()>0)
		{
			try
			{
			DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
			setNotVerifyServFromDate1(df.parse(notVerifyServFromDate));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		this.notVerifyServFromDate = notVerifyServFromDate;
	}
	public String getNotVerifyServToDate() {
		return notVerifyServToDate;
	}
	public void setNotVerifyServToDate(String notVerifyServToDate) {
		
		if(notVerifyServToDate.trim()!=null && notVerifyServToDate.trim().length()>0)
		{
			try
			{
				DateFormat df4=new SimpleDateFormat("dd/MM/yyyy");
				setNotVerifyServToDate1(df4.parse(notVerifyServToDate));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		this.notVerifyServToDate = notVerifyServToDate;
	}
	public void setNotVerifyServFromDate1(Date notVerifyServFromDate1) {
		if(notVerifyServFromDate1!=null)
		{
			try
			{
				DateFormat df1=new SimpleDateFormat("dd/MM/yyyy");
				String df2=df1.format(notVerifyServFromDate1);
				setNotVerifyServFromDate2(df2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		this.notVerifyServFromDate1 = notVerifyServFromDate1;
	}
	public Date getNotVerifyServFromDate1() {
		return notVerifyServFromDate1;
	}
	public void setNotVerifyServFromDate2(String notVerifyServFromDate2) {
		this.notVerifyServFromDate2 = notVerifyServFromDate2;
	}
	public String getNotVerifyServFromDate2() {
		return notVerifyServFromDate2;
	}
	public void setNotVerifyServToDate1(Date notVerifyServToDate1) {
		if(notVerifyServToDate1!=null)
		{
			try
			{
				DateFormat df5=new SimpleDateFormat("dd/MM/yyyy");
				String df4=df5.format(notVerifyServToDate1);
				setNotVerifyServToDate2(df4);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		this.notVerifyServToDate1 = notVerifyServToDate1;
	}
	public Date getNotVerifyServToDate1() {
		return notVerifyServToDate1;
	}
	public void setNotVerifyServToDate2(String notVerifyServToDate2) {
		this.notVerifyServToDate2 = notVerifyServToDate2;
	}
	public String getNotVerifyServToDate2() {
		return notVerifyServToDate2;
	}
	
	
	
	
	
}
