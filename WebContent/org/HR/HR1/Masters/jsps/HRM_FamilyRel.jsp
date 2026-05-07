<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <script type="text/javascript" src="../scripts/FamilyRelScript.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>

    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
    
    <title>Master HRM Family Relations Details</title>
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
  <form name="FamForm" id="FamForm">
      <table cellspacing="2" cellpadding="3" border="1" width="75%"
             align="center">
        <tr>
          <td colspan="2" class="tdH">
            <div align="center">
              <strong>Family Relations Details</strong>
            </div></td>
        </tr>
        <tr>
          <td class="table">Family Relationship Id</td>
          <td class="table">
           
                   <input type="TEXT" name="htxtFamId" maxlength="3"
                   id="htxtFamId" readonly size="3"/>System Generated
          </td>
        </tr>
        <tr>
          <td class="table">Family Relationship Desc</td>
          <td class="table">
            <input type="text" name="txtFamDesc" size="40" maxlength="60"
                   id="txtFamDesc"/>
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
            Family Relations Id
          </th>
          <th>
            Family Relations Desc
          </th>
          </tr>
          <tbody id="tblList" class="table">
           <%
      
          try
          {
              
            String sql="select * from HRM_MST_FAMILY_RELATIONS ORDER BY FAMILY_RELATIONSHIP_ID";
             results=statement.executeQuery(sql);
            try
            {
              while(results.next())
              {
                String strFamId=results.getString("FAMILY_RELATIONSHIP_ID");
	        String strFamDesc=results.getString("FAMILY_RELATIONSHIP_DESC");
                if(strFamDesc==null)
                                       {
                                           strFamDesc="Undefined Record Found";
                                           
                                       }
                                       else {
                                           strFamDesc=strFamDesc;
                                           
                                       }
                out.println("<tr id='" + strFamId + "'>");   
                out.println("<td><a href=\"javascript:loadValuesFromTable('" + strFamId + "')\">Edit</a></td>");
                out.println("<td>" + strFamId + "</td>");
	 out.println("<td>" + strFamDesc + "</td></tr>");
                 
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