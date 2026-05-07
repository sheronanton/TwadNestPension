<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"  contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>HRM_MST_OTHER_DEPT_OFFICES</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <script type="text/javascript" src="../scripts/HRM_OtherDept_Offices.js">
    </script>
    <script language="javascript">
    function popwindow()
    {
      my_window= window.open("HRM_OtherDept_Off_ListAll.jsp","mywindow1","status=1,resizable=yes, scrollbars=yes"); 
      my_window.moveTo(250,250);    
    }
    function load()
    {
    document.dept_office.cmbOtherDept_Id.focus();
    }
    </script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
  </head>
  <body onload="load()">
  
  <form name="dept_office" id="dept_office">
      <p>
        <%
  
  Connection con=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
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
            //ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

             Class.forName(strDriver.trim());
             con=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
  }
  catch(Exception e)
  {
    System.out.println("Exception in connection...."+e);
  }

  
  
  %>
      </p>
      <p>
        &nbsp;
      </p>
      
      <div align="center">
       <table  width="100%">
        
        <tr  >
        <td >
        <table cellspacing="2" cellpadding="3" border="1" width="100%">
        
        <tr class="tdH" >
        <th align="center" colspan="2">
                Other Department Offices
                </th>
           </tr>
           
          <tr class="table">
            <td>
              <div align="left">
                      Other Department Id 
                      <font color="#ff0000">
                        *
                      </font>
              </div></td>
            <td>
              <div align="left">
               <select size="1" name="cmbOtherDept_Id" id="cmbOtherDept_Id"  onchange="doFunction('loaddept','null')" >
              <option  value="">
                ---Select Department Id---
              </option>
              <%
                 try
                  {
                      ps=con.prepareStatement("select OTHER_DEPT_ID,OTHER_DEPT_NAME from HRM_MST_OTHER_DEPTS ORDER BY OTHER_DEPT_NAME");
                      rs=ps.executeQuery();
                      
                    while(rs.next())
                    {
                       String temp=rs.getString("OTHER_DEPT_ID");
                       out.println("<option value='" + temp + "'>" + rs.getString("OTHER_DEPT_NAME") + "</option>");
                     }
                    // rs.close();
                   }
                   catch(Exception e) {}
               %>            
            
            </select>
                
              </div>
            </td>
          </tr>
          <tr class="table">
            <td>
            <div align="left">
                      Other Department Office Id 
            </div>
            </td>
            <td>
              <div align="left">
                <input type="text" name="txtOtherDeptOff_Id"  id="txtOtherDeptOff_Id"  style="background-color: #ececec"  onfocus="null_cmbDeptid()" readonly="readonly" size="6" maxlength="4" /> ( System Generated ) 
              </div>
            </td>
          </tr>
          <tr class="table">
            <td>
              <div align="left">
                      Other Department Office Name 
                      <font color="#ff0000">
                        *
                      </font>
              </div></td>
            <td>
              <div align="left">
                <input type="text" name="txtOtherDeptOff_Name"  id="txtOtherDeptOff_Name"    maxlength="60" size="65"   /> 
              </div>
            </td>
          </tr>
          <tr class="table">
            <td><div align="left">
                      Other Department Office Short Name 
                      <font color="#ff0000">
                        *
                      </font></div></td>
            <td><div align="left">
                <input type="text" name="txtOtherDeptOff_SName"  id="txtOtherDeptOff_SName"   onfocus="null_offName()"   maxlength="20" size="55"   /> 
              </div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Address1</div></td>
            <td><div align="left"><input type="text" name="txtAddress1"  id="txtAddress1" maxlength="50" size="55"   /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Address2</div></td>
            <td><div align="left"><input type="text" name="txtAddress2"  id="txtAddress2" maxlength="50" size="55"   /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">
                      City / Down 
                      <font color="#ff0000">
                        *
                      </font></div></td>
            <td><div align="left"><input type="text" name="txtCity"  id="txtCity" maxlength="50" size="55"   /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Pincode</div></td>
            <td><div align="left"><input type="text" name="txtPincode"  id="txtPincode" maxlength="6" size="7" onfocus="null_city()"  onkeypress="return numbersonly(event)"   /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Phone Number (STD code-Phone Number)</div></td>
            <td><div align="left"><input type="text" name="txtStd"  id="txtStd" maxlength="5" size="6" onfocus="pincode()" onkeypress="return numbersonly(event)"  />-
             <input type="text" name="txtPhone1"  id="txtPhone1" maxlength="10" size="11" onkeypress="return numbersonly(event)"   /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Additional Phone Numbers (Separate by , or - )</div></td>
            <td><div align="left"><input type="text" name="txtAPhone"  id="txtAPhone" maxlength="50" size="52" onkeypress="return valid_addphone(event)"  /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Fax Number</div></td>
            <td><div align="left"><input type="text" name="txtFax"  id="txtFax" maxlength="10" size="11" onkeypress="return valid_fax(event)"  /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">E-Mail</div></td>
            <td><div align="left"><input type="text" name="txtEmail"  id="txtEmail" maxlength="60" size="65" onblur="valid_email()"/></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Head of Office</div></td>
            <td><div align="left"><input type="text" name="txtHeadOfDept"  id="txtHeadOfDept" style="TEXT-TRANSFORM:UPPERCASE"    maxlength="50" size="55"   /></div></td>
          </tr>
          
          <tr class="tdH">
            <td colspan="2">
              <div align="center">
              <table border="0"><tr><td>
                <input type="button" name="cmdadd" value="SAVE" id="cmdadd" onclick="doFunction('Add','null')"/></td>
                <td><input type="button" name="cmdupdate" value="UPDATE" id="cmdupdate" onclick="doFunction('Update','null')" style="display:none"/></td>
                <td><input type="button" name="cmddelete" value="DELETE" id="cmddelete" onclick="doFunction('Delete','null')" disabled="disabled"/></td>
                <td><input type="button" name="cmdclear" value="CLEAR ALL"  id="cmdclear" onclick="doFunction('Clear','null')"/></td>
                <td><input type="button" name="cmdlist" value="LIST ALL"  id="cmdlist" onclick="popwindow()"/> </td>
                </tr></table>
              </div></td>
          </tr>
        </table>
      
       
        
         <table id="mytable" align="center"  cellspacing="3" 
         cellpadding="2" border="1" width="100%">
          <tr class="tdH">
            <th>
              Select
            </th>
            <th>
              Other Department ID
            </th>
            <th>
              Other Department&nbsp;Office ID
            </th>
            <th>
              Other Department&nbsp;Office Name
            </th>
             <th>
              Other Department&nbsp;Office Short Name
            </th>
            <th>
              Address 1
            </th>
            <th>
             Address 2
            </th>
            <th>
              City / Town
            </th>
            <th>
              Pincode
            </th>
            <th>
             STD code
             </th>
            <th>
             Phone Number
            </th>
            <th>
             Additional Phone Number
            </th>
            <th>
             Fax Number
            </th>
            <th>
             E-Mail
            </th>
            <th>
             Head Of Office
            </th>
          </tr>
          <tbody id="tb" class="table" align="left" >
          
          <%
          ResultSet rs2=null;
          PreparedStatement ps2=null;
           try
           {
           
          
            ps2=con.prepareStatement("select off.OTHER_DEPT_ID,dept.OTHER_DEPT_NAME,off.OTHER_DEPT_OFFICE_ID," +
                            "off.OTHER_DEPT_OFFICE_NAME,off.OTHER_DEPT_OFFICE_SHORT_NAME,off.ADDRESS1, off.ADDRESS2,off.CITY_TOWN,"+
                            "off.PINCODE,off.STD_CODE, off.PHONE_NO,off.ADDL_PHONE_NOS,off.FAX_NO,off.E_MAIL,off.HEAD_OF_OFFICE "+
                            " from HRM_MST_OTHER_DEPTS dept,HRM_MST_OTHER_DEPT_OFFICES off where off.OTHER_DEPT_ID=dept.OTHER_DEPT_ID ORDER BY dept.OTHER_DEPT_NAME,off.OTHER_DEPT_OFFICE_ID");
            rs2=ps2.executeQuery();
                       
            while(rs2.next())
            {
               
                String strcode=rs2.getString("OTHER_DEPT_ID");
                String edit_code=strcode+"-"+rs2.getInt("OTHER_DEPT_OFFICE_ID");
                out.println("<tr id='" + edit_code + "'>");   
                out.println("<td><a href=\"javascript:loadTable('" + edit_code + "')\">Edit</a></td>");
                out.println("<td align='left'>"+rs2.getString("OTHER_DEPT_NAME")+"</td>");
                out.println("<td align='left'>"+rs2.getInt("OTHER_DEPT_OFFICE_ID")+"</td>");
                out.println("<td align='left'>"+rs2.getString("OTHER_DEPT_OFFICE_NAME")+"</td>");
                out.println("<td align='left'>"+rs2.getString("OTHER_DEPT_OFFICE_SHORT_NAME")+"</td>");
                if(rs2.getString("ADDRESS1")!=null)
                out.println("<td align='left'>"+rs2.getString("ADDRESS1")+"</td>");
                else
                 out.println("<td align='left'>"+"Not Available"+"</td>");
                if(rs2.getString("ADDRESS2")!=null)
                out.println("<td align='left'>"+rs2.getString("ADDRESS2")+"</td>");
                else
                out.println("<td align='left'>"+"Not Available"+"</td>");
                out.println("<td align='left'>"+rs2.getString("CITY_TOWN")+"</td>");
                if(rs2.getInt("PINCODE")!=0)
                out.println("<td align='left'>"+rs2.getInt("PINCODE")+"</td>");
                else
                out.println("<td align='left'>"+"Not Available"+"</td>");
                 if(rs2.getString("STD_CODE")!=null)
                out.println("<td align='left'>"+rs2.getString("STD_CODE")+"</td>");
                 else
                out.println("<td align='left'>"+"Not Available"+"</td>");
                if(rs2.getString("PHONE_NO")!=null)
                out.println("<td align='left'>"+rs2.getString("PHONE_NO")+"</td>");
                 else
                out.println("<td align='left'>"+"Not Available"+"</td>");
                if(rs2.getString("ADDL_PHONE_NOS")!=null)
                out.println("<td align='left'>"+rs2.getString("ADDL_PHONE_NOS")+"</td>");
                else
                out.println("<td align='left'>"+"Not Available"+"</td>");
                if(rs2.getString("FAX_NO")!=null)
                out.println("<td align='left'>"+rs2.getString("FAX_NO")+"</td>");
                else
                out.println("<td align='left'>"+"Not Available"+"</td>");
                if(rs2.getString("E_MAIL")!=null)
                out.println("<td align='left'>"+rs2.getString("E_MAIL")+"</td>");
                else
                out.println("<td align='left'>"+"Not Available"+"</td>");
                if(rs2.getString("HEAD_OF_OFFICE")!=null)
                out.println("<td align='left'>"+rs2.getString("HEAD_OF_OFFICE")+"</td></tr>");
                else
                out.println("<td align='left'>"+"Not Available"+"</td></tr>");
            }
          }
          catch(Exception e)
          {
            System.out.println("Exception in grid.."+e);
          }
           finally
          {
                rs2.close();
                ps2.close();
                con.close();
          }
          %>
          </tbody>
        </table>
    
      <table align="center"  cellspacing="3" cellpadding="2" border="1" width="100%" >
  
      <tr class="tdH">
      <td>
          <div align="center">
      <input type="button" id="Exit" name="Exit" value="EXIT" onclick="toExit()">
      </div>
      </td>
      </tr>
      
      </table>
      
      </td>
      </tr>
      
      </table>
      </div>
    </form></body>
</html>