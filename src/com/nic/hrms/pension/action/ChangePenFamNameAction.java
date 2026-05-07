package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.common.baseaction.Constants;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.ChangePenFamNameModel;
import com.nic.hrms.pension.service.ChangePenFamNameService;

public class ChangePenFamNameAction extends BaseAction {
	
	private  CommonSearchModel itrecsearch;
	private  CommonSearchModel itRecovery;
	private ChangePenFamNameModel changepenfamname;
	List<Object []> searchList=null;
	List<Object []> empDetails=null;
	private ChangePenFamNameService penfamService;
	private String token;
	private String status; 
	private String msg;
	private String empNo;
	private String initial;
	private String changeName;
	private BaseAction ba;
	public void validate()
	{
		if(token !=null)
		{
			if(token == null || token.trim().length() == 0 || token.trim().equals("") || !token.trim().matches(Constants.TOKEN))
			{
				token = null;	
				addActionError("Invalid Token");
			}	
		}
	}
	
	
public String gettokenvalueof()
	{
		token=generateToken();
		return SUCCESS;
	}

	
 public String getpenfamname()
 {
	 //System.out.println("Inside IT Recovery Action --------------->>>");
		int empId=0;
		int checkval=0;
		try
		{
		StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();		
		xmlString.append("<response>");
		
		boolean itrecFlag1=false;
		System.out.println("PPO NO TRY IN side");
		HttpSession session=getRequest().getSession();
	    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
	    empId=empProfile.getEmployeeId();
	    
	   int empno=Integer.parseInt(itRecovery.getSearchKeyword());
		
	  //checkval=penfamService.getIdName(empno, empId);
	  //System.out.println("checkval====="+checkval);
	  /*if(checkval>0)
	  {
		      xmlString.append("<command>CheckName</command>");
			  xmlString.append("<flag>true</flag>");
		 
	  }
	else
	  {*/
		xmlString.append("<command>pensionername</command>");
		//System.out.println("else part----------------------------------");
	   empDetails=penfamService.getNmpName(empno,empId);
		
		for(Object[] t2:empDetails)
		{
			//System.out.println("for  part----------------------------------");
			Object[] empdet=t2;
			 xmlString.append("<record>");
			 //xmlString.append("<ppoNo>" +empdet[0]+ "</ppoNo>");
			 xmlString.append("<empId>" +empdet[0]+ "</empId>");
			 xmlString.append("<initial>" +empdet[1]+ "</initial>");
			 xmlString.append("<empName>" +empdet[2]+ "</empName>");
			 xmlString.append("</record>");
			 itrecFlag1=true;
		}
	   
			if(itrecFlag1) 
				{
					xmlString.append("<flag1>true</flag1>");
				}
				else 
				{
					xmlString.append("<flag1>false</flag1>");
				}
			//	}
				   xmlString.append("</response>");
					
					getResponse().setContentType("text/xml");	
					System.out.println(xmlString.toString());
					out.println(xmlString.toString());
					out.flush();
					out.close();
			
		}
					catch(Exception e)
					{
						e.printStackTrace();
						System.out.println("Exception in IT Recovery "+e);
					}
						 
	 
	 return SUCCESS;
 }
	
	
	
	
	
	
	public String searchpenfamname()
	{
				
	    //System.out.println("inside search action it reco...>>>>>.");
		String options=itrecsearch.getSearchOption();
		String keyword=itrecsearch.getSearchKeyword();		
		int empId=0; 
		boolean flag = false;
		try
		{
		
		StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();			
		xmlString.append("<response>");
		
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		empId=empProfile.getEmployeeId();
		
		searchList=penfamService.itRecoverySearch(keyword,options,empId);
		
		xmlString.append("<command>itsearch</command>");
  	  
	    for(Object[] tl: searchList)
		 {
			Object[] temp=tl;
    	     xmlString.append("<record>");
			 //xmlString.append("<ppoNo>" +temp[0]+ "</ppoNo>");
			 xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
			 xmlString.append("<pensionerName>" +temp[2]+ "</pensionerName>");
			// xmlString.append("<processStatus>" +temp[3]+ "</processStatus>");		
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
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("static-access")
	public String changepenfamname()
	{
		HttpSession session=getRequest().getSession();
		if(token==null || token.trim().length() == 0 || !session.getAttribute("token").toString().equals(token) || !token.trim().matches(Constants.TOKEN))
		{
			addActionError("Invalid Token");
			token = null;
			return ERROR;
		}
		if(uservalidation()==true)
		{
			return gettokenvalueof();
		}
		String updateval="";
		Description(changeName);
		int empno=Integer.parseInt(empNo);
		if(test_flag==true)
		{
			updateval=penfamService.upadatepenfamname(initial,changeName,empno)?"y":"n";
			
		}
		else
		{
			msg=ba.getMessage();
		}
		if(updateval=="y")
		{
			status="Name Changed Successfully";
			token=generateToken();
		}
		else
		{
			msg="data Not Updated";
		}
		return SUCCESS;
	}
	public boolean uservalidation()
	{
		boolean flag=false;
		//System.out.println("empno===="+empNo);
		//int empno=Integer.parseInt(empNo);
		if(changeName == null || changeName.trim().length() == 0 || changeName.trim().equals(""))
		{
		msg="Enter the Change Name";
		flag=true;
		}
		if(empNo==null || empNo.trim().length()==0||empNo.trim().equals(""))
		{
			msg="Enter the EMP NO";
			flag=true;
		}
		
		return flag;
	}
	
	public CommonSearchModel getItrecsearch() {
		return itrecsearch;
	}


	public void setItrecsearch(CommonSearchModel itrecsearch) {
		this.itrecsearch = itrecsearch;
	}


	public CommonSearchModel getItRecovery() {
		return itRecovery;
	}


	public void setItRecovery(CommonSearchModel itRecovery) {
		this.itRecovery = itRecovery;
	}


	public ChangePenFamNameModel getChangepenfamname() {
		return changepenfamname;
	}


	public void setChangepenfamname(ChangePenFamNameModel changepenfamname) {
		this.changepenfamname = changepenfamname;
	}


	public List<Object[]> getSearchList() {
		return searchList;
	}


	public void setSearchList(List<Object[]> searchList) {
		this.searchList = searchList;
	}


	public List<Object[]> getEmpDetails() {
		return empDetails;
	}


	public void setEmpDetails(List<Object[]> empDetails) {
		this.empDetails = empDetails;
	}


	public ChangePenFamNameService getPenfamService() {
		return penfamService;
	}


	public void setPenfamService(ChangePenFamNameService penfamService) {
		this.penfamService = penfamService;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getChangeName() {
		return changeName;
	}


	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public BaseAction getBa() {
		return ba;
	}


	public void setBa(BaseAction ba) {
		this.ba = ba;
	}


	public String getInitial() {
		return initial;
	}


	public void setInitial(String initial) {
		this.initial = initial;
	}


	


	

	
}
