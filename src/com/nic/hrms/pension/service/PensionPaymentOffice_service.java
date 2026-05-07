package com.nic.hrms.pension.service;

import java.util.List;

import com.nic.hrms.pension.model.PensionPaymentOffice_dao;

public interface PensionPaymentOffice_service {

	List<PensionPaymentOffice_dao> getListOfPayOffice(int officeId);
}
