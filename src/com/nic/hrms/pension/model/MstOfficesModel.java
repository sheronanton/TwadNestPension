package com.nic.hrms.pension.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;


// pojo class for Master table Offices


public class MstOfficesModel implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	private int office_id;
	private String office_name;
	private String office_short_name;
	private char office_level_id;
	private int office_head_cadre_id;
	
	private String office_address1;
	private String office_address2;
	private String city_town_name;
	
	private int office_pin_code;
	private int district_code;
	
	private String office_std_code;
	private String office_phone_no;
	private String addl_phone_nos;
	private String office_fax_no;
	private String addl_fax_nos;

	private String  office_email_id;
	private String  addl_email_ids;
	private char  primary_work_id ;
	
	private Date date_of_formation;
	
	private char  hra_class_id;
	private char  accounting_unit;
	private char  wings_applicable;
	private char  office_old_code;
	private char  office_status_id;
	
	private Date status_effective_from;
	
	private String   remarks;
	private String  updated_by_user_id;
	
	private Timestamp updated_date;
	
	private char  cca_class_id;
	private char  process_flow_status_id;
	private String  office_name_original;
	private char pension_payment_office;
	
	
	
	public int getOffice_id() {
		return office_id;
	}
	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getOffice_short_name() {
		return office_short_name;
	}
	public void setOffice_short_name(String office_short_name) {
		this.office_short_name = office_short_name;
	}
	public char getOffice_level_id() {
		return office_level_id;
	}
	public void setOffice_level_id(char office_level_id) {
		this.office_level_id = office_level_id;
	}
	public int getOffice_head_cadre_id() {
		return office_head_cadre_id;
	}
	public void setOffice_head_cadre_id(int office_head_cadre_id) {
		this.office_head_cadre_id = office_head_cadre_id;
	}
	public String getOffice_address1() {
		return office_address1;
	}
	public void setOffice_address1(String office_address1) {
		this.office_address1 = office_address1;
	}
	public String getOffice_address2() {
		return office_address2;
	}
	public void setOffice_address2(String office_address2) {
		this.office_address2 = office_address2;
	}
	public String getCity_town_name() {
		return city_town_name;
	}
	public void setCity_town_name(String city_town_name) {
		this.city_town_name = city_town_name;
	}
	public int getOffice_pin_code() {
		return office_pin_code;
	}
	public void setOffice_pin_code(int office_pin_code) {
		this.office_pin_code = office_pin_code;
	}
	public int getDistrict_code() {
		return district_code;
	}
	public void setDistrict_code(int district_code) {
		this.district_code = district_code;
	}
	public String getOffice_std_code() {
		return office_std_code;
	}
	public void setOffice_std_code(String office_std_code) {
		this.office_std_code = office_std_code;
	}
	public String getOffice_phone_no() {
		return office_phone_no;
	}
	public void setOffice_phone_no(String office_phone_no) {
		this.office_phone_no = office_phone_no;
	}
	public String getAddl_phone_nos() {
		return addl_phone_nos;
	}
	public void setAddl_phone_nos(String addl_phone_nos) {
		this.addl_phone_nos = addl_phone_nos;
	}
	public String getOffice_fax_no() {
		return office_fax_no;
	}
	public void setOffice_fax_no(String office_fax_no) {
		this.office_fax_no = office_fax_no;
	}
	public String getAddl_fax_nos() {
		return addl_fax_nos;
	}
	public void setAddl_fax_nos(String addl_fax_nos) {
		this.addl_fax_nos = addl_fax_nos;
	}
	public String getOffice_email_id() {
		return office_email_id;
	}
	public void setOffice_email_id(String office_email_id) {
		this.office_email_id = office_email_id;
	}
	public String getAddl_email_ids() {
		return addl_email_ids;
	}
	public void setAddl_email_ids(String addl_email_ids) {
		this.addl_email_ids = addl_email_ids;
	}
	public char getPrimary_work_id() {
		return primary_work_id;
	}
	public void setPrimary_work_id(char primary_work_id) {
		this.primary_work_id = primary_work_id;
	}
	public Date getDate_of_formation() {
		return date_of_formation;
	}
	public void setDate_of_formation(Date date_of_formation) {
		this.date_of_formation = date_of_formation;
	}
	public char getHra_class_id() {
		return hra_class_id;
	}
	public void setHra_class_id(char hra_class_id) {
		this.hra_class_id = hra_class_id;
	}
	public char getAccounting_unit() {
		return accounting_unit;
	}
	public void setAccounting_unit(char accounting_unit) {
		this.accounting_unit = accounting_unit;
	}
	public char getWings_applicable() {
		return wings_applicable;
	}
	public void setWings_applicable(char wings_applicable) {
		this.wings_applicable = wings_applicable;
	}
	public char getOffice_old_code() {
		return office_old_code;
	}
	public void setOffice_old_code(char office_old_code) {
		this.office_old_code = office_old_code;
	}
	public char getOffice_status_id() {
		return office_status_id;
	}
	public void setOffice_status_id(char office_status_id) {
		this.office_status_id = office_status_id;
	}
	public Date getStatus_effective_from() {
		return status_effective_from;
	}
	public void setStatus_effective_from(Date status_effective_from) {
		this.status_effective_from = status_effective_from;
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
	
	
	public char getCca_class_id() {
		return cca_class_id;
	}
	public void setCca_class_id(char cca_class_id) {
		this.cca_class_id = cca_class_id;
	}
	public char getProcess_flow_status_id() {
		return process_flow_status_id;
	}
	public void setProcess_flow_status_id(char process_flow_status_id) {
		this.process_flow_status_id = process_flow_status_id;
	}
	public String getOffice_name_original() {
		return office_name_original;
	}
	public void setOffice_name_original(String office_name_original) {
		this.office_name_original = office_name_original;
	}
	public char getPension_payment_office() {
		return pension_payment_office;
	}
	public void setPension_payment_office(char pension_payment_office) {
		this.pension_payment_office = pension_payment_office;
	}
	
	
	
	
	
	
	
}