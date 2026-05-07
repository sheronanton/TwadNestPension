package com.nic.hrms.pension.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.RevisedPensionAuthorizationDao;
import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;
import com.nic.hrms.pension.model.RevisedPensionReportModel;
import com.nic.hrms.pension.service.RevisedPensionAuthorizationService;

public class RevisedPensionAuthorizationDaoImpl implements RevisedPensionAuthorizationService {
	 
	private SessionFactory sessionFactory;
	private RevisedPensionAuthorizationService revisedPenAuthSer;
		
	 
	@SuppressWarnings("unchecked")
	public List<Object[]> getMasterDetails(int empNo) 
	{
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);		
		List<Object[]> mstDataList=null;		
		List<Object[]> mstDataList1 = null;
		Query qry,qry1;
		int emp_count=0;
		String strQry="";
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
			
			
			/*
			String strQry="select emp.EMPLOYEE_ID,emp.EMPLOYEE_NAME,emp.EMPLOYEE_INITIAL,emp.GPF_NO,emp.DATE_OF_BIRTH,emp.GENDER,"
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
				+ " left join hrm_pen_app_rev_auth_org org on org.emp_no=emp.EMPLOYEE_ID" 
				+ " where emp.employee_id IN (SELECT emp_id  FROM hrm_pen_app_revised_pen_det form1  WHERE emp_id NOT IN" 
				+ "(SELECT emp_no FROM hrm_pen_app_rev_auth_org WHERE process_status = 'Final') ) " 
				+ "AND emp.employee_id IN (SELECT emp_no FROM hrm_pen_app_ho_mst_form2_det) and emp.EMPLOYEE_ID="+empNo;
			*/
			
			
			String query= "select * from HRM_PEN_APP_REV_AUTH_ORG where emp_no="+empNo;
			//System.out.println("Query== "+query);			
			qry=session.createSQLQuery(query);
			mstDataList1=qry.list();
			Object x =(Object) qry.list().size();
			//System.out.println("xxxxxxxxxxxxxxx :: "+x.toString());
			
			emp_count = Integer.parseInt(x.toString());
			
			if(emp_count>=1)
			{
				strQry="SELECT org.emp_no," +
					"form2.emp_name," +
					"form2.GPF_NO," +
					"emp.DATE_OF_BIRTH," +
					"form2.GENDER," +
					"offi.office_name," +
					"desi.DESIGNATION," +
					"form2.PAYMENT_OFFICE_ID," +
					"desi.DESIGNATION_ID," +
					"desi.SERVICE_GROUP_ID," +
					"org.ppo_no," +
					"org.resident_address," +
					"org.from_address," +
					"org.circle_ho_office_status," +
					"org.last_work_office_id," +
					"org.last_work_office_address," +
					"org.pension_pay_office_id," +
					"org.pension_pay_office_address," +
					"org.letter_no," +
					"org.dated_on," +
					"org.reference," +
					"org.authorized_officer," +
					"org.authorized_officer_address," +
					"org.last_work_office," +
					"org.gpo_no," +
					"org.nominee_id," +
					"org.nominee_name," +
					"org.nominee_relation_id," +
					"org.nominee_relation_desc," +
					"org.name_from_address," +
					"org.service_book_address " +
					"from HRM_PEN_APP_REV_AUTH_ORG org " +					
					"left outer join HRM_PEN_APP_AUTHORIZATION_ORG tmporg on tmporg.emp_no = org.emp_no " +
					"left outer join HRM_MST_EMPLOYEES emp on emp.EMPLOYEE_ID = org.emp_no " +
					"left outer join HRM_PEN_APP_HO_MST_FORM2_DET form2 on form2.emp_no = org.emp_no " +
					"LEFT OUTER JOIN com_mst_offices offi ON form2.PAYMENT_OFFICE_ID=offi.OFFICE_ID " +
					"LEFT OUTER JOIN HRM_MST_DESIGNATIONS desi ON form2.DESIG_ID=desi.DESIGNATION_ID " +
					"where org.process_status in('Final','Draft') " +
					"and tmporg.process_status ='Final' " +
					"and org.emp_no="+empNo;
			}
			else
			{
				strQry="SELECT org.emp_no," +
				"form2.emp_name," +
				"form2.GPF_NO," +
				"emp.DATE_OF_BIRTH," +
				"form2.GENDER," +
				"offi.office_name," +
				"desi.DESIGNATION," +
				"form2.PAYMENT_OFFICE_ID," +
				"desi.DESIGNATION_ID," +
				"desi.SERVICE_GROUP_ID," +
				"org.ppo_no," +
				"org.resident_address," +
				"org.from_address," +
				"org.circle_ho_office_status," +
				"org.last_work_office_id," +
				"org.last_work_office_address," +
				"org.pension_pay_office_id," +
				"org.pension_pay_office_address," +
				"org.letter_no," +
				"org.dated_on," +
				"org.reference," +
				"org.authorized_officer," +
				"org.authorized_officer_address," +
				"org.last_work_office," +
				"org.gpo_no," +
				"org.nominee_id," +
				"org.nominee_name," +
				"org.nominee_relation_id," +
				"org.nominee_relation_desc," +
				"org.name_from_address," +
				"org.service_book_address " +
				"from HRM_PEN_APP_AUTHORIZATION_ORG org " +				
				"left outer join HRM_MST_EMPLOYEES emp on emp.EMPLOYEE_ID = org.emp_no " +
				"left outer join HRM_PEN_APP_HO_MST_FORM2_DET form2 on form2.emp_no = org.emp_no " +
				"LEFT OUTER JOIN com_mst_offices offi ON form2.PAYMENT_OFFICE_ID=offi.OFFICE_ID " +
				"LEFT OUTER JOIN HRM_MST_DESIGNATIONS desi ON form2.DESIG_ID=desi.DESIGNATION_ID " +
				"where org.process_status ='Final' and org.emp_no="+empNo;
				
			}
			
			System.out.println("Query== "+strQry);
			
			qry1=session.createSQLQuery(strQry);
			mstDataList=qry1.list();
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

	public boolean deleteRecord(int empno)
	{
		boolean flag=false;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		try
		{					
			String deleteQry="delete from HRM_PEN_APP_REV_AUTH_ORG where EMP_NO="+empno;				
			Query qry=session.createSQLQuery(deleteQry);
			qry.executeUpdate();
			flag=true;
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag=false;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		return flag;	
	}
	
	
	public boolean saveRecord(RevisedPensionAuthorizationDao revisedPenAppAuthOri) 
	{
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		
		Transaction trans=null;		
		boolean flag=false;
		
		try
		{
			trans=session.beginTransaction();
			session.saveOrUpdate(revisedPenAppAuthOri);
			trans.commit();
			flag=true;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			trans.rollback();
			return flag;
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return flag;
	}

	

	@SuppressWarnings("unchecked")
	public List<Object[]> searchOperation(String option, String keyword) {
	Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
	List<Object[]> searchList=null;	
	try
	{
				
				String searchQry="SELECT f2.emp_no," +
				"f2.emp_name," +
				"design.designation," +
				"offi.office_name " +
				"FROM hrm_pen_app_ho_mst_form2_det f2 " +
				"LEFT OUTER JOIN hrm_pen_app_revised_pen_det f1 ON f2.emp_no = f1.emp_id " +
				"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = f2.office_id " +
				"LEFT OUTER JOIN hrm_emp_current_posting post ON f2.emp_no = post.employee_id " +
				"LEFT OUTER JOIN hrm_mst_designations design ON post.designation_id = design.designation_id " +
				"WHERE f2.emp_no IN (SELECT distinct(emp_id) FROM hrm_pen_app_revised_pen_det form1 " +
				"WHERE emp_id NOT IN (SELECT emp_no FROM hrm_pen_app_rev_auth_org WHERE process_status = 'Final')) " +
				"AND f2."+option+ " like '%"+keyword+"%'";
		
		
		
		
		
		Query qry=session.createSQLQuery(searchQry);
		searchList=qry.list();
		//System.out.println("SAERCH LIST SIZE>>>>>>>"+searchList.size());
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
		//System.out.println("Inside PPO NO check DAOIMPL ");
		
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
			String nomQry="select NOMINEE_ID,NOMINEE_NAME from HRM_PEN_APP_HO_MST_FORM2_NOMIN where EMP_NO="+empNo;
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
					" from HRM_PEN_APP_HO_MST_FORM2_NOMIN nom left outer join HRM_MST_FAMILY_RELATIONS rel on" +
					" nom.RELATIONSHIP_ID=rel.FAMILY_RELATIONSHIP_ID" +
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
				//System.out.println("DELETE_PEN_APP_CO_DETAILS Callable updated--"+call.executeUpdate());
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
	
	
	public boolean moveRevisedDetails(int empNo, String flag1)
	{
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		boolean flag=false;
		int flagtest=0;
		Transaction trans = null;
		try 
		{
				trans = session.beginTransaction();
				//System.out.println("===CALLING PROCEDURE=====");
				CallableStatement call=session.connection().prepareCall("{call MOVE_REV_PEN_AUTH_DETAILS(?,?)}");
				call.setInt(1, empNo);
				call.setString(2, flag1);
				//System.out.println("MOVE_REV_PEN_AUTH_DETAILS Callable updated");
				flagtest=call.executeUpdate();
				if(flagtest==1)
				{
					flag=true;
					trans.commit();
				}				
				
		}
		catch(Exception e)
		{
			trans.rollback();
			e.printStackTrace();
			return false;
		}

	return flag;
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
			 
			trans.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return penauthorisedOffobj;		
	}
	
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<RevisedPensionReportModel> getRevisedPensionDetails(HttpServletRequest request, int empId,String passed_letter_number,String passed_dated_on,String passed_reference,String ppono,String nameforfromaddress) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();      
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			       	//	" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       //"WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
				*/
					
		        String sqlQry="SELECT hrm_pen_det.emp_initial, " +
		        		"hrm_pen_det.emp_name, " +
		        		"hrm_pen_mst_auth.name_from_address, " +
		        		"authoff.authorization_desc, " +
		        		"hrm_pen_mst_auth.from_address, " +
		        		"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS, " +
		        		"hrm_pen_mst_auth.letter_no, " +
		        		"hrm_pen_mst_auth.dated_on, " +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference" +
		        		" FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det" +
		        		" LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id" +
		        		" LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
		        		" WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
		        		"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and hrm_pen_rev_hist.emp_id="+empId ;
		        
				//System.out.println("getRevisedPensionDetails query-- "+ sqlQry);
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";						
					  					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
					//System.out.println(nameforfromaddress);
					if(!(nameforfromaddress).equalsIgnoreCase(null))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase(null))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase(null))
					{
				    mainpd.setPENSION_PAY_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY REVISED PENSION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					
					
					/*if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}*/
					
					if(!(passed_letter_number).equalsIgnoreCase("null"))
					{
						letterno=passed_letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}
					
					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(passed_dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(tmp[7]);
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+passed_dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised pension/Revised commutation of pension in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.Secy.cum GMLr.no."+tmp[6]+"/dt."+datedon;
					mainpd.setLETTERNO1(letterno1);
					reference="3."+passed_reference;
				    mainpd.setREFERENCE(reference);
					content="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT(content);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					if(!(ppono).equalsIgnoreCase("null"))
					{
					 ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content1="Based on the revised pay fixation towards grade pay difference with reference to letter 2 nd cited, authorization for revised pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT1(content1);
					 content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting the " +
					 		"the amount already paid towards pension and commutation value of pension as per "+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 
					
					mainretn.add(mainpd);
						
				}
					
		 //con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	public List<RevisedPensionReportModel> getGradePayDetails(HttpServletRequest request, int empId, String letter_number,String dated_on, String passed_reference, String ppono,
			String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();      
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			       	//	" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       //"WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
				*/
					
		        String sqlQry="SELECT hrm_pen_det.emp_initial," +
		        		"hrm_pen_det.emp_name," +
		        		"hrm_pen_mst_auth.name_from_address," +
		        		"authoff.authorization_desc," +
		        		"hrm_pen_mst_auth.from_address," +
		        		"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS," +
		        		"hrm_pen_mst_auth.letter_no," +
		        		"hrm_pen_mst_auth.dated_on," +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference" +
		        		" FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det" +
		        		"  LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id" +
		        		" LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
		        		" WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
		        		"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and hrm_pen_rev_hist.emp_id="+empId ;
		        
				//System.out.println("getRevisedPensionDetails query-- "+ sqlQry);
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String reference1="";
					String letterno1="";						
					  					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
					//System.out.println(nameforfromaddress);
					if(!(nameforfromaddress).equalsIgnoreCase(null))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase(null))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase(null))
					{
				    mainpd.setPENSION_PAY_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY ONEMAN COMMISION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					
					
					/*if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}*/
					
					if(!(letter_number).equalsIgnoreCase("null"))
					{
						letterno=letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}
					
					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(tmp[7]);
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised pension/Revised commutation of pension in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt."+datedon;
					reference="2.M.D/TWAD/Chennai Proc.No.38432/E(per)/A1/2013/dt 09/03/2015";
					mainpd.setLETTERNO1(letterno1);
					reference1="3."+passed_reference;
					mainpd.setREFERENCE1(reference1);
				    mainpd.setREFERENCE(reference);
					content="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT(content);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					if(!(ppono).equalsIgnoreCase("null"))
					{
					 ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content1="Based on the revised pay fixation towards grade pay difference with reference to letter 2 nd cited, authorization for revised pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT1(content1);
					 content2="Hence, in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting the " +
					 		"the amount already paid towards pension and commutation value of pension as per "+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 
					
					mainretn.add(mainpd);
						
				}
					
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;
	}

	@Override
	public List<RevisedPensionReportModel> getGradePayDetailssubreport(HttpServletRequest request, int empId, String letter_number,
			String dated_on, String reference, String ppono,
			String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
			
			/*String sqlQry="SELECT  hrm_rev_hist.letter_no,hrm_rev_hist.dated_on,hrm_rev_hist.reference,hrm_rev_hist.emp_no " +
					"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist  " +
					"left outer join hrm_pen_app_authorization_org hrm_mst_org on hrm_mst_org.emp_no=hrm_rev_hist.emp_no " +
					"where hrm_rev_hist.emp_no="+empId+" and hrm_rev_hist.rev_reason='DUE TO PAY CHANGE'";
			
			System.out.println("getRevisedPensionDetailssubreport query -- "+ sqlQry);
			int temp=1;
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				String letterno="";
				String effectdate="";
				String reference="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				
			
			    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[1]+"").equalsIgnoreCase("null"))
				{
					effectdate=formatter1.format(tmp[1]);
					mainpd.setDATEDON((Date)tmp[1]);
				}
				mainpd.setEMPNO((BigDecimal)tmp[3]);
				temp=temp+1;
				letterno=temp+".  "+"JCE(GI)Lr.No."+tmp[0]+"/dt."+effectdate;
				mainpd.setLETTERNO(letterno);
				reference="Your Lr.No. "+tmp[2]+"/dt."+effectdate;
				//System.out.println(reference);
			    mainpd.setREFERENCE(reference);
			    mainretn.add(mainpd);	
				
			}*/
			
			String letterno=letter_number;
			String effectdate=dated_on;
			String reference1=reference;
			int empno=empId;
			RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
			int temp=1;	
			BigDecimal eno = new BigDecimal(empno);
			
			mainpd.setDATEDON(effectdate);
						
			mainpd.setEMPNO((BigDecimal)eno);
			temp=temp+1;
			letterno=temp+". "+"JCE(GI)Lr.No."+letterno+"/dt."+effectdate;
			mainpd.setLETTERNO(letterno);
			reference1="2. Your Lr.No. "+reference+"/dt."+effectdate;
			//System.out.println(reference);
		    mainpd.setREFERENCE(reference1);
		    mainretn.add(mainpd);	
			
			 con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;		
	}

	@Override
	public List<RevisedPensionReportModel> getGradePayDetailssubreport1(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
		    constNumtoLetter n = new constNumtoLetter();
			String content3="";
			String copy1="";
			String copy2="";
			String refinfor="";
			String prenametitle="";
			String wefondate="";
			String diffcommamt="";
			String datedon="";
			String nextdate="";
			
			/*		
			String sqlQry="SELECT  hrm_pen_det.emp_initial," +
		       "hrm_pen_det.emp_name," +
		       "hrm_pen_mst_auth.name_from_address," +
		       "authoff.authorization_desc," +
		       "hrm_pen_mst_auth.from_address," +
		       "hrm_pen_mst_auth.last_work_office_address," +
		       "hrm_pen_mst_auth.letter_no,"+
		       "hrm_pen_mst_auth.dated_on,"+
		       "desi.designation," +
		       "hrm_pen_det.ppo_no," +
		       "hrm_pen_det.date_of_retire," +
		       "hrm_pen_det.death_date," +
		       "hrm_pen_det.date_of_vrs," +
		       " hrm_pen_mst_form2.gender," +
		       "hrm_pen_det.pension_amount AS newpensionamount," +
		       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
		       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
		       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
		       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
		       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
		       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
		       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
		       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
		       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
		       "hrm_pen_mst_auth.reference  "+
		       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
		       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
		       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			//AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
		      // "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
			*/
			
			String sqlQry="SELECT hrm_pen_det.emp_initial," +
					"hrm_pen_det.emp_name," +
					"hrm_pen_mst_auth.name_from_address," +
					"authoff.authorization_desc," +
					"hrm_pen_mst_auth.from_address," +
					"hrm_pen_mst_auth.last_work_office_address," +
					"hrm_pen_mst_auth.letter_no," +
					"hrm_pen_mst_auth.dated_on," +
					"desi.designation," +
					"hrm_pen_det.ppo_no," +
					"hrm_pen_det.date_of_retire," +
					"hrm_pen_det.death_date," +
					"hrm_pen_det.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"hrm_pen_det.pension_amount AS newpensionamount," +
					"hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
					"hrm_pen_det.dcrg_amount AS newdcrgamount," +
					"hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
					"hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
					"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
					"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
					"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
					"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
					"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
					"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
					"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
					"hrm_pen_mst_auth.reference," +
					//" to_date(hrm_pen_det.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate, " +
					"to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
					"hrm_pen_mst_auth.RESIDENT_ADDRESS, " +
					"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS " +
					"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth " +
					"ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist " +
					"ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN hrm_emp_current_posting post " +
					"ON hrm_pen_det.emp_id = post.employee_id " +
					"LEFT OUTER JOIN hrm_mst_designations desi " +
					"ON desi.designation_id = post.designation_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff " +
					"ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
					"WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") " +
					"and hrm_pen_rev_hist.emp_id="+empId;				
			
			
			//System.out.println("getRevisedPensionDetailssubreport1 query -- "+ sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				/*System.out.println(tmp[0]);
				System.out.println(tmp[1]);
				System.out.println(tmp[2]);
				System.out.println(tmp[3]);
				System.out.println(tmp[4]);
				System.out.println(tmp[5]);
				System.out.println(tmp[6]);
				System.out.println(tmp[7]);
				System.out.println(tmp[8]);
				System.out.println(tmp[9]);
				System.out.println(tmp[10]);*/
				
				 int numtoworrevredpen=Integer.parseInt(tmp[20]+"");
				 RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				 if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[14]);
					
					}
				 
				 if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[18]);
					}
				 
				 if(!(tmp[20]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWREDPENAMT((BigDecimal)tmp[20]);
					
					}
				 
				 if(!(tmp[22]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[22]);
					}
				 if(!(tmp[23]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[23]);
					}
				 if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
				 DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						
					}
					if(!(tmp[27]+"").equalsIgnoreCase("null"))
					{
						//nextdate=formatter1.format(tmp[27]);
						nextdate=tmp[27]+"";
					}
				 //wefondate=" w.e.f "+datedon;
				 wefondate=" w.e.f "+nextdate;
				 mainpd.setWEFDATE(wefondate);
				 diffcommamt="(Rs."+tmp[18]+"-"+tmp[19]+")";
				 mainpd.setDIFFCOMMAMT(diffcommamt);
				 content3="Now the revised reduced pension is Rs."+tmp[20]+n.rupess_to_word(numtoworrevredpen);
				 //System.out.println("content3 ====>>  "+content3);
				 mainpd.setCONTENT3(content3);
				 if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
							refinfor="(Retired)";
						
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Death)";
						
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Voluntary Retirement)";
						
					}
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
				 copy1="Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[28];
				 mainpd.setCOPY1(copy1);
				 copy2="Copy to "+tmp[29];
				 mainpd.setCOPY2(copy2);
				 
			    mainretn.add(mainpd);	
				
			}
			
			 con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	}
	@Override
	public List<RevisedPensionReportModel> getOneManCommisionDetails(HttpServletRequest request, int empId, String passed_letter_number,String passed_dated_on, String passed_reference, String ppono,String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();      
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			       	//	" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       //"WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
				*/
					
		        String sqlQry="SELECT hrm_pen_det.emp_initial," +
		        		"hrm_pen_det.emp_name," +
		        		"hrm_pen_mst_auth.name_from_address," +
		        		"authoff.authorization_desc," +
		        		"hrm_pen_mst_auth.from_address," +
		        		"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS," +
		        		"hrm_pen_mst_auth.letter_no," +
		        		"hrm_pen_mst_auth.dated_on," +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference" +
		        		" FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det" +
		        		"  LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id" +
		        		" LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
		        		" WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
		        		"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and hrm_pen_rev_hist.emp_id="+empId ;
		        
				//System.out.println("getRevisedPensionDetails query-- "+ sqlQry);
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";						
					  					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
					//System.out.println(nameforfromaddress);
					if(!(nameforfromaddress).equalsIgnoreCase(null))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase(null))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase(null))
					{
				    mainpd.setPENSION_PAY_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY ONEMAN COMMISION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					
					
					/*if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}*/
					
					if(!(passed_letter_number).equalsIgnoreCase("null"))
					{
						letterno=passed_letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}
					
					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(passed_dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(tmp[7]);
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+passed_dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised pension/Revised commutation of pension in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt."+datedon;
					mainpd.setLETTERNO1(letterno1);
					reference="2."+passed_reference;
				    mainpd.setREFERENCE(reference);
					content="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT(content);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					if(!(ppono).equalsIgnoreCase("null"))
					{
					 ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content1="Based on the revised pay fixation towards grade pay difference vide reference to letter 2 nd cited, authorization for the "
					 		+ "revised pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT1(content1);
					 content2="Hence, in accordance with the above revision, "+tmp[5]+" is authorised to make payment, i.e, the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting the " +
					 		"the amount already paid towards pension and commutation value of pension as per "+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 
					
					mainretn.add(mainpd);
						
				}
					
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;
	}

	
	public List<RevisedPensionReportModel> getRevisedPensionDetailssubreport(HttpServletRequest request, int empId,String letter_number1,String dated_on1,String reference1,String ppono,String nameforfromaddress) 
	{
		   

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
			
			/*String sqlQry="SELECT  hrm_rev_hist.letter_no,hrm_rev_hist.dated_on,hrm_rev_hist.reference,hrm_rev_hist.emp_no " +
					"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist  " +
					"left outer join hrm_pen_app_authorization_org hrm_mst_org on hrm_mst_org.emp_no=hrm_rev_hist.emp_no " +
					"where hrm_rev_hist.emp_no="+empId+" and hrm_rev_hist.rev_reason='DUE TO PAY CHANGE'";
			
			System.out.println("getRevisedPensionDetailssubreport query -- "+ sqlQry);
			int temp=1;
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				String letterno="";
				String effectdate="";
				String reference="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				
			
			    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[1]+"").equalsIgnoreCase("null"))
				{
					effectdate=formatter1.format(tmp[1]);
					mainpd.setDATEDON((Date)tmp[1]);
				}
				mainpd.setEMPNO((BigDecimal)tmp[3]);
				temp=temp+1;
				letterno=temp+".  "+"JCE(GI)Lr.No."+tmp[0]+"/dt."+effectdate;
				mainpd.setLETTERNO(letterno);
				reference="Your Lr.No. "+tmp[2]+"/dt."+effectdate;
				//System.out.println(reference);
			    mainpd.setREFERENCE(reference);
			    mainretn.add(mainpd);	
				
			}*/
			
			String letterno=letter_number1;
			String effectdate=dated_on1;
			String reference=reference1;
			int empno=empId;
			RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
			int temp=1;	
			BigDecimal eno = new BigDecimal(empno);
			
			mainpd.setDATEDON(effectdate);
						
			mainpd.setEMPNO((BigDecimal)eno);
			temp=temp+1;
			letterno=temp+". "+"JCE(GI)Lr.No."+letterno+"/dt."+effectdate;
			mainpd.setLETTERNO(letterno);
			reference="2. Your Lr.No. "+reference+"/dt."+effectdate;
			//System.out.println(reference);
		    mainpd.setREFERENCE(reference);
		    mainretn.add(mainpd);	
			
			// con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;		
	}
	
	@Override
	public List<RevisedPensionReportModel> getOneManCommisionDetailssubreport(HttpServletRequest request, int empId, String letter_number1,String dated_on1, String reference1, String ppono,String nameforfromaddress) {
		// TODO Auto-generated method stub

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
			
			/*String sqlQry="SELECT  hrm_rev_hist.letter_no,hrm_rev_hist.dated_on,hrm_rev_hist.reference,hrm_rev_hist.emp_no " +
					"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist  " +
					"left outer join hrm_pen_app_authorization_org hrm_mst_org on hrm_mst_org.emp_no=hrm_rev_hist.emp_no " +
					"where hrm_rev_hist.emp_no="+empId+" and hrm_rev_hist.rev_reason='DUE TO PAY CHANGE'";
			
			System.out.println("getRevisedPensionDetailssubreport query -- "+ sqlQry);
			int temp=1;
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				String letterno="";
				String effectdate="";
				String reference="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				
			
			    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[1]+"").equalsIgnoreCase("null"))
				{
					effectdate=formatter1.format(tmp[1]);
					mainpd.setDATEDON((Date)tmp[1]);
				}
				mainpd.setEMPNO((BigDecimal)tmp[3]);
				temp=temp+1;
				letterno=temp+".  "+"JCE(GI)Lr.No."+tmp[0]+"/dt."+effectdate;
				mainpd.setLETTERNO(letterno);
				reference="Your Lr.No. "+tmp[2]+"/dt."+effectdate;
				//System.out.println(reference);
			    mainpd.setREFERENCE(reference);
			    mainretn.add(mainpd);	
				
			}*/
			
			String letterno=letter_number1;
			String effectdate=dated_on1;
			String reference=reference1;
			int empno=empId;
			RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
			int temp=1;	
			BigDecimal eno = new BigDecimal(empno);
			
			mainpd.setDATEDON(effectdate);
						
			mainpd.setEMPNO((BigDecimal)eno);
			temp=temp+1;
			letterno=temp+". "+"JCE(GI)Lr.No."+letterno+"/dt."+effectdate;
			mainpd.setLETTERNO(letterno);
			reference="2. Your Lr.No. "+reference+"/dt."+effectdate;
			//System.out.println(reference);
		    mainpd.setREFERENCE(reference);
		    mainretn.add(mainpd);	
			
			 con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;		
	}
	
	public List<RevisedPensionReportModel> getRevisedPensionDetailssubreport1(HttpServletRequest request, int empId) 
	{
		   //System.out.println("Entering into getRevisedPensionDetailssubreport1 method.....");

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
		    constNumtoLetter n = new constNumtoLetter();
			String content3="";
			String copy1="";
			String copy2="";
			String refinfor="";
			String prenametitle="";
			String wefondate="";
			String diffcommamt="";
			String datedon="";
			String nextdate="";
			
			/*		
			String sqlQry="SELECT  hrm_pen_det.emp_initial," +
		       "hrm_pen_det.emp_name," +
		       "hrm_pen_mst_auth.name_from_address," +
		       "authoff.authorization_desc," +
		       "hrm_pen_mst_auth.from_address," +
		       "hrm_pen_mst_auth.last_work_office_address," +
		       "hrm_pen_mst_auth.letter_no,"+
		       "hrm_pen_mst_auth.dated_on,"+
		       "desi.designation," +
		       "hrm_pen_det.ppo_no," +
		       "hrm_pen_det.date_of_retire," +
		       "hrm_pen_det.death_date," +
		       "hrm_pen_det.date_of_vrs," +
		       " hrm_pen_mst_form2.gender," +
		       "hrm_pen_det.pension_amount AS newpensionamount," +
		       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
		       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
		       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
		       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
		       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
		       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
		       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
		       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
		       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
		       "hrm_pen_mst_auth.reference  "+
		       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
		       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
		       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			//AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
		      // "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
			*/
			
			String sqlQry="SELECT hrm_pen_det.emp_initial," +
					"hrm_pen_det.emp_name," +
					"hrm_pen_mst_auth.name_from_address," +
					"authoff.authorization_desc," +
					"hrm_pen_mst_auth.from_address," +
					"hrm_pen_mst_auth.last_work_office_address," +
					"hrm_pen_mst_auth.letter_no," +
					"hrm_pen_mst_auth.dated_on," +
					"desi.designation," +
					"hrm_pen_det.ppo_no," +
					"hrm_pen_det.date_of_retire," +
					"hrm_pen_det.death_date," +
					"hrm_pen_det.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"hrm_pen_det.pension_amount AS newpensionamount," +
					"hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
					"hrm_pen_det.dcrg_amount AS newdcrgamount," +
					"hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
					"hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
					"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
					"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
					"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
					"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
					"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
					"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
					"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
					"hrm_pen_mst_auth.reference," +
					//" to_date(hrm_pen_det.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate, " +
					"add_days(hrm_pen_det.date_of_retire,1) AS nextdate, "+

					// "to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
					"hrm_pen_mst_auth.RESIDENT_ADDRESS, " +
					"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS " +
					"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth " +
					"ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist " +
					"ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN hrm_emp_current_posting post " +
					"ON hrm_pen_det.emp_id = post.employee_id " +
					"LEFT OUTER JOIN hrm_mst_designations desi " +
					"ON desi.designation_id = post.designation_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff " +
					"ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
					"WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") " +
					"and hrm_pen_rev_hist.emp_id="+empId;				
			
			
			//System.out.println("getRevisedPensionDetailssubreport1 query -- "+ sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				/*System.out.println(tmp[0]);
				System.out.println(tmp[1]);
				System.out.println(tmp[2]);
				System.out.println(tmp[3]);
				System.out.println(tmp[4]);
				System.out.println(tmp[5]);
				System.out.println(tmp[6]);
				System.out.println(tmp[7]);
				System.out.println(tmp[8]);
				System.out.println(tmp[9]);
				System.out.println(tmp[10]);*/
				
				 int numtoworrevredpen=Integer.parseInt(tmp[20]+"");
				 RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				 if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[14]);
					
					}
				 
				 if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[18]);
					}
				 
				 if(!(tmp[20]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWREDPENAMT((BigDecimal)tmp[20]);
					
					}
				 
				 if(!(tmp[22]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[22]);
					}
				 if(!(tmp[23]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[23]);
					}
				 if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
				 DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						
					}
					if(!(tmp[27]+"").equalsIgnoreCase("null"))
					{
						//nextdate=formatter1.format(tmp[27]);
						nextdate=tmp[27]+"";
					}
				 //wefondate=" w.e.f "+datedon;
				 wefondate=" w.e.f "+nextdate;
				 mainpd.setWEFDATE(wefondate);
				 diffcommamt="(Rs."+tmp[18]+"-"+tmp[19]+")";
				 mainpd.setDIFFCOMMAMT(diffcommamt);
				 content3="Now the revised reduced pension is Rs."+tmp[20]+n.rupess_to_word(numtoworrevredpen);
				 //System.out.println("content3 ====>>  "+content3);
				 mainpd.setCONTENT3(content3);
				 if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
							refinfor="(Retired)";
						
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Death)";
						
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Voluntary Retirement)";
						
					}
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
				 copy1="Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[28];
				 mainpd.setCOPY1(copy1);
				 copy2="Copy to "+tmp[29]+" for information";
				 mainpd.setCOPY2(copy2);
				 
			    mainretn.add(mainpd);	
				
			}
			
			// con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	}
	
	@Override
	public List<RevisedPensionReportModel> getOneManCommisionDetailssubreport1(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
		    constNumtoLetter n = new constNumtoLetter();
			String content3="";
			String copy1="";
			String copy2="";
			String refinfor="";
			String prenametitle="";
			String wefondate="";
			String diffcommamt="";
			String datedon="";
			String nextdate="";
			
			/*		
			String sqlQry="SELECT  hrm_pen_det.emp_initial," +
		       "hrm_pen_det.emp_name," +
		       "hrm_pen_mst_auth.name_from_address," +
		       "authoff.authorization_desc," +
		       "hrm_pen_mst_auth.from_address," +
		       "hrm_pen_mst_auth.last_work_office_address," +
		       "hrm_pen_mst_auth.letter_no,"+
		       "hrm_pen_mst_auth.dated_on,"+
		       "desi.designation," +
		       "hrm_pen_det.ppo_no," +
		       "hrm_pen_det.date_of_retire," +
		       "hrm_pen_det.death_date," +
		       "hrm_pen_det.date_of_vrs," +
		       " hrm_pen_mst_form2.gender," +
		       "hrm_pen_det.pension_amount AS newpensionamount," +
		       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
		       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
		       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
		       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
		       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
		       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
		       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
		       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
		       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
		       "hrm_pen_mst_auth.reference  "+
		       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
		       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
		       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			//AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
		      // "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
			*/
			
			String sqlQry="SELECT hrm_pen_det.emp_initial," +
					"hrm_pen_det.emp_name," +
					"hrm_pen_mst_auth.name_from_address," +
					"authoff.authorization_desc," +
					"hrm_pen_mst_auth.from_address," +
					"hrm_pen_mst_auth.last_work_office_address," +
					"hrm_pen_mst_auth.letter_no," +
					"hrm_pen_mst_auth.dated_on," +
					"desi.designation," +
					"hrm_pen_det.ppo_no," +
					"hrm_pen_det.date_of_retire," +
					"hrm_pen_det.death_date," +
					"hrm_pen_det.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"hrm_pen_det.pension_amount AS newpensionamount," +
					"hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
					"hrm_pen_det.dcrg_amount AS newdcrgamount," +
					"hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
					"hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
					"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
					"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
					"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
					"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
					"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
					"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
					"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
					"hrm_pen_mst_auth.reference," +
					//" to_date(hrm_pen_det.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate, " +
					"to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
					"hrm_pen_mst_auth.RESIDENT_ADDRESS, " +
					"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS " +
					"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth " +
					"ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist " +
					"ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN hrm_emp_current_posting post " +
					"ON hrm_pen_det.emp_id = post.employee_id " +
					"LEFT OUTER JOIN hrm_mst_designations desi " +
					"ON desi.designation_id = post.designation_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff " +
					"ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
					"WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") " +
					"and hrm_pen_rev_hist.emp_id="+empId;				
			
			
			//System.out.println("getRevisedPensionDetailssubreport1 query -- "+ sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				/*System.out.println(tmp[0]);
				System.out.println(tmp[1]);
				System.out.println(tmp[2]);
				System.out.println(tmp[3]);
				System.out.println(tmp[4]);
				System.out.println(tmp[5]);
				System.out.println(tmp[6]);
				System.out.println(tmp[7]);
				System.out.println(tmp[8]);
				System.out.println(tmp[9]);
				System.out.println(tmp[10]);*/
				
				 int numtoworrevredpen=Integer.parseInt(tmp[20]+"");
				 RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				 if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[14]);
					
					}
				 
				 if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[18]);
					}
				 
				 if(!(tmp[20]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWREDPENAMT((BigDecimal)tmp[20]);
					
					}
				 
				 if(!(tmp[22]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[22]);
					}
				 if(!(tmp[23]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[23]);
					}
				 if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
				 DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						
					}
					if(!(tmp[27]+"").equalsIgnoreCase("null"))
					{
						//nextdate=formatter1.format(tmp[27]);
						nextdate=tmp[27]+"";
					}
				 //wefondate=" w.e.f "+datedon;
				 wefondate=" w.e.f "+nextdate;
				 mainpd.setWEFDATE(wefondate);
				 diffcommamt="(Rs."+tmp[18]+"-"+tmp[19]+")";
				 mainpd.setDIFFCOMMAMT(diffcommamt);
				 content3="Now the revised reduced pension is Rs."+tmp[20]+n.rupess_to_word(numtoworrevredpen);
				 //System.out.println("content3 ====>>  "+content3);
				 mainpd.setCONTENT3(content3);
				 if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
							refinfor="(Retired)";
						
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Death)";
						
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Voluntary Retirement)";
						
					}
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
				 copy1="Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[28];
				 mainpd.setCOPY1(copy1);
				 copy2="Copy to "+tmp[29];
				 mainpd.setCOPY2(copy2);
				 
			    mainretn.add(mainpd);	
				
			}
			
			 con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<RevisedPensionReportModel> getRevisedpensionDetails_Note(HttpServletRequest request, int empId,String letter_no,String date_on,String passed_reference) 
	{
		   

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();	   
			
			/*
			String sqlQry="SELECT hrm_pen_det.emp_initial,hrm_pen_det.emp_name,hrm_pen_det.date_of_retire," +
					      "hrm_pen_det.death_date,hrm_pen_det.date_of_vrs,hrm_pen_mst_form2.gender," +
					      "hrm_pen_det.pension_amount AS newpensionamount,hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
					      "hrm_pen_det.dcrg_amount as newdcrgamount,hrm_pen_rev_hist.dcrg_amount as olddcrgamount," +
					      "hrm_pen_det.commutation_pen_amount as newcommpenamt,hrm_pen_rev_hist.commutation_pen_amount as oldcommpenamt," +
					      "hrm_pen_det.reduced_pension_amount as newredpenamt,hrm_pen_rev_hist.reduced_pension_amount as oldredpenamt," +
					      "hrm_pen_det.family_pension_50_amt as newfampen50amt,hrm_pen_det.family_pension_30_amt as newfampen30amt," +
					      "hrm_pen_rev_hist.family_pension_50_amt as oldfampen50amt,hrm_pen_rev_hist.family_pension_30_amt as oldfampen30amt" +
					      " FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det LEFT OUTER JOIN hrm_pen_app_revised_pen_det " +
					      "hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id  " +
					      "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 on hrm_pen_mst_form2.emp_no=hrm_pen_det.emp_id " +
					      "WHERE hrm_pen_rev_hist.emp_id ="+empId+" ";
					      		//"and  hrm_pen_rev_hist.updated_date=(SELECT MAX(updated_date)" +
					      //"FROM hrm_pen_app_revised_pen_det WHERE emp_id ="+empId+" and REVISED_REASON='DUE TO PAY CHANGE')" +
					      //"AND hrm_pen_rev_hist.REVISED_REASON='DUE TO PAY CHANGE'
			*/
			
			String sqlQry="SELECT newval.emp_initial," +
					"newval.emp_name," +
					"newval.date_of_retire," +
					"newval.death_date," +
					"newval.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"newval.pension_amount AS newpensionamount," +
					"oldval.pension_amount AS oldpensionamount," +
					"newval.dcrg_amount AS newdcrgamount," +
					"oldval.dcrg_amount AS olddcrgamount," +
					"newval.commutation_pen_amount AS newcommpenamt," +
					"oldval.commutation_pen_amount AS oldcommpenamt," +
					"newval.reduced_pension_amount AS newredpenamt," +
					"oldval.reduced_pension_amount AS oldredpenamt," +
					"newval.family_pension_50_amt AS newfampen50amt," +
					"newval.family_pension_30_amt AS newfampen30amt," +
					"oldval.family_pension_50_amt AS oldfampen50amt," +
					"oldval.family_pension_30_amt AS oldfampen30amt, " +
					"(select des.DESIGNATION from HRM_MST_DESIGNATIONS des " +
					" where des.designation_id=newval.DESIGNATION_ID) as designation , "+
					"hrm_pen_mst_auth.dated_on " +
					" from HRM_PEN_APP_HO_MST_FORM1_DET newval " +
					"left outer join HRM_PEN_APP_HO_MST_F1_DET_HIST oldval on newval.emp_id = oldval.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth " +
					"ON hrm_pen_mst_auth.emp_no=newval.emp_id " +
					"left outer join hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"on hrm_pen_mst_form2.emp_no =newval.emp_id " +
					"WHERE oldval.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and oldval.emp_id ="+empId;
					      
			//System.out.println(sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				String datedon="";
				String prenametitle="";
				String retiredate="";
				String information="";
				String voluntrydate="";
				String Deathdate="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				//mainpd.setEMP_NAME(tmp[0]+"."+tmp[1]);
				mainpd.setEMP_NAME(tmp[1]+"");
				if((tmp[5]+"").equalsIgnoreCase("M"))
				{
					prenametitle="Thiru.";
				}
				if((tmp[5]+"").equalsIgnoreCase("F"))
				{
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						prenametitle="Tmt.";
					}
					else
					{
						prenametitle="Selvi.";
					}
				}
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[2]+"").equalsIgnoreCase("null"))
				{						
					retiredate=formatter1.format(tmp[2]);
					information="retired on"+" "+retiredate;
					mainpd.setDATE_OF_RETIRE((Date)tmp[2]);
					
					//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
				}
				if(!(tmp[3]+"").equalsIgnoreCase("null"))
				{
					Deathdate=formatter1.format(tmp[3]);
					information="Death On"+" "+ Deathdate;
					mainpd.setDEATH_DATE((Date) tmp[3]);
				}
				
				if(!(tmp[4]+"").equalsIgnoreCase("null"))
				{
					voluntrydate=formatter1.format(tmp[4]);
					information="Voluntary Retirement On"+" "+ voluntrydate;
					mainpd.setDATE_OF_VRS((Date)tmp[4]);
				}
				
				
				String sub="Pension Establishment - Revision of Pensionary benefits of "+prenametitle+" "+tmp[1]+" "+tmp[18]+" "+
				"who "+information+" "+"reg.";
				datedon=formatter1.format(tmp[19]);				
				String ref="1.Secy.cum GMLr.no."+letter_no+"/dt."+datedon;
				String reference="3."+passed_reference;
			    mainpd.setREFERENCE(reference);
				//mainpd.setLETTERNO1(letterno1);
				//reference="Your Lr.No. "+tmp[26]+"/dt. "+datedon;
			   // mainpd.setREFERENCE(reference);
				//String ref="";
				
				String content1="The authorization for pensionary benefits was issued in this office Lr.no."+letter_no+"/dt."+datedon;
				
				String content2="In the ref 1st cited, orders have been issued towards authorization for pensionary benefits in respect of. "+prenametitle+" "+tmp[1]+" "+tmp[18]+" ." +
						"Now the pay has been revised and revised LPC along with necessary entries in the Service register has been received in the reference 2nd cited. ";
				
				String content3="Hence the revised pensionary benefits are worked out and put up below. ";
				
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from to "+prenametitle+" "+tmp[1]+" "+tmp[18]+" "+
			    "who "+information+" "+"are as detailed below.";  
			    //System.out.println(subject);
				  
			    mainpd.setSub(sub);
			    mainpd.setRef(ref);
			    mainpd.setNote_content1(content1);
			    mainpd.setNote_content2(content2);
			    mainpd.setNote_content3(content3);
			    mainpd.setSubject(subject);
			    mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[6]);
			    mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[7]);
			    mainpd.setNEWDCRGAMOUNT((BigDecimal)tmp[8]);
			    mainpd.setOLDDCRGAMOUNT((BigDecimal)tmp[9]);
			    mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[10]);
			    mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[11]);
			    mainpd.setNEWREDPENAMT((BigDecimal)tmp[12]);
			    mainpd.setOLDREDPENAMT((BigDecimal)tmp[13]);
			    mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[14]);
			    mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[16]);
			    mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[15]);
			    mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[17]);
			   
				mainretn.add(mainpd);	
				
			}
			
			 con.commit();
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;		
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<RevisedPensionReportModel> getOneManCommDetails_Note(HttpServletRequest request, int empId,String letter_no,String date_on,String passed_reference) 
	{
		   

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();	   
						
			String sqlQry="SELECT newval.emp_initial," +
					"newval.emp_name," +
					"newval.date_of_retire," +
					"newval.death_date," +
					"newval.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"newval.pension_amount AS newpensionamount," +
					"oldval.pension_amount AS oldpensionamount," +
					"newval.dcrg_amount AS newdcrgamount," +
					"oldval.dcrg_amount AS olddcrgamount," +
					"newval.commutation_pen_amount AS newcommpenamt," +
					"oldval.commutation_pen_amount AS oldcommpenamt," +
					"newval.reduced_pension_amount AS newredpenamt," +
					"oldval.reduced_pension_amount AS oldredpenamt," +
					"newval.family_pension_50_amt AS newfampen50amt," +
					"newval.family_pension_30_amt AS newfampen30amt," +
					"oldval.family_pension_50_amt AS oldfampen50amt," +
					"oldval.family_pension_30_amt AS oldfampen30amt, " +
					//"to_date(newval.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate "+					
					" to_char(trunc(newval.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
					"(select des.DESIGNATION from HRM_MST_DESIGNATIONS des " +
					" where des.designation_id=newval.DESIGNATION_ID) as designation, "+
					" hrm_pen_mst_auth.dated_on " +
					"from HRM_PEN_APP_HO_MST_FORM1_DET newval " +
					"left outer join HRM_PEN_APP_HO_MST_F1_DET_HIST oldval on newval.emp_id = oldval.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth " +
					"ON hrm_pen_mst_auth.emp_no=newval.emp_id " +
					"left outer join hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"on hrm_pen_mst_form2.emp_no =newval.emp_id " +
					"WHERE oldval.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and oldval.emp_id ="+empId;
					      
			//System.out.println(sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				String datedon="";
				String prenametitle="";
				String retiredate="";
				String information="";
				String voluntrydate="";
				String Deathdate="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				//mainpd.setEMP_NAME(tmp[0]+"."+tmp[1]);
				mainpd.setEMP_NAME(tmp[1]+"");
				if((tmp[5]+"").equalsIgnoreCase("M"))
				{
					prenametitle="Thiru.";
				}
				if((tmp[5]+"").equalsIgnoreCase("F"))
				{
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						prenametitle="Tmt.";
					}
					else
					{
						prenametitle="Selvi.";
					}
				}
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[2]+"").equalsIgnoreCase("null"))
				{						
					retiredate=formatter1.format(tmp[2]);
					information="retired on"+" "+retiredate;
					mainpd.setDATE_OF_RETIRE((Date)tmp[2]);
					
					//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
				}
				if(!(tmp[3]+"").equalsIgnoreCase("null"))
				{
					Deathdate=formatter1.format(tmp[3]);
					information="Death On"+" "+ Deathdate;
					mainpd.setDEATH_DATE((Date) tmp[3]);
				}
				
				if(!(tmp[4]+"").equalsIgnoreCase("null"))
				{
					voluntrydate=formatter1.format(tmp[4]);
					information="Voluntary Retirement On"+" "+ voluntrydate;
					mainpd.setDATE_OF_VRS((Date)tmp[4]);
				}
				
				
				String sub="Pension Establishment - Revision of Pensionary benefits of "+prenametitle+" "+tmp[1]+" "+tmp[19]+" "+
				"who "+information+" "+" due to revision of Grade pay - reg.";
								
				String ref="1.M.D/TWAD/Chennai Proc.No 47237/E(per)/A1/2012/dt 12/12/2012.";
				String reference="2."+passed_reference;
			    mainpd.setREFERENCE(reference);
				//mainpd.setLETTERNO1(letterno1);
				//reference="Your Lr.No. "+tmp[26]+"/dt. "+datedon;
			   // mainpd.setREFERENCE(reference);
				//String ref="";
			    
			    String empname_content = " "+prenametitle+" "+tmp[1]+" "+tmp[19];
			    
			    mainpd.setEMPNAME_CONTENT(empname_content);
				datedon=formatter1.format(tmp[20]);
				String content1="The authorization for pensionary benefits was issued in this office Lr.no."+letter_no+"/dt."+datedon;
				
				String content2="In the M.D Proc 1st cited, orders have been issued to revise the Grade pay of the Employees Retired/Expired on or later 1.1.2006." +
						"Accordingly the pay has been revised and revised LPC along with necessary entries in the Service register has been received in the reference 2nd cited. ";
				
				String content3="Hence the revised pensionary benefits are worked out and put up below. ";
				
				/*
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from "+formatter1.format(tmp[18])+" to "+prenametitle+" "+tmp[1]+" "+
			    "who "+information+" "+"are as detailed below.";  
			 */   
			    
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from "+tmp[18]+" to "+prenametitle+" "+tmp[1]+" "+
			    "who "+information+" "+"are as detailed below.";  
			    
				  
			    mainpd.setSub(sub);
			    mainpd.setRef(ref);
			    mainpd.setNote_content1(content1);
			    mainpd.setNote_content2(content2);
			    mainpd.setNote_content3(content3);
			    mainpd.setSubject(subject);
			    mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[6]);
			    mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[7]);
			    mainpd.setNEWDCRGAMOUNT((BigDecimal)tmp[8]);
			    mainpd.setOLDDCRGAMOUNT((BigDecimal)tmp[9]);
			    mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[10]);
			    mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[11]);
			    mainpd.setNEWREDPENAMT((BigDecimal)tmp[12]);
			    mainpd.setOLDREDPENAMT((BigDecimal)tmp[13]);
			    mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[14]);
			    mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[16]);
			    mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[15]);
			    mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[17]);
			   
				mainretn.add(mainpd);	
				
			}
			
			 con.commit();
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;		
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<RevisedPensionReportModel> getRevisedPensionDCRGDetails(HttpServletRequest request, int empId,String passed_letter_number,String passed_dated_on,String passed_reference,String ppono,String nameforfromaddress) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();	
		        
		   
		  		
		        constNumtoLetter n = new constNumtoLetter();
				
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+"  AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
		         */
		        
		        String sqlQry="SELECT hrm_pen_det.emp_initial," +
		        		"hrm_pen_det.emp_name," +
		        		"hrm_pen_mst_auth.name_from_address," +
		        		"authoff.authorization_desc," +
		        		"hrm_pen_mst_auth.from_address," +
		        		"hrm_pen_mst_auth.last_work_office_address," +
		        		"hrm_pen_mst_auth.letter_no," +
		        		"hrm_pen_mst_auth.dated_on," +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference, " +
		        		"hrm_pen_mst_auth.RESIDENT_ADDRESS " +
		        		"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id " +
		        		"LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer" +
		        		" WHERE hrm_pen_rev_hist.emp_id ="+empId+" " +
		        		" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)" +
		        		"FROM HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+")";

				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";
					String content3="";
					String content4="";
					String content5="";					
					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();									
					
					if(!(nameforfromaddress).equalsIgnoreCase("null"))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setLAST_WORK_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY REVISED PENSION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					if(!(passed_letter_number).equalsIgnoreCase("null"))
					{
						letterno=passed_letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(passed_dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+passed_dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
					mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised DCRG in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.Secy.cum GM Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					//reference="2."+tmp[26]+"/dt. "+datedon;
					reference="3."+passed_reference;
				    mainpd.setREFERENCE(reference);
					content1="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT1(content1);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					
					 //ppono=tmp[9]+"/TWAD";
					if(!(ppono).equalsIgnoreCase("null"))
					{
						ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content2="Based on the revised pay fixation with reference to letter 2 nd cited, authorization for revised " +
					 		"pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT2(content2);
					 /*content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[0]+"."+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting the " +
					 		"the amount already paid towards pension and commutation value of pension as per"+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 content3="The difference of amount in DCRG will be paid in 3 installments.";
					 mainpd.setCONTENT3(content3);*/
										 
					 int newdcrgamount=Integer.parseInt(tmp[16]+"");
					 int olddcrgamount=Integer.parseInt(tmp[17]+"");
					 int dcrgpensionamount=newdcrgamount-olddcrgamount;
					 String sumofamount=n.rupess_to_word(dcrgpensionamount);
					
					 content3="DCRG  -  Rs."+olddcrgamount+"/-";
					 content5="Revised DCRG  -  Rs."+newdcrgamount+"/-";
					 
					 mainpd.setCONTENT3(content3);
					 mainpd.setCONTENT5(content5);
					 
					 content4="I request you to make arrangement for payment from the TWAD Board funds a sum of Rs."+dcrgpensionamount+"/-("+newdcrgamount+"-"+olddcrgamount+") "+sumofamount +
					 		" to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" being the difference amount of revised DCRG after duly satisfying yourself about his " +
					 		"identification.";
					 mainpd.setCONTENT4(content4);
					 
					 String copy = "Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[27];
					 mainpd.setCOPY1(copy);
					
					mainretn.add(mainpd);
						
				}
					
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	@Override
	public List<RevisedPensionReportModel> getOneManCommisionDCRGDetails(HttpServletRequest request, int empId, String passed_letter_number,String passed_dated_on, String passed_reference, String ppono,String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();	
		        
		   
		  		
		        constNumtoLetter n = new constNumtoLetter();
				
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+"  AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
		         */
		        
		        String sqlQry="SELECT hrm_pen_det.emp_initial," +
		        		"hrm_pen_det.emp_name," +
		        		"hrm_pen_mst_auth.name_from_address," +
		        		"authoff.authorization_desc," +
		        		"hrm_pen_mst_auth.from_address," +
		        		"hrm_pen_mst_auth.last_work_office_address," +
		        		"hrm_pen_mst_auth.letter_no," +
		        		"hrm_pen_mst_auth.dated_on," +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference, " +
		        		"hrm_pen_mst_auth.RESIDENT_ADDRESS " +
		        		"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id " +
		        		"LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer" +
		        		" WHERE hrm_pen_rev_hist.emp_id ="+empId+" " +
		        		" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)" +
		        		"FROM HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+")";

				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";
					String content3="";
					String content4="";
					String content5="";					
					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();									
					
					if(!(nameforfromaddress).equalsIgnoreCase("null"))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setLAST_WORK_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY ONEMAN COMMISION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					if(!(passed_letter_number).equalsIgnoreCase("null"))
					{
						letterno=passed_letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(passed_dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+passed_dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
					mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised DCRG in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					//reference="2."+tmp[26]+"/dt. "+datedon;
					reference="2."+passed_reference;
				    mainpd.setREFERENCE(reference);
					content1="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT1(content1);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					
					 //ppono=tmp[9]+"/TWAD";
					if(!(ppono).equalsIgnoreCase("null"))
					{
						ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content2="Based on the revised pay fixation with reference to letter 2 nd cited, authorization for revised " +
					 		"pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT2(content2);
					 /*content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[0]+"."+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting the " +
					 		"the amount already paid towards pension and commutation value of pension as per"+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 content3="The difference of amount in DCRG will be paid in 3 installments.";
					 mainpd.setCONTENT3(content3);*/
										 
					 int newdcrgamount=Integer.parseInt(tmp[16]+"");
					 int olddcrgamount=Integer.parseInt(tmp[17]+"");
					 int dcrgpensionamount=newdcrgamount-olddcrgamount;
					 String sumofamount=n.rupess_to_word(dcrgpensionamount);
					
					 content3="DCRG  -  Rs."+olddcrgamount+"/-";
					 content5="Revised DCRG  -  Rs."+newdcrgamount+"/-";
					 
					 mainpd.setCONTENT3(content3);
					 mainpd.setCONTENT5(content5);
					 
					 content4="I request you to make arrangement for payment from the TWAD Board funds a sum of Rs."+dcrgpensionamount+"/-("+newdcrgamount+"-"+olddcrgamount+") "+sumofamount +
					 		" to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" being the difference amount of revised DCRG after duly satisfying yourself about his " +
					 		"identification.";
					 mainpd.setCONTENT4(content4);
					 
					 String copy = "Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[27];
					 mainpd.setCOPY1(copy);
					
					mainretn.add(mainpd);
						
				}
					
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
// AMOUNT TO WORD CONVERSION START
	
	
	class constNumtoLetter
	{
	    String[] unitdo ={"", " One", " Two", " Three", " Four", " Five",
	       " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
	       " Thirteen", " Fourteen", " Fifteen",  " Sixteen", " Seventeen", 
	       " Eighteen", " Nineteen"};
	    String[] tens =  {"", "Ten", " Twenty", " Thirty", " Forty", " Fifty",
	       " Sixty", " Seventy", " Eighty"," Ninety"};
	    String[] digit = {"", " Hundred", " Thousand", " Lakh", " Crore"};
	   int r;


	    //Count the number of digits in the input number
	    int numberCount(int num)
	    {
	        int cnt=0;

	        while (num>0)
	        {
	          r = num%10;
	          cnt++;
	          num = num / 10;
	        }

	          return cnt;
	    }


	    //Function for Conversion of two digit

	    String twonum(int numq)
	    {
	         int numr, nq;
	         String ltr="";

	         nq = numq / 10;
	         numr = numq % 10;

	         if (numq>19)
	           {
	         ltr=ltr+tens[nq]+unitdo[numr];
	           }
	         else
	           {
	         ltr = ltr+unitdo[numq];
	           }

	         return ltr;
	    }

	    //Function for Conversion of three digit

	    String threenum(int numq)
	    {
	           int numr, nq;
	           String ltr = "";

	           nq = numq / 100;
	           numr = numq % 100;

	           if (numr == 0)
	            {
	            ltr = ltr + unitdo[nq]+digit[1];
	             }
	           else
	            {
	            ltr = ltr +unitdo[nq]+digit[1]+" and"+twonum(numr);
	            }
	           return ltr;

	    }
	    
	    
	    
	    String rupess_to_word(int pensionamount)
	    {
	    	
	    	int len, q=0, r=0;
	        String ltr = " ";
	        String Str = "(Rupees";
	        int num=pensionamount;
	         
	        
	        if (num <= 0) Str="Zero or Negative number not for conversion."; 
	        //System.out.println("Zero or Negative number not for conversion");

	        while (num>0)
	        {

	           
	        	len=numberCount(num);

	           //Take the length of the number and do letter conversion

	           switch (len)

	           {
	                case 8:
	                        q=num/10000000;
	                        r=num%10000000;	                        
	                        ltr = twonum(q);	                        
	                        Str = Str+ltr+digit[4];
	                        num = r;
	                        break;

	                case 7:
	                case 6:
	                        q=num/100000;
	                        r=num%100000;	                        
	                        ltr = twonum(q);
	                        Str = Str+ltr+digit[3];
	                        num = r;
	                        break;

	                case 5:
	                case 4:

	                         q=num/1000;
	                         r=num%1000;
	                         ltr = twonum(q);
	                         Str= Str+ltr+digit[2];
	                         num = r;
	                         break;

	                case 3:


	                          if (len == 3)
	                              r = num;
	                          ltr = threenum(r);
	                          Str = Str + ltr;
	                          num = 0;
	                          break;

	                case 2:

	                         ltr = twonum(num);
	                         Str = Str + ltr;
	                         num=0;
	                         break;

	                case 1:
	                         Str = Str + unitdo[num];
	                         num=0;
	                         break;
	                default:

	                        num=0;
	                        System.out.println("Exceeding Crore....No conversion");
	                        System.exit(1);

	            }
	           		if (num==0)
	                Str=Str+" Only)";
	          }           
  
	        return Str;	    	
	    }
	}
	
	
	// AMOUNT TO WORD CONVERSIN END
	
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<RevisedPensionReportModel> getSplGrade_Note(HttpServletRequest request, int empId, String lett_no,
			String date_on, String reference) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();	   
						
			String sqlQry="SELECT newval.emp_initial," +
					"newval.emp_name," +
					"newval.date_of_retire," +
					"newval.death_date," +
					"newval.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"newval.pension_amount AS newpensionamount," +
					"oldval.pension_amount AS oldpensionamount," +
					"newval.dcrg_amount AS newdcrgamount," +
					"oldval.dcrg_amount AS olddcrgamount," +
					"newval.commutation_pen_amount AS newcommpenamt," +
					"oldval.commutation_pen_amount AS oldcommpenamt," +
					"newval.reduced_pension_amount AS newredpenamt," +
					"oldval.reduced_pension_amount AS oldredpenamt," +
					"newval.family_pension_50_amt AS newfampen50amt," +
					"newval.family_pension_30_amt AS newfampen30amt," +
					"oldval.family_pension_50_amt AS oldfampen50amt," +
					"oldval.family_pension_30_amt AS oldfampen30amt, " +
					//"to_date(newval.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate "+					
					" to_char(trunc(newval.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
					"(select DESIGNATION from HRM_MST_DESIGNATIONS where designation_id=newval.DESIGNATION_ID) as designation, "+
					" hrm_pen_mst_auth.dated_on " +
					"from HRM_PEN_APP_HO_MST_FORM1_DET newval " +
					"left outer join HRM_PEN_APP_HO_MST_F1_DET_HIST oldval on newval.emp_id = oldval.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
	        		" ON hrm_pen_mst_auth.emp_no=newval.emp_id " +
					"left outer join hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"on hrm_pen_mst_form2.emp_no =newval.emp_id " +
					"WHERE oldval.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and oldval.emp_id ="+empId;
					      
		    System.out.println(sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				String datedon="";
				String prenametitle="";
				String retiredate="";
				String retiredate1="";
				String information="";
				String voluntrydate="";
				String Deathdate="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				//mainpd.setEMP_NAME(tmp[0]+"."+tmp[1]);
				mainpd.setEMP_NAME(tmp[1]+"");
				if((tmp[5]+"").equalsIgnoreCase("M"))
				{
					prenametitle="Thiru.";
				}
				if((tmp[5]+"").equalsIgnoreCase("F"))
				{
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						prenametitle="Tmt.";
					}
					else
					{
						prenametitle="Selvi.";
					}
				}
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[2]+"").equalsIgnoreCase("null"))
				{						
					retiredate=formatter1.format(tmp[2]);
					information="retired on"+" "+retiredate;
					mainpd.setDATE_OF_RETIRE((Date)tmp[2]);
					
					//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
				}
				if(!(tmp[3]+"").equalsIgnoreCase("null"))
				{
					Deathdate=formatter1.format(tmp[3]);
					information="Death On"+" "+ Deathdate;
					mainpd.setDEATH_DATE((Date) tmp[3]);
				}
				
				if(!(tmp[4]+"").equalsIgnoreCase("null"))
				{
					voluntrydate=formatter1.format(tmp[4]);
					information="voluntarily retired On"+" "+ voluntrydate;
					mainpd.setDATE_OF_VRS((Date)tmp[4]);
				}
				
				
				String sub="Pension Establishment - Revision of Pensionary benefits of "+prenametitle+" "+tmp[1]+" "+
				"who "+information+" "+" due to sanction of additional increment @ 3% for movement to selection/Special grade - reg.";
								
				//String ref="1.M.D/TWAD/Chennai Proc.No 47237/E(per)/A1/2012/dt 12/12/2012.";
				String ref="1.BPMS NO. 108/dt. 11/12/2013";
				String reference1="2."+reference;
			    mainpd.setREFERENCE(reference1);
				//mainpd.setLETTERNO1(letterno1);
				//reference="Your Lr.No. "+tmp[26]+"/dt. "+datedon;
			   // mainpd.setREFERENCE(reference);
				//String ref="";
			    
			    String empname_content = " "+prenametitle+" "+tmp[1]+" "+tmp[19];
			    
			    mainpd.setEMPNAME_CONTENT(empname_content);
				datedon=formatter1.format(tmp[20]);
				String content1="The authorization for pensionary benefits was issued in this office Lr.no."+lett_no+"/dt."+datedon;
				
				String content2="In the Board Proc 1st cited, orders have been issued to Sanction 3% additional increment for movement of Sel. Grade/Spl. Grade for those employees whose movement is 1.1.2006 to 31.5.2009." +
						"Accordingly the pay has been revised and revised LPC along with necessary entries in the Service register has been received in the reference 2nd cited. ";
				
				String content3="Hence the revised pensionary benefits are worked out and put up below. ";
				
				/*
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from "+formatter1.format(tmp[18])+" to "+prenametitle+" "+tmp[1]+" "+
			    "who "+information+" "+"are as detailed below.";  
			 */   
			    
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from "+tmp[18]+" to "+prenametitle+" "+tmp[1]+" "+
			    "who "+information+" "+"are as detailed below.";  
			    SimpleDateFormat formatter2= new SimpleDateFormat("dd/MM/yyyy");
			    //retiredate1=formatter1.format(tmp[2]);
			    String date1=formatter2.format(tmp[2]);
			    java.util.Date date2=formatter2.parse(date1);
			    java.util.Date  beniftdate=formatter2.parse("01/04/2013");
			    String refdate="";
			    if(beniftdate.after(date2))
			    {
			    	
			    	refdate="Monetary benefit from 01/04/2013";
			    }
			    else
			    {
			    	refdate="Monetary benefit from "+tmp[18]+"";
			    }
				  
			    mainpd.setSub(sub);
			    mainpd.setRef(ref);
			    mainpd.setNote_content1(content1);
			    mainpd.setNote_content2(content2);
			    mainpd.setNote_content3(content3);
			    mainpd.setNote_content4(refdate);
			    mainpd.setSubject(subject);
			    mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[6]);
			    mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[7]);
			    mainpd.setNEWDCRGAMOUNT((BigDecimal)tmp[8]);
			    mainpd.setOLDDCRGAMOUNT((BigDecimal)tmp[9]);
			    mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[10]);
			    mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[11]);
			    mainpd.setNEWREDPENAMT((BigDecimal)tmp[12]);
			    mainpd.setOLDREDPENAMT((BigDecimal)tmp[13]);
			    mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[14]);
			    mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[16]);
			    mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[15]);
			    mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[17]);
			   
				mainretn.add(mainpd);	
				
			}
			
			 con.commit();
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;		
	}

	@Override
	public List<RevisedPensionReportModel> getGradePay_Note(HttpServletRequest request, int empId, String letter_no,String date_on, String passed_reference) {
		// TODO Auto-generated method stub

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();	   
						
			String sqlQry="SELECT newval.emp_initial," +
					"newval.emp_name," +
					"newval.date_of_retire," +
					"newval.death_date," +
					"newval.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"newval.pension_amount AS newpensionamount," +
					"oldval.pension_amount AS oldpensionamount," +
					"newval.dcrg_amount AS newdcrgamount," +
					"oldval.dcrg_amount AS olddcrgamount," +
					"newval.commutation_pen_amount AS newcommpenamt," +
					"oldval.commutation_pen_amount AS oldcommpenamt," +
					"newval.reduced_pension_amount AS newredpenamt," +
					"oldval.reduced_pension_amount AS oldredpenamt," +
					"newval.family_pension_50_amt AS newfampen50amt," +
					"newval.family_pension_30_amt AS newfampen30amt," +
					"oldval.family_pension_50_amt AS oldfampen50amt," +
					"oldval.family_pension_30_amt AS oldfampen30amt, " +
					//"to_date(newval.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate "+					
					" to_char(trunc(newval.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
					"(select des.DESIGNATION from HRM_MST_DESIGNATIONS des " +
					" where des.designation_id=newval.DESIGNATION_ID) as designation, "+
					" hrm_pen_mst_auth.dated_on " +
					"from HRM_PEN_APP_HO_MST_FORM1_DET newval " +
					"left outer join HRM_PEN_APP_HO_MST_F1_DET_HIST oldval on newval.emp_id = oldval.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
	        		" ON hrm_pen_mst_auth.emp_no=newval.emp_id " +
					"left outer join hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"on hrm_pen_mst_form2.emp_no =newval.emp_id " +
					"WHERE oldval.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and oldval.emp_id ="+empId;
					      
			//System.out.println(sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				String datedon="";
				String prenametitle="";
				String retiredate="";
				String information="";
				String voluntrydate="";
				String Deathdate="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				//mainpd.setEMP_NAME(tmp[0]+"."+tmp[1]);
				mainpd.setEMP_NAME(tmp[1]+"");
				if((tmp[5]+"").equalsIgnoreCase("M"))
				{
					prenametitle="Thiru.";
				}
				if((tmp[5]+"").equalsIgnoreCase("F"))
				{
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						prenametitle="Tmt.";
					}
					else
					{
						prenametitle="Selvi.";
					}
				}
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[2]+"").equalsIgnoreCase("null"))
				{						
					retiredate=formatter1.format(tmp[2]);
					information="retired on"+" "+retiredate;
					mainpd.setDATE_OF_RETIRE((Date)tmp[2]);
					
					//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
				}
				if(!(tmp[3]+"").equalsIgnoreCase("null"))
				{
					Deathdate=formatter1.format(tmp[3]);
					information="Death On"+" "+ Deathdate;
					mainpd.setDEATH_DATE((Date) tmp[3]);
				}
				
				if(!(tmp[4]+"").equalsIgnoreCase("null"))
				{
					voluntrydate=formatter1.format(tmp[4]);
					information="Voluntary Retirement On"+" "+ voluntrydate;
					mainpd.setDATE_OF_VRS((Date)tmp[4]);
				}
				
				
				String sub="Pension Establishment - Revision of Pensionary benefits of "+prenametitle+" "+tmp[1]+" "+tmp[19]+" "+
				"who "+information+" "+" due to revision of Grade pay - reg.";
								
				String ref="1.M.D/TWAD/Chennai Proc.No 38432/E(per)/A1/2013/dt 09/03/2015.";
				String reference="2."+passed_reference;
			    mainpd.setREFERENCE(reference);
				//mainpd.setLETTERNO1(letterno1);
				//reference="Your Lr.No. "+tmp[26]+"/dt. "+datedon;
			   // mainpd.setREFERENCE(reference);
				//String ref="";
			    
			    String empname_content = " "+prenametitle+" "+tmp[1]+" "+tmp[19];
			    
			    mainpd.setEMPNAME_CONTENT(empname_content);
			    datedon=formatter1.format(tmp[20]);
				String content1="The authorization for pensionary benefits was issued in this office Lr.no."+letter_no+"/dt."+datedon;
				
				String content2="In the M.D Proc 1st cited, orders have been issued to revise the Grade pay Difference of the Employees Retired/Expired on or later 1.1.2006." +
						"Accordingly the pay has been revised and revised LPC along with necessary entries in the Service register has been received in the reference 2nd cited. ";
				
				String content3="Hence the revised pensionary benefits are worked out and put up below. ";
				
				/*
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from "+formatter1.format(tmp[18])+" to "+prenametitle+" "+tmp[1]+" "+
			    "who "+information+" "+"are as detailed below.";  
			 */   
			    
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from "+tmp[18]+" to "+prenametitle+" "+tmp[1]+" "+
			    "who "+information+" "+"are as detailed below.";  
			    
				  
			    mainpd.setSub(sub);
			    mainpd.setRef(ref);
			    mainpd.setNote_content1(content1);
			    mainpd.setNote_content2(content2);
			    mainpd.setNote_content3(content3);
			    mainpd.setSubject(subject);
			    mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[6]);
			    mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[7]);
			    mainpd.setNEWDCRGAMOUNT((BigDecimal)tmp[8]);
			    mainpd.setOLDDCRGAMOUNT((BigDecimal)tmp[9]);
			    mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[10]);
			    mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[11]);
			    mainpd.setNEWREDPENAMT((BigDecimal)tmp[12]);
			    mainpd.setOLDREDPENAMT((BigDecimal)tmp[13]);
			    mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[14]);
			    mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[16]);
			    mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[15]);
			    mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[17]);
			   
				mainretn.add(mainpd);	
				
			}
			
			 con.commit();
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	}

	
	@Override
	public List<RevisedPensionReportModel> getSpecialGradeDetails(HttpServletRequest request, int empId, String passed_letter_number,
			String passed_dated_on, String passed_reference, String ppono,String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();      
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			       	//	" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       //"WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
				*/
					
		        String sqlQry="SELECT hrm_pen_det.emp_initial," +
		        		"hrm_pen_det.emp_name," +
		        		"hrm_pen_mst_auth.name_from_address," +
		        		"authoff.authorization_desc," +
		        		"hrm_pen_mst_auth.from_address," +
		        		"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS," +
		        		"hrm_pen_mst_auth.letter_no," +
		        		"hrm_pen_mst_auth.dated_on," +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference" +
		        		" FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det" +
		        		"  LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id" +
		        		" LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id" +
		        		" LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id" +
		        		" LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
		        		" WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
		        		"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") and hrm_pen_rev_hist.emp_id="+empId ;
		        
				//System.out.println("getRevisedPensionDetails query-- "+ sqlQry);
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";						
					  					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
					//System.out.println(nameforfromaddress);
					if(!(nameforfromaddress).equalsIgnoreCase(null))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase(null))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase(null))
					{
				    mainpd.setPENSION_PAY_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY ONEMAN COMMISION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					
					
					/*if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}*/
					
					if(!(passed_letter_number).equalsIgnoreCase("null"))
					{
						letterno=passed_letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}
					
					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(passed_dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(tmp[7]);
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+passed_dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
						mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised pension/Revised commutation of pension in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					reference="2."+passed_reference;
				    mainpd.setREFERENCE(reference);
					content="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT(content);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					if(!(ppono).equalsIgnoreCase("null"))
					{
					 ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content1="Based on the revised pay fixation with reference to letter 2 nd cited,where in additional increament of 3% for movement of" +
					 		" selection grade/special grade was awarded. Hence, authorization for the revised pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT1(content1);
					 content2="Hence, in accordance with the above revision, "+tmp[5]+" is authorised to make payment, i.e, the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting " +
					 		"the amount already paid towards pension and commutation value of pension as per "+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 
					
					mainretn.add(mainpd);
						
				}
					
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;
	}

	@Override
	public List<RevisedPensionReportModel> getSpecialGradeDetailssubreport(HttpServletRequest request, int empId, String letter_number1,
			String dated_on1, String reference1, String ppono,
			String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
			
			/*String sqlQry="SELECT  hrm_rev_hist.letter_no,hrm_rev_hist.dated_on,hrm_rev_hist.reference,hrm_rev_hist.emp_no " +
					"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist  " +
					"left outer join hrm_pen_app_authorization_org hrm_mst_org on hrm_mst_org.emp_no=hrm_rev_hist.emp_no " +
					"where hrm_rev_hist.emp_no="+empId+" and hrm_rev_hist.rev_reason='DUE TO PAY CHANGE'";
			
			System.out.println("getRevisedPensionDetailssubreport query -- "+ sqlQry);
			int temp=1;
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				String letterno="";
				String effectdate="";
				String reference="";
				RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				
			
			    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				if(!(tmp[1]+"").equalsIgnoreCase("null"))
				{
					effectdate=formatter1.format(tmp[1]);
					mainpd.setDATEDON((Date)tmp[1]);
				}
				mainpd.setEMPNO((BigDecimal)tmp[3]);
				temp=temp+1;
				letterno=temp+".  "+"JCE(GI)Lr.No."+tmp[0]+"/dt."+effectdate;
				mainpd.setLETTERNO(letterno);
				reference="Your Lr.No. "+tmp[2]+"/dt."+effectdate;
				//System.out.println(reference);
			    mainpd.setREFERENCE(reference);
			    mainretn.add(mainpd);	
				
			}*/
			
			String letterno=letter_number1;
			String effectdate=dated_on1;
			String reference=reference1;
			int empno=empId;
			RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
			int temp=1;	
			BigDecimal eno = new BigDecimal(empno);
			
			mainpd.setDATEDON(effectdate);
						
			mainpd.setEMPNO((BigDecimal)eno);
			temp=temp+1;
			letterno=temp+". "+"JCE(GI)Lr.No."+letterno+"/dt."+effectdate;
			mainpd.setLETTERNO(letterno);
			reference="2. Your Lr.No. "+reference+"/dt."+effectdate;
			//System.out.println(reference);
		    mainpd.setREFERENCE(reference);
		    mainretn.add(mainpd);	
			
			 con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;	
	}

	@Override
	public List<RevisedPensionReportModel> getSpecialGradeDetailssubreport1(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		{                 
			con=session.connection();
		    constNumtoLetter n = new constNumtoLetter();
			String content3="";
			String copy1="";
			String copy2="";
			String refinfor="";
			String prenametitle="";
			String wefondate="";
			String diffcommamt="";
			String datedon="";
			String nextdate="";
			
			/*		
			String sqlQry="SELECT  hrm_pen_det.emp_initial," +
		       "hrm_pen_det.emp_name," +
		       "hrm_pen_mst_auth.name_from_address," +
		       "authoff.authorization_desc," +
		       "hrm_pen_mst_auth.from_address," +
		       "hrm_pen_mst_auth.last_work_office_address," +
		       "hrm_pen_mst_auth.letter_no,"+
		       "hrm_pen_mst_auth.dated_on,"+
		       "desi.designation," +
		       "hrm_pen_det.ppo_no," +
		       "hrm_pen_det.date_of_retire," +
		       "hrm_pen_det.death_date," +
		       "hrm_pen_det.date_of_vrs," +
		       " hrm_pen_mst_form2.gender," +
		       "hrm_pen_det.pension_amount AS newpensionamount," +
		       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
		       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
		       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
		       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
		       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
		       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
		       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
		       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
		       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
		       "hrm_pen_mst_auth.reference  "+
		       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
		       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
		       "WHERE hrm_pen_rev_hist.emp_id="+empId+" ";
			//AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
		      // "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
			*/
			
			String sqlQry="SELECT hrm_pen_det.emp_initial," +
					"hrm_pen_det.emp_name," +
					"hrm_pen_mst_auth.name_from_address," +
					"authoff.authorization_desc," +
					"hrm_pen_mst_auth.from_address," +
					"hrm_pen_mst_auth.last_work_office_address," +
					"hrm_pen_mst_auth.letter_no," +
					"hrm_pen_mst_auth.dated_on," +
					"desi.designation," +
					"hrm_pen_det.ppo_no," +
					"hrm_pen_det.date_of_retire," +
					"hrm_pen_det.death_date," +
					"hrm_pen_det.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"hrm_pen_det.pension_amount AS newpensionamount," +
					"hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
					"hrm_pen_det.dcrg_amount AS newdcrgamount," +
					"hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
					"hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
					"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
					"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
					"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
					"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
					"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
					"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
					"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
					"hrm_pen_mst_auth.reference," +
					//" to_date(hrm_pen_det.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate, " +
					 "to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
					"hrm_pen_mst_auth.RESIDENT_ADDRESS, " +
					"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS " +
					"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth " +
					"ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist " +
					"ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
					"ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
					"LEFT OUTER JOIN hrm_emp_current_posting post " +
					"ON hrm_pen_det.emp_id = post.employee_id " +
					"LEFT OUTER JOIN hrm_mst_designations desi " +
					"ON desi.designation_id = post.designation_id " +
					"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff " +
					"ON authoff.authorization_id  = hrm_pen_mst_auth.authorized_officer " +
					"WHERE hrm_pen_rev_hist.updated_date in(select max(updated_date) " +
					"from HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+") " +
					"and hrm_pen_rev_hist.emp_id="+empId;				
			
			
			//System.out.println("getRevisedPensionDetailssubreport1 query -- "+ sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				/*System.out.println(tmp[0]);
				System.out.println(tmp[1]);
				System.out.println(tmp[2]);
				System.out.println(tmp[3]);
				System.out.println(tmp[4]);
				System.out.println(tmp[5]);
				System.out.println(tmp[6]);
				System.out.println(tmp[7]);
				System.out.println(tmp[8]);
				System.out.println(tmp[9]);
				System.out.println(tmp[10]);*/
				
				 int numtoworrevredpen=Integer.parseInt(tmp[20]+"");
				 RevisedPensionReportModel mainpd=new RevisedPensionReportModel();
				 if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWPENSIONAMOUNT((BigDecimal)tmp[14]);
					
					}
				 
				 if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWCOMMPENAMT((BigDecimal)tmp[18]);
					}
				 
				 if(!(tmp[20]+"").equalsIgnoreCase("null"))
					{
					 mainpd.setNEWREDPENAMT((BigDecimal)tmp[20]);
					
					}
				 
				 if(!(tmp[22]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN50AMT((BigDecimal)tmp[22]);
					}
				 if(!(tmp[23]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNEWFAMPEN30AMT((BigDecimal)tmp[23]);
					}
				 if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
				 DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						
					}
					if(!(tmp[27]+"").equalsIgnoreCase("null"))
					{
						//nextdate=formatter1.format(tmp[27]);
						nextdate=tmp[27]+"";
					}
				 //wefondate=" w.e.f "+datedon;
					
				 wefondate=" w.e.f "+nextdate;
				 mainpd.setWEFDATE(wefondate);
				 diffcommamt="(Rs."+tmp[18]+"-"+tmp[19]+")";
				 mainpd.setDIFFCOMMAMT(diffcommamt);
				 content3="Now the revised reduced pension is Rs."+tmp[20]+n.rupess_to_word(numtoworrevredpen);
				 //System.out.println("content3 ====>>  "+content3);
				 mainpd.setCONTENT3(content3);
				 SimpleDateFormat formatter2= new SimpleDateFormat("dd/MM/yyyy");
				    //retiredate1=formatter1.format(tmp[2]);
				    String date1=formatter2.format(tmp[10]);
				    java.util.Date date2=formatter2.parse(date1);
				    java.util.Date  beniftdate=formatter2.parse("01/04/2013");
				    String refdate="";
				    if(beniftdate.after(date2))
				    {
				    	
				    	refdate="Monetary benefit from 01/04/2013";
				    }
				    else
				    {
				    	refdate="Monetary benefit from "+tmp[27]+"";
				    }
				 mainpd.setCONTENT4(refdate);
				 if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
							refinfor="(Retired)";
						
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Death)";
						
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						
						refinfor="(Voluntary Retirement)";
						
					}
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
				 copy1="Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[28];
				 mainpd.setCOPY1(copy1);
				 copy2="Copy to "+tmp[29] +"for information.";
				 mainpd.setCOPY2(copy2);
				 
			    mainretn.add(mainpd);	
				
			}
			
			 con.commit();
			// System.out.println("jasp compltd");
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	}

	@Override
	public List<RevisedPensionReportModel> getSpecialGradeDCRGDetails(HttpServletRequest request, int empId, String passed_letter_number,
			String passed_dated_on, String passed_reference, String ppono,
			String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();	
		        
		   
		  		
		        constNumtoLetter n = new constNumtoLetter();
				
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+"  AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
		         */
		        
		        String sqlQry="SELECT hrm_pen_det.emp_initial," +
		        		"hrm_pen_det.emp_name," +
		        		"hrm_pen_mst_auth.name_from_address," +
		        		"authoff.authorization_desc," +
		        		"hrm_pen_mst_auth.from_address," +
		        		"hrm_pen_mst_auth.last_work_office_address," +
		        		"hrm_pen_mst_auth.letter_no," +
		        		"hrm_pen_mst_auth.dated_on," +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference, " +
		        		"hrm_pen_mst_auth.RESIDENT_ADDRESS " +
		        		"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id " +
		        		"LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer" +
		        		" WHERE hrm_pen_rev_hist.emp_id ="+empId+" " +
		        		" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)" +
		        		"FROM HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+")";

				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";
					String content3="";
					String content4="";
					String content5="";					
					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();									
					
					if(!(nameforfromaddress).equalsIgnoreCase("null"))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setLAST_WORK_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY ONEMAN COMMISION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					if(!(passed_letter_number).equalsIgnoreCase("null"))
					{
						letterno=passed_letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(passed_dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+passed_dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
					mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised DCRG in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					//reference="2."+tmp[26]+"/dt. "+datedon;
					reference="2."+passed_reference;
				    mainpd.setREFERENCE(reference);
					content1="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT1(content1);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					
					 //ppono=tmp[9]+"/TWAD";
					if(!(ppono).equalsIgnoreCase("null"))
					{
						ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content2="Based on the revised pay fixation with reference to letter 2 nd cited, authorization for revised " +
					 		"pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT2(content2);
					 /*content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[0]+"."+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting the " +
					 		"the amount already paid towards pension and commutation value of pension as per"+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 content3="The difference of amount in DCRG will be paid in 3 installments.";
					 mainpd.setCONTENT3(content3);*/
										 
					 int newdcrgamount=Integer.parseInt(tmp[16]+"");
					 int olddcrgamount=Integer.parseInt(tmp[17]+"");
					 int dcrgpensionamount=newdcrgamount-olddcrgamount;
					 String sumofamount=n.rupess_to_word(dcrgpensionamount);
					
					 content3="DCRG  -  Rs."+olddcrgamount+"/-";
					 content5="Revised DCRG  -  Rs."+newdcrgamount+"/-";
					 
					 mainpd.setCONTENT3(content3);
					 mainpd.setCONTENT5(content5);
					 
					 content4="I request you to make arrangement for payment from the TWAD Board funds a sum of Rs."+dcrgpensionamount+"/-("+newdcrgamount+"-"+olddcrgamount+") "+sumofamount +
					 		" to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" being the difference amount of revised DCRG after duly satisfying yourself about his " +
					 		"identification.";
					 mainpd.setCONTENT4(content4);
					 
					 String copy = "Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[27];
					 mainpd.setCOPY1(copy);
					
					mainretn.add(mainpd);
						
				}
					
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}

	@Override
	public List<RevisedPensionReportModel> getGradePayDCRGDetails(HttpServletRequest request, int empId, String letter_number,String dated_on, String passed_reference, String ppono,
			String nameforfromaddress) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportModel> mainretn=new ArrayList<RevisedPensionReportModel>();
		try
		   {
		        con=session.connection();	
		        
		   
		  		
		        constNumtoLetter n = new constNumtoLetter();
				
		        /*
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_det.ppo_no," +
			       "hrm_pen_det.date_of_retire," +
			       "hrm_pen_det.death_date," +
			       "hrm_pen_det.date_of_vrs," +
			       " hrm_pen_mst_form2.gender," +
			       "hrm_pen_det.pension_amount AS newpensionamount," +
			       "hrm_pen_rev_hist.pension_amount AS oldpensionamount," +
			       "hrm_pen_det.dcrg_amount AS newdcrgamount," +
			       "hrm_pen_rev_hist.dcrg_amount AS olddcrgamount," +
			       "hrm_pen_det.commutation_pen_amount AS newcommpenamt," +
			       "hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
			       "hrm_pen_det.reduced_pension_amount AS newredpenamt," +
			       "hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
			       "hrm_pen_det.family_pension_50_amt AS newfampen50amt," +
			       "hrm_pen_det.family_pension_30_amt AS newfampen30amt," +
			       "hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
			       "hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt,  " +
			       "hrm_pen_mst_auth.reference  "+
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_revised_pen_det hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+"  AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY CHANGE') AND hrm_pen_rev_hist.revised_reason='DUE TO PAY CHANGE'";
		         */
		        
		        String sqlQry="SELECT hrm_pen_det.emp_initial," +
		        		"hrm_pen_det.emp_name," +
		        		"hrm_pen_mst_auth.name_from_address," +
		        		"authoff.authorization_desc," +
		        		"hrm_pen_mst_auth.from_address," +
		        		"hrm_pen_mst_auth.last_work_office_address," +
		        		"hrm_pen_mst_auth.letter_no," +
		        		"hrm_pen_mst_auth.dated_on," +
		        		"desi.designation," +
		        		"hrm_pen_det.ppo_no," +
		        		"hrm_pen_det.date_of_retire," +
		        		"hrm_pen_det.death_date," +
		        		"hrm_pen_det.date_of_vrs," +
		        		"hrm_pen_mst_form2.gender," +
		        		"hrm_pen_det.pension_amount              AS newpensionamount," +
		        		"hrm_pen_rev_hist.pension_amount         AS oldpensionamount," +
		        		"hrm_pen_det.dcrg_amount                 AS newdcrgamount," +
		        		"hrm_pen_rev_hist.dcrg_amount            AS olddcrgamount," +
		        		"hrm_pen_det.commutation_pen_amount      AS newcommpenamt," +
		        		"hrm_pen_rev_hist.commutation_pen_amount AS oldcommpenamt," +
		        		"hrm_pen_det.reduced_pension_amount      AS newredpenamt," +
		        		"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
		        		"hrm_pen_det.family_pension_50_amt       AS newfampen50amt," +
		        		"hrm_pen_det.family_pension_30_amt       AS newfampen30amt," +
		        		"hrm_pen_rev_hist.family_pension_50_amt  AS oldfampen50amt," +
		        		"hrm_pen_rev_hist.family_pension_30_amt  AS oldfampen30amt," +
		        		"hrm_pen_mst_auth.reference, " +
		        		"hrm_pen_mst_auth.RESIDENT_ADDRESS " +
		        		"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth" +
		        		" ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist" +
		        		" ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2" +
		        		" ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		        		"LEFT OUTER JOIN hrm_emp_current_posting post" +
		        		" ON hrm_pen_det.emp_id = post.employee_id " +
		        		"LEFT OUTER JOIN hrm_mst_designations desi" +
		        		" ON desi.designation_id = post.designation_id " +
		        		"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff" +
		        		" ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer" +
		        		" WHERE hrm_pen_rev_hist.emp_id ="+empId+" " +
		        		" AND hrm_pen_rev_hist.updated_date =(SELECT MAX(updated_date)" +
		        		"FROM HRM_PEN_APP_HO_MST_F1_DET_HIST WHERE emp_id ="+empId+")";

				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String letterno= "";
					String datedon="";
					Integer letternumbercount=0;
					Integer lettercount=0;
					String subject="";
					String prenametitle="";
					String retiredate="";
					String voluntrydate="";
					String Deathdate="";
					String information="";
					String empname="";
					String content="";
					String refinfor="";
					//String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String reference1="";
					String letterno1="";
					String content3="";
					String content4="";
					String content5="";					
					
					RevisedPensionReportModel mainpd=new RevisedPensionReportModel();									
					
					if(!(nameforfromaddress).equalsIgnoreCase("null"))
					{
					mainpd.setNAME_FROM_ADDRESS(nameforfromaddress);
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setLAST_WORK_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY ONEMAN COMMISION' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					if(!(letter_number).equalsIgnoreCase("null"))
					{
						letterno=letter_number;
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(dated_on).equalsIgnoreCase("null"))
					{
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+dated_on;
					}
					mainpd.setLETTER_NO(letterno);
					if(!(tmp[1]+"").equalsIgnoreCase("null"))
					{
					mainpd.setEMP_NAME((String)tmp[1]);
				
					}
						
					if((tmp[13]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[13]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
				
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
														
						retiredate=formatter1.format(tmp[10]);
						refinfor="(Retired)";
						information="retired on"+" "+retiredate;
						mainpd.setDATE_OF_RETIRE((Date)tmp[10]);
						
						//mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						Deathdate=formatter1.format(tmp[11]);
						refinfor="(Death)";
						information="Death On"+" "+ Deathdate;
						mainpd.setDEATH_DATE((Date)tmp[11]);
					}
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						voluntrydate=formatter1.format(tmp[12]);
						refinfor="(Voluntary Retirement)";
						information="Voluntary Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised DCRG in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					datedon=formatter1.format(tmp[7]);
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					//reference="2."+tmp[26]+"/dt. "+datedon;
					reference="2.M.D/TWAD/Chennai Proc.No.38432/E(per)/A1/2013/dt 09/03/2015";
					reference1="3."+passed_reference;
					mainpd.setREFERENCE1(reference1);
				    mainpd.setREFERENCE(reference);
					content1="In the reference first cited authorization for pension and other benefits in " +
							"respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" was issued as detailed below:";
					mainpd.setCONTENT1(content1);
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDPENSIONAMOUNT((BigDecimal)tmp[15]);
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDCOMMPENAMT((BigDecimal)tmp[19]);
						
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
				     mainpd.setOLDREDPENAMT((BigDecimal)tmp[21]);
					}
					if(!(tmp[24]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN50AMT((BigDecimal)tmp[24]);
					}
					if(!(tmp[25]+"").equalsIgnoreCase("null"))
					{
						mainpd.setOLDFAMPEN30AMT((BigDecimal)tmp[25]);
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO((BigDecimal)tmp[9]);
					}
					
					 //ppono=tmp[9]+"/TWAD";
					if(!(ppono).equalsIgnoreCase("null"))
					{
						ppono=ppono+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content2="Based on the revised pay fixation with reference to letter 2 nd cited, authorization for revised " +
					 		"pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT2(content2);
					 /*content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
					 		"  commutation value of pension as follows to "+prenametitle+" "+tmp[0]+"."+tmp[1]+","+tmp[8]+" "+refinfor+" after deducting the " +
					 		"the amount already paid towards pension and commutation value of pension as per"+tmp[6]+"Dt"+datedon+" and PPO.No."+ppono;
					 mainpd.setCONTENT2(content2);
					 content3="The difference of amount in DCRG will be paid in 3 installments.";
					 mainpd.setCONTENT3(content3);*/
										 
					 int newdcrgamount=Integer.parseInt(tmp[16]+"");
					 int olddcrgamount=Integer.parseInt(tmp[17]+"");
					 int dcrgpensionamount=newdcrgamount-olddcrgamount;
					 String sumofamount=n.rupess_to_word(dcrgpensionamount);
					
					 content3="DCRG  -  Rs."+olddcrgamount+"/-";
					 content5="Revised DCRG  -  Rs."+newdcrgamount+"/-";
					 
					 mainpd.setCONTENT3(content3);
					 mainpd.setCONTENT5(content5);
					 
					 content4="I request you to make arrangement for payment from the TWAD Board funds a sum of Rs."+dcrgpensionamount+"/-("+newdcrgamount+"-"+olddcrgamount+") "+sumofamount +
					 		" to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+" being the difference amount of revised DCRG after duly satisfying yourself about his " +
					 		"identification.";
					 mainpd.setCONTENT4(content4);
					 
					 String copy = "Copy to "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+refinfor+"\n "
				 		+tmp[27];
					 mainpd.setCOPY1(copy);
					
					mainretn.add(mainpd);
						
				}
					
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}

	
	
	
	
}
