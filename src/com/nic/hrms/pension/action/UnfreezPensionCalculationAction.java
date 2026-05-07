package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.common.baseaction.Constants;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.UnfreezPensionCalculationModel;
import com.nic.hrms.pension.service.UnfreezPensionCalculationService;

public class UnfreezPensionCalculationAction extends BaseAction{
	
	
	private static final long serialVersionUID = 1L;
	private String token;
	private UnfreezPensionCalculationService unfreezeservice;
	private UnfreezPensionCalculationModel unforeezemodel;
	List<Object []> empDetails=null;
	
	private  CommonSearchModel itRecovery;
	private Integer empNo;
	private String empName;
	private String msg;
	private String status;
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
	
	public String getempname()
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
		   empDetails=unfreezeservice.getempName(empno,empId);
			
			for(Object[] t2:empDetails)
			{
				//System.out.println("for  part----------------------------------");
				Object[] empdet=t2;
				 xmlString.append("<record>");
				 //xmlString.append("<ppoNo>" +empdet[0]+ "</ppoNo>");
				 xmlString.append("<empId>" +empdet[0]+ "</empId>");				 
				 xmlString.append("<empName>" +empdet[1]+ "</empName>");
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
	
	
	public String getrevisedempname()
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
		   empDetails=unfreezeservice.getempRevisedName(empno,empId);
			
			for(Object[] t2:empDetails)
			{
				//System.out.println("for  part----------------------------------");
				Object[] empdet=t2;
				 xmlString.append("<record>");
				 //xmlString.append("<ppoNo>" +empdet[0]+ "</ppoNo>");
				 xmlString.append("<empId>" +empdet[0]+ "</empId>");				 
				 xmlString.append("<empName>" +empdet[1]+ "</empName>");
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
	
	
	
	public String unfreezepensioncalc()
	{
		boolean flag=false;
		flag=unfreezeservice.unfreezepensioncalculation(getRequest(),empNo);
		
		if (flag)
		{
			token=generateToken();
			status="Unfreeze Successfully";
			
		}
		else
		{
			msg="UnSuccessful";
		}
			
		return SUCCESS;
	}

	
	public String unfreezepensioncalcrevised()
	{

		boolean flag=false;
		flag=unfreezeservice.unfreezepensioncalculationrevised(getRequest(),empNo);
		
		if (flag)
		{
			token=generateToken();
			status="Unfreeze Successfully";
			
		}
		else
		{
			msg="UnSuccessful";
		}
			
		return SUCCESS;
	
	}
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String tokengeneration()
	{
		token=generateToken();
		return SUCCESS;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public UnfreezPensionCalculationService getUnfreezeservice() {
		return unfreezeservice;
	}


	public void setUnfreezeservice(UnfreezPensionCalculationService unfreezeservice) {
		this.unfreezeservice = unfreezeservice;
	}


	public UnfreezPensionCalculationModel getUnforeezemodel() {
		return unforeezemodel;
	}


	public void setUnforeezemodel(UnfreezPensionCalculationModel unforeezemodel) {
		this.unforeezemodel = unforeezemodel;
	}


	public Integer getEmpNo() {
		return empNo;
	}


	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<Object[]> getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(List<Object[]> empDetails) {
		this.empDetails = empDetails;
	}

	public CommonSearchModel getItRecovery() {
		return itRecovery;
	}

	public void setItRecovery(CommonSearchModel itRecovery) {
		this.itRecovery = itRecovery;
	}

	
	
	
	
	
	
	
}
