package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.model.Grade_dao;
import com.nic.hrms.pension.service.Grade_service;

public class Grade_daoImpl implements Grade_service{
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")

	public List<Grade_dao> getGrade() {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<Grade_dao> gradeobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			gradeobj =  session.createCriteria(Grade_dao.class).list();
			//System.out.println("gradeobj..--------------------->" + gradeobj);
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("-------------------------------> error in Grade daoImpl");
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return gradeobj;
	}

}
