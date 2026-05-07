package com.nic.hrms.pension.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.math.*;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.PensionApplicationHOForm1AverageEmolumentsValDao;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;
import com.nic.hrms.pension.model.PensionPaymentOffice_dao;
import com.nic.hrms.pension.model.RevisedDCRGPensionHODao;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionAuthorizationOriginalService;
import com.nic.hrms.pension.service.RevisedDCRGPenLoadHeadOfficeDataService;
import com.nic.hrms.pension.service.UpdatedUserIdService;
import com.nic.hrms.pension.model.RevisedPensionAuthorizationDao;
import com.nic.hrms.pension.service.RevisedPensionAuthorizationService;
public class RevisedDCRGPenLoadHeadOfficeData extends BaseAction{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4086182780693420924L;
	private RevisedDCRGPenLoadHeadOfficeDataService revDcrgPenHeadDataService;
	private PensionAuthorizationOriginalService penAuthOriService;
	private RevisedPensionAuthorizationDao revisedPenAppAuthOrg;
	/*private PensionerPaymentOfficeService paymentservice1;*/
	//private PensionAuthorizationOriginalService paymentservice1;

	private List<Object[]> headOffRevDataList;
	private List<Object[]> headOffDataList2;
	private CommonSearchModel revHeaddata;
	private RevisedDCRGPensionHODao revisedDCRGPen;
	private String HiddenSelectedNo;		
	private OfficeId_service officeIdservice;	
	private PensionApplicationSearchModel revisedDcrgPenappsearch;
	private RevisedPensionAuthorizationService revisedPenAuthService;
	List<Object[]> myList=null;
	private UpdatedUserIdService updateservice;

	double noofhalfyear=0.0;
	NumberFormat df1=new DecimalFormat("######0");
	String pensiontype="";
	Integer revdcrgamt=0;
	Integer revcaldcrgamt=0;
	private List<Map> report=new ArrayList<Map>();
	private List<Map> reportnote=new ArrayList<Map>();


	private int empNo;
	private String empName;
	private String empGenger;
	private String empdob;
	private String empDesignation;
	private String empOffice;
	private int empolddapercentage;
	private int empppono;
	private int empgpono;
	private String residentaddress;
	private String namefromaddress;
	private String authorizedofficeraddress;
	private String letterno;
	private String lastworkoffiaddress;
	private String reference;
	private String paymentofficename;
	private String paymentofficeaddress;
	private String FromAddress;
	private String ResidentAddress;
	private String Authorizedofficer;
	private String LETTERNO;
	private String REFERENCE;
	private int olddcrgamount;
	private int empOfficeid;
	private int paymentOfficeid;
	private int newdapercentage;
	private int noofhalfyeardcrg;
	private int newdaamount;
	private float totdcrghalfyear;
	private String authorisedOfficerDesc;
	private int authorisedOfficerId;
	private Integer lasttotal;
	private Integer authOfficer;
	private String Datedon;
	//private float newdapercentage;




	private List<PensionAuthorisedOfficer_dao> penAuthorisedOfficerList;
	private List<PensionPaymentOffice_dao> payOfficeList;
	public String loadData()
	{
		System.out.println("Inside Load Data Method");		
		StringBuffer xmlString = new StringBuffer();		
		xmlString.append("<response>");
		xmlString.append("<command>LoadAllData</command>");		
		boolean flag=false;
		try
		{

			PrintWriter out = getResponse().getWriter();	
			headOffRevDataList=revDcrgPenHeadDataService.loadAllData();		

			for(Object[] tl: headOffRevDataList)
			{
				Object[] temp=tl;
				xmlString.append("<record>");					
				xmlString.append("<empNo>"+temp[0]+"</empNo>");				
				xmlString.append("<empName>"+temp[1]+"</empName>");
				xmlString.append("<design>"+temp[2]+"</design>");
				xmlString.append("<office>"+temp[3]+"</office>");						
				xmlString.append("</record>");	
				flag=true;
			}

			if(flag)
			{
				xmlString.append("<flag>true</flag>");	
			}
			else
			{
				xmlString.append("<flag>false</flag>");	
			}
			xmlString.append("</response>");
			getResponse().setContentType("text/xml");
			System.out.println(xmlString.toString());
			out.println(xmlString.toString());
			out.flush();
			out.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		return SUCCESS;

	}

	public String loadApplicationRevisedDa() throws IOException
	{


		Double damount;
		Integer lasttotalforda;


		try
		{
			//PrintWriter out = getResponse().getWriter();
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			int loginEmpId=empProfile.getEmployeeId();	
			System.out.println(loginEmpId);

			penAuthorisedOfficerList=new ArrayList<PensionAuthorisedOfficer_dao>();
			penAuthorisedOfficerList=penAuthOriService.getListOfAythorisedOfficer();

			headOffRevDataList=revDcrgPenHeadDataService.LoadEmployeeData(Integer.parseInt(HiddenSelectedNo));	

			for(Object[] tl: headOffRevDataList)
			{
				Object[] temp=tl;

				empNo=Integer.parseInt(temp[0].toString());	
				empName=temp[1].toString();
				if(temp[16].toString().equalsIgnoreCase("M"))
				{
					empGenger="MALE";
				}
				else
				{
					empGenger="FEMALE";

				}
				if(temp[4]!=null)
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					empdob=formatter.format(temp[4]);

				}
				else
				{
					empdob=temp[4].toString();

				}
				empDesignation=temp[2].toString();
				empOffice=temp[3].toString();
				empppono=Integer.parseInt(temp[6].toString());
				empgpono=Integer.parseInt(temp[8].toString());
				authOfficer = Integer.parseInt(temp[11]+"");

				ResidentAddress=temp[9].toString();
				namefromaddress=temp[10].toString();
				lastworkoffiaddress=temp[14].toString();
             
             
                
                
                
                
				//authorizedofficeraddress=temp[12].toString();
				letterno=temp[13].toString();
				reference=temp[15].toString();
				paymentofficename=temp[20].toString();
				paymentofficeaddress=temp[21].toString();
				empOfficeid=Integer.parseInt(temp[29].toString());
				paymentOfficeid=Integer.parseInt(temp[30].toString());


				lasttotalforda=Integer.parseInt(temp[19]+"");


				String dor="";
				if(!(temp[23]+"").equalsIgnoreCase("null"))
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(temp[23]);
					System.out.println("The vrs date"+dor);
				}
				else if(!(temp[24]+"").equalsIgnoreCase("null"))
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(temp[24]);
					System.out.println("The dedate date"+dor);
				}
				else
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(temp[22]);
					System.out.println("The retirement date"+dor);
				}


				if(!(dor.equalsIgnoreCase("null")))
				{
					newdapercentage=revDcrgPenHeadDataService.penAppHOForm1CalcdaSettingValData(dor);
				}

				empolddapercentage=Integer.parseInt(temp[5].toString());
				olddcrgamount=(Integer.parseInt(temp[7].toString()));
				

				//damount=(Float.parseFloat((lasttotalforda)+"")*((Float.parseFloat((newdapercentage)+"")/100)));
				//damount=lasttotalforda;
				damount=Double.parseDouble(Float.toString(newdapercentage));
				
				System.out.println("The da amount is"+damount);


				Integer lastbasic=0;
				Integer lastgrade=0;
				Integer lastspecial=0;
				Integer lastother=0;

				lastbasic=Integer.parseInt(temp[25].toString());
				lastgrade=Integer.parseInt(temp[27].toString());
				lastspecial=Integer.parseInt(temp[26].toString());
				lastother=Integer.parseInt(temp[28].toString());

				lasttotal=lastbasic+lastgrade+lastspecial+lastother;

				pensiontype=temp[17]+"";
				System.out.println("The pension type is"+pensiontype);

				if(!(pensiontype.equalsIgnoreCase("null")))
				{

					noofhalfyeardcrg=Integer.parseInt(temp[18]+"");
					if((pensiontype.equalsIgnoreCase("1"))|| (pensiontype.equalsIgnoreCase("2")) )
					{ 

						newdaamount=(int)Math.round((lasttotalforda*damount)/100);
						System.out.println("The new Da amount"+newdaamount);
						totdcrghalfyear=Float.parseFloat(0.25+"");
						System.out.println("totaldcrghalfyear"+totdcrghalfyear);
						revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
						
//						if(revcaldcrgamt>=1000000)
//						{
//							revcaldcrgamt=1000000;
//						}
						if(revcaldcrgamt>=2000000)
						{
							revcaldcrgamt=2000000;
						}
						System.out.println("The revcaldcrgamt"+revcaldcrgamt);


					}

					if(pensiontype.equalsIgnoreCase("3"))
					{
						newdaamount=(int)Math.round((lasttotalforda*damount)/100);
						totdcrghalfyear=Float.parseFloat(0.5+"");
						revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
//						if(revcaldcrgamt>=1000000)
//						{
//							revcaldcrgamt=1000000;
//						}
						if(revcaldcrgamt>=2000000)
						{
							revcaldcrgamt=2000000;
						}


					}
				}
				else
				{
					newdaamount=(int)Math.round((lasttotalforda*damount)/100);
					totdcrghalfyear=Float.parseFloat(0.0+"");
					revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
				}


			}
		}

		catch(Exception e)
		{
			return ERROR;
		}



		return SUCCESS;
	}
	
	

	
	
	@SuppressWarnings("unchecked")
	public String loadDataEmployeeRpt() 
	{

	
		Double damount;
		Integer lasttotalforda;
		try
		{
			headOffRevDataList=revDcrgPenHeadDataService.LoadEmployeeData(getEmpNo());		
			Map reportMap = new HashMap();
			String datedon = "";
			String letterno= "";
			String subject= "";
			String content= "";
			String content1= "";
			String prenametitle="";
			String effectdate="";
			String last_working_office_address="";
			String residentaddress="";
			Integer letternumbercount=5;
			String refletterno="";
			String daorderno="";
			
			Integer dcrgpensionamount=0;
			Integer olddcrgpensionamount=0;
			Integer remainingdcrgpensionamount=0;
			String toaddress="";



			constNumtoLetter n = new constNumtoLetter();
						

			for(Object[] tl: headOffRevDataList)
			{
				Object[] temp=tl;


				reportMap.put("EMP_NO",(BigDecimal)temp[0]);				
				reportMap.put("PPO_NO",temp[6]);
				System.out.println("The from addresss is"+getFromAddress());

				reportMap.put("NAME_FROM_ADDRESS",getFromAddress());
				reportMap.put("AUTHORIZED_OFFICER",getAuthorizedofficer());


				residentaddress=getResidentAddress();
				
				/*toaddress=last_working_office_address;
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
					*/
				//mainpd.setTO_ADDRESS(toaddress);
				

				
				last_working_office_address=getLastworkoffiaddress();
				
				int index = last_working_office_address.indexOf(',');
				//System.out.println("The value is"+index);
				if(index !=-1 )
				{
				
				System.out.println("The last working office address"+last_working_office_address);
				String[] add_split=last_working_office_address.split(",");
				
				/*if(!(last_working_office_address.equalsIgnoreCase("null")))
				{*/

				
				
				try{
					if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
					{
						System.out.println("Split 1>>>>>"+add_split[2]);
						reportMap.put("TO_ADDRESS3",add_split[2]+",");
					}

					if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
					{
						System.out.println("Split 1>>>>>"+add_split[2]);
						reportMap.put("TO_ADDRESS3",add_split[2]+",");
					}
				}
				catch(Exception ee){
					System.out.println("Error in:"+ee.getMessage());
				}
				reportMap.put("TO_ADDRESS1",add_split[0]+",");
				reportMap.put("TO_ADDRESS2",add_split[1]+",");
				}
				else
				{
				/*}*/

				reportMap.put("TO_ADDRESS",last_working_office_address);
				}
				//letternumbercount=letternumbercount+lettercount+1;

				letternumbercount=6;
				letterno=getLETTERNO();;
				//letterno="Letter No."+letterno+" - 3";
				letterno="Letter No."+letterno+" - "+letternumbercount;
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");

				//datedon=formatter1.format(getDatedon());
				//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
				System.out.println(getDatedon());
				datedon=getDatedon();
				letterno=letterno+" Dated "+datedon;
				
				DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
				String sub_ret_cont="";
				if((temp[16]+"").equalsIgnoreCase("M"))
				{
					prenametitle="Thiru.";
				}
				if((temp[16]+"").equalsIgnoreCase("F"))
				{
					if(!(temp[16]+"").equalsIgnoreCase("null"))
					{
						prenametitle="Tmt.";
					}
					else
					{
						prenametitle="Selvi.";
					}
				}
				
				lasttotalforda=Integer.parseInt(temp[19]+"");


				String dor="";
				if(!(temp[23]+"").equalsIgnoreCase("null"))
				{
					
					dor=formatter.format(temp[23]);
					sub_ret_cont="who  voluntarily retired";
					System.out.println("The vrs date"+dor);
				}
				else if(!(temp[24]+"").equalsIgnoreCase("null"))
				{
					
					dor=formatter.format(temp[24]);
					sub_ret_cont="who  death ";
					System.out.println("The dedate date"+dor);
				}
				else
				{
					
					dor=formatter.format(temp[22]);
					sub_ret_cont="who  retired ";
					System.out.println("The retirement date"+dor);
				}

				subject="Authorisation for the payment of Revised DCRG - in respect of "+prenametitle+temp[1]+", "+temp[2]+" " +
				sub_ret_cont+"on "+dor+" - Holder of PPO No."+temp[6]+"/TWAD.";
				reportMap.put("SUBJECT",subject);
				
				//System.out.println("The reference is"+getREFERENCE());
				refletterno="1.JCE(GI)Lr.no."+getREFERENCE();


        	
				if(!(dor.equalsIgnoreCase("null")))
				{//commented on 30/nov/2018
					//daorderno="2."+revDcrgPenHeadDataService.getdaorderno(dor);
					//daorderno="2.M.D's Proc.No. DA/Estt(per)/A1/2018/dt. 29.10.2018";
					daorderno="2. M.D's Proc.No.12031/Estt(Per)/A1/2019-1  dated 23.05.2019";
					newdapercentage=revDcrgPenHeadDataService.penAppHOForm1CalcdaSettingValData(dor);
					effectdate=revDcrgPenHeadDataService.getdaeffectdate(dor);

				}
				
				

				empolddapercentage=Integer.parseInt(temp[5].toString());
				olddcrgamount=(Integer.parseInt(temp[7].toString()));
				damount=Double.parseDouble(Float.toString(newdapercentage));
				//damount=(Float.parseFloat((lasttotalforda)+"")*((Float.parseFloat((newdapercentage)+"")/100)));
				System.out.println("The da amount is amount---->"+damount);
				System.out.println("The old dcrg amount---->"+olddcrgamount);

				Integer lastbasic=0;
				Integer lastgrade=0;
				Integer lastspecial=0;
				Integer lastother=0;

				lastbasic=Integer.parseInt(temp[25].toString());
				lastgrade=Integer.parseInt(temp[27].toString());
				lastspecial=Integer.parseInt(temp[26].toString());
				lastother=Integer.parseInt(temp[28].toString());

				lasttotal=lastbasic+lastgrade+lastspecial+lastother;

				pensiontype=temp[17]+"";
				System.out.println("The pension type is"+pensiontype);

				if(!(pensiontype.equalsIgnoreCase("null")))
				{

					noofhalfyeardcrg=Integer.parseInt(temp[18]+"");
					if((pensiontype.equalsIgnoreCase("1"))|| (pensiontype.equalsIgnoreCase("2")) )
					{ 

						newdaamount=(int)Math.round((lasttotalforda*damount)/100);
						System.out.println("The new Da amount"+newdaamount);
						totdcrghalfyear=Float.parseFloat(0.25+"");
						System.out.println("totaldcrghalfyear"+totdcrghalfyear);
						revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
//						if(revcaldcrgamt>=1000000)
//						{
//							revcaldcrgamt=1000000;
//						}
						if(revcaldcrgamt>=2000000)
						{
							revcaldcrgamt=2000000;
						}
						System.out.println("The revcaldcrgamt"+revcaldcrgamt);


					}

					if(pensiontype.equalsIgnoreCase("3"))
					{
						newdaamount=(int)Math.round((lasttotalforda*damount)/100);
						totdcrghalfyear=Float.parseFloat(0.5+"");
						revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));		
//						if(revcaldcrgamt>=1000000)
//						{
//							revcaldcrgamt=1000000;
//						}
						if(revcaldcrgamt>=2000000)
						{
							revcaldcrgamt=2000000;
						}


					}
				}
				else
				{
					newdaamount=(int)Math.round((lasttotalforda*damount)/100);
					totdcrghalfyear=Float.parseFloat(0.0+"");
					revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
				}

				dcrgpensionamount=revcaldcrgamt;
				olddcrgpensionamount=olddcrgamount;
				
				if (dcrgpensionamount>=olddcrgpensionamount)
				{
					remainingdcrgpensionamount=dcrgpensionamount-olddcrgpensionamount;
				}
				else
				{
					remainingdcrgpensionamount=0;
				}

				content="Due to revision of D.A. from "+empolddapercentage+" % to "+newdapercentage+" % as on "+effectdate+
				" the gratuity amount authorised for payment in the reference 1st cited needs revision and a " +
				"revised gratuity of Rs."+dcrgpensionamount+"/- is sanctioned to "+
				prenametitle+temp[1]+", "+temp[2]+" "+sub_ret_cont+"on " +dor+".";

				reportMap.put("CONTENT",content);


				content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
				"Rs."+remainingdcrgpensionamount+"/- (Rs."+dcrgpensionamount+" - "+olddcrgpensionamount+") "+n.rupess_to_word(remainingdcrgpensionamount)+
				" to "+prenametitle+temp[1]+", "+temp[2]+" being the difference amount of revised DCRG after duly " +
				"satisfying yourself about his identification. ";
				reportMap.put("CONTENT1",content1);

				String copyto1content1="";
				//copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress+" with a request to contact "+toaddress;
				copyto1content1="Copy to "+prenametitle+temp[1]+", "+temp[2]+", "+residentaddress;
				reportMap.put("COPY_TO1",copyto1content1);

				
				reportMap.put("REFERENCE",daorderno);
				reportMap.put("REFERENCE_LETTERNO",refletterno);    
				reportMap.put("LETTER_NO",letterno);
				reportMap.put("DATED_ON",datedon);
				

				report.add(reportMap);

			}




		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	public String loadDataEmployeeRptnote() 
	{

		//System.out.println("the employee no is"+getEmpNo());
		Double damount;
		Integer lasttotalforda;
		
		try
		{



			headOffRevDataList=revDcrgPenHeadDataService.LoadEmployeeData(getEmpNo());		
			Map reportMap = new HashMap();
			String datedon = "";
			String subject= "";
			String content= "";
			String content1= "";
			String prenametitle="";
			String effectdate="";
			String daorderno="";
			Integer dcrgpensionamount=0;
			Integer olddcrgpensionamount=0;
			Integer remainingdcrgpensionamount=0;
			String note="";
			String refletterno="";


			
			for(Object[] tl: headOffRevDataList)
			{
				Object[] temp=tl;
				
				
				
				DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
				String sub_ret_cont="";
				if((temp[16]+"").equalsIgnoreCase("M"))
				{
					prenametitle="Thiru.";
				}
				if((temp[16]+"").equalsIgnoreCase("F"))
				{
					if(!(temp[16]+"").equalsIgnoreCase("null"))
					{
						prenametitle="Tmt.";
					}
					else
					{
						prenametitle="Selvi.";
					}
				}
				
				lasttotalforda=Integer.parseInt(temp[19]+"");
				String dor="";
				if(!(temp[23]+"").equalsIgnoreCase("null"))
				{
					
					dor=formatter.format(temp[23]);
					sub_ret_cont="who voluntarily retired";
					//System.out.println("The vrs date"+dor);
				}
				else if(!(temp[24]+"").equalsIgnoreCase("null"))
				{
					
					dor=formatter.format(temp[24]);
					sub_ret_cont="who  Death ";
					//System.out.println("The dedate date"+dor);
				}
				else
				{
					
					dor=formatter.format(temp[22]);
					sub_ret_cont="who  retired ";
					//System.out.println("The retirement date"+dor);
				}
				
		
				
				if(!(dor.equalsIgnoreCase("null")))
				{
					daorderno="2."+revDcrgPenHeadDataService.getdaorderno(dor);
					newdapercentage=revDcrgPenHeadDataService.penAppHOForm1CalcdaSettingValData(dor);
					effectdate=revDcrgPenHeadDataService.getdaeffectdate(dor);

				}
				
				

				empolddapercentage=Integer.parseInt(temp[5].toString());
				olddcrgamount=(Integer.parseInt(temp[7].toString()));

				//damount=(Float.parseFloat((lasttotalforda)+"")*((Float.parseFloat((newdapercentage)+"")/100)));
				damount=Double.parseDouble(Float.toString(newdapercentage));
				System.out.println("The da amount is"+damount);
				System.out.println("The old dcrg amount->"+olddcrgamount);

				Integer lastbasic=0;
				Integer lastgrade=0;
				Integer lastspecial=0;
				Integer lastother=0;

				lastbasic=Integer.parseInt(temp[25].toString());
				lastgrade=Integer.parseInt(temp[27].toString());
				lastspecial=Integer.parseInt(temp[26].toString());
				lastother=Integer.parseInt(temp[28].toString());

				lasttotal=lastbasic+lastgrade+lastspecial+lastother;

				pensiontype=temp[17]+"";
				System.out.println("The pension type is"+pensiontype);

				if(!(pensiontype.equalsIgnoreCase("null")))
				{

					noofhalfyeardcrg=Integer.parseInt(temp[18]+"");
					if((pensiontype.equalsIgnoreCase("1"))|| (pensiontype.equalsIgnoreCase("2")) )
					{ 

						newdaamount=(int)Math.round((lasttotalforda*damount)/100);
						System.out.println("The new Da amount"+newdaamount);
						totdcrghalfyear=Float.parseFloat(0.25+"");
						System.out.println("totaldcrghalfyear"+totdcrghalfyear);
						revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
						System.out.println("The revcaldcrgamt -*-->"+revcaldcrgamt);
//						if(revcaldcrgamt>=1000000)
//						{
//							revcaldcrgamt=1000000;
//						}
						if(revcaldcrgamt>=2000000)
						{
							revcaldcrgamt=2000000;
						}
						
					    note="Note:Revised DCRG:("+lasttotal+"+"+newdaamount+")*("+noofhalfyeardcrg+")*("+totdcrghalfyear+")="+revcaldcrgamt;
						System.out.println("The revcaldcrgamt"+revcaldcrgamt);


					}

					if(pensiontype.equalsIgnoreCase("3"))
					{
						newdaamount=(int)Math.round((lasttotalforda*damount)/100);
						totdcrghalfyear=Float.parseFloat(0.5+"");
						revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
//						if(revcaldcrgamt>=1000000)
//						{
//							revcaldcrgamt=1000000;
//						}
						if(revcaldcrgamt>=2000000)
						{
							revcaldcrgamt=2000000;
						}
						note="Note:Revised DCRG:("+lasttotal+"+"+newdaamount+")*("+noofhalfyeardcrg+")*("+totdcrghalfyear+")="+revcaldcrgamt;


					}
				}
				else
				{
					newdaamount=(int)Math.round((lasttotalforda*damount)/100);
					totdcrghalfyear=Float.parseFloat(0.0+"");
					revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
					note="Note:Revised DCRG:("+lasttotal+"+"+newdaamount+")*("+noofhalfyeardcrg+")*("+totdcrghalfyear+")="+revcaldcrgamt;
				}

				dcrgpensionamount=revcaldcrgamt;
				olddcrgpensionamount=olddcrgamount;
				
				if (dcrgpensionamount>=olddcrgpensionamount)
				{
					remainingdcrgpensionamount=dcrgpensionamount-olddcrgpensionamount;
				}
				else
				{
					remainingdcrgpensionamount=0;
				}

				
				
				subject="Pension Establishment - Gratuity revision due to enhancement of Dearness Allowance from "+empolddapercentage+" % to "+newdapercentage+" %  as on "+effectdate+"-Reg";
				reportMap.put("SUBJECT",subject);
				DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
				datedon=formatter1.format(new Date());
				refletterno="1.Secy. GM Lr.No.  "+getREFERENCE();

				reportMap.put("LETTERNO",refletterno);
				reportMap.put("REFERENCE",daorderno);
				content="In the reference 2 nd cited the Dearness Allowance of the Board's employees has been raised from "+empolddapercentage+"%  to "+newdapercentage+"% with effect from "+effectdate+".";
				reportMap.put("CONTENT",content);

								
                BigDecimal daamt=new BigDecimal(df1.format(newdaamount));
				BigDecimal olddcrgamount=new BigDecimal(df1.format(olddcrgpensionamount));
				BigDecimal newdcrgamount=new BigDecimal(df1.format(dcrgpensionamount));
				BigDecimal diffdcrgamount=new BigDecimal(df1.format(remainingdcrgpensionamount));
				BigDecimal basicpay=new BigDecimal(lastbasic);
				BigDecimal gradepay=new BigDecimal(lastgrade);
				BigDecimal specialpay=new BigDecimal(lastspecial);
				BigDecimal otherpay=new BigDecimal(lastother);
				
				System.out.println("olddcrgamount--> "+olddcrgamount);
				String newdaper=newdapercentage+"%";
				reportMap.put("NEWDAPERCENTAGE",newdaper);
				reportMap.put("BASICPAY",basicpay);
				reportMap.put("GRADEPAY",gradepay);
				reportMap.put("SPECIALPAY",specialpay);
				reportMap.put("OTHERPAY",otherpay);
				reportMap.put("DAAMOUNT",daamt);
				reportMap.put("OLDDCRGAMOUNT",olddcrgamount);
				reportMap.put("NEWDCRGAMOUNT",newdcrgamount);
				reportMap.put("diffdcrgamount",diffdcrgamount);

				content1="As gratuity of "+prenametitle+temp[1]+", "+temp[2]+" " +sub_ret_cont+"on "+dor+" has been originally calculated taking into account the Dearness Allowance at "+empolddapercentage+"%," +
				"Now revised orders authorising for payment of difference amount of gratuity due to enhancement of Dearness Allowance from  "+empolddapercentage+"%"  +
				" to "+newdapercentage+"%  w.e.f "+effectdate+" may be issued, as per the calculation given below.";
				reportMap.put("CONTENT1",content1);
				reportMap.put("NOTE",note);

				reportnote.add(reportMap);
				

			}




		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	public String ReviseDCRGPensionDataFreeze()

	{
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			int loginEmpId=empProfile.getEmployeeId();

			boolean procedureFlag=false;
			System.out.println("The employee id is"+revisedPenAppAuthOrg.getEmpNo());
			procedureFlag=revDcrgPenHeadDataService.moveOldDCRGIntoHistory(revisedPenAppAuthOrg.getEmpNo());
			System.out.println("The processvalue is"+procedureFlag);
			if(procedureFlag==true)
			{

				headOffRevDataList=revDcrgPenHeadDataService.LoadEmployeeData(revisedPenAppAuthOrg.getEmpNo());		
				Map reportMap1 = new HashMap();
				String datedon = "";
				String letterno= "";
				String subject= "";
				String content= "";
				String content1= "";
				String prenametitle="";
				String effectdate="";
				String last_working_office_address="";
				String residentaddress="";
				Integer letternumbercount=5;
				String refletterno="";
				String daorderno="";
				Integer dcrgpensionamount=0;
				Integer olddcrgpensionamount=0;
				Integer remainingdcrgpensionamount=0;
				Double damount;
				Integer lasttotalforda;



				constNumtoLetter n = new constNumtoLetter();

				DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
				String updatedId=updateservice.getUpdateId(loginEmpId);


				int officeId = officeIdservice.getOfficeId(revisedPenAppAuthOrg.getEmpNo());
				
				RevisedPensionAuthorizationDao revisedPen = new RevisedPensionAuthorizationDao();
				System.out.println("The updatedid"+updatedId);
				System.out.println("The officeId"+officeId);
				//System.out.println(revisedPenAppAuthOrg.setDatedOn(formatter.format(new java.util.Date())));
				/*System.out.println("The empid is"+revisedPenAppAuthOrg.getEmpNo());
				System.out.println("The ppono is"+revisedPenAppAuthOrg.getPpoNo());
				System.out.println("The gpono is"+revisedPenAppAuthOrg.getGpoNo());
				System.out.println("The residentaddress is"+revisedPenAppAuthOrg.getResidentialAddress());
				System.out.println("The namefrom address is"+revisedPenAppAuthOrg.getNamefromAddress());
				System.out.println("The authorized officer"+revisedPenAppAuthOrg.getAuthorizedOfficer());
				System.out.println("The authorized address"+revisedPenAppAuthOrg.getAuthorizedOfficerAddress());
				System.out.println("The last work office"+revisedPenAppAuthOrg.getLastWorkOfficeAddress());
				System.out.println("The letter no"+revisedPenAppAuthOrg.getLetterNo());
				System.out.println("The reference no"+revisedPenAppAuthOrg.getReference());*/
				
				revisedPenAppAuthOrg.setDatedOn(revisedPenAppAuthOrg.getDatedOn());
				revisedPenAppAuthOrg.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
				revisedPenAppAuthOrg.setProcessStatus("Final");	
				revisedPenAppAuthOrg.setUpdateUser(updatedId);
				System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
				revDcrgPenHeadDataService.saveRecord(revisedPenAppAuthOrg);	 
				
				System.out.println("sssssssssssssssssssssssssssssssssss");
				for(Object[] tl: headOffRevDataList)
				{
					Object[] temp=tl;


					reportMap1.put("EMP_NO",(BigDecimal)temp[0]);				
					reportMap1.put("PPO_NO",temp[6]);
					System.out.println("The from addresss is"+getFromAddress());
					
					reportMap1.put("NAME_FROM_ADDRESS",revisedPenAppAuthOrg.getNamefromAddress());

					penAuthorisedOfficerList=new ArrayList<PensionAuthorisedOfficer_dao>();
					penAuthorisedOfficerList=penAuthOriService.getListOfAythorisedOfficer();
					String officerName = "";
					for(PensionAuthorisedOfficer_dao officer: penAuthorisedOfficerList)
					{
						if(officer.getAuthorisedOfficerId()==revisedPenAppAuthOrg.getAuthorizedOfficer())
							officerName = officer.getAuthorisedOfficerDesc();
					}
					reportMap1.put("AUTHORIZED_OFFICER",officerName);

					residentaddress=revisedPenAppAuthOrg.getResidentialAddress();
					
					
					/*last_working_office_address=getLastworkoffiaddress();
					
					int index = last_working_office_address.indexOf(',');
					//System.out.println("The value is"+index);
					if(index !=-1 )
					{
					
					System.out.println("The last working office address"+last_working_office_address);
					String[] add_split=last_working_office_address.split(",");
					
					if(!(last_working_office_address.equalsIgnoreCase("null")))
					{

					
					
					try{
						if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
						{
							System.out.println("Split 1>>>>>"+add_split[2]);
							reportMap.put("TO_ADDRESS3",add_split[2]+",");
						}

						if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
						{
							System.out.println("Split 1>>>>>"+add_split[2]);
							reportMap.put("TO_ADDRESS3",add_split[2]+",");
						}
					}
					catch(Exception ee){
						System.out.println("Error in:"+ee.getMessage());
					}
					reportMap.put("TO_ADDRESS1",add_split[0]+",");
					reportMap.put("TO_ADDRESS2",add_split[1]+",");
					}
					else
					{
					}

					reportMap.put("TO_ADDRESS",last_working_office_address);
					}
					
					*/

					last_working_office_address=revisedPenAppAuthOrg.getLastWorkOfficeAddress();
					
					int index = last_working_office_address.indexOf(',');
					//System.out.println("The value is"+index);
					if(index !=-1 )
					{
					
					System.out.println("The last working office address"+last_working_office_address);
					
					/*if(!(last_working_office_address.equalsIgnoreCase("null")))
					{*/

					String[] add_split=last_working_office_address.split(",");
					
					try{
						if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
						{
							System.out.println("Split 1>>>>>"+add_split[2]);
							reportMap1.put("TO_ADDRESS3",add_split[2]+"");
						}

						if(!(add_split[2].equalsIgnoreCase(null)) || !(add_split[2].equalsIgnoreCase("")) || !(add_split[2].equalsIgnoreCase("null")))
						{
							System.out.println("Split 1>>>>>"+add_split[2]);
							reportMap1.put("TO_ADDRESS3",add_split[2]+"");
						}
					}
					catch(Exception ee){
						System.out.println("Error in:"+ee.getMessage());
					}
					reportMap1.put("TO_ADDRESS1",add_split[0]+",");
					reportMap1.put("TO_ADDRESS2",add_split[1]+",");
					/*}*/
					}
					else
					{
						reportMap1.put("TO_ADDRESS",last_working_office_address);
					}

					//letternumbercount=letternumbercount+lettercount+1;

					letternumbercount=6;
					letterno=revisedPenAppAuthOrg.getLetterNo();
					//letterno="Letter No."+letterno+" - 3";
					letterno="Letter No."+letterno+" - "+letternumbercount;
					//DateFormat formatter1= new SimpleDateFormat("dd/MM/yyyy");
					System.out.println("The value freeeze is"+revisedPenAppAuthOrg.getDatedOn());

					datedon=getDatedon();
					//letterno="Letter No."+letterno+" - 3 Dated "+datedon;
					letterno=letterno+" Dated "+revisedPenAppAuthOrg.getDatedOn();

					String sub_ret_cont="";
					if((temp[16]+"").equalsIgnoreCase("M"))
					{
						prenametitle="Thiru.";
					}
					if((temp[16]+"").equalsIgnoreCase("F"))
					{
						if(!(temp[16]+"").equalsIgnoreCase("null"))
						{
							prenametitle="Tmt.";
						}
						else
						{
							prenametitle="Selvi.";
						}
					}
					
					lasttotalforda=Integer.parseInt(temp[19]+"");


					String dor="";
					if(!(temp[23]+"").equalsIgnoreCase("null"))
					{
						
						dor=formatter.format(temp[23]);
						sub_ret_cont="who  voluntarily retired";
						//System.out.println("The vrs date"+dor);
					}
					else if(!(temp[24]+"").equalsIgnoreCase("null"))
					{
						
						dor=formatter.format(temp[24]);
						sub_ret_cont="who  death ";
						//System.out.println("The dedate date"+dor);
					}
					else
					{
						
						dor=formatter.format(temp[22]);
						sub_ret_cont="who  retired ";
						//System.out.println("The retirement date"+dor);
					}

					subject="Authorisation for the payment of Revised DCRG - in respect of "+prenametitle+temp[1]+", "+temp[2]+" " +
					sub_ret_cont+"on "+dor+" - Holder of PPO No."+temp[6]+"/TWAD.";
					reportMap1.put("SUBJECT",subject);
					System.out.println("The reference is"+getREFERENCE());
					refletterno="1.JCE(GI)Lr.no."+revisedPenAppAuthOrg.getReference();


	        	
					if(!(dor.equalsIgnoreCase("null")))
					{
						daorderno="2."+revDcrgPenHeadDataService.getdaorderno(dor);
						newdapercentage=revDcrgPenHeadDataService.penAppHOForm1CalcdaSettingValData(dor);
						effectdate=revDcrgPenHeadDataService.getdaeffectdate(dor);

					}
					
					

					empolddapercentage=Integer.parseInt(temp[5].toString());
					olddcrgamount=(Integer.parseInt(temp[7].toString()));
					damount=Double.parseDouble(Float.toString(newdapercentage));
					//damount=(Float.parseFloat((lasttotalforda)+"")*((Float.parseFloat((newdapercentage)+"")/100)));
					//System.out.println("The da amount is"+damount);


					Integer lastbasic=0;
					Integer lastgrade=0;
					Integer lastspecial=0;
					Integer lastother=0;

					lastbasic=Integer.parseInt(temp[25].toString());
					lastgrade=Integer.parseInt(temp[27].toString());
					lastspecial=Integer.parseInt(temp[26].toString());
					lastother=Integer.parseInt(temp[28].toString());

					lasttotal=lastbasic+lastgrade+lastspecial+lastother;

					pensiontype=temp[17]+"";
					System.out.println("The pension type is"+pensiontype);

					if(!(pensiontype.equalsIgnoreCase("null")))
					{

						noofhalfyeardcrg=Integer.parseInt(temp[18]+"");
						if((pensiontype.equalsIgnoreCase("1"))|| (pensiontype.equalsIgnoreCase("2")) )
						{ 

							newdaamount=(int)Math.round((lasttotalforda*damount)/100);
							System.out.println("The new Da amount"+newdaamount);
							totdcrghalfyear=Float.parseFloat(0.25+"");
							System.out.println("totaldcrghalfyear"+totdcrghalfyear);
							revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
//							if(revcaldcrgamt>=1000000)
//							{
//								revcaldcrgamt=1000000;
//							}
							if(revcaldcrgamt>=2000000)
							{
								revcaldcrgamt=2000000;
							}
							System.out.println("The revcaldcrgamt"+revcaldcrgamt);


						}

						if(pensiontype.equalsIgnoreCase("3"))
						{
							newdaamount=(int)Math.round((lasttotalforda*damount)/100);
							totdcrghalfyear=Float.parseFloat(0.5+"");
							revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
//							if(revcaldcrgamt>=1000000)
//							{
//								revcaldcrgamt=1000000;
//							}
							if(revcaldcrgamt>=2000000)
							{
								revcaldcrgamt=2000000;
							}


						}
					}
					else
					{
						newdaamount=(int)Math.round((lasttotalforda*damount)/100);
						totdcrghalfyear=Float.parseFloat(0.0+"");
						revcaldcrgamt=Math.round((lasttotal+newdaamount)*(totdcrghalfyear)*(noofhalfyeardcrg));	
					}

					dcrgpensionamount=revcaldcrgamt;
					olddcrgpensionamount=olddcrgamount;
					
					if (dcrgpensionamount>=olddcrgpensionamount)
					{
						remainingdcrgpensionamount=dcrgpensionamount-olddcrgpensionamount;
					}
					else
					{
						remainingdcrgpensionamount=0;
					}

					content="Due to revision of D.A. from "+empolddapercentage+" % to "+newdapercentage+" % as on "+effectdate+
					" the gratuity amount authorised for payment in the reference 1st cited needs revision and a " +
					"revised gratuity of Rs."+dcrgpensionamount+"/- is sanctioned to "+
					prenametitle+temp[1]+", "+temp[2]+" "+sub_ret_cont+"on " +dor+".";

					reportMap1.put("CONTENT",content);


					content1="I request you to make arrangement for the payment from the TWAD Board funds the sum of " +
					"Rs."+remainingdcrgpensionamount+"/- (Rs."+dcrgpensionamount+" - "+olddcrgpensionamount+") "+n.rupess_to_word(remainingdcrgpensionamount)+
					" to "+prenametitle+temp[1]+", "+temp[2]+" being the difference amount of revised DCRG after duly " +
					"satisfying yourself about his identification. ";
					reportMap1.put("CONTENT1",content1);

					String copyto1content1="";
					//copyto1content1="Copy to "+prenametitle+tmp[1]+", "+tmp[21]+" "+residentaddress+" with a request to contact "+toaddress;
					copyto1content1="Copy to "+prenametitle+temp[1]+", "+temp[2]+", "+residentaddress;
					reportMap1.put("COPY_TO1",copyto1content1);

					
					reportMap1.put("REFERENCE",daorderno);
					reportMap1.put("REFERENCE_LETTERNO",refletterno);    
					reportMap1.put("LETTER_NO",letterno);
					reportMap1.put("DATED_ON",datedon);
					
					String signature="";
					signature="Sd....";

					String content2="/t.c.f.b.o/";

					String content3="Administrative Officer,";
					String content4="TWAD Board,Head Office,Chennai-5";

					reportMap1.put("SIGNATURE",signature);
					reportMap1.put("CONTENT2",content2);
					reportMap1.put("CONTENT3",content3);
					reportMap1.put("CONTENT4",content4);
					
					revDcrgPenHeadDataService.updateNewDCRGIntoHeadOfficeData(dcrgpensionamount, newdaamount, newdapercentage,revisedPenAppAuthOrg.getEmpNo()+"", updatedId);

					report.add(reportMap1);

				}
			


			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}


	
	public String loadDataEmployee()
	{

		//System.out.println("SERACH FORM SUBMIT FOR HEAD OFFICE DATA.....>>>>>>>>>"+empNo);
		StringBuffer xmlString = new StringBuffer();		
		xmlString.append("<response>");
		xmlString.append("<command>LoadEmployeeData</command>");		
		boolean flag=false;
		int dapercentage=0;
		float daamount;
		try
		{
			PrintWriter out = getResponse().getWriter();

			headOffRevDataList=revDcrgPenHeadDataService.LoadEmployeeData(empNo);		

			for(Object[] tl: headOffRevDataList)
			{
				Object[] temp=tl;
				xmlString.append("<record>");					
				xmlString.append("<empNo>"+temp[0]+"</empNo>");				
				xmlString.append("<empName>"+temp[1]+"</empName>");
				xmlString.append("<design>"+temp[2]+"</design>");
				xmlString.append("<office>"+temp[3]+"</office>");
				if(temp[4]!=null)
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					String dob=formatter.format(temp[4]);
					xmlString.append("<dob>"+dob+"</dob>");
				}
				else
				{
					xmlString.append("<dob>"+temp[4]+"</dob>");
				}

				xmlString.append("<dapert>"+temp[5]+"</dapert>");
				xmlString.append("<ppono>"+temp[6]+"</ppono>");
				xmlString.append("<dcrgamount>"+temp[7]+"</dcrgamount>");
				xmlString.append("<gpono>"+temp[8]+"</gpono>");
				xmlString.append("<residentaddr>"+temp[9]+"</residentaddr>");
				xmlString.append("<namefromaddr>"+temp[10]+"</namefromaddr>");
				xmlString.append("<authofficer>"+temp[11]+"</authofficer>");
				xmlString.append("<authoffaddr>"+temp[12]+"</authoffaddr>");
				xmlString.append("<letterno>"+temp[13]+"</letterno>");
				xmlString.append("<lastworkoffiaddr>"+temp[14]+"</lastworkoffiaddr>");
				xmlString.append("<reference>"+temp[15]+"</reference>");
				xmlString.append("<gender>"+temp[16]+"</gender>");
				xmlString.append("<paymentofficename>"+temp[20]+"</paymentofficename>");
				xmlString.append("<paymentofficeaddress>"+temp[21]+"</paymentofficeaddress>");
				xmlString.append("<dor>"+temp[22]+"</dor>");
				xmlString.append("<vrs>"+temp[23]+"</vrs>");
				xmlString.append("<deathdate>"+temp[24]+"</deathdate>");
				xmlString.append("<officeid>"+temp[29]+"</officeid>");
				xmlString.append("<paymentofficeid>"+temp[30]+"</paymentofficeid>");


				String dor="";
				if(!(temp[23]+"").equalsIgnoreCase("null"))
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(temp[23]);
					System.out.println("The vrs date"+dor);
				}
				else if(!(temp[24]+"").equalsIgnoreCase("null"))
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(temp[24]);
					System.out.println("The dedate date"+dor);
				}
				else
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(temp[22]);
					System.out.println("The retirement date"+dor);
				}


				if(!(dor.equalsIgnoreCase("null")))
				{
					dapercentage=revDcrgPenHeadDataService.penAppHOForm1CalcdaSettingValData(dor);
				}



				xmlString.append("<newda>"+dapercentage+"</newda>");

				pensiontype=temp[17]+"";
				noofhalfyear=Double.parseDouble(temp[18]+"");
				revdcrgamt=Integer.parseInt(temp[19]+"");
				daamount=Math.round((Float.parseFloat((temp[19])+"")*((Float.parseFloat((dapercentage)+"")/100))));
				System.out.println("Thd Da Percentage"+daamount);
				System.out.println("Thd Da Percentage"+dapercentage);

				if(!(pensiontype.equalsIgnoreCase("null")))
				{
					System.out.println(pensiontype);
					xmlString.append("<noofhalfyeardcrg>"+Integer.parseInt(temp[18]+"")+"</noofhalfyeardcrg>");
					xmlString.append("<revdcrgamt>"+Integer.parseInt(temp[19]+"")+"</revdcrgamt>");

					if((pensiontype.equalsIgnoreCase("1"))|| (pensiontype.equalsIgnoreCase("2")) )
					{ 
						System.out.println(pensiontype);
						xmlString.append("<daamount>"+df1.format(daamount)+"</daamount>");
						revcaldcrgamt=Integer.parseInt(df1.format(((revdcrgamt+daamount)*(noofhalfyear)*0.25)));
						System.out.println("The revcaldcrgamt"+revcaldcrgamt);

						xmlString.append("<tothalfyear>"+0.25+"</tothalfyear>");
						xmlString.append("<revcaldcrgamt>"+revcaldcrgamt+"</revcaldcrgamt>");
					}

					if(pensiontype.equalsIgnoreCase("3"))
					{
						System.out.println("3"+revcaldcrgamt);
						xmlString.append("<daamount>"+df1.format(daamount)+"</daamount>");
						revcaldcrgamt=Integer.parseInt(df1.format(((revdcrgamt+daamount)*(noofhalfyear)*0.5)));
						System.out.println("The revcaldcrgamt else"+revcaldcrgamt);

						xmlString.append("<tothalfyear>"+0.5+"</tothalfyear>");
						xmlString.append("<revcaldcrgamt>"+revcaldcrgamt+"</revcaldcrgamt>");

					}
				}
				else
				{
					System.out.println("The final ele revcaldcrgamt"+revcaldcrgamt);
					xmlString.append("<noofhalfyeardcrg>"+Integer.parseInt(temp[18]+"")+"</noofhalfyeardcrg>");
					xmlString.append("<daamount>"+df1.format(daamount)+"</daamount>");
					xmlString.append("<revdcrgamt>"+Integer.parseInt(temp[19]+"")+"</revdcrgamt>");
					xmlString.append("<tothalfyear>"+0.0+"</tothalfyear>");
					xmlString.append("<revcaldcrgamt>"+0+"</revcaldcrgamt>");
				}

				xmlString.append("</record>");	
				flag=true;
			}

			if(flag)
			{
				xmlString.append("<flag>true</flag>");	
			}
			else
			{
				xmlString.append("<flag>false</flag>");	
			}
			xmlString.append("</response>");
			getResponse().setContentType("text/xml");
			System.out.println(xmlString.toString());
			out.println(xmlString.toString());
			out.flush();
			out.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		return SUCCESS;

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



	public String searchData()
	{
		System.out.println("Inside Search Data Method");		
		StringBuffer xmlString = new StringBuffer();		
		xmlString.append("<response>");
		xmlString.append("<command>LoadSearchData</command>");		
		boolean flag=false;
		try
		{

			PrintWriter out = getResponse().getWriter();			
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			int empId=empProfile.getEmployeeId();

			String keyword =revHeaddata.getSearchKeyword().trim();
			String option =revHeaddata.getSearchOption().trim();

			headOffDataList2=revDcrgPenHeadDataService.searchData(option, keyword, empId);		
			System.out.println("SIZE22==="+headOffDataList2.size());
			for(Object[] tl: headOffDataList2)
			{
				Object[] temp=tl;
				xmlString.append("<record>");					
				xmlString.append("<empNo>"+temp[0]+"</empNo>");				
				xmlString.append("<empName>"+temp[1]+"</empName>");
				xmlString.append("<design>"+temp[2]+"</design>");
				xmlString.append("<office>"+temp[3]+"</office>");						
				xmlString.append("</record>");	
				flag=true;
			}

			if(flag)
			{
				xmlString.append("<flag>true</flag>");	
			}
			else
			{
				xmlString.append("<flag>false</flag>");	
			}
			xmlString.append("</response>");
			getResponse().setContentType("text/xml");
			System.out.println(xmlString.toString());
			out.println(xmlString.toString());
			out.flush();
			out.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public String loadApplicationData()
	{
		System.out.println("SERACH FORM SUBMIT.....>>>>>>>>>"+HiddenSelectedNo);
		StringBuffer xmlString = new StringBuffer();

		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		boolean myFlag=false;
		try
		{
			PrintWriter out = getResponse().getWriter();
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			int loginEmpId=empProfile.getEmployeeId();		    

		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}





	public String loadHeadOfficeData()
	{
		String selectedId=revisedDcrgPenappsearch.getEmpId()+"";
		System.out.println("SERACH FORM SUBMIT FOR HEAD OFFICE DATA.....>>>>>>>>>"+selectedId);
		StringBuffer xmlString = new StringBuffer();

		xmlString.append("<response>");
		xmlString.append("<command>Get</command>");
		boolean myFlag=false;
		try
		{
			PrintWriter out = getResponse().getWriter();
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			int loginEmpId=empProfile.getEmployeeId();					    


			myList=revDcrgPenHeadDataService.penAppHOForm1MstValData(loginEmpId,selectedId);


			int dapercentage=0;
			if(myList.size()>0)
			{				
				for(Object[] tl: myList)
				{
					Object[] temp=tl;
					xmlString.append("<record>");					
					xmlString.append("<empid>"+temp[0]+"</empid>");
					xmlString.append("<empname>"+temp[1]+"</empname>");
					xmlString.append("<empinit>"+temp[2]+"</empinit>");
					xmlString.append("<gpfno>"+temp[3]+"</gpfno>");

					if(temp[4]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dob=formatter.format(temp[4]);
						xmlString.append("<dob>"+dob+"</dob>");
					}
					else
					{
						xmlString.append("<dob>"+temp[4]+"</dob>");
					}

					xmlString.append("<gender>"+temp[5]+"</gender>");
					xmlString.append("<officename>"+temp[6]+"</officename>");
					xmlString.append("<designation>"+temp[7]+"</designation>");					
					if(temp[12]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String doj=formatter.format(temp[12]);
						xmlString.append("<doj>"+doj+"</doj>");
					}
					else
					{
						xmlString.append("<doj>"+temp[12]+"</doj>");
					}
					xmlString.append("<grade>"+temp[13]+"</grade>");
					xmlString.append("<fromsession>"+temp[14]+"</fromsession>");
					if(temp[15]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String doj=formatter.format(temp[15]);
						xmlString.append("<doj1>"+doj+"</doj1>");
					}
					else
					{
						xmlString.append("<doj1>"+temp[15]+"</doj1>");
					}
					xmlString.append("<fromsession1>"+temp[16]+"</fromsession1>");

					if(temp[17]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dor=formatter.format(temp[17]);
						xmlString.append("<retiredate>"+dor+"</retiredate>");
						dapercentage=revDcrgPenHeadDataService.penAppHOForm1CalcdaSettingValData(dor);
					}
					else
					{
						xmlString.append("<retiredate>"+temp[17]+"</retiredate>");
					}					
					xmlString.append("<officeid>"+temp[9]+"</officeid>");
					xmlString.append("<desigid>"+temp[10]+"</desigid>");
					xmlString.append("<desigservgrp>"+temp[11]+"</desigservgrp>");				





					xmlString.append("</record>");

					myFlag=true;

				}
				if(myFlag) 
				{
					xmlString.append("<flag>true</flag>");
				}
				else 
				{
					xmlString.append("<flag>false</flag>");
				}


				xmlString.append("</response>");

				getResponse().setContentType("text/xml");
				out.println(xmlString.toString());
				System.out.println(xmlString.toString());
				out.flush();
				out.close();

			}			
		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}
	

	public String loadrevPenAppHOOldMstValData()
	{
		int loginEmpId=0;
		List<Object[]> myOldList=null;		
		StringBuffer oldxmlString = new StringBuffer();

		oldxmlString.append("<oldresponse>");
		oldxmlString.append("<oldcommand>Get</oldcommand>");
		boolean oldmyFlag=false;
		try
		{
			PrintWriter out = getResponse().getWriter();	
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			String searchEmpId=revisedDcrgPenappsearch.getEmpId()+"";
			myOldList=revDcrgPenHeadDataService.revpenAppHOOldMstValData(searchEmpId);


			if(myOldList.size()>0)
			{				
				for(Object[] oldtl: myOldList)
				{
					Object[] oldtemp=oldtl;
					oldxmlString.append("<oldrecord>");					
					oldxmlString.append("<EMP_ID>"+oldtemp[0]+"</EMP_ID>");					
					oldxmlString.append("<PENSION_TYPE>"+oldtemp[1]+"</PENSION_TYPE>");
					if(oldtemp[2]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dop=formatter.format(oldtemp[2]);
						oldxmlString.append("<DATE_OF_PROVINC>"+dop+"</DATE_OF_PROVINC>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_PROVINC>"+oldtemp[2]+"</DATE_OF_PROVINC>");
					}

					if(oldtemp[3]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dore=formatter.format(oldtemp[3]);
						oldxmlString.append("<DATE_OF_REG_ESTAB>"+dore+"</DATE_OF_REG_ESTAB>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_REG_ESTAB>"+oldtemp[3]+"</DATE_OF_REG_ESTAB>");
					}					
					if(oldtemp[4]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dos=formatter.format(oldtemp[4]);
						oldxmlString.append("<DATE_OF_SELECTION>"+dos+"</DATE_OF_SELECTION>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_SELECTION>"+oldtemp[4]+"</DATE_OF_SELECTION>");
					}					
					if(oldtemp[5]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dosp=formatter.format(oldtemp[5]);
						oldxmlString.append("<DATE_OF_SPECIAL>"+dosp+"</DATE_OF_SPECIAL>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_SPECIAL>"+oldtemp[5]+"</DATE_OF_SPECIAL>");
					}					
					if(oldtemp[6]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dovrs=formatter.format(oldtemp[6]);
						oldxmlString.append("<DATE_OF_VRS>"+dovrs+"</DATE_OF_VRS>");
					}
					else
					{
						oldxmlString.append("<DATE_OF_VRS>"+oldtemp[6]+"</DATE_OF_VRS>");
					}

					oldxmlString.append("<COMM_OPTED>"+oldtemp[7]+"</COMM_OPTED>");
					oldxmlString.append("<COMM_FACTOR_ONRTHIRD>"+oldtemp[8]+"</COMM_FACTOR_ONRTHIRD>");
					oldxmlString.append("<COM_FACTOR_PERT>"+oldtemp[9]+"</COM_FACTOR_PERT>");
					oldxmlString.append("<WCE_SERV_DAYS>"+oldtemp[10]+"</WCE_SERV_DAYS>");
					oldxmlString.append("<WCE_SERV_MONTH>"+oldtemp[11]+"</WCE_SERV_MONTH>");
					oldxmlString.append("<WCE_SERV_YEAR>"+oldtemp[12]+"</WCE_SERV_YEAR>");
					oldxmlString.append("<WCE_SERV_FLAG>"+oldtemp[13]+"</WCE_SERV_FLAG>");
					oldxmlString.append("<WCE_SERV_COUNT_FLAG>"+oldtemp[14]+"</WCE_SERV_COUNT_FLAG>");
					oldxmlString.append("<CONTINGENT_SERV_FLAG>"+oldtemp[15]+"</CONTINGENT_SERV_FLAG>");
					oldxmlString.append("<CONTINGENT_SERV_DAYS>"+oldtemp[16]+"</CONTINGENT_SERV_DAYS>");
					oldxmlString.append("<CONTINGENT_SERV_MONTH>"+oldtemp[17]+"</CONTINGENT_SERV_MONTH>");					
					oldxmlString.append("<CONTINGENT_SERV_YEAR>"+oldtemp[18]+"</CONTINGENT_SERV_YEAR>");
					oldxmlString.append("<NON_PROV_SERV_DAYS>"+oldtemp[19]+"</NON_PROV_SERV_DAYS>");
					oldxmlString.append("<NON_PROV_SERV_MONTH>"+oldtemp[20]+"</NON_PROV_SERV_MONTH>");
					oldxmlString.append("<NON_PROV_SERV_YEAR>"+oldtemp[21]+"</NON_PROV_SERV_YEAR>");
					oldxmlString.append("<EOL_DAYS>"+oldtemp[22]+"</EOL_DAYS>");
					oldxmlString.append("<EOL_MONTH>"+oldtemp[23]+"</EOL_MONTH>");
					oldxmlString.append("<EOL_YEAR>"+oldtemp[24]+"</EOL_YEAR>");
					oldxmlString.append("<SUSPENSION_DAYS>"+oldtemp[25]+"</SUSPENSION_DAYS>");
					oldxmlString.append("<SUSPENSION_MONTH>"+oldtemp[26]+"</SUSPENSION_MONTH>");
					oldxmlString.append("<SUSPENSION_YEAR>"+oldtemp[27]+"</SUSPENSION_YEAR>");
					oldxmlString.append("<BOY_SERV_DAYS>"+oldtemp[28]+"</BOY_SERV_DAYS>");
					oldxmlString.append("<BOY_SERV_MONTH>"+oldtemp[29]+"</BOY_SERV_MONTH>");
					oldxmlString.append("<BOY_SERV_YEAR>"+oldtemp[30]+"</BOY_SERV_YEAR>");
					oldxmlString.append("<OVERSTAY_LEAVE_DAYS>"+oldtemp[31]+"</OVERSTAY_LEAVE_DAYS>");
					oldxmlString.append("<OVERSTAY_LEAVE_MONTH>"+oldtemp[32]+"</OVERSTAY_LEAVE_MONTH>");
					oldxmlString.append("<OVERSTAY_LEAVE_YEAR>"+oldtemp[33]+"</OVERSTAY_LEAVE_YEAR>");
					oldxmlString.append("<NOT_REG_LEAVE_DAYS>"+oldtemp[34]+"</NOT_REG_LEAVE_DAYS>");
					oldxmlString.append("<NOT_REG_LEAVE_MONTH>"+oldtemp[35]+"</NOT_REG_LEAVE_MONTH>");
					oldxmlString.append("<NOT_REG_LEAVE_YEAR>"+oldtemp[36]+"</NOT_REG_LEAVE_YEAR>");
					oldxmlString.append("<APPRENTICE_DAYS>"+oldtemp[37]+"</APPRENTICE_DAYS>");
					oldxmlString.append("<APPRENTICE_MONTH>"+oldtemp[38]+"</APPRENTICE_MONTH>");
					oldxmlString.append("<APPRENTICE_YEAR>"+oldtemp[39]+"</APPRENTICE_YEAR>");
					oldxmlString.append("<NOT_SERV_VERIFY_DAYS>"+oldtemp[40]+"</NOT_SERV_VERIFY_DAYS>");
					oldxmlString.append("<NOT_SERV_VERIFY_MONTH>"+oldtemp[41]+"</NOT_SERV_VERIFY_MONTH>");
					oldxmlString.append("<NOT_SERV_VERIFY_YEAR>"+oldtemp[42]+"</NOT_SERV_VERIFY_YEAR>");
					oldxmlString.append("<FOREIGN_SERV_DAYS>"+oldtemp[43]+"</FOREIGN_SERV_DAYS>");
					oldxmlString.append("<FOREIGN_SERV_MONTH>"+oldtemp[44]+"</FOREIGN_SERV_MONTH>");
					oldxmlString.append("<FOREIGN_SERV_YEAR>"+oldtemp[45]+"</FOREIGN_SERV_YEAR>");
					oldxmlString.append("<LAST_BASIC_PAY>"+oldtemp[46]+"</LAST_BASIC_PAY>");
					oldxmlString.append("<LAST_SPECIAL_PAY>"+oldtemp[47]+"</LAST_SPECIAL_PAY>");
					oldxmlString.append("<LAST_GRADE_PAY>"+oldtemp[48]+"</LAST_GRADE_PAY>");
					oldxmlString.append("<LAST_OTHER_PAY1>"+oldtemp[49]+"</LAST_OTHER_PAY1>");
					oldxmlString.append("<LAST_OTHER_PAY2>"+oldtemp[50]+"</LAST_OTHER_PAY2>");
					oldxmlString.append("<LAST_OTHER_PAY3>"+oldtemp[51]+"</LAST_OTHER_PAY3>");
					oldxmlString.append("<PENSION_AMOUNT>"+oldtemp[52]+"</PENSION_AMOUNT>");
					oldxmlString.append("<DCRG_AMOUNT>"+oldtemp[53]+"</DCRG_AMOUNT>");
					oldxmlString.append("<NO_OF_HALFYEAR_PENSION>"+oldtemp[54]+"</NO_OF_HALFYEAR_PENSION>");
					oldxmlString.append("<NO_OF_HALFYEAR_DCRG>"+oldtemp[55]+"</NO_OF_HALFYEAR_DCRG>");
					oldxmlString.append("<TOTAL_COMMUTED_AMOUNT>"+oldtemp[56]+"</TOTAL_COMMUTED_AMOUNT>");
					oldxmlString.append("<REDUCED_PENSION_AMOUNT>"+oldtemp[57]+"</REDUCED_PENSION_AMOUNT>");
					oldxmlString.append("<FAMILY_PENSION_50_AMT>"+oldtemp[58]+"</FAMILY_PENSION_50_AMT>");
					oldxmlString.append("<FAMILY_PENSION_30_AMT>"+oldtemp[59]+"</FAMILY_PENSION_30_AMT>");
					oldxmlString.append("<DA_AMOUNT>"+oldtemp[60]+"</DA_AMOUNT>");
					oldxmlString.append("<COMMUTED_VALUE>"+oldtemp[61]+"</COMMUTED_VALUE>");
					oldxmlString.append("<COMMUTATION_PEN_AMOUNT>"+oldtemp[62]+"</COMMUTATION_PEN_AMOUNT>");
					oldxmlString.append("<ACTUAL_SER_YEAR>"+oldtemp[63]+"</ACTUAL_SER_YEAR>");
					oldxmlString.append("<ACTUAL_SER_MON>"+oldtemp[64]+"</ACTUAL_SER_MON>");
					oldxmlString.append("<ACTUAL_SER_DAYS>"+oldtemp[65]+"</ACTUAL_SER_DAYS>");
					oldxmlString.append("<NET_SER_YEAR>"+oldtemp[66]+"</NET_SER_YEAR>");
					oldxmlString.append("<NET_SER_MON>"+oldtemp[67]+"</NET_SER_MON>");
					oldxmlString.append("<NET_SER_DAYS>"+oldtemp[68]+"</NET_SER_DAYS>");
					oldxmlString.append("<TOT_NON_QUAL_SER_YEAR>"+oldtemp[69]+"</TOT_NON_QUAL_SER_YEAR>");
					oldxmlString.append("<TOT_NON_QUAL_SER_MON>"+oldtemp[70]+"</TOT_NON_QUAL_SER_MON>");
					oldxmlString.append("<TOT_NON_QUAL_SER_DAYS>"+oldtemp[71]+"</TOT_NON_QUAL_SER_DAYS>");
					oldxmlString.append("<SCALE_OF_PAY>"+oldtemp[72]+"</SCALE_OF_PAY>");
					oldxmlString.append("<WEIGHTAGE_YEAR>"+oldtemp[73]+"</WEIGHTAGE_YEAR>");
					oldxmlString.append("<WEIGHTAGE_MONTH>"+oldtemp[74]+"</WEIGHTAGE_MONTH>");
					oldxmlString.append("<WEIGHTAGE_DAYS>"+oldtemp[75]+"</WEIGHTAGE_DAYS>");

					if(oldtemp[76]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String famuptoseven=formatter.format(oldtemp[76]);
						oldxmlString.append("<FAM_PEN_UPTO_SEVEN>"+famuptoseven+"</FAM_PEN_UPTO_SEVEN>");
					}
					else
					{
						oldxmlString.append("<FAM_PEN_UPTO_SEVEN>"+oldtemp[76]+"</FAM_PEN_UPTO_SEVEN>");
					}					
					if(oldtemp[77]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String famafterseven=formatter.format(oldtemp[77]);
						oldxmlString.append("<FAM_PEN_AFTER_SEVEN>"+famafterseven+"</FAM_PEN_AFTER_SEVEN>");
					}
					else
					{
						oldxmlString.append("<FAM_PEN_AFTER_SEVEN>"+oldtemp[77]+"</FAM_PEN_AFTER_SEVEN>");
					}

					if(oldtemp[78]!=null)
					{
						DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
						String dodeath=formatter.format(oldtemp[78]);
						oldxmlString.append("<DEATH_DATE>"+dodeath+"</DEATH_DATE>");
					}
					else
					{
						oldxmlString.append("<DEATH_DATE>"+oldtemp[78]+"</DEATH_DATE>");
					}



					oldxmlString.append("</oldrecord>");

					oldmyFlag=true;

				}
				if(oldmyFlag) 
				{
					oldxmlString.append("<oldflag>true</oldflag>");
				}
				else 
				{
					oldxmlString.append("<oldflag>false</oldflag>");
				}


				oldxmlString.append("</oldresponse>");

				getResponse().setContentType("text/xml");
				out.println(oldxmlString.toString());
				out.flush();
				out.close();

			}




		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}






	public String loadrevPenAppHOOldAEValData()
	{


		Integer empId=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		try
		{
			StringBuffer aexmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			empId=revisedDcrgPenappsearch.getEmpId();

			aexmlString.append("<aeresponse>");
			aexmlString.append("<aecommand>Get</aecommand>");
			aexmlString.append("<aeflag>success</aeflag>");

			List<PensionApplicationHOForm1AverageEmolumentsValDao> aeli=revDcrgPenHeadDataService.loadHOForm1OldAeVal(empId);

			for(PensionApplicationHOForm1AverageEmolumentsValDao aetmp:aeli)
			{
				aexmlString.append("<aerecord>");
				aexmlString.append("<avgid>"+aetmp.getAvgID()+"</avgid>");
				aexmlString.append("<nc>"+aetmp.getMaxcheck_value()+"</nc>");
				aexmlString.append("<fromdate>"+aetmp.getFromdate2()+"</fromdate>");
				aexmlString.append("<todate>"+aetmp.getTodate2()+"</todate>");
				aexmlString.append("<totmonth>"+aetmp.getTmonth()+"</totmonth>");
				aexmlString.append("<totdays>"+aetmp.getTday()+"</totdays>");
				aexmlString.append("<basic>"+aetmp.getBasic_pay()+"</basic>");
				aexmlString.append("<grade>"+aetmp.getGrade_pay()+"</grade>");
				aexmlString.append("<special>"+aetmp.getSpecial_pay()+"</special>");
				aexmlString.append("<other1>"+aetmp.getOptionpay1()+"</other1>");
				aexmlString.append("<other2>"+aetmp.getOptionpay2()+"</other2>");
				aexmlString.append("<other3>"+aetmp.getOptionpay3()+"</other3>");
				aexmlString.append("<ppamount>"+aetmp.getPpamount()+"</ppamount>");
				aexmlString.append("</aerecord>");

			}


			aexmlString.append("</aeresponse>");
			getResponse().setContentType("text/xml");
			out.println(aexmlString.toString());
			out.flush();
			out.close();

		} 
		catch(Exception e) {
			e.printStackTrace();
		}


		return null;
	}




	


	public String ReviseDCRGPensionData()
	{
		Integer revisedEmpid=null;
		boolean procedureFlag=false;
		Integer age=0;
		try
		{
			HttpSession session=getRequest().getSession();
			UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
			int loginEmpId=empProfile.getEmployeeId();
			revisedEmpid=revisedDCRGPen.getEmpNo();
			System.out.println("revisedEmpid="+revisedEmpid);
			procedureFlag=revDcrgPenHeadDataService.moveOldDCRGIntoHistory(revisedEmpid);

			/*************************************DCRG caluculation end*******************************/
			if(procedureFlag==true)
			{
				age=revisedDCRGPen.getAge();
				Integer commutedamount=revisedDCRGPen.getCommutedamount();
				float commfloatval=Float.parseFloat(revDcrgPenHeadDataService.penAppHOForm1CalcComSettingValData(age)+"");					
				revisedDCRGPen.setCommuted_val(commfloatval);
				float commutedpensionamount=(commutedamount)*12*(commfloatval);
				Integer commutedpenamount=(int)Math.round(commutedpensionamount);
				revisedDCRGPen.setTotcommutedamount(commutedpenamount);



				Date vrsdate=revisedDCRGPen.getVrs_date1();
				Date retiredate=revisedDCRGPen.getDar1();
				Date dedate=revisedDCRGPen.getDeath_date1();
				String dor="";
				if(vrsdate!=null)
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(vrsdate);
				}
				else if(dedate!=null)
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(dedate);
				}
				else
				{
					DateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
					dor=formatter.format(retiredate);
				}



				int dapercentage=revDcrgPenHeadDataService.penAppHOForm1CalcdaSettingValData(dor);


				revisedDCRGPen.setDa_percentage(dapercentage);





				String basic_include=revisedDCRGPen.getAvg_include_basic();
				String basic_da=revisedDCRGPen.getAvg_da_basic();

				String grade_include=revisedDCRGPen.getAvg_include_grade();
				String grade_da=revisedDCRGPen.getAvg_da_grade();

				String special_include=revisedDCRGPen.getAvg_include_special();
				String special_da=revisedDCRGPen.getAvg_da_special();

				String other1_include=revisedDCRGPen.getAvg_include_other1();
				String other1_da=revisedDCRGPen.getAvg_da_other1();

				String other2_include=revisedDCRGPen.getAvg_include_other2();
				String other2_da=revisedDCRGPen.getAvg_da_other2();

				String other3_include=revisedDCRGPen.getAvg_include_other3();
				String other3_da=revisedDCRGPen.getAvg_da_other3();

				Integer lasttotal=0;
				Integer lastbasic=0;
				Integer lastgrade=0;
				Integer lastspecial=0;
				Integer lastother1=0;
				Integer lastother2=0;
				Integer lastother3=0;
				Integer maxdcrgamount=0;
				Integer dcrghalfyear=0;
				Integer lasttotalforda=0;
				Integer finaltotalppamount=0;
				float damount;
				float dcrgpensionamuont;
				float maxdcrgamountcheck;

				finaltotalppamount=revisedDCRGPen.getFinaltotppamount();
				if(revisedDCRGPen.getLastbasic()==null)
				{
					lastbasic=0;
				}
				else
				{
					lastbasic=revisedDCRGPen.getLastbasic();
				}
				if(revisedDCRGPen.getLastgrade()==null)
				{
					lastgrade=0;
				}
				else
				{
					lastgrade=revisedDCRGPen.getLastgrade();
				}
				if(revisedDCRGPen.getLastspecial()==null)
				{
					lastspecial=0;
				}
				else
				{
					lastspecial=revisedDCRGPen.getLastspecial();
				}
				if(revisedDCRGPen.getLastother1()==null)
				{
					lastother1=0;
				}
				else
				{
					lastother1=revisedDCRGPen.getLastother1();
				}
				if(revisedDCRGPen.getLastother2()==null)
				{
					lastother2=0;
				}
				else
				{
					lastother2=revisedDCRGPen.getLastother2();
				}
				if(revisedDCRGPen.getLastother3()==null)
				{
					lastother3=0;
				}
				else
				{
					lastother3=revisedDCRGPen.getLastother3();
				}

				lasttotal=lastbasic+lastgrade+lastspecial+lastother1+lastother2+lastother3;



				maxdcrgamount=revisedDCRGPen.getMax_dcrg_amt();
				dcrghalfyear=revisedDCRGPen.getNohalfyeardcrg();





				if((basic_include.equalsIgnoreCase("Y"))&&(basic_da.equalsIgnoreCase("Y")))
				{
					lasttotalforda=lasttotalforda+lastbasic;
				}
				if((grade_include.equalsIgnoreCase("Y"))&&(grade_da.equalsIgnoreCase("Y")))
				{
					lasttotalforda=lasttotalforda+lastgrade;
				}
				if((special_include.equalsIgnoreCase("Y"))&&(special_da.equalsIgnoreCase("Y")))
				{
					lasttotalforda=lasttotalforda+lastspecial;
				}
				if((other1_include.equalsIgnoreCase("Y"))&&(other1_da.equalsIgnoreCase("Y")))
				{
					lasttotalforda=lasttotalforda+lastother1;
				}
				if((other2_include.equalsIgnoreCase("Y"))&&(other2_da.equalsIgnoreCase("Y")))
				{
					lasttotalforda=lasttotalforda+lastother2;
				}
				if((other3_include.equalsIgnoreCase("Y"))&&(other3_da.equalsIgnoreCase("Y")))
				{
					lasttotalforda=lasttotalforda+lastother3;
				}

				System.out.println("The lastbasic"+lastbasic);
				System.out.println("The lastgrade"+lastgrade);
				System.out.println("The lastspecial"+lastspecial);
				System.out.println("The lastother1"+lastother1);
				System.out.println("The lastother2"+lastother2);
				System.out.println("The lastother3"+lastother3);


				damount=(Float.parseFloat((lasttotalforda)+"")*((Float.parseFloat((dapercentage)+"")/100)));	
				System.out.println("The lasttotalforda"+lasttotalforda);
				System.out.println("The dapercentage"+dapercentage);
				System.out.println("The damount"+damount);




				dcrgpensionamuont=Float.parseFloat((Math.round((lasttotal+damount))*(0.25)*(dcrghalfyear))+"");

				System.out.println("The dcrghalfyear"+dcrghalfyear);

				System.out.println("The dcrgpensionamuont"+dcrgpensionamuont);


				if(!(revisedDCRGPen.getDeath_date1()+"").equalsIgnoreCase("null"))
				{
					Integer nqs_year=0;
					Integer multvar_dcrg=1;
					float lpd=lasttotal;
					if(!(revisedDCRGPen.getNqs_year()+"").equalsIgnoreCase("null"))
					{
						nqs_year=revisedDCRGPen.getNqs_year();
					}
					if(nqs_year<1)
					{
						multvar_dcrg=2;
						dcrgpensionamuont=((lpd)+(damount))*2;
						dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*2)+"");
					}
					if((nqs_year>=1) && (nqs_year<5))
					{
						multvar_dcrg=6;
						dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*6)+"");
					}
					if((nqs_year>=5) && (nqs_year<20))
					{
						multvar_dcrg=12;
						dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*12)+"");
					}
					if(nqs_year>=20)
					{							
						dcrgpensionamuont=Float.parseFloat((Math.round((lpd+damount))*(0.5)*(dcrghalfyear))+"");							
					}				  
				}

				System.out.println("maxdcrgamount="+maxdcrgamount);


				maxdcrgamountcheck=Float.parseFloat(maxdcrgamount+"");

				if((dcrgpensionamuont>=maxdcrgamountcheck))
				{
					dcrgpensionamuont=maxdcrgamountcheck;
				}

				String updatedId=updateservice.getUpdateId(loginEmpId);
				revisedPenAppAuthOrg.setProcessStatus("Final");	
				revisedPenAppAuthOrg.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
				revisedPenAppAuthOrg.setUpdateUser(updatedId);
				revisedPenAuthService.saveRecord(revisedPenAppAuthOrg);
				revDcrgPenHeadDataService.updateNewDCRGIntoHeadOfficeData(dcrgpensionamuont, newdaamount, dapercentage, revisedEmpid+"", updatedId);

				//revisedDCRGPen.setDamount((int)Math.round(damount));				
				//revisedDCRGPen.setDcrgamount((int)Math.round(dcrgpensionamuont));

				/*System.out.println("age="+age);
					System.out.println("commfloatval="+commfloatval);
					System.out.println("commutedpenamount="+commutedpenamount);
					System.out.println("dapercentage="+dapercentage);
					System.out.println("lasttotal="+lasttotal);
					System.out.println("maxdcrgamount="+maxdcrgamount);
					System.out.println("dcrghalfyear="+dcrghalfyear);
					System.out.println("damount="+damount);
					System.out.println("dcrgpensionamuont="+dcrgpensionamuont);*/




			}
			/*************************************DCRG caluculation end*******************************/

		}
		catch(Exception e)
		{
			return ERROR;
		}
		return SUCCESS;
	}










	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public RevisedDCRGPenLoadHeadOfficeDataService getRevDcrgPenHeadDataService() {
		return revDcrgPenHeadDataService;
	}
	public void setRevDcrgPenHeadDataService(
			RevisedDCRGPenLoadHeadOfficeDataService revDcrgPenHeadDataService) {
		this.revDcrgPenHeadDataService = revDcrgPenHeadDataService;
	}	
	public List<Object[]> getHeadOffRevDataList() {
		return headOffRevDataList;
	}
	public void setHeadOffRevDataList(List<Object[]> headOffRevDataList) {
		this.headOffRevDataList = headOffRevDataList;
	}	
	public CommonSearchModel getRevHeaddata() {
		return revHeaddata;
	}
	public void setRevHeaddata(CommonSearchModel revHeaddata) {
		this.revHeaddata = revHeaddata;
	}
	public void setHiddenSelectedNo(String hiddenSelectedNo) {
		HiddenSelectedNo = hiddenSelectedNo;
	}
	public String getHiddenSelectedNo() {
		return HiddenSelectedNo;
	}

	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}
	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}	
	public PensionApplicationSearchModel getRevisedDcrgPenappsearch() {
		return revisedDcrgPenappsearch;
	}
	public void setRevisedDcrgPenappsearch(
			PensionApplicationSearchModel revisedDcrgPenappsearch) {
		this.revisedDcrgPenappsearch = revisedDcrgPenappsearch;
	}
	public List<Object[]> getMyList() {
		return myList;
	}
	public void setMyList(List<Object[]> myList) {
		this.myList = myList;
	}
	public List<Object[]> getHeadOffDataList2() {
		return headOffDataList2;
	}
	public void setHeadOffDataList2(List<Object[]> headOffDataList2) {
		this.headOffDataList2 = headOffDataList2;
	}
	public RevisedDCRGPensionHODao getRevisedDCRGPen() {
		return revisedDCRGPen;
	}
	public void setRevisedDCRGPen(RevisedDCRGPensionHODao revisedDCRGPen) {
		this.revisedDCRGPen = revisedDCRGPen;
	}
	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}
	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}

	public PensionAuthorizationOriginalService getPenAuthOriService() {
		return penAuthOriService;
	}

	public void setPenAuthOriService(PensionAuthorizationOriginalService penAuthOriService) {
		this.penAuthOriService = penAuthOriService;
	}

	public void setPenAuthorisedOfficerList(List<PensionAuthorisedOfficer_dao> penAuthorisedOfficerList) {
		this.penAuthorisedOfficerList = penAuthorisedOfficerList;
	}

	public List<PensionAuthorisedOfficer_dao> getPenAuthorisedOfficerList() {
		return penAuthorisedOfficerList;
	}

	public List<PensionPaymentOffice_dao> getPayOfficeList() {
		return payOfficeList;
	}

	public void setPayOfficeList(List<PensionPaymentOffice_dao> payOfficeList) {
		this.payOfficeList = payOfficeList;
	}

	public void setReport(List<Map> report) {
		this.report = report;
	}

	public List<Map> getReport() {
		return report;
	}

	public String getFromAddress() {
		return FromAddress;
	}

	public void setFromAddress(String fromAddress) {
		FromAddress = fromAddress;
	}

	public String getResidentAddress() {
		return ResidentAddress;
	}

	public void setResidentAddress(String residentAddress) {
		ResidentAddress = residentAddress;
	}

	public String getAuthorizedofficer() {
		return Authorizedofficer;
	}

	public void setAuthorizedofficer(String authorizedofficer) {
		Authorizedofficer = authorizedofficer;
	}

	public String getLETTERNO() {
		return LETTERNO;
	}

	public void setLETTERNO(String letterno) {
		LETTERNO = letterno;
	}

	public String getREFERENCE() {
		return REFERENCE;
	}

	public void setREFERENCE(String reference) {
		REFERENCE = reference;
	}

	public List<Map> getReportnote() {
		return reportnote;
	}

	public void setReportnote(List<Map> reportnote) {
		this.reportnote = reportnote;
	}

	public RevisedPensionAuthorizationDao getRevisedPenAppAuthOri() {
		return revisedPenAppAuthOrg;
	}

	public void setRevisedPenAppAuthOri(
			RevisedPensionAuthorizationDao revisedPenAppAuthOrg) {
		this.revisedPenAppAuthOrg = revisedPenAppAuthOrg;
	}

	public RevisedPensionAuthorizationService getRevisedPenAuthService() {
		return revisedPenAuthService;
	}

	public void setRevisedPenAuthService(
			RevisedPensionAuthorizationService revisedPenAuthService) {
		this.revisedPenAuthService = revisedPenAuthService;
	}

	public double getNoofhalfyear() {
		return noofhalfyear;
	}

	public void setNoofhalfyear(double noofhalfyear) {
		this.noofhalfyear = noofhalfyear;
	}

	public NumberFormat getDf1() {
		return df1;
	}

	public void setDf1(NumberFormat df1) {
		this.df1 = df1;
	}

	public String getPensiontype() {
		return pensiontype;
	}

	public void setPensiontype(String pensiontype) {
		this.pensiontype = pensiontype;
	}

	public Integer getRevdcrgamt() {
		return revdcrgamt;
	}

	public void setRevdcrgamt(Integer revdcrgamt) {
		this.revdcrgamt = revdcrgamt;
	}

	public Integer getRevcaldcrgamt() {
		return revcaldcrgamt;
	}

	public void setRevcaldcrgamt(Integer revcaldcrgamt) {
		this.revcaldcrgamt = revcaldcrgamt;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpGenger() {
		return empGenger;
	}

	public void setEmpGenger(String empGenger) {
		this.empGenger = empGenger;
	}

	public String getEmpdob() {
		return empdob;
	}

	public void setEmpdob(String empdob) {
		this.empdob = empdob;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpOffice() {
		return empOffice;
	}

	public void setEmpOffice(String empOffice) {
		this.empOffice = empOffice;
	}

	public int getEmpolddapercentage() {
		return empolddapercentage;
	}

	public void setEmpolddapercentage(int empolddapercentage) {
		this.empolddapercentage = empolddapercentage;
	}

	public int getEmpppono() {
		return empppono;
	}

	public void setEmpppono(int empppono) {
		this.empppono = empppono;
	}

	public int getEmpgpono() {
		return empgpono;
	}

	public void setEmpgpono(int empgpono) {
		this.empgpono = empgpono;
	}

	public String getResidentaddress() {
		return residentaddress;
	}

	public void setResidentaddress(String residentaddress) {
		this.residentaddress = residentaddress;
	}

	public String getNamefromaddress() {
		return namefromaddress;
	}

	public void setNamefromaddress(String namefromaddress) {
		this.namefromaddress = namefromaddress;
	}

	public String getAuthorizedofficeraddress() {
		return authorizedofficeraddress;
	}

	public void setAuthorizedofficeraddress(String authorizedofficeraddress) {
		this.authorizedofficeraddress = authorizedofficeraddress;
	}

	public String getLetterno() {
		return letterno;
	}

	public void setLetterno(String letterno) {
		this.letterno = letterno;
	}

	public String getLastworkoffiaddress() {
		return lastworkoffiaddress;
	}

	public void setLastworkoffiaddress(String lastworkoffiaddress) {
		this.lastworkoffiaddress = lastworkoffiaddress;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getPaymentofficename() {
		return paymentofficename;
	}

	public void setPaymentofficename(String paymentofficename) {
		this.paymentofficename = paymentofficename;
	}

	public String getPaymentofficeaddress() {
		return paymentofficeaddress;
	}

	public void setPaymentofficeaddress(String paymentofficeaddress) {
		this.paymentofficeaddress = paymentofficeaddress;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setOlddcrgamount(int olddcrgamount) {
		this.olddcrgamount = olddcrgamount;
	}

	public int getOlddcrgamount() {
		return olddcrgamount;
	}

	public void setEmpOfficeid(int empOfficeid) {
		this.empOfficeid = empOfficeid;
	}

	public int getEmpOfficeid() {
		return empOfficeid;
	}

	public void setPaymentOfficeid(int paymentOfficeid) {
		this.paymentOfficeid = paymentOfficeid;
	}

	public int getPaymentOfficeid() {
		return paymentOfficeid;
	}
	
	

	public void setNewdapercentage(int newdapercentage) {
		this.newdapercentage = newdapercentage;
	}

	public int getNewdapercentage() {
		return newdapercentage;
	}

	/*public float getNewdapercentage() {
		return newdapercentage;
	}

	public void setNewdapercentage(float newdapercentage) {
		this.newdapercentage = newdapercentage;
	}*/

	public void setNoofhalfyeardcrg(int noofhalfyeardcrg) {
		this.noofhalfyeardcrg = noofhalfyeardcrg;
	}

	public int getNoofhalfyeardcrg() {
		return noofhalfyeardcrg;
	}

	public void setNewdaamount(int newdaamount) {
		this.newdaamount = newdaamount;
	}

	public int getNewdaamount() {
		return newdaamount;
	}



	public float getTotdcrghalfyear() {
		return totdcrghalfyear;
	}

	public void setTotdcrghalfyear(float totdcrghalfyear) {
		this.totdcrghalfyear = totdcrghalfyear;
	}

	public void setAuthorisedOfficerDesc(String authorisedOfficerDesc) {
		this.authorisedOfficerDesc = authorisedOfficerDesc;
	}

	public String getAuthorisedOfficerDesc() {
		return authorisedOfficerDesc;
	}

	public void setAuthorisedOfficerId(int authorisedOfficerId) {
		this.authorisedOfficerId = authorisedOfficerId;
	}

	public int getAuthorisedOfficerId() {
		return authorisedOfficerId;
	}

	public void setAuthOfficer(Integer authOfficer) {
		this.authOfficer = authOfficer;
	}

	public Integer getAuthOfficer() {
		return authOfficer;
	}

	public Integer getLasttotal() {
		return lasttotal;
	}

	public void setLasttotal(Integer lasttotal) {
		this.lasttotal = lasttotal;
	}

	public String getDatedon() {
		return Datedon;
	}

	public void setDatedon(String datedon) {
		Datedon = datedon;
	}










}
