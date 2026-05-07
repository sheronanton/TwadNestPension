package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.util.Date;

public class HrPenPensionerCutOffEntryModel implements Serializable{

	
	  
	private static final long serialVersionUID = -8717466438563462190L;
		
	
		private int ppoNo;
		private int employeeId;
		private String pensionerInitial;
		private String sex;
		private int titleId;
		private String pensionerName;
		private Date dateOfBirth;
		private Date dateOfRetirement;
		private int desigServGrp;
		private int designationId;
		private String panNumber;		
		private String idMark1;
		private String idMark2;
		private float lastPayDrawnAmt;
		private float avgEmoulmentAmt;
		private String lastWorkingOfficeLevel;
		private int lastWorkingOfficeId;
		private int currAccountOfficeId;
		private Date cutOfEntryDate;
		private int classPensionId;
		private float originalPensionAmt;
		private float reducedPensionAmt;
		private float dearnessPay;
		private float provisionalPensionAmt;
		private float dcrgAmt;
		private float dcrgPertReceived;
		private int paymentOfficeId;
		private char commOpted;
		private char commReceived;	
		private String commfactorOnethird;
		private float commFactorPert;
		private float commAmt;
		private Date commPayDate;
		private String pshfSubscribed;
		private Date familyPensionTillDate;
		private float familyPensionTillDateAmt;
		private float familyPensionAfterDateAmt;
		private String payCommissionRevisonFlag;
		private int grossServiceYrs;
		private int grossServiceMonth;
		private int grossServiceDays;
	    private int totServiceYrs;	
	    private int totServiceMonths;
	    private int totServiceDays;
	    private int quaServiceYrs;
	    private int quaServiceMonths;
	    private int quaServiceDays;
	    private int nonquaServiceYrs;
	    private int nonquaServiceMonths;
	    private int nonquaServiceDays;
		private int weightageServiceYrs;
		private int weightageServiceMonths;
		private int weightageServiceDays;
		private int netquaServiceYrs;
		private int netquaServiceMonths;
		private int netquaServiceDays;
		private String address;
		private String district;
		private String state;
		private String pincode;
		private String contactLandline;
		private String contactCell;
		private String faxNo;
		private String contactEmailId;
		private String pensionStatus;
		private String pensionNotPaidFrmMon;
		private String pensionNotPaidFrmYear;
		private Date lastSignatureDate;
		private int bankId;
		private int branchId;
		private String bankAcNo;
		private byte[]familyPhoto;
	    private byte[]signatureAttachment;
	    private byte[]otherAttachment;
	    
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
		public String getPensionerInitial() {
			return pensionerInitial;
		}
		public void setPensionerInitial(String pensionerInitial) {
			this.pensionerInitial = pensionerInitial;
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
		public String getPensionerName() {
			return pensionerName;
		}
		public void setPensionerName(String pensionerName) {
			this.pensionerName = pensionerName;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Date getDateOfRetirement() {
			return dateOfRetirement;
		}
		public void setDateOfRetirement(Date dateOfRetirement) {
			this.dateOfRetirement = dateOfRetirement;
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
		public String getPanNumber() {
			return panNumber;
		}
		public void setPanNumber(String panNumber) {
			this.panNumber = panNumber;
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
		public float getLastPayDrawnAmt() {
			return lastPayDrawnAmt;
		}
		public void setLastPayDrawnAmt(float lastPayDrawnAmt) {
			this.lastPayDrawnAmt = lastPayDrawnAmt;
		}
		public float getAvgEmoulmentAmt() {
			return avgEmoulmentAmt;
		}
		public void setAvgEmoulmentAmt(float avgEmoulmentAmt) {
			this.avgEmoulmentAmt = avgEmoulmentAmt;
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
		public Date getCutOfEntryDate() {
			return cutOfEntryDate;
		}
		public void setCutOfEntryDate(Date cutOfEntryDate) {
			this.cutOfEntryDate = cutOfEntryDate;
		}
		public int getClassPensionId() {
			return classPensionId;
		}
		public void setClassPensionId(int classPensionId) {
			this.classPensionId = classPensionId;
		}
		public float getOriginalPensionAmt() {
			return originalPensionAmt;
		}
		public void setOriginalPensionAmt(float originalPensionAmt) {
			this.originalPensionAmt = originalPensionAmt;
		}
		public float getReducedPensionAmt() {
			return reducedPensionAmt;
		}
		public void setReducedPensionAmt(float reducedPensionAmt) {
			this.reducedPensionAmt = reducedPensionAmt;
		}
		public float getDearnessPay() {
			return dearnessPay;
		}
		public void setDearnessPay(float dearnessPay) {
			this.dearnessPay = dearnessPay;
		}
		public float getProvisionalPensionAmt() {
			return provisionalPensionAmt;
		}
		public void setProvisionalPensionAmt(float provisionalPensionAmt) {
			this.provisionalPensionAmt = provisionalPensionAmt;
		}
		public float getDcrgAmt() {
			return dcrgAmt;
		}
		public void setDcrgAmt(float dcrgAmt) {
			this.dcrgAmt = dcrgAmt;
		}
		public float getDcrgPertReceived() {
			return dcrgPertReceived;
		}
		public void setDcrgPertReceived(float dcrgPertReceived) {
			this.dcrgPertReceived = dcrgPertReceived;
		}
		public int getPaymentOfficeId() {
			return paymentOfficeId;
		}
		public void setPaymentOfficeId(int paymentOfficeId) {
			this.paymentOfficeId = paymentOfficeId;
		}
		public char getCommOpted() {
			return commOpted;
		}
		public void setCommOpted(char commOpted) {
			this.commOpted = commOpted;
		}
		public char getCommReceived() {
			return commReceived;
		}
		public void setCommReceived(char commReceived) {
			this.commReceived = commReceived;
		}
		public String getCommfactorOnethird() {
			return commfactorOnethird;
		}
		public void setCommfactorOnethird(String commfactorOnethird) {
			this.commfactorOnethird = commfactorOnethird;
		}
		public float getCommFactorPert() {
			return commFactorPert;
		}
		public void setCommFactorPert(float commFactorPert) {
			this.commFactorPert = commFactorPert;
		}
		public float getCommAmt() {
			return commAmt;
		}
		public void setCommAmt(float commAmt) {
			this.commAmt = commAmt;
		}
		public Date getCommPayDate() {
			return commPayDate;
		}
		public void setCommPayDate(Date commPayDate) {
			this.commPayDate = commPayDate;
		}
		public String getPshfSubscribed() {
			return pshfSubscribed;
		}
		public void setPshfSubscribed(String pshfSubscribed) {
			this.pshfSubscribed = pshfSubscribed;
		}
		public Date getFamilyPensionTillDate() {
			return familyPensionTillDate;
		}
		public void setFamilyPensionTillDate(Date familyPensionTillDate) {
			this.familyPensionTillDate = familyPensionTillDate;
		}
		public float getFamilyPensionTillDateAmt() {
			return familyPensionTillDateAmt;
		}
		public void setFamilyPensionTillDateAmt(float familyPensionTillDateAmt) {
			this.familyPensionTillDateAmt = familyPensionTillDateAmt;
		}
		public float getFamilyPensionAfterDateAmt() {
			return familyPensionAfterDateAmt;
		}
		public void setFamilyPensionAfterDateAmt(float familyPensionAfterDateAmt) {
			this.familyPensionAfterDateAmt = familyPensionAfterDateAmt;
		}
		public String getPayCommissionRevisonFlag() {
			return payCommissionRevisonFlag;
		}
		public void setPayCommissionRevisonFlag(String payCommissionRevisonFlag) {
			this.payCommissionRevisonFlag = payCommissionRevisonFlag;
		}
		public int getGrossServiceYrs() {
			return grossServiceYrs;
		}
		public void setGrossServiceYrs(int grossServiceYrs) {
			this.grossServiceYrs = grossServiceYrs;
		}
		public int getGrossServiceMonth() {
			return grossServiceMonth;
		}
		public void setGrossServiceMonth(int grossServiceMonth) {
			this.grossServiceMonth = grossServiceMonth;
		}
		public int getGrossServiceDays() {
			return grossServiceDays;
		}
		public void setGrossServiceDays(int grossServiceDays) {
			this.grossServiceDays = grossServiceDays;
		}
		public int getTotServiceYrs() {
			return totServiceYrs;
		}
		public void setTotServiceYrs(int totServiceYrs) {
			this.totServiceYrs = totServiceYrs;
		}
		public int getTotServiceMonths() {
			return totServiceMonths;
		}
		public void setTotServiceMonths(int totServiceMonths) {
			this.totServiceMonths = totServiceMonths;
		}
		public int getTotServiceDays() {
			return totServiceDays;
		}
		public void setTotServiceDays(int totServiceDays) {
			this.totServiceDays = totServiceDays;
		}
		public int getQuaServiceYrs() {
			return quaServiceYrs;
		}
		public void setQuaServiceYrs(int quaServiceYrs) {
			this.quaServiceYrs = quaServiceYrs;
		}
		public int getQuaServiceMonths() {
			return quaServiceMonths;
		}
		public void setQuaServiceMonths(int quaServiceMonths) {
			this.quaServiceMonths = quaServiceMonths;
		}
		public int getQuaServiceDays() {
			return quaServiceDays;
		}
		public void setQuaServiceDays(int quaServiceDays) {
			this.quaServiceDays = quaServiceDays;
		}
		public int getNonquaServiceYrs() {
			return nonquaServiceYrs;
		}
		public void setNonquaServiceYrs(int nonquaServiceYrs) {
			this.nonquaServiceYrs = nonquaServiceYrs;
		}
		public int getNonquaServiceMonths() {
			return nonquaServiceMonths;
		}
		public void setNonquaServiceMonths(int nonquaServiceMonths) {
			this.nonquaServiceMonths = nonquaServiceMonths;
		}
		public int getNonquaServiceDays() {
			return nonquaServiceDays;
		}
		public void setNonquaServiceDays(int nonquaServiceDays) {
			this.nonquaServiceDays = nonquaServiceDays;
		}
		public int getWeightageServiceYrs() {
			return weightageServiceYrs;
		}
		public void setWeightageServiceYrs(int weightageServiceYrs) {
			this.weightageServiceYrs = weightageServiceYrs;
		}
		public int getWeightageServiceMonths() {
			return weightageServiceMonths;
		}
		public void setWeightageServiceMonths(int weightageServiceMonths) {
			this.weightageServiceMonths = weightageServiceMonths;
		}
		public int getWeightageServiceDays() {
			return weightageServiceDays;
		}
		public void setWeightageServiceDays(int weightageServiceDays) {
			this.weightageServiceDays = weightageServiceDays;
		}
		public int getNetquaServiceYrs() {
			return netquaServiceYrs;
		}
		public void setNetquaServiceYrs(int netquaServiceYrs) {
			this.netquaServiceYrs = netquaServiceYrs;
		}
		public int getNetquaServiceMonths() {
			return netquaServiceMonths;
		}
		public void setNetquaServiceMonths(int netquaServiceMonths) {
			this.netquaServiceMonths = netquaServiceMonths;
		}
		public int getNetquaServiceDays() {
			return netquaServiceDays;
		}
		public void setNetquaServiceDays(int netquaServiceDays) {
			this.netquaServiceDays = netquaServiceDays;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getContactLandline() {
			return contactLandline;
		}
		public void setContactLandline(String contactLandline) {
			this.contactLandline = contactLandline;
		}
		public String getContactCell() {
			return contactCell;
		}
		public void setContactCell(String contactCell) {
			this.contactCell = contactCell;
		}
		public String getFaxNo() {
			return faxNo;
		}
		public void setFaxNo(String faxNo) {
			this.faxNo = faxNo;
		}
		public String getContactEmailId() {
			return contactEmailId;
		}
		public void setContactEmailId(String contactEmailId) {
			this.contactEmailId = contactEmailId;
		}
		public String getPensionStatus() {
			return pensionStatus;
		}
		public void setPensionStatus(String pensionStatus) {
			this.pensionStatus = pensionStatus;
		}
		public String getPensionNotPaidFrmMon() {
			return pensionNotPaidFrmMon;
		}
		public void setPensionNotPaidFrmMon(String pensionNotPaidFrmMon) {
			this.pensionNotPaidFrmMon = pensionNotPaidFrmMon;
		}
		public String getPensionNotPaidFrmYear() {
			return pensionNotPaidFrmYear;
		}
		public void setPensionNotPaidFrmYear(String pensionNotPaidFrmYear) {
			this.pensionNotPaidFrmYear = pensionNotPaidFrmYear;
		}
		public Date getLastSignatureDate() {
			return lastSignatureDate;
		}
		public void setLastSignatureDate(Date lastSignatureDate) {
			this.lastSignatureDate = lastSignatureDate;
		}
		public int getBankId() {
			return bankId;
		}
		public void setBankId(int bankId) {
			this.bankId = bankId;
		}
		public int getBranchId() {
			return branchId;
		}
		public void setBranchId(int branchId) {
			this.branchId = branchId;
		}
		public String getBankAcNo() {
			return bankAcNo;
		}
		public void setBankAcNo(String bankAcNo) {
			this.bankAcNo = bankAcNo;
		}
		public byte[] getFamilyPhoto() {
			return familyPhoto;
		}
		public void setFamilyPhoto(byte[] familyPhoto) {
			this.familyPhoto = familyPhoto;
		}
		public byte[] getSignatureAttachment() {
			return signatureAttachment;
		}
		public void setSignatureAttachment(byte[] signatureAttachment) {
			this.signatureAttachment = signatureAttachment;
		}
		public byte[] getOtherAttachment() {
			return otherAttachment;
		}
		public void setOtherAttachment(byte[] otherAttachment) {
			this.otherAttachment = otherAttachment;
		}
		
		
	
}
