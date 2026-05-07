package com.nic.hrms.pension.reports.model;

import java.io.Serializable;

public class Payrevisionreportmodeldetails implements Serializable
{
	
	
	java.math.BigDecimal PPO_NO;
	java.math.BigDecimal FOR_MONTH_FROM;
	java.math.BigDecimal FOR_YEAR_FROM;
	java.lang.String PENSIONER_NAME;
	java.lang.String PEN_FAMILYPEN_FLAG;
	java.math.BigDecimal ORIGINAL_PENSION;
	java.math.BigDecimal OLDPENSIONBASIC;
	java.math.BigDecimal DP;
	java.math.BigDecimal AP;
	java.math.BigDecimal DA;
	java.math.BigDecimal MED;
	java.math.BigDecimal OLD_OTH_EARNINGS;
	java.math.BigDecimal REVISED_ORIGINAL_PENSION;
	java.math.BigDecimal NEWPENSIONBASIC;
	java.math.BigDecimal NEW_DP;
	java.math.BigDecimal NEW_AP;
	java.math.BigDecimal NEW_DA;
	java.math.BigDecimal NEW_MED;
	java.math.BigDecimal NEW_OTH_EARNINGS;
	java.lang.String TITLE;
	java.lang.String CDATE;
	java.math.BigDecimal NEW_ALL_TOT;
	java.math.BigDecimal OLD_ALL_TOT;
	java.math.BigDecimal DIFFERENCE;
	
	
	
public java.math.BigDecimal getNEW_ALL_TOT() {
		return NEW_ALL_TOT;
	}
	public void setNEW_ALL_TOT(java.math.BigDecimal new_all_tot) {
		NEW_ALL_TOT = new_all_tot;
	}
	public java.math.BigDecimal getOLD_ALL_TOT() {
		return OLD_ALL_TOT;
	}
	public void setOLD_ALL_TOT(java.math.BigDecimal old_all_tot) {
		OLD_ALL_TOT = old_all_tot;
	}
	public java.math.BigDecimal getDIFFERENCE() {
		return DIFFERENCE;
	}
	public void setDIFFERENCE(java.math.BigDecimal difference) {
		DIFFERENCE = difference;
	}
private static final long serialVersionUID = 1L; 
	
	public java.math.BigDecimal getPPO_NO() {
		return PPO_NO;
	}
	public void setPPO_NO(java.math.BigDecimal ppo_no) {
		PPO_NO = ppo_no;
	}
	public java.math.BigDecimal getFOR_MONTH_FROM() {
		return FOR_MONTH_FROM;
	}
	public void setFOR_MONTH_FROM(java.math.BigDecimal for_month_from) {
		FOR_MONTH_FROM = for_month_from;
	}
	public java.math.BigDecimal getFOR_YEAR_FROM() {
		return FOR_YEAR_FROM;
	}
	public void setFOR_YEAR_FROM(java.math.BigDecimal for_year_from) {
		FOR_YEAR_FROM = for_year_from;
	}
	public java.lang.String getPENSIONER_NAME() {
		return PENSIONER_NAME;
	}
	public void setPENSIONER_NAME(java.lang.String pensioner_name) {
		PENSIONER_NAME = pensioner_name;
	}
	
	public java.lang.String getPEN_FAMILYPEN_FLAG() {
		return PEN_FAMILYPEN_FLAG;
	}
	public void setPEN_FAMILYPEN_FLAG(java.lang.String pen_familypen_flag) {
		PEN_FAMILYPEN_FLAG = pen_familypen_flag;
	}
	public java.math.BigDecimal getORIGINAL_PENSION() {
		return ORIGINAL_PENSION;
	}
	public void setORIGINAL_PENSION(java.math.BigDecimal original_pension) {
		ORIGINAL_PENSION = original_pension;
	}
	public java.math.BigDecimal getOLDPENSIONBASIC() {
		return OLDPENSIONBASIC;
	}
	public void setOLDPENSIONBASIC(java.math.BigDecimal oldpensionbasic) {
		OLDPENSIONBASIC = oldpensionbasic;
	}
	public java.math.BigDecimal getDP() {
		return DP;
	}
	public void setDP(java.math.BigDecimal dp) {
		DP = dp;
	}
	public java.math.BigDecimal getAP() {
		return AP;
	}
	public void setAP(java.math.BigDecimal ap) {
		AP = ap;
	}
	public java.math.BigDecimal getDA() {
		return DA;
	}
	public void setDA(java.math.BigDecimal da) {
		DA = da;
	}
	public java.math.BigDecimal getMED() {
		return MED;
	}
	public void setMED(java.math.BigDecimal med) {
		MED = med;
	}
	public java.math.BigDecimal getOLD_OTH_EARNINGS() {
		return OLD_OTH_EARNINGS;
	}
	public void setOLD_OTH_EARNINGS(java.math.BigDecimal old_oth_earnings) {
		OLD_OTH_EARNINGS = old_oth_earnings;
	}
	public java.math.BigDecimal getREVISED_ORIGINAL_PENSION() {
		return REVISED_ORIGINAL_PENSION;
	}
	public void setREVISED_ORIGINAL_PENSION(
			java.math.BigDecimal revised_original_pension) {
		REVISED_ORIGINAL_PENSION = revised_original_pension;
	}
	public java.math.BigDecimal getNEWPENSIONBASIC() {
		return NEWPENSIONBASIC;
	}
	public void setNEWPENSIONBASIC(java.math.BigDecimal newpensionbasic) {
		NEWPENSIONBASIC = newpensionbasic;
	}
	public java.math.BigDecimal getNEW_DP() {
		return NEW_DP;
	}
	public void setNEW_DP(java.math.BigDecimal new_dp) {
		NEW_DP = new_dp;
	}
	public java.math.BigDecimal getNEW_AP() {
		return NEW_AP;
	}
	public void setNEW_AP(java.math.BigDecimal new_ap) {
		NEW_AP = new_ap;
	}
	public java.math.BigDecimal getNEW_DA() {
		return NEW_DA;
	}
	public void setNEW_DA(java.math.BigDecimal new_da) {
		NEW_DA = new_da;
	}
	public java.math.BigDecimal getNEW_MED() {
		return NEW_MED;
	}
	public void setNEW_MED(java.math.BigDecimal new_med) {
		NEW_MED = new_med;
	}
	public java.math.BigDecimal getNEW_OTH_EARNINGS() {
		return NEW_OTH_EARNINGS;
	}
	public void setNEW_OTH_EARNINGS(java.math.BigDecimal new_oth_earnings) {
		NEW_OTH_EARNINGS = new_oth_earnings;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public java.lang.String getTITLE() {
		return TITLE;
	}
	public void setTITLE(java.lang.String title) {
		TITLE = title;
	}
	public java.lang.String getCDATE() {
		return CDATE;
	}
	public void setCDATE(java.lang.String cdate) {
		CDATE = cdate;
	}
	
	
	

}
