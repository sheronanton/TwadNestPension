package com.nic.hrms.pension.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.*;

import Servlets.Security.classes.UserProfile;

import com.nic.common.baseaction.BaseAction;
import com.nic.hrms.pension.service.UploadFilePdfService;
import com.nic.hrms.pension.model.UploadFilePdfModel;
public class UploadFilePdfAction extends BaseAction {

	private UploadFilePdfService uploadservice;
	private File myFile;
	private UploadFilePdfModel uploadmodel;


	@SuppressWarnings("deprecation")
	public String fileupload()
	{
		System.out.println("===================================================================");

		String contextPath = getRequest().getRealPath("/");
		System.out.println("path===="+contextPath);
		byte[] file = null;
		if(myFile !=null && myFile.length()>0){
			file=getByteArray(myFile);

			String path =contextPath+File.separator+"Document"+File.separator+"familyphoto.pdf";
			try{
				System.out.println("file path ::: " + path);
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(file);
				fos.close();
			}
			catch (IOException  e) {
				// TODO: handle exception
				System.out.println("IO Exception : "+e.getMessage());
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		System.out.println("file ::::::::::::::::::::::::::::::::::::::::: "+file.length);
		// uploadservice.insertfile(file);

		return SUCCESS;
	}

	public byte[] getByteArray(File file)
	{		
		byte[] b = new byte[(int) file.length()];

		try 
		{
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(b);			
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
	public UploadFilePdfService getUploadservice() {
		return uploadservice;
	}
	public void setUploadservice(UploadFilePdfService uploadservice) {
		this.uploadservice = uploadservice;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public UploadFilePdfModel getUploadmodel() {
		return uploadmodel;
	}
	public void setUploadmodel(UploadFilePdfModel uploadmodel) {
		this.uploadmodel = uploadmodel;
	}

}
