package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.ChangeNominee_dao;
import com.nic.hrms.pension.service.AddChangeNomineeService;

public class AddChangeNomineeDaoImpl implements AddChangeNomineeService {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean addChangeNominee(List<ChangeNominee_dao> myLi) {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try {	
			
				trans = session.beginTransaction();
				
				for(ChangeNominee_dao cDao:myLi)
				{
					//cDao.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
					//System.out.println("id in daoimpl"+cDao.getNomineeID());
					session.save(cDao);
				}
				
				trans.commit();
		flag=true;
		} catch(Exception e) {
	
		e.printStackTrace();
		System.out.println("--------------------------------------->error in adding records Chage Nominee"+e);
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return flag;
	}
	
	@SuppressWarnings("deprecation")

	public boolean validateChangeNominee(int PPoNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try {
			trans = session.beginTransaction();
			CallableStatement call=session.connection().prepareCall("{call change_nominee(?)}");
			call.setInt(1, PPoNo);
			System.out.println("Callable updated--"+call.executeUpdate());
			flag=true;
			trans.commit();
			}
		catch(Exception e)
		{
			trans.rollback();
			System.out.println("Except----"+e);
		}
		return flag;
	}


	public boolean deleteChangeNominee(int PPoNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try {
			trans = session.beginTransaction();
			Query query=session.createSQLQuery("delete from hrm_pen_change_nominee where ppo_no="+PPoNo);
			System.out.println("The row execute updated---->"+query.executeUpdate());
			flag=true;
			trans.commit();
			}
		catch(Exception e)
		{
			trans.rollback();
			System.out.println("Except----"+e);
		}
		return flag;
	}

}
