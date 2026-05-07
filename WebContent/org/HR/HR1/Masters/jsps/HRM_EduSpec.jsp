<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <script type="text/javascript" src="../scripts/EduSpec.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>

   <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
    
    <title>Master HRM Education Specification Details</title>
  </head>
  <body>
  <%
  Connection connection=null;
  Statement statement=null;
  ResultSet results=null;
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

    try
    {
      statement=connection.createStatement();
    }
    catch(SQLException e)
    {
    }
  }
  catch(Exception e)
  {
  }
  %>
  <form name="EduForm" id="EduForm">
      <table cellspacing="2" cellpadding="3" border="1" width="75%"
             align="center">
        <tr>
          <td colspan="2" class="tdH">
            <div align="center">
              <strong>Education Specialisation Details</strong>
            </div></td>
        </tr>
        <tr>
          <td class="table">Specialisation Id</td>
          <td class="table">
          
                   <input type="TEXT" name="htxtSpecId" maxlength="3"
                   id="htxtSpecId" readonly size="3"/>System Generated
          </td>
        </tr>
        <tr>
          <td class="table">Specialisation Desc</td>
          <td class="table">
            <input type="text" name="txtSpecDesc" size="40" maxlength="60"
                   id="txtQualDesc"/>
          </td>
        </tr>
       <tr>
          <td colspan="2" class="table" id="add" style="display:block">
            <input type="button" name="CmdAdd" value="SAVE" id="CmdAdd" onclick="callServer('Add','null')"/>
            <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
           </td>
           <td colspan="2" class="table" id="update" style="display:none">
            <input type="button" name="CmdUpdate" value="UPDATE"
                   id="CmdUpdate" onclick="callServer('Update','null')"/>
            <input type="button" name="CmdDelete" value="DELETE"
                   id="CmdDelete" onclick="callServer('Delete','null')"/>
                   <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
          </td>
        </tr>
      </table>
      <table cellspacing="3" cellpadding="2" border="1" width="75%"
             align="center" >
        <tr>
          <td class="table">Existing Details</td>
        </tr>
      </table>
      <table id="Existing" cellspacing="2" cellpadding="3" border="1" width="75%"
             align="center">
        <tr class="tdH">
          <th>
            Select
          </th>
          <th>
            Specialisation ID
          </th>
          <th>
            Specialisation Desc
          </th>
          </tr>
          <tbody id="tblList" class="table">
           <%
      
          try
          {
              
            String sql="select * from HRM_MST_EDU_SPECIALISATIONS ORDER BY SPECIALISATION_ID";
             results=statement.executeQuery(sql);
            try
            {
              while(results.next())
              {
                String strSpecId=results.getString("SPECIALISATION_ID");
	        String strSpecDesc=results.getString("SPECIALISATION_DESC");
                                if(strSpecDesc==null)
                                       {
                                           strSpecDesc="Undefined Record Found";
                                           
                                       }
                                       else {
                                           strSpecDesc=strSpecDesc;
                                           
                                       } 
                out.println("<tr id='" + strSpecId + "'>");   
                out.println("<td><a href=\"javascript:loadValuesFromTable('" + strSpecId + "')\">Edit</a></td>");
                out.println("<td>" + strSpecId + "</td>");
	 out.println("<td>" + strSpecDesc + "</td></tr>");
                 
              }
            }
            catch(SQLException e)
            {
              System.out.println("Exception in resultset:"+e);
            }
            finally
            {
              results.close();
            }
          }
          
      
      catch(SQLException e)
      { 
        System.out.println("Exception :"+e);
      }
    %>
          
          </tbody>
          
      </table>
      <table id="Exit" cellspacing="2" cellpadding="3" border="1" width="75%"
             align="center">
        <tr>
          
          <td class="tdH">
          <div align="center">
          <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick="Exit()" align="middle"/>
          </div>                   
          </td>
          </tr>
      </table>
     
    </form></body>
</html>