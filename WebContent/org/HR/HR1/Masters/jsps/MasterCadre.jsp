
<!--
    File Name     : MasterBenefit.jsp
    Purpose       : To create form that allows us add,modify and delete records residing in database
    References    : BenefitAjax.js,BenefitValidations.js,sample2.css
    Servlet Ref.  : ServletBenefitMaster.java
-->

<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
      <title>Cadre Master</title>
          <script type="text/javascript">
            var edit=false;            
          </script>
          <script type="text/javascript" src="../scripts/AjaxCadre.js"></script>      
          <script type="text/javascript" src="../scripts/ValidationCadre.js"></script>          
          
          <!--<link href="../../../../../css/green.css" rel="stylesheet" media="screen"/>          -->
          <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
          <link href="../../../../../css/tooltip.css" rel="stylesheet" media="screen"/>
    </head>
 <body>    
        
        <form name="frmCadre" >
          <div id="dhtmltooltip"></div>
          <script type="text/javascript" src="../../../../Library/scripts/tooltip.js"></script>
                <table  cellspacing="1" cellpadding="3" border="0" width="100%" class="table">
                    <tr>
                    
                        <td><center>
                            <h2>
                Cadre Master
                            </h2>
                            </center>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">   <center>                     
                              <table  cellspacing="3" cellpadding="1" border="0" width="100%" style="font-size:x-small;" align="center">
                                  <tr>
                                  <td colspan="2">&nbsp;&nbsp;&nbsp;</td>
                                      <td ><b>Cadre Id</b></td>
                                      <td style="color:rgb(255,51,102);">
                                        <input type="text" name="txtCadreId" size="4" maxlength="4" onkeyup="isInteger(this,event)" onblur="Verification()" onkeypress="LoadCadreDetails(event)"/>
                                        <img src="../../../../../images/help.png" width="16" height="16" onmouseover="ddrivetip('Enter Numeric Only','white',150)" onmouseout="hideddrivetip()"/> &nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="BUTTON" value="Select a Cadre ID" onclick="popupWindow()" name="cmdSelect" disabled> 
                                      </td>
                                  </tr>
                                  <tr>
                                  <td colspan="2">&nbsp;&nbsp;&nbsp;</td>
                                      <td ><b>Cadre Name</b></td>
                                      <td>
                                        <input type="text" name="txtCadreName" maxlength="50" size="25" />
                                      </td>
                                  </tr>
                                  <tr>
                                  <td colspan="2">&nbsp;&nbsp;&nbsp;</td>
                                      <td >
                                       <b> Cadre Short Name</b>
                                      </td>
                                      <td>
                                        <input type="text" name="txtCadreSName" maxlength="10" size="10" />
                                      </td>
                                  </tr>
                                  <tr>
                                  <td colspan="2" >&nbsp;&nbsp;&nbsp;</td>
                                      <td >
                                     <b>   Remarks</b>
                                      </td>
                                      <td>
                                        <textarea name="txtRemarks" cols="25" rows="5" ></textarea>
                                      </td>
                                  </tr>
                                  <tr>
                                  <td >&nbsp;&nbsp;&nbsp;</td>
                                      <td colspan=3 >
                                          <input type="Button" value="  Add  " onclick="addRecord();" name="cmdAdd"> 
                                          <input type="Button" value="  Edit  " onclick="promptID()" name="cmdEdit"> 
                                          <input type="Button" value=" Update" onclick="callServer('Update','null')" disabled name="cmdUpdate"> 
                                          <input type="Button" value=" Delete" onclick="callServer('Delete','null')" disabled name="cmdDelete">
                                          <input type="Button" value="Clear All" onclick="clearAll()" name="cmdClearAll">
                                          <input type="Button" value="List All Cadres" name="cmdListAll">                                 
                                      </td>                              
                                  </tr>                              
                              </table>   
                            </center>
                        </td>                        
                    </tr>
              </table>
        </form>
  </body>
</html>

