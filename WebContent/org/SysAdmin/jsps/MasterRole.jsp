<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Create New Role</title>
    <link href="../../../css/Sample3.css" rel="stylesheet" media="screen"/>
    <script language = "javascript" type="text/javascript"  src="../scripts/AjaxRoles.js"></script>
  </head>
  <body onload="callServer('Load','null')">
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
    <form name="frmMasterRoles">
      <P>&nbsp;</P>
     <center>
      <table cellspacing="2" cellpadding="3" border="1" width="75%" class="table">
        <tr>
          <td colspan="2" class="tdH">
            <DIV align="center">
              <STRONG>Create New Role</STRONG>
            </DIV>
          </td>
        </tr>
        <tr>
          <td class="td1">Role Id</td>
          <td>
            <input type="text" name="txtRId" readonly class="disab"/>System Generated
            <input type="hidden" name="htxtRId" id="htxtRId"/>
          </td>
        </tr>
        <tr>
          <td class="td1">Role Name</td>
          <td>
            <input type="text" name="txtRName" size="65"/>
          </td>
        </tr>
         <tr>
          <td class="td1">Role Category</td>
          <td>
            <input type="radio" name="category" id="category" value="I" />Individual
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                <input type="radio" name="category" id="category"  value="C"  />Common
                
          </td>
        </tr>
        <tr>
          <td colspan="2" class="tdH">
            <input type="Button" value="  Add " id="Add" onclick="callServer('Add','null')" name="cmdAdd"> 
            <input type="Button" value="  Update " id="Update" onclick="callServer('Update','null')" name="cmdUpdate" disabled> 
            <input type="Button" value=" Delete" id="Delete" onclick="callServer('Delete','null')" name="cmdDelete" disabled>
            <input type="Button" value="Clear All" onclick="clearAll()" name="cmdClearAll"> 
          </td>
        </tr>
      </table>
      
       <table cellspacing="3" cellpadding="2" border="1" width="75%"
             align="center" >
        <tr>
          <td class="table">Existing Details</td>
          <td align="right" class="table">
                Page&nbsp;Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="cmbpagination" onchange="changepagesize()">
                  <option value="5" selected="selected">5</option>
                  <option value="10">10</option>
                  <option value="15">15</option>
                  <option value="20">20</option>
                </select>
           </td>
        </tr>
      </table>
      
      <table id="Existing" cellspacing="2" cellpadding="3" border="1" width="75%"
             align="center">
        <tr class="tdH" >
                                    <th >View</th>
                                    <th >Role Id</th>
                                    <th >Role Name</th>
                                     <th >Role Category</th>
                                    </tr>
                                   
                                    <tbody id="tblList" name="tblList" class="table">
                                    </tbody>
 <tr class="tdH">
      <td colspan="5">
       <table align="center"  cellspacing="3" cellpadding="2" border="0" width="100%" >
       <tr >
       <td width="30%">
          <div align="left"> <div id="divpre" style="display:none"></div> </div>
      </td>
       <td width="40%">
          <div align="center"><table border="0"><tr><td> <div id="divcmbpage" style="display:none" >Page&nbsp;&nbsp;<select name="cmbpage" id="cmbpage" onchange="changepage()"></select></div></td><td><div id="divpage"></div></td></tr></table> </div>
      </td>
      <td width="30%">
          <div align="right"> <div id="divnext" style="display:none"></div> </div>
      </td>
      </tr>
      </table>
      </tr>
      <tr class="tdH">
          
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
