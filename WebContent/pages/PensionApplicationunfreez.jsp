<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="../styles/default.css" rel="stylesheet" />
<script type="text/javascript"
	src="../javascript/ChangeFamilyPensionerDetails.js"></script>

<title>Insert title here</title>
</head>
<body>
<s:form name="applicationunfreez" action="pensionapplicationunfreez" namespace="/pages">
<div>
<table border="1">
        <tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4">pension Application Unfreeze</font></td>
		</tr>
		<tr>
		   <th>EMPLOAYEE ID
		   </th>
		     <td><s:textfield name="empid" id="empid"/></td>
		</tr>
		<tr>
		<th>EMPLOYEE NAME
		</th>
		<td><s:textfield name="ename" id="ename"/>
		</td>
		</tr>
		<tr>
		<td><s:submit value="UNFREEZE"/><input type="button" value="close" onclick="window.close();"/></td>
		
		</tr>
</table>
</div>
</s:form>

</body>
</html>