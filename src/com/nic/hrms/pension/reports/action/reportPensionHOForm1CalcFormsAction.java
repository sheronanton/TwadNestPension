package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDeathDao;
import com.nic.hrms.pension.reports.service.reportPensionHOForm1CalcFormService;


public class reportPensionHOForm1CalcFormsAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	
	List <pensionForm1CalcDetailsDao> pensionHOForm1CalcDetails;
	List <pensionForm1CalcDetailsDeathDao> pensionHOForm1CalcDeathDetails;
	List <pensionForm1CalcDetailsDao> form1avgDetails;
	List <pensionForm1CalcDetailsDao> form1recovery;
	List <pensionForm1CalcDetailsDao> form1otherdeptservice;
	
	private reportPensionHOForm1CalcFormService reportpensionHOForm1CalcService;
	HashMap<String, String> reportParams=new HashMap<String,String>();
	
	private CommonSearchModel reportOffHOForm1;
	
	@SuppressWarnings("deprecation")
	public String headOffice_report_print() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		
		System.out.println("SEARCH EMP NO.........HEAD OFFICE.......>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		System.out.println("HEAD OFFICE typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionHOForm1CalcDetails=reportpensionHOForm1CalcService.getPensionHOForm1CalcDetails(getRequest(),empId);		
		form1avgDetails=reportpensionHOForm1CalcService.getHOForm1AvgDetails(getRequest(),empId);
		form1recovery=reportpensionHOForm1CalcService.getHOForm1RecoveryDetails(getRequest(),empId);
		form1otherdeptservice=reportpensionHOForm1CalcService.getHOForm1OtherDeptService(getRequest(),empId);
				    
		
			reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Average_Emoulment_Form1.jasper"));
			reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Form1.jasper"));
			reportParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservices.jasper"));
		//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String headOffice_report_deathprint() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		
		System.out.println("DEATH SEARCH EMP NO.........HEAD OFFICE.......>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		System.out.println("DEATH HEAD OFFICE typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionHOForm1CalcDeathDetails=reportpensionHOForm1CalcService.getPensionHOForm1CalcDeathDetails(getRequest(),empId);		
		form1recovery=reportpensionHOForm1CalcService.getHOForm1RecoveryDetails(getRequest(),empId);
		form1otherdeptservice=reportpensionHOForm1CalcService.getHOForm1OtherDeptService(getRequest(),empId);
				    
		
			reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Form1.jasper"));
			reportParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservices.jasper"));
		//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	public List<pensionForm1CalcDetailsDao> getPensionHOForm1CalcDetails() {
		return pensionHOForm1CalcDetails;
	}
	public void setPensionHOForm1CalcDetails(
			List<pensionForm1CalcDetailsDao> pensionHOForm1CalcDetails) {
		this.pensionHOForm1CalcDetails = pensionHOForm1CalcDetails;
	}
	public List<pensionForm1CalcDetailsDeathDao> getPensionHOForm1CalcDeathDetails() {
		return pensionHOForm1CalcDeathDetails;
	}
	public void setPensionHOForm1CalcDeathDetails(
			List<pensionForm1CalcDetailsDeathDao> pensionHOForm1CalcDeathDetails) {
		this.pensionHOForm1CalcDeathDetails = pensionHOForm1CalcDeathDetails;
	}
	public List<pensionForm1CalcDetailsDao> getForm1avgDetails() {
		return form1avgDetails;
	}
	public void setForm1avgDetails(List<pensionForm1CalcDetailsDao> form1avgDetails) {
		this.form1avgDetails = form1avgDetails;
	}	
	public List<pensionForm1CalcDetailsDao> getForm1recovery() {
		return form1recovery;
	}
	public void setForm1recovery(List<pensionForm1CalcDetailsDao> form1recovery) {
		this.form1recovery = form1recovery;
	}	
	public reportPensionHOForm1CalcFormService getReportpensionHOForm1CalcService() {
		return reportpensionHOForm1CalcService;
	}
	public void setReportpensionHOForm1CalcService(
			reportPensionHOForm1CalcFormService reportpensionHOForm1CalcService) {
		this.reportpensionHOForm1CalcService = reportpensionHOForm1CalcService;
	}
	public HashMap<String, String> getReportParams() {
		return reportParams;
	}
	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}
	public CommonSearchModel getReportOffHOForm1() {
		return reportOffHOForm1;
	}
	public void setReportOffHOForm1(CommonSearchModel reportOffHOForm1) {
		this.reportOffHOForm1 = reportOffHOForm1;
	}
	public List<pensionForm1CalcDetailsDao> getForm1otherdeptservice() {
		return form1otherdeptservice;
	}

	public void setForm1otherdeptservice(
			List<pensionForm1CalcDetailsDao> form1otherdeptservice) {
		this.form1otherdeptservice = form1otherdeptservice;
	}

	
	
	
	

}
