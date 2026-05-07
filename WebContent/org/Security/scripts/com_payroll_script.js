//***************************************** Code for Denied Right Click *****************************

history.forward();

var message="Right Click Permission Denied"; 

function clickIE() {if (document.all) {alert(message); return false;}}
function clickNS(e) {if 
(document.layers||(document.getElementById&&!document.all)) {
if (e.which==2||e.which==3) {alert(message);return false;}}}
if (document.layers) 
{document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;}
else{document.onmouseup=clickNS;document.oncontextmenu=clickIE;}

document.oncontextmenu=new Function("return false");

//*************************************** DATE SEPERATOR ********************************
function dateseparator(e,t)
 {
     var unicode=e.charCode? e.charCode : e.keyCode;
         //alert(unicode);
         //if(unicode !=8)
         
         if (unicode!=8 && unicode !=9 && unicode!=37 && unicode !=39 && unicode !=46  && unicode !=35 && unicode !=36 )
         {
             if(t.value.length==2 || t.value.length==5)
                 t.value=t.value + '/';
              if (unicode<48||unicode>57 ) 
                 return false ;
         }
        

 }
//*************************************** Check Date format Validation *************************************
function check_dateformat(field)
{
	
	var arr=new Array();
	
	var field_value=field.value;
	field_value=field_value.trim();

	if(field_value=="")
	{
		return false;
	}
	else
	{

		
	arr=field_value.split("/");
	
//	alert(arr.length);
	if(arr.length==3)
	{
		var ret=check_validdate(arr[0],arr[1],arr[2]);
		if(ret==false)
		{
			alert("Invalid Date.");
			field.value="";
			return false;
		}
		else
		{
			return true;
		}
	}
	else
	{
		alert("Date format Should be DD/MM/YYYY");
		field.value="";
		return false;
	}
	
	}
	
}

//**************************************** Check Valid Date *******************************************

function check_validdate(Day,Mn,Yr){
    var DateVal = Mn + "/" + Day + "/" + Yr;
    var dt = new Date(DateVal);
    
    if(parseInt(Yr)<=1900 || parseInt(Yr)>2100)
	{
		return false;
	}
	else if(dt.getDate()!=Day)
	{
       return(false);
        
	}
    else if(dt.getMonth()!=Mn-1)
    {        
        return(false);
       
    }
    else if(dt.getFullYear()!=Yr)
    {
    	return(false);
    }
    else
    {
    	return true;
    }

 }


//====================== TEXT COUNT FOR TEXTAREA LENGTH =============================

function TextCount( field, maxlimit,e ) {
	var unicode=e.charCode? e.charCode : e.keyCode;
    if(unicode==13)
     {
       try{t.blur();}catch(e){}
       return true;
     
     }
     if (unicode!=8 && unicode !=9  )
     {
	  if ( field.value.length >= maxlimit )
	  {
	    
	    return false;
	  }
	  else
		  return true;
     }
     else
    	 return true;
	 
	}

//=================================== Check From Date  ==============================

function CompareDate(fdate,tdate)
{

	var fromDate=document.getElementById(fdate).value;
	var toDate=document.getElementById(tdate).value;
	
	
	
	
	var ret=true;
	if(fromDate =="" || toDate == "")
	{
	}
	else
	{
		var fret=check_dateformat(document.getElementById(fdate));
		var tret=check_dateformat(document.getElementById(tdate));
		if(fret==true && tret==true)
		{
	var f_date =new Array();
	var t_date =new Array();
	
	f_date=fromDate.split("/");
	t_date=toDate.split("/");
	
	var fromYear=0,toYear=0,fromMonth=0,toMonth=0,fromDay=0,toDay=0;
	
	if(f_date[1]=='08' || f_date[1] =='8')
		f_date[1]="08";
	
	if(f_date[1]=='09' || f_date[1] =='9')
		f_date[1]="09";
	
	if(f_date[0]=='08' || f_date[0] =='8')
		f_date[0]="08";
	
	if(f_date[0]=='09' || f_date[0] =='9')
		f_date[0]="09";
	
	if(t_date[1]=='08' || t_date[1] =='8')
		t_date[1]="08";
	
	if(t_date[1]=='09' || t_date[1] =='9')
		t_date[1]="09";
	
	if(t_date[0]=='08' || t_date[0] =='8')
		t_date[0]="08";
	
	if(t_date[0]=='09' || t_date[0] =='9')
		t_date[0]="09";
	
	fromYear=parseInt(f_date[2]);
	fromMonth=parseInt(f_date[1]);
	fromDay=parseInt(f_date[0]);
	
	toYear=parseInt(t_date[2]);
	toMonth=parseInt(t_date[1]);
	toDay=parseInt(t_date[0]);
	
	if(fromYear>toYear)
	{
		ret= false;
	}
	else if(fromYear < toYear)
	{
		ret= true;
	}
	else if(fromMonth > toMonth)
	{
		ret= false;
		
	}
	else if(fromMonth < toMonth)
	{
		ret= true;
		
	}
	else if(fromDay < toDay)
	{
		ret= true;
		
	}
	else if(fromDay >= toDay)
	{
		ret= false;
		
	}
	
	}
	}
	
	if(ret==false)
	{
		alert("From Date Should be less than TO Date");
		document.getElementById(fdate).value="";
		document.getElementById(tdate).value="";
		return false;
	}
	else
	{
		return true;
	}
	
}

//===================================== Request ==============================================================
function getRequestAJAX()
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
//==================================== End Request =================================================================

function  getEmployeeDetails(empid,office_id,syear,smonth)
{
	var emp_detail=new Array();
	
	var brk_prd=new Array();
	   var url="../../../../common_payroll_servlet?command=getEmployeeDetails&employee_id="+empid+"&office_id="+office_id+"&syear="+syear+"&smonth="+smonth;

	   var req=getTransport();
 	    req.open("POST",url,true);
 	    req.onreadystatechange=function()
 	    {
 	    if(req.readyState==4)
 	   	{
 	   		if(req.status==200)
 	   		{		
// 	   			alert(req.responseText);
 	   			      var baseresponse=req.responseXML.getElementsByTagName("response")[0];
 	   	              var tagCommand=baseresponse.getElementsByTagName("command")[0];
 	   	              var command=tagCommand.firstChild.nodeValue;
 	   	              var flag=baseresponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
 	   	              if(flag=='success')
 	   	              {
 	   	            	
 	   	            	var empname=baseresponse.getElementsByTagName("EMPNAME")[0].firstChild.nodeValue;
 	   	            	var empdesign=baseresponse.getElementsByTagName("DESIGNATION")[0].firstChild.nodeValue;
 	   	            	var group_id=baseresponse.getElementsByTagName("PAY_BILL_GROUP_ID")[0].firstChild.nodeValue;
 	   	            	var group_name=baseresponse.getElementsByTagName("PAY_BILL_GROUP_DESC")[0].firstChild.nodeValue;
 	   	            	var statusid=baseresponse.getElementsByTagName("PAY_PROCESS_STATUS_ID")[0].firstChild.nodeValue;
 	   	            	var subgroup_id=baseresponse.getElementsByTagName("PAY_BILL_SUB_GROUP_ID")[0].firstChild.nodeValue;
 	   	            	var subgroup_name=baseresponse.getElementsByTagName("PAY_BILL_SUB_GROUP_DESC")[0].firstChild.nodeValue;
 	   	            	var proc_id=baseresponse.getElementsByTagName("PAY_PROCESS_ID")[0].firstChild.nodeValue;
 	   	            	var proc_name=baseresponse.getElementsByTagName("PAY_PROCESS_DESC")[0].firstChild.nodeValue;
 	   	            	   				    		emp_detail[0]="SUCCESS";
 	   				    		emp_detail[1]=empid;
 	   				    		emp_detail[2]=empname;
 	   				    		emp_detail[3]=empdesign;
 	   				    		emp_detail[4]=group_id;
 	   				    		emp_detail[5]=group_name;
 	   				    		emp_detail[6]=subgroup_id;
 	   				    		emp_detail[7]=subgroup_name;
 	   				    		emp_detail[8]=statusid;
 	   				    		emp_detail[9]=proc_id;
 	   				    		emp_detail[10]=proc_name;
 	   				    		
 	   				    try
 	   				    {
 	   				    var count=baseresponse.getElementsByTagName("count");
 	   				    	var j=0;
 	   			
	            		  for(var i=0;i<count.length;i++)
	            	         {
	            	            var slno=baseresponse.getElementsByTagName("REP_PERD_BREAKUP_SLNO")[i].firstChild.nodeValue;
	            	            var FROM_DATE=baseresponse.getElementsByTagName("FROM_DATE")[i].firstChild.nodeValue;
	            	            var TO_DATE=baseresponse.getElementsByTagName("TO_DATE")[i].firstChild.nodeValue;
	            	            var OFFICE_NAME=baseresponse.getElementsByTagName("OFFICE_NAME")[i].firstChild.nodeValue;
	            	            var NO_OF_DAYS=baseresponse.getElementsByTagName("NO_OF_DAYS")[i].firstChild.nodeValue;
	            	            	            	            
	            	            brk_prd[j]=count.length;
	            	            j=j+1;
	            	            brk_prd[j]=slno;
	            	            j=j+1;
	            	            brk_prd[j]=FROM_DATE;
	            	            j=j+1;
	            	            brk_prd[j]=TO_DATE;
	            	            j=j+1;
	            	            brk_prd[j]=OFFICE_NAME;
	            	            j=j+1;
	            	            brk_prd[j]=NO_OF_DAYS;
	            	            j=j+1;
	            	         }
 	   				    	
 	   				    	
 	   				    }
 	   				     catch(e)
 	   				     {
 	   				    	brk_prd[0]="FAIL";
 	   				     }
 	   	              }
 	   	              else
 	   	              {
 	   	            	emp_detail[0]="FAIL";
 	   	              }
 	   	            relieved_eployee(emp_detail,brk_prd);
 	   	         
 	   		}
 	   	}
 	    };
 	    req.send(null);
 	 
 	 
}
//======================================= End Get Employee Details ===================================================


//====================================== SQL Injection =====================================
function stripQuotes(strWords)
{
   
    strWords.value=strWords.value.replace( "'", "''");

}


function killChars(strWord)
{

var strWords=strWord.value;
var badChars=new Array("*", "|", "()", ";", "%", "/..", "../", "=", "\\", "/*", "*/", "%1", "%2", "%3", ".htm", ".html", "--", "select", "drop ", "insert ", "delete ", "xp_", "script", "alert","SELECT ","DROP ","DELETE ","UPDATE ", "update ");

var newChars=null;

// badChars = array("*", "|", "()", ";", "%", "/..", "../", "=", "\\", "/*", "*/", "%1", "%2", "%3", ".htm", ".html", "--", "select", "drop", "insert", "delete", "xp_", "script", "alert")

newChars = strWords;
 var len=badChars.length;
for  (var svr = 0;svr<len;svr++)
{

    newChars=newChars.replace(badChars[svr], "");

}

strWord.value = newChars;

}
//=========================================End SQL Injection ====================================
//=========================================Start Date Overlapping Check==========================
function Date_Overlapping(fDate,tDate,mDate)
{
	var ret=true;
	var fArr=new Array();
	var tArr=new Array();
	var mArr=new Array();	
	fArr=fDate.split("/");
	tArr=tDate.split("/");
	mArr=mDate.split("/");	
	var FDate = new Date(fArr[2]+"/"+fArr[1]+"/"+fArr[0]);
	var TDate = new Date(tArr[2]+"/"+tArr[1]+"/"+tArr[0]);
	var MDate = new Date(mArr[2]+"/"+mArr[1]+"/"+mArr[0]);

	if(MDate>FDate && MDate<TDate)
		ret=false;
	else if(mArr[0]==fArr[0] && mArr[1]==fArr[1] && mArr[2]==fArr[2] )
		ret=false;
	else if(mArr[0]==tArr[0] && mArr[1]==tArr[1] && mArr[2]==tArr[2] )
		ret=false;
	
	return ret;	
	
}
//=========================================End Date Overlapping Check============================

//=========================================Start Date Between From and To Date =======================
function Date_Between(fDate,tDate,mDate)
{
	var ret=true;
	var fArr=new Array();
	var tArr=new Array();
	var mArr=new Array();	
	fArr=fDate.split("/");
	tArr=tDate.split("/");
	mArr=mDate.split("/");	
	var FDate = new Date(fArr[2]+"/"+fArr[1]+"/"+fArr[0]);
	var TDate = new Date(tArr[2]+"/"+tArr[1]+"/"+tArr[0]);
	var MDate = new Date(mArr[2]+"/"+mArr[1]+"/"+mArr[0]);
	if(MDate<FDate || MDate>TDate)
		ret=false;
	return ret;
}
//=========================================End Date Between From and To Date =======================

//=========================================Start Date Should be less than given Date =======================
function Date_Less(fDate,tDate)
{
	var ret=true;
	var fArr=new Array();
	var tArr=new Array();
//	var mArr=new Array();	
	fArr=fDate.split("/");
	tArr=tDate.split("/");
//	mArr=mDate.split("/");	
	var FDate = new Date(fArr[2]+"/"+fArr[1]+"/"+fArr[0]);
	var TDate = new Date(tArr[2]+"/"+tArr[1]+"/"+tArr[0]);
//	var MDate = new Date(mArr[2]+"/"+mArr[1]+"/"+mArr[0]);
	if(FDate<TDate)
		ret=false;
	return ret;
}
//=========================================End  Date Should be less than given Date =======================

//=========================================Start  Date Should be Greater than given Date =======================

function Date_Greate(fDate,tDate)
{
	var ret=true;
	var fArr=new Array();
	var tArr=new Array();
//	var mArr=new Array();	
	fArr=fDate.split("/");
	tArr=tDate.split("/");
//	mArr=mDate.split("/");	
	var FDate = new Date(fArr[2]+"/"+fArr[1]+"/"+fArr[0]);
	var TDate = new Date(tArr[2]+"/"+tArr[1]+"/"+tArr[0]);
//	var MDate = new Date(mArr[2]+"/"+mArr[1]+"/"+mArr[0]);
	if(FDate>TDate)
		ret=false;
	return ret;
}
//=========================================End  Date Should be Greater than given Date =======================
//=========================================Start  Date Auto Complete =======================
function DateSeperator(e,t)
{
    var unicode=e.charCode? e.charCode : e.keyCode;
        //alert(unicode);
        //if(unicode !=8)
       
        if (unicode!=8 && unicode !=9 && unicode!=37 && unicode !=39 && unicode !=46  && unicode !=35 && unicode !=36 )
        {
            if(t.value.length==2 || t.value.length==5)
                t.value=t.value + '/';
             if (unicode<48||unicode>57 )
                return false
        }
      

}
//=========================================End  Date Auto Complete  =======================

//=========================================Start Check Future Date  =======================
function check_futureDate(id)
{
	var fieldDate=id.value;
	var CurrentDate=new Date();
	var fArr=new Array();
	fArr=fieldDate.split("/");
	var FDate = new Date(fArr[2]+"/"+fArr[1]+"/"+fArr[0]);
	if(FDate>CurrentDate)
		{
			alert("Date Must be less then Current Date");
			id.value="";
			return false;
		}
	else
		return true;
}