package com.nic.hrms.pension.dao.impl;



import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;



import com.nic.hrms.pension.model.ChangePensionerPaymentOffice_dao;
import com.nic.hrms.pension.model.ValidateCutOffDetails_dao;
import com.nic.hrms.pension.service.ChangePensionerPaymentOfficeService;

public class ChangePensionerPaymentOfficeDaoImpl implements ChangePensionerPaymentOfficeService {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")	
	public int paymentOfficeLoad(int ppoNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		int paymentOfficeId=0;
		try {	
			
				trans = session.beginTransaction();
				
				Query qry=session.createQuery("from ValidateCutOffDetails_dao where ppoNo=:ppoNo");
				qry.setInteger("ppoNo", ppoNo);
				List<ValidateCutOffDetails_dao> li=qry.list();
				for(ValidateCutOffDetails_dao tmp:li)
				{
					paymentOfficeId=tmp.getPaymentOfficeId();
				}
				
				trans.commit();
		
		} catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in getting payment office id");
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		return paymentOfficeId;
	}

	
	public boolean paymentOfficeChange(ChangePensionerPaymentOffice_dao cppOffice) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try {	
			
				trans = session.beginTransaction();
				
				
				//cppOffice.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
					session.saveOrUpdate(cppOffice);
				
				
				trans.commit();
		flag=true;
		} catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("--------------------------------------->error in paymentOffice change");
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return flag;
	}

	@SuppressWarnings("unchecked")
	
	public List<Object[]> changedPPo(String searchText, String options, int empId) {
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
				 		" join hrm_pen_change_payment_office  on hrm_pen_mst_details.ppo_no=hrm_pen_change_payment_office.ppo_no" +
				 		" where  (lower("+options+") like lower('%"+searchText+"%')) and hrm_pen_mst_details.payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        for(Object[] tl: list)
				 {
					Object[] temp=tl;
				//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+temp[0]+"\t"+temp[1]+"\t"+temp[2]+"\t"+temp[3]+"\t"+temp[4]);
									
				 }					
			}
			catch(Exception e){
					e.printStackTrace();
				}
		
			
	return list;
	}

	@SuppressWarnings("unchecked")
	
	public String changedPaymentOfficeLoad(int ppoNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		String paymentOfficeId=null;
		try {	
			
				trans = session.beginTransaction();				
				Query qry=session.createQuery("from ChangePensionerPaymentOffice_dao where ppoNo=:ppoNo");
				qry.setInteger("ppoNo", ppoNo);
				List<ChangePensionerPaymentOffice_dao> li=qry.list();
				for(ChangePensionerPaymentOffice_dao tmp:li)
				{
					paymentOfficeId=tmp.getPaymentOfficeId()+"@"+tmp.getReason();
				}
				
				trans.commit();
		
		} catch(Exception e) {
		
		e.printStackTrace();
		System.out.println("--------------------------------------->error in getting payment office id");
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		return paymentOfficeId;
		
	}

	@SuppressWarnings("deprecation")
	
	public boolean validateChangedPaymentOffice(int ppoNo) {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		try {
			trans = session.beginTransaction();
			CallableStatement call=session.connection().prepareCall("{call CHANGE_PENSIONER_PAYMENTOFFICE(?)}");
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

	@SuppressWarnings("unchecked")
	public List<Object[]> paymentOfficePPO(String searchText, String options,
			int empId) {
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

}
