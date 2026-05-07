package com.nic.hrms.pension.reports.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.reports.service.RevisedDCRGPensionOrderAuthorisationReportSearchService;


public class RevisedDCRGPensionOrderAuthorisationReportSearchDaoImpl implements RevisedDCRGPensionOrderAuthorisationReportSearchService {
	
	private SessionFactory sessionFactory;

	
		
	@SuppressWarnings("unchecked")
	public List<Object[]> revisedDCRGPenOrderAuthorisationReportUserSearch(int empId ) {
		List<Object[]> list=null;		
		
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 /*String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.PENSION_TYPE " +
			 		"FROM HRM_PEN_APP_AUTHORIZATION_ORG autho " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON autho.emp_no = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM2_DET appform2 ON app.emp_id = appform2.EMP_NO " +			 		
			 		"WHERE (lower(emp.employee_name) LIKE '%"+penappreportSearchKeyword+"%')";*/	 
				 
				 	/*String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.PENSION_TYPE " +
			 		"FROM hrm_mst_employees emp " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM2_DET appform2 ON app.emp_id = appform2.EMP_NO " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_AUTHORIZATION_ORG autho ON app.emp_id = autho.EMP_NO " +
			 		"WHERE emp.employee_id="+empId;*/
				 
				    /*String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.PENSION_TYPE " +
			 		"FROM hrm_mst_employees emp " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM2_DET appform2 ON app.emp_id = appform2.EMP_NO " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_AUTHORIZATION_ORG autho ON app.emp_id = autho.EMP_NO " +
			 		"WHERE emp.employee_id IN (SELECT DISTINCT(emp_id) FROM hrm_pen_app_revised_pen_det " +
			 		"WHERE revised_reason = 'DUE TO DA CHANGE') " +
			 		"AND emp.employee_id IN (SELECT DISTINCT(emp_no) FROM hrm_pen_rev_auth_org_hist " +
			 		"WHERE rev_reason = 'DUE TO DA CHANGE') " +
			 		"AND app.death_date IS NULL " +
			 		"AND emp.employee_id="+empId;*/
				    
				    
				    String str="SELECT emp.employee_id," +
				    		"emp.employee_name," +
				    		"app.pension_type " +
				    		"FROM HRM_PEN_APP_REV_AUTH_ORG revpen " +
				    		" left outer join hrm_mst_employees emp " +
				    		" ON revpen.emp_no = emp.employee_id " +
				    		" LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det app " +
				    		" ON app.emp_id = emp.employee_id " +
				    		" left outer join hrm_pen_app_revised_pen_det rev " +
				    		" on revpen.emp_no=rev.emp_id " +
				    		" where  " +
				    		" revpen.process_status='Final' " +
				    		" and rev.revised_reason='DUE TO DA CHANGE' " +
				    		" and rev.updated_date=(select max(updated_date) from " +
				    		" hrm_pen_app_revised_pen_det where emp_id=rev.emp_id) " +
				    		" AND app.death_date IS NULL AND revpen.emp_no="+empId;
				 
				 
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        			
			}
			catch(Exception e){
					e.printStackTrace();
				}		
		
			return list;	
	}
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> revDCRGPenOrderAuthorisationReportUserSearch1(String penappreportSearchOptions,String penappreportSearchKeyword,int empId ) {
		List<Object[]> list=null;
		
		//searching for emp_no
		if(penappreportSearchOptions.equals("1"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
								 
				 		/* String str="SELECT emp.employee_id,emp.employee_name,app.pension_type FROM hrm_pen_app_authorization_org autho " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON autho.emp_no = emp.employee_id " +
				 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det app ON app.emp_id = emp.employee_id " +
				 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det appform2 ON app.emp_id = appform2.emp_no " +
				 		"WHERE(LOWER(emp.employee_id) LIKE '%7%') " +
				 		"AND emp.employee_id IN (SELECT DISTINCT(emp_id) FROM hrm_pen_app_revised_pen_det " +
				 		"WHERE revised_reason = 'DUE TO DA CHANGE') " +
				 		"AND emp.employee_id IN (SELECT DISTINCT(emp_no) FROM hrm_pen_rev_auth_org_hist " +
				 		"WHERE rev_reason = 'DUE TO DA CHANGE')";*/
				 
				    /*String str="SELECT emp.employee_id,emp.employee_name,app.pension_type FROM hrm_pen_app_authorization_org autho " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON autho.emp_no = emp.employee_id " +
			 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det appform2 ON app.emp_id = appform2.emp_no " +
			 		"WHERE emp.employee_id IN (SELECT DISTINCT(emp_id) FROM hrm_pen_app_revised_pen_det " +
			 		"WHERE revised_reason = 'DUE TO DA CHANGE') " +
			 		"AND (LOWER(emp.employee_id) LIKE '%"+penappreportSearchKeyword+"%')";*/
				 
				 	/*String str="SELECT emp.employee_id,emp.employee_name,app.pension_type FROM hrm_pen_app_authorization_org autho " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON autho.emp_no = emp.employee_id " +
			 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det appform2 ON app.emp_id = appform2.emp_no " +
			 		"WHERE emp.employee_id IN (SELECT DISTINCT(emp_id) FROM hrm_pen_app_revised_pen_det " +
			 		"WHERE revised_reason = 'DUE TO DA CHANGE') " +
			 		"AND emp.employee_id IN (SELECT DISTINCT(emp_no) FROM hrm_pen_rev_auth_org_hist " +
			 		"WHERE rev_reason = 'DUE TO DA CHANGE') " +
			 		"AND (LOWER(emp.employee_id) LIKE '%"+penappreportSearchKeyword+"%') " +
			 		"AND app.death_date IS NULL";
				 	*/
				 	
				 
				 String str="SELECT emp.employee_id," +
		    		"emp.employee_name," +
		    		"app.pension_type " +
		    		"FROM HRM_PEN_APP_REV_AUTH_ORG revpen " +
		    		" left outer join hrm_mst_employees emp " +
		    		" ON revpen.emp_no = emp.employee_id " +
		    		" LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det app " +
		    		" ON app.emp_id = emp.employee_id " +
		    		" left outer join hrm_pen_app_revised_pen_det rev " +
		    		" on revpen.emp_no=rev.emp_id " +
		    		" where  " +
		    		" revpen.process_status='Final' " +
		    		" and rev.revised_reason='DUE TO DA CHANGE' " +
		    		" and rev.updated_date=(select max(updated_date) from " +
		    		" hrm_pen_app_revised_pen_det where emp_id=rev.emp_id) " +
		    		"AND (LOWER(emp.employee_id) LIKE '%"+penappreportSearchKeyword+"%') " +
		    		" AND app.death_date IS NULL ";
				 
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	       		
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		///searching for employee_name
		if(penappreportSearchOptions.equals("2"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				
				 
				 
				 /*String str="SELECT emp.employee_id," +
			 		"emp.employee_name," +
			 		"app.PENSION_TYPE " +
			 		"FROM HRM_PEN_APP_AUTHORIZATION_ORG autho " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON autho.emp_no = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM1_DET app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_FORM2_DET appform2 ON app.emp_id = appform2.EMP_NO " +			 		
			 		"WHERE (lower(emp.employee_name) LIKE '%"+penappreportSearchKeyword+"%')";*/
				 
				/* String str="SELECT emp.employee_id,emp.employee_name,app.pension_type FROM hrm_pen_app_authorization_org autho " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON autho.emp_no = emp.employee_id " +
			 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det app ON app.emp_id = emp.employee_id " +
			 		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det appform2 ON app.emp_id = appform2.emp_no " +
			 		"WHERE emp.employee_id IN (SELECT DISTINCT(emp_id) FROM hrm_pen_app_revised_pen_det " +
			 		"WHERE revised_reason = 'DUE TO DA CHANGE') " +
			 		"AND emp.employee_id IN (SELECT DISTINCT(emp_no) FROM hrm_pen_rev_auth_org_hist " +
			 		"WHERE rev_reason = 'DUE TO DA CHANGE') " +
			 		"AND (LOWER(emp.employee_name) LIKE '%"+penappreportSearchKeyword.toLowerCase()+"%') " +
			 		"AND app.death_date IS NULL";*/
				 
				 String str="SELECT emp.employee_id," +
		    		"emp.employee_name," +
		    		"app.pension_type " +
		    		"FROM HRM_PEN_APP_REV_AUTH_ORG revpen " +
		    		" left outer join hrm_mst_employees emp " +
		    		" ON revpen.emp_no = emp.employee_id " +
		    		" LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det app " +
		    		" ON app.emp_id = emp.employee_id " +
		    		" left outer join hrm_pen_app_revised_pen_det rev " +
		    		" on revpen.emp_no=rev.emp_id " +
		    		" where  " +
		    		" revpen.process_status='Final' " +
		    		" and rev.revised_reason='DUE TO DA CHANGE' " +
		    		" and rev.updated_date=(select max(updated_date) from " +
		    		" hrm_pen_app_revised_pen_det where emp_id=rev.emp_id) " +
		    		"AND (LOWER(emp.employee_name) LIKE '%"+penappreportSearchKeyword.toLowerCase()+"%') " +
		    		" AND app.death_date IS NULL ";
				 
				 
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	       
				 
				 
				 
				 
				 			
			}
			catch(Exception e){
					e.printStackTrace();
				}
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
