package com.nic.hrms.pension.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.service.EditCutOffSave_service;

public class EditCutOffSave_daoImpl implements EditCutOffSave_service{
	
	
private SessionFactory sessionFactory;

	public boolean editSaveCutOff(CutOffEntryPension_dao mstcutoffentry) 
	{
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try 
		{				
			trans = session.beginTransaction();
			session.saveOrUpdate(mstcutoffentry);
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
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}


