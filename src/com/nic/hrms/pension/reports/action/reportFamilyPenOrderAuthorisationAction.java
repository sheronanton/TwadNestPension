package com.nic.hrms.pension.reports.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.util.DateUtil;

import net.sf.jasperreports.engine.JRException;
import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.reports.model.FamilyPensionerOrderDao;
import com.nic.hrms.pension.reports.service.reportFamilyPenOrderAuthorisationService;


public class reportFamilyPenOrderAuthorisationAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;


	List <FamilyPensionerOrderDao> penOrderDetails;	
	List <FamilyPensionerOrderDao> penOrder1Details;
	List <FamilyPensionerOrderDao> penOrder2Details;
	List <FamilyPensionerOrderDao> penOrder3Details;
	List <FamilyPensionerOrderDao> penOrder4Details;
	List <Map> penOrder5Details;
	List<Object[]> penOrderReplist;
	List<Object[]> penOrder5Detail;

	private reportFamilyPenOrderAuthorisationService reportFamilyPenOrderAuthoService;
	HashMap<String, String> reportOrderAuthoParams=new HashMap<String,String>();

	private CommonSearchModel reportPenOrderAutho;

	private int empId;


	public String printPensionOrder1() throws JRException
	{
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		penOrderDetails=reportFamilyPenOrderAuthoService.getPenOrder1Details(getRequest(), empId);
		penOrder1Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/FamilyPensionOrderForm1_I.jasper"));

		return SUCCESS;
	}


	public String PenOrderAuthorisationReportUserSrch(){

		try{

			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			//empId=empProfile.getEmployeeId();
			empId=Integer.parseInt(getRequest().getParameter("empId"));

			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();

			xmlString.append("<response>");
			boolean flag = false;

			penOrderReplist=reportFamilyPenOrderAuthoService.penOrderAuthorisationReportUserSearch(empId);

			xmlString.append("<command>PenOrderAuthorisationReportUserSearch</command>");   

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
			System.out.println("error in pension order authorisation user searching the data to the databse"+e);
		}		  
		return null;
	}






	@SuppressWarnings({ "unchecked", "deprecation" })
	public String printPensionOrder2() throws JRException
	{
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		penOrderDetails=reportFamilyPenOrderAuthoService.getPenOrder2Details(getRequest(), empId);
		penOrder3Details=reportFamilyPenOrderAuthoService.getPenOrder2PersonDetails(getRequest(), empId);
		penOrder2Details=reportFamilyPenOrderAuthoService.getPenOrder2_IPersonDetails(getRequest(), empId);
		penOrder5Detail=reportFamilyPenOrderAuthoService.getPenOrder2_IPersonNomineeDetails(empId);
		System.out.println("LIST SIZE:::"+penOrder5Detail.size());
		
		penOrder5Details = new ArrayList<Map>();
		for(Iterator<Object[]> itr=penOrder5Detail.iterator();itr.hasNext();)
		{
			Map tmpMap= new HashMap();
			String relationship="";
			Object[] val=(Object[])itr.next();
			tmpMap.put("slno", val[0]+"");
			tmpMap.put("name", val[1]+"");
			if((val[2]+"").equalsIgnoreCase("1"))
			{
				relationship="Father";
			}
			if((val[2]+"").equalsIgnoreCase("2"))
			{
				relationship="Mother";
			}
			if((val[2]+"").equalsIgnoreCase("3"))
			{
				relationship="Spouse";
			}
			/*if((val[2]+"").equalsIgnoreCase("4"))
			{
				relationship="Spouse";
			}*/
			if((val[2]+"").equalsIgnoreCase("4"))
			{
				relationship="Son";
			}
			if((val[2]+"").equalsIgnoreCase("5"))
			{
				relationship="Daughter";
			}
			tmpMap.put("relationship", relationship);
			/*Date date=null;
			try{  
				date =(Date)new SimpleDateFormat("dd-MMM-yy").parse(val[3]+"");
				tmpMap.put("dob", ((Date)new SimpleDateFormat("dd-MM-yyyy").parse(val[3]+"")));
				System.out.println("CURRENT DATE:::"+date);
			}
			catch (Exception e){
				e.getMessage();
			} */
			tmpMap.put("dob", val[3]);

			penOrder5Details.add(tmpMap);
		}
		penOrder1Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/FamilyPensionOrderForm2_I.jasper"));
		reportOrderAuthoParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/FamilyPensionOrderForm2_II.jasper"));
		reportOrderAuthoParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/FamilyPensionOrderForm2_III.jasper"));
		reportOrderAuthoParams.put("dir3",getRequest().getRealPath("/org/HR/hr/pension/reports/FamilPensionOrderForm2_IV.jasper"));
		
		return SUCCESS;
	}







	public String printPensionOrder3() throws JRException
	{
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		penOrderDetails=reportFamilyPenOrderAuthoService.getPenOrder3Details(getRequest(), empId);
		penOrder3Details=reportFamilyPenOrderAuthoService.getPenOrder3PersonDetails(getRequest(), empId);
		penOrder1Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/FamilyPensionOrderForm3_I.jasper"));
		reportOrderAuthoParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/FamilyPensionOrderForm3_II.jasper"));

		return SUCCESS;
	}


	public String printPensionOrder4() throws JRException
	{
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
			empId=Integer.parseInt(getRequest().getParameter("empId"));
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}
		penOrderDetails=reportFamilyPenOrderAuthoService.getPenOrder4Details(getRequest(), empId);
		penOrder4Details=penOrderDetails;
		reportOrderAuthoParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/PensionOrderForm4_I.jasper"));

		return SUCCESS;
	}


	public String printPensionOrder5() throws JRException
	{		
		int empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");		
			empId=Integer.parseInt(getRequest().getParameter("empId"));				
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	


		penOrderDetails=reportFamilyPenOrderAuthoService.getPenOrder5Details(getRequest(),empId);			
		return SUCCESS;

	}


	public List<FamilyPensionerOrderDao> getPenOrderDetails() {
		return penOrderDetails;
	}
	public void setPenOrderDetails(List<FamilyPensionerOrderDao> penOrderDetails) {
		this.penOrderDetails = penOrderDetails;
	}
	public List<FamilyPensionerOrderDao> getPenOrder1Details() {
		return penOrder1Details;
	}
	public void setPenOrder1Details(List<FamilyPensionerOrderDao> penOrder1Details) {
		this.penOrder1Details = penOrder1Details;
	}
	public List<FamilyPensionerOrderDao> getPenOrder2Details() {
		return penOrder2Details;
	}
	public void setPenOrder2Details(List<FamilyPensionerOrderDao> penOrder2Details) {
		this.penOrder2Details = penOrder2Details;
	}
	public List<FamilyPensionerOrderDao> getPenOrder3Details() {
		return penOrder3Details;
	}
	public void setPenOrder3Details(List<FamilyPensionerOrderDao> penOrder3Details) {
		this.penOrder3Details = penOrder3Details;
	}
	public List<FamilyPensionerOrderDao> getPenOrder4Details() {
		return penOrder4Details;
	}
	public void setPenOrder4Details(List<FamilyPensionerOrderDao> penOrder4Details) {
		this.penOrder4Details = penOrder4Details;
	}
	public reportFamilyPenOrderAuthorisationService getReportFamilyPenOrderAuthoService() {
		return reportFamilyPenOrderAuthoService;
	}
	public void setReportFamilyPenOrderAuthoService(
			reportFamilyPenOrderAuthorisationService reportFamilyPenOrderAuthoService) {
		this.reportFamilyPenOrderAuthoService = reportFamilyPenOrderAuthoService;
	}
	public HashMap<String, String> getReportOrderAuthoParams() {
		return reportOrderAuthoParams;
	}
	public void setReportOrderAuthoParams(
			HashMap<String, String> reportOrderAuthoParams) {
		this.reportOrderAuthoParams = reportOrderAuthoParams;
	}
	public CommonSearchModel getReportPenOrderAutho() {
		return reportPenOrderAutho;
	}
	public void setReportPenOrderAutho(CommonSearchModel reportPenOrderAutho) {
		this.reportPenOrderAutho = reportPenOrderAutho;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public List<Map> getPenOrder5Details() {
		return penOrder5Details;
	}
	public void setPenOrder5Details(List<Map> penOrder5Details) {
		this.penOrder5Details = penOrder5Details;
	}
	public List<Object[]> getPenOrderReplist() {
		return penOrderReplist;
	}
	public void setPenOrderReplist(List<Object[]> penOrderReplist) {
		this.penOrderReplist = penOrderReplist;
	}
}
