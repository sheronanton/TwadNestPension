<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate-Change Nominee Search</title>
<link rel="StyleSheet" href='<s:url value="/css/Sample3.css" />' type="text/css">

<script  src="<s:url value="/javascript/FamMstNomineeSearch.js" />" type="text/javascript">
</script>
<script language=javascript>
	function set(value)
	{
		document.getElementById("selectedradio").value=0;
		document.getElementById("selectedradio").value=value;
		
	}

	function post_value()
	{	
		var mv=document.getElementById("radios").value;
		var rowcount=document.getElementById("rowcount").value;
		var sel_value=document.getElementById("selectedradio").value;
		
		var ppono_td_value=document.getElementById("ppoNo"+sel_value).innerHTML;
		//var emp_no_td_value=document.getElementById("employeeId"+sel_value).innerHTML;
		//var emp_name_td_value=document.getElementById("employeeName"+sel_value).innerHTML;		
		
		opener.document.FamValidateChangeNominee.ppoNo.value=ppono_td_value;
		//opener.document.FamValidateChangeNominee.EmpId.value=emp_no_td_value;
	    //opener.document.FamValidateChangeNominee.EmpName.value=emp_name_td_value;
	    
	    opener.loadChangedNominee(ppono_td_value);
		window.close();
	    
			
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

<script type="text/javascript">

function checkSelect()
{
		var count=0;
			for(var i=0;i<document.forms[0].elements.length;i++)
			{
				if(document.forms[0].elements[i].type=="radio")
             	count++;
			}
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
<body>
<s:hidden name="selectedradio" id="selectedradio" />
<s:hidden name="rowcount" id="rowcount" />
<s:hidden name="radios" id="radios" />

<s:form name="frm" action="editCutOfEntryPension.html"
	namespace="/pages">
	<table border="1" width="70%" align="center">
		<tr>
			<td colspan="4" background="../images/bluebg1.jpg"><font
				color="white" size="4"><strong>Validate-Change Nominee Search</strong></font></td>
		</tr>

		<tr>
			<td align="center"><s:select headerKey=""
				headerValue="-- Select --" id="options" name="options"
				list="#{'1':'PPO NO','4':'Family Pensioner Name'}"
				theme="simple" cssStyle="border:#ffba14 1.5px solid" onchange="javascript:cleanTbodyFamNom()"  />&nbsp;&nbsp;
			<s:textfield name="searchText" id="searchText" theme="simple"
				cssStyle="border:#ffba14 1.5px solid" />&nbsp;&nbsp; <input type="button" id="Search" name="Search" Value="Search" onclick="javascript:famValSearchNom('ChangedSearch')"/>&nbsp;&nbsp; <input
				type="reset" id="btnClear" name="Clear" value="Clear"  onclick="javascript:cleanTbodyFamNom()" /> <s:hidden
				name="searchPpoNo" id="searchPpoNo" theme="simple" /></td>
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
					</select></td>
				</tr>
			</table>
			</td>
		</tr>


		<tr>
			<td>
			<table id="Existing" border="0" width="100%" cellspacing="0"
				cellpadding="2" class="border1">
				<tr>
                    <th align="center" width="5%">Edit</th>
					<th align="center" width="10%">PPO NO</th>					
					<th align="center" width="25%">Family Pensioner Name</th>					
				</tr>
				<tbody id="tblList">
				</tbody>
			</table>
			</td>
		</tr>

		<tr>
			<td>
			<table align="center" border="0" width="100%"
				background="../images/button_bg.jpg">
				<tr>
					<td>
					<div align="left">
					<div id="divpre" style="display: none"></div>
					</div>
					</td>

					<td align="center">
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

					<td>
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
	<center><input type="button" id="btnSelect" name="select" Value="Select" onclick ="javascript:post_value()"/>&nbsp; 
		<!--<s:submit value="Edit" theme="simple" onclick="checkSelect()"></s:submit>
		 -->
		<input	type="button" name="Cancel" id="Cancel" value="Close" onclick="javascript:window.close()" /></center>
</s:form>


</body>
</html>

