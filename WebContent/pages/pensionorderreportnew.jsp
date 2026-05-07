<%@ include file="/common/taglibs.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pension Order - Authorisation  Report </title>
<link rel="stylesheet" href="<s:url value="/css/PensionCalcApplication.css"/>" type="text/css" />
<link type="text/css" href="../styles/demos.css" rel="stylesheet" />
<link type="text/css" href="../styles/ui.all.css" rel="stylesheet" />
<%--<script	src="<s:url value="/javascript/PensionOrderAuthorisationReport.js" />"	type="text/javascript"></script>--%>
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
<body><form name="Pension_App_rep" >
  
         
            <table border="0" width="100%">
            <tr class="tdH">
            
            <td align="center" colspan="2"><b>
           Application for pension </b>
            </td>
            </tr>
            <tr class="tdH">
            <td colspan="2">Employee Details</td>
            </tr>
            <tr>
            
            <td colspan="1">Employee Id</td>
            <td colspan="1"><input type="text" name="emp_id" id="emp_id" maxlength="5" size="5" onblur="employee_check()" onkeypress="return  numbersonly1(event,this)"> <img src="../../../../../../images/c-lovi.gif" width="20"
                     height="20"  onclick="servicepopup();"></img></td>
                     
            </tr>
            <tr>
            <td>Employee Name</td>
            <td><input type="text" name="emp_name" id="emp_name" size="30" disabled="disabled">  </td>
            </tr>
            <tr>
           <tr>
						<td align="left" width="30%"><font class="bodyText">Pension Type</font></td>
						<td> <input type="text" id="retire_id"  name="retire_id" size="30" disabled="disabled">
						<%-- <td align="left" width="50%">
						 	<s:select list="#{'1':'superannuation','2':'vrs','3':'death'}" headerKey="" headerValue="--Select--" id="reportformId" name="reportform" />							
						</td> --%>		</td>
					</tr>
             <td colspan="2" align="left" valign="top" class="table">
              <div align="center">
                <table border="0" width="100%">
                  <tr>
                    <td colspan="2" class="tdH">Report Output Format</td>
                  </tr>
                  <tr>
                    <td colspan="2" class="table" align="left">
                      
                        <input type="radio" name="optoutputtype" id="optoutputtype" value="pdf" checked></input>PDF
                                                                         Format
                      
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" class="table" align="left">
                      
                        <input type="radio" name="optoutputtype"  id="optoutputtype" value="excel"></input>EXCEL
                                                                         Format
                      
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" class="table" align="left">
                      
                        <input type="radio" name="optoutputtype" id="optoutputtype" value="html"></input>HTML
                                                                         Format
                      
                    </td>
                  </tr>
                </table>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="tdH" align="center">
            <input type="button" value="Submit" onclick="getemp();">
            <input type="button" id="cmdcancel" name="cancel" value="Cancel" onclick="self.close();">
            </td>
          </tr>
            </table>
           
            
  
     
    </form></body>
</html>