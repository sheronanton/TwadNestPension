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
	
<script type="text/javascript" src="../javascript/RevisedPensionAuthorization.js"></script>
<script type="text/javascript" src="../javascript/PensionApplicationCommon.js"></script>
<title>Revised Pension Authorisation</title>


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
<body>
<s:form name="revisedPensionAuthorization" action="revisedPenAuthoriseSaveData" method="POST" onsubmit="return checkAppSubmit();">
<table border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		<s:hidden id="hiddenDesigId" name="hiddenDesigId" theme="simple"/>
		<s:hidden id="hiddenDesigGrpId" name="hiddenDesigGrpId" theme="simple"/>
		<s:hidden id="hiddenEmpName" name="hiddenEmpName" theme="simple" />
		<s:hidden id="hiddenEmpGender" name="hiddenEmpGender" theme="simple" />
		<s:hidden id="hiddenOfficeId" name="hiddenOfficeId" theme="simple" />
		<s:hidden id="hiddenEmpDob" name="hiddenEmpDob" theme="simple" />
		
	<tr>
		<td colspan="4" background="../images/bluebg1.jpg"><font class="textHeader"><b>Revised Pension Authorisation</b></font></td>		
	</tr>
	
	<tr>
		<td width="20%"><font class="bodyText" ><s:text name="label.empno" />&nbsp;<font color="red">*</font> </font></td>
		<td width="35%"><s:textfield name="revisedPenAppAuthOri.empNo" id="empNo" theme="simple" cssClass="textbox" maxlength="8" onblur="getMasterData(this.value);"  /> &nbsp;
		<input type="button" value="Fetch" onclick="javascript:window.open('RevisedPensionAuthorizationSearch.jsp','RevisedPensionAuthorizationSearch','width=800,height=500,scrollbars=yes');" /></td>
	    <td width="20%"><font class="bodyText" ><s:text name="label.empname" />&nbsp;</font></td>
		<td width="25%" id="empNameLabelTD"><font class="bodyText" ><s:label name="empNameLabel" id="empNameLabel" theme="simple"  /></font>&nbsp;</td>			
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
		<td><font class="bodyText" ><s:label name="officeLabel" id="officeLabel" theme="simple"  /></font>&nbsp;</td>		
	</tr>
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.ppono" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textfield name="revisedPenAppAuthOri.ppoNo" id="ppoNo" theme="simple" cssClass="textbox" maxlength="8" onchange="javascript:ppoNoCheck(this);" /></td>
		<td><font class="bodyText" ><s:text name="label.gpono" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textfield name="revisedPenAppAuthOri.gpoNo" id="gpoNo" theme="simple" cssClass="textbox" maxlength="8" onchange="javascript:gpoNoCheck(this);" /></td>	
	</tr>
	
	
	
	
	<tr>
		<td>
		<font class="bodyText" ><s:text name="label.empResidential" /></font>&nbsp;</td>
		<td>
		<s:textarea name="revisedPenAppAuthOri.residentialAddress" id="empAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid" />
		<s:hidden name="revisedPenAppAuthOri.authorizedOfficerAddress" id="authOfficeAddress" />
		</td>
	
		<td>
		<font class="bodyText" >Name for From Address</font> <font color="red">*</font>&nbsp;</td>
		<td ><s:textfield name="revisedPenAppAuthOri.namefromAddress" id="nameforFromAddress" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
	
		
	</tr>
	
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.authofficer" /><font color="red">*</font></font>&nbsp;</td>
		<td>		
		<s:select id="authOfficer" name="revisedPenAppAuthOri.authorizedOfficer" onchange="fillfromAddress();" list="penAuthorisedOfficerList" listKey="authorisedOfficerId" listValue="authorisedOfficerDesc" headerKey="" headerValue="--Select--" theme="simple"  ></s:select>
		</td>
		<td><font class="bodyText" ><s:text name="label.fromaddress" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textarea name="revisedPenAppAuthOri.fromAddress" id="fromAddress" theme="simple" rows="3" cols="25" readonly="true" cssStyle="border:#ffba14 1.5px solid" /></td>		
		
	</tr>
	
	
	<tr>
	<td><font class="bodyText" >Service Book Address</font></td>
		<td><s:textarea name="revisedPenAppAuthOri.serviceBookAddress" id="serviceBookAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
		
		<td><font class="bodyText" ><s:text name="label.letterno" /> <font color="red">*</font></font>&nbsp;</td>
		<td ><s:textfield name="revisedPenAppAuthOri.letterNo" id="letterNo" theme="simple" cssClass="textbox" maxlength="95" size="30"/></td>		
	</tr>
	
	
	<tr>
		<td><font class="bodyText" ><s:text name="label.penpayoffice" /> <font color="red">*</font></font>&nbsp;</td>
		<td><s:select id="paymentOfficeId" name="revisedPenAppAuthOri.paymentOfficeId" list="payOfficeList" listKey="currAccountOfficeId" listValue="currAccountOfficeName" headerKey="" headerValue="--Select--" theme="simple" onchange="javascript:loadOfficeAddress(this);" ></s:select> </td>
		<td><font class="bodyText" ><s:text name="label.lastworkoffice" /></font>&nbsp;</td>
		<td class="bodyText"><s:textarea name="revisedPenAppAuthOri.lastWorkOffice" id="OfficeId" rows="2" cols="20" onchange="javascript:loadOfficeAddress1(this);" theme="simple" cssStyle="border:#ffba14 1.5px solid" readonly="true"/>&nbsp; 
		<input type="button" value="Select Office" onclick="window.open('PensionAuthorizationLastWorkOffice.jsp','LastWorkingOffice','width=800,height=600,scrollbars=yes')"/>
		&nbsp; Closed <s:checkbox name="close" theme="simple" id="closed" disabled="true"/> 
			<s:hidden id="lastWorkingOfficeId" name="revisedPenAppAuthOri.lastWorkOfficeId" /></td>
			<s:hidden id="status" name="mstcutoffentry.closed" />
			<s:hidden name="lastWorkingOfficeLevel" id="lastWorkingOfficeLevel" theme="simple" />		
	</tr>
	
	<tr>
	<td><font class="bodyText" ><s:text name="label.penpayoffaddress" /></font>&nbsp;</td>
		<td><s:textarea name="revisedPenAppAuthOri.paymentOfficeAddress" id="paymentOfficeAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
		<td><font class="bodyText" ><s:text name="label.lastworkofficeadd" /></font>&nbsp;</td>
		<td ><s:textarea name="revisedPenAppAuthOri.lastWorkOfficeAddress" id="lastWorkOfficeAddress" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
	</tr>
	
	<tr>
	<td><font class="bodyText" ><s:text name="label.datedon" /><font color="red">*</font></font>&nbsp;</td>
		
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
		
		<td><font class="bodyText" ><s:text name="label.ref" /></font>&nbsp;</td>
		<td ><s:textarea name="revisedPenAppAuthOri.reference" id="reference" theme="simple" rows="3" cols="25" cssStyle="border:#ffba14 1.5px solid"  /></td>
	
	</tr>	
	
	<tr>
	<td>
	<font class="bodyText" ><s:text name="label.nominname" /></font></td>
	<td><s:select list="{}" id="nomineeList" name="nomineeList" theme="simple" headerKey="" headerValue="--Select--" onchange="" /></td>
	
	<td><font class="bodyText" ><s:text name="label.relationship" /></font></td>
	<td><font class="bodyText" ><s:label id="nomineeRelationDescLabel" name="nomineeRelationDescLabel" theme="simple" /></font></td>
	<s:hidden id="nomineeName" name="revisedPenAppAuthOri.nomineeName" />
	<s:hidden id="nomineeId"  name="revisedPenAppAuthOri.nomineeId" />
	<s:hidden id="nomineeRelationId"  name="revisedPenAppAuthOri.nomineeRelationId"  />
	<s:hidden id="nomineeRelationDesc"  name="revisedPenAppAuthOri.nomineeRelationDesc"  />
	</tr>
	
	<tr>
		<td><font class="bodyText" ><s:text name="Pension Due to" /></font>&nbsp;</td>
		<td><font class="bodyText" >
			 <input type="radio" name="pen_option" id="pen_option" value="Revised_Pension" onchange="setOption()" checked="checked">Revised Pension <br>
            <input type="radio" name="pen_option" id="pen_option" value="OneMan_Commision" onchange="setOption()">One Man Commision <br>
            <input type="radio" name="pen_option" id="pen_option" value="Special_Grade" onchange="setOption()">3% Special Grade  <br>
             <input type="radio" name="pen_option" id="pen_option" value="Grade_pay" onchange="setOption()">Grade Pay Difference  
            <%-- <s:select list="#{'Revised_Pension':'Revised_Pension','OneMan_Commision':'OneMan_Commision','Special_Grade':'3% Special_Grade','Grade_pay':'Grade_pay_Difference'}" name="pen_option" id="pen_option" /> --%>
            </font>   
		</td>
	</tr>
	
	</table>
	<center>
	<table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
	
		
	<tr align="center">
	<td>
	<font class="bodyText" ><s:radio name="saveStatus" id="saveStatus" list="#{'Draft':'Draft','Final':'Final'}" theme="simple" onclick="return setCombobox();"/></font></td>
	
	</tr>
	</table>
	</center>
	<div id="showRevised_Pension" style="DISPLAY:none">
		    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		    <tr class="bodyText">
			<td align="left" width="30%"><font class="bodyText">Revised Pension Order Report</font></td>
			<td align="left" width="50%">
			<s:select list="#{'1':'Revised Pension Note','2':'Revised Pension Order','3':'Revised Pension DCRG'}" headerKey="" headerValue="--Select Any One--" id="reportformId" name="reportform" />							
			</td>
			</tr>	
			</table>
	<center>
				<br />
				<br />
				<input type="button" value="Save Form" onclick="javascript:saveasDraft()"/>&nbsp;
				<input type="button" value="Print Form" onclick="javascript:generateReport()"/>&nbsp;
				</center>
    </div>
    
    <div id="showOneMan_Commision" style="DISPLAY:none">
		    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		    <tr class="bodyText">
			<td align="left" width="30%"><font class="bodyText">OneMan Commision Order Report</font></td>
			<td align="left" width="50%">
			<s:select list="#{'1':'OneMan Commision Note','2':'OneMan Commision Order','3':'OneMan Commision DCRG'}" headerKey="" headerValue="--Select Any One--" id="reportform_onemanId" name="reportform_oneman" />							
			</td>
			</tr>	
			</table>
	<center>
				<br />
				<br />
				<input type="button" value="Save Form" onclick="javascript:saveasDraft()"/>&nbsp;
				<input type="button" value="Print Form" onclick="javascript:generateReport()"/>&nbsp;
				</center>
    </div>
    <div id="showSpl_grade" style="DISPLAY:none">
		    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		    <tr class="bodyText">
			<td align="left" width="30%"><font class="bodyText">3% Special Grade Order Report</font></td>
			<td align="left" width="50%">
			<s:select list="#{'1':'Special Grade Note','2':'Special Grade Order','3':'Special Grade DCRG'}" headerKey="" headerValue="--Select Any One--" id="reportform_SplgradeId" name="reportform_Splgrad" />							
			</td>
			</tr>	
			</table>
	<center>
				<br />
				<br />
				<input type="button" value="Save Form" onclick="javascript:saveasDraft()"/>&nbsp;
				<input type="button" value="Print Form" onclick="javascript:generateReport()"/>&nbsp;
				</center>
    </div>
     <div id="showgradepay" style="DISPLAY:none">
		    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		    <tr class="bodyText">
			<td align="left" width="30%"><font class="bodyText">Grade Pay Order Report</font></td>
			<td align="left" width="50%">
			<s:select list="#{'1':'Grade Pay Note','2':'Grade pay Order','3':'Grade Pay DCRG'}" headerKey="" headerValue="--Select Any One--" id="reportform_gradepayId" name="reportform_gradepay" />							
			</td>
			</tr>	
			</table>
	<center>
				<br />
				<br />
				<input type="button" value="Save Form" onclick="javascript:saveasDraft()"/>&nbsp;
				<input type="button" value="Print Form" onclick="javascript:generateReport()"/>&nbsp;
				</center>
    </div>
    <div id="showfinalshow" style="DISPLAY:none">
	    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
	    </table>
	<center>
	<br />
	<br /><s:submit value="Freeze Form" name="submit" id="submit" theme="simple" onclick="return validatebeforeFreeze();"/>&nbsp;
	</center>
    
    </div>
    <center>
    <br/>
    <input type="button" value="Close" onclick="javascript:window.close();"/>
    </center>
	
	
</s:form>

</body>
</html>