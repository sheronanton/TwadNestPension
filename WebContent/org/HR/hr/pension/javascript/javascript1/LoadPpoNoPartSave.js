
function getReq() {
    var req = false;
    try {
         req = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch(Ex) {
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


function checkPpoNo(ppoNo) {
	var numPat = /^[0-9]+$/;
	var strString =ppoNo;	
	if(!numPat.test(strString))
	{
		return false;
   }
 return true;
}



function loadPartialSave(ppoNo){
		
	var flag=checkPpoNo(ppoNo);
	
	if(!flag)
	{
		 alert("Please Enter Numeric values only!");
		 document.getElementById("ppoNo").value="";		 
		 var set=setTimeout(function(){document.getElementById("ppoNo").focus();document.getElementById("ppoNo").select();},10); 
	}
	
	else
		{				
			var url='LoadPartialSave.html?ppoNo='+ppoNo;
			var HttpPartialRequest = getReq();
			HttpPartialRequest.open("GET", url, true);
			HttpPartialRequest.onreadystatechange=function()
		    {    
		   	getList(HttpPartialRequest); 
		    };  
		     
		     HttpPartialRequest.send(null);
				     
		}
		
}


function getList(HttpPartialRequest) 
{
	var ppo=document.getElementById("ppoNo").value;		
	if(HttpPartialRequest.readyState == 4){
		if(HttpPartialRequest.status == 200){
			var dt=HttpPartialRequest.responseText;			
			if(dt=="yes")
				{
					alert('The Given PPO No already Exists');								
					document.getElementById("ppoNo").value="";
				
				}     
			if(dt=="no")
				{					
					checkFamilyPpoNo(ppo);
				}
			
		}
	}
	
}




function checkFamilyPpoNo(ppono)
{		

	var flag=checkPpoNo(ppono);	
	if(!flag)
	{
		 alert("Please Enter Numeric values only!");
		 document.getElementById("ppoNo").value="";		 
		 var set=setTimeout(function(){document.getElementById("ppoNo").focus();document.getElementById("ppoNo").select();},10); 
	}	
	else
	{	
		var url='familyCheckPpoNo.html?ppoNo='+ppono;
		var HttpPartialRequest1 = getReq();
		HttpPartialRequest1.open("GET", url, true);
		HttpPartialRequest1.onreadystatechange=function()
	     {    
			getFamilyPpoDetails(HttpPartialRequest1);
	     };  
	     HttpPartialRequest1.send(null);	
	}
}



function getFamilyPpoDetails(HttpPartialRequest1)
{
	if(HttpPartialRequest1.readyState == 4)
	{
		if(HttpPartialRequest1.status == 200)
		{        	
			var dt=HttpPartialRequest1.responseText;			
			if(dt=="yes")
				{
					alert('The Given PPO No already Exists');								
					document.getElementById("ppoNo").value="";					
				}     
		}
	}	
}

        	
        	



