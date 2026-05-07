package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PensionApplicationHODetailsCoDao implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	// TAB 3 Death Cum Family pension 
	private String dcfpDeathCertFlag;
	private String dcfpDeathCertRemarks;
	private String dcfpHeirCertFlag;
	private String dcfpHeirCertRemarks;
	private String dcfpServiceBookFlag;
	private String dcfpServiceBookRemarks;
	private Integer dcfpLastPayDrwan;
	private String dcfpFamilyPensionFlag;
	private String dcfpFamilyPensionRemarks;
	private String dcfpPhotoAttachFlag;
	private String dcfpPhotoAttachRemarks;
	private String dcfpSignAttachFlag;
	private String dcfpSignAttachRemarks;
	private String dcfpNoDueCertFlag;
	private String dcfpNoDueCertRemarks;
	private String familyMembersList;
	private Integer dcfpPensionAmount;
	private Integer dcfpGratuityAmount;

	// TAB 4 Pension 
	private String penFamilyPensionFlag;
	private String penFamilyPensionRemarks;
	private String penPhotoAttachFlag;
	private String penPhotoAttachRemarks;
	private String penSignAttachFlag;
	private String penSignAttachRemarks;
	private String penNoDueCertFlag;
	private String penNoDueCertRemarks;
	private String penConsentRecoverFlag;
	private String penConsentRecoverRemarks;
	private String penDeathCertFlag;
	private String penDeathCertRemarks;
	private String penHeirCertFlag;
	private String penHeirCertRemarks;
	private String penServiceBookFlag;
	private String penServiceBookRemarks;
	private String penDeclareFlag;
	private String penDeclareRemarks;
	private String penRegardDateFlag;
	private String penRegardDateRemarks;
	private String penSanctionUptoDateFlag;
	private String penSanctionUptoDateRemarks;
	private String pensionPaymentPlace;
	private String dcrgPaymentPlace;
	private String recoveriesIfAny;
	private String retireOrderFlag;
	private String retireOrderRemarks;
	private String deputationIfAny;

	
	
	
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
	public String getDcfpDeathCertFlag() {
		return dcfpDeathCertFlag;
	}
	public void setDcfpDeathCertFlag(String dcfpDeathCertFlag) {
		this.dcfpDeathCertFlag = dcfpDeathCertFlag;
	}
	public String getDcfpDeathCertRemarks() {
		return dcfpDeathCertRemarks;
	}
	public void setDcfpDeathCertRemarks(String dcfpDeathCertRemarks) {
		this.dcfpDeathCertRemarks = dcfpDeathCertRemarks;
	}
	public String getDcfpHeirCertFlag() {
		return dcfpHeirCertFlag;
	}
	public void setDcfpHeirCertFlag(String dcfpHeirCertFlag) {
		this.dcfpHeirCertFlag = dcfpHeirCertFlag;
	}
	public String getDcfpHeirCertRemarks() {
		return dcfpHeirCertRemarks;
	}
	public void setDcfpHeirCertRemarks(String dcfpHeirCertRemarks) {
		this.dcfpHeirCertRemarks = dcfpHeirCertRemarks;
	}
	public String getDcfpServiceBookFlag() {
		return dcfpServiceBookFlag;
	}
	public void setDcfpServiceBookFlag(String dcfpServiceBookFlag) {
		this.dcfpServiceBookFlag = dcfpServiceBookFlag;
	}
	public String getDcfpServiceBookRemarks() {
		return dcfpServiceBookRemarks;
	}
	public void setDcfpServiceBookRemarks(String dcfpServiceBookRemarks) {
		this.dcfpServiceBookRemarks = dcfpServiceBookRemarks;
	}
	public Integer getDcfpLastPayDrwan() {
		return dcfpLastPayDrwan;
	}
	public void setDcfpLastPayDrwan(Integer dcfpLastPayDrwan) {
		this.dcfpLastPayDrwan = dcfpLastPayDrwan;
	}
	public String getDcfpFamilyPensionFlag() {
		return dcfpFamilyPensionFlag;
	}
	public void setDcfpFamilyPensionFlag(String dcfpFamilyPensionFlag) {
		this.dcfpFamilyPensionFlag = dcfpFamilyPensionFlag;
	}
	public String getDcfpFamilyPensionRemarks() {
		return dcfpFamilyPensionRemarks;
	}
	public void setDcfpFamilyPensionRemarks(String dcfpFamilyPensionRemarks) {
		this.dcfpFamilyPensionRemarks = dcfpFamilyPensionRemarks;
	}
	public String getDcfpPhotoAttachFlag() {
		return dcfpPhotoAttachFlag;
	}
	public void setDcfpPhotoAttachFlag(String dcfpPhotoAttachFlag) {
		this.dcfpPhotoAttachFlag = dcfpPhotoAttachFlag;
	}
	public String getDcfpPhotoAttachRemarks() {
		return dcfpPhotoAttachRemarks;
	}
	public void setDcfpPhotoAttachRemarks(String dcfpPhotoAttachRemarks) {
		this.dcfpPhotoAttachRemarks = dcfpPhotoAttachRemarks;
	}
	public String getDcfpSignAttachFlag() {
		return dcfpSignAttachFlag;
	}
	public void setDcfpSignAttachFlag(String dcfpSignAttachFlag) {
		this.dcfpSignAttachFlag = dcfpSignAttachFlag;
	}
	public String getDcfpSignAttachRemarks() {
		return dcfpSignAttachRemarks;
	}
	public void setDcfpSignAttachRemarks(String dcfpSignAttachRemarks) {
		this.dcfpSignAttachRemarks = dcfpSignAttachRemarks;
	}
	public String getDcfpNoDueCertFlag() {
		return dcfpNoDueCertFlag;
	}
	public void setDcfpNoDueCertFlag(String dcfpNoDueCertFlag) {
		this.dcfpNoDueCertFlag = dcfpNoDueCertFlag;
	}
	public String getDcfpNoDueCertRemarks() {
		return dcfpNoDueCertRemarks;
	}
	public void setDcfpNoDueCertRemarks(String dcfpNoDueCertRemarks) {
		this.dcfpNoDueCertRemarks = dcfpNoDueCertRemarks;
	}
	public String getFamilyMembersList() {
		return familyMembersList;
	}
	public void setFamilyMembersList(String familyMembersList) {
		this.familyMembersList = familyMembersList;
	}
	public Integer getDcfpPensionAmount() {
		return dcfpPensionAmount;
	}
	public void setDcfpPensionAmount(Integer dcfpPensionAmount) {
		this.dcfpPensionAmount = dcfpPensionAmount;
	}
	public Integer getDcfpGratuityAmount() {
		return dcfpGratuityAmount;
	}
	public void setDcfpGratuityAmount(Integer dcfpGratuityAmount) {
		this.dcfpGratuityAmount = dcfpGratuityAmount;
	}
	public String getPenFamilyPensionFlag() {
		return penFamilyPensionFlag;
	}
	public void setPenFamilyPensionFlag(String penFamilyPensionFlag) {
		this.penFamilyPensionFlag = penFamilyPensionFlag;
	}
	public String getPenFamilyPensionRemarks() {
		return penFamilyPensionRemarks;
	}
	public void setPenFamilyPensionRemarks(String penFamilyPensionRemarks) {
		this.penFamilyPensionRemarks = penFamilyPensionRemarks;
	}
	public String getPenPhotoAttachFlag() {
		return penPhotoAttachFlag;
	}
	public void setPenPhotoAttachFlag(String penPhotoAttachFlag) {
		this.penPhotoAttachFlag = penPhotoAttachFlag;
	}
	public String getPenPhotoAttachRemarks() {
		return penPhotoAttachRemarks;
	}
	public void setPenPhotoAttachRemarks(String penPhotoAttachRemarks) {
		this.penPhotoAttachRemarks = penPhotoAttachRemarks;
	}
	public String getPenSignAttachFlag() {
		return penSignAttachFlag;
	}
	public void setPenSignAttachFlag(String penSignAttachFlag) {
		this.penSignAttachFlag = penSignAttachFlag;
	}
	public String getPenSignAttachRemarks() {
		return penSignAttachRemarks;
	}
	public void setPenSignAttachRemarks(String penSignAttachRemarks) {
		this.penSignAttachRemarks = penSignAttachRemarks;
	}
	public String getPenNoDueCertFlag() {
		return penNoDueCertFlag;
	}
	public void setPenNoDueCertFlag(String penNoDueCertFlag) {
		this.penNoDueCertFlag = penNoDueCertFlag;
	}
	public String getPenNoDueCertRemarks() {
		return penNoDueCertRemarks;
	}
	public void setPenNoDueCertRemarks(String penNoDueCertRemarks) {
		this.penNoDueCertRemarks = penNoDueCertRemarks;
	}
	public String getPenConsentRecoverFlag() {
		return penConsentRecoverFlag;
	}
	public void setPenConsentRecoverFlag(String penConsentRecoverFlag) {
		this.penConsentRecoverFlag = penConsentRecoverFlag;
	}
	public String getPenConsentRecoverRemarks() {
		return penConsentRecoverRemarks;
	}
	public void setPenConsentRecoverRemarks(String penConsentRecoverRemarks) {
		this.penConsentRecoverRemarks = penConsentRecoverRemarks;
	}
	public String getPenDeathCertFlag() {
		return penDeathCertFlag;
	}
	public void setPenDeathCertFlag(String penDeathCertFlag) {
		this.penDeathCertFlag = penDeathCertFlag;
	}
	public String getPenDeathCertRemarks() {
		return penDeathCertRemarks;
	}
	public void setPenDeathCertRemarks(String penDeathCertRemarks) {
		this.penDeathCertRemarks = penDeathCertRemarks;
	}
	public String getPenHeirCertFlag() {
		return penHeirCertFlag;
	}
	public void setPenHeirCertFlag(String penHeirCertFlag) {
		this.penHeirCertFlag = penHeirCertFlag;
	}
	public String getPenHeirCertRemarks() {
		return penHeirCertRemarks;
	}
	public void setPenHeirCertRemarks(String penHeirCertRemarks) {
		this.penHeirCertRemarks = penHeirCertRemarks;
	}
	public String getPenServiceBookFlag() {
		return penServiceBookFlag;
	}
	public void setPenServiceBookFlag(String penServiceBookFlag) {
		this.penServiceBookFlag = penServiceBookFlag;
	}
	public String getPenServiceBookRemarks() {
		return penServiceBookRemarks;
	}
	public void setPenServiceBookRemarks(String penServiceBookRemarks) {
		this.penServiceBookRemarks = penServiceBookRemarks;
	}
	public String getPenDeclareFlag() {
		return penDeclareFlag;
	}
	public void setPenDeclareFlag(String penDeclareFlag) {
		this.penDeclareFlag = penDeclareFlag;
	}
	public String getPenDeclareRemarks() {
		return penDeclareRemarks;
	}
	public void setPenDeclareRemarks(String penDeclareRemarks) {
		this.penDeclareRemarks = penDeclareRemarks;
	}
	public String getPenRegardDateFlag() {
		return penRegardDateFlag;
	}
	public void setPenRegardDateFlag(String penRegardDateFlag) {
		this.penRegardDateFlag = penRegardDateFlag;
	}
	public String getPenRegardDateRemarks() {
		return penRegardDateRemarks;
	}
	public void setPenRegardDateRemarks(String penRegardDateRemarks) {
		this.penRegardDateRemarks = penRegardDateRemarks;
	}
	public String getPenSanctionUptoDateFlag() {
		return penSanctionUptoDateFlag;
	}
	public void setPenSanctionUptoDateFlag(String penSanctionUptoDateFlag) {
		this.penSanctionUptoDateFlag = penSanctionUptoDateFlag;
	}
	public String getPenSanctionUptoDateRemarks() {
		return penSanctionUptoDateRemarks;
	}
	public void setPenSanctionUptoDateRemarks(String penSanctionUptoDateRemarks) {
		this.penSanctionUptoDateRemarks = penSanctionUptoDateRemarks;
	}
	public String getPensionPaymentPlace() {
		return pensionPaymentPlace;
	}
	public void setPensionPaymentPlace(String pensionPaymentPlace) {
		this.pensionPaymentPlace = pensionPaymentPlace;
	}
	public String getDcrgPaymentPlace() {
		return dcrgPaymentPlace;
	}
	public void setDcrgPaymentPlace(String dcrgPaymentPlace) {
		this.dcrgPaymentPlace = dcrgPaymentPlace;
	}
	public String getRecoveriesIfAny() {
		return recoveriesIfAny;
	}
	public void setRecoveriesIfAny(String recoveriesIfAny) {
		this.recoveriesIfAny = recoveriesIfAny;
	}
	public String getRetireOrderFlag() {
		return retireOrderFlag;
	}
	public void setRetireOrderFlag(String retireOrderFlag) {
		this.retireOrderFlag = retireOrderFlag;
	}
	public String getRetireOrderRemarks() {
		return retireOrderRemarks;
	}
	public void setRetireOrderRemarks(String retireOrderRemarks) {
		this.retireOrderRemarks = retireOrderRemarks;
	}
	public String getDeputationIfAny() {
		return deputationIfAny;
	}
	public void setDeputationIfAny(String deputationIfAny) {
		this.deputationIfAny = deputationIfAny;
	}
	
	
}
