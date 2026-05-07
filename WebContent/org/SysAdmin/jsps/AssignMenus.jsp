<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.ResourceBundle"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Master Roles Menu Details</title>
    <link href="../../../css/Sample3.css" rel="stylesheet" media="screen"/>
  <script type="text/javascript" src="../scripts/AjaxRolesMenu.js"></script>
    
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
    <form name="frmMasterRolesMenu" >
      
      <table cellspacing="3" cellpadding="2" border="1" width="100%">
        <tr>
          <td colspan="2" class="tdH">
            <DIV align="center">
              <STRONG>Master Roles Menu Details</STRONG>
            </DIV>
          </td>
        </tr>
        <tr>
          <td width="30%" class="td1">Role Id</td>
          <td width="70%" class="table">
            <select name="txtCmbRId" id="txtCmbRId" onchange="Load1(event)">
              <option value>--Select Role--</option>
               <%
                     try
                      {
                         results=statement.executeQuery("select Role_Id,Role_Name from SEC_MST_ROLES order by Role_Name");
                         while(results.next())
                         {
                             out.println("<option value='" + results.getInt("Role_Id") + "'>" + results.getString("Role_Name") + "</option>");
                         }
                         results.close();
                       }
                      catch(Exception e)
                      {
                      System.out.println("exception : " + e);
                      }
               %>            
            </select>
          </td>
        </tr>
        <tr>
          <td width="30%" class="td1">Intranet Major System</td>
          <td width="70%" class="table">
            <select name="txtCmbMajId" id="txtCmbMajId" onchange="combomajor(event)">
           
              <option>--Select Major System--</option>
            <%
                                        try
                                        {
                                            results1=statement.executeQuery("select MAJOR_SYSTEM_ID,MAJOR_SYSTEM_DESC from SEC_MST_MAJOR_SYSTEMS");
                                            while(results1.next())
                                            {
                                                String temp=results1.getString("MAJOR_SYSTEM_ID");                                            
                                                out.println("<option value='" + temp + "'>" + results1.getString("MAJOR_SYSTEM_DESC") + "</option>");                                            
                                            }
                                            results1.close();
                                        }
                                        catch(Exception e)
                                        {
                                        System.out.println("Exception in Major System:"+e);
                                        }
                                      %>
              
              
              
            </select>
          </td>
        </tr>
        <tr>
          <td width="30%" class="td1">Intranet Minor System</td>
          <td width="70%" class="table">
            <select name="txtCmbMinorId"  id="txtCmbMinorId"
                    onchange="comboMinor(event)">
              <option>--Select Minor System--</option>
            </select>
          </td>
        </tr>
        <tr>
          <td width="30%" class="td1">Intranet Sub System</td>
          <td width="70%" class="table">
            <select name="txtCmbSubId"  id="txtCmbSubId"
                    onchange="comboSub(event)" >
              <option>--Select Sub System--</option>
            </select>
          </td>
        </tr>
        <tr>
          <td width="30%" class="td1">Intranet Menu Id</td>
          <td width="70%" class="table">
            <select name="txtCmbMenu" id="txtCmbMenu" >
              <option>--Select Menu--</option>
            </select>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="BUTTON" value="Grant" name="cmdAdd" onclick="checkForRedundancy()" />
            <!--<input type="BUTTON" value="Delete" name="cmdDelete" onclick="callServer('Delete','null')" />-->
            <input type="BUTTON" value="ClearAll" name="cmdClearAll" onclick="clearAll()" />
            <input type="BUTTON" value="Exit" name="cmdExit" onclick="Exit()" />
          </td>
        </tr>
      </table>
      <table id="Existing"  border="1" width="100%"  style="font-family:arial;" >
                                    <tr><td  colspan="7">
          <strong>Existing Details</strong></td>
        </tr>
                                    <tr class="tdH">
                                    
                                    <th >Delete</th>
                                    <!--<th>Role Id</th>-->
                                    <th>Role Desc</th>
                                    <!--<th>Intranet Major System ID </th>-->
                                    <th>Intranet Major System Desc</th>
                                    <!--<th>Intranet Minor System ID </th>-->
                                    <th>Intranet Minor System Desc</th>
                                     <!--<th>Intranet Sub System ID </th>-->
                                     <th>Intranet Sub Desc </th>
                                     <th>Intranet Menu ID </th>
                                      <th>Intranet Menu Desc</th>
                                      
                                    
                                    <tbody id="tblList">
                                        </tbody>
                                       </tr>
                                  </table>
     
    </form>
  </body>
</html>
