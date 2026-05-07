package com.nic.hrms.pension.model;

import java.io.Serializable;

public class LastWorkingOfficeSearchModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3606304253461613048L;

	private String searchOption;
	private String searchKeyword;
	
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	




}
