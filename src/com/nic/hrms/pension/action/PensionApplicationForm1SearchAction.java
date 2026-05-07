	package com.nic.hrms.pension.action;
	
	import java.io.PrintWriter;
	import java.util.List;

import javax.servlet.http.HttpSession;
	
import Servlets.Security.classes.UserProfile;

	import com.nic.common.baseaction.BaseAction;
	import com.nic.hrms.pension.model.SearchScreen;
import com.nic.hrms.pension.service.PensionApplicationForm1SearchService;
	
	public class PensionApplicationForm1SearchAction extends BaseAction 
	{
			
		private static final long serialVersionUID = -2654897273573406381L;
		private PensionApplicationForm1SearchService penappform1searchservice;
		List<Object[]> GetSearhPenform1List;
		List<Object[]> GetSearhPenform1ValList;
		private SearchScreen penAppform1Srch;
		private SearchScreen penAppform1ValSrch;
		private String SearchScreenOptions;
		private String SearchScreenKeyword;	
		//int empId=11263;	
		
	
		//Search Screen Pension Calculation 
		public String PensionApplicationForm1Search()
		{
			int empId2=0;
			try
			{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId2=empProfile.getEmployeeId();

			}
			catch(Exception e)
			{
			System.out.println("Error in Getting Session Value");
			}
			try
			{
				StringBuffer xmlString = new StringBuffer();
				PrintWriter out = getResponse().getWriter();
				xmlString.append("<response>");
				SearchScreenKeyword =penAppform1Srch.getSearchScreenKeyword().toLowerCase();
				SearchScreenOptions=penAppform1Srch.getSearchScreenOptions();
				boolean flag = false;		
				GetSearhPenform1List=penappform1searchservice.FetchPensionApplicationForm1Search(SearchScreenKeyword, SearchScreenOptions, empId2);
				xmlString.append("<command>PenAppForm1Search</command>");
				for(Object[] tl: GetSearhPenform1List)
			    {
			    	Object[] temp=tl;
			        xmlString.append("<record>");
					//xmlString.append("<ppoNo>" +temp[0]+ "</ppoNo>");
					xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
					xmlString.append("<pensionerName>" +temp[1]+ "</pensionerName>");	
					/*xmlString.append("<classDescription>" +temp[3]+ "</classDescription>");
					xmlString.append("<processStatus>" +temp[4]+ "</processStatus>");*/
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
			catch(Exception e)
			{
				System.out.println("Error in searching the data"+e);
			}			  
			
			return SUCCESS;
		}
		
		
		
		
		
		
		
		public String PensionApplicationForm1ValSearch()
		{
			int empId2=0;
			try
			{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			empId2=empProfile.getEmployeeId();

			}
			catch(Exception e)
			{
			System.out.println("Error in Getting Session Value");
			}
			try
			{
				StringBuffer xmlString = new StringBuffer();
				PrintWriter out = getResponse().getWriter();
				System.out.println("test Validate Search regan");
				xmlString.append("<response>");
				SearchScreenKeyword =penAppform1ValSrch.getSearchScreenKeyword().toLowerCase();
				SearchScreenOptions=penAppform1ValSrch.getSearchScreenOptions();
				boolean flag = false;		
				GetSearhPenform1ValList=penappform1searchservice.FetchPensionApplicationForm1ValSearch(SearchScreenKeyword, SearchScreenOptions, empId2);
				xmlString.append("<command>PenAppForm1ValSearch</command>");
				for(Object[] tl: GetSearhPenform1ValList)
			    {
			    	Object[] temp=tl;
			        xmlString.append("<record>");
					//xmlString.append("<ppoNo>" +temp[0]+ "</ppoNo>");
					xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
					xmlString.append("<pensionerName>" +temp[1]+ "</pensionerName>");	
					/*xmlString.append("<classDescription>" +temp[3]+ "</classDescription>");
					xmlString.append("<processStatus>" +temp[4]+ "</processStatus>");*/
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
			catch(Exception e)
			{
				System.out.println("Error in searching the data"+e);
			}			  
			
			return SUCCESS;
		}
		
		
			
			
		
		
		public PensionApplicationForm1SearchService getPenappform1searchservice() {
			return penappform1searchservice;
		}
		public void setPenappform1searchservice(
				PensionApplicationForm1SearchService penappform1searchservice) {
			this.penappform1searchservice = penappform1searchservice;
		}
		public List<Object[]> getGetSearhPenform1List() {
			return GetSearhPenform1List;
		}
		public void setGetSearhPenform1List(List<Object[]> getSearhPenform1List) {
			GetSearhPenform1List = getSearhPenform1List;
		}
		public SearchScreen getPenAppform1Srch() {
			return penAppform1Srch;
		}
		public void setPenAppform1Srch(SearchScreen penAppform1Srch) {
			this.penAppform1Srch = penAppform1Srch;
		}
		public String getSearchScreenOptions() 
		{
			return SearchScreenOptions;
		}		
		public void setSearchScreenOptions(String searchScreenOptions) 
		{
			SearchScreenOptions = searchScreenOptions;
		}
		public String getSearchScreenKeyword() 
		{
			return SearchScreenKeyword;
		}
		public void setSearchScreenKeyword(String searchScreenKeyword) 
		{
			SearchScreenKeyword = searchScreenKeyword;
		}
		public List<Object[]> getGetSearhPenform1ValList() {
			return GetSearhPenform1ValList;
		}
		public void setGetSearhPenform1ValList(List<Object[]> getSearhPenform1ValList) {
			GetSearhPenform1ValList = getSearhPenform1ValList;
		}
		public SearchScreen getPenAppform1ValSrch() {
			return penAppform1ValSrch;
		}
		public void setPenAppform1ValSrch(SearchScreen penAppform1ValSrch) {
			this.penAppform1ValSrch = penAppform1ValSrch;
		}	
		
		
		
	}
