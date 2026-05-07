package com.nic.hrms.pension.reports.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


import com.nic.hrms.pension.reports.dao.impl.reportPenAppFieldOfficeDaoImpl.constNumtoLetter;
import com.nic.hrms.pension.reports.model.PensionerOrderDao;
import com.nic.hrms.pension.reports.service.reportPenOrderAuthorisationService;

public class reportPenOrderAuthorisationDaoImpl implements reportPenOrderAuthorisationService{

	private SessionFactory sessionFactory;

	private String forward="/t.c.f.b.o/",forward_officer="Administrative Officer,",forward_officer1="Head office ,",forward_officer2="Twad Board,Chennai-5",auth="Sd....";
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder1Details(HttpServletRequest request, int empId) {
		
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
//				"to_date(mstform1.date_of_retire + 1,   'DD/MM/YY') AS effectdate," +
//				"to_date(mstform1.date_of_vrs + 1,   'DD/MM/YY') AS effectdate_vrs," +
//				"to_date(mstform1.death_date + 1,   'DD/MM/YY') AS effectdate_death," +
				"mstform1.date_of_retire + 1 AS effectdate," +
			    "mstform1.date_of_vrs + 1 AS effectdate_vrs," +
                "mstform1.death_date + 1 AS effectdate_death," +
				"auth.process_status, " +
				"auth.name_from_address, " +
//				"REGEXP_SUBSTR(name_from_address,'[^,]+') AS name_sd " + 
                "SUBSTRING(name_from_address FROM 7 FOR LENGTH(name_from_address) - 12) "+
				//"substring(name_from_address from 0 for position(',' IN name_from_address)) "+
				"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
				"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
				"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON mstform1.emp_id = auth.emp_no " +
				"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
				"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
				"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
				"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = auth.authorized_officer " +
				"WHERE mstform1.emp_id = "+empId;
				
				
				
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
					String ppo_no="";
					String residentaddress="";
					
					PensionerOrderDao mainpd=new PensionerOrderDao();
					
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");
					//mainpd.setPPO_NO((BigDecimal)tmp[2]);
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						mainpd.setPPO_NO(tmp[2]+"/TWAD");
						ppo_no=tmp[2]+"";
					}
					else
					{
						mainpd.setPPO_NO("          /TWAD");
						ppo_no="          ";
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						residentaddress=tmp[4]+"";
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						mainpd.setFROM_ADDRESS(tmp[3]+"");
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
					String[] add_split=pension_payment_office_address.split(",");
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
					toaddress=pension_payment_office_address;
					System.out.println("toaddress>>>"+toaddress);
					mainpd.setTO_ADDRESS1(add_split[0]+",");
					mainpd.setTO_ADDRESS2(add_split[1]+",");
					
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[11]+"";
						letterno="Letter No."+letterno+" - 1";
					}					
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[12]);
						//letterno="Letter No."+letterno+" - 1 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
					}
					mainpd.setDATED_ON(datedon);
					mainpd.setLETTER_NO(letterno);
					String sub_ret_cont="";
					if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[18]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
						sub_ret_cont=" retired  ";
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
						sub_ret_cont=" retired ";
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
					/*subject="Issuing of P.P.O. NO."+ppo_no+"/TWAD,E.Code - "+tmp[0]+" in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" " +
							"who is due to retire on "+retiredate+" - Reg.";*/
					
					subject="Issuing of P.P.O. NO."+ppo_no+"/TWAD,E.Code - "+tmp[0]+" in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" " +
					sub_ret_cont+"on "+retiredate+" - Reg.";
					mainpd.setSUBJECT(subject);
					if(!(tmp[13]+"").equalsIgnoreCase("null"))
					{
					mainpd.setREFERENCE(tmp[13]+"");
					}
					if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
					mainpd.setAUTHORIZED_OFFICER(tmp[14]+"");
					}
					if((tmp[33]+"").equalsIgnoreCase("Final"))
					{
						mainpd.setAUTH(auth+" "+tmp[35]);
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
					
					if(!(tmp[30]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[30]);
					}
					if(!(tmp[31]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[31]);
					}
					if(!(tmp[32]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[32]);
					}
					
					content="I forward herewith the P.P.O. NO."+ppo_no+"/TWAD, E.Code - "+tmp[0]+" in favour " +
							"of "+prenametitle+tmp[1]+", "+tmp[21]+" for Rs."+pensionamount+"/-"+n.rupess_to_word(pensionamount)+" with " +
							"effect from " +effectdate+".";
					
									
					content1="The pensioner's portion of the order may be made over to him/her after satifying yourself about his/her " +
							"identity and after obtaining his/her signature on the disburser's portion.";
					
					
					mainpd.setCONTENT1(content1);
					mainpd.setCONTENT2(content2);
					mainpd.setCONTENT3(content3);					
					mainpd.setCONTENT(content);
					
					String copyto1content1="";
					String copyto1content2="";
					
					copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress+" with a request to contact "+toaddress;
					
					
						//System.out.println("last_working_office_id"+last_working_office_id);
						//System.out.println("pension_payment_office_id"+pension_payment_office_id);
						//if(last_working_office_id!=pension_payment_office_id)
						if(!last_working_office_id.equalsIgnoreCase(pension_payment_office_id))
						{
							copyto1content2="Copy to "+last_working_office_address;
						}
						System.out.println("copyto1content1"+copyto1content1+"-"+auth+" "+tmp[1]);
						System.out.println("copyto1content2"+copyto1content2);
											
					//copyto1content2="Copy to "+pension_payment_office_address;
					
					mainpd.setCOPY_TO1(copyto1content1);
					mainpd.setCOPY_TO2(copyto1content2);
					if((tmp[33]+"").equalsIgnoreCase("Draft"))
					{
					mainpd.setPROCESS_STATUS("("+tmp[33]+")");
					}
					if(!(tmp[34]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNAME_FROM_ADDRESS(tmp[34]+"");
					}
					if((tmp[33]+"").equalsIgnoreCase("Final"))
					{
						mainpd.setFORWARD(forward);
						mainpd.setFORWARD_OFFICER(forward_officer);
						mainpd.setFORWARD_OFFICER1(forward_officer1);
						mainpd.setFORWARD_OFFICER2(forward_officer2);
					}
					
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
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder2Details(HttpServletRequest request, int empId) {
		
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
						"mstform1.commutation_pen_amount, "+
						"mstform1.DATE_OF_RETIRE+1 AS EFFECTDATE," +
						"mstform1.DATE_OF_VRS+1 AS EFFECTDATE_VRS," +
						"mstform1.DEATH_DATE+1 AS EFFECTDATE_DEATH, " +
						"auth.gpo_no, " +
						"auth.process_status ," +
						"  auth.name_from_address, " +
//						"  REGEXP_SUBSTR(name_from_address,'[^,]+') AS name_sd "+ 
						"substring(name_from_address from 0 for position(',' IN name_from_address)) "+	
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON mstform1.emp_id = auth.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
						"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = auth.authorized_officer " +
						"WHERE mstform1.emp_id = "+empId;				
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
					String ppo_no="";
					PensionerOrderDao mainpd=new PensionerOrderDao();
					
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setECODE(tmp[0]+"/TWAD");
					//mainpd.setEMP_NAME(tmp[1]+", "+tmp[21]);
					//mainpd.setPPO_NO((BigDecimal)tmp[2]);
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
					mainpd.setPPO_NO(tmp[2]+"/TWAD");
					ppo_no=tmp[2]+"";
					}
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
					mainpd.setFROM_ADDRESS(tmp[3]+"");
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
					/*if(last_working_office_id.equalsIgnoreCase(pension_payment_office_id))
					{
						toaddress=last_working_office_address;
					}
					else
					{
						toaddress=pension_payment_office_address;
					}*/
					//toaddress=last_working_office_address;
					toaddress=pension_payment_office_address;
					mainpd.setTO_ADDRESS(toaddress);
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[11]+"";
						letterno="Letter No."+letterno+" - 2";
					}					
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[12]);
						//letterno="Letter No."+letterno+" - 2 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
					}
					mainpd.setDATED_ON(datedon);
					mainpd.setLETTER_NO(letterno);
					System.out.println("TMP{16 } Value is:::"+tmp[16].toString());
					String  vrscontent="Please note that payment should be made only on receipt of clear unconditional retirement order issued by the competent authority.";
					int tmp16=Integer.parseInt((tmp[16]+""));
					System.out.println("INT VALUE:::"+tmp16);
					if(tmp16==5)//(!(tmp[16]+"").equalsIgnoreCase("5"))
					{
						mainpd.setVRS_CONTENT("");
					}
					else
					{
						mainpd.setVRS_CONTENT(vrscontent);
					}
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
					mainpd.setEMP_NAME(prenametitle+" "+tmp[1]+", "+tmp[21]);
					/*subject="Authorisation for the payment of Gratuity in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" " +
							"who is due to retire on "+retiredate+" - Reg.";*/
					subject="Authorisation for the payment of Gratuity in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" " +
					sub_ret_cont+"on "+retiredate+" - Reg.";
					mainpd.setSUBJECT(subject);
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
					
					if(!(tmp[30]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[30]);
					}
					if(!(tmp[31]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[31]);
					}
					if(!(tmp[32]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[32]);
					}
											
					content="UNTIL FURTHER NOTICE, and on the expiration of every month, you are authorised to " +
							"pay "+prenametitle+tmp[1]+", "+tmp[21]+" the sum of Rs."+pensionamount+" /- "+n.rupess_to_word(pensionamount)+
							" being the amount of Superannuation PENSION, upon the production of the pensioners portion of the order taking " +
							"from the claimant a receipt of the amount according to usual form for the payment of first months pension. " +
							"The payment should commence from "+effectdate+" Subsequent payment should be made through Bank.";
									
					/*content1="In the event of the death of "+prenametitle+tmp[1]+" a family pension of " +
							"Rs.7068/-(Rupees Seven Thousand Sixty Eight/- only) per month may be paid to Thiru/Tmt.V.Banumathi, Wife from " +
							"the day following the date of death of the pensioner for 7 year or " +
							"up to 04/07/2016 whichever is earlier and Rs.4241/-(Rupees Four Thousand Two hundred and Forty One only) " +
							"later on till the date of her / his remarriage or death whichever is earlier (on receipt of death " +
							"certificate and form of application from widow/ widower). A non marriage certificate should " +
							"be obtained before payment.";*/
					
					
					mainpd.setCONTENT1(content1);
					//mainpd.setCONTENT2(content2);
					//mainpd.setCONTENT3(content3);
					
					
					if(!(tmp[33]+"").equalsIgnoreCase("null"))
					{
						//mainpd.setGPO_NO((BigDecimal) tmp[33]);
						mainpd.setGPO_NO(tmp[33]+"/TWAD");
					}
					if((tmp[34]+"").equalsIgnoreCase("Draft"))
					{
						mainpd.setPROCESS_STATUS("("+tmp[34]+")");
					}
					if((tmp[34]+"").equalsIgnoreCase("Final"))
					{
						mainpd.setFORWARD(forward);
						mainpd.setFORWARD_OFFICER(forward_officer);
						mainpd.setFORWARD_OFFICER1(forward_officer1);
						mainpd.setFORWARD_OFFICER2(forward_officer2);
						mainpd.setAUTH(auth+" "+tmp[36]);
					}
					mainpd.setCONTENT(content);
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
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder2PersonDetails(HttpServletRequest request, int empId) {
		
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
				String sqlQry="SELECT mstform2.emp_no," +
						"mstform2.emp_name," +
						"desi.designation," +
						"mstform1.date_of_birth," +
						"mstform2.id_mark1," +
						"mstform2.id_mark2," +
						"mstform2.emp_height," +
						"mstform2.nationality," +
						"auth.resident_address," +
						"pension_type," +
//						"(date_of_retire+1,'DD/MM/YY')," +
//						"(date_of_vrs+1,'DD/MM/YY')," +
//						"(death_date+1,'DD/MM/YY')," +
						"date_of_retire+1," +
						"date_of_vrs+1," +
						"death_date+1," +

						"mstform1.pension_amount," +
						"mstform1.family_pension_50_amt," +
						"mstform1.family_pension_30_amt," +
						"mstform1.fam_pen_upto_seven," +
						"mstform1.fam_pen_after_seven, " +
						"religion_name " +
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_state STA ON STA.state_code = mstform2.state " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON auth.emp_no = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_mst_religions rel ON rel.religion_code = cast(mstform2.religion as numeric)"+
						"WHERE mstform1.emp_id ="+empId;								
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					
					String retiredate= "";
					String content1= "";
					String content2= "";
					String prenametitle="";
					String dob="";
					String family_pen_upto_date="";
					String family_pen_after_date="";
					PensionerOrderDao mainpd=new PensionerOrderDao();
					
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						mainpd.setDESIGNATION(tmp[2]+"");
					}
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						dob=formatter1.format(tmp[3]);
						mainpd.setDATE_OF_BIRTH((Date) tmp[3]);
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						mainpd.setIDMARK1(tmp[4]+"");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						mainpd.setIDMARK2(tmp[5]+"");
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						mainpd.setHEIGHT(tmp[6]+"");
					}
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNATIONALITY(tmp[7]+"");
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRESIDENT_ADDRESS(tmp[8]+"");
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						if((tmp[9]+"").equalsIgnoreCase("1"))
						{
							mainpd.setPENSION_TYPE("Superannuation");
						}
						if((tmp[9]+"").equalsIgnoreCase("2"))
						{
							mainpd.setPENSION_TYPE("VRS");
						}
						if((tmp[9]+"").equalsIgnoreCase("3"))
						{
							mainpd.setPENSION_TYPE("Death");
						}
					}					
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[10]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[11]);
					}
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[12]);
					}					
					if(!(tmp[13]+"").equalsIgnoreCase("null"))
					{
						content1="Rs."+tmp[13]+"/-";
					}					
					mainpd.setPENSION_CONTENT(content1);					
					if(!(tmp[14]+"").equalsIgnoreCase("null"))
					{
						family_pen_upto_date=formatter1.format(tmp[16]);
						family_pen_after_date=formatter1.format(tmp[17]);
						content2="Rs."+tmp[14]+"/- from day following the date of death of the pensioner for 10 years or upto "+family_pen_upto_date+" whichever " +
								"is earlier and Rs."+tmp[15]+"/- later on.";
					}					
					mainpd.setFAMILY_PENSION_CONTENT(content2);
					if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
					mainpd.setRELIGION(tmp[18]+"");
					}
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
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder2_IPersonDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<PensionerOrderDao> mainretn=new ArrayList<PensionerOrderDao>();
		try
		   {
		        con=session.connection();	
		        
		        constNumtoLetter n = new constNumtoLetter();
		        int pensionamount = 0;
		        int family_pension_upto_seven = 0;
		        int family_pension_after_seven = 0;
		        
		        String sqlQry="SELECT mstform2.emp_no," +
						"mstform2.emp_name," +
						"desi.designation," +
						"mstform2.gender," +
						"mstform2.husband_name," +
						"nom.NOMINEE_INITIAL||'.'||auth.nominee_name," +
						"auth.nominee_relation_id," +
						"auth.nominee_relation_desc," +
						"mstform1.pension_type," +
//						"(mstform1.date_of_retire+1,'DD/MM/YY')," +
//						"(mstform1.date_of_vrs+1,'DD/MM/YY')," +
//						"(mstform1.death_date+1,'DD/MM/YY')," +
	//					"mstform1.date_of_retire+1," +
						"case when (mstform1.date_of_retire is not null) then mstform1.date_of_retire+1 else null end as date_of_retire,"+
						"case when (mstform1.date_of_vrs is not null ) then mstform1.date_of_vrs+1 else null end as date_of_vrs," +
						"case when (mstform1.death_date is not null ) then mstform1.death_date+1 else null end as death_date," +
//						"mstform1.death_date+1," +
						"mstform1.pension_amount," +
						"mstform1.family_pension_50_amt," +
						"mstform1.family_pension_30_amt," +
						"mstform1.fam_pen_upto_seven," +
						"mstform1.fam_pen_after_seven " +
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_state STA ON STA.state_code = mstform2.state " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON auth.emp_no = mstform2.emp_no " +
						"left outer join hrm_pen_app_ho_mst_form2_nomin nom on auth.NOMINEE_ID=nom.NOMINEE_ID " +
						"WHERE mstform1.emp_id = "+empId;								
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					System.out.println(Arrays.toString(tmp));
					String content="";
					String content1="";
					String prenametitle="";
					String effectdate="";
					String family_pen_upto_date="";
					String family_pen_after_date="";
					String nominee_name="";
					String nominee_relation="";
					PensionerOrderDao mainpd=new PensionerOrderDao();
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");					
					if((tmp[3]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[3]+"").equalsIgnoreCase("F"))
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
					//System.out.println("TMP{8} Value is:::"+tmp[8]);
					/*String  vrscontent="Please note that payment should be made only on receipt of clear unconditional retirement order issued by the competent authority.";
					if(!(tmp[8]+"").equalsIgnoreCase("5"))
					{
						mainpd.setVRS_CONTENT("");
					}
					else
					{
						mainpd.setVRS_CONTENT(vrscontent);
					}*/
					
					
					
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[9]);
					}
					if(!(tmp[10]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[10]);
					}
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						effectdate=formatter1.format(tmp[11]);
					}
					
					pensionamount=Integer.parseInt(tmp[12]+"");
					family_pension_upto_seven=Integer.parseInt(tmp[13]+"");
					family_pension_after_seven=Integer.parseInt(tmp[14]+"");
					if(!(tmp[15]+"").equalsIgnoreCase("null"))
					{
					family_pen_upto_date=formatter1.format(tmp[15]);
					}
					if(!(tmp[16]+"").equalsIgnoreCase("null"))
					{
					family_pen_after_date=formatter1.format(tmp[16]);	
					}
					
							
					content="UNTIL FURTHER NOTICE, and on the expiration of every month, you are authorised to " +
					"pay "+prenametitle+tmp[1]+", "+tmp[2]+" the sum of Rs."+pensionamount+" /- "+n.rupess_to_word(pensionamount)+
					" being the amount of Superannuation PENSION, upon the production of the pensioner�s portion of the order taking " +
					"from the claimant a receipt of the amount according to usual form for the payment of first month�s pension. " +
					"The payment should commence from "+effectdate+" Subsequent payment should be made through Bank.";
						
					System.out.println("tmp[5]>>>>>>>>>>>"+tmp[5].toString());
					//if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						nominee_name=tmp[5]+"";
						nominee_relation=tmp[7]+"";
						content1="In the event of the death of "+prenametitle+tmp[1]+" a family pension of " +
						"Rs."+family_pension_upto_seven+"/- "+n.rupess_to_word(family_pension_upto_seven)+" per month may be paid to " +
						"Thiru/Tmt."+nominee_name+", "+nominee_relation+" from the day following the date of death of the " +
						"pensioner for 10 year or up to "+family_pen_upto_date+" whichever is earlier " +
						"and Rs."+family_pension_after_seven+"/- "+	n.rupess_to_word(family_pension_after_seven)+" later on till " +
						"the date of her / his remarriage or death whichever is earlier (on receipt of death certificate " +
						"and form of application from widow/ widower). A non marriage certificate should be obtained before payment.";
					}
					if((tmp[5]+"").equalsIgnoreCase("null"))
					{
						content1="In the event of the death of the pensioner, the family pension will be stopped.";
					}
					mainpd.setCONTENT(content);
					mainpd.setCONTENT1(content1);
					mainretn.add(mainpd);	
					
				}	 
			
		// con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	

	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder3Details(HttpServletRequest request, int empId) {
		
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
				"auth.process_status, " +
				"auth.name_from_address ," +
//				"  REGEXP_SUBSTR(name_from_address,'[^,]+') AS name_sd "+
				"substring(name_from_address from 0 for position(',' IN name_from_address)) "+
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON mstform1.emp_id = auth.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
						"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = auth.authorized_officer " +
						"WHERE mstform1.emp_id = "+empId;				
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
					/*if(last_working_office_id.equalsIgnoreCase(pension_payment_office_id))
					{
						toaddress=last_working_office_address;
					}
					else
					{
						toaddress=pension_payment_office_address;
					}*/
					toaddress=last_working_office_address;
					//System.out.println("toaddress"+toaddress);
					String[] add_split=last_working_office_address.split(",");
					mainpd.setTO_ADDRESS1(add_split[0]+",");
					System.out.println("Split 1>>>>>"+add_split[0]);
					try{
						if(!(add_split[1].equalsIgnoreCase(null)) || !(add_split[1].equalsIgnoreCase("")) || !(add_split[1].equalsIgnoreCase("null")))
						{
							System.out.println("Split 1>>>>>"+add_split[1]);
							mainpd.setTO_ADDRESS2(add_split[1]);
						}
						
						if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
						{
							System.out.println("Split 2>>>>>"+add_split[2]);
							mainpd.setTO_ADDRESS3(add_split[2]);
						}
						
						if(!(add_split[3].equalsIgnoreCase(null)) || !(add_split[3].equalsIgnoreCase("")) || !(add_split[3].equalsIgnoreCase("null")))
						{
							System.out.println("Split 3>>>>>"+add_split[3]);
							mainpd.setTO_ADDRESS(add_split[3]);
						}
					}
					catch(Exception ee){
						System.out.println("Error in:"+ee.getMessage());
					}
					mainpd.setTO_ADDRESS(toaddress);
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[11]+"";
						letterno="Letter No."+letterno+" - 3";
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
						sub_ret_cont=" retired  ";
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
						sub_ret_cont=" retired  ";
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
					/*subject="Authorisation for the payment of Gratuity in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" " +
							"who is due to retire on "+retiredate+" - Reg.";*/
					subject="Authorisation for the payment of Gratuity in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" " +
					sub_ret_cont+"on "+retiredate+" - Reg.";
					mainpd.setSUBJECT(subject);
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
					
					
					/*content="The Pension and DCRG proposals in respect " +
							"of "+prenametitle+tmp[1]+", "+tmp[21]+" who is due to retire on " +retiredate+" are verified.";
							*/
					content="The Pension and DCRG proposals in respect " +
					"of "+prenametitle+tmp[1]+", "+tmp[21]+" "+sub_ret_cont+"on " +retiredate+" are verified.";
					
					
									
					/*content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
							"Rs."+dcrgpensionamount+"/- "+n.rupess_to_word(dcrgpensionamount)+
							" to "+prenametitle+tmp[1]+", "+tmp[21]+" being the DCRG due to him may be paid to him after duly " +
							"satisfying yourself about his identification. ";*/
					
					
										
					 String sqlQryforRecDesc="SELECT rec_id," +
							"rec_desc," +
							"rec_amount " +
							"FROM hrm_pen_app_ho_mst_rec_form1 where emp_id="+empId;
					 String recoveryDescForDCRG="";
					 Integer recAmount=0;	
					 Integer recoveryAmt=0;
					 List<Object[]> recdescli=session.createSQLQuery(sqlQryforRecDesc).list();
					 int listsize=recdescli.size();
					 int count=0;
						for(Object[] recDesctmp:recdescli)
						{
							count++;
							if(count!=listsize)
							{
							recoveryDescForDCRG+=recDesctmp[1]+" Rs."+recDesctmp[2]+", ";
							}
							else
							{
								recoveryDescForDCRG+=recDesctmp[1]+" Rs. "+recDesctmp[2]+" ";
							}
							recAmount+=Integer.parseInt(recDesctmp[2]+"");
							recoveryAmt=Integer.parseInt(recDesctmp[2]+"");
						}
					
						int netDcrgAmount=dcrgpensionamount-recAmount;
						
						if((tmp[23]+"").equalsIgnoreCase("M"))
						{
							if(count!=0)
							{
						/////////--------Gopi---------- /////////////////
								Integer sumofrec=recAmount;
								if(sumofrec>0)
								{
									//Integer dcrgdisfinalamount=dcrgpensionamount-sumofrec;
									if(netDcrgAmount<0)
									{
										netDcrgAmount=0;
										sumofrec=dcrgpensionamount;
									}
									else
									{
										netDcrgAmount=netDcrgAmount;
										sumofrec=recAmount;
										
									}
								}
								
								
						/////////--------Gopi---------- /////////////////
								
								content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
								"Rs."+dcrgpensionamount+"/- "+n.rupess_to_word(dcrgpensionamount)+
								" to "+prenametitle+tmp[1]+", "+tmp[21]+" being the DCRG due to him " +
								"An amount of Rs." +sumofrec+" "+n.rupess_to_word(sumofrec)+ " towards "+recoveryDescForDCRG+
								" may be deducted and the net amount of Rs. " +netDcrgAmount+" "+n.rupess_to_word(netDcrgAmount) +
								" may be paid to him after duly " +
								"satisfying yourself about his identification. ";
								
								System.out.println(content1);
							}
							else
							{							
								content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
								"Rs."+dcrgpensionamount+"/- "+n.rupess_to_word(dcrgpensionamount)+
								" to "+prenametitle+tmp[1]+", "+tmp[21]+" being the DCRG due to him " +
								" may be paid to him after duly " +
								"satisfying yourself about his identification. ";
							}
						}
						if((tmp[23]+"").equalsIgnoreCase("F"))
						{
							if(count!=0)
							{
							content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
							"Rs."+dcrgpensionamount+"/- "+n.rupess_to_word(dcrgpensionamount)+
							" to "+prenametitle+tmp[1]+", "+tmp[21]+" being the DCRG due to her " +
							"An amount of Rs." +recAmount+" "+n.rupess_to_word(recAmount)+" towards "+recoveryDescForDCRG+
							"may be deducted and the net amount of Rs. " +netDcrgAmount+" "+n.rupess_to_word(netDcrgAmount)+
							" may be paid to her after duly " +
							"satisfying yourself about her identification. ";
							}
							else
							{
								content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
								"Rs."+dcrgpensionamount+"/- "+n.rupess_to_word(dcrgpensionamount)+
								" to "+prenametitle+tmp[1]+", "+tmp[21]+" being the DCRG due to her " +
								" may be paid to her after duly " +
								"satisfying yourself about her identification. ";
							}
						}
					
					
					
					mainpd.setCONTENT1(content1);
					mainpd.setCONTENT2(content2);
					mainpd.setCONTENT3(content3);
					mainpd.setCONTENT(content);
					
					String copyto1content1="";
					copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress+" with a request to contact "+toaddress;
										
					mainpd.setCOPY_TO1(copyto1content1);
					if((tmp[30]+"").equalsIgnoreCase("Draft"))
					{
					mainpd.setPROCESS_STATUS("("+tmp[30]+")");
					}
					if(!(tmp[31]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNAME_FROM_ADDRESS(tmp[31]+"");
					}
					if((tmp[30]+"").equalsIgnoreCase("Final"))
					{
						mainpd.setFORWARD(forward);
						mainpd.setFORWARD_OFFICER(forward_officer);
						mainpd.setFORWARD_OFFICER1(forward_officer1);
						mainpd.setFORWARD_OFFICER2(forward_officer2);
						mainpd.setAUTH(auth+" "+tmp[32]);
					}	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder3PersonDetails(HttpServletRequest request, int empId) {
		
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
				/*String sqlQry="select mstform2.EMP_NO," +
				"mstform2.EMP_NAME," +
				"desi.DESIGNATION, " +
				"mstform1.DATE_OF_BIRTH," +	
				"mstform2.ID_MARK1," +
				"mstform2.ID_MARK2," +	
				"mstform2.EMP_HEIGHT," +			
				"mstform2.NATIONALITY," +				
				"auth.RESIDENT_ADDRESS " +
				"from HRM_PEN_APP_HO_MST_FORM2_DET mstform2 " +
				"left outer join HRM_PEN_APP_HO_MST_FORM1_DET mstform1 on mstform1.emp_id=mstform2.emp_no " +
				"left outer join HRM_MST_DESIGNATIONS desi on desi.DESIGNATION_ID=mstform2.DESIG_ID " +
				"left outer join COM_MST_STATE sta on sta.STATE_CODE=mstform2.STATE " +
				"left outer join COM_MST_OFFICES offi on offi.office_id=mstform2.PAYMENT_OFFICE_ID " +
				"left outer join HRM_PEN_APP_AUTHORIZATION_ORG auth on auth.emp_no=mstform2.emp_no " +
				"where mstform1.EMP_ID="+empId;					*/
				
				
				String sqlQry="SELECT mstform2.emp_no," +
						"mstform2.emp_name," +
						"desi.designation," +
						"mstform1.date_of_birth," +
						"mstform2.id_mark1," +
						"mstform2.id_mark2," +
						"mstform2.emp_height," +
						"mstform2.nationality," +
						"auth.resident_address," +
						"rel.religion_name " +
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_state STA ON STA.state_code = mstform2.state " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON auth.emp_no = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_mst_religions rel ON rel.religion_code = Cast(mstform2.religion as Numeric) WHERE mstform1.emp_id="+empId;					
				
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
					String dob="";
					PensionerOrderDao mainpd=new PensionerOrderDao();
					
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					mainpd.setEMP_NAME(tmp[1]+"");
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						mainpd.setDESIGNATION(tmp[2]+"");
					}
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					if(!(tmp[3]+"").equalsIgnoreCase("null"))
					{
						dob=formatter1.format(tmp[3]);
						mainpd.setDATE_OF_BIRTH((Date) tmp[3]);
					}
					if(!(tmp[4]+"").equalsIgnoreCase("null"))
					{
						mainpd.setIDMARK1(tmp[4]+"");
					}
					if(!(tmp[5]+"").equalsIgnoreCase("null"))
					{
						mainpd.setIDMARK2(tmp[5]+"");
					}
					if(!(tmp[6]+"").equalsIgnoreCase("null"))
					{
						mainpd.setHEIGHT(tmp[6]+"");
					}
					if(!(tmp[7]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNATIONALITY(tmp[7]+"");
					}
					if(!(tmp[8]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRESIDENT_ADDRESS(tmp[8]+"");
					}
					if(!(tmp[9]+"").equalsIgnoreCase("null"))
					{
						mainpd.setRELIGION(tmp[9]+"");
					}
					
					mainretn.add(mainpd);	
					
				}	 
			
		// con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder4Details(HttpServletRequest request, int empId) {
		
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
		        String ppo_no="";
				String pensiontype="";
				String classofpensionstring="";
				String comopted="";
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
						"auth.name_from_address," +
//						"  REGEXP_SUBSTR(name_from_address,'[^,]+') AS name_sd " +
						"substring(name_from_address from 0 for position(',' IN name_from_address)) "+
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON mstform1.emp_id = auth.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
						"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = auth.authorized_officer " +
						"WHERE mstform1.emp_id = "+empId;		
				
				System.out.println("Query is==="+sqlQry);
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				System.out.println("Size of List is----"+session.createSQLQuery(sqlQry).list());
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
					String toaddress = "";
					String last_working_office_id="";
					String last_working_office_address="";
					String pension_payment_office_id="";
					String pension_payment_office_address="";
					String residentaddress="";
					PensionerOrderDao mainpd=new PensionerOrderDao();
					
					mainpd.setEMP_NO((BigDecimal)tmp[0]);
					
					mainpd.setEMP_NAME(tmp[1]+"");
					//mainpd.setPPO_NO((BigDecimal)tmp[2]);
					mainpd.setPPO_NO(tmp[2]+"/TWAD");
					
					
					System.out.println("Emp_No :: "+tmp[0]);
					System.out.println("Emp_Name :: "+tmp[1]);
					System.out.println("Ppo_No :: "+tmp[2]);
					
					
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
					/*if(last_working_office_id.equalsIgnoreCase(pension_payment_office_id))
					{
						toaddress=last_working_office_address;
					}
					else
					{
						toaddress=pension_payment_office_address;
					}*/
					//toaddress=last_working_office_address;
					toaddress=pension_payment_office_address;
					String[] add_split=pension_payment_office_address.split(",");
					mainpd.setTO_ADDRESS1(add_split[0]+",");
					System.out.println("Split 1>>>>>"+add_split[0]);
					try{
						if(!(add_split[1].equalsIgnoreCase(null)) || !(add_split[1].equalsIgnoreCase("")) || !(add_split[1].equalsIgnoreCase("null")))
						{
							System.out.println("Split 1>>>>>"+add_split[1]);
							mainpd.setTO_ADDRESS2(add_split[1]+",");
						}
						
						if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
						{
							System.out.println("Split 2>>>>>"+add_split[2]);
							mainpd.setTO_ADDRESS3(add_split[2]);
						}
						
						if(!(add_split[3].equalsIgnoreCase(null)) || !(add_split[3].equalsIgnoreCase("")) || !(add_split[3].equalsIgnoreCase("null")))
						{
							System.out.println("Split 3>>>>>"+add_split[3]);
							mainpd.setTO_ADDRESS(add_split[3]);
						}
					}
					catch(Exception ee){
						System.out.println("Error in:"+ee.getMessage());
					}
					//mainpd.setTO_ADDRESS(toaddress);
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[11]+"";
						letterno="Letter No."+letterno+" - 4";
					}					
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[12]);
						//letterno="Letter No."+letterno+" - 4 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
					}
										
					mainpd.setDATED_ON(datedon);
					mainpd.setLETTER_NO(letterno);
					String sub_ret_cont="";
					if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[18]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
						sub_ret_cont="retired  ";
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
						sub_ret_cont="retired  ";
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
					/*subject="Authorisation for the payment of commutation value of pension - "+prenametitle+tmp[1]+", "+tmp[21]+" " +
							"who is due to retire on "+retiredate+" - Reg.";*/
					
					subject="Authorisation for the payment of commutation value of pension - "+prenametitle+tmp[1]+", "+tmp[21]+" " +
					sub_ret_cont+"on "+retiredate+" - Reg.";
					mainpd.setSUBJECT(subject);
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

					/*content="The pension and DCRG proposals in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" who is due to retire on " +
							""+retiredate+". are verified.";*/
					
					content="The pension and DCRG proposals in respect of "+prenametitle+tmp[1]+", "+tmp[21]+" "+sub_ret_cont+"on " +
					""+retiredate+". are verified.";
					
					pensionamount=Integer.parseInt(tmp[25]+"");
					dcrgpensionamount=Integer.parseInt(tmp[26]+"");
					commutedamount=Integer.parseInt(tmp[27]+"");
					reducedpensionamount=Integer.parseInt(tmp[28]+"");
					commutedpensionamount=Integer.parseInt(tmp[29]+"");
					if(!(tmp[2]+"").equalsIgnoreCase("null"))
					{
						ppo_no=tmp[2]+"";
					}
					else
					{
						ppo_no="     ";
					}
					/*content1="I authorise payment of Rs."+commutedpensionamount+"/- "+n.rupess_to_word(commutedpensionamount)+" being the commuted value of " +
							"Rs."+commutedamount+"/- "+n.rupess_to_word(commutedamount)+" out the superannuation pension of Rs."+pensionamount+"/- " +
							n.rupess_to_word(pensionamount)+" per mensem granted to "+prenametitle+tmp[1]+", "+tmp[21]+" who will be" +
							" holder of PPO No."+tmp[2]+"/TWAD E.Code - "+tmp[0];*/
					
					
					/////////--------Gopi---------- /////////////////
					
					 String sqlQryforRecDesc1="SELECT rec_id," +
						"rec_desc," +
						"rec_amount " +
						"FROM hrm_pen_app_ho_mst_rec_form1 where emp_id="+empId;
				 String recoveryDescForDCRG="";
				 Integer recAmount=0;	
				 Integer recoveryAmt=0;
				 String recoveryDescrip =null;
				 System.out.println("Qry ::: "+sqlQryforRecDesc1);
				 List<Object[]> recdesclist=session.createSQLQuery(sqlQryforRecDesc1).list();
				 System.out.println("Size of List is --- "+(session.createSQLQuery(sqlQryforRecDesc1).list()).size());
				 
				 int listsize=recdesclist.size();
				 int count=0;
					for(Object[] recDesctemp:recdesclist)
					{
						count++;
						if(count!=listsize)
						{
						recoveryDescForDCRG+=recDesctemp[1]+" Rs."+recDesctemp[2]+", ";
						}
						else
						{
							recoveryDescForDCRG+=recDesctemp[1]+" Rs. "+recDesctemp[2]+" ";
						}
						recAmount+=Integer.parseInt(recDesctemp[2]+"");
						recoveryAmt=Integer.parseInt(recDesctemp[2]+"");
						recoveryDescrip = recDesctemp[1].toString();
					}
				
					int netDcrgAmount=dcrgpensionamount-recAmount;	
					System.out.println("dcrgpensionamount ::: "+dcrgpensionamount);
					System.out.println("recAmount ::: "+recAmount);
					System.out.println("netDcrgAmount ::: "+netDcrgAmount);
					
					if(netDcrgAmount<0)
					{
						netDcrgAmount=Math.abs(netDcrgAmount);
						int netamount= commutedpensionamount-netDcrgAmount;						
						System.out.println("netDcrgAmount ::: "+netDcrgAmount);
						
						content1="I authorise payment of Rs."+commutedpensionamount+"/- "+n.rupess_to_word(commutedpensionamount)+" being the commuted value of " +
							 	 "Rs."+commutedamount+"/- "+n.rupess_to_word(commutedamount)+" out the superannuation pension of Rs."+pensionamount+"/- " +
							 	 n.rupess_to_word(pensionamount)+" per mensem granted to "+prenametitle+tmp[1]+", "+tmp[21]+" who will be" +
							 	 " holder of PPO No."+ppo_no+"/TWAD E.Code - "+tmp[0]+". " +
								 "\n\n"+"An Amount of Rs."+netDcrgAmount+"/- "+n.rupess_to_word(netDcrgAmount)+" toward balance amount of "+recoveryDescrip+ " " +
								 " may be recovered and the net amount of Rs."+netamount+"/- "+n.rupess_to_word(netamount)+" may be paid to him/her.";
												
					}
					else
					{
						content1="I authorise payment of Rs."+commutedpensionamount+"/- "+n.rupess_to_word(commutedpensionamount)+" being the commuted value of " +
							 	 "Rs."+commutedamount+"/- "+n.rupess_to_word(commutedamount)+" out the superannuation pension of Rs."+pensionamount+"/- " +
							 	 n.rupess_to_word(pensionamount)+" per mensem granted to "+prenametitle+tmp[1]+", "+tmp[21]+" who will be" +
							 	 " holder of PPO No."+ppo_no+"/TWAD E.Code - "+tmp[0];
					}
					
					/////////--------Gopi---------- /////////////////
					
					////////-----------rajasekar-------------/////////////
					/*
					content1="I authorise payment of Rs."+commutedpensionamount+"/- "+n.rupess_to_word(commutedpensionamount)+" being the commuted value of " +
					"Rs."+commutedamount+"/- "+n.rupess_to_word(commutedamount)+" out the superannuation pension of Rs."+pensionamount+"/- " +
					n.rupess_to_word(pensionamount)+" per mensem granted to "+prenametitle+tmp[1]+", "+tmp[21]+" who will be" +
					" holder of PPO No."+ppo_no+"/TWAD E.Code - "+tmp[0];
					*/
					////////-----------rajasekar-------------/////////////
					
					
					/*content2="I request you to be so good as to make arrangement for the payment of the above " +
							"amount as soon as possible on a simple receipt. The charge is debitable to the Head of " +
							"account \"IV- Expenditure � Pension\".";*/
					
					content2="I request you to be so good as to make arrangement for the payment of the above " +
					"amount as soon as possible on a simple receipt. The charge is debitable to the Head of " +
					"account \"IV- Expenditure - Pension\".";
					
					
					content3="Reduced Pension of Rs."+reducedpensionamount+"/- "+n.rupess_to_word(reducedpensionamount)+" " +
							"per mensem consequent on commutation may please be paid to " +
							""+prenametitle+tmp[1]+", "+tmp[21]+ " "+
							"from the date of disbursement of commuted value on completion of 3 months from the date of issue of " +
							"authorisation whichever is earlier. Restoration of full pension can be made on completion of 15 years " +
							"from the date of disbursement of commuted value.";
					
					mainpd.setCONTENT1(content1);
					mainpd.setCONTENT2(content2);
					mainpd.setCONTENT3(content3);
					
										
					mainpd.setCONTENT(content);
					
					
					String copyto1content1="";
					String copyto1content2="";
					
					copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress+" with a request to contact "+toaddress;
					
					
					if(!last_working_office_id.equalsIgnoreCase(pension_payment_office_id))
					{
						copyto1content2="Copy to "+last_working_office_address;
					}
					
					//copyto1content2="Copy to "+pension_payment_office_address;
					System.out.println("copyto1content1>>>"+copyto1content1);
					System.out.println("copyto1content2>>>"+copyto1content2);
					mainpd.setCOPY_TO1(copyto1content1);
					mainpd.setCOPY_TO2(copyto1content2);
					
					if((tmp[30]+"").equalsIgnoreCase("Draft"))
					{
						mainpd.setPROCESS_STATUS("("+tmp[30]+")");
					}
					if((tmp[30]+"").equalsIgnoreCase("Final"))
					{
						mainpd.setFORWARD(forward);
						mainpd.setFORWARD_OFFICER(forward_officer);
						mainpd.setFORWARD_OFFICER1(forward_officer1);
						mainpd.setFORWARD_OFFICER2(forward_officer2);
						mainpd.setAUTH(auth+" "+tmp[32]);
					}
					if(!(tmp[31]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNAME_FROM_ADDRESS(tmp[31]+"");
					}
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
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PensionerOrderDao> getPenOrder5Details(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<PensionerOrderDao> mainretn=new ArrayList<PensionerOrderDao>();
		try
		   {
		        con=session.connection();	
		        
 
				String pensiontype="";
				String classofpensionstring="";
				String comopted="";
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
						"mstform1.pension_amount," +
						"mstform1.death_date," +
						"desi.designation," +
						"offi.office_name," +
						"mstform2.gender," +
						"mstform2.husband_name," +
						"auth.process_status, " +
						"auth.name_from_address, " +
						"auth.service_book_address, " +
//						"  REGEXP_SUBSTR(name_from_address,'[^,]+') AS name_sd " +
						"substring(name_from_address from 0 for position(',' IN name_from_address)) "+
						"FROM hrm_pen_app_ho_mst_form2_det mstform2 " +
						"LEFT OUTER JOIN hrm_pen_app_ho_mst_form1_det mstform1 ON mstform1.emp_id = mstform2.emp_no " +
						"LEFT OUTER JOIN hrm_pen_app_authorization_org auth ON mstform1.emp_id = auth.emp_no " +
						"LEFT OUTER JOIN hrm_emp_current_posting post ON mstform1.emp_id = post.employee_id " +
						"LEFT OUTER JOIN hrm_mst_designations desi ON desi.designation_id = post.designation_id " +
						"LEFT OUTER JOIN com_mst_offices offi ON offi.office_id = mstform2.payment_office_id " +
						"LEFT OUTER JOIN hrm_pen_app_authorise_off_mst authoff ON authoff.authorization_id = auth.authorized_officer " +
						"WHERE mstform1.emp_id = "+empId;				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					String datedon = "";
					String letterno= "";
					String subject= "";
					String retiredate= "";
					String content= "";
					String prenametitle="";
					String toaddress = "";
					String last_working_office_id="";
					String last_working_office_address="";
					String pension_payment_office_id="";
					String pension_payment_office_address="";
					String residentaddress="";
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
					if(last_working_office_id.equalsIgnoreCase(pension_payment_office_id))
					{
						toaddress=last_working_office_address;
					}
					else
					{
						toaddress=pension_payment_office_address;
					}
					mainpd.setTO_ADDRESS(toaddress);
					//mainpd.setCIRCLE_HO_OFFICE_STATUS(tmp[5]+"");
					//mainpd.setLAST_WORK_OFFICE_ADDRESS(tmp[6]+"");
					//mainpd.setPENSION_PAY_OFFICE_ADDRESS(tmp[10]+"");
					if(!(tmp[11]+"").equalsIgnoreCase("null"))
					{
						letterno=tmp[11]+"";
						letterno="Letter No."+letterno+" - 5";
					}					
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					
					if(!(tmp[12]+"").equalsIgnoreCase("null"))
					{
						datedon=formatter1.format(tmp[12]);
						//letterno="Letter No."+letterno+" - 5 Dated "+datedon;
						letterno=letterno+" Dated "+datedon;
					}
					
					
					
								
					
					
					mainpd.setDATED_ON(datedon);
					mainpd.setLETTER_NO(letterno);
					String sub_ret_cont="";
					if(!(tmp[18]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[18]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[18]);
						sub_ret_cont="retired  ";
					}
					if(!(tmp[19]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[19]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[19]);
						sub_ret_cont="voluntarily retired ";
					}
					if(!(tmp[21]+"").equalsIgnoreCase("null"))
					{
						retiredate=formatter1.format(tmp[21]);
						mainpd.setDATE_OF_RETIREMENT((Date) tmp[21]);
						sub_ret_cont="retired  ";
					}
					if((tmp[24]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((tmp[24]+"").equalsIgnoreCase("F"))
					{
						if(!(tmp[25]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
					/*subject="Pension Establishment - Service Book of "+prenametitle+tmp[1]+", "+tmp[22]+" " +
							"who is due to retire on "+retiredate+" - reg.";*/
					
					subject="Pension Establishment - Service Book of "+prenametitle+tmp[1]+", "+tmp[22]+" " +
					sub_ret_cont+"on "+retiredate+" - reg.";
					mainpd.setSUBJECT(subject);
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
					
					/*content="I send herewith the service book of "+prenametitle+tmp[1]+", "+tmp[22]+" who is due to retire on " +
							""+retiredate+". I request you to return the same after his/her retirement with the following.";*/
					
					content="I send herewith the service book of "+prenametitle+tmp[1]+", "+tmp[22]+" "+sub_ret_cont+"on " +
					""+retiredate+". I request you to return the same after his/her retirement with the following.";
					
					
					mainpd.setCONTENT(content);
					mainretn.add(mainpd);	
					if((tmp[26]+"").equalsIgnoreCase("Draft"))
					{
						mainpd.setPROCESS_STATUS("("+tmp[26]+")");
					}
					if((tmp[26]+"").equalsIgnoreCase("Final"))
					{
						mainpd.setFORWARD(forward);
						mainpd.setFORWARD_OFFICER("Superintendent");
						mainpd.setFORWARD_OFFICER1(forward_officer1);
						mainpd.setFORWARD_OFFICER2(forward_officer2);
						mainpd.setAUTH(auth+" "+tmp[29]);
					}
					if(!(tmp[27]+"").equalsIgnoreCase("null"))
					{
						mainpd.setNAME_FROM_ADDRESS(tmp[27]+"");
					}
					String toadd="";
					if(!(tmp[28]+"").equalsIgnoreCase("null"))
					{
						//mainpd.setSERVICE_BOOK_ADDRESS(tmp[28]+"");
						toadd=tmp[28]+"";
					}
					String[] add_split=toadd.split(",");
					mainpd.setTO_ADDRESS1(add_split[0]+",");
					System.out.println("Split 1>>>>>"+add_split[0]);
					try{
						if(!(add_split[1].equalsIgnoreCase(null)) || !(add_split[1].equalsIgnoreCase("")) || !(add_split[1].equalsIgnoreCase("null")))
						{
							System.out.println("Split 1>>>>>"+add_split[1]);
							mainpd.setTO_ADDRESS2(add_split[1]+",");
						}
						
						if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
						{
							System.out.println("Split 2>>>>>"+add_split[2]);
							mainpd.setTO_ADDRESS3(add_split[2]);
						}
						
						if(!(add_split[3].equalsIgnoreCase(null)) || !(add_split[3].equalsIgnoreCase("")) || !(add_split[3].equalsIgnoreCase("null")))
						{
							System.out.println("Split 3>>>>>"+add_split[3]);
							mainpd.setTO_ADDRESS(add_split[3]);
						}
					}
					catch(Exception ee){
						System.out.println("Error in:"+ee.getMessage());
					}
				}	 
			
//		 con.commit();
         
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
	         
	        
	        if (num <= 0) Str="(Zero or Negative number not for conversion)"; //System.out.println("Zero or Negative number not for conversion");

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

	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getForward_officer() {
		return forward_officer;
	}

	public void setForward_officer(String forward_officer) {
		this.forward_officer = forward_officer;
	}
	

}





