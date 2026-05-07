
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*"%>
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>

<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
      <title>Activate User</title>
          
          <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
          <script type="text/javascript" src="../scripts/Activate_User.js"></script>      
          <script type="text/javascript" src="../scripts/UpdatingValidation.js"></script>
          <script type="text/javascript" >       var edit=false;    </script>    
          <script type="text/javascript" src="test.js"></script>
          
          <link href="../../../css/Sample3.css" rel="stylesheet" media="screen"/>
          <link href="test2.css" rel=stylesheet media="screen"/>
     </head>
 <body> 
       <form name="frmActivate_User" class="table" >
          <div id="dhtmltooltip"></div>
                <%
                  HttpSession session=request.getSession(false);
                  String userid=request.getParameter("userid");
                  session.setAttribute("userid",userid);
                %>
                <table  cellspacing="1" cellpadding="3" border="1" width="100%" class="table" >
                    <tr>
                        <td class="tdH">
                            <center><h2>Activate User</h2></center>
                        </td>
                     </tr>
                     <tr>
                        <td>                        
                             <table  cellspacing="3" cellpadding="1" border="1" width="100%" style="font-size:x-small;">
                                  <tr>
                                      <td class="td">User Id</td>
                                      <td><input type="text" name="txtUserId" id="txtUserId" maxlength="10" size="10" onchange="callServer('Login','null')"/> </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Employee Id</td>
                                      <td style="color:rgb(255,51,102);">
                                          <input type="text" name="txtSysId" id="txtSysId"  maxlength="5" size="8" readonly/>  
                                          <input type=hidden name=EmpId>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Employee Name</td>
                                      <td>
                                        <input type="text" name="txtEmpName" id="txtEmpName" maxlength="60" size="45" readonly/>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Current Login Status </td>
                                      <td> 
                                         <input type="text" name="txtUserStatus" id="txtUserStatus" maxlength="10" size="10" readonly/>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Enable Login ?</td>
                                      <td> 
                                         <input type="radio" name="txtLEnable" id="txtLEnable" value="1" />Yes
                                         <input type="radio" name="txtLEnable" id="txtLEnable" value="0" />No
                                        
                                      </td>
                                  </tr>
                                  <tr>
                                      <td colspan=3 class="td" align="center">
                                          <input type="Button" value=" Submit " id="Add" onclick="callServer('Add','null')" name="cmdAdd"> 
                                          <input type="Button" value="Clear All" onclick="clearAll()" name="cmdClearAll">                                 
                                          <input type="button" name="CmdExit" value="Exit" id="CmdExit" onclick="Exit()" align="middle"/>
                                      </td>                              
                                  </tr>      
                              </table>                              
                        </td>                        
                    </tr>
              </table>
        </form>
  </body>
</html>

