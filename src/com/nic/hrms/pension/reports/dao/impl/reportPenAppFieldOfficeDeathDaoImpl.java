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
import com.nic.hrms.pension.reports.model.penAppFieldOfficeDeathDetailsDao;
import com.nic.hrms.pension.reports.model.pensionCalcDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.service.reportPenAppFieldOfficeDeathService;

public class reportPenAppFieldOfficeDeathDaoImpl implements reportPenAppFieldOfficeDeathService{

	private SessionFactory sessionFactory;

	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathForm12Details(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDeathDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDeathDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 
				String pensiontype="";
				String classofpensionstring="";
				String comopted="";
				String empInitial="";
				String empName="";
				String sqlQry="SELECT emp.employee_initial," +
						"emp.employee_name," +
						"emp.gender," +
						"desi.designation," +
						"offi.office_name," +
						"fammstform2.claiment_name," +
						"fammstform2.claiment_dob," +
						"fammstform2.claiment_age," +
						"fammstform2.guardian_name," +
						"fammstform2.guardian_dob," +
						"fammstform2.guardian_relation_minor," +
						"fammstform2.guardian_relation_emp," +
						"fammstform2.employee_death_date," +
						"fammstform2.address " +
						"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON post.employee_id = fammstform2.emp_no " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = fammstform2.pension_pay_office_id " +
						"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"WHERE fammstform2.emp_no = "+empId;				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDeathDetailsDao mainpd=new penAppFieldOfficeDeathDetailsDao();
					if(!(tmp[0]+"").equalsIgnoreCase("null"))
					{
						empInitial=tmp[0]+".";
					}
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						empName=tmp[1]+"";
					}
					mainpd.setEMP_NAME(empInitial+empName);
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
					mainpd.setPAYMENT_OFFICE(tmp[4]+"");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
					mainpd.setCLAIMENTNAME(tmp[5]+"");
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
					mainpd.setCLAIMENT_DATE_OF_BIRTH((Date) tmp[6]);
					}
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
					mainpd.setCLAIMENT_AGE((BigDecimal) tmp[7]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_NAME(tmp[8]+"");
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_DATE_OF_BIRTH((Date) tmp[9]);
					}
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_RELATION_EMP(tmp[10]+"");
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_RELATION_MINOR(tmp[11]+"");
					}
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDATE_OF_DEATH((Date)tmp[12]);
					}
					if(!(tmp[13]+"").equalsIgnoreCase("null"))
					{
					mainpd.setADDRESS(tmp[13]+"");
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
	public List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathForm14Details(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDeathDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDeathDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 
				String pensiontype="";
				String classofpensionstring="";
				String comopted="";
				String empInitial="";
				String empName="";
				String sqlQry="SELECT emp.employee_initial," +
						"emp.employee_name," +
						"emp.gender," +
						"desi.designation," +
						"offi.office_name," +
						"fammstform2.claiment_name," +
						"fammstform2.claiment_dob," +
						"fammstform2.claiment_age," +
						"fammstform2.guardian_name," +
						"fammstform2.guardian_dob," +
						"fammstform2.guardian_relation_minor," +
						"fammstform2.guardian_relation_emp," +
						"fammstform2.employee_death_date," +
						"fammstform2.address " +
						"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON post.employee_id = fammstform2.emp_no " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = fammstform2.pension_pay_office_id " +
						"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"WHERE fammstform2.emp_no = "+empId;				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDeathDetailsDao mainpd=new penAppFieldOfficeDeathDetailsDao();
					if(!(tmp[0]+"").equalsIgnoreCase("null"))
					{
						empInitial=tmp[0]+".";
					}
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						empName=tmp[1]+"";
					}
					mainpd.setEMP_NAME(empInitial+empName);
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
					mainpd.setPAYMENT_OFFICE(tmp[4]+"");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
					mainpd.setCLAIMENTNAME(tmp[5]+"");
					//mainpd.setEMP_NAME(tmp[5]+"");
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
					mainpd.setCLAIMENT_DATE_OF_BIRTH((Date) tmp[6]);
					}
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
					mainpd.setCLAIMENT_AGE((BigDecimal) tmp[7]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_NAME(tmp[8]+"");
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_DATE_OF_BIRTH((Date) tmp[9]);
					}					
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_RELATION_MINOR(tmp[10]+"");
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
					mainpd.setGUARDIAN_RELATION_EMP(tmp[11]+"");
					}
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDATE_OF_DEATH((Date)tmp[12]);
					}
					if(!(tmp[13]+"").equalsIgnoreCase("null"))
					{
					mainpd.setADDRESS(tmp[13]+"");
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
	public List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathSpecSignDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDeathDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDeathDetailsDao>();
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
						"offi.office_name, " +
						"fammstform2.claiment_name " +		        		
						"from HRM_PEN_APP_FAM_MST_DET_FORM2 fammstform2 " +
						"left outer join HRM_PEN_APP_MST_FORM2 mstform2 on mstform2.emp_no=fammstform2.emp_no " +
						"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
						"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
						"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
						"where mstform1.EMP_ID="+empId;		*/
				String empInitial="";
				String empName="";
				
				String sqlQry="SELECT emp.employee_initial," +
						"emp.employee_name," +
						"emp.gender," +
						"desi.designation," +
						"offi.office_name," +
						"fammstform2.claiment_name " +
						"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON post.employee_id = fammstform2.emp_no  " +
						"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = fammstform2.pension_pay_office_id	" +
						"WHERE fammstform2.emp_no ="+ empId;
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDeathDetailsDao mainpd=new penAppFieldOfficeDeathDetailsDao();				
									
					String pre_name="";
					String employeename=tmp[1]+"";
					String designation=tmp[3]+"";
					
					
					if(!(tmp[0]+"").equalsIgnoreCase("null"))
					{
						empInitial=tmp[0]+".";
					}
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						empName=tmp[1]+"";
					}
					//mainpd.setEMP_NAME(empInitial+empName);
					
					if((tmp[2]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					if((tmp[2]+"").equalsIgnoreCase("F"))
					{					
							pre_name="Tmt ";						
					}
					
					/*if((tmp[2]+"").equalsIgnoreCase("M"))
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
					}*/
					mainpd.setCLAIMENTNAME(tmp[5]+"");
					//mainpd.setEMP_NAME(pre_name+employeename+", "+designation+",");
					mainpd.setEMP_NAME(pre_name+empInitial+empName+", "+designation);
					mainpd.setPAYMENT_OFFICE(tmp[4]+", TWAD Board.");				
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
	public List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathDescRollDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDeathDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDeathDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
		        String empInitial="";
		        String empName="";
		        String sqlQry="SELECT emp.employee_initial," +
				"emp.employee_name," +
				"emp.gender," +
				"desi.designation," +
				"offi.office_name," +
				"fammstform2.claiment_name," +
				"fammstform2.claiment_dob," +
				"fammstform2.claiment_age," +
				"fammstform2.guardian_name," +
				"fammstform2.guardian_dob," +
				"fammstform2.guardian_relation_minor," +
				"fammstform2.guardian_relation_emp," +
				"fammstform2.employee_death_date," +
				"fammstform2.address, " +
				"fammstform2.id_mark1, " +
				"fammstform2.id_mark2, " +
				"fammstform2.height " +
				"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
				"LEFT OUTER JOIN hrm_emp_current_posting post ON post.employee_id = fammstform2.emp_no " +
				"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = fammstform2.pension_pay_office_id " +
				"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
				"WHERE fammstform2.emp_no = "+empId;				
		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDeathDetailsDao mainpd=new penAppFieldOfficeDeathDetailsDao();
					if(!(tmp[0]+"").equalsIgnoreCase("null"))
					{
						empInitial=tmp[0]+".";
					}
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						empName=tmp[1]+"";
					}
					mainpd.setEMP_NAME(empInitial+empName);
					mainpd.setCLAIMENTNAME(tmp[5]+"");
					mainpd.setDATE_OF_BIRTH((Date) tmp[6]);
					if(!(tmp[16]+"").equalsIgnoreCase("null"))
					{
					mainpd.setEMP_HEIGHT(tmp[16]+"");
					}
					if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
					mainpd.setID_MARK1(tmp[14]+"");
					}
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
					mainpd.setID_MARK2(tmp[15]+"");	
					}
					if(!(tmp[13]+"").equalsIgnoreCase("null"))
					{
					mainpd.setADDRESS(tmp[13]+"");
					}
					String pre_name="";
					String employeename=tmp[0]+"";
					String designation=tmp[3]+"";
					if((tmp[2]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					/*if((tmp[2]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[6]+"").equalsIgnoreCase("null"))
						{
							pre_name="Tmt ";
						}
						else
						{
							pre_name="Selvi ";
						}
					}*/
					if((tmp[2]+"").equalsIgnoreCase("F"))
					{						
							pre_name="Tmt ";												
					}
					mainpd.setEMP_NAME_TITLE(pre_name+empInitial+empName+", "+designation+",");
					mainpd.setPAYMENT_OFFICE(tmp[8]+", TWAD Board.");		
					mainpd.setGUARDIAN_RELATION_EMP(tmp[11]+"");
					
					
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
	public List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathConsLetDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDeathDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDeathDetailsDao>();
		List<Object[]> mainli=null;
		try
		   {
		        con=session.connection();	
		        
   
		       /* String sqlQry="select mstform2.EMP_NAME, " +
				"mstform2.EMP_NO, "+
				"desi.DESIGNATION, "+
				"offi.office_name "+
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +						
				"left outer join hrm_mst_designations desi ON desi.designation_id = mstform2.desig_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"left outer join HRM_PEN_APP_FAM_MST_DET_FORM2 fammstform2 on mstform1.emp_id=fammstform2.emp_no " +
				"where mstform1.EMP_ID="+empId;	*/
		        
		        String empInitial="";
		        String empName="";
		        String sqlQry="SELECT emp.employee_initial," +
		        		"emp.employee_name," +
		        		"desi.designation," +
		        		"offi.office_name " +
		        		"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
		        		"LEFT OUTER JOIN hrm_pen_app_mst_form1_det mstform1 ON mstform1.emp_id = fammstform2.emp_no " +
		        		"LEFT OUTER JOIN hrm_emp_current_posting post ON post.employee_id = fammstform2.emp_no " +
		        		"LEFT OUTER JOIN hrm_mst_employees emp ON fammstform2.emp_no = emp.employee_id " +
		        		"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		        		"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform1.office_id " +
		        		"WHERE fammstform2.emp_no ="+empId;

		        
				mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDeathDetailsDao mainpd=new penAppFieldOfficeDeathDetailsDao();
					String designation="";
					String last_working_office="";
					String employeename=tmp[0]+"";
					
					
					if(!(tmp[0]+"").equalsIgnoreCase("null"))
					{
						empInitial=tmp[0]+".";
					}
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						empName=tmp[1]+"";
					}					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						designation=tmp[2]+"";
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						last_working_office=tmp[3]+"";
					}
					mainpd.setEMP_NAME(empInitial+empName+", "+designation+", TWAD Board, "+last_working_office);
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
	public List<penAppFieldOfficeDetailsDao> getPenAppFieldOfficeDeathConsLetRecDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
 	
		       /* String sqlQry="select mstform2.EMP_NAME, " +
				"mstform2.EMP_NO, "+
				"desi.DESIGNATION, "+
				"offi.office_name "+
				"from HRM_PEN_APP_MST_FORM2 mstform2 " +
				"left outer join HRM_PEN_APP_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +						
				"left outer join hrm_mst_designations desi ON desi.designation_id = mstform2.desig_id " +
				"left outer join COM_MST_OFFICES offi on offi.OFFICE_ID=mstform2.OFFICE_ID " +
				"where mstform1.EMP_ID="+empId;			*/	
		        
		        String empInitial="";
		        String empName="";
		        String sqlQry="SELECT emp.employee_initial," +
		        		"emp.employee_name," +
		        		"desi.designation," +
		        		"offi.office_name " +
		        		"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
		        		"LEFT OUTER JOIN hrm_pen_app_mst_form1_det mstform1 ON mstform1.emp_id = fammstform2.emp_no " +
		        		"LEFT OUTER JOIN hrm_emp_current_posting post ON post.employee_id = fammstform2.emp_no " +
		        		"LEFT OUTER JOIN hrm_mst_employees emp ON fammstform2.emp_no = emp.employee_id " +
		        		"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		        		"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform1.office_id " +
		        		"WHERE fammstform2.emp_no ="+empId;

		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDetailsDao mainpd=new penAppFieldOfficeDetailsDao();

					String designation="";
					String last_working_office="";
					String employeename=tmp[0]+"";
					
					
					if(!(tmp[0]+"").equalsIgnoreCase("null"))
					{
						empInitial=tmp[0]+".";
					}
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						empName=tmp[1]+"";
					}
					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						designation=tmp[2]+"";
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						last_working_office=tmp[3]+"";
					}
					mainpd.setEMP_NAME(empInitial+empName+", "+designation+", TWAD Board, "+last_working_office);		
										
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
	public List<penAppFieldOfficeDeathDetailsDao> getPenAppFieldOfficeDeathFormOfDeclarationDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDeathDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDeathDetailsDao>();
		try
		   {
		        con=session.connection();	
		        		        
		        constNumtoLetter n = new constNumtoLetter();
		        int pensionamount = 0;
		        int dcrgpensionamount = 0;
				String pensiontypecontent="Super Annuation";
				String content="";
				String retiredate="";
				String claimentname="";
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				
		        
		        /*String sqlQry="SELECT mstform2.emp_no," +
		        		"mstform2.emp_name," +
		        		"mstform1.pension_type," +
		        		"mstform1.date_of_retire," +
		        		"mstform1.date_of_vrs," +
		        		"mstform1.death_date," +
		        		"mstform1.pension_amount," +
		        		"mstform1.dcrg_amount," +
		        		"desi.designation," +
		        		"offi.office_name," +
		        		"mstform2.gender," +
		        		"mstform2.husband_name, " +
		        		"fammstform2.claiment_name " +
		        		"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
		        		"LEFT OUTER JOIN hrm_pen_app_mst_form1_det mstform1 ON mstform1.emp_id = fammstform2.emp_no " +
		        		"LEFT OUTER JOIN hrm_pen_app_mst_form2 mstform2 ON fammstform2.emp_no = mstform2.emp_no " +
		        		"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = mstform2.desig_id " +
		        		"LEFT OUTER JOIN com_mst_state STA ON STA.state_code = mstform2.state " +
		        		"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.office_id " +
		        		"WHERE mstform1.emp_id = "+empId+" AND mstform1.death_date IS NOT NULL";		*/
				
				
				String empInitial="";
				String empName="";
				
				String sqlQry="SELECT emp.employee_initial," +
						"emp.employee_name," +
						"fammstform2.employee_death_date," +
						"mstform1.pension_amount," +
						"mstform1.dcrg_amount," +
						"desi.designation," +
						"offi.office_name," +
						"emp.gender," +
						"fammstform2.claiment_name " +
						"FROM hrm_pen_app_fam_mst_det_form2 fammstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_mst_form1_det mstform1 ON mstform1.emp_id = fammstform2.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON post.employee_id = fammstform2.emp_no " +
						"LEFT OUTER JOIN hrm_mst_employees emp ON fammstform2.emp_no = emp.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform1.office_id " +
						"WHERE mstform1.emp_id = "+empId+" AND mstform1.death_date IS NOT NULL";

		        
		        
		        
		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					penAppFieldOfficeDeathDetailsDao mainpd=new penAppFieldOfficeDeathDetailsDao();
					//mainpd.setEMP_NO((BigDecimal)tmp[0]);
					
					if(!(tmp[0]+"").equalsIgnoreCase("null"))
					{
						empInitial=tmp[0]+".";
					}
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						empName=tmp[1]+"";
					}
					//mainpd.setEMP_NAME(empInitial+empName);
					
					
					mainpd.setRETDATE((Date) tmp[2]);
					retiredate=formatter1.format(tmp[2]);
					mainpd.setPENSION_TYPE("Death");
					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRETDATE((Date) tmp[2]);
						mainpd.setPENSION_TYPE("Death");
						pensiontypecontent="Death";
						retiredate=formatter1.format(tmp[2]);
					}
					
					pensionamount=Integer.parseInt(tmp[3]+"");
					dcrgpensionamount=Integer.parseInt(tmp[4]+"");
					mainpd.setPENSION_AMOUNT((BigDecimal) tmp[3]);
					mainpd.setDCRG_AMOUNT((BigDecimal) tmp[4]);
					mainpd.setPENSION_AMOUNT_WORD(n.rupess_to_word(pensionamount));
					mainpd.setDCRG_AMOUNT_WORD(n.rupess_to_word(dcrgpensionamount));
					
					
					String designation="";
					String last_working_office="";
					String pre_name="";
					String employeename=tmp[1]+"";
					if((tmp[7]+"").equalsIgnoreCase("M"))
					{
						pre_name="Thiru ";
					}
					if((tmp[7]+"").equalsIgnoreCase("F"))
					{						
							pre_name="Tmt ";
						
					}
					//mainpd.setEMP_NAME(pre_name+employeename);
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						designation=tmp[5]+"";
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						last_working_office=tmp[6]+"";
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
						claimentname=tmp[8]+"";
					}
					mainpd.setCLAIMENTNAME(claimentname);
					//mainpd.setEMP_NAME(pre_name+employeename+" " +designation+", "+last_working_office);
					mainpd.setEMP_NAME(pre_name+empInitial+empName+", " +designation);
					//mainpd.setEMP_NAME(pre_name+employeename);					
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
	public List<penAppFieldOfficeDeathDetailsDao> getFieldOfficeDeathNomineeDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<penAppFieldOfficeDeathDetailsDao> mainretn=new ArrayList<penAppFieldOfficeDeathDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
		        
		        
		       String sqlQry="SELECT nomi.emp_no," +
		        		"nomi.nominee_id," +
		        		"nomi.nominee_initial," +
		        		"nomi.nominee_name," +
		        		"nomi.relationship_id," +
		        		"nomi.dob," +
		        		"nomi.age," +
		        		"nomi.handicapped," +
		        		"nomi.marital_status," +
		        		"nomi.nomination_date," +
		        		"nomi.active_status," +
		        		"nomi.address " +
		        		"FROM hrm_pen_app_fam_mst_nom_form2 nomi " +
		        		"LEFT OUTER JOIN hrm_pen_app_fam_mst_det_form2 fammstform2 ON nomi.emp_no = fammstform2.emp_no " +
		        		"WHERE nomi.emp_no = "+empId+" AND nomi.process_status = 'VALIDATE'";
		        
		        
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] obj:mainli)
				{
														
					penAppFieldOfficeDeathDetailsDao nomObj=new penAppFieldOfficeDeathDetailsDao();
										
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
						nomObj.setRELATIONSHIP_ID("Son");
					}	
					else
					{
						nomObj.setRELATIONSHIP_ID("Daughter");
					}
					
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
					nomObj.setADDRESS(obj[11]+"");
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
	
	
	
	
	
	class constNumtoLetter
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





