<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
      <title>Assign Menus To User Roles</title>      
      <script type="text/javascript" src="../scripts/AssigningMenus.js"></script>
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
//System.out.println("Connection string :" + ConnectionString);
             Class.forName(strDriver.trim());
             connection=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
       try
       {
            statement=connection.createStatement();
            connection.clearWarnings();
       }
       catch(SQLException e)
       {
              System.out.println("Exception in creating statement:"+e);
       }          
  }
  catch(Exception e)
  {
         System.out.println("Exception in openeing connection:"+e);
  }  
 %>
<form name="frmAddingMenus" class="table" > 
    
               
                <table  cellspacing="1" cellpadding="3" border="1" width="100%" class="table" >
                    <tr>
                        <td class="tdH">
                            <center><h2>Adding Menus To Roles</h2></center>
                        </td>
                    </tr>
                    <tr>
                        <td>                        
                              <table  cellspacing="3" cellpadding="1" border="1" width="100%" style="font-size:x-small;">
                                  <tr>
                                      <td class="td">Role Id</td>
                                      <td style="color:rgb(255,51,102);">
                                      <select name=txtRoleId id=txtRoleId>
                                      <option>--Select Role Id--</option>                                      
                                      <%
                                            try
                                             {
                                                  results=statement.executeQuery("select * from SEC_MST_ROLES");
                                                  while(results.next())
                                                  {
                                                    out.println("<option value='" + results.getInt("ROLE_ID") + "'>" + results.getString("ROLE_NAME") + "</option>");   
                                                  }
                                                  results.close();
                                             }
                                             catch(Exception e)
                                             {
                                                    System.out.println("Exception in creating statement:"+e);
                                             }
                                      %>
 
                                      </select>                                     
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Major System</td>
                                      <td>
                                      <select name=txtMajorId id=txtMajorId onchange="callServer('Major','null')">
                                      <option>--Select MajorSystemId--</option>
                                       <%
                                            try
                                             {
                                                  results=statement.executeQuery("select * from SEC_MST_MAJOR_SYSTEMS");
                                                  while(results.next())
                                                  {
                                                    out.println("<option value='" + results.getString("MAJOR_SYSTEM_ID") + "'>" + results.getString("MAJOR_SYSTEM_SHORT_DESC") + "</option>");   
                                                  }
                                                  results.close();
                                             }
                                             catch(Exception e)
                                             {
                                                    System.out.println("Exception in creating statement:"+e);
                                             }
                                      %>
 
                                      </select>                                        
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Minor System</td>
                                      <td>
                                        <select name=txtMinorId id=txtMinorId onChange="callServer('Minor','null')">
                                      <option>--Select MinorSystemId--</option>
                                      </select>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Sub System</td>
                                      <td>
                                        <select name=cmbSub id=cmbSub>
                                      <option>--Select MinorSystemId--</option>
                                      </select>
                                      </td>
                                  </tr>
                                   <tr>
                                      <td class="td">Select the Menu</td>
                                      <td>
                                        <select name=cmbMenu id=cmbMenu>
                                      <option>--Select MenuSystemId--</option>
                                      </select>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">&nbsp;</td>
                                      <td>&nbsp;
                                      </td>
                                  </tr>
                                  <tr>
                                      <td colspan=3 class="td">
                                          <input type="Button" value="  Add " id="Add" onclick="callServer('Add','null')" name="cmdAdd"> 
                                          <input type="Button" value=" Delete " id="Delete" onclick="callServer('Delete','null')" disabled name="cmdDelete">
                                          <input type="Button" value="Clear All" onclick="clearAll()" name="cmdClearAll">                                 
                                      </td>                              
                                  </tr>      
                                  <tr>
                                  <td colspan="3">                                   
                                    <table id="Existing"  border="1" width="100%"  style="font-family:arial;">
                                    <tr>
                                    <td colspan="5">
                                    Existing Details
                                    </td>
                                    </tr>
                                    <tr>
                                    <th >View</th>
                                    <th >Menu Name</th>
                                    <th >Major System</th>
                                    <th >Minor System</th>
                                    <th >Sub System</th>
                                    </tr>
                                   
                                    <tbody id="tblList">
                                    
                                    </tbody>
                                  </table>
                                  
                                  </td>
                                  </tr>
                              </table>                              
                        </td>                        
                    </tr>
              </table>
        </form>
  </body>
</html>

