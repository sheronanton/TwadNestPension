<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false" contentType="text/html;charset=windows-1252"%>

<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/org/Security/scripts/comJS.js"></script>
<script type="text/javascript" src="ChangePasswordJS.js"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" /> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Change New Password</title>
<style type="text/css">
body {
	background-color: #ffffff;
}

a:link {
	color: #002173;
}

.up{
text-transform: uppercase;
font-weight: bold !important;
color:green;
}
</style>
<%-- <link href="<%=request.getContextPath()%>/css/Sample3.css" rel="stylesheet" media="screen" /> --%>
<link href="css/Sample3.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
  HttpSession session=null;
  session= request.getSession(false);
 %>
	<form name="frmchangepassword" method="post">
		<div align="center">
			<br /> <br /> <br />
			<table cellspacing="2" cellpadding="4" border="1" width="75%">
				<tr class="tdH">
					<th align="center" colspan="2" style="font-size: 25px; color: teal;">Change Password
					<img src="<%=request.getContextPath()%>/images/new.gif" width="30px" height="20px"/>
					</th>
				</tr>


				<tr class="table">
					<td colspan="1" width="50%">
						<div align="left" style="padding-left: 10px;">
							Enter Old Password<font color="#ff2121"> * </font>							
						</div>
					</td>
					<td>
						<div align="left" style="padding-left: 3px;">
							<input type="password" name="txtoldPassword"  maxlength="15" size="15" style="width: 223px;">
						</div>
					</td>
				</tr>
				<tr class="table">
					<td>
						<div align="left" style="padding-left: 10px;">
							Enter New Password<font color="#ff2121"> * </font>							
						</div>
					</td>
					<td>
						<div style="padding-left: 3px;">
							<input type="password" name="txtnewPassword" id="txtnewPassword" maxlength="15" size="15" onfocus="return checkoldpass()"  style="width: 223px;">
						</div>
					</td>
				</tr>
				<tr class="table">
					<td>
						<div align="left" style="padding-left: 10px;">
							Enter Confirm Password<font color="#ff2121"> * </font>							
						</div>
					</td>
					<td>
						<div align="left" style="padding-left: 3px;">
							<input type="password" name="txtconfirmPassword" id="txtconfirmPassword" maxlength="15" size="15" onfocus="return checkoldpass()"  style="width: 223px;">
						</div>
					</td>
				</tr>

				<tr class="tdH">
					<td colspan="2">
						<div align="center">
							<!--<input type="Submit" value="Submit" name="submit" onclick="doFunction('test','null')" onkeypress="doFunction('test','null')">  -->
							<input type="Submit" value="Submit" name="submit" onclick="doFunction('test','null')">
						</div>
					</td>
				</tr>
				<tr class="table">
					<td colspan="2"><marquee behavior="alternate" scrollamount="1">
							<font color="red"> &nbsp;&nbsp;New password must contain
								minimum of <font class="up">8</font> characters and maximum of <font class="up"> 15 </font> characters, including <font
								class="up">u</font>ppercase or <font class="up">l</font>owercase
								letters, <font class="up">n</font>umbers and <font class="up">s</font>pecial
								character (#?/!@$%^&amp;*-)
							</font>
						</marquee></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>