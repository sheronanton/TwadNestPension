package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.AddNominee_dao;
import com.nic.hrms.pension.model.ChangeNominee_dao;
import com.nic.hrms.pension.model.MstNominee_dao;

public interface LoadNomineeService {
	public boolean CheckNomineeValidated(int PPoNo);
	public List<AddNominee_dao> loadNominee(int PPoNo);
	 public List<MstNominee_dao> loadMstNominee(int PPoNo);
	 public List<ChangeNominee_dao> loadChangeNominee(int PPoNo);

}
