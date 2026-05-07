
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"  contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>HRM_OtherDept_Off_ListAll</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
  </head>
  <body >
  
  <form name="dept_officelist" id="dept_officelist">
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
      
       
      <table width="100%" align="center" >
      <tr>
        <td>
       
      <table cellspacing="2" cellpadding="3" border="1" width="100%" align="center" class="tdH">
      <tr>
        <td>
          <DIV align="center">&nbsp;&nbsp;
          <STRONG>List Of Other Department Offices Details</STRONG></DIV>
        </td>
      </tr>
    </table>
         <table id="mytable" align="center"  cellspacing="3" 
         cellpadding="2" border="1" width="100%">
         
          <tr class="tdH">
            
            <th>
              Other Department ID
            </th>
            <th>
              Other Department Office ID
            </th>
            <th>
              Other Department&nbsp; Office Name
            </th>
             <th>
              Other Department&nbsp; Office Short Name
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
          <tbody id="tb" class="table" align="left">
          
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
            System.out.println("gokul");
            while(rs2.next())
            {
               
                String strcode=rs2.getString("OTHER_DEPT_ID");
                String edit_code=strcode+"-"+rs2.getInt("OTHER_DEPT_OFFICE_ID");
                System.out.println("this"+strcode);
                System.out.println("this"+edit_code);
                out.println("<tr>");   
                //out.println("<td><a href=\"javascript:loadTable('" + edit_code + "')\">Edit</a></td>");
                out.println("<td align='left'>"+rs2.getString("OTHER_DEPT_NAME")+"</td>");
                out.println("<td align='left'>"+rs2.getInt("OTHER_DEPT_OFFICE_ID")+"</td>");
                out.println("<td align='left'>"+rs2.getString("OTHER_DEPT_OFFICE_NAME")+"</td>");
                out.println("<td align='left'>"+rs2.getString("OTHER_DEPT_OFFICE_SHORT_NAME")+"</td>");
                if(rs2.getString("ADDRESS1")!=null)
                out.println("<td align='left'>"+rs2.getString("ADDRESS1")+"</td>");
                else
                 out.println("<td align='left'>"+"&nbsp;"+"</td>");
                if(rs2.getString("ADDRESS2")!=null)
                out.println("<td align='left'>"+rs2.getString("ADDRESS2")+"</td>");
                else
                out.println("<td align='left'>"+"&nbsp;"+"</td>");
                out.println("<td align='left'>"+rs2.getString("CITY_TOWN")+"</td>");
                if(rs2.getInt("PINCODE")!=0)
                out.println("<td align='left'>"+rs2.getInt("PINCODE")+"</td>");
                else
                out.println("<td align='left'>"+"&nbsp;"+"</td>");
                 if(rs2.getString("STD_CODE")!=null)
                out.println("<td align='left'>"+rs2.getString("STD_CODE")+"</td>");
                 else
                out.println("<td align='left'>"+"&nbsp;"+"</td>");
                if(rs2.getString("PHONE_NO")!=null)
                out.println("<td align='left'>"+rs2.getString("PHONE_NO")+"</td>");
                 else
                out.println("<td align='left'>"+"&nbsp;"+"</td>");
                if(rs2.getString("ADDL_PHONE_NOS")!=null)
                out.println("<td align='left'>"+rs2.getString("ADDL_PHONE_NOS")+"</td>");
                else
                out.println("<td align='left'>"+"&nbsp;"+"</td>");
                if(rs2.getString("FAX_NO")!=null)
                out.println("<td align='left'>"+rs2.getString("FAX_NO")+"</td>");
                else
                out.println("<td align='left'>"+"&nbsp;"+"</td>");
                if(rs2.getString("E_MAIL")!=null)
                out.println("<td align='left'>"+rs2.getString("E_MAIL")+"</td>");
                else
                out.println("<td align='left'>"+"&nbsp;"+"</td>");
                if(rs2.getString("HEAD_OF_OFFICE")!=null)
                out.println("<td align='left'>"+rs2.getString("HEAD_OF_OFFICE")+"</td></tr>");
                else
                out.println("<td align='left'>"+"&nbsp;"+"</td></tr>");
              
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
      <input type="button" id="Exit" name="Exit" value="EXIT" onclick="self.close();">
      </div>
      </td>
      </tr>
      
      </table>
    </td>
      </tr>
      
      </table>
    </form></body>
</html>