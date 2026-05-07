package com.nic.hrms.pension.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.service.AjaxCombo_service;
import com.nic.hrms.pension.model.AjaxCombo_dao;
import com.nic.hrms.pension.model.DesignationCombo_dao;
import com.nic.hrms.pension.service.Designation_service;
import com.nic.hrms.pension.service.OfficeId_service;


public class AjaxLoadAction extends BaseAction {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7248133875069840721L;
	
	private AjaxCombo_service ajaxcomboservice;
	private List<AjaxCombo_dao> ajaxcombo;
	private List<DesignationCombo_dao> designationcombo;
	private Designation_service desigservice;
	private Integer bankId;
	private Integer gradeId;
	private OfficeId_service officeIdservice;
		
	
	
	public String branch()throws IOException{
		
		System.out.println("--------------------------->inside branch");

		try{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			boolean flag = false;
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    int empId=empProfile.getEmployeeId();
	
			int officeId = officeIdservice.getOfficeId(empId);
			
			int bankId1=bankId==null?0:bankId;
			
			ajaxcombo = ajaxcomboservice.getListOfBranch(bankId1,officeId);
		
		Iterator<AjaxCombo_dao> iterator = ajaxcombo.iterator();
		
		 while(iterator.hasNext()){
			 AjaxCombo_dao iter = iterator.next();
			// System.out.println("-------------------------->system print for branchId ="+iter.getBranchId());
			// System.out.println("-------------------------->system print for branchName ="+iter.getBranchName());
			/* int  branch = iter.getBranchId();
			 String bName = (iter.getBranchName()).trim();*/
			 xmlString.append("<record>");
			 xmlString.append("<code>"+iter.getBranchId()+ "</code>");
			 xmlString.append("<name>"+iter.getBranchName()+ "</name>");
			 xmlString.append("</record>");
			 flag = true;
		    }
		 
		 if(flag) {
			 xmlString.append("<flag>true</flag>");	 
		 } else {
			 xmlString.append("<flag>false</flag>");
		 }
		 
		 xmlString.append("</response>");
		 getResponse().setContentType("text/xml");
		 System.out.println(xmlString.toString());
		 out.println(xmlString.toString());
		  	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
		
	
	
public String gradeCombo()throws IOException{
		
	//	System.out.println("--------------------------->inside gradeCombo");

		try{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			boolean flag = false;
			designationcombo = desigservice.getDesignation(gradeId);
		
		
		Iterator<DesignationCombo_dao> iterator = designationcombo.iterator();
		
		 while(iterator.hasNext()){
			 DesignationCombo_dao iter = iterator.next();
			// System.out.println("-------------------------->system print for classid ="+iter.getDesignationId());
		//	 System.out.println("-------------------------->system print for classdesc ="+iter.getDesignationName());
			 xmlString.append("<record>");
			 xmlString.append("<code>" +iter.getDesignationId()+ "</code>");
			 xmlString.append("<name>" +iter.getDesignationName()+ "</name>");
			 xmlString.append("</record>");
			 flag = true;
		    }
		 
		 if(flag) {
			 xmlString.append("<flag>true</flag>");	 
		 } else {
			 xmlString.append("<flag>false</flag>");
		 }
		 
		 xmlString.append("</response>");
		 getResponse().setContentType("text/xml");
		 System.out.println(xmlString.toString());
		 out.println(xmlString.toString());
		  	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
public List<DesignationCombo_dao> getDesignationcombo() {
	return designationcombo;
}

public void setDesignationcombo(List<DesignationCombo_dao> designationcombo) {
	this.designationcombo = designationcombo;
}

public Designation_service getDesigservice() {
	return desigservice;
}

public void setDesigservice(Designation_service desigservice) {
	this.desigservice = desigservice;
}


public AjaxCombo_service getAjaxcomboservice() {
	return ajaxcomboservice;
}

public void setAjaxcomboservice(AjaxCombo_service ajaxcomboservice) {
	this.ajaxcomboservice = ajaxcomboservice;
}

public List<AjaxCombo_dao> getAjaxcombo() {
	return ajaxcombo;
}

public void setAjaxcombo(List<AjaxCombo_dao> ajaxcombo) {
	this.ajaxcombo = ajaxcombo;
}

public OfficeId_service getOfficeIdservice() {
	return officeIdservice;
}

public void setOfficeIdservice(OfficeId_service officeIdservice) {
	this.officeIdservice = officeIdservice;
}



public Integer getBankId() {
	return bankId;
}



public void setBankId(Integer bankId) {
	this.bankId = bankId;
}



public Integer getGradeId() {
	return gradeId;
}



public void setGradeId(Integer gradeId) {
	this.gradeId = gradeId;
}

	
}

