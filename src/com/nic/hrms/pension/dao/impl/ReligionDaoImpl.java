package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.service.ReligionService;

public class ReligionDaoImpl implements ReligionService {

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ReligionDao> getReligionList() 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<ReligionDao> myList=null;		
		try
		{
			tx=session.beginTransaction();
			myList=session.createCriteria(ReligionDao.class).list();
		tx.commit();
			System.out.println("---->>>"+myList);
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

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
