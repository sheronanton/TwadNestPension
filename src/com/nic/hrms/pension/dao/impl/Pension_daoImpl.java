package com.nic.hrms.pension.dao.impl;



import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.model.MstPension;
import com.nic.hrms.pension.service.Pension_service;

public class Pension_daoImpl implements  Pension_service{

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private SessionFactory sessionFactory;
	/*
	 * (non-Javadoc)
	 * @see com.nic.pension.service.Pension_service#saveuser(com.nic.pension.model.MstPension)
	 * SAVING THE DATA TO THE DATABASE
	 */
	
	public boolean saveuser(MstPension mstpension) {
		
		//System.out.println("---------------------------------");
		//System.out.println(mstpension.getClassDesc());
		//System.out.println(mstpension.getClassId());
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
			Transaction trans = null;
		try {			
			trans = session.beginTransaction();
			session.save(mstpension);
			trans.commit();
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		return true;
	}

	/* 
	 * (non-Javadoc)
	 * @see com.nic.pension.service.Pension_service#getAllClassOfPension()
	 * GETTING THE DATA AND PUTTING THE LIST TO THE DATABASE
	 */
	
	@SuppressWarnings("unchecked")

	public List<MstPension> getAllClassOfPension() {
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<MstPension> mstpensionobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			mstpensionobj =  session.createCriteria(MstPension.class).list();
			trans.commit();
			
		}catch(Exception e){
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return mstpensionobj;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.nic.pension.service.Pension_service#getAllClassOfPension()
	 * DELETING THE DATA FROM THE CLASS OF PENSION RECORD
	 */
	public boolean updateuser(String classId,String classDesc){
		//System.out.println("classID="+classId);
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try{
			//System.out.println("--------------------->classid"+classId);
			trans=session.beginTransaction();
			Query query = session.createQuery("update MstPension set classDesc =:classDesc where classId=:classId");
			query.setString("classId",classId);
			query.setString("classDesc",classDesc);
			query.executeUpdate();
			trans.commit();
					
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("data is not removed from the database");
			return false;
		}finally{
			
		}
		
		return true;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.nic.pension.service.Pension_service#getAllClassOfPension()
	 * UPDATING THE DATA FROM THE CLASS OF PENSION
	 */
	public boolean deleteuser(String classId){
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try{
			//System.out.println("--------------------->classid"+classId);
			trans=session.beginTransaction();
			Query query = session.createQuery("delete from MstPension where classId=:classId");
			query.setString("classId",classId);
			query.executeUpdate();
			trans.commit();
						
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("updating user is not done");
			return false;
		}finally{
			
		}
		
		return true;
	}
}


/* Transaction trans = null;
			trans = session.beginTransaction();
			SessionFactory fact = new Configuration().configure().buildSessionFactory();
			System.out.println("class id ="+classId);
		Query sql =session.createQuery("update class_desc where classId=:classId");
			sql.setString("classId",classId);
			session = fact.openSession();
			String sqldelete ="delete class_of_pension where class_id = :classId";	
			int row =session.createSQLQuery(sqldelete).setString("classId",classId).executeUpdate();
			trans.commit();
			if(row==0){
				System.out.println("row is not deleted");
			}else{
				System.out.println("row is deleted");
			}*/
