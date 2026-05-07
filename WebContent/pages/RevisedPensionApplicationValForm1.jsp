<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Validate Revised Pension Calculation</title>
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
	
	<link rel="stylesheet" href="<s:url value="/css/PensionCalcApplication.css"/>" type="text/css" />		
	<script type="text/javascript" src="<s:url value="/javascript/PensionApplicationHOForm1Common.js" />"> </script>
	<script type="text/javascript" src="<s:url value="/javascript/RevisedPensionCalculationFetchMstValData.js" />"> </script>
		
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

<script type="text/javascript" src="<s:url value="/javascript/RevisedPensionCalculationAverage_emoluments.js" />"> </script>
<script type="text/javascript" src="<s:url value="/javascript/RevisedPensionCalculationNon_Qualified_Service.js" />"> </script>
<script type="text/javascript" src="<s:url value="/javascript/PensionApplicationothdepartservice.js" />"> </script>

<style type="text/css">
table.border1 
{
	border-top:1px solid #aeaeae;
	border-left:1px solid #aeaeae;
	border-bottom:0px solid #ffffff;
	border-right:0px solid #ffffff;
}
table.border1 td,th
{
	border-top:0px solid #ffffff;
	border-left:0px solid #ffffff;
	border-bottom:1px solid #aeaeae;
	border-right:1px solid #aeaeae;
	padding:5px;		
}
.aetextbox
{
	width:70px; 
	height:20px; 
	font:12px Times New Roman; 
	color:#545a5d;
	border:1px solid #A0A0A0;
}
.aetextboxmonth
{
	width:40px; 
	height:20px; 
	font:12px Times New Roman; 
	color:#545a5d;
	border:1px solid #A0A0A0;
}
.nqstextbox
{
	width:40px; 
	height:20px; 
	font:12px Times New Roman; 
	color:#545a5d;
	border:1px solid #A0A0A0;
	text-align:right;
}
.recamountbox
{
	width:70px; 
	height:20px; 
	font:12px Times New Roman; 
	color:#545a5d;
	border:1px solid #A0A0A0;
}
.recdescriptionbox
{
	width:200px; 
	height:20px; 
	font:12px Times New Roman; 
	color:#545a5d;
	border:1px solid #A0A0A0;
}
</style>

</head> 

<body onload="fetchMstSettingData();">
<s:form name="AEForm" action="saveRevPensionValCalculation" method="POST"  namespace="/pages" >
<s:hidden name="Min_quali_wce_service" id="Min_quali_wce_service" ></s:hidden>
<s:hidden name="Selection_grade_gap" id="Selection_grade_gap" ></s:hidden>
<s:hidden name="Spl_grade_gap" id="Spl_grade_gap" ></s:hidden>
<s:hidden name="Vrs_eligible_yrs" id="Vrs_eligible_yrs" ></s:hidden>
<s:hidden name="Pension_eligible_yrs" id="Pension_eligible_yrs" ></s:hidden>
<s:hidden name="Family_pension_ceiling_yrs" id="Family_pension_ceiling_yrs" ></s:hidden>
<s:hidden name="Family_pension_ceiling_percent" id="Family_pension_ceiling_percent" ></s:hidden>
<s:hidden name="Family_pension_after_percent" id="Family_pension_after_percent" ></s:hidden>
<s:hidden name="Pension_half_yr_ceiling" id="Pension_half_yr_ceiling" ></s:hidden>
<s:hidden name="Dcrg_half_yr_celing" id="Dcrg_half_yr_celing" ></s:hidden>
<s:hidden name="revPensionValCalculation.Max_dcrg_amt" id="Max_dcrg_amt" ></s:hidden>
<s:hidden name="Avg_total_months" id="Avg_total_months" ></s:hidden>
<s:hidden name="Retirement_celing_yrs" id="Retirement_celing_yrs" ></s:hidden>
<s:hidden name="Weightage_max" id="Weightage_max" ></s:hidden>
<s:hidden name="da_percentage" id="da_percentage" ></s:hidden>
<s:hidden name="Family_pension_ceiling_age" id="Family_pension_ceiling_age" ></s:hidden>

<s:hidden name="Min_pension_amt" id="Min_pension_amt" ></s:hidden>
<s:hidden name="Max_pension_amt" id="Max_pension_amt" ></s:hidden>
<s:hidden name="Min_fam_pension_amt" id="Min_fam_pension_amt" ></s:hidden>
<s:hidden name="Max_fam_pension_amt" id="Max_fam_pension_amt" ></s:hidden>

<s:hidden name="revPensionValCalculation.age" id="age" ></s:hidden>
<s:hidden name="revPensionValCalculation.commuted_val" id="commuted_val" ></s:hidden>
<s:hidden name="revPensionValCalculation.finaltotppamount" id="finaltotppamount" ></s:hidden>


<s:hidden name="revPensionValCalculation.pensionamount" id="pensionamount" ></s:hidden>
<s:hidden name="revPensionValCalculation.fampensionamount" id="fampensionamount" ></s:hidden>
<s:hidden name="revPensionValCalculation.famafterpensionamount" id="famafterpensionamount" ></s:hidden>
<s:hidden name="revPensionValCalculation.dcrgamount" id="dcrgamount" ></s:hidden>
<s:hidden name="revPensionValCalculation.nohalfyearpen" id="nohalfyearpen" ></s:hidden>
<s:hidden name="revPensionValCalculation.nohalfyeardcrg" id="nohalfyeardcrg" ></s:hidden>
<s:hidden name="revPensionValCalculation.totcommutedamount" id="totcommutedamount" ></s:hidden>
<s:hidden name="revPensionValCalculation.reducedpensionamount" id="reducedpensionamount" ></s:hidden>
<s:hidden name="revPensionValCalculation.commutedamount" id="commutedamount" ></s:hidden>
<s:hidden name="revPensionValCalculation.damount" id="damount" ></s:hidden>


<s:hidden name="revPensionValCalculation.fam_pen_upto_seven_date" id="fam_pen_upto_seven_date" ></s:hidden>
<s:hidden name="revPensionValCalculation.fam_pen_after_seven_date" id="fam_pen_after_seven_date" ></s:hidden>


<s:hidden name="revPensionValCalculation.avg_pay_name_basic" id="avg_pay_name_basic" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_include_basic" id="avg_include_basic" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_da_basic" id="avg_da_basic" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_display_caption_basic" id="avg_display_caption_basic" ></s:hidden>

<s:hidden name="revPensionValCalculation.avg_pay_name_grade" id="avg_pay_name_grade" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_include_grade" id="avg_include_grade" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_da_grade" id="avg_da_grade" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_display_caption_grade" id="avg_display_caption_grade" ></s:hidden>

<s:hidden name="revPensionValCalculation.avg_pay_name_special" id="avg_pay_name_special" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_include_special" id="avg_include_special" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_da_special" id="avg_da_special" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_display_caption_special" id="avg_display_caption_special" ></s:hidden>

<s:hidden name="revPensionValCalculation.avg_pay_name_other1" id="avg_pay_name_other1" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_include_other1" id="avg_include_other1" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_da_other1" id="avg_da_other1" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_display_caption_other1" id="avg_display_caption_other1" ></s:hidden>

<s:hidden name="revPensionValCalculation.avg_pay_name_other2" id="avg_pay_name_other2" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_include_other2" id="avg_include_other2" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_da_other2" id="avg_da_other2" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_display_caption_other2" id="avg_display_caption_other2" ></s:hidden>

<s:hidden name="revPensionValCalculation.avg_pay_name_other3" id="avg_pay_name_other3" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_include_other3" id="avg_include_other3" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_da_other3" id="avg_da_other3" ></s:hidden>
<s:hidden name="revPensionValCalculation.avg_display_caption_other3" id="avg_display_caption_other3" ></s:hidden>


<s:hidden name="aws_year1" id="aws_year1" ></s:hidden>
<s:hidden name="aws_month1" id="aws_month1" ></s:hidden>
<s:hidden name="aws_day1" id="aws_day1" ></s:hidden>
<div class="demo">
<div id="tab11" style="background-color:#E9F5F5;">
 
<table border="0" align="center" width="100%"> 
		<tr>
			<td colspan="6" background="../images/bluebg1.jpg"><font color="white" size="4">Validate Revised Pension Calculation</font></td>
		</tr>		
		
		<tr>
			<td width="10%"><font class="bodyText">Employee No</font></td>
			<td width="25%"><s:textfield name="revPensionValCalculation.empNo" id="empNo"  theme="simple" cssClass="textbox" onchange="javascript:fetchMstDataCheckVal(this.value);" />
			<input type="button" name="" value="Select Emp.No." onclick="window.open('RevisedPensionApplicationValSearch.jsp','RevisedPensionApplicationValSearch','width=1000,height=600,scrollbars=yes')" />
			<s:hidden name="revPensionValCalculation.empInitial" id="empInitial" ></s:hidden>
			</td>		
			<td width="20%"><font class="bodyText">Employee Name</font></td>
			<td width="15%"><s:textfield name="revPensionValCalculation.empName" id="empName" theme="simple" cssClass="readonlytext" readonly="true" /></td>		
			<td width="15%"><font class="bodyText">Office</font></td>
			<td width="20%"><s:textfield name="" id="office"  theme="simple" cssClass="readonlytext" readonly="true"  />
			<s:hidden name="revPensionValCalculation.officeId" id="officeId" ></s:hidden>
			</td>		
		</tr>	
		<tr>
			<td width="10%"><font class="bodyText">Designation</font></td>
			<td width="25%"><s:textfield name="" id="designation" size="" maxlength="" theme="simple" cssClass="readonlytext" readonly="true" />
			<s:hidden name="revPensionValCalculation.desigId" id="desigId" ></s:hidden><s:hidden name="revPensionValCalculation.desigServiceGrp" id="desigServiceGrp" ></s:hidden>
			</td>		
			<td width="20%"><font class="bodyText">Date of Birth</font></td>
			<td width="15%"><s:textfield name="revPensionValCalculation.dateOfBirth" id="dateofBirth" size="10" maxlength="10" theme="simple" cssClass="readonlytext" readonly="true" /></td>
			<td width="15%"><font class="bodyText">Date of Joining</font></td>
			<td width="20%">
			<s:textfield name="revPensionValCalculation.twadDoj" id="twadDateofJoin" size="10" maxlength="10" theme="simple" cssClass="readonlytext" readonly="true" />
			<s:textfield name="revPensionValCalculation.twadDojsession" id="twadDateofJoinsession" size="2" maxlength="2" theme="simple" cssClass="readonlytext" readonly="true" />
			</td>												
		</tr>		
		<tr>
			<td width="10%"><font class="bodyText">Grade</font></td>
			<td width="25%"><s:textfield name="revPensionValCalculation.gradeId" id="gradeId" size="" maxlength="" theme="simple" cssClass="readonlytext" readonly="true" /></td>
			<td width="20%"><font class="bodyText">Scale of Pay</font></td>
			<td width="15%"><s:textfield name="revPensionValCalculation.scaleOfPay" id="scaleofpay" size="" maxlength="" theme="simple" cssClass="textbox"  /></td>
			<td width="15%"><font class="bodyText">GPF No.</font></td>
			<td width="20%" colspan="3"><s:textfield name="revPensionValCalculation.gpfNo" id="gpfNo" size="" maxlength="" theme="simple" cssClass="readonlytext" readonly="true"  /></td>	
		</tr>		
</table>
	
</div>
 


<div id="tabs" style="background-color:#FFEEBA">
	<ul>	
		<li><a href="#tabs-1">Pension Details</a></li>	
		<li><a href="#tabs-6">Other Department Service</a></li>	
		<li><a href="#tabs-2">Total Service</a></li>		
		<li><a href="#tabs-3">Last Pay Drawn</a></li>			
		<li><a href="#tabs-4" style="display: none">Average Emoluments</a></li>	
	</ul>
	
	
	<div id="tabs-1" style=" background-color: #E9F5F5;">
	<table border="0" width="100%" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">	
		<table border="0" align="center" width="100%" class="border1" cellpadding="0" cellspacing="0">
		
			<tr bgcolor="#BCC0C4">
				<td colspan="6" align="center"><font class="textHeader"><strong>Pension Details</strong></font></td>						
			</tr>
			
			<tr>
				<td align="left"><font class="bodyText">Type of Pension</font></td>
				<td align="left">					
					<s:select list="#{'1':'Super Annuation','2':'VRS','3':'Death'}" headerKey="" headerValue="--Select--" id="classPensionId" name="revPensionValCalculation.classPensionId" onchange="fetchEmployeeStatusData();typeofpension_selection();" />
								
				</td>
				
				<td align="left"><font class="bodyText">Date Of Super Annuation</font></td>
				<td align="left"><s:textfield name="revPensionValCalculation.dar" id="dar" size="10" maxlength="10" theme="simple" cssClass="readonlytext" readonly="true" /></td>
				<td align="left"><font class="bodyText">V.R.S Date</font></td>
				<td align="left"><s:textfield name="revPensionValCalculation.vrs_date" id="vrs_date" size="10" maxlength="10" onchange="vrs_date_calc();" onblur="vrs_date_calc();" theme="simple"  cssClass="textbox" onkeyup="dtval(this,event);" />
					<img src="../images/calendr3.gif" id="cal-button-7" align="middle" />			
				 	<script type="text/javascript">
	            		Calendar.setup({
	              		inputField    : "vrs_date",
	              		button        : "cal-button-7",
	              		align         : "Tr"
	            		});
	          		</script>
				</td>								
			</tr>
			
			
			
			<tr>				
				<td align="left"><font class="bodyText">WCE Service</font></td>
				<td align="left" class="bodyText"><s:radio name="revPensionValCalculation.wceserviceFlag" id="wceserviceFlag" list="#{'Yes':'Yes','No':'No'}" onclick="javascript:enableDisableWceServiceDetails(this);cal_other_tot_net_qualified_service();" /></td>					
				<td align="left"><font class="bodyText">WCE Service Period</font></td>
				<td align="left">Year :<s:textfield name="revPensionValCalculation.wceyear" id="wceyear" size="2" maxlength="2" theme="simple" cssClass="readonlytext" disabled="true" onchange="wceserviceChange();" onkeypress="return numonlywithoutdot(event);" />&nbsp;Months :<s:textfield name="revPensionValCalculation.wcemonth" id="wcemonth" size="2" maxlength="2" theme="simple" cssClass="readonlytext" disabled="true" onchange="wceserviceChange();" onkeypress="return numonlywithoutdot(event);" />&nbsp;Days:<s:textfield name="revPensionValCalculation.wceday" id="wceday" size="2" maxlength="2" theme="simple" cssClass="readonlytext" disabled="true" onchange="wceserviceChange();" onkeypress="return numonlywithoutdot(event);" /></td>										
				<td align="left"><font class="bodyText">WCE Service Counted</font></td>
				<td align="left" class="bodyText"><s:radio name="revPensionValCalculation.wcecountedFlag" id="wcecountedFlag" list="#{'Yes':'Yes','No':'No'}" onclick="cal_other_tot_net_qualified_service();" /></td>				
			</tr>
			
			<tr>				
				<td align="left"><font class="bodyText">Contingent Service</font></td>
				<td align="left" class="bodyText"><s:radio name="revPensionValCalculation.contingentserviceFlag" id="contingentserviceFlag" list="#{'Yes':'Yes','No':'No'}" onclick="javascript:enableDisablecontingentServiceDetails(this);cal_other_tot_cont_net_qualified_service();" /></td>					
				<td align="left"><font class="bodyText">Contingent Service Period</font></td>
				<td align="left">Year :<s:textfield name="revPensionValCalculation.contingentyear" id="contingentyear" size="2" maxlength="2" theme="simple" cssClass="readonlytext" disabled="true" onchange="contingent_service_validation();" onkeypress="return numonlywithoutdot(event);"/>&nbsp;Months :<s:textfield name="revPensionValCalculation.contingentmonth" id="contingentmonth" size="2" maxlength="2" theme="simple" cssClass="readonlytext" disabled="true" onchange="contingent_service_validation();" onkeypress="return numonlywithoutdot(event);" />&nbsp;Days:<s:textfield name="revPensionValCalculation.contingentday" id="contingentday" size="2" maxlength="2" theme="simple" cssClass="readonlytext" disabled="true" onchange="contingent_service_validation();" onkeypress="return numonlywithoutdot(event);" /></td>										
				<td align="left" class="bodyText">Death Date</td>	
				<td align="left"><s:textfield name="revPensionValCalculation.death_date" id="death_date" size="10" maxlength="10" onchange="death_date_calc();" onblur="death_date_calc();" theme="simple"  cssClass="textbox" onkeyup="dtval(this,event);" />
					<img src="../images/calendr3.gif" id="cal-button-13" align="middle" />			
				 	<script type="text/javascript">
	            		Calendar.setup({
	              		inputField    : "death_date",
	              		button        : "cal-button-13",
	              		align         : "Tr"
	            		});
	          		</script></td>							
			</tr>					
			
			<tr>
				<td align="left"><font class="bodyText">Date of Provincialisation</font></td>
				<td align="left"><s:textfield name="revPensionValCalculation.province_date" id="province_date" size="10" maxlength="10" onchange="province_date_validation();" onblur="province_date_validation();" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);"  />
					<img src="../images/calendr3.gif" id="cal-button-9" align="middle" />			
				 	<script type="text/javascript">
	            		Calendar.setup({
	              		inputField    : "province_date",
	              		button        : "cal-button-9",
	              		align         : "Tr"
	            		});
	          		</script>
				</td>
				<td align="left"><font class="bodyText">Date of Regular Establishment</font></td>
				<td align="left"><s:textfield name="revPensionValCalculation.regualr_estab_date" id="regualr_estab_date" size="10" maxlength="10" onchange="regular_est_date_validation();" onblur="regular_est_date_validation();" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
					<img src="../images/calendr3.gif" id="cal-button-10" align="middle" />			
				 	<script type="text/javascript">
	            		Calendar.setup({
	              		inputField    : "regualr_estab_date",
	              		button        : "cal-button-10",
	              		align         : "Tr"
	            		});
	          		</script>
				</td>	
				
				<td align="left"><font class="bodyText">Date of selection Grade</font></td>
				<td align="left"><s:textfield name="revPensionValCalculation.datOfSelectionGrade" id="selection_grade_date" size="10" maxlength="10" onchange="selection_grade();" onblur="selection_grade();" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
					<img src="../images/calendr3.gif" id="cal-button-11" align="middle" />			
				 	<script type="text/javascript">
	            		Calendar.setup({
	              		inputField    : "selection_grade_date",
	              		button        : "cal-button-11",
	              		align         : "Tr"
	            		});
	          		</script>
				</td>		
			</tr>
			
			
			<tr>
				<td align="left"><font class="bodyText">Date of Special Grade</font></td>
				<td align="left"><s:textfield name="revPensionValCalculation.dateOfSpecialGrade" id="special_grade_date" size="10" maxlength="10" onchange="special_grade();" onblur="special_grade();" theme="simple" cssClass="textbox" onkeyup="dtval(this,event);" />
					<img src="../images/calendr3.gif" id="cal-button-12" align="middle" />			
				 	<script type="text/javascript">
	            		Calendar.setup({
	              		inputField    : "special_grade_date",
	              		button        : "cal-button-12",
	              		align         : "Tr"
	            		});
	          		</script>
				</td>				
				<td align="left"><font class="bodyText">Pension Commuted</font></td>
				<td align="left" class="bodyText"><s:radio name="revPensionValCalculation.pensionCommutedFlag" id="pensionCommutedFlag" list="#{'Yes':'Yes','No':'No'}" onclick="javascript:enableDisableCommDetails(this);" /></td>					
				<td align="left"><font class="bodyText">Commuted percentage</font></td>
				<td align="left"><s:radio name="revPensionValCalculation.pensionpertFlag" id="pensionpertFlag" list="#{'onethird':'1/3','pert':'%'}" onclick="javascript:enableDisablePertDetails(this);" />&nbsp;<s:textfield name="revPensionValCalculation.commPert" id="commPert" size="2" maxlength="2" onkeypress="return numonlywithoutdot(event);" onchange="compert_validation();" theme="simple" cssClass="textbox" /></td>			
			</tr>	
			<tr>				
				<td align="left"><font class="bodyText">Other Department Service (Y/N)</font></td>
				<td align="left" class="bodyText">
				<s:radio name="revPensionValCalculation.otherdeparmentserviceFlag" id="otherdeparmentserviceFlag" list="#{'Yes':'Yes','No':'No'}"  onclick="javascript:enableDisableotherdepartmentDetails(this);" value="'No'" /></td>					
			</tr>	
		</table>
		</td>
		</tr>
		</table>	
	</div>
	
	<div id="tabs-6" style="background-color: #E9F5F5;" >
	 <table border="0" width="100%" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<table align="center" width="95%"  class="border1" cellpadding="0" cellspacing="0">		
						<tr bgcolor="#BCC0C4">
							<td align="center"><font class="textHeader"><strong>Other Department Service </strong></font></td>									
						</tr>
					</table>
				</td>
			</tr>
			<tr>
			<td>	
		<table id="my_dept_oth_div" width="95%" align="center" class="border1" cellpadding="0" cellspacing="0">
				<tr>
			          
			          <td align="center">From Date</td>
			          <td align="center">To Date</td>
			          <td align="center">Year</td>
					  <td align="center">Months</td>
					  <td align="center">Days</td>
					  <td align="center" id="Departmentname">DepartmentName</td>
					  <td align="center" id="Remarks">Remarks</td>
					  <td align="center" width="7%">Action</td>
						         
		       </tr>
		     <tbody id="othdeptser">
		     </tbody> 
	   	<tr>
				<td align="center" colspan="8">
					<input name="othdeptsersubmit_addrow" value="Add New" id="othdeptsersubmit_addrow" onclick="Addothdepartservice();" type="button">
					
				</td>
			</tr>
					 <tr>          
				      	<td colspan="2" align="center">Total Service</td>
		        		<td align="center"  >
						<input name="revPensionValCalculation.tototdepyear" id="tototdepyear1" value="" size="4" maxlength="4" readonly="readonly" style="background-color:#ececec;" type="text" class="aetextboxmonth">  
		  			</td>		
		 			<td align="center" >
						<input name="revPensionValCalculation.tototdepmonth" id="tototdepmonth1" value="" size="4" maxlength="2" readonly="readonly" style="background-color:#ececec;" type="text" class="aetextboxmonth">  
		  			</td>		
					<td align="center" >
						<input name="revPensionValCalculation.totothdeptday" id="totothdeptday1" value="" size="4" maxlength="2" readonly="readonly" style="background-color:#ececec;" type="text" class="aetextboxmonth">  
		  			</td>		
				
			</tr>
			
		</table>
		</td>
		</tr>
				
		</table>
		
	</div>
	
	<div id="tabs-2" style=" background-color: #E9F5F5;">
		<table border="0" width="100%" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">		 		
		 		<table border="0" width="50%" align="center" class="border1" cellpadding="0" cellspacing="0">						
						<tr>
							<td align="right" width="70%"><strong>Actual work Service: </strong>Service-(Contingent Service+WCE Service)</td>
							<td width="10%"><input type="text" name="aws_year" size="4" maxlength="2" value="" id="aws_year" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td width="10%"><input type="text" name="aws_month" size="4" maxlength="2" value="" id="aws_month" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td width="10%"><input type="text" name="aws_day" size="4" maxlength="2" value="" id="aws_day" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>		
						
						<tr>
							<td align="center" width="70%"><strong>Services Not Qualified for Pension</strong></td>
							<td width="10%">Years</td>
							<td width="10%">Months</td>
							<td width="10%">Days</td>				
						</tr>	
							
						<tr>
							<td align="left" width="20%">Non-Provisionalised Pension</td>
							<td><input type="text" name="revPensionValCalculation.npp_year" size="4" maxlength="2" value="" id="npp_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td ><input type="text" name="revPensionValCalculation.npp_month" size="4" maxlength="2" value="" id="npp_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.npp_day" size="4" maxlength="2" value="" id="npp_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>										
						</tr>	
										
						<tr>
							<td align="left" width="20%">EOL Without MC</td>
							<td><input type="text" name="revPensionValCalculation.ewm_year" size="4" maxlength="2" value="" id="ewm_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.ewm_month" size="4" maxlength="2" value="" id="ewm_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.ewm_day" size="4" maxlength="2" value="" id="ewm_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>							
						</tr>
										
						<tr>
							<td align="left" width="20%">Suspension(penalty)</td>
							<td><input type="text" name="revPensionValCalculation.s_year" size="4" maxlength="2" value="" id="s_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.s_month" size="4" maxlength="2" value="" id="s_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.s_day" size="4" maxlength="2" value="" id="s_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>								
						</tr>	
										
						<tr>
							<td align="left" width="20%">Boy Service</td>
							<td><input type="text" name="revPensionValCalculation.bs_year" size="4" maxlength="2" value="" id="bs_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.bs_month" size="4" maxlength="2" value="" id="bs_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.bs_day" size="4" maxlength="2" value="" id="bs_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>										
						</tr>
										
						<tr>
							<td align="left" width="20%">Overstayed of Leave and JT</td>
							<td><input type="text" name="revPensionValCalculation.ol_year" size="4" maxlength="2" value="" id="ol_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.ol_month" size="4" maxlength="2" value="" id="ol_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.ol_day" size="4" maxlength="2" value="" id="ol_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>								
						</tr>	
										
						<tr>
							<td align="left" width="20%">Leave Not Regularised</td>
							<td><input type="text" name="revPensionValCalculation.lnr_year" size="4" maxlength="2" value="" id="lnr_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.lnr_month" size="4" maxlength="2" value="" id="lnr_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.lnr_day" size="4" maxlength="2" value="" id="lnr_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>										
						</tr>
										
						<tr>
							<td align="left" width="20%">Apprentice Service</td>
							<td><input type="text" name="revPensionValCalculation.as_year" size="4" maxlength="2" value="" id="as_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.as_month" size="4" maxlength="2" value="" id="as_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.as_day" size="4" maxlength="2" value="" id="as_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
						</tr>	
										
						<tr>
							<td align="left" width="20%">Service Verification Not Done</td>
							<td><input type="text" name="revPensionValCalculation.svnd_year" size="4" maxlength="2" value="" id="svnd_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.svnd_month" size="4" maxlength="2" value="" id="svnd_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.svnd_day" size="4" maxlength="2" value="" id="svnd_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>										
						</tr>
										
						<tr>
							<td align="right" width="20%"><strong>Total Non Qualified Service:</strong></td>
							<td><input type="text" name="revPensionValCalculation.tqs_year" size="4" maxlength="2" value="" id="tqs_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td><input type="text" name="revPensionValCalculation.tqs_month" size="4" maxlength="2" value="" id="tqs_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td><input type="text" name="revPensionValCalculation.tqs_day" size="4" maxlength="2" value="" id="tqs_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>	
										
						<tr>
							<td align="left" width="20%">Period of Foreign Service for P.C not Received</td>
							<td><input type="text" name="revPensionValCalculation.fs_year" size="4" maxlength="2" value="" id="fs_year" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.fs_month" size="4" maxlength="2" value="" id="fs_month" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox"/></td>
							<td><input type="text" name="revPensionValCalculation.fs_day" size="4" maxlength="2" value="" id="fs_day" onkeypress="return numonlywithoutdot(event);" onchange="calctotalnqs();" class="nqstextbox" /></td>									
						</tr>
										
						<tr>
							<td align="right" width="20%"><strong>Net Qualifying Service:</strong></td>
							<td><input type="text" name="revPensionValCalculation.nqs_year" size="4" maxlength="2" value="" id="nqs_year" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td><input type="text" name="revPensionValCalculation.nqs_month" size="4" maxlength="2" value="" id="nqs_month" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td><input type="text" name="revPensionValCalculation.nqs_day" size="4" maxlength="2" value="" id="nqs_day" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						
						<tr>
							<td align="right" width="20%"><strong>Number of calculated half years:</strong></td>
							<td colspan="3" align="center"><input type="text" name="nohalf_year" size="4" maxlength="2" value="" id="nohalf_year" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>							
						</tr>						
				</table>
				</td>
			</tr>
			<tr>
				<td align="center" style="padding-top:30px;">		 		
			 		<table border="0" width="50%" align="center" class="border1" cellpadding="0" cellspacing="0">
			 			<tr>
							<td align="center" width="100%" colspan="4"><strong>Service Details</strong></td>
																	
						</tr>
								 		
			 		    <tr>
							<td align="left" width="70%" id="serdislable">Service by (Date of retirment - Date of join): </td>
							<td id="seryeardis"><input type="text" name="revPensionValCalculation.aws_yeardis" size="4" maxlength="2" value="" id="aws_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="sermonthdis"><input type="text" name="revPensionValCalculation.aws_monthdis" size="4" maxlength="2" value="" id="aws_monthdis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="serdaydis"><input type="text" name="revPensionValCalculation.aws_daydis" size="4" maxlength="2" value="" id="aws_daydis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						
						<tr>
							<td align="left" width="70%" id="weigtdislable" style="display:none;">Weightage: (+)</td>
							<td id="weigtyeardis" style="display:none;"><input type="text" name="revPensionValCalculation.weigt_yeardis" size="4" maxlength="2" value="" id="weigt_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="weigtmonthdis" style="display:none;"><input type="text" name="revPensionValCalculation.weigt_monthdis" size="4" maxlength="2" value="" id="weigt_monthdis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="weigtdaydis" style="display:none;"><input type="text" name="revPensionValCalculation.weigt_daydis" size="4" maxlength="2" value="" id="weigt_daydis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
			 			
						<tr>
							<td align="left" width="70%" id="contingentdislable" style="display:none;">Contingent Service: (-) (50% of actual contingent service)</td>
							<td id="contingentyeardis" style="display:none;"><input type="text" name="revPensionValCalculation.contingent_yeardis" size="4" maxlength="2" value="" id="contingent_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="contingentmonthdis" style="display:none;"><input type="text" name="revPensionValCalculation.contingent_monthdis" size="4" maxlength="2" value="" id="contingent_monthdis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="contingentdaydis" style="display:none;"><input type="text" name="revPensionValCalculation.contingent_daydis" size="4" maxlength="2" value="" id="contingent_daydis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						<tr>
							<td align="left" width="70%" id="fsdislable">Period of Foreign Service for P.C not Received:</td>
							<td id="fsyeardis"><input type="text" name="fs_yeardis" size="4" maxlength="2" value="" id="fs_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="fsmonthdis"><input type="text" name="fs_monthdis" size="4" maxlength="2" value="" id="fs_monthdis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="fsdaydis"><input type="text" name="fs_daydis" size="4" maxlength="2" value="" id="fs_daydis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						<tr>
							<td align="left" width="70%" id="wcedislable" style="display:none;">WCE Service: (-)</td>
							<td id="wceyeardis" style="display:none;"><input type="text" name="wce_yeardis" size="4" maxlength="2" value="" id="wce_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="wcemonthdis" style="display:none;"><input type="text" name="wce_monthdis" size="4" maxlength="2" value="" id="wce_monthdis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="wcedaydis" style="display:none;"><input type="text" name="wce_daydis" size="4" maxlength="2" value="" id="wce_daydis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						<tr>
							<td align="left" width="70%" id="nonqdislable">Non Qualified Service: (-)</td>
							<td id="nonqyeardis"><input type="text" name="nonq_yeardis" size="4" maxlength="2" value="" id="nonq_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="nonqmonthdis"><input type="text" name="nonq_monthdis" size="4" maxlength="2" value="" id="nonq_monthdis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="nonqdaydis"><input type="text" name="nonq_daydis" size="4" maxlength="2" value="" id="nonq_daydis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						
						<tr>
							<td align="right" width="70%" id="netqdislable"><strong>Net Qualifying Service: </strong></td>
							<td id="netqyeardis"><input type="text" name="netq_yeardis" size="4" maxlength="2" value="" id="netq_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="netqmonthdis"><input type="text" name="netq_monthdis" size="4" maxlength="2" value="" id="netq_monthdis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>
							<td id="netqdaydis"><input type="text" name="netq_daydis" size="4" maxlength="2" value="" id="netq_daydis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						
						<tr>
							<td align="right" width="70%" id="netqdislable"><strong>Number of half years for pension: </strong></td>
							<td colspan="3" align="center"><input type="text" name="nohalf_yeardis" size="4" maxlength="2" value="" id="nohalf_yeardis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
						<tr>
							<td align="right" width="70%" id="netqdislable"><strong>Number of half years for dcrg: </strong></td>
							<td colspan="3" align="center"><input type="text" name="nohalf_year_dcrg_dis" size="4" maxlength="2" value="" id="nohalf_year_dcrg_dis" class="nqstextbox" readonly="true" style="background-color:#ececec;" /></td>										
						</tr>
			 		
			 		</table>
		 		</td>
		 	</tr>
		</table>		 		
	</div>	
	
	  
	 
	  <div id="tabs-3" style=" background-color: #E9F5F5" >	
	  		<table border="0" width="100%" align="center" cellpadding="0" cellspacing="0">		
				<tr>
					<td align="center">
						<table align="center" width="95%"  class="border1" cellpadding="0" cellspacing="0">		
							<tr bgcolor="#BCC0C4">
								<td align="center"><font class="textHeader"><strong>Last Pay Drawn</strong></font></td>									
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table align="center" width="95%"  class="border1" cellpadding="0" cellspacing="0">		
							<tr>
								<td align="center" id="lastbasictcol"><div id="lastbasictitle"></div></td>			
								<td align="center" id="lastgradetcol" style="display: none"><div id="lastgradetitle"></div></td>			
								<td align="center" id="lastspecialtcol"><div id="lastspecialtitle"></div></td>	
								<td align="center" id="lastother1tcol"><div id="lastother1title"></div></td>			
								<td align="center" id="lastother2tcol"><div id="lastother2title"></div></td>			
								<td align="center" id="lastother3tcol"><div id="lastother3title"></div></td>
								<td align="center">Total&nbsp;&nbsp;<img src="../images/rupeessymbol.png" width="10" height="15" /></td>			
							</tr>
								
							<tr>
								<td align="center" id="lastbasiccol"><s:textfield name="revPensionValCalculation.lastbasic" id="lastbasic" theme="simple" cssStyle="text-align:right;" cssClass="aetextbox" onkeypress="return numonlywithoutdot(event);" onchange="lastcalc();"  /></td>	
								<td align="center" id="lastgradecol" style="display: none"><s:textfield name="revPensionValCalculation.lastgrade" id="lastgrade" theme="simple" cssStyle="text-align:right;" cssClass="aetextbox" onkeypress="return numonlywithoutdot(event);" onchange="lastcalc();" /></td>	
								<td align="center" id="lastspecialcol"><s:textfield name="revPensionValCalculation.lastspecial" id="lastspecial" theme="simple" cssStyle="text-align:right;" cssClass="aetextbox" onkeypress="return numonlywithoutdot(event);" onchange="lastcalc();" /></td>	
								<td align="center" id="lastother1col"><s:textfield name="revPensionValCalculation.lastother1" id="lastother1" theme="simple" cssStyle="text-align:right;" cssClass="aetextbox" onkeypress="return numonlywithoutdot(event);" onchange="lastcalc();" /></td>	
								<td align="center" id="lastother2col"><s:textfield name="revPensionValCalculation.lastother2" id="lastother2" theme="simple" cssStyle="text-align:right;" cssClass="aetextbox" onkeypress="return numonlywithoutdot(event);" onchange="lastcalc();" /></td>	
								<td align="center" id="lastother3col"><s:textfield name="revPensionValCalculation.lastother3" id="lastother3" theme="simple" cssStyle="text-align:right;" cssClass="aetextbox" onkeypress="return numonlywithoutdot(event);" onchange="lastcalc();" /></td>
								<td align="center"><s:textfield name="" id="lasttotal" theme="simple" cssStyle="text-align:right;background-color:#ececec;" cssClass="aetextbox" readonly="true" /></td>						
							</tr>		
						</table>
					</td>
				</tr>
			</table>
		</div>	
			
	   <div id="tabs-4" style=" background-color: #E9F5F5">	
	   <table border="0" width="100%" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<table align="center" width="95%"  class="border1" cellpadding="0" cellspacing="0">		
						<tr bgcolor="#BCC0C4">
							<td align="center"><font class="textHeader"><strong>Average Emoluments</strong></font></td>									
						</tr>
					</table>
				</td>
			</tr>
			<tr>
			<td>	
		<table id="my_div" width="95%" align="center" class="border1" cellpadding="0" cellspacing="0">
				<tr>
			          <td align="center">Not considered</td>
			          <td align="center">From Date</td>
			          <td align="center">To Date</td>
					  <td align="center">Months</td>
					  <td align="center">Days</td>
					  <td align="center" id="aebasictcol"><div id="aebasictitle"></div></td>
					  <td align="center" id="aegradetcol"><div id="aegradetitle"></div></td>
					  <td align="center" id="aespecialtcol"><div id="aespecialtitle"></div></td>					  
			          <td align="center" id="aeother1tcol"><div id="aeother1title"></div></td>
					  <td align="center" id="aeother2tcol"><div id="aeother2title"></div></td>
					  <td align="center" id="aeother3tcol"><div id="aeother3title"></div></td>
			          
			          <td align="center">Total Amount&nbsp;&nbsp;<img src="../images/rupeessymbol.png" width="10" height="15" /></td>
					  <td align="center">Proportionate pay&nbsp;&nbsp;<img src="../images/rupeessymbol.png" width="10" height="15" /></td>
					  <td align="center" width="7%">Action</td>
		       </tr>
		       
		       <tr>          
		
					 <td align="center">
						<input type="hidden" name="maxcheck_value" id="maxcheck_value" value="N" />
						<input name="maxcheck" id="maxcheck" value="Y" type="checkbox" onclick="checkfun_main(this.value);"> 
					 </td>
		        	<td align="center">
						<input name="fromdate" id="fromdate" value="" size="10" maxlength="10" onkeypress="dtval(this,event);" onblur="checkdatefirst(this);" type="text" class="aetextbox"> 
			  		</td>
		          	<td align="center">
						<input name="todate" id="todate" value="" size="10" maxlength="10" onkeypress="dtval(this,event);" onblur="checkdate(this);" type="text" class="aetextbox">  
		  			</td>			
		 			<td align="center">
						<input name="tmonth" id="tmonth" value="" size="4" maxlength="2" readonly="true" style="background-color:#ececec;" type="text" class="aetextboxmonth">  
		  			</td>		
					<td align="center">
						<input name="tday" id="tday" value="" size="4" maxlength="2" readonly="true" style="background-color:#ececec;" type="text" class="aetextboxmonth">  
		  			</td>		
					<td align="center" id="aebasiccol">
						<input value="" name="basic_pay" id="basic_pay" size="10" onkeypress="return numonly(event);" type="text" class="aetextbox" style="text-align:right;" onchange="calctotamount();"> 
					</td>					
					<td align="center" id="aegradecol">
						<input value="" name="grade_pay" id="grade_pay" size="10" onkeypress="return numonly(event);" type="text" class="aetextbox" style="text-align:right;" onchange="calctotamount();"> 
					</td> 		
					<td align="center" id="aespecialcol">
						<input value="" name="special_pay" id="special_pay" size="10" onkeypress="return numonly(event);" type="text" class="aetextbox" style="text-align:right;" onchange="calctotamount();"> 
					</td>
					<td align="center" id="aeother1col">
						<input value="" name="optionpay1" id="optionpay1" size="10" onkeypress="return numonly(event);" type="text" class="aetextbox" style="text-align:right;" onchange="calctotamount();"> 
					</td>
					<td align="center" id="aeother2col">
						<input value="" name="optionpay2" id="optionpay2" size="10" onkeypress="return numonly(event);" type="text" class="aetextbox" style="text-align:right;" onchange="calctotamount();"> 
					</td>
					<td align="center" id="aeother3col">
						<input value="" name="optionpay3" id="optionpay3" size="10" onkeypress="return numonly(event);" type="text" class="aetextbox" style="text-align:right;" onchange="calctotamount();"> 
					</td>
					<td align="center">
						<input value="" name="amount" id="amount" size="10" onkeypress="return numonly(event);" type="text" style="text-align:right;background-color:#ececec;" class="aetextbox" readonly="true" /> 
		  			</td>	
		  			<td align="center">
						<input value="" name="ppamount" id="ppamount" size="10" type="text" style="text-align:right;background-color:#ececec;" class="aetextbox" readonly="true" /> 
		  			</td>		
		  			<td align="center" width="7%">&nbsp;</td>	                  
		                  
		     </tr> 
		     <tbody id="test"></tbody>      
          	
			</table>
		</td>
		</tr>
		
		
		    <tr>
				<td align="center">
					<table align="center" width="100%" cellpadding="0" cellspacing="0">		
						<tr><td align="right" style="padding-top:5px;padding-right:180px;">Average Proportionate amount&nbsp;&nbsp;<img src="../images/rupeessymbol.png" width="10" height="15" />&nbsp;&nbsp;<input name="finaltotalppamount" id="finaltotalppamount" type="text" style="text-align:right;background-color:#ececec;" class="aetextbox" readonly="true" /></td></tr>
					</table>
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<table align="center" width="100%"  cellpadding="0" cellspacing="0">		
						<tr><td align="center"><input name="aesubmit_addrow" value="Add New" id="aesubmit_addrow" onclick="validateform();" type="button"></td></tr>
					</table>
				</td>
			</tr>
		
		</table>
		
		</div>	
		
					
		
 	</div>
 	
</div>

<div align="center">		
		<input type="submit"  value=" Submit " class="btn" onclick="return validation_final();calcservice();"/>&nbsp;
		<input type="button" name="cmdCancel" value=" Exit " class="btn" onclick="javascript:window.close()" />
</div>

</s:form>

</body>
</html>
