package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateCutOffDetails_dao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2781144378267390898L;
	
	private int ppoNo;
	private int employeeId;
	private String sex;
	private int titleId;
	private String dateOfBirth;
	private String pensionerInitial;
	private String pensionerName;
	private String idMark1;
	private String idMark2;
	private String dateOfRetirement;
	private int lastPayDrawnAmt;
	private int avgEmoulmentAmt;
	private String panNumber;
	private int desigServGrp;
	private int designationId;
	private String lastWorkingOfficeLevel;
	private int lastWorkingOfficeId;
	private String cutOfEntryDate;
	private int currAccountOfficeId;
	private int classPensionId;
	private int paymentOfficeId;
	private String processStatus;
	private String pensionStatus;
	private Date dateOfBirth1;
	private Date dateOfRetirement1;
	private Date cutOfEntryDate1;
	private String updatedId;
	private Timestamp updatedDate;
	
	

	
	
	
	public Date getCutOfEntryDate1() {
		return cutOfEntryDate1;
	}
	public void setCutOfEntryDate1(Date cutOfEntryDate1) 
	{
		this.cutOfEntryDate1 = cutOfEntryDate1;
	}
	
	public void setCutOfEntryDate(String cutOfEntryDate)
	{
		if(cutOfEntryDate!=null && cutOfEntryDate.length()>0)
			{
				try
				{           
					DateFormat datecutoff = new SimpleDateFormat("dd/MM/yyyy");           
					setCutOfEntryDate1(datecutoff.parse(cutOfEntryDate));
				}
				catch(Exception e)
				{	                 
					e.printStackTrace();        
				}
		
			}
		this.cutOfEntryDate = cutOfEntryDate;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) 
	{		
		if(dateOfBirth!=null && dateOfBirth.length()>0)
		{
			try
			{           
				DateFormat dateofbirth = new SimpleDateFormat("dd/MM/yyyy");          
				setDateOfBirth1(dateofbirth.parse(dateOfBirth));
         	}
			catch(Exception e)
			{
                e.printStackTrace();        
         	}
		}
		
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getDateOfRetirement() {
		return dateOfRetirement;
	}
	public void setDateOfRetirement(String dateOfRetirement)
	{
		if(dateOfRetirement!=null && dateOfRetirement.length()>0)
		{
			try
			{            
				DateFormat dateofretire=new SimpleDateFormat("dd/MM/yyyy");          
				setDateOfRetirement1(dateofretire.parse(dateOfRetirement));
         	}
			catch(Exception e)
			{
                e.printStackTrace();        
         	}
		}
		this.dateOfRetirement = dateOfRetirement;
	}
	
	public Date getDateOfBirth1() {
		return dateOfBirth1;
	}
	public void setDateOfBirth1(Date dateOfBirth1) {
		this.dateOfBirth1 = dateOfBirth1;
	}
	public Date getDateOfRetirement1() {
		return dateOfRetirement1;
	}
	public void setDateOfRetirement1(Date dateOfRetirement1) {
		this.dateOfRetirement1 = dateOfRetirement1;
	}
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	
	public String getPensionerInitial() {
		return pensionerInitial;
	}
	public void setPensionerInitial(String pensionerInitial) {
		this.pensionerInitial = pensionerInitial;
	}
	public String getPensionerName() {
		return pensionerName;
	}
	public void setPensionerName(String pensionerName) {
		this.pensionerName = pensionerName;
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
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public int getDesigServGrp() {
		return desigServGrp;
	}
	public void setDesigServGrp(int desigServGrp) {
		this.desigServGrp = desigServGrp;
	}
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getLastWorkingOfficeLevel() {
		return lastWorkingOfficeLevel;
	}
	public void setLastWorkingOfficeLevel(String lastWorkingOfficeLevel) {
		this.lastWorkingOfficeLevel = lastWorkingOfficeLevel;
	}
	public int getLastWorkingOfficeId() {
		return lastWorkingOfficeId;
	}
	public void setLastWorkingOfficeId(int lastWorkingOfficeId) {
		this.lastWorkingOfficeId = lastWorkingOfficeId;
	}
	
	public int getCurrAccountOfficeId() {
		return currAccountOfficeId;
	}
	public void setCurrAccountOfficeId(int currAccountOfficeId) {
		this.currAccountOfficeId = currAccountOfficeId;
	}
	public int getClassPensionId() {
		return classPensionId;
	}
	public void setClassPensionId(int classPensionId) {
		this.classPensionId = classPensionId;
	}
	public int getPaymentOfficeId() {
		return paymentOfficeId;
	}
	public void setPaymentOfficeId(int paymentOfficeId) {
		this.paymentOfficeId = paymentOfficeId;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getPensionStatus() {
		return pensionStatus;
	}
	public void setPensionStatus(String pensionStatus) {
		this.pensionStatus = pensionStatus;
	}
	public String getCutOfEntryDate() {
		return cutOfEntryDate;
	}
	public int getLastPayDrawnAmt() {
		return lastPayDrawnAmt;
	}
	public void setLastPayDrawnAmt(int lastPayDrawnAmt) {
		this.lastPayDrawnAmt = lastPayDrawnAmt;
	}
	public int getAvgEmoulmentAmt() {
		return avgEmoulmentAmt;
	}
	public void setAvgEmoulmentAmt(int avgEmoulmentAmt) {
		this.avgEmoulmentAmt = avgEmoulmentAmt;
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
