package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.service.LastWorkingOfficeService;

public class LastWorkingOfficeDaoImpl implements LastWorkingOfficeService{

	private SessionFactory sessionFactory;
	
		
	@SuppressWarnings("unchecked")
	public List<Object[]> getOffice() {
		
		List<Object[]> list=null;
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;		
			
		try
		{		  
			
			String str="select t2.office_id,t2.office_name,t1.office_status_desc,t3.office_level_name from MstOfficeStatusModel t1, MstOfficesModel t2 , MstOfficeLevelModel t3 where t2.office_status_id=t1.office_status_id and t2.office_level_id=t3.office_level_id";
			transaction = session.beginTransaction();
			//Query query=session.createSQLQuery("select t2.OFFICE_ID,t2.OFFICE_NAME,t1.OFFICE_STATUS_DESC,t3.OFFICE_LEVEL_NAME from COM_MST_OFFICE_STATUS t1, COM_MST_OFFICES t2 , com_mst_office_levels t3 where t2.OFFICE_STATUS_ID=t1.OFFICE_STATUS_ID and t2.OFFICE_LEVEL_ID=t3.OFFICE_LEVEL_ID"); 				
				Query query=session.createQuery(str);
			list=query.list();
			transaction.commit();		
			
			
						
		 }
		catch(Exception e){
				e.printStackTrace();
			}
		
		finally{
				SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
			
		return list;		
			
		}
	

	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getOfficeDetails(int id) {
		
		 System.out.println("---------------------->>from LAST WORK DAO"+id);
	
		 List<Object[]> lastworkingobj=null;
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;		
			
		try
		{		  
			
			String str="select t2.office_id,t2.office_name,t1.office_status_desc,t3.office_level_name from MstOfficeStatusModel t1, MstOfficesModel t2 , MstOfficeLevelModel t3 where t2.office_status_id=t1.office_status_id and t2.office_level_id=t3.office_level_id and t2.office_id="+id;
			transaction = session.beginTransaction();
			//Query query=session.createSQLQuery("select t2.OFFICE_ID,t2.OFFICE_NAME,t1.OFFICE_STATUS_DESC,t3.OFFICE_LEVEL_NAME from COM_MST_OFFICE_STATUS t1, COM_MST_OFFICES t2 , com_mst_office_levels t3 where t2.OFFICE_STATUS_ID=t1.OFFICE_STATUS_ID and t2.OFFICE_LEVEL_ID=t3.OFFICE_LEVEL_ID"); 				
				Query query=session.createQuery(str);
				lastworkingobj=query.list();
			transaction.commit();		
			
			
						
		 }
		catch(Exception e){
				e.printStackTrace();
			}
		
		finally{
				SessionFactoryUtils.releaseSession(session, sessionFactory);
			}
			
		return lastworkingobj;		
			
		}
	

	
	
	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	
	
	
}	