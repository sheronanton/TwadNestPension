<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>HRM MST OTHER DEPTS</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>

  </head>
  <body >
  <form>
  
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
    System.out.println(e);
  }
  
  
  %>
  <table width="100%">
      <tr>
      <td>
  <table cellspacing="2" cellpadding="3" 
  border="1" width="100%" align="center" class="tdH">
      <tr>
        <td>
          <DIV align="center">&nbsp;&nbsp;
          <STRONG>LISTING All OTHER DEPTS DETAILS</STRONG></DIV>
        </td>
      </tr>
    </table>
   
  <table id="Existing" cellspacing="2" 
  cellpadding="3" border="1" width="100%"
             align="center">
        <tr class="tdH">
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
          <tbody id="tblList" class="table">
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
            
            
                out.println("<tr >");   
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
      
      
      <table align="center"  cellspacing="3" cellpadding="2" border="1" width="100%" >
        <tr class="tdH">
      <td>
          <div align="center">
      <input type="BUTTON" value="  EXIT  " onclick="self.close();"/>
      </div>
      </td>
      </tr>
      
      </table>
        </td>
    </tr>
    </table> 
     
      </form>

  </body>
</html>