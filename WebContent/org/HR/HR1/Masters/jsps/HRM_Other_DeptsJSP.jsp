<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>HRM_MST_OTHER_DEPT</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <script type="text/javascript" src="../scripts/HRM_MST_OtherDeptsJS.js">    </script>
    
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
  </head>
  <body  >
  
  <form name="HRM_OtherDepts" id="Rws_TreatmentplantTypes">
      <p>
        <%
  
   Connection connection=null;
  PreparedStatement ps=null;
  ResultSet results=null;
  ResultSet results1=null;
  ResultSet results2=null;
  
  
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
      <table width="100%">
      <tr>
      <td>
        <table cellspacing="2" cellpadding="3" border="1"  width="100%">
        
        <tr class="tdH" >
        <th align="center" colspan="2">
                OTHER DEPARMENTS
                </th>
           </tr>
           
          <tr class="table">
            <td>
              <div align="left">
                      Other Dept Id<font color="#ff0000">
                        *
                      </font>
              </div></td>
            <td>
              <div align="left">
                <input type="text" name="txtOtherDeptid" id="txtOtherDeptid" maxlength="6" size="6"   style="TEXT-TRANSFORM:UPPERCASE"  onchange="return checkdeptid();"    /> 
              </div>
            </td>
          </tr>
          <tr class="table">
            <td>
              <div align="left">
                      Other Dept Name<font color="#ff0000">
                        *
                      </font>
              </div></td>
            <td>
              <div align="left">
                <input type="text" name="txtOtherDept"  id="txtOtherDept"    maxlength="60" size="65" onchange="return checkdeptname();"  /> 
              </div>
            </td>
          </tr>
          <tr class="table">
            <td><div align="left">
                      Other Dept Short Name<font color="#ff0000">
                        *
                      </font></div></td>
            <td><div align="left">
                <input type="text" name="txtOtherDeptShortName"  id="txtOtherDeptShortName"    maxlength="20" size="20"  onfocus="trm(this)"  onchange="return checkshortname();"  /> 
              </div></td>
          </tr>
          <tr class="table">
            <td rowspan="2"><div align="left">Address</div>
                    <div align="left"/>
                  </td>
            <td><div align="left"><input type="text" name="txtAddress1"  id="txtAddress1"     maxlength="50" size="50"   onfocus="trm(this)" onchange="return checkadd1();"  /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left"><input type="text" name="txtAddress2"  id="txtAddress2"     maxlength="50" size="50"  onfocus="trm(this)"  onchange="return checkadd2();"  /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">
                      City / Down<font color="#e70000">
                        *
                      </font></div></td>
            <td><div align="left"><input type="text" name="txtCity"  id="txtCity"     maxlength="50" size="50"  onfocus="trm(this)"  onkeypress="return nonanumber(event)" onchange="return checkcity()" /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Pincode</div></td>
            <td><div align="left"><input type="text" name="txtPincode"  id="txtPincode"     maxlength="6" size="6"  onkeypress="return numbersonly(event)"  onfocus="trm(this)" onchange="return checkpincode();"   /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Phone No (STD Code-Phone No)</div></td>
            <td><div align="left"><input type="text" name="txtStd"  id="txtStd"     maxlength="5" size="5" onkeypress="return numbersonly(event)"    onfocus="trm(this)"  onchange="return checkstd();"  />&nbsp;-&nbsp;<input type="text" name="txtPhone"  id="txtPhone"     maxlength="10" size="10"  onkeypress="return numbersonly(event)"   onfocus="trm(this)" onchange="return checkphone();" /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Additional Phone Nos.</div></td>
            <td><div align="left"><input type="text" name="txtAPhone"  id="txtAPhone"     maxlength="50" size="50" onkeypress="return addphone(event)"   onfocus="trm(this)" onchange="return checkaddphone();"   /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Fax No</div></td>
            <td><div align="left"><input type="text" name="txtFax"  id="txtFax"     maxlength="10" size="10" onkeypress="return fax(event)"  onfocus="trm(this)"  onchange="return checkfax();"  /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">E-Mail</div></td>
            <td><div align="left"><input type="text" name="txtEmail"  id="txtEmail"     maxlength="60" size="60"   onfocus="trm(this)"   onchange="return checkemail();" /></div></td>
          </tr>
          <tr class="table">
            <td><div align="left">Head of Dept</div></td>
            <td><div align="left"><input type="text" name="txtHeadOfDept"  id="txtHeadOfDept"     maxlength="50" size="50"    onfocus="trm(this)" onchange="return checkhead();"  /></div></td>
          </tr>
          
          <tr class="table">
            <td colspan="2">
              <div align="center">
               <table border="0">
                    <tr>
                        <td>
                      <input type="button" name="cmdadd" value="SAVE" id="cmdadd"
                             onclick="doFunction('Add','null')"  style="display:block"/>
                       </td> <td>
                      <input type="button" name="cmdupdate" value="UPDATE"
                             id="cmdupdate"
                             onclick="doFunction('Update','null')"
                             style="display:none"/>
                       </td> <td>
                      <input type="button" name="cmddelete" value="DELETE"
                             id="cmddelete"
                             onclick="doFunction('Delete','null')"
                             disabled="disabled" />
                       </td> <td>
                      <input type="button" name="cmdclear" value="CLEAR ALL"
                             id="cmdclear"
                             onclick="doFunction('Clear','null')"/>
                       </td> <td>
                      <input type="button" name="cmdlist" value="LIST ALL"
                             id="cmdlist" onclick="popwindow()"/>
                            </td>
                        </tr>
                    </table>
             <!--   <input type="button" name="cmdadd" value="ADD" id="cmdadd" onclick="doFunction('Add','null')"/>
                <input type="button" name="cmdupdate" value="UPDATE" id="cmdupdate" onclick="doFunction('Update','null')" disabled/>
                <input type="button" name="cmddelete" value="DELETE" id="cmddelete" onclick="doFunction('Delete','null')" disabled/>
                <input type="button" name="cmdclear" value="CLEAR ALL"  id="cmdclear" onclick="doFunction('Clear','null')"/>
                <input type="button" name="cmdlist" value="LIST ALL"  id="cmdlist" onclick="popwindow()"/> 
            -->
              </div></td>
          </tr>
        </table>
      
       
        
         <table id="mytable" align="center"  cellspacing="3" 
         cellpadding="2" border="1"  width="100%" >
          <tr class="tdH">
            <th>
              Select
            </th>
             <th>
           Other&nbsp;Dept&nbsp;ID
          </th>
          <th>
            Other&nbsp;Dept&nbsp;Name
          </th>
          <th>Other&nbsp;Dept Short&nbsp;Name </th>
          <th>Address1 </th>
          <th>Address2 </th>
          <th>City&nbsp;/&nbsp;Down </th>
          <th>Pincode </th>
          <th>STD&nbsp;Code </th>
          <th>Phone&nbsp;No </th>
          <th>Addl.&nbsp;Phone&nbsp;NOs. </th>
          <th>Fax&nbsp;No</th>
          <th>E-Mail </th>
          <th>Head&nbsp;Of&nbsp;Dept </th>
          </tr>
          <tbody id="tb" class="table">
          
          <%
          ResultSet rs=null;
           try
           {
            ps=connection.prepareStatement("select * from HRM_MST_OTHER_DEPTS order by OTHER_DEPT_ID");
            rs=ps.executeQuery();
                       
            while(rs.next())
            {
              
                String strcode="";
                String strname="";
                String strsname="";
                String add1="",add2="",city="",phone="",std="";
                long pincode=0;
                String addphone="",fax="",email="",headofdept="";
                
                      
                strcode=rs.getString("OTHER_DEPT_ID");
                
                strname=rs.getString("OTHER_DEPT_NAME");
                strsname=rs.getString("OTHER_DEPT_SHORT_NAME");
                add1=rs.getString("ADDRESS1");
                add2=rs.getString("ADDRESS2");
                city=rs.getString("CITY_TOWN");
                pincode=rs.getLong("PINCODE");
                std=rs.getString("STD_CODE");
                phone=rs.getString("PHONE_NO");
                addphone=rs.getString("ADDL_PHONE_NOS");
                fax=rs.getString("FAX_NO");
                email=rs.getString("E_MAIL");
                headofdept=rs.getString("HEAD_OF_DEPT");
            
            
                out.println("<tr id='" + strcode + "'>");   
                out.println("<td><a href=\"javascript:loadTable('" + strcode + "')\">Edit</a></td>");
                out.println("<td align='left'>"+strcode+"</td>");
                out.println("<td align='left'>"+strname+"</td>");
                
                if(strsname!=null)
                    out.println("<td align='left'>"+strsname+"</td>");
                else
                    out.println("<td align='left'>&nbsp;</td>");
                    
                 if(add1!=null)
                    out.println("<td align='left'>"+ add1+"</td>");
                else
                     out.println("<td align='left'>&nbsp;</td>");
                     
                if(add2!=null)
                    out.println("<td align='left'>"+ add2+"</td>");
                else
                     out.println("<td align='left'>&nbsp;</td>");
                     
                if(city!=null)
                    out.println("<td align='left'>"+city+"</td>");
                else
                     out.println("<td align='left'>&nbsp;</td>");
                     
                if(pincode!=0)
                    out.println("<td align='left'>"+pincode+"</td>");
                else
                 out.println("<td align='left'>&nbsp;</td>");
                 
                 if(std!=null)
                    out.println("<td align='left'>"+std+"</td>");
                else
                 out.println("<td align='left'>&nbsp;</td>");
                 
                if(phone!=null)
                    out.println("<td align='left'>"+phone+"</td>");
                else
                 out.println("<td align='left'>&nbsp; </td>");
                 
                if(addphone!=null)
                    out.println("<td align='left'>"+addphone+"</td>");
                else
                     out.println("<td align='left'>&nbsp;</td>");
                     
                if(fax!=null)
                    out.println("<td align='left'>"+fax+"</td>");
                else
                     out.println("<td align='left'>&nbsp;</td>");
                     
                if(email!=null)
                    out.println("<td align='left'>"+email+"</td>");
                else
                    out.println("<td align='left'>&nbsp;</td>");
                    
                if(headofdept!=null)
                    out.println("<td align='left'>"+headofdept+"</td></tr>");
                else
                     out.println("<td align='left'>&nbsp;</td>");
              
            }
          }
          catch(Exception e)
          {
            System.out.println("Exception in grid.."+e);
          }
           finally
          {
                rs.close();
                ps.close();
               // connection.close();
          }
          %>
          </tbody>
        </table>
     
      <table align="center"  cellspacing="3" cellpadding="2" border="1"  width="100%" >
  
      <tr class="tdH">
      <td>
          <div align="center">
      <input type="button" id="Exit" name="Exit" value="Exit" onclick="toExit()">
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