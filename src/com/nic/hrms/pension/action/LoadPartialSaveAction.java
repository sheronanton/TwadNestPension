package com.nic.hrms.pension.action;

import java.io.PrintWriter;

import com.nic.common.baseaction.BaseAction;

import com.nic.hrms.pension.model.LoadPartialSave_dao;
import com.nic.hrms.pension.service.LoadPartialSave_service;



public class LoadPartialSaveAction extends BaseAction {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5803032420941152226L;
	
	
	
	private LoadPartialSave_dao partialload;
	private LoadPartialSave_service partialservice;
	
	private int ppoNo;
	
	
	
	public String loadPartial(){
		
		try 
		{			
			StringBuffer xmlString = new StringBuffer();			
			PrintWriter out = getResponse().getWriter();
			//partialload = partialservice.getListOfPartialSave(ppoNo);
			
			int ppo = partialservice.getListOfPartialSave(ppoNo);	
			
			/*xmlString.append("<response>");
			xmlString.append("<command>Get</command>");
			xmlString.append("<flag>success</flag>");			
			xmlString.append("<record>");
			xmlString.append("<ppoNo>"+partialload.getPpoNo()+"</ppoNo>");*/
			/*xmlString.append("<empNo>"+partialload.getEmployeeId()+"</empNo>");
			xmlString.append("<empInitial>"+partialload.getPensionerInitial()+"</empInitial>");
			xmlString.append("<empName>"+partialload.getPensionerName()+"</empName>");
			xmlString.append("<gender>"+partialload.getSex()+"</gender>");
			xmlString.append("<titleId>"+partialload.getTitleId()+"</titleId>");
			xmlString.append("<dob>"+partialload.getDateOfBirth()+"</dob>");
			xmlString.append("<dor>"+partialload.getDateOfRetirement()+"</dor>");
			xmlString.append("<serviceGrpID>"+partialload.getDesigServGrp()+"</serviceGrpID>");
			xmlString.append("<designId>"+partialload.getDesignationId()+"</designId>");
			xmlString.append("<panNo>"+partialload.getPanNumber()+"</panNo>");
			xmlString.append("<idMark1>"+partialload.getIdMark1()+"</idMark1>");
			xmlString.append("<idMark2>"+partialload.getIdMark2()+"</idMark2>");
			xmlString.append("<lastPayDrawn>"+partialload.getLastPayDrawnAmt()+"</lastPayDrawn>");
			xmlString.append("<avgEmoulment>"+partialload.getAvgEmoulmentAmt()+"</avgEmoulment>");
			xmlString.append("<lastWorkingOfficeLevel>"+partialload.getLastWorkingOfficeLevel()+"</lastWorkingOfficeLevel>");
			xmlString.append("<lastWorkingOfficeId>"+partialload.getLastWorkingOfficeId()+"</lastWorkingOfficeId>");
			xmlString.append("<currAccOfficeId>"+partialload.getCurrAccountOfficeId()+"</currAccOfficeId>");
			xmlString.append("<cutOffEntryDate>"+partialload.getCutOfEntryDate()+"</cutOffEntryDate>");
			
			xmlString.append("<classPensionId>"+partialload.getClassPensionId()+"</classPensionId>");
			xmlString.append("<originalPensionAmt>"+partialload.getOriginalPensionAmt()+"</originalPensionAmt>");
			xmlString.append("<reducedPension>"+partialload.getReducedPensionAmt()+"</reducedPension>");
			xmlString.append("<dearnessPay>"+partialload.getDearnessPay()+"</dearnessPay>");
			xmlString.append("<provisionalPension>"+partialload.getProvisionalPensionAmt()+"</provisionalPension>");
			xmlString.append("<dcrgAmt>"+partialload.getDcrgAmt()+"</dcrgAmt>");		
			xmlString.append("<dcrgPertReceived>"+partialload.getDcrgPertReceived()+"</dcrgPertReceived>");
			//payment office			
			xmlString.append("<commOpted>"+partialload.getCommOpted()+"</commOpted>");
			xmlString.append("<commReceived>"+partialload.getCommReceived()+"</commReceived>");
			xmlString.append("<commfactorOnethird>"+partialload.getCommfactorOnethird()+"</commfactorOnethird>");		
			xmlString.append("<commAmt>"+partialload.getCommAmt()+"</commAmt>");
			xmlString.append("<commPayDate>"+partialload.getCommPayDate()+"</commPayDate>");	
			xmlString.append("<pshfSubscribed>"+partialload.getPshfSubscribed()+"</pshfSubscribed>");			
			xmlString.append("<familyPensionTillDate>"+partialload.getFamilyPensionTillDate()+"</familyPensionTillDate>");
			xmlString.append("<familyPensionTillDateAmt>"+partialload.getFamilyPensionTillDateAmt()+"</familyPensionTillDateAmt>");
			xmlString.append("<familyPensionAtferDateAmt>"+partialload.getFamilyPensionAtferDateAmt()+"</familyPensionAtferDateAmt>");
			xmlString.append("<payCommissionRevisonFlag>"+partialload.getPayCommissionRevisonFlag()+"</payCommissionRevisonFlag>");
			
			xmlString.append("<grossServiceYrs>"+partialload.getGrossServiceYrs()+"</grossServiceYrs>");
			xmlString.append("<grossServiceMonth>"+partialload.getGrossServiceMonth()+"</grossServiceMonth>");
			xmlString.append("<grossServiceDays>"+partialload.getGrossServiceDays()+"</grossServiceDays>");
			xmlString.append("<totServiceYrs>"+partialload.getTotServiceYrs()+"</totServiceYrs>");
			xmlString.append("<totServiceMonths>"+partialload.getTotServiceMonths()+"</totServiceMonths>");
			xmlString.append("<totServiceDays>"+partialload.getTotServiceDays()+"</totServiceDays>");
			xmlString.append("<quaServiceYrs>"+partialload.getQuaServiceYrs()+"</quaServiceYrs>");
			xmlString.append("<quaServiceMonths>"+partialload.getQuaServiceMonths()+"</quaServiceMonths>");
			xmlString.append("<quaServiceDays>"+partialload.getQuaServiceDays()+"</quaServiceDays>");
			xmlString.append("<nonquaServiceYrs>"+partialload.getNonquaServiceYrs()+"</nonquaServiceYrs>");
			xmlString.append("<nonquaServiceMonths>"+partialload.getNonquaServiceMonths()+"</nonquaServiceMonths>");
			xmlString.append("<nonquaServiceDays>"+partialload.getNonquaServiceDays()+"</nonquaServiceDays>");
			xmlString.append("<weightageServiceYrs>"+partialload.getWeightageServiceYrs()+"</weightageServiceYrs>");
			xmlString.append("<weightageServiceMonths>"+partialload.getWeightageServiceMonths()+"</weightageServiceMonths>");
			xmlString.append("<weightageServiceDays>"+partialload.getWeightageServiceDays()+"</weightageServiceDays>");
			xmlString.append("<netquaServiceYrs>"+partialload.getNetquaServiceYrs()+"</netquaServiceYrs>");
			xmlString.append("<netquaServiceMonths>"+partialload.getNetquaServiceMonths()+"</netquaServiceMonths>");
			xmlString.append("<netquaServiceDays>"+partialload.getNetquaServiceDays()+"</netquaServiceDays>");
			
			xmlString.append("<address>"+partialload.getAddress()+"</address>");
			xmlString.append("<district>"+partialload.getDistrict()+"</district>");
			xmlString.append("<state>"+partialload.getState()+"</state>");				
			xmlString.append("<pincode>"+partialload.getPincode()+"</pincode>");
			xmlString.append("<contactLandline>"+partialload.getContactLandline()+"</contactLandline>");
			xmlString.append("<contactCell>"+partialload.getContactCell()+"</contactCell>");
			xmlString.append("<faxNo>"+partialload.getFaxNo()+"</faxNo>");
			xmlString.append("<contactEmailId>"+partialload.getContactEmailId()+"</contactEmailId>");			
		
			xmlString.append("<pensionStatus>"+partialload.getPensionStatus()+"</pensionStatus>");
			xmlString.append("<pensionNotPaidFrmMon>"+partialload.getPensionNotPaidFrmMon()+"</pensionNotPaidFrmMon>");
			xmlString.append("<pensionNotPaidFrmYear>"+partialload.getPensionNotPaidFrmYear()+"</pensionNotPaidFrmYear>");
			xmlString.append("<lastSignatureDate>"+partialload.getLastSignatureDate()+"</lastSignatureDate>");
			
			xmlString.append("<bankId>"+partialload.getBankId()+"</bankId>");
			xmlString.append("<branchId>"+partialload.getBranchId()+"</branchId>");
			xmlString.append("<bankAcNo>"+partialload.getBankAcNo()+"</bankAcNo>");
			
			*/
			
			/*xmlString.append("</record>");
		
		 xmlString.append("</response>");*/
		 getResponse().setContentType("text/xml");
		 System.out.println(xmlString.toString());
		// out.print(partialload==null?"no":"yes");
		 out.print(ppo ==0 ?"no":"yes");
		 out.flush();
		 out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
		
	}




	public int getPpoNo() {
		return ppoNo;
	}

	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}

	public LoadPartialSave_dao getPartialload() {
		return partialload;
	}

	public void setPartialload(LoadPartialSave_dao partialload) {
		this.partialload = partialload;
	}


	public LoadPartialSave_service getPartialservice() {
		return partialservice;
	}


	public void setPartialservice(LoadPartialSave_service partialservice) {
		this.partialservice = partialservice;
	}


	
}
