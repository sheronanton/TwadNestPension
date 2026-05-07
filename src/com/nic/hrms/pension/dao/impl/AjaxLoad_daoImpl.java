package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.AjaxLoad_dao;
import com.nic.hrms.pension.service.AjaxLoad_service;




public class AjaxLoad_daoImpl implements AjaxLoad_service 
{

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<AjaxLoad_dao> getListOfBank()
	{
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<AjaxLoad_dao> ajaxobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			ajaxobj =  session.createCriteria(AjaxLoad_dao.class).list();
			
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return ajaxobj;
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
