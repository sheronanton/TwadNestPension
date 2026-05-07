package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationForm2MstNotVerifyServDao;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;
import com.nic.hrms.pension.service.PensionApplicationValidateForm2Service;

public class PensionApplicationValidateForm2DaoImpl implements PensionApplicationValidateForm2Service {

	private SessionFactory sessionFactory=null;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getEmpDetails(String option, String keyword, int empId)
	{					
		List<Object[]> myList4=null;			
		if(option.equals("1"))
		{
			Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
			Transaction trans=null;			
			try
			{
				trans=session.beginTransaction();			
				//String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID left outer join HRM_PEN_APP_CO_FORM2 app on app.EMP_NO=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2 where PROCESS_STATUS='ENTERED') and emp.EMPLOYEE_ID like '%"+keyword+"%'"; 
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
				 		"SELECT employee_id FROM hrm_emp_controlling_office) and CAST(employee_id AS TEXT) LIKE '%"+keyword+"%')) "+
						"and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2 where PROCESS_STATUS='ENTERED') " +
						"and CAST(emp.EMPLOYEE_ID AS TEXT) like '%"+keyword+"%'";
				Query valQry=session.createSQLQuery(str);
				myList4=valQry.list();
				
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
		}
		
		if(option.equals("3"))
		{
			Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
			Transaction trans=null;			
			try
			{
				trans=session.beginTransaction();			
				//String str="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,app.PROCESS_STATUS from HRM_EMP_CURRENT_POSTING post left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID left outer join HRM_PEN_APP_CO_FORM2 app on app.EMP_NO=emp.EMPLOYEE_ID where post.EMPLOYEE_ID in (select EMPLOYEE_ID from HRM_EMP_CONTROLLING_OFFICE where CONTROLLING_OFFICE_ID in(select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+")) and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2 where PROCESS_STATUS='ENTERED') and emp.EMPLOYEE_NAME like '%"+keyword+"%'"; 
				
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
				 		"select employee_id from hrm_mst_employees where lower(CAST(employee_name AS TEXT)) LIKE '%"+keyword.toLowerCase()+"%'))) "+
						"and emp.EMPLOYEE_ID in (select EMP_NO from HRM_PEN_APP_CO_FORM2 where PROCESS_STATUS='ENTERED') " +
						"and lower(CAST(emp.EMPLOYEE_NAME AS TEXT)) like '%"+keyword.toLowerCase()+"%'";
				Query valQry=session.createSQLQuery(str);
				myList4=valQry.list();
				
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
		}
		
		
		
		return myList4;
	}

	
	
	




	public PensionApplicationForm2Dao getExistingData(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;		
		PensionApplicationForm2Dao  myValidList = null;
		
		try
		{
			trans=session.beginTransaction();
			myValidList=(PensionApplicationForm2Dao) session.createCriteria(PensionApplicationForm2Dao.class)
			.add(Property.forName("empNo").eq(empId)).uniqueResult();
			
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
		
		return myValidList;
	}

	



	@SuppressWarnings("unchecked")
	public List<PensionApplicationNomineeDao> getListOfValidNominee(int empIdList) {

		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tran=null;
		List<PensionApplicationNomineeDao> valPenAppCo=null;
		
		try
		{
			tran=session.beginTransaction();
			valPenAppCo=session.createCriteria(PensionApplicationNomineeDao.class)
			.add(Property.forName("empNo").eq(empIdList)).list();
			tran.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tran.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return valPenAppCo;
	}








	@SuppressWarnings("unchecked")
	public List<PensionApplicationNotVerifyServDetailsDao> getListOfValidNotVerSer(int empIdList1) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		List<PensionApplicationNotVerifyServDetailsDao> valPenAppNVS = null;
		try
		{
			trans=session.beginTransaction();
			valPenAppNVS=session.createCriteria(PensionApplicationNotVerifyServDetailsDao.class)
			.add(Property.forName("empNo").eq(empIdList1)).list();
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
		return valPenAppNVS;
	}



	public boolean saveOrUpdateData(Object obj) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trann=null;
		
		try
		{
			trann=session.beginTransaction();
			session.saveOrUpdate(obj);
			trann.commit();
		}
		catch(Exception e)
		{
			trann.rollback();
			e.printStackTrace();
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
	
		return true;
	}


	@SuppressWarnings("unchecked")
	public boolean saveAddnominee(List<PensionApplicationForm2MstNomineeDao> penappnomin) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		PensionApplicationForm2MstNomineeDao penappnomco1=null;
		try
		{
			tx=session.beginTransaction();
			Iterator it=penappnomin.iterator();
			Query qry=session.createQuery("select coalesce(max(nomineeId),'0') from PensionApplicationForm2MstNomineeDao");
			while(it!=null && it.hasNext())
			{
				penappnomco1= new PensionApplicationForm2MstNomineeDao();
				String maxNomId=null;
				try
				{
					maxNomId=qry.iterate().next().toString();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				int maxCount=maxNomId!=null?(Integer.parseInt(maxNomId)+1):1;
				penappnomco1=(PensionApplicationForm2MstNomineeDao)it.next();
				penappnomco1.setNomineeId(maxCount);
				session.save(penappnomco1);
				
			}
			
 			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return true;
	}


	
	@SuppressWarnings("unchecked")
	public boolean saveNotVerifyService(List<PensionApplicationForm2MstNotVerifyServDao> notverserv) {

		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		PensionApplicationForm2MstNotVerifyServDao myObj=null;
		try
		{
			Iterator myIt=notverserv.iterator();
			trans=session.beginTransaction();
			Query mycount=session.createQuery("select coalesce(max(id),'0') from PensionApplicationForm2MstNotVerifyServDao");
			
			while(myIt!=null && myIt.hasNext())
			{
				myObj = new PensionApplicationForm2MstNotVerifyServDao();
				String maxId=null;
					try
					{
						maxId=mycount.iterate().next().toString();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
			
				int maxId1 = maxId!=null?(Integer.parseInt(maxId))+1:1;
				myObj =(PensionApplicationForm2MstNotVerifyServDao)myIt.next();
				myObj.setId(maxId1);				
				session.save(myObj);
			}
			
			trans.commit();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return true;
	}

	

	public boolean setMstProcessStatus(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tran=null;
		System.out.println("SET MST PROCESS STATUS.....");
		try
		{
			tran=session.beginTransaction();
			String str="update HRM_PEN_APP_CO_FORM2 set PROCESS_STATUS='VALIDATE' where EMP_NO="+empId;
			Query qr=session.createSQLQuery(str);
			qr.executeUpdate();
			tran.commit();
		}
	
		catch(Exception e)
		{
			tran.rollback();
			e.printStackTrace();
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return true;
	}
	
	
	public String getDesignation(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		String empdesig=null;
		
		try
		{
			trans=session.beginTransaction();
			Query desQry=session.createSQLQuery("select DESIGNATION from hrm_mst_designations where DESIGNATION_ID=(select DESIG_ID from HRM_PEN_APP_CO_FORM2 where emp_no="+empId+")");
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

	



	public boolean deleteNVServiceCo(int empId) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tran=null;
		try
		{
			tran=session.beginTransaction();
			Query qry=session.createSQLQuery("delete from HRM_PEN_APP_NOMINEE_CO_FORM2 where EMP_NO="+empId);
			qry.executeUpdate();
			tran.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tran.rollback();	
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return true;
	}



	public boolean deleteNomineeCo(int empId) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tran=null;
		try
		{
			tran=session.beginTransaction();
			Query qry=session.createSQLQuery("delete from HRM_PEN_APP_NVSERV_CO_FORM2 where EMP_NO="+empId);
			qry.executeUpdate();
			tran.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tran.rollback();	
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return true;
	}
	
	
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



}
