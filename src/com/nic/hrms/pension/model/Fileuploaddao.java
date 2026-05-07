package com.nic.hrms.pension.model;



public class Fileuploaddao implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  
	  private int ppoNo;
	  private String fileContentType;
	  private String fileFileName;
	  private byte[] familyPhoto;
	  private byte[] signatureDetails;
	  private byte[] otherDocuments;
	
	

	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	public byte[] getFamilyPhoto() {
		return familyPhoto;
	}
	public void setFamilyPhoto(byte[] familyPhoto) {
		this.familyPhoto = familyPhoto;
	}
	public byte[] getSignatureDetails() {
		return signatureDetails;
	}
	public void setSignatureDetails(byte[] signatureDetails) {
		this.signatureDetails = signatureDetails;
	}
	public byte[] getOtherDocuments() {
		return otherDocuments;
	}
	public void setOtherDocuments(byte[] otherDocuments) {
		this.otherDocuments = otherDocuments;
	}
	public int getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}
	


	
 }
