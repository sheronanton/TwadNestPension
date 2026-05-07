package com.nic.hrms.pension.reports.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.reports.model.RevisedDCRGnoteDao;
import com.nic.hrms.pension.reports.service.reportRevisedDCRGnoteService;

public class reportRevisedDCRGnoteDaoImpl implements reportRevisedDCRGnoteService
{
	
private SessionFactory sessionFactory;


@SuppressWarnings({ "deprecation", "unchecked" })
public List<RevisedDCRGnoteDao> getRevisedDCRGnoteDetails(HttpServletRequest request, int empId) 
{
	   

	Connection con=null;
    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
	List<RevisedDCRGnoteDao> mainretn=new ArrayList<RevisedDCRGnoteDao>();
	try
	{                 
		con=session.connection();	 
		
		
		
		/*String sqlQry="SELECT rev_hist.da_pert AS olda," +
				"hrm_pen_det.emp_name," +
				"hrm_pen_det.date_of_retire," +
				"hrm_pen_det.death_date," +
				"hrm_pen_det.date_of_vrs," +
				"hrm_pen_mst_form2.gender," +
				"rev_hist.pension_amount," +
				"hrm_pen_avg.prop_pay," +
				"rev_hist.da_amount," +
				"nvl(hrm_pen_avg.basic_pay,'0')," +
				"nvl(hrm_pen_avg.grade_pay,'0')," +
				"nvl(hrm_pen_avg.special_pay,'0')," +
				"(nvl(hrm_pen_avg.other1_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0')+ nvl(hrm_pen_avg.other2_pay,'0')) AS otherpay," +
				"(nvl(hrm_pen_avg.basic_pay,'0') + nvl(hrm_pen_avg.grade_pay,'0') + nvl(hrm_pen_avg.special_pay,'0') + nvl(hrm_pen_avg.other1_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0')) AS lpd," +
				"hrm_pen_det.dcrg_amount AS newdcrgamount," +
				"rev_hist.dcrg_amount AS olddcrgamount," +
				"hrm_pen_mst_auth.letter_no," +
				"hrm_pen_mst_auth.dated_on," +
				"hrm_pen_mst_auth.reference," +
				"hrm_pen_det.da_pert," +
				"rev_hist.NO_OF_HALFYEAR_DCRG,"+
				"rev_hist.pension_type   "+
				"FROM hrm_pen_app_revised_pen_det rev_hist  " +
				"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det hrm_pen_det ON hrm_pen_det.emp_id = rev_hist.emp_id  " +
				"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id   " +
				"LEFT OUTER JOIN hrm_pen_app_ho_mst_avg_form1 hrm_pen_avg ON hrm_pen_avg.emp_id = rev_hist.emp_id  " +
				"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no = rev_hist.emp_id " +
				"WHERE rev_hist.emp_id = "+empId+"  AND rev_hist.updated_date =(SELECT MAX(updated_date) FROM hrm_pen_app_revised_pen_det  " +
				"WHERE emp_id = "+empId+" AND revised_reason = 'DUE TO DA CHANGE') AND rev_hist.revised_reason = 'DUE TO DA CHANGE'";*/
		
		String sqlQry="SELECT  emp.employee_id," +
				"(case when   emp.EMPLOYEE_INITIAL is null then   emp.EMPLOYEE_NAME else   emp.EMPLOYEE_INITIAL ||'.' ||emp.EMPLOYEE_NAME end ) as employeename," +
				"emp.gender," +
				"des.designation," +
				"app.date_of_retire," +
				"app.date_of_vrs," +
				"app.death_date," +
				"auth.PPO_NO," +
				"auth.reference," +
				"offi.office_name," +
				"emp.DATE_OF_BIRTH," +
				"NVL(app.LAST_BASIC_PAY,0)," +
				"NVL(app.LAST_SPECIAL_PAY,0)," +
				"NVL(app.LAST_GRADE_PAY,0)," +
				"(NVL(app.LAST_OTHER_PAY1,0)+NVL(app.LAST_OTHER_PAY2,0)+NVL(app.LAST_OTHER_PAY3,0)) AS othpaytot," +
				"app.da_amount," +
				"app.DA_PERT," +
				"app.DCRG_AMOUNT, " +
				"auth.dated_on,  "+
				"app.NO_OF_HALFYEAR_DCRG  "+
				"  FROM hrm_pen_app_ho_mst_form1_det app," +
				" hrm_mst_designations des," +
				" com_mst_offices offi," +
				" HRM_PEN_APP_REV_AUTH_ORG auth," +
				" hrm_mst_employees emp," +
				" HRM_EMP_CURRENT_POSTING post," +
				" hrm_pen_app_authorise_off_mst authoff  " +
				" WHERE app.emp_id=post.employee_id " +
				" AND app.emp_id               =emp.employee_id " +
				" AND post.designation_id      = des.designation_id " +
				" AND app.emp_id               =auth.emp_no " +
				" AND auth.last_work_office_id = offi.office_id " +
				" AND app.emp_id               =auth.emp_no " +
				" AND authoff.authorization_id = auth.authorized_officer " +
				" AND app.process_status       ='VALIDATE' " +
				" AND auth.process_status      ='Final' " +
				" and app.emp_id=(select revdet.emp_id from hrm_pen_app_revised_pen_det revdet " +
				" where revdet.emp_id=app.emp_id  and revdet.revised_reason='DUE TO DA CHANGE' " +
				" AND revdet.updated_date=(select max(updated_date) from hrm_pen_app_revised_pen_det rev where  rev.emp_id=app.emp_id) )" +
				" AND app.emp_id="+empId;
		
		
		//System.out.println(sqlQry);
		
		Integer totalamount=0;
		Integer newda=0;
		Integer olddcrgamount=0;
		String prenametitle="";
		String retiredate="";
		String information="";
		String voluntrydate="";
		String Deathdate="";
		String letterno="";
		String reference="";
		String pensiontype="";
		String note="";
		String effectdate="";
		Integer olddapercentage=0;
		Integer dcrgpensionamount=0;
	    Integer remainingdcrgpensionamount=0;
	    Integer basicpay=0;
	    Integer specialpay=0;
	    Integer gradpay=0;
	    Integer otherpay=0;
	    Integer newdaamount=0;
	    Integer noofhalfyeardcrg=0;
	    float  totdcrghalfyear;
	    Integer  revcaldcrgamt=0;
	    String designation="";
	    
					
		List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
		for(Object[] tmp:mainli)
		{
			    		
			
			RevisedDCRGnoteDao mainpd=new RevisedDCRGnoteDao();
			
						
			if((tmp[2]+"").equalsIgnoreCase("M"))
			{
				prenametitle="Thiru."+tmp[1];
			}
			if((tmp[2]+"").equalsIgnoreCase("F"))
			{
				if(!(tmp[2]+"").equalsIgnoreCase("null"))
				{
					prenametitle="Tmt."+tmp[1];
				}
				else
				{
					prenametitle="Selvi."+tmp[1];
				}
			}
			DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
			if(!(tmp[3]+"").equalsIgnoreCase("null"))
			{
			designation=tmp[3]+"";
			}
						
			
			if(!(tmp[5]+"").equalsIgnoreCase("null"))
			{
				voluntrydate=formatter1.format(tmp[5]);
				information="who voluntarily retired on"+" "+ voluntrydate;
				mainpd.setDATE_OF_VRS((Date)tmp[5]);
			}
			
			else if(!(tmp[4]+"").equalsIgnoreCase("null"))
			{
				retiredate=formatter1.format(tmp[4]);
				information="who  retired on"+" "+retiredate;
				mainpd.setDATE_OF_RETIRE((Date)tmp[4]);
						
			}
			
			else
			{
				Deathdate=formatter1.format(tmp[6]);
				information="who  Death on"+" "+ Deathdate;
				mainpd.setDEATH_DATE((Date) tmp[6]);
			}
			
			if(!(tmp[18]+"").equalsIgnoreCase("null"))
			{
				mainpd.setDATEDON((Date)tmp[18]);
			}
			
			
			
			letterno="1.JCE(GI)Lr.no."+tmp[8];
			mainpd.setLETTERNO(letterno);
			
			String strLetQuery1="select order_no,effect_date,DA_PERCENTAGE from hrm_pen_mst_new_da where effect_date=(select max(effect_date) from hrm_pen_mst_new_da)";
			List<Object[]> latestnewdano=session.createSQLQuery(strLetQuery1).list();
			for(Object[] tmp1:latestnewdano)
			{
				if(!(tmp1[0]+"").equalsIgnoreCase("null"))
				{
				reference="2."+tmp1[0]+"";
				}
				if(!(tmp1[1]+"").equalsIgnoreCase("null"))
				{
				effectdate=formatter1.format(tmp1[1]);
				}
				if(!(tmp1[2]+"").equalsIgnoreCase("null"))
				{
				 newda=Integer.parseInt(tmp1[2]+"");
				}
			}
			
			String strLetQuery2="select dcrg_amount,da_pert,pension_type  from hrm_pen_app_revised_pen_det  where EMP_ID="+empId+" " +
					" and REVISED_REASON='DUE TO DA CHANGE'  AND updated_date=(select max(updated_date)  from hrm_pen_app_revised_pen_det where emp_id="+empId+")";
			
			List<Object[]> olddcrgdetails=session.createSQLQuery(strLetQuery2).list();
			for(Object[] tmp2:olddcrgdetails)
			{
				olddcrgamount=Integer.parseInt(tmp2[0]+"");
				olddapercentage=Integer.parseInt(tmp2[1]+"");
				pensiontype=tmp2[2]+"";
				
			}
									
		    mainpd.setREFERENCE(reference);
			
		     basicpay=Integer.parseInt(tmp[11]+"");
		     specialpay=Integer.parseInt(tmp[12]+"");
		     gradpay=Integer.parseInt(tmp[13]+"");
		     otherpay=Integer.parseInt(tmp[14]+"");
		    
		    mainpd.setBASICPAY((BigDecimal)tmp[11]);
		    mainpd.setGRADEPAY((BigDecimal)tmp[13]);
		    mainpd.setSPECIALPAY((BigDecimal)tmp[12]);
		    mainpd.setOTHERPAY((BigDecimal)tmp[14]);
		    mainpd.setNEWDAPERCENTAGE(Integer.toString(newda)+"%");
		   
			//mainpd.setLPDAMOUNT((BigDecimal)tmp[13]);
		    
		    dcrgpensionamount=Integer.parseInt(tmp[17]+"");
			mainpd.setNEWDCRGAMOUNT((BigDecimal)tmp[17]);
			
			BigDecimal olddcrgamt=new BigDecimal(olddcrgamount);
			newdaamount=Integer.parseInt(tmp[15]+"");
			BigDecimal newdaamount1=new BigDecimal(newdaamount);
			mainpd.setDAAMOUNT(newdaamount1);
			noofhalfyeardcrg=Integer.parseInt(tmp[19]+"");
			revcaldcrgamt=Integer.parseInt(tmp[17]+"");
			
			totalamount=basicpay+specialpay+gradpay+otherpay;
			
			mainpd.setOLDDCRGAMOUNT(olddcrgamt);
			
			
			
			if (dcrgpensionamount>=olddcrgamount)
			{
				remainingdcrgpensionamount=dcrgpensionamount-olddcrgamount;
			}
			else
			{
				remainingdcrgpensionamount=0;
			}
               BigDecimal remaindcrg=new BigDecimal(remainingdcrgpensionamount);
               
               
              
			   mainpd.setDiffdcrgamount(remaindcrg);			
		
			System.out.println("The pension type is"+pensiontype);

			if(!(pensiontype.equalsIgnoreCase("null")))
			{
				if((pensiontype.equalsIgnoreCase("1"))|| (pensiontype.equalsIgnoreCase("2")) )
				{ 

					totdcrghalfyear=Float.parseFloat(0.25+"");
					note="Note:Revised DCRG:("+totalamount+"+"+newdaamount+")*("+noofhalfyeardcrg+")*("+totdcrghalfyear+")="+dcrgpensionamount;
					System.out.println("The revcaldcrgamt"+revcaldcrgamt);


				}
				if(pensiontype.equalsIgnoreCase("3"))
				{
					
					totdcrghalfyear=Float.parseFloat(0.5+"");
					note="Note:Revised DCRG:("+totalamount+"+"+newdaamount+")*("+noofhalfyeardcrg+")*("+totdcrghalfyear+")="+dcrgpensionamount;
	
				}
				
			}
			
			
			 String subject="Pension Establishment - Gratuity revision due to enhancement of Dearness Allowance from "+olddapercentage+" % to "+newda+" %  as on "+effectdate+"-Reg";  
			    mainpd.setSUBJECT(subject);
			    mainpd.setNOTE(note);
			   	
			
		    String content="In the reference 2 nd cited the Dearness Allowance of the Board's employees has been raised from "+olddapercentage+"%  to "+newda+"% with effect from "+effectdate+".";
		    mainpd.setCONTENT(content);
		    String content1="As gratuity of "+prenametitle+", "+designation+" "+information+" has been originally calculated taking into account the Dearness Allowance at "+olddapercentage+"%," +
		    		"Now revised orders authorising for payment of difference amount of gratuity due to enhancement of Dearness Allowance from  "+olddapercentage+"%"  +
		    		" to "+newda+"%  w.e.f  "+effectdate+" may be issued, as per the calculation given below.";
		    mainpd.setCONTENT1(content1);
		    
		    
		  //  System.out.println(subject);
		  
		    mainretn.add(mainpd);	
			break;
		}
		
		 con.commit();
         
		
	}
	catch (Exception e) {
		e.printStackTrace();
}
finally
{
	SessionFactoryUtils.releaseSession(session, sessionFactory);
}		
return mainretn;
    
	
	
}


/*@SuppressWarnings({ "deprecation", "unchecked" })
public List<RevisedDCRGnoteDao> getRevisedDCRGnoteDetailssubreport(HttpServletRequest request, int empId) 
{
	   

	Connection con=null;
    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
	List<RevisedDCRGnoteDao> mainretn=new ArrayList<RevisedDCRGnoteDao>();
	try
	{                 
		con=session.connection();
		
		
		String sqlQry="SELECT  hrm_rev_hist.letter_no,hrm_rev_hist.dated_on,hrm_rev_hist.reference,hrm_rev_hist.emp_no " +
				"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist  " +
				"left outer join hrm_pen_app_authorization_org hrm_mst_org on hrm_mst_org.emp_no=hrm_rev_hist.emp_no " +
				"where hrm_rev_hist.emp_no="+empId+" and rev_reason='DUE TO DA CHANGE'";
		//System.out.println(sqlQry);
		int temp=1;
		List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
		for(Object[] tmp:mainli)
		{		
			String letterno="";
			String effectdate="";
			String reference="";
			RevisedDCRGnoteDao mainpd=new RevisedDCRGnoteDao();
			temp=temp+1;
			letterno=temp+".  "+"JCE(GI)Lr.No."+tmp[0];
			mainpd.setLETTERNO(letterno);
		    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
			if(!(tmp[1]+"").equalsIgnoreCase("null"))
			{
				effectdate=formatter1.format(tmp[1]);
				mainpd.setDATEDON((Date)tmp[1]);
			}
			mainpd.setEMPNO((BigDecimal)tmp[3]);
			reference="Managing Directors-Procs.No. "+tmp[2]+" "+effectdate;
			//System.out.println(reference);
		    mainpd.setREFERENCE(reference);
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
*/
	
	/*@SuppressWarnings({ "deprecation", "unchecked" })
	public List<RevisedDCRGnoteDao> getRevisedDCRGnoteDetails(HttpServletRequest request, int empId) 
	{
		   

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedDCRGnoteDao> mainretn=new ArrayList<RevisedDCRGnoteDao>();
		try
		{                 
			con=session.connection();	 
			
			String sqlQry="SELECT  rev_hist.da_pert AS olda," +
							"hrm_da.da_percentage AS newda," +
							"hrm_da.effect_date," +
							"hrm_pen_det.emp_name," +
							"hrm_pen_det.date_of_retire," +
							"hrm_pen_det.death_date," +
							"hrm_pen_det.date_of_vrs," +
							"hrm_pen_mst_form2.gender," +
							"rev_hist.pension_amount," +
							"hrm_pen_avg.prop_pay," +
							"rev_hist.da_amount," +
							"nvl(hrm_pen_avg.basic_pay,'0')," +
							"nvl(hrm_pen_avg.grade_pay,'0')," +
							"nvl(hrm_pen_avg.special_pay,'0')," +
							"(nvl(hrm_pen_avg.other1_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0')) AS otherpay," +
							"(nvl(hrm_pen_avg.basic_pay,'0') + nvl(hrm_pen_avg.grade_pay,'0') + nvl(hrm_pen_avg.special_pay,'0') + nvl(hrm_pen_avg.other1_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0')) AS lpd," +
							" hrm_pen_det.dcrg_amount AS newdcrgamount,rev_hist.dcrg_amount AS olddcrgamount," +
							"hrm_pen_mst_auth.letter_no," +
							"hrm_pen_mst_auth.dated_on," +
							"hrm_pen_mst_auth.reference  FROM hrm_pen_app_revised_pen_det rev_hist" +
							" LEFT OUTER JOIN hrm_pen_mst_new_da hrm_da ON hrm_da.da_percentage = rev_hist.da_pert" +
							" LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det hrm_pen_det ON hrm_pen_det.emp_id = rev_hist.emp_id " +
							" LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id" +
							" LEFT OUTER JOIN hrm_pen_app_ho_mst_avg_form1 hrm_pen_avg ON hrm_pen_avg.emp_id = rev_hist.emp_id " +
							"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth on hrm_pen_mst_auth.emp_no=rev_hist.emp_id  " +
							"WHERE rev_hist.emp_id ="+empId+" AND rev_hist.updated_date = (SELECT MAX(updated_date) FROM hrm_pen_app_revised_pen_det  WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO DA CHANGE')" +
							"AND rev_hist.revised_reason = 'DUE TO DA CHANGE'";
			
			String sqlQry="SELECT rev_hist.da_pert AS olda," +
					"hrm_pen_det.emp_name," +
					"hrm_pen_det.date_of_retire," +
					"hrm_pen_det.death_date," +
					"hrm_pen_det.date_of_vrs," +
					"hrm_pen_mst_form2.gender," +
					"rev_hist.pension_amount," +
					"hrm_pen_avg.prop_pay," +
					"rev_hist.da_amount," +
					"nvl(hrm_pen_avg.basic_pay,'0')," +
					"nvl(hrm_pen_avg.grade_pay,'0')," +
					"nvl(hrm_pen_avg.special_pay,'0')," +
					"(nvl(hrm_pen_avg.other1_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0')+ nvl(hrm_pen_avg.other2_pay,'0')) AS otherpay," +
					"(nvl(hrm_pen_avg.basic_pay,'0') + nvl(hrm_pen_avg.grade_pay,'0') + nvl(hrm_pen_avg.special_pay,'0') + nvl(hrm_pen_avg.other1_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0') + nvl(hrm_pen_avg.other2_pay,'0')) AS lpd," +
					"hrm_pen_det.dcrg_amount AS newdcrgamount," +
					"rev_hist.dcrg_amount AS olddcrgamount," +
					"hrm_pen_mst_auth.letter_no," +
					"hrm_pen_mst_auth.dated_on," +
					"hrm_pen_mst_auth.reference," +
					"hrm_pen_det.da_pert," +
					"rev_hist.NO_OF_HALFYEAR_DCRG,"+
					"rev_hist.pension_type   "+
					"FROM hrm_pen_app_revised_pen_det rev_hist  " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det hrm_pen_det ON hrm_pen_det.emp_id = rev_hist.emp_id  " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id   " +
					"LEFT OUTER JOIN hrm_pen_app_ho_mst_avg_form1 hrm_pen_avg ON hrm_pen_avg.emp_id = rev_hist.emp_id  " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no = rev_hist.emp_id " +
					"WHERE rev_hist.emp_id = "+empId+"  AND rev_hist.updated_date =(SELECT MAX(updated_date) FROM hrm_pen_app_revised_pen_det  " +
					"WHERE emp_id = "+empId+" AND revised_reason = 'DUE TO DA CHANGE') AND rev_hist.revised_reason = 'DUE TO DA CHANGE'";
			//System.out.println(sqlQry);
			
			Integer pensionamount=0;
			Integer daamount=0;
			Integer specialamount=0;
			Integer gradepay=0;
			Integer totalamount=0;
			double noofhalfyear=0.0;
			Integer letternumbercount=5;
			Integer lettercount=0;
						
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				String prenametitle="";
				String retiredate="";
				String information="";
				String voluntrydate="";
				String Deathdate="";
				String letterno="";
				String reference="";
				String dateon="";
				String newdaeffectiveDate="";
				String pensiontype="";
				String note="";
				
				
				
				RevisedDCRGnoteDao mainpd=new RevisedDCRGnoteDao();
				
				
				
				if((tmp[5]+"").equalsIgnoreCase("M"))
				{
					prenametitle="Thiru."+tmp[1];
				}
				if((tmp[5]+"").equalsIgnoreCase("F"))
				{
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						prenametitle="Tmt."+tmp[1];
					}
					else
					{
						prenametitle="Selvi."+tmp[1];
					}
				}
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				
				if(!(tmp[2]+"").equalsIgnoreCase("null"))
				{
					retiredate=formatter1.format(tmp[2]);
					information="retired on"+" "+retiredate;
					mainpd.setDATE_OF_RETIRE((Date)tmp[2]);
							
				}
				
				if(!(tmp[4]+"").equalsIgnoreCase("null"))
				{
					voluntrydate=formatter1.format(tmp[4]);
					information="Voluntry Retirement On"+" "+ voluntrydate;
					mainpd.setDATE_OF_VRS((Date)tmp[4]);
				}
				
				if(!(tmp[3]+"").equalsIgnoreCase("null"))
				{
					Deathdate=formatter1.format(tmp[3]);
					information="Death On"+" "+ Deathdate;
					mainpd.setDEATH_DATE((Date) tmp[3]);
				}
				
				if(!(tmp[17]+"").equalsIgnoreCase("null"))
				{
					dateon=formatter1.format(tmp[17]);
					mainpd.setDATEDON((Date)tmp[17]);
				}
				
				if(!(tmp[1]+"").equalsIgnoreCase("null"))
				{
									
				}
				
				String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE emp_id = "+empId;
				List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
				Iterator iteleter=subletterno.iterator();
				while (iteleter.hasNext())
				{
					lettercount=Integer.parseInt(iteleter.next()+"");
					
				}
				//letternumbercount=letternumbercount+lettercount+1;
				
				
				letternumbercount=letternumbercount+lettercount;
				
				letterno="1.JCE(GI)Lr.no."+tmp[16]+"-"+3+" "+"/dt. "+dateon;
				mainpd.setLETTERNO(letterno);
				
				String strLetQuery1="select order_no from hrm_pen_mst_new_da where effect_date=(select max(effect_date) from hrm_pen_mst_new_da)";
				List<Object[]> latestnewdano=session.createSQLQuery(strLetQuery1).list();
				Iterator iteleter1=latestnewdano.iterator();
				while (iteleter1.hasNext())
				{
					reference="2."+iteleter1.next()+"";
					
				}
							
			    mainpd.setREFERENCE(reference);
				
				reference="Managing Directors-Procs.No. "+tmp[18]+"/dt. "+dateon;
			    mainpd.setREFERENCE(reference);
				
				mainpd.setPENSIONAMOUNT((BigDecimal)tmp[6]);
				mainpd.setPROPAMOUNT((BigDecimal)tmp[7]);
				mainpd.setDAAMOUNT((BigDecimal)tmp[8]);
			    mainpd.setBASICPAY((BigDecimal)tmp[9]);
			    mainpd.setGRADEPAY((BigDecimal)tmp[10]);
			    mainpd.setSPECIALPAY((BigDecimal)tmp[11]);
			    mainpd.setOTHERPAY((BigDecimal)tmp[12]);
				mainpd.setLPDAMOUNT((BigDecimal)tmp[13]);
				mainpd.setNEWDCRGAMOUNT((BigDecimal)tmp[14]);
				mainpd.setOLDDCRGAMOUNT((BigDecimal)tmp[15]);
				String olddapercentage="";
				String newdapercentage=tmp[19]+"";
				if(!(tmp[0]+"").equalsIgnoreCase("null"))
				{
					olddapercentage=tmp[0]+"";
				}
				if(!(tmp[19]+"").equalsIgnoreCase("null"))
				{
					newdapercentage=tmp[19]+"";
				}
				
				pensiontype=tmp[21]+"";
				//System.out.println("The pension type is"+pensiontype);
				
				if(!(tmp[6]+"").equalsIgnoreCase("null"))
				{
					pensionamount=Integer.parseInt(tmp[6]+"");
				}
				
				if(!(tmp[8]+"").equalsIgnoreCase("null"))
				{
					daamount=Integer.parseInt(tmp[8]+"");
				}
				if(!(tmp[11]+"").equalsIgnoreCase("null"))
				{
					specialamount=Integer.parseInt(tmp[11]+"");
				}
				
				if(!(tmp[10]+"").equalsIgnoreCase("null"))
				{
					gradepay=Integer.parseInt(tmp[10]+"");
				}
				
				if(!(tmp[20]+"").equalsIgnoreCase("null"))
				{
					noofhalfyear=Double.parseDouble(tmp[20]+"");
				}
				 
				totalamount=pensionamount+daamount+specialamount+gradepay;
				NumberFormat df1=new DecimalFormat("######0");
				if(pensiontype.equalsIgnoreCase("1"))
				{
					note="Note:Revised DCRG:"+totalamount+"*("+df1.format(noofhalfyear)+"/66)*0.25="+df1.format((totalamount*(noofhalfyear/66)*0.25));
					//System.out.println("The value is"+totalamount*(noofhalfyear/66)*0.25);
					mainpd.setNOTE(note);
					
								
				}
				if(pensiontype.equalsIgnoreCase("2"))
				{
					note="Note:Revised DCRG:"+totalamount+"*("+df1.format(noofhalfyear)+"/66)*0.25="+df1.format((totalamount*(noofhalfyear/66)*0.25));
					mainpd.setNOTE(note);
				}
				if(pensiontype.equalsIgnoreCase("3"))
				{
					note="Note:Revised DCRG:"+totalamount+"*("+df1.format(noofhalfyear)+"/66)*0.5="+df1.format((totalamount*(noofhalfyear/66)*0.5));
					mainpd.setNOTE(note);
				}
				
				
				String sqlSubQry1="SELECT da_id,effect_date,da_percentage,order_no " +
				"FROM hrm_pen_mst_new_da where da_percentage="+newdapercentage+
				" and updated_date=(select max(updated_date) from hrm_pen_mst_new_da)";
				List<Object[]> subli1=session.createSQLQuery(sqlSubQry1).list();
				for(Object[] subtmp1:subli1)
				{		
					newdaeffectiveDate = formatter1.format(subtmp1[1]);							
				}
				
				 String subject="Pension Establishment - Gratuity revision due to enhancement of Dearness Allowance from "+olddapercentage+" % to "+newdapercentage+" %  as on "+newdaeffectiveDate+"-Reg";  
				    mainpd.setSUBJECT(subject);
				   	
				
			    String content="In the reference 2 nd cited the Dearness Allowance of the Board's employees has been raised from "+olddapercentage+"%  to "+newdapercentage+"% with effect from "+newdaeffectiveDate+".";
			    mainpd.setCONTENT(content);
			    String content1="As gratuity of "+prenametitle+" "+information+" has been originally calculated taking into account the Dearness Allowance at "+olddapercentage+"%," +
			    		"Now revised orders authorising for payment of difference amount of gratuity due to enhancement of Dearness Allowance at  "+olddapercentage+"%"  +
			    		"gratuity due to enahancement of Dearness Allowance at "+newdapercentage+"%  as on "+newdaeffectiveDate+" may be issued, as per the calculation given below.";
			    mainpd.setCONTENT1(content1);
			  //  System.out.println(subject);
			  	mainretn.add(mainpd);	
				break;
			}
			
			 con.commit();
	         
			
		}
		catch (Exception e) {
			e.printStackTrace();
	}
	finally
	{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	    
		
		
	}
*/
	
	
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
	

}
