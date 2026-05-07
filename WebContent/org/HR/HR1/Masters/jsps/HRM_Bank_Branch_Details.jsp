<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"  contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*,Servlets.Security.classes.UserProfile"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>    
    <meta http-equiv="cache-control" content="no-cache">
    <title>Bank Branch Details</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <script type="text/javascript"  src="../../../../../org/Library/scripts/checkDate.js"></script>
    <script type="text/javascript" src="../scripts/HRM_Bank_Branch_Details.js"></script>
    
    <link href="../../../../../css/Sample3.css" rel="stylesheet"  media="screen"/>
    <link href="../../../../../css/CalendarControl.css" rel="stylesheet" media="screen"/>
          <link href='../../../../../css/Fas_Account.css' rel='stylesheet' media='screen'/>
    <script type="text/javascript" src="../../../../../org/HR/HR1/EmployeeMaster/scripts/CalendarControl.js"></script> 
     <!-- to avoid future date the above script used-->
    <script type="text/javascript" language="javascript">
         function foc()
         {
         }
</script>
  </head>
  <body onload="foc()" bgcolor="rgb(255,255,225)">
  <table cellspacing="1" cellpadding="3" width="100%" >
      <tr class="tdH">
        <td colspan="2">
          <div align="center">
            <font size="4">HRM Bank Branch Details </font>
          </div>
        </td>
      </tr>
    </table>
    
    <form name="frmBank_Branch_Details" id="frmBank_Branch_Details" >
                  
  <%
  
      Connection con=null;
      ResultSet rs=null,rs2=null;
      PreparedStatement ps=null,ps2=null;
      ResultSet results=null;
      ResultSet results1=null;
      ResultSet results2=null;
       Statement statement=null;
       try
      {
      
                 ResourceBundle rs1=ResourceBundle.getBundle("Servlets.Security.servlets.Config");
                String ConnectionString="";
    
                String strDriver=rs1.getString("Config.DATA_BASE_DRIVER");
                String strdsn=rs1.getString("Config.DSN");
                String strhostname=rs1.getString("Config.HOST_NAME");
                String strportno=rs1.getString("Config.PORT_NUMBER");
                String strsid=rs1.getString("Config.SID");
                String strdbusername=rs1.getString("Config.USER_NAME");
                String strdbpassword=rs1.getString("Config.PASSWORD");
                ConnectionString=strdsn.trim()+"://"+strhostname.trim()+":"+strportno.trim()+"/"+strsid.trim();//PostgresDB Connection
          //      ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;
    
                 Class.forName(strDriver.trim());
                 con=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
      }
      catch(Exception e)
      {
        System.out.println("Exception in connection...."+e);
      }
  %>
  <% 
       HttpSession session=request.getSession(false);
       UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
      
       System.out.println("user id::"+empProfile.getEmployeeId());
       int empid=empProfile.getEmployeeId();
       int bankid=0;     
    
       int  oid=0;
       String oname="";
       try
       {
           
            ps=con.prepareStatement("select OFFICE_ID from HRM_EMP_CURRENT_POSTING where EMPLOYEE_ID=?" );
            ps.setInt(1,empid);
            results=ps.executeQuery();
                 if(results.next()) 
                 {
                    oid=results.getInt("OFFICE_ID");
                 }
            results.close();
            ps.close();
            ps=con.prepareStatement("select OFFICE_NAME from COM_MST_OFFICES where OFFICE_ID=?" );
            ps.setInt(1,oid);
            results=ps.executeQuery();
                 if(results.next()) 
                 {
                    oname=results.getString("OFFICE_NAME");
                  }
            results.close();
            ps.close();     
            System.out.println("off id.. emp id"+oid+".."+empid);     
       }
       catch(Exception e)
       {
         System.out.println(e);
       }
   
   %>
   
    
         <table cellspacing="1" cellpadding="2" border="1" width="100%">
        
                  
              <tr class="table">
                <td>
                  <div align="left">
                     Bank Name
                    <font color="#ff2121">*</font>
                  </div>
                </td>
                <td>
                  <div align="left">
                
                    <select size="1" name="cmbBankId" id="cmbBankId" tabindex="3" >
                    <option value="">-- Select Bank Name --</option>
                      <%
                    try
                    {
                     ps=con.prepareStatement("select BANK_ID, BANK_NAME from HRM_MST_BANKS");
                     
                     rs=ps.executeQuery();
                     while(rs.next())
                     {
                        out.println("<option value="+rs.getInt("BANK_ID")+">"+rs.getString("BANK_NAME")+"</option>");
                     }
                        
                    } 
                    catch(Exception e)
                    {
                    System.out.println("Exception in bank combo..."+e);
                    }
                    finally
                    {
                    rs.close();
                    ps.close();
                    }  
                %>
                    </select>
                  </div>
                </td>
              </tr>
               <tr class="table">
             <td >
                 Branch Id
                </td>
            <td>
                <input  tabindex="4" type=text name=id id="id"  class="disab" disabled >(System Generated)
                <input  tabindex="4" type=HIDDEN name=BranchId id="BranchId">
            </td>
        </tr>
              
              <TR class="table">
                                      <TD >
                                          Branch Name<label style="color:rgb(255,0,0);">*</label>
                                </TD>
                                      <TD>
                                          <input type="text" name="txtOffice_Name" id="txtOffice_Name" onkeyup="capitalise()" tabindex="5" size="30" >
                                          
                                      </TD>
                                  </TR>
                                  <TR class="table">
                                      <TD rowspan="2">
                                           Address<label style="color:rgb(255,0,0);"/>
                                </TD>
                                      <TD>
                                          <input type="text" name="txtOffice_Address1" id="txtOffice_Address1" tabindex="6" size="30" onfocus="return officeCheck()">
                                          
                                      </TD>
                                  </TR>
                                  <TR class="table">
                                      <TD>
                                          <input type="text" name="txtOffice_Address2" id="txtOffice_Address2" tabindex="7" onfocus="return officeCheck()" size="30">
                                          
                                      </TD>
                                  </TR>
                                  <TR class="table">
                                      <TD>
                                          City/Town
                                      </TD>
                                      <TD>
                                          <input type="text" name="txtOffice_City" id="txtOffice_City" tabindex="8" onfocus="return officeCheck()">
                                      </TD>
                                  </TR>
                                  <TR class="table">
                                      <TD size="1" name="cmbBankId" id="cmbBankId" tabindex="3" >
                                          District<label style="color:rgb(255,0,0);"/>
                                      </TD>
                                      <TD>
                                          <select name="cmbDistrict" id="cmbDistrict" tabindex="9" onfocus="return officeCheck()" onchange="loadName_Mas(this);">
                                          <option value="">----Select District----</option>
                                           <%
                                            try
                                            {
                                               ps=con.prepareStatement("select DISTRICT_CODE, DISTRICT_NAME from COM_MST_DISTRICTS order by District_Name");
                                               rs=ps.executeQuery();
                                               while(rs.next())
                                              {
                                                 out.println("<option value="+rs.getInt("DISTRICT_CODE")+">"+rs.getString("DISTRICT_NAME")+"</option>");
                                                 }
                        
                                               } 
                                            catch(Exception e)
                                          {
                                            System.out.println("Exception in District combo..."+e);
                                           }
                                         finally
                                         {
                                           rs.close();
                                           ps.close();
                                          }  
                                             %>
                                                  
                                          </select>
                                      
                                      
                          <div align="left" id="offlist_div_master"  style="display:none">
                            District Name
                            <!--img src="../../../../../images/c-lovi.gif" width="20" height="20" ></img-->
                            <input type="text" name="txtotherdist_Name" id="txtotherdist_Name"  size="20" tabindex="10"   />
                            State Name
                           <!--div align="left" id="emplist_div_master"  style="display:none"-->
                            <!--img src="../../../../../images/c-lovi.gif" width="20" height="20" ></img-->
                            <input type="text" name="txtotherstate_Name" id="txtotherstate_Name"  size="20" tabindex="11" />
                          </div>
                       </TD>
                                      <!--TD>
                                          <input type="text" name="txtotherdist_Name" id="txtotherdist_Name" tabindex="6" size="30" >
                                          
                                      </TD>
                                       
                                      <TD>
                                          <input type="text" name="txtotherstate_Name" id="txtotherstate_Name" tabindex="7" size="30" >
                                          
                                      </TD-->
                                  </TR>
                                  <tr class="table">
                                    <td>MICR Code<label style="color:rgb(255,0,0);"/></td>
                                    <td><input type=text name="txtMic_Code" id="txtMic_Code" size=10 maxlength="9" tabindex="12" onfocus="return officeCheck()" onkeypress="return  numbersonly1(event,this)" onblur="return checkmiccode();return pinlength();" >
                                    
                                  </tr>
                                  <TR class="table">
                                      <TD>
                                          Phone Number<label style="color:rgb(255,0,0);"/>
                                </TD>
                                      <TD>
                                          <input type="text" name="txtPhone" id="txtPhone" onkeypress="return  numbersonly1(event,this)" size="30" tabindex="13" maxlength="10" onchange="return checkphone();" >
                                          
                                      </TD>
                                  </TR>
                                  <TR class="table">
                                      <TD>
                                         Fax Number<label style="color:rgb(255,0,0);"/>
                                </TD>
                                      <TD>
                                          <input type="text" name="txtFax" id="txtFax" tabindex="14" onkeypress="return  numbersonly1(event,this)" maxlength="10" onchange="return checkfax();" >
                                          
                                      </TD>
                                  </TR>
                                  
              <tr class="table">
                <td>
                  <div align="left">Remarks</div>
                </td>
                <td>
                  <div align="left">
                    <textarea name="txtRemarks" id="txtRemarks" cols="50" tabindex="15" onkeypress="return check_leng(this.value);"
                              rows="4"></textarea>
                  </div>
                </td>
              </tr>
       
             <tr class="tdH">
              <td colspan="2">
                <div align="center">
                <table >
                 <tr>
                    <td>
                    <input type="button" name="cmdAdd" value="ADD" id="cmdAdd" onclick="doFunction('Add','null')" tabindex="20"/>
                     </td>
                     <td>
                    <input type="button" name="cmdUpdate" value="UPDATE" id="cmdUpdate" style="display:none" onclick="doFunction('Update','null')" tabindex="30"/>
                     </td>
                    <td>
                    <input type="button" name="cmdDelete" value="DELETE" id="cmdDelete" style="display:none" onclick="doFunction('Delete','null')" tabindex="40"/>
                     </td>
                     <td>
                    <input type="button" name="cmdClear" value="CLEAR" id="cmdClear" onclick="ClearAll()" tabindex="50"/>
                     </td>
                     <td>
                    <input type="button" name="cmdList" value="LIST" id="cmdList" onclick="ListHeads()" tabindex="60"/>
                     </td>
                       <td>
                     <input type="button" id="Exit" name="Exit" value="EXIT" onclick="exit()" tabindex="70"/>
                     </td>
                 </tr>
                </table>
                </div>
              </td>
            </tr>
         </table>
    </form></body>
</html>