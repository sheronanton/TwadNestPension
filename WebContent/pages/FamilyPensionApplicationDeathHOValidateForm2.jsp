<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="label.fampenapphoval" /></title>
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


function setValue()
{
var gen=document.getElementById("hiddengender").value;
if(gen=="M")
{
	document.getElementById("genderM").checked=true;
}
if(gen=="F")
{
	document.getElementById("genderF").checked=true;
}

}

</script>


</head> 

<body onload="setValue();">
<br>
<s:form name="famPenAppHOValidateForm2" action="famPenAppHoValidateSaveData.html" method="POST"  namespace="/pages" onsubmit="javascript:return ValidateSubmitCheck();" >

<div class="demo">
<div id="tab11" style="background-color:#E9F5F5">
 
<table border="1" align="center" width="100%" class="tableGrid"> 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4"><s:text name="label.fampenapphoval" /></font></td>
		</tr>
		
			
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.empno" /></font></td>
			<td width="15%">
				<s:hidden name="famPenAppHeadVal.empNo" id="empNo" value="%{famPenAppMstdata.empNo}" theme="simple" cssClass="readonlytext" />
				<s:label name="empNoLabel" id="empNoLabel" value="%{famPenAppMstdata.empNo}" theme="simple" cssClass="bodyTextBold"></s:label>
			</td>		
			<td width="15%"><font class="bodyText"><s:text name="label.empname" /></font></td>
			<td width="20%"> <s:hidden name="empName" id="empName" value="%{famPenAppMstdata.empName}" theme="simple"   />
				<s:label name="empNameLabel" id="empNameLabel" value="%{famPenAppMstdata.empName}" theme="simple"   cssClass="bodyTextBold"></s:label>
			</td>		
			<td width="15%"><font class="bodyText"><s:text name="label.gender" /></font></td>
			<td width="20%" class="bodyText" ><s:radio name="gender" id="gender" value="%{famPenAppMstdata.gender}" list="#{'M':'Male','F':'Female'}" disabled="true" ></s:radio> 
				<s:hidden name="gender" id="hiddengender" value="%{famPenAppMstdata.gender}" />
			</td>				
		</tr>	
		
		<tr>
			<td><font class="bodyText"><s:text name="label.dob" /></font></td>
			<td ><s:label name="dobLabel" id="dobLabel" value="%{famPenAppMstdata.dob2}" theme="simple" cssClass="bodyTextBold"></s:label></td>	
			<s:hidden id="dob" name="dob" value="%{famPenAppMstdata.dob2}" />			
			<td><font class="bodyText"><s:text name="label.doj" /></font></td>
			<td><s:label name="dojLabel" id="dojLabel" value="%{famPenAppMstdata.doj2}" theme="simple" cssClass="bodyTextBold"></s:label>
			<s:hidden id="doj" name="doj" value="%{famPenAppMstdata.doj2}" />	
			</td>		
			<td><font class="bodyText"><s:text name="label.designation" /></font></td>
			<td><s:label name="designation" id="designation" value="%{famPenAppMstdata.designation}" theme="simple" cssClass="bodyTextBold"></s:label>
				<s:hidden name="desigId" id="desigId" value="%{famPenAppMstdata.desigId}"/>
				<s:hidden name="desigServiceGrp" id="desigServiceGrp" value="%{famPenAppMstdata.desigServiceGrp}" />
			</td>			
		</tr>	
		
		<tr>
			<td><font class="bodyText"><s:text name="label.grade" /></font></td>
			<td><s:label name="gradeLabel" id="gradeLabel" theme="simple"  value="%{famPenAppMstdata.grade}" cssClass="bodyTextBold" ></s:label>
				<s:hidden name="gradeId" id="grade" theme="simple" value="%{famPenAppMstdata.grade}" /></td>			
			<td><font class="bodyText"><s:text name="label.office" /></font></td>
			<td><s:label name="office" id="office" value="%{famPenAppMstdata.office}" theme="simple"  cssClass="bodyTextBold"></s:label>
				<s:hidden name="officeId" id="officeId" value="%{famPenAppMstdata.officeId}"/></td>
			<td><font class="bodyText"><s:text name="label.religion" /></font></td>		
			<td><s:select name="famPenAppHeadVal.religionId" id="religionId" value="%{famPenAppHoData.religionId}" list="religionCombo" listKey="religionCode" listValue="religionName" headerKey="0" headerValue="--Select--" cssStyle="border:#ffba14 1.5px solid" /></td>
		</tr>
		
		<!--<tr>			
			<td><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td><s:textfield name="famPenAppHeadVal.nationality" id="nationality" value="%{famPenAppHoData.nationality}" theme="simple" cssClass="textbox" onchange="charOnly(this);" onblur="charOnly(this);"  /></td>				
			<td><font class="bodyText"><s:text name="label.idmark1"  /></font></td>
			<td ><s:textarea name="famPenAppHeadVal.idMark1" id="idMark1" value="%{famPenAppHoData.idMark1}" onchange="alphanumeric(this);" onblur="alphanumeric(this);" theme="simple" rows="3" cols="15" cssStyle="border:#ffba14 1.5px solid" /></td>		
			<td><font class="bodyText"><s:text name="label.idmark2" /></font></td>
			<td><s:textarea name="famPenAppHeadVal.idMark2" id="idMark2" value="%{famPenAppHoData.idMark2}" onchange="alphanumeric(this);" onblur="alphanumeric(this);" theme="simple" rows="3" cols="15" cssStyle="border:#ffba14 1.5px solid" /></td>	
		</tr>
		
		-->
		
		<tr>			
			<td ><font class="bodyText"><s:text name="label.presentaddress" /></font>  <font color="red" class="bodyTextBold" > *</font> </td>
			<td ><s:textarea name="famPenAppHeadVal.presentAddress" id="presentAddress" value="%{famPenAppHoData.presentAddress}" theme="simple" rows="3" cols="15" cssStyle="border:#ffba14 1.5px solid" /></td>				
			<td ><font class="bodyText"><s:text name="label.state" /></font></td>
			<td><s:select name="famPenAppHeadVal.stateId" id="stateId" list="stateList" value="%{famPenAppHoData.stateId}" listKey="stateId" listValue="stateName" headerKey="0" headerValue="--Select--" cssStyle="border:#ffba14 1.5px solid" /></td>		
			<td><font class="bodyText"><s:text name="label.penpayoffice" /></font>  <font color="red" class="bodyTextBold" > *</font> </td>
			<td ><s:select name="famPenAppHeadVal.paymentOfficeId" id="paymentOfficeId" value="%{famPenAppHoData.paymentOfficeIdStr}" list="payOfficeList" listKey="currAccountOfficeId1" listValue="currAccountOfficeName" headerKey="0" headerValue="--Select--"  cssStyle="border:#ffba14 1.5px solid" /></td>	
		</tr>
		
		<tr>			
			<td><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td><s:textfield name="famPenAppHeadVal.nationality" id="nationality" theme="simple" cssClass="textbox" value="%{famPenAppHoData.nationality}" onchange="charOnly(this);" onblur="charOnly(this);"  /></td>				
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
			<td width="20%"><font class="bodyText"><s:text name="label.claimentname" /></font>  <font color="red" class="bodyTextBold" > *</font> </td>
			<td width="15%"><s:textfield name="famPenAppHeadVal.claimentName" id="claimentName" value="%{famPenAppHoData.claimentName}" maxlength="40" theme="simple" cssClass="textbox" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.claimentdob" /></font></td>
			<td width="15%">
				<s:textfield name="famPenAppHeadVal.claimentDob1" id="claimentDob1" value="%{famPenAppHoData.claimentDob3}" onblur="return CheckDate(this);" onchange="return CheckDate(this);"  size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
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
			<td width="15%"><s:textfield name="famPenAppHeadVal.claimentAge" id="claimentAge" value="%{famPenAppHoData.claimentAge}" onchange="numchk(this);" onblur="numchk(this);" maxlength="3" size="3" theme="simple" cssClass="textbox" /></td>	
			
		</tr>
		
		
		
		<tr>					
			<td width="20%"><font class="bodyText"><s:text name="label.idmark1" /></font> <font color="red" class="bodyTextBold" > *</font> </td>
			<td width="15%"><s:textarea name="famPenAppHeadVal.idMark1" id="idMark1"  value="%{famPenAppHoData.idMark1}"  theme="simple" rows="3" cols="15" onchange="alphanumeric(this);" onblur="alphanumeric(this);" cssStyle="border:#ffba14 1.5px solid" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.idmark2" /></font></td>
			<td width="15%"><s:textarea name="famPenAppHeadVal.idMark2" id="idMark2"  value="%{famPenAppHoData.idMark2}"  theme="simple" rows="3" cols="15" onchange="alphanumeric(this);" onblur="alphanumeric(this);" cssStyle="border:#ffba14 1.5px solid" /></td>			
			<td width="20%"><font class="bodyText">Height</font></td>
			<td width="15%"><s:textfield name="famPenAppHeadVal.height" id="height" value="%{famPenAppHoData.height}" size="3" theme="simple" cssClass="textbox" /></td>	
			
		</tr>
		
		
		
		<tr>	
			<td width="20%"><font class="bodyText"><s:text name="label.guardianname" /></font></td>
			<td width="15%"><s:textfield name="famPenAppHeadVal.guardianName" id="guardianName"  value="%{famPenAppHoData.guardianName}" maxlength="" theme="simple" cssClass="textbox" /></td>				
			<td width="20%"><font class="bodyText"><s:text name="label.guardiandob" /></font></td>
			<td width="15%">
				<s:textfield name="famPenAppHeadVal.guardianDob1" id="guardianDob" value="%{famPenAppHoData.guardianDob3}" onblur="return CheckDate(this);" onchange="return CheckDate(this);"  size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);"  />
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
			<td width="15%"><s:textfield name="famPenAppHeadVal.guardianRelationMinor" id="guardianRelationMinor" value="%{famPenAppHoData.guardianRelationMinor}" maxlength="40" theme="simple" cssClass="textbox" /></td>							
										
		</tr>
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.guardianrelation" /></font></td>
			<td width="15%"><s:textfield name="famPenAppHeadVal.guardianRelationEmp" id="guardianRelationEmp" value="%{famPenAppHoData.guardianRelationEmp}" maxlength="40" theme="simple" cssClass="textbox" /></td>
			<td width="20%"><font class="bodyText"><s:text name="label.empdeathdate" /></font>  <font color="red" class="bodyTextBold" > *</font> </td>
			<td width="15%">
				<s:textfield name="famPenAppHeadVal.employeeDeathDate1" id="employeeDeathDate" value="%{famPenAppHoData.employeeDeathDate3}"  onblur="return CheckDate(this);" onchange="return CheckDate(this);" size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
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
			<td width="15%"><s:textarea name="famPenAppHeadVal.address" id="address" value="%{famPenAppHoData.address}" theme="simple" rows="3" cols="15"  cssStyle="border:#ffba14 1.5px solid" /></td>			
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
					
									
					<tbody id="addNewNominee">
					<s:iterator value="nomineeObj" >				
					<tr id="<s:property value='%{nomineeId}'/>" >
					<td width="5%" align="center"><s:textfield name="nomineeInitial" id="nomineeInitial" value="%{nomineeInitial}" maxLength="10" size="5" cssClass="textbox"></s:textfield> </td>
					<td width="15%" align="center"><s:textfield name="familyMembers" id="familyMembers" value="%{familyMembers}" maxLength="50" cssClass="textbox" ></s:textfield> </td>
					<td width="10%" align="center"><s:select id="relation" name="relation" value="%{relation}" headerKey="0" headerValue="-- Select --"  list="#{'1':'Father','2':'Mother','3':'Spouse','4':'Son','5':'Daughter'}" theme="simple" /></td>
					<td width="10%" align="center"><s:textfield name="nomineeDob" id="nomineeDob" value="%{nomineeDob2}" maxLength="10" onkeyup="dtval(this,event)" size="10" cssClass="textbox" ></s:textfield></td>
					<td width="5%" align="center"><s:textfield name="nomineeAge" id="nomineeAge" value="%{nomineeAge}" maxLength="3" size="3" cssClass="textbox"></s:textfield> </td>
					<td width="10%" align="center"><s:select id="handicapped" name="handicapped" value="%{handicapped}"  list="#{'Y':'Yes','N':'No'}" theme="simple" /></td>
					<td width="10%" align="center"><s:select id="martialStatus" name="martialStatus" value="%{martialStatus}" list="#{'Married':'Married','Unmarried':'Unmarried'}" theme="simple" /></td>
					<td width="10%" align="center"><s:textfield name="nominationDate" id="nominationDate" value="%{nominationDate2}" maxLength="10" size="10" onkeyup="dtval(this,event);" cssClass="textbox"></s:textfield></td>
					<td width="10%" align="center"><s:select id="activeStatus" name="activeStatus" value="%{activeStatus}"  list="#{'Y':'Yes','N':'No'}"  theme="simple" /></td>
					<td width="10%" align="center"><s:textarea id="address" name="address" value="%{address}" rows="2" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" ></s:textarea></td>
					<td width="5%" align="center"><img src="../images/delete.png" align="middle" onclick="javascript:Delete(<s:property value='%{nomineeId}'/>)"/></td>
				    </tr>					
					</s:iterator>
					
					</tbody>
					
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
