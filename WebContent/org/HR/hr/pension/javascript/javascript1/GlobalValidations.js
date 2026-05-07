
function numchk(obj) {

	var numPat = /^[0-9]+$/;
	var strString =obj.value;	
	var id=obj.id;
  if(!numPat.test(strString)){
    alert("Please Enter Numeric Values Only !");
    obj.value="";
   
    
    
  }
 
}


function charOnly(obj) {
	var numPat = /^[a-zA-Z ]+$/;
	var strString =obj.value;
	var id=obj.id;
  if(!numPat.test(strString)){
    alert("Not a Valid Character !");
    obj.value="";

       
  }
 
}




function classPension(obj)
{
	var val=obj.value;	
		if(val!=2)
		{
			document.PensionCutOffEntry.dcrgPertReceived.value="";
			document.PensionCutOffEntry.provisionalPensionAmt.value="";	
			document.PensionCutOffEntry.dcrgPertReceived.disabled=true;
			document.PensionCutOffEntry.provisionalPensionAmt.disabled=true;
		}
		else
		{
			document.PensionCutOffEntry.dcrgPertReceived.disabled=false;
			document.PensionCutOffEntry.provisionalPensionAmt.disabled=false;
		}
		if(val!=5){
			document.PensionCutOffEntry.weightageServiceYrs.value="";
			document.PensionCutOffEntry.weightageServiceMonths.value="";
			document.PensionCutOffEntry.weightageServiceDays.value="";
			document.PensionCutOffEntry.weightageServiceYrs.disabled=true;
			document.PensionCutOffEntry.weightageServiceMonths.disabled=true;
			document.PensionCutOffEntry.weightageServiceDays.disabled=true;
		}
		else{
			document.PensionCutOffEntry.weightageServiceYrs.disabled=false;
			document.PensionCutOffEntry.weightageServiceMonths.disabled=false;
			document.PensionCutOffEntry.weightageServiceDays.disabled=false;
			
		}
}


function alphanumeric(object) {
    var regForOneChar = /^[\w]+$/; 

    var values =object.value;
	var ids=object.id;
	 
	if(!regForOneChar.test(values)) {
	   alert("Please Enter AlphaNumeric Values Only !");
	   document.getElementById(ids).value="";
	}
}

function dtval(d,e) {
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


function setDateTime()
{
	
var d = new Date();

var curr_date = d.getDate();
var curr_month= d.getMonth()+1;
var curr_year = d.getFullYear();
var result=curr_date + "/" + curr_month + "/" + curr_year;
document.getElementById("cutOfEntryDate").value=result;

}


function ServiceCheck(Obj)
{

var value=Obj.value.trim();
var id=Obj.id;

	numchk(Obj);
	
	if(id=='grossServiceYrs' && value>50)
	{		
		alert('Gross Service Years must be less than 50 !');
		document.getElementById("grossServiceYrs").value="";
		
		return false;
	}
	

	if(id=='grossServiceMonth' && value>11)
	{
		alert('Gross Service Months must be less than 11 !');
		document.getElementById("grossServiceMonth").value="";
	
		return false;
	}


	if(id=='grossServiceDays' && value>30)
	{
		alert('Gross Service Days must be less than 30 !');
		document.getElementById("grossServiceDays").value="";
	
		return false;
	}
	
	
	if(id=='totServiceYrs' && value>50)
	{
		alert('Total Service Years must be less than 50 !');
		document.getElementById("totServiceYrs").value="";
	
		return false;
	}
	
	
	if(id=='totServiceMonths' && value>11)
	{
		alert('Total Service Months must be less than 11 !');
		document.getElementById("totServiceMonths").value="";
	
		return false;
	}


	if(id=='totServiceDays' && value>30)
	{
		alert('Total Service Days must be less than 30 !');
		document.getElementById("totServiceDays").value="";
	
		return false;
	}
	
	if(id=='quaServiceYrs' && value>50)
	{
		alert('Qualified Service Years must be less than 50 !');
		document.getElementById("quaServiceYrs").value="";	
	
		return false;
	}
	
	if(id=='quaServiceMonths' && value>11)
	{
		alert('Qualified Service Months must be less than 11 !');
		document.getElementById("quaServiceMonths").value="";
	
		return false;
	}


	if(id=='quaServiceDays' && value>30)
	{
		alert('Qualified Service Days must be less than 30 !');
		document.getElementById("quaServiceDays").value="";
		
		return false;
	}

	if(id=='nonquaServiceYrs' && value>50)
	{
		alert('Non Qualified Service Years must be less than 50 !');
		document.getElementById("nonquaServiceYrs").value="";
	
		return false;
	}
	
	
	if(id=='nonquaServiceMonths' && value>11)
	{
		alert('Non Qualified Service Months must be less than 11 !');
		document.getElementById("nonquaServiceMonths").value="";
	
		return false;
	}


	if(id=='nonquaServiceDays' && value>30)
	{
		alert('Non Qualified Service Days must be less than 30 !');
		document.getElementById("nonquaServiceDays").value="";
		
		return false;
	}
	
	if(id=='weightageServiceYrs' && value>5)
	{
		alert('Weightage Service Years must be less than 5 !');
		document.getElementById("weightageServiceYrs").value="";	
	
		return false;
	}
	
	
	if(id=='weightageServiceMonths' && value>11)
	{
		alert('Weightage Service Months must be less than 11 !');
		document.getElementById("weightageServiceMonths").value="";
		
		return false;
	}


	if(id=='weightageServiceDays' && value>30)
	{
		alert('Weightage Service Days must be less than 30 !');
		document.getElementById("weightageServiceDays").value="";
		
		return false;
	}
	
		
	if(id=='netquaServiceYrs' && value>50)
	{
		alert('Net Qualified Years must be less than 50 !');
		document.getElementById("netquaServiceYrs").value="";		
		return false;
	}
	
	
	if(id=='netquaServiceMonths' && value>11)
	{
		alert('Net Qualified Months must be less than 11 !');
		document.getElementById("netquaServiceMonths").value="";
		
		return false;
	}


	if(id=='netquaServiceDays' && value>30)
	{
		alert('Net Qualified Days must be less than 30 !');
		document.getElementById("netquaServiceDays").value="";	
	
		return false;
	}
	
return true;
}




function pensionstatus(obj)
{
	var value1=obj.value;
	if(value1=='true')   // true means Yes pension withheld 
		{
		document.PensionCutOffEntry.pensionNotPaidFrmMon.disabled=false;
		document.PensionCutOffEntry.pensionNotPaidFrmYear.disabled=false;
		}
		
	else if(value1=='false')
		{		
		document.PensionCutOffEntry.pensionNotPaidFrmYear.value="";
		document.PensionCutOffEntry.pensionNotPaidFrmMon.selectedIndex=0;
		document.PensionCutOffEntry.pensionNotPaidFrmMon.disabled=true;
		document.PensionCutOffEntry.pensionNotPaidFrmYear.disabled=true;
		}
}


function pensionWithHeldYear(value,id,obj)
{
	numchk(obj);
	 
	var date= new Date();
	var year =date.getFullYear();	
	if(value<=1970)
		{   
		document.getElementById("pensionNotPaidFrmYear").value="";
		alert('Pension Withheld Year Should be Greater than 1970 !');
		
		return false;
		}
	if(year<value)
		{
		document.getElementById("pensionNotPaidFrmYear").value="";
		alert('Please Enter Valid Pension Withheld Year !');
		
		return false;
		}
	return true;
}



function within100(obj)
{
	var value=obj.value.trim();	
	var id=obj.id;
	if(value>100)
		{
		alert('DCRG % should not exceed 100 !');
		obj.value="";
		
		}
}



function Commutationfactor(obj1)
{
	var value1=obj1.value.trim();
	var id=obj1.id;
	
	if(value1>33){
         alert('Commutation Factor % should not exceed 33 !');
         obj1.value="";
                 
	}
}



function echeck(str,id) {
	
		var at="@";
		var dot=".";
		var lat=str.indexOf(at);
		var lstr=str.length;
		var ldot=str.indexOf(dot);
		if (str.indexOf(at)==-1){
		   alert("Invalid E-mail ID !");
		   return false;
		}

		if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
		   alert("Invalid E-mail ID !");
		
		   return false;
		}

		if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
		    alert("Invalid E-mail ID !");
		
		    return false;
		}

		 if (str.indexOf(at,(lat+1))!=-1){
		    alert("Invalid E-mail ID !");
		 
		    return false;
		 }

		 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
		    alert("Invalid E-mail ID !");
		 
		    return false;
		 }

		 if (str.indexOf(dot,(lat+2))==-1){
		    alert("Invalid E-mail ID");
		  
		    return false;
		 }
		
		 if (str.indexOf(" ")!=-1){
		    alert("Invalid E-mail ID");
		
		    return false;
		 }

 		 return true;				
	}



function emailvalidation(){
	var emailID=document.PensionCutOffEntry.contactEmailId;
	
	if ((emailID.value==null)||(emailID.value.trim()=="")){
		alert("Please Enter your Email ID !");	
		emailID.value="";
		
		return false;
	}
	if (echeck(emailID.value,emailID)==false){
		emailID.value="";
		
		return false;
	}
	return true;
 }



function disablecommFactorPert()
{	
	document.getElementById("commFactorPert").disabled=true;
}



function enablecommFactorPert()
{	
	document.getElementById("commFactorPert").disabled=false;
}



function phoneValidation(value1)
{
	numchk(value1);
	
	var contactCell=value1.value.trim();
	var id=value1.id;
	if((contactCell.length>=10) && (contactCell.length<15)) 
	{
		
	}
	
	else{
		alert('Mobile Number must contain 10-15 Digits !');
		value1.value="";
		
		return false;
	}
 return true;
}



function disable1(value)
{
			
	document.PensionCutOffEntry.commAmt.value="";
	document.PensionCutOffEntry.commPayDate.value="";
	document.PensionCutOffEntry.commFactorPert.value="";
	
	document.PensionCutOffEntry.commAmt.disabled=false;
	document.PensionCutOffEntry.commPayDate.disabled=false;
	document.PensionCutOffEntry.commFactorPert.disabled=true;	
	
	document.PensionCutOffEntry.commfactorOnethird[0].checked=true;
	document.PensionCutOffEntry.commfactorOnethird[1].checked=false;

	document.PensionCutOffEntry.commfactorOnethird[0].disabled=false; 
	document.PensionCutOffEntry.commfactorOnethird[1].disabled=false;
	
}



function enable2(value)
{	
	document.PensionCutOffEntry.commAmt.value="";
	document.PensionCutOffEntry.commPayDate.value="";
	document.PensionCutOffEntry.commFactorPert.value="";
	
	document.PensionCutOffEntry.commAmt.disabled=true;
	document.PensionCutOffEntry.commPayDate.disabled=true;
	document.PensionCutOffEntry.commFactorPert.disabled=true;	
	
	document.PensionCutOffEntry.commfactorOnethird[0].checked=false;
	document.PensionCutOffEntry.commfactorOnethird[1].checked=false;

	document.PensionCutOffEntry.commfactorOnethird[0].disabled=true; 
	document.PensionCutOffEntry.commfactorOnethird[1].disabled=true;
	
}

function checkdate(obj)
{		
	var ids=obj.id;	
	var datesSep=obj.value.split("/");
	if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
			{
				alert("Choosen Date is Future !");
				obj.value="";
				obj.focus();				
			}
	
/*	else if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
		{
			alert('Invalid Date ');
			obj.value="";
		}*/
	else
		{
		//alert('Sas');
		}
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



function stopRKey(evt) {
	
	flag=true;	
	if(evt.keyCode == 13)
	{
		flag=false;
	}
	return flag;
	
}



function genderChange(obj)
{
	var value=obj.value;
	
	var s = document.getElementById("titleId");
	   
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
    {
		var optn0 = document.createElement("OPTION");
		var optn1 = document.createElement("OPTION");
		var optn2 = document.createElement("OPTION");
	
		if(value=='Male')
    	 {
			document.forms[0].titleId.options.length = 0;
			
			optn0.text = "-- Select --";
			optn0.value="0";
			s.options.add(optn0);
			
			optn1.text = "Mr";
			optn1.value="1";
			s.options.add(optn1);
			
			document.forms[0].titleId.selectedIndex=1;
			
			   	
    	 }
		else
			{
			document.getElementById("titleId").options.length = 0; 			
			optn0.text = "-- Select --";
			optn0.value="0";
			s.options.add(optn0);
			
			optn1.text = "Mrs";
			optn1.value="2";
			s.options.add(optn1);
			
			optn2.text = "Selvi";
			optn2.value="3";
			s.options.add(optn2);
			}
    	
    }
	
	else
		{
		
			if(value=='Male')
			{
				s.innerHTML='<option value="0">Select</option><option value="1">Mr</option>';
			}
			else
			{
				s.innerHTML='<option value="0">Select</option><option value="2">Mrs</option><option value="3">Selvi</option>';
			}
		
		}

   }


function checkdate1(obj)
{		
	var ids=obj.id;	
	var datesSep=obj.value.split("/");
	if(isFutureDate1(datesSep[0],datesSep[1],datesSep[2]))
		{		
				alert("Choosen Date is Future !");
				obj.value="";
				obj.focus();				
		}
	
	/*else if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
	{
		alert('Invalid Date ');
		obj.value="";
	}*/
	
	else
		{			
			dob_Check1(obj);
		}
}

function isFutureDate1(day,month,year)
{	
        month-=1;
        var dteDate;
        dteDate=new Date(year,month,day);
        return (dteDate.getTime()>new Date().getTime());    
}


function dob_Check1(obj1) {

var val= obj1.value;
var dM=val.split("/")[0];
var dD=val.split("/")[1];
var dY=val.split("/")[2];

var Dy=1900;
var Dm=1;
var Dd=1;

var y1900= new Date(Dy,Dm,Dd);
var da1=new Date(dY,dM,dD);
//oneyear 1270319400000
//-2206330200000

if(y1900>da1)
{
	alert('Date Of Birth is less than 1-1-1900 ');
	obj1.value="";
	var set1=setTimeout(function(){document.getElementById("dateOfBirth").focus();document.getElementById("dateOfBirth").select();},10);
}
}


function checkdate3(obj)
{		
	var ids=obj.id;	
	var datesSep=obj.value.split("/");
	
	if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
		{
			alert('Family Pension Till Date is Invalid');
			obj.value="";
		}
	else
		{
		 // alert('Sas');
		}
}



function payCommission(object)
{
	var values=object.value;
	if(values=='Yes')
		{
			document.forms[0].dearnessPay.value="";
			document.forms[0].dearnessPay.disabled=true;
		}
	else
	{
		document.forms[0].dearnessPay.value="";
		document.forms[0].dearnessPay.disabled=false;
	}
	
}



function isValidatePincode(t){
	 var pincode=t.value;
	
	 	if(pincode=="")
	       {
	           alert("--Enter Pincode--");
	           return false;
	       }
	       else
	       {
	            if(isNaN(pincode))
	             {
	                  alert("Pincode Contains Only Numbers....."); 
	                  
	                  t.value="";
	                  return false;
	              }
	              
	            
	              if(pincode.length>6) 
	              {
	                  alert("Pincode Must be Six Digits Only.....");
	                  t.value="";
	                  
	                  return false;
	                  
	              }
	              
	              if(pincode.length<6) 
	              {
	                  alert("Pincode Must be Six Digits .....");
	                  t.value="";
	                  
	                  return false;
	              }	            
	             
	      }
	         return true;	

}


