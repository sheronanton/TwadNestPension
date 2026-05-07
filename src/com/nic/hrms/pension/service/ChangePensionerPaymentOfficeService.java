package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.ChangePensionerPaymentOffice_dao;

public interface ChangePensionerPaymentOfficeService {
	public int paymentOfficeLoad(int ppoNo);
	public boolean paymentOfficeChange(ChangePensionerPaymentOffice_dao cppOffice);
	
	public List<Object[]> paymentOfficePPO(String searchText,String options,int empId );
	public List<Object[]> changedPPo(String searchText,String options,int empId );
	public String changedPaymentOfficeLoad(int ppoNo);
	public boolean validateChangedPaymentOffice(int ppoNo);

}
