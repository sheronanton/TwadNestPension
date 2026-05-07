package com.nic.hrms.pension.service;

import java.util.List;
import com.nic.hrms.pension.model.DesignationCombo_dao;


public interface Desiggroup_service {

	List<DesignationCombo_dao> getListOfDesig(int ppoNo);
	
}
