package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.common.baseaction.Constants;
import com.nic.hrms.pension.model.Designationmodel;
import com.nic.hrms.pension.service.Designationservice;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.ChangeDesignationModel;
import com.nic.hrms.pension.service.ChangeDesignationService;

public class ChangeDesignationAction extends BaseAction {
	
	private  CommonSearchModel desigsearch;
	private  CommonSearchModel desinationsearch;
	List<Object []> searchList=null;
	List<Object []> empDetails=null;
	private ChangeDesignationModel designationmodel;
	private ChangeDesignationService designationservicechange;
	private List<Designationmodel> destlist;
	private Designationservice destsrvice;
	
	private int designationId;
	private String token;
	private String status; 
	private String msg;
	private String empNo;
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
	
	
public String gettokenvaluegenerate()
	{
		token=generateToken();
		destlist=destsrvice.getDesignation();
		//System.out.println("size========="+destlist.size());
		return SUCCESS;
	}

public String getDesignation()
{
	int empId=0;
	try
	{
	StringBuffer xmlString = new StringBuffer();
	PrintWriter out = getResponse().getWriter();		
	xmlString.append("<response>");
	xmlString.append("<command>pensionername</command>");
	
	System.out.println("PPO NO TRY IN side");
	HttpSession session=getRequest().getSession();
    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
    empId=empProfile.getEmployeeId();
    
    int empno=Integer.parseInt(desinationsearch.getSearchKeyword());
	
    empDetails=designationservicechange.getIdName(empno, empId);
    boolean itrecFlag1=false;

	
	for(Object[] t2:empDetails)
	{
		Object[] empdet=t2;
		 xmlString.append("<record>");
		 //xmlString.append("<ppoNo>" +empdet[0]+ "</ppoNo>");
		 xmlString.append("<empId>" +empdet[0]+ "</empId>");
		 xmlString.append("<empName>" +empdet[1]+ "</empName>");
		 xmlString.append("<desigantion>" +empdet[3]+ "</desigantion>");
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
				
							
				
			xmlString.append("</response>");
			
			getResponse().setContentType("text/xml");	
			out.println(xmlString.toString());
			out.flush();
			out.close();
				
					
				//System.out.println("PPO NO + EMP iD "+ppono+ "\t" +empId) ;
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Exception in IT Recovery "+e);
				}
	
	return SUCCESS;
}

public String searchDesignation()
{
			
    //System.out.println("inside search action it reco...>>>>>.");
	String options=desigsearch.getSearchOption();
	String keyword=desigsearch.getSearchKeyword();		
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
	
	searchList=designationservicechange.designationSearch(keyword,options,empId);
	
	xmlString.append("<command>itsearch</command>");
	  
    for(Object[] tl: searchList)
	 {
		Object[] temp=tl;
	     xmlString.append("<record>");
		 //xmlString.append("<ppoNo>" +temp[0]+ "</ppoNo>");
		 xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
		 xmlString.append("<pensionerName>" +temp[1]+ "</pensionerName>");
		 xmlString.append("<designation>" +temp[3]+ "</designation>");		
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
public String changeDesignation()
{
	HttpSession session=getRequest().getSession();
	if(token==null || token.trim().length() == 0 || !session.getAttribute("token").toString().equals(token) || !token.trim().matches(Constants.TOKEN))
	{
		addActionError("Invalid Token");
		token = null;
		return ERROR;
	}
	/*if(uservalidation()==true)
	{
		return gettokenvalueof();
	}*/
	String updateval="";
	//System.out.println("--------------------------------------------->"+designationId);
	//System.out.println();
	int empno=Integer.parseInt(empNo);
	
	//System.out.println("================================="+empno);
	try{
	
		updateval=designationservicechange.upadatedesignation(designationId,empno)?"y":"n";
		
	
	}catch(Exception e){e.printStackTrace();}
	if(updateval=="y")
	{
		status="Designation Changed Successfully";
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
	if(designationId==0)
	{
		msg="Selecte the Designation";
	}
	
	if(empNo==null || empNo.trim().length()==0||empNo.trim().equals(""))
	{
		msg="Enter the EMP NO";
		flag=true;
	}
	return false;
}


public CommonSearchModel getDesigsearch() {
	return desigsearch;
}


public void setDesigsearch(CommonSearchModel desigsearch) {
	this.desigsearch = desigsearch;
}


public CommonSearchModel getDesinationsearch() {
	return desinationsearch;
}


public void setDesinationsearch(CommonSearchModel desinationsearch) {
	this.desinationsearch = desinationsearch;
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


public ChangeDesignationModel getDesignationmodel() {
	return designationmodel;
}


public void setDesignationmodel(ChangeDesignationModel designationmodel) {
	this.designationmodel = designationmodel;
}




public ChangeDesignationService getDesignationservicechange() {
	return designationservicechange;
}


public void setDesignationservicechange(
		ChangeDesignationService designationservicechange) {
	this.designationservicechange = designationservicechange;
}





public List<Designationmodel> getDestlist() {
	return destlist;
}


public void setDestlist(List<Designationmodel> destlist) {
	this.destlist = destlist;
}


public Designationservice getDestsrvice() {
	return destsrvice;
}


public void setDestsrvice(Designationservice destsrvice) {
	this.destsrvice = destsrvice;
}




public int getDesignationId() {
	return designationId;
}


public void setDesignationId(int designationId) {
	this.designationId = designationId;
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


public String getEmpNo() {
	return empNo;
}


public void setEmpNo(String empNo) {
	this.empNo = empNo;
}


public String getChangeName() {
	return changeName;
}


public void setChangeName(String changeName) {
	this.changeName = changeName;
}


public BaseAction getBa() {
	return ba;
}


public void setBa(BaseAction ba) {
	this.ba = ba;
}



}
