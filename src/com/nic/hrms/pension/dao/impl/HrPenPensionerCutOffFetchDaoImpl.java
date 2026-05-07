package com.nic.hrms.pension.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.HrPenPensionerCutOffFetchModel;

import com.nic.hrms.pension.service.HrPenPensionerCutOffFetchService;



public class HrPenPensionerCutOffFetchDaoImpl implements HrPenPensionerCutOffFetchService {
	
	private SessionFactory sessionFactory;
	private HrPenPensionerCutOffFetchModel fetchModelObj;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	
	@SuppressWarnings("unchecked")
	public List<HrPenPensionerCutOffFetchModel> fetch(int employeeId) {
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		fetchModelObj=new HrPenPensionerCutOffFetchModel();
		
		ArrayList arrLst=new ArrayList();
		Transaction trans = null;
	
		try{
			
			// System.out.println("------------------------------------------------------employeeId"+employeeId);
		     trans = session.beginTransaction();
		     String str="select f.employeeName,f.employeeInitial,f.employeePrefix, f.panNo, f.dateOfBirth,f.gender from HrPenPensionerCutOffFetchModel f where f.employeeId="+employeeId;
		    // System.out.println("-----------------------------------------------------afetr str");
		     Query query=session.createQuery(str);		
		     List list=query.list();
			// int a=list.size();
			// System.out.println("------------------------------------------->size"+a);
		for(Iterator iter=list.iterator();iter.hasNext();) {
              //private String gender;
				 Object[] obj=(Object[])iter.next();
          		 fetchModelObj.setEmployeeName(obj[0].toString());
          	//	 System.out.println("--------NAME obj[0]--"+obj[0]);
          		 
				 fetchModelObj.setEmployeeInitial(obj[1].toString());
				// System.out.println("--------INTIAL obj[1]--"+obj[1]);
				 
				 fetchModelObj.setEmployeePrefix(obj[2].toString());
				// System.out.println("------ PREFIX --obj[2]--"+obj[2]);
				 
			//	 fetchModelObj.setPanNo(obj[3].toString());
				 
				// System.out.println("---PAN NO -----obj[1]--"+obj[3]);
				 
				 fetchModelObj.setDateOfBirth((Date)obj[4]);
				// System.out.println("-----dob ---obj[4]--"+obj[4]);
				 
				 fetchModelObj.setGender(obj[5].toString());
				// System.out.println("-----dob ---obj[5]--"+obj[5]);
				 
				 arrLst.add(fetchModelObj);
			
				 
				/* System.out.println("--------obj[0]--"+obj[0]);
				 System.out.println("--------obj[1]--"+obj[1]);
				 System.out.println("--------obj[2]--"+obj[2]);
				// System.out.println("--------obj[3]--"+obj[3]);
				 System.out.println("--------obj[4]--"+obj[4]);
				 System.out.println("--------obj[5]--"+obj[5]);*/
			 
				 trans.commit();
			 }
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("------------------------------------------->Error in Search Service"+e);
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return arrLst;
	}

}
