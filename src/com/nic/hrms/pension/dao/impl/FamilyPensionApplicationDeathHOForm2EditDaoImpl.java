package com.nic.hrms.pension.dao.impl;

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
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathHOForm2NomineeDao;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathHOForm2EditService;

public class FamilyPensionApplicationDeathHOForm2EditDaoImpl implements FamilyPensionApplicationDeathHOForm2EditService{

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> editSearch(String option, String keyword,int loginEmpId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> editSerachList=null;		
		try
		{
			String myQry="SELECT  emp.employee_id,emp.employee_name,desi.DESIGNATION,offi.OFFICE_NAME " +
					" FROM hrm_emp_current_posting post LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id" +
					" LEFT OUTER JOIN        com_mst_offices offi   ON post.office_id = offi.office_id" +
					" LEFT OUTER JOIN        hrm_mst_employees emp             ON post.employee_id = emp.employee_id" +
					" LEFT OUTER JOIN  HRM_PEN_APP_FAM_MST_DET_FORM2 f2 on f2.EMP_NO=emp.employee_id" +
					" WHERE  emp.employee_id in (select emp_no from HRM_PEN_APP_FAM_MST_DET_FORM2)   and   emp."+option+" LIKE '%"+keyword+"%'";		
			tx=session.beginTransaction();
			Query qry=session.createSQLQuery(myQry);
			editSerachList=qry.list();
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
		return editSerachList;
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


	
	
	public List<Object[]> getMstData(int empNo) 
	{
		List<Object[]> mstList=null;
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		try
		{
			tx=session.beginTransaction();
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
			 		
			Query qry=session.createSQLQuery(str);
			mstList=qry.list();			
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
		return mstList;
	}
	
	
	public List<Object[]> getFieldMstData(int empNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> mstList2=null;
		try
		{
			tx=session.beginTransaction();			
			String str="SELECT EMP_NO,RELIGION_ID,NATIONALITY,ID_MARK1,ID_MARK2,PRESENT_ADDRESS,STATE_ID," +
			" PENSION_PAY_OFFICE_ID,CLAIMENT_NAME,CLAIMENT_DOB,CLAIMENT_AGE,GUARDIAN_NAME,GUARDIAN_DOB," +
			" GUARDIAN_RELATION_MINOR,GUARDIAN_RELATION_EMP,EMPLOYEE_DEATH_DATE,ADDRESS " +
			" FROM HRM_PEN_APP_FAM_MST_DET_FORM2 where EMP_NO="+empNo;			
			Query qry=session.createSQLQuery(str);
			mstList2=qry.list();			
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
		
		return mstList2;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> getNomineeList(int empNo) 
	{	
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> nomineeMstList=null;
		
		try
		{
			tx=session.beginTransaction();
			nomineeMstList=session.createCriteria(FamilyPensionApplicationDeathFieldForm2MstNomineeDao.class)
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

	public boolean saveDetails(FamilyPensionApplicationDeathHOForm2DetailsDao famPenAppHeadCo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		
		try
		{
			tx=session.beginTransaction();
			session.saveOrUpdate(famPenAppHeadCo);
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

	
	public boolean saveAddnominee(List<FamilyPensionApplicationDeathHOForm2NomineeDao> famPenAppHeadNomCo) {
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		FamilyPensionApplicationDeathHOForm2NomineeDao fpenappnom=null;
		try {	
			Iterator iter = famPenAppHeadNomCo.iterator();
			trans = session.beginTransaction();			
			Query maxcount = session.createQuery("select coalesce(max(nomineeId),'0') from FamilyPensionApplicationDeathHOForm2NomineeDao");
			
			while(iter!=null && iter.hasNext())
			{
				fpenappnom = new FamilyPensionApplicationDeathHOForm2NomineeDao();
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
				fpenappnom =(FamilyPensionApplicationDeathHOForm2NomineeDao)iter.next();
				fpenappnom.setNomineeId(maxnominee1);				
				session.save(fpenappnom);
			}
			
			trans.commit();
		
		}
		
		catch (Exception e) 
		{		
			e.printStackTrace();
			trans.rollback();
			System.out.println("Error in Saving Nominee"+e);
			return false;			
		}
		
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
	
		return true;
	}

	
	
	public boolean deleteNominee(int empNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		System.out.println("Inside Delete Nominee  ..............");
		try
		{
			tx=session.beginTransaction();			
			Query qry=session.createQuery("delete from FamilyPensionApplicationDeathHOForm2NomineeDao where empNo="+empNo);
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




	public List<Object[]> getHoDetails(int empNo) {
		List<Object[]> mstHOList=null;
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		try
		{
			tx=session.beginTransaction();
			String str="SELECT EMP_NO,RELIGION_ID,NATIONALITY,ID_MARK1,ID_MARK2,PRESENT_ADDRESS,STATE_ID," +
					" PENSION_PAY_OFFICE_ID,CLAIMENT_NAME,CLAIMENT_DOB,CLAIMENT_AGE,GUARDIAN_NAME,GUARDIAN_DOB," +
					" GUARDIAN_RELATION_MINOR,GUARDIAN_RELATION_EMP,EMPLOYEE_DEATH_DATE,ADDRESS " +
					" FROM HRM_PEN_FAPP_HO_DET_CO_FORM2 where EMP_NO="+empNo;
			 		
			Query qry=session.createSQLQuery(str);
			mstHOList=qry.list();			
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
		return mstHOList;
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
	
	
	


	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	

	

	
	

	

	

	
	
	
	
}
