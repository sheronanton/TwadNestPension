package com.nic.hrms.pension.model;

import java.io.Serializable;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CutOffEntryPension_dao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3695854034810132320L;
	
	public CutOffEntryPension_dao(){
		
	}
	

	
	private Integer ppoNo;
	private Integer employeeId;
	private String sex;
	private Integer titleId;
	private String dateOfBirth;
	private String pensionerInitial;
	private String pensionerName;
	private String idMark1;
	private String idMark2;
	private String dateOfRetirement;
	private Integer lastPayDrawnAmt;
	private Integer avgEmoulmentAmt;
	private String panNumber;
	private Integer bankId;
	private Integer desigServGrp;
	private Integer designationId;
	private String designationId1;
	private String lastWorkingOfficeLevel;
	private Integer lastWorkingOfficeId;
	private String cutOfEntryDate;
	private Integer currAccountOfficeId;
	private String currAccountOfficeId1;
	private Integer classPensionId;
	private Integer originalPensionAmt;
	private Integer reducedPensionAmt;
	private Integer dearnessPay;
	private Integer provisionalPensionAmt;
	private Integer dcrgAmt;
	private Integer dcrgPertReceived;
	private char commOpted;
	private String commReceived;
	private String commfactorOnethird;
	private Integer commFactorPert;
	private Integer commAmt;
	private String commPayDate;
	private String pshfSubscribed;
	private String familyPensionTillDate;
	private Integer familyPensionTillDateAmt;
	private Integer familyPensionAtferDateAmt;
	private String payCommissionRevisonFlag;
	private Integer grossServiceYrs;
	private Integer grossServiceMonth;
	private Integer grossServiceDays;
	private Integer totServiceYrs;	
	private Integer totServiceMonths;
	private Integer totServiceDays;
	private Integer quaServiceYrs;
	private Integer quaServiceMonths;
	private Integer quaServiceDays;
	private Integer nonquaServiceYrs;
	private Integer nonquaServiceMonths;
	private Integer nonquaServiceDays;
	private Integer weightageServiceYrs;
	private Integer weightageServiceMonths;
	private Integer weightageServiceDays;
	private Integer netquaServiceYrs;
	private Integer netquaServiceMonths;
	private Integer netquaServiceDays;
	private String address;
	private String district;
	private String state;
	private String pincode;
	private String contactLandline;
	private String contactCell;
	private String faxNo;
	private String contactEmailId;
	private String pensionStatus;
	private String pensionNotPaidFrmMon;
	private String pensionNotPaidFrmYear;
	private String lastSignatureDate;
	private Integer branchId;
	private String branchId1;
	private String bankAcNo;
	private Integer paymentOfficeId;
	private String paymentOfficeId1;
	private String processStatus;
	private Date dateOfBirth1;
	private String dateOfBirth2;
	private Date dateOfRetirement1;
	private String dateOfRetirement2;
	private Date cutOfEntryDate1;
	private String cutOfEntryDate2;
	private Date commPayDate1;
	private String commPayDate2;
	private Date familyPensionTillDate1;
	private String familyPensionTillDate2;
	private Date lastSignatureDate1;
	private String lastSignatureDate2;
	private String bankPaymentMode;
	private String closed;
    private String updatedUserId;
	private Timestamp updatedDate;
	
	
    

    
	

	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getLastSignatureDate() {
		return lastSignatureDate;
	}

	public void setLastSignatureDate(String lastSignatureDate) {
		
		if(lastSignatureDate.trim() != null && lastSignatureDate.trim().length() > 0)
		{
			try
			{
			    DateFormat lastdate = new SimpleDateFormat("dd/MM/yyyy");
	            setLastSignatureDate1(lastdate.parse(lastSignatureDate));
	        }
			catch(Exception e)
			{       
	                 e.printStackTrace();        
	        }
		}
		this.lastSignatureDate = lastSignatureDate;
	}

	public Date getLastSignatureDate1() {
		return lastSignatureDate1;
	}

	public void setLastSignatureDate1(Date lastSignatureDate1) {
		if(lastSignatureDate1 != null )
		{
			try 
			{
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String lastsigdate = formatter.format(lastSignatureDate1);
		         setLastSignatureDate2(lastsigdate);
		    } 
			catch (Exception e)
		    {   
		        	e.printStackTrace();
		    }
		}
		this.lastSignatureDate1 = lastSignatureDate1;
	}

	public String getLastSignatureDate2() {
		return lastSignatureDate2;
	}

	public void setLastSignatureDate2(String lastSignatureDate2) {
		this.lastSignatureDate2 = lastSignatureDate2;
	}

	public String getFamilyPensionTillDate() {
		return familyPensionTillDate;
	}

	public Date getFamilyPensionTillDate1() {
		return familyPensionTillDate1;
	}

	public void setFamilyPensionTillDate1(Date familyPensionTillDate1) {
		if(familyPensionTillDate1 != null)
		{
			try 
			{
		         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		         String famdate = formatter.format(familyPensionTillDate1);
		         setFamilyPensionTillDate2(famdate);
		    }
			catch (Exception e)
		    {
		        	System.out.println("Exception :");
		        	e.printStackTrace();
		    }
	 }
		this.familyPensionTillDate1 = familyPensionTillDate1;
	}

	public String getFamilyPensionTillDate2() 
	{
		return familyPensionTillDate2;
	}

	public void setFamilyPensionTillDate2(String familyPensionTillDate2) 
	{
		this.familyPensionTillDate2 = familyPensionTillDate2;
	}

	public void setFamilyPensionTillDate(String familyPensionTillDate) 
	{		
		if(familyPensionTillDate.trim() != null && familyPensionTillDate.trim().length() >0)
		{
			try
			{
				DateFormat familydate = new SimpleDateFormat("dd/MM/yyyy");
				setFamilyPensionTillDate1(familydate.parse(familyPensionTillDate));
         	}
			catch(Exception e)
			{           
                 e.printStackTrace();        
         	}
		}
		this.familyPensionTillDate = familyPensionTillDate;
	}

	public String getCommPayDate() {
		return commPayDate;
	}

	public Date getCommPayDate1() {
		return commPayDate1;
	}
	
	public void setCommPayDate1(Date commPayDate1) 
	{
		if(commPayDate1 != null)
		{
			try 
			{
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String paydate = formatter.format(commPayDate1);
				setCommPayDate2(paydate);
	        } 
			catch (Exception e)			
			{				
				e.printStackTrace();
			}
		}
		this.commPayDate1 = commPayDate1;
	}
	
	public String getCommPayDate2() {
		return commPayDate2;
	}
	public void setCommPayDate2(String commPayDate2) {
		this.commPayDate2 = commPayDate2;
	}
	
	
	public void setCommPayDate(String commPayDate) 
	{
		if(commPayDate.trim() != null && commPayDate.trim().length() >0 )
		{
			try
			{          
				DateFormat compaydate = new SimpleDateFormat("dd/MM/yyyy");
				setCommPayDate1(compaydate.parse(commPayDate));
         	}
			catch(Exception e)
			{                
                 e.printStackTrace();
           	}
		}
		this.commPayDate = commPayDate;
	}
	public Date getCutOfEntryDate1() {
		return cutOfEntryDate1;
	}
	
	public void setCutOfEntryDate1(Date cutOfEntryDate1) 
	{
		if(cutOfEntryDate1 != null)
		{
			try 
			{
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String cutdate = formatter.format(cutOfEntryDate1);
				setCutOfEntryDate2(cutdate);
	        } 
		
			catch (Exception e)
			{				 
				e.printStackTrace();
			}
		}
		this.cutOfEntryDate1 = cutOfEntryDate1;
	}
	
	
	public String getCutOfEntryDate2() {
		return cutOfEntryDate2;
	}
	public void setCutOfEntryDate2(String cutOfEntryDate2) {
		this.cutOfEntryDate2 = cutOfEntryDate2;
	}
	
	public String getCutOfEntryDate() {
		return cutOfEntryDate;
	}
	
	public void setCutOfEntryDate(String cutOfEntryDate) {
		if(cutOfEntryDate.trim() != null && cutOfEntryDate.trim().length() >0)
		{
			try
			{				
				DateFormat datecutoff = new SimpleDateFormat("dd/MM/yyyy");
				setCutOfEntryDate1(datecutoff.parse(cutOfEntryDate));
         	}
			catch(Exception e)
			{            
                 e.printStackTrace();        
			}
		}
		this.cutOfEntryDate = cutOfEntryDate;
	}
	
	public Date getDateOfRetirement1() {
		return dateOfRetirement1;
	}
	
	
	public void setDateOfRetirement1(Date dateOfRetirement1) 
	{
		if(dateOfRetirement1 != null)
		{
			try 
			{
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String dor = formatter.format(dateOfRetirement1);
				setDateOfRetirement2(dor);
	        }
			catch (Exception e)
			{				
				e.printStackTrace();
			}
		}
		
		this.dateOfRetirement1 = dateOfRetirement1;
	}
	public String getDateOfRetirement2() {
		return dateOfRetirement2;
	}
	public void setDateOfRetirement2(String dateOfRetirement2) {
		
		this.dateOfRetirement2 = dateOfRetirement2;
	}
	public String getDateOfBirth2() {
		return dateOfBirth2;
	}
	public void setDateOfBirth2(String dateOfBirth2) {
		this.dateOfBirth2 = dateOfBirth2;
	}
	public Date getDateOfBirth1() {
		return dateOfBirth1;
	}
	public void setDateOfBirth1(Date dateOfBirth1) 
	{
		if(dateOfBirth1 != null)
		{
			try 
			{
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String dob1 = formatter.format(dateOfBirth1);
	            setDateOfBirth2(dob1);
	        }
			catch (Exception e)
			{				  
				e.printStackTrace();
			}
		
		}
		this.dateOfBirth1 = dateOfBirth1;
	}
	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) 
	{
		 if(dateOfBirth.trim() != null && dateOfBirth.trim().length() >0)
		 {
		   try
		   {               
               DateFormat dateofbirth = new SimpleDateFormat("dd/MM/yyyy");
               setDateOfBirth1(dateofbirth.parse(dateOfBirth));
		   }
		   catch(Exception e)
		   {         
                e.printStackTrace();               
           }
		 }
		this.dateOfBirth = dateOfBirth;
	 }
	
	
	public String getDateOfRetirement() {
		return dateOfRetirement;
	}
	public void setDateOfRetirement(String dateOfRetirement) 
	{
		if(dateOfRetirement.trim() != null && dateOfRetirement.trim().length()> 0  )
		{
			try
			{				
				DateFormat dateofretire = new SimpleDateFormat("dd/MM/yyyy");
				setDateOfRetirement1(dateofretire.parse(dateOfRetirement));
         	}
			catch(Exception e)
			{            
                 e.printStackTrace();        
         	}
		}
		this.dateOfRetirement = dateOfRetirement;
	}
	

	public Integer getPaymentOfficeId() {
		return paymentOfficeId;
	}
	public void setPaymentOfficeId(Integer paymentOfficeId) {
		this.paymentOfficeId = paymentOfficeId;
		setPaymentOfficeId1(""+paymentOfficeId);
	}
	
	
	
	
	
	public String getPaymentOfficeId1() {
		return paymentOfficeId1;
	}

	public void setPaymentOfficeId1(String paymentOfficeId1) {
		this.paymentOfficeId1 = paymentOfficeId1;
	}

	public String getPensionStatus() {
		return pensionStatus;
	}
	public void setPensionStatus(String pensionStatus) {
		this.pensionStatus = pensionStatus;
	}
	public String getPensionNotPaidFrmMon() {
		return pensionNotPaidFrmMon;
	}
	public void setPensionNotPaidFrmMon(String pensionNotPaidFrmMon) {
		this.pensionNotPaidFrmMon = pensionNotPaidFrmMon;
	}
	public String getPensionNotPaidFrmYear() {
		return pensionNotPaidFrmYear;
	}
	public void setPensionNotPaidFrmYear(String pensionNotPaidFrmYear) {
		this.pensionNotPaidFrmYear = pensionNotPaidFrmYear;
	}
	
	
	public String getBankAcNo() {
		return bankAcNo;
	}
	public void setBankAcNo(String bankAcNo) {
		this.bankAcNo = bankAcNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getContactLandline() {
		return contactLandline;
	}
	public void setContactLandline(String contactLandline) {
		this.contactLandline = contactLandline;
	}
	public String getContactCell() {
		return contactCell;
	}
	public void setContactCell(String contactCell) {
		this.contactCell = contactCell;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getContactEmailId() {
		return contactEmailId;
	}
	public void setContactEmailId(String contactEmailId) {
		this.contactEmailId = contactEmailId;
	}
	
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	

	public String getPensionerInitial() {
		return pensionerInitial;
	}

	public void setPensionerInitial(String pensionerInitial) {
		this.pensionerInitial = pensionerInitial;
	}

	public String getPensionerName() {
		return pensionerName;
	}

	public void setPensionerName(String pensionerName) {
		this.pensionerName = pensionerName;
	}

	public String getIdMark1() {
		return idMark1;
	}

	public void setIdMark1(String idMark1) {
		this.idMark1 = idMark1;
	}

	public String getIdMark2() {
		return idMark2;
	}

	public void setIdMark2(String idMark2) {
		this.idMark2 = idMark2;
	}

	

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	
	public String getLastWorkingOfficeLevel() {
		return lastWorkingOfficeLevel;
	}

	public void setLastWorkingOfficeLevel(String lastWorkingOfficeLevel) {
		this.lastWorkingOfficeLevel = lastWorkingOfficeLevel;
	}

	
	public Integer getCurrAccountOfficeId() {
		return currAccountOfficeId;
	}

	public void setCurrAccountOfficeId(Integer currAccountOfficeId) {
		this.currAccountOfficeId = currAccountOfficeId;
		setCurrAccountOfficeId1(""+currAccountOfficeId);
	}

	

	public char getCommOpted() {
		return commOpted;
	}

	public void setCommOpted(char commOpted) {
		this.commOpted = commOpted;
	}

	public String getCommReceived() {
		return commReceived;
	}

	public void setCommReceived(String commReceived) {
		this.commReceived = commReceived;
	}

	public String getCommfactorOnethird() {
		return commfactorOnethird;
	}

	public void setCommfactorOnethird(String commfactorOnethird) {
		this.commfactorOnethird = commfactorOnethird;
	}

	public String getPshfSubscribed() {
		return pshfSubscribed;
	}

	public void setPshfSubscribed(String pshfSubscribed) {
		this.pshfSubscribed = pshfSubscribed;
	}

	public String getPayCommissionRevisonFlag() {
		return payCommissionRevisonFlag;
	}

	public void setPayCommissionRevisonFlag(String payCommissionRevisonFlag) {
		this.payCommissionRevisonFlag = payCommissionRevisonFlag;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getBankPaymentMode() {
		return bankPaymentMode;
	}

	public void setBankPaymentMode(String bankPaymentMode) {
		this.bankPaymentMode = bankPaymentMode;
	}

	
	public void setCurrAccountOfficeId1(String currAccountOfficeId1) {
		this.currAccountOfficeId1 = currAccountOfficeId1;
	}

	public String getCurrAccountOfficeId1() {
		return currAccountOfficeId1;
	}

	public void setDesignationId1(String designationId1) {
		this.designationId1 = designationId1;
	}

	public String getDesignationId1() {
		return designationId1;
	}

	public void setBranchId1(String branchId1) {
		this.branchId1 = branchId1;
	}

	public String getBranchId1() {
		return branchId1;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getPpoNo() {
		return ppoNo;
	}

	public void setPpoNo(Integer ppoNo) {
		this.ppoNo = ppoNo;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getLastPayDrawnAmt() {
		return lastPayDrawnAmt;
	}

	public void setLastPayDrawnAmt(Integer lastPayDrawnAmt) {
		this.lastPayDrawnAmt = lastPayDrawnAmt;
	}

	public Integer getAvgEmoulmentAmt() {
		return avgEmoulmentAmt;
	}

	public void setAvgEmoulmentAmt(Integer avgEmoulmentAmt) {
		this.avgEmoulmentAmt = avgEmoulmentAmt;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Integer getDesigServGrp() {
		return desigServGrp;
	}

	public void setDesigServGrp(Integer desigServGrp) {
		this.desigServGrp = desigServGrp;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
		setDesignationId1(""+designationId);
		
	}

	public Integer getLastWorkingOfficeId() {
		return lastWorkingOfficeId;
	}

	public void setLastWorkingOfficeId(Integer lastWorkingOfficeId) {
		this.lastWorkingOfficeId = lastWorkingOfficeId;
	}

	public Integer getClassPensionId() {
		return classPensionId;
	}

	public void setClassPensionId(Integer classPensionId) {
		this.classPensionId = classPensionId;
	}

	public Integer getOriginalPensionAmt() {
		return originalPensionAmt;
	}

	public void setOriginalPensionAmt(Integer originalPensionAmt) {
		this.originalPensionAmt = originalPensionAmt;
	}

	public Integer getReducedPensionAmt() {
		return reducedPensionAmt;
	}

	public void setReducedPensionAmt(Integer reducedPensionAmt) {
		this.reducedPensionAmt = reducedPensionAmt;
	}

	public Integer getDearnessPay() {
		return dearnessPay;
	}

	public void setDearnessPay(Integer dearnessPay) {
		this.dearnessPay = dearnessPay;
	}

	public Integer getProvisionalPensionAmt() {
		return provisionalPensionAmt;
	}

	public void setProvisionalPensionAmt(Integer provisionalPensionAmt) {
		this.provisionalPensionAmt = provisionalPensionAmt;
	}

	public Integer getDcrgAmt() {
		return dcrgAmt;
	}

	public void setDcrgAmt(Integer dcrgAmt) {
		this.dcrgAmt = dcrgAmt;
	}

	public Integer getDcrgPertReceived() {
		return dcrgPertReceived;
	}

	public void setDcrgPertReceived(Integer dcrgPertReceived) {
		this.dcrgPertReceived = dcrgPertReceived;
	}

	public Integer getCommFactorPert() {
		return commFactorPert;
	}

	public void setCommFactorPert(Integer commFactorPert) {
		this.commFactorPert = commFactorPert;
	}

	public Integer getCommAmt() {
		return commAmt;
	}

	public void setCommAmt(Integer commAmt) {
		this.commAmt = commAmt;
	}

	public Integer getFamilyPensionTillDateAmt() {
		return familyPensionTillDateAmt;
	}

	public void setFamilyPensionTillDateAmt(Integer familyPensionTillDateAmt) {
		this.familyPensionTillDateAmt = familyPensionTillDateAmt;
	}

	public Integer getFamilyPensionAtferDateAmt() {
		return familyPensionAtferDateAmt;
	}

	public void setFamilyPensionAtferDateAmt(Integer familyPensionAtferDateAmt) {
		this.familyPensionAtferDateAmt = familyPensionAtferDateAmt;
	}

	public Integer getGrossServiceYrs() {
		return grossServiceYrs;
	}

	public void setGrossServiceYrs(Integer grossServiceYrs) {
		this.grossServiceYrs = grossServiceYrs;
	}

	public Integer getGrossServiceMonth() {
		return grossServiceMonth;
	}

	public void setGrossServiceMonth(Integer grossServiceMonth) {
		this.grossServiceMonth = grossServiceMonth;
	}

	public Integer getGrossServiceDays() {
		return grossServiceDays;
	}

	public void setGrossServiceDays(Integer grossServiceDays) {
		this.grossServiceDays = grossServiceDays;
	}

	public Integer getTotServiceYrs() {
		return totServiceYrs;
	}

	public void setTotServiceYrs(Integer totServiceYrs) {
		this.totServiceYrs = totServiceYrs;
	}

	public Integer getTotServiceMonths() {
		return totServiceMonths;
	}

	public void setTotServiceMonths(Integer totServiceMonths) {
		this.totServiceMonths = totServiceMonths;
	}

	public Integer getTotServiceDays() {
		return totServiceDays;
	}

	public void setTotServiceDays(Integer totServiceDays) {
		this.totServiceDays = totServiceDays;
	}

	public Integer getQuaServiceYrs() {
		return quaServiceYrs;
	}

	public void setQuaServiceYrs(Integer quaServiceYrs) {
		this.quaServiceYrs = quaServiceYrs;
	}

	public Integer getQuaServiceMonths() {
		return quaServiceMonths;
	}

	public void setQuaServiceMonths(Integer quaServiceMonths) {
		this.quaServiceMonths = quaServiceMonths;
	}

	public Integer getQuaServiceDays() {
		return quaServiceDays;
	}

	public void setQuaServiceDays(Integer quaServiceDays) {
		this.quaServiceDays = quaServiceDays;
	}

	public Integer getNonquaServiceYrs() {
		return nonquaServiceYrs;
	}

	public void setNonquaServiceYrs(Integer nonquaServiceYrs) {
		this.nonquaServiceYrs = nonquaServiceYrs;
	}

	public Integer getNonquaServiceMonths() {
		return nonquaServiceMonths;
	}

	public void setNonquaServiceMonths(Integer nonquaServiceMonths) {
		this.nonquaServiceMonths = nonquaServiceMonths;
	}

	public Integer getNonquaServiceDays() {
		return nonquaServiceDays;
	}

	public void setNonquaServiceDays(Integer nonquaServiceDays) {
		this.nonquaServiceDays = nonquaServiceDays;
	}

	public Integer getWeightageServiceYrs() {
		return weightageServiceYrs;
	}

	public void setWeightageServiceYrs(Integer weightageServiceYrs) {
		this.weightageServiceYrs = weightageServiceYrs;
	}

	public Integer getWeightageServiceMonths() {
		return weightageServiceMonths;
	}

	public void setWeightageServiceMonths(Integer weightageServiceMonths) {
		this.weightageServiceMonths = weightageServiceMonths;
	}

	public Integer getWeightageServiceDays() {
		return weightageServiceDays;
	}

	public void setWeightageServiceDays(Integer weightageServiceDays) {
		this.weightageServiceDays = weightageServiceDays;
	}

	public Integer getNetquaServiceYrs() {
		return netquaServiceYrs;
	}

	public void setNetquaServiceYrs(Integer netquaServiceYrs) {
		this.netquaServiceYrs = netquaServiceYrs;
	}

	public Integer getNetquaServiceMonths() {
		return netquaServiceMonths;
	}

	public void setNetquaServiceMonths(Integer netquaServiceMonths) {
		this.netquaServiceMonths = netquaServiceMonths;
	}

	public Integer getNetquaServiceDays() {
		return netquaServiceDays;
	}

	public void setNetquaServiceDays(Integer netquaServiceDays) {
		this.netquaServiceDays = netquaServiceDays;
	}

	
	/*public void setPaymentOfficeId(Integer paymentOfficeId) {
		this.paymentOfficeId = paymentOfficeId;
	}*/

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		setBranchId1(branchId+"");
		this.branchId = branchId;
	}

	
	

	
	
	
}	