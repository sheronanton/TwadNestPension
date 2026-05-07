<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*,java.util.*,Servlets.Security.classes.UserProfile"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twad Board Intranet Services</title>




<script type='text/javascript' src='org/Security/scripts/twad.js'></script>
<link href='css/index.css' rel='stylesheet' media='screen'/>
<link href='css/doubletab2.css' rel='stylesheet' media='screen'/>
<script type='text/javascript' src='org/Security/scripts/StatusBarScrollText.js'></script>

<script type="text/javascript" src="jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="ddaccordion.js">

/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/

</script>


<script type="text/javascript">


ddaccordion.init({
	headerclass: "expandable", //Shared CSS class name of headers group that are expandable
	contentclass: "categoryitems", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "medium", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})


</script>

<style type="text/css">

.arrowlistmenu{
width: 280px; /*width of accordion menu*/
align: center; 
}

.arrowlistmenu .menuheader{ /*CSS class for menu headers in general (expanding or not!)*/
font: bold 14px Arial;
color: white;
background: #6C9FCC url(images/bluebg1.jpg) 50% bottom repeat-x;
  -moz-border-radius: .3em .3em .3em .3em;
margin-bottom: 10px; /*bottom spacing between header and rest of content*/
text-transform: uppercase;
padding: 4px 0 4px 10px; /*header text is indented 10px*/
cursor: hand;
cursor: pointer;
}

.arrowlistmenu .openheader{ /*CSS class to apply to expandable header when it's expanded*/
background-image: url(titlebar-active.png);
}

.arrowlistmenu ul{ /*CSS for UL of each sub menu*/
list-style-type: none;
margin: 0;
padding: 0;
margin-bottom: 8px; /*bottom spacing between each UL and rest of content*/
}

.arrowlistmenu ul li{
padding-bottom: 2px; /*bottom spacing between menu items*/
}

.arrowlistmenu ul li a{
color: blue;
background: url(arrowbullet.png) no-repeat center left; /*custom bullet list image*/
display: block;
padding: 2px 0;
padding-left: 19px; /*link text is indented 19px*/
text-decoration: none;
font-weight: bold;
border-bottom: 1px solid #dadada;
font-size: 90%;
}

.arrowlistmenu ul li a:visited{
color: #194F04;
}
.arrowlistmenu ul li a:active{
color: white;
background-color: #DB90DE;
}
.arrowlistmenu ul li a:hover{ /*hover state CSS*/
color: white;
background-color: #9909DB;
}

</style>
</head>
<body>
<div class="arrowlistmenu">

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
	String cnt="select count(*) as cnt1 from(select distinct(Major_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in ("+temp+")	)  as cnt ";
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
	String major_id="";
StringBuffer menucategoryCheck=new StringBuffer();
StringBuffer menusubCheck=new StringBuffer();
try{
major_id=request.getParameter("majorid");
System.out.println("major_id="+major_id);
}
catch(Exception e){
}
		//and MINOR_SYSTEM_ID in('HS030')
			
			String minor="select * from SEC_MST_MINOR_SYSTEMS where  Minor_System_Id in (select distinct(Minor_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in ("+temp+") and Major_System_Id='"+major_id+"' and MINOR_SYSTEM_ID in('HS030'))   ";
 		   
			ps=connection.prepareStatement(minor); 
            results1=ps.executeQuery();
           
 		  //m11+="<div class='arrowlistmenu'>";
                     while(results1.next())
                     {
                        m11+="<h3 class='menuheader expandable'>"+results1.getString("Minor_System_Short_Desc")+"</h3><ul class='categoryitems'>"; 
 			String subsystem="select * from SEC_MST_SUBSYSTEMS where sub_system_id in(select distinct(sub_system_id) from SEC_MST_ROLE_MENUS where Role_Id in("+temp+") and Major_System_Id='"+results1.getString("Major_System_Id")+"' and minor_system_id='"+results1.getString("Minor_System_Id")+"') and Major_System_Id='"+results1.getString("Major_System_Id")+"' and minor_system_id='"+results1.getString("Minor_System_Id")+"' and sub_system_desc in('Pension Application','Family Pension Application','Revised Pension Application','Revised Family Pension Application') order by sub_system_id";
 			//String subsystem="select * from SEC_MST_SUBSYSTEMS where sub_system_id in(select distinct(sub_system_id) from SEC_MST_ROLE_MENUS where Role_Id in("+temp+") and Major_System_Id='"+results1.getString("Major_System_Id")+"' and minor_system_id='"+results1.getString("Minor_System_Id")+"') and Major_System_Id='"+results1.getString("Major_System_Id")+"' and minor_system_id='"+results1.getString("Minor_System_Id")+"' order by sub_system_id";
 			ps=connection.prepareStatement(subsystem); 
 			results2=ps.executeQuery();
                           
                                while(results2.next())
                                { 
                                    m11+="<li><a href='testmenufile.jsp?major_id="+major_id+"&subid="+results2.getString("sub_system_id")+"&minor_id="+results1.getString("Minor_System_Id")+"' target='menu'>"+results2.getString("Sub_System_Short_Desc")+"</a></li>";
 
                                          
                                    }
                                 
                                   m11+="</ul>";  
                       }
 
	 // m11+="</div>";  
	
	out.print(m11);
}catch(Exception e){out.println("Errior"+e);
e.printStackTrace();
response.sendRedirect("index.jsp?message=dbnill");
}
	
	
%>

</div>
</body>

</html>