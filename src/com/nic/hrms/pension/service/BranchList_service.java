package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.AjaxCombo_dao;

public interface BranchList_service {
	
	List <AjaxCombo_dao> getBranchList(int ppo_no,int officeIdNo);

}
