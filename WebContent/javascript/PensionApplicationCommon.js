String.prototype.trim = function() {
    a = this.replace(/^\s+/, '');
    return a.replace(/\s+$/, '');
    };
    
function dtval(d,e) 
{
	var pK = e ? e.which : window.event.keyCode;
	if (pK == 8) {d.value = substr(0,d.value.length-1); return;}
	var dt = d.value;
	var da = dt.split('/');
	for (var a = 0; a < da.length; a++) {if (da[a] != +da[a]) da[a] = da[a].substr(0,da[a].length-1);}
	if (da[0] > 31) {da[1] = da[0].substr(da[0].length-1,1);da[0] = '0'+da[0].substr(0,da[0].length-1);}
	if (da[1] > 12) {da[2] = da[1].substr(da[1].length-1,1);da[1] = '0'+da[1].substr(0,da[1].length-1);}
	if (da[2] > 9999) da[1] = da[2].substr(0,da[2].length-1);
	dt = da.join('/');
	if (dt.length == 2 || dt.length == 5) dt += '/';
	d.value = dt;
}


function disableEnableCharges()
{	
	var chargesFlagY=document.getElementById("chargesFlagYes").checked;
	var chargesFlagN=document.getElementById("chargesFlagNo").checked;
	
	if(chargesFlagY)
		{
			document.getElementById("chargeDetails").value="";
			document.getElementById("chargeDetails").disabled=false;
		}
	if(chargesFlagN)
		{
			document.getElementById("chargeDetails").value="";
			document.getElementById("chargeDetails").disabled=true;
		}
		
}


function numchk(obj) 
{
	var numPat = /^[0-9]+$/;
	var strString =obj.value;	
	var id=obj.id;	
	if(strString.trim()!="")
		{	
			if(!numPat.test(strString))
				{
					alert("Please Enter Numeric Values Only !");
					obj.value="";
				}
		}
}


function charOnly(obj) 
{	
	var numPat = /^[a-zA-Z ]+$/;
	var strString2 =obj.value;
	var id=obj.id;
	if(strString2.trim()!="")
		{		
			if(!numPat.test(strString2))
			{
				alert("Not a Valid Character !");
				obj.value="";
			}
       } 
}


function alphanumeric(object) 
{
    var regForOneChar = /^[\w ]+$/; 
    var values =object.value;
	var ids=object.id;
	if(values.trim()!="") 
		{
			if(!regForOneChar.test(values)) 
			{
				alert("Please Enter AlphaNumeric Values Only !");
				document.getElementById(ids).value="";
			}
		}
}



function checkdate(obj)
{		
	
	var ids=obj.id;	
	if(obj.value!="" || obj.value!=null)
		{		
			var datesSep=obj.value.split("/");
			if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
				{
					alert("Choosen Date is Future !");
					obj.value="";						
				}		
		
		}
	
}

function CheckDate(obj)
{
	var dateval=obj.value.trim();
	
	if(dateval!="" && dateval.length>0)
		{		
			var datesSep=dateval.split("/");			
			if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
				{
					alert("Choosen Date is Future !");
					obj.value="";		
					return false;
				}	
			
			if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
			{
				alert("Invalid Date !");
				obj.value="";		
				return false;
			}	
		
		}
	else
		{
		
		}
	return true;
}

function isValidDate(day,month,year)
{	
	month-=1;
	var dteDate;
	dteDate=new Date(year,month,day);
	return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
}


function isFutureDate(day,month,year)
{   
    month-=1;
    var dteDate;
    dteDate=new Date(year,month,day);
    return (dteDate.getTime()>new Date().getTime());
               
}

