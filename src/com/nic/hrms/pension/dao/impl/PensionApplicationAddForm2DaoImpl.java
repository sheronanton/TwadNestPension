package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationIndividualNominee;
import com.nic.hrms.pension.model.PensionApplicationIndividualNotVerServ;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;
import com.nic.hrms.pension.service.PensionApplicationAddForm2Service;

public class PensionApplicationAddForm2DaoImpl implements PensionApplicationAddForm2Service{

	private SessionFactory sessionFactory;

	
	public boolean saveOrUpdateData(Object obj) 
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
			e.printStackTrace();		
			System.out.println("Error in SaveOrUpdate Record"+e);
			tx.rollback();
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean saveAddnominee(List<PensionApplicationNomineeDao> penappnominee) 
	{
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PensionApplicationNomineeDao penappnom=null;
		try {	
			Iterator iter = penappnominee.iterator();
			trans = session.beginTransaction();			
			Query maxcount = session.createQuery("select coalesce(max(nomineeId),'0') from PensionApplicationNomineeDao");
			
			while(iter!=null && iter.hasNext())
			{
				penappnom = new PensionApplicationNomineeDao();
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
				penappnom =(PensionApplicationNomineeDao)iter.next();
				penappnom.setNomineeId(maxnominee1);				
				session.save(penappnom);
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
	public boolean saveNotVerifyService(List<PensionApplicationNotVerifyServDetailsDao> notverserv) {

		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		PensionApplicationNotVerifyServDetailsDao myObj=null;
		try
		{
			Iterator myIt=notverserv.iterator();
			trans=session.beginTransaction();
			Query mycount=session.createQuery("select coalesce(max(id),'0') from PensionApplicationNotVerifyServDetailsDao");
			
			while(myIt!=null && myIt.hasNext())
			{
				myObj = new PensionApplicationNotVerifyServDetailsDao();
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
				myObj =(PensionApplicationNotVerifyServDetailsDao)myIt.next();
				myObj.setId(maxId1);				
				session.save(myObj);
			}
			
			trans.commit();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return false;
	}
	
	
	
	
	

	public boolean addNomineeDelete(int empId)
	{		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		try
		{
			
			trans=session.beginTransaction();
			System.out.println("asasdas00"+empId);
			Query query = session.createSQLQuery("delete from HRM_PEN_APP_NOMINEE_CO_FORM2 where EMP_NO="+empId);
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
			Query qry=session.createQuery("delete from PensionApplicationNotVerifyServDetailsDao where empNo=:deleteEmp");
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

	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getIndividualPersonnelData(int empId, int officeId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> myAppDataList=null;
		try
		{
			tx=session.beginTransaction();
			String myQry="SELECT emp_no,  father_name,  husband_name,  religion,  nationality,  emp_height,"
							+" id_mark1,  id_mark2,  present_address,  permanent_address,  address_after_retire,"
							+" state,  charges_flag,  charges_details,  payment_office_id,  application_date,"
							+" dcrg_nominee_name,  dcrg_nominee_dob,  dcrg_nominee_relation,  dcrg_nominee_address,"
							+" not_verify_service_tot_years,  not_verify_service_tot_months,  not_verify_service_tot_days"
							+" FROM hrm_pen_app_indivi_co where emp_no="+empId;			
			
			Query qry=session.createSQLQuery(myQry);
			myAppDataList=qry.list();
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
		return myAppDataList;
	}

	
	
	@SuppressWarnings("unchecked")
	public List<PensionApplicationIndividualNominee> getIndividualNominee(int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		List <PensionApplicationIndividualNominee> myNomineeList=null;
		try
		{
			tx=session.beginTransaction();			
			myNomineeList= session.createCriteria(PensionApplicationIndividualNominee.class).add(Property.forName("empNo").eq(empId)).list();					
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
		return myNomineeList;
	}

	@SuppressWarnings("unchecked")
	public List<PensionApplicationIndividualNotVerServ> getIndividualNVService(int empId) 
	{
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;		
		List <PensionApplicationIndividualNotVerServ> myNVServList=null;
		try
		{
			tx=session.beginTransaction();			
			myNVServList= session.createCriteria(PensionApplicationIndividualNotVerServ.class).add(Property.forName("empNo").eq(empId)).list();					
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
		return myNVServList;
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	


	

	

	


}
