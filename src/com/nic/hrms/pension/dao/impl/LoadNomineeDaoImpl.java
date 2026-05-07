package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.AddNominee_dao;
import com.nic.hrms.pension.model.ChangeNominee_dao;
import com.nic.hrms.pension.model.MstNominee_dao;
import com.nic.hrms.pension.service.LoadNomineeService;

public class LoadNomineeDaoImpl implements LoadNomineeService {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")

	public List<AddNominee_dao> loadNominee(int PPoNo) {
		List<AddNominee_dao> Nm=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		//System.out.println("My PoNo-->"+PPoNo);
		try {	
			
				trans = session.beginTransaction();
				
				Query qry=session.createQuery("from AddNominee_dao where ppoNo=:PPoNo");
				
				qry.setInteger("PPoNo", PPoNo);
				Nm=qry.list();
				
				trans.commit();
		
		} catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in Loading the records add nominee");
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return Nm;
	}


	@SuppressWarnings("unchecked")

	public List<MstNominee_dao> loadMstNominee(int PPoNo) {
		// TODO Auto-generated method stub
		List<MstNominee_dao> Nm=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		//System.out.println("My MstNominee_dao PoNo-->"+PPoNo);
		try {	
			
				trans = session.beginTransaction();
				
				Query qry=session.createQuery("from MstNominee_dao where ppoNo=:PPoNo");
				
				qry.setInteger("PPoNo", PPoNo);
				Nm=qry.list();
				
				trans.commit();
		
		} catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in Loading the records MstNominee_dao");
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return Nm;
	}


	@SuppressWarnings("unchecked")

	public List<ChangeNominee_dao> loadChangeNominee(int PPoNo) {
		// TODO Auto-generated method stub
		List<ChangeNominee_dao> Nm=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		//System.out.println("My ChangeNominee_dao PoNo-->"+PPoNo);
		try {	
			
				trans = session.beginTransaction();
				
				Query qry=session.createQuery("from ChangeNominee_dao where ppoNo=:PPoNo");
				
				qry.setInteger("PPoNo", PPoNo);
				Nm=qry.list();
				
				trans.commit();
		
		} catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in Loading the records ChangeNominee_dao");
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return Nm;
	}



	public boolean CheckNomineeValidated(int PPoNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		//System.out.println("My CheckNominee PpoNo-->"+PPoNo);
		try {	
			
				trans = session.beginTransaction();
				
				Query qry=session.createQuery("from ChangeNominee_dao where ppoNo=:PPoNo");
				
				qry.setInteger("PPoNo", PPoNo);
				
				
				if(!qry.list().isEmpty())
				{
					flag=true;
				}
				
				trans.commit();
		
		} catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in Check Nominee validation..");
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		return flag;
	}

}
