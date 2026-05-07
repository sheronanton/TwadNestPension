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
<script language='javascript' src='fg.menu.js' ></script>
<script type='text/javascript' src='org/Security/scripts/twad.js'></script>
<link href='css/index.css' rel='stylesheet' media='screen'/>
<link href='css/doubletab2.css' rel='stylesheet' media='screen'/>
<script type='text/javascript' src='org/Security/scripts/StatusBarScrollText.js'></script>
<script language='javascript' src='org/Security/scripts/tabpane.js'></script>
<style type="text/css">
		 body { font-size:12px; margin:0; padding:0; }
		 #menuLog { font-size:1.4em; margin:20px; }
		.hidden { position:absolute; top:0; left:-9999px; width:10px; height:1px; overflow:hidden; }
		.fg-button { clear:center; margin:0 0px 40px 0px; padding: .1em 1em; text-decoration:none !important; cursor:pointer; position: relative; text-align: center; zoom: 1; }
		.fg-button .ui-icon { position: absolute; top: 50%; margin-top: -8px; left: 50%; margin-left: -8px; }
		 a.fg-button {   float:left;  }
		 button.fg-button { width:auto; overflow:visible; }/* removes extra button width in IE */
		.fg-button-icon-left { padding-left: 2.1em; }
		.fg-button-icon-right { padding-right: 2.1em; }
		.fg-button-icon-left .ui-icon { right: auto; left: .2em; margin-left: 0; }
		.fg-button-icon-right .ui-icon { left: auto; right: .2em; margin-left: 0; }
		.fg-button-icon-solo { display:block; width:8px; text-indent: -9999px; }/* solo icon buttons must have block properties for the text-indent to work */	
		.fg-button.ui-state-loading .ui-icon { background: url(images/spinner_bar.gif) no-repeat 0 0; }
	</style>
	<!--[if IE]>
	<style type="text/css">
		.fg-menu-ipod .fg-menu li { width: 95%; }
		.fg-menu-ipod .ui-widget-content { border:0; }
	</style>
	
	</style>
	<![endif]-->	
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
//session.setMaxInactiveInterval(60);
System.out.println("session id:"+session.getId());
System.out.println("check for new session isnew::::::"+session.isNew());
System.out.println("Request value:"+request.getParameter("empid"));
System.out.println("ses parameter :"+request.getParameter("session"));
    if(session ==null) {
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return;
    }
    if(!session.isNew()) {
         
       if(session.getAttribute("UserProfile")==null) {
             session.invalidate(); 
             session=null;
             System.out.println(request.getContextPath()+"/index.jsp");
             response.sendRedirect(request.getContextPath()+"/index.jsp");
         }
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
}











try{


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
 <td>&nbsp;</td><td ><div id='divlogout' onclick="loadPage('Logout.jsp')" align='right' onmouseover="this.style.cursor='pointer';this.style.color='#000000';divlogout.style.background='#cfdee1';" onmouseout="this.style.cursor='default';this.style.color='#ffffff';this.style.background='#006D8A'"><a>Logout</a> </div></td></tr></table></div></td>
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
int i=1;
String  m11="";
String temp="";
int flag=0;
while(results.next())
{
		if(temp==""){
			temp=new Integer(results.getInt("Role_Id")).toString();
		}else{
			temp+=","+new Integer(results.getInt("Role_Id")).toString();
		}
}		
	//out.println("temp"+temp);
	String cnt="select count(*) as cnt1 from(select distinct(Major_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in ("+temp+")	) ";
	ps=connection.prepareStatement(cnt);
	cntt=ps.executeQuery();
	cntt.next();
	
	


    %>
    <script type="text/javascript">
		$('.fg-button').hover(
    		function(){  $(this).removeClass('ui-state-default').addClass('ui-state-focus'); },
    		function(){ $(this).removeClass('ui-state-focus').addClass('ui-state-default'); }
    	);
      	$(function(){
    		// MENUS  
	    	var a="<%=cntt.getInt("cnt1")%>";  
    		for(i=1;i<=a;i++){
    			var b="#flat"+i;	
    			$(b).menu({content: $(b).next().html(), flyOut: true ,showSpeed: 300});
		 	}
		 });
		 
	</script>
        
	<%

		String MajorSystemDesc="select Major_System_Short_Desc,Major_System_Id from SEC_MST_MAJOR_SYSTEMS where Major_System_Id in( select distinct(Major_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in("+temp+"))";
		ps=connection.prepareStatement(MajorSystemDesc);
		//ps.setInt(1,results.getInt("Major_System_Id"));
		m1=ps.executeQuery();
		while(m1.next())
		{
			
		
                    m11+="\n<a tabindex='0' href='#"+m1.getString("Major_System_Short_Desc")+"' class='fg-button fg-button-icon-right ui-widget ui-state-default ui-corner-all' id='flat"+i+"'>\n <span class='ui-icon ui-icon-triangle-1-s'></span>"+m1.getString("Major_System_Short_Desc")+" </a>\n";
 		    m11+="<div id='"+m1.getString("Major_System_Short_Desc")+"' class='hidden'>\n";
                    String minor="select * from SEC_MST_MINOR_SYSTEMS where  Minor_System_Id in (select distinct(Minor_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in ("+temp+") and Major_System_Id='"+m1.getString("Major_System_Id")+"')";
 		    ps=connection.prepareStatement(minor); 
                    results1=ps.executeQuery();
                    m11+="<ul>\n";
 		  
                     while(results1.next())
                     {
                        m11+="\t<li><a href=#>"+results1.getString("Minor_System_Short_Desc")+"</a>\n"; 
 			String subsystem="select * from SEC_MST_SUBSYSTEMS where sub_system_id in(select distinct(sub_system_id) from SEC_MST_ROLE_MENUS where Role_Id in("+temp+") and Major_System_Id='"+results1.getString("Major_System_Id")+"' and minor_system_id='"+results1.getString("Minor_System_Id")+"') and Major_System_Id='"+results1.getString("Major_System_Id")+"' and minor_system_id='"+results1.getString("Minor_System_Id")+"'";
 			ps=connection.prepareStatement(subsystem); 
 			results2=ps.executeQuery();
                            m11+="\t\t<ul>\n";
                                while(results2.next())
                                { 
                                    m11+="\t\t\t<li><a href=#>"+results2.getString("Sub_System_Short_Desc")+"</a>\n";
                                    String category="SELECT DISTINCT  menu_category as menu_cate,Major_System_Id,Minor_System_Id,sub_system_id,menu_category,null as original_file_path FROM SEC_MST_INTRANET_MENUS WHERE menu_id IN(SELECT DISTINCT(menu_id) FROM SEC_MST_ROLE_MENUS WHERE Role_Id IN("+temp+")  AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' and sub_system_id='"+results2.getString("sub_system_id")+"') AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' AND MENU_CATEGORY IS NOT NULL and sub_system_id='"+results2.getString("sub_system_id")+"' UNION ALL SELECT DISTINCT menu_desc as menu_cate,Major_System_Id,Minor_System_Id,sub_system_id,COALESCE(menu_category,null,'empty',menu_category) as menu_category,file_path as original_file_path  FROM SEC_MST_INTRANET_MENUS WHERE menu_id IN(SELECT DISTINCT(menu_id)FROM SEC_MST_ROLE_MENUS WHERE Role_Id IN("+temp+")  AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' AND sub_system_id= '"+results2.getString("sub_system_id")+"' ) AND MENU_CATEGORY IS NULL and sub_system_id= '"+results2.getString("sub_system_id")+"' AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' ";
                                    ps=connection.prepareStatement(category); 
                                    results3=ps.executeQuery();
                                        m11+="\t\t<ul>\n";
                                            while(results3.next()){
                                                m11+="\t\t\t<li><a href=# onclick=loadPageInNewWindow('"+results3.getString("original_file_path")+"')>"+results3.getString("menu_cate")+"</a>";
         	 				String subcategory="select distinct MENU_DESC,file_path from SEC_MST_INTRANET_MENUS where sub_system_id in(select distinct(sub_system_id) from SEC_MST_ROLE_MENUS where Role_Id in("+temp+") )and Major_System_Id='"+results3.getString("Major_System_Id")+"' and minor_system_id='"+results3.getString("Minor_System_Id")+"' and sub_system_id='"+results3.getString("sub_system_id")+"' and MENU_CATEGORY='"+results3.getString("menu_category")+"' ";
                                                ps=connection.prepareStatement(subcategory); 
                                                results4=ps.executeQuery();
                                                if( !results3.getString("menu_category").equalsIgnoreCase("empty"))
                                                    {
                                                       flag=1;
                                                           m11+="\t\t<ul >\n";
                                                                while(results4.next()){
                                                                	m11+="<li><a  href=# onclick=loadPageInNewWindow('"+results4.getString("file_path")+"')>"+ results4.getString("MENU_DESC")+"</a></li>\n";
                                                                }
                                                        //m11+="</ul></li></ul></li>\n";
                                                        m11+="</ul>\n";
                                                      }
                                                    m11+="</li>\n";
                                                }
                                            m11+="</ul>\n";
                                    }
                                    m11+="\t\t</li></ul>\n"; 
                       }
                        m11+="</li>\n</ul>\n"; 
 	 		 m11+="</div>\n";
 		  i++;
		}
	
	
	out.print(m11);
}catch(Exception e){out.println("Errior"+e);
response.sendRedirect("index.jsp?message=dbnill");
}
	
	
%>
</body>
</html>