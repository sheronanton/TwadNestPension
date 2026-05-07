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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;





import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcDetailsDeathDao;
import com.nic.hrms.pension.reports.model.pensionForm1CalcValDetailsDao;
import com.nic.hrms.pension.reports.service.reportRevisedPensionCalcValService;

public class reportRevisedPensionCalcValDaoImpl implements reportRevisedPensionCalcValService{

	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<pensionForm1CalcDetailsDao> getRevisedChangeAvgDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionForm1CalcDetailsDao> retn=new ArrayList<pensionForm1CalcDetailsDao>();
		try
		   { 
			    con=session.connection();
			    
			    
			    
			    
			    String basicpayname="";
				String gradepayname="";
				String specialpayname="";
				String other1payname="";				
				String other2payname="";
				String other3payname="";
				float sumofav=0;
				int aetotmonth=0;
				float averageemolamount=0;
				String sqlQryforavgsetting="select " +
				"avset.PAY_NAME," +
				"avset.INCLUDE," +
				"avset.DA," +				
				"avset.DISPLAY_CAPTION " +
				"from AVERAGE_CAL_SETTING avset";		
				
				
		List<Object[]> avgsettingmainli=session.createSQLQuery(sqlQryforavgsetting).list();
		for(Object[] avgsettingtmp:avgsettingmainli)
		{
			if((avgsettingtmp[0]+"").equals("BASIC"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						basicpayname=avgsettingtmp[3]+"";
					}
				}
			}			
			if((avgsettingtmp[0]+"").equals("GRADE PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						gradepayname=avgsettingtmp[3]+"";
					}
				}
			}
			if((avgsettingtmp[0]+"").equals("SPECIAL PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						specialpayname=avgsettingtmp[3]+"";						
					}					
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY1"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						other1payname=avgsettingtmp[3]+"";
					}
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY2"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						other2payname=avgsettingtmp[3]+"";
					}
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY3"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					if(!(avgsettingtmp[3]+"").equals("null"))
					{
						other3payname=avgsettingtmp[3]+"";
					}
				}
			}
		}
			
		 String str="select sum(av.PROP_PAY) from HRM_PEN_APP_REV_PEN_A_EMOL_CO av where av.EMP_ID="+empId;
		 Query query=session.createSQLQuery(str);	
		 Iterator obj=query.list().iterator();			 
		String objstring="";
		 while(obj.hasNext())
		 {
			 objstring=obj.next()+"";
			 if(!(objstring).equals("null"))
			 {
				 sumofav = Float.parseFloat(objstring);
			 }
			 
			 	
		 }
		 String str1="select AVGTOTMONTHS from HRM_PEN_CAL_SETTINGS";
		 Query query1=session.createSQLQuery(str1);	
		 Iterator obj1=query1.list().iterator();			 
		
		 while(obj1.hasNext())
		 {
			 aetotmonth = Integer.parseInt(""+obj1.next());		
			 	
		 }
		 averageemolamount=sumofav/aetotmonth;
			    
			    
				String sqlQry="select av.AVG_ID,av.NOT_CONSIDERED,av.DATE_FROM,av.DATE_TO,av.TOT_MONTHS,av.TOT_DAYS,av.BASIC_PAY,av.GRADE_PAY,av.SPECIAL_PAY,av.OTHER1_PAY,av.OTHER2_PAY,av.OTHER3_PAY,av.PROP_PAY from HRM_PEN_APP_REV_PEN_A_EMOL_CO av where EMP_ID="+empId;
				List<Object[]> li=session.createSQLQuery(sqlQry).list();
				System.out.println("------------------------------------------"+sqlQry);
				for(Object[] tmp:li)
				{
					pensionForm1CalcDetailsDao pd=new pensionForm1CalcDetailsDao();
					
					pd.setAVG_ID((BigDecimal)tmp[0]);
					pd.setNOT_CONSIDERED(tmp[1]+"");
					pd.setDATE_FROM((Date)tmp[2]);
					pd.setDATE_TO((Date)tmp[3]);
					pd.setTOT_MONTHS((BigDecimal)tmp[4]);
					pd.setTOT_DAYS((BigDecimal)tmp[5]);					
					
					if((basicpayname.equals("")) || (basicpayname.equals("null")))
					{
						pd.setAVGBASICLABLE("");
					}
					else
					{
						pd.setAVGBASICLABLE(basicpayname);
						if(!(tmp[6]+"").equals("null"))
						{
							pd.setBASIC_PAY(tmp[6]+"");
						}
					}
					
					if((specialpayname.equals("")) || (specialpayname.equals("null")))
					{
						pd.setAVGSPECIALLABLE("");
					}
					else
					{
						pd.setAVGSPECIALLABLE(specialpayname);
						if(!(tmp[8]+"").equals("null"))
						{
							pd.setSPECIAL_PAY(tmp[8]+"");
						}
					}					
					if((gradepayname.equals("")) || (gradepayname.equals("null")))
					{
						pd.setAVGGRADELABLE("");
					}
					else
					{
						pd.setAVGGRADELABLE(gradepayname);
						if(!(tmp[7]+"").equals("null"))
						{
							pd.setGRADE_PAY(tmp[7]+"");
						}
					}					
					
					if((other1payname.equals("")) || (other1payname.equals("null")))
					{
						pd.setAVGOTHER1LABLE("");
					}
					else
					{
						pd.setAVGOTHER1LABLE(other1payname);
						if(!(tmp[9]+"").equals("null"))
						{
							pd.setOTHER1_PAY(tmp[9]+"");
						}
					}					
					if((other2payname.equals("")) || (other2payname.equals("null")))
					{
						pd.setAVGOTHER2LABLE("");
					}
					else
					{
						pd.setAVGOTHER2LABLE(other2payname);
						if(!(tmp[10]+"").equals("null"))
						{
							pd.setOTHER2_PAY(tmp[10]+"");
						}
					}
					if((other3payname.equals("")) || (other3payname.equals("null")))
					{
						pd.setAVGOTHER3LABLE("");
					}
					else
					{
						pd.setAVGOTHER3LABLE(other3payname);
						if(!(tmp[11]+"").equals("null"))
						{
							pd.setOTHER3_PAY(tmp[11]+"");
						}
					}
										
					pd.setPROP_PAY((BigDecimal)tmp[12]);
					BigDecimal avgpaydrwnobj=new BigDecimal(averageemolamount);
					pd.setAVGPAYDRWAN(avgpaydrwnobj);
					retn.add(pd);			
		         }
				
		// con.commit();        
           }	
		catch (Exception e) {
				e.printStackTrace();
			System.out.println("--------------------------------------->error in saving the records");			
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		
		return retn;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<pensionForm1CalcDetailsDao> getRevisedPensionCalcDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionForm1CalcDetailsDao> mainretn=new ArrayList<pensionForm1CalcDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
		        
		        
		        
		        
		        Integer lastbasic = null;
		        Integer lastgrade = null;
		        Integer lastspecial = null;
		        Integer lastother1 = null;
		        Integer lastother2 = null;
		        Integer lastother3 = null;
		        Integer lastpaydrwan = null;
		        float averageemolamount = 0;
		        Integer pensionamount = null;
		        Float commutedamount = null;
				Integer commutedpert = null;
				String basicpayname="";
				String gradepayname="";
				String specialpayname="";
				String other1payname="";				
				String other2payname="";
				String other3payname="";
				Integer contingentday= null;
				Integer contingentmonth= null;
				Integer contingentyear= null;
				
				String otherdeptservice="";
				Integer othdeptyear=0;
				Integer othdeptmonth=0;
				Integer othdeptday=0;
				String subjectcontent="";
				
				String sqlQryforavgsetting="select " +
				"avset.PAY_NAME," +
				"avset.INCLUDE," +
				"avset.DA," +				
				"avset.DISPLAY_CAPTION " +
				"from AVERAGE_CAL_SETTING avset";		
				
				
		List<Object[]> avgsettingmainli=session.createSQLQuery(sqlQryforavgsetting).list();
		for(Object[] avgsettingtmp:avgsettingmainli)
		{
			if((avgsettingtmp[0]+"").equals("BASIC"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					basicpayname=avgsettingtmp[3]+"";
				}
			}			
			if((avgsettingtmp[0]+"").equals("GRADE PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					gradepayname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("SPECIAL PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					specialpayname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY1"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					other1payname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY2"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					other2payname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY3"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					other3payname=avgsettingtmp[3]+"";
				}
			}
		}
						
				
				
				String sqlQry="select " +
						"cd.EMP_ID," +
						"cd.OFFICE_ID," +
						"cd.PENSION_TYPE," +
						"cd.EMP_INITIAL," +
						"cd.EMP_NAME," +
						"cd.DESIG_SERVICE_GRP," +
						"cd.DESIGNATION_ID," +
						"cd.DATE_OF_BIRTH," +
						"cd.DATE_OF_APP," +
						"cd.DATE_OF_PROVINC," +
						"cd.DATE_OF_REG_ESTAB," +
						"cd.DATE_OF_SELECTION," +
						"cd.DATE_OF_SPECIAL," +
						"cd.DATE_OF_RETIRE," +
						"cd.DATE_OF_VRS," +
						"cd.COMM_OPTED," +
						"cd.COMM_FACTOR_ONRTHIRD," +
						"cd.COM_FACTOR_PERT," +
						"cd.WCE_SERV_DAYS," +
						"cd.WCE_SERV_MONTH," +
						"cd.WCE_SERV_YEAR," +
						"cd.WCE_SERV_FLAG," +
						"cd.WCE_SERV_COUNT_FLAG," +
						"cd.CONTINGENT_SERV_FLAG," +
						"cd.CONTINGENT_SERV_DAYS," +
						"cd.CONTINGENT_SERV_MONTH," +
						"cd.CONTINGENT_SERV_YEAR," +
						"cd.NON_PROV_SERV_DAYS," +
						"cd.NON_PROV_SERV_MONTH," +
						"cd.NON_PROV_SERV_YEAR," +
						"cd.EOL_DAYS," +
						"cd.EOL_MONTH," +
						"cd.EOL_YEAR," +
						"cd.SUSPENSION_DAYS," +
						"cd.SUSPENSION_MONTH," +
						"cd.SUSPENSION_YEAR," +
						"cd.BOY_SERV_DAYS," +
						"cd.BOY_SERV_MONTH," +
						"cd.BOY_SERV_YEAR," +
						"cd.OVERSTAY_LEAVE_DAYS," +
						"cd.OVERSTAY_LEAVE_MONTH," +
						"cd.OVERSTAY_LEAVE_YEAR," +
						"cd.NOT_REG_LEAVE_DAYS," +
						"cd.NOT_REG_LEAVE_MONTH," +
						"cd.NOT_REG_LEAVE_YEAR," +
						"cd.APPRENTICE_DAYS," +
						"cd.APPRENTICE_MONTH," +
						"cd.APPRENTICE_YEAR," +
						"cd.NOT_SERV_VERIFY_DAYS," +
						"cd.NOT_SERV_VERIFY_MONTH," +
						"cd.NOT_SERV_VERIFY_YEAR," +
						"cd.FOREIGN_SERV_DAYS," +
						"cd.FOREIGN_SERV_MONTH," +
						"cd.FOREIGN_SERV_YEAR," +
						"cd.LAST_BASIC_PAY," +
						"cd.LAST_SPECIAL_PAY," +
						"cd.LAST_GRADE_PAY," +
						"cd.LAST_OTHER_PAY1," +
						"cd.LAST_OTHER_PAY2," +
						"cd.LAST_OTHER_PAY3," +
						"cd.PENSION_AMOUNT," +
						"cd.DCRG_AMOUNT," +
						"cd.NO_OF_HALFYEAR_PENSION," +
						"cd.NO_OF_HALFYEAR_DCRG," +
						"cd.TOTAL_COMMUTED_AMOUNT," +
						"cd.REDUCED_PENSION_AMOUNT," +
						"cd.FAMILY_PENSION_50_AMT," +
						"cd.FAMILY_PENSION_30_AMT, " +
						"cd.DA_AMOUNT, " +
						"cd.COMMUTED_VALUE, " +
						"cd.COMMUTATION_PEN_AMOUNT, " +
						"cd.ACTUAL_SER_YEAR, " +
						"cd.ACTUAL_SER_MON, " +
						"cd.ACTUAL_SER_DAYS, " +
						"cd.NET_SER_YEAR, " +
						"cd.NET_SER_MON, " +
						"cd.NET_SER_DAYS, " +
						"cd.TOT_NON_QUAL_SER_YEAR, " +
						"cd.TOT_NON_QUAL_SER_MON, " +
						"cd.TOT_NON_QUAL_SER_DAYS, " +
						"cd.SCALE_OF_PAY, " +
						"cd.WEIGHTAGE_YEAR, " +
						"cd.WEIGHTAGE_MONTH, " +
						"cd.WEIGHTAGE_DAYS, " +
						"cd.FAM_PEN_UPTO_SEVEN, " +
						"cd.FAM_PEN_AFTER_SEVEN, " +
						"cd.DEATH_DATE," +
						"cd.OTH_DEPT_SERV_FLAG, " +
						"cd.OTH_DEPT_TOT_YEAR, " +
						"cd.OTH_DEPT_TOT_MONTH, " +
						"cd.OTH_DEPT_TOT_DAYS   " +
						"from hrm_pen_app_ho_mst_form1_det cd where cd.EMP_ID="+empId;	
				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					pensionForm1CalcDetailsDao mainpd=new pensionForm1CalcDetailsDao();
					
					mainpd.setEMP_ID((BigDecimal)tmp[0]);
					mainpd.setOFFICE_ID((BigDecimal)tmp[1]);
					mainpd.setPENSION_TYPE((BigDecimal)tmp[2]);
					mainpd.setEMP_INITIAL(tmp[3]+"");
					mainpd.setEMP_NAME(tmp[4]+"");
					mainpd.setDESIG_SERVICE_GRP((BigDecimal)tmp[5]);
					mainpd.setDESIGNATION_ID((BigDecimal)tmp[6]);
					mainpd.setDATE_OF_BIRTH((Date)tmp[7]);
					mainpd.setDATE_OF_APP((Date)tmp[8]);
					mainpd.setDATE_OF_PROVINC((Date)tmp[9]);
					mainpd.setDATE_OF_REG_ESTAB((Date)tmp[10]);
					mainpd.setDATE_OF_SELECTION((Date)tmp[11]);
					mainpd.setDATE_OF_SPECIAL((Date)tmp[12]);
					mainpd.setDATE_OF_VRS((Date)tmp[14]);
					mainpd.setCOMM_OPTED(tmp[15]+"");
					mainpd.setCOMM_FACTOR_ONRTHIRD(tmp[16]+"");
					mainpd.setCOM_FACTOR_PERT((BigDecimal)tmp[17]);
					
					mainpd.setWCE_SERV_FLAG(tmp[21]+"");
					mainpd.setWCE_SERV_COUNT_FLAG(tmp[22]+"");
					String wceflag=tmp[21]+"";
					String wcecountflag=tmp[22]+"";
					

					if(tmp[87]!=null)
					{
							if((tmp[87]+"").equals("Yes"))
							{
								if((tmp[88]+"").equals("null") || (tmp[88])==null)
								{
									othdeptyear=0;
									
								}
								else
								{
									othdeptyear	=Integer.parseInt(tmp[88]+"");
									
								}
								
								if((tmp[89]+"").equals("null") || (tmp[89])==null)
								{
									othdeptmonth=0;
									
								}
								else
								{
									othdeptmonth	=Integer.parseInt(tmp[89]+"");
									
								}
								
								if((tmp[90]+"").equals("null") || (tmp[90])==null)
								{
									othdeptday=0;
									
								}
								else
								{
									othdeptday	=Integer.parseInt(tmp[90]+"");
									
								}
								
								otherdeptservice="Other Dept Service";
								mainpd.setOTHDEPTYEAR(othdeptyear+"");
								mainpd.setOTHDEPTMONTH(othdeptmonth+"");
								mainpd.setOTHDEPTDAY(othdeptday+"");
								mainpd.setOTHDEPTSERVICE(otherdeptservice);
							}
					}
					
					if(wceflag.equals("Yes") && wcecountflag.equals("No"))
					{
						mainpd.setWCESERVICELABLE("WCE Service");
						
						
						if((tmp[18]+"").equals("null") || (tmp[18])==null)
						{
							mainpd.setWCE_SERV_DAYS("");
						}
						else
						{
							mainpd.setWCE_SERV_DAYS(tmp[18]+"");
						}
						if((tmp[19]+"").equals("null") || (tmp[19])==null)
						{
							mainpd.setWCE_SERV_MONTH("");
						}
						else
						{
							mainpd.setWCE_SERV_MONTH(tmp[19]+"");
						}
						if((tmp[20]+"").equals("null") || (tmp[20])==null)
						{
							mainpd.setWCE_SERV_YEAR("");
						}
						else
						{
							mainpd.setWCE_SERV_YEAR(tmp[20]+"");
						}
						
					}
					else
					{
						mainpd.setWCESERVICELABLE("");
						mainpd.setWCE_SERV_DAYS("");
						mainpd.setWCE_SERV_MONTH("");
						mainpd.setWCE_SERV_YEAR("");
					}
					
					mainpd.setCONTINGENT_SERV_FLAG(tmp[23]+"");
					
					
					
					String contingflag=tmp[23]+"";					
					if(contingflag.equals("Yes"))
					{
						
						Integer contingentserviceyear=0;
						Integer contingentservicemonth=0;
						Integer contingentserviceday=0;
						if((tmp[24]+"").equals("null") || (tmp[24])==null)
						{
							contingentday=0;
						}
						else
						{
							contingentday=Integer.parseInt(tmp[24]+"");
						}
						if((tmp[25]+"").equals("null") || (tmp[25])==null)
						{
							contingentmonth=0;
						}
						else
						{
							contingentmonth=Integer.parseInt(tmp[25]+"");
						}
						if((tmp[26]+"").equals("null") || (tmp[26])==null)
						{
							contingentyear=0;
						}
						else
						{
							contingentyear=Integer.parseInt(tmp[26]+"");
						}
						
						
						mainpd.setCONTSERVICELABLE("Contingent Service (50%)");
												
						if(contingentyear>0)
						{
							Integer contingentyrem=contingentyear%2;
							if(contingentyrem==0)
							{
								contingentserviceyear=contingentyear/2;
							}
							if(contingentyrem!=0)
							{
								contingentserviceyear=contingentyear/2;
								contingentmonth=contingentmonth+(contingentyrem*12);
							}
							
							
						}
						if(contingentmonth>0)
						{
							Integer contingentmrem=contingentmonth%2;
							if(contingentmrem==0)
							{
								contingentservicemonth=contingentmonth/2;
							}
							if(contingentmrem!=0)
							{
								contingentservicemonth=contingentmonth/2;
								Integer countday=contingentmrem*30;
								contingentday=contingentday+countday;
							}
							
						}
						
						if(contingentday>0)
						{
							Integer contingentdrem=contingentday%2;
							if(contingentdrem==0)
							{
								contingentserviceday=contingentday/2;
							}
							if(contingentdrem!=0)
							{
								contingentserviceday=(contingentday/2)+1;
								
							}
							
						}
						
						
						
						mainpd.setCONTINGENT_SERV_DAYS(contingentserviceday+"");
						mainpd.setCONTINGENT_SERV_MONTH(contingentservicemonth+"");
						mainpd.setCONTINGENT_SERV_YEAR(contingentserviceyear+"");
					}
					else
					{
						mainpd.setCONTSERVICELABLE("");
						mainpd.setCONTINGENT_SERV_DAYS("");
						mainpd.setCONTINGENT_SERV_MONTH("");
						mainpd.setCONTINGENT_SERV_YEAR("");
						
					}
					mainpd.setNON_PROV_SERV_DAYS((BigDecimal)tmp[27]);
					mainpd.setNON_PROV_SERV_MONTH((BigDecimal)tmp[28]);
					mainpd.setNON_PROV_SERV_YEAR((BigDecimal)tmp[29]);
					mainpd.setEOL_DAYS((BigDecimal)tmp[30]);
					mainpd.setEOL_MONTH((BigDecimal)tmp[31]);
					mainpd.setEOL_YEAR((BigDecimal)tmp[32]);
					mainpd.setSUSPENSION_DAYS((BigDecimal)tmp[33]);
					mainpd.setSUSPENSION_MONTH((BigDecimal)tmp[34]);
					mainpd.setSUSPENSION_YEAR((BigDecimal)tmp[35]);
					mainpd.setBOY_SERV_DAYS((BigDecimal)tmp[36]);
					mainpd.setBOY_SERV_MONTH((BigDecimal)tmp[37]);
					mainpd.setBOY_SERV_YEAR((BigDecimal)tmp[38]);
					mainpd.setOVERSTAY_LEAVE_DAYS((BigDecimal)tmp[39]);
					mainpd.setOVERSTAY_LEAVE_MONTH((BigDecimal)tmp[40]);
					mainpd.setOVERSTAY_LEAVE_YEAR((BigDecimal)tmp[41]);
					mainpd.setNOT_REG_LEAVE_DAYS((BigDecimal)tmp[42]);
					mainpd.setNOT_REG_LEAVE_MONTH((BigDecimal)tmp[43]);
					mainpd.setNOT_REG_LEAVE_YEAR((BigDecimal)tmp[44]);
					mainpd.setAPPRENTICE_DAYS((BigDecimal)tmp[45]);
					mainpd.setAPPRENTICE_MONTH((BigDecimal)tmp[46]);
					mainpd.setAPPRENTICE_YEAR((BigDecimal)tmp[47]);
					mainpd.setNOT_SERV_VERIFY_DAYS((BigDecimal)tmp[48]);
					mainpd.setNOT_SERV_VERIFY_MONTH((BigDecimal)tmp[49]);
					mainpd.setNOT_SERV_VERIFY_YEAR((BigDecimal)tmp[50]);
					mainpd.setFOREIGN_SERV_DAYS((BigDecimal)tmp[51]);
					mainpd.setFOREIGN_SERV_MONTH((BigDecimal)tmp[52]);
					mainpd.setFOREIGN_SERV_YEAR((BigDecimal)tmp[53]);
					
									
					
					if(basicpayname.equals(""))
					{
						mainpd.setLASTBASICLABLE("");
					}
					else
					{
						mainpd.setLASTBASICLABLE(basicpayname);
						if(!(tmp[54]+"").equals("null"))
						{
							mainpd.setLAST_BASIC_PAY(tmp[54]+"");
						}
						
					}
					
					if(specialpayname.equals(""))
					{
						mainpd.setLASTSPECIALLABLE("");
					}
					else
					{
						mainpd.setLASTSPECIALLABLE(specialpayname);
						if(!(tmp[55]+"").equals("null"))
						{
							mainpd.setLAST_SPECIAL_PAY(tmp[55]+"");
						}
					}					
					if(gradepayname.equals(""))
					{
						mainpd.setLASTGRADELABLE("");
					}
					else
					{
						mainpd.setLASTGRADELABLE(gradepayname);
						if(!(tmp[56]+"").equals("null"))
						{
							mainpd.setLAST_GRADE_PAY(tmp[56]+"");
						}
					}					
					
					if(other1payname.equals(""))
					{
						mainpd.setLASTOTHER1LABLE("");
					}
					else
					{
						mainpd.setLASTOTHER1LABLE(other1payname);
						if(!(tmp[57]+"").equals("null"))
						{
							mainpd.setLAST_OTHER_PAY1(tmp[57]+"");
						}
					}					
					if(other2payname.equals(""))
					{
						mainpd.setLASTOTHER2LABLE("");
					}
					else
					{
						mainpd.setLASTOTHER2LABLE(other2payname);
						if(!(tmp[58]+"").equals("null"))
						{
							mainpd.setLAST_OTHER_PAY2(tmp[58]+"");
						}
					}
					if(other3payname.equals(""))
					{
						mainpd.setLASTOTHER3LABLE("");
					}
					else
					{
						mainpd.setLASTOTHER3LABLE(other3payname);
						if(!(tmp[59]+"").equals("null"))
						{
							mainpd.setLAST_OTHER_PAY3(tmp[59]+"");
						}
					}
										
					mainpd.setPENSION_AMOUNT((BigDecimal)tmp[60]);
					pensionamount=Integer.parseInt(tmp[60]+"");
					mainpd.setDCRG_AMOUNT((BigDecimal)tmp[61]);
					mainpd.setNO_OF_HALFYEAR_PENSION((BigDecimal)tmp[62]);
					mainpd.setNO_OF_HALFYEAR_DCRG((BigDecimal)tmp[63]);
					
					
					
					Integer maxpenhalfyr=0;
					Integer penhalfyr=0;
					
					 String strpenhalfyr="select PENHALFYRCEILING from HRM_PEN_CAL_SETTINGS";
					 Query querypenhalfyr=session.createSQLQuery(strpenhalfyr);	
					 Iterator objpenhalfyr=querypenhalfyr.list().iterator();			 
					
					 while(objpenhalfyr.hasNext())
					 {
						 maxpenhalfyr = Integer.parseInt(""+objpenhalfyr.next());		
						 	
					 }				
					 
					  BigDecimal maxpenhalfyrobj=new BigDecimal(maxpenhalfyr);
				      mainpd.setMAX_PEN_HALF_YR((BigDecimal)maxpenhalfyrobj);
					 
					 penhalfyr=Integer.parseInt(tmp[62]+"");
					
					 if(penhalfyr<maxpenhalfyr)
					 {
						 mainpd.setRESTRICT_ORG_PEN("(Restrict to Original Pension)");
					 }
					 else
					 {
						 mainpd.setRESTRICT_ORG_PEN(""); 
					 }
					
					
					mainpd.setCOMMUTEDAMOUNT((BigDecimal)tmp[64]);
					mainpd.setREDUCED_PENSION_AMOUNT((BigDecimal)tmp[65]);
					mainpd.setFAMILY_PENSION_50_AMT((BigDecimal)tmp[66]);
					mainpd.setFAMILY_PENSION_30_AMT((BigDecimal)tmp[67]);
					mainpd.setDAMOUNT((BigDecimal)tmp[68]);
					mainpd.setCOMMUTEDVAL((BigDecimal)tmp[69]);
					mainpd.setTOTAL_COMMUTED_AMOUNT((BigDecimal)tmp[70]);
					
					
					mainpd.setACTUALSERVICEYEAR((BigDecimal)tmp[71]);
					mainpd.setACTUALSERVICEMONTH((BigDecimal)tmp[72]);
					mainpd.setACTUALSERVICEDAYS((BigDecimal)tmp[73]);
					
					
					mainpd.setNETQUALSERVICEYEAR((BigDecimal)tmp[74]);
					mainpd.setNETQUALSERVICEMONTH((BigDecimal)tmp[75]);
					mainpd.setNETQUALSERVICEDAYS((BigDecimal)tmp[76]);
					
					
					mainpd.setNONQUALSERVICEYEAR((BigDecimal)tmp[77]);
					mainpd.setNONQUALSERVICEMONTH((BigDecimal)tmp[78]);
					mainpd.setNONQUALSERVICEDAYS((BigDecimal)tmp[79]);
					if((tmp[80]+"").equals("") || (tmp[80]+"").equals("null"))
					{
						mainpd.setSCALEOFPAY("");
					}
					else
					{
						mainpd.setSCALEOFPAY(tmp[80]+"");
					}
					
					String vrsdateflag=tmp[14]+"";
					String dadate="";
					String vrs_fam_pen_text="";
					String familypenfifty=tmp[66]+"";
					String familypenthirty=tmp[67]+"";
					String uptodate="";
					String afterdate="";
					String uptotext="";
					String aftertext="";
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					uptodate=formatter1.format(tmp[84]);
					afterdate=formatter1.format(tmp[85]);
					
					
					if(vrsdateflag.equals("null") || vrsdateflag.equals(""))
					{
						mainpd.setWEIGHTAGE_SERV_YEAR("");
						mainpd.setWEIGHTAGE_SERV_MONTH("");
						mainpd.setWEIGHTAGE_SERV_DAYS("");
						mainpd.setWEIGHTAGELABLE("");
						mainpd.setTYPEOFPENSION("Retirement");
						if(!(tmp[13]+"").equalsIgnoreCase("null"))
						{
						mainpd.setDATE_OF_RETIRE((Date)tmp[13]);
						}
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						dadate=formatter.format(tmp[13]);
						vrs_fam_pen_text="";
						uptotext="Upto "+uptodate+" = "+familypenfifty;
						aftertext="From "+afterdate+" = "+familypenthirty;
						mainpd.setFAM_UPTO_DATE_TEXT(uptotext);
						mainpd.setFAM_AFTER_DATE_TEXT(aftertext);
						
					}
					else
					{
						mainpd.setWEIGHTAGE_SERV_YEAR(tmp[81]+"");
						mainpd.setWEIGHTAGE_SERV_MONTH(tmp[82]+"");
						mainpd.setWEIGHTAGE_SERV_DAYS(tmp[83]+"");
						mainpd.setWEIGHTAGELABLE("Weightage");						
						mainpd.setTYPEOFPENSION("VRS");
						if(!(tmp[14]+"").equalsIgnoreCase("null"))
						{
						mainpd.setDATE_OF_RETIRE((Date)tmp[14]);
						}
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						dadate=formatter.format(tmp[14]);
						vrs_fam_pen_text="Rs."+familypenfifty+"/- from the day following date of death of the pensioner for 7 years or upto "+uptodate+" whichever is earlier and Rs."+familypenthirty+"/- later on.";
						mainpd.setFAM_UPTO_DATE_TEXT("");
						mainpd.setFAM_AFTER_DATE_TEXT("");
					}
					
					
					Integer minpensionamount=0; 
					Integer maxpensionamount=0;
					Integer minfampensionamount=0;
					Integer maxfampensionamount=0;		        
			        Integer fampensionamount=Integer.parseInt(tmp[66]+"");
			        
			        String sqlQryforminpenamount="select MINPENSIONAMOUNT,MAXPENSIONAMOUNT,MINFAMPENSIONAMOUNT,MAXFAMPENSIONAMOUNT from HRM_PEN_CAL_SETTINGS";			
					
					List<Object[]> recminpenli=session.createSQLQuery(sqlQryforminpenamount).list();
					for(Object[] recminpentmp:recminpenli)
					{
						minpensionamount=Integer.parseInt(recminpentmp[0]+"");
						maxpensionamount=Integer.parseInt(recminpentmp[1]+"");
						minfampensionamount=Integer.parseInt(recminpentmp[2]+"");	
						maxfampensionamount=Integer.parseInt(recminpentmp[3]+"");	
					}
					if(pensionamount<=minpensionamount)
					{
						pensionamount=minpensionamount;
						mainpd.setRESTRICT_PENSION_TEXT("Minimum pension amount is "+minpensionamount);						
					}	
					/*if(pensionamount>=maxpensionamount)
					{
						pensionamount=maxpensionamount;
						mainpd.setRESTRICT_PENSION_TEXT("Maximum pension amount is "+maxpensionamount);						
					}	*/
					if(fampensionamount<=minfampensionamount)
					{
						fampensionamount=minfampensionamount;
						mainpd.setRESTRICT_ORG_PEN("Minimum family pension amount is "+minfampensionamount+". Hence it is restricted.");
						
					}
					if(fampensionamount>=maxfampensionamount)
					{
						fampensionamount=maxfampensionamount;
						mainpd.setRESTRICT_ORG_PEN("Maximum family pension amount is "+maxfampensionamount+". Hence it is restricted.");
					}
					
					mainpd.setFAM_UPTO_DATE((Date)tmp[84]);
					mainpd.setFAM_AFTER_DATE((Date)tmp[85]);
					
					mainpd.setVRS_FAM_PEN_TEXT(vrs_fam_pen_text);
					
					if((tmp[54]+"").equals("null"))
					{
						lastbasic=0;
					}
					else
					{
						lastbasic=Integer.parseInt(tmp[54]+"");	
					}			        
			        if((tmp[55]+"").equals("null"))
					{
			        	lastspecial=0;
					}
					else
					{
						lastspecial=Integer.parseInt(tmp[55]+"");	
					}
			        
			        if((tmp[56]+"").equals("null"))
					{
			        	lastgrade=0;
					}
					else
					{
						lastgrade=Integer.parseInt(tmp[56]+"");	
					}
			        
			        if((tmp[57]+"").equals("null"))
					{
			        	lastother1=0;
					}
					else
					{
						lastother1=Integer.parseInt(tmp[57]+"");	
					}
			        
			        if((tmp[58]+"").equals("null"))
					{
			        	lastother2=0;
					}
					else
					{
						lastother2=Integer.parseInt(tmp[58]+"");	
					}
			        
			        if((tmp[59]+"").equals("null"))
					{
			        	lastother3=0;
					}
					else
					{
						lastother3=Integer.parseInt(tmp[59]+"");	
					}
			 //       lastpaydrwan=lastbasic+lastgrade+lastspecial+lastother1+lastother2+lastother3;
			        lastpaydrwan=lastbasic+lastspecial+lastother1+lastother2+lastother3;
			        
			        
			        BigDecimal lastpayobj=new BigDecimal(lastpaydrwan);
			        mainpd.setLASTPAYDRAWNAMOUNT((BigDecimal)lastpayobj);
			        
			        float sumofav = 0;
			        int aetotmonth=0;
			        String designation="";
					try
					{
						 
						 String str="select sum(av.PROP_PAY) from HRM_PEN_APP_REV_PEN_A_EMOL_CO av where av.EMP_ID="+empId;
						 Query query=session.createSQLQuery(str);	
						 Iterator obj=query.list().iterator();			 
						String objstring="";
						 while(obj.hasNext())
						 {
							 objstring=obj.next()+"";
							 if(!(objstring).equals("null"))
							 {
								 sumofav = Float.parseFloat(objstring);
							 }
							 							 	
						 }
						 String str1="select AVGTOTMONTHS from HRM_PEN_CAL_SETTINGS";
						 Query query1=session.createSQLQuery(str1);	
						 Iterator obj1=query1.list().iterator();			 
						
						 while(obj1.hasNext())
						 {
							 aetotmonth = Integer.parseInt(""+obj1.next());		
							 	
						 }
						 averageemolamount=sumofav/aetotmonth;
						 
						 
						 
						 
						 
						 
						 //String str2="select DESIGNATION from HRM_MST_DESIGNATIONS WHERE DESIGNATION_ID="+tmp[6];
						 //String str2="select DESIGNATION from HRM_MST_DESIGNATIONS WHERE EMPLOYEE_ID="+empId;
						 String str2="SELECT desig.designation " +
					 		"FROM hrm_mst_designations desig " +
					 		"LEFT OUTER JOIN hrm_emp_current_posting post ON post.designation_id = desig.designation_id " +
					 		"WHERE post.employee_id = "+empId;
						 Query query2=session.createSQLQuery(str2);	
						 Iterator obj2=query2.list().iterator();			 
						
						 while(obj2.hasNext())
						 {
							 designation = obj2.next()+"";		
							 	
						 }
						 mainpd.setDESIGNATION_NAME(designation);
						 
						 Integer dapercentage=0;
						 
						 String str3="select DA_PERCENTAGE from hrm_pen_mst_new_da " +
					 		"where effect_date=(select min(effect_date) from hrm_pen_mst_new_da " +
					 		"where effect_date in (select min(effect_date) from hrm_pen_mst_new_da " +
					 		"where effect_date>=to_date('"+dadate+"','dd/MM/yyyy')) or effect_date in (select max(effect_date) from hrm_pen_mst_new_da " +
					 		"where effect_date<=to_date('"+dadate+"','dd/MM/yyyy')))";
						 Query query3=session.createSQLQuery(str3);	
						 Iterator obj3=query3.list().iterator();			 
						
						 while(obj3.hasNext())
						 {
							 dapercentage = Integer.parseInt(obj3.next()+"");		
							 	
						 }
						 BigDecimal daobj=new BigDecimal(dapercentage);
						 mainpd.setDAPERCENTAGE(daobj);
						 
						 Integer sumofrec=0;
						 
						 String sqlQryforsumofrec="select rec.REC_AMOUNT,rec.REC_DESC from HRM_PEN_APP_HO_CO_REC_FORM1 rec where rec.EMP_ID="+empId;		
							
							
							List<Object[]> recsumli=session.createSQLQuery(sqlQryforsumofrec).list();
							for(Object[] recsumtmp:recsumli)
							{
								sumofrec=sumofrec+Integer.parseInt(recsumtmp[0]+"");			
							}
						 
							BigDecimal recsumobj=new BigDecimal(sumofrec);
							mainpd.setRECOVERYAMOUNT(recsumobj);
							
							if(sumofrec>0)
							{
								Integer dcrgamount=Integer.parseInt(tmp[61]+"");
								Integer dcrgdisfinalamount=dcrgamount-sumofrec;
								
								mainpd.setDCRGRECAMTLABLE("DCRG = ");								
								mainpd.setDCRGDISAMT(dcrgamount+"");
								mainpd.setDCRGDISMINUSLABLE("-");								
								
								mainpd.setDCRGAMOUNTEQUALLABLE("=");
								
								
								if(dcrgdisfinalamount<0)
								{
									Integer commutationpensionamount=Integer.parseInt(tmp[70]+"");
									Integer commurecfinaldisamt=(dcrgamount+commutationpensionamount)-sumofrec;
									if(commurecfinaldisamt<0)
									{
										commurecfinaldisamt=sumofrec-dcrgamount;
									}
									Integer commurecamountdis=(sumofrec-dcrgamount);
									dcrgdisfinalamount=0;
									sumofrec=dcrgamount;
									
									
									mainpd.setCOMMURECAMTLABLE("Commutaion Pension Amount = ");
									mainpd.setCOMMUDISMINUSLABLE("-");
									mainpd.setCOMMUAMOUNTEQUALLABLE("=");
									mainpd.setCOMMUDISAMT(commutationpensionamount+"");									
									mainpd.setCOMMURECAMOUNTDIS(commurecamountdis+"");									
									mainpd.setCOMMURECFINALDISAMT(commurecfinaldisamt+"");
									
								}
								mainpd.setRECAMOUNTDIS(sumofrec+"");
								mainpd.setDCRGRECFINALDISAMT(dcrgdisfinalamount+"");
								
							}
							
							
					}
					
					
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					if(lastpaydrwan>=averageemolamount)
					{						
						BigDecimal avobj=new BigDecimal(lastpaydrwan);
						mainpd.setLPD(avobj);						
					}
					else
					{
						BigDecimal avobj=new BigDecimal(averageemolamount);
						mainpd.setLPD(avobj);							
					}
					BigDecimal avemobj=new BigDecimal(averageemolamount);        
			        mainpd.setAVGEMOULMENTSAMOUNT(avemobj);
			        
					
					mainretn.add(mainpd);			
		         }
				
		   
		// con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
			System.out.println("--------------------------------------->error in saving the records");
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return mainretn;	
	}

	private BigDecimal BigDecimal(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<pensionForm1CalcDetailsDao> getHOForm1RecoveryDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionForm1CalcDetailsDao> recretn=new ArrayList<pensionForm1CalcDetailsDao>();
		try
		   {
		        con=session.connection();	
		        
		        
		        int sumofrec=0;
		              
		        
		        
		        String sqlQryforsumofrec="select rec.REC_AMOUNT,rec.REC_DESC from HRM_PEN_APP_HO_CO_REC_FORM1 rec where rec.EMP_ID="+empId;		
				
				
				List<Object[]> recsumli=session.createSQLQuery(sqlQryforsumofrec).list();
				for(Object[] recsumtmp:recsumli)
				{
					sumofrec=sumofrec+Integer.parseInt(recsumtmp[0]+"");			
				}
		        
		        
				
				String sqlQry="select rec.REC_ID,rec.REC_DESC,rec.REC_AMOUNT from HRM_PEN_APP_HO_CO_REC_FORM1 rec where rec.EMP_ID="+empId;
				
				List<Object[]> recli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:recli)
				{
					pensionForm1CalcDetailsDao recpd=new pensionForm1CalcDetailsDao();
					
					recpd.setREC_ID((BigDecimal)tmp[0]);
					recpd.setREC_DESC(tmp[1]+"");
					recpd.setREC_AMOUNT((BigDecimal)tmp[2]);
					BigDecimal recobj=new BigDecimal(sumofrec);
					recpd.setRECOVERY_TOTAL_AMOUNT(recobj);
					recretn.add(recpd);			
		         }				
		// con.commit();        	
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
			System.out.println("--------------------------------------->error in saving the records");
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		return recretn;
	}
	
		
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<pensionForm1CalcDetailsDeathDao> getRevisedPensionCalcDeathDetails(HttpServletRequest request, int empId) {
		
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionForm1CalcDetailsDeathDao> deathmainretn=new ArrayList<pensionForm1CalcDetailsDeathDao>();
		try
		   {
		        con=session.connection();	
		        
		        
		        System.out.println("DEATH DAO IMPL Method");
		        
		        
		        Integer lastbasic = null;
		        Integer lastgrade = null;
		        Integer lastspecial = null;
		        Integer lastother1 = null;
		        Integer lastother2 = null;
		        Integer lastother3 = null;
		        Integer lastpaydrwan = null;
		        float averageemolamount = 0;
		        Integer pensionamount = null;
		        Float commutedamount = null;
				Integer commutedpert = null;
				String basicpayname="";
				String gradepayname="";
				String specialpayname="";
				String other1payname="";				
				String other2payname="";
				String other3payname="";
				Integer contingentday= null;
				Integer contingentmonth= null;
				Integer contingentyear= null;
				
				String sqlQryforavgsetting="select " +
				"avset.PAY_NAME," +
				"avset.INCLUDE," +
				"avset.DA," +				
				"avset.DISPLAY_CAPTION " +
				"from AVERAGE_CAL_SETTING avset";		
				
				
		List<Object[]> avgsettingmainli=session.createSQLQuery(sqlQryforavgsetting).list();
		for(Object[] avgsettingtmp:avgsettingmainli)
		{
			if((avgsettingtmp[0]+"").equals("BASIC"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					basicpayname=avgsettingtmp[3]+"";
				}
			}			
			if((avgsettingtmp[0]+"").equals("GRADE PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					gradepayname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("SPECIAL PAY"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					specialpayname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY1"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					other1payname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY2"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					other2payname=avgsettingtmp[3]+"";
				}
			}
			if((avgsettingtmp[0]+"").equals("OTHER PAY3"))
			{
				if((avgsettingtmp[1]+"").equals("Y"))
				{
					other3payname=avgsettingtmp[3]+"";
				}
			}
		}
				
				
				
				
				
				
				String sqlQry="select " +
						"cd.EMP_ID," +
						"cd.OFFICE_ID," +
						"cd.PENSION_TYPE," +
						"cd.EMP_INITIAL," +
						"cd.EMP_NAME," +
						"cd.DESIG_SERVICE_GRP," +
						"cd.DESIGNATION_ID," +
						"cd.DATE_OF_BIRTH," +
						"cd.DATE_OF_APP," +
						"cd.DATE_OF_PROVINC," +
						"cd.DATE_OF_REG_ESTAB," +
						"cd.DATE_OF_SELECTION," +
						"cd.DATE_OF_SPECIAL," +
						"cd.DATE_OF_RETIRE," +
						"cd.DATE_OF_VRS," +
						"COMM_OPTED," +
						"COMM_FACTOR_ONRTHIRD," +
						"COM_FACTOR_PERT," +
						"WCE_SERV_DAYS," +
						"WCE_SERV_MONTH," +
						"WCE_SERV_YEAR," +
						"WCE_SERV_FLAG," +
						"WCE_SERV_COUNT_FLAG," +
						"cd.CONTINGENT_SERV_FLAG," +
						"cd.CONTINGENT_SERV_DAYS," +
						"cd.CONTINGENT_SERV_MONTH," +
						"cd.CONTINGENT_SERV_YEAR," +
						"cd.NON_PROV_SERV_DAYS," +
						"cd.NON_PROV_SERV_MONTH," +
						"cd.NON_PROV_SERV_YEAR," +
						"cd.EOL_DAYS," +
						"cd.EOL_MONTH," +
						"cd.EOL_YEAR," +
						"cd.SUSPENSION_DAYS," +
						"cd.SUSPENSION_MONTH," +
						"cd.SUSPENSION_YEAR," +
						"cd.BOY_SERV_DAYS," +
						"cd.BOY_SERV_MONTH," +
						"cd.BOY_SERV_YEAR," +
						"cd.OVERSTAY_LEAVE_DAYS," +
						"cd.OVERSTAY_LEAVE_MONTH," +
						"cd.OVERSTAY_LEAVE_YEAR," +
						"cd.NOT_REG_LEAVE_DAYS," +
						"cd.NOT_REG_LEAVE_MONTH," +
						"cd.NOT_REG_LEAVE_YEAR," +
						"cd.APPRENTICE_DAYS," +
						"cd.APPRENTICE_MONTH," +
						"cd.APPRENTICE_YEAR," +
						"cd.NOT_SERV_VERIFY_DAYS," +
						"cd.NOT_SERV_VERIFY_MONTH," +
						"cd.NOT_SERV_VERIFY_YEAR," +
						"cd.FOREIGN_SERV_DAYS," +
						"cd.FOREIGN_SERV_MONTH," +
						"cd.FOREIGN_SERV_YEAR," +
						"cd.LAST_BASIC_PAY," +
						"cd.LAST_SPECIAL_PAY," +
						"cd.LAST_GRADE_PAY," +
						"cd.LAST_OTHER_PAY1," +
						"cd.LAST_OTHER_PAY2," +
						"cd.LAST_OTHER_PAY3," +
						"cd.PENSION_AMOUNT," +
						"cd.DCRG_AMOUNT," +
						"cd.NO_OF_HALFYEAR_PENSION," +
						"cd.NO_OF_HALFYEAR_DCRG," +
						"cd.TOTAL_COMMUTED_AMOUNT," +
						"cd.REDUCED_PENSION_AMOUNT," +
						"cd.FAMILY_PENSION_50_AMT," +
						"cd.FAMILY_PENSION_30_AMT, " +
						"cd.DA_AMOUNT, " +
						"cd.COMMUTED_VALUE, " +
						"cd.COMMUTATION_PEN_AMOUNT, " +
						"cd.ACTUAL_SER_YEAR, " +
						"cd.ACTUAL_SER_MON, " +
						"cd.ACTUAL_SER_DAYS, " +
						"cd.NET_SER_YEAR, " +
						"cd.NET_SER_MON, " +
						"cd.NET_SER_DAYS, " +
						"cd.TOT_NON_QUAL_SER_YEAR, " +
						"cd.TOT_NON_QUAL_SER_MON, " +
						"cd.TOT_NON_QUAL_SER_DAYS, " +
						"cd.SCALE_OF_PAY, " +
						"cd.WEIGHTAGE_YEAR, " +
						"cd.WEIGHTAGE_MONTH, " +
						"cd.WEIGHTAGE_DAYS, " +
						"cd.FAM_PEN_UPTO_SEVEN, " +
						"cd.FAM_PEN_AFTER_SEVEN, " +
						"cd.DEATH_DATE " +
						"from hrm_pen_app_ho_mst_form1_det cd where cd.EMP_ID="+empId;				
				List<Object[]> mainli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:mainli)
				{
					pensionForm1CalcDetailsDeathDao deathmainpd=new pensionForm1CalcDetailsDeathDao();
					
					deathmainpd.setEMP_ID((BigDecimal)tmp[0]);
					deathmainpd.setOFFICE_ID((BigDecimal)tmp[1]);
					deathmainpd.setPENSION_TYPE((BigDecimal)tmp[2]);
					deathmainpd.setEMP_INITIAL(tmp[3]+"");
					deathmainpd.setEMP_NAME(tmp[4]+"");
					deathmainpd.setDESIG_SERVICE_GRP((BigDecimal)tmp[5]);
					deathmainpd.setDESIGNATION_ID((BigDecimal)tmp[6]);
					deathmainpd.setDATE_OF_BIRTH((Date)tmp[7]);
					deathmainpd.setDATE_OF_APP((Date)tmp[8]);
					deathmainpd.setDATE_OF_PROVINC((Date)tmp[9]);
					deathmainpd.setDATE_OF_REG_ESTAB((Date)tmp[10]);
					deathmainpd.setDATE_OF_SELECTION((Date)tmp[11]);
					deathmainpd.setDATE_OF_SPECIAL((Date)tmp[12]);
					deathmainpd.setDATE_OF_VRS((Date)tmp[14]);
					deathmainpd.setCOMM_OPTED(tmp[15]+"");
					deathmainpd.setCOMM_FACTOR_ONRTHIRD(tmp[16]+"");
					deathmainpd.setCOM_FACTOR_PERT((BigDecimal)tmp[17]);
										
					deathmainpd.setWCE_SERV_FLAG(tmp[21]+"");
					deathmainpd.setWCE_SERV_COUNT_FLAG(tmp[22]+"");
					String wceflag=tmp[21]+"";
					String wcecountflag=tmp[22]+"";
					if(wceflag.equals("Yes") && wcecountflag.equals("No"))
					{
						deathmainpd.setWCESERVICELABLE("WCE Service");
						
						
						if((tmp[18]+"").equals("null") || (tmp[18])==null)
						{
							deathmainpd.setWCE_SERV_DAYS("");
						}
						else
						{
							deathmainpd.setWCE_SERV_DAYS(tmp[18]+"");
						}
						if((tmp[19]+"").equals("null") || (tmp[19])==null)
						{
							deathmainpd.setWCE_SERV_MONTH("");
						}
						else
						{
							deathmainpd.setWCE_SERV_MONTH(tmp[19]+"");
						}
						if((tmp[20]+"").equals("null") || (tmp[20])==null)
						{
							deathmainpd.setWCE_SERV_YEAR("");
						}
						else
						{
							deathmainpd.setWCE_SERV_YEAR(tmp[20]+"");
						}
						
					}
					else
					{
						deathmainpd.setWCESERVICELABLE("");
						deathmainpd.setWCE_SERV_DAYS("");
						deathmainpd.setWCE_SERV_MONTH("");
						deathmainpd.setWCE_SERV_YEAR("");
					}
					
					deathmainpd.setCONTINGENT_SERV_FLAG(tmp[23]+"");
					
					
					
					
					String contingflag=tmp[23]+"";					
					if(contingflag.equals("Yes"))
					{
						
						
						
						Integer contingentserviceyear=0;
						Integer contingentservicemonth=0;
						Integer contingentserviceday=0;
						if((tmp[24]+"").equals("null") || (tmp[24])==null)
						{
							contingentday=0;
						}
						else
						{
							contingentday=Integer.parseInt(tmp[24]+"");
						}
						if((tmp[25]+"").equals("null") || (tmp[25])==null)
						{
							contingentmonth=0;
						}
						else
						{
							contingentmonth=Integer.parseInt(tmp[25]+"");
						}
						if((tmp[26]+"").equals("null") || (tmp[26])==null)
						{
							contingentyear=0;
						}
						else
						{
							contingentyear=Integer.parseInt(tmp[26]+"");
						}
						
						
						deathmainpd.setCONTSERVICELABLE("Contingent Service (50%)");
						
						
						
						
						if(contingentyear>0)
						{
							Integer contingentyrem=contingentyear%2;
							if(contingentyrem==0)
							{
								contingentserviceyear=contingentyear/2;
							}
							if(contingentyrem!=0)
							{
								contingentserviceyear=contingentyear/2;
								contingentmonth=contingentmonth+(contingentyrem*12);
							}
							
							
						}
						if(contingentmonth>0)
						{
							Integer contingentmrem=contingentmonth%2;
							if(contingentmrem==0)
							{
								contingentservicemonth=contingentmonth/2;
							}
							if(contingentmrem!=0)
							{
								contingentservicemonth=contingentmonth/2;
								Integer countday=contingentmrem*30;
								contingentday=contingentday+countday;
							}
							
						}
						
						if(contingentday>0)
						{
							Integer contingentdrem=contingentday%2;
							if(contingentdrem==0)
							{
								contingentserviceday=contingentday/2;
							}
							if(contingentdrem!=0)
							{
								contingentserviceday=(contingentday/2)+1;
								
							}
							
						}
						
						
						
						
						deathmainpd.setCONTINGENT_SERV_DAYS(contingentserviceday+"");
						deathmainpd.setCONTINGENT_SERV_MONTH(contingentservicemonth+"");
						deathmainpd.setCONTINGENT_SERV_YEAR(contingentserviceyear+"");
					}
					else
					{
						deathmainpd.setCONTSERVICELABLE("");
						deathmainpd.setCONTINGENT_SERV_DAYS("");
						deathmainpd.setCONTINGENT_SERV_MONTH("");
						deathmainpd.setCONTINGENT_SERV_YEAR("");
						
					}
					deathmainpd.setNON_PROV_SERV_DAYS((BigDecimal)tmp[27]);
					deathmainpd.setNON_PROV_SERV_MONTH((BigDecimal)tmp[28]);
					deathmainpd.setNON_PROV_SERV_YEAR((BigDecimal)tmp[29]);
					deathmainpd.setEOL_DAYS((BigDecimal)tmp[30]);
					deathmainpd.setEOL_MONTH((BigDecimal)tmp[31]);
					deathmainpd.setEOL_YEAR((BigDecimal)tmp[32]);
					deathmainpd.setSUSPENSION_DAYS((BigDecimal)tmp[33]);
					deathmainpd.setSUSPENSION_MONTH((BigDecimal)tmp[34]);
					deathmainpd.setSUSPENSION_YEAR((BigDecimal)tmp[35]);
					deathmainpd.setBOY_SERV_DAYS((BigDecimal)tmp[36]);
					deathmainpd.setBOY_SERV_MONTH((BigDecimal)tmp[37]);
					deathmainpd.setBOY_SERV_YEAR((BigDecimal)tmp[38]);
					deathmainpd.setOVERSTAY_LEAVE_DAYS((BigDecimal)tmp[39]);
					deathmainpd.setOVERSTAY_LEAVE_MONTH((BigDecimal)tmp[40]);
					deathmainpd.setOVERSTAY_LEAVE_YEAR((BigDecimal)tmp[41]);
					deathmainpd.setNOT_REG_LEAVE_DAYS((BigDecimal)tmp[42]);
					deathmainpd.setNOT_REG_LEAVE_MONTH((BigDecimal)tmp[43]);
					deathmainpd.setNOT_REG_LEAVE_YEAR((BigDecimal)tmp[44]);
					deathmainpd.setAPPRENTICE_DAYS((BigDecimal)tmp[45]);
					deathmainpd.setAPPRENTICE_MONTH((BigDecimal)tmp[46]);
					deathmainpd.setAPPRENTICE_YEAR((BigDecimal)tmp[47]);
					deathmainpd.setNOT_SERV_VERIFY_DAYS((BigDecimal)tmp[48]);
					deathmainpd.setNOT_SERV_VERIFY_MONTH((BigDecimal)tmp[49]);
					deathmainpd.setNOT_SERV_VERIFY_YEAR((BigDecimal)tmp[50]);
					deathmainpd.setFOREIGN_SERV_DAYS((BigDecimal)tmp[51]);
					deathmainpd.setFOREIGN_SERV_MONTH((BigDecimal)tmp[52]);
					deathmainpd.setFOREIGN_SERV_YEAR((BigDecimal)tmp[53]);
					
					
					
					
					
					if(basicpayname.equals(""))
					{
						deathmainpd.setLASTBASICLABLE("");
					}
					else
					{
						deathmainpd.setLASTBASICLABLE(basicpayname);
						if(!(tmp[54]+"").equals("null"))
						{
							deathmainpd.setLAST_BASIC_PAY(tmp[54]+"");
						}
						
					}
					
					if(specialpayname.equals(""))
					{
						deathmainpd.setLASTSPECIALLABLE("");
					}
					else
					{
						deathmainpd.setLASTSPECIALLABLE(specialpayname);
						if(!(tmp[55]+"").equals("null"))
						{
							deathmainpd.setLAST_SPECIAL_PAY(tmp[55]+"");
						}
					}					
					if(gradepayname.equals(""))
					{
						deathmainpd.setLASTGRADELABLE("");
					}
					else
					{
						deathmainpd.setLASTGRADELABLE(gradepayname);
						if(!(tmp[56]+"").equals("null"))
						{
							deathmainpd.setLAST_GRADE_PAY(tmp[56]+"");
						}
					}					
					
					if(other1payname.equals(""))
					{
						deathmainpd.setLASTOTHER1LABLE("");
					}
					else
					{
						deathmainpd.setLASTOTHER1LABLE(other1payname);
						if(!(tmp[57]+"").equals("null"))
						{
							deathmainpd.setLAST_OTHER_PAY1(tmp[57]+"");
						}
					}					
					if(other2payname.equals(""))
					{
						deathmainpd.setLASTOTHER2LABLE("");
					}
					else
					{
						deathmainpd.setLASTOTHER2LABLE(other2payname);
						if(!(tmp[58]+"").equals("null"))
						{
							deathmainpd.setLAST_OTHER_PAY2(tmp[58]+"");
						}
					}
					if(other3payname.equals(""))
					{
						deathmainpd.setLASTOTHER3LABLE("");
					}
					else
					{
						deathmainpd.setLASTOTHER3LABLE(other3payname);
						if(!(tmp[59]+"").equals("null"))
						{
							deathmainpd.setLAST_OTHER_PAY3(tmp[59]+"");
						}
					}
										
					deathmainpd.setPENSION_AMOUNT((BigDecimal)tmp[60]);
					pensionamount=Integer.parseInt(tmp[60]+"");
					deathmainpd.setDCRG_AMOUNT((BigDecimal)tmp[61]);
					deathmainpd.setNO_OF_HALFYEAR_PENSION((BigDecimal)tmp[62]);
					deathmainpd.setNO_OF_HALFYEAR_DCRG((BigDecimal)tmp[63]);
					
					
					
					Integer maxpenhalfyr=0;
					Integer penhalfyr=0;
					
					 String strpenhalfyr="select PENHALFYRCEILING from HRM_PEN_CAL_SETTINGS";
					 Query querypenhalfyr=session.createSQLQuery(strpenhalfyr);	
					 Iterator objpenhalfyr=querypenhalfyr.list().iterator();			 
					
					 while(objpenhalfyr.hasNext())
					 {
						 maxpenhalfyr = Integer.parseInt(""+objpenhalfyr.next());		
						 	
					 }				
					 
					  BigDecimal maxpenhalfyrobj=new BigDecimal(maxpenhalfyr);
					  deathmainpd.setMAX_PEN_HALF_YR((BigDecimal)maxpenhalfyrobj);
					 
					 penhalfyr=Integer.parseInt(tmp[62]+"");
					
					 if(penhalfyr<maxpenhalfyr)
					 {
						 deathmainpd.setRESTRICT_ORG_PEN("(Restrict to Original Pension)");
					 }
					 else
					 {
						 deathmainpd.setRESTRICT_ORG_PEN(""); 
					 }
					
					
					
					 deathmainpd.setCOMMUTEDAMOUNT((BigDecimal)tmp[64]);
					 deathmainpd.setREDUCED_PENSION_AMOUNT((BigDecimal)tmp[65]);
					 deathmainpd.setFAMILY_PENSION_50_AMT((BigDecimal)tmp[66]);
					 deathmainpd.setFAMILY_PENSION_30_AMT((BigDecimal)tmp[67]);
					 deathmainpd.setDAMOUNT((BigDecimal)tmp[68]);
					 deathmainpd.setCOMMUTEDVAL((BigDecimal)tmp[69]);
					 deathmainpd.setTOTAL_COMMUTED_AMOUNT((BigDecimal)tmp[70]);
					
					
					 deathmainpd.setACTUALSERVICEYEAR((BigDecimal)tmp[71]);
					 deathmainpd.setACTUALSERVICEMONTH((BigDecimal)tmp[72]);
					 deathmainpd.setACTUALSERVICEDAYS((BigDecimal)tmp[73]);
					
					
					 deathmainpd.setNETQUALSERVICEYEAR((BigDecimal)tmp[74]);
					 deathmainpd.setNETQUALSERVICEMONTH((BigDecimal)tmp[75]);
					 deathmainpd.setNETQUALSERVICEDAYS((BigDecimal)tmp[76]);
					
					
					 deathmainpd.setNONQUALSERVICEYEAR((BigDecimal)tmp[77]);
					 deathmainpd.setNONQUALSERVICEMONTH((BigDecimal)tmp[78]);
					 deathmainpd.setNONQUALSERVICEDAYS((BigDecimal)tmp[79]);
					if((tmp[80]+"").equals("") || (tmp[80]+"").equals("null"))
					{
						deathmainpd.setSCALEOFPAY("");
					}
					else
					{
						deathmainpd.setSCALEOFPAY(tmp[80]+"");
					}
					
					String vrsdateflag=tmp[14]+"";
					String dadate="";
					String vrs_fam_pen_text="";
					String familypenfifty=tmp[66]+"";
					String familypenthirty=tmp[67]+"";
					String uptodate="";
					String afterdate="";
					String uptotext="";
					String aftertext="";
					DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					uptodate=formatter1.format(tmp[84]);
					afterdate=formatter1.format(tmp[85]);
					String deathdate=formatter1.format(tmp[86]);
					
					
					if(vrsdateflag.equals("null") || vrsdateflag.equals(""))
					{
						deathmainpd.setWEIGHTAGE_SERV_YEAR("");
						deathmainpd.setWEIGHTAGE_SERV_MONTH("");
						deathmainpd.setWEIGHTAGE_SERV_DAYS("");
						deathmainpd.setWEIGHTAGELABLE("");
						deathmainpd.setTYPEOFPENSION("Death");
						if(!(tmp[86]+"").equalsIgnoreCase("null"))
						{
						deathmainpd.setDATE_OF_RETIRE((Date)tmp[86]);
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						//dadate=formatter.format(tmp[13]);
						dadate=formatter.format(tmp[86]);
						}
						
						vrs_fam_pen_text="";
						uptotext="Upto "+uptodate+" = "+familypenfifty;
						aftertext="From "+afterdate+" = "+familypenthirty;
						deathmainpd.setFAM_UPTO_DATE_TEXT(uptotext);
						deathmainpd.setFAM_AFTER_DATE_TEXT(aftertext);
						
					}
					else
					{
						deathmainpd.setWEIGHTAGE_SERV_YEAR(tmp[81]+"");
						deathmainpd.setWEIGHTAGE_SERV_MONTH(tmp[82]+"");
						deathmainpd.setWEIGHTAGE_SERV_DAYS(tmp[83]+"");
						deathmainpd.setWEIGHTAGELABLE("Weightage");						
						deathmainpd.setTYPEOFPENSION("VRS");
						if(!(tmp[14]+"").equalsIgnoreCase("null"))
						{
						deathmainpd.setDATE_OF_RETIRE((Date)tmp[14]);
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						dadate=formatter.format(tmp[14]);
						}
						
						vrs_fam_pen_text="Rs."+familypenfifty+"/- from the day following date of death of the pensioner for 7 years or upto "+uptodate+" whichever is earlier and Rs."+familypenthirty+"/- later on.";
						deathmainpd.setFAM_UPTO_DATE_TEXT("");
						deathmainpd.setFAM_AFTER_DATE_TEXT("");
					}
					
					
					Integer minpensionamount=0; 
					Integer maxpensionamount=0;
					Integer minfampensionamount=0;
					Integer maxfampensionamount=0;		        
			        Integer fampensionamount=Integer.parseInt(tmp[66]+"");
			        
			        String sqlQryforminpenamount="select MINPENSIONAMOUNT,MAXPENSIONAMOUNT,MINFAMPENSIONAMOUNT,MAXFAMPENSIONAMOUNT from HRM_PEN_CAL_SETTINGS";			
					
					List<Object[]> recminpenli=session.createSQLQuery(sqlQryforminpenamount).list();
					for(Object[] recminpentmp:recminpenli)
					{
						minpensionamount=Integer.parseInt(recminpentmp[0]+"");
						maxpensionamount=Integer.parseInt(recminpentmp[1]+"");
						minfampensionamount=Integer.parseInt(recminpentmp[2]+"");	
						maxfampensionamount=Integer.parseInt(recminpentmp[3]+"");	
					}
					if(pensionamount<=minpensionamount)
					{
						pensionamount=minpensionamount;
						deathmainpd.setRESTRICT_PENSION_TEXT("Minimum pension amount is "+minpensionamount);						
					}	
					
					if(fampensionamount<=minfampensionamount)
					{
						fampensionamount=minfampensionamount;
						deathmainpd.setRESTRICT_ORG_PEN("Minimum family pension amount is "+minfampensionamount+". Hence it is restricted.");
						
					}
					if(fampensionamount>=maxfampensionamount)
					{
						fampensionamount=maxfampensionamount;
						deathmainpd.setRESTRICT_ORG_PEN("Maximum family pension amount is "+maxfampensionamount+". Hence it is restricted.");
					}
					
					deathmainpd.setFAM_UPTO_DATE((Date)tmp[84]);
					deathmainpd.setFAM_AFTER_DATE((Date)tmp[85]);
					
					deathmainpd.setVRS_FAM_PEN_TEXT(vrs_fam_pen_text);
					
					if((tmp[54]+"").equals("null"))
					{
						lastbasic=0;
					}
					else
					{
						lastbasic=Integer.parseInt(tmp[54]+"");	
					}			        
			        if((tmp[55]+"").equals("null"))
					{
			        	lastspecial=0;
					}
					else
					{
						lastspecial=Integer.parseInt(tmp[55]+"");	
					}
			        
			        if((tmp[56]+"").equals("null"))
					{
			        	lastgrade=0;
					}
					else
					{
						lastgrade=Integer.parseInt(tmp[56]+"");	
					}
			        
			        if((tmp[57]+"").equals("null"))
					{
			        	lastother1=0;
					}
					else
					{
						lastother1=Integer.parseInt(tmp[57]+"");	
					}
			        
			        if((tmp[58]+"").equals("null"))
					{
			        	lastother2=0;
					}
					else
					{
						lastother2=Integer.parseInt(tmp[58]+"");	
					}
			        
			        if((tmp[59]+"").equals("null"))
					{
			        	lastother3=0;
					}
					else
					{
						lastother3=Integer.parseInt(tmp[59]+"");	
					}
			        lastpaydrwan=lastbasic+lastgrade+lastspecial+lastother1+lastother2+lastother3;
			        
			        
			        BigDecimal lastpayobj=new BigDecimal(lastpaydrwan);
			        deathmainpd.setLASTPAYDRAWNAMOUNT((BigDecimal)lastpayobj);
			        
			        float sumofav = 0;
			        int aetotmonth=0;
			        String designation="";
					try
					{
						 
						 String str="select sum(av.PROP_PAY) from HRM_PEN_APP_REV_PEN_A_EMOL_CO av where av.EMP_ID="+empId;
						Query query=session.createSQLQuery(str);	
						 Iterator obj=query.list().iterator();			 
						String objstring="";
						 while(obj.hasNext())
						 {
							 objstring=obj.next()+"";
							 if(!(objstring).equals("null"))
							 {
							 sumofav = Float.parseFloat(objstring);
							 }
							 	
						 }
						 String str1="select AVGTOTMONTHS from HRM_PEN_CAL_SETTINGS";
						 Query query1=session.createSQLQuery(str1);	
						 Iterator obj1=query1.list().iterator();			 
						
						 while(obj1.hasNext())
						 {
							 aetotmonth = Integer.parseInt(""+obj1.next());		
							 	
						 }
						 averageemolamount=sumofav/aetotmonth;
						 
						 
						 
						 
						 
						 
						 //String str2="select DESIGNATION from HRM_MST_DESIGNATIONS WHERE DESIGNATION_ID="+tmp[6];
						 //String str2="select DESIGNATION from HRM_MST_DESIGNATIONS WHERE EMPLOYEE_ID="+empId;
						 String str2="SELECT desig.designation " +
					 		"FROM hrm_mst_designations desig " +
					 		"LEFT OUTER JOIN hrm_emp_current_posting post ON post.designation_id = desig.designation_id " +
					 		"WHERE post.employee_id = "+empId;
						 Query query2=session.createSQLQuery(str2);	
						 Iterator obj2=query2.list().iterator();			 
						
						 while(obj2.hasNext())
						 {
							 designation = obj2.next()+"";		
							 	
						 }
						 deathmainpd.setDESIGNATION_NAME(designation);
						 
						 Integer dapercentage=0;
						 
						 String str3="select DA_PERCENTAGE from hrm_pen_mst_new_da " +
					 		"where effect_date=(select min(effect_date) from hrm_pen_mst_new_da " +
					 		"where effect_date in (select min(effect_date) from hrm_pen_mst_new_da " +
					 		"where effect_date>=to_date('"+dadate+"','dd/MM/yyyy')) or effect_date in (select max(effect_date) from hrm_pen_mst_new_da " +
					 		"where effect_date<=to_date('"+dadate+"','dd/MM/yyyy')))";
						 Query query3=session.createSQLQuery(str3);	
						 Iterator obj3=query3.list().iterator();			 
						
						 while(obj3.hasNext())
						 {
							 dapercentage = Integer.parseInt(obj3.next()+"");		
							 	
						 }
						 BigDecimal daobj=new BigDecimal(dapercentage);
						 deathmainpd.setDAPERCENTAGE(daobj);
						 
						 Integer sumofrec=0;
						 
						 String sqlQryforsumofrec="select rec.REC_AMOUNT,rec.REC_DESC from HRM_PEN_APP_HO_CO_REC_FORM1 rec where rec.EMP_ID="+empId;		
							
							
							List<Object[]> recsumli=session.createSQLQuery(sqlQryforsumofrec).list();
							for(Object[] recsumtmp:recsumli)
							{
								sumofrec=sumofrec+Integer.parseInt(recsumtmp[0]+"");			
							}
						 
							BigDecimal recsumobj=new BigDecimal(sumofrec);
							
							deathmainpd.setRECOVERYAMOUNT(recsumobj);
							
							if(sumofrec>0)
							{
								Integer dcrgamount=Integer.parseInt(tmp[61]+"");
								Integer dcrgdisfinalamount=dcrgamount-sumofrec;
								
								deathmainpd.setDCRGRECAMTLABLE("DCRG = ");								
								deathmainpd.setDCRGDISAMT(dcrgamount+"");
								deathmainpd.setDCRGDISMINUSLABLE("-");								
								
								deathmainpd.setDCRGAMOUNTEQUALLABLE("=");
								
								
								if(dcrgdisfinalamount<0)
								{
									Integer commutationpensionamount=Integer.parseInt(tmp[70]+"");
									Integer commurecfinaldisamt=(dcrgamount+commutationpensionamount)-sumofrec;
									if(commurecfinaldisamt<0)
									{
										commurecfinaldisamt=sumofrec-dcrgamount;
									}
									Integer commurecamountdis=(sumofrec-dcrgamount);
									dcrgdisfinalamount=0;
									sumofrec=dcrgamount;
									
									
									deathmainpd.setCOMMURECAMTLABLE("Commutaion Pension Amount = ");
									deathmainpd.setCOMMUDISMINUSLABLE("-");
									deathmainpd.setCOMMUAMOUNTEQUALLABLE("=");
									deathmainpd.setCOMMUDISAMT(commutationpensionamount+"");									
									deathmainpd.setCOMMURECAMOUNTDIS(commurecamountdis+"");									
									deathmainpd.setCOMMURECFINALDISAMT(commurecfinaldisamt+"");
									
								}
								deathmainpd.setRECAMOUNTDIS(sumofrec+"");
								deathmainpd.setDCRGRECFINALDISAMT(dcrgdisfinalamount+"");
								
							}
							
							
							
							
							Integer nqs_year=0;
							if(!(tmp[74]+"").equalsIgnoreCase("null"))
							{
								nqs_year=Integer.parseInt(tmp[74]+"");
							}
							
							if(nqs_year<1)
							{
								deathmainpd.setDCRG_TITLE_LABLE("( LPD+DA ) * 2");
								deathmainpd.setDCRG_AMOUNT_LABLE("( "+lastpaydrwan+"+"+tmp[68]+" ) * 2");
							}
							if((nqs_year>=1) && (nqs_year<5))
							{									
								deathmainpd.setDCRG_TITLE_LABLE("( LPD+DA ) * 6");
								deathmainpd.setDCRG_AMOUNT_LABLE("( "+lastpaydrwan+"+"+tmp[68]+" ) * 6");
							}
							if((nqs_year>=5) && (nqs_year<20))
							{									
								deathmainpd.setDCRG_TITLE_LABLE("( LPD+DA ) * 12");
								deathmainpd.setDCRG_AMOUNT_LABLE("( "+lastpaydrwan+"+"+tmp[68]+" ) * 12");
							}
							if(nqs_year>=20)
							{							
								deathmainpd.setDCRG_TITLE_LABLE("( LPD+DA ) * 0.5 * (Number of Half Years for DCRG)");
								deathmainpd.setDCRG_AMOUNT_LABLE("( "+lastpaydrwan+"+"+tmp[68]+" ) * 0.5 * ( "+tmp[63]+" )");
							}	
							
							
							
					}
										
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
			        
					if(lastpaydrwan>=averageemolamount)
					{					
						
						BigDecimal avobj=new BigDecimal(lastpaydrwan);
						deathmainpd.setLPD(avobj);
						
					}
					else
					{
						BigDecimal avobj=new BigDecimal(averageemolamount);
						deathmainpd.setLPD(avobj);						
						
					}
					BigDecimal avemobj=new BigDecimal(averageemolamount);        
					deathmainpd.setAVGEMOULMENTSAMOUNT(avemobj);
			        
					
			        deathmainretn.add(deathmainpd);			
		         }
				
		   
		 con.commit();
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
			System.out.println("--------------------------------------->error in saving the records");
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}		
		return deathmainretn;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<pensionForm1CalcDetailsDao> getHOForm1OtherDeptServiceVal(
			HttpServletRequest request, int empId) {
		// TODO Auto-generated method stub
		Connection con=null;
	    Session session = SessionFactoryUtils.doGetSession(sessionFactory,true);
		List<pensionForm1CalcDetailsDao> othdeptretn=new ArrayList<pensionForm1CalcDetailsDao>();
		try
		   {
		        con=session.connection();	
		   	
				String sqlQry="SELECT " +
						"DATE_OF_JOINING," +
						"DATE_OF_RELIEVING," +
						"TOT_YEAR_SERVICE," +
						"TOT_MONTH_SERVICE," +
						"TOT_DAY_SERVICE," +
						"DEPATMENT_NAME," +
						"REMARKS FROM HRM_PEN_APP_HO_MST_OTHDEPTSER where  EMPLOYEEID ="+empId;
				
				List<Object[]> recli=session.createSQLQuery(sqlQry).list();
				for(Object[] tmp:recli)
				{
					pensionForm1CalcDetailsDao othdpetpd=new pensionForm1CalcDetailsDao();


				                     	Date doj=null;
										Date dor=null;
										Integer year=0;
										Integer month=0;
										Integer days=0;
										String department="";
										String remarks="";
										
										if(!(tmp[0]+"").equals("null"))
										{
											doj=(Date)tmp[0];
										}
										if(!(tmp[1]+"").equals("null"))
										{
											dor=(Date)tmp[1];
										}
										
										if(!(tmp[2]+"").equals("null"))
										{
											year=Integer.parseInt(tmp[2]+"");
										}
										
										if(!(tmp[3]+"").equals("null"))
										{
											month=Integer.parseInt(tmp[3]+"");
										}
										
										if(!(tmp[4]+"").equals("null"))
										{
											days=Integer.parseInt(tmp[4]+"");
										}
											
										if(!(tmp[5]+"").equals("null"))
										{
											department=tmp[5]+"";
										}
												
										if(!(tmp[6]+"").equals("null"))
										{
											remarks=tmp[6]+"";
										}
										
										
										BigDecimal totyear=new BigDecimal(year);
										BigDecimal totmonth=new BigDecimal(month);
										BigDecimal totdays=new BigDecimal(days);
										
										othdpetpd.setDATE_OF_JOINING(doj);
										othdpetpd.setDATE_OF_RELIEVING(dor);
										
										othdpetpd.setTOT_YEAR_SERVICE(totyear);
										othdpetpd.setTOT_MONTH_SERVICE(totmonth);
										othdpetpd.setTOT_DAY_SERVICE(totdays);
										
										othdpetpd.setDEPATMENT_NAME(department);
										othdpetpd.setREMARKS(remarks);
										
					
					othdeptretn.add(othdpetpd);			
		         }				
		// con.commit();        	
         
		   }	
		catch (Exception e) {
				e.printStackTrace();
		}finally{
			SessionFactoryUtils.releaseSession(session, sessionFactory);
		}	
		return othdeptretn;
	}
	
}
	
	







