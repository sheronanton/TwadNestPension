package com.nic.hrms.pension.reports.dao.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeForm2ReportDao;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNomineeForm2;
import com.nic.hrms.pension.reports.model.PensionApplicationFieldOfficeNotVerServForm2;
import com.nic.hrms.pension.reports.service.PensionApplicationHeadOfficeForm2ReportService;

public class PensionApplicationHeadOfficeForm2ReportDaoImpl implements PensionApplicationHeadOfficeForm2ReportService {

	private SessionFactory sessionFactory;

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<PensionApplicationFieldOfficeForm2ReportDao> printHeadOfficeDetails(HttpServletRequest request, int empId, int officeId) {
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);		
		List<Object[]> printDetails=null;	
		List<PensionApplicationFieldOfficeForm2ReportDao> printRetDetails=new ArrayList<PensionApplicationFieldOfficeForm2ReportDao>();
		try
		{
			String s= request.getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeForm2.jrxml");
			String s1=request.getRealPath("/org/HR/hr/pension/reports/PensionApplicationFieldOfficeForm2.jasper");
			
			JasperCompileManager.compileReportToFile(s,s1);
			  
			
			String myQry="select det.EMP_NO,det.EMP_NAME,det.GENDER,det.DESIG_SERVICE_GRP,det.DESIG_ID,GRADE,det.OFFICE_ID,det.GPF_NO,det.FATHER_NAME," +
				" det.HUSBAND_NAME,rel.RELIGION_NAME,det.NATIONALITY,det.EMP_HEIGHT,det.ID_MARK1,det.ID_MARK2,det.PRESENT_ADDRESS,det.PERMANENT_ADDRESS,det.ADDRESS_AFTER_RETIRE," +
				" det.STATE,det.CHARGES_FLAG,det.CHARGES_DETAILS,det.PAYMENT_OFFICE_ID,det.APPLICATION_DATE,det.DCRG_NOMINEE_NAME,det.DCRG_NOMINEE_DOB," +
				" det.DCRG_NOMINEE_RELATION,det.DCRG_NOMINEE_ADDRESS,det.NOT_VERIFY_SERVICE_TOT_YEARS,det.NOT_VERIFY_SERVICE_TOT_MONTHS," +
				" det.NOT_VERIFY_SERVICE_TOT_DAYS,off.OFFICE_NAME,design.DESIGNATION,sta.STATE_NAME from HRM_PEN_APP_HO_MST_FORM2_DET det left outer join COM_MST_OFFICES off " +
				" on off.OFFICE_ID=det.OFFICE_ID left outer join HRM_MST_DESIGNATIONS design "+
				" on design.DESIGNATION_ID=det.DESIG_ID " +
				"left outer join COM_MST_STATE sta on det.STATE=sta.STATE_CODE  " +
				"left outer join HRM_MST_RELIGIONS rel ON rel.RELIGION_CODE = det.religion" +
				"where det.EMP_NO::varchar="+empId;
			
			
			printDetails=session.createSQLQuery(myQry).list();
			
			
			
			
			for(Object[] tmp:printDetails)
			{
				PensionApplicationFieldOfficeForm2ReportDao penapp=new PensionApplicationFieldOfficeForm2ReportDao();								
				penapp.setEMP_NO((BigDecimal)tmp[0]);
				penapp.setEMP_NAME(tmp[1]+"");
				penapp.setGENDER(tmp[2]+"");				
				penapp.setDESIG_SERVICE_GRP((BigDecimal)tmp[3]);
				penapp.setDESIG_ID((BigDecimal)tmp[4]);
				if(!(tmp[5]+"").equalsIgnoreCase("null"))
				{
				penapp.setGRADE(tmp[5]+"");	
				}
				penapp.setOFFICE_ID((BigDecimal)tmp[6]);
				penapp.setGPF_NO((BigDecimal)tmp[7]);
				if(!(tmp[8]+"").equalsIgnoreCase("null"))
				{
				penapp.setFATHER_NAME(tmp[8]+"");
				}
				if(!(tmp[9]+"").equalsIgnoreCase("null"))
				{
				penapp.setHUSBAND_NAME(tmp[9]+"");
				}
				if(!(tmp[10]+"").equalsIgnoreCase("null"))
				{
				penapp.setRELIGION(tmp[10]+"");
				}
				if(!(tmp[11]+"").equalsIgnoreCase("null"))
				{
				penapp.setNATIONALITY(tmp[11]+"");
				}
				if(!(tmp[12]+"").equalsIgnoreCase("null"))
				{
				penapp.setEMP_HEIGHT(tmp[12]+"");
				}
				if(!(tmp[13]+"").equalsIgnoreCase("null"))
				{
				penapp.setID_MARK1(tmp[13]+"");
				}
				if(!(tmp[14]+"").equalsIgnoreCase("null"))
				{
				penapp.setID_MARK2(tmp[14]+"");
				}
				if(!(tmp[15]+"").equalsIgnoreCase("null"))
				{
				penapp.setPRESENT_ADDRESS(tmp[15]+"");
				}
				if(!(tmp[16]+"").equalsIgnoreCase("null"))
				{
				penapp.setPERMANENT_ADDRESS(tmp[16]+"");
				}
				if(!(tmp[17]+"").equalsIgnoreCase("null"))
				{
				penapp.setADDRESS_AFTER_RETIRE(tmp[17]+"");	
				}
				penapp.setSTATE((BigDecimal)tmp[18]);				
				//penapp.setCHARGES_FLAG(tmp[19]+"");
				if(!(tmp[19]+"").equalsIgnoreCase("null"))
				{
					if(!(tmp[20]+"").equalsIgnoreCase("null"))
					{
						penapp.setCHARGES_DETAILS(tmp[20]+"");
					}
					else
					{
						penapp.setCHARGES_DETAILS("");
					}
					penapp.setCHARGES_FLAG(tmp[19]+"");
				}
				else
				{
					penapp.setCHARGES_DETAILS("");
				}
				penapp.setPAYMENT_OFFICE_ID((BigDecimal)tmp[21]);
				penapp.setAPPLICATION_DATE((Date)tmp[22]);
				
				if(!(tmp[23]+"").equalsIgnoreCase("null"))
				{
				penapp.setDCRG_NOMINEE_NAME(tmp[23]+"");
				}
				if(!(tmp[25]+"").equalsIgnoreCase("null"))
				{
				penapp.setDCRG_NOMINEE_RELATION(tmp[25]+"");
				}
				penapp.setDCRG_NOMINEE_DOB((Date)tmp[24]);
				
				if(!(tmp[26]+"").equalsIgnoreCase("null"))
				{
				penapp.setDCRG_NOMINEE_ADDRESS(tmp[26]+"");
				}
				penapp.setNOT_VERIFY_SERVICE_TOT_YEARS((BigDecimal)tmp[27]);
				penapp.setNOT_VERIFY_SERVICE_TOT_MONTHS((BigDecimal)tmp[28]);
				penapp.setNOT_VERIFY_SERVICE_TOT_DAYS((BigDecimal)tmp[29]);
				if(!(tmp[31]+"").equalsIgnoreCase("null"))
				{
				penapp.setDESIGNATION(tmp[31]+"");
				}
				if(!(tmp[30]+"").equalsIgnoreCase("null"))
				{
				penapp.setOFFICE_NAME(tmp[30]+"");
				}
				if(!(tmp[30]+"").equalsIgnoreCase("null"))
				{
				penapp.setPAY_OFFICE_NAME(tmp[30]+"");
				}
				if(!(tmp[32]+"").equalsIgnoreCase("null"))
				{
				penapp.setSTATE_NAME(tmp[32]+"");
				}
				printRetDetails.add(penapp);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return printRetDetails;
		
	}

	
	@SuppressWarnings({ "unchecked" })
	public List<PensionApplicationFieldOfficeNomineeForm2> printHeadOfficeNominee(HttpServletRequest request, int empIdList) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<Object[]> nominList=null;
		List<PensionApplicationFieldOfficeNomineeForm2> printNomin=new ArrayList<PensionApplicationFieldOfficeNomineeForm2>();
		try
		{
						
			String qry="SELECT emp_no,  nominee_id,  nominee_initial,  nominee_name,  relationship_id,  dob,"
						+ "age,  handicapped,  marital_status,  nomination_date,  active_status,  reason FROM HRM_PEN_APP_HO_MST_FORM2_NOMIN where emp_no="+empIdList;
			Query myQry1=session.createSQLQuery(qry);
			nominList=myQry1.list();
			
			for(Object[] obj:nominList)
			{
				PensionApplicationFieldOfficeNomineeForm2 nomObj=new PensionApplicationFieldOfficeNomineeForm2();
				nomObj.setEMP_NO((BigDecimal)obj[0]);
				nomObj.setNOMINEE_ID((BigDecimal)obj[1]);
				
				if(obj[2]!=null)
				{
					if(obj[3]!=null)
					{
						nomObj.setNOMINEE_NAME(obj[2]+"."+obj[3]);
					}					
					
				}
				else
				{
					nomObj.setNOMINEE_NAME(obj[3]+"");
				}	
				
				if(Integer.parseInt(obj[4]+"")==1)
				{
					nomObj.setRELATIONSHIP_ID("Father");
				}
				else if(Integer.parseInt(obj[4]+"")==2)
				{
					nomObj.setRELATIONSHIP_ID("Mother");
				}
				else if(Integer.parseInt(obj[4]+"")==3)
				{
					nomObj.setRELATIONSHIP_ID("Spouse");
				}	
				/*else if(Integer.parseInt(obj[4]+"")==4)
				{
					nomObj.setRELATIONSHIP_ID("Son");
				}	
				else
				{
					nomObj.setRELATIONSHIP_ID("Daughter");
				}*/
				else if(Integer.parseInt(obj[4]+"")==5)
				{
					nomObj.setRELATIONSHIP_ID("Son");
				}	
				else
				{
					nomObj.setRELATIONSHIP_ID("Daughter");
				}
				
				nomObj.setDOB((Date)obj[5]);
				nomObj.setAGE((BigDecimal)obj[6]);
				
				if(obj[7]!="" && obj[7].equals("Y"))					
					nomObj.setHANDICAPPED("Yes");
				else
					nomObj.setHANDICAPPED("No");
				if(!(obj[8]+"").equalsIgnoreCase("null"))
				{
				nomObj.setMARITAL_STATUS(obj[8]+"");
				}
				if(!(obj[9]+"").equalsIgnoreCase("null"))
				{
				nomObj.setNOMINATION_DATE((Date)obj[9]);
				}
				if(!(obj[10]+"").equalsIgnoreCase("null"))
				{
				nomObj.setACTIVE_STATUS(obj[10]+"");
				}
				if(!(obj[11]+"").equalsIgnoreCase("null"))
				{
				nomObj.setREASON(obj[11]+"");
				}
				printNomin.add(nomObj);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return printNomin;
	}

	
	@SuppressWarnings({ "unchecked" })
	public List<PensionApplicationFieldOfficeNotVerServForm2> printHeadOfficeNVServ(HttpServletRequest request, int empIdList) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<Object[]> serviceList=null;
		List<PensionApplicationFieldOfficeNotVerServForm2> printService=new ArrayList<PensionApplicationFieldOfficeNotVerServForm2>();
		try
		{
			
			String qry2="SELECT  nvco.id,nvco.emp_no, nvco.start_date,  nvco.end_date,  nvco.reason,  nvco.not_verify_years,  nvco.not_verify_months,  nvco.not_verify_days, "
				+ " det.NOT_VERIFY_SERVICE_TOT_YEARS,det.NOT_VERIFY_SERVICE_TOT_MONTHS,det.NOT_VERIFY_SERVICE_TOT_DAYS " 
				+ " FROM HRM_PEN_APP_HO_MST_FORM2_SERV nvco left outer join HRM_PEN_APP_HO_MST_FORM2_DET det on det.EMP_NO =nvco.emp_no"
				+ " where nvco.emp_no="+empIdList;
				
		
			Query myQry2=session.createSQLQuery(qry2);
			serviceList=myQry2.list();

			
			for(Object[] obj1:serviceList)
			{
				
				PensionApplicationFieldOfficeNotVerServForm2 serObj=new PensionApplicationFieldOfficeNotVerServForm2();
				serObj.setID((BigDecimal)obj1[0]);
				serObj.setEMP_NO((BigDecimal)obj1[1]);
				serObj.setSTART_DATE((Date)obj1[2]);
				serObj.setEND_DATE((Date)obj1[3]);
				if(!(obj1[4]+"").equalsIgnoreCase("null"))
				{
				serObj.setREASON(obj1[4]+"");
				}
				serObj.setNOT_VERIFY_YEARS((BigDecimal)obj1[5]);
				serObj.setNOT_VERIFY_MONTHS((BigDecimal)obj1[6]);
				serObj.setNOT_VERIFY_DAYS((BigDecimal)obj1[7]);		
				serObj.setNOT_VERIFY_SERVICE_TOT_YEARS((BigDecimal)obj1[8]);
				serObj.setNOT_VERIFY_SERVICE_TOT_MONTHS((BigDecimal)obj1[9]);
				serObj.setNOT_VERIFY_SERVICE_TOT_DAYS((BigDecimal)obj1[10]);
				printService.add(serObj);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return printService;
	}

	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	
}
