<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>  <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <script type="text/javascript" src="../scripts/SubScript.js"></script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
    <title>Sub System Details</title>
  </head>
  <body onload="toWork()" class="table">
    <%
  Connection connection=null;
  Statement statement=null;
  ResultSet results=null;
  ResultSet results1=null;
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
  <form name="SubForm" id="SubForm">
     
      <table cellspacing="3" cellpadding="2" border="1" width="75%" align="center">
        <tr>
          <td colspan="2" class="tdH">
            <div align="center">
              <strong>Sub System Details</strong>
            </div></td>
        </tr>
        <tr>
          <td class="table">Major System Id</td>
          <td class="table">
            <select size="1" name="CmbMajorId" id="CmbMajorId" onchange="combomajor(event)">
              <option value="">
                ---Select Major Id---
              </option>
               <%
                                        try
                                        {
                                            results1=statement.executeQuery("select Major_System_Id,Major_System_Desc from SEC_MST_MAJOR_SYSTEMS");
                                            while(results1.next())
                                            {
                                            String temp=results1.getString("Major_System_Id");
                                            System.out.println(temp);
                                              out.println("<option value='" + temp + "'>" + results1.getString("Major_System_Desc") + "</option>");
                                            
                                            }
                                            results1.close();
                                        }
                                        catch(Exception e)
                                        {}
                                      %>

            </select>
          </td>
        </tr>
        <tr>
          <td class="table">Minor System Id</td>
          <td class="table">
            <select size="1" name="CmbMinorId" id="CmbMinorId" onchange="callServer('Load','null')">
              <option value="">
                ---Select Minor Id---
              </option>
            </select>
          </td>
        </tr>
        <tr>
          <td class="table">Sub System Id</td>
          <td class="table">
            <input type="text" name="txtSubId" id="txtSubId"/>
            <input type="HIDDEN" name="htxtSubId" id="htxtSubId"/>
          </td>
        </tr>
        <tr>
          <td class="table">Sub System Desc</td>
          <td class="table">
            <input type="text" name="txtSubDesc" size="85" id="txtSubDesc"/>
          </td>
        </tr>
        <tr>
          <td class="table">Sub System Short Desc</td>
          <td class="table">
            <input type="text" name="txtSDesc" id="txtSubSDesc" size="85"/>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="table" id="add" style="display:block">
            <input type="button" name="CmdAdd" value="SAVE" id="CmdAdd" onclick="checkForRedundancy()"/>
            <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
                   <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick="Exit()" align="middle"/>
           </td>
           <td colspan="2" class="table" id="update" style="display:none">
            <input type="button" name="CmdUpdate" value="UPDATE"
                   id="CmdUpdate" onclick="callServer('Update','null')"/>
            <input type="button" name="CmdDelete" value="DELETE"
                   id="CmdDelete" onclick="callServer('Delete','null')"/>
                   <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
                   <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick="Exit()" align="middle"/>
          </td>
        </tr>
      </table>
      <p>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Existing Details
      </p>
      
      <table id="Existing" cellspacing="2" cellpadding="3" border="1" width="75%" align="center">
        <tr class="tdH">
          <th>
            View
          </th>
          <th>
            Sub System Id
          </th>
          <th>
            Sub System Desc
          </th>
          <th>
            Sub System Short Desc
          </th>
          <tbody id="tblList" class="table"></tbody>
        </tr>
      </table>
      <p>
        &nbsp;
      </p>
    </form></body>
</html>