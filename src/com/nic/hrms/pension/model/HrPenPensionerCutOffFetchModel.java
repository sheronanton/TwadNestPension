//package com.nic.pension.model;
package com.nic.hrms.pension.model;

import java.sql.Timestamp;
import java.util.*;


public class HrPenPensionerCutOffFetchModel {
	private int employeeId ;
	private String employeeName ;
	private String employeeInitial ;
    private String employeePrefix;
	private int gpfNo;
	private String panNo;
	
	private Date dateOfBirth ;
	
	
    private String bloodGroup;
    private String gender;
    private char communityId;
    private char religonId;
    private char motherTongueId;
    private char mediumOfStudyId;
    private int nativeDistrictCode;
    private int nativeTalukCode;
    private char employmentStatusId;
    private Date twadEntryDate;
    private int joinTimeDesigId;
    private char recruitmentModeId;
    private char serviceTobeCounted;
    private Date dateFromServiceCount;
    private char maritalStatus;
    private char empCurrentStatusId;
    private String remarks;
    private String updatedByUserId;
    private  Timestamp updatedDate;
    private String qualifications;
    private String otherDistricts;
    private String otherState;
    private char processFlowStatusId;
    private Date regularisationProbationDate;
    private String approvedProbationer;
    private String isConsolidate;
    private String empWkgGettingPension;
    private String isHandicapped;

    public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeInitial() {
		return employeeInitial;
	}
	public void setEmployeeInitial(String employeeInitial) {
		this.employeeInitial = employeeInitial;
	}
	public String getEmployeePrefix() {
		return employeePrefix;
	}
	public void setEmployeePrefix(String employeePrefix) {
		this.employeePrefix = employeePrefix;
	}
	public int getGpfNo() {
		return gpfNo;
	}
	public void setGpfNo(int gpfNo) {
		this.gpfNo = gpfNo;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public char getCommunityId() {
		return communityId;
	}
	public void setCommunityId(char communityId) {
		this.communityId = communityId;
	}
	public char getReligonId() {
		return religonId;
	}
	public void setReligonId(char religonId) {
		this.religonId = religonId;
	}
	public char getMotherTongueId() {
		return motherTongueId;
	}
	public void setMotherTongueId(char motherTongueId) {
		this.motherTongueId = motherTongueId;
	}
	public char getMediumOfStudyId() {
		return mediumOfStudyId;
	}
	public void setMediumOfStudyId(char mediumOfStudyId) {
		this.mediumOfStudyId = mediumOfStudyId;
	}
	public int getNativeDistrictCode() {
		return nativeDistrictCode;
	}
	public void setNativeDistrictCode(int nativeDistrictCode) {
		this.nativeDistrictCode = nativeDistrictCode;
	}
	public int getNativeTalukCode() {
		return nativeTalukCode;
	}
	public void setNativeTalukCode(int nativeTalukCode) {
		this.nativeTalukCode = nativeTalukCode;
	}
	public char getEmploymentStatusId() {
		return employmentStatusId;
	}
	public void setEmploymentStatusId(char employmentStatusId) {
		this.employmentStatusId = employmentStatusId;
	}
	public Date getTwadEntryDate() {
		return twadEntryDate;
	}
	public void setTwadEntryDate(Date twadEntryDate) {
		this.twadEntryDate = twadEntryDate;
	}
	public int getJoinTimeDesigId() {
		return joinTimeDesigId;
	}
	public void setJoinTimeDesigId(int joinTimeDesigId) {
		this.joinTimeDesigId = joinTimeDesigId;
	}
	public char getRecruitmentModeId() {
		return recruitmentModeId;
	}
	public void setRecruitmentModeId(char recruitmentModeId) {
		this.recruitmentModeId = recruitmentModeId;
	}
	public char getServiceTobeCounted() {
		return serviceTobeCounted;
	}
	public void setServiceTobeCounted(char serviceTobeCounted) {
		this.serviceTobeCounted = serviceTobeCounted;
	}
	public Date getDateFromServiceCount() {
		return dateFromServiceCount;
	}
	public void setDateFromServiceCount(Date dateFromServiceCount) {
		this.dateFromServiceCount = dateFromServiceCount;
	}
	public char getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public char getEmpCurrentStatusId() {
		return empCurrentStatusId;
	}
	public void setEmpCurrentStatusId(char empCurrentStatusId) {
		this.empCurrentStatusId = empCurrentStatusId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUpdatedByUserId() {
		return updatedByUserId;
	}
	public void setUpdatedByUserId(String updatedByUserId) {
		this.updatedByUserId = updatedByUserId;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getOtherDistricts() {
		return otherDistricts;
	}
	public void setOtherDistricts(String otherDistricts) {
		this.otherDistricts = otherDistricts;
	}
	public String getOtherState() {
		return otherState;
	}
	public void setOtherState(String otherState) {
		this.otherState = otherState;
	}
	public char getProcessFlowStatusId() {
		return processFlowStatusId;
	}
	public void setProcessFlowStatusId(char processFlowStatusId) {
		this.processFlowStatusId = processFlowStatusId;
	}
	public Date getRegularisationProbationDate() {
		return regularisationProbationDate;
	}
	public void setRegularisationProbationDate(Date regularisationProbationDate) {
		this.regularisationProbationDate = regularisationProbationDate;
	}
	public String getApprovedProbationer() {
		return approvedProbationer;
	}
	public void setApprovedProbationer(String approvedProbationer) {
		this.approvedProbationer = approvedProbationer;
	}
	public String getIsConsolidate() {
		return isConsolidate;
	}
	public void setIsConsolidate(String isConsolidate) {
		this.isConsolidate = isConsolidate;
	}
	public String getEmpWkgGettingPension() {
		return empWkgGettingPension;
	}
	public void setEmpWkgGettingPension(String empWkgGettingPension) {
		this.empWkgGettingPension = empWkgGettingPension;
	}
	public String getIsHandicapped() {
		return isHandicapped;
	}
	public void setIsHandicapped(String isHandicapped) {
		this.isHandicapped = isHandicapped;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	
	
  }
