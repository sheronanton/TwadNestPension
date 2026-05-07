package com.nic.hrms.pension.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.ReligionService;
import com.nic.hrms.pension.service.State_service;

public class PensionApplicationAddForm2ComboAction extends BaseAction{

	private static final long serialVersionUID = 2390437376027789032L;

	
	//private PensionPaymentOffice_service paymentservice;


	private PensionerPaymentOfficeService paymentservice1;
	
	private State_service stateservice;
	private OfficeId_service officeIdservice;
	private ReligionService religionService;
	private List<ReligionDao> religionCombo;
	private List<State_dao> stateList;	
	private List<PensionPaymentOffice_dao> payOfficeList;
	
	public String loadCombo()
	{
		
		try
		{
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();			
		    
		    int officeId = officeIdservice.getOfficeId(empId);			    
			stateList=stateservice.getListOfstate();
			//payOfficeList = paymentservice.getListOfPayOffice(officeId);			
			payOfficeList = paymentservice1.getListOfPayOffice();
			religionCombo=religionService.getReligionList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
		
		
	}

	
	public List<State_dao> getStateList() {
		return stateList;
	}


	public void setStateList(List<State_dao> stateList) {
		this.stateList = stateList;
	}


	public State_service getStateservice() {
		return stateservice;
	}


	public void setStateservice(State_service stateservice) {
		this.stateservice = stateservice;
	}


	public List<PensionPaymentOffice_dao> getPayOfficeList() {
		return payOfficeList;
	}


	public void setPayOfficeList(List<PensionPaymentOffice_dao> payOfficeList) {
		this.payOfficeList = payOfficeList;
	}


	/*public PensionPaymentOffice_service getPaymentservice() {
		return paymentservice;
	}


	public void setPaymentservice(PensionPaymentOffice_service paymentservice) {
		this.paymentservice = paymentservice;
	}
*/

	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}


	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}


	public void setPaymentservice1(PensionerPaymentOfficeService paymentservice1) {
		this.paymentservice1 = paymentservice1;
	}


	public PensionerPaymentOfficeService getPaymentservice1() {
		return paymentservice1;
	}


	public void setReligionService(ReligionService religionService) {
		this.religionService = religionService;
	}


	public ReligionService getReligionService() {
		return religionService;
	}


	public void setReligionCombo(List<ReligionDao> religionCombo) {
		this.religionCombo = religionCombo;
	}


	public List<ReligionDao> getReligionCombo() {
		return religionCombo;
	}

}
