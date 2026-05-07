package com.nic.hrms.pension.dao.impl;

import java.util.List;

import com.nic.hrms.pension.model.AjaxCombo_dao;
import com.nic.hrms.pension.service.AjaxCombo_service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class Ajaxcombo_daoImpl implements AjaxCombo_service {
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")

	public List<AjaxCombo_dao> getListOfBranch(int bankId , int officeId) {
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<AjaxCombo_dao> ajaxobj = null;
		Transaction trans = null;
		try
		{			
			trans = session.beginTransaction();			
		    ajaxobj =  session.createCriteria(AjaxCombo_dao.class).add(Property.forName("bankId").eq(bankId))
		    .add(Property.forName("officeId").eq(officeId)).list();			
			trans.commit();			
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return ajaxobj;
		
	}

}
