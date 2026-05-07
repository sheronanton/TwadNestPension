package com.nic.hrms.pension.reports.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.reports.model.penAppFieldOfficeDetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG1DetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG2DetailsDao;
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDCRG3DetailsDao;
import com.nic.hrms.pension.reports.model.pensionCalcDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.service.reportPenAppFieldOfficeService;

public class reportPenAppFieldOfficeDaoImpl implements reportPenAppFieldOfficeService{

	private SessionFactory sessionFactory;

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 
				String pensiontype="";
				String classofpensionstring="";
				String comopted="";
				/*String sqlQry="select mstform2.EMP_NO," +
						"mstform2.EMP_NAME," +
						"mstform2.FATHER_NAME," +
						"mstform2.HUSBAND_NAME," +
						"mstform2.EMP_HEIGHT," +
						"mstform2.ID_MARK1," +
						"mstform2.ID_MARK2," +
						"mstform2.PRESENT_ADDRESS," +
						"mstform2.PERMANENT_ADDRESS," +
						"mstform2.ADDRESS_AFTER_RETIRE," +
						"sta.STATE_NAME," +
						"mstform1.PENSION_TYPE," +
						"mstform1.DATE_OF_BIRTH," +
						"mstform1.DATE_OF_RETIRE," +
						"mstform1.DATE_OF_VRS," +
						"mstform1.COMM_OPTED," +
						"mstform1.COMM_FACTOR_ONRTHIRD," +
						"mstform1.COM_FACTOR_PERT," +
						"mstform1.PENSION_AMOUNT," +
						"mstform1.TOTAL_COMMUTED_AMOUNT," +
						"mstform1.COMMUTATION_PEN_AMOUNT," +
						"mstform1.DEATH_DATE," +
						"desi.DESIGNATION, " +
						"offi.OFFICE_NAME " +
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
						"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
						"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
						"left outer join COM_MST_OFFICES offi on offi.office_id=mstform2.PAYMENT_OFFICE_ID " +
						"where mstform1.EMP_ID="+empId;	*/	
				
				
				/*String sqlQry="select mstform2.EMP_NO," +
				"mstform1.EMP_NAME," +
				"mstform2.FATHER_NAME," +
				"mstform2.HUSBAND_NAME," +
				"mstform2.EMP_HEIGHT," +
				"mstform2.ID_MARK1," +
				"mstform2.ID_MARK2," +
				"mstform2.PRESENT_ADDRESS," +
				"mstform2.PERMANENT_ADDRESS," +
				"mstform2.ADDRESS_AFTER_RETIRE," +
				"sta.STATE_NAME," +
				"mstform1.PENSION_TYPE," +
				"mstform1.DATE_OF_BIRTH," +
				"mstform1.DATE_OF_RETIRE," +
				"mstform1.DATE_OF_VRS," +
				"mstform1.COMM_OPTED," +
				"mstform1.COMM_FACTOR_ONRTHIRD," +
				"mstform1.COM_FACTOR_PERT," +
				"mstform1.PENSION_AMOUNT," +
				"mstform1.TOTAL_COMMUTED_AMOUNT," +
				"mstform1.COMMUTATION_PEN_AMOUNT," +
				"mstform1.DEATH_DATE," +
				"desi.DESIGNATION, " +
				"offi.OFFICE_NAME " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
				"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
				"left outer join COM_MST_OFFICES offi on offi.office_id=mstform2.PAYMENT_OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;	*/
				
				String sqlQry="select mstform2.EMP_NO," +
				"mstform1.EMP_NAME," +
				"mstform2.FATHER_NAME," +
				"mstform2.HUSBAND_NAME," +
				"mstform2.EMP_HEIGHT," +
				"mstform2.ID_MARK1," +
				"mstform2.ID_MARK2," +
				"mstform2.PRESENT_ADDRESS," +
				"mstform2.PERMANENT_ADDRESS," +
				"mstform2.ADDRESS_AFTER_RETIRE," +
				"sta.STATE_NAME," +
				"mstform1.PENSION_TYPE," +
				"mstform1.DATE_OF_BIRTH," +
				"mstform1.DATE_OF_RETIRE," +
				"mstform1.DATE_OF_VRS," +
				"mstform1.COMM_OPTED," +
				"mstform1.COMM_FACTOR_ONRTHIRD," +
				"mstform1.COM_FACTOR_PERT," +
				"mstform1.PENSION_AMOUNT," +
				"mstform1.TOTAL_COMMUTED_AMOUNT," +
				"mstform1.COMMUTATION_PEN_AMOUNT," +
				"mstform1.DEATH_DATE," +
				"desi.DESIGNATION, " +
				"offi.OFFICE_NAME " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_EMP_CURRENT_POSTING emp ON mstform1.EMP_ID=emp.EMPLOYEE_ID "+
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=emp.DESIGNATION_ID " +
				"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
				"left outer join COM_MST_OFFICES offi on offi.office_id=mstform2.PAYMENT_OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;	
				
							
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDetailsDao mainpd=new penAppFieldOfficeDetailsDao();
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						mainpd.setFATHER_NAME(tmp[2]+"");
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						mainpd.setHUSBAND_NAME(tmp[3]+"");
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						mainpd.setEMP_HEIGHT(tmp[4]+"");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						mainpd.setID_MARK1(tmp[5]+"");
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						mainpd.setID_MARK2(tmp[6]+"");
					}
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPRESENT_ADDRESS(tmp[7]+"");
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPERMANENT_ADDRESS(tmp[8]+"");
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setADDRESS_AFTER_RETIRE(tmp[9]+"");
					}
					mainpd.setSTATE(tmp[10]+"");
					pensiontype=tmp[11]+"";
					//System.out.println("The pension type is"+pensiontype);
					if(pensiontype.equalsIgnoreCase("1"))
					{
						classofpensionstring="Superannuation";
						//System.out.println("The pension type is"+classofpensionstring);
						mainpd.setDATE_OF_RETIRE((Date)tmp[13]);
					}
					if(pensiontype.equalsIgnoreCase("2"))
					{
						classofpensionstring="VRS";
						//System.out.println("The pension type is"+classofpensionstring);
						mainpd.setDATE_OF_RETIRE((Date)tmp[14]);
					}
					if(pensiontype.equalsIgnoreCase("3"))
					{
						classofpensionstring="DEATH";
						//System.out.println("The pension type is"+classofpensionstring);
						mainpd.setDATE_OF_RETIRE((Date)tmp[21]);
					}
					mainpd.setPENSION_TYPE(classofpensionstring);
					mainpd.setPENSION_TYPE_LABEL(classofpensionstring);
					
					comopted=tmp[15]+"";
					if(comopted.equalsIgnoreCase("Yes"))
					{
						mainpd.setWHETHER_COMMUTED("Yes");
						mainpd.setCOMMUTED_AMOUNT((BigDecimal)tmp[19]);
						if((tmp[16]+"").equalsIgnoreCase("onethird"))
						{
							mainpd.setCOMMUTED_FRACTION("One third of pension amount.");
						}
						if((tmp[16]+"").equalsIgnoreCase("pert"))
						{
							mainpd.setCOMMUTED_FRACTION(tmp[17]+" % of proposed pension amount.");
						}						
						
					}
					else
					{
						mainpd.setWHETHER_COMMUTED("No");
						
					}
					mainpd.setDATE_OF_BIRTH((Date)tmp[12]);					
					mainpd.setPENSION_AMOUNT((BigDecimal)tmp[18]);
					mainpd.setDESIGNATION(tmp[22]+"");
					mainpd.setPAYMENT_OFFICE(tmp[23]+"");			
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeSpecSignDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 
				String pensiontype="";
				String classofpensionstring="";
				String comopted="";
				/*String sqlQry="select mstform2.EMP_NO," +
						"mstform2.EMP_NAME," +
						"mstform2.GENDER," +
						"mstform2.HUSBAND_NAME," +						
						"desi.DESIGNATION, " +
						"offi.office_name " +
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
						"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
						"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
						"where mstform1.EMP_ID="+empId;		*/	
				
				
				String sqlQry="select mstform2.EMP_NO," +
				"mstform1.EMP_NAME," +
				"mstform2.GENDER," +
				"mstform2.HUSBAND_NAME," +						
				"desi.DESIGNATION, " +
				"offi.office_name " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_EMP_CURRENT_POSTING post ON post.employee_id=mstform2.emp_no  " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=post.DESIGNATION_ID " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;		
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDetailsDao mainpd=new penAppFieldOfficeDetailsDao();				
									
					String pre_name="";
					String employeename=tmp[1]+"";
					String designation=tmp[4]+"";
					if((tmp[2]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					if((tmp[2]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[3]+"").equalsIgnoreCase("null"))
						{
							pre_name="Tmt ";
						}
						else
						{
							pre_name="Selvi ";
						}
					}
					mainpd.setEMP_NAME(pre_name+employeename+", "+designation+",");
					mainpd.setPAYMENT_OFFICE(tmp[5]+", Twad Board.");				
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeDescRollDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG3DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG3DetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 
				
				/*String sqlQry="select mstform2.EMP_NAME," +						
						"mstform1.DATE_OF_BIRTH," +
						"mstform2.EMP_HEIGHT," +
						"mstform2.ID_MARK1," +
						"mstform2.ID_MARK2, " +	
						"mstform2.GENDER," +
						"mstform2.HUSBAND_NAME," +						
						"desi.DESIGNATION, " +
						"offi.office_name " +
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +						
						"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
						"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
						"where mstform1.EMP_ID="+empId;		*/	
		        
		        
		        
		        String sqlQry="select mstform1.EMP_NAME," +						
				"mstform1.DATE_OF_BIRTH," +
				"mstform2.EMP_HEIGHT," +
				"mstform2.ID_MARK1," +
				"mstform2.ID_MARK2, " +	
				"mstform2.GENDER," +
				"mstform2.HUSBAND_NAME," +						
				"desi.DESIGNATION, " +
				"offi.office_name " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +	
				"left outer join HRM_EMP_CURRENT_POSTING post ON post.employee_id=mstform2.emp_no  " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=post.DESIGNATION_ID " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;		
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDCRG3DetailsDao mainpd=new penAppFieldOfficeDCRG3DetailsDao();
					mainpd.setEMP_NAME(tmp[0]+"");
					mainpd.setDATE_OF_BIRTH((Date) tmp[1]);
					mainpd.setEMP_HEIGHT(tmp[2]+"");
					mainpd.setID_MARK1(tmp[3]+"");
					mainpd.setID_MARK2(tmp[4]+"");
							
					
					
					
					String pre_name="";
					String employeename=tmp[0]+"";
					String designation=tmp[7]+"";
					if((tmp[5]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					if((tmp[5]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[6]+"").equalsIgnoreCase("null"))
						{
							pre_name="Tmt ";
						}
						else
						{
							pre_name="Selvi ";
						}
					}
					mainpd.setEMP_NAME_TITLE(pre_name+employeename+", "+designation+",");
					mainpd.setPAYMENT_OFFICE(tmp[8]+", Twad Board.");		
					
					
					
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeAttJoinPhotDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 
				
		        /*String sqlQry="select mstform2.EMP_NAME," +					
				"mstform2.GENDER," +
				"mstform2.HUSBAND_NAME," +						
				"desi.DESIGNATION, " +
				"offi.office_name " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +						
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;	*/	
		        
		        String sqlQry="select mstform1.EMP_NAME," +					
				"mstform2.GENDER," +
				"mstform2.HUSBAND_NAME," +						
				"desi.DESIGNATION, " +
				"offi.office_name " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +	
				"left outer join HRM_EMP_CURRENT_POSTING post ON post.employee_id=mstform2.emp_no  " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=post.DESIGNATION_ID " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;	
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDetailsDao mainpd=new penAppFieldOfficeDetailsDao();
					String pre_name="";
					String employeename=tmp[0]+"";
					String designation=tmp[3]+"";
					if((tmp[1]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					if((tmp[1]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[2]+"").equalsIgnoreCase("null"))
						{
							pre_name="Tmt ";
						}
						else
						{
							pre_name="Selvi ";
						}
					}
					mainpd.setEMP_NAME(pre_name+employeename+", "+designation+",");
					mainpd.setPAYMENT_OFFICE(tmp[4]+", Twad Board.");				
										
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeConsLetDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG3DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG3DetailsDao>();
		List<Object[]> mainli=null;
		try
		   {
		        con=session.connection();	
		        
 
				
				/*String sqlQry="select mstform2.EMP_NAME, " +
						"mstform2.EMP_NO, "+
						"desi.DESIGNATION, "+
						"offi.office_name "+
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +						
						"left outer join hrm_mst_designations desi ON desi.designation_id = mstform2.desig_id " +
						"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
						"where mstform1.EMP_ID="+empId;		*/	
		        
		        
		        String sqlQry="select mstform1.EMP_NAME, " +
				"mstform2.EMP_NO, "+
				"desi.DESIGNATION, "+
				"offi.office_name "+
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +	
				"left outer join HRM_EMP_CURRENT_POSTING post ON post.employee_id=mstform2.emp_no  " +
				"left outer join hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;		
				mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDCRG3DetailsDao mainpd=new penAppFieldOfficeDCRG3DetailsDao();
					//mainpd.setEMP_NAME(tmp[0]+"");			
					String designation="";
					String last_working_office="";
					String employeename=tmp[0]+"";
					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						designation=tmp[2]+"";
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						last_working_office=tmp[3]+"";
					}
					mainpd.setEMP_NAME(employeename+", "+designation+", Twad Board, "+last_working_office);
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeConsLetRecDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 	
		        /*String sqlQry="select mstform2.EMP_NAME, " +
				"mstform2.EMP_NO, "+
				"desi.DESIGNATION, "+
				"offi.office_name "+
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +						
				"left outer join hrm_mst_designations desi ON desi.designation_id = mstform2.desig_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;		*/
		        
		        String sqlQry="select mstform1.EMP_NAME, " +
				"mstform2.EMP_NO, "+
				"desi.DESIGNATION, "+
				"offi.office_name "+
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_EMP_CURRENT_POSTING post ON post.employee_id=mstform2.emp_no " +
				"left outer join hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;		
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDetailsDao mainpd=new penAppFieldOfficeDetailsDao();

					String designation="";
					String last_working_office="";
					String employeename=tmp[0]+"";
					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						designation=tmp[2]+"";
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						last_working_office=tmp[3]+"";
					}
					mainpd.setEMP_NAME(employeename+", "+designation+", Twad Board, "+last_working_office);		
										
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeFormOfDeclarationDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG3DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG3DetailsDao>();
		try
		   {
		        con=session.connection();	
		        		        
		        constNumtoLetter n = new constNumtoLetter();
		        int pensionamount = 0;
		        int dcrgpensionamount = 0;
				
				/*String sqlQry="select mstform2.EMP_NO," +
						"mstform2.EMP_NAME," +						
						"mstform1.PENSION_TYPE," +						
						"mstform1.DATE_OF_RETIRE," +
						"mstform1.DATE_OF_VRS," +
						"mstform1.DEATH_DATE," +
						"mstform1.PENSION_AMOUNT," +
						"mstform1.DCRG_AMOUNT," +						
						"desi.DESIGNATION, " +
						"offi.office_name, " +
						"mstform2.GENDER, " +
						"mstform2.HUSBAND_NAME " +
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
						"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
						"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
						"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
						"where mstform1.EMP_ID="+empId;		*/	
		        
		        
		        String sqlQry="select mstform2.EMP_NO," +
				"mstform1.EMP_NAME," +						
				"mstform1.PENSION_TYPE," +						
				"mstform1.DATE_OF_RETIRE," +
				"mstform1.DATE_OF_VRS," +
				"mstform1.DEATH_DATE," +
				"mstform1.PENSION_AMOUNT," +
				"mstform1.DCRG_AMOUNT," +						
				"desi.DESIGNATION, " +
				"offi.office_name, " +
				"mstform2.GENDER, " +
				"mstform2.HUSBAND_NAME " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_EMP_CURRENT_POSTING post ON post.employee_id=mstform2.emp_no " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=post.DESIGNATION_ID " +
				"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;		
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDCRG3DetailsDao mainpd=new penAppFieldOfficeDCRG3DetailsDao();
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					//mainpd.setEMP_NAME(tmp[1]+"");	
					mainpd.setRETDATE((Date) tmp[3]);
					mainpd.setPENSION_TYPE("Superannuation");
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRETDATE((Date) tmp[4]);
						mainpd.setPENSION_TYPE("VRS");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRETDATE((Date) tmp[5]);
						mainpd.setPENSION_TYPE("Death");
					}
					
					pensionamount=Integer.parseInt(tmp[6]+"");
					dcrgpensionamount=Integer.parseInt(tmp[7]+"");
					mainpd.setPENSION_AMOUNT((BigDecimal) tmp[6]);
					mainpd.setDCRG_AMOUNT((BigDecimal) tmp[7]);
					mainpd.setPENSION_AMOUNT_WORD(n.rupess_to_word(pensionamount));
					mainpd.setDCRG_AMOUNT_WORD(n.rupess_to_word(dcrgpensionamount));
					
					
					String designation="";
					String last_working_office="";
					String pre_name="";
					String employeename=tmp[1]+"";
					if((tmp[10]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					if((tmp[10]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[11]+"").equalsIgnoreCase("null"))
						{
							pre_name="Tmt ";
						}
						else
						{
							pre_name="Selvi ";
						}
					}
					mainpd.setEMP_NAME(pre_name+employeename);
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
						designation=tmp[8]+"";
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						last_working_office=tmp[9]+"";
					}
					mainpd.setDESIGNATION(designation+", "+last_working_office);
					
					
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG1DetailsDao> getPenAppFieldOfficeDcrg1Details(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG1DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG1DetailsDao>();
		try
		   {
		        con=session.connection();	
		        
				
				/*String sqlQry="select mstform2.EMP_NO," +
						"mstform2.EMP_NAME," +
						"mstform2.FATHER_NAME," +
						"mstform2.HUSBAND_NAME," +
						"rel.RELIGION_NAME," +
						"mstform2.NATIONALITY," +
						"mstform2.PERMANENT_ADDRESS," +
						"sta.STATE_NAME," +
						"mstform1.PENSION_TYPE," +
						"mstform1.DATE_OF_BIRTH," +
						"post.DATE_EFFECTIVE_FROM," +
						"serv.DATE_FROM," +
						"serv.DATE_FROM_SESSION," +
						"mstform1.DATE_OF_RETIRE," +
						"mstform1.DATE_OF_VRS," +
						"mstform1.DEATH_DATE," +
						"mstform1.ACTUAL_SER_YEAR," +
						"mstform1.ACTUAL_SER_MON," +
						"mstform1.ACTUAL_SER_DAYS," +
						"mstform1.EOL_YEAR," +
						"mstform1.EOL_MONTH," +
						"mstform1.EOL_DAYS," +
						"mstform1.NET_SER_YEAR," +
						"mstform1.NET_SER_MON," +
						"mstform1.NET_SER_DAYS," +
						"mstform1.LAST_BASIC_PAY," +
						"mstform1.LAST_SPECIAL_PAY," +
						"mstform1.LAST_GRADE_PAY," +
						"mstform1.LAST_OTHER_PAY1," +
						"mstform1.LAST_OTHER_PAY2," +
						"mstform1.LAST_OTHER_PAY3," +
						"mstform1.PENSION_AMOUNT, " +
						"desi.DESIGNATION, " +
						"offi.OFFICE_NAME " +
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
						"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
						"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
						"left outer join HRM_EMP_CURRENT_POSTING post on post.EMPLOYEE_ID=mstform1.emp_id " +
						"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID=mstform1.emp_id " +
						"LEFT OUTER JOIN HRM_MST_RELIGIONS rel ON rel.RELIGION_CODE = mstform2.religion " +
						"LEFT OUTER JOIN COM_MST_OFFICES offi on offi.OFFICE_ID=post.OFFICE_ID " +
						"where mstform1.EMP_ID="+empId+ 
						" and serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID="+empId+")";*/
		        
		       /* String sqlQry="select mstform2.EMP_NO," +
				"mstform1.EMP_NAME," +
				"mstform2.FATHER_NAME," +
				"mstform2.HUSBAND_NAME," +
				"rel.RELIGION_NAME," +
				"mstform2.NATIONALITY," +
				"mstform2.PERMANENT_ADDRESS," +
				"sta.STATE_NAME," +
				"mstform1.PENSION_TYPE," +
				"mstform1.DATE_OF_BIRTH," +
				"post.DATE_EFFECTIVE_FROM," +
				"serv.DATE_FROM," +
				"serv.DATE_FROM_SESSION," +
				"mstform1.DATE_OF_RETIRE," +
				"mstform1.DATE_OF_VRS," +
				"mstform1.DEATH_DATE," +
				"mstform1.ACTUAL_SER_YEAR," +
				"mstform1.ACTUAL_SER_MON," +
				"mstform1.ACTUAL_SER_DAYS," +
				"mstform1.EOL_YEAR," +
				"mstform1.EOL_MONTH," +
				"mstform1.EOL_DAYS," +
				"mstform1.NET_SER_YEAR," +
				"mstform1.NET_SER_MON," +
				"mstform1.NET_SER_DAYS," +
				"mstform1.LAST_BASIC_PAY," +
				"mstform1.LAST_SPECIAL_PAY," +
				"mstform1.LAST_GRADE_PAY," +
				"mstform1.LAST_OTHER_PAY1," +
				"mstform1.LAST_OTHER_PAY2," +
				"mstform1.LAST_OTHER_PAY3," +
				"mstform1.PENSION_AMOUNT, " +
				"desi.DESIGNATION, " +
				"offi.OFFICE_NAME " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
				"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
				"left outer join HRM_EMP_CURRENT_POSTING post on post.EMPLOYEE_ID=mstform1.emp_id " +
				"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID=mstform1.emp_id " +
				"LEFT OUTER JOIN HRM_MST_RELIGIONS rel ON rel.RELIGION_CODE = mstform2.religion " +
				"LEFT OUTER JOIN COM_MST_OFFICES offi on offi.OFFICE_ID=post.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId+ 
				" and serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID="+empId+")";*/
		        
		        
		        String sqlQry="select mstform2.EMP_NO," +
				"mstform1.EMP_NAME," +
				"mstform2.FATHER_NAME," +
				"mstform2.HUSBAND_NAME," +
				"rel.RELIGION_NAME," +
				"mstform2.NATIONALITY," +
				"mstform2.PERMANENT_ADDRESS," +
				"sta.STATE_NAME," +
				"mstform1.PENSION_TYPE," +
				"mstform1.DATE_OF_BIRTH," +
				"post.DATE_EFFECTIVE_FROM," +
				"serv.DATE_FROM," +
				"serv.DATE_FROM_SESSION," +
				"mstform1.DATE_OF_RETIRE," +
				"mstform1.DATE_OF_VRS," +
				"mstform1.DEATH_DATE," +
				"mstform1.ACTUAL_SER_YEAR," +
				"mstform1.ACTUAL_SER_MON," +
				"mstform1.ACTUAL_SER_DAYS," +
				"mstform1.EOL_YEAR," +
				"mstform1.EOL_MONTH," +
				"mstform1.EOL_DAYS," +
				"mstform1.NET_SER_YEAR," +
				"mstform1.NET_SER_MON," +
				"mstform1.NET_SER_DAYS," +
				"mstform1.LAST_BASIC_PAY," +
				"mstform1.LAST_SPECIAL_PAY," +
				"mstform1.LAST_GRADE_PAY," +
				"mstform1.LAST_OTHER_PAY1," +
				"mstform1.LAST_OTHER_PAY2," +
				"mstform1.LAST_OTHER_PAY3," +
				"mstform1.PENSION_AMOUNT, " +
				"desi.DESIGNATION, " +
				"offi.OFFICE_NAME " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
				"left outer join HRM_EMP_CURRENT_POSTING post on post.EMPLOYEE_ID=mstform1.emp_id " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=post.DESIGNATION_ID " +
				"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID=mstform1.emp_id " +
				"LEFT OUTER JOIN HRM_MST_RELIGIONS rel ON rel.RELIGION_CODE = mstform2.religion " +
				"LEFT OUTER JOIN COM_MST_OFFICES offi on offi.OFFICE_ID=post.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId+ 
				" and serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID="+empId+")";
		        
		        
		        
		        
		        
		        
		        
		        
		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					String pensiontype="";
					String father_name="";
					String husband_name="";
					
					Integer lastbasic=0;
					Integer lastspecial=0;
					Integer lastgrade=0;
					Integer lastother1=0;
					Integer lastother2=0;
					Integer lastother3=0;
					Integer lastpaydrawn=0;
					
					
					float sumofav=0;
					int aetotmonth=0;
					float averageemolamount=0;
					
					penAppFieldOfficeDCRG1DetailsDao mainpd=new penAppFieldOfficeDCRG1DetailsDao();
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");	
					
					father_name=tmp[2]+"";
					husband_name=tmp[3]+"";
					if(!father_name.equalsIgnoreCase("null"))
					{
					mainpd.setFATHER_NAME(father_name);
					}
					if(!husband_name.equalsIgnoreCase("null"))
					{
						mainpd.setFATHER_NAME(husband_name);
					}				
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
					mainpd.setRELIGION(tmp[4]+"");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNATIONALITY(tmp[5]+"");
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
					mainpd.setPERMANENT_ADDRESS(tmp[6]+"");
					}
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
					mainpd.setSTATE_NAME(tmp[7]+"");
					}			
					
					pensiontype=tmp[8]+"";
					if(pensiontype.equalsIgnoreCase("1"))
					{
						mainpd.setPENSION_TYPE("Superannuation");
					}
					if(pensiontype.equalsIgnoreCase("2"))
					{
						mainpd.setPENSION_TYPE("VRS");
					}
					if(pensiontype.equalsIgnoreCase("3"))
					{
						mainpd.setPENSION_TYPE("Death");
					}
									
					mainpd.setDATE_OF_BIRTH((Date)tmp[9]);
					mainpd.setDATE_EFFECTIVE_FROM((Date)tmp[10]);					
					mainpd.setDATE_FROM((Date)tmp[11]);
					mainpd.setDATE_FROM_SESSION(tmp[12]+"");
					mainpd.setDATE_OF_RETIRE((Date)tmp[13]);
					mainpd.setDATE_OF_VRS((Date)tmp[14]);
					mainpd.setDEATH_DATE((Date)tmp[15]);
					
					mainpd.setACTUAL_SER_YEAR((BigDecimal)tmp[16]);
					mainpd.setACTUAL_SER_MON((BigDecimal)tmp[17]);
					mainpd.setACTUAL_SER_DAYS(((BigDecimal)tmp[18]));
					
					mainpd.setEOL_YEAR((BigDecimal)tmp[19]);
					mainpd.setEOL_MONTH((BigDecimal)tmp[20]);
					mainpd.setEOL_DAYS((BigDecimal)tmp[21]);
					
					
					mainpd.setNET_SER_YEAR((BigDecimal)tmp[22]);
					mainpd.setNET_SER_MON((BigDecimal)tmp[23]);
					mainpd.setNET_SER_DAYS((BigDecimal)tmp[24]);
					
					
					
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						lastbasic=Integer.parseInt(tmp[25]+"");
					}
					if(!(tmp[26]+"").equalsIgnoreCase("null"))
					{
						lastspecial=Integer.parseInt(tmp[26]+"");
					}
					if(!(tmp[27]+"").equalsIgnoreCase("null"))
					{
						lastgrade=Integer.parseInt(tmp[27]+"");
					}
					if(!(tmp[28]+"").equalsIgnoreCase("null"))
					{
						lastother1=Integer.parseInt(tmp[28]+"");
					}
					if(!(tmp[29]+"").equalsIgnoreCase("null"))
					{
						lastother2=Integer.parseInt(tmp[29]+"");
					}
					if(!(tmp[30]+"").equalsIgnoreCase("null"))
					{
						lastother3=Integer.parseInt(tmp[30]+"");
					}
					
					lastpaydrawn=lastbasic+lastspecial+lastgrade+lastother1+lastother2+lastother3;
					String name_of_lat_establishment="";
					/*if(!(tmp[32]+"").equalsIgnoreCase("null"))
					{
						name_of_lat_establishment=tmp[32]+", Twad Board, ";
					}
					/*if(!(tmp[33]+"").equalsIgnoreCase("null"))
					{
						name_of_lat_establishment+=tmp[33]+".";
					}*/
					
					if(!(tmp[32]+"").equalsIgnoreCase("null"))
					{
						name_of_lat_establishment=tmp[32]+"";
					}
					
					mainpd.setNAME_OF_ESTABLISHMENT(name_of_lat_establishment);
					
					String str="select sum(av.PROP_PAY) from HRM_PEN_APP_MST_AVG_FORM1 av where av.EMP_ID="+empId;
					 Query query=session.createSQLQuery(str);	
					 Iterator obj=query.list().iterator();			 
					String objstring="";
					 while(obj.hasNext())
					 {
						 objstring=obj.next()+"";
						 if(!(objstring).equalsIgnoreCase("null"))
						 {
							 sumofav = Float.parseFloat(objstring);
						 }
						 
						 	
					 }
					
					 
					 String str1="select AVGTOTMONTHS from HRM_PEN_CAL_SETTINGS";
					 Query query1=session.createSQLQuery(str1);	
					 Iterator obj1=query1.list().iterator();					
					 while(obj1.hasNext())
					 {
						 aetotmonth = Integer.parseInt(""+obj1.next());		
						 	
					 }
					 averageemolamount=sumofav/aetotmonth;
					
					 BigDecimal avgpaydrwnobj=new BigDecimal(averageemolamount);
					 BigDecimal lastpaydrawnobj=new BigDecimal(lastpaydrawn);
					 
					 					 
					 //Integer avamount=Integer.parseInt(avgpaydrwnobj+"");					
					 Integer avamount=avgpaydrwnobj.intValue();
					 System.out.println("avamount===="+avamount);
					if(lastpaydrawn>=avamount)
					{
						mainpd.setAE_LPD(lastpaydrawnobj);
					}
					else
					{
						mainpd.setAE_LPD(avgpaydrwnobj);
					}
					mainpd.setPENSION_AMOUNT((BigDecimal)tmp[31]);
					
					
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG2DetailsDao> getPenAppFieldOfficeDcrg2Details(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG2DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG2DetailsDao>();
		try
		   {
		        con=session.connection();	
		       
				
				String sqlQry="select mstform2.EMP_NO," +
						"mstform1.DCRG_AMOUNT," +
						"to_date(mstform1.DATE_OF_RETIRE+1,'DD/MM/YY') AS RETDATE," +
						"to_date(mstform1.DATE_OF_VRS+1,'DD/MM/YY') AS VRSDATE," +
						"to_date(mstform1.DEATH_DATE+1,'DD/MM/YY') AS DEATHDATE," +
						"mstform1.DATE_OF_BIRTH," +
						"mstform2.EMP_HEIGHT," +
						"mstform2.ID_MARK1," +
						"mstform2.ID_MARK2," +
						"mstform2.APPLICATION_DATE," +
						"mstform2.CHARGES_FLAG," +
						"mstform2.CHARGES_DETAILS," +
						"emp.GPF_NO, " +
						"offi.OFFICE_NAME " +
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
						"left outer join HRM_MST_EMPLOYEES emp on mstform1.emp_id=emp.EMPLOYEE_ID " +
						"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.PAYMENT_OFFICE_ID " +
						"where mstform1.EMP_ID="+empId;
				
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
										
					penAppFieldOfficeDCRG2DetailsDao mainpd=new penAppFieldOfficeDCRG2DetailsDao();
					
														
					mainpd.setEMP_NO((BigDecimal) tmp[0]);
					mainpd.setDCRG_AMOUNT((BigDecimal) tmp[1]);
					mainpd.setDATE_FROM_PEN((Date) tmp[2]);					
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						mainpd.setDATE_FROM_PEN((Date) tmp[3]);
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						mainpd.setDATE_FROM_PEN((Date) tmp[4]);
					}					
					mainpd.setDATE_OF_BIRTH((Date) tmp[5]);
					mainpd.setEMP_HEIGHT(tmp[6]+"");
					mainpd.setID_MARK1(tmp[7]+"");
					mainpd.setID_MARK2(tmp[8]+"");
					mainpd.setAPPLICATION_DATE((Date) tmp[9]);
					
					if((tmp[10]+"").equalsIgnoreCase("Yes"))
					{
						mainpd.setCHARGES_DETAILS(tmp[11]+"");
					}
					if((tmp[10]+"").equalsIgnoreCase("No"))
					{
						mainpd.setCHARGES_DETAILS("No");
					}
					
					mainpd.setGPF_NO((BigDecimal) tmp[12]);
					if(!(tmp[13]+"").equalsIgnoreCase("null"))
					{
					mainpd.setPAYMENT_OFFICE(tmp[13]+"");
					}
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG1DetailsDao> getPenAppFieldOfficeFormAssPenGratuityDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG1DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG1DetailsDao>();
		try
		   {
		        con=session.connection();	
		        
				
				/*String sqlQry="select mstform2.EMP_NO," +
						"mstform2.EMP_NAME," +
						"mstform2.FATHER_NAME," +
						"mstform2.HUSBAND_NAME," +
						"rel.RELIGION_NAME," +
						"mstform2.NATIONALITY," +
						"mstform2.PERMANENT_ADDRESS," +
						"sta.STATE_NAME," +
						"mstform1.PENSION_TYPE," +
						"mstform1.DATE_OF_BIRTH," +
						"post.DATE_EFFECTIVE_FROM," +
						"serv.DATE_FROM," +
						"serv.DATE_FROM_SESSION," +
						"mstform1.DATE_OF_RETIRE," +
						"mstform1.DATE_OF_VRS," +
						"mstform1.DEATH_DATE, " +
						"desi.DESIGNATION, " +
						"offi.OFFICE_NAME " +
						"from HRM_PEN_APP_MST_FORM2 mstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
						"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
						"left outer join HRM_EMP_CURRENT_POSTING post on post.EMPLOYEE_ID=mstform1.emp_id " +
						"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID=mstform1.emp_id " +
						"left outer join HRM_MST_RELIGIONS rel ON rel.RELIGION_CODE = mstform2.religion " +
						"left outer join hrm_mst_designations desi ON desi.designation_id = mstform2.desig_id " +
						"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
						"where mstform1.EMP_ID="+empId+ 
						" and serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID="+empId+")";*/
		        
		        
		        String sqlQry="select mstform2.EMP_NO," +
				"mstform1.EMP_NAME," +
				"mstform2.FATHER_NAME," +
				"mstform2.HUSBAND_NAME," +
				"rel.RELIGION_NAME," +
				"mstform2.NATIONALITY," +
				"mstform2.PERMANENT_ADDRESS," +
				"sta.STATE_NAME," +
				"mstform1.PENSION_TYPE," +
				"mstform1.DATE_OF_BIRTH," +
				"post.DATE_EFFECTIVE_FROM," +
				"serv.DATE_FROM," +
				"serv.DATE_FROM_SESSION," +
				"mstform1.DATE_OF_RETIRE," +
				"mstform1.DATE_OF_VRS," +
				"mstform1.DEATH_DATE, " +
				"desi.DESIGNATION, " +
				"offi.OFFICE_NAME, " +
				"mstform2.APPLICATION_DATE " +
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
				"left outer join HRM_EMP_CURRENT_POSTING post on post.EMPLOYEE_ID=mstform1.emp_id " +
				"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID=mstform1.emp_id " +
				"left outer join HRM_MST_RELIGIONS rel ON rel.RELIGION_CODE = mstform2.religion " +
				"left outer join hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId+ 
				" and serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID="+empId+")";
		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					String pensiontype="";
					String father_name="";
					String husband_name="";
					
										
					penAppFieldOfficeDCRG1DetailsDao mainpd=new penAppFieldOfficeDCRG1DetailsDao();
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");	
					
					father_name=tmp[2]+"";
					husband_name=tmp[3]+"";
					if(!father_name.equalsIgnoreCase("null"))
					{
						mainpd.setFATHER_NAME(father_name);
					}
					if(!husband_name.equalsIgnoreCase("null"))
					{
						mainpd.setFATHER_NAME(husband_name);
					}				
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRELIGION(tmp[4]+"");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNATIONALITY(tmp[5]+"");
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPERMANENT_ADDRESS(tmp[6]+"");
					}
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						mainpd.setSTATE_NAME(tmp[7]+"");
					}			
					
					pensiontype=tmp[8]+"";
					if(pensiontype.equalsIgnoreCase("1"))
					{
						mainpd.setPENSION_TYPE("Superannuation");
					}
					if(pensiontype.equalsIgnoreCase("2"))
					{
						mainpd.setPENSION_TYPE("VRS");
					}
					if(pensiontype.equalsIgnoreCase("3"))
					{
						mainpd.setPENSION_TYPE("Death");
					}
										
					mainpd.setDATE_OF_BIRTH((Date)tmp[9]);
				
					
					mainpd.setDATE_EFFECTIVE_FROM((Date)tmp[10]);					
					
					mainpd.setDATE_FROM((Date)tmp[11]);
					
					
					//
					mainpd.setDATE_FROM_SESSION(tmp[12]+"");
					
					
					mainpd.setDATE_OF_RETIRE((Date)tmp[13]);
					
					
					//
					mainpd.setDATE_OF_VRS((Date)tmp[14]);
					mainpd.setDEATH_DATE((Date)tmp[15]);				 
					
					String name_of_establishment="";
					/*if(!(tmp[16]+"").equalsIgnoreCase("null"))
					{
						name_of_establishment=tmp[16]+", Twad Board, ";
					}
					if(!(tmp[17]+"").equalsIgnoreCase("null"))
					{
						name_of_establishment+=tmp[17]+". ";
					}*/
					if(!(tmp[16]+"").equalsIgnoreCase("null"))
					{
						name_of_establishment=tmp[16]+"";
					}
					mainpd.setAPPLICATION_DATE((Date)tmp[18]);
					mainpd.setNAME_OF_ESTABLISHMENT(name_of_establishment);
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<pensionForm1CalcValDetailsDao> getPenAppFieldOfficeFormAssPenGratuity2Details(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionForm1CalcValDetailsDao> mainretn=new ArrayList<pensionForm1CalcValDetailsDao>();
		try
		   {
		        con=session.connection();	
		        String sqlQry="select mstform1.ACTUAL_SER_DAYS," +
		        		"mstform1.ACTUAL_SER_MON," +
		        		"mstform1.ACTUAL_SER_YEAR," +
		        		"mstform1.NET_SER_DAYS," +
		        		"mstform1.NET_SER_MON," +
		        		"mstform1.NET_SER_YEAR," +
		        		"mstform1.NON_PROV_SERV_DAYS," +
		        		"mstform1.NON_PROV_SERV_MONTH," +
		        		"mstform1.NON_PROV_SERV_YEAR," +
		        		"mstform1.EOL_DAYS," +
		        		"mstform1.EOL_MONTH," +
		        		"mstform1.EOL_YEAR," +
		        		"mstform1.SUSPENSION_DAYS," +
		        		"mstform1.SUSPENSION_MONTH," +
		        		"mstform1.SUSPENSION_YEAR," +
		        		"mstform1.BOY_SERV_DAYS," +
		        		"mstform1.BOY_SERV_MONTH," +
		        		"mstform1.BOY_SERV_YEAR," +
		        		"mstform1.OVERSTAY_LEAVE_DAYS," +
		        		"mstform1.OVERSTAY_LEAVE_MONTH," +
		        		"mstform1.OVERSTAY_LEAVE_YEAR," +
		        		"mstform1.NOT_REG_LEAVE_DAYS," +
		        		"mstform1.NOT_REG_LEAVE_MONTH," +
		        		"mstform1.NOT_REG_LEAVE_YEAR," +
		        		"mstform1.APPRENTICE_DAYS," +
		        		"mstform1.APPRENTICE_MONTH," +
		        		"mstform1.APPRENTICE_YEAR," +
		        		"mstform1.NOT_SERV_VERIFY_DAYS," +
		        		"mstform1.NOT_SERV_VERIFY_MONTH," +
		        		"mstform1.NOT_SERV_VERIFY_YEAR," +
		        		"mstform1.FOREIGN_SERV_DAYS," +
		        		"mstform1.FOREIGN_SERV_MONTH," +
		        		"mstform1.FOREIGN_SERV_YEAR," +
		        		"mstform1.TOT_NON_QUAL_SER_DAYS," +
		        		"mstform1.TOT_NON_QUAL_SER_MON," +
		        		"mstform1.TOT_NON_QUAL_SER_YEAR," +		        				        		
		        		"mstform1.WEIGHTAGE_DAYS," +
		        		"mstform1.WEIGHTAGE_MONTH," +
		        		"mstform1.WEIGHTAGE_YEAR," +
		        		"mstform1.PENSION_TYPE," +
		        		"mstform1.WCE_SERV_DAYS," +
		        		"mstform1.WCE_SERV_MONTH," +
		        		"mstform1.WCE_SERV_YEAR," +
		        		"mstform1.WCE_SERV_FLAG," +
		        		"mstform1.WCE_SERV_COUNT_FLAG," +
		        		"mstform1.CONTINGENT_SERV_FLAG," +
		        		"mstform1.CONTINGENT_SERV_DAYS," +
		        		"mstform1.CONTINGENT_SERV_MONTH," +
		        		"mstform1.CONTINGENT_SERV_YEAR," +
		        		"mstform1.NO_OF_HALFYEAR_PENSION," +
		        		"mstform1.NO_OF_HALFYEAR_DCRG, " +
		        		"(mstform1.LAST_BASIC_PAY+mstform1.LAST_SPECIAL_PAY+mstform1.LAST_GRADE_PAY+mstform1.LAST_OTHER_PAY1+mstform1.LAST_OTHER_PAY2+mstform1.LAST_OTHER_PAY3+mstform1.DA_AMOUNT) emol_rock_dcrg "+  
		        		"FROM HRM_PEN_APP_MST_FORM1_DET mstform1 " +
		        		"where mstform1.EMP_ID="+empId;
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					String pensiontype="";
					String father_name="";
					String husband_name="";
					
										
					pensionForm1CalcValDetailsDao mainpd=new pensionForm1CalcValDetailsDao();
									 
					mainpd.setACTUALSERVICEDAYS((BigDecimal) tmp[0]);
					mainpd.setACTUALSERVICEMONTH((BigDecimal) tmp[1]);
					mainpd.setACTUALSERVICEYEAR((BigDecimal) tmp[2]);
					
					mainpd.setNETQUALSERVICEDAYS((BigDecimal) tmp[3]);
					mainpd.setNETQUALSERVICEMONTH((BigDecimal) tmp[4]);
					mainpd.setNETQUALSERVICEYEAR((BigDecimal) tmp[5]);
					
					mainpd.setNON_PROV_SERV_DAYS((BigDecimal) tmp[6]);
					mainpd.setNON_PROV_SERV_MONTH((BigDecimal) tmp[7]);
					mainpd.setNON_PROV_SERV_YEAR((BigDecimal) tmp[8]);
					
					
					mainpd.setEOL_DAYS((BigDecimal) tmp[9]);
					mainpd.setEOL_MONTH((BigDecimal) tmp[10]);
					mainpd.setEOL_YEAR((BigDecimal) tmp[11]);
					
					
					mainpd.setSUSPENSION_DAYS((BigDecimal) tmp[12]);
					mainpd.setSUSPENSION_MONTH((BigDecimal) tmp[13]);
					mainpd.setSUSPENSION_YEAR((BigDecimal) tmp[14]);
					
					mainpd.setBOY_SERV_DAYS((BigDecimal) tmp[15]);
					mainpd.setBOY_SERV_MONTH((BigDecimal) tmp[16]);
					mainpd.setBOY_SERV_YEAR((BigDecimal) tmp[17]);
					
					mainpd.setOVERSTAY_LEAVE_DAYS((BigDecimal) tmp[18]);
					mainpd.setOVERSTAY_LEAVE_MONTH((BigDecimal) tmp[19]);
					mainpd.setOVERSTAY_LEAVE_YEAR((BigDecimal) tmp[20]);
					
					mainpd.setNOT_REG_LEAVE_DAYS((BigDecimal) tmp[21]);
					mainpd.setNOT_REG_LEAVE_MONTH((BigDecimal) tmp[22]);
					mainpd.setNOT_REG_LEAVE_YEAR((BigDecimal) tmp[23]);
					
					
					mainpd.setAPPRENTICE_DAYS((BigDecimal) tmp[24]);
					mainpd.setAPPRENTICE_MONTH((BigDecimal) tmp[25]);
					mainpd.setAPPRENTICE_YEAR((BigDecimal) tmp[26]);
					
					
					mainpd.setNOT_SERV_VERIFY_DAYS((BigDecimal) tmp[27]);
					mainpd.setNOT_SERV_VERIFY_MONTH((BigDecimal) tmp[28]);
					mainpd.setNOT_SERV_VERIFY_YEAR((BigDecimal) tmp[29]);
					
					mainpd.setFOREIGN_SERV_DAYS((BigDecimal) tmp[30]);
					mainpd.setFOREIGN_SERV_MONTH((BigDecimal) tmp[31]);
					mainpd.setFOREIGN_SERV_YEAR((BigDecimal) tmp[32]);
					
					
					mainpd.setNONQUALSERVICEDAYS((BigDecimal) tmp[33]);
					mainpd.setNONQUALSERVICEMONTH((BigDecimal) tmp[34]);
					mainpd.setNONQUALSERVICEYEAR((BigDecimal) tmp[35]);
					
					
					String typeofpension=tmp[39]+"";
					
					
					if(typeofpension.equalsIgnoreCase("1") || typeofpension.equalsIgnoreCase("3"))
					{
						mainpd.setWEIGHTAGE_SERV_YEAR("");
						mainpd.setWEIGHTAGE_SERV_MONTH("");
						mainpd.setWEIGHTAGE_SERV_DAYS("");
						mainpd.setWEIGHTAGELABLE("");				
						
					}
					else
					{						
						mainpd.setWEIGHTAGELABLE("Weightage");	
						mainpd.setWEIGHTAGE_SERV_DAYS(tmp[36]+"");
						mainpd.setWEIGHTAGE_SERV_MONTH(tmp[37]+"");
						mainpd.setWEIGHTAGE_SERV_YEAR(tmp[38]+"");
						
					}
					
					
					
					
					mainpd.setWCE_SERV_FLAG(tmp[43]+"");
					mainpd.setWCE_SERV_COUNT_FLAG(tmp[44]+"");
					String wceflag=tmp[43]+"";
					String wcecountflag=tmp[44]+"";
					if(wceflag.equalsIgnoreCase("Yes") && wcecountflag.equalsIgnoreCase("No"))
					{
						mainpd.setWCESERVICELABLE("WCE Service");						
						if((tmp[40]+"").equalsIgnoreCase("null") || (tmp[40])==null)
						{
							mainpd.setWCE_SERV_DAYS("");
						}
						else
						{
							mainpd.setWCE_SERV_DAYS(tmp[40]+"");
						}
						if((tmp[41]+"").equalsIgnoreCase("null") || (tmp[41])==null)
						{
							mainpd.setWCE_SERV_MONTH("");
						}
						else
						{
							mainpd.setWCE_SERV_MONTH(tmp[41]+"");
						}
						if((tmp[42]+"").equalsIgnoreCase("null") || (tmp[42])==null)
						{
							mainpd.setWCE_SERV_YEAR("");
						}
						else
						{
							mainpd.setWCE_SERV_YEAR(tmp[42]+"");
						}
						
					}
					else
					{
						mainpd.setWCESERVICELABLE("");
						mainpd.setWCE_SERV_DAYS("");
						mainpd.setWCE_SERV_MONTH("");
						mainpd.setWCE_SERV_YEAR("");
					}
					
					
					
					
					
					
					
					mainpd.setCONTINGENT_SERV_FLAG(tmp[45]+"");
										
					Integer contingentday= null;
					Integer contingentmonth= null;
					Integer contingentyear= null;
					
					String contingflag=tmp[45]+"";					
					if(contingflag.equalsIgnoreCase("Yes"))
					{						
						Integer contingentserviceyear=0;
						Integer contingentservicemonth=0;
						Integer contingentserviceday=0;
						if((tmp[46]+"").equalsIgnoreCase("null") || (tmp[46])==null)
						{
							contingentday=0;
						}
						else
						{
							contingentday=Integer.parseInt(tmp[46]+"");
						}
						if((tmp[47]+"").equalsIgnoreCase("null") || (tmp[47])==null)
						{
							contingentmonth=0;
						}
						else
						{
							contingentmonth=Integer.parseInt(tmp[47]+"");
						}
						if((tmp[48]+"").equalsIgnoreCase("null") || (tmp[48])==null)
						{
							contingentyear=0;
						}
						else
						{
							contingentyear=Integer.parseInt(tmp[48]+"");
						}
						
						
						mainpd.setCONTSERVICELABLE("Contingent Service (50%)");
									
						
						if(contingentyear>0)
						{
							Integer contingentyrem=contingentyear%2;
							if(contingentyrem==0)
							{
								contingentserviceyear=contingentyear/2;
							}
							if(contingentyrem!=0)
							{
								contingentserviceyear=contingentyear/2;
								contingentmonth=contingentmonth+(contingentyrem*12);
							}
							
							
						}
						if(contingentmonth>0)
						{
							Integer contingentmrem=contingentmonth%2;
							if(contingentmrem==0)
							{
								contingentservicemonth=contingentmonth/2;
							}
							if(contingentmrem!=0)
							{
								contingentservicemonth=contingentmonth/2;
								Integer countday=contingentmrem*30;
								contingentday=contingentday+countday;
							}
							
						}
						
						if(contingentday>0)
						{
							Integer contingentdrem=contingentday%2;
							if(contingentdrem==0)
							{
								contingentserviceday=contingentday/2;
							}
							if(contingentdrem!=0)
							{
								contingentserviceday=(contingentday/2)+1;
								
							}
							
						}
						
						
						
						mainpd.setCONTINGENT_SERV_DAYS(contingentserviceday+"");
						mainpd.setCONTINGENT_SERV_MONTH(contingentservicemonth+"");
						mainpd.setCONTINGENT_SERV_YEAR(contingentserviceyear+"");
					}
					else
					{
						mainpd.setCONTSERVICELABLE("");
						mainpd.setCONTINGENT_SERV_DAYS("");
						mainpd.setCONTINGENT_SERV_MONTH("");
						mainpd.setCONTINGENT_SERV_YEAR("");
						
					}
					
					mainpd.setNO_OF_HALFYEAR_PENSION((BigDecimal) tmp[49]);
					mainpd.setNO_OF_HALFYEAR_DCRG((BigDecimal) tmp[50]);
					mainpd.setEMOL_ROCK_DCRG((BigDecimal) tmp[51]);
					
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
			
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<pensionForm1CalcValDetailsDao> getFieldOfficeAvgValDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionForm1CalcValDetailsDao> retn=new ArrayList<pensionForm1CalcValDetailsDao>();
		try
		   { 
			    con=session.connection();
			    
			    
			    
			    
			    String basicpayname="";
				String gradepayname="";
				String specialpayname="";
				String other1payname="";				
				String other2payname="";
				String other3payname="";
				float sumofav=0;
				int aetotmonth=0;
				float averageemolamount=0;
				String sqlQryforavgsetting="select " +
				"avset.PAY_NAME," +
				"avset.INCLUDE," +
				"avset.DA," +				
				"avset.DISPLAY_CAPTION " +
				"from AVERAGE_CAL_SETTING avset";		
				
				
		List<Object[]> avgsettingmainli=session.createSQLQuery(sqlQryforavgsetting).list();
		for(Object[] avgsettingtmp:avgsettingmainli)
		{
			if((avgsettingtmp[0]+"").equals("BASIC"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						basicpayname=avgsettingtmp[3]+"";
					}
				}
			}			
			if((avgsettingtmp[0]+"").equals("GRADE PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						gradepayname=avgsettingtmp[3]+"";
					}
				}
			}
			if((avgsettingtmp[0]+"").equals("SPECIAL PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						specialpayname=avgsettingtmp[3]+"";						
					}					
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY1"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						other1payname=avgsettingtmp[3]+"";
					}
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY2"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						other2payname=avgsettingtmp[3]+"";
					}
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY3"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						other3payname=avgsettingtmp[3]+"";
					}
				}
			}
		}
			
		 String str="select sum(av.PROP_PAY) from HRM_PEN_APP_MST_AVG_FORM1 av where av.EMP_ID="+empId;
		 Query query=session.createSQLQuery(str);	
		 Iterator obj=query.list().iterator();			 
		String objstring="";
		 while(obj.hasNext())
		 {
			 objstring=obj.next()+"";
			 //sumofav = Integer.parseInt(""+obj.next());
			 if(!(objstring).equals("null"))
			 {
				 sumofav = Float.parseFloat(objstring);
			 }
			 
			 	
		 }
		 String str1="select AVGTOTMONTHS from HRM_PEN_CAL_SETTINGS";
		 Query query1=session.createSQLQuery(str1);	
		 Iterator obj1=query1.list().iterator();			 
		
		 while(obj1.hasNext())
		 {
			 aetotmonth = Integer.parseInt(""+obj1.next());		
			 	
		 }
		 averageemolamount=sumofav/aetotmonth;
			    
			    
				String sqlQry="select av.AVG_ID,av.NOT_CONSIDERED,av.DATE_FROM,av.DATE_TO,av.TOT_MONTHS,av.TOT_DAYS,av.BASIC_PAY,av.GRADE_PAY,av.SPECIAL_PAY,av.OTHER1_PAY,av.OTHER2_PAY,av.OTHER3_PAY,av.PROP_PAY from HRM_PEN_APP_MST_AVG_FORM1 av where EMP_ID="+empId;
				List<Object[]> li=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:li)
				{
					pensionForm1CalcValDetailsDao pd=new pensionForm1CalcValDetailsDao();
					
					pd.setAVG_ID((BigDecimal)tmp[0]);
					pd.setNOT_CONSIDERED(tmp[1]+"");
					pd.setDATE_FROM((Date)tmp[2]);
					pd.setDATE_TO((Date)tmp[3]);
					pd.setTOT_MONTHS((BigDecimal)tmp[4]);
					pd.setTOT_DAYS((BigDecimal)tmp[5]);					
					
					if((basicpayname.equals("")) || (basicpayname.equals("null")))
					{
						pd.setAVGBASICLABLE("");
					}
					else
					{
						pd.setAVGBASICLABLE(basicpayname);
						if(!(tmp[6]+"").equals("null"))
						{
							pd.setBASIC_PAY(tmp[6]+"");
						}
					}
					
					if((specialpayname.equals("")) || (specialpayname.equals("null")))
					{
						pd.setAVGSPECIALLABLE("");
					}
					else
					{
						pd.setAVGSPECIALLABLE(specialpayname);
						if(!(tmp[8]+"").equals("null"))
						{
							pd.setSPECIAL_PAY(tmp[8]+"");
						}
					}					
					if((gradepayname.equals("")) || (gradepayname.equals("null")))
					{
						pd.setAVGGRADELABLE("");
					}
					else
					{
						pd.setAVGGRADELABLE(gradepayname);
						if(!(tmp[7]+"").equals("null"))
						{
							pd.setGRADE_PAY(tmp[7]+"");
						}
					}					
					
					if((other1payname.equals("")) || (other1payname.equals("null")))
					{
						pd.setAVGOTHER1LABLE("");
					}
					else
					{
						pd.setAVGOTHER1LABLE(other1payname);
						if(!(tmp[9]+"").equals("null"))
						{
							pd.setOTHER1_PAY(tmp[9]+"");
						}
					}					
					if((other2payname.equals("")) || (other2payname.equals("null")))
					{
						pd.setAVGOTHER2LABLE("");
					}
					else
					{
						pd.setAVGOTHER2LABLE(other2payname);
						if(!(tmp[10]+"").equals("null"))
						{
							pd.setOTHER2_PAY(tmp[10]+"");
						}
					}
					if((other3payname.equals("")) || (other3payname.equals("null")))
					{
						pd.setAVGOTHER3LABLE("");
					}
					else
					{
						pd.setAVGOTHER3LABLE(other3payname);
						if(!(tmp[11]+"").equals("null"))
						{
							pd.setOTHER3_PAY(tmp[11]+"");
						}
					}
										
					pd.setPROP_PAY((BigDecimal)tmp[12]);
					BigDecimal avgpaydrwnobj=new BigDecimal(averageemolamount);
					pd.setAVGPAYDRWAN(avgpaydrwnobj);
					retn.add(pd);			
		         }
				
		 con.commit(); 
		   }	
		catch (Exception e) {
				e.printStackTrace();			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		
		return retn;
	}
	
	
		
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeFormAssPenGratuity3Details(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG3DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG3DetailsDao>();
		try
		   {
		        con=session.connection();	
		        String sqlQry="select " +
		        		"mstform1.PENSION_AMOUNT," +
		        		"mstform1.DCRG_AMOUNT," +
		        		"to_date(mstform1.DATE_OF_RETIRE+1,'DD/MM/YY') AS RETDATE," +
						"to_date(mstform1.DATE_OF_VRS+1,'DD/MM/YY') AS VRSDATE," +
						"to_date(mstform1.DEATH_DATE+1,'DD/MM/YY') AS DEATHDATE," +
		        		"mstform2.EMP_HEIGHT," +
		        		"mstform2.ID_MARK1," +
		        		"mstform2.ID_MARK2, " +
		        		"offi.office_name " +
		        		"FROM HRM_PEN_APP_MST_FORM1_DET mstform1 " +
		        		"left outer join HRM_PEN_APP_MST_FORM2 mstform2 on mstform2.EMP_NO=mstform1.EMP_ID " +
		        		"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.PAYMENT_OFFICE_ID " +
		        		"where mstform1.EMP_ID="+empId;
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
										
					penAppFieldOfficeDCRG3DetailsDao mainpd=new penAppFieldOfficeDCRG3DetailsDao();
									 
					mainpd.setPENSION_AMOUNT((BigDecimal) tmp[0]);
					mainpd.setDCRG_AMOUNT((BigDecimal) tmp[1]);					
					mainpd.setRETDATE((Date) tmp[2]);
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRETDATE((Date) tmp[3]);
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRETDATE((Date) tmp[4]);
					}
					mainpd.setEMP_HEIGHT(tmp[5]+"");
					mainpd.setID_MARK1(tmp[6]+"");
					mainpd.setID_MARK2(tmp[7]+"");
				    mainpd.setPAYMENT_OFFICE(tmp[8]+"");
					
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG3DetailsDao> getFieldOfficeNomineeDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG3DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG3DetailsDao>();
		try
		   {
		        con=session.connection();	
		        String sqlQry="SELECT emp_no," +
		        		"nominee_id," +
		        		"nominee_initial," +
		        		"nominee_name," +
		        		"relationship_id," +
		        		"dob," +
		        		"age," +
		        		"handicapped," +
		        		"marital_status," +
		        		"nomination_date," +
		        		"active_status," +
		        		"reason " +
		        		"FROM HRM_PEN_APP_MST_FORM2_NOMIN " +
		        		"where emp_no="+empId;
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] obj:mainli)
				{
														
					penAppFieldOfficeDCRG3DetailsDao nomObj=new penAppFieldOfficeDCRG3DetailsDao();
										
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
					else if(Integer.parseInt(obj[4]+"")==4)
					{
						nomObj.setRELATIONSHIP_ID("Spouse");
					}
					else if(Integer.parseInt(obj[4]+"")==5)
					{
						nomObj.setRELATIONSHIP_ID("Son");
					}
					else if(Integer.parseInt(obj[4]+"")==6)
					{
						nomObj.setRELATIONSHIP_ID("Daughter");
					}
					/*else
					{
						nomObj.setRELATIONSHIP_ID("Daughter");
					}*/
					
					//nomObj.setRELATIONSHIP_ID(obj[4]+"");
					nomObj.setDOB((Date)obj[5]);
					nomObj.setAGE((BigDecimal)obj[6]);
					
					if(obj[7]!="" && obj[7].equals("Y"))					
						nomObj.setHANDICAPPED("Yes");
					else
						nomObj.setHANDICAPPED("No");
					
					nomObj.setMARITAL_STATUS(obj[8]+"");
					nomObj.setNOMINATION_DATE((Date)obj[9]);
					nomObj.setACTIVE_STATUS(obj[10]+"");
					if(!(obj[11]+"").equalsIgnoreCase("null"))
					{
					nomObj.setREASON(obj[11]+"");
					}
					
					
					mainretn.add(nomObj);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeDetailsOfFamily(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG3DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG3DetailsDao>();
		try
		   {
		        con=session.connection();	
		       		        
		        
		        /*String sqlQry="select mstform2.EMP_NAME," +
		        		"desi.DESIGNATION," +
		        		"mstform1.DATE_OF_BIRTH," +
		        		"serv.DATE_FROM," +
		        		"serv.DATE_FROM_SESSION " +
		        		"from HRM_PEN_APP_MST_FORM2 mstform2 " +
		        		"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
		        		"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
		        		"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID=mstform1.emp_id " +
		        		"where serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID= mstform1.EMP_ID) " +
		        		"and mstform1.EMP_ID="+empId;
		        */
		        String sqlQry="select mstform1.EMP_NAME," +
        		"desi.DESIGNATION," +
        		"mstform1.DATE_OF_BIRTH," +
        		"serv.DATE_FROM," +
        		"serv.DATE_FROM_SESSION " +
        		"from HRM_PEN_APP_MST_FORM2 mstform2 " +
        		"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
        		"left outer join HRM_EMP_CURRENT_POSTING post on post.EMPLOYEE_ID=mstform1.emp_id "+
        		"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=post.DESIGNATION_ID " +
        		"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID=mstform1.emp_id " +
        		"where serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID= mstform1.EMP_ID) " +
        		"and mstform1.EMP_ID="+empId;
        
		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
										
					penAppFieldOfficeDCRG3DetailsDao mainpd=new penAppFieldOfficeDCRG3DetailsDao();
									 
					mainpd.setEMP_NAME(tmp[0]+"");
					mainpd.setDESIGNATION(tmp[1]+"");
					mainpd.setDATE_OF_BIRTH((Date) tmp[2]);
					mainpd.setDATE_FROM((Date) tmp[3]);
					mainpd.setDATE_FROM_SESSION(tmp[4]+"");
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDCRG3DetailsDao> getPenAppFieldOfficeNoDueCertificate(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDCRG3DetailsDao> mainretn=new ArrayList<penAppFieldOfficeDCRG3DetailsDao>();
		try
		   {
		        con=session.connection();	
		       		        
		        
		       /* String sqlQry="select mstform2.EMP_NAME, " +
				"mstform2.GENDER, "+
				"mstform2.HUSBAND_NAME, "+
				"desi.DESIGNATION, "+
				"offi.office_name "+
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +						
				"left outer join hrm_mst_designations desi ON desi.designation_id = mstform2.desig_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;*/
		        
		        String sqlQry="select mstform1.EMP_NAME, " +
				"mstform2.GENDER, "+
				"mstform2.HUSBAND_NAME, "+
				"desi.DESIGNATION, "+
				"offi.office_name "+
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_EMP_CURRENT_POSTING post on post.EMPLOYEE_ID=mstform1.emp_id "+
				"left outer join hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;
		        
		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
										
					penAppFieldOfficeDCRG3DetailsDao mainpd=new penAppFieldOfficeDCRG3DetailsDao();
									

					String designation="";
					String last_working_office="";
					String employeename=tmp[0]+"";
					String pre_name="";
					if((tmp[1]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					if((tmp[1]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[2]+"").equalsIgnoreCase("null"))
						{
							pre_name="Tmt ";
						}
						else
						{
							pre_name="Selvi ";
						}
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						designation=tmp[3]+"";
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						last_working_office=tmp[4]+"";
					}
					mainpd.setEMP_NAME(pre_name+employeename+", "+designation+", ");	
					mainpd.setPAYMENT_OFFICE("Twad Board, "+last_working_office);
					
					
					mainretn.add(mainpd);	
					
				}	 
			
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<pensionCalcDetailsDao> getFieldOfficeRecoveryDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionCalcDetailsDao> recretn=new ArrayList<pensionCalcDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
		        
		        int sumofrec=0;     
		          
		        
		        
		        String sqlQryforsumofrec="select rec.REC_AMOUNT,rec.REC_DESC from HRM_PEN_APP_MST_RECO_FORM1 rec where rec.EMP_ID="+empId;		
				
				
				List<Object[]> recsumli=session.createSQLQuery(sqlQryforsumofrec).list();
				for(Object[] recsumtmp:recsumli)
				{
					sumofrec=sumofrec+Integer.parseInt(recsumtmp[0]+"");			
				}
		        
		        
				
				String sqlQry="select rec.REC_ID,rec.REC_DESC,rec.REC_AMOUNT from HRM_PEN_APP_MST_RECO_FORM1 rec where rec.EMP_ID="+empId;
				
				List<Object[]> recli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:recli)
				{
					pensionCalcDetailsDao recpd=new pensionCalcDetailsDao();
					
					recpd.setREC_ID((BigDecimal)tmp[0]);
					recpd.setREC_DESC(tmp[1]+"");
					recpd.setREC_AMOUNT((BigDecimal)tmp[2]);
					BigDecimal recobj=new BigDecimal(sumofrec);
					recpd.setRECOVERY_TOTAL_AMOUNT(recobj);
					recretn.add(recpd);			
		         }				
		 con.commit();        	
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		return recretn;
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	public class constNumtoLetter
	{
	    String[] unitdo ={"", " One", " Two", " Three", " Four", " Five",
	       " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
	       " Thirteen", " Fourteen", " Fifteen",  " Sixteen", " Seventeen", 
	       " Eighteen", " Nineteen"};
	    String[] tens =  {"", "Ten", " Twenty", " Thirty", " Forty", " Fifty",
	       " Sixty", " Seventy", " Eighty"," Ninety"};
	    String[] digit = {"", " Hundred", " Thousand", " Lakh", " Crore"};
	   int r;


	    //Count the number of digits in the input number
	    int numberCount(int num)
	    {
	        int cnt=0;

	        while (num>0)
	        {
	          r = num%10;
	          cnt++;
	          num = num / 10;
	        }

	          return cnt;
	    }


	    //Function for Conversion of two digit

	    String twonum(int numq)
	    {
	         int numr, nq;
	         String ltr="";

	         nq = numq / 10;
	         numr = numq % 10;

	         if (numq>19)
	           {
	         ltr=ltr+tens[nq]+unitdo[numr];
	           }
	         else
	           {
	         ltr = ltr+unitdo[numq];
	           }

	         return ltr;
	    }

	    //Function for Conversion of three digit

	    String threenum(int numq)
	    {
	           int numr, nq;
	           String ltr = "";

	           nq = numq / 100;
	           numr = numq % 100;

	           if (numr == 0)
	            {
	            ltr = ltr + unitdo[nq]+digit[1];
	             }
	           else
	            {
	            ltr = ltr +unitdo[nq]+digit[1]+" and"+twonum(numr);
	            }
	           return ltr;

	    }
	    
	    
	    
	    String rupess_to_word(int pensionamount)
	    {
	    	
	    	int len, q=0, r=0;
	        String ltr = " ";
	        String Str = "(Rupees";
	        int num=pensionamount;
	         
	        
	        if (num <= 0) Str="Zero or Negative number not for conversion."; //System.out.println("Zero or Negative number not for conversion");

	        while (num>0)
	        {

	           
	        	len=numberCount(num);

	           //Take the length of the number and do letter conversion

	           switch (len)

	           {
	                case 8:
	                        q=num/10000000;
	                        r=num%10000000;	                        
	                        ltr = twonum(q);	                        
	                        Str = Str+ltr+digit[4];
	                        num = r;
	                        break;

	                case 7:
	                case 6:
	                        q=num/100000;
	                        r=num%100000;	                        
	                        ltr = twonum(q);
	                        Str = Str+ltr+digit[3];
	                        num = r;
	                        break;

	                case 5:
	                case 4:

	                         q=num/1000;
	                         r=num%1000;
	                         ltr = twonum(q);
	                         Str= Str+ltr+digit[2];
	                         num = r;
	                         break;

	                case 3:


	                          if (len == 3)
	                              r = num;
	                          ltr = threenum(r);
	                          Str = Str + ltr;
	                          num = 0;
	                          break;

	                case 2:

	                         ltr = twonum(num);
	                         Str = Str + ltr;
	                         num=0;
	                         break;

	                case 1:
	                         Str = Str + unitdo[num];
	                         num=0;
	                         break;
	                default:

	                        num=0;
	                        System.out.println("Exceeding Crore....No conversion");
	                        System.exit(1);


	            }
	                        if (num==0)
	                        Str=Str+" Only).";
	          }       
	        
	        
	        return Str;     
	    	
	    }
	    
	    
	    
	    
	    

	}
	
	
	
	
	
	

	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	

}





