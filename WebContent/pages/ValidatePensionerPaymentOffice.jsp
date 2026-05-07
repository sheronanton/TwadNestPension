<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Validate Changed Pensioner's Payment Office</title>
	
	<link type="text/css" href="../styles/calendar-win2k-cold-1.css" rel="stylesheet" />
	<link type="text/css" href="../styles/demos.css" rel="stylesheet" />
	<link type="text/css" href="../styles/default.css" rel="stylesheet" />
	<link type="text/css" href="../styles/ui.all.css" rel="stylesheet" />
	
	<style type="text/css">
	.fontss
	{
	
	font-family:Verdana;
	font-size:12px;
			
	}
	</style>
	
	<script type="text/javascript" src="../javascript/ChangePensionerPaymentOffice.js"></script>

</head> 

<body >
<br><br><br>

<s:form name="ValidatePaymentOffice" action="ValidatePaymentOffice" method="POST" enctype="multipart/form-data" namespace="/pages" >


 
<table border="0" align="center" width="70%" bgcolor="#DFE8E8" > 
		<tr bgcolor="#BCC0C4">
			<td colspan="4" background="../images/bluebg1.jpg"><font color="white" size="4">Validate Pensioner's Payment Office</font></td>
		</tr>
		<tr>
			<td class="fontss">PPO NO <font color="red">*</font> </td>
			<td><s:textfield name="ppoNo" id="ppoNo" theme="simple" cssClass="textbox" readonly="true"  onchange="loadChangedPPo();" cssStyle="background-color:#dddddf;" />&nbsp;&nbsp;   
			<input type="button" value="Select PPO NO" onclick="window.open('ChangedPaymentOfficeSearch.jsp','ChangePensionerSearch','width=800,height=500,scrollbars=yes')"/> </td>
			</tr>
			<tr>
			<td class="fontss">Employee Id</td>
			<td><s:textfield name="employeeId" id="employeeId" theme="simple" cssClass="textbox" readonly="true"  cssStyle="background-color:#dddddf;" /> </td>
		</tr>
		<tr>
			<td class="fontss">Employee Name</td>
			<td><s:textfield name="employeeName" id="employeeName" theme="simple" cssClass="textbox" readonly="true" cssStyle="background-color:#dddddf;" /> </td>
		</tr>
		<tr>
			<td class="fontss">Old Office Name</td>
			<td><input type="text" name="old" id="old" readonly size="30" class="textbox" style="background-color:#dddddf;"> </td>
		</tr>
		<tr>
			<td class="fontss">New Office Name <font color="red">*</font></td>
			<td><s:select name="paymentOfficeId" id="paymentOfficeId" headerKey="" headerValue="--Select--" list="paymentload" theme="simple" cssClass="selectbox" listKey="currAccountOfficeId" listValue="currAccountOfficeName" cssStyle="border:#ffba14 1.5px solid" /> </td>
		</tr>
		<tr>
			<td class="fontss"> Reason for Change <font color="red">*</font></td>
			<td> <s:textarea name="reason" id="reason" theme="simple" cssStyle="border:#ffba14 1.5px solid" rows="5" cols="25"  /> &nbsp; </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button"  value="Validate" onclick="javascript:validate()"/>
			<input type="button" value="Clear" onclick="javascript:clearMyForm();" /> &nbsp;			
			<input type="button" value="Close" onclick="javascript:window.close();" />
		</td>
		</tr>		
</table>
	
<s:hidden name="updatedBy" id="updatedBy" value="R"/>

</s:form>

</body>
</html>
