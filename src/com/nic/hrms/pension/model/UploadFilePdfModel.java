package com.nic.hrms.pension.model;

import java.io.File;
import java.io.Serializable;


public class UploadFilePdfModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private byte[] myFile;

	public byte[] getMyFile() {
		return myFile;
	}

	public void setMyFile(byte[] bs) {
		this.myFile = bs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	

}
