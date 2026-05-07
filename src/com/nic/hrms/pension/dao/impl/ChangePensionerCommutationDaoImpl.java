package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.model.ChangeCommutationDao;
import com.nic.hrms.pension.model.ValidatePensionerDetails;
import com.nic.hrms.pension.service.ChangePensionerCommutationService;

public class ChangePensionerCommutationDaoImpl implements ChangePensionerCommutationService {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ValidatePensionerDetails loadMstCommutation(int PPONo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		ValidatePensionerDetails obj=null;
		try {	
			
				trans = session.beginTransaction();
				
				//session.createCriteria(ValidatePensionerDetails.class).
				obj=(ValidatePensionerDetails)session.load(ValidatePensionerDetails.class, PPONo);
				//System.out.println("ji");
				if(obj!=null)
				System.out.println("check2--->"+PPONo+"--\n--Amt- "+obj.getCommAmt()+"--1/3--"+obj.getCommfactorOnethird());
				
				trans.commit();
		
		} catch(Exception e) {
			obj=null;
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in getting Mstcommutation");
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		return obj;
	}

	public ChangeCommutationDao changedCommutationLoad(int ppoNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		ChangeCommutationDao obj=null;
		try {	
			
				trans = session.beginTransaction();
				
				//session.createCriteria(ChangeCommutationDao.class).
				obj=(ChangeCommutationDao)session.load(ChangeCommutationDao.class, ppoNo);
				//System.out.println("ji");
				if(obj!=null)
				System.out.println("check2 changed commutation--->"+ppoNo+"--\n--Amt- "+obj.getCommAmt()+"--1/3--"+obj.getCommFactorOneThird());
				
				trans.commit();
		
		} catch(Exception e) {
			obj=null;
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in getting Changedcommutation");
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> changedPPo(String searchText, String options,
			int empId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		///searching for ppo_no
		
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 String str="select distinct hrm_pen_mst_details.ppo_no,employee_id,pensioner_name,NVL(class_description,' ')," +
				 		"NVL(hrm_pen_mst_details.process_status,' ')  from (hrm_pen_mst_details left outer join" +
				 		" hrm_pen_mst_class_pension on hrm_pen_mst_details.class_pension_id=hrm_pen_mst_class_pension.class_pension_id ) " +
				 		" join hrm_pen_change_commutation  on hrm_pen_mst_details.ppo_no=hrm_pen_change_commutation.ppo_no" +
				 		" where  (lower("+options+") like lower('%"+searchText+"%')) and hrm_pen_mst_details.payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        for(Object[] tl: list)
				 {
					Object[] temp=tl;
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+temp[0]+"\t"+temp[1]+"\t"+temp[2]+"\t"+temp[3]+"\t"+temp[4]);
									
				 }					
			}
			catch(Exception e){
					e.printStackTrace();
				}
		
			
	return list;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> commutationPPO(String searchText, String options,
			int empId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		///searching for ppo_no
		
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 String str="select distinct hrm_pen_mst_details.ppo_no,employee_id,pensioner_name,NVL(class_description,' ')," +
				 		"NVL(hrm_pen_mst_details.process_status,' ')  from (hrm_pen_mst_details left outer join" +
				 		" hrm_pen_mst_class_pension on hrm_pen_mst_details.class_pension_id=hrm_pen_mst_class_pension.class_pension_id ) " +
				 		
				 		" where  (lower("+options+") like lower('%"+searchText+"%')) and hrm_pen_mst_details.payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        for(Object[] tl: list)
				 {
					Object[] temp=tl;
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+temp[0]+"\t"+temp[1]+"\t"+temp[2]+"\t"+temp[3]+"\t"+temp[4]);
									
				 }					
			}
			catch(Exception e){
					e.printStackTrace();
				}
		
			
	return list;
	}

	@SuppressWarnings("deprecation")
	public boolean validateChangedCommutation(int ppoNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try {
			trans = session.beginTransaction();
			CallableStatement call=session.connection().prepareCall("{call CHANGE_PENSIONER_COMMUTATION(?)}");
			call.setInt(1, ppoNo);
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

	public boolean commutationChange(ChangeCommutationDao ChangeComm) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try {	
			
				trans = session.beginTransaction();
				
				
				ChangeComm.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
					session.saveOrUpdate(ChangeComm);
				
				
				trans.commit();
		flag=true;
		} catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in Commutation change");
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return flag;
	}
	

}
