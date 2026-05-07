package com.nic.hrms.pension.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.model.DesignationCombo_dao;
import com.nic.hrms.pension.service.Desiggroup_service;


public class Desiggroup_daoImpl implements Desiggroup_service {

	
private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@SuppressWarnings("unchecked")

	public List<DesignationCombo_dao> getListOfDesig(int searchVPpoNo) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<DesignationCombo_dao> designationobj = null;
		CutOffEntryPension_dao mstppono = null;
		Transaction trans = null;
		
		try{
			
			trans = session.beginTransaction();
			mstppono =  (CutOffEntryPension_dao) session.createCriteria(CutOffEntryPension_dao.class)
			.add(Property.forName("ppoNo").eq(searchVPpoNo)).uniqueResult();
				/*"select DESIG_SERVICE_GRP from HR_PEN_MST_CO where PPO_NO="+searchVPpoNo);*/
			
				
			int gradeId  = mstppono.getDesigServGrp()==null?0:mstppono.getDesigServGrp();
					 
			designationobj =  session.createCriteria(DesignationCombo_dao.class).add(Property.forName("gradeId").eq(gradeId)).list();
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return designationobj;
	}

	
}
