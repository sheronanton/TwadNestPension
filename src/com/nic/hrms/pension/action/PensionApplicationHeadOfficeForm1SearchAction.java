	package com.nic.hrms.pension.action;
	
	import java.io.PrintWriter;
	import java.util.List;
	import javax.servlet.http.HttpSession;	
	import Servlets.Security.classes.UserProfile;
	import com.nic.common.baseaction.BaseAction;
	import com.nic.hrms.pension.model.SearchScreen;
	import com.nic.hrms.pension.service.PensionApplicationHeadOfficeForm1SearchService;
	
	public class PensionApplicationHeadOfficeForm1SearchAction extends BaseAction 
	{
			
		private static final long serialVersionUID = -2654897273573406381L;
		private PensionApplicationHeadOfficeForm1SearchService penappHeadOfficeform1searchservice;
		List<Object[]> GetSearhPenHeadOfficeform1List;
		List<Object[]> GetSearhPenHeadOfficeform1ValList;
		private SearchScreen penAppHeadOfficeform1Srch;
		private SearchScreen penAppHeadOfficeform1ValSrch;
		private String SearchScreenOptions;
		private String SearchScreenKeyword;	
		
	
		//Search Screen Pension Calculation 
		public String PensionApplicationHeadOfficeForm1Search()
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
				SearchScreenKeyword =penAppHeadOfficeform1Srch.getSearchScreenKeyword().toLowerCase();
				SearchScreenOptions=penAppHeadOfficeform1Srch.getSearchScreenOptions();
				boolean flag = false;		
				GetSearhPenHeadOfficeform1List=penappHeadOfficeform1searchservice.FetchPensionApplicationHeadOfficeForm1Search(SearchScreenKeyword, SearchScreenOptions, empId2);
				xmlString.append("<command>PenAppHeadOfficeForm1Search</command>");
				for(Object[] tl: GetSearhPenHeadOfficeform1List)
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
		
		
		
		
		
		
		
		public String PensionApplicationHeadOfficeForm1ValSearch()
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
				SearchScreenKeyword =penAppHeadOfficeform1ValSrch.getSearchScreenKeyword().toLowerCase();
				SearchScreenOptions=penAppHeadOfficeform1ValSrch.getSearchScreenOptions();
				boolean flag = false;		
				GetSearhPenHeadOfficeform1ValList=penappHeadOfficeform1searchservice.FetchPensionApplicationHeadOfficeForm1ValSearch(SearchScreenKeyword, SearchScreenOptions, empId2);
				xmlString.append("<command>PenAppHeadOfficeForm1ValSearch</command>");
				for(Object[] tl: GetSearhPenHeadOfficeform1ValList)
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
		
		
			
			
		
		
		
		public PensionApplicationHeadOfficeForm1SearchService getPenappHeadOfficeform1searchservice() {
			return penappHeadOfficeform1searchservice;
		}
		public void setPenappHeadOfficeform1searchservice(
				PensionApplicationHeadOfficeForm1SearchService penappHeadOfficeform1searchservice) {
			this.penappHeadOfficeform1searchservice = penappHeadOfficeform1searchservice;
		}				
		public List<Object[]> getGetSearhPenHeadOfficeform1List() {
			return GetSearhPenHeadOfficeform1List;
		}
		public void setGetSearhPenHeadOfficeform1List(
				List<Object[]> getSearhPenHeadOfficeform1List) {
			GetSearhPenHeadOfficeform1List = getSearhPenHeadOfficeform1List;
		}
		public SearchScreen getPenAppHeadOfficeform1Srch() {
			return penAppHeadOfficeform1Srch;
		}
		public void setPenAppHeadOfficeform1Srch(SearchScreen penAppHeadOfficeform1Srch) {
			this.penAppHeadOfficeform1Srch = penAppHeadOfficeform1Srch;
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
		public List<Object[]> getGetSearhPenHeadOfficeform1ValList() {
			return GetSearhPenHeadOfficeform1ValList;
		}
		public void setGetSearhPenHeadOfficeform1ValList(
				List<Object[]> getSearhPenHeadOfficeform1ValList) {
			GetSearhPenHeadOfficeform1ValList = getSearhPenHeadOfficeform1ValList;
		}
		public SearchScreen getPenAppHeadOfficeform1ValSrch() {
			return penAppHeadOfficeform1ValSrch;
		}
		public void setPenAppHeadOfficeform1ValSrch(
				SearchScreen penAppHeadOfficeform1ValSrch) {
			this.penAppHeadOfficeform1ValSrch = penAppHeadOfficeform1ValSrch;
		}
		
		
		
		
	}
