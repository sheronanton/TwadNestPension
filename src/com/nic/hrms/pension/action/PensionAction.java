/*
 * This is the servlet page where all the business logic
 * is written.this class also contains the xmls and ajax fittings
 * to it.
 */

package com.nic.hrms.pension.action;




import com.nic.common.baseaction.BaseAction;

import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;
import com.nic.hrms.pension.model.MstPension;
import com.nic.hrms.pension.service.Pension_service;


public class PensionAction extends BaseAction{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pension_service penService;
	List<MstPension> listPension;	
	
	
	public Pension_service getPenService() {
		return penService;
	}

	public void setPenService(Pension_service penService) {
		this.penService = penService;
	}


	private MstPension mstPension;

	private String classId;
	private String classDesc;
	
	/*
	 * getter and Setter methods for the variables
	 */
	
	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassId() {
		return classId;
	}
	
	public MstPension getMstPension() {
		return mstPension;
	}

	public void setMstPension(MstPension mstPension) {
		this.mstPension = mstPension;
	}



	
	/*
	 * writting of the method class within which all the 
	 * business logic is written
	 */
	
	public String add(){
		
		try{
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			System.out.println("--------------------------> " + mstPension.getClassId());
			System.out.println(mstPension.getClassDesc());
			
			penService.saveuser(mstPension);
			//System.out.println("-------------------------->save success");
			xmlString.append("<command>Add</command>");
			 xmlString.append("<flag>success</flag>");
			 
			 xmlString.append("<record>");
				xmlString.append("<classId>" +mstPension.getClassId()+ "</classId>");
				xmlString.append("<classDesc>" +mstPension.getClassDesc()+ "</classDesc>");
				xmlString.append("</record>");
				xmlString.append("</response>");
				getResponse().setContentType("text/xml");
				System.out.println(xmlString.toString());
				out.println(xmlString.toString());
	
		}catch(Exception e){
			System.out.println("error in addin the data to the databse"+e);
		}
		return null;	
	}
	
	public String getList(){
		
		try{
			StringBuffer xmlString = new StringBuffer();
			System.out.println("penserive"+penService);
			PrintWriter out = getResponse().getWriter();
			
			xmlString.append("<response>");
			System.out.println("penserive"+penService);
			 listPension = penService.getAllClassOfPension();
			 Iterator<MstPension> iterator = listPension.iterator();
			 xmlString.append("<command>Get</command>");
			 xmlString.append("<flag>success</flag>");
			
			 System.out.println("--------------------------------------->"+listPension.size());
			 while(iterator.hasNext()){
				MstPension iter = iterator.next();
				 System.out.println("system print for classid ="+iter.getClassId());
				 System.out.println("system print for classdesc ="+iter.getClassDesc());
				 	xmlString.append("<record>");
					xmlString.append("<classId>" +iter.getClassId()+ "</classId>");
					xmlString.append("<classDesc>" +iter.getClassDesc()+ "</classDesc>");
					xmlString.append("</record>");
			 }
			 xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 System.out.println(xmlString.toString());
			 out.println(xmlString.toString());
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error in gettin the list from the database"+e);
		}
		return null;
	}

	public String delete(){
		try{
			//System.out.println("inside delete");
			
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			
			xmlString.append("<command>Delete</command>");
			
			 classId=mstPension.getClassId();
			//System.out.println("class id in action ="+classId);
			// System.out.println("--------------------------------------->inside deleting");
			penService.deleteuser(classId);
		//	System.out.println("---------------------------------------->deleting finished");
			
			xmlString.append("<flag>success</flag>");
						
			xmlString.append("</response>");
			 getResponse().setContentType("text/xml");
			 System.out.println(xmlString.toString());
			 out.println(xmlString.toString());
		}catch(Exception e){
			System.out.println("deleting failed");
		}
		return "success";
	}
	
	public String update(){
		try{
			
			System.out.println("inside updte");
			classId = mstPension.getClassId();
			classDesc = mstPension.getClassDesc();
			System.out.println("inside e"+classId);
			
			StringBuffer xmlString = new StringBuffer();
			PrintWriter out = getResponse().getWriter();
			xmlString.append("<response>");
			
			xmlString.append("<command>Update</command>");
			
			
			
			penService.updateuser(classId,classDesc);
			
			xmlString.append("<flag>success</flag>");
			 
			    xmlString.append("<record>");
				xmlString.append("<classId>" +mstPension.getClassId()+ "</classId>");
				xmlString.append("<classDesc>" +mstPension.getClassDesc()+ "</classDesc>");
				xmlString.append("</record>");
				xmlString.append("</response>");
				getResponse().setContentType("text/xml");
				System.out.println(xmlString.toString());
				out.println(xmlString.toString());
			
			
			
		}catch(Exception e){
			System.out.println("updating failed");
		}
		return "success";
	}

	
}
