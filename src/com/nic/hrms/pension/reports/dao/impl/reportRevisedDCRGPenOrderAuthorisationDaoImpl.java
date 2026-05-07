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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.reports.dao.impl.reportPenAppFieldOfficeDaoImpl.constNumtoLetter;
import com.nic.hrms.pension.reports.model.PensionerOrderDao;
import com.nic.hrms.pension.reports.service.reportRevisedDCRGPenOrderAuthorisationService;
import com.nic.hrms.pension.model.RevisedPensionAuthorizationDao;

public class reportRevisedDCRGPenOrderAuthorisationDaoImpl implements reportRevisedDCRGPenOrderAuthorisationService{

	private SessionFactory sessionFactory;

	
	/*@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getRevisedDCRGPenOrderDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<PensionerOrderDao> mainretn=new ArrayList<PensionerOrderDao>();
		try
		   {
		        con=session.connection();	
		        
		        constNumtoLetter n = new constNumtoLetter();
		        int pensionamount = 0;
		        int dcrgpensionamount = 0;
		        int commutedamount = 0;
		        int reducedpensionamount = 0;
		        int commutedpensionamount = 0;
 
				String pensiontype="";
				String classofpensionstring="";
				String comopted="";	
				String reference="";
				String refletterno="";
				
				int oldpensionamount = 0;
				int olddcrgpensionamount = 0;
				int olddapercentage = 0;
				String newdaeffectiveDate="";
				String sqlSubQry="SELECT mstform1hist.emp_id," +
						"mstform1hist.pension_amount," +
						"mstform1hist.dcrg_amount," +
						"mstform1hist.da_pert " +
						"FROM hrm_pen_app_revised_pen_det mstform1hist " +
						"LEFT OUTER JOIN hrm_pen_rev_auth_org_hist authhist ON mstform1hist.emp_id = authhist.emp_no " +
						"WHERE mstform1hist.emp_id IN (SELECT DISTINCT(emp_id) " +
						"FROM hrm_pen_app_revised_pen_det " +
						"WHERE revised_reason = 'DUE TO DA CHANGE' " +
						"AND updated_date = (SELECT MAX(updated_date) " +
						"FROM hrm_pen_app_revised_pen_det " +
						"WHERE emp_id = "+empId+")) " +
						"AND mstform1hist.emp_id IN (SELECT DISTINCT(emp_no) " +
						"FROM hrm_pen_rev_auth_org_hist " +
						"WHERE rev_reason = 'DUE TO DA CHANGE' " +
						"AND updated_date =(SELECT MAX(updated_date) " +
						"FROM hrm_pen_rev_auth_org_hist " +
						"WHERE emp_no = "+empId+")) " +
						"AND mstform1hist.revised_reason = 'DUE TO DA CHANGE' " +
						"AND authhist.rev_reason = 'DUE TO DA CHANGE' " +
						"AND mstform1hist.emp_id = "+empId;
				List<Object[]> subli=session.createSQLQuery(sqlSubQry).list();
				for(Object[] subtmp:subli)
				{								
					oldpensionamount = Integer.parseInt(subtmp[1]+"");
					olddcrgpensionamount = Integer.parseInt(subtmp[2]+"");
					olddapercentage = Integer.parseInt(subtmp[3]+"");				
				}
				
				
						
				
						String sqlQry="SELECT mstform2.emp_no," +
						"mstform2.emp_name," +
						"auth.ppo_no," +
						"auth.from_address," +
						"auth.resident_address," +
						"auth.circle_ho_office_status," +
						"auth.last_work_office_id," +
						"auth.last_work_office," +
						"auth.last_work_office_address," +
						"auth.pension_pay_office_id," +
						"auth.pension_pay_office_address," +
						"auth.letter_no," +
						"auth.dated_on," +
						"auth.reference," +
						"authoff.authorization_desc," +
						"auth.authorized_officer_address," +
						"mstform1.pension_type," +
						"mstform1.date_of_birth," +
						"mstform1.date_of_retire," +
						"mstform1.date_of_vrs," +
						"mstform1.death_date," +
						"desi.designation," +
						"offi.office_name," +
						"mstform2.gender," +
						"mstform2.husband_name," +
						"mstform1.pension_amount," +
						"mstform1.dcrg_amount," +
						"mstform1.total_commuted_amount," +
						"mstform1.reduced_pension_amount," +
						"mstform1.commutation_pen_amount," +
						"auth.process_status," +
						"auth.name_from_address, " +
						"mstform1.da_pert "+
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON mstform1.emp_id = auth.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
						"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = auth.authorized_officer " +
						"WHERE mstform1.emp_id IN (SELECT DISTINCT(emp_id) FROM hrm_pen_app_revised_pen_det " +
						"WHERE revised_reason = 'DUE TO DA CHANGE' AND updated_date =(SELECT MAX(updated_date) " +
						"FROM hrm_pen_app_revised_pen_det WHERE emp_id = "+empId+")) " +
						"AND mstform1.emp_id IN (SELECT DISTINCT(emp_no) FROM hrm_pen_rev_auth_org_hist " +
						"WHERE rev_reason = 'DUE TO DA CHANGE' AND updated_date = (SELECT MAX(updated_date) " +
						"FROM hrm_pen_rev_auth_org_hist WHERE emp_no = "+empId+")) AND mstform1.emp_id = "+empId;
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					String datedon = "";
					String letterno= "";
					String subject= "";
					String retiredate= "";
					String content= "";
					String content1= "";
					String content2= "";
					String content3= "";
					String content4= "";
					String prenametitle="";
					String effectdate="";
					String toaddress = "";
					String last_working_office_id="";
					String last_working_office_address="";
					String pension_payment_office_id="";
					String pension_payment_office_address="";
					String residentaddress="";
					Integer letternumbercount=5;
					Integer lettercount=0;
					PensionerOrderDao mainpd=new PensionerOrderDao();
					
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");
					//mainpd.setPPO_NO((BigDecimal)tmp[2]);
					mainpd.setPPO_NO(tmp[2]+"/TWAD");
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
					mainpd.setFROM_ADDRESS(tmp[3]+"");
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						residentaddress=tmp[4]+"";
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						last_working_office_id=tmp[6]+"";
						last_working_office_address=tmp[8]+"";
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						pension_payment_office_id=tmp[9]+"";
						pension_payment_office_address=tmp[10]+"";
					}
					
					toaddress=last_working_office_address;
					String[] add_split=last_working_office_address.split(",");
					System.out.println("Split 1>>>>>"+add_split[0]);
					System.out.println("Split 2>>>>>"+add_split[1]);
						try{
							if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
							{
								System.out.println("Split 1>>>>>"+add_split[2]);
								mainpd.setTO_ADDRESS3(add_split[2]);
							}
							
							if(!(add_split[3].equalsIgnoreCase(null)) || !(add_split[3].equalsIgnoreCase("")) || !(add_split[3].equalsIgnoreCase("null")))
							{
								System.out.println("Split 1>>>>>"+add_split[3]);
								mainpd.setTO_ADDRESS(add_split[3]);
							}
						}
						catch(Exception ee){
							System.out.println("Error in:"+ee.getMessage());
						}
						mainpd.setTO_ADDRESS1(add_split[0]+",");
						mainpd.setTO_ADDRESS2(add_split[1]+",");
						
					//mainpd.setTO_ADDRESS(toaddress);
					
					
					
					String strLetQuery="SELECT count(emp_id) FROM hrm_pen_app_revised_pen_det WHERE emp_id = "+empId;
					List<Object[]> subletterno=session.createSQLQuery(strLetQuery).list();
					Iterator iteleter=subletterno.iterator();
					while (iteleter.hasNext())
					{
						lettercount=Integer.parseInt(iteleter.next()+"");
						
					}
					//letternumbercount=letternumbercount+lettercount+1;
					
					
					letternumbercount=letternumbercount+lettercount;
					
					
					
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[11]+"";
						//letterno="Letter No."+letterno+" - 3";
						letterno="Letter No."+letterno+" - "+letternumbercount;
					}					
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[12]);
						//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
					}
					
						
					mainpd.setDATED_ON(datedon);
					mainpd.setLETTER_NO(letterno);
					String sub_ret_cont="";
					if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[18]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
						sub_ret_cont="who is due to retire ";
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[19]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[19]);
						sub_ret_cont="voluntarily retired ";
					}
					if(!(tmp[20]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[20]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[20]);
						sub_ret_cont="who is due to retire ";
					}
					if((tmp[23]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[23]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[24]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
					subject="Authorisation for the payment of Revised DCRG - in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" " +
					sub_ret_cont+"on "+retiredate+" - Holder of PPO No."+tmp[2]+"/TWAD.";
					mainpd.setSUBJECT(subject);
					
					refletterno="1.JCE(GI)Lr.no."+tmp[11]+"-"+3+" "+"/dt. "+datedon;
					mainpd.setREFERENCE_LETTERNO(refletterno);
					
					String strLetQuery1="select order_no from hrm_pen_mst_new_da where effect_date=(select max(effect_date) from hrm_pen_mst_new_da)";
					List<Object[]> latestnewdano=session.createSQLQuery(strLetQuery1).list();
					Iterator iteleter1=latestnewdano.iterator();
					while (iteleter1.hasNext())
					{
						reference="2."+iteleter1.next()+"";
						
					}
								
				    mainpd.setREFERENCE(reference);
					
					
					if(!(tmp[13]+"").equalsIgnoreCase("null"))
					{
					mainpd.setREFERENCE(tmp[13]+"");
					}
					
					
					if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
					mainpd.setAUTHORIZED_OFFICER(tmp[14]+"");
					}
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
					mainpd.setAUTHORIZED_OFFICER_ADDRESS(tmp[15]+"");
					}
					
					
					pensionamount=Integer.parseInt(tmp[25]+"");
					dcrgpensionamount=Integer.parseInt(tmp[26]+"");
					commutedamount=Integer.parseInt(tmp[27]+"");
					reducedpensionamount=Integer.parseInt(tmp[28]+"");
					commutedpensionamount=Integer.parseInt(tmp[29]+"");
					String newdapercentage=tmp[32]+"";
					
					String sqlSubQry1="SELECT da_id,effect_date,da_percentage,order_no " +
					"FROM hrm_pen_mst_new_da where da_percentage="+newdapercentage+
					" and updated_date=(select max(updated_date) from hrm_pen_mst_new_da)";
					List<Object[]> subli1=session.createSQLQuery(sqlSubQry1).list();
					for(Object[] subtmp1:subli1)
					{		
						newdaeffectiveDate = formatter1.format(subtmp1[1]);							
					}
					
					int remainingdcrgpensionamount=dcrgpensionamount - olddcrgpensionamount;
					
					content="Due to revision of D.A. from "+olddapercentage+" % to "+newdapercentage+" % as on "+newdaeffectiveDate+
					" the gratuity amount authorised for payment in the reference 1st cited needs revision and a " +
					"revised gratuity of Rs."+dcrgpensionamount+"/- is sanctioned to "+
					prenametitle+tmp[1]+", "+tmp[21]+" "+sub_ret_cont+"on " +retiredate+".";
									
					content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
							"Rs."+remainingdcrgpensionamount+"/- (Rs."+dcrgpensionamount+" - "+olddcrgpensionamount+") "+n.rupess_to_word(remainingdcrgpensionamount)+
							" to "+prenametitle+tmp[1]+", "+tmp[21]+" being the difference amount of revised DCRG after duly " +
							"satisfying yourself about his identification. ";
					
					
					mainpd.setCONTENT1(content1);					
					mainpd.setCONTENT(content);
					
					String copyto1content1="";
					//copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress+" with a request to contact "+toaddress;
					copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress;
										
					mainpd.setCOPY_TO1(copyto1content1);
					if((tmp[30]+"").equalsIgnoreCase("Draft"))
					{
					mainpd.setPROCESS_STATUS("("+tmp[30]+")");
					}
					if(!(tmp[31]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNAME_FROM_ADDRESS(tmp[31]+"");
					}
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
	}*/
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getRevisedDCRGPenOrderDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		//List<PensionerOrderDao> mainretn=new ArrayList<PensionerOrderDao>();
	    List<PensionerOrderDao> mainretn=new ArrayList<PensionerOrderDao>();
		try
		   {
		        con=session.connection();	
		        
		        constNumtoLetter n = new constNumtoLetter();
		    	String last_working_office_address="";
		    	String prenametitle="";
		    	String subject="";
		    	String refletterno="";
		    	String reference="";
				String empolddapercentage="";
				Integer olddcrgpensionamount=0;
				Integer olddapercentage=0;
				String effectdate="";
				String content="";
				Integer remainingdcrgpensionamount=0;
				Integer newdcrgpensionamount=0;
				String content1="";
				String letterno="";
				
									
					
					String myQry="SELECT emp.employee_id," +
							"auth.name_from_address," +
							"auth.pension_pay_office_address," +
							"auth.letter_no||' - 6 Dated '|| auth.dated_on," +
							"emp.gender," +
							"emp.EMPLOYEE_INITIAL||'.'||emp.EMPLOYEE_NAME," +
							"des.designation," +
							"app.date_of_retire," +
							"app.date_of_vrs," +
							"app.death_date," +
							"auth.PPO_NO," +
							"auth.reference," +
							"offi.office_name," +
							"emp.DATE_OF_BIRTH," +
							"app.DA_PERT," +
							"app.dcrg_amount," +
							"auth.gpo_no," +
							"auth.resident_address," +
							"auth.authorized_officer," +
							"auth.authorized_officer_address," +
							"auth.last_work_office_address," +
							"app.pension_type," +
							"app.DCRG_AMOUNT, " +
							"authoff.authorization_desc  " +
							" FROM hrm_pen_app_ho_mst_form1_det app," +
							"hrm_mst_designations des," +
							"com_mst_offices offi," +
							"HRM_PEN_APP_REV_AUTH_ORG  auth," +
							"hrm_mst_employees emp," +
							"HRM_EMP_CURRENT_POSTING post," +
							"hrm_pen_app_authorise_off_mst authoff "+
							"  WHERE app.emp_id=post.employee_id AND app.emp_id=emp.employee_id AND post.designation_id = des.designation_id " +
							"  AND app.emp_id=auth.emp_no and auth.last_work_office_id = offi.office_id AND app.emp_id=auth.emp_no " +
							"  AND authoff.authorization_id = auth.authorized_officer "+							
							"  AND app.process_status='VALIDATE'   and auth.process_status='Final'   " +
							"  AND app.emp_id IN (SELECT emp_no FROM hrm_pen_app_authorization_org  WHERE process_status='Final'  ) AND app.emp_id="+empId;

					List<Object[]> mainli=session.createSQLQuery(myQry).list();
					for(Object[] tmp:mainli)
					{
						PensionerOrderDao mainpd=new PensionerOrderDao();
						
						mainpd.setNAME_FROM_ADDRESS(tmp[1]+"");
						mainpd.setEMP_NO((BigDecimal)tmp[0]);
						mainpd.setPPO_NO(tmp[10]+"");
						mainpd.setGPO_NO(tmp[16]+"");
						if(!(tmp[2]+"").equalsIgnoreCase("null"))
						{
						mainpd.setFROM_ADDRESS(tmp[2]+"");
						}
						if(!(tmp[23]+"").equalsIgnoreCase("null"))
						{
						mainpd.setAUTHORIZED_OFFICER(tmp[23]+"");
						}
						
						if(!(tmp[20]+"").equalsIgnoreCase("null"))
						{
							
							last_working_office_address=tmp[20]+"";
						}
						
						String[] add_split=last_working_office_address.split(",");
						/*System.out.println("Split 1>>>>>"+add_split[0]);
						System.out.println("Split 2>>>>>"+add_split[1]);*/
							try{
								if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
								{
									System.out.println("Split 1>>>>>"+add_split[2]);
									mainpd.setTO_ADDRESS3(add_split[2]);
								}
								
								if(!(add_split[3].equalsIgnoreCase(null)) || !(add_split[3].equalsIgnoreCase("")) || !(add_split[3].equalsIgnoreCase("null")))
								{
									System.out.println("Split 1>>>>>"+add_split[3]);
									mainpd.setTO_ADDRESS(add_split[3]);
								}
							}
							catch(Exception ee){
								System.out.println("Error in:"+ee.getMessage());
							}
							mainpd.setTO_ADDRESS1(add_split[0]+",");
							mainpd.setTO_ADDRESS2(add_split[1]+",");
							
							String sub_ret_cont="";
							if((tmp[4]+"").equalsIgnoreCase("M"))
							{
								prenametitle="Thiru.";
							}
							if((tmp[4]+"").equalsIgnoreCase("F"))
							{
								if(!(tmp[4]+"").equalsIgnoreCase("null"))
								{
									prenametitle="Tmt.";
								}
								else
								{
									prenametitle="Selvi.";
								}
							}
							
							letterno="Letter No."+tmp[3];
							mainpd.setLETTER_NO(letterno);
							
							String dor="";
							DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
							if(!(tmp[8]+"").equalsIgnoreCase("null"))
							{
								
								dor=formatter.format(tmp[8]);
								sub_ret_cont="who  voluntarily retired";
								System.out.println("The vrs date"+dor);
							}
							else if(!(tmp[9]+"").equalsIgnoreCase("null"))
							{
								
								dor=formatter.format(tmp[9]);
								sub_ret_cont="who  death ";
								System.out.println("The dedate date"+dor);
							}
							else
							{
								
								dor=formatter.format(tmp[7]);
								sub_ret_cont="who  retired ";
								System.out.println("The retirement date"+dor);
							}

							subject="Authorisation for the payment of Revised DCRG - in respect of "+prenametitle+tmp[5]+", "+tmp[6]+" "+	sub_ret_cont+"on "+dor+" - Holder of PPO No."+tmp[10]+"/TWAD.";
					
					          mainpd.setSUBJECT(subject);
					          refletterno="1.JCE(GI)Lr.no."+tmp[11];
					          mainpd.setREFERENCE_LETTERNO(refletterno);
					          
					          String strLetQuery1="select EFFECT_DATE, ORDER_NO from hrm_pen_mst_new_da where EFFECT_DATE is not null and effect_date=(select max(effect_date) from hrm_pen_mst_new_da)";
								List<Object[]> latestnewdano=session.createSQLQuery(strLetQuery1).list();
								
								for(Object[] subtmpda:latestnewdano)
								{
									reference="2."+subtmpda[1];
									
									effectdate=formatter.format(subtmpda[0]);
								}
								/*Iterator iteleter1=latestnewdano.iterator();
								while (iteleter1.hasNext())
								{
									reference="2."+iteleter1.next()+"";
									
								}*/
											
							    mainpd.setREFERENCE(reference);
							    
							    
							    String sqlSubQry="SELECT  DCRG_AMOUNT,DA_PERT FROM HRM_PEN_APP_REVISED_PEN_DET where emp_id="+empId+" and updated_date=(select max(updated_date) from HRM_PEN_APP_REVISED_PEN_DET where emp_id="+empId+" )";

							    List<Object[]> subli=session.createSQLQuery(sqlSubQry).list();
								for(Object[] subtmp:subli)
								{								
									olddcrgpensionamount = Integer.parseInt(subtmp[0]+"");
									olddapercentage = Integer.parseInt(subtmp[1]+"");				
								}
								
												    
							    
							    content="Due to revision of D.A. from "+olddapercentage+" % to "+tmp[14]+" % as on "+effectdate+
								" the gratuity amount authorised for payment in the reference 1st cited needs revision and a " +
								"revised gratuity of Rs."+tmp[15]+"/- is sanctioned to "+
								prenametitle+tmp[5]+", "+tmp[6]+" "+sub_ret_cont+"on " +dor+".";
							    
							    mainpd.setCONTENT(content);
							    newdcrgpensionamount=Integer.parseInt(tmp[15]+"");
							    
							    if (newdcrgpensionamount>=olddcrgpensionamount)
								{
									remainingdcrgpensionamount=newdcrgpensionamount-olddcrgpensionamount;
								}
								else
								{
									remainingdcrgpensionamount=0;
								}
							    
							  
							    
							    content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
								"Rs."+remainingdcrgpensionamount+"/- (Rs."+newdcrgpensionamount+" - "+olddcrgpensionamount+") "+n.rupess_to_word(remainingdcrgpensionamount)+
								" to "+prenametitle+tmp[5]+", "+tmp[6]+" being the difference amount of revised DCRG after duly " +
								"satisfying yourself about his identification. ";
							    mainpd.setCONTENT1(content1);
							    
							    String copyto1content1="";
								//copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress+" with a request to contact "+toaddress;
								copyto1content1="Copy to "+prenametitle+tmp[5]+", "+tmp[6]+", "+tmp[17];
								mainpd.setCOPY_TO1(copyto1content1);

								String signature="";
								signature="Sd....";

								String content2="/t.c.f.b.o/";

								String content3="Administrative Officer,";
								String content4="TWAD Board,Head Office,Chennai-5";
								mainpd.setSIGNATURE(signature);
								mainpd.setCONTENT2(content2);
								mainpd.setCONTENT3(content3);
								mainpd.setCONTENT4(content4);

								
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
	         
	        
	        if (num <= 0) Str="Zero or Negative number not for conversion."; //System.out.println("Zero or Negative number not for conversion");

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





