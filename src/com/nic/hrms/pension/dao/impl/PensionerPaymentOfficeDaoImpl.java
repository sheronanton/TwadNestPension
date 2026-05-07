package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.service.PensionerPaymentOfficeService;

public class PensionerPaymentOfficeDaoImpl implements PensionerPaymentOfficeService{

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<PensionPaymentOffice_dao> getListOfPayOffice() {
		

		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<PensionPaymentOffice_dao> paymentobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			paymentobj = session.createQuery("from PensionPaymentOffice_dao where PenisonPaymentOffice='Y'").list();
			 
			System.out.println("paymentobj..--------------------->" + paymentobj);
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("-------------------------------> error in payment office combo daoImpl");
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return paymentobj;
		
	}
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
