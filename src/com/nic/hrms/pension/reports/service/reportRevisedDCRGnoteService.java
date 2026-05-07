package com.nic.hrms.pension.reports.service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


import com.nic.hrms.pension.reports.model.RevisedDCRGnoteDao;
public interface reportRevisedDCRGnoteService 
{
	List<RevisedDCRGnoteDao> getRevisedDCRGnoteDetails(HttpServletRequest request, int empId);	
	/*List<RevisedDCRGnoteDao> getRevisedDCRGnoteDetailssubreport(HttpServletRequest request, int empId);*/

}
