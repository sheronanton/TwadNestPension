<%@ page contentType="text/html;charset=windows-1252" session="false"%>
<%@ page import="Servlets.Security.classes.UserProfile"%>
<%@ page import="java.sql.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<link href="css/index.css" rel="stylesheet" media="screen" />
<script type="text/javascript">
 /* function loadLoginPage()
{    
    //document.location=url;
    //alert("called");
    try
    {
    window.opener = '';
    window.close();
    WindowObjectReference1 = window.open('index.jsp', "SingleSecondaryWindowName1","status=1,toolbar=1,location=1,fullscreen=yes,resizable=yes");
     //      "fullscreen=yes,resizable=yes,scrollbars=yes,status=yes,addressbar=yes");

    WindowObjectReference1.focus(); 
    }
    catch(event)
    {
       WindowObjectReference1 = window.open('index.jsp', "SingleSecondaryWindowName1","status=1,toolbar=1,location=1,fullscreen=yes,resizable=yes,menubar=yes");
     
     window.open('','_parent','');
     window.close();
   

    WindowObjectReference1.focus(); 
    }

}*/
  </script>
</head>
<body>
<%
   Connection connection=null;
   Statement statement=null;
   PreparedStatement ps=null;
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
<% 
    try
    {       
       String Remote_host="";
       String sess_id="";
       int out_flag=0;
      // getting remote host address
       Remote_host=request.getRemoteHost();
                         // updating logout time on history
                            try
                            {
                            
                              ps=connection.prepareStatement("update sec_mst_users_login_history set logged_out_time=(select now()) where user_id=? and ip_address=? and session_id=?"); 
                              // getting user id from the session object
                              HttpSession session=request.getSession();
                              UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
                              System.out.println("emp"+empProfile);
                              int Emp_Id=empProfile.getEmployeeId();
                              System.out.println(" the Employee Id is(upon logout) :"+Emp_Id);
                              sess_id=session.getId();
                              System.out.println("Session id on logout :---------->"+sess_id);
                               ps.setInt(1,Emp_Id);
                               ps.setString(2,Remote_host);
                               ps.setString(3,sess_id);
                              
                               out_flag=ps.executeUpdate(); 
                               connection.commit();
                               System.out.println("int out_flag=0; "+out_flag);
                               if(out_flag>0)
                               {
                               System.out.println("Logout time inserted successfully");
                               }
                                
                             }
                    catch(Exception e)
                           {
                                System.out.println("Problem in updating login history : " + e);
                           } 
        //clearing the session object
        HttpSession session=request.getSession(false);
        session.removeAttribute("UserProfile"); 
        session.invalidate();
        session=null;
        System.out.println("session closed completely");
        //out.println("<script language='javascript'>history.clear();</script>");
    }
    catch(Exception e)
    {     
    System.out.println(e);
    }
  %>
<br>
<br>
<br>
<br>
<div id=seperator1 class="HeaderSeperator"></div>
<center>
<p><b> You have logged out, successfully.<br>
To visit the home page, please follow this link&nbsp; <a
	href="index.jsp">Home</a>&nbsp; </b></p>
</center>
<div id=seperator2 class="HeaderSeperator"></div>
</body>
<script type="text/javascript">
if( self != top ) { top.location.replace(self.location.href); }
</script>
</html>
