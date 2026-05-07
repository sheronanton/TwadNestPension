	
	package com.nic.hrms.pension.dao.impl;
	
	import java.util.List;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.springframework.orm.hibernate3.SessionFactoryUtils;
	import com.nic.hrms.pension.service.RevisedPensionCalculationSearchService;
	
	
	public class RevisedPensionCalculationSearchDaoImpl implements RevisedPensionCalculationSearchService
	{
		
		private SessionFactory sessionFactory;
		
		
		@SuppressWarnings("unchecked")
		public List<Object[]> FetchRevisedPensionCalculationSearch(String SearchScreenKeyword,String SearchScreenOptions, int empId) 
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
				 
				 String str="SELECT emp.employee_id," +
				 		"emp.employee_name " +
				 		"FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"WHERE emp.employee_id IN " +
				 		"(SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final') " +
				 		"AND emp.employee_id IN " +
				 		"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det) " +
				 		"AND(LOWER (cast("+options1+" as TEXT)) LIKE '%"+SearchScreenKeyword+"%')";
				 
				 
				 
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
		public List<Object[]> FetchRevisedPensionCalculationValSearch(String SearchScreenKeyword,String SearchScreenOptions, int empId) 
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
		         				 
			
				 
				 String str="SELECT emp.employee_id," +
				 		"emp.employee_name " +
				 		"FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"WHERE emp.employee_id NOT IN " +
				 		"(SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final') " +
				 		"AND emp.employee_id IN " +
				 		"(SELECT emp_id FROM hrm_pen_app_ho_co_form1_det) " +
				 		"AND (LOWER("+options1+") LIKE '%"+SearchScreenKeyword+"%')";
				 
				 
				 
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