<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>untitled</title>
    <script type="text/javascript">
    function assignValue()
    {
      window.opener.document.frmCadre.txtCadreId.value=document.frmCadre.cmbCadreId.value;      
      window.opener.document.frmCadre.txtCadreId.focus();      
      self.close();
    }
    function closeWindow()
    {
       window.opener.document.frmCadre.txtCadreId.focus();
       self.close();
    }
    </script>
  </head>
  <body>
  <%
   Connection connection=null;
   Statement statement=null;
   ResultSet results=null;   

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
            connection.clearWarnings();
       }
       catch(SQLException e)
       {
              //System.out.println("Exception in creating statement:"+e);
       }          
  }
  catch(Exception e)
  {
         //System.out.println("Exception in openeing connection:"+e);
  }  
 %>     
    <form name="frmCadre">
      <table cellspacing="2" cellpadding="3" border="1" width="100%">
        <tr>
          <td>Select a Cadre</td>
          <td>
            <select name="cmbCadreId">
            <%
                try
                {
                    results=statement.executeQuery("select * from HR_MST_CADRE");
                    while(results.next())
                    {
                        String temp=results.getString("Cadre_Id");
                        out.println("<option value='" + temp + "'>" + results.getString("Cadre_Name") + "( " + temp + " )</option>");   
                    }
                    results.close();
                }
                catch(SQLException e)
                {
                        //System.out.println("Exception in creating statement:"+e);
                }
            %>
            </select>
          </td>
        </tr>
        <tr>
          <td colspan="2"><center>
          <input type="BUTTON" value="  Ok  " onclick="assignValue()"> &nbsp;&nbsp;
          <input type="BUTTON" value="Cancel" onclick="closeWindow()"></center>
          </td>          
        </tr>
      </table>
    </form>
  </body>
</html>
