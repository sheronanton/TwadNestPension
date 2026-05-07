function getTransport()
{

 var req = false;

 try 
 {
       req= new ActiveXObject("Msxml2.XMLHTTP");
 }
 catch (e) 
 {
       try 
       {
            req = new ActiveXObject("Microsoft.XMLHTTP");
       }
       catch (e2) 
       {
            req = false;
       }
 }
 if (!req && typeof XMLHttpRequest != 'undefined') 
 {
       req = new XMLHttpRequest();
 }   
 return req;
} 


function numberOnly(e,oBj)
{
	var keynum;
	var keychar;
	var numcheck;
	
	if(window.event) //IE
	{
		keynum=e.keyCode;
	}
	if(e.which) //Netscape/Firefox/Opera
	{
		keynum=e.which;
	}
	keychar=String.fromCharCode(keynum);
	//var splCharCheck = /[a-zA-Z!@#$%&*()+=|_'"`~:;<>?,\/\\\^\\{\}\[\]]/;
	var splCharCheck = /[a-zA-Z!@#$%&*()+=|_"'`~:;<>?,.\-\\/\\\^\\{\}\[\]]/;
	
	return (!splCharCheck.test(keychar));
}

function charOnly(e,oBj)
{
	var keynum;
	var keychar;
	var numcheck;
	
	if(window.event) //IE
	{
		keynum=e.keyCode;
	}
	if(e.which) //Netscape/Firefox/Opera
	{
		keynum=e.which;
	}
	keychar=String.fromCharCode(keynum);
	//var splCharCheck = /[a-zA-Z!@#$%&*()+=|_'"`~:;<>?,\/\\\^\\{\}\[\]]/;
	var splCharCheck = /[0-9!@#$%&*()+=|_"'`~:;<>?,\-\\/\\\^\\{\}\[\]]/;
	
	return (!splCharCheck.test(keychar));
}


function checkExisting(empNo)
{
	try
	{	
	if(empNo!="" && empNo.length>0)
	{		
		var url="checkexistingpenfam.html?itRecovery.searchKeyword="+empNo;			
		var myFamPenObj=getTransport();
		myFamPenObj.open("GET", url, true);
		myFamPenObj.onreadystatechange=function()
		{    				
			loadValues(myFamPenObj);
		
		};		
		myFamPenObj.send(null);			
	}	
	
	}
	
	catch(e)
	{
		alert(e);
	}
}
 
function loadValues(myFamPenObj)
{
	if(myFamPenObj.readyState==4)
	  {
	      if(myFamPenObj.status==200)
	      {  	  
	    	  
	    	  
	    	     //alert(myFamPenObj.responseText);
		    	  var baseResponse=myFamPenObj.responseXML.getElementsByTagName("response")[0];	 
		    	  //alert(baseResponse);
		    	  var tagCommand=baseResponse.getElementsByTagName("command")[0].firstChild.nodeValue;
		    	 // alert(tagCommand);
		    	 /*if(tagCommand=="CheckName") 
		    	  {
		    	  var flag2=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
		    	  //alert(flag2);
		    	  if(flag2==true ||flag2=='true')
		    	  	{
		    		  document.getElementById("empNo").value="";
		    		  document.getElementById("empName").value="";
		    		  document.getElementById("changeName").value="";
		    		  alert("Enter the Employee Already Authorized");
		    		  
		    		}
		    	  }
		    	 else*/ 
		    	  if(tagCommand=="pensionername")
		    	   {
		    	  var display=baseResponse.getElementsByTagName("record");
		    	  var flag1=baseResponse.getElementsByTagName("flag1")[0].firstChild.nodeValue;
		    	  //alert(flag1);	  
		    	  if(display.length<=0)
		   		  {	    
			    	  alert("Not a valid EMP NO.");	
			    	  document.getElementById("empNo").value="";
		   		  }
		    	  else
		    		 {
		    		  if(flag1=='true' || flag1==true)
		    			  {
		    			var initial= baseResponse.getElementsByTagName("initial")[0].firstChild.nodeValue;
		    		     var name= baseResponse.getElementsByTagName("empName")[0].firstChild.nodeValue;
		    			  //alert(initial+"---"+name);
		    			  document.getElementById("empNo").value=baseResponse.getElementsByTagName("empId")[0].firstChild.nodeValue;
		    			  document.getElementById("empName").value=nullcheck(baseResponse.getElementsByTagName("empName")[0].firstChild.nodeValue);
		    			  document.getElementById("initial").value=nullcheck(initial);
		    			  document.getElementById("changeName").value=nullcheck(name);
		    			 }
		    		  else
		    			  {
		    			   alert("Enter the Employee Already Authorized");
		    			}
		    	 }
		      }
	      }
	  }

}



function nullcheck(checkstring)
{
	var printstring
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

function chechchar(name)
{
	//alert("name=="+name);
   if(name.indexOf('.') == -1)
	   {
	   alert("Enter the Valid Name(e.g T.Gopinath or TN.Gopinath)");
	   document.getElementById("changeName").value="";
	   document.getElementById("changeName").focus();
	   }
}