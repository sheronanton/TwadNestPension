package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MstOfficeLevelModel implements Serializable {

// pojo class for Office level table
	
	
	private static final long serialVersionUID = 1L;
	
	private char office_level_id;
	private String office_level_name;
	private int office_head_cadre_id;
	private int hierarchical_sequence;
	private String hierachical_view_name;
	private String remarks;
	private String updated_by_user_id;
	private Timestamp updated_date;
	
	
	
	
	public String getHierachical_view_name() {
		return hierachical_view_name;
	}
	public void setHierachical_view_name(String hierachical_view_name) {
		this.hierachical_view_name = hierachical_view_name;
	}
	
	
	
	public char getOffice_level_id() {
		return office_level_id;
	}
	public void setOffice_level_id(char office_level_id) {
		this.office_level_id = office_level_id;
	}
	public String getOffice_level_name() {
		return office_level_name;
	}
	public void setOffice_level_name(String office_level_name) {
		this.office_level_name = office_level_name;
	}
	public int getOffice_head_cadre_id() {
		return office_head_cadre_id;
	}
	public void setOffice_head_cadre_id(int office_head_cadre_id) {
		this.office_head_cadre_id = office_head_cadre_id;
	}
	public int getHierarchical_sequence() {
		return hierarchical_sequence;
	}
	public void setHierarchical_sequence(int hierarchical_sequence) {
		this.hierarchical_sequence = hierarchical_sequence;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUpdated_by_user_id() {
		return updated_by_user_id;
	}
	public void setUpdated_by_user_id(String updated_by_user_id) {
		this.updated_by_user_id = updated_by_user_id;
	}
	public Timestamp getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}
	
		
	
}
