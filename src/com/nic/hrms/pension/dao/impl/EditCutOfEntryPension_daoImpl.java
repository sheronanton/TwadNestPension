package com.nic.hrms.pension.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.service.EditCutOfEntryPension_service;

public class EditCutOfEntryPension_daoImpl implements EditCutOfEntryPension_service {
	

	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	

	public CutOffEntryPension_dao getListOfEdit(int ppoNo){
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
	CutOffEntryPension_dao editcutobj = null;
	Transaction trans = null;
	try{
		
		trans = session.beginTransaction();
		
		editcutobj =  (CutOffEntryPension_dao) session.createCriteria(CutOffEntryPension_dao.class)
		.add(Property.forName("ppoNo").eq(ppoNo)).uniqueResult();
		
			trans.commit();
		
	}catch(Exception e){
		e.printStackTrace();
		
		
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}
	
	return editcutobj;
	}

	

}
