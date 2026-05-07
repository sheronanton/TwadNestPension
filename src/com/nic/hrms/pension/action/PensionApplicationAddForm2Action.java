package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.CommonSearchModel;
import com.nic.hrms.pension.model.PensionApplicationForm2Dao;
import com.nic.hrms.pension.model.PensionApplicationIndividualNominee;
import com.nic.hrms.pension.model.PensionApplicationIndividualNotVerServ;
import com.nic.hrms.pension.model.PensionApplicationNomineeDao;
import com.nic.hrms.pension.model.PensionApplicationNotVerifyServDetailsDao;
import com.nic.hrms.pension.model.PensionApplicationSearchModel;
import com.nic.hrms.pension.service.OfficeId_service;
import com.nic.hrms.pension.service.PensionApplicationAddForm2Service;
import com.nic.hrms.pension.service.PensionApplicationEditForm2Service;
import com.nic.hrms.pension.service.UpdatedUserIdService;

public class PensionApplicationAddForm2Action extends BaseAction
{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = -4225485652699018126L;

	private PensionApplicationForm2Dao addpenappco;
	private OfficeId_service officeIdservice;
	private UpdatedUserIdService updateservice;
	
	private Integer empNo;
	private List<String> nomineeInitial;
	private List<String> familyMembers;	
	private List<String> relation;	
	private List<String> nomineeDob;	
	private List<Integer> nomineeAge;
	private List<String> handicapped;
	private List<String> martialStatus;
	private List<String> nominationDate;
	private List<String> activeStatus;
	private List<String> nominReason;	
	
	private List<String> notVerifyServFromDate;
	private List<String> notVerifyServToDate;
	private List<String> notVerifyServiceReason;
	private List<Integer> notVerifyYear;
	private List<Integer> notVerifyMonth;
	private List<Integer> notVerifyDays;
	private String checkStatus;
	
	private List<PensionApplicationNomineeDao> nomineeList;
	private PensionApplicationAddForm2Service penappform2service;	
	private List<PensionApplicationNotVerifyServDetailsDao> notVerifyList;
	private PensionApplicationEditForm2Service penAppEditService;
	
	private CommonSearchModel penAppAdd;
	
	private List<Object[]> loadIndividualDataList;
	private List<PensionApplicationIndividualNominee> loadIndividualNominList;
	private List<PensionApplicationIndividualNotVerServ> loadIndividualNVSerList;
	
	private PensionApplicationSearchModel loadindi;
	
	
	@SuppressWarnings("unchecked")
	public String saveForm2()
	{
		boolean saveFlag=false;
		try
		{
			
			   HttpSession session=getRequest().getSession();
		       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		       int empId=empProfile.getEmployeeId();
		       
			   int officeId = officeIdservice.getOfficeId(empId);				
			   String updatedId=updateservice.getUpdateId(empId);			   
			   
			if(familyMembers != null && familyMembers.size()!= 0)
			{
				
				Iterator iter1 = nomineeInitial.iterator();
				Iterator iter = familyMembers.iterator();
				Iterator iter3 = relation.iterator();				
				Iterator iter4 = nomineeDob.iterator();
				Iterator iter5 = nomineeAge.iterator();
				Iterator iter6 = handicapped.iterator();
				Iterator iter7 = martialStatus.iterator();
				Iterator iter8 = nominationDate.iterator();
				Iterator iter9 = activeStatus.iterator();
				Iterator iter10 = nominReason.iterator();
			    
				PensionApplicationNomineeDao multidata=null;
				nomineeList = new ArrayList<PensionApplicationNomineeDao>();
			    
			     while(iter.hasNext()){
			    	multidata = new PensionApplicationNomineeDao();	
			    	multidata.setEmpNo(addpenappco.getEmpNo());
			    	multidata.setFamilyMembers((String)iter.next());
			    	multidata.setNomineeInitial((String)iter1.next());
			    	multidata.setRelation((String)iter3.next());
			    	multidata.setNomineeDob((String)iter4.next());
			    	multidata.setNomineeAge((Integer)iter5.next());
			    	multidata.setHandicapped((String)iter6.next());
			    	multidata.setMartialStatus((String)iter7.next());
			    	multidata.setNominationDate((String)iter8.next());
			    	multidata.setActiveStatus((String)iter9.next());
			    	multidata.setNominReason((String)iter10.next());
			    
			    	multidata.setUpdatedUserId(updatedId);
			    	multidata.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidata.setProcessStatus("ENTERED");
			    	nomineeList.add(multidata);
			    	
		        }
			     
			     penappform2service.saveAddnominee(nomineeList);
			     
			}
			
		
		
			if(checkStatus.equalsIgnoreCase("yes"))
			{				
				addpenappco.setProcessStatus("PARTIAL");						
			}			
			if(checkStatus.equalsIgnoreCase("no"))
			{
				addpenappco.setProcessStatus("ENTERED");
			}			
			addpenappco.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			addpenappco.setUpdatedUser(updatedId);
			
			saveFlag=penappform2service.saveOrUpdateData(addpenappco);
		
			if(notVerifyServFromDate!=null && notVerifyServFromDate.size()>0)
			{
				
				Iterator it1=notVerifyServFromDate.iterator();
				Iterator it2=notVerifyServToDate.iterator();
				Iterator it3=notVerifyServiceReason.iterator();
				Iterator it4=notVerifyYear.iterator();
				Iterator it5=notVerifyMonth.iterator();
				Iterator it6=notVerifyDays.iterator();
				
			
				PensionApplicationNotVerifyServDetailsDao multidata2=null;
				notVerifyList = new ArrayList<PensionApplicationNotVerifyServDetailsDao>();
		
				while(it1.hasNext())
				{
					multidata2=new PensionApplicationNotVerifyServDetailsDao();
					multidata2.setEmpNo(addpenappco.getEmpNo());
					multidata2.setNotVerifyServFromDate((String) it1.next());
					multidata2.setNotVerifyServToDate((String) it2.next());
					multidata2.setNotVerifyServiceReason((String)it3.next());
					multidata2.setNotVerifyYear((Integer)it4.next());
					multidata2.setNotVerifyMonth((Integer)it5.next());
					multidata2.setNotVerifyDays((Integer)it6.next());							
					
					multidata2.setUpdatedUserId(updatedId);
			    	multidata2.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			    	multidata2.setProcessStatus("ENTERED");
			    	notVerifyList.add(multidata2);
				}
				
				penappform2service.saveNotVerifyService(notVerifyList);
			}
			
		
		}
			
			
			
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		
		if(!saveFlag)
			return ERROR;
		else
			return SUCCESS;
		
	}


	
public String getAppIndividualData()
{	
	
	try
	{
		boolean mypenAppFlag2 = false;
		
		HttpSession session=getRequest().getSession();
	    UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
	    int loginEmpId=empProfile.getEmployeeId();	    
	    
	    int officeId = officeIdservice.getOfficeId(loginEmpId);	   	 // login employee ofice id	    
	    int empId=loadindi.getEmpId();	    						// from text field 
	    
	    loadIndividualDataList=penappform2service.getIndividualPersonnelData(empId, officeId);
	    loadIndividualNominList=penappform2service.getIndividualNominee(empId);
	    loadIndividualNVSerList=penappform2service.getIndividualNVService(empId);
	    
	   
	    StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		xmlString.append("<response>");			
		xmlString.append("<command>loadIndividualData</command>");
		    
	    for(Object[] tl: loadIndividualDataList)
		 {
			Object[] temp=tl;
   	     	 xmlString.append("<commondata>");				 
			 xmlString.append("<empNo>" +temp[0]+ "</empNo>");
			 xmlString.append("<fatherName>" +temp[1]+ "</fatherName>");
			 xmlString.append("<husbandName>" +temp[2]+ "</husbandName>");
			 xmlString.append("<religion>" +temp[3]+ "</religion>");
			 xmlString.append("<nationality>" +temp[4]+ "</nationality>");
			 xmlString.append("<empHeight>" +temp[5]+ "</empHeight>");
			 xmlString.append("<id1>" +temp[6]+ "</id1>");
			 xmlString.append("<id2>" +temp[7]+ "</id2>");
			 xmlString.append("<presentAddress>" +temp[8]+ "</presentAddress>");
			 xmlString.append("<permanentAddress>" +temp[9]+ "</permanentAddress>");
			 xmlString.append("<addressAfterRetire>" +temp[10]+ "</addressAfterRetire>");
			 xmlString.append("<state>" +temp[11]+ "</state>");
			 xmlString.append("<chargeFlag>" +temp[12]+ "</chargeFlag>");
			 xmlString.append("<chargeDesc>" +temp[13]+ "</chargeDesc>");
			 xmlString.append("<payOffice>" +temp[14]+ "</payOffice>");			 
			
			 if(temp[15]!=null)
			 {
				 DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
				 String strDate=df.format(temp[15]);
				 xmlString.append("<appDate>" +strDate+ "</appDate>");
			 }
			 xmlString.append("<appDate>"+temp[15]+"</appDate>");
			 
			 xmlString.append("<dcrgNominName>" +temp[16]+ "</dcrgNominName>");
			 
			 if(temp[15]!=null)
			 {
				 DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
				 String strDate1=df.format(temp[17]);
				 xmlString.append("<dcrgNomineeDob>" +strDate1+ "</dcrgNomineeDob>");
			 }
			 else
			 {
				 xmlString.append("<dcrgNomineeDob>" +temp[15]+ "</dcrgNomineeDob>");

			 }
			 xmlString.append("<dcrgNomineeRelation>" +temp[18]+ "</dcrgNomineeRelation>");
			 xmlString.append("<dcrgNomineeAddress>" +temp[19]+ "</dcrgNomineeAddress>");
			 xmlString.append("<notVerTotYear>" +temp[20]+ "</notVerTotYear>");
			 xmlString.append("<notVerTotMonth>" +temp[21]+ "</notVerTotMonth>");
			 xmlString.append("<notVerTotDays>" +temp[22]+ "</notVerTotDays>");			 
			 xmlString.append("</commondata>");	
			 mypenAppFlag2=true;
      }
	    
	    
	    for(PensionApplicationIndividualNominee t2: loadIndividualNominList)
		 {
	    	xmlString.append("<nomindata>");
	    	xmlString.append("<nominId>"+t2.getNomineeId()+"</nominId>");	    	
	    	xmlString.append("<nominInitial>"+t2.getNomineeInitial()+"</nominInitial>");
	    	xmlString.append("<nominName>"+t2.getFamilyMembers()+"</nominName>");
	    	xmlString.append("<nominRelation>"+t2.getRelation()+"</nominRelation>");
	    	xmlString.append("<nominDob>"+t2.getNomineeDob2()+"</nominDob>");
	    	xmlString.append("<nominAge>"+t2.getNomineeAge()+"</nominAge>");
	    	xmlString.append("<nominHandy>"+t2.getHandicapped()+"</nominHandy>");
	    	xmlString.append("<nominMartial>"+t2.getMartialStatus()+"</nominMartial>");
	    	xmlString.append("<nominDate>"+t2.getNominationDate2()+"</nominDate>");
	    	xmlString.append("<nominStatus>"+t2.getActiveStatus()+"</nominStatus>");
	    	xmlString.append("<nominReason>"+t2.getNominReason()+"</nominReason>");
	    	xmlString.append("</nomindata>");
		 }
	    
	 		
	    for(PensionApplicationIndividualNotVerServ t3: loadIndividualNVSerList)
		 {
	    	xmlString.append("<servicedata>");
	    	xmlString.append("<startDate>"+t3.getNotVerifyServFromDate2()+"</startDate>");
	    	xmlString.append("<endDate>"+t3.getNotVerifyServToDate2()+"</endDate>");
	    	xmlString.append("<reason>"+t3.getNotVerifyServiceReason()+"</reason>");
	    	xmlString.append("<totYear>"+t3.getNotVerifyYear()+"</totYear>");
	    	xmlString.append("<totMonth>"+t3.getNotVerifyMonth()+"</totMonth>");
	    	xmlString.append("<totDays>"+t3.getNotVerifyDays()+"</totDays>");	    	
	    	xmlString.append("</servicedata>");
		 }
	    
	    
	    if(mypenAppFlag2)
	    {
	    	xmlString.append("<flag>success</flag>");
	    }
	    else
	    {
	    	xmlString.append("<flag>fail</flag>");
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
	




public String addSearch()
{
	System.out.println("key"+penAppAdd.getSearchKeyword());
	System.out.println("opt"+penAppAdd.getSearchOption());
	
	List<Object[]> myListAdd = null;
	int empId=0;
	boolean mypenAppFlag2 = false;
	try
	{
		StringBuffer xmlString = new StringBuffer();
		PrintWriter out = getResponse().getWriter();
		xmlString.append("<response>");	
		
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		empId=empProfile.getEmployeeId();
			
		String opt=penAppAdd.getSearchOption();
		String key=penAppAdd.getSearchKeyword();
		
		myListAdd=penAppEditService.getListEmpAdd(opt,key,empId);	
		
		xmlString.append("<command>addsearch</command>");
	
	    
	    for(Object[] tl: myListAdd)
		 {
			Object[] temp=tl;
   	     	 xmlString.append("<record>");				 
			 xmlString.append("<employeeId>" +temp[0]+ "</employeeId>");
			 xmlString.append("<employeeName>" +temp[1]+ "</employeeName>");			 
			 xmlString.append("</record>");	
			 mypenAppFlag2=true;
      }
	    
	    if(mypenAppFlag2)
	    {
	    	xmlString.append("<flag>success</flag>");
	    }
	    else
	    {
	    	xmlString.append("<flag>fail</flag>");
	    }
	    
	     xmlString.append("</response>");
		 getResponse().setContentType("text/xml");
		 System.out.println(xmlString.toString());
		 out.println(xmlString.toString());
		 out.flush();
		 out.close();
		 
		
	}
	catch (Exception e) 
	{
			e.printStackTrace();
			return ERROR;
	}
	
	
	return SUCCESS;
}



	public PensionApplicationForm2Dao getAddpenappco() {
		return addpenappco;
	}





	public void setAddpenappco(PensionApplicationForm2Dao addpenappco) {
		this.addpenappco = addpenappco;
	}





	public OfficeId_service getOfficeIdservice() {
		return officeIdservice;
	}




	public void setOfficeIdservice(OfficeId_service officeIdservice) {
		this.officeIdservice = officeIdservice;
	}




	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}




	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}




	



	public List<String> getNomineeInitial() {
		return nomineeInitial;
	}




	public void setNomineeInitial(List<String> nomineeInitial) {
		this.nomineeInitial = nomineeInitial;
	}




	public List<String> getFamilyMembers() {
		return familyMembers;
	}




	public void setFamilyMembers(List<String> familyMembers) {
		this.familyMembers = familyMembers;
	}




	public List<String> getRelation() {
		return relation;
	}




	public void setRelation(List<String> relation) {
		this.relation = relation;
	}




	public List<String> getNomineeDob() {
		return nomineeDob;
	}




	public void setNomineeDob(List<String> nomineeDob) {
		this.nomineeDob = nomineeDob;
	}




	public List<Integer> getNomineeAge() {
		return nomineeAge;
	}




	public void setNomineeAge(List<Integer> nomineeAge) {
		this.nomineeAge = nomineeAge;
	}




	public List<String> getHandicapped() {
		return handicapped;
	}




	public void setHandicapped(List<String> handicapped) {
		this.handicapped = handicapped;
	}




	public List<String> getMartialStatus() {
		return martialStatus;
	}




	public void setMartialStatus(List<String> martialStatus) {
		this.martialStatus = martialStatus;
	}




	public List<String> getNominationDate() {
		return nominationDate;
	}




	public void setNominationDate(List<String> nominationDate) {
		this.nominationDate = nominationDate;
	}




	public List<String> getActiveStatus() {
		return activeStatus;
	}




	public void setActiveStatus(List<String> activeStatus) {
		this.activeStatus = activeStatus;
	}




	public List<String> getNominReason() {
		return nominReason;
	}




	public void setNominReason(List<String> nominReason) {
		this.nominReason = nominReason;
	}




	public List<PensionApplicationNomineeDao> getNomineeList() {
		return nomineeList;
	}




	public void setNomineeList(List<PensionApplicationNomineeDao> nomineeList) {
		this.nomineeList = nomineeList;
	}




	public void setPenappform2service(PensionApplicationAddForm2Service penappform2service) {
		this.penappform2service = penappform2service;
	}




	public PensionApplicationAddForm2Service getPenappform2service() {
		return penappform2service;
	}











	public Integer getEmpNo() {
		return empNo;
	}





	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}










	public List<String> getNotVerifyServFromDate() {
		return notVerifyServFromDate;
	}





	public void setNotVerifyServFromDate(List<String> notVerifyServFromDate) {
		this.notVerifyServFromDate = notVerifyServFromDate;
	}





	public List<String> getNotVerifyServToDate() {
		return notVerifyServToDate;
	}





	public void setNotVerifyServToDate(List<String> notVerifyServToDate) {
		this.notVerifyServToDate = notVerifyServToDate;
	}





	public List<String> getNotVerifyServiceReason() {
		return notVerifyServiceReason;
	}





	public void setNotVerifyServiceReason(List<String> notVerifyServiceReason) {
		this.notVerifyServiceReason = notVerifyServiceReason;
	}





	public List<Integer> getNotVerifyYear() {
		return notVerifyYear;
	}





	public void setNotVerifyYear(List<Integer> notVerifyYear) {
		this.notVerifyYear = notVerifyYear;
	}





	




	public List<Integer> getNotVerifyMonth() {
		return notVerifyMonth;
	}





	public void setNotVerifyMonth(List<Integer> notVerifyMonth) {
		this.notVerifyMonth = notVerifyMonth;
	}





	public List<Integer> getNotVerifyDays() {
		return notVerifyDays;
	}





	public void setNotVerifyDays(List<Integer> notVerifyDays) {
		this.notVerifyDays = notVerifyDays;
	}





	public void setNotVerifyList(List<PensionApplicationNotVerifyServDetailsDao> notVerifyList) {
		this.notVerifyList = notVerifyList;
	}





	public List<PensionApplicationNotVerifyServDetailsDao> getNotVerifyList() {
		return notVerifyList;
	}





	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}





	public String getCheckStatus() {
		return checkStatus;
	}



	public void setPenAppAdd(CommonSearchModel penAppAdd) {
		this.penAppAdd = penAppAdd;
	}



	public CommonSearchModel getPenAppAdd() {
		return penAppAdd;
	}



	public void setPenAppEditService(PensionApplicationEditForm2Service penAppEditService) {
		this.penAppEditService = penAppEditService;
	}



	public PensionApplicationEditForm2Service getPenAppEditService() {
		return penAppEditService;
	}



	public void setLoadIndividualDataList(List<Object[]> loadIndividualDataList) {
		this.loadIndividualDataList = loadIndividualDataList;
	}



	public List<Object[]> getLoadIndividualDataList() {
		return loadIndividualDataList;
	}



	public PensionApplicationSearchModel getLoadindi() {
		return loadindi;
	}



	public void setLoadindi(PensionApplicationSearchModel loadindi) {
		this.loadindi = loadindi;
	}



	public List<PensionApplicationIndividualNominee> getLoadIndividualNominList() {
		return loadIndividualNominList;
	}



	public void setLoadIndividualNominList(
			List<PensionApplicationIndividualNominee> loadIndividualNominList) {
		this.loadIndividualNominList = loadIndividualNominList;
	}



	public void setLoadIndividualNVSerList(List<PensionApplicationIndividualNotVerServ> loadIndividualNVSerList) {
		this.loadIndividualNVSerList = loadIndividualNVSerList;
	}



	public List<PensionApplicationIndividualNotVerServ> getLoadIndividualNVSerList() {
		return loadIndividualNVSerList;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
