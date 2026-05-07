package com.nic.hrms.pension.reports.action;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeReportSearchText;
import com.nic.hrms.pension.reports.service.RevisedFamilyPensionOrderReportSearchService;


public class RevisedFamilyPensionOrderReportSearchAction extends BaseAction {

	
	private static final long serialVersionUID = 4738479838165595678L;
	private RevisedFamilyPensionOrderReportSearchService revFamPenOrderreportservice;
	private PensionApplicationFieldOfficeReportSearchText revFamPenorderReport;
	private String penorderReportSearchOptions;
	private String penorderReportSearchKeyword;
	List<Object[]> penOrderReplist;
    int	empId;
   
		
		public String RevisedFamilyPenOrderAuthorisationReportUserSrch(){
		
		try{
			
			HttpSession session=getRequest().getSession();
		    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		    //empId=empProfile.getEmployeeId();
		    empId=Integer.parseInt(getRequest().getParameter("empId"));
		    	
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
						
			xmlString.append("<response>");
			boolean flag = false;
			
			penOrderReplist=revFamPenOrderreportservice.revisedFamilyPenOrderReportUserSearch(empId);
   	     	
			xmlString.append("<command>RevFamPenOrderReportUserSearch</command>");   
    
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
		   System.out.println("error in REVISED FAMILY pension order REPORT DUE TO PAY CHANGE user searching the data to the databse"+e);
		   }		  
		   return null;
	}
	
	
		
		
		
		
		
		
		
		
		
		public String RevFamilyPenOrderAuthorisationReportUserSrch1(){
			
			try{
				
				HttpSession session=getRequest().getSession();
			    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			    empId=empProfile.getEmployeeId();
			    //empId=Integer.parseInt(getRequest().getParameter("empId"));
			    	
				StringBuffer xmlString = new StringBuffer();
				PrintWriter out = getResponse().getWriter();
				
				penorderReportSearchKeyword=revFamPenorderReport.getPenappreportSearchKeyword().toLowerCase();
				penorderReportSearchOptions=revFamPenorderReport.getPenappreportSearchOptions();
				xmlString.append("<response>");
				boolean flag = false;
				
				penOrderReplist=revFamPenOrderreportservice.revFamilyPenOrderReportUserSearch1(penorderReportSearchOptions, penorderReportSearchKeyword, empId);
	   	     	
				xmlString.append("<command>FamPenOrderReportUserSearch1</command>");   
	    
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
			   System.out.println("error in REVISED FAMILY pension order REPORT DUE TO PAY CHANGE user searching the data to the databse"+e);
			   }		  
			   return null;
		}
		
		
	

	
	
	
	public RevisedFamilyPensionOrderReportSearchService getRevFamPenOrderreportservice() {
			return revFamPenOrderreportservice;
	}
	public void setRevFamPenOrderreportservice(
				RevisedFamilyPensionOrderReportSearchService revFamPenOrderreportservice) {
			this.revFamPenOrderreportservice = revFamPenOrderreportservice;
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
	public PensionApplicationFieldOfficeReportSearchText getRevFamPenorderReport() {
		return revFamPenorderReport;
	}
	public void setRevFamPenorderReport(
			PensionApplicationFieldOfficeReportSearchText revFamPenorderReport) {
		this.revFamPenorderReport = revFamPenorderReport;
	}
	
	
	
	
	
	
	
}	