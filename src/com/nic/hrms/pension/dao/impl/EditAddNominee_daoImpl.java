package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.AddNominee_dao;
import com.nic.hrms.pension.service.EditAddNominee_service;

public class EditAddNominee_daoImpl implements EditAddNominee_service{
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;
	
	
	

	@SuppressWarnings("unchecked")

	public List<AddNominee_dao> getListOfEditNominee(int ppoNoo) {
		
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<AddNominee_dao> editnomineeobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			editnomineeobj =  session.createCriteria(AddNominee_dao.class).add(Property.forName("ppoNo").eq(ppoNoo)).list();
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return editnomineeobj;
	}

}
