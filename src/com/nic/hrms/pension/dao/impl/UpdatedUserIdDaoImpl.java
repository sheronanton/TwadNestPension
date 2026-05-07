package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.UpdatedUserIdService;

public class UpdatedUserIdDaoImpl implements UpdatedUserIdService{

	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public int getOfficeId(int empId) {
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		int i = 0;
		try
		{
			 transaction = session.beginTransaction();
			 String str="select office_id from hrm_emp_current_posting where employee_id='"+empId+"'";
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 i = Integer.parseInt(""+obj.next());		
				 transaction.commit();       	
			 }
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println("Emp ID "+empId + "Office ID" +i);
		
		return i;
	}
	
	

	@SuppressWarnings("unchecked")
	public String getUpdateId(int empId) 
	{
		System.out.println("calling dao impl for empId");
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		String i = "";
		try
		{
			 transaction = session.beginTransaction();
			 String str="select user_id from sec_mst_users where employee_id='"+empId+"'";
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 i = (String) obj.next();		
				 transaction.commit();       	
			 }
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println("===================================>Emp ID "+empId + "User ID" +i);
		
		return i;
		
	}

	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	
	
	
	
	
	

}
