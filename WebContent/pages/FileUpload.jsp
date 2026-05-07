<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add - Pensioner File Uploading</title>
<script type="text/javascript" src="../javascript/PensionerFileValidation.js"></script>
<script type="text/javascript">

function preview()
{
	var path=document.getElementById("familyPhoto").value;
	
	
	if(path!="")
	{
	document.getElementById("family").style.display="block";
	document.getElementById("img").src=path;
	}
	
	var path1=document.getElementById("signatureDetails").value;	
	
	
	if(path1!="")
	{
	document.getElementById("sign").style.display="block";
	document.getElementById("img2").src=path1;
	}
	var path2=document.getElementById("otherDocuments").value;
	
	if(path2!="")
	{	
	document.getElementById("others").style.display="block";
	document.getElementById("img3").src=path2;
	}
}


</script>

	
</head>

<body>

	<s:form method="post" action="fileupload" enctype="multipart/form-data" namespace="/pages">
		<table border="0" align="center" width="70%" style="background-color: #DFE8E8">
			
			<tr bgcolor="#BCC0C4">
				<td colspan="4" background="../images/bluebg1.jpg"><font color="white" size="4">Add - Pensioner File Uploading</font></td>
			</tr>
			
			<tr>
				<td class="fontss">PPO NO <font color="red">*</font> </td>
				<td><s:textfield name="ppoNo" id="ppoNo" theme="simple" cssClass="textbox" size="8" />&nbsp; <input type="button" value="Select PPO NO" onclick="window.open('FileUploadSearch.jsp','a','width=800,height=500,scrollbars=yes')" />  </td>
			</tr>
						
			<tr>
				<td class="fontss">Family Photo <font color="red"></font> </td>
				<td><s:file name="familyPhoto" id="familyPhoto" size="30" onchange="preview();"></s:file></td>
			</tr>
			
			<tr>
				<td class="fontss">Signature Details <font color="red"></font> </td>
				<td><s:file name="signatureDetails" id="signatureDetails" size="30" onchange="preview();"></s:file></td>
			</tr>
			<tr>
				<td class="fontss">Other Documents<font color="red"></font> </td>
				<td><s:file name="otherDocuments" id="otherDocuments" size="30" onchange="preview();" ></s:file></td>
			</tr>
			
			<tr align="center">
				<td colspan="2"><s:submit value="submit" theme="simple" onclick="Checkfiles()"></s:submit>
				<s:reset value="reset" theme="simple"></s:reset></td>
			</tr>
			
					
		
			
</table>

<table align="center">
	<tr>
				<td>&nbsp;</td>
				<td align="center" style="text-align:center !important;padding-left:30px;padding-bottom:20px;">&nbsp;
				<div id="family" style="float:left;width:100px;padding:0 20px 0 20px;display:none;">
				<div style="height:30px;font-weight:bold;float:left;nowrap:nowrap;">Family&nbsp;Photo</div>
				<div id="familyimg" style="clear:both;">
				<img id="img" width="130" height="130">
				</div>
				</div>
				
				<div id="sign" style="float:left;width:100px;padding:0 20px 0 20px;display:none;">
				<div style="height:30px;font-weight:bold;float:left;nowrap:nowrap;">Signature&nbsp;Details</div>
				<div id="signatureimg" style="clear:both;">
				<img id="img2" width="130" height="130">
				</div>
				</div>
				
				<div id="others" style="float:left;width:100px;padding:0 20px 0 20px;display:none;">
				<div style="height:30px;font-weight:bold;float:left;nowrap:nowrap;">Others&nbsp;Documents</div>
				<div id="otherimg" style="clear:both;">
				<img id="img3" width="130" height="130">
				</div>
				</div>
				</td>
			</tr>
</table>

</s:form>
</body>
</html>