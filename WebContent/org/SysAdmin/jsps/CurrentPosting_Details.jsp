<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.ResourceBundle"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>MasterRolesMenu</title>
     <link href="../../../css/Sample3.css" rel="stylesheet" media="screen"/>
     <link href="../../../css/CalendarControl.css" rel="stylesheet" media="screen"/> 
  <script type="text/javascript" src="../scripts/CurrPostingScript.js"></script>
  <script type="text/javascript"  src="../../Library/scripts/checkDate.js"></script>
  <script type="text/javascript"       src="../../Library/scripts/CalendarControl.js"></script>
  <script type="text/javascript">
  function toLoad()
    {
      document.frmEmployee.txtEmpId1.focus();
    }
    </script>
  </head>
  <body class="table" onload="toLoad()">
  
     <%
  Connection connection=null;
  Statement statement=null;
  ResultSet results=null;
  ResultSet results1=null;
  PreparedStatement ps=null;
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

  
  
  <form name="frmEmployee" id="frmEmployee">
      <p>
        &nbsp;
      </p>
      <table cellspacing="3" cellpadding="2" border="1" width="100%">
       <tr>
                                                <td align="center" class="tdH"
                                                    colspan="4">
                                                      <center>
                                                            <b>Update Employee Designation and Office Details</b>
                                                      </center>
                                                </td>
                                          </tr>
        
                                        <tr>
                                                <td colspan="2">Employee Id</td>
                                                <td colspan="2">
                                                      <input tabindex="1"
                                                             type="text"
                                                             name="txtEmpId1"
                                                             id="txtEmpId1"
                                                             onchange="callServer1('Load','null')" onkeypress="return  numbersonly1(event,this)"></input>
                                                      <input tabindex="1"
                                                             type="HIDDEN"
                                                             name="EmpId"
                                                             id="EmpId"></input>
                                                      <img src="../../../images/c-lovi.gif"
                                                           width="20"
                                                           height="20"
                                                           alt="empList"
                                                           onclick="servicepopup1();"></img>
                                                </td>
                                          </tr>
                                          
                                          <tr>
                                                <td colspan="2">Employee Name</td>
                                                <td colspan="2">
                                                      <input tabindex="1"
                                                             type="text"
                                                             name="txtEmpName"
                                                             id="txtEmpName" readonly size="45"></input>
                                                             
                                                </td>
                                          </tr>
         <tr>
                                                <td colspan="2">Designation</td>
                                                <td colspan="2">
                                                      <table cellspacing="2"
                                                             cellpadding="3"
                                                             border="0"
                                                             width="100%">
                                                            <tr>
                                                                  <td>Service
                                                                      Group</td>
                                                                  <td>
                                                                        <div id="divdes"
                                                                             style="visibility:hidden">Designation</div>
                                                                  </td>
                                                            </tr>
                                                            <tr>
                                                                  <td>
                                                                        <select name="cmbsgroup"
                                                                                id="cmbsgroup"
                                                                                onchange="getDesignation1()">
                                                                              <option value="0">Select
                                                                                                Service
                                                                                                Group</option>
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
            System.out.println("Exception in the service group id"+e);
          }
           
                
        %>
                                                                        </select>
                                                                  </td>
                                                                  <td>
                                                                        <select name="cmbdes"
                                                                                id="cmbdes"
                                                                                style="visibility:hidden"></select>
                                                                  </td>
                                                            </tr>
                                                      </table>
                                                </td>
                                          </tr>
                                            <tr>
                                                <td colspan="2">
                                                      Office&nbsp;Id
                                                      
                                                </td>
                                                <td colspan="2">
                                                      <input type="text"
                                                             name="Office_Id"
                                                             maxlength="30"
                                                             size="15" onchange="callServer1('ExistgOff','null')" 
                                                            onkeypress="return  numbersonly1(event,this)" />
                                                      <img src="../../../images/c-lovi.gif"
                                                           width="20"
                                                           height="20"
                                                           alt="empList"
                                                           onclick="jobpopup1();"/>
                                                </td>
                                          </tr>
                                          <tr>
                                                <td colspan="2">
                                                      Office Name
                                                    
                                                </td>
                                                <td colspan="2">
                                                      <input type="text"
                                                             name="Office_Name"
                                                             maxlength="30"
                                                             size="45" readonly />
                                                    
                                                </td>
                                          </tr>
        <tr>
          <td class="table" colspan="2">Date Of Joining</td>
          <td class="table" colspan="2">
            <input type="text" name="txtdtjoin" maxlength="10" id="txtdtjoin" onchange="return validate_date('frmEmployee','txtdtjoin')" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')" onBlur="DateFormat(this,this.value,event,true,'3')"/><font color="#000084" size="1"></font>
            <img src="../../../images/calendr3.gif" onclick="showCalendarControl(document.frmEmployee.txtdtjoin);" alt="Show Calendar"></img>
          </td>
        </tr>
        <tr>
          <td class="table" colspan="2">Remarks</td>
          <td class="table" colspan="2">
            <textarea name="txtremarks" cols="25" rows="5" id="txtremarks"></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="table">
            <input type="BUTTON" name="cmdUpdate" value="    Update    " id="cmdUpdate" onclick="checkForRedundancy()"/>
            <input type="BUTTON" name="cmdDelete" value="    Delete    " id="cmdDelete" onclick="callServer1('Delete','null')"/>
            <input type="BUTTON" name="cmdClear" value="Clear All"
                   id="cmdClear" onclick="clearAll()"/>
          </td>
        </tr>
      </table>
     
    </form></body>
</html>