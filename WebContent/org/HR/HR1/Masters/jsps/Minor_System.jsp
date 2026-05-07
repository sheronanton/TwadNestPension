<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
       <title>Minor Systems Details</title>
         <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
       <script type="text/javascript" src="../scripts/MinorScript.js"></script>
       <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
  </head>
  <body class="table">
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
  
  <form name="MinorForm" id="MinorForm">
      
      <table cellspacing="2" cellpadding="3" border="1" width="75%" align="center">
        <tr class="tdH">
          <th colspan="2">
             Minor  Systems  Details
          </th>
        </tr>
        <tr>
          <td class="table">Major System Id</td>
          <td class="table">
            <select size="1" name="CmbMajorId" id="CmbMajorId" onchange="callServer('Load','null')">
              <option value="">
                ---Select Major Id---
              </option>
               <%
                                        try
                                        {
                                            results1=statement.executeQuery("select MAJOR_SYSTEM_ID,MAJOR_SYSTEM_DESC from SEC_MST_MAJOR_SYSTEMS");
                                            while(results1.next())
                                            {
                                            String temp=results1.getString("MAJOR_SYSTEM_ID");
                                            System.out.println(temp);
                                              out.println("<option value='" + temp + "'>" + results1.getString("MAJOR_SYSTEM_DESC") + "</option>");
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
            <input type="text" name="txtMinorId" id="txtMinorId" style="TEXT-TRANSFORM:UPPERCASE" onchange="return toCheckNumeric1()"/>
            <input type="HIDDEN" name="htxtMinorId" id="htxtMinorId"/>
          </td>
        </tr>
        <tr>
          <td class="table">Minor System  Desc</td>
          <td class="table">
            <input type="text" name="txtMinorDesc" id="txtMinorDesc" size="85" onchange="return toCheckNumeric2()"/>
          </td>
        </tr>
        <tr>
          <td class="table">Minor System Short Desc</td>
          <td class="table">
            <input type="text" name="txtMinorSDesc" 
                   id="txtMinorSDesc" size="85" onchange="return toCheckNumeric3()"/>
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
        Existing Details:
      </p>
      
      <table id="Existing" cellspacing="2" cellpadding="3" border="1" width="75%" align="center">
        <tr class="tdH">
          <th>
            View
          </th>
          <th>
            Minor System Id
          </th>
          <th>
            Minor System  Desc
          </th>
          <th>
            Minor System Short Desc
          </th>
          <tbody id="tblList" name="tblList" class="table"></tbody>
        </tr>
      </table>
      <p>
        &nbsp;
      </p>
      <p>
        &nbsp;
      </p>
    </form></body>
</html>