package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.ChangeNominee_dao;

public interface AddChangeNomineeService {
	public boolean addChangeNominee(List<ChangeNominee_dao> myLi);
	 public boolean validateChangeNominee(int PPoNo);
	 public boolean deleteChangeNominee(int PPoNo);

}
