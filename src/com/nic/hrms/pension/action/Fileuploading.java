package com.nic.hrms.pension.action;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.model.Fileuploaddao;
import com.nic.hrms.pension.service.Fileupload_service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fileuploading extends BaseAction{

	/**
	 * 
	 */
	    private static final long serialVersionUID = -9208910183310010569L;
	    
	    private int ppoNo;
	    private File familyPhoto;
	    private File signatureDetails;
	    private File otherDocuments;
	    private String fileContentType[];
	    private String fileFileName[];
	    private Fileupload_service fileservice;
	   
	  
	  
	public String upload() throws Exception 
	{   
         Fileuploaddao fileobj = new Fileuploaddao();
         fileobj.setPpoNo(ppoNo);
        if(familyPhoto != null && familyPhoto.length()>0)
       		fileobj.setFamilyPhoto(getByteArray(familyPhoto));
       	if(signatureDetails != null && signatureDetails.length()>0 )
       		fileobj.setSignatureDetails(getByteArray(signatureDetails));
       	if(otherDocuments != null && otherDocuments.length()>0)
       		fileobj.setOtherDocuments (getByteArray(otherDocuments));
     
       	fileservice.saveupload(fileobj);
      
         return "success";
	}
		
	public byte[] getByteArray(File file){
	
		//File file=new File(getFileContentType());
		byte[] b = new byte[(int) file.length()];
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(b);
			/*for (int y = 0; y < b.length; y++)
			{
				System.out.print((char)b[y]);
				System.out.println("file converted successfully to bytes");
			}*/
		}
		
		catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found.");
			e.printStackTrace();
		}
		
		catch (IOException e1)
		{
			System.out.println("Error Reading The File.");
			e1.printStackTrace();
		}
		return b;
	}
	
	
	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public Fileupload_service getFileservice() {
		return fileservice;
	}

	public void setFileservice(Fileupload_service fileservice) {
		this.fileservice = fileservice;
	}

	public File getFamilyPhoto() {
		return familyPhoto;
	}

	public void setFamilyPhoto(File familyPhoto) {
		this.familyPhoto = familyPhoto;
	}

	public File getSignatureDetails() {
		return signatureDetails;
	}

	public void setSignatureDetails(File signatureDetails) {
		this.signatureDetails = signatureDetails;
	}

	public File getOtherDocuments() {
		return otherDocuments;
	}

	public void setOtherDocuments(File otherDocuments) {
		this.otherDocuments = otherDocuments;
	}

	public int getPpoNo() {
		return ppoNo;
	}

	public void setPpoNo(int ppoNo) {
		this.ppoNo = ppoNo;
	}


}
