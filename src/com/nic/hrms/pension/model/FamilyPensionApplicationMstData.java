package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FamilyPensionApplicationMstData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8682440100641745421L;

	private Integer empNo;
	private String empName;
	private String empInitial;
	private String gender;
	private Date dob;
	private String dob2;
	private Date doj;
	private String doj2;	
	private String designation;
	private Integer desigId;
	private Integer desigServiceGrp;
	private String grade;
	private Integer officeId;
	private String office;
	private Integer gpfNo;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getDesigId() {
		return desigId;
	}
	public void setDesigId(Integer desigId) {
		this.desigId = desigId;
	}
	public Integer getDesigServiceGrp() {
		return desigServiceGrp;
	}
	public void setDesigServiceGrp(Integer desigServiceGrp) {
		this.desigServiceGrp = desigServiceGrp;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		if(dob!=null)
		{
			DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
			String dobStr=df.format(dob);
			System.out.println("DOB STR"+dobStr);
			
			setDob2(dobStr);
		}
		this.dob = dob;
	}
	public void setDob2(String dob2) {
		this.dob2 = dob2;
	}
	public String getDob2() {
		return dob2;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		if(doj!=null)
		{
			DateFormat df2=new SimpleDateFormat("dd/MM/yyyy");
			String dojStr=df2.format(doj);
			System.out.println("DOJ STR"+dojStr);
			setDoj2(dojStr);
		}
		this.doj = doj;
	}
	public String getDoj2() {
		return doj2;
	}
	public void setDoj2(String doj2) {
		this.doj2 = doj2;
	}
	public void setGpfNo(Integer gpfNo) {
		this.gpfNo = gpfNo;
	}
	public Integer getGpfNo() {
		return gpfNo;
	}
	public void setEmpInitial(String empInitial) {
		this.empInitial = empInitial;
	}
	public String getEmpInitial() {
		return empInitial;
	}
	
	
	
}
