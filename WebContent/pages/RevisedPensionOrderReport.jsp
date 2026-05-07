<%@ include file="/common/taglibs.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Revised Pension Order due to pay change- Authorisation  Report </title>
<link rel="stylesheet" href="<s:url value="/css/PensionCalcApplication.css"/>" type="text/css" />
<link type="text/css" href="../styles/demos.css" rel="stylesheet" />
<link type="text/css" href="../styles/ui.all.css" rel="stylesheet" />
<script	src="<s:url value="/javascript/RevisedPensionOrderReport.js" />"	type="text/javascript"></script>
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
<s:form name="RevisedPensionOrderReport" action="" method="POST"  namespace="/pages" >
	<table border="0" align="center" width="80%" style="background-color:#E9F5F5;">
		<tr>
			<td background="../images/bluebg1.jpg"><font color="white" size="4">Revised Pension Order due to pay change- Authorisation Report</font></td>
		</tr>
		<tr>
			<td align="center">			
				<table align="center" width="100%" class="border1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left" width="30%"><font class="bodyText">Employee No</font></td>
						<td align="left" width="50%">
							<s:textfield name="empNo" id="empNo"  theme="simple" cssClass="textbox" onchange="revPenOrderReportSearch(this.value);" />	
							<input type="button" name="" value="Select Emp.No." onclick="window.open('RevisedPensionOrderReportSearch.jsp','RevisedPensionOrderReportSearch','width=1000,height=600,scrollbars=yes')" />
							<s:hidden name="pensionType" id="pensionType" />
						</td>		
					</tr>
					<tr>
						<td align="left" width="30%"><font class="bodyText">Employee Name</font></td>
						<td align="left" width="50%"><s:textfield name="empName" id="empName"  theme="simple" cssClass="readonlytext" readonly="true" /></td>		
					</tr>	
					<tr>
                     
					</tr>
					<tr> 
			
				</table>			
			</td>
		</tr>		
	</table>
	<div id="Revised_pension" style="DISPLAY:none">
                <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
						<td align="left" width="30%"><font class="bodyText">Select Pension Order Report</font></td>
						<td align="left" width="50%">
						 	<!--<s:select list="#{'1':'Revised Pension Note','2':'Revised Pension Order','3':'Revised DCRG Pension Order'}" headerKey="" headerValue="--Select--" id="reportformId" name="reportform" />-->							
						 	<s:select list="#{'1':'Revised Pension Order','2':'Revised DCRG Pension Order'}" headerKey="" headerValue="--Select--" id="reportformId" name="reportform" />
						</td>
						</table>
			</div>
	<div id="showOneMan_Commision" style="DISPLAY:none">
		    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		    <tr class="bodyText">
			<td align="left" width="30%"><font class="bodyText">OneMan Commision Order Report</font></td>
			<td align="left" width="50%">
			<s:select list="#{'1':'OneMan Commision Order','2':'OneMan Commision DCRG'}" headerKey="" headerValue="--Select Any One--" id="reportform_onemanId" name="reportform_oneman" />							
			</td>
			</tr>	
			</table>
			</div>
	<div id="showSpcial_grade" style="DISPLAY:none">
		    <table  border="0" align="center" width="80%" style="background-color:#E9F5F5" cellpadding="0" cellspacing="0" class="border1">
		    <tr class="bodyText">
			<td align="left" width="30%"><font class="bodyText">Special Grade Order Report</font></td>
			<td align="left" width="50%">
			<s:select list="#{'1':'Special Grade Order','2':'Special Grade DCRG'}" headerKey="" headerValue="--Select Any One--" id="reportform_SplGradeId" name="reportform_SplGrade" />							
			</td>
			</tr>	
			</table>
			</div>
	<div align="center" >
	<table  border=0 width="80%" style="background-color:#E9F5F5;" >
	<tr class="bodyText">
	<td align="center">
	<input type="button" value="Print" onclick="javascript:GenReport()"/>&nbsp;&nbsp;
	<input type="button" value="Close" onclick="javascript:window.close()"/>
	</td>
	</tr>
	</table>
	</div>
</s:form>
</body>
</html>