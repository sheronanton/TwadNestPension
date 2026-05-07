package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.service.PensionPaymentOffice_service;

public class PensionPaymentOffice_daoImpl implements PensionPaymentOffice_service {
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")

	public List<PensionPaymentOffice_dao> getListOfPayOffice(int officeId) {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<PensionPaymentOffice_dao> paymentobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			paymentobj = session.createQuery("from PensionPaymentOffice_dao where PenisonPaymentOffice='Y'and currAccountOfficeId='"+officeId+"'").list();
			 
			//System.out.println("paymentobj..--------------------->" + paymentobj);
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("-------------------------------> error in payment office combo daoImpl");
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return paymentobj;
		
	}

}
