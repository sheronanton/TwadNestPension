package com.nic.hrms.pension.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.model.PensionApplicationHODetailsCoDao;
import com.nic.hrms.pension.model.PensionApplicationHODetailsValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeCoDao;
import com.nic.hrms.pension.model.PensionApplicationHONomineeValidateDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceCoDao;
import com.nic.hrms.pension.model.PensionApplicationHOServiceValidateDao;
import com.nic.hrms.pension.service.PensionApplicationHOValidateService;

public class PensionApplicationHOValidateDaoImpl implements PensionApplicationHOValidateService{

	public SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getListEmp() {
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<Object[]> listData=null;		
		try
		{
			String str="select mst.EMP_NO,mst.EMP_NAME,design.DESIGNATION,offi.OFFICE_NAME " +
			" from HRM_PEN_APP_HO_CO_FORM2_DET mst LEFT OUTER JOIN HRM_EMP_CURRENT_POSTING post "+
            " ON mst.emp_no=post.employee_id left outer join HRM_MST_DESIGNATIONS design "+
			" on post.DESIGNATION_ID=design.DESIGNATION_ID left outer join COM_MST_OFFICES offi "+
			" on offi.OFFICE_ID=mst.OFFICE_ID"+
			" WHERE mst.emp_no not in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')";
			/*String str="select mst.EMP_NO,mst.EMP_NAME,design.DESIGNATION,offi.OFFICE_NAME " +
						" from HRM_PEN_APP_HO_CO_FORM2_DET mst left outer join HRM_MST_DESIGNATIONS design "+
						" on mst.DESIG_ID=design.DESIGNATION_ID left outer join COM_MST_OFFICES offi "+
						" on offi.OFFICE_ID=mst.OFFICE_ID"+
						" WHERE mst.emp_no not in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')";*/
			Query qry=session.createSQLQuery(str);
			listData=qry.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return listData;
	}
	
	@SuppressWarnings("unchecked")
	public Integer penAppEmpdesigination(int empId,int loginEmpOfficeId) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		Integer i = 0;
		try
		{
			 transaction = session.beginTransaction();
			 String str="select DESIGNATION_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId+" and OFFICE_ID="+loginEmpOfficeId;
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 i = Integer.parseInt(""+obj.next());		
				       	
			 }
			 transaction.commit();
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return i;
	   
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getSearchList(String Keyword, String option, int empId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<Object[]> listSearchData=null;
		try
		{
			/*String str="select mst.EMP_NO,mst.EMP_NAME,design.DESIGNATION,offi.OFFICE_NAME " +
				" from HRM_PEN_APP_HO_CO_FORM2_DET mst left outer join HRM_MST_DESIGNATIONS design "+
				" on mst.DESIG_ID=design.DESIGNATION_ID left outer join COM_MST_OFFICES offi "+
				" on offi.OFFICE_ID=mst.OFFICE_ID where "+option+" like '%"+Keyword+"%'" +
				" AND mst.emp_no not in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')";*/
			
			System.out.println("option--------->"+option);
			System.out.println("keyword--------->"+Keyword);
			
			String str="select mst.EMP_NO,mst.EMP_NAME,design.DESIGNATION,offi.OFFICE_NAME " +
			" from HRM_PEN_APP_HO_CO_FORM2_DET mst LEFT OUTER JOIN HRM_EMP_CURRENT_POSTING post "+
            " ON mst.emp_no=post.employee_id left outer join HRM_MST_DESIGNATIONS design "+
			" on post.DESIGNATION_ID=design.DESIGNATION_ID left outer join COM_MST_OFFICES offi "+
			" on offi.OFFICE_ID=mst.OFFICE_ID where cast("+option+" as TEXT ) like '%"+Keyword+"%'" +
			" AND mst.emp_no not in (select emp_no from hrm_pen_app_authorization_org where process_status='Final')";
			
			Query qry=session.createSQLQuery(str);
			listSearchData=qry.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return listSearchData;
	}
	
	public PensionApplicationHODetailsCoDao commonData(int empNo,int loginEmpNo,int loginEmpOfficeId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);		
		PensionApplicationHODetailsCoDao mstData=null;
		try
		{
			mstData=(PensionApplicationHODetailsCoDao) session.createCriteria(PensionApplicationHODetailsCoDao.class)
							.add(Property.forName("empNo").eq(empNo)).uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return mstData;
	}
	
	public String getFreezdata(Integer empId) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		String frzChk=null;
		try
		{
			String myQry="select emp_name from hrm_pen_app_ho_mst_form2_det where emp_no="+empId;
			Query qry=session.createSQLQuery(myQry);
			frzChk=(String) qry.uniqueResult();
			System.out.println("...= ==>"+empId);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return frzChk;
	}
	
	
	public List<PensionApplicationHONomineeCoDao> listHOEditNominee(int searchEmpNo, int loginEmpNo, int loginEmpOfficeId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<PensionApplicationHONomineeCoDao> hoNomineeEdit=null;
		
		try
		{
			
			hoNomineeEdit=session.createCriteria(PensionApplicationHONomineeCoDao.class)
							.add(Property.forName("empNo").eq(searchEmpNo)).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return hoNomineeEdit;
	}
	
	
	public List<PensionApplicationHOServiceCoDao> listHOEditService(int searchEmpNo, int loginEmpNo, int loginEmpOfficeId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<PensionApplicationHOServiceCoDao> hoServiceEditList=null;		
		try
		{
			hoServiceEditList=session.createCriteria(PensionApplicationHOServiceCoDao.class)
							.add(Property.forName("empNo").eq(searchEmpNo)).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return hoServiceEditList;
	}

	
	
	public boolean saveorUpdateData(PensionApplicationHODetailsValidateDao penapphoval) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.saveOrUpdate(penapphoval);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return true;
	}

	
	public boolean saveNominee(List<PensionApplicationHONomineeValidateDao> penapphovalnom) {
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PensionApplicationHONomineeValidateDao penappnom=null;
		try {	
			Iterator iter = penapphovalnom.iterator();
			trans = session.beginTransaction();			
			Query maxcount = session.createQuery("select coalesce(max(nomineeId),'0') from PensionApplicationHONomineeValidateDao");
			
			while(iter!=null && iter.hasNext())
			{
				penappnom = new PensionApplicationHONomineeValidateDao();
				String maxnominee=null;
					try
					{
						maxnominee=maxcount.iterate().next().toString();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
			
				int maxnominee1 = maxnominee!=null?(Integer.parseInt(maxnominee))+1:1;
				penappnom =(PensionApplicationHONomineeValidateDao)iter.next();
				penappnom.setNomineeId(maxnominee1);				
				session.save(penappnom);
			}
			
			trans.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			trans.rollback();
			return false;
		}
		
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return true;
	}

	
	public boolean saveNotVerifyService(List<PensionApplicationHOServiceValidateDao> penapphovalser) {
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;
		PensionApplicationHOServiceValidateDao myObj=null;
		try
		{
			Iterator myIt=penapphovalser.iterator();
			trans=session.beginTransaction();
			Query mycount=session.createQuery("select coalesce(max(id),'0') from PensionApplicationHOServiceValidateDao");
			
			while(myIt!=null && myIt.hasNext())
			{
				myObj = new PensionApplicationHOServiceValidateDao();
				String maxId=null;
					try
					{
						maxId=mycount.iterate().next().toString();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
			
				int maxId1 = maxId!=null?(Integer.parseInt(maxId))+1:1;
				System.out.println("MAX ID....>>>>>"+maxId1);
				myObj =(PensionApplicationHOServiceValidateDao)myIt.next();
				myObj.setId(maxId1);				
				session.save(myObj);
			}
			
			trans.commit();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
			return false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return true;
	}

	
	
	public String getDesignation(Integer desigId) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		String strDesign=null;
		try
		{
			String myQry="select DESIGNATION from HRM_MST_DESIGNATIONS WHERE DESIGNATION_ID="+desigId;
			Query qry=session.createSQLQuery(myQry);
			strDesign=(String) qry.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return strDesign;
	}

	public String getOfficeName(Integer officeId) {
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		String strOffice=null;
		try
		{
			String myQry="select OFFICE_NAME from COM_MST_OFFICES WHERE OFFICE_ID="+officeId;
			Query qry=session.createSQLQuery(myQry);
			strOffice=(String) qry.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return strOffice;
	
	}

	
	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	


	

	

}
