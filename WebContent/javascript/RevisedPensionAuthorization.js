
var __pagination=5;
var totalblock=0;
var sno=0;
var sel=0;
String.prototype.trim = function() {
    a = this.replace(/^\s+/, '');
    return a.replace(/\s+$/, '');
    };

    
function setOption()
{
	document.getElementById("saveStatusDraft").checked=false;
	document.getElementById("saveStatusFinal").checked=false;
}
function setCombobox()
{
	if(document.getElementById("saveStatusDraft").checked==true)
	{
		for (var i=0; i <document.revisedPensionAuthorization.pen_option.length; i++)
		{
		   if (document.revisedPensionAuthorization.pen_option[i].checked)
		   {
		      var pen_option_val=document.revisedPensionAuthorization.pen_option[i].value;
		   }
		}
		
		if(pen_option_val=="Revised_Pension")
		{
			document.getElementById("showRevised_Pension").style.display='block';
			document.getElementById("showOneMan_Commision").style.display='none';
			document.getElementById("showSpl_grade").style.display='none';
			document.getElementById("showfinalshow").style.display='none';
			document.getElementById("showgradepay").style.display='none';
		}
		
		if(pen_option_val=="OneMan_Commision")
		{
			document.getElementById("showRevised_Pension").style.display='none';
			document.getElementById("showSpl_grade").style.display='none';
			document.getElementById("showOneMan_Commision").style.display='block';
			document.getElementById("showfinalshow").style.display='none';
			document.getElementById("showgradepay").style.display='none';
		}
		
		if(pen_option_val=="Special_Grade")
		{
			document.getElementById("showSpl_grade").style.display='block';
			document.getElementById("showRevised_Pension").style.display='none';
			document.getElementById("showOneMan_Commision").style.display='none';
			document.getElementById("showfinalshow").style.display='none';
			document.getElementById("showgradepay").style.display='none';
		}
		
		if(pen_option_val=="Grade_pay")
		{
			document.getElementById("showSpl_grade").style.display='none';
			document.getElementById("showRevised_Pension").style.display='none';
			document.getElementById("showOneMan_Commision").style.display='none';
			document.getElementById("showfinalshow").style.display='none';
			document.getElementById("showgradepay").style.display='block';
		}

		//document.getElementById("showselect").style.display='block';
		//document.getElementById("showfinalshow").style.display='none';
		
		
	}
	if(document.getElementById("saveStatusFinal").checked==true)
	{
		document.getElementById("showRevised_Pension").style.display='none';
		document.getElementById("showOneMan_Commision").style.display='none';
		document.getElementById("showSpl_grade").style.display='none';
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
	if(!req && typeof XMLHttpRequest != 'undefined') 
	{
		req = new XMLHttpRequest();
	}
	return req;
}


function generateReport() 
{	  			  
	try
	{
		var Status;
		if(document.revisedPensionAuthorization.saveStatus[0].checked)
		{
			Status=document.revisedPensionAuthorization.saveStatus[0].value;
		}	
		else if(document.revisedPensionAuthorization.saveStatus[1].checked)
		{
			Status=document.revisedPensionAuthorization.saveStatus[1].value;
		}
		else
		{
			Status=null;
		}
		if(Status=="" || Status==null )
		{
			alert("Select Draft or Final Option");
			return false;
		}
		var empno=document.getElementById("empNo").value;
		var ppono=document.getElementById("ppoNo").value;
		var gpono=document.getElementById("gpoNo").value;
		var ResidentAddress=document.getElementById("empAddress").value;
		var nameFromAddress=document.getElementById("nameforFromAddress").value;
		
		var payoffice=document.getElementById("paymentOfficeId");
		var payoffiid=payoffice.selectedIndex;
		var paymentofficeid=payoffice.options[payoffiid].text;
		
		var fromAddress=document.getElementById("fromAddress").value;
		var serviceBookAddress=document.getElementById("serviceBookAddress").value;
		
		var LETTERNO=document.getElementById("letterNo").value;
		
		var authauth=document.getElementById("authOfficer");
		var Authorizedoffi=authauth.selectedIndex;
		var Authorizedofficer=authauth.options[Authorizedoffi].text;
		
		var REFERENCE=document.getElementById("reference").value;
		var lastworkofficeaddress=document.getElementById("lastWorkOfficeAddress").value;
				
		var typeOfReportVal=document.getElementById("reportformId").value;
		var typeOfReportVal_1=document.getElementById("reportform_onemanId").value;	
		var typeOfReportVal_2=document.getElementById("reportform_SplgradeId").value;	
		var typeOfReportVal_3=document.getElementById("reportform_gradepayId").value;
		
		var Datedon=document.getElementById("datedOn").value;		
		
		var reportformid=document.getElementById("reportformId");
		var selectedindex=reportformid.selectedIndex;
		var selectedtext=reportformid.options[selectedindex].text;
		
		var reportform_onemanId=document.getElementById("reportform_onemanId");
		var selectedindex_1=reportform_onemanId.selectedIndex;
		var selectedtext_1=reportform_onemanId.options[selectedindex_1].text;
		
		var reportform_splgrade=document.getElementById("reportform_SplgradeId");
		var selectedindex_2=reportform_splgrade.selectedIndex;
		var selectedtext_2=reportform_splgrade.options[selectedindex_2].text;
		
		var reportform_gradepayId=document.getElementById("reportform_gradepayId");
		var selectedindex_3=reportform_gradepayId.selectedIndex;
		var selectedtext_3=reportform_gradepayId.options[selectedindex_3].text;
		
		if(empno=="")
		{
			alert("Select the Employee No.");
			return false;
		}
	  	if(ppono=="")
	  	{
	  		alert("Please Enter PPO Number");
	  		return false;
	  	}
	  	if(gpono=="")
	  	{
	  		alert("Please Enter G.P.O No.");
	  		return false;
	  	}
	  	if(Datedon=="")
		{
	 		alert("Please Select Date.");
	 		return false;
	  	}
	  	
	  	for (var i=0; i <document.revisedPensionAuthorization.pen_option.length; i++)
		{
		   if (document.revisedPensionAuthorization.pen_option[i].checked)
		   {
		      var pen_option_val=document.revisedPensionAuthorization.pen_option[i].value;
		   }
		}
	  	//var pen_option_val=document.getElementsByName(pen_option).value;
	  	//alert(pen_option_val);
	  	
		if(pen_option_val=="Revised_Pension")
		{
			if(selectedtext=="" || selectedtext=="--Select Any One--")
			{
				alert("Please Select Revised Pension Order Report !...");
				return false;
			}
		}
		
		if(pen_option_val=="OneMan_Commision")
		{
			if(selectedtext_1=="" || selectedtext_1=="--Select Any One--")
			{
				alert("Please Select OneMan Commision Order Report !...");
				return false;
			}
		}
		if(pen_option_val=="Special_Grade")
		{
			if(selectedtext_2=="" || selectedtext_2=="--Select Any One--")
			{
				alert("Please Select Special Grade Report !...");
				return false;
			}
		}
		
		if(pen_option_val=="Grade_Pay")
		{
			if(selectedtext_3=="" || selectedtext_32=="--Select Any One--")
			{
				alert("Please Select Grade Pay Report !...");
				return false;
			}
		}
		//alert('welcome to report generation=='+typeOfReportVal_3);
	  	if(typeOfReportVal=="1")
		{	 
	  		//alert('First window'+typeOfReportVal);
	  		actionurl="RevisedpensionNote.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;
	  		//alert(' '+actionurl);
	  		window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_1=="1")
		{			  
			actionurl="OneManCommisionNote.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;				  
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_2=="1")
		{			  
			actionurl="SplGradeNote.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;				  
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_3=="1")
		{	
			//alert("1");
			actionurl="GradePayNote.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;				  
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal=="2")
		{				 
			actionurl="RevisedpensionOrder.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_1=="2")
		{
			actionurl="OneManCommisionOrder.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_2=="2")
		{
			actionurl="SpecialGradeOrder.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_3=="2")
		{
			actionurl="GradePayOrder.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal=="3" )
		{
			actionurl="RevisedpensionOrderDcrg.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;					  
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_1=="3" )
		{
			actionurl="OneManCommisionOrderDcrg.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;					  
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_2=="3" )
		{
			actionurl="SpecialGradeOrderDcrg.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;					  
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
		if(typeOfReportVal_3=="3" )
		{
			actionurl="GradePayOrderDcrg.html?empId="+empno+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+"&ppono="+ppono+"&FromAddress="+nameFromAddress;					  
			window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
		}
	}
	catch(e)
	{
		//alert(e.message);
	}
	return true;	
}


function saveasDraft()
{
	var Status;
	if(document.revisedPensionAuthorization.saveStatus[0].checked)
	{
		Status=document.revisedPensionAuthorization.saveStatus[0].value;
	}	
	else if(document.revisedPensionAuthorization.saveStatus[1].checked)
	{
		Status=document.revisedPensionAuthorization.saveStatus[1].value;
	}
	else
	{
		Status=null;
	}
	if(Status=="" || Status==null )
	{
		alert("Select Draft or Final Option");
		return false;
	}
	var empno=document.getElementById("empNo").value;
	var ppono=document.getElementById("ppoNo").value;
	var gpono=document.getElementById("gpoNo").value;
	var ResidentAddress=document.getElementById("empAddress").value;
	var nameFromAddress=document.getElementById("nameforFromAddress").value;
	
	var officeid=document.getElementById("hiddenOfficeId").value;
	//alert(officeid);
	var payoffice=document.getElementById("paymentOfficeId");
	var payoffiid=payoffice.selectedIndex;
	var paymentofficeid=payoffice.options[payoffiid].text;
	
	var paymentOfficeAddress=document.getElementById("paymentOfficeAddress").value;
	
	var fromAddress=document.getElementById("fromAddress").value;		
	var serviceBookAddress=document.getElementById("serviceBookAddress").value;
	
	var LETTERNO=document.getElementById("letterNo").value;
	
	var authid =document.getElementById("authOfficeAddress").value;
	//alert('authid=== '+authid);
	var authauth=document.getElementById("authOfficer");
	var Authorizedoffi=authauth.selectedIndex;
	//alert('authid   === '+Authorizedoffi);
	var Authorizedofficer=authauth.options[Authorizedoffi].text;
	//alert('Authorizedofficer=== '+Authorizedofficer);
	
	var REFERENCE=document.getElementById("reference").value;
	
	var lastworkofficeid=document.getElementById("lastWorkingOfficeId").value;
	//alert(lastworkofficeid);
	var lastworkofficeaddress=document.getElementById("lastWorkOfficeAddress").value;
			
	var typeOfReportVal=document.getElementById("reportformId").value;
	var typeOfReportVal_1=document.getElementById("reportform_onemanId").value;	
	
	var Datedon=document.getElementById("datedOn").value;		
	
	var reportformid=document.getElementById("reportformId");
	var selectedindex=reportformid.selectedIndex;
	var selectedtext=reportformid.options[selectedindex].text;
	
	var reportform_onemanId=document.getElementById("reportform_onemanId");
	var selectedindex_1=reportform_onemanId.selectedIndex;
	var selectedtext_1=reportform_onemanId.options[selectedindex_1].text;	
	
	var nominee_name=document.getElementById("nomineeName").value;
	var nominee_id=document.getElementById("nomineeId").value;
	var nominee_relationId=document.getElementById("nomineeRelationId").value;
	var nominee_relationDesc=document.getElementById("nomineeRelationDesc").value;
	
	if(Status=="Draft")
	{
		
		actionurl="RevisedpensionDraftSave.html?empId="+empno+"&ppono="+ppono+"&gpono="+gpono+"&officeid="+officeid+"&residentAddress="+ResidentAddress+
				"&officeaddress="+paymentOfficeAddress+"&from_address="+fromAddress+"&servicebookaddress="+serviceBookAddress+"&authorizedofficer="+Authorizedofficer+
				"&lastworkofficeid="+lastworkofficeid+"&lastworkofficeaddress="+lastworkofficeaddress+"&LetterNo="+LETTERNO+"&date_on="+Datedon+"&reference="+REFERENCE+
				"&namefromaddress="+nameFromAddress+"&authoffid="+Authorizedoffi+"&authoffaddress="+authid+"" +
				"&status="+Status+"&nominee_name="+nominee_name+"&nominee_id="+nominee_id+"&nominee_relationId="+nominee_relationId+"&nominee_relationDesc="+nominee_relationDesc;
		
		//alert(actionurl);
		window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');		
	}
	return true;
}

function validatebeforeFreeze()
{	
	try
	{
		//alert("checking freeze method");
		var empno=document.getElementById("empNo").value;
		var ppono=document.getElementById("ppoNo").value;
		var gpono=document.getElementById("gpoNo").value;
		var namefromaddress=document.getElementById("nameforFromAddress").value;
		var authOfficer=document.getElementById("authOfficer").value;
		var letterNo=document.getElementById("letterNo").value;
		var paymentOfficeId=document.getElementById("paymentOfficeId").value;
		var Datedon=document.getElementById("datedOn").value;
		
		if(empno=="")
		{
			alert("Select the Employee No.");
			return false;
		}
		if(ppono=="")
		{
			alert("Enter the PPO No.");
			return false;
		}
		if(gpono=="")
		{
			alert("Enter the GPO No.");
			return false;
		}
		if(namefromaddress=="")
		{
			alert("Enter the NAME FROM ADDRESS.");
			return false;
		}
		if(authOfficer=="")
		{
			alert("Select the AUTHORIZED OFFICER.");
			return false;
		}
		if(letterNo=="")
		{
			alert("Enter the LETTER No.");
			return false;
		}
		if(paymentOfficeId=="")
		{
			alert("Select the PAYMENT OFFICE.");
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
		var url="revisedPenAuthoriseCheckPpoNo.html?searchModel4.empId="+ppoVal;			
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
	var url="revisedPenAuthoriseGetOfficeAddress.html?searchModel3.empId="+val1;
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
var url="revisedPenAuthoriseGetOfficeAddress.html?searchModel3.empId="+obj;
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
	var url="revisedPenAuthoriseGetMasterData.html?searchModel.empId="+val;
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
		 
		 var lastworkOfficeId=document.getElementById("lastWorkingOfficeId").value;
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
		 
		 if(lastworkOfficeId!="")
		 {
			 if(lastworkOfficeId==OfficeId)
			 {
				 document.getElementById("lastWorkOfficeAddress").value=addStr;
			 }
		 }
		 
  
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
			  document.getElementById("empNo").value=nullcheck(baseResponse.getElementsByTagName("empId")[i].firstChild.nodeValue);		
			 // var pinit=nullcheck(baseResponse.getElementsByTagName("empInitial")[i].firstChild.nodeValue);	
    		  var empname=nullcheck(baseResponse.getElementsByTagName("empName")[i].firstChild.nodeValue);
    		  //var empname;
    		  
    		  /*if(pinit!="" || pinit.length>0)
			  {
			  		empname=pinit+' '+pname;
			  }
    		  else
			  {
    			  empname=pname;
			  }*/
			  
			
			  document.getElementById("empNameLabel").innerHTML=empname;
			  document.getElementById("hiddenEmpName").value=empname;		  	  
  
			  var gen=nullcheck(baseResponse.getElementsByTagName("gender")[i].firstChild.nodeValue);	
			  document.getElementById("hiddenEmpGender").value=gen;

			  if(gen=='M')
				  {
				  document.getElementById("empGenderLabel").innerHTML='Male';
				  }
			  if(gen=='F')
				  {
				  document.getElementById("empGenderLabel").innerHTML='Female';
				  }
			  
			  document.getElementById("designationLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("designation")[i].firstChild.nodeValue);
			  document.getElementById("hiddenDesigGrpId").value=nullcheck(baseResponse.getElementsByTagName("desigGrpId")[i].firstChild.nodeValue);
			  document.getElementById("hiddenDesigId").value=nullcheck(baseResponse.getElementsByTagName("desigId")[i].firstChild.nodeValue);
			  
			  document.getElementById("officeLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("officeName")[i].firstChild.nodeValue);	
			  document.getElementById("hiddenOfficeId").value=nullcheck(baseResponse.getElementsByTagName("officeId")[i].firstChild.nodeValue);
			  
			  
			  document.getElementById("empDobLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("dob")[i].firstChild.nodeValue);
			  document.getElementById("hiddenEmpDob").value=nullcheck(baseResponse.getElementsByTagName("dob")[i].firstChild.nodeValue);
		
			  
			  document.getElementById("ppoNo").value=nullcheck(baseResponse.getElementsByTagName("ppoNo")[i].firstChild.nodeValue); 
			  document.getElementById("empAddress").value=nullcheck(baseResponse.getElementsByTagName("residentAddress")[i].firstChild.nodeValue); 

			  
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
			  
			  document.getElementById("lastWorkingOfficeId").value=nullcheck(baseResponse.getElementsByTagName("lastOfficeId")[i].firstChild.nodeValue);
			  document.getElementById("lastWorkOfficeAddress").value=nullcheck(baseResponse.getElementsByTagName("lastOfficeAddress")[i].firstChild.nodeValue);
			  document.getElementById("OfficeId").value=nullcheck(baseResponse.getElementsByTagName("lastOffice")[i].firstChild.nodeValue);

			  document.getElementById("paymentOfficeId").value=nullcheck(baseResponse.getElementsByTagName("payOfficeId")[i].firstChild.nodeValue);
			  document.getElementById("paymentOfficeAddress").value=nullcheck(baseResponse.getElementsByTagName("payOfficeAddress")[i].firstChild.nodeValue);
			   
			  document.getElementById("letterNo").value=nullcheck(baseResponse.getElementsByTagName("letterNo")[i].firstChild.nodeValue);
			  document.getElementById("datedOn").value=nullcheck(baseResponse.getElementsByTagName("datedOn")[i].firstChild.nodeValue);
			  document.getElementById("reference").value=nullcheck(baseResponse.getElementsByTagName("ref")[i].firstChild.nodeValue);
			  
			  document.getElementById("authOfficer").value=nullcheck(baseResponse.getElementsByTagName("authOfficer")[i].firstChild.nodeValue);
			  document.getElementById("authOfficeAddress").value=nullcheck(baseResponse.getElementsByTagName("authOfficerAddress")[i].firstChild.nodeValue);
			  document.getElementById("gpoNo").value=nullcheck(baseResponse.getElementsByTagName("gpono")[i].firstChild.nodeValue);
			  
			  document.getElementById("nomineeId").value=nullcheck(baseResponse.getElementsByTagName("nominId")[i].firstChild.nodeValue);
			  document.getElementById("nomineeName").value=nullcheck(baseResponse.getElementsByTagName("nominName")[i].firstChild.nodeValue);
			  document.getElementById("nomineeRelationId").value=nullcheck(baseResponse.getElementsByTagName("relId")[i].firstChild.nodeValue);
			  document.getElementById("nomineeRelationDesc").value=nullcheck(baseResponse.getElementsByTagName("relDesc")[i].firstChild.nodeValue);
			 
			  document.getElementById("nomineeRelationDescLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("relDesc")[i].firstChild.nodeValue);
			  
			  
			  document.getElementById("nameforFromAddress").value=nullcheck(baseResponse.getElementsByTagName("nameFromAddress")[i].firstChild.nodeValue);
			  document.getElementById("serviceBookAddress").value=nullcheck(baseResponse.getElementsByTagName("serviceBookAddress")[i].firstChild.nodeValue);
			  
			  /*alert(nullcheck(baseResponse.getElementsByTagName("nominId")[i].firstChild.nodeValue));
			  alert(nullcheck(baseResponse.getElementsByTagName("nominName")[i].firstChild.nodeValue));
			  alert(nullcheck(baseResponse.getElementsByTagName("relId")[i].firstChild.nodeValue));
			  alert(nullcheck(baseResponse.getElementsByTagName("relDesc")[i].firstChild.nodeValue));*/
			  
			  
			  sel=nullcheck(baseResponse.getElementsByTagName("nominId")[i].firstChild.nodeValue);
			 
	   }
		  
		  
		  
		  var display2=baseResponse.getElementsByTagName("nominee");	    
		  var nomlist=document.getElementById("nomineeList");
		  
		  if(display2.length <=0)
		  {			 
			 alert('No Nominee Details');
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
		  };
}
}


function getRelationName(myObj)
{
var optValue=myObj.value;
var empNo=document.getElementById("empNo").value;
if(optValue!=0)
	{		
		var url="revisedPenAuthorisegetNomRelation.html?searchModel5.empId="+empNo+"&searchModel5.keyword="+optValue;		
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
		
	
		setRadio();
	}


	function searchOperation()
	{
		
		var opt=document.getElementById("SearchOptions").value;
		var key=document.getElementById("SearchKeyword").value;		
		  var url="revPenAuthoriseSearch.html?revPenAuthSearch.searchKeyword="+key+"&revPenAuthSearch.searchOption="+opt;
		  
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
		var nameforFromAddress=document.getElementById("nameforFromAddress").value;
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
}
 