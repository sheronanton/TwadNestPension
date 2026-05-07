	
	package com.nic.hrms.pension.dao.impl;
	
	import java.util.List;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.springframework.orm.hibernate3.SessionFactoryUtils;
	import com.nic.hrms.pension.service.PensionApplicationForm1SearchService;
	
	
	public class PensionApplicationForm1SearchDaoImpl implements PensionApplicationForm1SearchService
	{
		
		private SessionFactory sessionFactory;
		
		
		@SuppressWarnings("unchecked")
		public List<Object[]> FetchPensionApplicationForm1Search(String SearchScreenKeyword,String SearchScreenOptions, int empId) 
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
			String str="";
			
			try
			{			
				 trans = session.beginTransaction();			 			 
				 
				 
				/* String str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"WHERE post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"AND emp.employee_id NOT IN (SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET) " +
			 		"AND (lower("+options1+") LIKE '%"+SearchScreenKeyword+"%')";*/
				 
				
				 if(SearchScreenOptions.equals("2"))
					{
				str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"WHERE (post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"or post.employee_id in(" +
			 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
			 		"SELECT employee_id FROM hrm_emp_controlling_office) and CAST(employee_id AS TEXT) LIKE '%"+SearchScreenKeyword+"%'))"+
			 		"AND emp.employee_id NOT IN (SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET) " +
			 		"AND (lower (CAST("+options1+" AS TEXT)) LIKE '%"+SearchScreenKeyword+"%')";			
					 
					
					 		}
				 else if(SearchScreenOptions.equals("3"))
					{
					 str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
				 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"WHERE (post.employee_id IN " +
				 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
				 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
				 		"or post.employee_id in(" +
				 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
				 		"SELECT employee_id FROM hrm_emp_controlling_office) and employee_id in (" +
				 		"select employee_id from hrm_mst_employees where lower(CAST(employee_name AS TEXT)) LIKE '%"+SearchScreenKeyword.toLowerCase()+"%')))"+
				 		"AND emp.employee_id NOT IN (SELECT emp_id FROM HRM_PEN_APP_MST_FORM1_DET) " +
				 		"AND (lower (CAST("+options1+" as TEXT)) LIKE '%"+SearchScreenKeyword.toLowerCase()+"%')";	
					 
					 
					 
					}
				 Query query=session.createSQLQuery(str);
				 System.out.println("search query for add/edit in field office pension calculation=======>"+str);
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
		public List<Object[]> FetchPensionApplicationForm1ValSearch(String SearchScreenKeyword,String SearchScreenOptions, int empId) 
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
			String str="";
			try
			{			
				 trans = session.beginTransaction();       				 
				 			
				 
				 
				/* String str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"WHERE post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"AND emp.employee_id IN (SELECT emp_id FROM HRM_PEN_APP_FORM1_DETAILS) " +
			 		"AND (lower("+options1+") LIKE '%"+SearchScreenKeyword+"%')";*/
				 if(SearchScreenOptions.equals("2"))
					{
				 str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
			 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			 		"WHERE (post.employee_id IN " +
			 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
			 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
			 		"or post.employee_id in(" +
			 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
			 		"SELECT employee_id FROM hrm_emp_controlling_office) and CAST(employee_id AS TEXT) LIKE '%"+SearchScreenKeyword+"%')) "+
			 		"AND emp.employee_id IN (SELECT emp_id FROM HRM_PEN_APP_FORM1_DETAILS) " +
			 		"AND (lower(CAST("+options1+" AS TEXT)) LIKE '%"+SearchScreenKeyword+"%')";
					 
					
					 
					 
					 
					}
				 else if(SearchScreenOptions.equals("3"))
					{
					 str="SELECT emp.employee_id,emp.employee_name FROM hrm_emp_current_posting post " +
				 		"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
				 		"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
				 		"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
				 		"WHERE (post.employee_id IN " +
				 		"(SELECT employee_id FROM hrm_emp_controlling_office WHERE controlling_office_id IN " +
				 		"(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) " +
				 		"or post.employee_id in(" +
				 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
				 		"SELECT employee_id FROM hrm_emp_controlling_office) and employee_id in (" +
				 		"select employee_id from hrm_mst_employees where lower(CAST(employee_name AS TEXT)) LIKE '%"+SearchScreenKeyword.toLowerCase()+"%'))) "+
				 		"AND emp.employee_id IN (SELECT emp_id FROM HRM_PEN_APP_FORM1_DETAILS) " +
				 		"AND (lower(CAST("+options1+" AS TEXT)) LIKE '%"+SearchScreenKeyword.toLowerCase()+"%')";
					 
					 
					 
					 
					 
					 
					}
				 
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