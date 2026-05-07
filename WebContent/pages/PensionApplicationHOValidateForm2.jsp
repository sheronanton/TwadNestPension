<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="label.penapphovalid" /></title>
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

function setRadio()
{
	var genFlag=document.getElementById("hiddengender").value;
	var charFlag=document.getElementById("hiddenChargeFlag").value;
	
	if(genFlag.trim()=='M')		
	{
		document.getElementById("genderM").checked=true;	
		document.getElementById("husbandName").value="";
		document.getElementById("husbandName").disabled=true;	
	}
	else
	{
		document.getElementById("genderF").checked=true;
	}

	if(charFlag.trim()=='Yes') {		
		document.getElementById("chargeDetails").disabled=false;
	}
	else {		
		document.getElementById("chargeDetails").value="";
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

function specialcharecter(fieldval)
{
	//alert('welcome gopi' + fieldval.value);
    var iChars = "!`@#$%^&*()+=-[]\\\';{}|\":<>?~_"; 
    
    var data = fieldval.value;
    var name=fieldval.id;    
    if(name=="permanentAddress")
    {
        name="PERMANENT ADDRESS";
    }
    else if(name=="presentAddress")
    {
    	name="PRESENT ADDRESS";
    }
    else if(name=="addressAfterRetire")
    {
    	name="ADDRESS AFTER RETIREMENT";
    }
    else if(name=="dcrgAddress")
    {
    	name="DCRG ADDRESS";
    }
    else
    {
        name="";
    }
    
    for (var i = 0; i < data.length; i++)
    {   
        if (iChars.indexOf(data.charAt(i)) != -1)
        {    
        alert (name+" has special characters. \nThese are not allowed.\n !`@#$%^&*()+=-[]\';{}|\":<>?~_ . \n Please remove them and try again.");        
        fieldval.value = "";
        return false; 
        } 
    }   
}

</script>

</head> 

<body onload="disableEnterKey(event);setRadio();freezcheck();">


<br>
<s:form name="pensionApplication" action="penAppSaveValidateData" method="POST"  namespace="/pages" onsubmit="return CheckValidation();" >

<div class="demo" >
<div id="tab11" style="background-color:#E9F5F5">

 <s:hidden value="%{penapphoco.chargesFlag}" id="hiddenChargeFlag" name="hiddenChargeFlag" />
 
 <%-- <s:textfield value="%{penapfrzchk}" ></s:textfield> --%>
<table border="0" align="center" width="100%" > 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4"><s:text name="label.penapphovalid" /></font></td>
		</tr>
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.empno" /></font></td>
			<td width="15%">
				<s:hidden name="penapphoval.empNo" id="empNo" theme="simple" value="%{HiddenSelectedNo}" />
				<s:label id="empNoLabel" name="empNoLabel" theme="simple" cssClass="bodyTextBold" disabled="true" value="%{penapphoco.empNo}"></s:label>
				
				</td>		
			<td width="20%"><font class="bodyText"><s:text name="label.empname" /></font></td>
			<td width="15%">
				<s:hidden name="penapphoval.empName" id="empName" theme="simple" value="%{penapphoco.empName}" />
				<s:label id="empNameLabel" name="empNameLabel" theme="simple" cssClass="bodyTextBold" disabled="true" value="%{penapphoco.empName}"></s:label>
			</td>		
			
			<td width="15%"><font class="bodyText"><s:text name="label.gender" /></font></td>
			<td width="20%" class="bodyText" >
				<s:radio name="gen" id="gender" list="#{'M':'Male','F':'Female'}" disabled="true" ></s:radio> 
				<s:hidden name="penapphoval.gender" id="hiddengender" value="%{penapphoco.gender}"/>
			</td>				
		</tr>	
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.designation" /></font></td>
			<td width="15%">
				<s:label id="designationLabel" name="designationLabel" theme="simple" cssClass="bodyTextBold" value="%{designStr}"></s:label>
				<s:hidden name="penapphoval.desigId" id="desigId" value="%{penapphoco.desigId}" />
				<s:hidden name="penapphoval.desigServiceGrp" id="desigServiceGrp" value="%{penapphoco.desigServiceGrp}" />
			</td>					
			<td width="20%"><font class="bodyText"><s:text name="label.grade"  /></font></td>
			<td width="15%">
				<s:hidden name="penapphoval.gradeId" id="grade" theme="simple" value="%{penapphoco.gradeId}" />
				<s:label id="gradeLabel" name="gradeLabel" theme="simple" cssClass="bodyTextBold" value="%{penapphoco.gradeId}" ></s:label>
			</td>
			<td width="15%"><font class="bodyText"><s:text name="label.office" /></font></td>
			<td width="20%">
				<s:label id="officeLabel" name="officeLabel" theme="simple" cssClass="bodyTextBold" value="%{officeStr}" ></s:label>
				<s:hidden name="penapphoval.officeId" id="officeId" value="%{penapphoco.officeId}" />
			</td>
		</tr>			
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.gpfno" /></font></td>			
			<td width="15%">
				<s:label id="gpfNoLabel" name="gpfNoLabel" theme="simple"  cssClass="bodyTextBold" value="%{penapphoco.gpfNo}" ></s:label>
				<s:hidden name="penapphoval.gpfNo" id="gpfNo" theme="simple" value="%{penapphoco.gpfNo}" />
			</td>					
				<td width="20%"><font class="bodyText"><s:text name="label.fathername" /></font></td>			
				<td  width="15%"><s:textfield name="penapphoval.fatherName" id="fatherName" disabled="true" value="%{penapphoco.fatherName}"  maxlength="50" theme="simple" cssClass="textbox"></s:textfield> </td>
				<td width="15%"><font class="bodyText"><s:text name="label.husbandname" /></font></td>
				<td  width="20%"><s:textfield name="penapphoval.husbandName" id="husbandName" disabled="true" value="%{penapphoco.husbandName}" maxlength="50" theme="simple" cssClass="textbox" ></s:textfield> </td>
			</tr>
		<tr>	
			
			<td width="20%"><font class="bodyText"><s:text name="label.religion" /></font></td>
			<td width="15%">			
				<s:select name="penapphoval.religion" disabled="true" id="religion" list="religionCombo" listKey="religionCode" listValue="religionName" value="%{penapphoco.religion}" theme="simple" headerKey="0" headerValue="--Select--" ></s:select>			
			</td>			
			<td width="15%"><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td width="20%"><s:textfield name="penapphoval.nationality" disabled="true" id="nationality"  value="%{penapphoco.nationality}"  maxlength="40" theme="simple" cssClass="textbox" /></td>		
			<td width="15%"><font class="bodyText"><s:text name="label.height" /></font> </td>
			<td width="15%"><s:textfield name="penapphoval.empHeight" disabled="true" id="empHeight" value="%{penapphoco.empHeight}"   maxlength="10" theme="simple" cssClass="textbox" /></td>		
		
		</tr>	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.idmark1" /></font> </td>
			<td width="15%"><s:textarea name="penapphoval.idMark1" id="idMark1" disabled="true" value="%{penapphoco.idMark1}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>
			<td width="15%"><font class="bodyText"><s:text name="label.idmark2" /></font> </td>
			<td width="20%"><s:textarea name="penapphoval.idMark2" id="idMark2" disabled="true" value="%{penapphoco.idMark2}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>		
			<td width="15%"><font class="bodyText"><s:text name="label.presentaddress" /></font></td>
			<td width="15%"><s:textarea name="penapphoval.presentAddress" id="presentAddress" disabled="true" value="%{penapphoco.presentAddress}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.presentAddress,this.form.countdown,100);" 
				onkeyup="limitText(this.form.presentAddress,this.form.countdown,100);"				 
				onchange="specialcharecter(this.form.presentAddress);">
				
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown" size="3" value="100"> characters left.</font>
			</td>	 						
			
		</tr>	
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.permanentaddress" /></font></td>
			<td width="15%"><s:textarea name="penapphoval.permanentAddress" disabled="true" id="permanentAddress" value="%{penapphoco.permanentAddress}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.permanentAddress,this.form.countdown1,100);" 
				onkeyup="limitText(this.form.permanentAddress,this.form.countdown1,100);"				 
				onchange="specialcharecter(this.form.permanentAddress);">
				
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown1" size="3" value="100"> characters left.</font>
			</td>						
			
			<td width="20%"><font class="bodyText"><s:text name="label.addressretire" /></font></td>
			<td width="15%"><s:textarea name="penapphoval.addressAfterRetire" disabled="true" id="addressAfterRetire" value="%{penapphoco.addressAfterRetire}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.addressAfterRetire,this.form.countdown2,100);" 
				onkeyup="limitText(this.form.addressAfterRetire,this.form.countdown2,100);"				 
				onchange="specialcharecter(this.form.addressAfterRetire);" >				
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown2" size="3" value="100"> characters left.</font>
			</td>		
			
			<td width="15%"><font class="bodyText"><s:text name="label.retirestate" /></font></td>
			<td width="20%"><s:select name="penapphoval.stateId" id="stateId" disabled="true" list="stateList" listKey="stateId" listValue="stateName" value="%{penapphoco.stateId}"  headerKey="0" headerValue="--Select State--" /></td>
				
		</tr>
		<tr>
		        <td width="15%"><font class="bodyText"><s:text name="label.charges" /></font></td>
				<td width="15%" class="bodyText" ><s:radio name="penapphoval.chargesFlag" disabled="true" id="chargesFlag" list="#{'Yes':'Yes','No':'No'}"  value="%{penapphoco.chargesFlag}"  onclick="javascript:disableEnableCharges();" > </s:radio> </td>
				<td width="20%"><font class="bodyText"><s:text name="label.chargesdetails" /></font></td>
				<td width="15%"> <s:textarea name="penapphoval.chargeDetails" id="chargeDetails"  disabled="true" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>		
				<td width="15%"><font class="bodyText"><s:text name="label.penpayoffice" /></font></td>				
				<td width="20%"><s:select name="penapphoval.pensionPayOfficeId" id="pensionPayOfficeId" disabled="true" list="payOfficeList" listKey="currAccountOfficeId1" listValue="currAccountOfficeName"   value="%{penapphoco.pensionPayOfficeId1}"   headerKey="0" headerValue="--Select--" /> </td>	
		</tr>
	
		<tr>
		 		<td width="15%"><font class="bodyText"><s:text name="label.appdate" /></font></td>
				<td width="15%"> <s:textfield name="penapphoval.appliedDate" id="appliedDate" disabled="true" value="%{penapphoco.appliedDate2}"  size="10" maxlength="10" theme="simple" cssStyle="border:#ffba14 1.5px solid" />
				<img src="../images/calendr3.gif" id="cal-button-10"   align="middle" />			
					 	<script type="text/javascript">
		            		Calendar.setup({
		              		inputField    : "appliedDate",
		              		button        : "cal-button-10",
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
		<li><a href="#tabs-3">Death Check List</a></li>
		<li><a href="#tabs-4">Pension Check List</a></li>
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
						
						<th width="5%" align="center"><font class="bodyText"><s:text name="label.initial"/></font></th>
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
					<s:iterator value="penapphonom" >				
					<tr id="<s:property value='nomineeId'/>" >
						<td width="5%" align="center" ><s:textfield name="nomineeInitial" id="nomineeInitial" value="%{nomineeInitial}" size="5" maxlength="10" cssClass="textbox" disabled="true"/></td>
						<td width="15%" align="center"><s:textfield name="familyMembers" id="familyMembers" value="%{familyMembers}"  maxlength="30" cssClass="textbox"  disabled="true"/></td>
						<td width="10%" align="center"><s:select name="relation" id="relation" value="%{relation}" list="#{'1':'Father','2':'Mother','3':'Spouse','4':'Son','5':'Daughter'}"  disabled="true"/></td>
						<td width="10%" align="center"><s:textfield name="nomineeDob" id="nomineeDob" value="%{nomineeDob2}" size="10" maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox"  disabled="true"/></td>
						<td width="5%" align="center"><s:textfield name="nomineeAge" id="nomineeAge" value="%{nomineeAge}"  size="3" maxlength="3" cssClass="textbox" disabled="true" /></td>
						<td width="10%" align="center"><s:select name="handicapped" id="handicapped" value="%{handicapped}" list="#{'Y':'Yes','N':'No'}"  disabled="true"/></td>
						<td width="10%" align="center"><s:select name="martialStatus" id="martialStatus" value="%{martialStatus}" list="#{'Married':'Married','Unmarried':'Unmarried'}"  disabled="true"/></td>
						<td width="10%" align="center"><s:textfield name="nominationDate" id="nominationDate" value="%{nominationDate2}" size="10" maxlength="10" onkeyup="dtval(this,event);" cssClass="textbox"  disabled="true"/></td>				
						<td width="10%" align="center"><s:select name="activeStatus" id="activeStatus" value="%{activeStatus}" list="#{'Yes':'Yes','No':'No'}"  disabled="true"/></td>
						<td width="10%" align="center"><s:textfield name="nominReason" id="nominReason" value="%{nominReason}" cssClass="textbox"  disabled="true"/></td>	
						<td width="5%" align="center"><button disabled="disabled"><img src="../images/delete.png" align="middle"id="delbtn" name="delbtn"   onclick="javascript:Delete(<s:property value='%{nomineeId}'/>)" /></button></td>
					</tr>	
							
					</s:iterator>
					</tbody>
						
				</table>
				
				</td>
			</tr>
			
			
			
			
			<tr>
				<td align="center"><input type="button" id="add_new1" name="add_new1"  value="Add New" disabled="disabled" onclick="javascript:addNewNominee();"> </td>
			</tr>
			
			<tr bgcolor="#BCC0C4">
				<td align="center"><font class="textHeader"><strong><s:text name="label.nominfordcrg" /></strong></font></td>						
			</tr>
			
			<tr>			
				<td>
					<table border="1" align="center" width="100%" class="tableGrid">
					<tr>				
						<td><font class="bodyText"><s:text name="label.nominname" /></font></td>
						<td><s:textfield name="penapphoval.dcrgNomineeName" id="dcrgNomineeName" disabled="true" value="%{penapphoco.dcrgNomineeName}"  maxlength="50" theme="simple" cssClass="textbox" /></td>
						<td><font class="bodyText"><s:text name="label.dob" /></font></td>
						<td><s:textfield name="penapphoval.dcrgNomineeDob" id="dcrgNomineeDob" disabled="true" value="%{penapphoco.dcrgNomineeDob2}"   size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
						 <img src="../images/calendr3.gif"  id="cal-button-4" align="middle"  />			
					 	<script type="text/javascript">
		            		Calendar.setup({
		              		inputField    : "dcrgNomineeDob",
		              		button        : "cal-button-4",
		              		align         : "Tr"
		            		});
		          		</script>
						</td>
						<td><font class="bodyText"><s:text name="label.relationship" /></font></td>
						<td><s:textfield name="penapphoval.dcrgRelation" id="dcrgRelation" value="%{penapphoco.dcrgRelation}" disabled="true" maxlength="25" theme="simple" cssClass="textbox" /></td>	
						<td><font class="bodyText"><s:text name="label.address" /></font></td>
						<td><s:textarea name="penapphoval.dcrgAddress" id="dcrgAddress" value="%{penapphoco.dcrgAddress}" disabled="true" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
											onkeydown="limitText(this.form.dcrgAddress,this.form.countdown3,100);" 
				onkeyup="limitText(this.form.dcrgAddress,this.form.countdown3,100);"				 
				onchange="specialcharecter(this.form.dcrgAddress);">				
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown3" size="3" value="100"> characters left.</font>
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
								<s:iterator value="penapphoser">					
								<tr id="<s:property value='%{id}'/>" >									
								<td width="15%" align="center"><s:textfield name="notVerifyServFromDate" id="notVerifyServFromDate" value="%{notVerifyServFromDate2}"  maxlength="10" onkeyup="dtval(this,event);" onblur="javascript:checkValidDate(this);" cssClass="textbox" /></td>
								<td width="15%" align="center"><input type="text" name="notVerifyServToDate" id="notVerifyServToDate" value="<s:property value='%{notVerifyServToDate2}'/>" onchange="javascript:checkValidtoDate(this);" maxlength="10" onkeyup="dtval(this,event);"  onblur="javascript:checkValidtoDate(this);calculateService(<s:property value='%{id}'/>);" class="textbox" /></td>
								<td width="15%" align="center"><s:textfield name="notVerifyServiceReason" id="notVerifyServiceReason" value="%{notVerifyServiceReason}" cssClass="textbox"/></td>
								<td width="15%" align="center"><s:textfield name="notVerifyYear" id="notVerifyYear" value="%{notVerifyYear}"  maxlength="" readonly="true" cssClass="readonlytext"/></td>
								<td width="15%" align="center"><s:textfield name="notVerifyMonth" id="notVerifyMonth" value="%{notVerifyMonth}"   maxlength="" readonly="true" cssClass="readonlytext"/></td>
								<td width="15%" align="center"><s:textfield name="notVerifyDays" id="notVerifyDays" value="%{notVerifyDays}"  maxlength="" readonly="true" cssClass="readonlytext"/></td>
								<td width="5%" align="center"><img src="../images/delete.png" align="middle" id="delbtn2" name="delbtn2" onclick="javascript:Delete1(<s:property value='%{id}'/>);" /></td>
								</tr>					
					</s:iterator>	
					
					</tbody>
							
					</table>
				</td>
				
				
			</tr>
			
			<tr>
				<td colspan="7" align="center"><input type="button" id="add_new2" value="Add New" onclick="javascript:addNewNotVerify();" /></td>
			</tr>
			
			<tr>
				<td>
					<table border="1" width="30%" class="tableGrid" align="right">
						<tr>										
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totyear" /></font></strong></td>
							<td  width="50%"><s:textfield name="penapphoval.notVerifyServiceTotYears" id="notVerifyServiceTotYears" value="%{penapphoco.notVerifyServiceTotYears}" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true" /></td>	
						</tr>
						
						<tr>	
							<td  width="50%"><strong><font class="bodyText"><s:text name="label.totmonth" /></font></strong></td>
							<td  width="50%"><s:textfield name="penapphoval.notVerifyServiceTotMonths" id="notVerifyServiceTotMonths" value="%{penapphoco.notVerifyServiceTotMonths}" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true" /></td>	
						</tr>
						
						<tr>	
							<td  width="50%"><strong><font class="bodyText"><s:text name="label.totdays" /></font></strong></td>
							<td  width="50%"><s:textfield name="penapphoval.notVerifyServiceTotDays" id="notVerifyServiceTotDays" value="%{penapphoco.notVerifyServiceTotDays}" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true" /></td>				
						</tr>
					</table>
				</td>
			</tr>			
		</table>
	</div>
		
		
		<div id="tabs-3" style=" background-color: #E9F5F5">	
		<table border="1" align="center" width="70%" class="tableGrid">			
			
			<tr bgcolor="#BCC0C4">
				<td colspan="4" align="center"><font class="textHeader"><strong><s:text name="label.deathchklist" /></strong></font></td>							
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.orgdeathcert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.dcfpDeathCertFlag" id="famDeathCertFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.dcfpDeathCertFlag}"  ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.dcfpDeathCertRemarks" id="famDeathCertDesc" value="%{penapphoco.dcfpDeathCertRemarks}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.heircert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.dcfpHeirCertFlag" id="famHeirCertFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.dcfpHeirCertFlag}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.dcfpHeirCertRemarks" id="famHeirCertDesc" value="%{penapphoco.dcfpHeirCertRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.servbookrec" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.dcfpServiceBookFlag" id="famServBookRecFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.dcfpServiceBookFlag}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.dcfpServiceBookRemarks" id="famServBookRecDesc" value="%{penapphoco.dcfpServiceBookRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<!--<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.lastpaydetails" /></font></td>
				<td colspan="3"><s:textfield name="penapphoval.dcfpLastPayDrwan"  id="famLastpayDrawn" value="%{penapphoco.dcfpLastPayDrwan}"  theme="simple" cssClass="readonlytext" readonly="true"></s:textfield></td>				
			</tr>
			-->
			<s:hidden name="penapphoval.dcfpLastPayDrwan"  id="famLastpayDrawn" theme="simple"  />
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.desrollfamilypen" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.dcfpFamilyPensionFlag" id="famRollFamilyPenFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.dcfpFamilyPensionFlag}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.dcfpFamilyPensionRemarks" id="famRollFamilyPenDesc" value="%{penapphoco.dcfpFamilyPensionRemarks}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.attphoto" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.dcfpPhotoAttachFlag" id="famPhotoFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.dcfpPhotoAttachFlag}" ></s:radio></font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.dcfpPhotoAttachRemarks" id="famPhotoDesc" value="%{penapphoco.dcfpPhotoAttachRemarks}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.specsign" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.dcfpSignAttachFlag" id="famSignFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.dcfpSignAttachFlag}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.dcfpSignAttachRemarks" id="famSignDesc" value="%{penapphoco.dcfpSignAttachRemarks}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
		
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.noduecert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.dcfpNoDueCertFlag" id="famNoDueFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.dcfpNoDueCertFlag}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.dcfpNoDueCertRemarks" id="famNoDueDesc" value="%{penapphoco.dcfpNoDueCertRemarks}" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<!--<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.amtfampenautho" /></font></td>
				<td colspan="3"><s:textfield id="famPensionAmount" name="penapphoval.dcfpPensionAmount" value="%{penapphoco.dcfpPensionAmount}" maxlength="15" theme="simple" cssClass="readonlytext" readonly="true"></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.amtgratuityautho" /></font></td>
				<td colspan="3"><s:textfield id="famDcrgAmount" name="penapphoval.dcfpGratuityAmount" value="%{penapphoco.dcfpGratuityAmount}" maxlength="15" theme="simple" cssClass="readonlytext" readonly="true" ></s:textfield></td>				
			</tr>		
			
		-->
		
		<s:hidden id="famPensionAmount" name="penapphoval.dcfpPensionAmount" />
		<s:hidden id="famDcrgAmount" name="penapphoval.dcfpGratuityAmount" />
		
		</table>
	</div>
		
		
		
	<div id="tabs-4" style=" background-color: #E9F5F5">	
		<table border="1" align="center" width="70%"  class="tableGrid" >			
			
			<tr bgcolor="#BCC0C4">
				<td colspan="4" align="center"><font class="textHeader"><strong><s:text name="label.penchklist" /></strong></font></td>									
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.desrollfamilypen" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penFamilyPensionFlag" id="penFamilyPensionFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penFamilyPensionFlag}"  ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penFamilyPensionRemarks" id="penFamilyPensionRemarks" value="%{penapphoco.penFamilyPensionRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.attphoto" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penPhotoAttachFlag" id="penPhotoAttachFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penPhotoAttachFlag}"  ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penPhotoAttachRemarks" id="penPhotoAttachRemarks" value="%{penapphoco.penPhotoAttachRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.specsign" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penSignAttachFlag" id="penSignAttachFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penSignAttachFlag}"  ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penSignAttachRemarks" id="penSignAttachRemarks" value="%{penapphoco.penSignAttachRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.noduecert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penNoDueCertFlag" id="penNoDueCertFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penNoDueCertFlag}"  ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penNoDueCertRemarks" id="penNoDueCertRemarks" value="%{penapphoco.penNoDueCertRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.consentrecover" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penConsentRecoverFlag" id="penConsentRecoverFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penConsentRecoverFlag}"  ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penConsentRecoverRemarks" id="penConsentRecoverRemarks" value="%{penapphoco.penConsentRecoverRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
				<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.orgdeathcert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penDeathCertFlag" id="penDeathCertFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penDeathCertFlag}"  ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penDeathCertRemarks" id="penDeathCertRemarks" value="%{penapphoco.penDeathCertRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.heircert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penHeirCertFlag" id="penHeirCertFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penHeirCertFlag}"  ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penHeirCertRemarks" id="penHeirCertRemarks" value="%{penapphoco.penHeirCertRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.servbookrec" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penServiceBookFlag" id="penServiceBookFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penServiceBookFlag}"  ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penServiceBookRemarks" id="penServiceBookRemarks" value="%{penapphoco.penServiceBookRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.declare" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penDeclareFlag" id="penDeclareFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penDeclareFlag}"  ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penDeclareRemarks" id="penDeclareRemarks" value="%{penapphoco.penDeclareRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.regardingdate" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penRegardDateFlag" id="penRegardDateFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penRegardDateFlag}"  ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penRegardDateRemarks" id="penRegardDateRemarks" value="%{penapphoco.penRegardDateRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.incrementsanction" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.penSanctionUptoDateFlag" id="penSanctionUptoDateFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.penSanctionUptoDateFlag}"  ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.penSanctionUptoDateRemarks" id="penSanctionUptoDateRemarks" value="%{penapphoco.penSanctionUptoDateRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.paymentplace" /></font></td>
				<td colspan="3"><s:textfield id="pensionPaymentPlace" name="penapphoval.pensionPaymentPlace" value="%{penapphoco.pensionPaymentPlace}"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.paymentgratuity" /></font></td>
				<td colspan="3"><s:textfield id="dcrgPaymentPlace" name="penapphoval.dcrgPaymentPlace"  value="%{penapphoco.dcrgPaymentPlace}"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.recover" /></font></td>
				<td colspan="3"><s:textfield id="recoveriesIfAny" name="penapphoval.recoveriesIfAny" value="%{penapphoco.recoveriesIfAny}"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.retireorder" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="penapphoval.retireOrderFlag" id="retireOrderFlag" list="#{'Yes':'Yes','No':'No'}" value="%{penapphoco.retireOrderFlag}"  ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="penapphoval.retireOrderRemarks" id="retireOrderRemarks" value="%{penapphoco.retireOrderRemarks}"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.deputation" /></font></td>
				<td colspan="3"><s:textfield id="deputationIfAny" name="penapphoval.deputationIfAny" value="%{penapphoco.deputationIfAny}"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
		</table>
	</div>
		
		
		
		
 	</div>
 	
</div>

	<div align="center">
	
		<input type="submit"  value=" Freeze "id="freezebtn" class="btn"/>&nbsp;
		<input type="button" name="cmdCancel" value=" Exit " class="btn" onclick="javascript:window.close()" />
	
</div>

</s:form>

</body>
</html>
