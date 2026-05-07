package com.nic.hrms.pension.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nic.hrms.pension.model.RevisedPensionAuthorizationDao;
import com.nic.hrms.pension.model.PensionAuthorisedOfficer_dao;
import com.nic.hrms.pension.model.RevisedPensionReportModel;


public interface RevisedPensionAuthorizationService {
	
	List<Object[]> getMasterDetails(int empNo);	
	boolean saveRecord(RevisedPensionAuthorizationDao revisedPenAppAuthOri);
	List<Object[]> searchOperation(String option,String keyword);
	List<Object[]> getAddress(int officeId);
	List<Object[]> checkPpoNo(int ppoNo);
	List<Object[]> getNominee(int empNo);
	List<Object[]> getNominDetails(int empNo,int nomId);
	boolean deleteHoCoDetails(int empNo);
	boolean deleteRecord(int empno);
	boolean moveRevisedDetails(int empNo, String flag);
	List<PensionAuthorisedOfficer_dao> getListOfAythorisedOfficer();	
	List<RevisedPensionReportModel> getRevisedpensionDetails_Note(HttpServletRequest request, int empId,String lett_no,String date_on,String reference);
	List<RevisedPensionReportModel> getOneManCommDetails_Note(HttpServletRequest request, int empId,String lett_no,String date_on,String reference);
	List<RevisedPensionReportModel> getRevisedPensionDetails(HttpServletRequest request, int empId,String letter_number,String dated_on,String reference,String ppono,String nameforfromaddress);
	List<RevisedPensionReportModel> getRevisedPensionDCRGDetails(HttpServletRequest request, int empId,String letter_number,String dated_on,String reference,String ppono,String nameforfromaddress);
	List<RevisedPensionReportModel> getRevisedPensionDetailssubreport(HttpServletRequest request, int empId,String letter_number,String dated_on,String reference,String ppono,String nameforfromaddress);
	List<RevisedPensionReportModel> getRevisedPensionDetailssubreport1(HttpServletRequest request, int empId);
	List<RevisedPensionReportModel> getOneManCommisionDetails(HttpServletRequest request, int empId, String letter_number,String dated_on, String reference, String ppono,String nameforfromaddress);
	List<RevisedPensionReportModel> getOneManCommisionDetailssubreport(HttpServletRequest request, int empId, String letter_number,String dated_on, String reference, String ppono,
			String nameforfromaddress);
	List<RevisedPensionReportModel> getOneManCommisionDetailssubreport1(HttpServletRequest request, int empId);
	List<RevisedPensionReportModel> getOneManCommisionDCRGDetails(HttpServletRequest request, int empId, String letter_number,String dated_on, String reference, String ppono,
			String nameforfromaddress);
	List<RevisedPensionReportModel> getSplGrade_Note(HttpServletRequest request, int empId, String lett_no,
			String date_on, String reference);
	List<RevisedPensionReportModel> getSpecialGradeDetails(HttpServletRequest request, int empId, String letter_number,
			String dated_on, String reference, String ppono,
			String nameforfromaddress);
	List<RevisedPensionReportModel> getSpecialGradeDetailssubreport(HttpServletRequest request, int empId, String letter_number,
			String dated_on, String reference, String ppono,
			String nameforfromaddress);
	List<RevisedPensionReportModel> getSpecialGradeDetailssubreport1(HttpServletRequest request, int empId);
	List<RevisedPensionReportModel> getSpecialGradeDCRGDetails(HttpServletRequest request, int empId, String letter_number,String dated_on, String reference, String ppono,
			String nameforfromaddress);
	List<RevisedPensionReportModel> getGradePay_Note(HttpServletRequest request, int empId, String lett_no,String date_on, String reference);
	List<RevisedPensionReportModel> getGradePayDetails(HttpServletRequest request, int empId, String letter_number,
			String dated_on, String reference, String ppono,
			String nameforfromaddress);
	List<RevisedPensionReportModel> getGradePayDetailssubreport(HttpServletRequest request, int empId, String letter_number,
			String dated_on, String reference, String ppono,
			String nameforfromaddress);
	List<RevisedPensionReportModel> getGradePayDetailssubreport1(HttpServletRequest request, int empId);
	List<RevisedPensionReportModel> getGradePayDCRGDetails(HttpServletRequest request, int empId, String letter_number,
			String dated_on, String reference, String ppono,
			String nameforfromaddress);
	
	
}
