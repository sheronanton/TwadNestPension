package com.nic.hrms.pension.model;

import java.io.Serializable;

public class PpoNoCommonCheck implements Serializable{

	/**
	 * 
	 *  Table Name : HRM_PEN_MST_COMMON
	 */
	private static final long serialVersionUID = 8442411031089138538L;


	private Integer ppoNo;
	private String pensionerInitial;
	private String pensionerName;
	private String pensionFlag;
	

	public Integer getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(Integer ppoNo) {
		this.ppoNo = ppoNo;
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
	public String getPensionFlag() {
		return pensionFlag;
	}
	public void setPensionFlag(String pensionFlag) {
		this.pensionFlag = pensionFlag;
	}
	
	
	
	
	
}
