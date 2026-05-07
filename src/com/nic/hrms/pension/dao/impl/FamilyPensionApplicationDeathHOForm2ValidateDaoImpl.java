package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2NomineeDao;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathHOForm2ValidateService;

public class FamilyPensionApplicationDeathHOForm2ValidateDaoImpl implements FamilyPensionApplicationDeathHOForm2ValidateService {

	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	public List<Object[]> getMstData(int empNo)
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> getMstList=null;
		try
		{
			tx=session.beginTransaction();
			String mstQry="";
			Query qry=session.createSQLQuery(mstQry);
			getMstList=qry.list();
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();		
			tx.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return getMstList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> searchData(String option,String keyword,int loginEmpId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> searchList=null;
		try
		{
			tx=session.beginTransaction();
			String mstQry="SELECT  emp.employee_id,emp.employee_name,desi.DESIGNATION,offi.OFFICE_NAME " +
					" FROM hrm_emp_current_posting post LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id" +
					" LEFT OUTER JOIN        com_mst_offices offi   ON post.office_id = offi.office_id" +
					" LEFT OUTER JOIN        hrm_mst_employees emp             ON post.employee_id = emp.employee_id" +
					" LEFT OUTER JOIN  HRM_PEN_APP_FAM_MST_DET_FORM2 f2 on f2.EMP_NO=emp.employee_id" +
					" WHERE  emp.employee_id in (select emp_no from HRM_PEN_FAPP_HO_DET_CO_FORM2)   and   cast(emp."+option+" as text) LIKE '%"+keyword+"%'";
			Query qry=session.createSQLQuery(mstQry);
			searchList=qry.list();
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();		
			tx.rollback();		
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return searchList;
	}

	
	public FamilyPensionApplicationDeathHOForm2DetailsDao getCoDetails(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		System.out.println("INSIDE GET CO DETAILS IMPLEMENTATION::::"+empId);
		FamilyPensionApplicationDeathHOForm2DetailsDao mstdata=null;
		try
		{
			tx=session.beginTransaction();
			mstdata=(FamilyPensionApplicationDeathHOForm2DetailsDao) session.createCriteria(FamilyPensionApplicationDeathHOForm2DetailsDao.class)
			.add(Property.forName("empNo").eq(empId)).uniqueResult();
			System.out.println("SIZE OF LIST:::"+mstdata.toString());
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return mstdata;
	}
	
	public List<Object[]> getMstDataCheck(int empNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> mstDatasList=null;
		try
		{
			String str="SELECT emp.employee_id,emp.employee_name, emp.employee_initial, emp.gpf_no, emp.date_of_birth, emp.gender," +
			" offi.office_name, desi.designation, offi.office_id, desi.designation_id, desi.service_group_id, post.office_grade," +
			" serv.date_from FROM hrm_emp_current_posting post " +
			" LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			" LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			" LEFT OUTER JOIN hrm_emp_service_data serv ON serv.employee_id = "+empNo+
			" LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id" +
			" LEFT OUTER JOIN PEN_ALLRETIREMENTVIEW vie ON vie.employee_id = emp.employee_id " +
			" WHERE post.employee_id = "+empNo+					
			"  AND serv.employee_id = "+empNo+ " AND serv.date_from =(SELECT MIN(date_from) FROM hrm_emp_service_data  WHERE employee_id = "+empNo+")";
			tx=session.beginTransaction();
			Query qry=session.createSQLQuery(str);
			mstDatasList=qry.list();
			tx.commit();		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return mstDatasList;
	}

	
		@SuppressWarnings("unchecked")
		public List<FamilyPensionApplicationDeathHOForm2NomineeDao> getHoNomineeList(int empNo) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		List<FamilyPensionApplicationDeathHOForm2NomineeDao> nomineeMstList=null;
		
		try
		{
			tx=session.beginTransaction();
			nomineeMstList=session.createCriteria(FamilyPensionApplicationDeathHOForm2NomineeDao.class)
			.add(Property.forName("empNo").eq(empNo)).list();
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
		return nomineeMstList;
	}


		public boolean saveDetails(Object obj) 
		{
			Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
			Transaction tx=null;
			try
			{
				tx=session.beginTransaction();
				session.saveOrUpdate(obj);
				tx.commit();
			}
			catch(Exception e)
			{
				tx.rollback();
				return false;	
			}
			finally
			{
				SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
			
			return true;
		}

	

		public boolean saveAddnominee(List<FamilyPensionApplicationDeathHOForm2MstNomineeDao> famPenAppHeadNomMst) {
			
			Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
			Transaction trans = null;
			FamilyPensionApplicationDeathHOForm2MstNomineeDao fpenhovalnom=null;
			try {	
				Iterator iter = famPenAppHeadNomMst.iterator();
				trans = session.beginTransaction();			
				Query maxcount = session.createQuery("select coalesce(max(nomineeId),'0') from FamilyPensionApplicationDeathHOForm2MstNomineeDao");
				
				while(iter!=null && iter.hasNext())
				{
					fpenhovalnom = new FamilyPensionApplicationDeathHOForm2MstNomineeDao();
					String maxnominee=null;
						try
						{
							maxnominee=maxcount.iterate().next().toString();
						}
						catch(Exception e)
						{
							e.printStackTrace();
							
						}
				
					int maxnominee1 = maxnominee!=null?(Integer.parseInt(maxnominee))+1:1;
					fpenhovalnom =(FamilyPensionApplicationDeathHOForm2MstNomineeDao)iter.next();
					fpenhovalnom.setNomineeId(maxnominee1);				
					session.save(fpenhovalnom);
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
			return false;
		}


		public boolean deleteNominee(int empNo) 
		{
		
			Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
			Transaction tx=null;			
			try
			{
				tx=session.beginTransaction();			
				Query qry=session.createQuery("delete from FamilyPensionApplicationDeathHOForm2MstNomineeDao where empNo="+empNo);
				qry.executeUpdate();
				tx.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				tx.rollback();
				return false;				
			}
			finally
			{
				SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
			
			return true;
			
		
		}


		public boolean deleteHoCoDetails(int empNo) 
		{
			
			Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
			Transaction trans = null;
			try 
			{
					trans = session.beginTransaction();
					CallableStatement call=session.connection().prepareCall("call DELETE_FAM_PEN_APP_CO_DETAILS(?)");
					call.setInt(1, empNo);
					System.out.println("Callable updated--"+call.executeUpdate());
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


		


		
	



	
	
	
}
