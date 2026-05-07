package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.LastWorkingOfficeSearchService;

public class LastWorkingOfficeSearchDaoImpl implements LastWorkingOfficeSearchService {

	List<Object[]> list=null;
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")

	public List<Object[]> SearchOffice(String option,String keyword ) {
		
		
		// option==1 (OFFICE ID)
		if(option.equals("1"))
		{
		
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
			
				
				transaction = session.beginTransaction();
				 				
			
				String str="select t2.office_id,t2.office_name,t1.office_status_desc,t3.office_level_name,t2.office_level_id from MstOfficeStatusModel t1, MstOfficesModel t2 , MstOfficeLevelModel t3 where t2.office_status_id=t1.office_status_id and t2.office_level_id=t3.office_level_id and cast(t2.office_id as string) like '%"+keyword+ "%'";
				Query query=session.createQuery(str);
				
				
				list=query.list();
				transaction.commit();
			
				
			}
			
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			

			
			
		}
		
		
		
		
		// option==2 (OFFICE NAME)
		if(option.equals("2"))
		{
		
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
			
				
				transaction = session.beginTransaction();
			 				
				
				String str="select t2.office_id,t2.office_name,t1.office_status_desc,t3.office_level_name,t2.office_level_id from MstOfficeStatusModel t1, MstOfficesModel t2 , MstOfficeLevelModel t3 where t2.office_status_id=t1.office_status_id and t2.office_level_id=t3.office_level_id and (lower(t2.office_name) like '%"+keyword+"%')";
				
				Query query=session.createQuery(str);
				
				
				list=query.list();
				transaction.commit();
			
			
				
			}
			
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	
		// option==3(status search)
		
		if(option.equals("3"))
		{
		
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
			
				
				transaction = session.beginTransaction();
			 				
				
				String str="select t2.office_id,t2.office_name,t1.office_status_desc,t3.office_level_name,t2.office_level_id from MstOfficeStatusModel t1, MstOfficesModel t2 , MstOfficeLevelModel t3 where t2.office_status_id=t1.office_status_id and t2.office_level_id=t3.office_level_id and (lower(t1.office_status_desc) like '%"+keyword+ "%')";
				
				Query query=session.createQuery(str);
				
				
				list=query.list();
				transaction.commit();
			
		
			}
			
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	
		
		
		// option==4 (level desc)
		
		if(option.equals("4"))
		{
			
			
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
			
				
				transaction = session.beginTransaction();
				 				
				
				String str="select t2.office_id,t2.office_name,t1.office_status_desc,t3.office_level_name,t2.office_level_id from MstOfficeStatusModel t1, MstOfficesModel t2 , MstOfficeLevelModel t3 where t2.office_status_id=t1.office_status_id and t2.office_level_id=t3.office_level_id and (lower(t3.office_level_name) like '%"+keyword+ "%')";
				
				Query query=session.createQuery(str);
				
				
				list=query.list();
				transaction.commit();
			
				
				
			}
			
			
			catch(Exception e)
			{
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
	
}

