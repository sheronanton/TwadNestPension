package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import com.nic.hrms.pension.service.ChangePenFamNameService;

public class ChangePenFamNameDaoImpl implements ChangePenFamNameService {
	
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> itRecoverySearch(String keyword, String options,
			int empId) {
		// TODO Auto-generated method stub
		
		List<Object[]> list=null;		
		///searching for ppo_no
		if(options.equals("1"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 		 
				 
				 
				 //String str="select EMP_NO,EMP_NAME from HRM_PEN_APP_HO_CO_FORM2_DET where emp_no like '%"+keyword+"%' " ;
				 		   //" and OFFICE_ID=(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id="+keyword+" )";
				 
				 String str="select f1.EMP_ID,f1.EMP_INITIAL,f1.EMP_NAME from HRM_PEN_APP_HO_CO_FORM1_DET f1 "+ 
				             " left outer join HRM_PEN_APP_HO_MST_FORM1_DET mf1 on mf1.EMP_ID=f1.emp_id "+
				             " where f1.emp_id like '%"+keyword+"%' ";
				 System.out.println(str);
				 
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
				 
				 
				 
				 /*String str="select EMP_NO,EMP_NAME from HRM_PEN_APP_HO_CO_FORM2_DET where (lower(emp_name) like '%"+keyword+"%')" +
				 		    " and OFFICE_ID=(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id='"+empId+"' )";
				 */
				 //String str="select EMP_NO,EMP_NAME from HRM_PEN_APP_HO_CO_FORM2_DET where (lower(emp_name) like '%"+keyword+"%')";
		 
				 String str="select f1.EMP_ID,f1.EMP_INITIAL,f1.EMP_NAME from HRM_PEN_APP_HO_CO_FORM1_DET f1 "+ 
	             " left outer join HRM_PEN_APP_HO_MST_FORM1_DET mf1 on mf1.EMP_ID=f1.emp_id "+
	             " where lower(f1.emp_name) like '%"+keyword+"%') ";
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
	public int getIdName(int empno, int empId) {
		// TODO Auto-generated method stub
		System.out.println("idname========================dao");
		int myEmpDet=0;
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		
		try
		{
			trans=session.beginTransaction();
			
			String empQry="select EMP_NO,EMP_NAME from hrm_pen_app_ho_mst_form2_det where emp_no like '%"+empno+"%'" ;
					 //" and OFFICE_ID=(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id='"+empId+"')";
			Query query=session.createSQLQuery(empQry);
			myEmpDet=query.list().size();
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
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getNmpName(int empno, int empId) {
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
			 String str="select f1.EMP_ID,f1.EMP_INITIAL,f1.EMP_NAME from HRM_PEN_APP_HO_CO_FORM1_DET f1 "+ 
             " left outer join HRM_PEN_APP_HO_MST_FORM1_DET mf1 on mf1.EMP_ID=f1.emp_id "+
             " where cast(f1.emp_id as text) like '%"+empno+"%' ";
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

	@SuppressWarnings("deprecation")
	public boolean upadatepenfamname(String initial, String changeName, Integer empNo) {
		// TODO Auto-generated method stub
		HttpServletRequest request;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try 
		{
			trans = session.beginTransaction();			
			CallableStatement call=session.connection().prepareCall("call HRM_PEN_PENFAM_CHANGENAME(?,?,?)");
			call.setInt(1, empNo);
			call.setString(2, initial);
			call.setString(3, changeName);			
			System.out.println("Callable updated--"+call.executeUpdate());
			flag=true;
		//	System.out.println("flag=>"+flag);
			trans.commit();
				
		}
		catch(Exception e)
		{
			trans.rollback();
			e.printStackTrace();
			System.out.println("Except----"+e);
		}
		return flag;
	}


	
	

}
