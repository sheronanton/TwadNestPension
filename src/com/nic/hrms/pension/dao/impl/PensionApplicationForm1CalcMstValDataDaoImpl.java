package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1AverageEmolumentsDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.PensionApplicationForm1ValDao;
import com.nic.hrms.pension.service.PensionApplicationForm1CalcMstValDataService;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesValDao;
import com.nic.hrms.pension.model.PensionApplicationForm1RecoveriesDao;
import com.nic.hrms.pension.model.PensionApplicationForm1OthDeptServiceValDao;


public class PensionApplicationForm1CalcMstValDataDaoImpl implements PensionApplicationForm1CalcMstValDataService{

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
		
	
	public List<Object[]> penAppForm1MstValData(int loginEmpId, int curloginEmpId) 
	{
		List<Object[]> list=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{
			
			tx=session.beginTransaction();
			
						
			/*String strQuery="select emp.EMPLOYEE_ID," +
			"emp.EMPLOYEE_NAME," +
			"emp.EMPLOYEE_INITIAL," +
			"emp.GPF_NO," +
			"emp.DATE_OF_BIRTH," +
			"emp.GENDER," +
			"offi.office_name," +
			"desi.DESIGNATION," +
			"emp.TWAD_ENTRY_DATE," +
			"offi.OFFICE_ID," +
			"desi.DESIGNATION_ID," +
			"desi.SERVICE_GROUP_ID," +
			"post.DATE_EFFECTIVE_FROM," +
			"post.OFFICE_GRADE, " +
			"post.DATE_EFFECTIVE_FROM_SESSION, " +
			"serv.DATE_FROM, " +
			"serv.DATE_FROM_SESSION ," +
			"vie.RETIREDATE " +
			"from HRM_EMP_CURRENT_POSTING post " +
			"left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
			"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
			"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID="+loginEmpId+" "+
			"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"left outer join PEN_ALLRETIREMENTVIEW vie on vie.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"left outer join HRM_EMP_CONTROLLING_OFFICE cont on cont.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"left outer join HRM_PEN_APP_FORM1_DETAILS f1 on f1.EMP_ID=emp.EMPLOYEE_ID " +
			"where post.EMPLOYEE_ID="+loginEmpId+" and serv.EMPLOYEE_ID="+loginEmpId+
			" and serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID="+loginEmpId+")" +
			" and cont.CONTROLLING_OFFICE_ID=(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id ='"+curloginEmpId+"')" +
			" and f1.PROCESS_STATUS='ENTERED'";*/
			
			
			/*String strQuery="select emp.EMPLOYEE_ID," +
			"emp.EMPLOYEE_NAME," +
			"emp.EMPLOYEE_INITIAL," +
			"emp.GPF_NO," +
			"emp.DATE_OF_BIRTH," +
			"emp.GENDER," +
			"offi.office_name," +
			"desi.DESIGNATION," +
			"emp.TWAD_ENTRY_DATE," +
			"offi.OFFICE_ID," +
			"desi.DESIGNATION_ID," +
			"desi.SERVICE_GROUP_ID," +
			"post.DATE_EFFECTIVE_FROM," +
			"post.OFFICE_GRADE, " +
			"post.DATE_EFFECTIVE_FROM_SESSION, " +
			"serv.DATE_FROM, " +
			"serv.DATE_FROM_SESSION ," +
			"vie.RETIREDATE " +
			"from HRM_EMP_CURRENT_POSTING post " +
			"left outer join HRM_MST_DESIGNATIONS desi  on post.DESIGNATION_ID=desi.DESIGNATION_ID " +
			"left outer join com_mst_offices offi on post.OFFICE_ID=offi.OFFICE_ID " +
			"left outer join hrm_emp_service_data serv on serv.EMPLOYEE_ID="+loginEmpId+" "+
			"left outer join HRM_MST_EMPLOYEES emp on post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"left outer join PEN_ALLRETIREMENTVIEW vie on vie.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"left outer join HRM_EMP_CONTROLLING_OFFICE cont on cont.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"left outer join HRM_PEN_APP_FORM1_DETAILS f1 on f1.EMP_ID=emp.EMPLOYEE_ID " +
			"where post.EMPLOYEE_ID="+loginEmpId+" and serv.EMPLOYEE_ID="+loginEmpId+
			" and serv.DATE_FROM=(select min(DATE_FROM) from hrm_emp_service_data where EMPLOYEE_ID="+loginEmpId+")" +
			" and (cont.CONTROLLING_OFFICE_ID=(SELECT office_id FROM hrm_emp_current_posting WHERE employee_id ='"+curloginEmpId+"') " +
			"or cont.CONTROLLING_OFFICE_ID is null)" +
			" and f1.PROCESS_STATUS='ENTERED'";*/
			
			String strQuery="SELECT emp.EMPLOYEE_ID, " +
			"emp.EMPLOYEE_NAME, " +
			"emp.EMPLOYEE_INITIAL,  " +
			"emp.GPF_NO," +
			"emp.DATE_OF_BIRTH, " +
			"emp.GENDER," +
			"offi.office_name, " +
			"desi.DESIGNATION,  " +
			"emp.TWAD_ENTRY_DATE, " +
			"offi.OFFICE_ID, " +
			"desi.DESIGNATION_ID, " +
			"desi.SERVICE_GROUP_ID," +
			"post.DATE_EFFECTIVE_FROM, " +
			"post.OFFICE_GRADE," +
			"post.DATE_EFFECTIVE_FROM_SESSION," +
			"case when serv.DATE_FROM is null then" +
			" (select DATE_EFFECTIVE_FROM from HRM_EMP_CURRENT_POSTING WHERE EMPLOYEE_ID="+loginEmpId+") " +
			" else" +
			" serv.DATE_FROM " +
			" end as DATE_FROM ," +
			"serv.DATE_FROM_SESSION ," +
			"vie.RETIREDATE," +
			"post.employee_status_id FROM HRM_EMP_CURRENT_POSTING post " +
			"LEFT OUTER JOIN HRM_MST_DESIGNATIONS desi ON post.DESIGNATION_ID=desi.DESIGNATION_ID " +
			"LEFT OUTER JOIN com_mst_offices offi ON post.OFFICE_ID=offi.OFFICE_ID " +
			"LEFT OUTER JOIN hrm_emp_service_data serv ON serv.EMPLOYEE_ID="+loginEmpId+" " +
			"LEFT OUTER JOIN HRM_MST_EMPLOYEES emp ON post.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"LEFT OUTER JOIN PEN_ALLRETIREMENTVIEW vie ON vie.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"LEFT OUTER JOIN HRM_EMP_CONTROLLING_OFFICE cont ON cont.EMPLOYEE_ID=emp.EMPLOYEE_ID " +
			"WHERE post.EMPLOYEE_ID="+loginEmpId+
			" AND (serv.DATE_FROM =(SELECT MIN(DATE_FROM)   FROM hrm_emp_service_data   WHERE EMPLOYEE_ID="+loginEmpId+")  " +
			"or serv.DATE_FROM is null) " +
			"AND (cont.CONTROLLING_OFFICE_ID= (SELECT office_id FROM hrm_emp_current_posting WHERE employee_id ='"+curloginEmpId+"'  ) OR " +
			"cont.CONTROLLING_OFFICE_ID IS NULL)";  			
			
			
			
			
			 Query query=session.createSQLQuery(strQuery);	
			 list=query.list();
			 tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return list;
	}
	
	
	
	
	public List<Object[]> penAppForm1CalcOldMstValData(int loginEmpId) 
	{
		List<Object[]> oldlist=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction oldtx=null;
		try		
		{
			
			oldtx=session.beginTransaction();
			String strOldQuery="select EMP_ID," +
					"PENSION_TYPE," +
					"DATE_OF_PROVINC," +
					"DATE_OF_REG_ESTAB," +
					"DATE_OF_SELECTION," +
					"DATE_OF_SPECIAL," +
					"DATE_OF_VRS," +
					"COMM_OPTED," +
					"COMM_FACTOR_ONRTHIRD," +
					"COM_FACTOR_PERT," +
					"WCE_SERV_DAYS," +
					"WCE_SERV_MONTH," +
					"WCE_SERV_YEAR," +
					"WCE_SERV_FLAG," +
					"WCE_SERV_COUNT_FLAG," +
					"CONTINGENT_SERV_FLAG," +
					"CONTINGENT_SERV_DAYS," +
					"CONTINGENT_SERV_MONTH," +
					"CONTINGENT_SERV_YEAR," +
					"NON_PROV_SERV_DAYS," +
					"NON_PROV_SERV_MONTH," +
					"NON_PROV_SERV_YEAR," +
					"EOL_DAYS," +
					"EOL_MONTH," +
					"EOL_YEAR," +
					"SUSPENSION_DAYS," +
					"SUSPENSION_MONTH," +
					"SUSPENSION_YEAR," +
					"BOY_SERV_DAYS," +
					"BOY_SERV_MONTH," +
					"BOY_SERV_YEAR," +
					"OVERSTAY_LEAVE_DAYS," +
					"OVERSTAY_LEAVE_MONTH," +
					"OVERSTAY_LEAVE_YEAR," +
					"NOT_REG_LEAVE_DAYS," +
					"NOT_REG_LEAVE_MONTH," +
					"NOT_REG_LEAVE_YEAR," +
					"APPRENTICE_DAYS," +
					"APPRENTICE_MONTH," +
					"APPRENTICE_YEAR," +
					"NOT_SERV_VERIFY_DAYS," +
					"NOT_SERV_VERIFY_MONTH," +
					"NOT_SERV_VERIFY_YEAR," +
					"FOREIGN_SERV_DAYS," +
					"FOREIGN_SERV_MONTH," +
					"FOREIGN_SERV_YEAR," +
					"LAST_BASIC_PAY," +
					"LAST_SPECIAL_PAY," +
					"LAST_GRADE_PAY," +
					"LAST_OTHER_PAY1," +
					"LAST_OTHER_PAY2," +
					"LAST_OTHER_PAY3," +
					"PENSION_AMOUNT," +
					"DCRG_AMOUNT," +
					"NO_OF_HALFYEAR_PENSION," +
					"NO_OF_HALFYEAR_DCRG," +
					"TOTAL_COMMUTED_AMOUNT," +
					"REDUCED_PENSION_AMOUNT," +
					"FAMILY_PENSION_50_AMT," +
					"FAMILY_PENSION_30_AMT," +
					"DA_AMOUNT," +
					"COMMUTED_VALUE," +
					"COMMUTATION_PEN_AMOUNT," +
					"ACTUAL_SER_YEAR," +
					"ACTUAL_SER_MON," +
					"ACTUAL_SER_DAYS," +
					"NET_SER_YEAR," +
					"NET_SER_MON," +
					"NET_SER_DAYS," +
					"TOT_NON_QUAL_SER_YEAR," +
					"TOT_NON_QUAL_SER_MON," +
					"TOT_NON_QUAL_SER_DAYS," +
					"SCALE_OF_PAY," +
					"WEIGHTAGE_YEAR," +
					"WEIGHTAGE_MONTH," +
					"WEIGHTAGE_DAYS," +
					"FAM_PEN_UPTO_SEVEN," +
					"FAM_PEN_AFTER_SEVEN, " +
					"DEATH_DATE," +
					"OTH_DEPT_SERV_FLAG,  " +
					"LEVEL_OF_PAY  " +
					"from HRM_PEN_APP_FORM1_DETAILS where EMP_ID="+loginEmpId+" " +
					"and PROCESS_STATUS='ENTERED'";			
					

			 Query oldquery=session.createSQLQuery(strOldQuery);	
			 oldlist=oldquery.list();
			 oldtx.commit();
		}
		catch(Exception e)
		{
			oldtx.rollback();
			e.printStackTrace();
			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return oldlist;
	}
	

	
	@SuppressWarnings("unchecked")

	public List<PensionApplicationForm1AverageEmolumentsDao> loadForm1OldAeVal(int empid) {
		// TODO Auto-generated method stub
		List<PensionApplicationForm1AverageEmolumentsDao> Ae=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try {	
			
				trans = session.beginTransaction();
				
				Query qry=session.createQuery("from PensionApplicationForm1AverageEmolumentsDao where empNo="+empid+" order by fromdate1");
				
				Ae=qry.list();
				
				trans.commit();
		
		} catch(Exception e) {
		// TODO: handle exception
			trans.rollback();
		e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return Ae;
	}

	
	@SuppressWarnings("unchecked")

	public List<PensionApplicationForm1OthDeptServiceDao> loadForm1OldOtherDepServiceVal(int empid) {
		// TODO Auto-generated method stub
		List<PensionApplicationForm1OthDeptServiceDao> OtherDeptService=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try {	
			
				trans = session.beginTransaction();
				
				Query qry=session.createQuery("from PensionApplicationForm1OthDeptServiceDao where compositePK.empNo="+empid+" order by compositePK.fromdate1");
				
				OtherDeptService=qry.list();
				
				trans.commit();
		
		} catch(Exception e) {
		// TODO: handle exception
			trans.rollback();
		e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return OtherDeptService;
	}

	
	
	@SuppressWarnings("unchecked")

	public List<PensionApplicationForm1RecoveriesDao> loadForm1OldRecoveriesVal(int empid) {
		// TODO Auto-generated method stub
		List<PensionApplicationForm1RecoveriesDao> Reco=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try {	
			
				trans = session.beginTransaction();				
				Query qry=session.createQuery("from PensionApplicationForm1RecoveriesDao where empNo="+empid);				
				Reco=qry.list();				
				trans.commit();
		
		} catch(Exception e) 
		{
		// TODO: handle exception
			trans.rollback();
		e.printStackTrace();
	}
		finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
		// TODO Auto-generated method stub
		return Reco;
	}

	
	
	
	
	
	
	
	
	public List<Object[]> penAppForm1CalcSettingValData() 
	{
		List<Object[]> settinglist=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{
			
			tx=session.beginTransaction();
						
			String strQuery="select MINQUALIWCESERVICE," +
			"SELECTIONGRADEGAP," +
			"SPLGRADEGAP," +
			"VRSELIGIBLEYRS," +
			"PENELIGIBLEYRS," +
			"FAMPENCEILINGYRS," +
			"FAMPENCEILINGPERT," +
			"FAMPENAFTERPERT," +
			"PENHALFYRCEILING," +
			"DCRGHALFYRCELING," +
			"MAXDCRGAMT," +
			"AVGTOTMONTHS," +
			"RET_AGE," +
			"WEIHTAGE_MAX," +
			"FAMPENCEILING_AGE," +
			"MINPENSIONAMOUNT," +
			"MAXPENSIONAMOUNT," +
			"MINFAMPENSIONAMOUNT," +
			"MAXFAMPENSIONAMOUNT " +
			"from HRM_PEN_CAL_SETTINGS";
			 
			
			Query query=session.createSQLQuery(strQuery);	
			 settinglist=query.list();
			 tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return settinglist;
	}
	
	
	
	
	
	public List<Object[]> penAppForm1CalcAvgSettingValData() 
	{
		List<Object[]> avgsettinglist=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{
			
			tx=session.beginTransaction();
			String strQuery="select PAY_NAME,INCLUDE,DA,DISPLAY_CAPTION from AVERAGE_CAL_SETTING";
			 Query query=session.createSQLQuery(strQuery);	
			 avgsettinglist=query.list();
			 tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return avgsettinglist;
	}
	
	
	@SuppressWarnings("unchecked")
	public int penAppForm1CalcdaSettingValData(String dadate) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		int i = 0;
		try
		{
			 transaction = session.beginTransaction();
			 String str="select DA_PERCENTAGE from hrm_pen_mst_new_da " +
		 		"where effect_date=(select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date in (select min(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date>=to_date('"+dadate+"','dd/MM/yyyy')) or effect_date in (select max(effect_date) from hrm_pen_mst_new_da " +
		 		"where effect_date<=to_date('"+dadate+"','dd/MM/yyyy')))";
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
	public Double penAppForm1CalcComSettingValData(int age) {
	
		Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		Transaction transaction = null;
		
		Double i = 0.000;
		try
		{
			 transaction = session.beginTransaction();
			 String str="select COMM_VALUE from HRM_PEN_CAL_COMMUTED where AGE="+age;
			 Query query=session.createSQLQuery(str);	
			 Iterator obj=query.list().iterator();			 
			
			 while(obj.hasNext())
			 {
				 //i = Integer.parseInt(""+obj.next());
				 i=Double.parseDouble(""+obj.next());
				       	
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
	
	
	
	public List<Object[]> penAppForm1CalcEmpStatusValData(int empId) 
	{
		List<Object[]> empstatuslist=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{
			
			tx=session.beginTransaction();
			String strQuery="select DATE_EFFECTIVE_FROM,EMPLOYEE_STATUS_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID="+empId;
			 Query query=session.createSQLQuery(strQuery);	
			 empstatuslist=query.list();
			 tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();			
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
			
		}
		return empstatuslist;
	}
	
	
	
	
	
	
	public boolean savePensionAppForm1ValCalculation(PensionApplicationForm1ValDao pensionAppValform1)
	{		
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;	
				
		try
		{							
			trans = session.beginTransaction();					
			session.saveOrUpdate(pensionAppValform1);
			trans.commit();
		} 	
		
		catch (Exception e)
		{					
			e.printStackTrace();
			trans.rollback();
		}
		
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
	
		return true;
	}
	
	
	
	
	
	
	
	
	public boolean saveAddAverageEmolumentsVal(List<PensionApplicationForm1AverageEmolumentsValDao> valpenform1averageemoluments) {
        
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PensionApplicationForm1AverageEmolumentsValDao addavgemoobj=null;
		try {	
			Iterator iter = valpenform1averageemoluments.iterator();
			trans = session.beginTransaction();
			Query maxcount = session.createQuery("select max(avgID) from PensionApplicationForm1AverageEmolumentsValDao");
			while(iter!=null && iter.hasNext()){
				
				addavgemoobj = new PensionApplicationForm1AverageEmolumentsValDao();
				String maxavgemolid=null;
					try
					{
						maxavgemolid=maxcount.iterate().next().toString();
					}
					catch(Exception e)
					{
						
					}
			
				int maxavgemolid1 = maxavgemolid!=null?(Integer.parseInt(maxavgemolid))+1:1;
				
				addavgemoobj =(PensionApplicationForm1AverageEmolumentsValDao)iter.next();
				addavgemoobj.setAvgID(maxavgemolid1);
				session.save(addavgemoobj);
				
			}
			
			trans.commit();
		
		} catch (Exception e) {
			trans.rollback();
		e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
	return true;
	}
	
	
	
	
	
	
	
	public boolean saveForm1RecoveriesVal(List<PensionApplicationForm1RecoveriesValDao> valform1recmultidatlist) {       
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PensionApplicationForm1RecoveriesValDao addrecobj=null;
		try {	
			Iterator iter = valform1recmultidatlist.iterator();
			trans = session.beginTransaction();
			Query maxcount = session.createQuery("select max(recID) from PensionApplicationForm1RecoveriesValDao");
			while(iter!=null && iter.hasNext()){
				
				addrecobj = new PensionApplicationForm1RecoveriesValDao();
				String maxrecid=null;
					try
					{
						maxrecid=maxcount.iterate().next().toString();
					}
					catch(Exception e)
					{
						
					}
			
				int maxrecid1 = maxrecid!=null?(Integer.parseInt(maxrecid))+1:1;
				addrecobj =(PensionApplicationForm1RecoveriesValDao)iter.next();				
				addrecobj.setRecID(maxrecid1);
				session.save(addrecobj);
				
			}
			
			trans.commit();
		
		} catch (Exception e) {
		// TODO: handle exception
			trans.rollback();
		e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
	return true;
	}
	
	
	
	
	

	
	@SuppressWarnings("deprecation")
	public boolean deleteForm1AvgemolumentsVal(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_MST_AVG_FORM1 where EMP_ID="+emp_id);		
		//Query query = session.createSQLQuery("delete from HRM_PEN_CAL_AVG_EMOL_FORM1 where EMP_ID="+emp_id);
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
		
	}
	return flag;

	
	
	}
	
	
		
	
	

	@SuppressWarnings("deprecation")
	public boolean deleteForm1RecoveriesVal(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();		
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_MST_RECO_FORM1 where EMP_ID="+emp_id);		
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
		
	}
	return flag;

	
	
	}
	
	@SuppressWarnings("deprecation")
	public boolean deleteForm1Recoveries(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();		
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_RECOVERY_FORM1 where EMP_ID="+emp_id);
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
		
	}
	return flag;

	
	
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean deleteForm1OtherdeptserviceVal(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();		
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_MST_OTHDEPTSER_VAL where EMPLOYEEID="+emp_id);		
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
		
	}
	return flag;

	
	
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean deleteForm1othdeptservice(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();		
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_MST_OTH_DEPT_SER where EMPLOYEEID="+emp_id);		
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
		
	}
	return flag;

	
	
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean deleteForm1Avgemoluments(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_AVG_EMOL_FORM1 where EMP_ID="+emp_id);
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
		
	}
	return flag;

	
	
	}
	
	
public boolean saveAddOtherDepartmentServiceVal(List<PensionApplicationForm1OthDeptServiceValDao> penform1otherdepartmentserviceval)
{
        
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PensionApplicationForm1OthDeptServiceValDao addavgothdeptseroobj=null;
		try {	
			//Iterator iter = penform1otherdepartmentservice.iterator();
			trans = session.beginTransaction();
			
			for(PensionApplicationForm1OthDeptServiceValDao dao: penform1otherdepartmentserviceval)
			{
				session.saveOrUpdate(dao);
			}
						
			trans.commit();
			session.flush();
		
		} catch (Exception e) {
		trans.rollback();
		e.printStackTrace();
	}finally{
		session.close();
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
	return true;
	}
		
	
	

	
	
	
	

	public boolean deleteForm1Details(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();		
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_FORM1_DETAILS where EMP_ID="+emp_id);
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
		
	}
	return flag;

	
	
	}
	
		
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
