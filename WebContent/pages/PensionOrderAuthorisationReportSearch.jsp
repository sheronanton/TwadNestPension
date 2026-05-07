<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pension Order - Authorisation Report Search</title>
<link rel=StyleSheet href="<s:url value="/css/Sample3.css" />"
	type="text/css">
	
<script
	src="<s:url value="/javascript/PensionOrderAuthorisationReportSearch.js" />"
	type="text/javascript">
</script>
<script language=javascript>

function set(value)
{
	
document.getElementById("selectedradio").value=0;
document.getElementById("selectedradio").value=value;
document.getElementById("Submit").disabled=false;
}
function post_valueFamSrch(){
	
  	var mv=document.getElementById("radios").value;
	var rowcount=document.getElementById("rowcount").value;
	var sel_value=document.getElementById("selectedradio").value; 
	
	var emp_no_td_value=document.getElementById("employeeId"+sel_value).innerHTML;
	var emp_name_td_value=document.getElementById("employeeName"+sel_value).innerHTML;	

	document.getElementById("penOrderAuthorisationempNo").value=emp_no_td_value;

	opener.document.PensionOrderAuthorisationReport.empNo.value=emp_no_td_value;	
	opener.document.PensionOrderAuthorisationReport.empName.value=emp_name_td_value;
	opener.penOrderAuthorisationReportSearch(emp_no_td_value);	
	window.close();
	
}
</script>
<style type="text/css">
.fontss {
	font-family: Verdana;
	font-size: 12px;
}
</style>



</head>
<br>
<br>
<br>
<body>
<s:hidden name="selectedradio" id="selectedradio" />
<s:hidden name="rowcount" id="rowcount" />
<s:hidden name="radios" id="radios" />
<s:form action=""	name="" namespace="/pages">
	<table width="70%" align="center" border="1">
		<tr>
			<td colspan="4" background="../images/bluebg1.jpg" align="center"><font	color="white" size="3"><strong>Pension Order - Authorisation Report Search </strong></font></td>
		</tr>
		<tr>
			<td align="center" height="30" valign="middle">
			<s:select headerKey="" headerValue="-- Select --" id="penappreportSearchOptions" name="penorderAuthorisationReport.penappreportSearchOptions"
				list="#{'1':'Emp No','2':'Employee Name'}" theme="simple" cssStyle="border:#ffba14 1.5px solid"  onchange="javascript:cleanTbodyFai()" />&nbsp;&nbsp;
			<s:textfield  id="penappreportSearchKeyword" name="penorderAuthorisationReport.penappreportSearchKeyword" theme="simple"
				cssStyle="border:#ffba14 1.5px solid" />&nbsp;&nbsp; 
			<input type="button" id="Search" name="Search" Value="Search" onclick="penOrderAuthorisationReportSearch('Search');" />&nbsp;&nbsp;
			<input type="reset" id="btnClear" name="Clear" value="Clear" onclick="javascript:cleanTbodyFai()" />
			<s:hidden name="" id="penOrderAuthorisationempNo" theme="simple">
			</s:hidden>
  
	        </td>
		</tr>
		<tr>
			<td>
			<table border="0" width="100%" align="center" background="../images/button_bg.jpg">
				<tr>
					<td align="right" style="border-right:0px solid #FFFFFF !important;border-bottom:0px solid #FFFFFF !important;">Page&nbsp;Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select name="cmbpagination" id="cmbpagination"  
						onchange="changepagesize()">
						<option value="5" selected="selected">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
					</select> </td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>
			<table id="Existing" border="1" width="100%" cellspacing="0" cellpadding="0" class="border1">
				<tr>
					<th align="center" width="10%">Select</th>
					<th align="center" width="25%">Emp No</th>
					<th align="center" width="40%">Employee Name</th>
					</tr>
				<tbody id="tblList">
							
				</tbody>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan="4">
			<table align="center" cellspacing="0" cellpadding="2" border="0" width="100%" background="../images/button_bg.jpg">
				<tr>
					<td width="30%">
					<div align="left">
					<div id="divpre" style="display: none"></div>
					</div>
					</td>
					<td width="40%">
					<div align="center">
					<table border="0">
						<tr>
							<td>
							<div id="divcmbpage" style="display: none"><font
								color="Black" size="2"><strong> Page&nbsp;&nbsp;<select
								name="cmbpage" id="cmbpage" onchange="changepage()"></select></strong></font></div>
							</td>
							<td>
							<div id="divpage"></div>
							</td>
						</tr>
					</table>
					</div>
					</td>
					<td width="40%">
					<div align="right">
					<div id="divnext" style="display: none"></div>
					</div>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<br>
	<center>
<input type="button" name="Submit" id="Submit" value="Submit" onclick="post_valueFamSrch();" disabled="true" />
	<input type="button" name="Close" id="Cancel"
		value="Close" onclick="javascript:window.close()" /></center>
</s:form>
</body>
</html>

