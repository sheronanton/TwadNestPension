package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RevisedDCRGPensionHODao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6678782340706179006L;
	
	
	
	
	private Integer empNo;
	private Integer officeId;
	private Integer classPensionId;
	private String empInitial;
	private String empName;
	private Integer desigServiceGrp;
	private Integer desigId;
	private Integer age;
	private String scaleOfPay;
	private String dateOfBirth;	
	private Date dateOfBirth1;
	private String dateOfBirth2;	
	private String twadDoj;	
	private Date twadDoj1;
	private String twadDoj2;	
	private String province_date;	
	private Date province_date1;
	private String province_date2;	
	private String regualr_estab_date;	
	private Date regualr_estab_date1;
	private String regualr_estab_date2;	
	private String datOfSelectionGrade;	
	private Date datOfSelectionGrade1;
	private String datOfSelectionGrade2;	
	private String dateOfSpecialGrade;	
	private Date dateOfSpecialGrade1;
	private String dateOfSpecialGrade2;	
	private String dar;	
	private Date dar1;
	private String dar2;
	private String vrs_date;	
	private Date vrs_date1;
	private String vrs_date2;
	
	
	private String death_date;	
	private Date death_date1;
	private String death_date2;
	
	private String pensionCommutedFlag;
	private String pensionpertFlag;
	
	private Integer commPert;	
	private Integer wceyear;
	private Integer wcemonth;
	private Integer wceday;
	private String wceserviceFlag;
	private String wcecountedFlag;	
	private Integer contingentyear;
	private Integer contingentmonth;
	private Integer contingentday;
	
	private Integer contingent_yeardis;
	private Integer contingent_monthdis;
	private Integer contingent_daydis;
	
	
	private String contingentserviceFlag;	
	private Integer npp_year;
	private Integer npp_month;
	private Integer npp_day;	
	private Integer ewm_year;
	private Integer ewm_month;
	private Integer ewm_day;	
	private Integer s_year;
	private Integer s_month;
	private Integer s_day;	
	private Integer bs_year;
	private Integer bs_month;
	private Integer bs_day;	
	private Integer ol_year;
	private Integer ol_month;
	private Integer ol_day;	
	private Integer lnr_year;
	private Integer lnr_month;
	private Integer lnr_day;	
	private Integer as_year;
	private Integer as_month;
	private Integer as_day;	
	private Integer svnd_year;
	private Integer svnd_month;
	private Integer svnd_day;	
	private Integer fs_year;
	private Integer fs_month;
	private Integer fs_day;	
	private Integer lastbasic;
	private Integer lastgrade;
	private Integer lastspecial;
	private Integer lastother1;
	private Integer lastother2;
	private Integer lastother3;	
	private Integer pensionamount;
	private Integer fampensionamount;
	private Integer famafterpensionamount;
	private Integer dcrgamount;
	private Integer nohalfyearpen;
	private Integer nohalfyeardcrg;
	private Integer totcommutedamount;
	private Integer reducedpensionamount;
	private Integer commutedamount;
	private Integer damount;
	private float commuted_val;	
	private Integer aws_yeardis;
	private Integer aws_monthdis;
	private Integer aws_daydis;	
	private Integer nqs_year;
	private Integer nqs_month;
	private Integer nqs_day;	
	private Integer tqs_year;
	private Integer tqs_month;
	private Integer tqs_day;	
	private Integer weigt_yeardis;
	private Integer weigt_monthdis;
	private Integer weigt_daydis;	
	private String fam_pen_upto_seven_date;	
	private Date fam_pen_upto_seven_date1;
	private String fam_pen_upto_seven_date2;	
	private String fam_pen_after_seven_date;	
	private Date fam_pen_after_seven_date1;
	private String fam_pen_after_seven_date2;
	private Integer da_percentage;
	
	
	String avg_include_basic;
	  String avg_da_basic;
	  			  
	  String avg_include_grade;
	  String avg_da_grade;
	 			  
	  String avg_include_special;
	  String avg_da_special;
	  
	  String avg_include_other1;
	  String avg_da_other1;
	  
	  String avg_include_other2;
	  String avg_da_other2;
	  
	  String avg_include_other3;
	  String avg_da_other3;
		
	 Integer Max_dcrg_amt;
	 Integer finaltotppamount;
	 
	 
	 private String processStatus;
	 private String updatedUser;
	 private Timestamp updateDate;
	 private Timestamp unlockedDate;
	 private String unlockedBy;
	 
	 
	 
	 
	 
	 
	 
		
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	
	public String getEmpInitial() {
		return empInitial;
	}
	public void setEmpInitial(String empInitial) {
		this.empInitial = empInitial;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	public String getScaleOfPay() {
		return scaleOfPay;
	}
	public void setScaleOfPay(String scaleOfPay) {
		this.scaleOfPay = scaleOfPay;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {		
		
		if(dateOfBirth.trim() != null && dateOfBirth.trim().length() >0){
			try{
	            System.out.println("------------------------>dob"+dateOfBirth);
	            DateFormat datebirth = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setDateOfBirth1(datebirth.parse(dateOfBirth));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of dateOfBirth"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfBirth1() {
		return dateOfBirth1;
	}
	public void setDateOfBirth1(Date dateOfBirth1) {
		
		if(dateOfBirth1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String datefbirth = formatter.format(dateOfBirth1);
		         setDateOfBirth2(datefbirth);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
			}
		
		this.dateOfBirth1 = dateOfBirth1;
	}
	public String getDateOfBirth2() {
		return dateOfBirth2;
	}
	public void setDateOfBirth2(String dateOfBirth2) {
		this.dateOfBirth2 = dateOfBirth2;
	}
	public String getTwadDoj() {
		return twadDoj;
	}
	public void setTwadDoj(String twadDoj) {		
		
		if(twadDoj.trim() != null && twadDoj.trim().length() >0){
			try{
	            System.out.println("------------------------>twadDoj"+twadDoj);
	            DateFormat dateofjoin = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setTwadDoj1(dateofjoin.parse(twadDoj));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of twadDoj"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.twadDoj = twadDoj;
	}
	public Date getTwadDoj1() {
		return twadDoj1;
	}
	public void setTwadDoj1(Date twadDoj1) {
		
		if(twadDoj1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String dateofjoin = formatter.format(dateOfBirth1);
		         setTwadDoj2(dateofjoin);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		this.twadDoj1 = twadDoj1;
	}
	public String getTwadDoj2() {
		return twadDoj2;
	}
	public void setTwadDoj2(String twadDoj2) {
		this.twadDoj2 = twadDoj2;
	}
	public String getProvince_date() {
		return province_date;
	}
	public void setProvince_date(String province_date) {
		
		if(province_date.trim() != null && province_date.trim().length() >0){
			try{
	            System.out.println("------------------------>province_date"+province_date);
	            DateFormat prodate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setProvince_date1(prodate.parse(province_date));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of province_date"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.province_date = province_date;
	}
	public Date getProvince_date1() {
		return province_date1;
	}
	public void setProvince_date1(Date province_date1) {
		
		if(province_date1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String prodate = formatter.format(province_date1);
		         setProvince_date2(prodate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		this.province_date1 = province_date1;
	}
	public String getProvince_date2() {
		return province_date2;
	}
	public void setProvince_date2(String province_date2) {
		this.province_date2 = province_date2;
	}
	public String getDar() {
		return dar;
	}
	public void setDar(String dar) {
		
		if(dar.trim() != null && dar.trim().length() >0){
			try{
	            System.out.println("------------------------>dar"+dar);
	            DateFormat dardate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setDar1(dardate.parse(dar));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of dar"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.dar = dar;
	}
	public Date getDar1() {
		return dar1;
	}
	public void setDar1(Date dar1) {
		
		if(dar1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String dardate = formatter.format(dar1);
		         setDar2(dardate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		this.dar1 = dar1;
	}
	public String getDar2() {
		return dar2;
	}
	public void setDar2(String dar2) {
		this.dar2 = dar2;
	}
	public String getVrs_date() {
		return vrs_date;
	}
	public void setVrs_date(String vrs_date) {
		
		if(vrs_date.trim() != null && vrs_date.trim().length() >0){
			try{
	            System.out.println("------------------------>vrs_date"+vrs_date);
	            DateFormat vrsdate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setVrs_date1(vrsdate.parse(vrs_date));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of vrs_date"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		this.vrs_date = vrs_date;
	}
	public Date getVrs_date1() {
		return vrs_date1;
	}
	public void setVrs_date1(Date vrs_date1) {
		
		if(vrs_date1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String vrsdate = formatter.format(vrs_date1);
		         setVrs_date2(vrsdate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		
		this.vrs_date1 = vrs_date1;
	}
	public String getVrs_date2() {
		return vrs_date2;
	}
	public void setVrs_date2(String vrs_date2) {
		this.vrs_date2 = vrs_date2;
	}	
	
	public String getRegualr_estab_date() {
		return regualr_estab_date;
	}
	public void setRegualr_estab_date(String regualr_estab_date) {
		
		if(regualr_estab_date.trim() != null && regualr_estab_date.trim().length() >0){
			try{
	            System.out.println("------------------------>regualr_estab_date"+regualr_estab_date);
	            DateFormat regedate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setRegualr_estab_date1(regedate.parse(regualr_estab_date));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of regualr_estab_date"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.regualr_estab_date = regualr_estab_date;
	}
	public Date getRegualr_estab_date1() {
		return regualr_estab_date1;
	}
	public void setRegualr_estab_date1(Date regualr_estab_date1) {
		
		if(regualr_estab_date1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String regedate = formatter.format(regualr_estab_date1);
		         setRegualr_estab_date2(regedate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		this.regualr_estab_date1 = regualr_estab_date1;
	}
	public String getRegualr_estab_date2() {
		return regualr_estab_date2;
	}
	public void setRegualr_estab_date2(String regualr_estab_date2) {
		this.regualr_estab_date2 = regualr_estab_date2;
	}
	public String getDatOfSelectionGrade() {
		return datOfSelectionGrade;
	}
	public void setDatOfSelectionGrade(String datOfSelectionGrade) {
		if(datOfSelectionGrade.trim() != null && datOfSelectionGrade.trim().length() >0){
			try{
	            System.out.println("------------------------>datOfSelectionGrade"+datOfSelectionGrade);
	            DateFormat selgdate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setDatOfSelectionGrade1(selgdate.parse(datOfSelectionGrade));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of datOfSelectionGrade"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		this.datOfSelectionGrade = datOfSelectionGrade;
	}
	public Date getDatOfSelectionGrade1() {
		return datOfSelectionGrade1;
	}
	public void setDatOfSelectionGrade1(Date datOfSelectionGrade1) {
		
		if(datOfSelectionGrade1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String selgdate = formatter.format(datOfSelectionGrade1);
		         setDatOfSelectionGrade2(selgdate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		
		this.datOfSelectionGrade1 = datOfSelectionGrade1;
	}
	public String getDatOfSelectionGrade2() {
		return datOfSelectionGrade2;
	}
	public void setDatOfSelectionGrade2(String datOfSelectionGrade2) {
		this.datOfSelectionGrade2 = datOfSelectionGrade2;
	}
	public String getDateOfSpecialGrade() {
		return dateOfSpecialGrade;
	}
	public void setDateOfSpecialGrade(String dateOfSpecialGrade) {
		
		if(dateOfSpecialGrade.trim() != null && dateOfSpecialGrade.trim().length() >0){
			try{
	            System.out.println("------------------------>dateOfSpecialGrade"+dateOfSpecialGrade);
	            DateFormat splgdate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setDateOfSpecialGrade1(splgdate.parse(dateOfSpecialGrade));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of dateOfSpecialGrade"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		this.dateOfSpecialGrade = dateOfSpecialGrade;
	}
	public Date getDateOfSpecialGrade1() {
		return dateOfSpecialGrade1;
	}
	public void setDateOfSpecialGrade1(Date dateOfSpecialGrade1) {
		
		if(dateOfSpecialGrade1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String splgdate = formatter.format(dateOfSpecialGrade1);
		         setDateOfSpecialGrade2(splgdate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		this.dateOfSpecialGrade1 = dateOfSpecialGrade1;
	}
	public String getDateOfSpecialGrade2() {
		return dateOfSpecialGrade2;
	}
	public void setDateOfSpecialGrade2(String dateOfSpecialGrade2) {
		this.dateOfSpecialGrade2 = dateOfSpecialGrade2;
	}
	
	
	public String getWceserviceFlag() {
		return wceserviceFlag;
	}
	public void setWceserviceFlag(String wceserviceFlag) {
		this.wceserviceFlag = wceserviceFlag;
	}
	public String getWcecountedFlag() {
		return wcecountedFlag;
	}
	public void setWcecountedFlag(String wcecountedFlag) {
		this.wcecountedFlag = wcecountedFlag;
	}
	public String getContingentserviceFlag() {
		return contingentserviceFlag;
	}
	public void setContingentserviceFlag(String contingentserviceFlag) {
		this.contingentserviceFlag = contingentserviceFlag;
	}
	
	public Integer getContingent_yeardis() {
		return contingent_yeardis;
	}
	public void setContingent_yeardis(Integer contingent_yeardis) {
		this.contingent_yeardis = contingent_yeardis;
	}
	public Integer getContingent_monthdis() {
		return contingent_monthdis;
	}
	public void setContingent_monthdis(Integer contingent_monthdis) {
		this.contingent_monthdis = contingent_monthdis;
	}
	public Integer getContingent_daydis() {
		return contingent_daydis;
	}
	public void setContingent_daydis(Integer contingent_daydis) {
		this.contingent_daydis = contingent_daydis;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public String getPensionCommutedFlag() {
		return pensionCommutedFlag;
	}
	public void setPensionCommutedFlag(String pensionCommutedFlag) {
		this.pensionCommutedFlag = pensionCommutedFlag;
	}
	public String getPensionpertFlag() {
		return pensionpertFlag;
	}
	public void setPensionpertFlag(String pensionpertFlag) {
		this.pensionpertFlag = pensionpertFlag;
	}
	
	public float getCommuted_val() {
		return commuted_val;
	}
	public void setCommuted_val(float commuted_val) {
		this.commuted_val = commuted_val;
	}	
	
	public String getFam_pen_upto_seven_date() {
		return fam_pen_upto_seven_date;
	}
	public void setFam_pen_upto_seven_date(String fam_pen_upto_seven_date) {		
		
		if(fam_pen_upto_seven_date.trim() != null && fam_pen_upto_seven_date.trim().length() >0){
			try{
	            System.out.println("------------------------>fam_pen_upto_seven_date"+fam_pen_upto_seven_date);
	            DateFormat fambeforedate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setFam_pen_upto_seven_date1(fambeforedate.parse(fam_pen_upto_seven_date));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of fam_pen_upto_seven_date"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		
		this.fam_pen_upto_seven_date = fam_pen_upto_seven_date;
	}
	public Date getFam_pen_upto_seven_date1() {
		return fam_pen_upto_seven_date1;
	}
	public void setFam_pen_upto_seven_date1(Date fam_pen_upto_seven_date1) {
		
		if(fam_pen_upto_seven_date1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String fambeforedate = formatter.format(fam_pen_upto_seven_date1);
		         setFam_pen_upto_seven_date2(fambeforedate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		
		this.fam_pen_upto_seven_date1 = fam_pen_upto_seven_date1;
	}
	public String getFam_pen_upto_seven_date2() {
		return fam_pen_upto_seven_date2;
	}
	public void setFam_pen_upto_seven_date2(String fam_pen_upto_seven_date2) {
		this.fam_pen_upto_seven_date2 = fam_pen_upto_seven_date2;
	}
	public String getFam_pen_after_seven_date() {
		return fam_pen_after_seven_date;
	}
	public void setFam_pen_after_seven_date(String fam_pen_after_seven_date) {
		
		
		if(fam_pen_after_seven_date.trim() != null && fam_pen_after_seven_date.trim().length() >0){
			try{
	            System.out.println("------------------------>fam_pen_after_seven_date"+fam_pen_after_seven_date);
	            DateFormat famafterdate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setFam_pen_after_seven_date1(famafterdate.parse(fam_pen_after_seven_date));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of fam_pen_after_seven_date"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.fam_pen_after_seven_date = fam_pen_after_seven_date;
	}
	public Date getFam_pen_after_seven_date1() {
		return fam_pen_after_seven_date1;
	}
	public void setFam_pen_after_seven_date1(Date fam_pen_after_seven_date1) {
		
		if(fam_pen_after_seven_date1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String famafterdate = formatter.format(fam_pen_after_seven_date1);
		         setFam_pen_after_seven_date2(famafterdate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		this.fam_pen_after_seven_date1 = fam_pen_after_seven_date1;
	}
	public String getFam_pen_after_seven_date2() {
		return fam_pen_after_seven_date2;
	}
	public void setFam_pen_after_seven_date2(String fam_pen_after_seven_date2) {
		this.fam_pen_after_seven_date2 = fam_pen_after_seven_date2;
	}
	
	
	
	public String getDeath_date() {
		return death_date;
	}
	public void setDeath_date(String death_date) {
		
		
		if(death_date.trim() != null && death_date.trim().length() >0){
			try{
	            System.out.println("------------------------>death_date"+death_date);
	            DateFormat deathdate = new SimpleDateFormat("dd/MM/yyyy");
	            
	            setDeath_date1(deathdate.parse(death_date));
	         	}catch(Exception e){
	                 System.out.println("-------------------->inside exception block of date of death_date"+e);
	                 e.printStackTrace();
	        
	         	}
			}
		
		this.death_date = death_date;
	}
	public Date getDeath_date1() {
		return death_date1;
	}
	public void setDeath_date1(Date death_date1) {		
		
		if(death_date1 != null){
			try {
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String deathdate = formatter.format(death_date1);
		         setDeath_date2(deathdate);
		        }
			catch (Exception e)
		    {
		    e.printStackTrace();
		    }
		}
		
		this.death_date1 = death_date1;
	}
	public String getDeath_date2() {
		return death_date2;
	}
	public void setDeath_date2(String death_date2) {
		this.death_date2 = death_date2;
	}
	
	
	
	
	
	public Integer getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public Integer getClassPensionId() {
		return classPensionId;
	}
	public void setClassPensionId(Integer classPensionId) {
		this.classPensionId = classPensionId;
	}
	public Integer getDesigServiceGrp() {
		return desigServiceGrp;
	}
	public void setDesigServiceGrp(Integer desigServiceGrp) {
		this.desigServiceGrp = desigServiceGrp;
	}
	public Integer getDesigId() {
		return desigId;
	}
	public void setDesigId(Integer desigId) {
		this.desigId = desigId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCommPert() {
		return commPert;
	}
	public void setCommPert(Integer commPert) {
		this.commPert = commPert;
	}
	public Integer getWceyear() {
		return wceyear;
	}
	public void setWceyear(Integer wceyear) {
		this.wceyear = wceyear;
	}
	public Integer getWcemonth() {
		return wcemonth;
	}
	public void setWcemonth(Integer wcemonth) {
		this.wcemonth = wcemonth;
	}
	public Integer getWceday() {
		return wceday;
	}
	public void setWceday(Integer wceday) {
		this.wceday = wceday;
	}
	public Integer getContingentyear() {
		return contingentyear;
	}
	public void setContingentyear(Integer contingentyear) {
		this.contingentyear = contingentyear;
	}
	public Integer getContingentmonth() {
		return contingentmonth;
	}
	public void setContingentmonth(Integer contingentmonth) {
		this.contingentmonth = contingentmonth;
	}
	public Integer getContingentday() {
		return contingentday;
	}
	public void setContingentday(Integer contingentday) {
		this.contingentday = contingentday;
	}
	public Integer getNpp_year() {
		return npp_year;
	}
	public void setNpp_year(Integer npp_year) {
		this.npp_year = npp_year;
	}
	public Integer getNpp_month() {
		return npp_month;
	}
	public void setNpp_month(Integer npp_month) {
		this.npp_month = npp_month;
	}
	public Integer getNpp_day() {
		return npp_day;
	}
	public void setNpp_day(Integer npp_day) {
		this.npp_day = npp_day;
	}
	public Integer getEwm_year() {
		return ewm_year;
	}
	public void setEwm_year(Integer ewm_year) {
		this.ewm_year = ewm_year;
	}
	public Integer getEwm_month() {
		return ewm_month;
	}
	public void setEwm_month(Integer ewm_month) {
		this.ewm_month = ewm_month;
	}
	public Integer getEwm_day() {
		return ewm_day;
	}
	public void setEwm_day(Integer ewm_day) {
		this.ewm_day = ewm_day;
	}
	public Integer getS_year() {
		return s_year;
	}
	public void setS_year(Integer s_year) {
		this.s_year = s_year;
	}
	public Integer getS_month() {
		return s_month;
	}
	public void setS_month(Integer s_month) {
		this.s_month = s_month;
	}
	public Integer getS_day() {
		return s_day;
	}
	public void setS_day(Integer s_day) {
		this.s_day = s_day;
	}
	public Integer getBs_year() {
		return bs_year;
	}
	public void setBs_year(Integer bs_year) {
		this.bs_year = bs_year;
	}
	public Integer getBs_month() {
		return bs_month;
	}
	public void setBs_month(Integer bs_month) {
		this.bs_month = bs_month;
	}
	public Integer getBs_day() {
		return bs_day;
	}
	public void setBs_day(Integer bs_day) {
		this.bs_day = bs_day;
	}
	public Integer getOl_year() {
		return ol_year;
	}
	public void setOl_year(Integer ol_year) {
		this.ol_year = ol_year;
	}
	public Integer getOl_month() {
		return ol_month;
	}
	public void setOl_month(Integer ol_month) {
		this.ol_month = ol_month;
	}
	public Integer getOl_day() {
		return ol_day;
	}
	public void setOl_day(Integer ol_day) {
		this.ol_day = ol_day;
	}
	public Integer getLnr_year() {
		return lnr_year;
	}
	public void setLnr_year(Integer lnr_year) {
		this.lnr_year = lnr_year;
	}
	public Integer getLnr_month() {
		return lnr_month;
	}
	public void setLnr_month(Integer lnr_month) {
		this.lnr_month = lnr_month;
	}
	public Integer getLnr_day() {
		return lnr_day;
	}
	public void setLnr_day(Integer lnr_day) {
		this.lnr_day = lnr_day;
	}
	public Integer getAs_year() {
		return as_year;
	}
	public void setAs_year(Integer as_year) {
		this.as_year = as_year;
	}
	public Integer getAs_month() {
		return as_month;
	}
	public void setAs_month(Integer as_month) {
		this.as_month = as_month;
	}
	public Integer getAs_day() {
		return as_day;
	}
	public void setAs_day(Integer as_day) {
		this.as_day = as_day;
	}
	public Integer getSvnd_year() {
		return svnd_year;
	}
	public void setSvnd_year(Integer svnd_year) {
		this.svnd_year = svnd_year;
	}
	public Integer getSvnd_month() {
		return svnd_month;
	}
	public void setSvnd_month(Integer svnd_month) {
		this.svnd_month = svnd_month;
	}
	public Integer getSvnd_day() {
		return svnd_day;
	}
	public void setSvnd_day(Integer svnd_day) {
		this.svnd_day = svnd_day;
	}
	public Integer getFs_year() {
		return fs_year;
	}
	public void setFs_year(Integer fs_year) {
		this.fs_year = fs_year;
	}
	public Integer getFs_month() {
		return fs_month;
	}
	public void setFs_month(Integer fs_month) {
		this.fs_month = fs_month;
	}
	public Integer getFs_day() {
		return fs_day;
	}
	public void setFs_day(Integer fs_day) {
		this.fs_day = fs_day;
	}
	public Integer getLastbasic() {
		return lastbasic;
	}
	public void setLastbasic(Integer lastbasic) {
		this.lastbasic = lastbasic;
	}
	public Integer getLastgrade() {
		return lastgrade;
	}
	public void setLastgrade(Integer lastgrade) {
		this.lastgrade = lastgrade;
	}
	public Integer getLastspecial() {
		return lastspecial;
	}
	public void setLastspecial(Integer lastspecial) {
		this.lastspecial = lastspecial;
	}
	public Integer getLastother1() {
		return lastother1;
	}
	public void setLastother1(Integer lastother1) {
		this.lastother1 = lastother1;
	}
	public Integer getLastother2() {
		return lastother2;
	}
	public void setLastother2(Integer lastother2) {
		this.lastother2 = lastother2;
	}
	public Integer getLastother3() {
		return lastother3;
	}
	public void setLastother3(Integer lastother3) {
		this.lastother3 = lastother3;
	}
	public Integer getPensionamount() {
		return pensionamount;
	}
	public void setPensionamount(Integer pensionamount) {
		this.pensionamount = pensionamount;
	}
	public Integer getFampensionamount() {
		return fampensionamount;
	}
	public void setFampensionamount(Integer fampensionamount) {
		this.fampensionamount = fampensionamount;
	}
	public Integer getFamafterpensionamount() {
		return famafterpensionamount;
	}
	public void setFamafterpensionamount(Integer famafterpensionamount) {
		this.famafterpensionamount = famafterpensionamount;
	}
	public Integer getDcrgamount() {
		return dcrgamount;
	}
	public void setDcrgamount(Integer dcrgamount) {
		this.dcrgamount = dcrgamount;
	}
	public Integer getNohalfyearpen() {
		return nohalfyearpen;
	}
	public void setNohalfyearpen(Integer nohalfyearpen) {
		this.nohalfyearpen = nohalfyearpen;
	}
	public Integer getNohalfyeardcrg() {
		return nohalfyeardcrg;
	}
	public void setNohalfyeardcrg(Integer nohalfyeardcrg) {
		this.nohalfyeardcrg = nohalfyeardcrg;
	}
	public Integer getTotcommutedamount() {
		return totcommutedamount;
	}
	public void setTotcommutedamount(Integer totcommutedamount) {
		this.totcommutedamount = totcommutedamount;
	}
	public Integer getReducedpensionamount() {
		return reducedpensionamount;
	}
	public void setReducedpensionamount(Integer reducedpensionamount) {
		this.reducedpensionamount = reducedpensionamount;
	}
	public Integer getCommutedamount() {
		return commutedamount;
	}
	public void setCommutedamount(Integer commutedamount) {
		this.commutedamount = commutedamount;
	}
	public Integer getDamount() {
		return damount;
	}
	public void setDamount(Integer damount) {
		this.damount = damount;
	}
	public Integer getAws_yeardis() {
		return aws_yeardis;
	}
	public void setAws_yeardis(Integer aws_yeardis) {
		this.aws_yeardis = aws_yeardis;
	}
	public Integer getAws_monthdis() {
		return aws_monthdis;
	}
	public void setAws_monthdis(Integer aws_monthdis) {
		this.aws_monthdis = aws_monthdis;
	}
	public Integer getAws_daydis() {
		return aws_daydis;
	}
	public void setAws_daydis(Integer aws_daydis) {
		this.aws_daydis = aws_daydis;
	}
	public Integer getNqs_year() {
		return nqs_year;
	}
	public void setNqs_year(Integer nqs_year) {
		this.nqs_year = nqs_year;
	}
	public Integer getNqs_month() {
		return nqs_month;
	}
	public void setNqs_month(Integer nqs_month) {
		this.nqs_month = nqs_month;
	}
	public Integer getNqs_day() {
		return nqs_day;
	}
	public void setNqs_day(Integer nqs_day) {
		this.nqs_day = nqs_day;
	}
	public Integer getTqs_year() {
		return tqs_year;
	}
	public void setTqs_year(Integer tqs_year) {
		this.tqs_year = tqs_year;
	}
	public Integer getTqs_month() {
		return tqs_month;
	}
	public void setTqs_month(Integer tqs_month) {
		this.tqs_month = tqs_month;
	}
	public Integer getTqs_day() {
		return tqs_day;
	}
	public void setTqs_day(Integer tqs_day) {
		this.tqs_day = tqs_day;
	}
	public Integer getWeigt_yeardis() {
		return weigt_yeardis;
	}
	public void setWeigt_yeardis(Integer weigt_yeardis) {
		this.weigt_yeardis = weigt_yeardis;
	}
	public Integer getWeigt_monthdis() {
		return weigt_monthdis;
	}
	public void setWeigt_monthdis(Integer weigt_monthdis) {
		this.weigt_monthdis = weigt_monthdis;
	}
	public Integer getWeigt_daydis() {
		return weigt_daydis;
	}
	public void setWeigt_daydis(Integer weigt_daydis) {
		this.weigt_daydis = weigt_daydis;
	}
	public String getAvg_include_basic() {
		return avg_include_basic;
	}
	public void setAvg_include_basic(String avg_include_basic) {
		this.avg_include_basic = avg_include_basic;
	}
	public String getAvg_da_basic() {
		return avg_da_basic;
	}
	public void setAvg_da_basic(String avg_da_basic) {
		this.avg_da_basic = avg_da_basic;
	}
	public String getAvg_include_grade() {
		return avg_include_grade;
	}
	public void setAvg_include_grade(String avg_include_grade) {
		this.avg_include_grade = avg_include_grade;
	}
	public String getAvg_da_grade() {
		return avg_da_grade;
	}
	public void setAvg_da_grade(String avg_da_grade) {
		this.avg_da_grade = avg_da_grade;
	}
	public String getAvg_include_special() {
		return avg_include_special;
	}
	public void setAvg_include_special(String avg_include_special) {
		this.avg_include_special = avg_include_special;
	}
	public String getAvg_da_special() {
		return avg_da_special;
	}
	public void setAvg_da_special(String avg_da_special) {
		this.avg_da_special = avg_da_special;
	}
	public String getAvg_include_other1() {
		return avg_include_other1;
	}
	public void setAvg_include_other1(String avg_include_other1) {
		this.avg_include_other1 = avg_include_other1;
	}
	public String getAvg_da_other1() {
		return avg_da_other1;
	}
	public void setAvg_da_other1(String avg_da_other1) {
		this.avg_da_other1 = avg_da_other1;
	}
	public String getAvg_include_other2() {
		return avg_include_other2;
	}
	public void setAvg_include_other2(String avg_include_other2) {
		this.avg_include_other2 = avg_include_other2;
	}
	public String getAvg_da_other2() {
		return avg_da_other2;
	}
	public void setAvg_da_other2(String avg_da_other2) {
		this.avg_da_other2 = avg_da_other2;
	}
	public String getAvg_include_other3() {
		return avg_include_other3;
	}
	public void setAvg_include_other3(String avg_include_other3) {
		this.avg_include_other3 = avg_include_other3;
	}
	public String getAvg_da_other3() {
		return avg_da_other3;
	}
	public void setAvg_da_other3(String avg_da_other3) {
		this.avg_da_other3 = avg_da_other3;
	}
	public Integer getMax_dcrg_amt() {
		return Max_dcrg_amt;
	}
	public void setMax_dcrg_amt(Integer max_dcrg_amt) {
		Max_dcrg_amt = max_dcrg_amt;
	}
	public Integer getFinaltotppamount() {
		return finaltotppamount;
	}
	public void setFinaltotppamount(Integer finaltotppamount) {
		this.finaltotppamount = finaltotppamount;
	}
	
	
	
	
	
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public Timestamp getUnlockedDate() {
		return unlockedDate;
	}
	public void setUnlockedDate(Timestamp unlockedDate) {
		this.unlockedDate = unlockedDate;
	}
	public String getUnlockedBy() {
		return unlockedBy;
	}
	public void setUnlockedBy(String unlockedBy) {
		this.unlockedBy = unlockedBy;
	}
	public Integer getDa_percentage() {
		return da_percentage;
	}
	public void setDa_percentage(Integer da_percentage) {
		this.da_percentage = da_percentage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}