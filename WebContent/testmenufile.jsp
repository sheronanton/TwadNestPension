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

<script type='text/javascript' src='org/Security/scripts/StatusBarScrollText.js'></script>
<link href="NewTabMenu.css" rel="stylesheet" type="text/css" />
<style type="text/css">

/******************************************************************************
* Styles for the tabbed displays.                                             *
******************************************************************************/

/*-----------------------------------------------------------------------------
  Note: The border-radius property is a proposed feature for CSS3 which creates
        rounded corners. Mozilla/Netscape browsers currently support this
        feature via the proprietary -moz-border-radius property. Both are
        defined here. Browsers that support neither should simply ignore them.
-----------------------------------------------------------------------------*/
body {
margin:0;
padding:0;
height:100%;
width :100%;

} 
div.tabBox {
height:100%;
max-width:100%;

}

div.tabArea {
  font-size: 90%;
  font-weight: bold;
  padding: 4px 0px 4px 0px;
  width : 100%;
  color: white;

}



div.tabMain {
 background:  url(images/menugif.png) 50% bottom repeat;
  border: 1px solid #6C9FCC url(images/menugif.png) 50% bottom repeat;;

  -moz-border-radius: 0em .0em .5em 0em;
  border-radius-topright: .5em;
  border-radius-bottomright: .5em;
  padding: .5em;
  position: relative;
  z-index: 101;
    height : 180px;

}

div.tabhead{
 background:  url(images/menugif.png) 50% bottom repeat;
  border: 1px solid #6C9FCC url(images/menugif.png) 50% bottom repeat;;

  font-weight: bold;
  color : white;

  -moz-border-radius: .5em .5em .0em .0em;
  border-radius-topright: .5em;
  border-radius-bottomright: .5em;
  padding: .5em .0em .0em .0em;

  z-index: 101;


}


/******************************************************************************
* Additional styles.                                                          *
******************************************************************************/
  a:link {
color: #0A4A0C;
}

a:visited {
color: #0A4A0C;
}
a:hover {
color: #9909DB;
}
h5#title {

background:url(images/indexBg.jpg) no-repeat right top;

  border: 1px solid #000000  url(images/bluebg1.jpg)  bottom repeat-x;
  
  color: #ccccff;
  font-weight: none;
  margin-top: 0em;
  margin-bottom: .5em;
  padding: 1px .3em 1px .3em;
  height:99%;
  overflow: auto;

  scrollbar-base-color: #9999cc;
scrollbar-arrow-color: white;
scrollbar-track-color: #ccccff;

scrollbar-shadow-color: black;
scrollbar-lightshadow-color: black;
scrollbar-darkshadow-color: gray;

scrollbar-highlight-color: white;
scrollbar-3dlight-color: black;
}

</style>

<script type="text/javascript">//<![CDATA[

//*****************************************************************************
// Do not remove this notice.
//
// Copyright 2002 by Mike Hall.
// See http://www.brainjar.com for terms of use.
//*****************************************************************************
//alert("Hai");
function synchTab(frameName) {

  var elList, i;

  // Exit if no frame name was given.

  if (frameName == null)
    return;

  // Check all links.

  elList = document.getElementsByTagName("A");
  for (i = 0; i < elList.length; i++)

    // Check if the link's target matches the frame being loaded.

    if (elList[i].target == frameName) {

      // If the link's URL matches the page being loaded, activate it.
      // Otherwise, make sure the tab is deactivated.

      if (elList[i].href == window.frames[frameName].location.href) {
        elList[i].className += " activeTab";
        elList[i].blur();
      }
      else
        removeName(elList[i], "activeTab");
    }
}

function removeName(el, name) {

  var i, curList, newList;

  if (el.className == null)
    return;

  // Remove the given class name from the element's className property.

  newList = new Array();
  curList = el.className.split(" ");
  for (i = 0; i < curList.length; i++)
    if (curList[i] != name)
      newList.push(curList[i]);
  el.className = newList.join(" ");
}

//]]></script>

</head>
<body >
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
        ConnectionString=strdsn.trim()+"://"+strhostname.trim()+":"+strportno.trim()+"/"+strsid.trim();//PostgresDB Connections
        //ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

         Class.forName(strDriver.trim());
         connection=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
}
catch(Exception e)
{
System.out.println("Exception in connection...."+e);
response.sendRedirect(request.getContextPath()+ "/index.jsp?message=dbnill");
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
	String cnt="select count(*) as cnt1 from(select distinct(Major_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in ("+temp+")	) as cnt ";
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
	String submenuid="";
	String minorid="";
	String major_id="";
StringBuffer menucategoryCheck=new StringBuffer();
StringBuffer menusubCheck=new StringBuffer();
		try{
major_id=request.getParameter("major_id");
submenuid=request.getParameter("subid");
minorid=request.getParameter("minor_id");
System.out.println("major_id="+major_id);
System.out.println("minorid="+minorid);
System.out.println("submenuid="+submenuid);
System.out.println("TEMP="+temp);
}
catch(Exception e){
}
 m11+="";
   int tdlen=0;
  m11+="<table width='100%'><tr>";
		
                                    String singlemenu="SELECT MENU_DESC, " +
"  file_path, " +
"  category_seq_no " +
"FROM SEC_MST_INTRANET_MENUS " +
"WHERE Major_System_Id='"+major_id+"' " +
"AND Minor_System_Id='"+minorid+"' " +
"AND sub_system_id  ='"+submenuid+"' "+
" and MENU_ID in(select MENU_ID from SEC_MST_ROLE_MENUS where Major_System_Id='"+major_id+"' "+ 
" And Minor_System_Id='"+minorid+"' "+ 
" And Sub_System_Id  ='"+submenuid+"' "+ 
" and ROLE_ID in ("+temp+"))   " +
"AND Menu_Category  is null " +
"ORDER BY category_seq_no, " +
"  ORDER_SEQ_NO";
												ps=connection.prepareStatement(singlemenu); 

                                                results2=ps.executeQuery();
                                                 
                                                   System.out.println("results2="+tdlen);
                                                 if(results2.next()){
                                                 tdlen=tdlen+1;
                                                  m11+="<td valign='top' width='25%' height='30%'><div class='tabBox' style='clear:both;'> <div class='tabhead'>&nbsp;&nbsp;&nbsp;Menu</a><div class='tabMain'><h5 id='title'>";
                                                   m11+="<p><img src='images/arrowToRight.gif'></img>&nbsp;<a  href=# onclick=loadPageInNewWindow('"+results2.getString("file_path")+"')>"+ results2.getString("MENU_DESC")+"</a></p>";
                                                  while(results2.next()){
                                                System.out.println("results2");
                        m11+="<p><img src='images/arrowToRight.gif'>&nbsp;<a  href=# onclick=loadPageInNewWindow('"+results2.getString("file_path")+"')>"+ results2.getString("MENU_DESC")+"</a></p>";
                        } 
                         m11+="</h5></div></div></td>";
                                                 }
                                               
        
                                //    String category="SELECT DISTINCT  menu_category as menu_cate,Major_System_Id,Minor_System_Id,sub_system_id,menu_category,null as original_file_path,category_seq_no FROM SEC_MST_INTRANET_MENUS WHERE menu_id IN(SELECT DISTINCT(menu_id) FROM SEC_MST_ROLE_MENUS WHERE Role_Id IN("+temp+")  AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' and sub_system_id='"+results2.getString("sub_system_id")+"') AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' AND MENU_CATEGORY IS NOT NULL and sub_system_id='"+results2.getString("sub_system_id")+"' UNION ALL SELECT DISTINCT menu_desc as menu_cate,Major_System_Id,Minor_System_Id,sub_system_id,decode(menu_category,null,'empty',menu_category) as menu_category,file_path as original_file_path,category_seq_no  FROM SEC_MST_INTRANET_MENUS WHERE menu_id IN(SELECT DISTINCT(menu_id)FROM SEC_MST_ROLE_MENUS WHERE Role_Id IN("+temp+")  AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' AND sub_system_id= '"+results2.getString("sub_system_id")+"' ) AND MENU_CATEGORY IS NULL and sub_system_id= '"+results2.getString("sub_system_id")+"' AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' order by category_seq_no"; 
                                   //String category="SELECT menu_category as menu_cate,Major_System_Id,Minor_System_Id,sub_system_id,menu_category,file_path FROM SEC_MST_INTRANET_MENUS WHERE	menu_id IN(SELECT DISTINCT(menu_id) FROM SEC_MST_ROLE_MENUS WHERE Role_Id IN("+temp+") AND Major_System_Id='PMS' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' and sub_system_id='"+results2.getString("sub_system_id")+"') AND Major_System_Id='"+results2.getString("Major_System_Id")+"' AND minor_system_id='"+results2.getString("Minor_System_Id")+"' AND MENU_CATEGORY IS NOT NULL and sub_system_id='"+results2.getString("sub_system_id")+"'  group by menu_category,FILE_PATH,major_system_id,minor_system_id,sub_system_id,menu_category  order by min(category_seq_no)";
                                   String category="SELECT DISTINCT(Menu_Category) " +
"   " +
"FROM Sec_Mst_Intranet_Menus " +
"WHERE Major_System_Id='"+major_id+"' " +
"AND Minor_System_Id  ='"+minorid+"' " +
"AND Sub_System_Id    ='"+submenuid+"' " +
" and MENU_ID in(select MENU_ID from SEC_MST_ROLE_MENUS where Major_System_Id='"+major_id+"'  " +
" And Minor_System_Id='"+minorid+"'  " +
 " And Sub_System_Id  ='"+submenuid+"'  " +
" and ROLE_ID in ("+temp+"))   " +
"AND Menu_Category   <>'null' " +
"" ;
                                   
                                    try{
                                    ps=connection.prepareStatement(category); 
                                    results3=ps.executeQuery();
                                      
                                     
                                            while(results3.next()){
                                            tdlen=tdlen+1;
                                            System.out.println("resulstset3="+tdlen);
                                            
                                            	String menu="SELECT MENU_DESC, " +
"  file_path, " +
"  category_seq_no " +
"FROM SEC_MST_INTRANET_MENUS " +
"WHERE Major_System_Id='"+major_id+"' " +
"AND Minor_System_Id='"+minorid+"' " +
"AND sub_system_id  ='"+submenuid+"' " +
" and MENU_ID in(select MENU_ID from SEC_MST_ROLE_MENUS where Major_System_Id='"+major_id+"' "+ 
" And Minor_System_Id='"+minorid+"' "+ 
" And Sub_System_Id  ='"+submenuid+"' "+ 
" and ROLE_ID in ("+temp+"))  " +
"AND Menu_Category  ='"+results3.getString("Menu_Category")+"' " +
"ORDER BY category_seq_no, " +
"  ORDER_SEQ_NO";
												ps=connection.prepareStatement(menu); 

                                                results4=ps.executeQuery();
                                                 m11+="<td valign='top' width='25%' height='30%' ><div class='tabBox' style='clear:both;'><div class='tabhead'>&nbsp;&nbsp;&nbsp;"+results3.getString("Menu_Category")+"<div class='tabMain'><h5 id='title'>";
                                                while(results4.next()){
                                                System.out.println("resulstset4");
                        m11+="<p><img src='images/arrowToRight.gif'>&nbsp;<a  href=# onclick=loadPageInNewWindow('"+results4.getString("file_path")+"')  valign='top'>"+ results4.getString("MENU_DESC")+"</a></p>";
                        }                    	
                                            	
                                             m11+="</h5></div></div></td>";
                                             for(int j=1;j<5;j++){
                                             if(tdlen==(j*3)){
                                             m11+="</tr><tr>";
                                             
                                             }
                                             }
                                             
                                             }
                                            m11+="</tr></table>";
                                            results3.close();
                                            }
                                            catch(Exception e)
	{
	System.out.println("error inner2");
	e.printStackTrace();
	return;
	}
                                          
                                 
                                   
	
	//System.out.print(m11);
	out.print(m11);
}catch(Exception e){out.println("Errior"+e);
e.printStackTrace();
response.sendRedirect("index.jsp?message=dbnill");
}
	
	
%>
</body>
</html>