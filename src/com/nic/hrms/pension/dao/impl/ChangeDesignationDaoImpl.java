package com.nic.hrms.pension.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import com.nic.hrms.pension.service.ChangeDesignationService;

public class ChangeDesignationDaoImpl implements ChangeDesignationService {

	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Object[]> designationSearch(String keyword, String options,
			int empId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		if(options.equals("1"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 		 
				 
				 
				 String str="select cp.employee_id,to_char(emp.employee_initial||'.'||emp.employee_name) as empname ,cp.designation_id,dest.designation" +
				 		" from hrm_emp_current_posting cp left outer join hrm_mst_designations dest on dest.designation_id=cp.designation_id" +
				 		" left outer join HRM_MST_EMPLOYEES emp on emp.employee_id=cp.employee_id " +
				 		" where cp.EMPLOYEE_STATUS_ID in('SAN','VRS','DTH','CMR','MEV','DIS','RES') and employee_id like '%"+keyword+"%' " ;
				  	//"and cp.office_id=(select ecp.office_id from hrm_emp_current_posting ecp where ecp.employee_id='"+keyword+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	       			
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		
		///searching for pensioner_name
		if(options.equals("2"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 //String str="SELECT ppo_no,employee_id,pensioner_name FROM hrm_pen_mst_details where process_status='VALIDATE' and (lower(pensioner_name) like '%"+searchKeyword+"%') and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"') UNION SELECT hr_pen_mst_family.ppo_no,hr_pen_mst_family_emp_det.employee_id,hr_pen_mst_family_emp_det.EMP_NAME FROM hr_pen_mst_family left outer join hr_pen_mst_family_emp_det on hr_pen_mst_family.ppo_no=hr_pen_mst_family_emp_det.ppo_no where hr_pen_mst_family.process_status='VALIDATE' and (lower(hr_pen_mst_family_emp_det.EMP_NAME) like '%"+searchKeyword+"%') and hr_pen_mst_family.payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 
				 
				 
				 String str="select cp.employee_id,to_char(emp.employee_initial||'.'||emp.employee_name) as empname ,cp.designation_id,dest.designation" +
				 		" from hrm_emp_current_posting cp left outer join hrm_mst_designations dest on dest.designation_id=cp.designation_id" +
				 		" left outer join HRM_MST_EMPLOYEES emp on emp.employee_id=cp.employee_id where cp.EMPLOYEE_STATUS_ID in('SAN','VRS','DTH','CMR','MEV','DIS','RES')" +
				 		" and (lower(emp.employee_name) like '%"+keyword+"%') ";
				 //"and cp.office_id=(select ecp.office_id from hrm_emp_current_posting ecp where ecp.employee_id='"+empId+"')";
				 
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

	@SuppressWarnings("unchecked")
	public List<Object[]> getIdName(int empno, int empId) {
		// TODO Auto-generated method stub
		List<Object []> myEmpDet=null;
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		
		try
		{
			trans=session.beginTransaction();
			
			String empQry="select cp.employee_id,to_char(emp.employee_initial||'.'||emp.employee_name) as empname ,cp.designation_id,dest.designation" +
	 		" from hrm_emp_current_posting cp left outer join hrm_mst_designations dest on dest.designation_id=cp.designation_id" +
	 		" left outer join HRM_MST_EMPLOYEES emp on emp.employee_id=cp.employee_id " +
	 		" where cp.EMPLOYEE_STATUS_ID in('SAN','VRS','DTH','CMR','MEV','DIS','RES')and employee_id in("+empno+")" ;
	 		//" cp.office_id=(select ecp.office_id from hrm_emp_current_posting ecp where ecp.employee_id='"+empno+"')";
			System.out.println(empQry);
			Query query=session.createSQLQuery(empQry);
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

	@SuppressWarnings("deprecation")
	public boolean upadatedesignation(int changedesig, int empno) {
		// TODO Auto-generated method stub
		System.out.println("ado=====================================");
		System.out.println(changedesig+"===="+empno);
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PreparedStatement ps=null;
		boolean flag=false;
		try 
		{
			trans = session.beginTransaction();
			Connection conn=session.connection();
			String str="update hrm_emp_current_posting set designation_id="+changedesig+" where employee_id="+empno;
			System.out.println(str);
			ps=conn.prepareStatement(str);
		    ps.executeUpdate();
		    flag=true;
		    ps.close();
		    //conn.close();
		    trans.commit();
		    session.flush();
		}
		catch(Exception e)
		{
			trans.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return flag;
	}
	

	
}
