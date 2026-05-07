String.prototype.trim = function() {
    a = this.replace(/^\s+/, '');
    return a.replace(/\s+$/, '');
    };
    
function submitValidationCheck()
{
	var empNo=document.getElementById("penEmpNo").value.trim();
	var presentAddress=document.getElementById("presentAddress").value.trim();
	var claimentName=document.getElementById("claimentName").value.trim();
	var employeeDeathDate=document.getElementById("employeeDeathDate").value.trim();
	var payOffice=document.getElementById("paymentOfficeId").selectedIndex;
	var claimentDob=document.getElementById("claimentDob").value.trim();
	var claimentAge=document.getElementById("claimentAge").value.trim();
	
	var flag=true;
	
	var empdeath=employeeDeathDate.split("/");
	var claimentdob=claimentDob.split("/");
	
	var guardDob=document.getElementById("guardianDob").value.trim();
	var gdob=guardDob.split("/");
	
	if(empNo!="" && empNo.length>0)
		{
			if(presentAddress=="" && presentAddress.length<=0)
			{
				alert('Please Enter Employee Present Address ');
				return false;	
			}	
			
			if(payOffice==0)
			{
				alert('Please Select Pension Payment Office');
				return false;
			}
			
			if(claimentName=="" && claimentName.length<=0)
			{
				alert('Please Enter Claiment Name ');
				return false;	
			}
							
			if(claimentDob=="" && claimentDob.length<=0 && claimentAge=="" && claimentAge.length<=0)
			{
				alert('Please Enter Claiment Date of Birth or Age');
				return false;
			}
			
			if(employeeDeathDate=="" && employeeDeathDate.length<=0)
			{
				alert('Please Enter Employee Death Date ');
				return false;	
			}	
			
			if((!isValidDate(empdeath[0],empdeath[1],empdeath[2])) && (employeeDeathDate.length!=0))
			{
				alert('Invalid Employee Death Date');
				return false;	
			}
			
			if((!isValidDate(claimentdob[0],claimentdob[1],claimentdob[2])) && (claimentDob.length!=0))
			{
				alert('Invalid Claiment Date of Birth');
				return false;	
			}
			
			if((!isValidDate(gdob[0],gdob[1],gdob[2])) && (guardDob.length!=0))
			{
				alert('Invalid Guardian Date of Birth');
				return false;	
			}
			 
			 
			
		flag=CheckSubmit();
			
		}
	else
		{
			alert('Please Enter Employee Number');
			return false;
		}
	
return flag;


}



function ValidateSubmitCheck()
{	
	try
	{
	var presentAddress=document.getElementById("presentAddress").value.trim();
	var claimentName=document.getElementById("claimentName").value.trim();
	var employeeDeathDate=document.getElementById("employeeDeathDate").value.trim();
	var payOffice=document.getElementById("paymentOfficeId").selectedIndex;
	var claimentDob=document.getElementById("claimentDob1").value.trim();
	var claimentAge=document.getElementById("claimentAge").value.trim();
	
	var flag=true;
	
	var empdeath=employeeDeathDate.split("/");
	var claimentdob=claimentDob.split("/");
	
	var guardDob=document.getElementById("guardianDob").value.trim();
	var gdob=guardDob.split("/");
	
	
			if(presentAddress=="" && presentAddress.length<=0)
			{
				alert('Please Enter Employee Present Address ');
				return false;	
			}	
			
			if(payOffice==0)
			{
				alert('Please Select Pension Payment Office');
				return false;
			}
			
			if(claimentName=="" && claimentName.length<=0)
			{
				alert('Please Enter Claiment Name ');
				return false;	
			}
							
			if(claimentDob=="" && claimentDob.length<=0 && claimentAge=="" && claimentAge.length<=0)
			{
				alert('Please Enter Claiment Date of Birth or Age');
				return false;
			}
			
			if(employeeDeathDate=="" && employeeDeathDate.length<=0)
			{
				alert('Please Enter Employee Death Date ');
				return false;	
			}	
			
			if((!isValidDate(empdeath[0],empdeath[1],empdeath[2])) && (employeeDeathDate.length!=0))
			{
				alert('Invalid Employee Death Date');
				return false;	
			}
			
			if((!isValidDate(claimentdob[0],claimentdob[1],claimentdob[2])) && (claimentDob.length!=0))
			{
				alert('Invalid Claiment Date of Birth');
				return false;	
			}
			
			if((!isValidDate(gdob[0],gdob[1],gdob[2])) && (guardDob.length!=0))
			{
				alert('Invalid Guardian Date of Birth');
				return false;	
			}
			 
			 
			
		flag=CheckSubmit();
			
		
return flag;
	
}

	catch(e)
	{
		alert(e.message);
	}
}





