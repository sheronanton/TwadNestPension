package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.List;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.AddNominee_dao;
import com.nic.hrms.pension.model.ChangeNominee_dao;
import com.nic.hrms.pension.model.MstNominee_dao;
import com.nic.hrms.pension.service.LoadNomineeService;

public class LoadNomineeAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoadNomineeService loadNomineeService;
	int ppoNo;
	
	public LoadNomineeService getLoadNomineeService() {
		return loadNomineeService;
	}


	public void setLoadNomineeService(LoadNomineeService loadNomineeService) {
		this.loadNomineeService = loadNomineeService;
	}


	public int getPpoNo() {
		return ppoNo;
	}


	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}

	public String checkValidated()
	{
		try
		{
			PrintWriter out = getResponse().getWriter();
			getResponse().setContentType("text/xml");
			out.print(loadNomineeService.CheckNomineeValidated(ppoNo));
			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("Excep in check validated");
		}
		return null;
	}
	public String loadNominee()
	{
	try
		{
		//System.out.println("Load Nominee");
		StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		
		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		xmlString.append("<flag>success</flag>");
		
		List<AddNominee_dao> li=loadNomineeService.loadNominee(ppoNo);
		
		
		for(AddNominee_dao tmp:li)
		{
			
			xmlString.append("<record>");
			xmlString.append("<nomineeid>"+tmp.getNomineeID()+"</nomineeid>");
			xmlString.append("<nomineeinitial>"+tmp.getNomineeInitial()+"</nomineeinitial>");
			xmlString.append("<familymembers>"+tmp.getFamilyMembers()+"</familymembers>");
			xmlString.append("<handicapped>"+tmp.getHandicapped()+"</handicapped>");
			xmlString.append("<maritalstatus>"+tmp.getMartialStatus()+"</maritalstatus>");
			xmlString.append("<relation>"+tmp.getRelation()+"</relation>");
			xmlString.append("<age>"+tmp.getAge()+"</age>");
			xmlString.append("<dob>"+tmp.getDob()+"</dob>");
			xmlString.append("<nominationdate>"+tmp.getNominationDate()+"</nominationdate>");
			
			xmlString.append("</record>");
			
		}
		
	
	 xmlString.append("</response>");
	 getResponse().setContentType("text/xml");
	 System.out.println(xmlString.toString());
	 out.println(xmlString.toString());
	 out.flush();
	 out.close();
		
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return null;
	}

	
	public String loadMstNominee()
	{
	try
		{
		//System.out.println("MstNominee_dao");
		StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		
		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		xmlString.append("<flag>success</flag>");
		
		List<MstNominee_dao> li=loadNomineeService.loadMstNominee(ppoNo);
		
		for(MstNominee_dao tmp:li)
		{
			xmlString.append("<record>");
			xmlString.append("<nomineeid>"+tmp.getNomineeID()+"</nomineeid>");
			xmlString.append("<nomineeinitial>"+tmp.getNomineeInitial()+"</nomineeinitial>");
			xmlString.append("<familymembers>"+tmp.getFamilyMembers()+"</familymembers>");
			xmlString.append("<handicapped>"+tmp.getHandicapped()+"</handicapped>");
			xmlString.append("<maritalstatus>"+tmp.getMaritalStatus()+"</maritalstatus>");
			xmlString.append("<relation>"+tmp.getRelation()+"</relation>");
			xmlString.append("<age>"+tmp.getAge()+"</age>");
			xmlString.append("<dob>"+tmp.getDob()+"</dob>");
			xmlString.append("<nominationdate>"+tmp.getNominationDate()+"</nominationdate>");
			
			
			
			xmlString.append("</record>");
			
		}
		
	
	 xmlString.append("</response>");
	 getResponse().setContentType("text/xml");
	 System.out.println(xmlString.toString());
	 out.println(xmlString.toString());
	 out.flush();
	 out.close();
		
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return null;
	}


	public String loadChangeNominee()
	{
	try
		{
		//System.out.println("MstNominee_dao");
		StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		
		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		xmlString.append("<flag>success</flag>");
		
		List<ChangeNominee_dao> li=loadNomineeService.loadChangeNominee(ppoNo);
		
		for(ChangeNominee_dao tmp:li)
		{
			xmlString.append("<record>");
			xmlString.append("<nomineeid>"+tmp.getNomineeID()+"</nomineeid>");
			xmlString.append("<nomineeinitial>"+tmp.getNomineeInitial()+"</nomineeinitial>");
			xmlString.append("<familymembers>"+tmp.getFamilyMembers()+"</familymembers>");
			xmlString.append("<handicapped>"+tmp.getHandicapped()+"</handicapped>");
			xmlString.append("<maritalstatus>"+tmp.getMaritalStatus()+"</maritalstatus>");
			xmlString.append("<relation>"+tmp.getRelation()+"</relation>");
			xmlString.append("<age>"+tmp.getAge()+"</age>");
			xmlString.append("<dob>"+tmp.getDob()+"</dob>");
			xmlString.append("<nominationdate>"+tmp.getNominationDate()+"</nominationdate>");
			xmlString.append("<deletedreason>"+tmp.getDeletedReason()+"</deletedreason>");
			
			
			
			xmlString.append("</record>");
			
		}
		
	
	 xmlString.append("</response>");
	 getResponse().setContentType("text/xml");
	 System.out.println(xmlString.toString());
	 out.println(xmlString.toString());
	 out.flush();
	 out.close();
		
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return null;
	}


	


}
