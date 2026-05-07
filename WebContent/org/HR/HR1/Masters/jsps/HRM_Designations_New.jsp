<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,java.util.*"%>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <script type="text/javascript" src="../scripts/DesigScript_New.js"></script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
    <title>Master HRM Designation Details</title>
  </head>
  <body onload="callServer('Get','null')">
   <%
  Connection connection=null;
  Statement statement=null;
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
                // ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

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
  <form name="DesigForm" id="DesigForm">
      <table cellspacing="3" cellpadding="2" border="1" width="100%" align="center">
        <tr>
          <td colspan="2" class="tdH">
            <div align="center">
              <strong>DESIGNATIONS DETAILS</strong>
            </div></td>
        </tr>
        <tr>
          <td class="table">Designation Id</td>
          <td class="table">
            
            <input type="TEXT" name="htxtDesigId" maxlength="3" id="htxtDesigId" readonly size="3"/>System Generated
          </td>
        </tr>
        <tr>
          <td class="table">Designation</td>
          <td class="table">
            <input type="text" name="txtDesigDesc" id="txtDesigDesc"/>
          </td>
        </tr>
         <tr>
          <td class="table">Cadre Id</td>
          <td class="table">
            <select size="1" name="cmbCadreId" id="cmbCadreId" onchange="callServer('Pay','null')">
              <option value="">
                ---Select Cadre Id---
              </option>
              <%
                                        try
                                        {
                                            results1=statement.executeQuery("select CADRE_ID,CADRE_NAME from HRM_MST_CADRE");
                                            while(results1.next())
                                            {
                                            String temp=results1.getString("CADRE_ID");
                                              out.println("<option value='" + temp + "'>" + results1.getString("CADRE_NAME") + "</option>");
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
          <td class="table">Pay Scale Id</td>
            <td class="table">
            <input type="text" name="cmbPayId" id="cmbPayId" readonly size="35">
          </td>          
        </tr>
        
        <tr>
          <td class="table">Post Rank Id</td>
          <td class="table">
            <select size="1" name="cmbPostId" id="cmbPostId">
              <option value="">
                ---Select Post Rank Id---
              </option>
              <%
                                        try
                                        {
                                            results1=statement.executeQuery("select POST_RANK_ID,POST_RANK_NAME from HRM_MST_POST_RANKS");
                                            while(results1.next())
                                            {
                                            String temp=results1.getString("POST_RANK_ID");
                                              out.println("<option value='" + temp + "'>" + results1.getString("POST_RANK_NAME") + "</option>");
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
          <td class="table">Service Group Id</td>
          <td class="table">
            <select size="1" name="cmbSerId" id="cmbSerId">
              <option value="">
                ---Select Service Group Id
              </option>
              <%
                                        try
                                        {
                                            results2=statement.executeQuery("select SERVICE_GROUP_ID,SERVICE_GROUP_NAME from HRM_MST_SERVICE_GROUP");
                                            while(results2.next())
                                            {
                                            String temp=results2.getString("SERVICE_GROUP_ID");
                                              out.println("<option value='" + temp + "'>" + results2.getString("SERVICE_GROUP_NAME") + "</option>");
                                            }
                                            results2.close();
                                        }
                                        catch(Exception e)
                                        {}
                                      %>
            </select>
          </td>
        </tr>
        <tr>
          <td class="table">Ordering Sequence Number</td>
          <td class="table">
            <input type="text" name="txtDesigsDesc" id="txtDesigsDesc"/>
          </td>
        </tr>
        <tr>
          <td class="table">Remarks</td>
          <td class="table">
            <textarea name="txtRemarks" cols="25" rows="3" id="txtRemarks"></textarea>
          </td>
        </tr>
        <tr>
         
          <td colspan="2" class="table">
            <input type="button" name="CmdAdd" value="ADD" id="CmdAdd" onclick="callServer('Add','null')"/>
            <input type="button" name="CmdUpdate" value="UPDATE"
                   id="CmdUpdate" onclick="callServer('Update','null')" disabled/>
            <input type="button" name="CmdDelete" value="DELETE"
                   id="CmdDelete" onclick="callServer('Delete','null')" disabled/>
            <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
          </td>
        
        </tr>
      </table>
       <table cellspacing="3" cellpadding="2" border="1" width="100%"
             align="center" >
        <tr>
          <td class="table">Existing Details</td>
        </tr>
      </table>
      <table id="Existing" cellspacing="2" cellpadding="3" border="1" width="100%"
             align="center">
        <tr class="tdH">
          <th>
            Select
          </th>
          <th>
            Designation Id
          </th>
          <th>
            Designation 
          </th>
           <th>
            Cadre Name
          </th>
          <th>
            Post Rank Name
          </th>
          
          <th>
            Service Group Name
          </th>
           <th>
            Order Seq No
          </th>
          <th>
            Remarks
          </th>
          </tr>
          <tbody id="tblList" class="table">
          
          </tbody>
          
      </table>
      <table id="Exit" cellspacing="2" cellpadding="3" border="1" width="100%"
             align="center">
        <tr>
          
          <td class="tdH">
          <div align="center">
          <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick=Exit() align="middle"/>
          </div>                   
          </td>
          </tr>
      </table>
      
    </form></body>
</html>