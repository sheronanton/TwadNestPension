<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate - Pension Application Form 2</title>
<link rel=StyleSheet href="<s:url value="/css/Sample3.css" />"	type="text/css">
	
	
<script src="<s:url value="/javascript/PensionApplicationValidateForm2Search.js" />" type="text/javascript"> </script>

<script language="javascript">

function set(value)
{

document.getElementById("selectedradio").value=0;
document.getElementById("selectedradio").value=value;
postValue();
}

function postValue()
{

	var mv=document.getElementById("radios").value;
	var rowcount=document.getElementById("rowcount").value;
	var sel_value=document.getElementById("selectedradio").value; 
	
	var emp_no_td_value=document.getElementById("employeeId"+sel_value).innerHTML;
	var emp_name_td_value=document.getElementById("employeeName"+sel_value).innerHTML;
	var processStatus=document.getElementById("processStatus"+sel_value).innerHTML;
	document.getElementById("penAppValHiddenEmpId").value=emp_no_td_value;

		
}
</script>
<style type="text/css">
.fontss {
	font-family: Verdana;
	font-size: 16px;
}

.tableText
{
	font-family: Verdana;
	font-size: 15px;

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

<s:form action="PenAppForm2ValidDataLoad.html" name="" namespace="/pages">
	<table border="1" width="70%" align="center">
		<tr>
			<td  background="../images/bluebg1.jpg"><font
				color="white" size="4"><strong>Validate - Pension Application Form 2</strong></font></td>
		</tr>

		<tr>
			
			<td align="center">
			
			<s:select headerKey=""
				headerValue="-- Select --" id="SearchOptions" name="SearchOptions"
				list="#{'1':'Employee No','3':'Employee Name'}"
				theme="simple" cssStyle="border:#ffba14 1.5px solid"  onchange="javascript:cleanTbody()" />&nbsp;&nbsp;

			<s:textfield  id="SearchKeyword" name="SearchKeyword" theme="simple"
				cssStyle="border:#ffba14 1.5px solid" />&nbsp;&nbsp; 
			
			<input type="button" id="Search" name="Search" Value="Search"
				onclick="javascript:validateSearch('ValidateSearch')" />&nbsp;&nbsp;
			
			<input type="reset" id="btnClear" name="Clear" value="Clear" onclick="javascript:cleanTbody()" />
		
		<s:hidden name="penAppValHiddenEmpId" id="penAppValHiddenEmpId" />	
		</td>
		</tr>


		<tr>
			<td>
			<table border="1" width="100%" align="center"
				background="../images/button_bg.jpg">
				<tr>
					<td align="right">Page&nbsp;Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
					<th align="center" width="5%" >Edit</th>				
					<th align="center" width="10%" >Employee No</th>
					<th align="center" width="25%" >Employee Name</th>				
					<th align="center" width="25%" >Process Status</th>
				</tr>
				<tbody id="tblList">
				</tbody>
			</table>
			</td>
		</tr>
		
		<tr>
			<td>
			<table align="center" border="0"
				width="100%" background="../images/button_bg.jpg">
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
	<center><input type="submit" name="Submit" id="Submit" value="Submit" onclick="javascript:postValue();"/> 
	<input type="button" name="Close" id="Cancel" value="Close" onclick="javascript:window.close()" /></center>

</s:form>
</body>
</html>

