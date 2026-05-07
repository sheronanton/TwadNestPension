package com.nic.hrms.pension.model;

import java.io.Serializable;

public class SearchScreen implements Serializable{
	
	private static final long serialVersionUID = 8419833738396120535L;
	private String SearchScreenOptions;
	private String SearchScreenKeyword;
	
	
	public String getSearchScreenOptions() {
		return SearchScreenOptions;
	}
	public void setSearchScreenOptions(String searchScreenOptions) {
		SearchScreenOptions = searchScreenOptions;
	}
	public String getSearchScreenKeyword() {
		return SearchScreenKeyword;
	}
	public void setSearchScreenKeyword(String searchScreenKeyword) {
		SearchScreenKeyword = searchScreenKeyword;
	}

}
