<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,java.util.*,Servlets.Security.classes.UserProfile"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script type="text/javascript" src="../scripts/Bulk_Userid_Create.js"></script>
  <link href="../../../css/Sample3.css" rel="stylesheet" media="screen"/>
<title>Create Bulk User Account</title>
</head>
<body>
<form name="frmValidationSummaryRep">
<%
  
  Connection connection=null;
  PreparedStatement ps=null;
  ResultSet results=null;
  ResultSet results1=null;
  ResultSet results2=null;
  
  
  try
  {
  
            ResourceBundle rs=ResourceBundle.getBundle("Servlets.Security.servlets.Config");
            String ConnectionString="";

            String strDriver=rs.getString("Config.DATA_BASE_DRIVER");
            String strdsn=rs.getString("Config.DSN");
            String strhostname=rs.getString("Config.HOST_NAME");
            String strportno=rs.getString("Config.PORT_NUMBER");
            String strsid=rs.getString("Config.SID");
            String strdbusername=rs.getString("Config.USER_NAME");
            String strdbpassword=rs.getString("Config.PASSWORD");
            ConnectionString=strdsn.trim()+"://"+strhostname.trim()+":"+strportno.trim()+"/"+strsid.trim();//PostgresDB Connection
            //ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

             Class.forName(strDriver.trim());
             connection=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
  }
  catch(Exception e)
  {
    System.out.println("Exception in connection...."+e);
  }
  
  
  %>
  
    <table cellspacing="3" cellpadding="2" border="1" width="100%">
             
                <tr>
                  <td  class="tdH" align="center" colspan=2><strong>Bulk User Account Creation</strong></td>
             </tr>
                <tr class="table">
    
                  <td>
                  Select Employee Service Group</td>
                  <td>
                    <div align="left"  id='divrankwhole'>
                    <select name="cmbsgroup1" id="cmbsgroup1" onchange="getDesignation1()">
                <option value="0">Select Service Group</option>
                        <%
                         ResultSet rs=null;
           
           try
           {
           ps=connection.prepareStatement("select SERVICE_GROUP_ID,SERVICE_GROUP_NAME from HRM_MST_SERVICE_GROUP  order by SERVICE_GROUP_NAME");
            rs=ps.executeQuery();
              int strcode=0;
            String strname="";          
            while(rs.next())
            {
              
               
                strcode=rs.getInt("SERVICE_GROUP_ID");
                strname=rs.getString("SERVICE_GROUP_NAME");
                
                out.println("<option value='"+strcode+"'>"+strname+"</option>");
                
             }
          }
          catch(Exception e)
          {
            System.out.println("Exception in grid.."+e);
          }
            
              
        %>
               </select> </div>          </td>
               </tr> 
               <tr class="table">  
                  <td>Select Employee Designation </td>
     
        <td><select name="Desig" id="Desig" onChange="loademployee()">
          <option>--Select Designation--</option>
        </select></td>
        </tr>  
  
  </table>
  
  <table cellspacing="3" cellpadding="2" border="1" width="100%">
  <tr>
          <td colspan="4" class="tdH" align="center"><b>Employee Details</b></td>
   </tr>
   <tr class="tdH">
   			<th>Employee Id</th>
   			<th>Employee Name</th>
        	<th>Designation ID</th>
        	<th>Office Name</th>
   </tr>
   
   <tbody id="tlist" >
   </tbody>
   
   
  </table>
  <table cellspacing="3" cellpadding="2" border="1" width="100%">
  <tr><td class="tdH" align="center">  <input type="button" id="subconfirm" name="subconfirm" value="Create" onclick="confirmlogin()"> </td></tr>
  </table>
  </form>
</body>
</html>