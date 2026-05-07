package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.ClassOfpensionCombo_dao;
import com.nic.hrms.pension.service.ClassPensionCombo_service;

public class ClassOfPensionCombo_daoImpl implements ClassPensionCombo_service {
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;
	
	

	@SuppressWarnings("unchecked")

	public List<ClassOfpensionCombo_dao> getClassOfPension() {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<ClassOfpensionCombo_dao> classpensionobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			classpensionobj =  session.createCriteria(ClassOfpensionCombo_dao.class).list();
		
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return classpensionobj;
	}

}
