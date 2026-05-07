<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="label.penappedit"/></title>
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

function setValues()
{
	var ch=document.getElementById("hiddengender").value;	
	if(ch=="M")
	{
		document.getElementById("genderM").checked=true;	
		document.getElementById("husbandName").readOnly=true; 
	}
	if(ch=="F")
	{
		document.getElementById("genderF").checked=true;
		document.getElementById("husbandName").readOnly=false;
		 document.getElementById("fatherName").readOnly=false;
	
	}
	
	var chflag=document.getElementById("HiddenChargesFlag").value;
	if(chflag=="Yes")
	{
		document.getElementById("chargeDetails").disabled=false;
	}
	if(chflag=="No")
	{
		document.getElementById("chargeDetails").disabled=true;
	}

	document.getElementById("pensionPayOfficeId").value=document.getElementById("chk").value;

	
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

<body onload="disableEnterKey(event);setValues();">
<br>
<s:form name="penApplicationEditForm2" action="penAppEditForm2SaveAction" method="POST"  namespace="/pages" onsubmit="return CheckValidation();" >
<div class="demo">
<div id="tab11" style="background-color:#E9F5F5">
 
<table border="0" align="center" width="100%"> 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4"><s:text name="label.penappedit" /></font></td>
		</tr>
	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.empno" /></font></td>
			<td width="15%">	
			<s:label id="empNoLabel" name="empNoLabel" value="%{editpenappdata.empNo}" cssClass="bodyTextBold" />
			<s:hidden name="editpenappco.empNo" id="empNo" value="%{editpenappdata.empNo}" theme="simple" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.empname" /></font></td>
			<td width="15%">
				<s:label id="empNameLabel" name="empNameLabel" value="%{editpenappdata.empName}" cssClass="bodyTextBold"/>
				<s:hidden name="editpenappco.empName" id="empName" value="%{editpenappdata.empName}"  theme="simple" />			
			</td>		
			
			<td width="20%"><font class="bodyText"><s:text name="label.gender" /></font></td>
			<td width="15%" class="bodyText" >
			<s:radio name="gender" id="gender" list="#{'M':'Male','F':'Female'}" value="%{editpenappdata.gender}" disabled="true" ></s:radio> 
			<s:hidden name="editpenappco.gender" id="hiddengender" value="%{editpenappdata.gender}" />
			</td>		
			
			
					
		</tr>	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.designation" /></font></td>
			<td width="15%">
				<s:label id="desigLabel" name="desigLabel" value="%{empDesig}" cssClass="bodyTextBold" />			
				<s:hidden id="designation" value="%{empDesig}"  theme="simple" cssClass="readonlytext" />
				<s:hidden name="editpenappco.desigId" id="desigId" value="%{editpenappdata.desigId}"  />
				<s:hidden name="editpenappco.desigServiceGrp" id="desigServiceGrp"  value="%{editpenappdata.desigServiceGrp}"   />
			</td>					
			<td width="15%"><font class="bodyText"><s:text name="label.grade" /></font></td>
			<td width="20%">
				<s:label id="gradeLabel" name="gradeLabel" value="%{editpenappdata.gradeId}" cssClass="bodyTextBold" />		
				<s:hidden name="editpenappco.gradeId" id="grade" theme="simple" value="%{editpenappdata.gradeId}" />
			</td>
			<td width="15%"><font class="bodyText"><s:text name="label.office" /></font></td>
			<td width="20%">
				<s:label id="officeLabel" name="officeLabel" value="%{officeName}" cssClass="bodyTextBold" />
				<s:hidden name="" id="office"  theme="simple" value="%{officeName}" />
				<s:hidden name="editpenappco.officeId" id="officeId" value="%{editpenappdata.officeId}"/>
			</td>
			
			
				
		
					
		</tr>	
		<tr>
		<td width="20%"><font class="bodyText"><s:text name="label.gpfno" /></font></td>
		<td width="15%" >
			<s:hidden name="editpenappco.gpfNo" id="gpfNo" value="%{editpenappdata.gpfNo}" theme="simple" />
			<s:label id="gpfLabel" name="gpfLabel" value="%{editpenappdata.gpfNo}" cssClass="bodyTextBold" />

			
		</td>			
		<td width="20%"><font class="bodyText">Father's Name</font></td>
		<td width="15%"><s:textfield name="editpenappco.fatherName" value="%{editpenappdata.fatherName}" id="fatherName" maxlength="60" theme="simple" cssClass="textbox"  /></td>		
		<td width="20%"><font class="bodyText">Husband's Name</font></td>
		<td width="15%"><s:textfield name="editpenappco.husbandName" id="husbandName"  maxlength="60" theme="simple" cssClass="textbox" value="%{editpenappdata.husbandName}" /> </td>
		</tr>
		
		
		<tr>
		<td width="15%"><font class="bodyText"><s:text name="label.religion" /></font></td>
			<td width="20%"><s:select name="editpenappco.religion"  id="religion" list="religionCombo" listKey="religionCode" listValue="religionName" value="%{editpenappdata.religion}" theme="simple" headerKey="0" headerValue="--Select--" ></s:select></td>
			
			
			
			<td width="20%"><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td width="15%"><s:textfield name="editpenappco.nationality" id="nationality" value="%{editpenappdata.nationality}" maxlength="40" theme="simple" cssClass="textbox" /></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.height" /></font></td>
			<td width="15%"><s:textfield name="editpenappco.empHeight" id="empHeight" value="%{editpenappdata.empHeight}"  maxlength="20" theme="simple" cssClass="textbox" /></td>		
	
		</tr>	
		
		
		<tr>
		
		<td width="15%"><font class="bodyText"><s:text name="label.idmark1" /></font></td>
			<td width="20%"><s:textarea name="editpenappco.idMark1" id="idMark1" value="%{editpenappdata.idMark1}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>
			<td width="20%"><font class="bodyText"><s:text name="label.idmark2" /></font></td>
			<td width="15%"><s:textarea name="editpenappco.idMark2" id="idMark2" value="%{editpenappdata.idMark2}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>		
			<td width="20%"><font class="bodyText"><s:text name="label.presentaddress" /></font> <font color="red" class="bodyText">*</font></td>
			<td>
			<s:textarea name="editpenappco.presentAddress" id="presentAddress" value="%{editpenappdata.presentAddress}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.presentAddress,this.form.countdown1,100);" 
				onkeyup="limitText(this.form.presentAddress,this.form.countdown1,100);">
				</s:textarea><br>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown1" size="3" value="100"> characters left.</font>
				</td>		
		
		</tr>	
		
		<tr>
		
			<td><font class="bodyText"><s:text name="label.permanentaddress" /></font><font color="red" class="bodyText">*</font></td>
			<td><s:textarea name="editpenappco.permanentAddress" id="permanentAddress" rows="3"
			 cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"  value="%{editpenappdata.permanentAddress}" 
			 onkeydown="limitText(this.form.permanentAddress,this.form.countdown3,100);" 
				onkeyup="limitText(this.form.permanentAddress,this.form.countdown3,100);">
				</s:textarea><br>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown3" size="3" value="100"> characters left.</font>
				</td>
		
			<td width="20%"><font class="bodyText"><s:text name="label.addressretire" /></font><font color="red" class="bodyText">*</font></td>
			<td>
			<s:textarea name="editpenappco.addressAfterRetire" id="addressAfterRetire" value="%{editpenappdata.addressAfterRetire}" 
			rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"  
			onkeydown="limitText(this.form.addressAfterRetire,this.form.countdown2,100);" 
				onkeyup="limitText(this.form.addressAfterRetire,this.form.countdown2,100);">
				</s:textarea><br>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown2" size="3" value="100"> characters left.</font>
				</td>
						
			<td width="15%"><font class="bodyText"><s:text name="label.retirestate" /></font></td>
			<td width="20%"><s:select name="editpenappco.stateId" id="stateId" value="%{editpenappdata.stateId}" list="stateList" listKey="stateId" listValue="stateName"  headerKey="" headerValue="--Select State--" /></td>
				
		</tr>
		<tr>
		        <td width="20%"><font class="bodyText"><s:text name="label.charges" /></font></td>
				<td  width="14%" class="bodyText" ><s:radio name="editpenappco.chargesFlag" id="chargesFlag"  value="%{editpenappdata.chargesFlag}" list="#{'Yes':'Yes','No':'No'}" onclick="disableEnableCharges();" > </s:radio> </td>
				<td><font class="bodyText"><s:text name="label.chargesdetails" /></font></td>
				<s:hidden id="HiddenChargesFlag" value="%{editpenappdata.chargesFlag}"></s:hidden>
				<td><s:textarea name="editpenappco.chargeDetails" id="chargeDetails"  value="%{editpenappdata.chargeDetails}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" disabled="true" /></td>		
			
				<td width="20%"><font class="bodyText"><s:text name="label.penpayoffice" /></font><font color="red" class="bodyText">*</font></td>				
				<td><s:select name="editpenappco.pensionPayOfficeId" id="pensionPayOfficeId"  value="%{editpenappdata.pensionPayOfficeId}" list="payOfficeList" listKey="currAccountOfficeId1" listValue="currAccountOfficeName" headerKey="" headerValue="--Select--" /> </td>	
				<s:hidden id="chk" value="%{editpenappdata.pensionPayOfficeId}" />
		</tr>
			
			<tr>
			<td><font class="bodyText">Date of Applicant Applied for Pension</font><font color="red" class="bodyText">*</font></td>
						<td><s:textfield name="editpenappco.appliedDate" id="appliedDate" value="%{editpenappdata.appliedDate2}" size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" onchange="checkdate(this);" onblur="checkdate(this);" />
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
					<s:iterator value="editpenappnom">					
					<tr id="<s:property value='%{nomineeId}'/>" >					
					<td width="5%" align="center"><s:textfield name="nomineeInitial" id="nomineeInitial" value="%{nomineeInitial}" size="5" maxlength="10" cssClass="textbox" /></td>
					<td width="15%" align="center"><s:textfield name="familyMembers" id="familyMembers" value="%{familyMembers}"  maxlength="50" cssClass="textbox" /></td>
					<td width="10%" align="center"><s:select name="relation" id="relation" value="%{relation}" list="#{'1':'Father','2':'Mother','3':'Spouse','5':'Son','6':'Daughter'}"/></td>
					<td width="10%" align="center"><s:textfield name="nomineeDob" id="nomineeDob" value="%{nomineeDob2}" size="10" maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox" /></td>
					<td width="5%" align="center"><s:textfield name="nomineeAge" id="nomineeAge" value="%{nomineeAge}"  size="3" maxlength="3" cssClass="textbox" /></td>
					<td width="10%" align="center"><s:select name="handicapped" id="handicapped" value="%{handicapped}" list="#{'Y':'Yes','N':'No'}" /></td>
					<td width="10%" align="center"><s:select name="martialStatus" id="martialStatus" value="%{martialStatus}" list="#{'Married':'Married','Unmarried':'Unmarried'}" /></td>
					<td width="10%" align="center"><s:textfield name="nominationDate" id="nominationDate" value="%{nominationDate2}" size="10" maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox"/></td>				
					<td width="10%" align="center"><s:select name="activeStatus" id="activeStatus" value="%{activeStatus}" list="#{'Yes':'Yes','No':'No'}" /></td>
					<td width="10%" align="center"><s:textfield name="nominReason" id="nominReason" value="%{nominReason}" maxlength="30" cssClass="textbox" /></td>	
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
					<table border="1" align="center" width="100%" class="tableGrid">
					<tr>				
						<td><font class="bodyText"><s:text name="label.nominname" /></font></td>
						<td><s:textfield name="editpenappco.dcrgNomineeName" id="dcrgNomineeName" value="%{editpenappdata.dcrgNomineeName}" maxlength="60" theme="simple" cssClass="textbox" /></td>
						<td><font class="bodyText"><s:text name="label.dob" /></font></td>
						<td><s:textfield name="editpenappco.dcrgNomineeDob" id="dcrgNomineeDob" value="%{editpenappdata.dcrgNomineeDob2}" size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
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
						<td><s:textfield name="editpenappco.dcrgRelation" id="dcrgRelation" value="%{editpenappdata.dcrgRelation}" maxlength="30" theme="simple" cssClass="textbox" /></td>	
						<td><font class="bodyText"><s:text name="label.address" /></font></td>
						<td><s:textarea name="editpenappco.dcrgAddress" id="dcrgAddress" value="%{editpenappdata.dcrgAddress}" 
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
							<td width="15%" align="center"><font class="bodyText"><strong>Start Date</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>End Date</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Reason</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Years</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Months</strong></font></td>
							<td width="15%" align="center"><font class="bodyText"><strong>Days</strong></font></td>
							<th width="5%" align="center"><font class="bodyText"><s:text name="label.delete" /></font></th>			
						</tr>						
							<tbody id="notVerifyService">
								<s:iterator value="editpenappnvs">					
								<tr id="<s:property value='%{id}'/>" >									
									<td width="15%" align="center"><s:textfield name="notVerifyServFromDate" id="notVerifyServFromDate" value="%{notVerifyServFromDate2}"  maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyServToDate" id="notVerifyServToDate" value="%{notVerifyServToDate2}"  maxlength="10" onkeyup="dtval(this,event);" onblur="calculateService(id);" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyServiceReason" id="notVerifyServiceReason" value="%{notVerifyServiceReason}" cssClass="textbox" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyYear" id="notVerifyYear" value="%{notVerifyYear}"  maxlength="" readonly="true" cssClass="readonlytext" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyMonth" id="notVerifyMonth" value="%{notVerifyMonth}"   maxlength="" readonly="true" cssClass="readonlytext" /></td>
									<td width="15%" align="center"><s:textfield name="notVerifyDays" id="notVerifyDays" value="%{notVerifyDays}"  maxlength="" readonly="true" cssClass="readonlytext" /></td>
									<td width="5%" align="center"><img src="../images/delete.png" align="middle" onclick="javascript:Delete1(<s:property value='%{id}'/>)"/></td>
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
					<table border="1" align="right" class="tableGrid" width="30%">
						<tr>
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totyear" /></font></strong></td>
							<td width="50%"><s:textfield name="editpenappco.notVerifyServiceTotYears" id="notVerifyServiceTotYears" value="%{editpenappdata.notVerifyServiceTotYears}"  maxlength="6" theme="simple" cssClass="readonlytext" readonly="true" /></td>	
						</tr>		
						
						<tr>	
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totmonth" /></font></strong></td>
							<td width="50%"><s:textfield name="editpenappco.notVerifyServiceTotMonths" id="notVerifyServiceTotMonths" value="%{editpenappdata.notVerifyServiceTotMonths}" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true"    /></td>	
						</tr>
						
						<tr>	
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totdays" /></font></strong></td>
							<td width="50%"><s:textfield name="editpenappco.notVerifyServiceTotDays" id="notVerifyServiceTotDays" value="%{editpenappdata.notVerifyServiceTotDays}"  maxlength="6" theme="simple" cssClass="readonlytext" readonly="true"    /></td>				
						</tr>
					</table>
					</td>
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
