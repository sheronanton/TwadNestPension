package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.service.PensionApplicationLoadMstDataService;

public class PensionApplicationLoadMstDataAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2580606530771088937L;
	private PensionApplicationLoadMstDataService penappmstservice;
	private PensionApplicationSearchModel penAppComm;
	private PensionApplicationSearchModel chkavail;
	
	
	public String loadMstData()
	{
		
		int loginEmpId=0;
		List<Object[]> myList=null;
		StringBuffer xmlString = new StringBuffer();
		
		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		boolean myFlag=false;
		try
		{
			PrintWriter out = getResponse().getWriter();	
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			loginEmpId=empProfile.getEmployeeId();
			int empid=penAppComm.getEmpId();
			
			myList=penappmstservice.penAppMstData(empid, loginEmpId);			
			System.out.println("GETTING MASTER DATA...>>"+myList.size());
			
			//if(myList.size()>0)
			//{				
				for(Object[] tl: myList)
				 {
					Object[] temp=tl;
					xmlString.append("<record>");					
					xmlString.append("<empid>"+temp[0]+"</empid>");
					xmlString.append("<empname>"+temp[1]+"</empname>");
					xmlString.append("<empinit>"+temp[2]+"</empinit>");
					xmlString.append("<gpfno>"+temp[3]+"</gpfno>");
					
					if(temp[4]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dob=formatter.format(temp[4]);
						xmlString.append("<dob>"+dob+"</dob>");
					}
					else
					{
						xmlString.append("<dob>"+temp[4]+"</dob>");
					}
					
					xmlString.append("<gender>"+temp[5]+"</gender>");
					xmlString.append("<officename>"+temp[6]+"</officename>");
					xmlString.append("<designation>"+temp[7]+"</designation>");
					
					if(temp[8]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String doj=formatter.format(temp[8]);
						xmlString.append("<doj>"+doj+"</doj>");
					}
					else
					{
						xmlString.append("<doj>"+temp[8]+"</doj>");
					}
					
					xmlString.append("<officeid>"+temp[9]+"</officeid>");
					xmlString.append("<desigid>"+temp[10]+"</desigid>");
					xmlString.append("<desigservgrp>"+temp[11]+"</desigservgrp>");
					xmlString.append("<grade>"+temp[12]+"</grade>");
					xmlString.append("</record>");
					
					myFlag=true;
					
				 }
				
				/* 
				 * if(temp1[6]!=null)
				{
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		        String afterDate = formatter.format(temp1[6]);	   
				xmlString.append("<afterdate>"+afterDate+"</afterdate>");
				}
				else
				{
					xmlString.append("<afterdate>"+temp1[6]+"</afterdate>");
				}
	         	
				 * */
				if(myFlag) 
		        {
					xmlString.append("<flag>true</flag>");
		        }
		        else 
		        {
		        	xmlString.append("<flag>false</flag>");
		        }
				
				
		    	 xmlString.append("</response>");

			 getResponse().setContentType("text/xml");	
			 out.println(xmlString.toString());
			 out.flush();
			 out.close();
			 
			//}
			
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String chkAvailable()
	{
		List<Object[]> myChkList=null;
		try
		{
			int empid=chkavail.getEmpId();
			
			int loginId=0;
			PrintWriter out = getResponse().getWriter();
			StringBuffer xmlString = new StringBuffer();		
			xmlString.append("<response>");
			xmlString.append("<command>Get</command>");
			boolean myFlag1=false;
					
			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");			
			loginId=empProfile.getEmployeeId();			
			myChkList=penappmstservice.chkAvailablity(empid, loginId);
			
			for(Object[] tt:myChkList)
			{
				Object[] temp=tt;
				xmlString.append("<record>");					
				xmlString.append("<empid>"+temp[0]+"</empid>");
				xmlString.append("<empname>"+temp[1]+"</empname>");
				xmlString.append("</record>");
				myFlag1=true;
			}
			if(myFlag1) 
	        {
				xmlString.append("<flag>true</flag>");
	        }
	        else 
	        {
	        	xmlString.append("<flag>false</flag>");
	        }
			
			
	    	 xmlString.append("</response>");

		 getResponse().setContentType("text/xml");	
		 out.println(xmlString.toString());
		 out.flush();
		 out.close();		
			
		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}

	
	
	public String chkAvailableForm1()
	{
		List<Object[]> myChkList1=null;
		try
		{
			int empid=chkavail.getEmpId();
			int loginId=0;
			PrintWriter out = getResponse().getWriter();
			StringBuffer xmlString = new StringBuffer();		
			xmlString.append("<response>");
			xmlString.append("<command>Get</command>");
			boolean myFlag1=false;
					
			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");			
			loginId=empProfile.getEmployeeId();			
			myChkList1=penappmstservice.chkAvailablityForm1(empid, loginId);
			
			for(Object[] tt:myChkList1)
			{
				Object[] temp=tt;
				xmlString.append("<record>");					
				xmlString.append("<empid>"+temp[0]+"</empid>");
				xmlString.append("<empname>"+temp[1]+"</empname>");
				xmlString.append("</record>");
				myFlag1=true;
				System.out.println("available----------------->");
			}
			if(myFlag1) 
	        {
				xmlString.append("<flag>true</flag>");
	        }
	        else 
	        {
	        	xmlString.append("<flag>false</flag>");
	        }
			
			
	    	 xmlString.append("</response>");

		 getResponse().setContentType("text/xml");	
		 out.println(xmlString.toString());
		 out.flush();
		 out.close();		
			
		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}
	

	public String penAppFreezeCheck1()
	{
		List<Object[]> myChkList1=null;
		try
		{
			int empid=chkavail.getEmpId();
			int loginId=0;
			PrintWriter out = getResponse().getWriter();
			StringBuffer xmlString = new StringBuffer();		
			xmlString.append("<response>");
			xmlString.append("<command>Get</command>");
			boolean myFlag1=false;
					
			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");			
			loginId=empProfile.getEmployeeId();			
			myChkList1=penappmstservice.penAppFreezeCheck2(empid);
			System.out.println("available----------------->"+empid+"-"+loginId);
			for(Object[] tt:myChkList1)
			{
				Object[] temp=tt;
				xmlString.append("<record>");					
				xmlString.append("<empid>"+temp[0]+"</empid>");
				xmlString.append("<empname>"+temp[1]+"</empname>");
				xmlString.append("</record>");
				myFlag1=true;
				System.out.println("available----------------->");
			}
			if(myFlag1) 
	        {
				xmlString.append("<flag>true</flag>");
	        }
	        else 
	        {
	        	xmlString.append("<flag>false</flag>");
	        }
			
			
	    	 xmlString.append("</response>");

		 getResponse().setContentType("text/xml");	
		 out.println(xmlString.toString());
		 out.flush();
		 out.close();		
			
		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public void setPenappmstservice(PensionApplicationLoadMstDataService penappmstservice) {
		this.penappmstservice = penappmstservice;
	}

	public PensionApplicationLoadMstDataService getPenappmstservice() {
		return penappmstservice;
	}

	public void setPenAppComm(PensionApplicationSearchModel penAppComm) {
		this.penAppComm = penAppComm;
	}

	public PensionApplicationSearchModel getPenAppComm() {
		return penAppComm;
	}

	public void setChkavail(PensionApplicationSearchModel chkavail) {
		this.chkavail = chkavail;
	}

	public PensionApplicationSearchModel getChkavail() {
		return chkavail;
	}
	
}
