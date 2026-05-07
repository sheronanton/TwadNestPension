<%@ page contentType="text/html;charset=iso-8859-1" session="false"%>
<%@ page import="java.util.*,Servlets.Security.servlets.*,java.sql.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"></meta>

<title>TWAD Nest - Phase II welcomes you...</title>
<style type="text/css"></style>
<link href="images1/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="aes.js">     </script>
<script type="text/javascript" src="aes1.js">     </script>
<script type="text/javascript" src="org/Security/scripts/Crypto-js.min.js"> </script>
<script type="text/javascript" src="org/Security/scripts/pad-nopadding.js">     </script>
<script type="text/javascript" src="org/Security/scripts/md5.js"> </script>
<script type="text/javascript" src="org/Security/scripts/md5_new.js"> </script>
<script type="text/javascript" src="org/Security/scripts/sha256.js">     </script>
<script type="text/javascript" src="index.js">     </script>
<script type="text/javascript" src="org/Security/scripts/twad.js">     </script>
<script type="text/javascript" src="org/hrms/payroll/script/com_payroll_script.js"></script>
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT=" no-store, no-cache, must-revalidate">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT=" pre-check=0, post-check=0, max-age=0">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.bg {
	background-image: url(images1/indexbg.jpg);
	background-repeat: no-repeat;
	background-position: center top;
}
-->
</style>
</head>

<body>
<%
		HttpSession session = null;

		session = request.getSession(true);
		String saltValue = TwadUtil.getSeckeys();

		session.setAttribute("saltValue", saltValue);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="599" align="center" valign="top" class="bg"><br />
				<br /> <br /> <br /> <br /> <br /> <img src="images1/title.png"
				alt="" width="400" height="129" /> <br /> <br /> <br /> <br />
				<table width="320" border="0" cellspacing="0" cellpadding="0">
					<th><h2>
							<font color="#FBCE43">Pension</font>
						</h2></th>
					<tr>
						<td height="225" width="410" align="center" valign="middle"
							background="images1/login_bg.png"
							style="background-repeat: no-repeat">
							<form name="frmindex" id="frmindex"><table width="85%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td align="left" valign="middle">
											
											<b><font color="white" size="2">UserName</font></b>
										</td>
										<td align="left" valign="middle">&nbsp;&nbsp; <input
											type="text" name="txtID" tabindex="1" class="textbox"
											placeholder="Username" autocomplete="on"
											title="Enter UserName" maxlength="12" size="16" onblur="killChars(this);stripQuotes(this);" /> &nbsp;
										</td> &nbsp;
									</tr>
									<tr>
										<td align="left" valign="left">
											<!-- <img src="images1/pword_img.jpg" width="65" height="14" />-->
											<b><font color="white" size="2">Password</font></b>
										</td>
										<td align="left" valign="middle">&nbsp;&nbsp; <input
											type="password" name="txtword" placeholder="Password"
											autocomplete="on" tabindex="2" class="textbox" maxlength="12"
											size="16" title="Enter Password" />
										</td>
									</tr>
									
									<tr>                          	
             				<td align="left" valign="middle">
             					<b><font color="white" size="2">Enter Code</font></b>
             				</td>
              				<td align="left" valign="middle">
              				    	&nbsp;&nbsp;
              				    <input type="text"  name="captchaval" tabindex="3"  onKeyPress="return buttonsubmit(event);" 
								id="captchaval" class="textbox"  size="16"  maxlength="7" title="Enter Security Code"  placeholder="Security Code" autocomplete="off" >
							
							</td>
							&nbsp;&nbsp;&nbsp;
						 </tr> 
						 <tr>
             			 	<td></td>
             			 </tr>                                 
                         <tr>
                         &nbsp;&nbsp;
             			 	<td height="15" valign="right" colspan="4">
             					&nbsp;&nbsp;<img src="captcha.jsp" style="height:25px;width:150px; " />&nbsp;&nbsp;<a href="" onclick="Reload()"><img src="images/refresh.png" tabindex="6" style="height:25px;width:25px;border:1; color:pink;" title="Change Code"/></a>
            				</td>
             			 </tr>
								</table>
								<table width="80%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="25">&nbsp;</td>
										<td align="right" valign="bottom"><a id="loginid"
											href="#" onKeyPress="return buttonsubmit(event)"> <img
												src="images/login-button.png" tabindex="4"
												onClick="return notNull()" name="butSubmit" alt="Login"
												width="120" height="48" border="0" />
										</a></td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="100" align="center" valign="bottom" bgcolor="#176B9A">
			</td>
		</tr>
		<tr>
			<td height="30" align="center" valign="bottom" bgcolor="#176B9A">
				<table width="714" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="50" align="center" valign="middle"
							background="images1/footerbg.jpg"
							style="background-repeat: no-repeat"><span
							class="arialwhitebold">Designed &amp; Developed by <a
								href="http://www.tn.nic.in" target="_blank"
								class="arialwhitebold">National Informatics Centre, Chennai</a>
						</span></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
if( self != top ) { top.location.replace(self.location.href); }
var saltValue="<%=saltValue%>";
</script>
</html>
<%
	try {
		String message = request.getParameter("message");
		System.out.println("Message:----------------->" + message);
		request.setAttribute("message", "");
		if (message != null) {
			out.println("<script type='text/javascript'>");
			if (message.equals("yes")) {
				out.println("responce('yes');");			
			} else if (message.equals("noprofile")) {
				out.println("responce('noprofile');");
			} else if (message.equals("retired")) {
				out.println("responce('retired');");
			} else if (message.equals("dbnill")) {
				out.println("responce('dbnill');");
			} else if (message.equals("logindisabled")) {
				out.println("responce('logindisabled');");
			} else if (message.equals("captcha")) {
				out.println("responce('captcha');");
			} else if (message.equals("invalidDate")) {
				out.println("responce('invalidDate');");
			}
			out.println("</script>");

		}
	} catch (Exception e) {
		System.out.println("Exception ------------->" + e);
	}
%>