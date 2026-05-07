package com.nic.hrms.pension.reports.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.reports.service.PensionApplicationFeildOfficeReportSearchService;


public class PensionApplicationFieldOfficeReportSearchDaoImpl implements PensionApplicationFeildOfficeReportSearchService {
	
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	public List<Object[]> penAppFieldOfficeReportUserSearch(String penappreportSearchOptions,String penappreportSearchKeyword,int empId ) {
		List<Object[]> list=null;
		
		//searching for emp_no
		if(penappreportSearchOptions.equals("2"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 /*String str="SELECT emp.employee_id," +
				 		"emp.employee_name," +
				 		"app.process_status, " +
				 		"app.PENSION_TYPE " +
				 		"FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
				 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
				 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM2 appform2 ON app.emp_id = appform2.EMP_NO " +
				 		"WHERE post.employee_id IN " +
				 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
				 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
				 		"AND emp.employee_id IN " +
				 		"(SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET WHERE process_status = 'VALIDATE') " +
				 		"AND appform2.EMP_NO IN " +
				 		"(SELECT EMP_NO FROM HRM_PEN_APP_MST_FORM2 WHERE process_status = 'VALIDATE') " +
				 		"AND (lower(emp.employee_id) LIKE '%"+penappreportSearchKeyword+"%')";*/
				 
				 
				 String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.process_status, " +
			 		"app.PENSION_TYPE " +
			 		"FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM2 appform2 ON app.emp_id = appform2.EMP_NO " +
			 		"WHERE (post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"OR post.employee_id IN (" +
			 		"SELECT employee_id FROM hrm_emp_current_posting WHERE employee_id NOT IN (" +
			 		"SELECT employee_id FROM hrm_emp_controlling_office) AND CAST(employee_id AS TEXT)LIKE '%"+penappreportSearchKeyword+"%')) "+
			 		"AND emp.employee_id IN " +
			 		"(SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET WHERE process_status = 'VALIDATE') " +
			 		"AND appform2.EMP_NO IN " +
			 		"(SELECT EMP_NO FROM HRM_PEN_APP_MST_FORM2 WHERE process_status = 'VALIDATE') " +
			 		"AND (lower(CAST(emp.employee_id AS TEXT)) LIKE '%"+penappreportSearchKeyword+"%')";
				 
				 
				 
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        /*for(Object[] tl: list)
				 {
					Object[] temp=tl;
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+temp[0]+"\t"+temp[1]+"\t"+temp[2]);						
				 }	*/				
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		///searching for pensioner_name
		if(penappreportSearchOptions.equals("3"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				/* String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.process_status, " +
			 		"app.PENSION_TYPE " +
			 		"FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM2 appform2 ON app.emp_id = appform2.EMP_NO " +
			 		"WHERE post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"AND emp.employee_id IN " +
			 		"(SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET WHERE process_status = 'VALIDATE') " +
			 		"AND appform2.EMP_NO IN " +
			 		"(SELECT EMP_NO FROM HRM_PEN_APP_MST_FORM2 WHERE process_status = 'VALIDATE') " +
			 		"AND (lower(emp.employee_name) LIKE '%"+penappreportSearchKeyword+"%')";*/
				 
				 
				 
				 
				 
				 String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.process_status, " +
			 		"app.PENSION_TYPE " +
			 		"FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM2 appform2 ON app.emp_id = appform2.EMP_NO " +
			 		"WHERE (post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"OR post.employee_id IN (" +
			 		"SELECT employee_id FROM hrm_emp_current_posting WHERE employee_id NOT IN (" +
			 		"SELECT employee_id FROM hrm_emp_controlling_office) AND employee_id IN (" +
			 		"SELECT employee_id FROM hrm_mst_employees WHERE lower(CAST(employee_name AS TEXT)) LIKE '%"+penappreportSearchKeyword.toLowerCase()+"%')))"+
			 		"AND emp.employee_id IN " +
			 		"(SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET WHERE process_status = 'VALIDATE') " +
			 		"AND appform2.EMP_NO IN " +
			 		"(SELECT EMP_NO FROM HRM_PEN_APP_MST_FORM2 WHERE process_status = 'VALIDATE') " +
			 		"AND (lower(CAST(emp.employee_name AS TEXT)) LIKE '%"+penappreportSearchKeyword.toLowerCase()+"%')";
				 
				 
				 
				 
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        /*for(Object[] tl: list)
				 {
					Object[] temp=tl;
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+temp[0]+"\t"+temp[1]+"\t"+temp[2]);					
				 }		*/			
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		
			return list;	
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> penAppFieldOfficeReportUserSearch1(String penappreportSearchKeyword,int empId ) {
		List<Object[]> list=null;		
		
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				/* String str="SELECT emp.employee_id," +
				 		"emp.employee_name," +
				 		"app.process_status, " +
				 		"app.PENSION_TYPE " +
				 		"FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
				 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
				 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM2 appform2 ON app.emp_id = appform2.EMP_NO " +
				 		"WHERE post.employee_id IN " +
				 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
				 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
				 		"AND emp.employee_id IN " +
				 		"(SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET WHERE process_status = 'VALIDATE') " +
				 		"AND appform2.EMP_NO IN " +
				 		"(SELECT EMP_NO FROM HRM_PEN_APP_MST_FORM2 WHERE process_status = 'VALIDATE') " +
				 		"AND emp.employee_id="+penappreportSearchKeyword;*/
				 
				 
				 String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.process_status, " +
			 		"app.PENSION_TYPE " +
			 		"FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_MST_FORM2 appform2 ON app.emp_id = appform2.EMP_NO " +
			 		"WHERE (post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"OR post.employee_id IN (" +
			 		"SELECT employee_id FROM hrm_emp_current_posting WHERE employee_id NOT IN (" +
			 		"SELECT employee_id FROM hrm_emp_controlling_office) AND employee_id = "+penappreportSearchKeyword+")) "+
			 		"AND emp.employee_id IN " +
			 		"(SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET WHERE process_status = 'VALIDATE') " +
			 		"AND appform2.EMP_NO IN " +
			 		"(SELECT EMP_NO FROM HRM_PEN_APP_MST_FORM2 WHERE process_status = 'VALIDATE') " +
			 		"AND emp.employee_id="+penappreportSearchKeyword;
				 
				 
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        /*for(Object[] tl: list)
				 {
					Object[] temp=tl;
					System.out.println("Onchange field office report user search query>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+temp[0]+"\t"+temp[1]+"\t"+temp[2]);						
				 }	*/				
			}
			catch(Exception e){
					e.printStackTrace();
				}		
		
			return list;	
	}
	
	
	
	
	
	
	
	
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		
		
		
		
				
	}
