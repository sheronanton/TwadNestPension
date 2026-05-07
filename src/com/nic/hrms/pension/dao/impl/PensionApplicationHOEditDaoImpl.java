package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationHODetailsCoDao;
import com.nic.hrms.pension.model.PensionApplicationHODetailsValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeCoDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceCoDao;
import com.nic.hrms.pension.service.PensionApplicationHOEditService;

public class PensionApplicationHOEditDaoImpl implements PensionApplicationHOEditService {

	private SessionFactory sessionFactory;
	
	
	public boolean saveCommonData(PensionApplicationHODetailsCoDao coData) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		try
		{
			tx=session.beginTransaction();
			session.saveOrUpdate(coData);
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


	
	public PensionApplicationHODetailsCoDao getFullData(int empId,int officeId, int selectedId)
	{
		System.out.println("Inside HEAD DAOIMPL Action");
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true) ;		
		PensionApplicationHODetailsCoDao hoDataList=null;
		try
		{
	
			hoDataList=(PensionApplicationHODetailsCoDao) session.createCriteria((PensionApplicationHODetailsCoDao.class))
					.add(Property.forName("empNo").eq(selectedId)).uniqueResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return hoDataList;
	}
	
	


	
	@SuppressWarnings("unchecked")
	public List<PensionApplicationHONomineeCoDao> loadNominee(int empId,
			int officeId, int SearchId) {
		System.out.println("INSIDE NOMINEE DO IMPLPLPL"+SearchId);
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<PensionApplicationHONomineeCoDao> DataNominee=null;
		try
		{
			DataNominee=session.createCriteria(PensionApplicationHONomineeCoDao.class)
									.add(Property.forName("empNo").eq(SearchId)).list();
			System.out.println(DataNominee.size()+"--aaaaaaaaaaaaa");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return DataNominee;
		
	}

	
	@SuppressWarnings("unchecked")
	public List<PensionApplicationHOServiceCoDao> loadService(int empId,
			int officeId, int SearchId) {
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<PensionApplicationHOServiceCoDao> DataService=null;
		try
		{
			DataService=session.createCriteria(PensionApplicationHOServiceCoDao.class)
									.add(Property.forName("empNo").eq(SearchId)).list();
			System.out.println(DataService.size()+"--aaaaaaaaaaaaa");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return DataService;
	}
	
public String getDesignation(Integer desigId) {
		
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

public String getEmpIdFrz(Integer empId) {
	
	Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
	String strEmpIdFrz =null;
	try
	{
		String myQry="select emp_name from hrm_pen_app_ho_mst_form2_det where emp_no="+empId;
		Query qry=session.createSQLQuery(myQry);
		strEmpIdFrz=(String)qry.uniqueResult();
		System.out.println("--freeze date----"+strEmpIdFrz+"--"+empId);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}
	
	return strEmpIdFrz;
}

	public String getOfficeName(Integer officeId) 
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

	public boolean saveNominee(List<PensionApplicationHONomineeCoDao> coNominee) 
	{		
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PensionApplicationHONomineeCoDao penappnom=null;
		try {	
			Iterator iter = coNominee.iterator();
			trans = session.beginTransaction();			
			Query maxcount = session.createQuery("select max(nomineeId) from PensionApplicationHONomineeCoDao");
			
			while(iter!=null && iter.hasNext())
			{
				penappnom = new PensionApplicationHONomineeCoDao();
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
				penappnom =(PensionApplicationHONomineeCoDao)iter.next();
				penappnom.setNomineeId(maxnominee1);				
				session.save(penappnom);
			}
			
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

	


	public boolean saveNotVerifyService(List<PensionApplicationHOServiceCoDao> coService) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		PensionApplicationHOServiceCoDao myObj=null;
		try
		{
			Iterator myIt=coService.iterator();
			trans=session.beginTransaction();
			Query mycount=session.createQuery("select coalesce(max(id),'0') from PensionApplicationHOServiceCoDao");
			
			while(myIt!=null && myIt.hasNext())
			{
				myObj = new PensionApplicationHOServiceCoDao();
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
				System.out.println("MAX ID....>>>>>"+maxId1);
				myObj =(PensionApplicationHOServiceCoDao)myIt.next();
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

	
	public boolean addNomineeDelete(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		try
		{
			
			trans=session.beginTransaction();
			System.out.println("asasdas00"+empId);
			Query query = session.createQuery("delete from PensionApplicationHONomineeCoDao where empNo=:deleteEmp");
			query.setInteger("deleteEmp", empId);
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



	public boolean deleteNotVerify(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		try
		{
			trans=session.beginTransaction();
			Query qry=session.createQuery("delete from PensionApplicationHOServiceCoDao where empNo=:deleteEmp");
			qry.setInteger("deleteEmp", empId);
			qry.executeUpdate();
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

	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	@SuppressWarnings("unchecked")
	public List<Object[]> getMasterData(int empId) {
		System.out.println("Am in DAOIMPL MST DATA...");
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<Object[]> mstData=null;
		try
		{
			String myQry="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME, emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH," +
					" emp.GENDER,offi.office_name,desi.DESIGNATION,emp.TWAD_ENTRY_DATE,offi.OFFICE_ID,desi.DESIGNATION_ID," +
					" desi.SERVICE_GROUP_ID,post.OFFICE_GRADE from HRM_EMP_CURRENT_POSTING post  left outer join " +
					" HRM_MST_DESIGNATIONS desi on post.DESIGNATION_ID=desi.DESIGNATION_ID left outer join " +
					" com_mst_offices offi  on post.OFFICE_ID=offi.OFFICE_ID left outer join" +
					" HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID where emp.EMPLOYEE_ID="+empId;		
			Query query=session.createSQLQuery(myQry);	
			mstData=query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return mstData;
	}



	






	

	



	


}
