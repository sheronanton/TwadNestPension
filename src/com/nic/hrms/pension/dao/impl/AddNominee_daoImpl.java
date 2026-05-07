package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.AddNominee_dao;
import com.nic.hrms.pension.service.AddNominee_service;

public class AddNominee_daoImpl implements AddNominee_service{

	
   private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public boolean saveAddnominee(List<AddNominee_dao> addnominee) {       
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		AddNominee_dao addnomineeobj=null;
		try {	
			Iterator iter = addnominee.iterator();
			trans = session.beginTransaction();
			//Query maxcount = session.createQuery("select max(nomineeID) from AddNominee_dao");
			Query maxcount = session.createQuery("select coalesce(max(nomineeID),'0') from AddNominee_dao");
			
			while(iter!=null && iter.hasNext()){
				
				addnomineeobj = new AddNominee_dao();
				String maxnominee=null;
					try
					{
						maxnominee=maxcount.iterate().next().toString();
					}
					catch(Exception e)
					{
						
					}
			
				int maxnominee1 = maxnominee!=null?(Integer.parseInt(maxnominee))+1:1;
				addnomineeobj =(AddNominee_dao)iter.next();
				addnomineeobj.setNomineeID(maxnominee1);				
				session.save(addnomineeobj);
				
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

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}