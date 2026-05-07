package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.CurrentAcMainOffice_dao;
import com.nic.hrms.pension.service.CurrentAcMainOffice_service;

public class CurrentAcMainOffice_daoImpl implements CurrentAcMainOffice_service {
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	public List<CurrentAcMainOffice_dao> getListOfOffice() {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<CurrentAcMainOffice_dao> currentacofficeobj = null;

		try{
			
			//trans = session.beginTransaction();
			/*currentacofficeobj =  session.createCriteria(CurrentAcMainOffice_dao.class)
			.add(Property.forName("accUnit").eq('y')).list();*/
			
			currentacofficeobj = session.createQuery("from CurrentAcMainOffice_dao order by currAccountOfficeName asc").list();
			
			//System.out.println("currentacofficeobj..--------------------->" + currentacofficeobj.size());
			
			
		}catch(Exception e){
			e.printStackTrace();
		
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return currentacofficeobj;
	}

}
