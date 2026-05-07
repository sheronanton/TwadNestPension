package com.nic.hrms.pension.dao.impl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.LoadPartialSave_service;

public class LoadPartialSave_daoImpl implements LoadPartialSave_service {
private SessionFactory sessionFactory;
	


	public int getListOfPartialSave(int ppoNo) 
	{
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);		
		int ppo=0;
		Transaction trans = null;
		try
		{
			trans = session.beginTransaction();
			Query qry=session.createSQLQuery("select ppo_no from HR_PEN_MST_CO where ppo_no="+ppoNo);			
			ppo=qry.executeUpdate();			
			trans.commit();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error during PPO No Check"+e);
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		
		return ppo;
	}



	
	/*public LoadPartialSave_dao getListOfPartialSave(int ppoNo) {
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		LoadPartialSave_dao  partialsaveobj = null;
		Transaction trans = null;
		
		try
		{
			trans = session.beginTransaction();
			Query qry=session.createQuery("from LoadPartialSave_dao where ppoNo="+ppoNo);
			List<LoadPartialSave_dao> liObj=qry.list();
			for(LoadPartialSave_dao kn:liObj)
			{
				partialsaveobj=kn;
			}
			partialsaveobj =  (LoadPartialSave_dao) session.createCriteria(LoadPartialSave_dao.class)
			.add(Property.forName("ppoNo").eq(ppoNo)).uniqueResult();			
			trans.commit();			
		}
		
		
	
		catch(Exception e){
			e.printStackTrace();
			System.out.println("-------------------------------> error in partial save daoImpl");
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return partialsaveobj;
	}*/
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
