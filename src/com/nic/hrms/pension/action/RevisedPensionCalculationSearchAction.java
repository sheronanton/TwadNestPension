	package com.nic.hrms.pension.action;
	
	import java.io.PrintWriter;
	import java.util.List;
	import javax.servlet.http.HttpSession;	
	import Servlets.Security.classes.UserProfile;
	import com.nic.common.baseaction.BaseAction;
	import com.nic.hrms.pension.model.SearchScreen;
	import com.nic.hrms.pension.service.RevisedPensionCalculationSearchService;
	
	public class RevisedPensionCalculationSearchAction extends BaseAction 
	{
			
		private static final long serialVersionUID = -2654897273573406381L;
		private RevisedPensionCalculationSearchService revpenCalculationsearchservice;
		List<Object[]> GetSearhRevisedPenList;
		List<Object[]> GetSearhRevisedPenValList;
		private SearchScreen revPenCalculationSrch;
		private SearchScreen revPenCalculationValSrch;
		private String SearchScreenOptions;
		private String SearchScreenKeyword;	
		
	
		//Search Screen Pension Calculation 
		public String revisedPensionCalculationSearch()
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
				SearchScreenKeyword =revPenCalculationSrch.getSearchScreenKeyword().toLowerCase();
				SearchScreenOptions=revPenCalculationSrch.getSearchScreenOptions();
				boolean flag = false;		
				GetSearhRevisedPenList=revpenCalculationsearchservice.FetchRevisedPensionCalculationSearch(SearchScreenKeyword, SearchScreenOptions, empId2);
				xmlString.append("<command>RevisedPensionCalculationSearch</command>");
				for(Object[] tl: GetSearhRevisedPenList)
			    {
			    	Object[] temp=tl;
			        xmlString.append("<record>");
					xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
					xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");	
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
			catch(Exception e)
			{
				System.out.println("Error in searching the data"+e);
			}			  
			
			return SUCCESS;
		}
		
		
		
		
		
		
		
		public String revisedPensionCalculationValSearch()
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
				SearchScreenKeyword =revPenCalculationValSrch.getSearchScreenKeyword().toLowerCase();
				SearchScreenOptions=revPenCalculationValSrch.getSearchScreenOptions();
				boolean flag = false;		
				GetSearhRevisedPenValList=revpenCalculationsearchservice.FetchRevisedPensionCalculationValSearch(SearchScreenKeyword, SearchScreenOptions, empId2);
				xmlString.append("<command>PenAppHeadOfficeForm1ValSearch</command>");
				for(Object[] tl: GetSearhRevisedPenValList)
			    {
			    	Object[] temp=tl;
			        xmlString.append("<record>");
					xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
					xmlString.append("<pensionerName>" +temp[1]+ "</pensionerName>");	
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
			catch(Exception e)
			{
				System.out.println("Error in searching the data"+e);
			}			  
			
			return SUCCESS;
		}
		
		
			
			
		
		
		
					
		
		public RevisedPensionCalculationSearchService getRevpenCalculationsearchservice() {
			return revpenCalculationsearchservice;
		}
		public void setRevpenCalculationsearchservice(
				RevisedPensionCalculationSearchService revpenCalculationsearchservice) {
			this.revpenCalculationsearchservice = revpenCalculationsearchservice;
		}			
		public List<Object[]> getGetSearhRevisedPenList() {
			return GetSearhRevisedPenList;
		}
		public void setGetSearhRevisedPenList(List<Object[]> getSearhRevisedPenList) {
			GetSearhRevisedPenList = getSearhRevisedPenList;
		}
		public SearchScreen getRevPenCalculationSrch() {
			return revPenCalculationSrch;
		}
		public void setRevPenCalculationSrch(SearchScreen revPenCalculationSrch) {
			this.revPenCalculationSrch = revPenCalculationSrch;
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
		public List<Object[]> getGetSearhRevisedPenValList() {
			return GetSearhRevisedPenValList;
		}
		public void setGetSearhRevisedPenValList(
				List<Object[]> getSearhRevisedPenValList) {
			GetSearhRevisedPenValList = getSearhRevisedPenValList;
		}
		public SearchScreen getRevPenCalculationValSrch() {
			return revPenCalculationValSrch;
		}
		public void setRevPenCalculationValSrch(SearchScreen revPenCalculationValSrch) {
			this.revPenCalculationValSrch = revPenCalculationValSrch;
		}
		
		
		
		
		
	}
