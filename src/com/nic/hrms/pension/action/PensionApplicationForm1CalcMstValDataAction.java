package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.List;
import java.lang.Integer;
//import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsDao;
import com.nic.hrms.pension.model.PensionApplicationCalcSearchModel;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServicePK;
import com.nic.hrms.pension.model.PensionApplicationForm1ValDao;
import com.nic.hrms.pension.service.PensionApplicationForm1CalcMstValDataService;
import com.nic.hrms.pension.service.UpdatedUserIdService;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceValPK;

public class PensionApplicationForm1CalcMstValDataAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2580606530771088937L;
	private PensionApplicationForm1CalcMstValDataService penappmform1calcValservice;
	private PensionApplicationCalcSearchModel penAppCalcComm;
	private PensionApplicationForm1ValDao pensionAppCalcValForm1;
	private PensionApplicationForm1OthDeptServicePK pensionapplform1pk;
	
	
	
	private List<String> maxcheck_value;
	private List<String> fromdate;
	private List<String> todate;
	private List<Integer> tmonth;
	private List<Integer> tday;
	
	private List<Integer> basic_pay;
	private List<Integer> grade_pay;
	private List<Integer> special_pay;
	private List<Integer> optionpay1;
	private List<Integer> optionpay2;
	private List<Integer> optionpay3;
	
	private String[] othdeptfromdate;
	private String[] othdepttodate;
	private Integer[] otdepyear;
	private Integer[] otdepmonth;
	private Integer[] othdeptday;
	private String[] Departmentname;
	private String[] Remarks;
	
	
	private List<Float> ppamount;
	
	private List<PensionApplicationForm1AverageEmolumentsValDao> valform1aemultidatlist;
	
	
	private List<String> rec_description;
	private List<Integer> rec_amount;
	
	private List<PensionApplicationForm1RecoveriesValDao> valform1recmultidatlist;
	private List<PensionApplicationForm1OthDeptServiceValDao> valform1Otherservicelist;
	
	private Integer reportEmpId;
	private String typeofPension="";
	
	private UpdatedUserIdService updateservice;
	
	
	public String loadSettingValData()
	{
		int loginEmpId=0;
		
		List<Object[]> mysettingList=null;
		List<Object []> myavgsettingList=null;
		List<Object[]> dasettingList=null;
		StringBuffer xmlString = new StringBuffer();
		
		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		boolean myFlag=false;
		try
		{
			PrintWriter out = getResponse().getWriter();	
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			loginEmpId=empProfile.getEmployeeId();					
			
			mysettingList=penappmform1calcValservice.penAppForm1CalcSettingValData();
			myavgsettingList=penappmform1calcValservice.penAppForm1CalcAvgSettingValData();			
			  int dapercentage=0;
			
			if(mysettingList.size()>0)
			{				
								
					xmlString.append("<record>");	
					
					for(Object[] settingtl: mysettingList)
					{
						Object[] settingtemp=settingtl;
						
						xmlString.append("<Min_quali_wce_service>"+settingtemp[0]+"</Min_quali_wce_service>");
						xmlString.append("<Selection_grade_gap>"+settingtemp[1]+"</Selection_grade_gap>");
						xmlString.append("<Spl_grade_gap>"+settingtemp[2]+"</Spl_grade_gap>");
						xmlString.append("<Vrs_eligible_yrs>"+settingtemp[3]+"</Vrs_eligible_yrs>");
						xmlString.append("<Pension_eligible_yrs>"+settingtemp[4]+"</Pension_eligible_yrs>");
						xmlString.append("<Family_pension_ceiling_yrs>"+settingtemp[5]+"</Family_pension_ceiling_yrs>");
						xmlString.append("<Family_pension_ceiling_percent>"+settingtemp[6]+"</Family_pension_ceiling_percent>");
						xmlString.append("<Family_pension_after_percent>"+settingtemp[7]+"</Family_pension_after_percent>");
						xmlString.append("<Pension_half_yr_ceiling>"+settingtemp[8]+"</Pension_half_yr_ceiling>");
						xmlString.append("<Dcrg_half_yr_celing>"+settingtemp[9]+"</Dcrg_half_yr_celing>");
						xmlString.append("<Max_dcrg_amt>"+settingtemp[10]+"</Max_dcrg_amt>");
						xmlString.append("<Avg_total_months>"+settingtemp[11]+"</Avg_total_months>");
						xmlString.append("<Retirement_celing_yrs>"+settingtemp[12]+"</Retirement_celing_yrs>");
						xmlString.append("<Weightage_max>"+settingtemp[13]+"</Weightage_max>");
						xmlString.append("<Family_pension_ceiling_age>"+settingtemp[14]+"</Family_pension_ceiling_age>");
						xmlString.append("<Min_pension_amt>"+settingtemp[15]+"</Min_pension_amt>");
						xmlString.append("<Max_pension_amt>"+settingtemp[16]+"</Max_pension_amt>");						
						xmlString.append("<Min_fam_pension_amt>"+settingtemp[17]+"</Min_fam_pension_amt>");
						xmlString.append("<Max_fam_pension_amt>"+settingtemp[18]+"</Max_fam_pension_amt>");
						
					}					
					for(Object[] avgsettingtl: myavgsettingList)
					{
						Object[] avgsettingtemp=avgsettingtl;
						xmlString.append("<averagerecord>");
						xmlString.append("<PAY_NAME>"+avgsettingtemp[0]+"</PAY_NAME>");
						xmlString.append("<INCLUDE>"+avgsettingtemp[1]+"</INCLUDE>");
						xmlString.append("<DA>"+avgsettingtemp[2]+"</DA>");
						xmlString.append("<DISPLAY_CAPTION>"+avgsettingtemp[3]+"</DISPLAY_CAPTION>");						
						xmlString.append("</averagerecord>");
					}		
					
						xmlString.append("<da_percentage>"+dapercentage+"</da_percentage>");		
					
					
					xmlString.append("</record>");
					
					myFlag=true;					
				 
				if(myFlag) 
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
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	
	public String loadPenAppForm1MstValData()
	{
		int loginEmpId=0;
		int curloginEmpId=0;
		List<Object[]> myList=null;
		List<Object[]> mysettingList=null;
		List<Object []> myavgsettingList=null;
		List<Object[]> dasettingList=null;
		StringBuffer xmlString = new StringBuffer();
		
		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		boolean myFlag=false;
		try
		{
			PrintWriter out = getResponse().getWriter();	
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			curloginEmpId=empProfile.getEmployeeId();
			loginEmpId=pensionAppCalcValForm1.getEmpNo();
			
					
			myList=penappmform1calcValservice.penAppForm1MstValData(loginEmpId,curloginEmpId);
			int dapercentage=0;
			if(myList.size()>0)
			{				
				for(Object[] tl: myList)
				 {
					Object[] temp=tl;
					xmlString.append("<record>");					
					xmlString.append("<empid>"+temp[0]+"</empid>");
					xmlString.append("<empname>"+temp[1]+"</empname>");
					xmlString.append("<empinit>"+temp[2]+"</empinit>");
					xmlString.append("<gpfno>"+temp[3]+"</gpfno>");
					
					if(temp[4]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dob=formatter.format(temp[4]);
						xmlString.append("<dob>"+dob+"</dob>");
					}
					else
					{
						xmlString.append("<dob>"+temp[4]+"</dob>");
					}
					
					xmlString.append("<gender>"+temp[5]+"</gender>");
					xmlString.append("<officename>"+temp[6]+"</officename>");
					xmlString.append("<designation>"+temp[7]+"</designation>");					
					if(temp[12]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String doj=formatter.format(temp[12]);
						xmlString.append("<doj>"+doj+"</doj>");
					}
					else
					{
						xmlString.append("<doj>"+temp[12]+"</doj>");
					}
					xmlString.append("<grade>"+temp[13]+"</grade>");
					xmlString.append("<fromsession>"+temp[14]+"</fromsession>");
					if(temp[15]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String doj=formatter.format(temp[15]);
						xmlString.append("<doj1>"+doj+"</doj1>");
					}
					else
					{
						xmlString.append("<doj1>"+temp[15]+"</doj1>");
					}
					xmlString.append("<fromsession1>"+temp[16]+"</fromsession1>");
					
					if(temp[17]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dor=formatter.format(temp[17]);
						xmlString.append("<retiredate>"+dor+"</retiredate>");
						dapercentage=penappmform1calcValservice.penAppForm1CalcdaSettingValData(dor);
					}
					else
					{
						xmlString.append("<retiredate>"+temp[17]+"</retiredate>");
					}
					
					xmlString.append("<officeid>"+temp[9]+"</officeid>");
					xmlString.append("<desigid>"+temp[10]+"</desigid>");
					xmlString.append("<desigservgrp>"+temp[11]+"</desigservgrp>");				
					xmlString.append("<empStatusId>"+temp[18]+"</empStatusId>");
					
					
					
					xmlString.append("</record>");
					
					myFlag=true;
					
				 }
				if(myFlag) 
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
			
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	
	public String loadPenAppForm1OldMstValData()
	{
		int loginEmpId=0;
		List<Object[]> myOldList=null;		
		StringBuffer oldxmlString = new StringBuffer();
		
		oldxmlString.append("<oldresponse>");
		oldxmlString.append("<oldcommand>Get</oldcommand>");
		boolean oldmyFlag=false;
		try
		{
			PrintWriter out = getResponse().getWriter();	
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			//loginEmpId=empProfile.getEmployeeId();
			loginEmpId=pensionAppCalcValForm1.getEmpNo();
			myOldList=penappmform1calcValservice.penAppForm1CalcOldMstValData(loginEmpId);
			
			if(myOldList.size()>0)
			{				
				for(Object[] oldtl: myOldList)
				 {
					Object[] oldtemp=oldtl;
					oldxmlString.append("<oldrecord>");					
					oldxmlString.append("<EMP_ID>"+oldtemp[0]+"</EMP_ID>");					
					oldxmlString.append("<PENSION_TYPE>"+oldtemp[1]+"</PENSION_TYPE>");
					if(oldtemp[2]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dop=formatter.format(oldtemp[2]);
						oldxmlString.append("<DATE_OF_PROVINC>"+dop+"</DATE_OF_PROVINC>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_PROVINC>"+oldtemp[2]+"</DATE_OF_PROVINC>");
					}
					
					
					if(oldtemp[3]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dore=formatter.format(oldtemp[3]);
						oldxmlString.append("<DATE_OF_REG_ESTAB>"+dore+"</DATE_OF_REG_ESTAB>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_REG_ESTAB>"+oldtemp[3]+"</DATE_OF_REG_ESTAB>");
					}
					
					
					if(oldtemp[4]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dos=formatter.format(oldtemp[4]);
						oldxmlString.append("<DATE_OF_SELECTION>"+dos+"</DATE_OF_SELECTION>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_SELECTION>"+oldtemp[4]+"</DATE_OF_SELECTION>");
					}
					
					
					if(oldtemp[5]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dosp=formatter.format(oldtemp[5]);
						oldxmlString.append("<DATE_OF_SPECIAL>"+dosp+"</DATE_OF_SPECIAL>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_SPECIAL>"+oldtemp[5]+"</DATE_OF_SPECIAL>");
					}
					
					if(oldtemp[6]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dovrs=formatter.format(oldtemp[6]);
						oldxmlString.append("<DATE_OF_VRS>"+dovrs+"</DATE_OF_VRS>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_VRS>"+oldtemp[6]+"</DATE_OF_VRS>");
					}
					
					oldxmlString.append("<COMM_OPTED>"+oldtemp[7]+"</COMM_OPTED>");
					oldxmlString.append("<COMM_FACTOR_ONRTHIRD>"+oldtemp[8]+"</COMM_FACTOR_ONRTHIRD>");
					oldxmlString.append("<COM_FACTOR_PERT>"+oldtemp[9]+"</COM_FACTOR_PERT>");
					oldxmlString.append("<WCE_SERV_DAYS>"+oldtemp[10]+"</WCE_SERV_DAYS>");
					oldxmlString.append("<WCE_SERV_MONTH>"+oldtemp[11]+"</WCE_SERV_MONTH>");
					oldxmlString.append("<WCE_SERV_YEAR>"+oldtemp[12]+"</WCE_SERV_YEAR>");
					oldxmlString.append("<WCE_SERV_FLAG>"+oldtemp[13]+"</WCE_SERV_FLAG>");
					oldxmlString.append("<WCE_SERV_COUNT_FLAG>"+oldtemp[14]+"</WCE_SERV_COUNT_FLAG>");
					oldxmlString.append("<CONTINGENT_SERV_FLAG>"+oldtemp[15]+"</CONTINGENT_SERV_FLAG>");
					oldxmlString.append("<CONTINGENT_SERV_DAYS>"+oldtemp[16]+"</CONTINGENT_SERV_DAYS>");
					oldxmlString.append("<CONTINGENT_SERV_MONTH>"+oldtemp[17]+"</CONTINGENT_SERV_MONTH>");					
					oldxmlString.append("<CONTINGENT_SERV_YEAR>"+oldtemp[18]+"</CONTINGENT_SERV_YEAR>");
					oldxmlString.append("<NON_PROV_SERV_DAYS>"+oldtemp[19]+"</NON_PROV_SERV_DAYS>");
					oldxmlString.append("<NON_PROV_SERV_MONTH>"+oldtemp[20]+"</NON_PROV_SERV_MONTH>");
					oldxmlString.append("<NON_PROV_SERV_YEAR>"+oldtemp[21]+"</NON_PROV_SERV_YEAR>");
					oldxmlString.append("<EOL_DAYS>"+oldtemp[22]+"</EOL_DAYS>");
					oldxmlString.append("<EOL_MONTH>"+oldtemp[23]+"</EOL_MONTH>");
					oldxmlString.append("<EOL_YEAR>"+oldtemp[24]+"</EOL_YEAR>");
					oldxmlString.append("<SUSPENSION_DAYS>"+oldtemp[25]+"</SUSPENSION_DAYS>");
					oldxmlString.append("<SUSPENSION_MONTH>"+oldtemp[26]+"</SUSPENSION_MONTH>");
					oldxmlString.append("<SUSPENSION_YEAR>"+oldtemp[27]+"</SUSPENSION_YEAR>");
					oldxmlString.append("<BOY_SERV_DAYS>"+oldtemp[28]+"</BOY_SERV_DAYS>");
					oldxmlString.append("<BOY_SERV_MONTH>"+oldtemp[29]+"</BOY_SERV_MONTH>");
					oldxmlString.append("<BOY_SERV_YEAR>"+oldtemp[30]+"</BOY_SERV_YEAR>");
					oldxmlString.append("<OVERSTAY_LEAVE_DAYS>"+oldtemp[31]+"</OVERSTAY_LEAVE_DAYS>");
					oldxmlString.append("<OVERSTAY_LEAVE_MONTH>"+oldtemp[32]+"</OVERSTAY_LEAVE_MONTH>");
					oldxmlString.append("<OVERSTAY_LEAVE_YEAR>"+oldtemp[33]+"</OVERSTAY_LEAVE_YEAR>");
					oldxmlString.append("<NOT_REG_LEAVE_DAYS>"+oldtemp[34]+"</NOT_REG_LEAVE_DAYS>");
					oldxmlString.append("<NOT_REG_LEAVE_MONTH>"+oldtemp[35]+"</NOT_REG_LEAVE_MONTH>");
					oldxmlString.append("<NOT_REG_LEAVE_YEAR>"+oldtemp[36]+"</NOT_REG_LEAVE_YEAR>");
					oldxmlString.append("<APPRENTICE_DAYS>"+oldtemp[37]+"</APPRENTICE_DAYS>");
					oldxmlString.append("<APPRENTICE_MONTH>"+oldtemp[38]+"</APPRENTICE_MONTH>");
					oldxmlString.append("<APPRENTICE_YEAR>"+oldtemp[39]+"</APPRENTICE_YEAR>");
					oldxmlString.append("<NOT_SERV_VERIFY_DAYS>"+oldtemp[40]+"</NOT_SERV_VERIFY_DAYS>");
					oldxmlString.append("<NOT_SERV_VERIFY_MONTH>"+oldtemp[41]+"</NOT_SERV_VERIFY_MONTH>");
					oldxmlString.append("<NOT_SERV_VERIFY_YEAR>"+oldtemp[42]+"</NOT_SERV_VERIFY_YEAR>");
					oldxmlString.append("<FOREIGN_SERV_DAYS>"+oldtemp[43]+"</FOREIGN_SERV_DAYS>");
					oldxmlString.append("<FOREIGN_SERV_MONTH>"+oldtemp[44]+"</FOREIGN_SERV_MONTH>");
					oldxmlString.append("<FOREIGN_SERV_YEAR>"+oldtemp[45]+"</FOREIGN_SERV_YEAR>");
					oldxmlString.append("<LAST_BASIC_PAY>"+oldtemp[46]+"</LAST_BASIC_PAY>");
					oldxmlString.append("<LAST_SPECIAL_PAY>"+oldtemp[47]+"</LAST_SPECIAL_PAY>");
					oldxmlString.append("<LAST_GRADE_PAY>"+oldtemp[48]+"</LAST_GRADE_PAY>");
					oldxmlString.append("<LAST_OTHER_PAY1>"+oldtemp[49]+"</LAST_OTHER_PAY1>");
					oldxmlString.append("<LAST_OTHER_PAY2>"+oldtemp[50]+"</LAST_OTHER_PAY2>");
					oldxmlString.append("<LAST_OTHER_PAY3>"+oldtemp[51]+"</LAST_OTHER_PAY3>");
					oldxmlString.append("<PENSION_AMOUNT>"+oldtemp[52]+"</PENSION_AMOUNT>");
					oldxmlString.append("<DCRG_AMOUNT>"+oldtemp[53]+"</DCRG_AMOUNT>");
					oldxmlString.append("<NO_OF_HALFYEAR_PENSION>"+oldtemp[54]+"</NO_OF_HALFYEAR_PENSION>");
					oldxmlString.append("<NO_OF_HALFYEAR_DCRG>"+oldtemp[55]+"</NO_OF_HALFYEAR_DCRG>");
					oldxmlString.append("<TOTAL_COMMUTED_AMOUNT>"+oldtemp[56]+"</TOTAL_COMMUTED_AMOUNT>");
					oldxmlString.append("<REDUCED_PENSION_AMOUNT>"+oldtemp[57]+"</REDUCED_PENSION_AMOUNT>");
					oldxmlString.append("<FAMILY_PENSION_50_AMT>"+oldtemp[58]+"</FAMILY_PENSION_50_AMT>");
					oldxmlString.append("<FAMILY_PENSION_30_AMT>"+oldtemp[59]+"</FAMILY_PENSION_30_AMT>");
					oldxmlString.append("<DA_AMOUNT>"+oldtemp[60]+"</DA_AMOUNT>");
					oldxmlString.append("<COMMUTED_VALUE>"+oldtemp[61]+"</COMMUTED_VALUE>");
					oldxmlString.append("<COMMUTATION_PEN_AMOUNT>"+oldtemp[62]+"</COMMUTATION_PEN_AMOUNT>");
					oldxmlString.append("<ACTUAL_SER_YEAR>"+oldtemp[63]+"</ACTUAL_SER_YEAR>");
					oldxmlString.append("<ACTUAL_SER_MON>"+oldtemp[64]+"</ACTUAL_SER_MON>");
					oldxmlString.append("<ACTUAL_SER_DAYS>"+oldtemp[65]+"</ACTUAL_SER_DAYS>");
					oldxmlString.append("<NET_SER_YEAR>"+oldtemp[66]+"</NET_SER_YEAR>");
					oldxmlString.append("<NET_SER_MON>"+oldtemp[67]+"</NET_SER_MON>");
					oldxmlString.append("<NET_SER_DAYS>"+oldtemp[68]+"</NET_SER_DAYS>");
					oldxmlString.append("<TOT_NON_QUAL_SER_YEAR>"+oldtemp[69]+"</TOT_NON_QUAL_SER_YEAR>");
					oldxmlString.append("<TOT_NON_QUAL_SER_MON>"+oldtemp[70]+"</TOT_NON_QUAL_SER_MON>");
					oldxmlString.append("<TOT_NON_QUAL_SER_DAYS>"+oldtemp[71]+"</TOT_NON_QUAL_SER_DAYS>");
					oldxmlString.append("<SCALE_OF_PAY>"+oldtemp[72]+"</SCALE_OF_PAY>");
					oldxmlString.append("<WEIGHTAGE_YEAR>"+oldtemp[73]+"</WEIGHTAGE_YEAR>");
					oldxmlString.append("<WEIGHTAGE_MONTH>"+oldtemp[74]+"</WEIGHTAGE_MONTH>");
					oldxmlString.append("<WEIGHTAGE_DAYS>"+oldtemp[75]+"</WEIGHTAGE_DAYS>");
					
					
					
					
					if(oldtemp[76]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String famuptoseven=formatter.format(oldtemp[76]);
						oldxmlString.append("<FAM_PEN_UPTO_SEVEN>"+famuptoseven+"</FAM_PEN_UPTO_SEVEN>");
					}
					else
					{
						oldxmlString.append("<FAM_PEN_UPTO_SEVEN>"+oldtemp[76]+"</FAM_PEN_UPTO_SEVEN>");
					}					
					if(oldtemp[77]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String famafterseven=formatter.format(oldtemp[77]);
						oldxmlString.append("<FAM_PEN_AFTER_SEVEN>"+famafterseven+"</FAM_PEN_AFTER_SEVEN>");
					}
					else
					{
						oldxmlString.append("<FAM_PEN_AFTER_SEVEN>"+oldtemp[77]+"</FAM_PEN_AFTER_SEVEN>");
					}
					
					if(oldtemp[78]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dodeath=formatter.format(oldtemp[78]);
						oldxmlString.append("<DEATH_DATE>"+dodeath+"</DEATH_DATE>");
					}
					else
					{
						oldxmlString.append("<DEATH_DATE>"+oldtemp[78]+"</DEATH_DATE>");
					}
					
					oldxmlString.append("<OTHDEPTSERVICE>"+oldtemp[79]+"</OTHDEPTSERVICE>");	
					oldxmlString.append("<LEVEL_OF_PAY>"+oldtemp[80]+"</LEVEL_OF_PAY>");	
					
					oldxmlString.append("</oldrecord>");
					
					oldmyFlag=true;
					
				 }
				if(oldmyFlag) 
		        {
					oldxmlString.append("<oldflag>true</oldflag>");
		        }
		        else 
		        {
		        	oldxmlString.append("<oldflag>false</oldflag>");
		        }
				
				
				oldxmlString.append("</oldresponse>");

			 getResponse().setContentType("text/xml");
			 out.println(oldxmlString.toString());
			 out.flush();
			 out.close();
			 
			}
			
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	
	
	public String loadPenAppForm1OldAEValData()
	{
		
		
		Integer empId=0;
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		//empId=empProfile.getEmployeeId();		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}	
	try
		{
		StringBuffer aexmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		empId=pensionAppCalcValForm1.getEmpNo();
		
		aexmlString.append("<aeresponse>");
		aexmlString.append("<aecommand>Get</aecommand>");
		aexmlString.append("<aeflag>success</aeflag>");
		
		List<PensionApplicationForm1AverageEmolumentsDao> aeli=penappmform1calcValservice.loadForm1OldAeVal(empId);
		
		for(PensionApplicationForm1AverageEmolumentsDao aetmp:aeli)
		{
			aexmlString.append("<aerecord>");
			aexmlString.append("<avgid>"+aetmp.getAvgID()+"</avgid>");
			aexmlString.append("<nc>"+aetmp.getMaxcheck_value()+"</nc>");
			aexmlString.append("<fromdate>"+aetmp.getFromdate2()+"</fromdate>");
			aexmlString.append("<todate>"+aetmp.getTodate2()+"</todate>");
			aexmlString.append("<totmonth>"+aetmp.getTmonth()+"</totmonth>");
			aexmlString.append("<totdays>"+aetmp.getTday()+"</totdays>");
			aexmlString.append("<basic>"+aetmp.getBasic_pay()+"</basic>");
			aexmlString.append("<grade>"+aetmp.getGrade_pay()+"</grade>");
			aexmlString.append("<special>"+aetmp.getSpecial_pay()+"</special>");
			aexmlString.append("<other1>"+aetmp.getOptionpay1()+"</other1>");
			aexmlString.append("<other2>"+aetmp.getOptionpay2()+"</other2>");
			aexmlString.append("<other3>"+aetmp.getOptionpay3()+"</other3>");
			aexmlString.append("<ppamount>"+aetmp.getPpamount()+"</ppamount>");
			aexmlString.append("</aerecord>");
			
		}
		
	
		aexmlString.append("</aeresponse>");
	 getResponse().setContentType("text/xml");
	 out.println(aexmlString.toString());
	 out.flush();
	 out.close();
		
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return null;
	}
	
		
	
	public String loadPenAppForm1OldRecoveryValData()
	{
		
		
		Integer empId=0;
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		//empId=empProfile.getEmployeeId();		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}	
	try
		{
		StringBuffer recxmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		empId=pensionAppCalcValForm1.getEmpNo();
		recxmlString.append("<recresponse>");
		recxmlString.append("<reccommand>Get</reccommand>");
		recxmlString.append("<recflag>success</recflag>");
		
		List<PensionApplicationForm1RecoveriesDao> recli=penappmform1calcValservice.loadForm1OldRecoveriesVal(empId);
		
		for(PensionApplicationForm1RecoveriesDao rectmp:recli)
		{
			recxmlString.append("<recrecord>");
			recxmlString.append("<recid>"+rectmp.getRecID()+"</recid>");
			recxmlString.append("<recdescription>"+rectmp.getRec_description()+"</recdescription>");
			recxmlString.append("<recamount>"+rectmp.getRec_amount()+"</recamount>");
			recxmlString.append("</recrecord>");
			
		}
		
	
		recxmlString.append("</recresponse>");
	 getResponse().setContentType("text/xml");
	 out.println(recxmlString.toString());
	 out.flush();
	 out.close();
		
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return null;
	}
	
	
	
	
	
	
	public String loadPenAppForm1ComValData()
	{
		
		StringBuffer xmlString = new StringBuffer();
		
		xmlString.append("<comresponse>");
		xmlString.append("<comcommand>Get</comcommand>");		
		try
		{
			PrintWriter out = getResponse().getWriter();	
			HttpSession session=getRequest().getSession();
			int age=pensionAppCalcValForm1.getAge();
			
			
			Double commvalue=penappmform1calcValservice.penAppForm1CalcComSettingValData(age);
			
			if(commvalue!=0.000)
			{	
					xmlString.append("<comrecord>");					
					xmlString.append("<commuted_val>"+commvalue+"</commuted_val>");
					xmlString.append("</comrecord>");				
					xmlString.append("<comflag>true</comflag>");   	
		        
			}
				
		    	 xmlString.append("</comresponse>");

			 getResponse().setContentType("text/xml");
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
	
	
	
		
	
	public String loadPenAppForm1OtherDepServiceValData()
	{
		
		Integer empId=0;
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		//empId=empProfile.getEmployeeId();		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		
		try
		{
		StringBuffer othdeptxmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		empId=pensionAppCalcValForm1.getEmpNo();
		
		othdeptxmlString.append("<othdeptserviceresponse>");
		othdeptxmlString.append("<othdeptservicecommand>Get</othdeptservicecommand>");
		othdeptxmlString.append("<othdeptserviceflag>success</othdeptserviceflag>");
		
		List<PensionApplicationForm1OthDeptServiceDao> othdeptserli=penappmform1calcValservice.loadForm1OldOtherDepServiceVal(empId);
		for(PensionApplicationForm1OthDeptServiceDao othdeptsertmp:othdeptserli)
		{
						
			othdeptxmlString.append("<othdeptrecord>");
			othdeptxmlString.append("<fromdate>"+othdeptsertmp.getCompositePK().getFromdate2()+"</fromdate>");
			othdeptxmlString.append("<todate>"+othdeptsertmp.getTodate2()+"</todate>");
			othdeptxmlString.append("<totyear>"+othdeptsertmp.getOthServiceYear()+"</totyear>");
			othdeptxmlString.append("<totmonth>"+othdeptsertmp.getOthServiceMonth()+"</totmonth>");
			othdeptxmlString.append("<totdays>"+othdeptsertmp.getOtherServiceDay()+"</totdays>");
			othdeptxmlString.append("<deptname>"+othdeptsertmp.getDepartmentName()+"</deptname>");
			othdeptxmlString.append("<remark>"+othdeptsertmp.getRemarks()+"</remark>");
			
			othdeptxmlString.append("</othdeptrecord>");
			
		}
		
	
		othdeptxmlString.append("</othdeptserviceresponse>");
	 getResponse().setContentType("text/xml");
	 out.println(othdeptxmlString.toString());
	 out.flush();
	 out.close();
		
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return null;
	}
	
	
	
	
	public String loadPenAppForm1EmpValStatus()
	{
		
		List<Object []> myempstatusList=null;
		StringBuffer xmlString = new StringBuffer();
		
		xmlString.append("<empstatresponse>");
		xmlString.append("<empstatcommand>Get</empstatcommand>");		
		try
		{
			PrintWriter out = getResponse().getWriter();	
			HttpSession session=getRequest().getSession();
			int empId=pensionAppCalcValForm1.getEmpNo();
			
			myempstatusList=penappmform1calcValservice.penAppForm1CalcEmpStatusValData(empId);
			
			String effdate="";
			DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
			if(myempstatusList.size()>0)
			{
				xmlString.append("<empstatrecord>");
			for(Object[] empstatetl: myempstatusList)
			{
				
				Object[] empstatustemp=empstatetl;	
				
				effdate=formatter.format(empstatustemp[0]);	
				xmlString.append("<effectdate>"+effdate+"</effectdate>");				
				xmlString.append("<employeestatus>"+empstatustemp[1]+"</employeestatus>");										
				
			}	
				xmlString.append("</empstatrecord>");
			}	
		    	 xmlString.append("</empstatresponse>");

			 getResponse().setContentType("text/xml");
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
	
	
	

	
	@SuppressWarnings("unchecked")
	public String addPensionAppForm1ValCalculation()
	{
		
		Integer empId=0;
		String returnflag="SUCCESS";
		try
		{
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		empId=empProfile.getEmployeeId();		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		
		try
		{ 		
				
			Integer age=0;
			
			String updatedId=updateservice.getUpdateId(empId);
			
			Date deatdate=pensionAppCalcValForm1.getDeath_date1();			
			
			
			int 	last=pensionAppCalcValForm1.getLastlevel();
			System.out.println("last::"+last);
			String scale=pensionAppCalcValForm1.getScaleOfPay();
			System.out.println("scale::"+scale);
			
			if(deatdate==null)
			{				
			if(basic_pay != null){
				
				Iterator iter = maxcheck_value.iterator();
				Iterator iter1 = fromdate.iterator();
				Iterator iter2 = todate.iterator();
				Iterator iter3 = tmonth.iterator();
				Iterator iter4 = tday.iterator();
				Iterator iter5 = basic_pay.iterator();
				Iterator iter6 = grade_pay.iterator();
				Iterator iter7 = special_pay.iterator();
				Iterator iter8 = optionpay1.iterator();
				Iterator iter9 = optionpay2.iterator();
				Iterator iter10 = optionpay3.iterator();
				Iterator iter11 = ppamount.iterator();
				penappmform1calcValservice.deleteForm1AvgemolumentsVal(pensionAppCalcValForm1.getEmpNo());
				PensionApplicationForm1AverageEmolumentsValDao form1aemultidata=null;
				valform1aemultidatlist = new ArrayList<PensionApplicationForm1AverageEmolumentsValDao>();
			    
			    for(int i=0; i<basic_pay.size(); i++)
			    {
			    	form1aemultidata = new PensionApplicationForm1AverageEmolumentsValDao();	    	
			    	
			    	form1aemultidata.setMaxcheck_value(maxcheck_value.get(i));
			    	form1aemultidata.setFromdate(fromdate.get(i));
			    	form1aemultidata.setTodate(todate.get(i));
			    	form1aemultidata.setTmonth(tmonth.get(i));
			    	form1aemultidata.setTday(tday.get(i));
		    		
			    	form1aemultidata.setBasic_pay(basic_pay.get(i));
			    	//form1aemultidata.setGrade_pay(grade_pay.get(i));
			    	form1aemultidata.setSpecial_pay(special_pay.get(i));
			    	form1aemultidata.setOptionpay1(optionpay1.get(i));
			    	form1aemultidata.setOptionpay2(optionpay2.get(i));
			    	form1aemultidata.setOptionpay3(optionpay3.get(i));
			    	form1aemultidata.setPpamount(ppamount.get(i));
			    	form1aemultidata.setEmpNo(pensionAppCalcValForm1.getEmpNo());
			    	form1aemultidata.setProcessStatus("VALIDATE");
			    	form1aemultidata.setUpdatedUser(updatedId);
			    	form1aemultidata.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	form1aemultidata.setUnlockedBy(updatedId);
			    	form1aemultidata.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	valform1aemultidatlist.add(form1aemultidata);
			    }
			    			   
			    penappmform1calcValservice.saveAddAverageEmolumentsVal(valform1aemultidatlist);
			}
			
			}
			
			
			
			PensionApplicationForm1OthDeptServiceValDao form1otherdeptservicedata=null;
		    valform1Otherservicelist=new ArrayList<PensionApplicationForm1OthDeptServiceValDao>();
		    penappmform1calcValservice.deleteForm1OtherdeptserviceVal(pensionAppCalcValForm1.getEmpNo());
					
		    if(pensionAppCalcValForm1.getOtherdeparmentserviceFlag().equals("Yes"))
					{
						
						PensionApplicationForm1OthDeptServiceValPK compositePk = null;
						
						for(int i=0;i<othdeptfromdate.length;i++)
						{
							form1otherdeptservicedata=new PensionApplicationForm1OthDeptServiceValDao();
							compositePk = new PensionApplicationForm1OthDeptServiceValPK();
						    compositePk.setEmpNo(pensionAppCalcValForm1.getEmpNo());
							compositePk.setFromdate(othdeptfromdate[i]);
							form1otherdeptservicedata.setCompositePK(compositePk);
							form1otherdeptservicedata.setTodate(othdepttodate[i]);
							form1otherdeptservicedata.setOthServiceYear(otdepyear[i]);
							form1otherdeptservicedata.setOthServiceMonth(otdepmonth[i]);
							form1otherdeptservicedata.setOtherServiceDay(othdeptday[i]);
							form1otherdeptservicedata.setDepartmentName(Departmentname[i]);
							form1otherdeptservicedata.setRemarks(Remarks[i]);
							form1otherdeptservicedata.setUpdatedUser(updatedId);
							form1otherdeptservicedata.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
							form1otherdeptservicedata.setUnlockedBy(updatedId);
							form1otherdeptservicedata.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
							
							valform1Otherservicelist.add(form1otherdeptservicedata);
							
							//System.out.println("The length size"+othdeptfromdate[i]);
						}
						
						penappmform1calcValservice.saveAddOtherDepartmentServiceVal(valform1Otherservicelist);
						pensionAppCalcValForm1.getTototdepyear();
						pensionAppCalcValForm1.getTototdepmonth();
						pensionAppCalcValForm1.getTotothdeptday();
						
					}
			
			
			
			
			
				if(rec_amount != null){	
					Iterator reciter1 = rec_description.iterator();
					Iterator reciter2 = rec_amount.iterator();
					
					PensionApplicationForm1RecoveriesValDao form1recmultidata=null;
					valform1recmultidatlist = new ArrayList<PensionApplicationForm1RecoveriesValDao>();
					penappmform1calcValservice.deleteForm1RecoveriesVal(pensionAppCalcValForm1.getEmpNo());
				    for(int j=0; j<rec_amount.size(); j++)
				    {
				    	if((rec_description.get(j)).equals("null") || (rec_description.get(j)).equals(""))
				    	{
				    	
				    	}
				    	else
				    	{
				    		form1recmultidata = new PensionApplicationForm1RecoveriesValDao();			    				    	
				    		form1recmultidata.setRec_description(rec_description.get(j));	    		
				    		form1recmultidata.setRec_amount(rec_amount.get(j));
				    		form1recmultidata.setEmpNo(pensionAppCalcValForm1.getEmpNo());				    		
				    		form1recmultidata.setProcessStatus("VALIDATE");
				    		form1recmultidata.setUpdatedUser(updatedId);
				    		form1recmultidata.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
				    		form1recmultidata.setUnlockedBy(updatedId);
				    		form1recmultidata.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
					    	valform1recmultidatlist.add(form1recmultidata);
				    	}
				    	
				    }
			    
				   
				    penappmform1calcValservice.saveForm1RecoveriesVal(valform1recmultidatlist);
			}
			
			
			
					
				age=pensionAppCalcValForm1.getAge();
				
				Integer commutedamount=pensionAppCalcValForm1.getCommutedamount();
				float commfloatval=Float.parseFloat(penappmform1calcValservice.penAppForm1CalcComSettingValData(age)+"");					
				pensionAppCalcValForm1.setCommuted_val(commfloatval);
				
				//float commutedpensionamount=(commutedamount)*12*(commfloatval);
				//Integer commutedpenamount=(int)Math.round(commutedpensionamount);
				Double commdoubleval=Double.parseDouble(Float.toString(commfloatval));
				
				System.out.println("commutedamount::"+commutedamount+" "+" commdoubleval::"+commdoubleval);
				
				Integer commutedpenamount=(int)Math.round((commutedamount)*12*(commdoubleval));
				
				pensionAppCalcValForm1.setTotcommutedamount(commutedpenamount);
				
				
				
				
				
				

				
				
				/*Date vrsdate=pensionAppCalcValForm1.getVrs_date1();
				Date retiredate=pensionAppCalcValForm1.getDar1();
				String dor="";
				if(vrsdate!=null)
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(vrsdate);
				}
				else
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(retiredate);
				}*/
				
				Date vrsdate=pensionAppCalcValForm1.getVrs_date1();
				Date retiredate=pensionAppCalcValForm1.getDar1();
				Date dedate=pensionAppCalcValForm1.getDeath_date1();
				String dor="";
				if(vrsdate!=null)
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(vrsdate);
				}
				else if(dedate!=null)
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(dedate);
				}
				else
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(retiredate);
				}
				
				
				
				
				
				int dapercentage=penappmform1calcValservice.penAppForm1CalcdaSettingValData(dor);
				
				
				pensionAppCalcValForm1.setDa_percentage(dapercentage);
				
				
				
				
				
				  
				  String basic_include=pensionAppCalcValForm1.getAvg_include_basic();
				  String basic_da=pensionAppCalcValForm1.getAvg_da_basic();
				  			  
				  String grade_include=pensionAppCalcValForm1.getAvg_include_grade();
				  String grade_da=pensionAppCalcValForm1.getAvg_da_grade();
				 			  
				  String special_include=pensionAppCalcValForm1.getAvg_include_special();
				  String special_da=pensionAppCalcValForm1.getAvg_da_special();
				  
				  String other1_include=pensionAppCalcValForm1.getAvg_include_other1();
				  String other1_da=pensionAppCalcValForm1.getAvg_da_other1();
				  
				  String other2_include=pensionAppCalcValForm1.getAvg_include_other2();
				  String other2_da=pensionAppCalcValForm1.getAvg_da_other2();
				  
				  String other3_include=pensionAppCalcValForm1.getAvg_include_other3();
				  String other3_da=pensionAppCalcValForm1.getAvg_da_other3();
				  			  
				  Integer lasttotal=0;
				  Integer lastbasic=0;
				  Integer lastgrade=0;
				  Integer lastspecial=0;
				  Integer lastother1=0;
				  Integer lastother2=0;
				  Integer lastother3=0;
				  Integer maxdcrgamount=0;
				  Integer dcrghalfyear=0;
				  Integer lasttotalforda=0;
				  Integer finaltotalppamount=0;
				  float damount;
				  float dcrgpensionamuont;
				  float maxdcrgamountcheck;
				  
				  finaltotalppamount=pensionAppCalcValForm1.getFinaltotppamount();
				  if(pensionAppCalcValForm1.getLastbasic()==null)
				  {
					  lastbasic=0;
				  }
				  else
				  {
				  lastbasic=pensionAppCalcValForm1.getLastbasic();
				  }
				  if(pensionAppCalcValForm1.getLastgrade()==null)
				  {
					  lastgrade=0;
				  }
				  else
				  {
					  lastgrade=pensionAppCalcValForm1.getLastgrade();
				  }
				  if(pensionAppCalcValForm1.getLastspecial()==null)
				  {
					  lastspecial=0;
				  }
				  else
				  {
					  lastspecial=pensionAppCalcValForm1.getLastspecial();
				  }
				  if(pensionAppCalcValForm1.getLastother1()==null)
				  {
					  lastother1=0;
				  }
				  else
				  {
					  lastother1=pensionAppCalcValForm1.getLastother1();
				  }
				  if(pensionAppCalcValForm1.getLastother2()==null)
				  {
					  lastother2=0;
				  }
				  else
				  {
					  lastother2=pensionAppCalcValForm1.getLastother2();
				  }
				  if(pensionAppCalcValForm1.getLastother3()==null)
				  {
					  lastother3=0;
				  }
				  else
				  {
					  lastother3=pensionAppCalcValForm1.getLastother3();
				  }
				  
				 // lasttotal=lastbasic+lastgrade+lastspecial+lastother1+lastother2+lastother3;
				  lasttotal=lastbasic+lastspecial+lastother1+lastother2+lastother3;
				  
				  
				
				  maxdcrgamount=pensionAppCalcValForm1.getMax_dcrg_amt();
				  dcrghalfyear=pensionAppCalcValForm1.getNohalfyeardcrg();
				
				
				  
				
				  if((basic_include.equalsIgnoreCase("Y"))&&(basic_da.equalsIgnoreCase("Y")))
				  {
					  lasttotalforda=lasttotalforda+lastbasic;					  
				  }
				 /* if((grade_include.equalsIgnoreCase("Y"))&&(grade_da.equalsIgnoreCase("Y")))
				  {
					  lasttotalforda=lasttotalforda+lastgrade;					 
				  }*/
				  if((special_include.equalsIgnoreCase("Y"))&&(special_da.equalsIgnoreCase("Y")))
				  {
					  lasttotalforda=lasttotalforda+lastspecial;					  
				  }
				  if((other1_include.equalsIgnoreCase("Y"))&&(other1_da.equalsIgnoreCase("Y")))
				  {
					  lasttotalforda=lasttotalforda+lastother1;					  
				  }
				  if((other2_include.equalsIgnoreCase("Y"))&&(other2_da.equalsIgnoreCase("Y")))
				  {
					  lasttotalforda=lasttotalforda+lastother2;					  
				  }
				  if((other3_include.equalsIgnoreCase("Y"))&&(other3_da.equalsIgnoreCase("Y")))
				  {
					  lasttotalforda=lasttotalforda+lastother3;					  
				  }
				  				  
				  damount=(Float.parseFloat((lasttotalforda)+"")*((Float.parseFloat((dapercentage)+"")/100)));	
				
				  dcrgpensionamuont=Float.parseFloat((Math.round((lasttotal+damount))*(0.25)*(dcrghalfyear))+"");
				  
				  
				  
				  
				  
				  
				  if(!(pensionAppCalcValForm1.getDeath_date1()+"").equalsIgnoreCase("null"))
				  {
						Integer nqs_year=0;
						Integer multvar_dcrg=1;
						float lpd=lasttotal;
						if(!(pensionAppCalcValForm1.getNqs_year()+"").equalsIgnoreCase("null"))
						{
							  nqs_year=pensionAppCalcValForm1.getNqs_year();
						}
						if(nqs_year<1)
						{
							multvar_dcrg=2;
							dcrgpensionamuont=((lpd)+(damount))*2;
							dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*2)+"");
						}
						if((nqs_year>=1) && (nqs_year<5))
						{
							multvar_dcrg=6;
							dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*6)+"");
						}
						if((nqs_year>=5) && (nqs_year<20))
						{
							multvar_dcrg=12;
							dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*12)+"");
						}
						if(nqs_year>=20)
						{							
							dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*(0.5)*(dcrghalfyear))+"");							
						}				  
				  }
				  
				  
				  
				  
				  
				  maxdcrgamountcheck=Float.parseFloat(maxdcrgamount+"");
				  
				  if((dcrgpensionamuont>=maxdcrgamountcheck))
				  {
					  dcrgpensionamuont=maxdcrgamountcheck;
				  }
				
				  
				 					
					pensionAppCalcValForm1.setDamount((int)Math.round(damount));				
					pensionAppCalcValForm1.setDcrgamount((int)Math.round(dcrgpensionamuont));
				
				
				
				
					pensionAppCalcValForm1.setLevel_of_pay(last);
					pensionAppCalcValForm1.setProcessStatus("VALIDATE");
					pensionAppCalcValForm1.setUpdatedUser(updatedId);
					pensionAppCalcValForm1.setUpdateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
					pensionAppCalcValForm1.setUnlockedBy(updatedId);
					pensionAppCalcValForm1.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
				
			
					Integer empidd=pensionAppCalcValForm1.getEmpNo();
					
				penappmform1calcValservice.savePensionAppForm1ValCalculation(pensionAppCalcValForm1);	
				
				
				penappmform1calcValservice.deleteForm1Avgemoluments(empidd);
				penappmform1calcValservice.deleteForm1Details(empidd);
				penappmform1calcValservice.deleteForm1Recoveries(empidd);
				penappmform1calcValservice.deleteForm1othdeptservice(empidd);
		
				reportEmpId=pensionAppCalcValForm1.getEmpNo();
				Date deathdate=pensionAppCalcValForm1.getDeath_date1();
				Date vdate=pensionAppCalcValForm1.getVrs_date1();
				Date retdate=pensionAppCalcValForm1.getDar1();
				
				
				
				if(!(retdate+"").equalsIgnoreCase("null"))
				{
					typeofPension="Super annuation";
				}
				if(!(vdate+"").equalsIgnoreCase("null"))
				{
					typeofPension="VRS";
				}
				if(!(deathdate+"").equalsIgnoreCase("null"))
				{
					typeofPension="death";
					returnflag="DEATH";
				}				
				
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		return returnflag;
	}

	
	public PensionApplicationCalcSearchModel getPenAppCalcComm() {
		return penAppCalcComm;
	}
	public void setPenAppCalcComm(PensionApplicationCalcSearchModel penAppCalcComm) {
		this.penAppCalcComm = penAppCalcComm;
	}	
	public PensionApplicationForm1CalcMstValDataService getPenappmform1calcValservice() {
		return penappmform1calcValservice;
	}
	public void setPenappmform1calcValservice(
			PensionApplicationForm1CalcMstValDataService penappmform1calcValservice) {
		this.penappmform1calcValservice = penappmform1calcValservice;
	}
	public PensionApplicationForm1ValDao getPensionAppCalcValForm1() {
		return pensionAppCalcValForm1;
	}
	public void setPensionAppCalcValForm1(
			PensionApplicationForm1ValDao pensionAppCalcValForm1) {
		this.pensionAppCalcValForm1 = pensionAppCalcValForm1;
	}

	public List<PensionApplicationForm1AverageEmolumentsValDao> getValform1aemultidatlist() {
		return valform1aemultidatlist;
	}
	public void setValform1aemultidatlist(
			List<PensionApplicationForm1AverageEmolumentsValDao> valform1aemultidatlist) {
		this.valform1aemultidatlist = valform1aemultidatlist;
	}
	public List<PensionApplicationForm1RecoveriesValDao> getValform1recmultidatlist() {
		return valform1recmultidatlist;
	}
	public void setValform1recmultidatlist(
			List<PensionApplicationForm1RecoveriesValDao> valform1recmultidatlist) {
		this.valform1recmultidatlist = valform1recmultidatlist;
	}

	public List<String> getMaxcheck_value() {
		return maxcheck_value;
	}

	public void setMaxcheck_value(List<String> maxcheck_value) {
		this.maxcheck_value = maxcheck_value;
	}

	public List<String> getFromdate() {
		return fromdate;
	}

	public void setFromdate(List<String> fromdate) {
		this.fromdate = fromdate;
	}

	public List<String> getTodate() {
		return todate;
	}

	public void setTodate(List<String> todate) {
		this.todate = todate;
	}

	public List<Integer> getTmonth() {
		return tmonth;
	}

	public void setTmonth(List<Integer> tmonth) {
		this.tmonth = tmonth;
	}

	public List<Integer> getTday() {
		return tday;
	}

	public void setTday(List<Integer> tday) {
		this.tday = tday;
	}

	public List<Integer> getBasic_pay() {
		return basic_pay;
	}

	public void setBasic_pay(List<Integer> basic_pay) {
		this.basic_pay = basic_pay;
	}

	public List<Integer> getGrade_pay() {
		return grade_pay;
	}

	public void setGrade_pay(List<Integer> grade_pay) {
		this.grade_pay = grade_pay;
	}

	public List<Integer> getSpecial_pay() {
		return special_pay;
	}

	public void setSpecial_pay(List<Integer> special_pay) {
		this.special_pay = special_pay;
	}

	public List<Integer> getOptionpay1() {
		return optionpay1;
	}

	public void setOptionpay1(List<Integer> optionpay1) {
		this.optionpay1 = optionpay1;
	}

	public List<Integer> getOptionpay2() {
		return optionpay2;
	}

	public void setOptionpay2(List<Integer> optionpay2) {
		this.optionpay2 = optionpay2;
	}

	public List<Integer> getOptionpay3() {
		return optionpay3;
	}

	public void setOptionpay3(List<Integer> optionpay3) {
		this.optionpay3 = optionpay3;
	}	

	
	public List<Float> getPpamount() {
		return ppamount;
	}

	public void setPpamount(List<Float> ppamount) {
		this.ppamount = ppamount;
	}	
	

	public List<String> getRec_description() {
		return rec_description;
	}

	public void setRec_description(List<String> rec_description) {
		this.rec_description = rec_description;
	}

	public List<Integer> getRec_amount() {
		return rec_amount;
	}

	public void setRec_amount(List<Integer> rec_amount) {
		this.rec_amount = rec_amount;
	}	

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setReportEmpId(Integer reportEmpId) {
		this.reportEmpId = reportEmpId;
	}

	public Integer getReportEmpId() {
		return reportEmpId;
	}

	public String getTypeofPension() {
		return typeofPension;
	}

	public void setTypeofPension(String typeofPension) {
		this.typeofPension = typeofPension;
	}

	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}

	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}


	public PensionApplicationForm1OthDeptServicePK getPensionapplform1pk() {
		return pensionapplform1pk;
	}


	public void setPensionapplform1pk(
			PensionApplicationForm1OthDeptServicePK pensionapplform1pk) {
		this.pensionapplform1pk = pensionapplform1pk;
	}
  public String[] getOthdeptfromdate() {
		return othdeptfromdate;
	}
  public void setOthdeptfromdate(String[] othdeptfromdate) {
		this.othdeptfromdate = othdeptfromdate;
	}
	public String[] getOthdepttodate() {
		return othdepttodate;
	}
	public void setOthdepttodate(String[] othdepttodate) {
		this.othdepttodate = othdepttodate;
	}
	public Integer[] getOtdepyear() {
		return otdepyear;
	}

  public void setOtdepyear(Integer[] otdepyear) {
		this.otdepyear = otdepyear;
	}
	public Integer[] getOtdepmonth() {
		return otdepmonth;
	}
	public void setOtdepmonth(Integer[] otdepmonth) {
		this.otdepmonth = otdepmonth;
	}
	public Integer[] getOthdeptday() {
		return othdeptday;
	}
	public void setOthdeptday(Integer[] othdeptday) {
		this.othdeptday = othdeptday;
	}
	public String[] getDepartmentname() {
		return Departmentname;
	}
	public void setDepartmentname(String[] departmentname) {
		Departmentname = departmentname;
	}
	public String[] getRemarks() {
		return Remarks;
	}
	public void setRemarks(String[] remarks) {
		Remarks = remarks;
	}
	public List<PensionApplicationForm1OthDeptServiceValDao> getValform1Otherservicelist() {
		return valform1Otherservicelist;
	}
	public void setValform1Otherservicelist(
			List<PensionApplicationForm1OthDeptServiceValDao> valform1Otherservicelist) {
		this.valform1Otherservicelist = valform1Otherservicelist;
	}
	
	
}
