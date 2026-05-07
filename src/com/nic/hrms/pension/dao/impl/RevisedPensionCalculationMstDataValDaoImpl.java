package com.nic.hrms.pension.dao.impl;

import java.sql.CallableStatement;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.model.PensionApplicationHOForm1OthDeptServiceDao;
import com.nic.hrms.pension.model.PensionApplicationHOForm1OthDeptServiceValDao;
import com.nic.hrms.pension.model.RevisedPensionCalcOthDeptService;
import com.nic.hrms.pension.model.RevisedPensionCalcOthDeptServiceDao;
import com.nic.hrms.pension.model.RevisedPensionCalculationAverageEmolumentsDao;
import com.nic.hrms.pension.model.RevisedPensionCalculationDao;
import com.nic.hrms.pension.service.RevisedPensionCalculationMstDataValService;

public class RevisedPensionCalculationMstDataValDaoImpl implements RevisedPensionCalculationMstDataValService{

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	
		
	public List<Object[]> revisedPenCalculationMstChangeData(int loginEmpId, int curloginEmpId) 
	{
		List<Object[]> list=null;
		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{			
			tx=session.beginTransaction();			
						
			/*
			String strQuery="SELECT emp.employee_id," +
			"emp.employee_name," +
			"emp.employee_initial," +
			"emp.gpf_no," +
			"emp.date_of_birth," +
			"emp.gender," +
			"offi.office_name," +
			"desi.designation," +
			"emp.twad_entry_date," +
			"offi.office_id," +
			"desi.designation_id," +
			"desi.service_group_id," +
			"post.date_effective_from," +
			"post.office_grade," +
			"post.date_effective_from_session," +
			"serv.date_from," +
			"serv.date_from_session," +
			"vie.retiredate " +
			"FROM hrm_emp_current_posting post " +
			"LEFT OUTER JOIN hrm_mst_designations desi ON post.designation_id = desi.designation_id " +
			"LEFT OUTER JOIN com_mst_offices offi ON post.office_id = offi.office_id " +
			"LEFT OUTER JOIN hrm_emp_service_data serv ON serv.employee_id = "+loginEmpId+" " +
			"LEFT OUTER JOIN hrm_mst_employees emp ON post.employee_id = emp.employee_id " +
			"LEFT OUTER JOIN PEN_ALLRETIREMENTVIEW vie ON vie.employee_id = emp.employee_id " +
			"WHERE post.employee_id = "+loginEmpId+" " +
			"AND serv.employee_id = "+loginEmpId+" " +
			"AND serv.date_from = (" +
			"SELECT MIN(date_from) FROM hrm_emp_service_data WHERE employee_id = "+loginEmpId+") " +
			"AND post.employee_id IN (SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final')";
			*/
			
			String strQuery="select form1_det.emp_id," +
			"form1_det.emp_name," +
			"form1_det.emp_initial," +
			"form2_det.gpf_no," +
			"form1_det.date_of_birth," +
			"form2_det.gender," +
			"offi.office_name," +
			"desi.designation," +
			"form1_det.office_id," +
			"form1_det.designation_id," +
			"form1_det.desig_service_grp," +
			"form1_det.date_of_app," +
			"form2_det.grade," +
			"post.date_effective_from_session," +
			"serv.date_from," +
			"serv.date_from_session," +
			"form1_det.date_of_retire " +
			"from hrm_pen_app_ho_co_form1_det form1_det " +
			"left outer join hrm_pen_app_ho_mst_form2_det form2_det on form2_det.emp_no=form1_det.emp_id " +
			"left outer join com_mst_offices offi on offi.office_id=form1_det.office_id " +
			"left outer join hrm_emp_current_posting post on post.employee_id=form1_det.emp_id " +
			"left outer join hrm_mst_designations desi on post.designation_id = desi.designation_id " +
			"left outer join hrm_emp_service_data serv on serv.employee_id = form1_det.emp_id " +
			"where form1_det.emp_id="+loginEmpId+" and  serv.date_from = (select min(date_from)" +
			"from hrm_emp_service_data where employee_id = form1_det.emp_id) and post.employee_id in " +
			"(select emp_no from hrm_pen_app_authorization_org where process_status = 'Final')";
						 
			 		
			System.out.println("strQuery :: "+strQuery);
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
	
	
	
	public List<Object[]> revisedPenCalcChangeData(int loginEmpId, int curloginEmpId) 
	{
		List<Object[]> list=null;		
		Session session=SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction tx=null;
		try		
		{			
			tx=session.beginTransaction();				
			
			String strQuery="SELECT emp_id," +
					"emp_name," +
					"emp_initial " +
					"FROM HRM_PEN_APP_HO_CO_FORM1_DET " +
					"WHERE emp_id IN " +
					"(SELECT emp_no FROM hrm_pen_app_authorization_org WHERE process_status = 'Final') " +
					"AND emp_id = "+loginEmpId;
			
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
	
	
	
	
	
	
	
	public List<Object[]> revisedPenCalculationChangeData(int loginEmpId) 
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
					"DEATH_DATE , "+
				    "OTH_DEPT_SERV_FLAG " +
					"from HRM_PEN_APP_HO_CO_FORM1_DET where EMP_ID="+loginEmpId;			
					

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
	public List<RevisedPensionCalculationAverageEmolumentsDao> loadRevisedChangeAe(int empid) 
	{
		List<RevisedPensionCalculationAverageEmolumentsDao> Ae=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try 
		{	
			trans = session.beginTransaction();				
			Query qry=session.createQuery("from RevisedPensionCalculationAverageEmolumentsDao where empNo="+empid+" order by fromdate1");				
			Ae=qry.list();				
			trans.commit();
		}		
		catch(Exception e) 
		{		
			e.printStackTrace();
			trans.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		
		return Ae;
	}

	
	
	
	
	
	
	
	public List<Object[]> revPenCalcSettingData() 
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
	
	
	
	
	
	public List<Object[]> revPenCalcAvgSettingData() 
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
	public int revPenCalcdaSettingData(String dadate) {
	
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
	public Double revPenCalcComSettingData(int age) {
	
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
	
	
	
	
		
	public List<Object[]> revPenCalcEmpStatusData(int empId) 
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
	
	
	
	
	
	
	public boolean saveRevisedPensionValCalculation(RevisedPensionCalculationDao revisedpensionValCalc)
	{		
		
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;	
				
		try
		{							
			trans = session.beginTransaction();					
			session.saveOrUpdate(revisedpensionValCalc);
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
	
	
	
	
	
	
	
	
	public boolean saveRevisedPenValAverageEmoluments(List<RevisedPensionCalculationAverageEmolumentsDao> revPenaverageemoluments) {
        
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		RevisedPensionCalculationAverageEmolumentsDao addavgemoobj=null;
		try {	
			Iterator iter = revPenaverageemoluments.iterator();
			trans = session.beginTransaction();
			Query maxcount = session.createQuery("select max(avgID) from RevisedPensionCalculationAverageEmolumentsDao");
			while(iter!=null && iter.hasNext()){
				
				addavgemoobj = new RevisedPensionCalculationAverageEmolumentsDao();
				String maxavgemolid=null;
				
					try
					{
						maxavgemolid=maxcount.iterate().next().toString();
					}
					catch(Exception e)
					{
						
					}
			
				int maxavgemolid1 = maxavgemolid!=null?(Integer.parseInt(maxavgemolid))+1:1;
				addavgemoobj =(RevisedPensionCalculationAverageEmolumentsDao)iter.next();
				addavgemoobj.setAvgID(maxavgemolid1);
				session.save(addavgemoobj);
				
			}
			
			trans.commit();
		
		} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		trans.rollback();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}	
	return true;
	}
	
	
	
		
	@SuppressWarnings("deprecation")
	public boolean deleteRevisedAvgemoluments(int emp_id) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	boolean flag=false;
	
	try{
		trans=session.beginTransaction();
		Query query = session.createSQLQuery("delete from HRM_PEN_APP_REV_PEN_A_EMOL_CO where EMP_ID="+emp_id);		
		query.executeUpdate();
		trans.commit();
					
	}
	catch(Exception e)
	{
		trans.rollback();
		e.printStackTrace();
	}
	
	finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}
	return flag;

	
	
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean moveOldPensionDetailsIntoHistory(int empId) 
	{
	
	Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
	Transaction trans = null;
	
	try {
		trans = session.beginTransaction();
		//CallableStatement call=session.connection().prepareCall("{call REVIS_PENSION_DUE_PAY_CHANGE(?)}");//REVIS_PENSION_DUE_DA_CHANGE (empId IN NUMBER ) AS
		CallableStatement call=session.connection().prepareCall("call MOVE_MST_FORM1_DET_TO_HIST(?)");
		call.setInt(1, empId);
		System.out.println("Callable updated MOVE_MST_FORM1_DET_TO_HIST--"+call.executeUpdate());
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
	
		
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List<RevisedPensionCalcOthDeptService> loadHOOfficeForm1OldOtherDepServiceVal(
			Integer empId) {
		// TODO Auto-generated method stub
		List<RevisedPensionCalcOthDeptService> hoolddeptser=null;
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		try 
		{	
			trans = session.beginTransaction();				
			Query qry=session.createQuery("from RevisedPensionCalcOthDeptService where compositePK.empNo="+empId+" order by compositePK.fromdate1");				
			hoolddeptser=qry.list();				
			trans.commit();
		}
		catch(Exception e) 
		{		
			e.printStackTrace();
			trans.rollback();
		}
		finally
		{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}
		
		return hoolddeptser;
	}



	@Override
	public boolean deleteHOForm1OthdeptdetailsVal(Integer empNo) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		boolean flag=false;
		
		try{
			trans=session.beginTransaction();		
			Query query = session.createSQLQuery("delete from HRM_PEN_APP_HO_MST_OTHDEPTSER where EMPLOYEEID="+empNo);
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



	@Override
	public boolean saveAddHOOtherDepartmentServiceVal(List<RevisedPensionCalcOthDeptServiceDao> revvalotherdao) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		//PensionApplicationHOForm1OthDeptServiceValDao valaddavgothdeptseroobj=null;
		try {	
			//Iterator iter = penform1otherdepartmentservice.iterator();
			trans = session.beginTransaction();
			
			for(RevisedPensionCalcOthDeptServiceDao dao: revvalotherdao)
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

}
