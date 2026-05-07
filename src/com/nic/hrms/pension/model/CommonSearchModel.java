package com.nic.hrms.pension.model;

import java.io.Serializable;

public class CommonSearchModel implements Serializable{

	/**
	 * Common Model for Search Operation
	 */
	private static final long serialVersionUID = 1L;
	
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
