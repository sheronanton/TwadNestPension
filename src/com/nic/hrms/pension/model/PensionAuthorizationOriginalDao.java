package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PensionAuthorizationOriginalDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer empNo;
	private Integer ppoNo;
	private Integer gpoNo;
	private String residentialAddress;
	private String fromAddress;
	private String namefromAddress;
	private String serviceBookAddress;
	private String officeStatus;
	private Integer lastWorkOfficeId;
	private String lastWorkOffice;
	private String lastWorkOfficeAddress;
	private Integer paymentOfficeId;
	private String paymentOfficeAddress;
	
	private String letterNo;
	private String datedOn;
	private Date datedOn1;
	private String datedOn2;
	private String reference;
	//private String authorizedOfficer;
	private Integer authorizedOfficer;
	private String authorizedOfficerAddress;
	
	private String processStatus;
	private String updateUser;
	private Timestamp updatedDate;
	private Integer nomineeId;
	private String nomineeName;
	private Integer nomineeRelationId;
	private String nomineeRelationDesc;
	
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public Integer getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(Integer ppoNo) {
		this.ppoNo = ppoNo;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	
	public String getOfficeStatus() {
		return officeStatus;
	}
	public void setOfficeStatus(String officeStatus) {
		this.officeStatus = officeStatus;
	}
	public String getLetterNo() {
		return letterNo;
	}
	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}
	public String getDatedOn() {
		return datedOn;
	}
	public void setDatedOn(String datedOn) {
		
		if(datedOn.trim() != null && datedOn.trim().length() >0)
		 {
		   try
		   {               
              DateFormat dateofbirth = new SimpleDateFormat("dd/MM/yyyy");
              setDatedOn1(dateofbirth.parse(datedOn));
		   }
		   catch(Exception e)
		   {         
               e.printStackTrace();               
          }
		 }
		
		this.datedOn = datedOn;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	/*public String getAuthorizedOfficer() {
		return authorizedOfficer;
	}
	public void setAuthorizedOfficer(String authorizedOfficer) {
		this.authorizedOfficer = authorizedOfficer;
	}*/	
	
	public String getAuthorizedOfficerAddress() {
		return authorizedOfficerAddress;
	}
	public Integer getAuthorizedOfficer() {
		return authorizedOfficer;
	}
	public void setAuthorizedOfficer(Integer authorizedOfficer) {
		this.authorizedOfficer = authorizedOfficer;
	}
	public void setAuthorizedOfficerAddress(String authorizedOfficerAddress) {
		this.authorizedOfficerAddress = authorizedOfficerAddress;
	}
	
	public void setPaymentOfficeAddress(String paymentOfficeAddress) {
		this.paymentOfficeAddress = paymentOfficeAddress;
	}
	public String getPaymentOfficeAddress() {
		return paymentOfficeAddress;
	}
	public void setLastWorkOfficeAddress(String lastWorkOfficeAddress) {
		this.lastWorkOfficeAddress = lastWorkOfficeAddress;
	}
	public String getLastWorkOfficeAddress() {
		return lastWorkOfficeAddress;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public void setDatedOn1(Date datedOn1) {
		
		if(datedOn1 != null)
		{
			try 
			{
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String dob1 = formatter.format(datedOn1);
				setDatedOn2(dob1);
	        }
			catch (Exception e)
			{				  
				e.printStackTrace();
			}
		
		}
		this.datedOn1 = datedOn1;
	}
	public Date getDatedOn1() {
		return datedOn1;
	}
	public void setDatedOn2(String datedOn2) {
		this.datedOn2 = datedOn2;
	}
	public String getDatedOn2() {
		return datedOn2;
	}
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public Integer getLastWorkOfficeId() {
		return lastWorkOfficeId;
	}
	public void setLastWorkOfficeId(Integer lastWorkOfficeId) {
		this.lastWorkOfficeId = lastWorkOfficeId;
	}
	public Integer getPaymentOfficeId() {
		return paymentOfficeId;
	}
	public void setPaymentOfficeId(Integer paymentOfficeId) {
		this.paymentOfficeId = paymentOfficeId;
	}
	public void setLastWorkOffice(String lastWorkOffice) {
		this.lastWorkOffice = lastWorkOffice;
	}
	public String getLastWorkOffice() {
		return lastWorkOffice;
	}
	public Integer getNomineeId() {
		return nomineeId;
	}
	public void setNomineeId(Integer nomineeId) {
		this.nomineeId = nomineeId;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public Integer getNomineeRelationId() {
		return nomineeRelationId;
	}
	public void setNomineeRelationId(Integer nomineeRelationId) {
		this.nomineeRelationId = nomineeRelationId;
	}
	public String getNomineeRelationDesc() {
		return nomineeRelationDesc;
	}
	public void setNomineeRelationDesc(String nomineeRelationDesc) {
		this.nomineeRelationDesc = nomineeRelationDesc;
	}
	public void setGpoNo(Integer gpoNo) {
		this.gpoNo = gpoNo;
	}
	public Integer getGpoNo() {
		return gpoNo;
	}
	public String getNamefromAddress() {
		return namefromAddress;
	}
	public void setNamefromAddress(String namefromAddress) {
		this.namefromAddress = namefromAddress;
	}
	public String getServiceBookAddress() {
		return serviceBookAddress;
	}
	public void setServiceBookAddress(String serviceBookAddress) {
		this.serviceBookAddress = serviceBookAddress;
	}
	
	
	
	
}
