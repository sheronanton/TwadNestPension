package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.DesignationCombo_dao;

public interface Designation_service {

	 List<DesignationCombo_dao> getDesignation( int gradeId);
}
