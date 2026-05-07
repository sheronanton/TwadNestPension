<%@ include file="/common/taglibs.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Revised Family Pension Order due to pay change- Authorisation  Report </title>
<link rel="stylesheet" href="<s:url value="/css/PensionCalcApplication.css"/>" type="text/css" />
<link type="text/css" href="../styles/demos.css" rel="stylesheet" />
<link type="text/css" href="../styles/ui.all.css" rel="stylesheet" />
<script	src="<s:url value="/javascript/RevisedFamilyPensionOrderReport.js" />"	type="text/javascript"></script>
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
			<td background="../images/bluebg1.jpg"><font color="white" size="4">Revised Family Pension Order due to pay change- Authorisation Report</font></td>
		</tr>
		<tr>
			<td align="center">			
				<table align="center" width="100%" class="border1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left" width="30%"><font class="bodyText">Employee No</font></td>
						<td align="left" width="50%">
							<s:textfield name="empNo" id="empNo"  theme="simple" cssClass="textbox" onchange="revFamPenOrderReportSearch(this.value);" />	
							<input type="button" name="" value="Select Emp.No." onclick="window.open('RevisedFamilyPensionOrderReportSearch.jsp','RevisedFamilyPensionOrderReportSearch','width=1000,height=600,scrollbars=yes')" />
							<s:hidden name="pensionType" id="pensionType" />
						</td>		
					</tr>
					<tr>
						<td align="left" width="30%"><font class="bodyText">Employee Name</font></td>
						<td align="left" width="50%"><s:textfield name="empName" id="empName"  theme="simple" cssClass="readonlytext" readonly="true" /></td>		
					</tr>	
					<tr>
						<td align="left" width="30%"><font class="bodyText">Select Pension Order Report</font></td>
						<td align="left" width="50%">
						 	<s:select list="#{'1':'Revised pay change note','2':'Revised Pension Order','3':'Revised DCRG Pension Order'}" headerKey="" headerValue="--Select--" id="reportformId" name="reportform" />							
						</td>		
					</tr>	
					<tr>
						<td align="center" colspan="2">
							<input type="button" value="Print" onclick="javascript:GenReport()"/>&nbsp;&nbsp;
							<input type="button" value="Close" onclick="javascript:window.close()"/>
						</td>
					</tr>
				</table>			
			</td>
		</tr>		
	</table>
</s:form>
</body>
</html>