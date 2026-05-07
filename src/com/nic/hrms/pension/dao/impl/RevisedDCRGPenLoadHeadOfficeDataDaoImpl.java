package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationHOForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.RevisedPensionAuthorizationDao;
import com.nic.hrms.pension.service.RevisedDCRGPenLoadHeadOfficeDataService;

public class RevisedDCRGPenLoadHeadOfficeDataDaoImpl implements RevisedDCRGPenLoadHeadOfficeDataService{

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> loadAllData() 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> dataList=null;
		try
		{
			tx=session.beginTransaction();			
			
			/*String myQry="SELECT app.emp_id,app.emp_name,des.designation,offi.office_name " +
					"FROM hrm_pen_app_ho_mst_form1_det app,hrm_mst_designations des,com_mst_offices offi " +
					"WHERE app.designation_id = des.designation_id " +
					"AND app.office_id = offi.office_id " +
					"AND app.process_status = 'VALIDATE' " +
					"AND app.da_pert <>" +
					"(SELECT da_percentage FROM hrm_pen_mst_new_da " +
					"WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					"AND(app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det " +
					"WHERE date_of_retire <= " +
					"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					"OR app.emp_id IN " +
					"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det " +
					"WHERE date_of_vrs <= " +
					"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					"OR app.emp_id IN " +
					"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE death_date <= " +
					"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))) " +
					"AND app.emp_id in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')";
		*/	
			
			
			/*String myQry="SELECT app.emp_id," +
								"app.emp_name," +
								"des.designation," +
								"offi.office_name  " +
								"FROM hrm_pen_app_ho_mst_form1_det app,hrm_mst_designations des,com_mst_offices offi  " +
								"WHERE app.designation_id = des.designation_id 	AND app.office_id = offi.office_id    " +
								"AND app.process_status ='VALIDATE' " +
								"AND app.da_pert <> " +
								"(SELECT da_percentage FROM hrm_pen_mst_new_da  WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
								"and (app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det  " +
								"WHERE date_of_vrs  >=(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))  " +
								"OR app.emp_id IN  (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det   " +
								"WHERE date_of_vrs is null and  date_of_retire >=" +
								"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da )) " +
								"OR app.emp_id IN " +
								"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det   " +
								"WHERE death_date >=(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))) " +
								"AND app.emp_id in (select emp_no from hrm_pen_app_authorization_org where process_status='Final') " +
								"AND app.emp_id not in (select emp_id from HRM_PEN_APP_REVISED_PEN_DET)";*/
			
			
			
			String myQry="SELECT app.emp_id," +
					"app.emp_name," +
					"des.designation," +
					"offi.office_name," +
					"app.DATE_OF_BIRTH," +
					"app.DA_PERT," +
					"app.PPO_NO," +
					"app.dcrg_amount," +
					"auth.gpo_no," +
					"auth.resident_address," +
					"auth.name_from_address," +
					"auth.authorized_officer," +
					"auth.authorized_officer_address," +
					"auth.letter_no," +
					"auth.last_work_office_address," +
					"auth.reference  " +
					"FROM hrm_pen_app_ho_mst_form1_det app," +
					"hrm_mst_designations des," +
					"com_mst_offices offi," +
					"hrm_pen_app_authorization_org auth  " +
					"WHERE app.designation_id = des.designation_id  " +
					"AND app.emp_id=auth.emp_no and auth.last_work_office_id = offi.office_id  AND app.process_status='VALIDATE'   " +
					"AND app.da_pert<>(SELECT da_percentage  FROM hrm_pen_mst_new_da WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))" +
					"AND (app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))" +
					" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs  IS NULL  AND date_of_retire >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det  WHERE death_date >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))) " +
					" AND app.emp_id IN (SELECT emp_no FROM hrm_pen_app_authorization_org  WHERE process_status='Final'  ) AND app.emp_id NOT IN " +
					" (SELECT emp_id FROM HRM_PEN_APP_REVISED_PEN_DET where  process_status='Final' )";
	
	
			
			
			
			Query qry=session.createSQLQuery(myQry);
			dataList=qry.list();
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		
		return dataList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> LoadEmployeeData(int empid) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> dataList=null;
		try
		{
			tx=session.beginTransaction();			
			
				/*String myQry="SELECT emp.EMPLOYEE_ID," +
				    "emp.EMPLOYEE_NAME||'.'||emp.EMPLOYEE_INITIAL,"+
					"des.designation," +
					"offi.office_name," +
					"emp.DATE_OF_BIRTH," +
					"app.DA_PERT," +
					"auth.PPO_NO," +
					"app.dcrg_amount," +
					"auth.gpo_no," +
					"auth.resident_address," +
					"auth.name_from_address," +
					"auth.authorized_officer," +
					"auth.authorized_officer_address," +
					"auth.letter_no," +
					"auth.last_work_office_address," +
					"auth.reference," +
					"emp.gender," +
					"app.pension_type,"+
					"app.no_of_halfyear_dcrg,"+
					"(NVL(app.LAST_BASIC_PAY,0)+NVL(app.LAST_SPECIAL_PAY,0)+NVL(app.LAST_GRADE_PAY,0) +NVL(app.LAST_OTHER_PAY1,0)+NVL(app.LAST_OTHER_PAY2,0)+NVL(app.LAST_OTHER_PAY3,0) ) AS overalltot,"+
					"(select office_name from com_mst_offices where office_id=auth.pension_pay_office_id) as officename,"+
					"auth.pension_pay_office_address,"+
					"app.date_of_retire,"+
					"app.date_of_vrs,"+
					"app.death_date  "+
					"FROM hrm_pen_app_ho_mst_form1_det app," +
					"hrm_mst_designations des," +
					"com_mst_offices offi," +
					"hrm_pen_app_authorization_org auth,  " +
					"hrm_mst_employees emp,  " +
					"HRM_EMP_CURRENT_POSTING post  "+
					"WHERE app.emp_id=post.employee_id AND app.emp_id=emp.employee_id AND post.designation_id = des.designation_id  " +
					"AND app.office_id= offi.office_id AND app.emp_id=auth.emp_no AND app.process_status='VALIDATE'   " +
					"AND app.da_pert<>(SELECT da_percentage  FROM hrm_pen_mst_new_da WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))" +
					"AND (app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))" +
					" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs  IS NULL  AND date_of_retire >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det  WHERE death_date >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))) " +
					" AND app.emp_id IN (SELECT emp_no FROM hrm_pen_app_authorization_org  WHERE process_status='Final'  ) AND app.emp_id NOT IN " +
					" (SELECT emp_id FROM HRM_PEN_APP_REVISED_PEN_DET where  process_status='Final' ) AND app.emp_id="+empid;*/
				
				/*String myQry="SELECT emp.EMPLOYEE_ID," +
			    "emp.EMPLOYEE_INITIAL||'.'||emp.EMPLOYEE_NAME,"+
				"des.designation," +
				"offi.office_name," +
				"emp.DATE_OF_BIRTH," +
				"app.DA_PERT," +
				"auth.PPO_NO," +
				"app.dcrg_amount," +
				"auth.gpo_no," +
				"auth.resident_address," +
				"auth.name_from_address," +
				"auth.authorized_officer," +
				"auth.authorized_officer_address," +
				"auth.letter_no," +
				"auth.last_work_office_address," +
				"(auth.letter_no||'-3 dt.'||to_char(auth.DATED_ON,'dd/MM/YYYY')) as reference," +
				"emp.gender," +
				"app.pension_type,"+
				"app.no_of_halfyear_dcrg,"+
				"(NVL(app.LAST_BASIC_PAY,0)+NVL(app.LAST_GRADE_PAY,0)) AS overalltot,"+
				"(select office_name from com_mst_offices where office_id=auth.pension_pay_office_id) as officename,"+
				"auth.pension_pay_office_address,"+
				"app.date_of_retire,"+
				"app.date_of_vrs,"+
				"app.death_date," +
				"NVL(app.LAST_BASIC_PAY,0)," +
				"NVL(app.LAST_SPECIAL_PAY,0)," +
				"NVL(app.LAST_GRADE_PAY,0)," +
				"(NVL(app.LAST_OTHER_PAY1,0)+NVL(app.LAST_OTHER_PAY2,0)+NVL(app.LAST_OTHER_PAY3,0)) as othpaytot,"+
				"auth.last_work_office_id,"+
				"auth.pension_pay_office_id  "+
				"FROM hrm_pen_app_ho_mst_form1_det app," +
				"hrm_mst_designations des," +
				"com_mst_offices offi," +
				"hrm_pen_app_authorization_org auth,  " +
				"hrm_mst_employees emp,  " +
				"HRM_EMP_CURRENT_POSTING post  "+
				"WHERE app.emp_id=post.employee_id AND app.emp_id=emp.employee_id AND post.designation_id = des.designation_id  " +
				"AND app.office_id= offi.office_id AND app.emp_id=auth.emp_no AND app.process_status='VALIDATE'   " +
				"AND app.da_pert<>(SELECT da_percentage  FROM hrm_pen_mst_new_da WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))" +
				"AND (app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))" +
				" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs  IS NULL  AND date_of_retire >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
				" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det  WHERE death_date >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))) " +
				" AND app.emp_id IN (SELECT emp_no FROM hrm_pen_app_authorization_org  WHERE process_status='Final'  ) AND app.emp_id NOT IN " +
				" (SELECT emp_id FROM HRM_PEN_APP_REVISED_PEN_DET where  process_status='Final' ) AND app.emp_id="+empid;
	*/
			
			String myQry="SELECT emp.EMPLOYEE_ID," +
		    "emp.EMPLOYEE_INITIAL||'.'||emp.EMPLOYEE_NAME,"+
			"des.designation," +
			"offi.office_name," +
			"emp.DATE_OF_BIRTH," +
			"app.DA_PERT," +
			"auth.PPO_NO," +
			"app.dcrg_amount," +
			"auth.gpo_no," +
			"auth.resident_address," +
			"auth.name_from_address," +
			"auth.authorized_officer," +
			"auth.authorized_officer_address," +
			"auth.letter_no," +
			"auth.last_work_office_address," +
			"(auth.letter_no||'-3 dt.'||(auth.DATED_ON,'dd/MM/YYYY')) as reference," +
			"emp.gender," +
			"app.pension_type,"+
			"app.no_of_halfyear_dcrg,"+
			"(COALESCE(app.LAST_BASIC_PAY,0)+COALESCE(app.LAST_GRADE_PAY,0)) AS overalltot,"+
			"(select office_name from com_mst_offices where office_id=auth.pension_pay_office_id) as officename,"+
			"auth.pension_pay_office_address,"+
			"app.date_of_retire,"+
			"app.date_of_vrs,"+
			"app.death_date," +
			"COALESCE(app.LAST_BASIC_PAY,0)," +
			"COALESCE(app.LAST_SPECIAL_PAY,0)," +
			"COALESCE(app.LAST_GRADE_PAY,0)," +
			"(COALESCE(app.LAST_OTHER_PAY1,0)+COALESCE(app.LAST_OTHER_PAY2,0)+COALESCE(app.LAST_OTHER_PAY3,0)) as othpaytot,"+
			"auth.last_work_office_id,"+
			"auth.pension_pay_office_id  "+
			"FROM hrm_pen_app_ho_mst_form1_det app," +
			"hrm_mst_designations des," +
			"com_mst_offices offi," +
			"hrm_pen_app_authorization_org auth,  " +
			"hrm_mst_employees emp,  " +
			"HRM_EMP_CURRENT_POSTING post  "+
			"WHERE app.emp_id=post.employee_id AND app.emp_id=emp.employee_id AND post.designation_id = des.designation_id  " +
			"AND app.emp_id=auth.emp_no and auth.last_work_office_id = offi.office_id AND app.emp_id=auth.emp_no AND app.process_status='VALIDATE'   " +
			"AND app.da_pert<>(SELECT da_percentage  FROM hrm_pen_mst_new_da WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))" +
			"AND (app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))" +
			" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE date_of_vrs  IS NULL  AND date_of_retire >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
			" OR app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det  WHERE death_date >= (SELECT MAX(effect_date) FROM hrm_pen_mst_new_da ))) " +
			" AND app.emp_id IN (SELECT emp_no FROM hrm_pen_app_authorization_org  WHERE process_status='Final'  ) AND app.emp_id NOT IN " +
			" (SELECT emp_id FROM HRM_PEN_APP_REVISED_PEN_DET where  process_status='Final' ) AND app.emp_id="+empid;

	
			
			
			
			Query qry=session.createSQLQuery(myQry);
			dataList=qry.list();
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		
		return dataList;
	}
	

	@SuppressWarnings("unchecked")
	public List<Object[]> searchData(String searchOption,String searchKeyword, int empId) {
				
		List<Object[]> penlist=null;
		
		///searching for empno
		System.out.println("Inside search DAO IMple ............>>>>>>>>>>>.."+searchOption+"\t key"+searchKeyword+"\t"+empId);
		
		if(searchOption.equals("1"))
		{
			System.out.println("inside 1 st opt");
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();			 
				 
				
				/* String myQry="SELECT emp.employee_id, to_char(emp.employee_initial || emp.employee_name),des.designation,offi.office_name " +
					"FROM hrm_pen_app_ho_mst_form1_det app,hrm_mst_designations des,com_mst_offices offi,hrm_mst_employees emp " +
					"WHERE app.designation_id = des.designation_id " +
					"AND app.office_id = offi.office_id " +
					"AND emp.employee_id = app.emp_id " +
					"AND app.process_status = 'VALIDATE' " +
					"AND app.da_pert <>" +
					"(SELECT da_percentage FROM hrm_pen_mst_new_da " +
					"WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					"AND(app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det " +
					"WHERE date_of_retire <= " +
					"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					"OR app.emp_id IN " +
					"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det " +
					"WHERE date_of_vrs <= " +
					"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					"OR app.emp_id IN " +
					"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE death_date <= " +
					"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))) " +
					"AND app.emp_id in (select emp_no from hrm_pen_app_authorization_org where process_status='Final') " +
					"AND emp.employee_id LIKE '%"+searchKeyword+"%'";*/
				 
				 String myQry="SELECT emp.employee_id, (emp.employee_initial || emp.employee_name),des.designation,offi.office_name " +
					"FROM hrm_pen_app_ho_mst_form1_det app,hrm_mst_designations des,com_mst_offices offi,hrm_mst_employees emp,hrm_pen_app_authorization_org org  " +
					"WHERE app.designation_id = des.designation_id " +
					"AND app.emp_id=org.emp_no and org.last_work_office_id= offi.office_id " +
					"AND emp.employee_id = app.emp_id " +
					"AND app.process_status = 'VALIDATE' " +
					"AND app.da_pert <>" +
					"(SELECT da_percentage FROM hrm_pen_mst_new_da " +
					"WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
					"AND app.emp_id in (select emp_no from hrm_pen_app_authorization_org where process_status='Final') " +
					"AND cast(emp.employee_id as TEXT) LIKE '%"+searchKeyword+"%'";
				
				 
				 
				 
				 Query query=session.createSQLQuery(myQry);	
				 penlist=query.list();
				 transaction.commit();
						
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
			
	}
		
		
		
		///searching for empname	
		
		if(searchOption.equals("3"))
			{
			System.out.println("inside 2 st opt");
				Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
				Transaction transaction = null;
			
				try
					{
						transaction = session.beginTransaction();						
												
						String myQry="SELECT emp.employee_id, (emp.employee_initial || emp.employee_name),des.designation,offi.office_name " +
						"FROM hrm_pen_app_ho_mst_form1_det app,hrm_mst_designations des,com_mst_offices offi,hrm_mst_employees emp,hrm_pen_app_authorization_org org " +
						"WHERE app.designation_id = des.designation_id " +
						"AND app.emp_id=org.emp_no and org.last_work_office_id= offi.office_id " +
						"AND emp.employee_id = app.emp_id " +
						"AND app.process_status = 'VALIDATE' " +
						"AND app.da_pert <>" +
						"(SELECT da_percentage FROM hrm_pen_mst_new_da " +
						"WHERE effect_date =(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
						"AND(app.emp_id IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det " +
						"WHERE date_of_retire <= " +
						"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
						"OR app.emp_id IN " +
						"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det " +
						"WHERE date_of_vrs <= " +
						"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da)) " +
						"OR app.emp_id IN " +
						"(SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det WHERE death_date <= " +
						"(SELECT MAX(effect_date) FROM hrm_pen_mst_new_da))) " +
						"AND app.emp_id in (select emp_no from hrm_pen_app_authorization_org where process_status='Final') " +
						"AND lower(emp.employee_name) LIKE '%"+searchKeyword.toLowerCase()+"%'";
					 
				
						Query query=session.createSQLQuery(myQry);	
						penlist=query.list();
						transaction.commit();
							
										
					}
			catch(Exception e){
					e.printStackTrace();
				}
			finally
			{
				SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
			
		}
				
		return penlist;
	}

	
	
	
	
	public List<Object[]> penAppHOForm1MstValData(int loginEmpId, String searchEmpId) 
	{
		List<Object[]> list=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{
			
			tx=session.beginTransaction();
			
						
					String strQuery="SELECT emp.employee_id," +
					"emp.employee_name," +
					"emp.employee_initial," +
					"emp.gpf_no," +
					"emp.date_of_birth," +
					"emp.gender," +
					"offi.office_name," +
					"desi.designation," +
					"emp.twad_entry_date," +
					"offi.office_id," +
					"desi.designation_id," +
					"desi.service_group_id," +
					"post.date_effective_from," +
					"post.office_grade," +
					"post.date_effective_from_session," +
					"serv.date_from," +
					"serv.date_from_session," +
					"vie.retiredate " +
					"FROM hrm_emp_current_posting post " +
					"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
					"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
					"LEFT OUTER JOIN hrm_emp_service_data serv ON serv.employee_id = "+searchEmpId+" " +
					"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
					"LEFT OUTER JOIN PEN_ALLRETIREMENTVIEW vie ON vie.employee_id = emp.employee_id " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det f1 ON f1.emp_id = emp.employee_id " +
					"WHERE post.employee_id = "+searchEmpId+" " +
					"AND serv.employee_id = "+searchEmpId+" " +
					"AND serv.date_from = " +
					"(SELECT MIN(date_from) FROM hrm_emp_service_data WHERE employee_id = "+searchEmpId+") AND f1.process_status = 'VALIDATE'";


			
			
			
			

			 Query query=session.createSQLQuery(strQuery);	
			 list=query.list();
			 tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return list;
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public int penAppHOForm1CalcdaSettingValData(String dadate) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		int i = 0;
		try
		{
			 transaction = session.beginTransaction();
			 String str="select DA_PERCENTAGE from hrm_pen_mst_new_da " +
		 		"where effect_date=(select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date in (select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date>=to_date('"+dadate+"','dd/MM/yyyy')) or effect_date in (select max(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date<=to_date('"+dadate+"','dd/MM/yyyy')))";
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 i = Integer.parseInt(""+obj.next());		
				       	
			 }
			 transaction.commit();
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return i;
	   
	}
	
	
	@SuppressWarnings("unchecked")
	public String getdaorderno(String dadate) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		String orderno = "";
		try
		{
			 transaction = session.beginTransaction();
			 String str="select ORDER_NO from hrm_pen_mst_new_da " +
		 		"where effect_date=(select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date in (select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date>=to_date('"+dadate+"','dd/MM/yyyy')) or effect_date in (select max(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date<=to_date('"+dadate+"','dd/MM/yyyy')))";
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 orderno =obj.next()+"";		
				       	
			 }
			 transaction.commit();
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return orderno;
	   
	}
	
	
	@SuppressWarnings("unchecked")
	public String getdaeffectdate(String dadate) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		String effectdate = "";
		try
		{
			 transaction = session.beginTransaction();
			 String str="select (EFFECT_DATE,'dd/mm/yyyy') from hrm_pen_mst_new_da " +
		 		"where effect_date=(select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date in (select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date>=to_date('"+dadate+"','dd/MM/yyyy')) or effect_date in (select max(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date<=to_date('"+dadate+"','dd/MM/yyyy')))";
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 effectdate =obj.next()+"";		
				       	
			 }
			 transaction.commit();
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return effectdate;
	   
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Double penAppHOForm1CalcComSettingValData(int age) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		Double i = 0.000;
		try
		{
			 transaction = session.beginTransaction();
			 String str="select COMM_VALUE from HRM_PEN_CAL_COMMUTED where AGE="+age;
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 i=Double.parseDouble(""+obj.next());
				     	
			 }
			 transaction.commit();  
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		
		return i;
	   
	}
	
	
	
	
	
	

	public List<Object[]> revpenAppHOOldMstValData(String searchEmpId) 
	{
		List<Object[]> oldlist=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction oldtx=null;
		try		
		{
			
			oldtx=session.beginTransaction();
			String strOldQuery="select EMP_ID," +
					"PENSION_TYPE," +
					"DATE_OF_PROVINC," +
					"DATE_OF_REG_ESTAB," +
					"DATE_OF_SELECTION," +
					"DATE_OF_SPECIAL," +
					"DATE_OF_VRS," +
					"COMM_OPTED," +
					"COMM_FACTOR_ONRTHIRD," +
					"COM_FACTOR_PERT," +
					"WCE_SERV_DAYS," +
					"WCE_SERV_MONTH," +
					"WCE_SERV_YEAR," +
					"WCE_SERV_FLAG," +
					"WCE_SERV_COUNT_FLAG," +
					"CONTINGENT_SERV_FLAG," +
					"CONTINGENT_SERV_DAYS," +
					"CONTINGENT_SERV_MONTH," +
					"CONTINGENT_SERV_YEAR," +
					"NON_PROV_SERV_DAYS," +
					"NON_PROV_SERV_MONTH," +
					"NON_PROV_SERV_YEAR," +
					"EOL_DAYS," +
					"EOL_MONTH," +
					"EOL_YEAR," +
					"SUSPENSION_DAYS," +
					"SUSPENSION_MONTH," +
					"SUSPENSION_YEAR," +
					"BOY_SERV_DAYS," +
					"BOY_SERV_MONTH," +
					"BOY_SERV_YEAR," +
					"OVERSTAY_LEAVE_DAYS," +
					"OVERSTAY_LEAVE_MONTH," +
					"OVERSTAY_LEAVE_YEAR," +
					"NOT_REG_LEAVE_DAYS," +
					"NOT_REG_LEAVE_MONTH," +
					"NOT_REG_LEAVE_YEAR," +
					"APPRENTICE_DAYS," +
					"APPRENTICE_MONTH," +
					"APPRENTICE_YEAR," +
					"NOT_SERV_VERIFY_DAYS," +
					"NOT_SERV_VERIFY_MONTH," +
					"NOT_SERV_VERIFY_YEAR," +
					"FOREIGN_SERV_DAYS," +
					"FOREIGN_SERV_MONTH," +
					"FOREIGN_SERV_YEAR," +
					"LAST_BASIC_PAY," +
					"LAST_SPECIAL_PAY," +
					"LAST_GRADE_PAY," +
					"LAST_OTHER_PAY1," +
					"LAST_OTHER_PAY2," +
					"LAST_OTHER_PAY3," +
					"PENSION_AMOUNT," +
					"DCRG_AMOUNT," +
					"NO_OF_HALFYEAR_PENSION," +
					"NO_OF_HALFYEAR_DCRG," +
					"TOTAL_COMMUTED_AMOUNT," +
					"REDUCED_PENSION_AMOUNT," +
					"FAMILY_PENSION_50_AMT," +
					"FAMILY_PENSION_30_AMT," +
					"DA_AMOUNT," +
					"COMMUTED_VALUE," +
					"COMMUTATION_PEN_AMOUNT," +
					"ACTUAL_SER_YEAR," +
					"ACTUAL_SER_MON," +
					"ACTUAL_SER_DAYS," +
					"NET_SER_YEAR," +
					"NET_SER_MON," +
					"NET_SER_DAYS," +
					"TOT_NON_QUAL_SER_YEAR," +
					"TOT_NON_QUAL_SER_MON," +
					"TOT_NON_QUAL_SER_DAYS," +
					"SCALE_OF_PAY," +
					"WEIGHTAGE_YEAR," +
					"WEIGHTAGE_MONTH," +
					"WEIGHTAGE_DAYS," +
					"FAM_PEN_UPTO_SEVEN," +
					"FAM_PEN_AFTER_SEVEN, " +
					"DEATH_DATE " +
					"from HRM_PEN_APP_HO_MST_FORM1_DET where EMP_ID="+searchEmpId+" " +
					"and PROCESS_STATUS='VALIDATE'";			
					

			 Query oldquery=session.createSQLQuery(strOldQuery);	
			 oldlist=oldquery.list();
			 oldtx.commit();
		}
		catch(Exception e)
		{
			oldtx.rollback();
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return oldlist;
	}
	

	
	
	
	
	
	
	

	@SuppressWarnings("unchecked")

	public List<PensionApplicationHOForm1AverageEmolumentsValDao> loadHOForm1OldAeVal(int empid) {
		// TODO Auto-generated method stub
		List<PensionApplicationHOForm1AverageEmolumentsValDao> Ae=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try {	
			
				trans = session.beginTransaction();				
				Query qry=session.createQuery("from PensionApplicationHOForm1AverageEmolumentsValDao where empNo="+empid+" order by fromdate1");				
				Ae=qry.list();				
				trans.commit();
		
		} catch(Exception e) {
			trans.rollback();
		e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return Ae;
	}

	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean updateNewDCRGIntoHeadOfficeData(float dcrgpensionamount, int damount, int dapercentage, String empId, String updatedId) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;

	try {
		//String updatedDate=(new java.sql.Timestamp(new java.util.Date().getTime()))+"";
		//Date updatedDate=new java.util.Date();
		Timestamp updatedDate=new java.sql.Timestamp(new java.util.Date().getTime());
		trans = session.beginTransaction();		
		//System.out.println("updatedDate="+updatedDate);
		//Query qry=session.createSQLQuery("UPDATE HRM_PEN_APP_HO_MST_FORM1_DET SET DCRG_AMOUNT="+dcrgpensionamount+",DA_AMOUNT="+damount+",DA_PERT="+dapercentage+",UPDATED_USER_ID='"+updatedId+"',UPDATED_DATE="+updatedDate+", UNLOCKED_BY='"+updatedId+"',UNLOCKED_DATE="+updatedDate+" where EMP_ID="+empId);				
		/*String str="UPDATE HRM_PEN_APP_HO_MST_FORM1_DET " +
				"SET " +
				"DCRG_AMOUNT="+dcrgpensionamount+", " +
				"DA_AMOUNT="+damount+", " +
				"DA_PERT="+dapercentage+", " +
				"UPDATED_USER_ID='"+updatedId+"', " +
				"UPDATED_DATE="+updatedDate+", " +
				"UNLOCKED_BY='"+updatedId+"', " +
				"UNLOCKED_DATE="+updatedDate+" " +
				"where EMP_ID="+empId;*/
		String str="UPDATE HRM_PEN_APP_HO_MST_FORM1_DET " +
		"SET " +
		"DCRG_AMOUNT="+dcrgpensionamount+", " +
		"DA_AMOUNT="+damount+", " +
		"DA_PERT="+dapercentage+", " +
		"UPDATED_USER_ID='"+updatedId+"', " +
		"UNLOCKED_BY='"+updatedId+"' " +
		"where EMP_ID="+empId;
		Query qry=session.createSQLQuery(str);
		//Query qry=session.createSQLQuery("UPDATE HRM_PEN_APP_HO_MST_FORM1_DET SET DCRG_AMOUNT="+dcrgpensionamount+",DA_AMOUNT="+damount+",DA_PERT="+dapercentage+",UPDATED_USER_ID='"+updatedId+"', UNLOCKED_BY='"+updatedId+"' where EMP_ID="+empId);
		qry.executeUpdate();				
		trans.commit();
		}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
		return false;
	}

		return true;
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean moveOldDCRGIntoHistory(int empId) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;

	try {
		trans = session.beginTransaction();
		CallableStatement call=session.connection().prepareCall("{call REVIS_PENSION_DUE_DA_CHANGE(?)}");//REVIS_PENSION_DUE_DA_CHANGE (empId IN NUMBER ) AS
		call.setInt(1, empId);
		System.out.println("Callable updated REVIS_PENSION_DUE_DA_CHANGE--"+call.executeUpdate());
		trans.commit();
		}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
		return false;
	}

		return true;
	}
	
	

	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public boolean saveRecord(
			RevisedPensionAuthorizationDao revisedPenAppAuthOrg) {
		// TODO Auto-generated method stub

		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		
		Transaction trans=null;		
		boolean flag=false;
		
		try
		{
			
			trans=session.beginTransaction();
			session.save(revisedPenAppAuthOrg);
			trans.commit();
			session.flush();
			flag=true;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			trans.rollback();
			return flag;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return flag;
	}


	



	


	


	
	
	

}
