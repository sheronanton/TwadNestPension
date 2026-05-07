
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


function showAlert(elementId)
{
	if(elementId=="empId")
	{
		document.getElementById("showLabel").disabled=false;
		document.getElementById("showLabel").innerHTML="Enter Numeric Values only.";
	}
	else
	{		
		document.getElementById("showLabel").disabled=false;
		document.getElementById("showLabel").innerHTML ="Enter alpha Values only.";
	}
}

function enableDisableotherdepartmentDetails()
{
	
	var obj=document.getElementById("otherdeparmentserviceFlagYes").checked;
	/*try
	{
	alert("objcheck"+obj);
	}
	catch(e)
	{
		alert(e.message);
	}*/
	if(obj==false)
		{
		deleteotherdpetonload();
		
		 /*document.getElementById("othdeptsersubmit_addrow").disabled = true; 
		document.getElementById("tototdepyear1").value=0;
		document.getElementById("tototdepmonth1").value=0;
		document.getElementById("totothdeptday1").value=0;*/
		}
	if(obj==true)
		{			
		document.getElementById("othdeptsersubmit_addrow").disabled = false; 
		}
	
}


function disableAlert()
{
	document.getElementById("showLabel").innerHTML="";
}

function enableDisableCommDetails(obj)
{
	if(obj.value=="No")
		{		
			document.AEForm.commPert.disabled=true;
			//document.AEForm.commFactor.disabled=true;
			document.AEForm.commPert.style.backgroundColor = '#dddddf';
			//document.AEForm.commFactor.style.backgroundColor = '#dddddf';
			document.getElementById("pensionpertFlagonethird").disabled=true;
			document.getElementById("pensionpertFlagpert").disabled=true;
		}
	if(obj.value=="Yes")
		{
			document.AEForm.commPert.disabled=true;
			document.AEForm.commPert.style.backgroundColor = '#dddddf';
			document.getElementById("pensionpertFlagonethird").checked='checked';
			document.getElementById("pensionpertFlagonethird").disabled=false;
			document.getElementById("pensionpertFlagpert").disabled=false;
		}
	
}




function enableDisablePertDetails(obj)
{
	if(obj.value=="onethird")
	{		
		document.AEForm.commPert.disabled=true;
		document.AEForm.commPert.style.backgroundColor = '#dddddf';		
	}
if(obj.value=="pert")
	{
		document.AEForm.commPert.disabled=false;
		document.AEForm.commPert.style.backgroundColor = '#ffffff';		
	}
}



function enableDisableServicePrior(obj1)
{
	if(obj1.value=="No")
	{		
		document.AEForm.nameofEstd.disabled=true;
		document.AEForm.govtUnderService.disabled=true;
		document.AEForm.nameofEstd.style.backgroundColor = '#dddddf';
		document.AEForm.govtUnderService.style.backgroundColor = '#dddddf';
	}
if(obj1.value=="Yes")
	{
		document.AEForm.nameofEstd.disabled=false;
		document.AEForm.govtUnderService.disabled=false;
		document.AEForm.nameofEstd.style.backgroundColor = '#ffffff';
		document.AEForm.govtUnderService.style.backgroundColor = '#ffffff';
	}

}


function enableDisableWceServiceDetails(obj)
{
	if(obj.value=="No")
		{		
			document.AEForm.wceyear.disabled=true;
			document.AEForm.wcemonth.disabled=true;
			document.AEForm.wceday.disabled=true;
			document.AEForm.wceyear.style.backgroundColor = '#dddddf';
			document.AEForm.wcemonth.style.backgroundColor = '#dddddf';
			document.AEForm.wceday.style.backgroundColor = '#dddddf';
			document.AEForm.wceyear.value=0;
			document.AEForm.wcemonth.value=0;
			document.AEForm.wceday.value=0;
			document.getElementById("wcecountedFlagNo").checked='checked';
			document.getElementById("wcecountedFlagYes").disabled=true;
			document.getElementById("wcecountedFlagNo").disabled=true;
			document.getElementById("regualr_estab_date").disabled=true;
			document.getElementById("regualr_estab_date").style.backgroundColor = '#dddddf';
			document.getElementById("regualr_estab_date").value="";
			document.getElementById("cal-button-10").style.display="none";
		}
	if(obj.value=="Yes")
		{			
			document.AEForm.wceyear.disabled=false;
			document.AEForm.wcemonth.disabled=false;
			document.AEForm.wceday.disabled=false;
			document.AEForm.wceyear.style.backgroundColor = '#ffffff';
			document.AEForm.wcemonth.style.backgroundColor = '#ffffff';
			document.AEForm.wceday.style.backgroundColor = '#ffffff';
			document.getElementById("wcecountedFlagYes").disabled=true;
			document.getElementById("wcecountedFlagNo").disabled=true;
			document.getElementById("regualr_estab_date").disabled=false;
			document.getElementById("regualr_estab_date").style.backgroundColor = '#ffffff';
			document.getElementById("cal-button-10").style.display="inline";
		}
	
}



function enableDisablecontingentServiceDetails(obj)
{
	if(obj.value=="No")
		{		
			document.AEForm.contingentyear.disabled=true;
			document.AEForm.contingentmonth.disabled=true;
			document.AEForm.contingentday.disabled=true;
			document.AEForm.contingentyear.style.backgroundColor = '#dddddf';
			document.AEForm.contingentmonth.style.backgroundColor = '#dddddf';
			document.AEForm.contingentday.style.backgroundColor = '#dddddf';
			document.AEForm.contingentyear.value=0;
			document.AEForm.contingentmonth.value=0;
			document.AEForm.contingentday.value=0;
		}
	if(obj.value=="Yes")
		{			
			document.AEForm.contingentyear.disabled=false;
			document.AEForm.contingentmonth.disabled=false;
			document.AEForm.contingentday.disabled=false;
			document.AEForm.contingentyear.style.backgroundColor = '#ffffff';
			document.AEForm.contingentmonth.style.backgroundColor = '#ffffff';
			document.AEForm.contingentday.style.backgroundColor = '#ffffff';
		}
	
}

