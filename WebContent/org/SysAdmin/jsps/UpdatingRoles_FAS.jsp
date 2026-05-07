


<!--
    File Name     : IntranetMajorSystems.jsp
    Purpose       : To create form that allows us add,modify and delete records residing in database
    References    : BenefitAjax.js,BenefitValidations.js,sample2.css
    Servlet Ref.  : ServletBenefitMaster.java
-->

<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*"%>
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
      <title>Updating Roles</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
          <script type="text/javascript" src="../scripts/UpdatingAjax_FAS.js"></script>      
          <script type="text/javascript" src="../scripts/UpdatingValidation_FAS.js"></script>
          <link href="test2.css" rel=stylesheet media="screen"/>
      <script type="text/javascript" >
     var edit=false;
      </script>    
          <link href="../../../css/Sample3.css" rel="stylesheet" media="screen"/>
      
    </head>
 <body > 
        <form name="frmMasterSub" class="table" >
        <div id="dhtmltooltip"></div>
    <script type="text/javascript" src="test.js"></script>
                <%
                HttpSession session=request.getSession(false);
                String userid=request.getParameter("userid");
                session.setAttribute("userid",userid);
                %>
                <table  cellspacing="1" cellpadding="3" border="1" width="100%" class="table" >
                    <tr>
                        <td class="tdH">
                            <center><h2>Updating Roles</h2></center>
                        </td>
                    </tr>
                    <tr>
                        <td>                        
                              <table  cellspacing="3" cellpadding="1" border="1" width="100%" style="font-size:x-small;">
                                 <tr>
                                      <td class="td">User Id</td>
                                      <td>
                                        <input type="text" name="txtUserId" maxlength="10" size="10" onchange="callServer('Login','null')"/>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Employee Id</td>
                                      <td style="color:rgb(255,51,102);">
                                     <!-- <select name=txtSysId id=txtSysId onchange="callServer('Login','null')">
                                      <option>--Select Employee Id--</option>
                                      </select>         -->
                                            <input type="text" name="txtSysId" id=txtSysId  maxlength="5" size="8"  onkeypress="return  numbersonly1(event,this)"  readonly/>  
                                           <!--onchange="callServer('Login','null')"
                                           onchange="callServer('Login','null')"
                                           <img src="../../../images/c-lovi.gif"
                                                                                                  width="20"
                                                                                                  height="20"
                                                                                                  alt="empList"
                                                                                                  onclick="servicepopup();"/> -->
                                              <input type=hidden name=EmpId>
                                              
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Employee Name</td>
                                      <td>
                                        <input type="text" name="txtEmpName" maxlength="60" size="45" readonly/>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">RoleName</td>
                                      <td>
                                      <select name=txtName id=txtName>
                                      <option>--Select Role--</option>
                                      </select>
                                        <!--<input type="text" name="txtName" maxlength="50" size="25" />-->
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="td">Ordering Sequence Number</td>
                                      <td>
                                        <input type="text" name="txtOrderSeq" maxlength="3" size="25" />
                                      </td>
                                  </tr>
                                  
                                  <tr>
                                      <td colspan=3 class="td">
                                          <input type="Button" value="  Grant " id="Grant" onclick="callServer('Add','null')" name="cmdAdd"> 
                                          <input type="Button" value=" Revoke" id="Revoke" onclick="callServer('Delete','null')" disabled name="cmdDelete">
                                          <input type="Button" value="Clear All" onclick="clearAll()" name="cmdClearAll">                                 
                                          <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick="Exit()" align="middle"/>
                                      </td>                              
                                  </tr>      
                                  <tr>
                                  <td colspan="3">
                                   <!--<div id="mydiv" name="mydiv"> -->
                                    <table name="Existing" id="Existing"  border="1" width="100%"  style="font-family:arial;">
                                    <tr>
                                    Existing Details
                                    </tr>
                                    <tr>
                                    <p><th >View</th></p>
                                    <th >Role Id</th>
                                    <th >Role Name</th>
                                    <th >Ordering Seqence Number</th>
                                    </tr>
                                   
                                    <tbody id="tblList" name="tblList">
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

