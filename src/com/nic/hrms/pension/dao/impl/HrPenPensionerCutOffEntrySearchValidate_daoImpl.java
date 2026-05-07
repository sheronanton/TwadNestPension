package com.nic.hrms.pension.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.CutOffEntryPension_dao;
import com.nic.hrms.pension.service.HrPenPensionerCutOffEntrySearchValidated_service;

public class HrPenPensionerCutOffEntrySearchValidate_daoImpl implements HrPenPensionerCutOffEntrySearchValidated_service {
	
	private SessionFactory sessionFactory;

	private CutOffEntryPension_dao obj;

	@SuppressWarnings("unchecked")
	public List<Object[]> searchuser1(String searchText,String options,int empId ) {
		List<Object[]> list=null;
		
		///searching for ppo_no
		if(options.equals("1"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 String str="select ppo_no,employee_id,pensioner_name,class_description,process_status  from hr_pen_mst_co left outer join hrm_pen_mst_class_pension on hr_pen_mst_co.class_pension_id=hrm_pen_mst_class_pension.class_pension_id where (lower(ppo_no) like '%"+searchText+"%')and process_status='ENTERED' and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	       				
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		///searching for emp_no
		if(options.equals("2"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 String str="select ppo_no,employee_id,pensioner_name,class_description,process_status  from hr_pen_mst_co left outer join hrm_pen_mst_class_pension on hr_pen_mst_co.class_pension_id=hrm_pen_mst_class_pension.class_pension_id where  (lower(employee_id) like '%"+searchText+"%')and process_status='ENTERED' and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				  Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        				
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		///searching for pensioner_name
		if(options.equals("3"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 String str="select ppo_no,employee_id,pensioner_name,class_description,process_status  from hr_pen_mst_co left outer join hrm_pen_mst_class_pension on hr_pen_mst_co.class_pension_id=hrm_pen_mst_class_pension.class_pension_id where  (lower(pensioner_name) like '%"+searchText+"%')and process_status='ENTERED' and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	       				
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
		///searching for class_description
		if(options.equals("4"))
		{
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 String str="select ppo_no,employee_id,pensioner_name,class_description,process_status  from hr_pen_mst_co left outer join hrm_pen_mst_class_pension on hr_pen_mst_co.class_pension_id=hrm_pen_mst_class_pension.class_pension_id where  (lower(class_description) like '%"+searchText+"%')and process_status='ENTERED' and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	        				
			}
			catch(Exception e){
					e.printStackTrace();
				}
		}
			return list;	
	}
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		public void setObj(CutOffEntryPension_dao obj) {
			this.obj = obj;
		}
		public CutOffEntryPension_dao getObj() {
			return obj;
		}
		
	}
