package com.nic.hrms.pension.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;



import com.nic.hrms.pension.service.MstNomineeSearchService;



public class MstNomineeSearchDaoImpl implements MstNomineeSearchService {
	
	private SessionFactory sessionFactory;

	
	
@SuppressWarnings("unchecked")
public List<Object[]> SearchThings(String searchText,String options,int empId ) {
	
	List<Object[]> list=null;
	///searching for ppo_no
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		try
		{
			 transaction = session.beginTransaction();
			 /*String str="select distinct ppo_no,employee_id,pensioner_name,class_description," +
			 		"process_status from (hrm_pen_mst_details left outer join" +
			 		" hrm_pen_mst_class_pension on hrm_pen_mst_details.class_pension_id=hrm_pen_mst_class_pension.class_pension_id ) " +
			 		" join hrm_pen_mst_nominee  on hrm_pen_mst_details.ppo_no=hrm_pen_mst_nominee.ppo_no" +
			 		" where  (lower("+options+") like lower('%"+searchText+"%')) and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";*/
			 
			 
			 //without join nominee tables
			 String str="select distinct ppo_no,employee_id,pensioner_name,class_description," +
		 		"process_status from (hrm_pen_mst_details left outer join" +
		 		" hrm_pen_mst_class_pension on hrm_pen_mst_details.class_pension_id=hrm_pen_mst_class_pension.class_pension_id ) " +
		 		" where  (lower("+options+") like lower('%"+searchText+"%')) and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
		 
			 Query query=session.createSQLQuery(str);	
			 list=query.list();
			 transaction.commit();
        				
		}
		catch(Exception e){
				e.printStackTrace();
			}
	
		return list;	
}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")

	public List<Object[]> ChangedSearchThings(String searchText,String options, int empId) {
		
		List<Object[]> list=null;
			Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
			Transaction transaction = null;
			try
			{
				 transaction = session.beginTransaction();
				 String str="select distinct hrm_pen_mst_details.ppo_no,employee_id,pensioner_name,class_description," +
				 		"process_status from (hrm_pen_mst_details left outer join" +
				 		" hrm_pen_mst_class_pension on hrm_pen_mst_details.class_pension_id=hrm_pen_mst_class_pension.class_pension_id ) " +
				 		" join hrm_pen_change_nominee  on hrm_pen_mst_details.ppo_no=hrm_pen_change_nominee.ppo_no" +
				 		" where  (lower("+options+") like lower('%"+searchText+"%')) and  ppo_no in (select ppo_no from hrm_pen_change_nominee) and payment_office_id=(select office_id from hrm_emp_current_posting where employee_id='"+empId+"')";
				 Query query=session.createSQLQuery(str);	
				 list=query.list();
				 transaction.commit();
	       					
			}
			catch(Exception e){
					e.printStackTrace();
				}
		
			return list;	
	}
	
	
}
