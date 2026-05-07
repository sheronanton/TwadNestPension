package com.nic.hrms.pension.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;
import com.nic.hrms.pension.service.PensionApplicationEditForm2Service;

public class PensionApplicationEditForm2DaoImpl implements PensionApplicationEditForm2Service{

	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getListEmp(String option, String keyword, int empId) 
	{
		
		List<Object[]> penAppList1=null;
		
		if(option.equals("1"))
		{
			
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				
				 
				// String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID left outer join HRM_PEN_APP_CO_FORM2 app on app.EMP_NO=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2 where PROCESS_STATUS <> 'VALIDATE') and emp.EMPLOYEE_ID like '%"+keyword+"%'"; 
				/* 
				 String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post " +
				 		"left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
				 		"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
				 		"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
				 		"left outer join HRM_PEN_APP_CO_FORM2 app on app.EMP_NO=emp.EMPLOYEE_ID " +
				 		"where post.EMPLOYEE_ID in (" +
				 		"select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(" +
				 		"select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) " +
				 		"and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2 where PROCESS_STATUS <> 'VALIDATE') and emp.EMPLOYEE_ID like '%"+keyword+"%'";
				 */
				 
				 
				 String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post " +
			 		"left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
			 		"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
			 		"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			 		"left outer join HRM_PEN_APP_CO_FORM2 app on app.EMP_NO=emp.EMPLOYEE_ID " +
			 		"where (post.EMPLOYEE_ID in (" +
			 		"select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(" +
			 		"select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) " +
			 		"or post.employee_id in(" +
			 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
			 		"SELECT employee_id FROM hrm_emp_controlling_office) and CAST(employee_id AS TEXT) LIKE '%"+keyword+"%'))"+
			 		"and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2 where PROCESS_STATUS <> 'VALIDATE') and CAST(emp.EMPLOYEE_ID AS TEXT) like '%"+keyword+"%'";
			 
				 Query query=session.createSQLQuery(str);	
				 penAppList1=query.list();
				 transaction.commit();
	       		
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		
		if(option.equals("3"))
		{
			
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				//String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID left outer join HRM_PEN_APP_CO_FORM2 app on app.EMP_NO=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2  where PROCESS_STATUS <> 'VALIDATE') and lower(emp.EMPLOYEE_NAME) like '%"+keyword+"%'";
				 
				 String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post " +
				 		"left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
				 		"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
				 		"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
				 		"left outer join HRM_PEN_APP_CO_FORM2 app on app.EMP_NO=emp.EMPLOYEE_ID " +
				 		"where (post.EMPLOYEE_ID in (" +
				 		"select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(" +
				 		"select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) " +
				 		"or post.employee_id in(" +
				 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
				 		"SELECT employee_id FROM hrm_emp_controlling_office) and employee_id in (" +
				 		"select employee_id from hrm_mst_employees where lower(CAST(employee_name AS TEXT)) LIKE '%"+keyword.toLowerCase()+"%')))"+
				 		"and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2  where PROCESS_STATUS <> 'VALIDATE') and lower(CAST(emp.EMPLOYEE_NAME AS TEXT)) like '%"+keyword.toLowerCase()+"%'";
				 Query query=session.createSQLQuery(str);	
				 penAppList1=query.list();
				 transaction.commit();
	     			
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		
		return penAppList1;
	}

	
	public PensionApplicationForm2Dao getExistingData(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tran=null;
		PensionApplicationForm2Dao penAppEditObj=null;
		try
		{
			tran=session.beginTransaction();
			penAppEditObj=(PensionApplicationForm2Dao) session.createCriteria(PensionApplicationForm2Dao.class)
			.add(Property.forName("empNo").eq(empId)).uniqueResult();
			
		}
		catch(Exception e)
		{
			tran.rollback();
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return penAppEditObj;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PensionApplicationNomineeDao> getListOfEditNominee(int empIdList) {
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tran=null;
		List<PensionApplicationNomineeDao> penAppEditNomObj=null;
		try
		{
			tran=session.beginTransaction();
			penAppEditNomObj=session.createCriteria(PensionApplicationNomineeDao.class)
			.add(Property.forName("empNo").eq(empIdList)).list();
			tran.commit();
		}
		catch(Exception e)
		{
			tran.rollback();
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return penAppEditNomObj;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<PensionApplicationNotVerifyServDetailsDao> getListOfEditNotVerSer(int empIdList1) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tran=null;
		List<PensionApplicationNotVerifyServDetailsDao> penAppEditNVSObj=null;
		try
		{
			tran=session.beginTransaction();
			penAppEditNVSObj=session.createCriteria(PensionApplicationNotVerifyServDetailsDao.class)
			.add(Property.forName("empNo").eq(empIdList1)).list();
			tran.commit();
		}
		catch(Exception e)
		{
			tran.rollback();
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return penAppEditNVSObj;
	}

	


	@SuppressWarnings("unchecked")
	public List<Object[]> getListEmpAdd(String option, String keywors, int empId) {
	
		
		
List<Object[]> penAppList2=null;
		
		if(option.equals("1"))
		{
			System.out.println("inside daoimpl 1.....");
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				// String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_MST_EMPLOYEES emp, HRM_PEN_APPLICATION_NEW app where emp.EMPLOYEE_ID=app.EMP_NO and emp.EMPLOYEE_ID like '%"+keyword+"%'";
				// String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID left outer join HRM_PEN_APPLICATION_NEW app on app.EMP_NO=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APPLICATION_NEW) and emp.EMPLOYEE_ID like '%"+keyword+"%'"; 
				 
				 //String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) and emp.EMPLOYEE_ID like '%"+keywors+"%'"; 				 
				 
				 String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME from HRM_EMP_CURRENT_POSTING post " +
				 		"left outer join HRM_MST_DESIGNATIONS desi on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
				 		"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
				 		"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
				 		"where (post.EMPLOYEE_ID in (" +
				 		"select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(" +
				 		"select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) " +
				 		"or post.employee_id in(" +
				 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
				 		"SELECT employee_id FROM hrm_emp_controlling_office) and CAST(employee_id AS TEXT) LIKE '%"+keywors+"%')) "+
				 		"and CAST(emp.EMPLOYEE_ID AS TEXT) like '%"+keywors+"%'";
				 Query query=session.createSQLQuery(str);	
				System.out.println( "HRM_PEN_APP_MST_FORM1_DET----->"+query.list());
				 penAppList2=query.list();
				 transaction.commit();
	     		
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		
		if(option.equals("3"))
		{
			System.out.println("inside daoimpl 2.....");
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				//String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) and emp.EMPLOYEE_NAME like '%"+keywors+"%'";
				 
				 
				 String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME from HRM_EMP_CURRENT_POSTING post " +
				 		"left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
				 		"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
				 		"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
				 		"where (post.EMPLOYEE_ID in (" +
				 		"select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(" +
				 		"select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) " +
				 		"or post.employee_id in(" +
				 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
				 		"SELECT employee_id FROM hrm_emp_controlling_office) and employee_id in (" +
				 		"select employee_id from hrm_mst_employees where lower(CAST(employee_name AS TEXT)) LIKE '%"+keywors.toLowerCase()+"%'))) "+
				 		"and lower(CAST(emp.EMPLOYEE_NAME AS TEXT)) like '%"+keywors.toLowerCase()+"%'";
				 
				 Query query=session.createSQLQuery(str);	
				 penAppList2=query.list();
				 transaction.commit();
	      			
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		
		return penAppList2;
		
		
	}
	
	
	public String getDesignation(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		String empdesig=null;
		
		try
		{
			trans=session.beginTransaction();
			Query desQry=session.createSQLQuery("select DESIGNATION from hrm_mst_designations where DESIGNATION_ID=(select DESIGNATION_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")");
			empdesig=(String) desQry.uniqueResult();
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
		return empdesig;
	}

	public String getOffice(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction txx=null;
		String officeName=null;
		try		
		{
			txx=session.beginTransaction();
			Query offQry=session.createSQLQuery("SELECT OFFICE_NAME FROM COM_MST_OFFICES WHERE OFFICE_ID=(select OFFICE_ID from HRM_PEN_APP_CO_FORM2 WHERE EMP_NO="+empId+")");
			officeName=(String) offQry.uniqueResult();
			txx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return officeName;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	

	


	

	

	

}
