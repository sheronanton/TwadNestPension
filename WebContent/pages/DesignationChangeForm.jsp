<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Designation Change form</title>
<style type="text/css">
table.border1
{
	border-top:1px solid #FFFFFF;
	border-left:1px solid #FFFFFF;
	border-right:0px solid #FFFFFF;
	border-bottom:0px solid #FFFFFF;
	font-family:Arial;
	font-size:12px;
	background-color:#DFE8E8;
	
}
table.border1 th
{
	border-top:0px solid #FFFFFF;
	border-left:0px solid #FFFFFF;
	border-right:1px solid #FFFFFF;
	border-bottom:1px solid #FFFFFF;
	padding:5px 0 5px 10px;
	height:25px;
	font-size:13px !important;
	text-align:left;
}
table.border1 td
{
	border-top:0px solid #FFFFFF;
	border-left:0px solid #FFFFFF;
	border-right:1px solid #FFFFFF;
	border-bottom:1px solid #FFFFFF;
	padding:5px 0 5px 10px;
	height:25px;
	text-align:left;
}

table.border1 a
{
text-decoration:none;
font-weight:bold;
 color:#000000; 

}
table.border1 a:hover
{
text-decoration:none;
font-weight:bold;
color:red; 

}
img
{
border:none;
}
a
{
border:none;
}

</style>
<style type="text/css">
.info, .success, .warning, .error {
    border: 1px solid;
    margin: 15px 0px;
    padding:15px 20px 15px 55px;
    width: 300px;	
    font: bold 12px verdana;
    -moz-box-shadow: 0 0 5px #888;
    -webkit-box-shadow: 0 0 5px#888;
    box-shadow: 0 0 5px #888;
    text-shadow: 2px 2px 2px #ccc;
    -webkit-border-radius: 15px;
    -moz-border-radius: 15px;
    border-radius: 15px;
}

.success {
    color: #4F8A10;
    background: #DFF2BF url('../images/success1.png') no-repeat 10px center;
}
.warning {
    color: #9F6000;
    background: #FEEFB3 url('../images/warning1.png') no-repeat 10px center;
}
</style>
<script  src="<s:url value="/javascript/Designationchangeform.js" />" type="text/javascript">
</script>
<script type="text/javascript">
function clearp()
{
	//alert("hide");
	document.forms[0].empNo.value="";
	document.forms[0].empName.value="";
	document.forms[0].desig.value="";
}
</script>
</head>
<body bgcolor="#ecf4f7" onload="clearp();">
<table border="0" cellpadding="0" cellspacing="0" width="50%" align="center">
	<tr>
		<td align="center">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" class="border1" >
			<s:form name="changename" action="" method="POST"  namespace="/pages" >
			
			<s:hidden name="token" id="token" ></s:hidden>
			<s:if test="status!=null">
				<div class="success"><s:property value="status"/></div>
			</s:if>
			<s:if test="msg != null">
			  <div class="warning"><s:property value="msg"/></div>
			</s:if>
			
			
				<tr>
					<th colspan="2" background="../images/bluebg1.jpg" style="color:#FFFFFF; font-size:15px;">Change Designation Form</th>
				</tr>	
				<tr>
				<td><font class="fontss">Emp NO</font>&nbsp;<font color="red">*</font></td>
				<td><s:textfield id="empNo" name="empNo" theme="simple" cssClass="textbox" onkeypress="return numberOnly(event,this);" onchange="checkExisting(this.value);" />&nbsp;
				<input type="button" value="Select EMP NO" onclick="window.open('designationSearch.jsp','as','width=800,height=500,scrollbars=yes')"/>
				</td>
		
				</tr>
				<tr>
				<td><font class="fontss"><div id="plable">Emp Name</div></font></td>
				<td><s:textfield id="empName" name="empName" theme="simple" cssClass="textbox" readonly="true" cssStyle="background-color:#dddddf;"/></td>
	   			</tr>
				<tr>
				<td><font class="fontss"><div id="plable">Designation</div></font></td>
				<td><s:textfield id="desig" name="desig" theme="simple" cssClass="textbox" readonly="true" cssStyle="background-color:#dddddf; width=30;" /></td>
	   			</tr>
			   	<tr>
				<td ><font class="fontss"><div id="plable">Change Designation</div></font><font color="red">*</font></td>
				<td ><s:select id="designationId" name="designationId" theme="simple" listValue="designationName" list="destlist" listKey="designationId" headerKey="" headerValue="--Select Designation--"/></td>
			 	</tr>
				<tr>
					<td colspan="2" style="text-align:center !important;">
					<!--<s:submit action="insertFestival" value="Add" name="addfest" id="addfest"/>-->
					<s:submit action="changedesination" value="UpdateDesignation" name="updatedesig" id="updatedesig"/>
					<!--<s:submit action="DeleteFestival" value="Delete" name="deletefest" id="deletefest"/>-->
					
					<!--<input type="submit" id="add" name="add" value="add" />
					<input type="submit" id="update" name="update" value="update" />
					<input type="submit" id="delete" name="delete" value="delete" />
					-->
					<input type="button" name="Close" id="Close" value="Close" onclick="javascript:window.close();" />
                    

					
					<div style="float:right;padding:0px 5px 0px 0px;"><font color="red">*</font>&nbsp;<span style="font-style:italic;">fields are mandatory</span></div>
					</td>
					
				</tr>	
				
			</s:form>
			</table>
		</td>
	</tr>
	</table>
</body>
</html>