package com.nic.hrms.pension.dao.impl;


import java.util.Iterator;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.OfficeId_service;

public class officeId_daoImpl implements OfficeId_service{
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


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
			// System.out.println("hiiiiiiiii");
			 
			 while(obj.hasNext()){
			 i = Integer.parseInt(""+obj.next());
			// System.out.println("------------------------>i"+i);
			 }
			 /*for(Object[] tmp:list)
			 {
				 //i = (Integer)tmp[0];
				 
				 System.out.println((BigDecimal)tmp[0]);
			 }
			*/ 
			 transaction.commit();
        	
		}
		catch(Exception e){
				e.printStackTrace();
			}
		return i;
	   }
	
	
	}
	


 