<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,java.util.*,Servlets.Security.classes.UserProfile"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twad Board Intranet Services</title>
<link type="text/css" href="fg.menu.css" media="screen" rel="stylesheet" />
	<link type="text/css" href="themes/start/jquery-ui.css" media="screen" rel="stylesheet" />
	<script language='javascript' src='jquery-1.3.2.min.js'></script>

<script type='text/javascript' src='org/Security/scripts/twad.js'></script>
<link href='css/index.css' rel='stylesheet' media='screen'/>

<script type='text/javascript' src='org/Security/scripts/StatusBarScrollText.js'></script>


	
</head>

<%

int empid=0;
String status="";
String Remote_host="";
String sess_id="";
boolean flag_chk=true;


try
{
  flag_chk=request.isRequestedSessionIdFromCookie();
  System.out.println("from cookie : "+flag_chk);
  //Getting  Remote host IP
  Remote_host=request.getRemoteHost();
  System.out.println("Remote Host is :"+Remote_host);
   session=request.getSession(false);
   System.out.println("::Session:: "+session);
   if(session!=null) 
   {
             
            String sessionid=request.getParameter("session");
            System.out.println("session id:"+session.getId());
           empid=Integer.parseInt(request.getParameter("empid"));
           status=request.getParameter("status");
           System.out.println("empid:---------"+empid);
            System.out.println("status:---------"+status);
           
          
   }
}
catch(Exception e)
{
  e.printStackTrace();
}

session=request.getSession(false);
try{
if(session ==null) {
        response.sendRedirect(request.getContextPath()+"/index.jsp?message=sessionout");
        return;
    }
//session.setMaxInactiveInterval(60);
System.out.println("session id:"+session.getId());
System.out.println("check for new session isnew::::::"+session.isNew());
System.out.println("Request value:"+request.getParameter("empid"));
System.out.println("ses parameter :"+request.getParameter("session"));
    
    if(!session.isNew()) {
         
       if(session.getAttribute("UserProfile")==null) {
             session.invalidate(); 
             session=null;
             System.out.println(request.getContextPath()+"/index.jsp?message=sessionout");
             response.sendRedirect(request.getContextPath()+"/index.jsp?message=sessionout");
         }
     }
       }
    catch(Exception e){
            response.sendRedirect(request.getContextPath()+"/index.jsp?message=sessionout");
    }
    sess_id=session.getId();
    System.out.println("------------------- session object created in SERVLET LOGIN.Session Id is  :"+sess_id);
    UserProfile up=null;
    up=(UserProfile)session.getAttribute("UserProfile");

    String profile=(String)session.getAttribute("profile");
    
    String sqlGetRoleId="";
    



Connection connection=null;
ResultSet rs=null;
PreparedStatement ps=null;


 

ResultSet results=null;
ResultSet cntt,m1=null;

ResultSet results1=null;
ResultSet results2=null;
ResultSet results3=null;
ResultSet results4=null;
try
{ 
   	     	
   ResourceBundle  rb=ResourceBundle.getBundle("Servlets.Security.servlets.Config");
     
       String ConnectionString="";
        String strDriver=rb.getString("Config.DATA_BASE_DRIVER");
        String strdsn=rb.getString("Config.DSN");
        String strhostname=rb.getString("Config.HOST_NAME");
        String strportno=rb.getString("Config.PORT_NUMBER");
        String strsid=rb.getString("Config.SID");
        String strdbusername=rb.getString("Config.USER_NAME");
        String strdbpassword=rb.getString("Config.PASSWORD");
        ConnectionString=strdsn.trim()+"://"+strhostname.trim()+":"+strportno.trim()+"/"+strsid.trim();//PostgresDB Connection
        //ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

         Class.forName(strDriver.trim());
         connection=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
}
catch(Exception e)
{
System.out.println("Exception in connection...."+e);
response.sendRedirect(request.getContextPath()
								+ "/index.jsp?message=dbnill");
}











try{}catch(Exception e){out.println("Errior"+e);
e.printStackTrace();
response.sendRedirect("index.jsp?message=dbnill");
}
	
	
%>
<frameset rows="200,*" name="framehead" id="framehead" frameborder="0" border="0" framespacing="0">
 <frame name="top_header" id="top_header" src="testheader.jsp"></frame>
 <frameset cols="300,*" frameborder="0" border="0" framespacing="0">
 <frame name="content" id="content" src="testsubmenu.jsp" marginheight="0" marginwidth="0" horizoantalscrolling="auto" noresize>
	<frame name="menu" src="testmenufile.jsp" marginheight="0" marginwidth="0"   noresize></frame>
</frameset>

</frameset>
<script type="text/javascript">

</script>
</html>