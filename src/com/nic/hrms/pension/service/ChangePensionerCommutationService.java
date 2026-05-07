package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.ChangeCommutationDao;

import com.nic.hrms.pension.model.ValidatePensionerDetails;



public interface ChangePensionerCommutationService {
	public ValidatePensionerDetails loadMstCommutation(int PPONo);
	public boolean commutationChange(ChangeCommutationDao ChangeComm);
	public List<Object[]> commutationPPO(String searchText,String options,int empId );
	public List<Object[]> changedPPo(String searchText,String options,int empId );
	public ChangeCommutationDao changedCommutationLoad(int ppoNo);
	public boolean validateChangedCommutation(int ppoNo);

}
