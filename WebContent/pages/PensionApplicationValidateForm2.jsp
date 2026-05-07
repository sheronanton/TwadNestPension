<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="label.penappvalidate"/></title>
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
		document.getElementById("husbandName").readOnly=true; 
		
	}
	if(gen=="F")
	{
		document.getElementById("genderF").checked=true;
		document.getElementById("husbandName").readOnly=false;
		 document.getElementById("fatherName").readOnly=false;
	
	}

	document.getElementById("pensionPayOfficeId").value=document.getElementById("setPayOffice").value;

	var chflag=document.getElementById("hiddenChFlag").value;
	if(chflag=="Yes")
	{
		document.getElementById("chargeDetails").disabled=false;
	}
	if(chflag=="No")
	{
		document.getElementById("chargeDetails").disabled=true;
	}
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

<body onload="disableEnterKey(event);setValue();">
<br>
<s:form name="" action="penAppValidForm2SaveAction" method="POST"  namespace="/pages" onsubmit="return CheckValidation();" >
<div class="demo">
<div id="tab11" style="background-color:#E9F5F5">
 
<table border="0" align="center" width="100%"> 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4"><s:text name="label.penappvalidate" /></font></td>
		</tr>
	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.empno" /></font></td>			
			<td width="15%">
				<s:hidden name="valpenappco.empNo" id="empNo" value="%{valpenappdata.empNo}" theme="simple" />
				<s:label name="empNoLabel" id="empNoLabel" value="%{valpenappdata.empNo}" theme="simple" cssClass="bodyTextBold"  ></s:label>
			</td>		
			
			<td width="20%"><font class="bodyText"><s:text name="label.empname" /></font></td>
			<td width="15%">
				<s:hidden name="valpenappco.empName" id="empName" value="%{valpenappdata.empName}"  theme="simple" />
				<s:label name="empNameLabel" id="empNameLabel" value="%{valpenappdata.empName}" theme="simple" cssClass="bodyTextBold"  ></s:label>
			</td>		
			
			<td width="20%"><font class="bodyText"><s:text name="label.gender" /></font></td>
			<td width="15%" class="bodyText" >
				<s:radio name="" id="gender" list="#{'M':'Male','F':'Female'}" value="%{valpenappdata.gender}" disabled="true" ></s:radio> 
				<s:hidden name="valpenappco.gender" id="hiddengender" value="%{valpenappdata.gender}" />
			</td>		
			
			
					
		</tr>	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.designation" /></font></td>
			<td width="15%">
				<s:label name="designation" id="designation" theme="simple"  value="%{empDesign}" cssClass="bodyTextBold"  />
				<s:hidden name="valpenappco.desigId" id="desigId"  value="%{valpenappdata.desigId}" />
				<s:hidden name="valpenappco.desigServiceGrp" id="desigServiceGrp"  value="%{valpenappdata.desigServiceGrp}"  />
			</td>					
			<td width="15%"><font class="bodyText"><s:text name="label.grade" /></font></td>
			<td width="20%">
				<s:label name="gradeLabel" id="gradeLabel" theme="simple"  value="%{valpenappdata.gradeId}" cssClass="bodyTextBold"  />			
				<s:hidden name="valpenappco.gradeId" id="gradeId" theme="simple" cssClass="readonlytext" value="%{valpenappdata.gradeId}" /></td>
			<td width="15%"><font class="bodyText"><s:text name="label.office" /></font></td>
			<td width="20%">
				<s:label name="office" id="office" theme="simple"  value="%{empOfficeName}" cssClass="bodyTextBold"  />				
				<s:hidden name="valpenappco.officeId" id="officeId" value="%{valpenappdata.officeId}"/>
			</td>
			
		</tr>	
		<tr>
		<td width="20%"><font class="bodyText"><s:text name="label.gpfno" /></font></td>
		<td width="15%" >
		<s:label name="gpfLabel" id="gpfLabel" theme="simple"  value="%{valpenappdata.gpfNo}" cssClass="bodyTextBold"  />		
		<s:hidden name="valpenappco.gpfNo" id="gpfNo" value="%{valpenappdata.gpfNo}" theme="simple" cssClass="readonlytext" /></td>			
		<td width="20%"><font class="bodyText">Father's Name</font></td>
		
		<td width="15%"><s:textfield name="valpenappco.fatherName" value="%{valpenappdata.fatherName}" id="fatherName" maxlength="60" theme="simple" cssClass="textbox"  /></td>		
		<td width="20%"><font class="bodyText">Husband's Name</font></td>
		<td width="15%">
		<s:textfield name="valpenappco.husbandName" id="husbandName"  maxlength="60" theme="simple" cssClass="textbox" value="%{valpenappdata.husbandName}" /></td>
		</TR>
		
		<TR>		
		<td width="15%"><font class="bodyText"><s:text name="label.religion" /></font></td>
			<td width="20%"><s:select name="editpenappco.religion"  id="religion" list="religionCombo" listKey="religionCode" listValue="religionName" value="%{valpenappdata.religion}" theme="simple" headerKey="0" headerValue="--Select--" ></s:select>	</td>
			<td width="20%"><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td width="15%"><s:textfield name="valpenappco.nationality" id="nationality" value="%{valpenappdata.nationality}" maxlength="40" theme="simple" cssClass="textbox" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.height" /></font></td>
			<td width="15%"><s:textfield name="valpenappco.empHeight" id="empHeight" value="%{valpenappdata.empHeight}" maxlength="20" theme="simple" cssClass="textbox" /></td>		
			
		</tr>	
		<tr>
		
		<td width="15%"><font class="bodyText"><s:text name="label.idmark1" /></font></td>
			<td width="20%"><s:textarea name="valpenappco.idMark1" id="idMark1" value="%{valpenappdata.idMark1}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>
			<td width="20%"><font class="bodyText"><s:text name="label.idmark2" /></font></td>
			<td width="15%"><s:textarea name="valpenappco.idMark2" id="idMark2" value="%{valpenappdata.idMark2}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.presentaddress" /></font> <font color="red" class="bodyText">*</font></td>
			<td><s:textarea name="valpenappco.presentAddress" id="presentAddress" value="%{valpenappdata.presentAddress}" 
			rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.presentAddress,this.form.countdown1,100);" 
				onkeyup="limitText(this.form.presentAddress,this.form.countdown1,100);">
				</s:textarea><br>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown1" size="3" value="100"> characters left.</font>
				</td>			
		
			
		</tr>	
		
		<tr>
			<td><font class="bodyText"><s:text name="label.permanentaddress" /></font><font color="red" class="bodyText">*</font></td>
			<td><s:textarea name="valpenappco.permanentAddress" id="permanentAddress" value="%{valpenappdata.permanentAddress}" 
			rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.permanentAddress,this.form.countdown3,100);" 
				onkeyup="limitText(this.form.permanentAddress,this.form.countdown3,100);">
				</s:textarea><br>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown3" size="3" value="100"> characters left.</font>
				</td>
			<td width="20%"><font class="bodyText"><s:text name="label.addressretire" /></font><font color="red" class="bodyText">*</font></td>
			<td><s:textarea name="valpenappco.addressAfterRetire" id="addressAfterRetire" value="%{valpenappdata.addressAfterRetire}" 
			rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.addressAfterRetire,this.form.countdown2,100);" 
				onkeyup="limitText(this.form.addressAfterRetire,this.form.countdown2,100);">
				</s:textarea><br>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown2" size="3" value="100"> characters left.</font>
				</td>		
			<td width="15%"><font class="bodyText"><s:text name="label.retirestate" /></font></td>
			<td width="20%"><s:select name="valpenappco.stateId" id="stateId" value="%{valpenappdata.stateId}" list="stateList" listKey="stateId" listValue="stateName"  headerKey="0" headerValue="--Select State--" /></td>
				
		</tr>
		<tr>
		        <td width="20%"><font class="bodyText"><s:text name="label.charges" /></font></td>
				<td  width="14%" class="bodyText" ><s:radio name="valpenappco.chargesFlag" id="chargesFlag"  value="%{valpenappdata.chargesFlag}" list="#{'Yes':'Yes','No':'No'}" onclick="disableEnableCharges();" > </s:radio> </td>
				<s:hidden id="hiddenChFlag"  value="%{valpenappdata.chargesFlag}" />
				<td><font class="bodyText"><s:text name="label.chargesdetails" /></font></td>
				<td><s:textarea name="valpenappco.chargeDetails" id="chargeDetails"  value="%{valpenappdata.chargeDetails}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" disabled="true" /></td>		
			
				<td width="20%"><font class="bodyText"><s:text name="label.penpayoffice" /></font><font color="red" class="bodyText">*</font></td>				
				<td><s:select name="valpenappco.pensionPayOfficeId" id="pensionPayOfficeId"  list="payOfficeList" listKey="currAccountOfficeId1" listValue="currAccountOfficeName" value="%{valpenappdata.pensionPayOfficeId}"  headerKey="" headerValue="--Select--" /> </td>	
				<s:hidden id="setPayOffice" value="%{valpenappdata.pensionPayOfficeId}" />
		</tr>
			
		<tr>
			<td><font class="bodyText">Date of Applicant Applied for Pension</font><font color="red" class="bodyText">*</font></td>
						<td><s:textfield name="valpenappco.appliedDate" id="appliedDate" value="%{valpenappdata.appliedDate2}" size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
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
					
					<tbody id="addNewNominee">
					<s:iterator value="valpenappnom">					
					<tr id="<s:property value='%{nomineeId}'/>" >					
					<td width="5%" align="center"><s:textfield name="nomineeInitial" id="nomineeInitial" value="%{nomineeInitial}" size="5" maxlength="10" cssClass="textbox"/></td>
					<td width="15%" align="center"><s:textfield name="familyMembers" id="familyMembers" value="%{familyMembers}"  maxlength="10" cssClass="textbox" /></td>
					<td width="10%" align="center"><s:select name="relation" id="relation" value="%{relation}" list="#{'1':'Father','2':'Mother','3':'Spouse','5':'Son','6':'Daughter'}"/></td>
					<td width="10%" align="center"><s:textfield name="nomineeDob" id="nomineeDob" value="%{nomineeDob2}" size="10" maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox" /></td>
					<td width="5%" align="center"><s:textfield name="nomineeAge" id="nomineeAge" value="%{nomineeAge}"  size="5" maxlength="3" cssClass="textbox" /></td>
					<td width="10%" align="center"><s:select name="handicapped" id="handicapped" value="%{handicapped}" list="#{'Y':'Yes','N':'No'}" /></td>
					<td width="10%" align="center"><s:select name="martialStatus" id="martialStatus" value="%{martialStatus}" list="#{'Married':'Married','Unmarried':'Unmarried'}" /></td>
					<td width="10%" align="center"><s:textfield name="nominationDate" id="nominationDate" value="%{nominationDate2}" size="10" maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox" /></td>				
					<td width="10%" align="center"><s:select name="activeStatus" id="activeStatus" value="%{activeStatus}" list="#{'Yes':'Yes','No':'No'}" /></td>
					<td width="10%" align="center"><s:textfield name="nominReason" id="nominReason" value="%{nominReason}" cssClass="textbox" /></td>	
					<td width="5%" align="center"><img src="../images/delete.png" align="middle" onclick="javascript:Delete(<s:property value='%{nomineeId}'/>)"/></td>
					</tr>					
					</s:iterator>
					</tbody>
					
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
						<td><s:textfield name="valpenappco.dcrgNomineeName" id="" value="%{valpenappdata.dcrgNomineeName}" size="" maxlength="" theme="simple" cssClass="textbox" /></td>
						<td><font class="bodyText"><s:text name="label.dob" /></font></td>
						<td><s:textfield name="valpenappco.dcrgNomineeDob" id="dcrgNomineeDob" value="%{valpenappdata.dcrgNomineeDob2}" size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
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
						<td><s:textfield name="valpenappco.dcrgRelation" id="" value="%{valpenappdata.dcrgRelation}" size="" maxlength="" theme="simple" cssClass="textbox" /></td>	
						<td><font class="bodyText"><s:text name="label.address" /></font></td>
						<td><s:textarea name="valpenappco.dcrgAddress" id="dcrgAddress" value="%{valpenappdata.dcrgAddress}" 
						rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"
						onkeydown="limitText(this.form.dcrgAddress,this.form.countdown4,100);" 
				onkeyup="limitText(this.form.dcrgAddress,this.form.countdown4,100);">
				</s:textarea><br>
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
				<td colspan="2" align="center"><font class="textHeader"><strong><s:text name="label.notverfyserdet" /></strong></font></td>									
			</tr>
									
			<tr>
				<td colspan="7">
					<table border="1" width="100%" class="tableGrid">
						<tr>
							<th width="15%" align="center"><font class="bodyText"><strong>Start Date</strong></font></th>
							<th width="15%" align="center"><font class="bodyText"><strong>End Date</strong></font></th>
							<th width="15%" align="center"><font class="bodyText"><strong>Reason</strong></font></th>
							<th width="15%" align="center"><font class="bodyText"><strong>Years</strong></font></th>
							<th width="15%" align="center"><font class="bodyText"><strong>Months</strong></font></th>
							<th width="15%" align="center"><font class="bodyText"><strong>Days</strong></font></th>
							<th width="5%" align="center"><font class="bodyText"><s:text name="label.delete" /></font></th>			
						</tr>
												
							<tbody id="notVerifyService">
								<s:iterator value="valpenappnvser">					
								<tr id="<s:property value='%{id}'/>">									
									<td width="15%" align="center"><s:textfield name="notVerifyServFromDate" id="notVerifyServFromDate" value="%{notVerifyServFromDate2}"  maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyServToDate" id="notVerifyServToDate" value="%{notVerifyServToDate2}"  maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyServiceReason" id="notVerifyServiceReason" value="%{notVerifyServiceReason}" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyYear" id="notVerifyYear" value="%{notVerifyYear}"  maxlength="" readonly="true" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyMonth" id="notVerifyMonth" value="%{notVerifyMonth}"   maxlength="" readonly="true" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyDays" id="notVerifyDays" value="%{notVerifyDays}"  maxlength="" readonly="true" cssClass="textbox" /></td>
									<td width="5%" align="center"><img src="../images/delete.png" align="middle" onclick="javascript:Delete1(<s:property value='%{id}'/>)" /></td>
								</tr>		
								</s:iterator>
							</tbody>					
						<tr>
							<td colspan="7" align="center"><input type="button" value="Add New" onclick="javascript:addNewNotVerify();" /></td>
						</tr>
					</table>
				</td>
				
				
			</tr>
			
			
			<tr>
				<td>
					<table border="1" width="30%" class="tableGrid" align="right">
						<tr>											
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totyear" /></font></strong></td>
							<td width="50%"><s:textfield name="valpenappco.notVerifyServiceTotYears" id="notVerifyServiceTotYears" value="%{valpenappdata.notVerifyServiceTotYears}" size="" maxlength="" theme="simple" cssClass="readonlytext" readonly="true" /></td>	
						</tr>
						
						<tr>	
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totmonth" /></font></strong></td>
							<td width="50%"><s:textfield name="valpenappco.notVerifyServiceTotMonths" id="notVerifyServiceTotMonths" value="%{valpenappdata.notVerifyServiceTotMonths}" size="" maxlength="" theme="simple" cssClass="readonlytext" readonly="true"/></td>	
						</tr>
						<tr>	
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totdays" /></font></strong></td>
							<td width="50%"><s:textfield name="valpenappco.notVerifyServiceTotDays" id="notVerifyServiceTotDays" value="%{valpenappdata.notVerifyServiceTotDays}" size="" maxlength="" theme="simple" cssClass="readonlytext" readonly="true" /></td>				
						</tr>
					</table>
				</td>
			</tr>			
		</table>
	</div>
		
	
	
 	</div>
 	
</div>

	<div align="center">
			<input type="submit"  value=" Freeze " class="btn"/>&nbsp;
		<input type="button" name="cmdCancel" value=" Exit " class="btn" onclick="javascript:window.close()" />
</div>

</s:form>

</body>
</html>
