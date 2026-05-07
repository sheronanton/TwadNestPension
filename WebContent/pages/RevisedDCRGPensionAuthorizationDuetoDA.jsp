<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<s:url value="/css/PensionApplication.css"/>" type="text/css" />


	<script type="text/javascript" src="../javascript/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="../javascript/ui.core.js"></script>
	<script type="text/javascript" src="../javascript/ui.tabs.js"></script>	
	<script type="text/javascript" src="../javascript/calendar.js"></script>
    <script type="text/javascript" src="../javascript/calendar-setup.js"></script>
    <script type="text/javascript" src="../javascript/calendar-en.js"></script>
    <script type="text/javascript" src="../javascript/calender-cust.js"></script>
   
   	<link type="text/css" href="../styles/calendar-win2k-cold-1.css" rel="stylesheet" />
	<link type="text/css" href="../styles/demos.css" rel="stylesheet" />
	<link type="text/css" href="../styles/default.css" rel="stylesheet" />
	<link type="text/css" href="../styles/ui.all.css" rel="stylesheet" />
	
<script type="text/javascript" src="../javascript/RevisedDCRGPensionAuthorizationDuetoDa.js"></script>
<script type="text/javascript" src="../javascript/PensionApplicationCommon.js"></script>
<title>Revised DCRG Pension Authorisation Due to DA</title>


<style type="text/css">
table.border1 
{
	border-top:1px solid #ffffff;
	border-left:1px solid #ffffff;
	border-bottom:0px solid #ffffff;
	border-right:0px solid #ffffff;
}
table.border1 td,th
{
	border-top:0px solid #ffffff;
	border-left:0px solid #ffffff;
	border-bottom:1px solid #ffffff;
	border-right:1px solid #ffffff;
	padding:5px;		
}

</style>

</head>
<body onload="fillfromAddress();" >
<s:form name="revisedDCRGPensionAuthorization" action="revisedDCRGPensionfreeze" method="POST" >
<table border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		
		<tr>
		<td>
		<s:hidden name="revisedPenAppAuthOri.empNo" id="empNo"  theme="simple" cssClass="readonlytext" value="%{HiddenSelectedNo}"  />
		<s:hidden name="revisedPenAppAuthOri.ppoNo" id="ppoNo"  theme="simple" cssClass="readonlytext" value="%{empppono}"  />
		<s:hidden name="revisedPenAppAuthOri.gpoNo" id="gpoNo"  theme="simple" cssClass="readonlytext" value="%{empgpono}"  />
		<s:hidden name="revisedPenAppAuthOri.lastWorkOffice" id="lastWorkOffice"  theme="simple" cssClass="readonlytext" value="%{lastworkoffiaddress}"  />
		<s:hidden name="revisedPenAppAuthOri.lastWorkOfficeId" id="lastWorkOfficeId"  theme="simple" cssClass="readonlytext" value="%{empOfficeid}"  />
		<s:hidden name="revisedPenAppAuthOri.paymentOfficeId" id="paymentOfficeId"  theme="simple" cssClass="readonlytext" value="%{paymentOfficeid}"  />
		<s:hidden name="revisedPenAppAuthOri.paymentOfficeAddress" id="paymentOfficeAddress"  theme="simple" cssClass="readonlytext" value="%{paymentofficeaddress}"  />
		</td>
		
		</tr>
	<tr>
		<td colspan="4" background="../images/bluebg1.jpg"><font class="textHeader"><b>Revised DCRG Pension Authorisation Due to DA </b></font></td>		
	</tr>
	
	<tr>
		<td width="20%"><font class="bodyText" ><s:text name="label.empno" /></font>&nbsp;</td>
		
		<td width="35%" ><font class="bodyText" ><s:property value="empNo" id="empNo" /></font> &nbsp;
		</td>
	    <td width="20%"><font class="bodyText" ><s:text name="label.empname" />&nbsp;</font></td>
		<td width="25%" id="empNameLabelTD">
		<font class="bodyText" ><s:property value="empName" id="empName"  /></font>&nbsp;</td>			
	</tr>
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.gender" /></font>&nbsp;</td>
		<td><font class="bodyText" ><s:property value="empGenger" id="empGenger" /></font>&nbsp;</td>		
			<td><font class="bodyText" ><s:text name="label.dob" /></font>&nbsp;</td>
		<td ><font class="bodyText" ><s:property value="empdob" id="empdob" /></font>&nbsp;</td>
	</tr>
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.designation" /></font>&nbsp;</td>
		<td><font class="bodyText" ><s:property value="empDesignation" id="empDesignation" /></font>&nbsp;</td>	
		<td><font class="bodyText" ><s:text name="label.office" /></font>&nbsp;</td>
		<td ><font class="bodyText" ><s:property value="empOffice" id="empOffice" /></font>&nbsp;</td>		
	</tr>
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.ppono" /> </font>&nbsp;</td>
		<td ><font class="bodyText" ><s:property value="empppono" id="empppono" /></font></td>
		<td><font class="bodyText" ><s:text name="label.gpono" />&nbsp;</font></td>
		<td ><font class="bodyText" ><s:property value="empgpono" id="empgpono" /></font></td>	
	</tr>
	
	<tr>
		<td>
		<font class="bodyText" ><s:text name="label.empResidential" /></font>&nbsp;</td>
		<td>
		<s:textarea name="revisedPenAppAuthOri.residentialAddress" id="ResidentAddress"  theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid" value="%{ResidentAddress}" >
		</s:textarea>
		
		</td>
	
		<td>
		<font class="bodyText" >Name for From Address</font> <font color="red">*</font>&nbsp;</td>
		<td >
		<s:textfield name="revisedPenAppAuthOri.namefromAddress" id="namefromaddress" value="%{namefromaddress}"  theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
	
		
	</tr>
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.authofficer" /><font color="red">*</font></font>&nbsp;</td>
		<td>		
		<s:select id="authOfficer" name="revisedPenAppAuthOri.authorizedOfficer" value="authOfficer"  onchange="fillfromAddress();" list="penAuthorisedOfficerList" listKey="authorisedOfficerId" listValue="authorisedOfficerDesc" headerKey="" headerValue="--Select--"   theme="simple"  ></s:select>
		</td>
		<td>
		<font class="bodyText" ><s:text name="label.fromaddress" /> <font color="red">*</font></font>&nbsp;</td>
		<td >
		<s:textarea name="revisedPenAppAuthOri.authorizedOfficerAddress" id="fromAddress" theme="simple" rows="3" cols="25"  cssStyle="border:#ffba14 1.5px solid" />
		<s:hidden name="revisedPenAppAuthOri.fromAddress" id="fromAddress1" theme="simple"   cssStyle="border:#ffba14 1.5px solid" />
		</td>		
		
	</tr>
	
		
	<tr>
		
		<td><font class="bodyText" >Pension Payment Office Name</font>&nbsp;</td>
		<td><font class="bodyText"><s:property value="paymentofficename" id="paymentofficename"  /></font></td>	
		<td><font class="bodyText" >Pension Payment Office Address</font>&nbsp;</td>
	    <td><font class="bodyText" ><s:property value="paymentofficeaddress" id="paymentofficeaddress"  /></font></td>
		
		
	</tr>
	<tr>
	<td><font class="bodyText" >Last Working Office </font>&nbsp;</td>
		<td><font class="bodyText"><s:property value="lastworkoffiaddress" id="lastworkoffiaddress"  /></font></td>	
		<td><font class="bodyText" >DCRG Working Office </font>&nbsp;</td>
		<td><font class="bodyText">
		<s:textarea name="revisedPenAppAuthOri.lastWorkOfficeAddress" id="lastworkoffiaddress"  value="%{lastworkoffiaddress}" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid" ></s:textarea></font></td>	
	
	</tr>
	
	<tr>
	<td><font class="bodyText" ><s:text name="label.letterno" /> <font color="red">*</font></font>&nbsp;</td>
	<td ><s:textfield name="revisedPenAppAuthOri.letterNo" id="letterNo" value="%{letterno}" theme="simple" cssClass="textbox" maxlength="95" size="30"/></td>		
	<td><font class="bodyText" ><s:text name="label.ref" /></font>&nbsp;</td>
	<td ><s:textarea name="revisedPenAppAuthOri.reference" id="reference"  value="%{reference}"  theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
	</tr>
	
	<tr>
	<td><font class="bodyText" >DCRG Already Sanctioned</font>&nbsp;</td>
	<td ><font class="bodyText" ><s:property value="olddcrgamount" id="olddcrgamount"/></font></td>		
	<td><font class="bodyText" >Sanctioned DCRG DA Percentage</font>&nbsp;</td>
	<td ><font class="bodyText" ><s:property value="empolddapercentage" id="empolddapercentage"/></font></td>		
	
	</tr>
	
	<tr>
	<td><font class="bodyText" >RevisedCalculatedDCRGAmount</font>&nbsp;</td>
	<td >
	<font class="bodyText" >(<s:property value="lasttotal" id="lasttotal"/>+<s:property value="newdaamount" id="newdaamount"/>)*(<s:property value="noofhalfyeardcrg" id="noofhalfyeardcrg"/>)*<s:property value="totdcrghalfyear" id="totdcrghalfyear"/>=
	<font class="bodyText" ><s:property value="revcaldcrgamt" id="revcaldcrgamt"/></font>
	</font></td>
	<td><font class="bodyText" >Now Revised DCRG DA Percentage</font>&nbsp;</td>		
	<td><font class="bodyText" ><s:label name="newdapercentage" id="newdapercentage"/></font>
	</td>	
	</tr>
	<tr>
	</tr>
	<tr>
	<td>
	<font class="bodyText" >Dated On<font color="red">*</font></font>&nbsp;</td>
		
	<td><s:textfield name="revisedPenAppAuthOri.datedOn" id="datedOn" theme="simple" cssClass="textbox" maxlength="10" size="10" onkeyup="dtval(this,event)" />
		<img src="../images/calendr3.gif" id="cal-button-1" align="middle"/>
		<script type="text/javascript">
		  Calendar.setup({
              inputField    : "datedOn",
              button        : "cal-button-1",
              align         : "Tr"
            });
        </script>
		</td>	
		
	</tr>
		
	</table>
	<center>
	<table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
	<tr align="center">
	<td><font class="bodyText" ><s:radio name="saveStatus" id="saveStatus" list="#{'Draft':'Draft','Final':'Final'}" theme="simple" onclick="return setRadio();" /></font></td>
	</tr>
	</table>
	</center>
	<div id="showselect" style="DISPLAY:none">
		    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		    <tr class="bodyText">
			<td align="left" width="30%"><font class="bodyText">Select Pension Order Report</font></td>
			<td align="left" width="50%">
			<s:select list="#{'1':'Revised DCRG Order','2':'Revised DCRG note'}" headerKey="" headerValue="--Select--" id="reportformId" name="reportform" />							
			</td>
			</tr>	
			</table>
	<center>
				<br />
				<br /><input type="button" value="Print" onclick="javascript:GenReport()"/>&nbsp;
				</center>
    </div>
    <div id="showfinalshow" style="DISPLAY:none">
	    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
	    </table>
	<center>
	<br />
	<br /><s:submit value="freeze" name="submit" id="submit" theme="simple" onclick="return validation();"/>&nbsp;
	</center>
    
    </div>
    <center>
    <br/>
    <input type="button" value="Close" onclick="javascript:window.close();"/>
    </center>
	
	
</s:form>

</body>
</html>