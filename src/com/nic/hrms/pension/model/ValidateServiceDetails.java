package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ValidateServiceDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5408132503309617021L;
	
	
	private int ppoNo;
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
	private String processStatus;
	private String updatedId;
	private Timestamp updatedDate;
	
	
	
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
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
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
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
