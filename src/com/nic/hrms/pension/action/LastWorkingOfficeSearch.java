package com.nic.hrms.pension.action;

import java.io.PrintWriter;
import java.util.List;

import com.nic.common.baseaction.BaseAction;

import com.nic.hrms.pension.service.LastWorkingOfficeSearchService;
import com.nic.hrms.pension.model.LastWorkingOfficeSearchModel;

public class LastWorkingOfficeSearch extends BaseAction {

	
	 
	 /** last Working Office Search operation  
	 * 
	 */
	private static final long serialVersionUID = 1331151406227090748L;
	private LastWorkingOfficeSearchService searchService;
	List<Object[]> listoffice;
	LastWorkingOfficeSearchModel officeSearchObj;
	
	
	public String searchOffice()
	 {
		
		
		try 
		{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			
			xmlString.append("<response>");
			xmlString.append("<command>search</command>");
			xmlString.append("<flag>success</flag>");
			
			String option=officeSearchObj.getSearchOption();
			String keyword=officeSearchObj.getSearchKeyword().toLowerCase();
			
				
			listoffice = searchService.SearchOffice(option,keyword);
			
			 for(Object[] tl: listoffice)
			 {
				Object[] temp=tl;
				xmlString.append("<record>");
				
				xmlString.append("<officeid>" +temp[0]+ "</officeid>");
				xmlString.append("<officename>" +temp[1]+ "</officename>");
				xmlString.append("<statusdesc>" +temp[2]+ "</statusdesc>");
				xmlString.append("<levelname>" +temp[3]+ "</levelname>");
				xmlString.append("<levelid>" +temp[4]+ "</levelid>");
								
				xmlString.append("</record>");
								
			 }
			
			 xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 System.out.println(xmlString.toString());
			 out.println(xmlString.toString());
			 out.flush();
			 out.close();
			 
		}
		
		 catch (Exception e) {

			 e.printStackTrace();
			 System.out.println("ERROR "+e);
		}
		 
				 
		 return "success";
	 
}


	public LastWorkingOfficeSearchService getSearchService() {
		return searchService;
	}


	public void setSearchService(LastWorkingOfficeSearchService searchService) {
		this.searchService = searchService;
	}


	public List<Object[]> getListoffice() {
		return listoffice;
	}


	public void setListoffice(List<Object[]> listoffice) {
		this.listoffice = listoffice;
	}


	public LastWorkingOfficeSearchModel getOfficeSearchObj() {
		return officeSearchObj;
	}


	public void setOfficeSearchObj(LastWorkingOfficeSearchModel officeSearchObj) {
		this.officeSearchObj = officeSearchObj;
	}

	
}