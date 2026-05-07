package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.AjaxCombo_dao;
import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.service.BranchList_service;

public class BranchList_daoImpl implements BranchList_service {
	
	
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<AjaxCombo_dao> getBranchList(int ppo_no , int officeId ) {
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<AjaxCombo_dao> branchobj = null;
		CutOffEntryPension_dao branppono = null;
		Transaction trans = null;
		try
		{
			trans = session.beginTransaction();			
			branppono =  (CutOffEntryPension_dao) session.createCriteria(CutOffEntryPension_dao.class)
			.add(Property.forName("ppoNo").eq(ppo_no)).uniqueResult();			
			
			/*Query query=session.createSQLQuery("select BANK_ID from HR_PEN_MST_CO where PPO_NO="+ppo_no);
			bankId1=query.uniqueResult();
			int bankId = Integer.parseInt( bankId1.toString());*/
			
			int bankId = branppono.getBankId()==null?0:branppono.getBankId(); 
			branchobj =  session.createCriteria(AjaxCombo_dao.class).add(Property.forName("bankId").eq(bankId))
			.add(Property.forName("officeId").eq(officeId)).list(); 			
			
			trans.commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return branchobj;
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
