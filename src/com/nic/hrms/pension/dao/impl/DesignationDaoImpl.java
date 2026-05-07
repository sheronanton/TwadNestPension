package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import com.nic.hrms.pension.service.Designationservice;
import com.nic.hrms.pension.model.Designationmodel;

public class DesignationDaoImpl implements Designationservice {
   
	private SessionFactory sessionFactory;
	 
	@SuppressWarnings("unchecked")
	public List<Designationmodel> getDesignation() {
		// TODO Auto-generated method stub
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Designationmodel> myList=null;		
		try
		{
			tx=session.beginTransaction();
			myList=session.createCriteria(Designationmodel.class).list();
			//System.out.println("daoimpl======"+myList.size());
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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
