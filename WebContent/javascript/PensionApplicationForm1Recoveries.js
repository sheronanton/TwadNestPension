
/*function GetXmlHttpObject()
{
    if(window.XMLHttpRequest)
    {
         // code for IE7+, Firefox, Chrome, Opera, Safari
        return new XMLHttpRequest();
    }
    if(window.ActiveXObject)
    {
        // code for IE6, IE5
         return new ActiveXObject("Microsoft.XMLHTTP");
    }
}*/


/*************************************Add row in grid function start*******************************************/
var recaid=1;
function addRecoveries()
{
	
	tbodyvar=document.getElementById("rectest");	
	recaid=1;
	if(tbodyvar.rows.length>0)
	{
		recaid=tbodyvar.rows.length+1;
	}
	mycurrent_recrow=document.createElement("TR");	
	mycurrent_recrow.id="rec"+recaid;
    rid=mycurrent_recrow.id;
	//mycurrent_recrow.id=aid;
      
         
    
	reccell1=document.createElement("TD");
	reccell1.setAttribute("align","center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{ 	 
		rechidden1=document.createElement("<input type='text'  name='rec_description' id='rec_description' class='recdescriptionbox'>");		
	}
	else
	{		  
		rechidden1=document.createElement("input");
		rechidden1.type="text";
		rechidden1.style.textAlign="left";
		rechidden1.name="rec_description";
		rechidden1.id="rec_description";			
		rechidden1.className="recdescriptionbox";		
	}
	reccell1.appendChild(rechidden1);
	mycurrent_recrow.appendChild(reccell1);



	reccell2=document.createElement("TD");
	reccell2.setAttribute("align","center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{			 
		rechidden2=document.createElement("<input type='text'  name='rec_amount' id='rec_amount' style='text-align:right;' onkeypress='return numonly(event);' onchange='refresh_totalrecamount();' class='recamountbox'>");
	}
	else
	{			  
		rechidden2=document.createElement("input");
		rechidden2.type="text";
		rechidden2.style.textAlign="right";
		rechidden2.name="rec_amount";
		rechidden2.id="rec_amount";		
		rechidden2.className="recamountbox";
		rechidden2.setAttribute('onkeypress','return numonly(event);');
		rechidden2.setAttribute('onchange','refresh_totalrecamount();');
	}
	reccell2.appendChild(rechidden2);
	mycurrent_recrow.appendChild(reccell2);



	reccell3=document.createElement("TD");
	reccell3.setAttribute("align","center");
	reccell3.setAttribute("width","10%");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{  		 
		rechidden3=document.createElement("<input type='button'  name='"+rid+"' id='"+rid+"' value='Delete'  onclick='deleterecrow(this);'/>");			
	}
	else
	{		  
		rechidden3=document.createElement("input");
		rechidden3.type="button";
		rechidden3.value="Delete";
		rechidden3.name=rid;
		rechidden3.id=rid;
		rechidden3.setAttribute('onclick','delrecrow(this);');			    
	}
	reccell3.appendChild(rechidden3);
	mycurrent_recrow.appendChild(reccell3);  
   
  	tbodyvar.appendChild(mycurrent_recrow);    
  	recaid++;	
	
}

/****************************************************************Add row in grid function end*******************************************/


/**********************************************************Recovery form validation start************************************************/

function validaterecform()
{
	try
	{
	
	tbodyvar=document.getElementById("rectest");
	var recdescriptionEntity=document.AEForm.rec_description;	
	var recamountEntity=document.AEForm.rec_amount;	
	if(tbodyvar.rows.length>0)
	{
		var valfl=0;
		for(i=0; i<recdescriptionEntity.length; i++)
		{			
			if(recdescriptionEntity[i].value=="")
			{
				valfl=1;
				recdescriptionEntity[i].style.background="red";
			}
			else if(recdescriptionEntity[i].value!="")
			{
				recdescriptionEntity[i].style.background="white";
			}
			if(recamountEntity[i].value=="")
			{
				valfl=1;
				recamountEntity[i].style.background="red";
			}
			else if(recamountEntity[i].value!="")
			{
				recamountEntity[i].style.background="white";
			}
						
		}
		if(valfl==0)
		{			
			refresh_totalrecamount();			
		}
		else
		{
			alert("Please Enter valid data.");
			return false;
		}
		
	
	}
	else
	{		
		if(recdescriptionEntity.value=="")
		{
			alert("Enter recovery description");
			return false;
		}
		if(recamountEntity.value=="")
		{
			alert("Enter recovery amount");
			return false;
		}		
		refresh_totalrecamount();
	}	
			addRecoveries();
		
	}
	catch(e)
	{
		alert(e.message);
	}
	
}

/***************************************************************Recovery form validation end************************************************/


/******************************************************Number only function start**********************************************************/
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
	var splCharCheck = /[a-zA-Z!@#$%&*()+-=|_'"`~:;<>?,\/\\\^\\{\}\[\]]/;
	
	return (!splCharCheck.test(keychar));
}



function numonly(e)
{
	var flag=true;
    var unicode=e.charCode? e.charCode : e.keyCode;
  
    if (unicode!=8)//backspace
    { 
    	// alert(unicode);  	
        if (unicode<45||unicode>57||unicode==47||unicode==45) 
        	flag=false ;
    }
    
    return flag;
    
} 

/******************************************************Number only function end***************************************************************/


/**************************************************************Delete row function start for IE**********************************************/


function deleterecrow(str)
{	
	var r=confirm("Are you sure want to delete this record.");
	if(r==true)
	{
		try
		{
			var current = window.event.srcElement;			
    		while ( (current = current.parentElement)  && current.tagName !="TR");
        	current.parentElement.removeChild(current);        		
        	refresh_totalrecamount();        		
		}
		catch(e)
		{
			alert(e.message);
		}
	}
	

}
/**************************************************************Delete row function end for IE**********************************************/
/**************************************************************Delete row function start for Mozilla***************************************/
function delrecrow(str)
{		
	var deletrow=str.id;	
	var r=confirm("Are you sure want to delete this record.");
	if(r==true)
	{
		try
		{			
			document.getElementById(deletrow).innerHTML="";			
			refresh_totalrecamount();
		}
		catch(e)
		{
			alert(e.message);
		}
	}

}

/*************************************************************Delete row function end for Mozilla*******************************************/

/***********************************************************Total Recvoery amount calculation start*****************************************/

function refresh_totalrecamount()
{	
	var frecamount=0;
	var ftrecamount=0;
	tbodyvar=document.getElementById("rectest");	
	var recdescriptionEntity=document.AEForm.rec_description;	
	var recamountEntity=document.AEForm.rec_amount;
		//if(tbodyvar.rows.length>0)	
		if(recdescriptionEntity.length>0)
		{			
			var t=0;
			for(t=0; t<recdescriptionEntity.length; t++)
			{				
				if(recamountEntity[t].value=="")
				{
					recamountEntity[t].style.background="red";
					recamountEntity[t].value=0;
				}
				if(recamountEntity[t].value!="")
				{
					recamountEntity[t].style.background="white";
				}
				
				if(recdescriptionEntity[t].value=="")
				{
					recdescriptionEntity[t].style.background="red";
				}
				if(recdescriptionEntity[t].value!="")
				{
					recdescriptionEntity[t].style.background="white";
				}
				frecamount=parseFloat(frecamount)+parseFloat(recamountEntity[t].value);
				
			}		
			document.getElementById("finaltotalrecamount").value=(frecamount);
		}
		else
		{				
				ftrecamount=document.getElementById("rec_amount").value;
				document.getElementById("finaltotalrecamount").value=ftrecamount;
		}
}
/***********************************************************Total Recvoery amount calculation end*****************************************/