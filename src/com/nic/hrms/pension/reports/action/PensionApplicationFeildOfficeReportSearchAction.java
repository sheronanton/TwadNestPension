package com.nic.hrms.pension.reports.action;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeReportSearchText;
import com.nic.hrms.pension.reports.service.PensionApplicationFeildOfficeReportSearchService;


public class PensionApplicationFeildOfficeReportSearchAction extends BaseAction {

	
	private static final long serialVersionUID = 4738479838165595678L;
	private PensionApplicationFeildOfficeReportSearchService penappfieldofficereportservice;
  
	private PensionApplicationFieldOfficeReportSearchText penappfieldofficereport;
	private String penappreportSearchOptions;
	private String penappreportSearchKeyword;
	List<Object[]> penappreplist;
    int	empId;
   
	public String PenAppFieldOfficeReportUserSrch(){
		
		try{
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    empId=empProfile.getEmployeeId();
		    	
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			
			penappreportSearchOptions=penappfieldofficereport.getPenappreportSearchOptions();
			penappreportSearchKeyword =penappfieldofficereport.getPenappreportSearchKeyword().toLowerCase();
		
			xmlString.append("<response>");
			boolean flag = false;
			
			penappreplist=penappfieldofficereportservice.penAppFieldOfficeReportUserSearch(penappreportSearchOptions, penappreportSearchKeyword, empId);
   	     	
			xmlString.append("<command>PenAppFieldOfficeReportUserSearch</command>");   
    
		    for(Object[] tl: penappreplist)
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		public String PenAppFieldOfficeReportUserSrch1(){
		
		try{
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    empId=empProfile.getEmployeeId();
		    	
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			
			penappreportSearchKeyword =penappfieldofficereport.getPenappreportSearchKeyword().toLowerCase();
		
			xmlString.append("<response>");
			boolean flag = false;
			
			penappreplist=penappfieldofficereportservice.penAppFieldOfficeReportUserSearch1(penappreportSearchKeyword, empId);
   	     	
			xmlString.append("<command>PenAppFieldOfficeReportUserSearch1</command>");   
    
		    for(Object[] tl: penappreplist)
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PensionApplicationFeildOfficeReportSearchService getPenappfieldofficereportservice() {
		return penappfieldofficereportservice;
	}
	public void setPenappfieldofficereportservice(
			PensionApplicationFeildOfficeReportSearchService penappfieldofficereportservice) {
		this.penappfieldofficereportservice = penappfieldofficereportservice;
	}	
	public String getPenappreportSearchOptions() {
		return penappreportSearchOptions;
	}
	public void setPenappreportSearchOptions(String penappreportSearchOptions) {
		this.penappreportSearchOptions = penappreportSearchOptions;
	}
	public PensionApplicationFieldOfficeReportSearchText getPenappfieldofficereport() {
		return penappfieldofficereport;
	}
	public void setPenappfieldofficereport(
			PensionApplicationFieldOfficeReportSearchText penappfieldofficereport) {
		this.penappfieldofficereport = penappfieldofficereport;
	}
	public List<Object[]> getPenappreplist() {
		return penappreplist;
	}
	public void setPenappreplist(List<Object[]> penappreplist) {
		this.penappreplist = penappreplist;
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