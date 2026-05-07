package com.nic.hrms.pension.model;

import java.io.Serializable;

public class State_dao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6180116596291894609L;
	
	private int stateId;
	private String stateName;
	
	
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	

}
