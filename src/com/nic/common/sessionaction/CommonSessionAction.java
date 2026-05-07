package com.nic.common.sessionaction;

import com.nic.common.baseaction.BaseAction;


public class CommonSessionAction extends BaseAction {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6824685704755472618L;
	private String currentSession;
	private int Employee_Id;
	private String UserId;
	private String Employee_Initial;
	private String Employee_Name;
	private String Employee_Prefix ;
	private String Designation ;
	private String Office_Level;
	private String Office_Short_Name;
	private String Office_Address ;
	
	
	public void gettingSession(){	
		
	/* setCurrentSession(getRequest().getSession().toString());	
	 Employee_Id =(Integer)getRequest().getSession().getAttribute("Employee_Id");	
	 UserId =getRequest().getSession().getAttribute("UserId").toString();
	 Employee_Initial =getRequest().getSession().getAttribute("Employee_Initial").toString();
	 Employee_Name =getRequest().getSession().getAttribute("Employee_Name").toString();
	 Employee_Prefix =getRequest().getSession().getAttribute("Employee_Prefix").toString();
	 Designation =getRequest().getSession().getAttribute("Designation").toString();
	 Office_Level =getRequest().getSession().getAttribute("Office_Level").toString();
	 Office_Short_Name =getRequest().getSession().getAttribute("Office_Short_Name").toString();
	 Office_Address =getRequest().getSession().getAttribute("Office_Address").toString();*/
	 System.out.println(Employee_Id);
	}
		
	
public static void main(String args[]){
	
	CommonSessionAction some = new CommonSessionAction();
	some.gettingSession();
}
	/*Employee_Id
	Employee_Initial
	Employee_Name
	Employee_Prefix
	Designation
	Office_Level
	Office_Short_Name
	Office_Address*/

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employeeId) {
		Employee_Id = (Integer)getRequest().getSession().getAttribute("Employee_Id");
		System.out.println("-----------------------employee id in session setting"+Employee_Id);
		
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getEmployee_Initial() {
		return Employee_Initial;
	}

	public void setEmployee_Initial(String employeeInitial) {
		Employee_Initial = employeeInitial;
	}

	public String getEmployee_Name() {
		return Employee_Name;
	}

	public void setEmployee_Name(String employeeName) {
		Employee_Name = employeeName;
	}

	public String getEmployee_Prefix() {
		return Employee_Prefix;
	}

	public void setEmployee_Prefix(String employeePrefix) {
		Employee_Prefix = employeePrefix;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getOffice_Level() {
		return Office_Level;
	}

	public void setOffice_Level(String officeLevel) {
		Office_Level = officeLevel;
	}

	public String getOffice_Short_Name() {
		return Office_Short_Name;
	}

	public void setOffice_Short_Name(String officeShortName) {
		Office_Short_Name = officeShortName;
	}

	public String getOffice_Address() {
		return Office_Address;
	}

	public void setOffice_Address(String officeAddress) {
		Office_Address = officeAddress;
	}

	public String getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(String currentSession) {
		this.currentSession = currentSession;
	}

	
}