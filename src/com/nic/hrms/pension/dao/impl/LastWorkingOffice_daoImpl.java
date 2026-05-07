package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.LastWorkingOffice_dao;
import com.nic.hrms.pension.service.LastWorkingOfficeCombo_service;

public class LastWorkingOffice_daoImpl implements LastWorkingOfficeCombo_service {
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")

	public List<LastWorkingOffice_dao> getListWorkingOffice() {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<LastWorkingOffice_dao> lastoffice = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			lastoffice =  session.createCriteria(LastWorkingOffice_dao.class).list();			
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();			
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return lastoffice;
	
	}
	
	

}
