package com.nic.hrms.pension.reports.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.reports.dao.impl.ReportRevisedPensionOrderDaoImpl.constNumtoLetter;
import com.nic.hrms.pension.model.RevisedPensionReportModel;
import com.nic.hrms.pension.reports.model.RevisedPensionReportOrderModel;
import com.nic.hrms.pension.reports.service.ReportRevisedPensionOrderService;

public class ReportRevisedPensionOrderDaoImpl implements ReportRevisedPensionOrderService {
	
private SessionFactory sessionFactory;

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<RevisedPensionReportOrderModel> getRevisedpaypensionDetails_Note(HttpServletRequest request, int empId) 
	{		   
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
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
					      "WHERE hrm_pen_rev_hist.emp_id ="+empId+" and  hrm_pen_rev_hist.updated_date=(SELECT MAX(updated_date)" +
					      "FROM hrm_pen_app_revised_pen_det WHERE emp_id ="+empId+" and REVISED_REASON='DUE TO PAY CHANGE')" +
					      "AND hrm_pen_rev_hist.REVISED_REASON='DUE TO PAY CHANGE'";
			
			*/
			
			String sqlQry="SELECT hrm_pen_det.emp_initial," +
							"hrm_pen_det.emp_name," +
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
							"hrm_pen_det.reduced_pension_amount AS newredpenamt," +
							"hrm_pen_rev_hist.reduced_pension_amount AS oldredpenamt," +
							"hrm_pen_det.family_pension_50_amt  AS newfampen50amt," +
							"hrm_pen_det.family_pension_30_amt  AS newfampen30amt," +
							"hrm_pen_rev_hist.family_pension_50_amt AS oldfampen50amt," +
							"hrm_pen_rev_hist.family_pension_30_amt AS oldfampen30amt," +
							"auth.letter_no," +
							"auth.reference," +
							"auth.dated_on " +
							"FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
							"LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist " +
							"ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
							"LEFT OUTER JOIN HRM_PEN_APP_AUTHORIZATION_ORG auth " +
							"ON hrm_pen_det.emp_id = auth.emp_no " +
							"LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 " +
							"ON hrm_pen_mst_form2.emp_no =hrm_pen_det.emp_id " +
							"WHERE hrm_pen_rev_hist.emp_id    ="+empId+" " +
							"AND hrm_pen_det.updated_date=(SELECT MAX(updated_date) " +
							"FROM hrm_pen_app_revised_pen_det " +
							"WHERE emp_id ="+empId+" AND REVISED_REASON='DUE TO PAY CHANGE')";       
			
			
			//System.out.println(sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				String prenametitle="";
				String retiredate="";
				String information="";
				String voluntrydate="";
				String Deathdate="";
				RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
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
					information="Voluntry Retirement On"+" "+ voluntrydate;
					mainpd.setDATE_OF_VRS((Date)tmp[4]);
				}
				
				
				String sub="Pension Establishment - Revision of Pensionary benefits of "+prenametitle+" "+tmp[1]+" "+
				"who "+information+" "+"reg.";
								
				String ref="1.JCE(GI)Lr.no."+tmp[18]+"/dt. "+tmp[20];
				String reference="2."+tmp[19];
			    mainpd.setREFERENCE(reference);
				//mainpd.setLETTERNO1(letterno1);
				//reference="Your Lr.No. "+tmp[26]+"/dt. "+datedon;
			   // mainpd.setREFERENCE(reference);
				//String ref="";
				
				String content1="The authorization for pensionary benefits was issued in this office Lr.no."+tmp[18]+"/dt."+tmp[20];
				
				String content2="In the ref 1st cited, orders have been issued towards authorization for pensionary benefits in respect of. "+prenametitle+" "+tmp[1]+" ." +
						"Now the pay has been revised and revised LPC along with necessary entries in the Service register has been received in the reference 2nd cited. ";
				
				String content3="Hence revised pensionary benefits are worked out and put up below. ";
				
			    String subject="Accordingly,the revised pensionary benefits found admissible with effect from to "+prenametitle+" "+tmp[1]+" "+
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
	public List<RevisedPensionReportOrderModel> getRevisedPensionDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		   {
		        con=session.connection();      
		        
		        /*
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
		        		"hrm_pen_mst_auth.ppo_no," +
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
		        		"hrm_pen_mst_auth.reference " +
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
		        		"ON authoff.authorization_id       = hrm_pen_mst_auth.authorized_officer " +
		        		"WHERE hrm_pen_rev_hist.emp_id = "+empId+" " +
		        		"AND hrm_pen_det.updated_date = (SELECT MAX(updated_date) " +
		        		"FROM hrm_pen_app_revised_pen_det WHERE emp_id = "+empId+" " +
		        		"AND revised_reason = 'DUE TO PAY REVISED PENSION')";

				
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
					String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";						
					  					
					RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
					//System.out.println(tmp[4]);
					if(!(tmp[2]+"").equalsIgnoreCase(null))
					{
					mainpd.setNAME_FROM_ADDRESS(tmp[2]+"");
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
					
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}
					
					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;					
						letterno=letterno+" Dated "+datedon;
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
						refinfor="(Voluntry Retirement)";
						information="Voluntry Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised pension/Revised commutation of pension in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);					
					}	

				   
				    
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					reference="2."+tmp[26]+"";
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
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
					 ppono=tmp[9]+""+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content1="Based on the revised pay fixation with reference to letter 2 nd cited, authorization for revised pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT1(content1);
					 content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
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
	public List<RevisedPensionReportOrderModel> getonemancommisionDetails(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		   {
		        con=session.connection();      
		        
		        /*
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
		        		"hrm_pen_mst_auth.ppo_no," +
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
		        		"hrm_pen_mst_auth.reference " +
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
		        		"ON authoff.authorization_id       = hrm_pen_mst_auth.authorized_officer " +
		        		"WHERE hrm_pen_rev_hist.emp_id = "+empId+" " +
		        		"AND hrm_pen_det.updated_date = (SELECT MAX(updated_date) " +
		        		"FROM hrm_pen_app_revised_pen_det WHERE emp_id = "+empId+" " +
		        		"AND revised_reason = 'DUE TO PAY ONEMAN COMMISION')";

				
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
					String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";						
					  					
					RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
					//System.out.println(tmp[4]);
					if(!(tmp[2]+"").equalsIgnoreCase(null))
					{
					mainpd.setNAME_FROM_ADDRESS(tmp[2]+"");
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
					
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}
					
					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;					
						letterno=letterno+" Dated "+datedon;
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
						refinfor="(Voluntry Retirement)";
						information="Voluntry Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised pension/Revised commutation of pension in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);					
					}				
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					reference="2."+tmp[26]+"";
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
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
					 ppono=tmp[9]+""+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content1="Based on the revised pay fixation with reference to letter 2 nd cited, authorization for revised pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT1(content1);
					 content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
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
	public List<RevisedPensionReportOrderModel> getspecialgradeDetails(	HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		   {
		        con=session.connection();      
		        
		        /*
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
		        		"hrm_pen_mst_auth.ppo_no," +
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
		        		"hrm_pen_mst_auth.reference " +
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
		        		"ON authoff.authorization_id       = hrm_pen_mst_auth.authorized_officer " +
		        		"WHERE hrm_pen_rev_hist.emp_id = "+empId+" " +
		        		"AND hrm_pen_det.updated_date = (SELECT MAX(updated_date) " +
		        		"FROM hrm_pen_app_revised_pen_det WHERE emp_id = "+empId+" " +
		        		"AND revised_reason = 'DUE TO PAY SPECIAL GRADE')";

				
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
					String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";						
					  					
					RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
					//System.out.println(tmp[4]);
					if(!(tmp[2]+"").equalsIgnoreCase(null))
					{
					mainpd.setNAME_FROM_ADDRESS(tmp[2]+"");
					}
					if(!(tmp[3]+"").equalsIgnoreCase(null))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase(null))
					{
				    mainpd.setPENSION_PAY_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY SPECIAL GRADE' AND emp_id = "+empId;
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
					
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}
					
					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						//datedon=formatter1.format(passed_dated_on);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;					
						letterno=letterno+" Dated "+datedon;
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
						refinfor="(Voluntry Retirement)";
						information="Voluntry Retirement On"+" "+ voluntrydate;
						mainpd.setDATE_OF_VRS((Date)tmp[12]);
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
					mainpd.setDESIGNATION((String)tmp[8]);
					}
					subject="Authorisation for the payment of Revised pension/Revised commutation of pension in respect of  "+prenametitle+" "+tmp[1]+","+tmp[8]+" "+information+"- Reg.";
					mainpd.setSUBJECT(subject);
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);					
					}				
					letterno1="1.JCE(GI)Lr.no."+tmp[6]+"/dt. "+datedon;
					mainpd.setLETTERNO1(letterno1);
					reference="2."+tmp[26]+"";
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
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
					 ppono=tmp[9]+""+"/TWAD";
					}
					else
					{
						ppono="        /TWAD";
					}
					 content1="Based on the revised pay fixation with reference to letter 2 nd cited, authorization for revised pensionary benefits in respect of "+prenametitle+" "+tmp[1]+","+tmp[8]+"  "+refinfor+" "+
					 		"holder of PPO No."+ppono+" is issued now.";
					 mainpd.setCONTENT1(content1);
					 content2="Hence in accordance with the above revision, "+tmp[5]+" is authorised to make payment the amount of pension and" +
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

	
	public List<RevisedPensionReportOrderModel> getRevisedPensionDetailssubreport(HttpServletRequest request, int empId) 
	{
		   

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
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
			
			String sqlQry="SELECT hrm_rev_hist.letter_no," +
					"hrm_rev_hist.dated_on," +
					"hrm_rev_hist.reference," +
					"hrm_rev_hist.emp_no " +
					"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_mst_org " +
					"ON hrm_mst_org.emp_no      =hrm_rev_hist.emp_no " +
					"WHERE hrm_rev_hist.emp_no  =9979 AND " +
					"hrm_rev_hist.updated_date = (select max(updated_date) " +
					"from hrm_pen_rev_auth_org_hist where emp_no="+empId+" and REV_REASON='DUE TO PAY REVISED PENSION') " +
					"AND hrm_rev_hist.rev_reason='DUE TO PAY REVISED PENSION' ";
			
				
			//System.out.println("getRevisedPensionDetailssubreport query -- "+ sqlQry);
			int temp=1;
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				String letterno="";
				String effectdate="";
				String reference="";
				RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
				
			
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
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;		
	}
	
	@SuppressWarnings("unchecked")
	public List<RevisedPensionReportOrderModel> getonemancommisionDetailssubreport(HttpServletRequest request, int empId) 
	{
		// TODO Auto-generated method stub

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
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
			
			String sqlQry="SELECT hrm_rev_hist.letter_no," +
					"hrm_rev_hist.dated_on," +
					"hrm_rev_hist.reference," +
					"hrm_rev_hist.emp_no " +
					"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_mst_org " +
					"ON hrm_mst_org.emp_no      =hrm_rev_hist.emp_no " +
					"WHERE hrm_rev_hist.emp_no  =9979 AND " +
					"hrm_rev_hist.updated_date = (select max(updated_date) " +
					"from hrm_pen_rev_auth_org_hist where emp_no="+empId+" and REV_REASON='DUE TO PAY ONEMAN COMMISION') " +
					"AND hrm_rev_hist.rev_reason='DUE TO PAY ONEMAN COMMISION' ";
			
				
			//System.out.println("getRevisedPensionDetailssubreport query -- "+ sqlQry);
			int temp=1;
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				String letterno="";
				String effectdate="";
				String reference="";
				RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
				
			
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
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	}
	@Override
	public List<RevisedPensionReportOrderModel> getspecialgradeDetailssubreport(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
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
			
			String sqlQry="SELECT hrm_rev_hist.letter_no," +
					"hrm_rev_hist.dated_on," +
					"hrm_rev_hist.reference," +
					"hrm_rev_hist.emp_no " +
					"FROM hrm_pen_rev_auth_org_hist hrm_rev_hist " +
					"LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_mst_org " +
					"ON hrm_mst_org.emp_no      =hrm_rev_hist.emp_no " +
					"WHERE hrm_rev_hist.emp_no  =9979 AND " +
					"hrm_rev_hist.updated_date = (select max(updated_date) " +
					"from hrm_pen_rev_auth_org_hist where emp_no="+empId+" and REV_REASON='DUE TO PAY SPECIAL GRADE') " +
					"AND hrm_rev_hist.rev_reason='DUE TO PAY SPECIAL GRADE' ";
			
				
			//System.out.println("getRevisedPensionDetailssubreport query -- "+ sqlQry);
			int temp=1;
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{		
				String letterno="";
				String effectdate="";
				String reference="";
				RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
				
			
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
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
	}finally{
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}		
	return mainretn;
	}
	
	public List<RevisedPensionReportOrderModel> getRevisedPensionDetailssubreport1(HttpServletRequest request, int empId) 
	{
		   //System.out.println("Entering into getRevisedPensionDetailssubreport1 method.....");

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		{                 
			con=session.connection();
		    constNumtoLetter n = new constNumtoLetter();
			String content3="";
			String copy1="";
			String copy2="";
			String officeaddress1,officeaddress2,officeaddress3;
			String refinfor="";
			String prenametitle="";
			String wefondate="";
			String diffcommamt="";
			String datedon="";
			String nextdate="";
			
					
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
		       "hrm_pen_mst_auth.reference,  "+
		       //"to_date(hrm_pen_det.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate, " +
		       "to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
				"hrm_pen_mst_auth.RESIDENT_ADDRESS, " +
				"hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS " +
		       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
		       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
		       "WHERE hrm_pen_rev_hist.emp_id="+empId+" " +
		       	"AND hrm_pen_det.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
		       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY REVISED PENSION')";
			
			/*
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
					" to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, ",
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
			*/
			
			//System.out.println("getRevisedPensionDetailssubreport1 query -- "+ sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				 int numtoworrevredpen=Integer.parseInt(tmp[20]+"");
				 RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
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
						//System.out.println(tmp[27]);
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
						
						refinfor="(Voluntry Retirement)";
						
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
				 
				 officeaddress1="Administrative Officer,";
				 officeaddress2="Head office,";
				 officeaddress3="Twad Board,Chennai-5.";
				 
				 mainpd.setOFFICEADDRESS1(officeaddress1);
				 mainpd.setOFFICEADDRESS2(officeaddress2);				 
				 mainpd.setOFFICEADDRESS3(officeaddress3);	
				 
				 String tcfbo="/t.c.f.b.o/";
				 mainpd.setTcfbo(tcfbo);
				 
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
	public List<RevisedPensionReportOrderModel> getonmancommisionDetailssubreport1(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub

		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		{                 
			con=session.connection();
		    constNumtoLetter n = new constNumtoLetter();
			String content3="";
			String copy1="";
			String copy2="";
			String officeaddress1,officeaddress2,officeaddress3;
			String refinfor="";
			String prenametitle="";
			String wefondate="";
			String diffcommamt="";
			String datedon="";
			String nextdate="";
			
					
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
		       "hrm_pen_mst_auth.reference,  "+
		       //"to_date(hrm_pen_det.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate, " +
		       "to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
				" hrm_pen_mst_auth.RESIDENT_ADDRESS, " +
				" hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS " +
		       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
		       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
		       "WHERE hrm_pen_rev_hist.emp_id="+empId+" " +
		       	"AND hrm_pen_det.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
		       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY ONEMAN COMMISION')";
			
			/*
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
					" to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, ",
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
			*/
			
			//System.out.println("getRevisedPensionDetailssubreport1 query -- "+ sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				 int numtoworrevredpen=Integer.parseInt(tmp[20]+"");
				 RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
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
						//System.out.println(tmp[27]);
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
						
						refinfor="(Voluntry Retirement)";
						
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
				 
				 officeaddress1="Administrative Officer,";
				 officeaddress2="Head office,";
				 officeaddress3="Twad Board,Chennai-5.";
				 
				 mainpd.setOFFICEADDRESS1(officeaddress1);
				 mainpd.setOFFICEADDRESS2(officeaddress2);				 
				 mainpd.setOFFICEADDRESS3(officeaddress3);	
				 
				 String tcfbo="/t.c.f.b.o/";
				 mainpd.setTcfbo(tcfbo);
				 
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
	public List<RevisedPensionReportOrderModel> getspecialgradeDetailssubreport1(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		{                 
			con=session.connection();
		    constNumtoLetter n = new constNumtoLetter();
			String content3="";
			String copy1="";
			String copy2="";
			String officeaddress1,officeaddress2,officeaddress3;
			String refinfor="";
			String prenametitle="";
			String wefondate="";
			String diffcommamt="";
			String datedon="";
			String nextdate="";
			
					
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
		       "hrm_pen_mst_auth.reference,  "+
		       //"to_date(hrm_pen_det.DATE_OF_RETIRE,'dd/mm/yyyy')+1 as nextdate, " +
		       "to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, "+
				" hrm_pen_mst_auth.RESIDENT_ADDRESS, " +
				" hrm_pen_mst_auth.PENSION_PAY_OFFICE_ADDRESS " +
		       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
		       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
		       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
		       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
		       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
		       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
		       "WHERE hrm_pen_rev_hist.emp_id="+empId+" " +
		       	"AND hrm_pen_det.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
		       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY SPECIAL GRADE')";
			
			/*
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
					" to_char(trunc(hrm_pen_det.date_of_retire+1),'DD-MM-yyyy') AS nextdate, ",
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
			*/
			
			//System.out.println("getRevisedPensionDetailssubreport1 query -- "+ sqlQry);
			List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
			for(Object[] tmp:mainli)
			{
				 int numtoworrevredpen=Integer.parseInt(tmp[20]+"");
				 RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
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
						//System.out.println(tmp[27]);
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
						
						refinfor="(Voluntry Retirement)";
						
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
				 
				 officeaddress1="Administrative Officer,";
				 officeaddress2="Head office,";
				 officeaddress3="Twad Board,Chennai-5.";
				 
				 mainpd.setOFFICEADDRESS1(officeaddress1);
				 mainpd.setOFFICEADDRESS2(officeaddress2);				 
				 mainpd.setOFFICEADDRESS3(officeaddress3);	
				 
				 String tcfbo="/t.c.f.b.o/";
				 mainpd.setTcfbo(tcfbo);
				 
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
	public List<RevisedPensionReportOrderModel> getRevisedPensionDCRGDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		   {
		        con=session.connection();
		  		
		        constNumtoLetter n = new constNumtoLetter();
		        
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_mst_auth.ppo_no," +
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
			       "hrm_pen_mst_auth.reference,  "+
			       "hrm_pen_mst_auth.RESIDENT_ADDRESS " +
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+"  AND hrm_pen_det.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY REVISED PENSION')";
		         
		        
		        /*
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
				*/
				
				//System.out.println("DCRG query---"+sqlQry);
				
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
					String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";
					String content3="";
					String content4="";
					String content5="";
					
					
					RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
					
					
					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNAME_FROM_ADDRESS(tmp[2]+"");
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
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
						
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
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
						refinfor="(Voluntry Retirement)";
						information="Voluntry Retirement On"+" "+ voluntrydate;
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
					reference="2."+tmp[26]+"";
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
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						ppono=tmp[9]+""+"/TWAD";
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
					 
					 String officeaddress1,officeaddress2,officeaddress3;
					 
					 officeaddress1="Administrative Officer,";
					 officeaddress2="Head office,";
					 officeaddress3="Twad Board,Chennai-5.";
					 
					 mainpd.setOFFICEADDRESS1(officeaddress1);
					 mainpd.setOFFICEADDRESS2(officeaddress2);				 
					 mainpd.setOFFICEADDRESS3(officeaddress3);	
					 
					 String tcfbo="/t.c.f.b.o/";
					 mainpd.setTcfbo(tcfbo);
					
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
	public List<RevisedPensionReportOrderModel> getonemancommisionDCRGDetails(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		   {
		        con=session.connection();
		  		
		        constNumtoLetter n = new constNumtoLetter();
		        
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_mst_auth.ppo_no," +
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
			       "hrm_pen_mst_auth.reference,  "+
			       "hrm_pen_mst_auth.RESIDENT_ADDRESS " +
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+"  AND hrm_pen_det.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY ONEMAN COMMISION')";
		         
		        
		        /*
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
				*/
				
				//System.out.println("DCRG query---"+sqlQry);
				
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
					String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";
					String content3="";
					String content4="";
					String content5="";
					
					
					RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
					
					
					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNAME_FROM_ADDRESS(tmp[2]+"");
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
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
						
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
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
						refinfor="(Voluntry Retirement)";
						information="Voluntry Retirement On"+" "+ voluntrydate;
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
					reference="2."+tmp[26]+"";
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
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						ppono=tmp[9]+""+"/TWAD";
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
					 
					 String officeaddress1,officeaddress2,officeaddress3;
					 
					 officeaddress1="Administrative Officer,";
					 officeaddress2="Head office,";
					 officeaddress3="Twad Board,Chennai-5.";
					 
					 mainpd.setOFFICEADDRESS1(officeaddress1);
					 mainpd.setOFFICEADDRESS2(officeaddress2);				 
					 mainpd.setOFFICEADDRESS3(officeaddress3);	
					 
					 String tcfbo="/t.c.f.b.o/";
					 mainpd.setTcfbo(tcfbo);
					
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
	@Override
	public List<RevisedPensionReportOrderModel> getspecialgradeDCRGDetails(HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<RevisedPensionReportOrderModel> mainretn=new ArrayList<RevisedPensionReportOrderModel>();
		try
		   {
		        con=session.connection();
		  		
		        constNumtoLetter n = new constNumtoLetter();
		        
				String sqlQry="SELECT  hrm_pen_det.emp_initial," +
			       "hrm_pen_det.emp_name," +
			       "hrm_pen_mst_auth.name_from_address," +
			       "authoff.authorization_desc," +
			       "hrm_pen_mst_auth.from_address," +
			       "hrm_pen_mst_auth.last_work_office_address," +
			       "hrm_pen_mst_auth.letter_no,"+
			       "hrm_pen_mst_auth.dated_on,"+
			       "desi.designation," +
			       "hrm_pen_mst_auth.ppo_no," +
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
			       "hrm_pen_mst_auth.reference,  "+
			       "hrm_pen_mst_auth.RESIDENT_ADDRESS " +
			       "FROM hrm_pen_app_ho_mst_form1_det hrm_pen_det " +
			       "LEFT OUTER JOIN hrm_pen_app_authorization_org hrm_pen_mst_auth ON hrm_pen_mst_auth.emp_no=hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN HRM_PEN_APP_HO_MST_F1_DET_HIST hrm_pen_rev_hist ON hrm_pen_det.emp_id = hrm_pen_rev_hist.emp_id " +
			       "LEFT OUTER JOIN hrm_pen_app_ho_mst_form2_det hrm_pen_mst_form2 ON hrm_pen_mst_form2.emp_no = hrm_pen_det.emp_id " +
			       "LEFT OUTER JOIN hrm_emp_current_posting post ON hrm_pen_det.emp_id = post.employee_id " +
			       "LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id  " +
			       "LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = hrm_pen_mst_auth.authorized_officer  " +
			       "WHERE hrm_pen_rev_hist.emp_id="+empId+"  AND hrm_pen_det.updated_date =(SELECT MAX(updated_date)  FROM hrm_pen_app_revised_pen_det  " +
			       "WHERE emp_id="+empId+"  AND revised_reason = 'DUE TO PAY SPECIAL GRADE')";
		         
		        
		        /*
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
				*/
				
				//System.out.println("DCRG query---"+sqlQry);
				
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
					String ppono="";
					String content1="";
					String content2="";
					String reference="";
					String letterno1="";
					String content3="";
					String content4="";
					String content5="";
					
					
					RevisedPensionReportOrderModel mainpd=new RevisedPensionReportOrderModel();
					
					
					
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
					mainpd.setNAME_FROM_ADDRESS(tmp[2]+"");
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setAUTHORIZED_OFFICER((String )tmp[3]);
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
				    mainpd.setLAST_WORK_OFFICE_ADDRESS((String)tmp[5]);
					}
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE REVISED_REASON='DUE TO PAY SPECIAL GRADE' AND emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					letternumbercount=letternumbercount+lettercount+1;
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
						
					{
						letterno=tmp[6]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
                    DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[7]);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
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
						refinfor="(Voluntry Retirement)";
						information="Voluntry Retirement On"+" "+ voluntrydate;
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
					reference="2."+tmp[26]+"";
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
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						ppono=tmp[9]+""+"/TWAD";
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
					 
					 String officeaddress1,officeaddress2,officeaddress3;
					 
					 officeaddress1="Administrative Officer,";
					 officeaddress2="Head office,";
					 officeaddress3="Twad Board,Chennai-5.";
					 
					 mainpd.setOFFICEADDRESS1(officeaddress1);
					 mainpd.setOFFICEADDRESS2(officeaddress2);				 
					 mainpd.setOFFICEADDRESS3(officeaddress3);	
					 
					 String tcfbo="/t.c.f.b.o/";
					 mainpd.setTcfbo(tcfbo);
					
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
	
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	

	


	


	


	


	


	
	

}
