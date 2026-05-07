<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="/struts-tags" prefix="s"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pensioner Search</title>
<link rel=StyleSheet href="<s:url value="/css/Sample3.css" />" type="text/css" >
<script  src="<s:url value="/javascript/MstNomineeSearch.js" />" type="text/javascript">
</script>
<script language=javascript>


function set (value)
{

document.getElementById("selectedradio").value=0;
document.getElementById("selectedradio").value=value;
 
}



function post_value(){

	var mv=document.getElementById("radios").value;
	var rowcount=document.getElementById("rowcount").value;
	var sel_value=document.getElementById("selectedradio").value; 
	

	var ppono=document.getElementById("ppoNo"+sel_value).innerHTML;
	var employeeId=document.getElementById("employeeId"+sel_value).innerHTML;
	var pensionerName=document.getElementById("pensionerName"+sel_value).innerHTML;
	
	
	opener.document.AddChangeNominee.ppoNo.value=ppono;
	opener.document.AddChangeNominee.EmpId.value=employeeId;
	opener.document.AddChangeNominee.EmpName.value=pensionerName;
	
	opener.CheckChangedNominee(ppono);
	window.close();
    
	
}
</script>
<style type="text/css">
	.fontss
	{
	  font-size:18px;			
	}
	</style>
</head>
 
<br><br><br>
<body>


	<table border="1" width="70%" align="center"> 
		<tr>
			<td background="../images/bluebg1.jpg"><font color="white" size="4"><strong>Pensioner Search</strong></font></td>
		</tr>
		
		<tr>
			<td align="center">
				<table width="100%" >
			 		<tr>
			 			<td colspan="4" align="center">
							<s:form name="frm" action="">
							<input type="hidden" name="empId" value="8710">
								<s:select headerKey="" headerValue="-- Select --"id="options" name="options"
								 list="#{'ppo_no':'PPO NO','employee_id':'Employee No','pensioner_name':'Name','class_description':'Pension Type'}" theme="simple" cssStyle="border:#ffba14 1.5px solid" />&nbsp;&nbsp;
								<s:textfield name="searchText" id="searchText" theme="simple" cssStyle="border:#ffba14 1.5px solid"/>&nbsp;&nbsp;
								<input type="button" id="Search" name="Search" Value="Search" onclick="javascript:callServer('Search')"/>&nbsp;&nbsp;
								<input type="reset" id="btnClear" name="Clear" value="Clear" />
							</s:form>
					   </td>
					</tr>   	
				</table>
			</td>	
		</tr>
	
		<tr>
			<td>
				<table border="0" width="100%" align="center" background="../images/button_bg.jpg" >
  					<tr>
       		          <td align="right" >
            		    Page&nbsp;Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            		    <select name="cmbpagination" id="cmbpagination" onchange="changepagesize()">
                  			<option value="5" selected="selected">5</option>
                  			<option value="10">10</option>
                  			<option value="15">15</option>
                  			<option value="20">20</option>
                		</select>
           			  </td>
        			</tr>
			    </table>
			</td>
		</tr>	
			
			
		<tr>
			<td>
				<table id="Existing" border="0" width="100%" cellpadding="0" cellspacing="0" class="border1">
					<tr>
						<th rowspan="2" align="center" width="10%" >Edit</th>
            			<th rowspan="2" align="center" width="10%" >PPO NO</th>
            			<th rowspan="2" align="center" width="10%" >Emp.No</th>
            			<th rowspan="2" align="center" width="30%" >Emp.Name</th>
            			<th rowspan="2" align="center" width="15%" >Pension Type</th>
            			<!--<th rowspan="2" align="center" width="25%" >Process Status</th>
            	   -->
            	   </tr>
						<tbody id="tblList" >
						</tbody>
				</table>	
			</td>
		</tr>	    
    
    <tr>
   		 <td colspan="17">
     		<table align="center"  cellspacing="0" cellpadding="2" border="1" width="100%" background="../images/button_bg.jpg" >
                <tr>
                   <td width="30%">
                 		 <div align="left"> <div id="divpre" style="display:none"></div> </div>
                   </td>
                   <td width="40%">
                         <div align="center"><table border="0"><tr><td> <div id="divcmbpage" style="display:none" ><font color="Black" size="2"><strong>
                         Page&nbsp;&nbsp;<select name="cmbpage" id="cmbpage" onchange="changepage()"></select></strong></font></div></td><td>
                   <div id="divpage"></div></td></tr></table> </div>
                        </td>
                        <td width="40%">
                             <div align="right"> <div id="divnext" style="display:none"></div> </div>
                        </td>
                    </tr>
            </table>
      </td>
    </tr>
</table>
	
	<table align="center" width="70%">
		<tr>
			<td style="padding:20px 0 0 0" valign="middle" align="center">
				<input type="button" id="btnSelect" name="select" Value="Select" onclick ="javascript:post_value()"/>
				<input type="button" id="btnClear" name="Close" value="Close" onclick="javascript:window.close()" />
			</td>
		</tr>
	</table>	

	
	
	

	
	 <s:hidden name="ppono" id="ppono"/>
<!--	<s:textfield name="ppono" id="ppono"> </s:textfield>-->
<s:hidden name="selectedradio" id="selectedradio" />
<s:hidden name="rowcount" id="rowcount" />
<s:hidden name="radios" id="radios"  />

</body>
	
</html>