package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PensionApplicationForm2Dao implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3128383921357217723L;
	
	private Integer empNo;
	private String empName;
	private String gender;
	private Integer desigServiceGrp;
	private Integer desigId;
	private String gradeId;
	private Integer officeId;	
	private Integer gpfNo;	
	private String fatherName;	
	private String husbandName;	
	
	private String religion;
	private String nationality;
	private String empHeight;
	private String idMark1;
	private String idMark2;
	private String presentAddress;
	private String permanentAddress;	
	private String addressAfterRetire;
	private Integer stateId;
	private String chargesFlag;
	private String chargeDetails;	
	private Integer pensionPayOfficeId;	
	private String pensionPayOfficeId1;	
	
	private String appliedDate;
	private Date appliedDate1;
	private String appliedDate2;
	
	//TAB 1 DCRG Nominee Details		
	private String dcrgNomineeName;	
	private String dcrgRelation;
	private String dcrgAddress;				
	private String dcrgNomineeDob; 
	private Date dcrgNomineeDob1;
	private String dcrgNomineeDob2;
	
	//TAB 2 Not verified Service Details	
	private Integer notVerifyServiceTotYears;
	private Integer notVerifyServiceTotMonths;
	private Integer notVerifyServiceTotDays;

	private String processStatus;
	private String updatedUser;
	private Timestamp updatedDate;
	private String unlockedBy;
	private Timestamp unlockedDate;
	
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public Integer getDesigServiceGrp() {
		return desigServiceGrp;
	}
	public void setDesigServiceGrp(Integer desigServiceGrp) {
		this.desigServiceGrp = desigServiceGrp;
	}
	public Integer getDesigId() {
		return desigId;
	}
	public void setDesigId(Integer desigId) {
		this.desigId = desigId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmpHeight() {
		return empHeight;
	}
	public void setEmpHeight(String empHeight) {
		this.empHeight = empHeight;
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
		this.stateId = stateId;
	}
	public String getAddressAfterRetire() {
		return addressAfterRetire;
	}
	public void setAddressAfterRetire(String addressAfterRetire) {
		this.addressAfterRetire = addressAfterRetire;
	}
	
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	
	public Integer getGpfNo() {
		return gpfNo;
	}
	public void setGpfNo(Integer gpfNo) {
		this.gpfNo = gpfNo;
	}
	public String getChargesFlag() {
		return chargesFlag;
	}
	public void setChargesFlag(String chargesFlag) {
		this.chargesFlag = chargesFlag;
	}
	public String getChargeDetails() {
		return chargeDetails;
	}
	public void setChargeDetails(String chargeDetails) {
		this.chargeDetails = chargeDetails;
	}
	public Integer getPensionPayOfficeId() {
		return pensionPayOfficeId;
	}
	public void setPensionPayOfficeId(Integer pensionPayOfficeId) {
		setPensionPayOfficeId1(pensionPayOfficeId+"");
		this.pensionPayOfficeId = pensionPayOfficeId;
	}
	public String getDcrgNomineeName() {
		return dcrgNomineeName;
	}
	public void setDcrgNomineeName(String dcrgNomineeName) {
		this.dcrgNomineeName = dcrgNomineeName;
	}
	public String getDcrgRelation() {
		return dcrgRelation;
	}
	public void setDcrgRelation(String dcrgRelation) {
		this.dcrgRelation = dcrgRelation;
	}
	public String getDcrgAddress() {
		return dcrgAddress;
	}
	public void setDcrgAddress(String dcrgAddress) {
		this.dcrgAddress = dcrgAddress;
	}
	
	public Integer getNotVerifyServiceTotYears() {
		return notVerifyServiceTotYears;
	}
	public void setNotVerifyServiceTotYears(Integer notVerifyServiceTotYears) {
		this.notVerifyServiceTotYears = notVerifyServiceTotYears;
	}
	public Integer getNotVerifyServiceTotMonths() {
		return notVerifyServiceTotMonths;
	}
	public void setNotVerifyServiceTotMonths(Integer notVerifyServiceTotMonths) {
		this.notVerifyServiceTotMonths = notVerifyServiceTotMonths;
	}
	public Integer getNotVerifyServiceTotDays() {
		return notVerifyServiceTotDays;
	}
	public void setNotVerifyServiceTotDays(Integer notVerifyServiceTotDays) {
		this.notVerifyServiceTotDays = notVerifyServiceTotDays;
	}
	

	
	
	
	public String getDcrgNomineeDob() {
		return dcrgNomineeDob;
	}
	public void setDcrgNomineeDob(String dcrgNomineeDob) {
		
		if(dcrgNomineeDob.trim()!=null && dcrgNomineeDob.trim().length()>0)
		{
			try
			{
				DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
				setDcrgNomineeDob1(df.parse(dcrgNomineeDob));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		this.dcrgNomineeDob = dcrgNomineeDob;
	}
	public Date getDcrgNomineeDob1() {
		return dcrgNomineeDob1;
	}
	public void setDcrgNomineeDob1(Date dcrgNomineeDob1) {
		if(dcrgNomineeDob1!=null)			
		{
			try
			{
				DateFormat df1=new SimpleDateFormat("dd/MM/yyyy");
				String str=df1.format(dcrgNomineeDob1);
				setDcrgNomineeDob2(str);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		this.dcrgNomineeDob1 = dcrgNomineeDob1;
	}
	public String getDcrgNomineeDob2() {
		return dcrgNomineeDob2;
	}
	public void setDcrgNomineeDob2(String dcrgNomineeDob2) {
		this.dcrgNomineeDob2 = dcrgNomineeDob2;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}
	public String getHusbandName() {
		return husbandName;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public String getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(String appliedDate) {
		if(appliedDate.trim()!=null && appliedDate.trim().length()>0)
		{			
			try {
				DateFormat df=new SimpleDateFormat("dd/MM/yyyy");	
				setAppliedDate1(df.parse(appliedDate));
			} 
			catch (ParseException e) {			
				e.printStackTrace();
			}
		}
		this.appliedDate = appliedDate;
	}
	public Date getAppliedDate1() {
		return appliedDate1;
	}
	public void setAppliedDate1(Date appliedDate1) {
		if(appliedDate1!=null)
		{
			try
			{
				DateFormat df1=new SimpleDateFormat("dd/MM/yyyy");
				String sr=df1.format(appliedDate1);
				setAppliedDate2(sr);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		this.appliedDate1 = appliedDate1;
	}
	
	public String getAppliedDate2() {
		return appliedDate2;
	}
	public void setAppliedDate2(String appliedDate2) {
		this.appliedDate2 = appliedDate2;
	}
	public String getUnlockedBy() {
		return unlockedBy;
	}
	public void setUnlockedBy(String unlockedBy) {
		this.unlockedBy = unlockedBy;
	}
	public Timestamp getUnlockedDate() {
		return unlockedDate;
	}
	public void setUnlockedDate(Timestamp unlockedDate) {
		this.unlockedDate = unlockedDate;
	}
	public void setPensionPayOfficeId1(String pensionPayOfficeId1) {
		this.pensionPayOfficeId1 = pensionPayOfficeId1;
	}
	public String getPensionPayOfficeId1() {
		return pensionPayOfficeId1;
	}
	
	
	
}
	