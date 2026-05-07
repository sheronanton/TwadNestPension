package com.nic.hrms.pension.action;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;



import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;

import com.nic.hrms.pension.service.MstNomineeSearchService;


public class MstNomineeSearchAction extends BaseAction {

	private static final long serialVersionUID = 7067999996014976317L;
    private MstNomineeSearchService mstsearchservice;
	
	
	private String searchText;
	private String options;
   
	
    int	empId;
    
	
   
    
	
	public String MstNomineeSearch(){
		List<Object[]> objsearchlist;
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
			xmlString.append("<response>");
			
			
	
				objsearchlist=mstsearchservice.SearchThings(searchText,options,empId);

			
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
	
	public String ChangedNomineeSearch(){
		List<Object[]> objsearchlist;
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
			xmlString.append("<response>");
			
		
	
				objsearchlist=mstsearchservice.ChangedSearchThings(searchText, options, empId);
				//SearchThings(searchText,options,empId);

			
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

	public MstNomineeSearchService getMstsearchservice() {
		return mstsearchservice;
	}

	public void setMstsearchservice(MstNomineeSearchService mstsearchservice) {
		this.mstsearchservice = mstsearchservice;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	public void setOptions(String options) {
		this.options = options;
	}

	public String getOptions() {
		return options;
	}
	
}	
	
	
	
