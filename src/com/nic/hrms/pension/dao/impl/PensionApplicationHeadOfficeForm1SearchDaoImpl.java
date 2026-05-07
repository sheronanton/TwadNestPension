	
	package com.nic.hrms.pension.dao.impl;
	
	import java.util.List;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.springframework.orm.hibernate3.SessionFactoryUtils;
	import com.nic.hrms.pension.service.PensionApplicationHeadOfficeForm1SearchService;
	
	
	public class PensionApplicationHeadOfficeForm1SearchDaoImpl implements PensionApplicationHeadOfficeForm1SearchService
	{
		
		private SessionFactory sessionFactory;
		
		
		@SuppressWarnings("unchecked")
		public List<Object[]> FetchPensionApplicationHeadOfficeForm1Search(String SearchScreenKeyword,String SearchScreenOptions, int empId) 
		{
			String options1="";
			String options2="";
			List<Object[]> list=null;
			
			
			if(SearchScreenOptions.equals("2"))
			{			
					options1="emp.employee_id";						
			}
			else if(SearchScreenOptions.equals("3"))
			{			
					options1="emp.employee_name";
					
			}
				
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction trans = null;
			
			try
			{			
				 trans = session.beginTransaction();				 			 
				 
				
				 
				 /*String str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"WHERE emp.employee_id NOT IN (SELECT emp_id FROM HRM_PEN_APP_HO_MST_FORM1_DET) " +
			 		"AND (lower("+options1+") LIKE '%"+SearchScreenKeyword+"%')";*/
				 
				 
				 
				 String str="SELECT emp.employee_id," +
				 		"emp.employee_name " +
				 		"FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"WHERE emp.employee_id NOT IN " +
				 		"(SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final') " +
				 		"AND(LOWER(CAST("+options1+" AS TEXT)) LIKE '%"+SearchScreenKeyword+"%')";
				 
				 
				 
				 Query query=session.createSQLQuery(str);
				 list=query.list();
				 trans.commit();   
			}
			catch(Exception e)
			{
					e.printStackTrace();
					
			}
			finally
			{
					SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
				
			return list;	
		}	
		
		
		
		
		
		
		
		
		
		@SuppressWarnings("unchecked")
		public List<Object[]> FetchPensionApplicationHeadOfficeForm1ValSearch(String SearchScreenKeyword,String SearchScreenOptions, int empId) 
		{
			String options1="";
			String options2="";
			List<Object[]> list=null;
			
			
			if(SearchScreenOptions.equals("2"))
			{			
					options1="emp.employee_id";						
			}
			else if(SearchScreenOptions.equals("3"))
			{			
					options1="emp.employee_name";
					
			}
				
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction trans = null;
			
			try
			{			
				 trans = session.beginTransaction();				
		         				 
				 	
				 
				 /*String str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"WHERE emp.employee_id IN (SELECT emp_id FROM HRM_PEN_APP_HO_CO_FORM1_DET) " +
			 		"AND (lower("+options1+") LIKE '%"+SearchScreenKeyword+"%')";*/
				 
				 
				 
				 
				 
				 String str="SELECT emp.employee_id," +
				 		"emp.employee_name " +
				 		"FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"WHERE emp.employee_id NOT IN " +
				 		"(SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final') " +
				 		"AND emp.employee_id IN " +
				 		"(SELECT emp_id FROM hrm_pen_app_ho_co_form1_det) " +
				 		"AND (LOWER(CAST("+options1+" AS TEXT)) LIKE '%"+SearchScreenKeyword+"%')";
				 
				 
				 
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 trans.commit();   
			}
			catch(Exception e)
			{
					e.printStackTrace();
					
			}
			finally
			{
					SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
				
			return list;	
		}	
		
		
		
		
		
		public SessionFactory getSessionFactory() 
		{
			return sessionFactory;
		}
		
		
		public void setSessionFactory(SessionFactory sessionFactory) 
		{
			this.sessionFactory = sessionFactory;
		}
	
	
	}