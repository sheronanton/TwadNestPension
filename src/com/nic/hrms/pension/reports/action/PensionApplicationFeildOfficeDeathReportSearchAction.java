package com.nic.hrms.pension.reports.action;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeReportSearchText;
import com.nic.hrms.pension.reports.service.PensionApplicationFeildOfficeDeathReportSearchService;


public class PensionApplicationFeildOfficeDeathReportSearchAction extends BaseAction {

	
	private static final long serialVersionUID = 4738479838165595678L;
	private PensionApplicationFeildOfficeDeathReportSearchService penappfieldofficeDeathreportservice;
  
	private PensionApplicationFieldOfficeReportSearchText penappfieldofficeDeathreport;
	private String penappreportSearchOptions;
	private String penappreportSearchKeyword;
	List<Object[]> penappDeathreplist;
    int	empId;
   
	public String PenAppFieldOfficeDeathReportUserSrch(){
		
		try{
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    empId=empProfile.getEmployeeId();
		    	
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			
			penappreportSearchOptions=penappfieldofficeDeathreport.getPenappreportSearchOptions();
			penappreportSearchKeyword =penappfieldofficeDeathreport.getPenappreportSearchKeyword().toLowerCase();
		
			xmlString.append("<response>");
			boolean flag = false;
			
			penappDeathreplist=penappfieldofficeDeathreportservice.penAppFieldOfficeDeathReportUserSearch(penappreportSearchOptions, penappreportSearchKeyword, empId);
   	     	
			xmlString.append("<command>PenAppFieldOfficeDeathReportUserSearch</command>");   
    
		    for(Object[] tl: penappDeathreplist)
			 {
				 Object[] temp=tl;  	     
				 
			 	xmlString.append("<record>");
				xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
				xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");				
				xmlString.append("<pensionType>" +temp[3]+ "</pensionType>");
				xmlString.append("</record>");		
		        flag = true;
				 
				 
	          }
	         if(flag) 
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
		   catch(Exception e){
		   System.out.println("error in searching the data to the databse"+e);
		   }		  
		   return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		public String PenAppFieldOfficeDeathReportUserSrch1(){
		
		try{
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    empId=empProfile.getEmployeeId();
		    	
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			
			penappreportSearchKeyword =penappfieldofficeDeathreport.getPenappreportSearchKeyword().toLowerCase();
		
			xmlString.append("<response>");
			boolean flag = false;
			
			penappDeathreplist=penappfieldofficeDeathreportservice.penAppFieldOfficeDeathReportUserSearch1(penappreportSearchKeyword, empId);
   	     	
			xmlString.append("<command>PenAppFieldOfficeDeathReportUserSearch1</command>");   
    
		    for(Object[] tl: penappDeathreplist)
			 {
				 Object[] temp=tl;
	    	     				 
			 	xmlString.append("<record>");
				xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
				xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");	
				xmlString.append("<pensionType>" +temp[3]+ "</pensionType>");
				xmlString.append("</record>");		
		        flag = true;
				 
				 
	          }
	         if(flag) 
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
		   catch(Exception e){
		   System.out.println("error in searching the data to the databse"+e);
		   }		  
		   return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PensionApplicationFeildOfficeDeathReportSearchService getPenappfieldofficeDeathreportservice() {
		return penappfieldofficeDeathreportservice;
	}
	public void setPenappfieldofficeDeathreportservice(
				PensionApplicationFeildOfficeDeathReportSearchService penappfieldofficeDeathreportservice) {
		this.penappfieldofficeDeathreportservice = penappfieldofficeDeathreportservice;
	}
	public String getPenappreportSearchOptions() {
		return penappreportSearchOptions;
	}
	public void setPenappreportSearchOptions(String penappreportSearchOptions) {
		this.penappreportSearchOptions = penappreportSearchOptions;
	}	
	public PensionApplicationFieldOfficeReportSearchText getPenappfieldofficeDeathreport() {
		return penappfieldofficeDeathreport;
	}
	public void setPenappfieldofficeDeathreport(
			PensionApplicationFieldOfficeReportSearchText penappfieldofficeDeathreport) {
		this.penappfieldofficeDeathreport = penappfieldofficeDeathreport;
	}	
	public List<Object[]> getPenappDeathreplist() {
		return penappDeathreplist;
	}
	public void setPenappDeathreplist(List<Object[]> penappDeathreplist) {
		this.penappDeathreplist = penappDeathreplist;
	}
	public String getPenappreportSearchKeyword() {
		return penappreportSearchKeyword;
	}
	public void setPenappreportSearchKeyword(String penappreportSearchKeyword) {
		this.penappreportSearchKeyword = penappreportSearchKeyword;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}	
}	