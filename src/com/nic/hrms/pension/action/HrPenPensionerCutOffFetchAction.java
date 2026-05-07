package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.HrPenPensionerCutOffEntryModel;
import com.nic.hrms.pension.model.HrPenPensionerCutOffFetchModel;
import com.nic.hrms.pension.service.HrPenPensionerCutOffFetchService;

public class HrPenPensionerCutOffFetchAction extends BaseAction{
	
	private static final long serialVersionUID = -6468136066164524604L;
	
	private HrPenPensionerCutOffFetchService fetchservice;
	List<HrPenPensionerCutOffFetchModel> objfetchlist;

	private HrPenPensionerCutOffEntryModel mstcutoffentry;
	
	private int employeeId;
	
	public String fetch1(){
		try{
		
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			employeeId=mstcutoffentry.getEmployeeId();
			
			boolean flag = false;
			objfetchlist=fetchservice.fetch(employeeId);			
			Iterator<HrPenPensionerCutOffFetchModel> iterator = objfetchlist.iterator();
	        xmlString.append("<command>fetch</command>");		   
			
		    while(iterator.hasNext()){
	    	 HrPenPensionerCutOffFetchModel iter = iterator.next();
			 xmlString.append("<record>");
			 xmlString.append("<pensionerName>" +iter.getEmployeeName()+ "</pensionerName>");
			 xmlString.append("<pensionerInitial>" +iter.getEmployeeInitial()+ "</pensionerInitial>");
			 xmlString.append("<titleId>" +iter.getEmployeePrefix()+ "</titleId>");
			
			 String strDate = iter.getDateOfBirth().toString();
			 SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
			 Date date = sdfSource.parse(strDate);
			 SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");
			 strDate = sdfDestination.format(date);
			 //System.out.println("========>>>>strDate"+strDate);
			 
			 xmlString.append("<dateOfBirth>" +strDate+ "</dateOfBirth>");
			 xmlString.append("<gender>" +iter.getGender()+ "</gender>");
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
		   System.out.println("error in fetching the data to the databse"+e);
		   }
		   return null;
	}

	
	


	public HrPenPensionerCutOffEntryModel getMstcutoffentry() {
		return mstcutoffentry;
	}





	public void setMstcutoffentry(HrPenPensionerCutOffEntryModel mstcutoffentry) {
		this.mstcutoffentry = mstcutoffentry;
	}





	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public List<HrPenPensionerCutOffFetchModel> getObjfetchlist() {
		return objfetchlist;
	}

	public void setObjfetchlist(List<HrPenPensionerCutOffFetchModel> objfetchlist) {
		this.objfetchlist = objfetchlist;
	}

	
	
	public void setFetchservice(HrPenPensionerCutOffFetchService fetchservice) {
		this.fetchservice = fetchservice;
	}

	/**
	 * @return the fetchservice
	 */
	public HrPenPensionerCutOffFetchService getFetchservice() {
		return fetchservice;
	}
	
	
	
}
