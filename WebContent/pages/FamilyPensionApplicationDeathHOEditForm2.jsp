<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="label.fampenapphoedit" /></title>
	<s:head theme="ajax" />	
	<script type="text/javascript" src="../javascript/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="../javascript/ui.core.js"></script>
	<script type="text/javascript" src="../javascript/ui.tabs.js"></script>	
	<script type="text/javascript" src="../javascript/calendar.js"></script>
    <script type="text/javascript" src="../javascript/calendar-setup.js"></script>
    <script type="text/javascript" src="../javascript/calendar-en.js"></script>
    <script type="text/javascript" src="../javascript/calender-cust.js"></script>              
	<link type="text/css" href="../styles/calendar-win2k-cold-1.css" rel="stylesheet" />
	<link type="text/css" href="../styles/demos.css" rel="stylesheet" />
	<link type="text/css" href="../styles/ui.all.css" rel="stylesheet" />	
	<link rel="stylesheet" href="<s:url value="/css/PensionApplication.css"/>" type="text/css" />
		
	<script type="text/javascript" src="../javascript/FamilyPensionApplicationDeathDynamicGrid.js"></script>
	<script type="text/javascript" src="../javascript/FamilyPensionApplicationDeathHOForm2.js"></script>
	<script type="text/javascript" src="../javascript/PensionApplicationCommon.js"></script>
	<script type="text/javascript" src="../javascript/FamilyPensionApplicationDeathValidation.js"></script>
	
	
	<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
	});
	</script>


<script type="text/javascript">	
function disableEnterKey(e)
{
     var key;      
     if(window.event)
          key = window.event.keyCode; //IE
     else
          key = e.which; //firefox  
     return (key != 13);
}

</script>

</head> 

<body>
<br>
<s:form name="famPenAppHOEditForm2" action="famPenAppHoEditSaveData.html" method="POST"  namespace="/pages" onsubmit="javascript:return submitValidationCheck();" >

<div class="demo">
<div id="tab11" style="background-color:#E9F5F5">
 
<table border="1" align="center" width="100%" class="tableGrid"> 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4"><s:text name="label.fampenapphoedit" /></font></td>
		</tr>
		
		<tr>
			<td align="center" colspan="6">
			
			
				<font class="bodyText">				
				Employee No   </font> <font color="red" class="bodyTextBold" > * </font> : <s:textfield name="penEmpNo" id="penEmpNo" maxlength="10" theme="simple" cssClass="textbox" onchange="numchk(this);javascript:fetchMstData(this.value);">	</s:textfield>&nbsp;
				<input type="button" name="Select" value="Select" onclick="window.open('FamilyPensionApplicationDeathHOEditForm2Search.jsp','mywindow','width=800,height=500,scrollbars=yes')" /> &nbsp;
				<input type="button" name="Clear" value="Clear" onclick="javascript:clearAllData();" />				
			</td>			
		</tr>
		
		<tr bgcolor="#BCC0C4">
			<td colspan="6" align="center"><font class="textHeader"><strong><s:text name="label.empdetails" /></strong></font></td>
		</tr>
		
		
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.empno" /></font></td>
			<td width="15%">
				<s:hidden name="famPenAppHeadCo.empNo" id="empNo"  theme="simple" cssClass="readonlytext" />
				<s:label name="empNoLabel" id="empNoLabel" theme="simple" cssClass="bodyTextBold"></s:label>
			</td>		
			<td width="15%"><font class="bodyText"><s:text name="label.empname" /></font></td>
			<td width="20%"> <s:hidden name="empName" id="empName" theme="simple"  />
				<s:label name="empNameLabel" id="empNameLabel" theme="simple"  cssClass="bodyTextBold"></s:label>
			</td>		
			<td width="15%"><font class="bodyText"><s:text name="label.gender" /></font></td>
			<td width="20%" class="bodyText" ><s:radio name="gender" id="gender" list="#{'M':'Male','F':'Female'}" disabled="true" ></s:radio> 
				<s:hidden name="gender" id="hiddengender" />
			</td>				
		</tr>	
		
		<tr>
			<td><font class="bodyText"><s:text name="label.dob" /></font></td>
			<td ><s:label name="dobLabel" id="dobLabel" theme="simple" cssClass="bodyTextBold"></s:label></td>	
			<s:hidden id="dob" name="dob" />			
			<td><font class="bodyText"><s:text name="label.doj" /></font></td>
			<td><s:label name="dojLabel" id="dojLabel" theme="simple" cssClass="bodyTextBold"></s:label>
			<s:hidden id="doj" name="doj" />	
			</td>		
			<td><font class="bodyText"><s:text name="label.designation" /></font></td>
			<td><s:label name="designation" id="designation" theme="simple" cssClass="bodyTextBold"></s:label>
				<s:hidden name="desigId" id="desigId" />
				<s:hidden name="desigServiceGrp" id="desigServiceGrp" />
			</td>			
		</tr>	
		
		<tr>
			<td><font class="bodyText"><s:text name="label.grade" /></font></td>
			<td><s:label name="gradeLabel" id="gradeLabel" theme="simple"  cssClass="bodyTextBold" ></s:label>
				<s:hidden name="gradeId" id="grade" theme="simple" /></td>			
			<td><font class="bodyText"><s:text name="label.office" /></font></td>
			<td><s:label name="office" id="office"  theme="simple"  cssClass="bodyTextBold"></s:label>
				<s:hidden name="officeId" id="officeId" /></td>
			<td><font class="bodyText"><s:text name="label.religion" /></font></td>		
			<td><s:select name="famPenAppHeadCo.religionId" id="religionId" list="religionCombo" listKey="religionCode" listValue="religionName" headerKey="0" headerValue="--Select--" cssStyle="border:#ffba14 1.5px solid" /></td>
		</tr>
		
		<!--<tr>			
			<td><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td><s:textfield name="famPenAppHeadCo.nationality" id="nationality" theme="simple" cssClass="textbox" onchange="charOnly(this);" onblur="charOnly(this);" /></td>				
			<td><font class="bodyText"><s:text name="label.idmark1"  /></font></td>
			<td ><s:textarea name="famPenAppHeadCo.idMark1" id="idMark1" theme="simple" rows="3" cols="15" onchange="alphanumeric(this);" onblur="alphanumeric(this);" cssStyle="border:#ffba14 1.5px solid" /></td>		
			<td><font class="bodyText"><s:text name="label.idmark2" /></font></td>
			<td><s:textarea name="famPenAppHeadCo.idMark2" id="idMark2" theme="simple" rows="3" cols="15" onchange="alphanumeric(this);" onblur="alphanumeric(this);" cssStyle="border:#ffba14 1.5px solid" /></td>	
		</tr>
		
		-->
		
		<tr>			
			<td ><font class="bodyText"><s:text name="label.presentaddress" /></font> <font color="red" class="bodyTextBold" > *</font> </td>
			<td ><s:textarea name="famPenAppHeadCo.presentAddress" id="presentAddress" theme="simple" rows="3" cols="15" cssStyle="border:#ffba14 1.5px solid" /></td>				
			<td ><font class="bodyText"><s:text name="label.state" /></font></td>
			<td><s:select name="famPenAppHeadCo.stateId" id="stateId" list="stateList" listKey="stateId" listValue="stateName" headerKey="0" headerValue="--Select--" cssStyle="border:#ffba14 1.5px solid" /></td>		
			<td><font class="bodyText"><s:text name="label.penpayoffice" /></font> <font color="red" class="bodyTextBold" > *</font> </td>
			<td ><s:select name="famPenAppHeadCo.paymentOfficeId" id="paymentOfficeId" list="payOfficeList" listKey="currAccountOfficeId1" listValue="currAccountOfficeName" headerKey="0" headerValue="--Select--"  cssStyle="border:#ffba14 1.5px solid" /></td>	
		</tr>
		
		<tr>			
			<td><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td><s:textfield name="famPenAppHeadCo.nationality" id="nationality" theme="simple" cssClass="textbox" onchange="charOnly(this);" onblur="charOnly(this);"  /></td>				
			<td>&nbsp;</td>
			<td >&nbsp;</td>		
			<td>&nbsp;</td>
			<td>&nbsp;</td>	
		</tr>
		
		
</table>
	
</div>
 


<div id="tabs" style="background-color:#FFEEBA">
	<ul>
		<li><a href="#tabs-1">Claiment Details</a></li>				
		<li><a href="#tabs-2">Nominee Details</a></li>			
	</ul>
	
	<div id="tabs-1" style="background-color: #E9F5F5;">	
		<table border="1" align="center" width="100%" class="tableGrid">	
		
		<tr>					
			<td width="20%"><font class="bodyText"><s:text name="label.claimentname" /></font> <font color="red" class="bodyTextBold" > *</font> </td>
			<td width="15%"><s:textfield name="famPenAppHeadCo.claimentName" id="claimentName" maxlength="40" theme="simple" cssClass="textbox" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.claimentdob" /></font></td>
			<td width="15%">
			<s:textfield name="famPenAppHeadCo.claimentDob1" id="claimentDob" onblur="return CheckDate(this);" onchange="return CheckDate(this);"  maxlength="10" size="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
			<img src="../images/calendr3.gif" id="cal-button-1" align="middle" />					
			 <script type="text/javascript">
            Calendar.setup({
              inputField    : "claimentDob",
              button        : "cal-button-1",
              align         : "Tr"
            });

          </script>
			
			</td>			
			<td width="20%"><font class="bodyText"><s:text name="label.claimentage" /></font></td>
			<td width="15%"><s:textfield name="famPenAppHeadCo.claimentAge" id="claimentAge" maxlength="3" size="3" onchange="numchk(this);" onblur="numchk(this);" theme="simple" cssClass="textbox" /></td>	
			
		</tr>
		
		
		<tr>					
			<td width="20%"><font class="bodyText"><s:text name="label.idmark1" /></font> <font color="red" class="bodyTextBold" > *</font> </td>
			<td width="15%"><s:textarea name="famPenAppHeadCo.idMark1" id="idMark1" theme="simple" rows="3" cols="15" onchange="alphanumeric(this);" onblur="alphanumeric(this);" cssStyle="border:#ffba14 1.5px solid" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.idmark2" /></font></td>
			<td width="15%"><s:textarea name="famPenAppHeadCo.idMark2" id="idMark2" theme="simple" rows="3" cols="15" onchange="alphanumeric(this);" onblur="alphanumeric(this);" cssStyle="border:#ffba14 1.5px solid" /></td>			
			<td width="20%"><font class="bodyText">Height</font></td>
			<td width="15%"><s:textfield name="famPenAppHeadCo.height" id="height" value="%{fpenappdeathco.height}" size="3" theme="simple" cssClass="textbox" /></td>	
			
		</tr>
		
		
		<tr>	
			<td width="20%"><font class="bodyText"><s:text name="label.guardianname" /></font></td>
			<td width="15%"><s:textfield name="famPenAppHeadCo.guardianName" id="guardianName" maxlength="" theme="simple" cssClass="textbox" /></td>				
			<td width="20%"><font class="bodyText"><s:text name="label.guardiandob" /></font></td>
			<td width="15%">
			<s:textfield name="famPenAppHeadCo.guardianDob1" id="guardianDob" onblur="return CheckDate(this);" onchange="return CheckDate(this);"  maxlength="10" theme="simple" size="10" cssClass="textbox" onkeyup="dtval(this,event);"  />
			<img src="../images/calendr3.gif" id="cal-button-2" align="middle" />					
			 <script type="text/javascript">
            Calendar.setup({
              inputField    : "guardianDob",
              button        : "cal-button-2",
              align         : "Tr"
            });
          </script>
			
			</td>					
			<td width="20%"><font class="bodyText"><s:text name="label.guardrelation" /></font></td>
			<td width="15%"><s:textfield name="famPenAppHeadCo.guardianRelationMinor" id="guardianRelationMinor" maxlength="40" theme="simple" cssClass="textbox" /></td>							
										
		</tr>
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.guardianrelation" /></font></td>
			<td width="15%"><s:textfield name="famPenAppHeadCo.guardianRelationEmp" id="guardianRelationEmp" maxlength="40" theme="simple" cssClass="textbox" /></td>
			<td width="20%"><font class="bodyText"><s:text name="label.empdeathdate" /></font> <font color="red" class="bodyTextBold" > *</font> </td>
			<td width="15%"><s:textfield name="famPenAppHeadCo.employeeDeathDate1" id="employeeDeathDate"  onblur="return CheckDate(this);" onchange="return CheckDate(this);" maxlength="10" size="10"  theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
			<img src="../images/calendr3.gif" id="cal-button-3" align="middle" />					
			 <script type="text/javascript">
            Calendar.setup({
              inputField    : "employeeDeathDate",
              button        : "cal-button-3",
              align         : "Tr"
            });
          </script>
			
			</td>
			<td width="20%"><font class="bodyText"><s:text name="label.claimentguardaddress" /></font></td>
			<td width="15%"><s:textarea name="famPenAppHeadCo.address" id="address" theme="simple" rows="3" cols="15" cssStyle="border:#ffba14 1.5px solid" /></td>			
		</tr>
			
				
			</table>
	</div>
	
	
	
	
	
	
	<div id="tabs-2" style=" background-color: #E9F5F5">	
		<table border="0" align="center" width="100%">			
			
		<tr>
				<td colspan="6">
				<table border="1" align="center" width="100%" class="tableGrid" >
					<tr bgcolor="#BCC0C4">						
						<th width="5%" align="center"><font class="bodyText"><s:text name="label.initial" /></font></th>
						<th width="15%" align="center"><font class="bodyText"><s:text name="label.familymembers" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.relationship" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.dob" /></font></th>
						<th width="5%" align="center"><font class="bodyText"><s:text name="label.age" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.handicapped" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.martialstatus" /></font></th>						
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.nomindate" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.active" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.nominaddress" /></font></th>						
						<th width="5%" align="center"><font class="bodyText"><s:text name="label.delete" /></font></th>					
					</tr>
					
					<tbody id="addNewNominee"></tbody>
					
				</table>
				</td>
			</tr>
			
			<tr>
				<td colspan="6" align="center"><input type="button" value="Add New" onclick="javascript:addDcrgNomineeGrid();"> </td>
			</tr>
			
		
		</table>
	</div>
		
	
	
 	</div>
 	
</div>

	<div align="center">
		
		<input type="submit"  value=" Submit " class="btn"/>&nbsp;
		<input type="button" name="cmdCancel" value=" Exit " class="btn" onclick="javascript:window.close()" />
</div>

</s:form>

</body>
</html>
