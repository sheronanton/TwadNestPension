package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.PensionApplicationLoadMstDataService;

public class PensionApplicationLoadMstDataDaoImpl implements PensionApplicationLoadMstDataService{

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> penAppMstData(int searchEmpId,int loginEmpId) 
	{
		List<Object[]> list=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{
			
			tx=session.beginTransaction();
			//String strQuery="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER,offi.office_name,desi.DESIGNATION,emp.TWAD_ENTRY_DATE,offi.OFFICE_ID,desi.DESIGNATION_ID,desi.SERVICE_GROUP_ID from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID where post.EMPLOYEE_ID="+searchEmpId;			
			 
			//String strQuery="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER,offi.office_name,desi.DESIGNATION,emp.TWAD_ENTRY_DATE,offi.OFFICE_ID,desi.DESIGNATION_ID,desi.SERVICE_GROUP_ID,post.OFFICE_GRADE from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in( select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+loginEmpId+") and emp.EMPLOYEE_ID="+searchEmpId+")"; 
			
			/*String strQuery="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER,offi.office_name,desi.DESIGNATION,emp.TWAD_ENTRY_DATE,offi.OFFICE_ID,desi.DESIGNATION_ID,desi.SERVICE_GROUP_ID,post.OFFICE_GRADE from HRM_EMP_CURRENT_POSTING post " +
					"left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
					"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
					"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
					"where (post.EMPLOYEE_ID in (" +
					"select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in( " +
					"select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+loginEmpId+") " +
					"or post.employee_id in(" +
			 		"select employee_id from hrm_emp_current_posting where employee_id not in(" +
			 		"SELECT employee_id FROM hrm_emp_controlling_office) and employee_id = "+searchEmpId+"))"+
					"and emp.EMPLOYEE_ID="+searchEmpId+")";*/
			
			
			
			String strQuery="SELECT emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER,offi.office_name,desi.DESIGNATION,emp.TWAD_ENTRY_DATE,offi.OFFICE_ID,desi.DESIGNATION_ID,desi.SERVICE_GROUP_ID,post.OFFICE_GRADE " +
					"FROM HRM_EMP_CURRENT_POSTING post " +
					"LEFT OUTER JOIN HRM_MST_DESIGNATIONS desi ON post.DESIGNATION_ID=desi.DESIGNATION_ID " +
					"LEFT OUTER JOIN com_mst_offices offi ON post.OFFICE_ID=offi.OFFICE_ID " +
					"LEFT OUTER JOIN HRM_MST_EMPLOYEES emp ON post.EMPLOYEE_ID      =emp.EMPLOYEE_ID " +
					"WHERE (post.EMPLOYEE_ID IN  (SELECT EMPLOYEE_ID  FROM HRM_EMP_CONTROLLING_OFFICE  WHERE CONTROLLING_OFFICE_ID IN ( " +
					"SELECT OFFICE_ID FROM HRM_EMP_CURRENT_POSTING WHERE EMPLOYEE_ID="+loginEmpId+")) OR post.employee_id IN (" +
					"SELECT employee_id FROM hrm_emp_current_posting WHERE employee_id NOT IN ( " +
					"SELECT employee_id FROM hrm_emp_controlling_office) AND employee_id    = "+searchEmpId+" )) and emp.EMPLOYEE_ID = "+searchEmpId;
			
			
			Query query=session.createSQLQuery(strQuery);	
			 list=query.list();
			 tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
			System.out.println(e);
			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return list;
	}

	
	@SuppressWarnings("unchecked")
	public List<Object[]> chkAvailablity(int searchEmpId, int loginId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		List<Object[]> myListt=null;
		try
		{
			trans=session.beginTransaction();
			Query myQry=session.createSQLQuery("select EMP_NO,EMP_NAME from HRM_PEN_APP_MST_FORM2 where EMP_NO="+searchEmpId);
			myListt=myQry.list();
			trans.commit();
			System.out.println("DAO IMPL E SIZE>>>>>>>>>>>>>>>>"+myListt.size());
		}
		catch(Exception e)
		{
			trans.rollback();
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
	
		return myListt;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> chkAvailablityForm1(int searchEmpId, int loginId) {
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);		
		List<Object[]> myListt1=null;
		try
		{		
			Query myQry1=session.createSQLQuery("select EMP_ID,EMP_NAME from HRM_PEN_APP_MST_FORM1_DET where EMP_ID="+searchEmpId);
			myListt1=myQry1.list();			
		}
		catch(Exception e)
		{			
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
	
		return myListt1;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> penAppFreezeCheck2(int searchEmpId) {
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);		
		List<Object[]> myListt1=null;
		try
		{		
			Query myQry1=session.createSQLQuery("select emp_no,emp_name from hrm_pen_app_ho_mst_form2_det where emp_no="+searchEmpId);
			myListt1=myQry1.list();		
			System.out.println("myListt1----------------->"+myListt1);
		}
		catch(Exception e)
		{			
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
	
		return myListt1;
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
