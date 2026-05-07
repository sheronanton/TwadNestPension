package com.nic.hrms.pension.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.Designation_service;
import com.nic.hrms.pension.model.DesignationCombo_dao;

public class Designationcombo_daoImpl implements Designation_service{
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")

	public List<DesignationCombo_dao> getDesignation(int gradeId) {
		
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<DesignationCombo_dao> desigobj = null;
		Transaction trans = null;
		try{
			
			trans = session.beginTransaction();
			desigobj =  session.createCriteria(DesignationCombo_dao.class).add(Property.forName("gradeId").eq(gradeId)).addOrder(Order.asc("orderSeqNo"))
			.list();
			
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return desigobj;
	}

}
