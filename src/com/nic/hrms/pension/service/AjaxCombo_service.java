package com.nic.hrms.pension.service;

import java.util.List;



import com.nic.hrms.pension.model.AjaxCombo_dao;

public interface AjaxCombo_service {
	
	List<AjaxCombo_dao> getListOfBranch(int bankId ,int officeId);
 
}
