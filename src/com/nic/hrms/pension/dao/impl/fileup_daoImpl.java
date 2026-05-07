package com.nic.hrms.pension.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.Fileuploaddao;
import com.nic.hrms.pension.service.Fileupload_service;

public class fileup_daoImpl implements Fileupload_service{

	
	

	private SessionFactory sessionFactory;
	/*
	 * (non-Javadoc)
	 * @see com.nic.pension.service.Pension_service#saveuser(com.nic.pension.model.MstPension)
	 * SAVING THE DATA TO THE DATABASE
	 */
	
	public boolean saveupload(Fileuploaddao fileup) 
	{
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try 
		{			
			trans = session.beginTransaction();
			session.saveOrUpdate(fileup);
			trans.commit();
		} 
		catch (Exception e) 
		{		
			e.printStackTrace();
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
