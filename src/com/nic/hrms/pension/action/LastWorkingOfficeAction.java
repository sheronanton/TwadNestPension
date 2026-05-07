package com.nic.hrms.pension.action;


import java.io.PrintWriter;
import java.util.List;

import com.nic.common.baseaction.BaseAction;

import com.nic.hrms.pension.model.MstOfficeLevelModel;
import com.nic.hrms.pension.model.MstOfficeStatusModel;
import com.nic.hrms.pension.model.MstOfficesModel;
import com.nic.hrms.pension.service.LastWorkingOfficeService;

public class LastWorkingOfficeAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1682040473592639385L;


	private MstOfficesModel officeModel;
	private MstOfficeStatusModel statusModel;
	private MstOfficeLevelModel levelModel;
		
	private LastWorkingOfficeService officeService;
	
	List<Object[]> listoffice;
	
	public String loadoffices()
	{
		try 
		{
		StringBuffer xmlString = new StringBuffer();
		
		PrintWriter out = getResponse().getWriter();
		
		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		xmlString.append("<flag>success</flag>");
		
		
		listoffice = officeService.getOffice();
	

		 for(Object[] tl: listoffice)
		 {
			Object[] temp=tl;
			xmlString.append("<record>");			
			xmlString.append("<officeid>" +temp[0]+ "</officeid>");
			xmlString.append("<officename>" +temp[1]+ "</officename>");
			xmlString.append("<statusdesc>" +temp[2]+ "</statusdesc>");
			xmlString.append("<levelname>" +temp[3]+ "</levelname>");			
			xmlString.append("</record>");		
			
		 }
		
		 xmlString.append("</response>");
		 getResponse().setContentType("text/xml");
		 System.out.println(xmlString.toString());
		 out.println(xmlString.toString());
		 out.flush();
		 out.close();		 
		}
		
		
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
	
		
		return "success";
	}



	public MstOfficesModel getOfficeModel() {
		return officeModel;
	}



	public void setOfficeModel(MstOfficesModel officeModel) {
		this.officeModel = officeModel;
	}



	public MstOfficeStatusModel getStatusModel() {
		return statusModel;
	}



	public void setStatusModel(MstOfficeStatusModel statusModel) {
		this.statusModel = statusModel;
	}



	public LastWorkingOfficeService getOfficeService() {
		return officeService;
	}



	public void setOfficeService(LastWorkingOfficeService officeService) {
		this.officeService = officeService;
	}



	public List<Object[]> getListoffice() {
		return listoffice;
	}



	public void setListoffice(List<Object[]> listoffice) {
		this.listoffice = listoffice;
	}



	public MstOfficeLevelModel getLevelModel() {
		return levelModel;
	}



	public void setLevelModel(MstOfficeLevelModel levelModel) {
		this.levelModel = levelModel;
	}



	

	
}