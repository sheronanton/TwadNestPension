
var __pagination=5;
var totalblock=0;
var sno=0;
var sel=0;
String.prototype.trim = function() {
    a = this.replace(/^\s+/, '');
    return a.replace(/\s+$/, '');
    };

function setRadio()
{


	if(document.getElementById("saveStatusDraft").checked==true)
		{
		document.getElementById("showselect").style.display='block';
		document.getElementById("showfinalshow").style.display='none';
		
		}
	if(document.getElementById("saveStatusFinal").checked==true)
	{
	document.getElementById("showselect").style.display='none';
	document.getElementById("showfinalshow").style.display='block';
	
	}
	
}

 

function getReq() 
	{
	    var req = false;
	    try {
	         req = new ActiveXObject("Msxml2.XMLHTTP");
	    }
	    catch(Ex)
	    {
	         try {
	             req = new ActiveXObject("Microsoft.XMLHTTP");
	         }
	         catch(ex1) {
	             req = false;
	         }
	    }
	    if(!req && typeof XMLHttpRequest != 'undefined') {
	            req = new XMLHttpRequest();
	            
	    }
	    return req;
	}

function loademployeedata()
{	

      var url="loadRevDCRGPensionValidDataDuetoDa.html?empNo="+document.getElementById("empNo").value;
       var req=getReq();
       req.open("GET",url,true);        
       req.onreadystatechange=function()
       {
           processResult1(req);
        };   
        req.send(null);
}  
	
function processResult1(req)

{	   
	//alert(req);
      if(req.readyState==4)
	  {
    	  //alert("readystate");
	      if(req.status==200)
	      {  
	    	 // alert("readystatus");
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var command=tagCommand.firstChild.nodeValue;
	         if(command=="LoadEmployeeData")
	         { 
	        	 loadMstData(baseResponse);  	        	
	         }	      
	       /*  if(command=="LoadSearchData")
	         {
	        	 LoadData(baseResponse); 
	         }*/
	  
	   }
	}

}



function checkAppSubmit()
{
	var empNo=document.getElementById("empNo").value;
	var ppoNo=document.getElementById("ppoNo").value;	
	var gpoNo=document.getElementById("gpoNo").value;
	var fromAddress=document.getElementById("fromAddress").value;
	var namefromAddress=document.getElementById("nameforFromAddress").value;
	var serviceBookAddress=document.getElementById("serviceBookAddress").value;
	
	var lastWorkOffice=document.getElementById("OfficeId").value;
	var payOffice=document.getElementById("paymentOfficeId");
	
	var empAddress=document.getElementById("empAddress").value;
	var reference=document.getElementById("reference").value;
	
	
	var letterNo=document.getElementById("letterNo").value;
	var datedOn=document.getElementById("datedOn").value;

	var authOfficer=document.getElementById("authOfficer");
	var authOfficeAddress=document.getElementById("authOfficeAddress").value;
	if(document.getElementById("saveStatusFinal").checked)
	{
		status="Final";
	}
	else
	{
		status="Draft";
	}
	if(status=="Final")
	{
		if(empNo!="")
			{
				if(ppoNo=="")
				{
						alert('Please Enter PPO No.');
						return false;
				}
				if(gpoNo=="")
				{
						alert('Please Enter GPO No.');
						return false;
				}				
				if(empAddress=="")
				{
						alert('Please Enter Employee Residential Address.');
						return false;
				}
				if(namefromAddress=="")
				{
					alert('Please Enter Name for From Address');
					return false;
				}
				if(authOfficer.selectedIndex==0)
				{
					alert('Please Select Authorized Officer');
					return false;
				}				
				if(fromAddress=="")				
				{
						alert('Please Enter From Address');
						return false;
				}							
				/*if(serviceBookAddress=="")
				{
					alert('Please Enter Name for Service Booking Address');
					return false;
				}*/
				if(letterNo=="")				
				{
					alert('Please Enter Letter No');
					return false;
				}
				if(payOffice.selectedIndex==0)				
				{
					alert('Please Select Pension Payment Office');
					return false;
				}
				if(lastWorkOffice=="")				
				{
					alert('Please Select Last Working Office');
					return false;
				}				
				if(datedOn=="")				
				{
					alert('Please Enter Dated On');
					return false;
				}
				if(reference=="")
				{
						alert('Please Enter Reference.');
						return false;
				}
				
				
				
			}
		else
			{
			
				alert('Please Enter Employee Number.');
				return false;
			}
	}
	else
	{
		if(empNo=="")
		{
			alert('Please Enter Employee Number.');
			return false;
		}
	}
	
	return true;
}


function ppoNoCheck(objectChk)
{

	var ppoVal=objectChk.value;
	if(ppoVal.trim()!="")
		{
			var url="penAuthoriseCheckPpoNo.html?searchModel4.empId="+ppoVal;			
			var ajaxObj=getReq();
				ajaxObj.open("GET", url, true);
				ajaxObj.onreadystatechange=function()
				{
					checkPpoNumber(ajaxObj);
				};
		     ajaxObj.send(null);
		}
	
}



function checkPpoNumber(req)
{
	 if(req.readyState==4)
	  {
	      if(req.status==200)
	      {  
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
	    	  var display=baseResponse.getElementsByTagName("record");	       
	    	  if(display.length > 0)
	    	  {
	    		  alert('PPO No already Exists');
	    		  document.getElementById("ppoNo").value="";
	    	  }	  
	    	  else
	    	   {
	      
	    	   }
	      }
	  }
}



function loadOfficeAddress(obj)
{
	var val1=obj.value;
	if(val1=="")
	{		
		document.getElementById("paymentOfficeAddress").value="";
	}
	if(val1!="" || val1.length!=0 || val1!=0)
	{		
	var url="penAuthoriseGetOfficeAddress.html?searchModel3.empId="+val1;
	var ajaxObj=getReq();
		ajaxObj.open("GET", url, true);
		ajaxObj.onreadystatechange=function()
		{
			processResult(ajaxObj);
		};
     ajaxObj.send(null);
	}

}


function loadOfficeAddress1(obj)
{
if(obj!="" || val1.length!=0 || obj!=0)
{		
var url="penAuthoriseGetOfficeAddress.html?searchModel3.empId="+obj;
var ajaxObj=getReq();
	ajaxObj.open("GET", url, true);
	ajaxObj.onreadystatechange=function()
	{
		processResult12(ajaxObj);
	};
 ajaxObj.send(null);
}


}



function processResult12(req)
{
	 if(req.readyState==4)
	  {
	      if(req.status==200)
	      {  
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
	    	  var display=baseResponse.getElementsByTagName("record");	       
	    	  
	    	  if(display.length <=0)
	    	  {
	    		  alert('Address Not in Database');
	    	  }	  
	    	  else
	    	   {	
	    		 var preaddress1="The Administrative Officer, ";
	    		 var preaddress2="The Superintending Engineer, ";
	    		 var preaddress="";
	    		 var OfficeId=nullcheck(baseResponse.getElementsByTagName("officeID")[0].firstChild.nodeValue); 
	    		 var add1=nullcheck(baseResponse.getElementsByTagName("address1")[0].firstChild.nodeValue);
	    		 var add2=nullcheck(baseResponse.getElementsByTagName("address2")[0].firstChild.nodeValue);
	    		 var city=nullcheck(baseResponse.getElementsByTagName("city")[0].firstChild.nodeValue);
	    		 var pin=nullcheck(baseResponse.getElementsByTagName("pincode")[0].firstChild.nodeValue); 
	    		 var penpayOfficeId=document.getElementById("paymentOfficeId").value;
	    		 
	    		 //var addStr=add1+' '+add2+' '+city+' -'+pin;
	    		 //var addStr=preaddress+add1+' '+add2+' '+city+' -'+pin;    		 
	    		 
	    		 
	    		 
	    		/* var addStr=add1+' '+add2+' '+city+' -'+pin;
	    		 if(OfficeId==penpayOfficeId)
	    		 {
	    			 addStr=document.getElementById("paymentOfficeAddress").value;
	    		 }	  */  
	    		 
	    		 
	    		 
	    		 if(OfficeId==penpayOfficeId)
	    		 {
	    			 addStr=document.getElementById("paymentOfficeAddress").value;
	    		 }
	    		 else
	    		 {
	    			 addStr=document.getElementById("OfficeId").value;
	    		 }
	    		 
	    		 document.getElementById("lastWorkOfficeAddress").value=addStr;
	      
	    	   }
	      }
	  }
}


function getMasterData(val)
{	
	if(val!="" || val.length!=0)
	{
	var url="penAuthoriseGetMasterData.html?searchModel.empId="+val;
	var ajaxObj=getReq();
		ajaxObj.open("GET", url, true);
		ajaxObj.onreadystatechange=function()
		{
			processResult(ajaxObj);
		};
     ajaxObj.send(null);
	}
	
}



function processResult(req)
{
	 if(req.readyState==4)
	  {
	      if(req.status==200)
	      {  
	    	
	    	  try
	    	  {
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var command=tagCommand.firstChild.nodeValue;
	    	
	    	 if(command=="getMstData")
	         { 
	    		 loadMstData(baseResponse);  	        	
	         }	   
	    	 if(command=="getExistingData")
	         { 
	    		 loadExistData(baseResponse);  	        	
	         }	 
	    	 
	    	 if(command=="searchData")
	         { 
	    		 LoadData(baseResponse);  	        	
	         }	 
	    	 
	    	 if(command=="addressData")
	    	  {
	    		 loadAddress(baseResponse);
	    	  }
	    	
	    	  }
	    	  
	    	  catch(e)
	    	  {
	    		//alert(e);  
	    	  }
	  
	   }
	}

}

function loadAddress(baseResponse)
{
	var display=baseResponse.getElementsByTagName("record");	       
	  if(display.length <=0)
	  {
		  alert('Address Not in Database');
	  }	  
	  else
	   {	
		  var preaddress1="The Administrative Officer, ";
 		 var preaddress2="The Superintending Engineer, ";
 		 var preaddress="";
		 var OfficeId=nullcheck(baseResponse.getElementsByTagName("officeID")[0].firstChild.nodeValue); 
		 var add1=nullcheck(baseResponse.getElementsByTagName("address1")[0].firstChild.nodeValue);
		 var add2=nullcheck(baseResponse.getElementsByTagName("address2")[0].firstChild.nodeValue);
		 var city=nullcheck(baseResponse.getElementsByTagName("city")[0].firstChild.nodeValue);
		 var pin=nullcheck(baseResponse.getElementsByTagName("pincode")[0].firstChild.nodeValue); 
		 //alert(OfficeId);
		 var pin1='';
		 if(pin!="")
			 {
			 pin1='-'+pin;
			 }
		 else
			 {
			 pin1=pin;
			 }
		 //var addStr=add1+' '+add2+' '+city+''+pin1;
		 
		// var lastworkOfficeId=document.getElementById("lastWorkingOfficeId").value;
		 if(OfficeId==5000)
		 {
			 preaddress=preaddress1;
		 }
		 else
		 {
			 preaddress=preaddress2;
		 }
		 //var addStr=preaddress+add1+' '+add2+' '+city+' -'+pin;
		
		 	var pensionPaymentoffice=document.getElementById("paymentOfficeId").value;
		 	var pensionPaymentofficeId=document.getElementById("paymentOfficeId");
			var selectedindex=pensionPaymentofficeId.selectedIndex;
			var selectedtext=pensionPaymentofficeId.options[selectedindex].text;
			if(pensionPaymentoffice=="")
			{
				selectedtext="";
			}
			else
			{
				selectedtext=selectedtext+".";
			}
		 
		 var addStr=preaddress+selectedtext;
		 
		 document.getElementById("paymentOfficeAddress").value=addStr;
		 
		/* if(lastworkOfficeId!="")
		 {
			 if(lastworkOfficeId==OfficeId)
			 {
				 document.getElementById("lastWorkOfficeAddress").value=addStr;
			 }
		 }
*/		 
  
	   }

}

function loadExistData(baseResponse)
{
	var display=baseResponse.getElementsByTagName("record");	       
	  if(display.length <=0)
	  {
		  alert('please Enter Required Details');
	  }	  
	  else
	   {	
		  for(var i=0;i<display.length;i++)
    	  {    
			  document.getElementById("empNo").value=nullcheck(baseResponse.getElementsByTagName("empNo")[i].firstChild.nodeValue); 
			  document.getElementById("ppoNo").value=nullcheck(baseResponse.getElementsByTagName("ppoNo")[i].firstChild.nodeValue); 

			  document.getElementById("fromAddress").value=nullcheck(baseResponse.getElementsByTagName("fromAddress")[i].firstChild.nodeValue);
			 
			  var officeFlag=nullcheck(baseResponse.getElementsByTagName("officeStatus")[i].firstChild.nodeValue);
			  if(officeFlag=='Yes')
				{  
				  	//document.getElementById("circleOrHoYes").checked=true;
				}
			  else
				  {
				  	//document.getElementById("circleOrHoNo").checked=true;
				  }
			  
			  document.getElementById("paymentOfficeAddress").value=nullcheck(baseResponse.getElementsByTagName("payOffice")[i].firstChild.nodeValue);	
			  document.getElementById("letterNo").value=nullcheck(baseResponse.getElementsByTagName("letterNo")[i].firstChild.nodeValue);
			  
			  
			  document.getElementById("datedOn").value=nullcheck(baseResponse.getElementsByTagName("datedOn")[i].firstChild.nodeValue);
			  document.getElementById("reference").value=nullcheck(baseResponse.getElementsByTagName("ref")[i].firstChild.nodeValue);
			  
			  document.getElementById("authOfficer").value=nullcheck(baseResponse.getElementsByTagName("authOfficer")[i].firstChild.nodeValue);
			  document.getElementById("authOfficeAddress").value=nullcheck(baseResponse.getElementsByTagName("authOfficerAddress")[i].firstChild.nodeValue);
			 
			 			  
			  document.getElementById("lastWorkOfficeAddress").value=nullcheck(baseResponse.getElementsByTagName("lastOfficeAddress")[i].firstChild.nodeValue);

			  
    	  }
	   }
}



function loadMstData(baseResponse)
{	
	 var display=baseResponse.getElementsByTagName("record");	       
	  if(display.length <=0)
	  {
		  alert('Record Not Found');	
		  clearAll();
	  }	  
	  else
	   {		  
		  for(var i=0;i<display.length;i++)
    	  {    
			  document.getElementById("empNoLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("empNo")[i].firstChild.nodeValue);		      
			 
			 // var pinit=nullcheck(baseResponse.getElementsByTagName("empInitial")[i].firstChild.nodeValue);	
    		  /*var pname=nullcheck(baseResponse.getElementsByTagName("empName")[i].firstChild.nodeValue);
    		  var empname=pname;*/
			  var empname=nullcheck(baseResponse.getElementsByTagName("empName")[i].firstChild.nodeValue);
			  document.getElementById("hiddenEmpName").value=empname;
			  //alert(document.getElementById("hiddenEmpName").value);
    		  document.getElementById("empNameLabel").innerHTML=empname;
    		  
    		  //document.getElementById("hiddenEmpName").value=nullcheck(baseResponse.getElementsByTagName("empName")[i].firstChild.nodeValue);
    		  var gen=nullcheck(baseResponse.getElementsByTagName("gender")[i].firstChild.nodeValue);	
			  //document.getElementById("hiddenEmpGender").value=gen;
   		  
			  if(gen=='M')
				  {
				  document.getElementById("empGenderLabel").innerHTML='Male';
				  document.getElementById("hiddenEmpGender").value='Male';
				  }
			  if(gen=='F')
				  {
				  document.getElementById("empGenderLabel").innerHTML='Female';
				  document.getElementById("hiddenEmpGender").value='Female';
				  }
			  
			  var dob=nullcheck(baseResponse.getElementsByTagName("dob")[i].firstChild.nodeValue);
			  document.getElementById("empDobLabel").innerHTML=dob;
			  document.getElementById("hiddenEmpDob").value=dob;
			  	  
			  
			  var designation=nullcheck(baseResponse.getElementsByTagName("design")[i].firstChild.nodeValue);
    	      document.getElementById("designationLabel").innerHTML=designation;
    	      document.getElementById("hiddenEmpDesignation").value=designation;
    	      
    	      var office=nullcheck(baseResponse.getElementsByTagName("office")[i].firstChild.nodeValue);
    	      document.getElementById("officeLabel").innerHTML=office;
    		  document.getElementById("hiddenEmpOffice").value=office;
    		  
    		  var ppono=nullcheck(baseResponse.getElementsByTagName("ppono")[i].firstChild.nodeValue);
    		  document.getElementById("ppoNo").innerHTML=ppono;
    		  document.getElementById("hiddenEmpppono").value=ppono;  
    		  
    		  var gpono=nullcheck(baseResponse.getElementsByTagName("gpono")[i].firstChild.nodeValue);
    		  document.getElementById("gpoNo").innerHTML=gpono;
    		  document.getElementById("hiddenEmpgpono").value=gpono;
    		  document.getElementById("empAddress").innerHTML=nullcheck(baseResponse.getElementsByTagName("residentaddr")[i].firstChild.nodeValue);
    		  document.getElementById("nameforFromAddress").value=nullcheck(baseResponse.getElementsByTagName("namefromaddr")[i].firstChild.nodeValue);
    		  document.getElementById("authOfficer").value=nullcheck(baseResponse.getElementsByTagName("authofficer")[i].firstChild.nodeValue);
    		  
    		  fillfromAddress();
    		  
    		  var paymentofficename=nullcheck(baseResponse.getElementsByTagName("paymentofficename")[i].firstChild.nodeValue);
    		  document.getElementById("paymentofficename").innerHTML=paymentofficename;
    		  document.getElementById("hiddenEmppenpayofficename").value=paymentofficename;
    		  
    		  var paymentofficeaddress=nullcheck(baseResponse.getElementsByTagName("paymentofficeaddress")[i].firstChild.nodeValue);
    		  document.getElementById("paymentofficeaddress").innerHTML=paymentofficeaddress;
    		  document.getElementById("hiddenEmppenpayofficeaddress").value=paymentofficeaddress; 
    		  
    		  var lastworkofficeaddress=nullcheck(baseResponse.getElementsByTagName("lastworkoffiaddr")[i].firstChild.nodeValue);
    	  	  document.getElementById("OfficeIdLabel").innerHTML=lastworkofficeaddress;
    		  document.getElementById("hiddenEmplastworkofficeaddress").value=lastworkofficeaddress;
    		  
    		  document.getElementById("dcrgofficeaddress").value=nullcheck(baseResponse.getElementsByTagName("lastworkoffiaddr")[i].firstChild.nodeValue);
    		   
    		  document.getElementById("letterNo").value=nullcheck(baseResponse.getElementsByTagName("letterno")[i].firstChild.nodeValue);
    		  document.getElementById("reference").value=nullcheck(baseResponse.getElementsByTagName("reference")[i].firstChild.nodeValue);
    	      
    		  var olddcrgamount=nullcheck(baseResponse.getElementsByTagName("dcrgamount")[i].firstChild.nodeValue);
    		  document.getElementById("OLDDCRGAMOUNT").innerHTML=olddcrgamount;
    	      document.getElementById("hiddenEmpolddcrgamount").value=olddcrgamount;
    	      
    	      var newdcrgamount=nullcheck(baseResponse.getElementsByTagName("revcaldcrgamt")[i].firstChild.nodeValue);
    	      document.getElementById("revcaldcrgamount").innerHTML=newdcrgamount;
    	      document.getElementById("hiddenEmpnewdcrgamount").value=newdcrgamount;
    	      
    	      var olddapercentage=nullcheck(baseResponse.getElementsByTagName("dapert")[i].firstChild.nodeValue);
    	      document.getElementById("OLDDAPERENTAGE").innerHTML=olddapercentage;
    	      document.getElementById("hiddenEmpolddapercentage").value=olddapercentage;
    	      
    	      var totdcrgamount=nullcheck(baseResponse.getElementsByTagName("revdcrgamt")[i].firstChild.nodeValue);
    	      document.getElementById("revdcrgamount").innerHTML=totdcrgamount;
    	      document.getElementById("hiddenEmptotdcrgamount").value=totdcrgamount;
    	      
    	      
    	      var noofhalfyeardcrg=nullcheck(baseResponse.getElementsByTagName("noofhalfyeardcrg")[i].firstChild.nodeValue);
    	      document.getElementById("noofhalfdcrgyear").innerHTML=noofhalfyeardcrg;
    	      document.getElementById("hiddenEmpnoofhalfyeardcrg").value=noofhalfyeardcrg;
    	      
    	      
    	      
    	      var newda=nullcheck(baseResponse.getElementsByTagName("newda")[i].firstChild.nodeValue);
    	      document.getElementById("revnewda").innerHTML=newda;
    	      document.getElementById("hiddenEmpnewdapercentage").value=newda;
    	      
    	      var newdaamount=nullcheck(baseResponse.getElementsByTagName("daamount")[i].firstChild.nodeValue);
    	      document.getElementById("daamount").innerHTML=newdaamount;
    	      document.getElementById("hiddenEmpnewdaamount").value=newdaamount;
    	      
    	      
    	      
    	      var halfyearper=nullcheck(baseResponse.getElementsByTagName("tothalfyear")[i].firstChild.nodeValue);
    	      document.getElementById("hiddenEmphalfyearper").value=halfyearper;
    	      document.getElementById("tothalfyear").innerHTML=halfyearper;
    	      
    	      var officeid=nullcheck(baseResponse.getElementsByTagName("officeid")[i].firstChild.nodeValue);
    	      document.getElementById("hiddenEmpofficeid").value=officeid;
    	      var paymentofficeid=nullcheck(baseResponse.getElementsByTagName("paymentofficeid")[i].firstChild.nodeValue);
    	      document.getElementById("hiddenEmppaymentofficeid").value=paymentofficeid;
    	     
    	      
    	     
    	     
			 
	   }
		  
		  
		  
		  /*var display2=baseResponse.getElementsByTagName("nominee");	    
		  var nomlist=document.getElementById("nomineeList");
		  
		  if(display2.length <=0)
		  {			 
			 
		  }	  
		  else
		   {	
			  document.getElementById("nomineeList").options.length=0;			
			  var option0=document.createElement("option");
			  	 option0.value='0';
				 option0.innerHTML='--Select--';			 
				 nomlist.appendChild(option0);
				 
			  for(var i=0;i<display2.length;i++)
	    	  {    
				 var nomId=nullcheck(baseResponse.getElementsByTagName("nomId")[i].firstChild.nodeValue);			 
				 var nomName=nullcheck(baseResponse.getElementsByTagName("nomName")[i].firstChild.nodeValue);	
				 var option1=document.createElement("option");
				 option1.value=nomId;
				 option1.innerHTML=nomName;			 
				 nomlist.appendChild(option1);
	    	  }
			  
		   }		  
		
		  document.getElementById("nomineeList").value=sel;
			
		  nomlist.onchange=function()
		  {
			  getRelationName(this);
		  };*/
}
	  
	  setradiovalue();
	  
}
function setradiovalue()
{
	
	document.getElementById("saveStatusDraft").checked=false;
	document.getElementById("saveStatusFinal").checked=false;
	
}

function getRelationName(myObj)
{
var optValue=myObj.value;
var empNo=document.getElementById("empNo").value;
if(optValue!=0)
	{		
		var url="penAuthorisegetNomRelation.html?searchModel5.empId="+empNo+"&searchModel5.keyword="+optValue;		
		var ajaxObj=getReq();
			ajaxObj.open("GET", url, true);
			ajaxObj.onreadystatechange=function()
			{
				nomineeDetails(ajaxObj);
			};
	     ajaxObj.send(null);
	}
if(optValue==0)
{
	 document.getElementById("nomineeName").value="";	
	 document.getElementById("nomineeId").value="";
	 document.getElementById("nomineeRelationId").value="";
	 document.getElementById("nomineeRelationDesc").value="";					 
	 document.getElementById("nomineeRelationDescLabel").innerHTML="";
	
}
}


function nomineeDetails(req)
{
	 if(req.readyState==4)
	  {
	      if(req.status==200)
	      {  
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];	    
	    	  var display3=baseResponse.getElementsByTagName("record");	    	    	  
	    	  if(display3.length <=0)
			  {			 
				 
			  }	  
			  else
			   {	
				 
				  for(var i=0;i<display3.length;i++)
		    	  {    
					 var nomId=nullcheck(baseResponse.getElementsByTagName("nomID")[i].firstChild.nodeValue);			 
					 var nomName=nullcheck(baseResponse.getElementsByTagName("nomName")[i].firstChild.nodeValue);	
					 var relID=nullcheck(baseResponse.getElementsByTagName("relID")[i].firstChild.nodeValue);
					 var relDesc=nullcheck(baseResponse.getElementsByTagName("relDesc")[i].firstChild.nodeValue);
					 /*alert("nomName="+nomName);
					 alert("nomId="+nomId);
					 alert("relID="+relID);
					 alert("relDesc="+relDesc);
					 alert("relDesc="+relDesc);*/
					 if(relID==3 || relID==4)
					 {
						 relDesc="Spouse";
					 }					 
					 document.getElementById("nomineeName").value=nomName;	
					 document.getElementById("nomineeId").value=nomId;
					 document.getElementById("nomineeRelationId").value=relID;
					 document.getElementById("nomineeRelationDesc").value=relDesc;					 
					 document.getElementById("nomineeRelationDescLabel").innerHTML=relDesc;					
		    	  }
				  
			   }
			  
	    	 
	      }
	  }

}

function GenReport() 
{

	
		try
	  	{
		  	 var empno=document.getElementById("empNo").value;
		  	 var FromAddress=document.getElementById("namefromaddress").value;
			 var ResidentAddress=document.getElementById("ResidentAddress").value;
			 var authauth=document.getElementById("authOfficer");
			 var Authorizedoffi=authauth.selectedIndex;
			 var Authorizedofficer=authauth.options[Authorizedoffi].text;
			 var LETTERNO=document.getElementById("letterNo").value;
			 var REFERENCE=document.getElementById("reference").value;
			 var lastworkofficeaddress=document.getElementById("lastworkoffiaddress").value;
					 
		    var reportformid=document.getElementById("reportformId");
		  	var typeOfReportVal=document.getElementById("reportformId").value;
		  	var Datedon=document.getElementById("datedOn").value;
		  	//alert(Datedon);
		  	var selectedindex=reportformid.selectedIndex;
		  	var selectedtext=reportformid.options[selectedindex].text;		  
		  	if(empno=="")
			{
				alert("Select the Employee No.");
				return false;
			}
		  	if(Datedon=="")
	  		{
	  		alert("Please Select Date.");
			return false;
	  		
	  		}
		  	if(selectedtext=="" || selectedtext=="--Select--")
			{
				alert("Please Select pension order report.");
				return false;
			}
			else
			{	
				
				
				  if(typeOfReportVal==1)
				  {
					  					  
					 actionurl="revisedDCRGPensionOrderduetoDaReport.html?empNo="+empno+"&FromAddress="+FromAddress+"&ResidentAddress="
					 +ResidentAddress+"&Authorizedofficer="+Authorizedofficer+"&LETTERNO="+LETTERNO+"&REFERENCE="+REFERENCE+"&lastworkoffiaddress="+lastworkofficeaddress+"&Datedon="+Datedon+"&rnd="+new Date().getTime();
					 // alert("draft"+actionurl);
					 window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  if(typeOfReportVal==2)
				  {
					  actionurl="RevisedDCRGnoteduetoDa.html?empNo="+empno+"&LETTERNO="+LETTERNO+"&REFERENCE="+REFERENCE+"&rnd="+new Date().getTime();;
					  //alert("draft"+actionurl);
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  
				
			}			  
		}
		catch(e)
		{
			//alert(e.message);
		}
		return true;	
}



function validation()
{
	
	try
	{
		//alert("Hai");
		 var empno=document.getElementById("empNo").value;
		 var Datedon=document.getElementById("datedOn").value;
		 if(empno=="")
			{
				alert("Select the Employee No.");
				return false;
			}
		  	if(Datedon=="")
	  		{
	  		alert("Please Select Date.");
			return false;
	  		
	  		}
		
	}
	catch(e)
	{
		
	}
	return true;

}


function freezedata()
{
	
	try
	{
		 var empno=document.getElementById("empNo").value;
	  	 var FromAddress=document.getElementById("nameforFromAddress").value;
		 var ResidentAddress=document.getElementById("empAddress").value;
		 var authauth=document.getElementById("authOfficer");
		 var Authorizedoffi=authauth.selectedIndex;
		 var Authorizedofficer=authauth.options[Authorizedoffi].text;
		 var LETTERNO=document.getElementById("letterNo").value;
		 var REFERENCE=document.getElementById("reference").value;
		 var Datedon=document.getElementById("datedOn").value;
		 //alert(Datedon);
		 
	  	var reportformid=document.getElementById("reportformId");
	  	var typeOfReportVal=document.getElementById("reportformId").value;
	  	var selectedindex=reportformid.selectedIndex;
	  	var selectedtext=reportformid.options[selectedindex].text;	
	  	
	  	if(empno=="")
		{
			alert("Select the Employee No.");
			return false;
		}
	  	if(Datedon=="")
  		{
  		alert("Please Select Date.");
		return false;
  		
  		}
	  	if(selectedtext=="" || selectedtext=="--Select--")
		{
			alert("Please Select pension order report.");
			return false;
		}
	  	
	  	else
	  		{
	  		 actionurl="revisedDCRGPensionfreeze.html?empNo="+empno+"&FromAddress="+FromAddress+"&ResidentAddress="
			 +ResidentAddress+"&Authorizedofficer="+Authorizedofficer+"&LETTERNO="+LETTERNO+"&REFERENCE="+REFERENCE+"&Datedon="+Datedon+"&rnd="+new Date().getTime();
			//alert("Freeze"+actionurl);
	  		
	  		}
		
	}
	
	catch(e)
	{
		//alert(e.message);
	}
	return true;	


}


	function clearAll()
	{
		
		document.getElementById("empNo").value="";	
		document.getElementById("empAddress").value="";		
		document.getElementById("empNameLabel").innerHTML="";		
    	document.getElementById("hiddenEmpName").value="";	 
    	document.getElementById("hiddenEmpGender").value="";
    	document.getElementById("empGenderLabel").innerHTML="";
    	document.getElementById("designationLabel").innerHTML="";	  
    	document.getElementById("hiddenDesigGrpId").value="";
    	document.getElementById("hiddenDesigId").value="";
    	document.getElementById("officeLabel").innerHTML="";
    	document.getElementById("hiddenOfficeId").value="";
    	document.getElementById("empDobLabel").innerHTML="";
    	document.getElementById("hiddenEmpDob").value="";
	  	//document.getElementById("circleOrHoNo").checked=true;
    	document.getElementById("ppoNo").value="";
  		document.getElementById("fromAddress").value="";
    	document.getElementById("paymentOfficeAddress").value="";	
		document.getElementById("letterNo").value="";
		document.getElementById("datedOn").value="";
		document.getElementById("reference").value="";
		document.getElementById("authOfficer").selectedIndex=0;
		document.getElementById("authOfficeAddress").value="";				  
		document.getElementById("lastWorkOfficeAddress").value="";
		document.getElementById("OfficeId").value="";
		document.getElementById("lastWorkingOfficeId").value="";
		document.getElementById("status").value="";
		document.getElementById("lastWorkingOfficeLevel").value="";
		document.getElementById("paymentOfficeId").selectedIndex=0;
		document.getElementById("nameforFromAddress").value="";
		document.getElementById("serviceBookAddress").value="";
		/*
		document.getElementById("empNo").value="";	
		document.getElementById("empAddress").value="";		
		document.getElementById("empNameLabel").innerHTML="";		
    	document.getElementById("hiddenEmpName").value="";	 
    	document.getElementById("hiddenEmpGender").value="";
    	document.getElementById("empGenderLabel").innerHTML="";
    	document.getElementById("designationLabel").innerHTML="";	  
    	document.getElementById("hiddenDesigGrpId").value="";
    	document.getElementById("hiddenDesigId").value="";
    	document.getElementById("officeLabel").innerHTML="";
    	document.getElementById("hiddenOfficeId").value="";
    	document.getElementById("empDobLabel").innerHTML="";
    	document.getElementById("hiddenEmpDob").value="";
	  	//document.getElementById("circleOrHoNo").checked=true;
    	document.getElementById("ppoNo").value="";
  		document.getElementById("fromAddress").value="";
    	document.getElementById("paymentOfficeAddress").value="";	
		document.getElementById("letterNo").value="";
		document.getElementById("datedOn").value="";
		document.getElementById("reference").value="";
		document.getElementById("authOfficer").selectedIndex=0;
		document.getElementById("authOfficeAddress").value="";				  
		document.getElementById("lastWorkOfficeAddress").value="";
		document.getElementById("OfficeId").value="";
		document.getElementById("lastWorkingOfficeId").value="";
		document.getElementById("status").value="";
		document.getElementById("lastWorkingOfficeLevel").value="";
		document.getElementById("paymentOfficeId").selectedIndex=0;
		document.getElementById("nameforFromAddress").value="";
		document.getElementById("serviceBookAddress").value="";
		*/
		
	
		setRadio();
	}


	function searchOperation()
	{
		
		var opt=document.getElementById("SearchOptions").value;
		var key=document.getElementById("SearchKeyword").value;		
		  var url="penAuthoriseSearch.html?penAuthSearch.searchKeyword="+key+"&penAuthSearch.searchOption="+opt;
		  
		  var req=getReq();
		  req.open("GET",url,true);        
		  req.onreadystatechange=function()
		  {
			  processResult(req);
	      };   
	      req.send(null);
	}
		
	
	
function nullcheck(checkstring)
{
	var printstring;
		if((checkstring=="null")||(checkstring==null))
		{
			printstring="";
			
		}
		else
		{
			printstring=checkstring;
		}
		return printstring;
}



function LoadData(baseResponse)
{
	   
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;  
    var len=baseResponse.getElementsByTagName("record").length;
    if(len==0)
      {
	      alert("Pensioner details are not available");   
	      cleanTbody();
	    }
  
         record1=new Array();
         record2=new Array();
         record3=new Array();
         record4=new Array();
                   
         if(len>0)
      	  
          {
      	  var display=baseResponse.getElementsByTagName("empNo");   
      	  for(var i=0;i<display.length;i++)
            {
                record1[i] = baseResponse.getElementsByTagName("empNo")[i].firstChild.nodeValue;
                record2[i] = baseResponse.getElementsByTagName("empName")[i].firstChild.nodeValue;
                record3[i] = baseResponse.getElementsByTagName("designation")[i].firstChild.nodeValue;
                record4[i] = baseResponse.getElementsByTagName("officeName")[i].firstChild.nodeValue;
                
      	    }       
                            totalblock=0;
                            if(record1.length>0)
                              {
                          	  changepagesize();
                                  totalblock=parseInt(record1.length/__pagination);
                             
                                  if(record1.length%__pagination!=0)
                                  {
                                      totalblock=totalblock+1;
                                  }
                                  var cmbpage=document.getElementById("cmbpage");
                                  try
                                  { 
                                      cmbpage.innerHTML="";
                                  }
                                  catch(e){
                                       cmbpage.innerText="";
                                  }
                                  
                                  for(i=1;i<=totalblock;i++)
                                  {
                                      var option=document.createElement("OPTION");
                                      option.text=i;
                                      option.value=i;
                                      try
                                      {
                                      cmbpage.add(option);
                                      }
                                      catch(errorObject)
                                      {
                                      cmbpage.add(option,null);
                                      }
                                  }  
                            
                                  loadRecordVal(1);
                              }
         
       }
         else
         {
             
             var tbody=document.getElementById("tblList");	               
             try
             {
          	   tbody.innerHTML="";
             }
             catch(e) 
             {
          	   tbody.innerText="";
            }
         }
}



function loadRecordVal(page)
{
 
    var i=0;
    var c=0;    
    var p=__pagination*(page-1);

    var tbody=document.getElementById("tblList");
    try{
    	tbody.innerHTML="";
    	
    }
    
    catch(e) {
    	tbody.innerText="";
    	
    }
    document.getElementById("cmbpage").selectedIndex=page-1;
    
    for(i=p;i<record1.length && c<__pagination;i++)
    {
            c++;
            sno++;
            var mycurrent_row=document.createElement("TR"); 
             mycurrent_row.id=p;
             var cell4 = document.createElement("TD");        
             var radioInput ="";   
            if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
            {
               radioInput = document.createElement("<input type=radio name=radios value="+sno+" onclick=javascript:set("+sno+")>");
            }
            else
            {
           	radioInput = document.createElement('input');
            radioInput.setAttribute('type', 'radio');
            radioInput.setAttribute('name', "radios");
            radioInput.setAttribute("value", sno);
            radioInput.setAttribute("onclick","javascript:set("+sno+")");  
			 
			}
			
            cell4.appendChild(radioInput);
            mycurrent_row.appendChild(cell4); 
             
            cell5=document.createElement("TD");	            
	        var currentText=document.createTextNode(record1[i]);
	        cell5.setAttribute("id", "empNo"+sno);	     
	        cell5.appendChild(currentText);
	        mycurrent_row.appendChild(cell5);

	        cell1=document.createElement("TD");	            
            var currentText=document.createTextNode(record2[i]);
            cell1.setAttribute("id", "empName"+sno);	     
            cell1.appendChild(currentText);
            mycurrent_row.appendChild(cell1);
            
            cell2=document.createElement("TD");
            var currentText=document.createTextNode(record3[i]);
            cell2.setAttribute("id", "design"+sno);
            cell2.appendChild(currentText);
            mycurrent_row.appendChild(cell2);            
            
            cell3=document.createElement("TD");
            var currentText=document.createTextNode(record4[i]);
            cell3.setAttribute("id", "office"+sno);
            cell3.appendChild(currentText);
            mycurrent_row.appendChild(cell3);	            
            
        /*    cell7=document.createElement("TD");
            var currentText=document.createTextNode(record5[i]);
            cell7.setAttribute("id", "processStatus"+sno);
            cell7.appendChild(currentText);
            mycurrent_row.appendChild(cell7);
            */
            tbody.appendChild(mycurrent_row);
            
    }
    document.getElementById("rowcount").value=sno;
    sno=0;
    /*This Part Is Used To Move The Next Page Or The Previous Page In The Grid*/
        
    var cell=document.getElementById("divcmbpage");
    cell.style.display="block";
    var cell=document.getElementById("divpage");
    cell.style.display="block";
    try
    {
    	cell.innerHTML='/'+totalblock;
    }
    catch(e){
    	cell.innerText='/'+totalblock;
    }
    
    if(page<totalblock)
    {
        var cell=document.getElementById("divnext");
        cell.style.display="block";
        
        try
        {
            cell.innerHTML="";
        }
        
        catch(e)
        {
            cell.innerText="";
        }
        
        var anc=document.createElement("A");
        var url="javascript:loadRecordVal("+(page+1)+")";
        anc.href=url;
        var txtedit=document.createTextNode("<<Next>>");
        anc.appendChild(txtedit);
        cell.appendChild(anc);
    }
    else
    {
        
    	var cell=document.getElementById("divnext");
        cell.style.display="block";
        
        try{	        	
        cell.innerHTML="";
        
        }
        
        catch(e) {
        	cell.innerText="";
        	
        }
    }
    
    if(page>1)
    {
        var cell=document.getElementById("divpre");
        cell.style.display="block";
        try{
        	cell.innerHTML="";
        	
        }
        
        catch(e) {
        	cell.innerText="";
        	
        }
        
        var anc=document.createElement("A");
        var url="javascript:loadRecordVal("+(page-1)+")";
        anc.href=url;
        var txtedit=document.createTextNode("<<Previous>>");
        anc.appendChild(txtedit);
        cell.appendChild(anc);
    }
    else
    {
        var cell=document.getElementById("divpre");
        cell.style.display="block";
        
        try{
        	cell.innerHTML="";
        	}
        
        catch(e) {
        	cell.innerText="";
        	
        }
    }

}




function changepagesize()
{
	
	
    __pagination=document.getElementById("cmbpagination").value;
    
     totalblock=0;
     
        if(record1.length>0)
        {
            totalblock=parseInt(record1.length/__pagination);
            if(record1.length%__pagination!=0)
            {
                totalblock=totalblock+1;
            }
            var cmbpage=document.getElementById("cmbpage");
            try
            {
                cmbpage.innerHTML="";
            }
            catch(e)
            {
                cmbpage.innerText="";
            }
            for(i=1;i<=totalblock;i++)
            {
                var option=document.createElement("OPTION");
                option.text=i;
                option.value=i;
                try
                {
                    cmbpage.add(option);
                }
                catch(errorObject)
                {
                    cmbpage.add(option,null);
                }
            } 
        }
        loadRecordVal(1);
        document.getElementById("Submit").disabled=true;
}

function changepage()
{
	var page=document.getElementById("cmbpage").value;
    loadRecordVal(parseInt(page));
    document.getElementById("Submit").disabled=true;
}


function cleanTbody()
{
	var tbody=document.getElementById("tblList");	               
    try
    {
 	   tbody.innerHTML="";
    }
    catch(e) 
    {
 	   tbody.innerText="";
     }    
     
    var celldivpre=document.getElementById("divpre");
    var celldivnext=document.getElementById("divnext");
    var celldivcmbpage=document.getElementById("divcmbpage");
    var celldivpage=document.getElementById("divpage");
     
    celldivpre.style.display="none";
    celldivnext.style.display="none";
    celldivcmbpage.style.display="none";
    celldivpage.style.display="none";
    
    document.getElementById("SearchKeyword").value="";
    
    var cellcmbpagination=document.getElementById("cmbpagination");
    cellcmbpagination.value=5; 
    document.getElementById("Submit").disabled=true;
}


function fillfromAddress()
{

		var authOfficer=document.getElementById("authOfficer").value;
		//var nameforFromAddress=document.getElementById("nameforFromAddress").value;
		var authOfficerid=document.getElementById("authOfficer");
		var selectedindex=authOfficerid.selectedIndex;
		var selectedtext=authOfficerid.options[selectedindex].text;
		if(authOfficer=="")
		{
			selectedtext=""
		}
		else
		{
			selectedtext=selectedtext+","
		}
		var fromaddresscontent=" TWAD Board, Head Office, Chennai-600 005.";
		//document.getElementById("fromAddress").value=nameforFromAddress+","+selectedtext+fromaddresscontent;
		document.getElementById("fromAddress").value=selectedtext+fromaddresscontent;
		document.getElementById("fromAddress1").value=selectedtext+fromaddresscontent;
		
		
}
 