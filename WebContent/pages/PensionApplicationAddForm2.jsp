<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="label.penappadd" /></title>
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
	<script type="text/javascript" src="<s:url value="/javascript/PensionApplicationForm2DynamicGrid.js" />" ></script>
	<script type="text/javascript" src="<s:url value="/javascript/PensionApplicationCommon.js" />"> </script>
	<script type="text/javascript" src="<s:url value="/javascript/PensionApplicationFetchMstData.js" />"> </script>
	<script type="text/javascript" src="<s:url value="/javascript/PensionApplicationForm2Validation.js" /> "></script>
	<script src="<s:url value="/javascript/PensionApplicationEditForm2Search.js" />" type="text/javascript"> </script>
	
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

function setRadio()
{
	document.getElementById("chargesFlagNo").checked="true";
	
}

function limitText(limitField, limitCount, limitNum) {
	if (limitField.value.length > limitNum) {
		limitField.value = limitField.value.substring(0, limitNum);
	} else {
		limitCount.value = limitNum - limitField.value.length;
	}
}

</script>

</head> 

<body onload="disableEnterKey(event);setRadio();">
<br>
<s:form name="penApplicationForm2" action="penAppAddForm2SaveAction" method="POST"  namespace="/pages" onsubmit="return CheckValidation();" >

<div class="demo">
<div id="tab11" style="background-color:#E9F5F5">
 
<table border="0" align="center" width="100%"> 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4"><s:text name="label.penappadd" /></font></td>
		</tr>
		
		<tr>
			<td align="center" colspan="6">
				<font class="bodyText"><s:text name="label.empno" /></font>
				<s:textfield name="" id="empId" size="" maxlength="" theme="simple" cssClass="textbox" onchange="javascript:checkAvailForm1(this.value);" >	</s:textfield>&nbsp;
				<input type="button" name="" value="Select" onclick="window.open('PensionApplicationAddForm2Search.jsp','mywindow','width=800,height=500,scrollbars=yes')" /> &nbsp;
				<input type="button" name="" value="Clear" onclick="" />				
			</td>			
		</tr>
		
		<tr bgcolor="#BCC0C4">
			<td colspan="6" align="center"><font class="textHeader"><strong><s:text name="label.empdetails" /></strong></font></td>
		</tr>
		
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.empno" /></font></td>
			<td width="15%">
				<s:hidden name="addpenappco.empNo" id="empNo"  theme="simple" cssClass="readonlytext"/>
				<s:label name="empNoLabel" id="empNoLabel" theme="simple" cssClass="bodyTextBold"></s:label>
			</td>		
			<td width="20%"><font class="bodyText"><s:text name="label.empname" /></font></td>
			<td width="15%"><s:hidden name="addpenappco.empName" id="empName" theme="simple"  />
				<s:label name="empNameLabel" id="empNameLabel" theme="simple"  cssClass="bodyTextBold"></s:label>
			</td>		
			<td width="20%"><font class="bodyText"><s:text name="label.gender" /></font></td>
			<td width="15%" class="bodyText" ><s:radio name="gender" id="gender" list="#{'M':'Male','F':'Female'}" disabled="true" ></s:radio> 
				<s:hidden name="addpenappco.gender" id="hiddengender" />
			</td>				
		</tr>	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.designation" /></font></td>
			<td width="15%">
				<s:label name="designation" id="designation" theme="simple" cssClass="bodyTextBold"></s:label>
				<s:hidden name="addpenappco.desigId" id="desigId" />
				<s:hidden name="addpenappco.desigServiceGrp" id="desigServiceGrp" />
			</td>					
			<td width="15%"><font class="bodyText"><s:text name="label.grade" /></font></td>
			<td width="20%"><s:label name="gradeLabel" id="gradeLabel" theme="simple"  cssClass="bodyTextBold" ></s:label>
				<s:hidden name="addpenappco.gradeId" id="grade" theme="simple" /></td>
			<td width="15%"><font class="bodyText"><s:text name="label.office" /></font></td>
			<td width="20%">
				<s:label name="office" id="office"  theme="simple"  cssClass="bodyTextBold"></s:label>
				<s:hidden name="addpenappco.officeId" id="officeId" />
			</td>
			
		</tr>	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.gpfno" /></font></td>
			<td width="15%" ><s:label name="gpfNoLabel" id="gpfNoLabel" theme="simple" cssClass="bodyTextBold" ></s:label>
				<s:hidden name="addpenappco.gpfNo" id="gpfNo" theme="simple"  />
			</td>			
			
			<td width="20%"><font class="bodyText">Father's Name</font></td>
			<td width="15%"><s:textfield name="addpenappco.fatherName" id="fatherName" maxlength="60" theme="simple" cssClass="textbox" /></td>		
			<td width="20%"><font class="bodyText">Husband's Name</font></td>
			<td width="15%"><s:textfield name="addpenappco.husbandName" id="husbandName"  maxlength="60" theme="simple" cssClass="textbox"  /> </td>
		</tr>
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.religion" /></font></td>
			<td width="20%"><s:select name="addpenappco.religion"  id="religion" list="religionCombo" listKey="religionCode" listValue="religionName" theme="simple" headerKey="0" headerValue="--Select--" ></s:select></td>
			<td width="20%"><font class="bodyText"><s:text name="label.nationality" /></font> </td>
			<td width="15%"><s:textfield name="addpenappco.nationality" id="nationality" maxlength="40" theme="simple" cssClass="textbox" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.height" /></font></td>
			<td width="15%"><s:textfield name="addpenappco.empHeight" id="empHeight"  maxlength="20" theme="simple" cssClass="textbox" /></td>		
		
		</tr>	
		<tr>
			
			<td width="15%"><font class="bodyText"><s:text name="label.idmark1" /></font></td>
			<td width="20%"><s:textarea name="addpenappco.idMark1" id="idMark1" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>
			<td width="20%"><font class="bodyText"><s:text name="label.idmark2" /></font></td>
			<td width="15%"><s:textarea name="addpenappco.idMark2" id="idMark2" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.presentaddress" /></font><font color="red" class="bodyText" class="bodyText">*</font></td>
			<td>
				<s:textarea name="addpenappco.presentAddress" id="presentAddress" 
				rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"
				onkeydown="limitText(this.form.presentAddress,this.form.countdown1,100);" 
				onkeyup="limitText(this.form.presentAddress,this.form.countdown1,100);" >
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown1" size="3" value="100"> characters left.</font>
			</td>	
						
		</tr>	
		
		<tr>
			
			<td><font class="bodyText"><s:text name="label.permanentaddress" /></font><font color="red" class="bodyText" class="bodyText">*</font></td>
			<td>
			<s:textarea name="addpenappco.permanentAddress" id="permanentAddress"  
				rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"				
				onkeydown="limitText(this.form.permanentAddress,this.form.countdown2,100);" 
				onkeyup="limitText(this.form.permanentAddress,this.form.countdown2,100);" >
			</s:textarea>
			<font size="1" color="red">(Maximum characters: 100)<br>
			You have <input readonly type="text" name="countdown2" size="3" value="100"> characters left.</font>
			</td>	
			
			<td width="20%"><font class="bodyText"><s:text name="label.addressretire" /></font><font color="red" class="bodyText" class="bodyText">*</font></td>
			<td width="15%">
				<s:textarea name="addpenappco.addressAfterRetire" id="addressAfterRetire" 
				rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
				onkeydown="limitText(this.form.addressAfterRetire,this.form.countdown3,100);" 
				onkeyup="limitText(this.form.addressAfterRetire,this.form.countdown3,100);" >
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown3" size="3" value="100"> characters left.</font>
			</td>		
			<td width="15%"><font class="bodyText"><s:text name="label.retirestate" /></font></td>
			<td width="20%"><s:select name="addpenappco.stateId" id="stateId" list="stateList" listKey="stateId" listValue="stateName" headerKey="" headerValue="--Select State--" /></td>
				
		</tr>
		<tr>
		        <td width="20%"><font class="bodyText"><s:text name="label.charges" /></font></td>
				<td  width="14%" class="bodyText" ><s:radio name="addpenappco.chargesFlag" id="chargesFlag" list="#{'Yes':'Yes','No':'No'}" onclick="disableEnableCharges();" > </s:radio> </td>
				<td><font class="bodyText"><s:text name="label.chargesdetails" /></font></td>
				<td><s:textarea name="addpenappco.chargeDetails" id="chargeDetails" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" disabled="true" /></td>		
			
				<td width="20%"><font class="bodyText"><s:text name="label.penpayoffice" /></font><font color="red" class="bodyText" class="bodyText">*</font></td>				
				<td><s:select name="addpenappco.pensionPayOfficeId" id="pensionPayOfficeId" list="payOfficeList" listKey="currAccountOfficeId1" listValue="currAccountOfficeName" headerKey="0" headerValue="--Select--" /> </td>	
		
		</tr>
		
		<tr>
			<td><font class="bodyText">Date of Applicant Applied for Pension</font><font color="red" class="bodyText" class="bodyText">*</font></td>
						<td><s:textfield name="addpenappco.appliedDate" id="appliedDate" size="10" maxlength="10" theme="simple" cssClass="textbox" onchange="checkdate(this);" onblur="checkdate(this);" onkeyup="dtval(this,event);" />
						<img src="../images/calendr3.gif" id="cal-button-6" align="middle" />			
					 	<script type="text/javascript">
		            		Calendar.setup({
		              		inputField    : "appliedDate",
		              		button        : "cal-button-6",
		              		align         : "Tr"
		            		});
		          		</script>
						</td>
			
		</tr>	
	
</table>
	
</div>
 


<div id="tabs" style="background-color:#FFEEBA">
	<ul>
		<li><a href="#tabs-1">Nominee</a></li>				
		<li><a href="#tabs-2">Not Verified Service</a></li>			
	</ul>
	
	
	<div id="tabs-1" style="background-color: #E9F5F5;">	
		<table border="0" align="center" width="100%">					
			<tr bgcolor="#BCC0C4">
				<td align="center"><font class="textHeader"><strong><s:text name="label.famnomindet" /></strong></font></td>						
			</tr>
			
			<tr>
				<td>
				<table border="1" align="center" width="100%" class="tableGrid">
					<tr>						
						<th width="5%" align="center"><font class="bodyText"><s:text name="label.initial" /></font></th>
						<th width="15%" align="center"><font class="bodyText"><s:text name="label.familymembers" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.relationship" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.dob" /></font></th>
						<th width="5%" align="center"><font class="bodyText"><s:text name="label.age" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.handicapped" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.martialstatus" /></font></th>						
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.nomindate" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.active" /></font></th>
						<th width="10%" align="center"><font class="bodyText"><s:text name="label.reason" /></font></th>	
						<th width="5%" align="center"><font class="bodyText"><s:text name="label.delete" /></font></th>					
					</tr>
					
					<tbody id="addNewNominee"></tbody>
					
				</table>
				</td>
			</tr>
			
			
			
			
			<tr>
				<td align="center"><input type="button" value="Add New" onclick="javascript:addNewNominee();"> </td>
			</tr>
			
			<tr bgcolor="#BCC0C4">
				<td align="center"><font class="textHeader"><strong><s:text name="label.nominfordcrg" /></strong></font></td>						
			</tr>
			
			<tr>			
				<td>
					<table border="1" align="center" width="100%" class="tableGrid" >
					<tr>				
						<td><font class="bodyText"><s:text name="label.nominname" /></font></td>
						<td><s:textfield name="addpenappco.dcrgNomineeName" id="dcrgNomineeName" maxlength="30" theme="simple" cssClass="textbox" >
							</s:textfield>
						</td>
						<td><font class="bodyText"><s:text name="label.dob" /></font></td>
						<td><s:textfield name="addpenappco.dcrgNomineeDob" id="dcrgNomineeDob" size="10" maxlength="10" theme="simple" cssClass="textbox" onchange="checkdate(this);" onblur="checkdate(this);" onkeyup="dtval(this,event);" />
						<img src="../images/calendr3.gif" id="cal-button-4" align="middle" />			
					 	<script type="text/javascript">
		            		Calendar.setup({
		              		inputField    : "dcrgNomineeDob",
		              		button        : "cal-button-4",
		              		align         : "Tr"
		            		});
		          		</script>
						</td>
						<td><font class="bodyText"><s:text name="label.relationship" /></font></td>
						<td><s:textfield name="addpenappco.dcrgRelation" id="dcrgRelation" maxlength="30" theme="simple" cssClass="textbox" /></td>	
						<td><font class="bodyText"><s:text name="label.address" /></font></td>
						<td>
							<s:textarea name="addpenappco.dcrgAddress" id="dcrgAddress" 
							rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"
							onkeydown="limitText(this.form.dcrgAddress,this.form.countdown4,100);" 
							onkeyup="limitText(this.form.dcrgAddress,this.form.countdown4,100);" >
							</s:textarea>
							<font size="1" color="red">(Maximum characters: 100)<br>
								You have <input readonly type="text" name="countdown4" size="3" value="100"> characters left.</font>
							</td>											
					</tr>	
					</table>					
				</td>
			</tr>
			</table>
	</div>
	
	
	
	
	
	
	<div id="tabs-2" style=" background-color: #E9F5F5">	
		<table border="0" align="center" width="100%" class="tableGrid">			
			
			<tr bgcolor="#BCC0C4">
				<th colspan="2" align="center"><font class="textHeader"><strong><s:text name="label.notverfyserdet" /></strong></font></th>									
			</tr>
									
			<tr>
				<td colspan="7">
					<table border="1" width="100%" class="tableGrid">
						<tr>
							<td width="15%" align="center"><font class="bodyText"><strong>Start Date</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>End Date</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Reason</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Years</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Months</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Days</strong></font></td>
							<th width="5%" align="center"><font class="bodyText"><s:text name="label.delete" /></font></th>			
						</tr>						
					
					<tbody id="notVerifyService"></tbody>					
					
					</table>
				</td>				
			</tr>
			
		
			<tr>
				<td colspan="7" align="center"><input type="button" value="Add New" onclick="javascript:addNewNotVerify();" /></td>
			</tr>
					
		
			<tr>
				<TD>
					<table border="1" align="right" class="tableGrid" width="30%">
						<tr>
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totyear" /></font></strong></td>
							<td width="50%"><s:textfield name="addpenappco.notVerifyServiceTotYears" id="notVerifyServiceTotYears" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true"   /></td>	
						</tr>
						
						<tr>					
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totmonth" /></font></strong></td>
							<td width="50%"><s:textfield name="addpenappco.notVerifyServiceTotMonths" id="notVerifyServiceTotMonths" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true"  /></td>	
						</tr>
						
						<tr>				
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totdays" /></font></strong></td>
							<td width="50%"><s:textfield name="addpenappco.notVerifyServiceTotDays" id="notVerifyServiceTotDays" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true"  /></td>				
						</tr>
						
					</table>
				</TD>
			</tr>
			
			
		
		</table>
	</div>
		
	
	
 	</div>
 	
</div>

	<div align="center">
		<input type="radio" name="checkStatus" id="checkStatus" value="yes" checked="checked"/><font class="bodyText"><s:text name="label.partial" /></font>
		<input type="radio" name="checkStatus" id="checkStatus" value="no" /><font class="bodyText"><s:text name="label.fullsave" /></font><br><br>
		
		<input type="submit"  value=" Submit " class="btn"/>&nbsp;
		<input type="button" name="cmdCancel" value=" Exit " class="btn" onclick="javascript:window.close()" />
</div>

</s:form>

</body>
</html>
