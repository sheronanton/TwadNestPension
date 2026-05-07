package com.nic.hrms.pension.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpSession;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.ChangeNominee_dao;
import com.nic.hrms.pension.service.AddChangeNomineeService;
import com.nic.hrms.pension.service.UpdatedUserIdService;



public class AddChangeNomineeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UpdatedUserIdService updateservice;
	
	
	AddChangeNomineeService addChangeNomineeService;
	public AddChangeNomineeService getAddChangeNomineeService() {
		return addChangeNomineeService;
	}


	public void setAddChangeNomineeService(
			AddChangeNomineeService addChangeNomineeService) {
		this.addChangeNomineeService = addChangeNomineeService;
	}
	private List<String> familyMembers;
	private List<String> nomineeInitial;
	private List<String> relation;
	private List<Date> dob;
	private List<String> dobStr;
	public List<String> getDobStr() {
		return dobStr;
	}


	public void setDobStr(List<String> dobStr) {
		this.dobStr = dobStr;
		//The Date format is dd/MM/yyyy
		try{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<Date> tmpDate=new ArrayList<Date>(dobStr.size());
			for(String tmp:dobStr)
			{
				//setting null if it is tmp is null
				System.out.println("The New Date tmp----"+tmp);
				tmpDate.add(tmp==null || tmp.trim().length()==0?null:df.parse(tmp));
			}
			setDob(tmpDate);
			System.out.println("Date settes succesfully");
		}
		catch(Exception e)
		{
			System.out.println("Excep in date setting---->Baabu"+e);
		}
		
	}
	private List<Integer> age;
	private List<Integer> nomineeID;
	private List<String> maritalStatus;
	private int ppoNo;
	private List<String> handicapped;
	private String updatedBy;
	private List<String> nominationDateStr;
	private List<Date> nominationDate;
	private List<String> deletedReason;
	
	
	public String addChange()
	{
		String  retn=null;
		try
		{
		System.out.println("hi..");
		
		List<ChangeNominee_dao> myLi=new ArrayList<ChangeNominee_dao>();
		
		HttpSession session=getRequest().getSession();
		UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
		int empId=empProfile.getEmployeeId();	
		String updatedId=updateservice.getUpdateId(empId);
		
		for(int i=0;i<familyMembers.size();i++)
		{
			ChangeNominee_dao cDao=new ChangeNominee_dao();
			cDao.setAge(age.get(i));
			cDao.setDob(dob.get(i));
			cDao.setFamilyMembers(familyMembers.get(i));
			cDao.setNomineeInitial(nomineeInitial.get(i));
			cDao.setHandicapped(handicapped.get(i));
			cDao.setMaritalStatus(maritalStatus.get(i));
			cDao.setNomineeID(nomineeID.get(i));
			cDao.setPpoNo(ppoNo);
			cDao.setNominationDate(nominationDate.get(i));
			cDao.setDeletedReason(deletedReason.get(i));
			cDao.setRelation(relation.get(i));
			
			cDao.setProcessStatus("VALIDATE");
			cDao.setUpdatedBy(updatedId);
			cDao.setUnlockedBy(updatedId);
			cDao.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			cDao.setUnlockedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			
			myLi.add(cDao);
			
		}
		retn=addChangeNomineeService.addChangeNominee(myLi)?"y":"n";
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("The bug from Action nominee change--"+e);
		}
		return retn;
	}
	
	
	
	
	
	public List<String> getDeletedReason() {
		return deletedReason;
	}


	public void setDeletedReason(List<String> deletedReason) {
		this.deletedReason = deletedReason;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public List<String> getNominationDateStr() {
		return nominationDateStr;
	}


	public void setNominationDateStr(List<String> nominationDateStr) {
		this.nominationDateStr = nominationDateStr;
		try{
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			List<Date> tmpDate=new ArrayList<Date>(nominationDateStr.size());
				for(String tmp:nominationDateStr)
				{
					
					tmpDate.add(df.parse(tmp));
				}
				setNominationDate(tmpDate);
				System.out.println("Nomimnation Date sets succesfully");
			}
			catch(Exception e)
			{
				System.out.println("Excep in date setting"+e);
			}
	}


	public List<Date> getNominationDate() {
		return nominationDate;
	}


	public void setNominationDate(List<Date> nominationDate) {
		this.nominationDate = nominationDate;
	}


	public String  validateChange()
	{
		String  retn=null;
		try
		{
			if(addChangeNomineeService.deleteChangeNominee(ppoNo))
			{
				if(addChange().equalsIgnoreCase("y"))
				retn=addChangeNomineeService.validateChangeNominee(ppoNo)?"y":"n";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("The bug--"+e);
		}
		return retn;
		
	}
	
	
	public List<String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(List<String> familyMembers) {
			
		this.familyMembers = familyMembers;
	}
	
	
	public List<String> getNomineeInitial() {
		return nomineeInitial;
	}


	public void setNomineeInitial(List<String> nomineeInitial) {
		this.nomineeInitial = nomineeInitial;
	}


	public List<String> getRelation() {
		
		return relation;
	}
	public void setRelation(List<String> relation) {
		
		this.relation = relation;
	}
	public List<Date> getDob() {
		return dob;
	}
	public void setDob(List<Date> dob) {
		
		this.dob = dob;
	}
	public List<Integer> getAge() {
		return age;
	}
	public void setAge(List<Integer> age) {
		
		this.age = age;
	}
	public List<Integer> getNomineeID() {
		return nomineeID;
	}
	public void setNomineeID(List<Integer> nomineeID) {
		
		this.nomineeID = nomineeID;
	}
	public List<String> getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(List<String> maritalStatus) {
		
		this.maritalStatus = maritalStatus;
	}
	
	public int getPpoNo() {
		return ppoNo;
	}


	public void setPpoNo(int ppoNo) {
		
		this.ppoNo = ppoNo;
	}


	public List<String> getHandicapped() {
		return handicapped;
	}
	public void setHandicapped(List<String> handicapped) {
		
		this.handicapped = handicapped;
	}
	
	public UpdatedUserIdService getUpdateservice() {
		return updateservice;
	}


	public void setUpdateservice(UpdatedUserIdService updateservice) {
		this.updateservice = updateservice;
	}
	

	

}
