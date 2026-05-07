package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.ChangeCommutationDao;
import com.nic.hrms.pension.model.ValidatePensionerDetails;
import com.nic.hrms.pension.service.ChangePensionerCommutationService;
import com.nic.hrms.pension.service.UpdatedUserIdService;

@SuppressWarnings("serial")
public class ChangePensionerCommutationAction extends BaseAction {
	
	ChangePensionerCommutationService changeCommServ;
	 private ChangeCommutationDao changeComm;
	private String searchText;
	private String options;
	private int empId;
	
	private UpdatedUserIdService updateservice;
	
	

	public String loadMstCommutation()
	{
		try
		{
		StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		System.out.println("check1");
		ValidatePensionerDetails obj=changeCommServ.loadMstCommutation(changeComm.getPpoNo());
		
		xmlString.append("<response>");
		xmlString.append("<command>search</command>");
		if(obj!=null)
		{
	    xmlString.append("<flag>success</flag>");
	    xmlString.append("<ppono>"+obj.getPpoNo()+"</ppono>");
	    xmlString.append("<commopted>"+obj.getCommOpted()+"</commopted>");
	    xmlString.append("<commreceived>"+obj.getCommReceived()+"</commreceived>");
	    xmlString.append("<commfactoronethird>"+obj.getCommfactorOnethird()+"</commfactoronethird>");
	    xmlString.append("<commfactorpert>"+obj.getCommFactorPert()+"</commfactorpert>");
	    xmlString.append("<commamt>"+obj.getCommAmt()+"</commamt>");
	    xmlString.append("<commpaydate>"+obj.getCommPayDate1()+"</commpaydate>");
	    xmlString.append("<reducedpensionamt>"+obj.getReducedPensionAmt()+"</reducedpensionamt>");
	    
	    
		}
		else
		{
			xmlString.append("<flag>NoRecord</flag>");
		}
		
		
		xmlString.append("</response>");
		 getResponse().setContentType("text/xml");
		 System.out.println(xmlString.toString());
		 out.println(xmlString.toString());
		 out.flush();
		 out.close();
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	
	public String loadChangedCommutation()
	{
		try
		{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			
			//out.println(changepensionerpaymentofcservice.changedPaymentOfficeLoad(cppOffice.getPpoNo()));
			ChangeCommutationDao obj=changeCommServ.changedCommutationLoad(changeComm.getPpoNo());
			xmlString.append("<response>");
			xmlString.append("<command>search</command>");
			if(obj!=null)
			{
		    xmlString.append("<flag>success</flag>");
		    xmlString.append("<ppono>"+obj.getPpoNo()+"</ppono>");
		    xmlString.append("<commopted>"+obj.getCommOpted()+"</commopted>");
		    xmlString.append("<commreceived>"+obj.getCommRecd()+"</commreceived>");
		    xmlString.append("<commfactoronethird>"+obj.getCommFactorOneThird()+"</commfactoronethird>");
		    xmlString.append("<commfactorpert>"+obj.getCommFactorPert()+"</commfactorpert>");
		    xmlString.append("<commamt>"+obj.getCommAmt()+"</commamt>");
		    xmlString.append("<commpaydate>"+obj.getCommPayDate()+"</commpaydate>");
		    xmlString.append("<reducedpensionamt>"+obj.getReducedPensionAmt()+"</reducedpensionamt>");
		    xmlString.append("<reason>"+obj.getReason()+"</reason>");
		     
			}
			else
			{
				xmlString.append("<flag>NoRecord</flag>");
			}
			
			
			xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 System.out.println(xmlString.toString());
			 out.println(xmlString.toString());
			 out.flush();
			 out.close();
			
			
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
	}
	
	public String commutationSearch()
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
						
			objsearchlist=changeCommServ.commutationPPO(searchText, options, empId);
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
			

			//objsearchlist=changepensionerpaymentofcservice.changedPPo(searchText, options, empId);
			objsearchlist=changeCommServ.changedPPo(searchText, options, empId);
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
		try
		{
			PrintWriter out = getResponse().getWriter();
			getResponse().setContentType("text/xml");
			
			int empId4=0;
			try
			{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId4=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId4);
			changeComm.setUpdatedBy(updatedId);
			changeComm.setUnlockedBy(updatedId);
			System.out.println("===============INSIDE ACTION4 ===============>updatedId"+updatedId);	
			}
			catch(Exception e)
			{
				System.out.println("Error in Getting Session Value");
			}			
			
			
			changeComm.setProcessStatus("VALIDATE");
			changeComm.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));				
			changeComm.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			//out.print(changepensionerpaymentofcservice.paymentOfficeChange(cppOffice));
			out.print(changeCommServ.commutationChange(changeComm));
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
		
	public String Validate()
	{
		try
		{
			PrintWriter out = getResponse().getWriter();
			getResponse().setContentType("text/xml");
			
			int empId3=0;
			try
			{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId3=empProfile.getEmployeeId();
			String updatedId=updateservice.getUpdateId(empId3);
			changeComm.setUpdatedBy(updatedId);
			changeComm.setUnlockedBy(updatedId);
			System.out.println("===============INSIDE ACTION2 ===============>updatedId"+updatedId);	
			}
			catch(Exception e)
			{
				System.out.println("Error in Getting Session Value");
			}			
			
			
			changeComm.setProcessStatus("VALIDATE");
			changeComm.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));				
			changeComm.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			
			boolean myFlag=false;
			if(changeCommServ.commutationChange(changeComm))
			{
				myFlag=changeCommServ.validateChangedCommutation(changeComm.getPpoNo());
			}
			
			out.print(myFlag);
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	
	
	
	public ChangePensionerCommutationService getChangeCommServ() {
		return changeCommServ;
	}

	public void setChangeCommServ(ChangePensionerCommutationService changeCommServ) {
		this.changeCommServ = changeCommServ;
	}

	public ChangeCommutationDao getChangeComm() {
		return changeComm;
	}

	public void setChangeComm(ChangeCommutationDao changeComm) {
		this.changeComm = changeComm;
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

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}
	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}

	

}
