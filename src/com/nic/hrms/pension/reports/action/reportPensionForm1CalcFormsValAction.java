package com.nic.hrms.pension.reports.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDeathDao;
import com.nic.hrms.pension.reports.service.reportPensionForm1CalcFormValService;


public class reportPensionForm1CalcFormsValAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988931778640042309L;
	
	
	List <pensionForm1CalcValDetailsDao> pensionForm1CalcValDetails;
	List <pensionForm1CalcValDetailsDeathDao> pensionForm1CalcDeathValDetails;
	List <pensionForm1CalcValDetailsDao> form1avgValDetails;
	List <pensionForm1CalcValDetailsDao> form1Valrecovery;
	//List <pensionForm1CalcValDetailsDao> Valform1Valrecovery;
	List <pensionForm1CalcValDetailsDao> form1otherdeptservicesVal;
	


	private reportPensionForm1CalcFormValService reportpensionForm1CalcValService;
	
	List <pensionForm1CalcValDetailsDao> form1SubReportDetails;
	List <pensionForm1CalcValDetailsDeathDao> form1SubReportDeathDetails;
	HashMap<String, String> reportValParams=new HashMap<String,String>();
	
	private CommonSearchModel reportOffValForm1;
	
	@SuppressWarnings("deprecation")
	public String valfieldofficeprint() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		//empId=empProfileChBnk.getEmployeeId();
		
		//System.out.println("SEARCH EMP NO................>>>>"+reportOffForm1.getSearchKeyword());
		System.out.println("Val Form1 SEARCH EMP NO................>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		System.out.println("Val form1 typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionForm1CalcValDetails=reportpensionForm1CalcValService.getPensionForm1CalcValDetails(getRequest(),empId);		
		form1avgValDetails=reportpensionForm1CalcValService.getForm1AvgValDetails(getRequest(),empId);
		form1Valrecovery=reportpensionForm1CalcValService.getForm1RecoveryValDetails(getRequest(),empId);
		//Valform1Valrecovery=reportpensionForm1CalcValService.getForm1OtherDeptServiceVal(getRequest(),empId);
		form1otherdeptservicesVal=reportpensionForm1CalcValService.getForm1OtherDeptServiceVal(getRequest(), empId);
		//form1SubReportDetails=reportpensionForm1CalcValService.getPensionForm1CalcValDetails(getRequest(),empId);
		form1SubReportDetails=pensionForm1CalcValDetails;		    
		
			reportValParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Average_Emoulment_Val_Form1.jasper"));
			reportValParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Val_Form1.jasper"));
			reportValParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/Pension_Form1_calculation_Val_main_I.jasper"));
			reportValParams.put("dir3",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservicesVal.jasper"));
			
		//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String valfieldofficedeathprint() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		
		System.out.println("Val Form1 DEATH SEARCH EMP NO................>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		System.out.println("Val form1 DEATH typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionForm1CalcDeathValDetails=reportpensionForm1CalcValService.getPensionForm1CalcDeathValDetails(getRequest(),empId);		
		form1Valrecovery=reportpensionForm1CalcValService.getForm1RecoveryValDetails(getRequest(),empId);
		form1otherdeptservicesVal=reportpensionForm1CalcValService.getForm1OtherDeptServiceVal(getRequest(), empId);
		form1SubReportDeathDetails=pensionForm1CalcDeathValDetails;
				    
		
			reportValParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Val_Form1.jasper"));
			reportValParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/Pension_Form1_calculation_death_Val_main_I.jasper"));
			reportValParams.put("dir3",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservicesVal.jasper"));
			
			//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}


	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String valfieldofficeworkingsheetprint() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		//empId=empProfileChBnk.getEmployeeId();
		
		//System.out.println("SEARCH EMP NO................>>>>"+reportOffForm1.getSearchKeyword());
		System.out.println("Val Form1 SEARCH EMP NO................>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		System.out.println("Val form1 typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionForm1CalcValDetails=reportpensionForm1CalcValService.getPensionForm1CalcValDetails(getRequest(),empId);		
		form1avgValDetails=reportpensionForm1CalcValService.getForm1AvgValDetails(getRequest(),empId);
		form1Valrecovery=reportpensionForm1CalcValService.getForm1RecoveryValDetails(getRequest(),empId);
		form1otherdeptservicesVal=reportpensionForm1CalcValService.getForm1OtherDeptServiceVal(getRequest(), empId);
		
		//form1SubReportDetails=reportpensionForm1CalcValService.getPensionForm1CalcValDetails(getRequest(),empId);
		form1SubReportDetails=pensionForm1CalcValDetails;		    
		
			reportValParams.put("dir",getRequest().getRealPath("/org/HR/hr/pension/reports/Average_Emoulment_Val_Form1.jasper"));
			reportValParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Val_Form1.jasper"));
			reportValParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/Pension_Form1_calculation_Working_Sheet_Val_main_I.jasper"));
			reportValParams.put("dir3",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservicesVal.jasper"));
			
			//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public String valfieldofficeworkingsheetdeathprint() throws JRException
	{
		
		int empId=0;
		String typeOfPen="";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfileChBnk=(UserProfile)session.getAttribute("UserProfile");
		
		System.out.println("Val Form1 DEATH SEARCH EMP NO................>>>>"+getRequest().getParameter("empId"));
		empId=Integer.parseInt(getRequest().getParameter("empId"));
		typeOfPen=getRequest().getParameter("typeOfPen");
		System.out.println("Val form1 DEATH typeOfPen................>>>>"+getRequest().getParameter("typeOfPen"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Session Value");
		}	
		
		
		
		
		pensionForm1CalcDeathValDetails=reportpensionForm1CalcValService.getPensionForm1CalcDeathValDetails(getRequest(),empId);		
		form1Valrecovery=reportpensionForm1CalcValService.getForm1RecoveryValDetails(getRequest(),empId);
		form1otherdeptservicesVal=reportpensionForm1CalcValService.getForm1OtherDeptServiceVal(getRequest(), empId);
		//form1SubReportDeathDetails=pensionForm1CalcDeathValDetails;
				    
		
			reportValParams.put("dir1",getRequest().getRealPath("/org/HR/hr/pension/reports/Recoveries_Val_Form1.jasper"));
			reportValParams.put("dir3",getRequest().getRealPath("/org/HR/hr/pension/reports/form1otherdeptservicesVal.jasper"));
			//reportValParams.put("dir2",getRequest().getRealPath("/org/HR/hr/pension/reports/Pension_Form1_calculation_death_Val_main_I.jasper"));
		//SUBREPORT_DIR,SUBREPORT_DIR1
		return SUCCESS;
		
	}

	
	





	public List<pensionForm1CalcValDetailsDao> getPensionForm1CalcValDetails() {
		return pensionForm1CalcValDetails;
	}

	public void setPensionForm1CalcValDetails(
			List<pensionForm1CalcValDetailsDao> pensionForm1CalcValDetails) {
		this.pensionForm1CalcValDetails = pensionForm1CalcValDetails;
	}

	public List<pensionForm1CalcValDetailsDeathDao> getPensionForm1CalcDeathValDetails() {
		return pensionForm1CalcDeathValDetails;
	}

	public void setPensionForm1CalcDeathValDetails(
			List<pensionForm1CalcValDetailsDeathDao> pensionForm1CalcDeathValDetails) {
		this.pensionForm1CalcDeathValDetails = pensionForm1CalcDeathValDetails;
	}

	public List<pensionForm1CalcValDetailsDao> getForm1avgValDetails() {
		return form1avgValDetails;
	}

	public void setForm1avgValDetails(
			List<pensionForm1CalcValDetailsDao> form1avgValDetails) {
		this.form1avgValDetails = form1avgValDetails;
	}

	public List<pensionForm1CalcValDetailsDao> getForm1Valrecovery() {
		return form1Valrecovery;
	}

	public void setForm1Valrecovery(
			List<pensionForm1CalcValDetailsDao> form1Valrecovery) {
		this.form1Valrecovery = form1Valrecovery;
	}

	public reportPensionForm1CalcFormValService getReportpensionForm1CalcValService() {
		return reportpensionForm1CalcValService;
	}

	public void setReportpensionForm1CalcValService(
			reportPensionForm1CalcFormValService reportpensionForm1CalcValService) {
		this.reportpensionForm1CalcValService = reportpensionForm1CalcValService;
	}

	public HashMap<String, String> getReportValParams() {
		return reportValParams;
	}

	public void setReportValParams(HashMap<String, String> reportValParams) {
		this.reportValParams = reportValParams;
	}

	public CommonSearchModel getReportOffValForm1() {
		return reportOffValForm1;
	}

	public void setReportOffValForm1(CommonSearchModel reportOffValForm1) {
		this.reportOffValForm1 = reportOffValForm1;
	}

	public List<pensionForm1CalcValDetailsDao> getForm1SubReportDetails() {
		return form1SubReportDetails;
	}

	public void setForm1SubReportDetails(
			List<pensionForm1CalcValDetailsDao> form1SubReportDetails) {
		this.form1SubReportDetails = form1SubReportDetails;
	}

	public List<pensionForm1CalcValDetailsDeathDao> getForm1SubReportDeathDetails() {
		return form1SubReportDeathDetails;
	}

	public void setForm1SubReportDeathDetails(
			List<pensionForm1CalcValDetailsDeathDao> form1SubReportDeathDetails) {
		this.form1SubReportDeathDetails = form1SubReportDeathDetails;
	}


	/*public List<pensionForm1CalcValDetailsDao> getValform1Valrecovery() {
		return Valform1Valrecovery;
	}


	public void setValform1Valrecovery(
			List<pensionForm1CalcValDetailsDao> valform1Valrecovery) {
		Valform1Valrecovery = valform1Valrecovery;
	}
*/

	
	public List<pensionForm1CalcValDetailsDao> getForm1otherdeptservicesVal() {
		return form1otherdeptservicesVal;
	}

	public void setForm1otherdeptservicesVal(
			List<pensionForm1CalcValDetailsDao> form1otherdeptservicesVal) {
		this.form1otherdeptservicesVal = form1otherdeptservicesVal;
	}
	
	
	
	
}
