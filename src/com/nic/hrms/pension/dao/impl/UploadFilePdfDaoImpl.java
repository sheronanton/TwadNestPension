package com.nic.hrms.pension.dao.impl;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.PreparedStatement;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.nic.hrms.pension.service.UploadFilePdfService;

public class UploadFilePdfDaoImpl implements UploadFilePdfService {

	private SessionFactory sessionFactory;
	HttpServletRequest request;
	@SuppressWarnings("deprecation")
	
   public boolean insertfile(byte[] file) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.doGetSession(sessionFactory, true);
		Transaction trans = null;
		PreparedStatement ps=null;
		
		trans = session.beginTransaction();
		 String contextPath = request.getRealPath("/");
		 /*//byte[] buf=new byte[(int)file.length];
			//io1.read(buf);
		    String filename=contextPath+"Document"+File.separator+"case"+".txt";
		   	File filewritetofloder = new File(filename);
		   	FileWriter fr=new FileWriter(filename,true);
        	BufferedWriter bw=new BufferedWriter(fr);
			//bw.write(buf);
			//System.out.println("The final Result is"bw.write(result));
			//bw.flush();
*/			
        	try 
    		{
        	//InputStream da=fileService.getInputStream(file);
			byte[] buf=new byte[(int)file.length];
			//read(buf);
			FileOutputStream fo1=new FileOutputStream(contextPath+File.separator+"Document"+File.separator+"case"+".pdf");
			String realpathfamily= contextPath+File.separator+"Document"+File.separator+"case"+".pdf";
			//System.out.println(realpathfamily);
			//familynewlist.setRealPathFamily(realpathfamily);
			String conPathFPhoto1 ="../Document/case"+".pdf";
			//familynewlist.setContextPathFamilyphoto(conPathFPhoto1);
			fo1.write(buf);
			fo1.flush();
			fo1.close();	
		 
			trans.commit();
			
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	

	
	
	
}
