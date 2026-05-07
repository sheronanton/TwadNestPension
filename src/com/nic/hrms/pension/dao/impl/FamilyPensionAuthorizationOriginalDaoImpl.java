package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.FamilyPensionAuthorizationOriginalDao;
import com.nic.hrms.pension.model.PensionAuthorizationOriginalDao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;
import com.nic.hrms.pension.service.FamilyPensionAuthorizationOriginalService;
import com.nic.hrms.pension.service.PensionAuthorizationOriginalService;

public class FamilyPensionAuthorizationOriginalDaoImpl implements FamilyPensionAuthorizationOriginalService {
	 
	private SessionFactory sessionFactory;
		
	 
	@SuppressWarnings("unchecked")
	public List<Object[]> getMasterDetails(int empNo) {
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		
		List<Object[]> mstDataList=null;		
		try
		{
			
			/*String strQry="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER,"
				+ " offi.office_name,desi.DESIGNATION,offi.OFFICE_ID,desi.DESIGNATION_ID,"
				+ " desi.SERVICE_GROUP_ID," 
				+ " org.ppo_no,org.resident_address,org.from_address,org.circle_ho_office_status,org.last_work_office_id,"
			    + " org.last_work_office_address,org.pension_pay_office_id,org.pension_pay_office_address,org.letter_no,org.dated_on,"
			    + " org.reference,org.authorized_officer,org.authorized_officer_address,org.last_work_office,org.gpo_no,"
				+ " org.nominee_id,org.nominee_name,org.nominee_relation_id,org.nominee_relation_desc, " 
				+ " org.name_from_address,org.service_book_address "
				+ "from HRM_EMP_CURRENT_POSTING post"
				+ " left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID"
				+ " left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join" 
				+ " HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " 
				+ " left join hrm_pen_app_authorization_org org on org.emp_no=emp.EMPLOYEE_ID" 
				+ " where emp.employee_id IN (SELECT emp_id  FROM hrm_pen_app_ho_mst_form1_det form1  WHERE emp_id NOT IN" 
				+ "(SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final') ) " 
				+ "AND emp.employee_id IN (SELECT emp_no FROM hrm_pen_app_ho_mst_form2_det) and emp.EMPLOYEE_ID="+empNo;*/
			
			
			/*String strQry="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER,"
				+ " offi.office_name,desi.DESIGNATION,offi.OFFICE_ID,desi.DESIGNATION_ID,"
				+ " desi.SERVICE_GROUP_ID," 
				+ " org.ppo_no,org.resident_address,org.from_address,org.circle_ho_office_status,org.last_work_office_id,"
			    + " org.last_work_office_address,org.pension_pay_office_id,org.pension_pay_office_address,org.letter_no,org.dated_on,"
			    + " org.reference,org.authorized_officer,org.authorized_officer_address,org.last_work_office,org.gpo_no,"
				+ " org.nominee_id,org.nominee_name,org.nominee_relation_id,org.nominee_relation_desc, " 
				+ " org.name_from_address,org.service_book_address,mstform2.permanent_address "
				+ "from HRM_EMP_CURRENT_POSTING post"   
				+ " left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID"
				+ " left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID left outer join" 
				+ " HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " 
				+ " left join hrm_pen_app_authorization_org org on org.emp_no=emp.EMPLOYEE_ID"
				+ " LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det mstform2 ON mstform2.emp_no = emp.employee_id"
				+ " where emp.employee_id IN (SELECT emp_id  FROM hrm_pen_app_ho_mst_form1_det form1  WHERE emp_id NOT IN" 
				+ "(SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final') ) " 
				+ "AND emp.employee_id IN (SELECT emp_no FROM hrm_pen_app_ho_mst_form2_det) and emp.EMPLOYEE_ID="+empNo;*/
			
			String strQry=" SELECT emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER," +
					" offi.office_name,desi.DESIGNATION,offi.OFFICE_ID,desi.DESIGNATION_ID,desi.SERVICE_GROUP_ID,org.ppo_no,org.resident_address," +
					" org.from_address,org.circle_ho_office_status,org.last_work_office_id,org.last_work_office_address,org.pension_pay_office_id," +
					" org.pension_pay_office_address,org.letter_no,org.dated_on,org.reference,org.authorized_officer,org.authorized_officer_address," +
					" org.last_work_office,org.gpo_no,org.nominee_id,org.nominee_name,org.nominee_relation_id,org.nominee_relation_desc," +
					" org.name_from_address,org.service_book_address,mstform2.address " +
					" FROM HRM_EMP_CURRENT_POSTING post " +
					" LEFT OUTER JOIN HRM_MST_DESIGNATIONS desi ON post.DESIGNATION_ID=desi.DESIGNATION_ID LEFT OUTER JOIN com_mst_offices offi" +
					" ON post.OFFICE_ID=offi.OFFICE_ID LEFT OUTER JOIN HRM_MST_EMPLOYEES emp ON post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
					" LEFT JOIN hrm_pen_fapp_authorization_org org ON org.emp_no=emp.EMPLOYEE_ID LEFT OUTER JOIN HRM_PEN_FAPP_HO_DET_MST_FORM2 mstform2" +
					" ON mstform2.emp_no     = emp.employee_id WHERE  emp.employee_id IN (SELECT emp_no FROM HRM_PEN_FAPP_HO_DET_MST_FORM2 ) " +
					" AND emp.EMPLOYEE_ID="+empNo+" AND emp.employee_id NOT IN (SELECT emp_no FROM hrm_pen_fapp_authorization_org WHERE process_status = 'Final')";
			
			
			Query qry=session.createSQLQuery(strQry);
			mstDataList=qry.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);			
		}
		
		return mstDataList;
	}

	
	
	public boolean saveRecord(FamilyPensionAuthorizationOriginalDao penAppAuthOri) 
	{
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans=null;		
		try
		{
			trans=session.beginTransaction();
			session.saveOrUpdate(penAppAuthOri);
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

	/*@SuppressWarnings("unchecked")
	public List<Object[]> getExistingDetails(int empNo) {
	Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);	
	List<Object[]> myListData=null;
	try
	{
		String qry="SELECT emp_no, ppo_no, from_address,to_address,circle_ho_office_status,"
					+" pension_pay_office_address,letter_no,dated_on,reference,authorized_officer,"
					+" authorized_officer_address,copy_to1,copy_to2,last_work_office_address  FROM hrm_pen_app_authorization_org where PROCESS_STATUS <>'Final' and emp_no="+empNo;
		Query myQry=session.createSQLQuery(qry);
		myListData=myQry.list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}
		
		return myListData;
	}*/
	
	/*@SuppressWarnings("unchecked")
	public List<Object[]> getExistingDetails(int empNo) {
	Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);	
	List<Object[]> myListData=null;
	try
	{
		String qry="SELECT emp_no, ppo_no, from_address,to_address,circle_ho_office_status,"
					+" pension_pay_office_address,letter_no,dated_on,reference,authorized_officer,"
					+" authorized_officer_address,copy_to1,copy_to2,last_work_office_address  FROM hrm_pen_app_authorization_org where PROCESS_STATUS <>'Final' and emp_no="+empNo;
		Query myQry=session.createSQLQuery(qry);
		myListData=myQry.list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}
		
		return myListData;
	}*/
	

	

	@SuppressWarnings("unchecked")
	public List<Object[]> searchOperation(String option, String keyword) {
	Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
	List<Object[]> searchList=null;	
	try
	{
		
		
		/*String searchQry="select f2.EMP_NO,f2.EMP_NAME,design.DESIGNATION,offi.OFFICE_NAME  from" +
		" HRM_PEN_APP_HO_MST_FORM2_DET f2  left outer join HRM_PEN_APP_HO_MST_FORM1_DET f1" +
		" on f2.emp_no=f1.emp_id left outer join COM_MST_OFFICES offi  on offi.OFFICE_ID=f2.OFFICE_ID " +
		" left outer join HRM_MST_DESIGNATIONS design on  f2.DESIG_ID= design.DESIGNATION_ID " +
		" WHERE f2.emp_no IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det form1  " +
		" WHERE emp_id NOT IN (SELECT emp_no FROM hrm_pen_app_authorization_org  " +
		" WHERE process_status = 'Final')) AND f2.emp_no IN  (SELECT emp_no FROM hrm_pen_app_ho_mst_form2_det) AND " +
		" f2."+option+ " like '%"+keyword+"%'"; */
		
		
		String searchQry="select f2.EMP_NO,f2.EMP_NAME,design.DESIGNATION,offi.OFFICE_NAME  from" +
		" HRM_PEN_APP_HO_MST_FORM2_DET f2  left outer join HRM_PEN_APP_HO_MST_FORM1_DET f1" +
		" on f2.emp_no=f1.emp_id left outer join COM_MST_OFFICES offi  on offi.OFFICE_ID=f2.OFFICE_ID " +
		" left outer join hrm_emp_current_posting post ON f2.EMP_NO = post.employee_id " +
		" left outer join HRM_MST_DESIGNATIONS design on  post.designation_id= design.DESIGNATION_ID " +
		" WHERE f2.emp_no IN (SELECT emp_id FROM hrm_pen_app_ho_mst_form1_det form1  " +
		" WHERE emp_id NOT IN (SELECT emp_no FROM hrm_pen_app_authorization_org  " +
		" WHERE process_status = 'Final')) AND f2.emp_no IN  (SELECT emp_no FROM hrm_pen_app_ho_mst_form2_det) AND " +
		" f2."+option+ " like '%"+keyword+"%'"; 
		
		
		
		
		
		Query qry=session.createSQLQuery(searchQry);
		searchList=qry.list();
		System.out.println("SAERCH LIST SIZE>>>>>>>"+searchList.size());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}
		
		return searchList;
	}



	@SuppressWarnings("unchecked")
	public List<Object[]> getAddress(int officeId) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		List<Object[]> addressList=null;
		try
		{
			String query="select OFFICE_ID,OFFICE_ADDRESS1,OFFICE_ADDRESS2,CITY_TOWN_NAME,OFFICE_PIN_CODE " +
							"from COM_MST_OFFICES where OFFICE_ID="+officeId;
			Query qry =session.createSQLQuery(query);
			addressList=qry.list();		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return addressList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object[]> checkPpoNo(int ppoNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> myList1=null;
		System.out.println("Inside PPO NO check DAOIMPL ");
		
		try
		{
			tx=session.beginTransaction();
			String chkQry="select EMP_NO,PPO_NO from HRM_PEN_APP_AUTHORIZATION_ORG where PPO_NO="+ppoNo;
			Query qry=session.createSQLQuery(chkQry);
			myList1=qry.list();		
			tx.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		return myList1;
	}



	@SuppressWarnings("unchecked")
	public List<Object[]> getNominee(int empNo) {
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> nomList=null;
		
		try
		{
			tx=session.beginTransaction();
			String nomQry="select NOMINEE_ID,NOMINEE_NAME from HRM_PEN_FAPP_HO_NOM_MST_FORM2 where EMP_NO="+empNo;
			Query qry=session.createSQLQuery(nomQry);
			nomList=qry.list();
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
	
		return nomList;
	}
	


	@SuppressWarnings("unchecked")
	public List<Object[]> getNominDetails(int empNo, int nomId) 
	{
	
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		List<Object[]> nomList2=null;
		
		try
		{
			tx=session.beginTransaction();
			String nomQry="select nom.NOMINEE_ID,nom.NOMINEE_NAME,rel.FAMILY_RELATIONSHIP_ID,rel.FAMILY_RELATIONSHIP_DESC" +
					" from HRM_PEN_FAPP_HO_NOM_MST_FORM2 nom left outer join HRM_MST_FAMILY_RELATIONS rel on" +
					" cast(nom.RELATIONSHIP_ID as numeric) =rel.FAMILY_RELATIONSHIP_ID" +
					" where nom.NOMINEE_ID="+nomId+" and  nom.EMP_NO="+empNo;
			Query qry=session.createSQLQuery(nomQry);
			nomList2=qry.list();
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
	
		return nomList2;
	}
	
	
	
	
	
	
	public boolean deleteHoCoDetails(int empNo) 
	{
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try 
		{
				trans = session.beginTransaction();
				CallableStatement call=session.connection().prepareCall("{call DELETE_PEN_APP_CO_DETAILS(?)}");
				call.setInt(1, empNo);
				System.out.println("DELETE_PEN_APP_CO_DETAILS Callable updated--"+call.executeUpdate());
				trans.commit();
		}
		catch(Exception e)
		{
			trans.rollback();
			e.printStackTrace();
			return false;
		}

	return true;
		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<PensionAuthorisedOfficer_dao> getListOfAythorisedOfficer() {
		

		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<PensionAuthorisedOfficer_dao> penauthorisedOffobj = null;
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			//penauthorisedOffobj = session.createQuery("from PensionAuthorisedOfficer_dao where PenisonPaymentOffice='Y'").list();
			penauthorisedOffobj = session.createQuery("from PensionAuthorisedOfficer_dao").list();
			 
			//System.out.println("paymentobj..--------------------->" + paymentobj);
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return penauthorisedOffobj;
		
	}
	
	
	
	
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}













	

	
	
	
}
