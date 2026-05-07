package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2DetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstDetailsDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2MstNomineeDao;
import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2NomineeCo;
import com.nic.hrms.pension.model.FamilyPensionApplicationMstData;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathFieldForm2ValidateService;

public class FamilyPensionApplicationDeathFieldForm2ValidateDaoImpl implements FamilyPensionApplicationDeathFieldForm2ValidateService{

	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> searchData(String searchKey, String searchOption,int empNo) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;	
		List<Object[]> myList=null;
		try
		{
			tx=session.beginTransaction();
			String qryStr="SELECT emp.employee_id,emp.employee_name,desi.DESIGNATION,offi.OFFICE_NAME" +
					" FROM hrm_emp_current_posting post LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
					" LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id" +
					" LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
					" LEFT OUTER JOIN HRM_PEN_APP_FAM_CO_DET_FORM2 app ON app.emp_no = emp.employee_id" +
					" WHERE post.employee_id IN (SELECT employee_id FROM hrm_emp_controlling_office WHERE " +
					"controlling_office_id IN (SELECT office_id FROM hrm_emp_current_posting  WHERE employee_id = "+empNo+"))" +
					" AND emp.employee_id IN  (SELECT emp_no FROM HRM_PEN_APP_FAM_CO_DET_FORM2 WHERE process_status <> 'VALIDATE')" +
					" AND emp."+searchOption+" LIKE '%"+searchKey+"%'";
			Query qry=session.createSQLQuery(qryStr);
			myList=qry.list();
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
		return myList;
	}
	
	
	public FamilyPensionApplicationDeathFieldForm2DetailsDao getDetails(int empNo) {
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		FamilyPensionApplicationDeathFieldForm2DetailsDao myList = null;
		
		try
		{
			tx=session.beginTransaction();
			myList=(FamilyPensionApplicationDeathFieldForm2DetailsDao) session.createCriteria(FamilyPensionApplicationDeathFieldForm2DetailsDao.class)
			.add(Property.forName("empNo").eq(empNo)).uniqueResult();
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
		
		return myList;
	}


	
	@SuppressWarnings("unchecked")
	public List<Object[]> getMstData(int empNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> mstData=null;
		System.out.println("INSIDE MST DATA.....");
		try
		{
			tx=session.beginTransaction();
			String myQry=" SELECT emp.employee_id,emp.employee_name,emp.employee_initial,emp.gpf_no,emp.date_of_birth," +
					" emp.gender,offi.office_name,desi.designation,offi.office_id,desi.designation_id, desi.service_group_id," +
					" post.office_grade,serv.date_from  FROM  hrm_emp_current_posting post " +
					" LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id" +
					" LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id" +
					" LEFT OUTER JOIN hrm_emp_service_data serv ON serv.employee_id = " +empNo+
					" LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
					" LEFT OUTER JOIN PEN_ALLRETIREMENTVIEW vie ON vie.employee_id = emp.employee_id" +
					" WHERE post.employee_id = "+empNo+" AND serv.employee_id ="+empNo+ 
					"  AND serv.date_from =(SELECT MIN(date_from) FROM hrm_emp_service_data WHERE employee_id = "+empNo+")";
			Query qry=session.createSQLQuery(myQry);
			mstData=qry.list();
			System.out.println(mstData.size());
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
		return mstData;
	}

	@SuppressWarnings("unchecked")
	public List<FamilyPensionApplicationDeathFieldForm2NomineeCo> getNomineeList(
			int empNo, int officeId) {
		System.out.println("Nominee ....emp no......"+empNo);
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		List<FamilyPensionApplicationDeathFieldForm2NomineeCo> nomineeList=null;
		
		try
		{
			tx=session.beginTransaction();
			nomineeList=session.createCriteria(FamilyPensionApplicationDeathFieldForm2NomineeCo.class)
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
		return nomineeList;
		
	}

	

	public boolean saveDetails(FamilyPensionApplicationDeathFieldForm2MstDetailsDao detailsObj) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.saveOrUpdate(detailsObj);
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


	public boolean saveNominee(List<FamilyPensionApplicationDeathFieldForm2MstNomineeDao> nomineeObj) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
	
		FamilyPensionApplicationDeathFieldForm2MstNomineeDao fpenappnom=null;
		try {	
			Iterator iter = nomineeObj.iterator();
			tx = session.beginTransaction();			
			Query maxcount = session.createQuery("select coalesce(max(nomineeId),'0') from FamilyPensionApplicationDeathFieldForm2NomineeCo");
			
			while(iter!=null && iter.hasNext())
			{
				fpenappnom = new FamilyPensionApplicationDeathFieldForm2MstNomineeDao();
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
				fpenappnom =(FamilyPensionApplicationDeathFieldForm2MstNomineeDao)iter.next();
				fpenappnom.setNomineeId(maxnominee1);				
				session.save(fpenappnom);
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


	public boolean deleteNominee(int empNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			String delQry="delete from HRM_PEN_APP_FAM_MST_NOM_FORM2 where EMP_NO="+empNo;
			Query qry=session.createSQLQuery(delQry);
			qry.executeUpdate();
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
		return false;
	}



	public boolean deleteCoDetails(int empNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			String delQry="delete from HRM_PEN_APP_FAM_CO_DET_FORM2 where EMP_NO="+empNo;
			Query qry=session.createSQLQuery(delQry);
			qry.executeUpdate();
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
		return false;
		
	}


	public boolean deleteCoNominee(int empNo) 
	{
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			String delQry="delete from HRM_PEN_APP_FAM_CO_NOMIN_FORM2 where EMP_NO="+empNo;
			Query qry=session.createSQLQuery(delQry);
			qry.executeUpdate();
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
		return false;
	}


	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	

	

	

	
}
