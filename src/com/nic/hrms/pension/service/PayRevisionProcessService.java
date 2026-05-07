package com.nic.hrms.pension.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.nic.hrms.pension.reports.model.Payrevisionreportmodeldetails;
public interface PayRevisionProcessService {
	
	
	List<Object[]> getPensionerDetails(int ppono);
	List<Object[]> getPayRevisionDetails(int ppono);
	List<Object[]> getPayRevisionValidate(int ppono);
	public boolean validatePayRevision(int ppono,int officeid);
	public List<Object[]> searchPayRevisionProcess(String searchOption,String searchKeyword,int empId ) ;
	List<Payrevisionreportmodeldetails> getAllPayrevisiondetails(HttpServletRequest request,int ppono,int officeid);
	public List<Object[]> getPayrevisionchklistgrouplist(int ppono,int officeid);
	public List<Object[]> getPayrevisionArrearCommutation(int ppono,int officeid);
	public List<Object[]> getPayrevisionArrearExitdetails(int ppono,int officeid);
	
	
	/*List<Object[]> getFamilyDetails(int ppono);	
	boolean saveChangeFamily(ChangeFamilyPensionerDetailsModel newdetails);
	List<Object[]> getMstDcrgDetails(int ppono);
	List<Object[]> getChangedDcrgDetails(int ppono);
	public boolean validateDcrgDetails(int ppono);
	List<Object[]> changeSearch(String searchOption,String searchKeyword,int empId );*/
}
