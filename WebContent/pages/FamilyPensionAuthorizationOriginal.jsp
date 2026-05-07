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
	
<script type="text/javascript" src="../javascript/FamilyPensionAuthorizationOriginal.js"></script>
<script type="text/javascript" src="../javascript/PensionApplicationCommon.js"></script>
<title>Family Pension Authorization Letter (Original)</title>


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
<body onload="setRadio();">
<s:form name="pensionAuthorizationOriginal" action="familyPenAuthoriseSaveData" onsubmit="return checkAppSubmit();">
<table border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		<s:hidden id="hiddenDesigId" name="hiddenDesigId" theme="simple"/>
		<s:hidden id="hiddenDesigGrpId" name="hiddenDesigGrpId" theme="simple"/>
		<s:hidden id="hiddenEmpName" name="hiddenEmpName" theme="simple" />
		<s:hidden id="hiddenEmpGender" name="hiddenEmpGender" theme="simple" />
		<s:hidden id="hiddenOfficeId" name="hiddenOfficeId" theme="simple" />
		<s:hidden id="hiddenEmpDob" name="hiddenEmpDob" theme="simple" />
		
	<tr>
		<td colspan="4" background="../images/bluebg1.jpg"><font class="textHeader"><b>Family Pension Authorization Letter (Original)</b></font></td>		
	</tr>
	
	<tr>
		<td width="20%"><font class="bodyText" ><s:text name="label.empno" />&nbsp;<font color="red">*</font> </font></td>
		<td width="35%"><s:textfield name="penAppAuthOri.empNo" id="empNo" theme="simple" cssClass="textbox" maxlength="8" onblur="getMasterData(this.value);"  /> &nbsp;
		<input type="button" value="Fetch" onclick="javascript:window.open('FamilyPensionAuthorizationOriginalSearch.jsp','window','width=800,height=500,scrollbars=yes');" /></td>
	    <td width="20%"><font class="bodyText" ><s:text name="label.empname" />&nbsp;</font></td>
		<td width="25%" id="empNameLabelTD"><font class="bodyText" ><s:label name="empNameLabel" id="empNameLabel" theme="simple"  /></font>&nbsp;</td>			
	</tr>
	
	<tr>
		<td width="20%"></td>
		<td width="35%"></td>
	    <td width="20%"><font class="bodyText" ><s:label name="label.empname" value="Family Pensioner Initial & Name"/>&nbsp;</font></td>
		<td width="25%" id="empNameLabelTD"><font class="bodyText" >
		<s:textfield name="penAppAuthOri.empInitial" id="empInitial" theme="simple" cssClass="textbox" size="3"/><s:textfield name="penAppAuthOri.empName" id="empName" theme="simple" cssClass="textbox"/></font>&nbsp;</td>			
	</tr>
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.gender" /></font>&nbsp;</td>
		<td><font class="bodyText" ><s:label name="empGenderLabel" id="empGenderLabel" theme="simple"  /></font>&nbsp;</td>		
			<td><font class="bodyText" ><s:text name="label.dob" /></font>&nbsp;</td>
		<td ><font class="bodyText" ><s:label name="empDobLabel" id="empDobLabel" theme="simple"  /></font>&nbsp;</td>
	</tr>
	
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.designation" /></font>&nbsp;</td>
		<td><font class="bodyText" ><s:label name="designationLabel" id="designationLabel" theme="simple"  /></font>&nbsp;</td>	
		<td><font class="bodyText" ><s:text name="label.office" /></font>&nbsp;</td>
		<td ><font class="bodyText" ><s:label name="officeLabel" id="officeLabel" theme="simple"  /></font>&nbsp;</td>		
	</tr>
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.ppono" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textfield name="penAppAuthOri.ppoNo" id="ppoNo" theme="simple" cssClass="textbox" maxlength="8" onchange="javascript:ppoNoCheck(this);" /></td>
		<td><font class="bodyText" ><s:text name="label.gpono" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textfield name="penAppAuthOri.gpoNo" id="gpoNo" theme="simple" cssClass="textbox" maxlength="8" onchange="javascript:gpoNoCheck(this);" /></td>	
	</tr>
	
	
	
	
	<tr>
		<td>
		<font class="bodyText" ><s:text name="label.empResidential" /></font>&nbsp;</td>
		<td>
		<s:textarea name="penAppAuthOri.residentialAddress" id="empAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid" />
		<s:hidden name="penAppAuthOri.authorizedOfficerAddress" id="authOfficeAddress" />
		</td>
	
		<td>
		<font class="bodyText" >Name for From Address</font> <font color="red">*</font>&nbsp;</td>
		<td ><s:textfield name="penAppAuthOri.namefromAddress" id="nameforFromAddress" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
	
		
	</tr>
	
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.authofficer" /><font color="red">*</font></font>&nbsp;</td>
		<td>		
		<s:select id="authOfficer" name="penAppAuthOri.authorizedOfficer" onchange="fillfromAddress();" list="penAuthorisedOfficerList" listKey="authorisedOfficerId" listValue="authorisedOfficerDesc" headerKey="" headerValue="--Select--" theme="simple"  ></s:select>
		</td>
		<td><font class="bodyText" ><s:text name="label.fromaddress" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textarea name="penAppAuthOri.fromAddress" id="fromAddress" theme="simple" rows="3" cols="25" readonly="true" cssStyle="border:#ffba14 1.5px solid" /></td>		
		
	</tr>
	
	
	<tr>
	<td><font class="bodyText" >Service Book Address</font></td>
		<td><s:textarea name="penAppAuthOri.serviceBookAddress" id="serviceBookAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
		
		<td><font class="bodyText" ><s:text name="label.letterno" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textfield name="penAppAuthOri.letterNo" id="letterNo" theme="simple" cssClass="textbox" maxlength="95" size="30"/></td>		
	</tr>
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.penpayoffice" /> <font color="red">*</font></font>&nbsp;</td>
		<td><s:select id="paymentOfficeId" name="penAppAuthOri.paymentOfficeId" list="payOfficeList" listKey="currAccountOfficeId" listValue="currAccountOfficeName" headerKey="" headerValue="--Select--" theme="simple" onchange="javascript:loadOfficeAddress(this);" ></s:select> </td>
		<td><font class="bodyText" ><s:text name="label.lastworkoffice" /></font>&nbsp;</td>
		<td class="bodyText"><s:textarea name="penAppAuthOri.lastWorkOffice" id="OfficeId" rows="2" cols="20" onchange="javascript:loadOfficeAddress1(this);" theme="simple" cssStyle="border:#ffba14 1.5px solid" readonly="true"/>&nbsp; 
		<input type="button" value="Select Office" onclick="window.open('PensionAuthorizationLastWorkOffice.jsp','LastWorkingOffice','width=800,height=600,scrollbars=yes')"/>
		&nbsp; Closed <s:checkbox name="close" theme="simple" id="closed" disabled="true"/> 
			<s:hidden id="lastWorkingOfficeId" name="penAppAuthOri.lastWorkOfficeId" /></td>
			<s:hidden id="status" name="mstcutoffentry.closed" />
			<s:hidden name="lastWorkingOfficeLevel" id="lastWorkingOfficeLevel" theme="simple" />		
	</tr>
	
	<tr>
	<td><font class="bodyText" ><s:text name="label.penpayoffaddress" /></font>&nbsp;</td>
		<td><s:textarea name="penAppAuthOri.paymentOfficeAddress" id="paymentOfficeAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
		<td><font class="bodyText" ><s:text name="label.lastworkofficeadd" /></font>&nbsp;</td>
		<td ><s:textarea name="penAppAuthOri.lastWorkOfficeAddress" id="lastWorkOfficeAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
	</tr>
	
	<tr>
	<td><font class="bodyText" ><s:text name="label.datedon" /><font color="red">*</font></font>&nbsp;</td>
		
	<td><s:textfield name="penAppAuthOri.datedOn" id="datedOn" theme="simple" cssClass="textbox" maxlength="10" size="10" onkeyup="dtval(this,event)" />
		<img src="../images/calendr3.gif" id="cal-button-1" align="middle"/>
		<script type="text/javascript">
		  Calendar.setup({
              inputField    : "datedOn",
              button        : "cal-button-1",
              align         : "Tr"
            });
        </script>
		</td>	
		
		<td><font class="bodyText" ><s:text name="label.ref" /></font>&nbsp;</td>
		<td ><s:textarea name="penAppAuthOri.reference" id="reference" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
	
	</tr>	
	
	<tr>
	<td>
	<font class="bodyText" ><s:text name="label.nominname" /></font></td>
	<td><s:select list="{}" id="nomineeList" name="nomineeList" theme="simple" headerKey="" headerValue="--Select--" onchange="" /></td>
	
	<td><font class="bodyText" ><s:text name="label.relationship" /></font></td>
	<td><font class="bodyText" ><s:label id="nomineeRelationDescLabel" name="nomineeRelationDescLabel" theme="simple" /></font></td>
	<s:hidden id="nomineeName" name="penAppAuthOri.nomineeName" />
	<s:hidden id="nomineeId"  name="penAppAuthOri.nomineeId" />
	<s:hidden id="nomineeRelationId"  name="penAppAuthOri.nomineeRelationId"  />
	<s:hidden id="nomineeRelationDesc"  name="penAppAuthOri.nomineeRelationDesc"  />
	</tr>
	
	
		
</table>
	
	<center><font class="bodyText" ><s:radio name="saveStatus" id="saveStatus" list="#{'Draft':'Draft','Final':'Final'}" theme="simple" /></font><br />
	<br /><s:submit name="submit" id="submit" theme="simple" value="Submit"/>&nbsp;<s:reset name="clear" id="clear" value="Clear" theme="simple" onclick="clearAll();" />&nbsp;
	<input type="button" value="Close" onclick="javascript:window.close();"/></center>
</s:form>
</body>
</html>