package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.ChangePensionerPaymentOffice_dao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.service.ChangePensionerPaymentOfficeService;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionPaymentOffice_service;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class ChangePensionerPaymentOfficeAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PensionPaymentOffice_service paymentservice;
	
	private PensionerPaymentOfficeService paymentservice1;
	
	private ChangePensionerPaymentOfficeService changepensionerpaymentofcservice;
	
	private List<PensionPaymentOffice_dao> paymentload;
	
	
	private ChangePensionerPaymentOffice_dao cppOffice;
	private String searchText;
	private String options;
	private int empId;
	private OfficeId_service officeIdservice;
	
	private UpdatedUserIdService updateservice;
	
	
	

	public String load()
	{
	
		try {
		HttpSession session=getRequest().getSession();
	    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
	    System.out.println(empProfile.getEmployeeName());
	    empId=empProfile.getEmployeeId();
	    
	    
		}
		
		catch (Exception e) {
		e.printStackTrace();
		}
		
		int officeId = officeIdservice.getOfficeId(empId);
		
		// here a changed
		//paymentload = paymentservice.getListOfPayOffice(officeId);
		
		paymentload = paymentservice1.getListOfPayOffice();
		
		return SUCCESS;
	}

	public String loadPaymentOffice()
	{
		try
		{
			PrintWriter out = getResponse().getWriter();
			getResponse().setContentType("text/xml");
			out.println(changepensionerpaymentofcservice.paymentOfficeLoad(cppOffice.getPpoNo()));
			
		}
		catch(Exception e)
		{
			
		}
		
		return null;
	}
	
	
	public String loadChangedPaymentOffice()
	{
		try
		{
			PrintWriter out = getResponse().getWriter();
			getResponse().setContentType("text/xml");
			out.println(changepensionerpaymentofcservice.changedPaymentOfficeLoad(cppOffice.getPpoNo()));
			
		}
		catch(Exception e)
		{
			
		}
		
		return null;
	}
	
	public String PaymentOfficeSearch()
	{
		try{
			
			try {
				HttpSession session=getRequest().getSession();
			    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			    System.out.println(empProfile.getEmployeeName());
			    empId=empProfile.getEmployeeId();		    
				}
				
				catch (Exception e) {
				e.printStackTrace();
				}
			
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			List<Object[]> objsearchlist=null;
			xmlString.append("<response>");
			
			

			objsearchlist=changepensionerpaymentofcservice.paymentOfficePPO(searchText, options, empId);
			xmlString.append("<command>search</command>");
		    xmlString.append("<flag>success</flag>");
		   
		    for(Object[] tl: objsearchlist)
			 {
				Object[] temp=tl;
	    	     xmlString.append("<record>");
				 xmlString.append("<ppoNo>" +temp[0]+ "</ppoNo>");
				 xmlString.append("<employeeId>" +temp[1]+ "</employeeId>");
				 xmlString.append("<pensionerName>" +temp[2]+ "</pensionerName>");
				 xmlString.append("<classDescription>" +temp[3]+ "</classDescription>");
				 //xmlString.append("<processStatus>" +temp[4]+ "</processStatus>");
				 xmlString.append("</record>");				
	       }
		    
	    	 xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 System.out.println(xmlString.toString());
			 out.println(xmlString.toString());
			 out.flush();
			 out.close();
			
	   }
		   catch(Exception e){
		   System.out.println("error in searching the data to the databse"+e);
		   }
		  
		   return null;
	}
	
	public String loadChangedPPO()
	{
		try{
			
			try {
				HttpSession session=getRequest().getSession();
			    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			    System.out.println(empProfile.getEmployeeName());
			    empId=empProfile.getEmployeeId();
			    
			    
				}
				
				catch (Exception e) {
				e.printStackTrace();
				}
				
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			List<Object[]> objsearchlist=null;
			xmlString.append("<response>");
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SEARCH TEXT CONVERTED TO LOWER CASE...."+searchText);
			

			objsearchlist=changepensionerpaymentofcservice.changedPPo(searchText, options, empId);
			xmlString.append("<command>search</command>");
		    xmlString.append("<flag>success</flag>");
		   
		    for(Object[] tl: objsearchlist)
			 {
				Object[] temp=tl;
	    	     xmlString.append("<record>");
				 xmlString.append("<ppoNo>" +temp[0]+ "</ppoNo>");
				 xmlString.append("<employeeId>" +temp[1]+ "</employeeId>");
				 xmlString.append("<pensionerName>" +temp[2]+ "</pensionerName>");
				 xmlString.append("<classDescription>" +temp[3]+ "</classDescription>");
				 xmlString.append("<processStatus>" +temp[4]+ "</processStatus>");
				 xmlString.append("</record>");				
	       }
		    
	    	 xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 System.out.println(xmlString.toString());
			 out.println(xmlString.toString());
			 out.flush();
			 out.close();
			
	   }
		   catch(Exception e){
		   System.out.println("error in searching the data to the databse"+e);
		   }
		  
		   return null;
	}
	
	public String change()
	{
		System.out.println("calling change method....");
		try
		{
			PrintWriter out = getResponse().getWriter();
			getResponse().setContentType("text/xml");
			//System.out.println("reason--"+cppOffice.getReason());
			//System.out.println("updatedby-------"+cppOffice.getUpdatedBy());
			
			int empId1=0;
			try
			{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId1=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId1);
			cppOffice.setUpdatedBy(updatedId);
			cppOffice.setUnlockedBy(updatedId);
			System.out.println("===============INSIDE ACTION ===============>updatedId"+updatedId);	
			}
			catch(Exception e)
			{
				System.out.println("Error in Getting Session Value");
			}			
			
			
			cppOffice.setProcessStatus("VALIDATE");
			cppOffice.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));				
			cppOffice.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			
			out.print(changepensionerpaymentofcservice.paymentOfficeChange(cppOffice));
		}
		catch(Exception e)
		{
			
		}
		return null; // null
	}
	
	public String Validate()
	{
		try
		{
			PrintWriter out = getResponse().getWriter();
			getResponse().setContentType("text/xml");
			//System.out.println("reason--"+cppOffice.getReason());
			//System.out.println("updatedby-------"+cppOffice.getUpdatedBy());
			
			int empId2=0;
			try
			{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId2=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId2);
			cppOffice.setUpdatedBy(updatedId);
			cppOffice.setUnlockedBy(updatedId);
			System.out.println("===============INSIDE ACTION2 ===============>updatedId"+updatedId);	
			}
			catch(Exception e)
			{
				System.out.println("Error in Getting Session Value");
			}			
			
			
			cppOffice.setProcessStatus("VALIDATE");
			cppOffice.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));				
			cppOffice.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			
			
			boolean myFlag=false;
			if(changepensionerpaymentofcservice.paymentOfficeChange(cppOffice))
			{
				myFlag=changepensionerpaymentofcservice.validateChangedPaymentOffice(cppOffice.getPpoNo());
			}
			
			out.print(myFlag);
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;		
	}
	public ChangePensionerPaymentOffice_dao getCppOffice() {
		return cppOffice;
	}
	public void setCppOffice(ChangePensionerPaymentOffice_dao cppOffice) {
		this.cppOffice = cppOffice;
	}
	public PensionPaymentOffice_service getPaymentservice() {
		return paymentservice;
	}
	public void setPaymentservice(PensionPaymentOffice_service paymentservice) {
		this.paymentservice = paymentservice;
	}
	public List<PensionPaymentOffice_dao> getPaymentload() {
		return paymentload;
	}
	public void setPaymentload(List<PensionPaymentOffice_dao> paymentload) {
		this.paymentload = paymentload;
	}
	public ChangePensionerPaymentOfficeService getChangepensionerpaymentofcservice() {
		return changepensionerpaymentofcservice;
	}
	public void setChangepensionerpaymentofcservice(
			ChangePensionerPaymentOfficeService changepensionerpaymentofcservice) {
		this.changepensionerpaymentofcservice = changepensionerpaymentofcservice;
	}
	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}
	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}		
	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}
	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}

	public void setPaymentservice1(PensionerPaymentOfficeService paymentservice1) {
		this.paymentservice1 = paymentservice1;
	}

	public PensionerPaymentOfficeService getPaymentservice1() {
		return paymentservice1;
	}

}
