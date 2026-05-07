
String.prototype.trim = function() {
	        a = this.replace(/^\s+/, '');
	        return a.replace(/\s+$/, '');
	        };  
	        
function CheckValidation()
{	
	var empno=document.getElementById("empNo").value.trim();
	var presentAddress=document.getElementById("presentAddress").value.trim();
	var permanentAddress=document.getElementById("permanentAddress").value.trim();
	var addressAfterRetire=document.getElementById("addressAfterRetire").value.trim();	
	var appliedDate=document.getElementById("appliedDate").value.trim();
	var datesSep1=appliedDate.split("/");	
	
	try
	{
	var myFlag=false;
	
	var payOffice=document.getElementById("pensionPayOfficeId").selectedIndex;
		
	if(empno!=null && empno.length>0)
		{
			if(presentAddress=="" && presentAddress.length<=0)
				{
					alert('Please Enter Employee Present Address ');
					return false;	
				}
			
			if(permanentAddress=="" && permanentAddress.length<=0)
				{
					alert('Please Enter Employee Permanent Address ');
					return false;	
				}
			if(addressAfterRetire=="" && addressAfterRetire.length<=0)
				{
					alert('Please Enter Employee Address After Retirement ');
					return false;	
				}
			
			if(payOffice==0)
				{
					alert('Please Select Pension Payment Office');
					return false;
				}
		
			if(appliedDate=="" && appliedDate.length<=0)
				{
					alert('Please Enter Pension Applied Date ');
					return false;	
				}
		
			if((!isValidDate(datesSep1[0],datesSep1[1],datesSep1[2])) && (appliedDate.length!=0))
				{
					alert('Invalid Pension Applied Date !');
					document.getElementById("appliedDate").value="";
					return false;	
				}
			
			if(!chkSubmit2())
				{
					return false;
				}
	
			if(!chkSubmit())
				{				
					return false;					
				}
				
		
			return true;
		}

	else
		{
			alert('Please Enter Employee Number');
			return false;
		}
		
		}
	catch(e)
	{
		alert(e);
	}
}




function isValidDate(day,month,year)
{
    month-=1;
    var dteDate;
    dteDate=new Date(year,month,day);
    return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
}


