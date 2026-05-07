<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Last Working Office</title>

<link rel=StyleSheet href="<s:url value="/css/Sample3.css" />" type="text/css" >
<script type="text/javascript" src="../javascript/LastWorkingOffice.js"></script>

<script language="javascript">

function set(value)
{
	
document.getElementById("selectedradio").value=0;
document.getElementById("selectedradio").value=value;
 
}

function post_value(){

var mv=document.getElementById("radios").value;
var rowcount=document.getElementById("rowcount").value;
var sel_value=document.getElementById("selectedradio").value; 
//alert(document.getElementById("selectedradio").value)

var office_td_value=document.getElementById("office"+sel_value).innerHTML;
var level_td_value=document.getElementById("level"+sel_value).innerHTML;
var status_td_value=document.getElementById("status"+sel_value).innerHTML;
var officeid_td_value=document.getElementById("officeid"+sel_value).innerHTML;
//var levelid_td_value=document.getElementById("levelid"+sel_value).innerHTML;

if(level_td_value=='Division')
{		
		opener.document.forms[0].lastWorkingOfficeLevel.value='DN';	
}

else if(level_td_value=='Lab')
{
	opener.document.forms[0].lastWorkingOfficeLevel.value='LB';
}

else if(level_td_value=='Audit Wing')
{
	opener.document.forms[0].lastWorkingOfficeLevel.value ='AW';
}

else if(level_td_value=='Circle')
{
	opener.document.forms[0].lastWorkingOfficeLevel.value ='CL';
}

else if(level_td_value=='H.O.')
{
	opener.document.forms[0].lastWorkingOfficeLevel.value ='HO';
}

else if(level_td_value=='Region')
{
	opener.document.forms[0].lastWorkingOfficeLevel.value ='RN';
}

else if(level_td_value=='Sub-Division')
{
	opener.document.forms[0].lastWorkingOfficeLevel.value ='SD';
}

else 
{
	opener.document.forms[0].lastWorkingOfficeLevel.value ='SN';
}

opener.document.forms[0].lastWorkingOfficeId.value =officeid_td_value;


opener.loadOfficeAddress1(officeid_td_value);


//alert('check'+officeid_td_value);
//var res=office_td_value+","+level_td_value+","+status_td_value;

var res=office_td_value;
opener.document.forms[0].OfficeId.value =res;



if(status_td_value=="Closed")
{
	opener.document.getElementById("status").value="true";
}
else
{
	opener.document.getElementById("status").value="false";
}

//alert("--"+level_td_value+"--")

	if (status_td_value=="Closed")
	{
		opener.document.forms[0].closed.checked=true;
		opener.document.forms[0].closed.disabled=true;
		
	}

	else
		opener.document.forms[0].closed.checked=false;
		self.close();


if (status_td_value=="Closed")
{
	opener.document.forms[0].currAccountOfficeId.selectedIndex=0;
	opener.document.forms[0].currAccountOfficeId.disabled=false;
	
}
else{
	
	opener.document.forms[0].currAccountOfficeId.selectedIndex=0;
	opener.document.forms[0].currAccountOfficeId.disabled=true;
}
}

</script>


<script type="text/javascript">

function stopRKey(evt) {
	
  var evt = (evt) ? evt : ((event) ? event : null);
  var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
  if ((evt.keyCode == 13) && (node.type=="text"))  {return false;}
}

document.onkeypress = stopRKey;

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
<!--
onload="callServer('Get')"
-->
<body>

<table border="1" width="70%" align="center">
	<tr bgcolor="#BCC0C4">
		<td  background="../images/bluebg1.jpg"><font
			color="white" size="4"><strong>Last Working Office</strong></font></td>
	</tr>
	<tr align="center">
		<s:form name="frm" action="" namespace="/pages">
			<td colspan="4"><s:select name="searchOption" id="searchOption"
				list="#{'1':'Office Id','2':'Office Name','3':'Status','4':'Level'}"
				headerKey="0" headerValue="--Select--" theme="simple"
				cssStyle="border:#ffba14 1.5px solid" onchange="cleanTbodyOffice();"/>&nbsp;&nbsp; 
				<s:textfield name="searchKeyword" id="searchKeyword" theme="simple"
				cssStyle="border:#ffba14 1.5px solid" />&nbsp;&nbsp; 
				<input type="button" id="btnSearch" name="Search" Value="Search"
				onclick="javascript:callServer1('search')">&nbsp;&nbsp; 
				<input type="reset" id="btnClear" name="Clear" value="Clear" onclick="cleanTbodyOffice();"/></td>
		</s:form>
	</tr>

	<tr>
		<td>
		<table border="0" width="100%"  background="../images/button_bg.jpg">
			<tr>

				<td colspan="2" align="right">
				Page&nbsp;Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select
					name="cmbpagination" id="cmbpagination" onchange="changepagesize()">
					<option value="5" selected="selected">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
				</select></td>
			</tr>
		</table>
		</td>
	</tr>

<tr>
	<td>
		
		<table id="Existing" border="1" width="100%" cellspacing="0" align="center" class="border1">
		<tr background="../images/button_bg.jpg">
			<th rowspan="2" align="center"><strong>Select</strong></th>
			<th rowspan="2" align="center"><strong>Office ID</strong></th>
			<th rowspan="2" align="center"><strong>Office Name</strong></th>
			<th rowspan="2" align="center"><strong>Status</strong></th>
			<th rowspan="2" align="center"><strong>Level</strong></th>
		</tr>
		
		<tbody id="tblList">
		</tbody>
		</table>
	</td>
</tr>
		
		<tr>
			<td>
			<table align="center" cellspacing="0" cellpadding="2" border="0"  width="100%" style="background:url(../images/button_bg.jpg) left top repeat-x;">
				<tr>
					<td width="30%">
						<div align="left">
							<div id="divpre" style="display:none"></div>
							</div>
					</td>
					
					<td width="40%" >
						<div align="center">
							<table>
								<tr>
									<td>
										<div id="divcmbpage" style="display:none"><font	size="2">Page&nbsp;&nbsp;
											<select	name="cmbpage" id="cmbpage" onchange="changepage()"></select></font>
										</div>
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

	<table align="center">
		<tr>
			<td colspan="4"><input type="button" id="btnSelect"
				name="select" Value="Select" onclick="post_value();" /> <input
				type="button" id="btnClear" name="Close" value="Close"
				onclick="javascript:window.close();" /></td>
		</tr>
	</table>

	

<s:hidden name="selectedradio" id="selectedradio" />
<s:hidden name="rowcount" id="rowcount" />
<s:hidden name="radios" id="radios" />

</body>

</html>