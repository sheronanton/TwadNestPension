package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.FamilyPensionApplicationDeathFieldForm2NomineeCo;
import com.nic.hrms.pension.service.FamilyPensionApplicationDeathFieldForm2Service;

public class FamilyPensionApplicationDeathFieldForm2DaoImpl implements FamilyPensionApplicationDeathFieldForm2Service{

	private SessionFactory sessionFactory=null;
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getMstData(int empNo, int loginEmpId) 
	{
		List<Object[]> mstList=null;
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		try
		{
			tx=session.beginTransaction();
			String str="SELECT emp.employee_id,emp.employee_name, emp.employee_initial, emp.gpf_no, emp.date_of_birth, emp.gender," +
					" offi.office_name, desi.designation, offi.office_id, desi.designation_id, desi.service_group_id, post.office_grade," +
					" serv.date_from,death.RELIGION_ID,death.NATIONALITY,death.ID_MARK1,death.ID_MARK2,death.PRESENT_ADDRESS,death.STATE_ID," +
					" death.PENSION_PAY_OFFICE_ID,death.CLAIMENT_NAME,death.CLAIMENT_DOB,death.CLAIMENT_AGE,death.GUARDIAN_NAME,death.GUARDIAN_DOB," +
					" death.GUARDIAN_RELATION_MINOR,death.GUARDIAN_RELATION_EMP,death.EMPLOYEE_DEATH_DATE,death.ADDRESS " +
					" FROM hrm_emp_current_posting post " +
					" LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
					" LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
					" LEFT OUTER JOIN hrm_emp_service_data serv ON serv.employee_id = "+empNo+
					" LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id" +
					" LEFT OUTER JOIN PEN_ALLRETIREMENTVIEW vie ON vie.employee_id = emp.employee_id " +
					" left JOIN  HRM_PEN_APP_FAM_CO_DET_FORM2 death on death.EMP_NO=emp.employee_id "+
					" WHERE post.employee_id = "+empNo+					
					"  AND serv.employee_id = "+empNo+ " AND serv.date_from =(SELECT MIN(date_from) FROM hrm_emp_service_data  WHERE employee_id = "+empNo+") "+
			 		"  AND emp.employee_id in (select EMPLOYEE_ID from  HRM_EMP_CONTROLLING_OFFICE   where  " +
			 		"  CONTROLLING_OFFICE_ID  in( select OFFICE_ID from  HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+loginEmpId+"))";
			System.out.println(str);
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

	
	public boolean saveRecord(Object obj) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;	
		try
		{			
			tx=session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
		}
		catch(Exception  e)
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

	
	public boolean saveAddnominee(List<FamilyPensionApplicationDeathFieldForm2NomineeCo> penappnominee) 
	{
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		FamilyPensionApplicationDeathFieldForm2NomineeCo fpenappnom=null;
		try {	
			Iterator iter = penappnominee.iterator();
			trans = session.beginTransaction();			
			Query maxcount = session.createQuery("select coalesce(max(nomineeId),'0') from FamilyPensionApplicationDeathFieldForm2NomineeCo");
			
			while(iter!=null && iter.hasNext())
			{
				fpenappnom = new FamilyPensionApplicationDeathFieldForm2NomineeCo();
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
				fpenappnom =(FamilyPensionApplicationDeathFieldForm2NomineeCo)iter.next();
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
	
	@SuppressWarnings("unchecked")
	public List<FamilyPensionApplicationDeathFieldForm2NomineeCo> getNomineeList(int empNo, int officeId) 
	{
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


	public boolean deleteNominee(int empNo) 
	{
		System.out.println("DELETE CALLING ........");
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		try
		{			
			trans=session.beginTransaction();		
			Query query = session.createQuery("delete from FamilyPensionApplicationDeathFieldForm2NomineeCo where empNo=:deleteEmp");
			query.setInteger("deleteEmp", empNo);
			query.executeUpdate();
			trans.commit();
		}
		catch(Exception e)
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
	

	@SuppressWarnings("unchecked")
	public List<Object[]> searchMethod(String option, String keyword,int loginEmpId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> searchList=null;
		try
		{
			tx=session.beginTransaction();
			String str="SELECT emp.employee_id,emp.employee_name,desi.DESIGNATION,offi.OFFICE_NAME" +
					" FROM hrm_emp_current_posting post LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
					" LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id" +
					" LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +					
					" WHERE post.employee_id IN (SELECT employee_id FROM hrm_emp_controlling_office WHERE " +
					"controlling_office_id IN (SELECT office_id FROM hrm_emp_current_posting  WHERE employee_id = "+loginEmpId+"))" +					
					" AND emp."+option+" LIKE '%"+keyword+"%'";
			Query qrySearch=session.createSQLQuery(str);
			searchList=qrySearch.list();			
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
		return searchList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> chkAvailablity2(int searchEmpId, int loginId) 
	{		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		List<Object[]> chkList=null;
		try
		{
			trans=session.beginTransaction();
			Query myQry=session.createSQLQuery("select EMP_NO,CLAIMENT_NAME from HRM_PEN_APP_FAM_MST_DET_FORM2 where EMP_NO="+searchEmpId);
			chkList=myQry.list();
			trans.commit();
		
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
	
		return chkList;
	}

	public List<Object[]> chkAvailablity1(int searchEmpId, int loginId) 
	{		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		List<Object[]> chkList1=null;
		try
		{
			trans=session.beginTransaction();
			Query myQry1=session.createSQLQuery("select EMP_ID,EMP_NAME from HRM_PEN_APP_MST_FORM1_DET where EMP_ID="+searchEmpId);
			chkList1=myQry1.list();
			trans.commit();
		
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
	
		return chkList1;
	}
	
	
	public List<Object[]> getCoDetails(int empNo, int loginEmpId) 
	{
		try
		{
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			
		}
		return null;
	}

	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	


	






	
	
}
