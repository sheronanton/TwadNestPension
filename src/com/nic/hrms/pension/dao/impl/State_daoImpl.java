package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.ReligionDao;
import com.nic.hrms.pension.model.State_dao;
import com.nic.hrms.pension.service.State_service;

public class State_daoImpl implements State_service {
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")

	public List<State_dao> getListOfstates() {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<State_dao> stateobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			stateobj =  session.createCriteria(State_dao.class).list();
			System.out.println("stateobj..--------------------->" + stateobj);
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("-------------------------------> error in State daoImpl");
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return stateobj;
	}
	@SuppressWarnings("unchecked")
	public List<State_dao> getListOfstate() {
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<State_dao> stateObj =null;
		try
		{
			String myQry="select * from COM_MST_STATE";
			stateObj=session.createSQLQuery(myQry).list();
			
			System.out.println("--state list->----"+stateObj);
			//System.out.println("--state list 2->----"+qry);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return stateObj;
	}

}
