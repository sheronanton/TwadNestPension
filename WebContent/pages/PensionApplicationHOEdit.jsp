<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="label.penapphoedit" /></title>
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
	<script type="text/javascript" src="<s:url value="/javascript/PensionApplicationHOEdit.js" /> "></script>
	
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
    //alert(data);
    //alert(name);
    for (var i = 0; i < data.length; i++)
    {   
        if (iChars.indexOf(data.charAt(i)) != -1)
        {    
        	alert (name+" has special characters. \nThese are not allowed \n !`@#$%^&*()+=-[]\';{}|\":<>?~_ . \n Please remove them and try again.");        
        fieldval.value = "";
        return false; 
        } 
    }   
}


</script>

</head> 

<body onload="disableEnterKey(event);setRadio();callAjax();">
<br>
<s:form name="pensionApplication" action="penAppSaveHeadOfficeData" method="POST"  namespace="/pages" onsubmit="return CheckValidation();" >

<div class="demo">
<div id="tab11" style="background-color:#E9F5F5">
 
<table border="0" align="center" width="100%" > 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4"><s:text name="label.penapphoedit" /></font></td>
		</tr>
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.empno" /></font></td>
			<td width="15%">
				<s:hidden name="addpenappho.empNo" id="empNo" theme="simple" value="%{HiddenSelectedNo}" />
				<s:label id="empNoLabel" name="empNoLabel" theme="simple" cssClass="bodyTextBold" ></s:label>
				
				</td>		
			<td width="20%"><font class="bodyText"><s:text name="label.empname" /></font></td>
			<td width="15%">
				<s:hidden name="addpenappho.empName" id="empName" theme="simple" />
				<s:label id="empNameLabel" name="empNameLabel" theme="simple" cssClass="bodyTextBold" ></s:label>
			</td>		
			
			<td width="15%"><font class="bodyText"><s:text name="label.gender" /></font></td>
			<td width="20%" class="bodyText" >
				<s:radio name="gen" id="gender" list="#{'M':'Male','F':'Female'}" disabled="true" ></s:radio> 
				<s:hidden name="addpenappho.gender" id="hiddengender" />
			</td>				
		</tr>	
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.designation" /></font></td>
			<td width="15%">
				<s:label id="designationLabel" name="designationLabel" theme="simple" cssClass="bodyTextBold"></s:label>
				<s:hidden name="addpenappho.desigId" id="desigId"  />
				<s:hidden name="addpenappho.desigServiceGrp" id="desigServiceGrp" />
			</td>					
			<td width="20%"><font class="bodyText"><s:text name="label.grade" /></font></td>
			<td width="15%">
				<s:hidden name="addpenappho.gradeId" id="grade" theme="simple" />
				<s:label id="gradeLabel" name="gradeLabel" theme="simple" cssClass="bodyTextBold"></s:label>
			</td>
			<td width="15%"><font class="bodyText"><s:text name="label.office" /></font></td>
			<td width="20%">
				<s:label id="officeLabel" name="officeLabel" theme="simple" cssClass="bodyTextBold" ></s:label>
				<s:hidden name="addpenappho.officeId" id="officeId" />
			</td>
		</tr>			
		
		<tr>
			<td width="15%"><font class="bodyText"><s:text name="label.gpfno" /></font></td>			
			<td width="15%">
				<s:label id="gpfNoLabel" name="gpfNoLabel" theme="simple"  cssClass="bodyTextBold" ></s:label>
				<s:hidden name="addpenappho.gpfNo" id="gpfNo" theme="simple" />
			</td>		
			<td width="20%"><font class="bodyText"><s:text name="label.fathername" /></font></td>
			<td  width="15%"><s:textfield name="addpenappho.fatherName" id="fatherName"  maxlength="50" theme="simple" cssClass="textbox"></s:textfield> </td>
			<td width="15%"><font class="bodyText"><s:text name="label.husbandname" /></font></td>
			<td  width="20%"><s:textfield name="addpenappho.husbandName" id="husbandName" maxlength="50" theme="simple" cssClass="textbox" ></s:textfield> </td>
		</tr>
		<tr>	
			
			<td width="20%"><font class="bodyText"><s:text name="label.religion" /></font></td>
			<td width="15%">			
				<s:select name="addpenappho.religion"  id="religion" list="religionCombo" listKey="religionCode" listValue="religionName" theme="simple" headerKey="0" headerValue="--Select--" ></s:select>			
			</td>			
			<td width="15%"><font class="bodyText"><s:text name="label.nationality" /></font></td>
			<td width="20%"><s:textfield name="addpenappho.nationality" id="nationality" maxlength="40" theme="simple" cssClass="textbox" /></td>		
			<td width="15%"><font class="bodyText"><s:text name="label.height" /></font> </td>
			<td width="15%"><s:textfield name="addpenappho.empHeight" id="empHeight"  maxlength="10" theme="simple" cssClass="textbox" /></td>		
		
		</tr>	
		<tr>
			<td width="20%"><font class="bodyText"><s:text name="label.idmark1" /></font> </td>
			<td width="15%"><s:textarea name="addpenappho.idMark1" id="idMark1" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>
			<td width="15%"><font class="bodyText"><s:text name="label.idmark2" /></font> </td>
			<td width="20%"><s:textarea name="addpenappho.idMark2" id="idMark2" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"/></td>		
			<td width="15%"><font class="bodyText"><s:text name="label.presentaddress" /></font></td>
			<td width="15%"><s:textarea name="addpenappho.presentAddress" id="presentAddress" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
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
			<td width="15%"><s:textarea name="addpenappho.permanentAddress" id="permanentAddress" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid"
			onkeydown="limitText(this.form.permanentAddress,this.form.countdown1,100);" 
				onkeyup="limitText(this.form.permanentAddress,this.form.countdown1,100);"				 
				onchange="specialcharecter(this.form.permanentAddress);">
				
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown1" size="3" value="100"> characters left.</font>
			</td>	 
					
			
			<td width="20%"><font class="bodyText"><s:text name="label.addressretire" /></font></td>
			<td width="15%"><s:textarea name="addpenappho.addressAfterRetire" id="addressAfterRetire" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
			onkeydown="limitText(this.form.addressAfterRetire,this.form.countdown2,100);" 
				onkeyup="limitText(this.form.addressAfterRetire,this.form.countdown2,100);"				 
				onchange="specialcharecter(this.form.addressAfterRetire);" >				
				</s:textarea>
				<font size="1" color="red">(Maximum characters: 100)<br>
				You have <input readonly type="text" name="countdown2" size="3" value="100"> characters left.</font>
			</td>	 	
			
			<td width="15%"><font class="bodyText"><s:text name="label.retirestate" /></font></td>
			<td width="20%"><s:select name="addpenappho.stateId" id="stateId" list="stateList" listKey="stateId" listValue="stateName" headerKey="" headerValue="--Select State--" /></td>
				
		</tr>
		<tr>
		        <td width="15%"><font class="bodyText"><s:text name="label.charges" /></font></td>
				<td width="15%" class="bodyText" ><s:radio name="addpenappho.chargesFlag" id="chargesFlag" list="#{'Yes':'Yes','No':'No'}" onclick="javascript:disableEnableCharges();" > </s:radio> </td>
				<td width="20%"><font class="bodyText"><s:text name="label.chargesdetails" /></font></td>
				<td width="15%"> <s:textarea name="addpenappho.chargeDetails" id="chargeDetails"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid;" /></td>		
				<td width="15%"><font class="bodyText"><s:text name="label.penpayoffice" /></font></td>				
				<td width="20%"><s:select name="addpenappho.pensionPayOfficeId" id="pensionPayOfficeId" list="payOfficeList" listKey="currAccountOfficeId1" listValue="currAccountOfficeName"  headerKey="0" headerValue="--Select--" /> </td>	
		</tr>
	
		<tr>
		 		<td width="15%"><font class="bodyText"><s:text name="label.appdate" /></font></td>
				<td width="15%"> <s:textfield name="addpenappho.appliedDate" id="appliedDate" size="10" maxlength="10" theme="simple" cssStyle="border:#ffba14 1.5px solid" />
				<img src="../images/calendr3.gif" id="cal-button-10" align="middle" />			
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
				
					</tbody>
					
				</table>
				</td>
			</tr>
			
			
			
			
			<tr>
				<td align="center"><input type="button" id="addnew1" value="Add New" onclick="javascript:addNewNominee();"> </td>
			</tr>
			
			<tr bgcolor="#BCC0C4">
				<td align="center"><font class="textHeader"><strong><s:text name="label.nominfordcrg" /></strong></font></td>						
			</tr>
			
			<tr>			
				<td>
					<table border="1" align="center" width="100%" class="tableGrid">
					<tr>				
						<td><font class="bodyText"><s:text name="label.nominname" /></font></td>
						<td><s:textfield name="addpenappho.dcrgNomineeName" id="dcrgNomineeName"  maxlength="50" theme="simple" cssClass="textbox" /></td>
						<td><font class="bodyText"><s:text name="label.dob" /></font></td>
						<td><s:textfield name="addpenappho.dcrgNomineeDob" id="dcrgNomineeDob"  size="10" maxlength="10" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
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
						<td><s:textfield name="addpenappho.dcrgRelation" id="dcrgRelation"  maxlength="25" theme="simple" cssClass="textbox" /></td>	
						<td><font class="bodyText"><s:text name="label.address" /></font></td>
						<td><s:textarea name="addpenappho.dcrgAddress" id="dcrgAddress"  rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" 
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
								
					
					</tbody>
							
					</table>
				</td>
				
				
			</tr>
			
			<tr>
				<td colspan="7" align="center"><input type="button" id="addnew2"  value="Add New" onclick="javascript:addNewNotVerify();" /></td>
			</tr>
			
			<tr>
				<td>
					<table border="1" width="30%" class="tableGrid" align="right">
						<tr>										
							<td width="50%"><strong><font class="bodyText"><s:text name="label.totyear" /></font></strong></td>
							<td  width="50%"><s:textfield name="addpenappho.notVerifyServiceTotYears" id="notVerifyServiceTotYears" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true" /></td>	
						</tr>
						
						<tr>	
							<td  width="50%"><strong><font class="bodyText"><s:text name="label.totmonth" /></font></strong></td>
							<td  width="50%"><s:textfield name="addpenappho.notVerifyServiceTotMonths" id="notVerifyServiceTotMonths" maxlength="6" theme="simple" cssClass="readonlytext" readonly="true" /></td>	
						</tr>
						
						<tr>	
							<td  width="50%"><strong><font class="bodyText"><s:text name="label.totdays" /></font></strong></td>
							<td  width="50%"><s:textfield name="addpenappho.notVerifyServiceTotDays" id="notVerifyServiceTotDays"  maxlength="6" theme="simple" cssClass="readonlytext" readonly="true" /></td>				
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
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.dcfpDeathCertFlag" id="famDeathCertFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.dcfpDeathCertRemarks" id="famDeathCertDesc" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.heircert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.dcfpHeirCertFlag" id="famHeirCertFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.dcfpHeirCertRemarks" id="famHeirCertDesc" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.servbookrec" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.dcfpServiceBookFlag" id="famServBookRecFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.dcfpServiceBookRemarks" id="famServBookRecDesc" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			<!--			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.lastpaydetails" /></font></td>
				<td colspan="3"><s:textfield name="addpenappho.dcfpLastPayDrwan"  id="famLastpayDrawn"  theme="simple" cssClass="readonlytext" readonly="true"></s:textfield></td>				
			</tr>			
			-->
			<s:hidden name="addpenappho.dcfpLastPayDrwan"  id="famLastpayDrawn"  theme="simple"></s:hidden>
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.desrollfamilypen" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.dcfpFamilyPensionFlag" id="famRollFamilyPenFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.dcfpFamilyPensionRemarks" id="famRollFamilyPenDesc" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.attphoto" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.dcfpPhotoAttachFlag" id="famPhotoFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio></font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.dcfpPhotoAttachRemarks" id="famPhotoDesc" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.specsign" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.dcfpSignAttachFlag" id="famSignFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.dcfpSignAttachRemarks" id="famSignDesc" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.noduecert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.dcfpNoDueCertFlag" id="famNoDueFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.dcfpNoDueCertRemarks" id="famNoDueDesc" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<!--<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.amtfampenautho" /></font></td>
				<td colspan="3"><s:textfield id="famPensionAmount" name="addpenappho.dcfpPensionAmount" maxlength="15" theme="simple" cssClass="readonlytext" readonly="true"></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.amtgratuityautho" /></font></td>
				<td colspan="3"><s:textfield id="famDcrgAmount" name="addpenappho.dcfpGratuityAmount" maxlength="15" theme="simple" cssClass="readonlytext" readonly="true" ></s:textfield></td>				
			</tr>		
			
		-->
		

		<s:hidden id="famPensionAmount" name="addpenappho.dcfpPensionAmount"  theme="simple" ></s:hidden>
		<s:hidden id="famDcrgAmount" name="addpenappho.dcfpGratuityAmount" theme="simple"  ></s:hidden>
		
		</table>
	</div>
		
		
		
	<div id="tabs-4" style=" background-color: #E9F5F5">	
		<table border="1" align="center" width="70%"  class="tableGrid" >			
			
			<tr bgcolor="#BCC0C4">
				<td colspan="4" align="center"><font class="textHeader"><strong><s:text name="label.penchklist" /></strong></font></td>									
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.desrollfamilypen" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penFamilyPensionFlag" id="penFamilyPensionFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penFamilyPensionRemarks" id="penFamilyPensionRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.attphoto" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penPhotoAttachFlag" id="penPhotoAttachFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penPhotoAttachRemarks" id="penPhotoAttachRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.specsign" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penSignAttachFlag" id="penSignAttachFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penSignAttachRemarks" id="penSignAttachRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.noduecert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penNoDueCertFlag" id="penNoDueCertFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penNoDueCertRemarks" id="penNoDueCertRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.consentrecover" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penConsentRecoverFlag" id="penConsentRecoverFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penConsentRecoverRemarks" id="penConsentRecoverRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
				<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.orgdeathcert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penDeathCertFlag" id="penDeathCertFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penDeathCertRemarks" id="penDeathCertRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.heircert" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penHeirCertFlag" id="penHeirCertFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penHeirCertRemarks" id="penHeirCertRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.servbookrec" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penServiceBookFlag" id="penServiceBookFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penServiceBookRemarks" id="penServiceBookRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.declare" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penDeclareFlag" id="penDeclareFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio></font> </td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penDeclareRemarks" id="penDeclareRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.regardingdate" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penRegardDateFlag" id="penRegardDateFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penRegardDateRemarks" id="penRegardDateRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.incrementsanction" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.penSanctionUptoDateFlag" id="penSanctionUptoDateFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.penSanctionUptoDateRemarks" id="penSanctionUptoDateRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.paymentplace" /></font></td>
				<td colspan="3"><s:textfield id="pensionPaymentPlace" name="addpenappho.pensionPaymentPlace"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.paymentgratuity" /></font></td>
				<td colspan="3"><s:textfield id="dcrgPaymentPlace" name="addpenappho.dcrgPaymentPlace"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.recover" /></font></td>
				<td colspan="3"><s:textfield id="recoveriesIfAny" name="addpenappho.recoveriesIfAny"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.retireorder" /></font></td>
				<td width="20%"><font class="bodyText"><s:radio name="addpenappho.retireOrderFlag" id="retireOrderFlag" list="#{'Yes':'Yes','No':'No'}" ></s:radio> </font></td>
				<td width="10%"><font class="bodyText"><s:text name="label.remarks" /></font></td>
				<td width="30%"><s:textarea name="addpenappho.retireOrderRemarks" id="retireOrderRemarks" rows="3" cols="15" theme="simple" cssStyle="border:#ffba14 1.5px solid" /></td>
			</tr>
			
			<tr>
				<td width="40%"><font class="bodyText"><s:text name="label.deputation" /></font></td>
				<td colspan="3"><s:textfield id="deputationIfAny" name="addpenappho.deputationIfAny"  theme="simple" cssClass="textbox" ></s:textfield></td>				
			</tr>
			
		</table>
	</div>
		
		
		
		
 	</div>
 	
</div>

	<div align="center">
		<input type="radio" name="checkStatus" id="checkStatus" value="yes" checked="checked"/><font class="bodyText"><s:text name="label.partial" /></font>
		<input type="radio" name="checkStatus" id="checkStatus" value="no" /><font class="bodyText"><s:text name="label.fullsave" /></font><br><br>
		
		<input type="submit"  value=" Submit " id="submit" class="btn"/>&nbsp;
		<input type="button" name="cmdCancel" value=" Exit " class="btn" onclick="javascript:window.close()" />
</div>

</s:form>

</body>
</html>
