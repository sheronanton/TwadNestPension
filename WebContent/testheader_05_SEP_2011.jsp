<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,java.util.*,Servlets.Security.classes.UserProfile"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twad Board Intranet Services</title>

	<script language='javascript' src='jquery-1.3.2.min.js'></script>

<script type='text/javascript' src='org/Security/scripts/twad.js'></script>
<link href='css/index.css' rel='stylesheet' media='screen'/>
<link href='css/doubletab2.css' rel='stylesheet' media='screen'/>
<script type='text/javascript' src='org/Security/scripts/StatusBarScrollText.js'></script>

<style type="text/css">
#tabs {
font-size: 80%;

}
#tabs ul {
float: left;
background: #6C9FCC  url(images/bluebg1.jpg) 50% bottom repeat-x;

  -moz-border-radius: .5em .5em .5em .5em;

width: 97%;
padding-top: 4px;
}
#tabs li {
margin-left: 0px;
list-style: none;
}
* html #tabs li {
display: inline; /* ie6 double float margin bug */
}
#tabs li,
#tabs li a {
float: left;
}
#tabs ul li a {
text-decoration: none;
padding: 8px;
color: #FFFFFC;
font-weight: bold;
}

#tabs ul li.active {
background: #CEE1EF url(img/nav-right.gif) no-repeat right top;
 border: 2px solid #6C9FCC;
  border-bottom-width: 0px;
  border-color: #6C9FCC #6C9FCC #6C9FCC #6C9FCC;
  -moz-border-radius: .75em .75em 0em 0em;
  border-radius-topleft: .75em;
  border-radius-topright: .75em;
}
#tabs ul li.active a {
background: url(img/nav-left.gif) no-repeat left top;
color: #333333;
}
</style>
<script type="text/javascript">
$(document).ready(function(){


$('#tabs ul li:first').addClass('active'); // Set the class of the first link to active
$('#tabs ul li a').click(function(){ //When any link is clicked
$('#tabs ul li').removeClass('active'); // Remove active class from all links
$(this).parent().addClass('active'); //Set clicked link class to active



});
});
</script>
</head>
<body>
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











try{
String  m11="";
String temp="";
int flag=0;
int i=1;
String compareMenu="menu";
try
{
	if(profile.equalsIgnoreCase("twad")) {
	    sqlGetRoleId="select Role_Id from SEC_MST_USER_ROLES where Employee_Id=? order by List_Seq_No";
	    System.out.println("query : " + sqlGetRoleId);
	    ps=connection.prepareStatement(sqlGetRoleId);
	    ps.setInt(1,up.getEmployeeId());
	}
	else{
	    String userid=(String)session.getAttribute("UserId");
            System.out.println("userid::"+userid);
	    sqlGetRoleId="select Role_Id from SEC_MST_OTHER_USER_ROLES where USER_ID=? order by List_Seq_No";
	    System.out.println("query : " + sqlGetRoleId);
	    ps=connection.prepareStatement(sqlGetRoleId);
	    ps.setString(1,userid);
	}
	
	//STYLE="background-position: center;background-color:#FFFFFF; background-repeat:no-repeat;background-attachment:scroll"
%>

<table cellspacing="0" border="0" width="100%">
 <tr  height='89' style='background:images1/subpageBannerNew.jpg'><td height='89' background='images1/subpageBannerNew.jpg;'STYLE="background-repeat:no-repeat;"  colspan=3 align='right'>
 <div><table border="0" ><tr><td><div id='divpre' onclick="loadPageInNewWindow('<%=request.getContextPath()%>/org/HR/HR1/EmployeeMaster/jsps/EmployeeOptionJSP.jsp')" align='right' onmouseover="this.style.cursor='pointer';this.style.color='#000000';this.style.background='#cfdee1';" onmouseout="this.style.cursor='default';this.style.color='#ffffff'; this.style.background='#006D8A'"> <a>Preferences</a> </div></td>
 <td>&nbsp;</td><td ><div id='divlogout'   onclick="loadPage('Logout.jsp')" align='right' onmouseover="this.style.cursor='pointer';this.style.color='#000000';divlogout.style.background='#cfdee1';" onmouseout="this.style.cursor='default';this.style.color='#ffffff';this.style.background='#006D8A'"><a>Logout</a> </div></td></tr></table></div></td>
 </tr>
 
 <tr><td><div align='left'><b> Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</b><%=up.getEmployeePrefix()+" "+ up.getEmpInitial() + "." + up.getEmployeeName()%></div></td>
 <td align='right'><div align='right'><b>Office Level :</b></div></td><td align='left' ><div align='left'> <%=up.getOfficeLevel() %></div></td>
 </tr>
 
 <tr class='ProfileBand'><td><div align='left'><b>Designation :</b> <%=up.getDesignation()%></div></td>
  <td align='right'><div align='right'><b>Office Name :</b></div></td><td align='left' ><div align='left'><%=up.getOfficeShortName()%></div></td>
 </tr>
 
</table>


<% 
System.out.println("inside ---- scriptlet");
results=ps.executeQuery();

while(results.next())
{
		if(temp==""){
			temp=new Integer(results.getInt("Role_Id")).toString();
		}else{
			temp+=","+new Integer(results.getInt("Role_Id")).toString();
		}
}
}
	catch(Exception e){
	System.out.println("error1");
	e.printStackTrace();
	}		
	//out.println("temp"+temp);
	String cnt="select count(*) as cnt1 from(select distinct(Major_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in ("+temp+")	) ";
	try
	{ps=connection.prepareStatement(cnt);
	cntt=ps.executeQuery();
	cntt.next();
	
	}
	catch(Exception e)
	{
	System.out.println("error 2");
	e.printStackTrace();
	return;
	}


    %>

        
	<%
StringBuffer menucategoryCheck=new StringBuffer();
StringBuffer menusubCheck=new StringBuffer();

	String MajorSystemDesc="select Major_System_Short_Desc,Major_System_Id from SEC_MST_MAJOR_SYSTEMS where Major_System_Id in( select distinct(Major_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in("+temp+"))";
		ps=connection.prepareStatement(MajorSystemDesc);
		//ps.setInt(1,results.getInt("Major_System_Id"));
		m1=ps.executeQuery();
		 m11+="<div id='tabs'><ul>"; 
		while(m1.next())
		{
		 m11+="<li><a href=testsubmenu.jsp?majorid="+m1.getString("Major_System_Id")+" target='content'>"+m1.getString("Major_System_Short_Desc")+" </a></li>\n"; 
		}
			
		 m11+="</ul><div>"; 
           
                    String minor="select * from SEC_MST_MINOR_SYSTEMS where  Minor_System_Id in (select distinct(Minor_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in ("+temp+") and Major_System_Id='HRS')";
 		    ps=connection.prepareStatement(minor); 
                    results1=ps.executeQuery();

 		  
                   //  while(results1.next())
                    // {
                        //m11+="<a href=testsubmenu.jsp?submenuid="+results1.getString("Minor_System_Id")+" target='content'>"+results1.getString("Minor_System_Short_Desc")+" </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"; 
 			
                     //  }


	
	
	
	out.print(m11);
}catch(Exception e){out.println("Errior"+e);
e.printStackTrace();
response.sendRedirect("index.jsp?message=dbnill");
}
	
	
%>
</body>
</html>