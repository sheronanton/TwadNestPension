package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.UnfreezPensionCalculationService;

public class UnfreezPensionCalculationDaoImpl implements UnfreezPensionCalculationService{

	SessionFactory sessionFactory;

	@Override
	public boolean unfreezepensioncalculation(HttpServletRequest request,
			Integer empNo) {
		// TODO Auto-generated method stub
		
		Session session=SessionFactoryUtils.getSession(sessionFactory, true);
		
		Transaction trans=null;
		boolean flag=false;
		  try {
			trans=session.beginTransaction();
			CallableStatement call=session.connection().prepareCall("{call HRM_PEN_PENFAM_UNFREEZE(?)}");
			call.setInt(1, empNo);					
			System.out.println("Callable updated--"+call.executeUpdate());
			flag=true;
		//	System.out.println("flag=>"+flag);
			trans.commit();
			  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Object[]> getempName(int empno, int empId) {
		// TODO Auto-generated method stub
		System.out.println("empname========================dao");
		List<Object[]> myEmpDet=null;
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		
		try
		{
			trans=session.beginTransaction();
			
			//String empQry="select EMP_NO,EMP_NAME from HRM_PEN_APP_HO_CO_FORM2_DET where emp_no in("+empno+")" ;
					 //" and OFFICE_ID=(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id="+empno+")";
			 String str="select f1.EMP_ID,f1.EMP_INITIAL||''||f1.EMP_NAME as empname from HRM_PEN_APP_HO_MST_FORM1_DET f1 "+      
					 " where f1.emp_id like '%"+empno+"%' and  PROCESS_STATUS='VALIDATE' ";
			System.out.println(str);
			Query query=session.createSQLQuery(str);
			myEmpDet=query.list();
			trans.commit();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			trans.rollback();
			
		}
		
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		
		return myEmpDet;
	}

	@Override
	public List<Object[]> getempRevisedName(int empno, int empId) {
		// TODO Auto-generated method stub
		System.out.println("empname========================dao");
		List<Object[]> myEmpDet=null;
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		
		try
		{
			trans=session.beginTransaction();
			
			//String empQry="select EMP_NO,EMP_NAME from HRM_PEN_APP_HO_CO_FORM2_DET where emp_no in("+empno+")" ;
					 //" and OFFICE_ID=(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id="+empno+")";
			 String str=" SELECT f1.EMP_ID, " +
					 "  f1.EMP_INITIAL " +
					 "  ||'' " +
					 "  ||f1.EMP_NAME AS empname " +
					 " FROM HRM_PEN_APP_REVISED_PEN_DET f1 " +
					 " WHERE cast(f1.emp_id as text) LIKE '%"+empno+"%' " +
					 " AND PROCESS_STATUS='VALIDATE'";
			System.out.println(str);
			Query query=session.createSQLQuery(str);
			myEmpDet=query.list();
			trans.commit();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			trans.rollback();
			
		}
		
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		
		return myEmpDet;
	}

	@Override
	public boolean unfreezepensioncalculationrevised(
			HttpServletRequest request, Integer empNo) {
		// TODO Auto-generated method stub
		
		Session session=SessionFactoryUtils.getSession(sessionFactory, true);
		
		Transaction trans=null;
		boolean flag=false;
		  try {
			trans=session.beginTransaction();
			CallableStatement call=session.connection().prepareCall("{call HRM_PEN_REVISED_APP_UNFREEZE(?)}");
			call.setInt(1, empNo);					
			System.out.println("Callable updated--"+call.executeUpdate());
			flag=true;
		//	System.out.println("flag=>"+flag);
			trans.commit();
			  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
}
