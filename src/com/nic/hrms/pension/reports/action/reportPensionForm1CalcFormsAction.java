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
import com.nic.hrms.pension.reports.service.reportPensionForm1CalcFormService;



public class reportPensionForm1CalcFormsAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	
	List <pensionForm1CalcDetailsDao> pensionForm1CalcDetails;
	List <pensionForm1CalcDetailsDeathDao> pensionForm1CalcDeathDetails;
	List <pensionForm1CalcDetailsDao> form1avgDetails;
	List <pensionForm1CalcDetailsDao> form1recovery;
	List <pensionForm1CalcDetailsDao> form1otherdeptservice;
	private reportPensionForm1CalcFormService reportpensionForm1CalcService;
	HashMap<String, String> reportParams=new HashMap<String,String>();
	
	private CommonSearchModel reportOffForm1;
	
	@SuppressWarnings("deprecation")
	public String print() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		//empId=empProfileChBnk.getEmployeeId();
		
		//System.out.println("SEARCH EMP NO................>>>>"+reportOffForm1.getSearchKeyword());
		//System.out.println("SEARCH EMP NO.........676767.......>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		//System.out.println("typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionForm1CalcDetails=reportpensionForm1CalcService.getPensionForm1CalcDetails(getRequest(),empId);		
		form1avgDetails=reportpensionForm1CalcService.getForm1AvgDetails(getRequest(),empId);
		form1recovery=reportpensionForm1CalcService.getForm1RecoveryDetails(getRequest(),empId);
		form1otherdeptservice=reportpensionForm1CalcService.getForm1OtherDeptService(getRequest(),empId);
				    
		
		reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Average_Emoulment_Form1.jasper"));
		reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Form1.jasper"));
		reportParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservices.jasper"));
		//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}
	
	
	
	
	/*@SuppressWarnings("deprecation")
	public String otherdeptservice() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		
		//System.out.println("DEATH SEARCH EMP NO.........676767.......>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		//System.out.println("DEATH typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionForm1CalcDeathDetails=reportpensionForm1CalcService.getPensionForm1CalcDeathDetails(getRequest(),empId);		
		//form1avgDetails=reportpensionForm1CalcService.getForm1AvgDetails(getRequest(),empId);
		form1recovery=reportpensionForm1CalcService.getForm1RecoveryDetails(getRequest(),empId);
		
				    
		
			//reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Average_Emoulment_Form1.jasper"));
			reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/.jasper"));
		//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}
	*/
	
	
	
	@SuppressWarnings("deprecation")
	public String deathprint() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		
		//System.out.println("DEATH SEARCH EMP NO.........676767.......>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		//System.out.println("DEATH typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionForm1CalcDeathDetails=reportpensionForm1CalcService.getPensionForm1CalcDeathDetails(getRequest(),empId);		
		//form1avgDetails=reportpensionForm1CalcService.getForm1AvgDetails(getRequest(),empId);
		form1recovery=reportpensionForm1CalcService.getForm1RecoveryDetails(getRequest(),empId);
		form1otherdeptservice=reportpensionForm1CalcService.getForm1OtherDeptService(getRequest(),empId);
		
				    
		
			//reportParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Average_Emoulment_Form1.jasper"));
			reportParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Form1.jasper"));
			reportParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservices.jasper"));
		//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}
	
	
	
	
	
	
	public List<pensionForm1CalcDetailsDao> getPensionForm1CalcDetails() {
		return pensionForm1CalcDetails;
	}
	public void setPensionForm1CalcDetails(
			List<pensionForm1CalcDetailsDao> pensionForm1CalcDetails) {
		this.pensionForm1CalcDetails = pensionForm1CalcDetails;
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
	public reportPensionForm1CalcFormService getReportpensionForm1CalcService() {
		return reportpensionForm1CalcService;
	}
	public void setReportpensionForm1CalcService(
			reportPensionForm1CalcFormService reportpensionForm1CalcService) {
		this.reportpensionForm1CalcService = reportpensionForm1CalcService;
	}
	public HashMap<String, String> getReportParams() {
		return reportParams;
	}
	public void setReportParams(HashMap<String, String> reportParams) {
		this.reportParams = reportParams;
	}

	public void setReportOffForm1(CommonSearchModel reportOffForm1) {
		this.reportOffForm1 = reportOffForm1;
	}

	public CommonSearchModel getReportOffForm1() {
		return reportOffForm1;
	}

	public List<pensionForm1CalcDetailsDeathDao> getPensionForm1CalcDeathDetails() {
		return pensionForm1CalcDeathDetails;
	}
	public void setPensionForm1CalcDeathDetails(
			List<pensionForm1CalcDetailsDeathDao> pensionForm1CalcDeathDetails) {
		this.pensionForm1CalcDeathDetails = pensionForm1CalcDeathDetails;
	}


	public List<pensionForm1CalcDetailsDao> getForm1otherdeptservice() {
		return form1otherdeptservice;
	}

	public void setForm1otherdeptservice(
			List<pensionForm1CalcDetailsDao> form1otherdeptservice) {
		this.form1otherdeptservice = form1otherdeptservice;
	}
	
	

	/*public List<Otherdeptservicedao> getForm1otherdeptservice() {
		return form1otherdeptservice;
	}

	public void setForm1otherdeptservice(
			List<Otherdeptservicedao> form1otherdeptservice) {
		this.form1otherdeptservice = form1otherdeptservice;
	}
	*/
	
	
	

}
