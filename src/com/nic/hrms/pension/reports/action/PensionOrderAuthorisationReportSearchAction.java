package com.nic.hrms.pension.reports.action;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeReportSearchText;
import com.nic.hrms.pension.reports.service.PensionOrderAuthorisationReportSearchService;


public class PensionOrderAuthorisationReportSearchAction extends BaseAction {

	
	private static final long serialVersionUID = 4738479838165595678L;
	private PensionOrderAuthorisationReportSearchService penOrderAuthorisationreportservice;
	private PensionApplicationFieldOfficeReportSearchText penorderAuthorisationReport;
	private String penorderReportSearchOptions;
	private String penorderReportSearchKeyword;
	List<Object[]> penOrderReplist;
    int	empId;
   
		
		public String PenOrderAuthorisationReportUserSrch(){
		
		try{
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    //empId=empProfile.getEmployeeId();
		    empId=Integer.parseInt(getRequest().getParameter("empId"));
		    	
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
						
			xmlString.append("<response>");
			boolean flag = false;
			
			penOrderReplist=penOrderAuthorisationreportservice.penOrderAuthorisationReportUserSearch(empId);
   	     	
			xmlString.append("<command>PenOrderAuthorisationReportUserSearch</command>");   
    
		    for(Object[] tl: penOrderReplist)
			 {
				 Object[] temp=tl;
	    	     				 
			 	xmlString.append("<record>");
				xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
				xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");	
				xmlString.append("<pensionType>" +temp[2]+ "</pensionType>");
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
		   System.out.println("error in pension order authorisation user searching the data to the databse"+e);
		   }		  
		   return null;
	}
	
	
		
		
		
		
		
		
		
		
		
		public String PenOrderAuthorisationReportUserSrch1(){
			
			try{
				
				HttpSession session=getRequest().getSession();
			    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			    empId=empProfile.getEmployeeId();
			    //empId=Integer.parseInt(getRequest().getParameter("empId"));
			    	
				StringBuffer xmlString = new StringBuffer();
				PrintWriter out = getResponse().getWriter();
				
				penorderReportSearchKeyword=penorderAuthorisationReport.getPenappreportSearchKeyword().toLowerCase();
				penorderReportSearchOptions=penorderAuthorisationReport.getPenappreportSearchOptions();
				xmlString.append("<response>");
				boolean flag = false;
				
				penOrderReplist=penOrderAuthorisationreportservice.penOrderAuthorisationReportUserSearch1(penorderReportSearchOptions, penorderReportSearchKeyword, empId);
	   	     	
				xmlString.append("<command>PenOrderAuthorisationReportUserSearch1</command>");   
	    
			    for(Object[] tl: penOrderReplist)
				 {
					 Object[] temp=tl;
		    	     				 
				 	xmlString.append("<record>");
					xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
					xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");	
					xmlString.append("<pensionType>" +temp[2]+ "</pensionType>");
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
		
		
		
		
		
		
		
		
	
	
	
	public PensionOrderAuthorisationReportSearchService getPenOrderAuthorisationreportservice() {
			return penOrderAuthorisationreportservice;
	}

	public void setPenOrderAuthorisationreportservice(
				PensionOrderAuthorisationReportSearchService penOrderAuthorisationreportservice) {
			this.penOrderAuthorisationreportservice = penOrderAuthorisationreportservice;
	}	
	public String getPenorderReportSearchOptions() {
		return penorderReportSearchOptions;
	}

	public void setPenorderReportSearchOptions(String penorderReportSearchOptions) {
		this.penorderReportSearchOptions = penorderReportSearchOptions;
	}

	public String getPenorderReportSearchKeyword() {
		return penorderReportSearchKeyword;
	}

	public void setPenorderReportSearchKeyword(String penorderReportSearchKeyword) {
		this.penorderReportSearchKeyword = penorderReportSearchKeyword;
	}
	public List<Object[]> getPenOrderReplist() {
		return penOrderReplist;
	}
	public void setPenOrderReplist(List<Object[]> penOrderReplist) {
		this.penOrderReplist = penOrderReplist;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public PensionApplicationFieldOfficeReportSearchText getPenorderAuthorisationReport() {
		return penorderAuthorisationReport;
	}
	public void setPenorderAuthorisationReport(
			PensionApplicationFieldOfficeReportSearchText penorderAuthorisationReport) {
		this.penorderAuthorisationReport = penorderAuthorisationReport;
	}
	
	
	
	
}	