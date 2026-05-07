<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*,Servlets.Security.classes.UserProfile"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>     <meta http-equiv="cache-control" content="no-cache">
    <title>Bank Account Number List</title>
    
      <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
   <script type="text/javascript" language="javascript">
    function btncancel()
    {
     self.close();
    }
    function EditHead(rowID)
    {
    
                var bankid="",officename="",branch_id="",BranchName="",address1="";
                var bank="",address2="",city="",mic="",phoneno="",faxno="",remark="";
                var district="",branch_id="",bankid="",bank_acc_type="",operID="",otherdist="",otherstate="";
                   r=document.getElementById(rowID);
                 rcells=r.cells;
      
                
                bankid=rcells.item(15).firstChild.nodeValue;
                branch_id=rcells.item(2).firstChild.nodeValue;
                officename=rcells.item(3).firstChild.nodeValue;
                address1=rcells.item(4).firstChild.nodeValue;
                address2=rcells.item(5).firstChild.nodeValue;
                city=rcells.item(6).firstChild.nodeValue;
                district=rcells.item(7).firstChild.nodeValue;
                mic=rcells.item(9).firstChild.nodeValue;
                phoneno=rcells.item(10).firstChild.nodeValue;
                faxno=rcells.item(11).firstChild.nodeValue;
                remark=rcells.item(12).firstChild.nodeValue
                otherdist=rcells.item(13).firstChild.nodeValue
                otherstate=rcells.item(14).firstChild.nodeValue
        Minimize();
    
      
        opener.doParentBankAccNumbers(bank,bankid,branch_id,officename,address1,address2,city,district,mic,phoneno,faxno,remark,otherdist,otherstate);
      
   }
   
    function Minimize() 
    {
    window.resizeTo(0,0);
    window.screenX = screen.width;
    window.screenY = screen.height;
    opener.window.focus();
    }

</script>
  </head>
  <body  bgcolor="rgb(255,255,225)">
   <%
  
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    PreparedStatement ps1=null;
    
     Connection connection=null;

  ResultSet results=null;
  ResultSet results1=null;
  ResultSet results2=null;
   ResultSet rs1=null; 
   try
  {
  
             ResourceBundle rb=ResourceBundle.getBundle("Servlets.Security.servlets.Config");
            String ConnectionString="";

            String strDriver=rb.getString("Config.DATA_BASE_DRIVER");
            String strdsn=rb.getString("Config.DSN");
            String strhostname=rb.getString("Config.HOST_NAME");
            String strportno=rb.getString("Config.PORT_NUMBER");
            String strsid=rb.getString("Config.SID");
            String strdbusername=rb.getString("Config.USER_NAME");
            String strdbpassword=rb.getString("Config.PASSWORD");
            ConnectionString=strdsn.trim()+"://"+strhostname.trim()+":"+strportno.trim()+"/"+strsid.trim();//PostgresDB Connection
           // ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

             Class.forName(strDriver.trim());
             con=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
  }
  catch(Exception e)
  {
    System.out.println("Exception in connection...."+e);
  }
  
  %>
  
  
 
        
  <form name="frmBankBranchList" id="frmBankBranchList">
      <table cellspacing="2" cellpadding="3" border="1" width="100%">
        <tr class="tdH">
          <td>
            <div align="center">
              TWAD BOARD-INTEGRATED ONLINE SYSTEM -HUMAM RESOURCE MANAGEMENT SYSTEM
            </div></td>
        </tr>
        <tr class="table">
          <td>
            <div align="center">
              List of HRM Bank Branch Details 
            </div></td>
            
        </tr>
       
      </table>
       <table cellspacing="2" cellpadding="3" border="1" width="100%">
       
       <tr class="tdH">
      <th>Select </th>
       <!--th>Bank Account Number </th-->
       <th>Bank Name </th>
        <th style="display:none"> Bank Id </th>
        <th>Branch ID </th>
       <th>Branch Name </th>
        <th style="display:none"> Branch Id </th>
       <th>
            Branch Address1
          </th>
          <th>
            Branch Address2
          </th>
       <!--th style="display:none"> Account type Id </th-->
       <th>
            City/Town
          </th>
       
       <th>
            District
          </th>
          <th style="display:none"> District Id </th>
       <th>
            MICR Code
          </th>
       <th>
            Phone No
          </th>
       <th>Fax&nbsp;No </th>
       <th>Remarks </th>
       <th>Other District</th>
       <th>Other State</th>
       
       </tr>
       <tbody id="tb" class="table" align="left">
          <%
           try
           {
          
           int cmbBankId=0;
           try{
           cmbBankId=Integer.parseInt(request.getParameter("cmbBankId"));
           System.out.println("cmbBankId.."+cmbBankId);
           }catch(Exception e)
           {
                System.out.println("Exception in cmbBankId.."+cmbBankId);
           } 
           int cmbDistrict=0;
       
           
                
                String sql_que="select a.DISTRICT_CODE,a.BRANCH_ID,a.BRANCH_NAME,a.BRANCH_ADDRESS1,a.BRANCH_ADDRESS2,a.CITY_TOWN_NAME,a.MICR_CODE,a.PHONE,a.FAX,a.REMARKS,OTHER_DIST_NAME,OTHER_STATE_NAME,"
                              +" b.district_name,c.BANK_NAME from HRM_MST_BANK_BRANCHES a ,COM_MST_DISTRICTS b, HRM_MST_BANKS C"
                              +" WHERE  a.BANK_ID=? AND a.Bank_id=c.Bank_id and a.district_code=b.district_code order by a.BRANCH_ID";
               
            
            ps=con.prepareStatement(sql_que);
            ps.setInt(1,cmbBankId);
            rs=ps.executeQuery();
           int cnt=0; 
         
            while(rs.next())
            {
               
                cnt++;
                out.println("<tr id='" + cnt + "'>");   
                out.println("<td><a href=\"javascript:EditHead('" + cnt + "')\">Edit</a></td>");
               
                out.println("<td>"+rs.getString("BANK_NAME")+"</td>");
                
                out.println("<td>"+rs.getInt("BRANCH_ID")+"</td>");
                out.println("<td>"+rs.getString("BRANCH_NAME")+"</td>");
            
                out.println("<td>"+rs.getString("BRANCH_ADDRESS1")+"</td>");
                out.println("<td>"+rs.getString("BRANCH_ADDRESS2")+"</td>");
                out.println("<td>"+rs.getString("CITY_TOWN_NAME")+"</td>");
                out.println("<td style='display:none' >"+rs.getInt("district_code")+"</td>"); 
                out.println("<td >"+rs.getString("DISTRICT_NAME")+"</td>"); 
                out.println("<td>"+rs.getInt("MICR_CODE")+"</td>");
                out.println("<td>"+rs.getInt("PHONE")+"</td>");
                out.println("<td>"+rs.getInt("FAX")+"</td>");
                out.println("<td>"+rs.getString("REMARKS")+"</td>");
                out.println("<td>"+rs.getString("OTHER_DIST_NAME")+"</td>");
                out.println("<td>"+rs.getString("OTHER_STATE_NAME")+"</td>");
                out.println("<td style='display:none' >"+cmbBankId+"</td>"); 
                
            
                
            }
            if(cnt==0)
             out.println("<tr><td>No data found<td><td></td><td></td></tr>");
          }
          catch(Exception e)
          {
            System.out.println("Exception in grid.."+e);
          }
          %>
          
          </tbody>
       </table>
        <table align="center" cellspacing="3" cellpadding="2" border="1"
             width="100%">
        <tr class="tdH">
          <td>
            <div align="center">
              <input type="button" id="cmdcancel" name="cancel" value="Exit"
                     onclick=" self.close();"></input>
            </div>
          </td>
        </tr>
      </table> 
    </form>
   </body>
</html>