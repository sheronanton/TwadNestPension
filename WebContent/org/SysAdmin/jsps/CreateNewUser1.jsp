<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Create New User</title>
    <script type="text/javascript" src="../scripts/CreateNewUserValidation1.js">
    </script>
    <link href="../../../css/Sample3.css" rel="stylesheet" media="screen"/>
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
              //System.out.println("Exception in creating statement:"+e);
       }          
  }
  catch(Exception e)
  {
         //System.out.println("Exception in openeing connection:"+e);
  }  
  %>
  <form name="frmCreateUser" action="../../../CreateNewUser.con" method="post">
  
  <table  cellspacing="1" cellpadding="3" border="1" width="100%" class="table" >
                    <tr>
                        <td class="tdH">
                            <center><b>Create New User</b></center>
                        </td>
                    </tr>
                    <tr>
                        <td>                        
                              <table  cellspacing="3" cellpadding="1" border="1" width="100%" >
                                  <tr>
                                      <td class="table">Employee Id</td>
                                      <td class="table">
                                       <input type="text" name="txtEmployeeId" id=txtEmployeeId  maxlength="5" size="8" onchange="callLogin('EmpName','null')" onkeypress="return  numbersonly1(event,this)"/>  
                                            <img src="../../../images/c-lovi.gif"
                                                                                                  width="20"
                                                                                                  height="20"
                                                                                                  alt="empList"
                                                                                                  onclick="servicepopup();"/>
                                             
                                    <!--  <select name=txtEmployeeId id=txtEmployeeId onchange="Login()">
                                      <option>--Select Employee Id--</option>
                                      <%
                                      try
                                        {
                                            results=statement.executeQuery("select a.Employee_Id,a.Employee_Name from HRM_MST_EMPLOYEES a "+
                                                " inner join HRM_EMP_CURRENT_POSTING b on b.EMPLOYEE_ID=a.EMPLOYEE_ID "+
                                                "  where a.Employee_Id not in(select Employee_Id from SEC_MST_USERS) and "+
                                                " b.OFFICE_ID is not null and b.DESIGNATION_ID is not null");
                                            while(results.next())
                                            {
                                            String id=results.getString("Employee_Id");
                                            String name=results.getString("Employee_name");
                                                out.println("<option value='" + id + "'>" +name+"(" + id + ")"+ "</option>");   
                                            }
                                            results.close();
                                        }
                                        catch(SQLException e)
                                        {
                                                //System.out.println("Exception in creating statement:"+e);
                                        }
                                      
                                      %>
                                      </select>
                                            -->  
                                              
                                              
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Employee Name</td>
                                      <td>
                                        <input type="text" name="txtEmpName" maxlength="60" size="45" readonly/>
                                      </td>
                                  </tr>
                                  <tr>
                                   <td class="table">LoginId</td>
                                      <td class="table">
                                           <input type="text" name="txtLoginId" maxlength="50" size="25" />
                                           <input type="hidden" name="LoginId">
                                      </td>
                                  </tr>
                                  <tr>
                                   <td class="table">Password</td>
                                      <td class="table">
                                           <input type="password" name="txtPassword" maxlength="50" size="25" />
                                      </td>
                                  </tr>
                                  <tr>
                                   <td class="table">ConfirmPassword</td>
                                      <td class="table">
                                           <input type="password" name="txtConfirmPassword" maxlength="50" size="25" />
                                      </td>
                                  </tr>
                                  
                                  
                                  <tr>
                                      <td colspan=2 class="table" align="center">
                                          <input type="Submit" value="  Add " id="Add" name="cmdAdd" onclick="return nullCheck()"> 
                                                                         
                                      </td>                              
                                  </tr>      
                                  </table>
                    </td>
                    </tr>
</table>
</form>
  </body>
 
</html>