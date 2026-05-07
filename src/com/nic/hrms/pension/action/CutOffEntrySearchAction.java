package com.nic.hrms.pension.action;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;



import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.model.CutOffEntrySearchText_dao;
import com.nic.hrms.pension.service.CutOffEntrySearchService;
//import com.nic.common.sessionaction.CommonSessionAction;
//Servlets.Security.classes;

import Servlets.Security.classes.*; 


public class CutOffEntrySearchAction extends BaseAction {

	private static final long serialVersionUID = 7067999996014976317L;
    private CutOffEntrySearchService searchservice;
	List<Object[]> objsearchlist;
	private CutOffEntrySearchText_dao objsearchpojo;
	private CutOffEntryPension_dao obj;
	private String searchText;
	private String options;
	//private CommonSessionAction sessionVariable;
   	
    
  

	public String search1(){
		try{
			HttpSession session=getRequest().getSession();
		    UserProfile empProfileEdt=(UserProfile)session.getAttribute("UserProfile");
		    int empId = empProfileEdt.getEmployeeId();
					
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			searchText =objsearchpojo.getSearchText().toLowerCase();
			options=objsearchpojo.getOptions();
 
			boolean flag = false;
			
			objsearchlist=searchservice.searchuser1(searchText,options,empId);

			xmlString.append("<command>search</command>");
		   	   
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
	
	public CutOffEntrySearchService getSearchservice() {
		return searchservice;
	}
	public void setSearchservice(CutOffEntrySearchService searchservice) {
		this.searchservice = searchservice;
	}
	public CutOffEntrySearchText_dao getObjsearchpojo() {
		return objsearchpojo;
	}
	public void setObjsearchpojo(CutOffEntrySearchText_dao objsearchpojo) {
		this.objsearchpojo = objsearchpojo;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}	
	public void setObj(CutOffEntryPension_dao obj) {
		this.obj = obj;
	}
	public CutOffEntryPension_dao getObj() {
		return obj;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getOptions() {
		return options;
	}

		
}	
	
	
	
