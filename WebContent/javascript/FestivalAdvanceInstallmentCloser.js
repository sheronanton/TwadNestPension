
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
function setInstallmentAmount()
{
	var loanamount=document.getElementById("loanamount").value;
	var noofinstallment=document.getElementById("totalinstallment").value;
	var oldtotalinstallment=document.getElementById("oldtotalinstallment").value;
	var installementamount=parseInt(loanamount)/parseInt(noofinstallment);
	//var remainingamount=document.getElementById("remainingamount").value;
	installmentover=document.getElementById("installmentOver").value;
	
		if((noofinstallment==oldtotalinstallment) || oldtotalinstallment==0 || oldtotalinstallment=="")
		{
			if((parseInt(loanamount)%parseInt(noofinstallment))==0)
			{
		  	document.getElementById("installmentamount").value=installementamount;
			}
		    else
			{
		    	
			alert("This amount is not divisible by zero");
			document.getElementById("installmentamount").value="";
			document.getElementById("totalinstallment").value="";
			//document.getElementById("completedindiv").style.display="none";
			document.getElementById("completedInstallment").value="";
			document.getElementById("amountRecovered").value="";
			}
		}
		else
		{
			
			installmentover=document.getElementById("installmentOver").value;
			noofinstallment=parseInt(noofinstallment)-parseInt(installmentover);
			if(oldtotalinstallment==noofinstallment)
			{
				var lamount=parseInt(remainingamount)/parseInt(noofinstallment);
				var installementamount=lamount;
			}
			else
			{
				var lamount=parseInt(loanamount)/parseInt(noofinstallment);
				var installementamount=lamount;
			}
			if((parseInt(lamount)%parseInt(noofinstallment))==0)
			{
			//document.getElementById("remaininginstallment").value=noofinstallment;
			document.getElementById("installmentamount").value=installementamount;
			}
			else
			{
			alert("This amount is not divisible by zero");
			document.getElementById("installmentamount").value="";
			document.getElementById("totalinstallment").value="";
			//document.getElementById("completedindiv").style.display="none";
			document.getElementById("completedInstallment").value="";
			document.getElementById("amountRecovered").value="";
			}
		}
	
		
	
}

function callServer(command)
{
 
      var url="";
      
      
      if(command=="Delete")
      {  
    	  ppono=document.getElementById("ppono").value; 
    	  
	  		    var r=confirm("Are you sure want to closure this record");
	  		  	if(r==false)
	  		  	{
	  		  		return false;
	  		  	}
      			url="DeleteInstallment.html?fai.ppono="+ppono;
      			var req=getTransport();
                req.open("GET",url,true);        
                req.onreadystatechange=function()
                {
                     processResponse(req);
                }   
                req.send(null);
      }
       
}  

function Fetchrecord(ppono)
{
	
	  url="FetchFestivalAdvanceInstallment.html?fai.ppono="+ppono;
 	  var req=getTransport();
     req.open("GET",url,true);        
     req.onreadystatechange=function()
     {
    	 processResponseChangeFetchFestivalAdvanceInstallment(req);
     }   
     req.send(null);
}




function processResponseChangeFetchFestivalAdvanceInstallment(req)
{   
  if(req.readyState==4)
  {
      if(req.status==200)
      {    
         var baseResponse=req.responseXML.getElementsByTagName("response")[0];
         var tagCommand=baseResponse.getElementsByTagName("command")[0];                    
         var command=tagCommand.firstChild.nodeValue;    
         var flag = baseResponse.getElementsByTagName('flag')[0].firstChild.nodeValue;
         var flag1 = baseResponse.getElementsByTagName('flag1')[0].firstChild.nodeValue;
         var len=baseResponse.getElementsByTagName("record").length;
        
         if(len==0)
        	 {
        	 alert("Not a valid PPO NO.");
        	 document.getElementById("plable").innerHTML="Pensioner Name";
        	 document.getElementById("ppono").value="";
        	 document.getElementById("employeename").value="";
        	 
        	 document.getElementById("festivalId").value=0;
             document.getElementById("loanamount").value="";
             document.getElementById("totalinstallment").value="";
       	  	 document.getElementById("installmentamount").value="";
       	  	 document.getElementById("sanctionDate").value="";
       	     document.getElementById("installmentStartMonth").value=0;
       	     document.getElementById("installmentStartYear").value="";
       	     document.getElementById("installmentEndMonth").value="";
       	  
       	     document.getElementById("installmentEnddMonth").value="";
   	         document.getElementById("installmentEndYear").value="";
   	         document.getElementById("remarks").value="";
   	         
   	         
   	         //document.getElementById("installmentOver").value=0;
   	         //document.getElementById("aRecovered").value=0;
   	         //document.getElementById("oldtotalinstallment").value=0;
   	         document.getElementById("completedInstallment").value="";
   	         document.getElementById("rInstallment").value="";
   	         document.getElementById("amountRecovered").value="";
   	         document.forms[0].faiDelete.disabled=true;
   	         
   	      
   	   
        	 }
         
        if(len>0)
         {  
        	
          if(command=="FetchFestivalAdvanceInstallmentDetails")
           {
        	 
        	  if(flag1=="true")
         	 	{
        		  
               
               document.getElementById("festivalId").value=0;
               document.getElementById("loanamount").value="";
               document.getElementById("totalinstallment").value="";
         	  	 document.getElementById("installmentamount").value="";
         	  	 document.getElementById("sanctionDate").value="";
         	  	 document.getElementById("installmentStartMonth").value=0;
         	  	 document.getElementById("installmentStartYear").value="";
         	  	 document.getElementById("installmentEndMonth").value="";
         	  	 document.getElementById("installmentEnddMonth").value="";
         	  	 document.getElementById("installmentEndYear").value="";
    	          	  
    	  
          
         	  	
         	  	 
          
         	  	 document.forms[0].faiDelete.disabled=true;
         	  	 
         	  	 document.getElementById("remarks").value="";
         	  	//document.getElementById("festivalId").disabled=false;
         	  	//document.getElementById("totalinstallment").disabled=false;
         	  	//document.getElementById("totalinstallment").style.background="#ffffff";
         	  	//document.getElementById("installmentStartMonth").disabled=false;
         	  	//document.getElementById("installmentStartYear").disabled=false;
         	  	//document.getElementById("completedindiv").style.display="none";
               
         	 	}
        	  
            if(flag=="true")
        	 {
            	
              //document.getElementById("employeename").value=nullcheck(req.responseXML.getElementsByTagName("pensionerName")[0].firstChild.nodeValue);
              employeename=nullcheck(req.responseXML.getElementsByTagName("pensionerName")[0].firstChild.nodeValue);
              employeeInitial=nullcheck(req.responseXML.getElementsByTagName("employeeInitial")[0].firstChild.nodeValue);
              pensionType=nullcheck(req.responseXML.getElementsByTagName("pensionType")[0].firstChild.nodeValue);
              if(employeeInitial!="")
           	   {
           	   employeeInitial=employeeInitial+".";
           	   }
              		document.getElementById("employeename").value=employeeInitial+employeename;
              		if(pensionType=="F")
           	   {
           	   document.getElementById("plable").innerHTML="Family Pensioner Name";
           	   }
              		else if(pensionType=="P")
            	   {
            	   document.getElementById("plable").innerHTML="Pensioner Name";
            	   }
              		else
           	   {
              			document.getElementById("plable").innerHTML="Pensioner Name";
           	   }
              document.getElementById("festivalId").value=req.responseXML.getElementsByTagName("festivalId")[0].firstChild.nodeValue;
              
              document.getElementById("loanamount").value=req.responseXML.getElementsByTagName("loanAmount")[0].firstChild.nodeValue;
              document.getElementById("totalinstallment").value=req.responseXML.getElementsByTagName("totalInstallment")[0].firstChild.nodeValue;
              
              
              document.getElementById("installmentamount").value=req.responseXML.getElementsByTagName("installmentAmount")[0].firstChild.nodeValue;
        	  document.getElementById("sanctionDate").value=nullcheck(req.responseXML.getElementsByTagName("sanctionDate")[0].firstChild.nodeValue);
        	  document.getElementById("installmentStartMonth").value=req.responseXML.getElementsByTagName("installmentStartMonth")[0].firstChild.nodeValue;
        	  
        	  document.getElementById("installmentStartYear").value=req.responseXML.getElementsByTagName("installmentStartYear")[0].firstChild.nodeValue;
        	  
        	  document.getElementById("installmentEndMonth").value=req.responseXML.getElementsByTagName("installmentEndMonth")[0].firstChild.nodeValue;
        	  endmonth=req.responseXML.getElementsByTagName("installmentEndMonth")[0].firstChild.nodeValue;
        	  if(endmonth==01 || endmonth==1)
        		{
        			disendmonth="Jan";
        		}
        		if(endmonth==02 || endmonth==2)
        		{
        			disendmonth="Feb";
        		}
        		if(endmonth==03 || endmonth==3)
        		{
        			disendmonth="Mar";
        		}
        		if(endmonth==04 || endmonth==4)
        		{
        			disendmonth="Apr";
        		}
        		if(endmonth==05 || endmonth==5)
        		{
        			disendmonth="May";
        		}
        		if(endmonth==06 || endmonth==6)
        		{
        			disendmonth="Jun";
        		}
        		if(endmonth==07 || endmonth==7)
        		{
        			disendmonth="Jul";
        		}
        		if(endmonth==08 || endmonth==8)
        		{
        			disendmonth="Aug";
        		}
        		if(endmonth==09 || endmonth==9)
        		{
        			disendmonth="Sep";
        		}
        		if(endmonth==10)
        		{
        			disendmonth="Oct";
        		}
        		if(endmonth==11)
        		{
        			disendmonth="Nov";
        		}
        		if(endmonth==12)
        		{
        			disendmonth="Dec";
        		}
        	  document.getElementById("installmentEnddMonth").value=disendmonth;
        	  document.getElementById("installmentEndYear").value=req.responseXML.getElementsByTagName("installmentEndYear")[0].firstChild.nodeValue;
        	          	  
        	  var totalinstallment=req.responseXML.getElementsByTagName("totalInstallment")[0].firstChild.nodeValue;
              var totalamount=req.responseXML.getElementsByTagName("loanAmount")[0].firstChild.nodeValue;
              
              
              //document.getElementById("completedindiv").style.display="inline";
              var amountRecovered=req.responseXML.getElementsByTagName("amountRecovered")[0].firstChild.nodeValue;
              var installmentOver=req.responseXML.getElementsByTagName("installmentOver")[0].firstChild.nodeValue;
              
            	  //document.getElementById("festivalId").disabled=true;
            	  //document.getElementById("totalinstallment").disabled=true;
            	  //document.getElementById("totalinstallment").style.background="#dddddf";
            	  //document.getElementById("installmentStartMonth").disabled=true;
            	  //document.getElementById("installmentStartYear").disabled=true;
            	  
            	  document.forms[0].faiDelete.disabled=true;
            	  
            	  //document.getElementById("sanctionDate").disabled=true;
            	  //document.getElementById("sanctionDate").style.background="#dddddf";
            	  //document.getElementById("cal-button-1").style.display="none";
            	  //document.getElementById("loanamount").disabled=true;
            	  //document.getElementById("loanamount").style.background="#dddddf";
            	  
            	  document.getElementById("completedInstallment").value=installmentOver;
            	  document.getElementById("rInstallment").value=totalinstallment-installmentOver;
                  document.getElementById("amountRecovered").value=amountRecovered;
                  //document.getElementById("completedInstallment").disabled=true;
            	  //document.getElementById("completedInstallment").style.background="#dddddf";
            	  //document.getElementById("rInstallment").disabled=true;
            	  //document.getElementById("rInstallment").style.background="#dddddf";
            	  //document.getElementById("amountRecovered").disabled=true;
            	  //document.getElementById("amountRecovered").style.background="#dddddf";
             
        	  document.forms[0].faiDelete.disabled=false;
        	  try
        	  {
        		  document.getElementById("remarks").value=req.responseXML.getElementsByTagName("remarks")[0].firstChild.nodeValue;
        	  }
        	  catch(e)
        	  {
        		  document.getElementById("remarks").value="";
        	  }
        	  
        	      
        	 }
            
            	if(flag=="false")
            	{
            		 alert("Not a valid PPO NO for festival closer.");
            		 
            		 document.getElementById("ppono").value="";
                     document.getElementById("employeename").value="";
                     document.getElementById("festivalId").value=0;
                     document.getElementById("loanamount").value="";
                     document.getElementById("totalinstallment").value="";
              	  	 document.getElementById("installmentamount").value="";
              	  	 document.getElementById("sanctionDate").value="";
              	  	 document.getElementById("installmentStartMonth").value=0;
              	  	 document.getElementById("installmentStartYear").value="";
              	  	 document.getElementById("installmentEndMonth").value="";
              	  	 document.getElementById("installmentEnddMonth").value="";
              	  	 document.getElementById("installmentEndYear").value="";
         	         	  
         	  
               
              	  	 document.forms[0].faiDelete.disabled=true;
              	  	 
              	  	 document.getElementById("remarks").value="";
              	  	
              	  	//document.getElementById("festivalId").disabled=false;
              	  	//document.getElementById("totalinstallment").disabled=false;
              	  	//document.getElementById("totalinstallment").style.background="#ffffff";
              	  	//document.getElementById("installmentStartMonth").disabled=false;
              	  	//document.getElementById("installmentStartYear").disabled=false;
              	  	//document.getElementById("completedindiv").style.display="none";
              	  	 document.getElementById("completedInstallment").value="";
        	         document.getElementById("rInstallment").value="";
        	         document.getElementById("amountRecovered").value="";
        	         
        	         document.forms[0].faiDelete.disabled=true;
            		 
            	}
            
            
           }
         }
      }
  }
}











function processResponse(req)
{   

  if(req.readyState==4)
  {
	
      if(req.status==200)
      {    
        
          var baseResponse=req.responseXML.getElementsByTagName("response")[0];
          var tagCommand=baseResponse.getElementsByTagName("command")[0];
          var command=tagCommand.firstChild.nodeValue;
          if(command=="Delete")
          { 
        	  
        	  alert("Festival advance close Successfully");
        	  //window.close();
        	  window.location.reload();
          }
          
          
      }
  }
}


function setEnddate()
{
	if((document.getElementById("installmentStartYear").value!="" || document.getElementById("installmentStartYear").value!=0) && (document.getElementById("installmentStartMonth").value!="" || document.getElementById("installmentStartMonth").value!=0) && (document.getElementById("totalinstallment").value!="" || document.getElementById("totalinstallment").value!=0))
	{
		
	var totalinstallment=document.getElementById("totalinstallment").value;
	var test=Math.round(parseInt(totalinstallment)/12);
	var td=new Date();
	var curmonth=td.getMonth()+parseInt(1);
	var curyear=td.getFullYear();
	var completeinstallment=0;
	var oldcompleteinstallment=0;
	var newcompleteinstallment=0;
	var remaininstall=0;
		if(curyear > document.getElementById("installmentStartYear").value)
		{
					
					oldcompleteinstallment=(parseInt(12)-(parseInt(document.getElementById("installmentStartMonth").value)-1));
					newcompleteinstallment=(parseInt(curmonth)-parseInt(1));
					completeinstallment=parseInt(oldcompleteinstallment)+parseInt(newcompleteinstallment);
					
		}
		if(curyear == document.getElementById("installmentStartYear").value)
		{
				if(curmonth > document.getElementById("installmentStartMonth").value)
				{
					completeinstallment=parseInt(curmonth)-parseInt(document.getElementById("installmentStartMonth").value);
					
				}
		
		}
		if(completeinstallment>=totalinstallment)
		{
			alert("Installment Already Over");
			//document.getElementById("completedindiv").style.display="none";
			document.getElementById("completedInstallment").value="";
			document.getElementById("faiAdd").disabled=true;
		}
		if(completeinstallment<totalinstallment)
		{
			
			//document.getElementById("completedindiv").style.display="inline";
			document.getElementById("completedInstallment").value=completeinstallment;
			document.getElementById("rInstallment").value=parseInt(totalinstallment)-parseInt(completeinstallment);
			document.getElementById("amountRecovered").value=completeinstallment*parseInt(document.getElementById("installmentamount").value);
			document.getElementById("faiAdd").disabled=false;
		}
	var endm=(parseInt(document.getElementById("installmentStartMonth").value)+parseInt(totalinstallment)-1);
	
	var endmonth=endm;
	if(endm>12)
	{
		endmonth=(parseInt(endm)-12);
		endyear=parseInt(document.getElementById("installmentStartYear").value)+1;
	}
	else
	{
		endyear=parseInt(document.getElementById("installmentStartYear").value);
	}
	
	if(endmonth==01 || endmonth==1)
	{
		disendmonth="Jan";
	}
	if(endmonth==02 || endmonth==2)
	{
		disendmonth="Feb";
	}
	if(endmonth==03 || endmonth==3)
	{
		disendmonth="Mar";
	}
	if(endmonth==04 || endmonth==4)
	{
		disendmonth="Apr";
	}
	if(endmonth==05 || endmonth==5)
	{
		disendmonth="May";
	}
	if(endmonth==06 || endmonth==6)
	{
		disendmonth="Jun";
	}
	if(endmonth==07 || endmonth==7)
	{
		disendmonth="Jul";
	}
	if(endmonth==08 || endmonth==8)
	{
		disendmonth="Aug";
	}
	if(endmonth==09 || endmonth==9)
	{
		disendmonth="Sep";
	}
	if(endmonth==10)
	{
		disendmonth="Oct";
	}
	if(endmonth==11)
	{
		disendmonth="Nov";
	}
	if(endmonth==12)
	{
		disendmonth="Dec";
	}
	
	document.getElementById("installmentEnddMonth").value=disendmonth;
	document.getElementById("installmentEndMonth").value=endmonth;
	document.getElementById("installmentEndYear").value=endyear;
	return isValidFromMonthYear();
	}
}


function checkdate(obj)
{       
    var ids=obj.id;   
    var datesSep=obj.value.split("/");
    
    var endyear=datesSep[2];
    	var totalinstallment=document.getElementById("totalinstallment").value;
    	var test=Math.round(parseInt(totalinstallment)/12);
    	var endm=(12-parseInt(datesSep[1]))+parseInt(totalinstallment);
    	var endmonth=endm;
    	//alert(endm);
    	if(endm>12)
    	{
    		endmonth=parseInt(endm)-12;
    		endyear=parseInt(datesSep[2])+1;
    	}
    	if(endmonth==01 || endmonth==1)
    	{
    		disendmonth="Jan";
    	}
    	if(endmonth==02 || endmonth==2)
    	{
    		disendmonth="Feb";
    	}
    	if(endmonth==03 || endmonth==3)
    	{
    		disendmonth="Mar";
    	}
    	if(endmonth==04 || endmonth==4)
    	{
    		disendmonth="Apr";
    	}
    	if(endmonth==05 || endmonth==5)
    	{
    		disendmonth="May";
    	}
    	if(endmonth==06 || endmonth==6)
    	{
    		disendmonth="Jun";
    	}
    	if(endmonth==07 || endmonth==7)
    	{
    		disendmonth="Jul";
    	}
    	if(endmonth==08 || endmonth==8)
    	{
    		disendmonth="Aug";
    	}
    	if(endmonth==09 || endmonth==9)
    	{
    		disendmonth="Sep";
    	}
    	if(endmonth==10)
    	{
    		disendmonth="Oct";
    	}
    	if(endmonth==11)
    	{
    		disendmonth="Nov";
    	}
    	if(endmonth==12)
    	{
    		disendmonth="Dec";
    	}
    	//document.getElementById("installmentenddate").value=endmonth+"-"+endyear;
    	document.getElementById("installmentEnddMonth").value=disendmonth;
    	document.getElementById("installmentEndMonth").value=endmonth;
    	document.getElementById("installmentEndYear").value=endyear;
    	
    	//return isValidFromMonthYear();
}

function setAmountRecovered()
{
	var totalinstallment=parseInt(document.getElementById("totalinstallment").value);
	var completedInstallment=parseInt(document.getElementById("completedInstallment").value);
	var rInstallment=document.getElementById("rInstallment").value;
	//var amountRecovered=getElementById("amountRecovered").value;
	if(totalinstallment!="" && completedInstallment!="" && document.getElementById("installmentamount").value!="")
	{
		if(completedInstallment>totalinstallment)
		{
			alert("Enter valid completed installments.");
			document.getElementById("completedInstallment").value=0;
			document.getElementById("amountRecovered").value=0;
			document.getElementById("rInstallment").value=0;
		}
		else if(completedInstallment==totalinstallment)
		{
			alert("Installment Already Over");
			amountRecovered=completedInstallment*parseInt(document.getElementById("installmentamount").value);
			document.getElementById("amountRecovered").value=amountRecovered;
			document.getElementById("rInstallment").value=totalinstallment-completedInstallment;
		}
		else
		{
			amountRecovered=completedInstallment*parseInt(document.getElementById("installmentamount").value);
			document.getElementById("amountRecovered").value=amountRecovered;
			document.getElementById("rInstallment").value=totalinstallment-completedInstallment;
		}
	}
	else if(totalinstallment!="" && rInstallment!="" && document.getElementById("installmentamount").value!="")
	{
		document.getElementById("rInstallment").value=totalinstallment-completedInstallment;
		rInstallment=document.getElementById("rInstallment").value;
		amountRecovered=parseInt(document.getElementById("loanamount").value)-(parseInt(rInstallment)*parseInt(document.getElementById("installmentamount").value));
		document.getElementById("amountRecovered").value=amountRecovered;
		document.getElementById("completedInstallment").value=totalinstallment-rInstallment;
	}
	
	
}


function isFutureDate(day,month,year)
{   
        month-=1;
        var dteDate;
        dteDate=new Date(year,month,day);
        return (dteDate.getTime()>new Date().getTime());   
}


function isFutureDate_new(month,year)
{   
        month-=1;
        var dteDate;
        //dteDate=new Date(year,month,day);
        dteDate=new Date(year,month);
        //alert(dteDate.getTime());
        //alert(new Date().getTime());
        return (dteDate.getTime()>new Date().getTime());   
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


function checkdate(obj)
{		
	
	var ids=obj.id;	
	var datesSep=obj.value.split("/");
	if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
			{
				alert("Choosen Date is Future !");
				obj.value="";							
			}
	if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
	{
		alert("Choosen Date is inValid !");
		obj.value="";
	}
}


function isValidDate(day,month,year)
{
        month-=1;
        var dteDate;
        dteDate=new Date(year,month,day);
        return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
}

/*******************************************Sart Validation for instalment from month and year*******************************************/
function isValidFromMonthYear()
{   
       
	  var sanctiondate=document.getElementById("sanctionDate").value;
	  var sanctiondatearray=sanctiondate.split("/");
	  var sanctionmonth=sanctiondatearray[1];
	  var sanctionyear=sanctiondatearray[2];
	  var validfrommonth=0;
	  var smonth=0;
	  var frommonth=document.getElementById("installmentStartMonth").value;
	  var fromyear=document.getElementById("installmentStartYear").value;
	  if(sanctiondate!="" && (frommonth!="" || frommonth!=0) && (fromyear!="" || fromyear!=0))
	{
	  if(sanctionmonth=='01')
	  {
		  smonth=1;
	  }
	  if(sanctionmonth=='02')
	  {
		  smonth=2;
	  }
	  if(sanctionmonth=='03')
	  {
		  smonth=3;
	  }
	  if(sanctionmonth=='04')
	  {
		  smonth=4;
	  }
	  if(sanctionmonth=='05')
	  {
		  smonth=5;
	  }
	  if(sanctionmonth=='06')
	  {
		  smonth=6;
	  }
	  if(sanctionmonth=='07')
	  {
		  smonth=7;
	  }
	  if(sanctionmonth=='08')
	  {
		  smonth=8;
	  }
	  if(sanctionmonth=='09')
	  {
		  smonth=9;
	  }
	  if(sanctionmonth=='10')
	  {
		  smonth=10;
	  }
	  if(sanctionmonth=='11')
	  {
		  smonth=11;
	  }
	  if(sanctionmonth=='12')
	  {
		  smonth=12;
	  }
	  
	  
	  if(frommonth=='1')
	  {
		  frommonth="01";
	  }
	  if(frommonth=='2')
	  {
		  frommonth="02";
	  }
	  if(frommonth=='3')
	  {
		  frommonth="03";
	  }
	  if(frommonth=='4')
	  {
		  frommonth="04";
	  }
	  if(frommonth=='5')
	  {
		  frommonth="05";
	  }
	  if(frommonth=='6')
	  {
		  frommonth="06";
	  }
	  if(frommonth=='7')
	  {
		  frommonth="07";
	  }
	  if(frommonth=='8')
	  {
		  frommonth="08";
	  }
	  if(frommonth=='9')
	  {
		  frommonth="09";
	  }
	  if(frommonth=='10')
	  {
		  frommonth="10";
	  }
	  if(frommonth=='11')
	  {
		  frommonth="11";
	  }
	  if(frommonth=='12')
	  {
		  frommonth="12";
	  }
	  validfrommonth=parseInt(smonth)+2;
        if(validfrommonth>12)
        {
        	validfromyear=parseInt(sanctionyear)+1;
        	check=validfrommonth%12;
        	validfrommonth=check;
        	
        }
        else
        {
        	validfromyear=sanctionyear;
        	validfrommonth=parseInt(smonth)+2;
        }
       var validstring="";
       var endvalcurmonth=12;
       
    	   endvalcurmonth=parseInt(smonth)+2;
       if(endvalcurmonth>=12)
       {
    	   endvalcurmonth=12
       }
       
        for(v=smonth; v<=endvalcurmonth; v++)
        {
        	if(v<=9)
        	{
        		validstring+="0"+v+":"+sanctionyear+"/";
        	}
        	else
        	{
        	validstring+=v+":"+sanctionyear+"/";
        	}
        }
       
        if(smonth>10)
        {
        	for(u=1; u<=validfrommonth; u++)
            {
        		if(u<=9)
        		{
        			validstring+="0"+u+":"+validfromyear+"/";
        		}
        		else
        		{
        			validstring+=u+":"+validfromyear+"/";
        		}
            }	
        }
        valstringarray=validstring.split("/");
        var fromvalid=0;
        for(l=0; l<(valstringarray.length)-1; l++)
        {
        	    
        	//alert(valstringarray[l]+"=="+frommonth+":"+fromyear)
        	if(valstringarray[l]==frommonth+":"+fromyear)
        	{
        		fromvalid=1;
        	}
        }
        if(fromvalid==0)
        {
        	alert("Please select valid from month and year.");
        	document.getElementById("installmentStartMonth").value=0;
        	return false;
      	    
        }
	}
        return true;
        
}
/*******************************************End Validation for instalment from month and year*******************************************/

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
