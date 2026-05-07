package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNotVerifyServDao;
import com.nic.hrms.pension.service.PensionApplicationLoadFieldOfficeDataService;

public class PensionApplicationLoadFieldOfficeDataDaoImpl implements PensionApplicationLoadFieldOfficeDataService{

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
			//String myQry="select EMP_NO,EMP_NAME,DESIGNATION,OFFICE_NAME from HRM_PEN_APPLICATION_NEW app,HRM_MST_DESIGNATIONS des,COM_MST_OFFICES offi where app.DESIG_ID=des.DESIGNATION_ID and app.OFFICE_ID=offi.OFFICE_ID and app.PROCESS_STATUS='VALIDATE'";
			
			
			
			//String myQry="select EMP_NO,EMP_NAME,DESIGNATION,OFFICE_NAME from HRM_PEN_APP_MST_FORM2 app,HRM_MST_DESIGNATIONS des,COM_MST_OFFICES offi where app.DESIG_ID=des.DESIGNATION_ID and app.OFFICE_ID=offi.OFFICE_ID and app.PROCESS_STATUS='VALIDATE'";
			
			String myQry="select EMP_NO,EMP_NAME," +
					"DESIGNATION,OFFICE_NAME " +
					"from HRM_PEN_APP_MST_FORM2 app,HRM_MST_DESIGNATIONS des,COM_MST_OFFICES offi " +
					"where app.DESIG_ID=des.DESIGNATION_ID " +
					"and app.OFFICE_ID=offi.OFFICE_ID " +
					"and app.PROCESS_STATUS='VALIDATE' " +
					"AND app.emp_no not in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')";
			
			//HRM_PEN_APP_MST_FORM2
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
				 //String myQry="select EMP_NO,EMP_NAME,DESIGNATION,OFFICE_NAME from HRM_PEN_APPLICATION_NEW app,HRM_MST_DESIGNATIONS des,COM_MST_OFFICES offi where (lower(EMP_NO) like '%"+searchKeyword+"%') and app.DESIG_ID=des.DESIGNATION_ID and app.OFFICE_ID=offi.OFFICE_ID and app.PROCESS_STATUS='VALIDATE'";
				 //String myQry="select EMP_NO,EMP_NAME,DESIGNATION,OFFICE_NAME from HRM_PEN_APP_MST_FORM2 app,HRM_MST_DESIGNATIONS des,COM_MST_OFFICES offi where (lower(EMP_NO) like '%"+searchKeyword+"%') and app.DESIG_ID=des.DESIGNATION_ID and app.OFFICE_ID=offi.OFFICE_ID and app.PROCESS_STATUS='VALIDATE'";
				/* String myQry="SELECT emp.employee_id,emp.employee_name,app.process_status FROM hrm_emp_current_posting post" +
				 		" LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id LEFT" +
				 		" OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id LEFT" +
				 		" OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id LEFT" +
				 		" OUTER JOIN hrm_pen_app_mst_form2 app ON app.emp_no = emp.employee_id" +
				 		" WHERE post.employee_id IN (SELECT employee_id FROM hrm_emp_controlling_office WHERE " +
				 		" controlling_office_id IN (SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) AND" +
				 		" emp.employee_id NOT IN (SELECT emp_no FROM hrm_pen_app_mst_form2) AND (LOWER(emp.employee_id) LIKE '%"+searchKeyword+"%')";
				*/ 
				 
				 String myQry=" select emp.employee_id,emp.employee_name,desi.DESIGNATION,offi.OFFICE_NAME " +
				 		" from hrm_emp_current_posting post LEFT OUTER JOIN hrm_mst_designations desi" +
				 		" ON post.designation_id = desi.designation_id LEFT OUTER JOIN com_mst_offices offi " +
				 		" ON post.office_id = offi.office_id LEFT OUTER JOIN hrm_mst_employees emp " +
				 		" ON post.employee_id = emp.employee_id where (LOWER(cast(emp.employee_id as text)) LIKE '%"+searchKeyword+"%')" +
				 		" AND emp.employee_id not in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')" +
				 		" and emp.GPF_NO is not null";
				 
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
						//HRM_PEN_APP_MST_FORM2
						//String myQry="select EMP_NO,EMP_NAME,DESIGNATION,OFFICE_NAME from HRM_PEN_APPLICATION_NEW app,HRM_MST_DESIGNATIONS des,COM_MST_OFFICES offi where (lower(EMP_NAME) like '%"+searchKeyword+"%') and app.DESIG_ID=des.DESIGNATION_ID and app.OFFICE_ID=offi.OFFICE_ID and app.PROCESS_STATUS='VALIDATE'"; 
						//String myQry="select EMP_NO,EMP_NAME,DESIGNATION,OFFICE_NAME from HRM_PEN_APP_MST_FORM2 app,HRM_MST_DESIGNATIONS des,COM_MST_OFFICES offi where (lower(EMP_NAME) like '%"+searchKeyword+"%') and app.DESIG_ID=des.DESIGNATION_ID and app.OFFICE_ID=offi.OFFICE_ID and app.PROCESS_STATUS='VALIDATE'";
					/*	 String myQry="SELECT emp.employee_id,emp.employee_name,app.process_status FROM hrm_emp_current_posting post" +
					 		" LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id LEFT" +
					 		" OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id LEFT" +
					 		" OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id LEFT" +
					 		" OUTER JOIN hrm_pen_app_mst_form2 app ON app.emp_no = emp.employee_id" +
					 		" WHERE post.employee_id IN (SELECT employee_id FROM hrm_emp_controlling_office WHERE " +
					 		" controlling_office_id IN (SELECT office_id FROM hrm_emp_current_posting WHERE employee_id = '"+empId+"')) AND" +
					 		" emp.employee_id NOT IN (SELECT emp_no FROM hrm_pen_app_mst_form2) AND (LOWER(emp.EMPLOYEE_NAME) LIKE '%"+searchKeyword+"%')";
				*/
						 String myQry=" select emp.employee_id,emp.employee_name,desi.DESIGNATION,offi.OFFICE_NAME " +
					 		"from hrm_emp_current_posting post LEFT OUTER JOIN hrm_mst_designations desi" +
					 		" ON post.designation_id = desi.designation_id LEFT OUTER JOIN com_mst_offices offi " +
					 		" ON post.office_id = offi.office_id LEFT OUTER JOIN hrm_mst_employees emp " +
					 		" ON post.employee_id = emp.employee_id where (LOWER(cast(emp.EMPLOYEE_NAME as TEXT)) LIKE '%"+searchKeyword+"%')" +
					 		" AND emp.employee_id not in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')"; 
				
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

	//PensionApplicationForm2Dao
	public PensionApplicationForm2MstDao loadFieldOfficeData(int empId,int officeId,int SearchId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true) ;		
		PensionApplicationForm2MstDao fieldDataList=null;
		try
		{
		/*	String qryStr="SELECT emp_no,  emp_name,  gender,  desig_service_grp,  desig_id,  grade,  office_id,"
						+" gpf_no,  father_name,  husband_name,  religion,  nationality,  emp_height,  id_mark1,  id_mark2,  present_address,"
						+" permanent_address,  address_after_retire,  state,  charges_flag,  charges_details,  payment_office_id,  application_date,"
						+" dcrg_nominee_name,  dcrg_nominee_dob,  dcrg_nominee_relation,  dcrg_nominee_address,  not_verify_service_tot_years,"
						+" not_verify_service_tot_months,  not_verify_service_tot_days FROM hrm_pen_app_mst_form2 where emp_no="+SearchId;
			Query qry=session.createSQLQuery(qryStr);
			fieldDataList=qry.list();*/
			
			fieldDataList=(PensionApplicationForm2MstDao) session.createCriteria((PensionApplicationForm2MstDao.class))
					.add(Property.forName("empNo").eq(SearchId)).uniqueResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return fieldDataList;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<PensionApplicationForm2MstNomineeDao> loadFieldOfficeNominee(int empId, int officeId, int SearchId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<PensionApplicationForm2MstNomineeDao> fieldDataNominee=null;
		try
		{
			fieldDataNominee=session.createCriteria(PensionApplicationForm2MstNomineeDao.class)
									.add(Property.forName("empNo").eq(SearchId)).list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return fieldDataNominee;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<PensionApplicationForm2MstNotVerifyServDao> loadFieldOfficeService(int empId, int officeId, int SearchId) 
	{
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<PensionApplicationForm2MstNotVerifyServDao> fieldDataService=null;
		try
		{
			fieldDataService=session.createCriteria(PensionApplicationForm2MstNotVerifyServDao.class)
									.add(Property.forName("empNo").eq(SearchId)).list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return fieldDataService;
	}
	
	
	public String getDesignation(int desigId) {
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		String strDesign=null;
		try
		{
			String myQry="select DESIGNATION from HRM_MST_DESIGNATIONS WHERE DESIGNATION_ID="+desigId;
			Query qry=session.createSQLQuery(myQry);
			strDesign=(String) qry.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return strDesign;
	}

	public String getOfficeName(int officeId) 
	{
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		String strOffice=null;
		try
		{
			String myQry="select OFFICE_NAME from COM_MST_OFFICES WHERE OFFICE_ID="+officeId;
			Query qry=session.createSQLQuery(myQry);
			strOffice=(String) qry.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return strOffice;
	}

	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	



	


	


	
	
	

}
