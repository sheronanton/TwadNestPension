var aid=1;
var year=0;
var month=0;
var	dayremainer=0;
var	daydivident=0;
var monthremainer=0;
var monthdivident=0;
var days=0;
var deptrid=0;
var tbodylength=0;
var tbody="";

function isSameDate(fromday,frommonth,fromyear,today,tomonth,toyear)
{   
        frommonth-=1;
        tomonth-=1;
        var fromdteDate;
        var todteDate;
        fromdteDate=new Date(fromyear,frommonth,fromday);
        todteDate=new Date(toyear,tomonth,today);
        //return (fromdteDate.getTime()<=todteDate.getTime());   
        return (fromdteDate.getTime()-todteDate.getTime());   
}


function checkotherdeptdate(str)
{

    //alert("val==="+str);
	var deptflag=document.getElementById("otherdeparmentserviceFlagYes").checked;
	var valflag=0;
	
	if(deptflag)
	{
		//alert("val==="+deptflag);
		
		try
		{
			//alert(document.getElementById("othdeptfromdate"+str).value);
			var othdeptfromdate=document.getElementById("othdeptfromdate"+str).value;
			var othdepttodate=document.getElementById("othdepttodate"+str).value;
			
		//alert("fromdate "+othdeptfromdate);
		//alert("todate "+othdepttodate);
		}
		catch(e)
		{
			alert(e.message);
		}
		//alert(othdeptfromdate);
		if(othdeptfromdate=="")
		{
			alert("Enter the Date of Joining");
			cleanotherdeptservice(str);
			valflag=1;	
			return false;
		}
		
		if(othdepttodate=="")
		{
			alert("Enter the Date of Relieving");
			cleanotherdeptservice(str);
			valflag=1;	
			return false;
		}

		var othdeptfrmdate=othdeptfromdate.split("/");
		var othdepttodate=othdepttodate.split("/");
		
		//alert("String value1=="+str);
		if(isFutureDate(othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2]))
		{
			alert("Choosen Date is Future !");
			cleanotherdeptservice(str);
			valflag=1;
			return false;
		}
		if(isFutureDate(othdepttodate[0],othdepttodate[1],othdepttodate[2]))
		{
			alert("Choosen Date is Future !");
			cleanotherdeptservice(str);
			valflag=1;	
			return false;
		}

		if(!isValidDate(othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2]))
		{
			alert("Choosen Date is inValid !");
			cleanotherdeptservice(str);
			valflag=1;
			return false;
		}

		if(!isValidDate(othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2]))
		{
			alert("Choosen Date is inValid !");
			cleanotherdeptservice(str);
			valflag=1;
			return false;
		}

		
		
		//alert("String value2==="+str);
		if(isGreaterDate(othdepttodate[0],othdepttodate[1],othdepttodate[2],othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2]))
		{
			alert("To Date is less than From date !");
			cleanotherdeptservice(str);
			valflag=1;	
			return false;
		}

		/*
		try
		{
		alert(isSameDate(othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2],othdepttodate[0],othdepttodate[1],othdepttodate[2]));
		}
		catch(e)
		{
			alert(e.message);
		}
		*/
		//alert("String value333==="+str);
		
		if(isSameDate(othdepttodate[0],othdepttodate[1],othdepttodate[2],othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2])<=0)
		{
			alert("Choosen Different Date !");
			cleanotherdeptservice(str);
			valflag=1;
			return false;
		}
	//	alert("String value"+str);
		if(str>1)
		{
			try
			{
			var newstr=str-1;
			var othchkdepttodate=document.getElementById("othdepttodate"+newstr).value;
			var othchkdepttodate=othchkdepttodate.split("/");
			//alert("Cheking date"+othchkdepttodate);
			//alert(isSameDate(othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2],othchkdepttodate[0],othchkdepttodate[1],othchkdepttodate[2]));
		if(isSameDate(othdeptfrmdate[0],othdeptfrmdate[1],othdeptfrmdate[2],othchkdepttodate[0],othchkdepttodate[1],othchkdepttodate[2])<=0)
		{
			alert("Choose Date Greater than To Date !");
			cleanotherdeptservice(str);
			valflag=1;
			return false;
		}
			}
			catch(e)
			{
				alert(e.message);
			}
		}
		try
		{
			if(valflag==0)
			{
				var tdate=new Date(othdepttodate[2],othdepttodate[1]-1,othdepttodate[0]);
				var fdate=new Date(othdeptfrmdate[2],othdeptfrmdate[1]-1,othdeptfrmdate[0]);
				var dated=datediff(tdate,fdate);
				//alert("day"+dated[0]+"month"+dated[1]+"year"+dated[2]);
				year=dated[0];
				month=dated[1];
				day=dated[2];

				//alert("year"+year+"month"+month+"day"+day);
                alert("otherdeptyear---->"+parseInt(year));
                alert("otherdeptmon---->"+parseInt(month));
                alert("otherdeptday---->"+parseInt(day));
				document.getElementById("otdepyear"+str).value=parseInt(year);
				document.getElementById("otdepmonth"+str).value=parseInt(month);
				document.getElementById("othdeptday"+str).value=parseInt(day);
				otherdepttotservice();
			}
		}
		catch(e)
		{
			//alert(e.message);
		}
		return true;
	}
	/*else
	{
		alert("Kindly Check Whether Other Department Service (Yes Or No)");
		cleanotherdeptservice();
		varflag=1;
	}*/


}

function cleanotherdeptservice(str)
{
	//alert("String value is"+str);
	document.getElementById("othdeptfromdate"+str).value="";
	document.getElementById("othdepttodate"+str).value="";
	document.getElementById("otdepyear"+str).value="";
	document.getElementById("otdepmonth"+str).value="";
	document.getElementById("othdeptday"+str).value="";
	document.getElementById("Departmentname"+str).value="";
	document.getElementById("Remarks"+str).value="";
   var mytextfocus=document.getElementById("othdeptfromdate"+str);
    mytextfocus.focus();

}

function otherdepttotservice()
{

	//alert("condition checking");

	var i=0;
	var tqs_year=0;
	var tqs_month=0;
	var tqs_day=0;
	var chkflag=0;
	/*tbodyvar=document.getElementById("othdeptser");
			tbodylength=tbodyvar.rows.length;*/
	//alert("id value"+rid);

	/*if(parseInt(tbodylength)==1)
		{
		document.getElementById("tototdepyear1").value=0;
		document.getElementById("tototdepmonth1").value=0;
		document.getElementById("totothdeptday1").value=0;
		}*/


	//alert("deptrid"+deptrid);
	try
	{
	
	for( i=1;i<=deptrid;i++)
	{
		
		
		
		try
		{
			alert(tqs_day);
			alert(tqs_month);
			alert(tqs_year);
			tqs_year=parseInt(tqs_year)+parseInt(document.getElementById("otdepyear"+i).value);
			tqs_month=parseInt(tqs_month)+parseInt(document.getElementById("otdepmonth"+i).value);
			tqs_day=parseInt(tqs_day)+parseInt(document.getElementById("othdeptday"+i).value);
			 alert(parseInt(tqs_year));
	            alert(parseInt(document.getElementById("otdepyear"+i).value));
	         
	            alert(parseInt(document.getElementById("otdepmonth"+i).value));
	            alert(tqs_day);

			if(tqs_day>29)
			{
				tqs_dayremainer=tqs_day%30;
				tqs_daydivident=tqs_day/30;

				tqs_month=parseInt(tqs_month)+parseInt(tqs_daydivident);
				tqs_day=tqs_dayremainer;
			}
			if(tqs_month>11)
			{
				tqs_monthremainer=tqs_month%12;
				tqs_monthdivident=tqs_month/12;

				tqs_year=parseInt(tqs_year)+parseInt(tqs_monthdivident);
				tqs_month=tqs_monthremainer;
			}	

			// alert("Year"+tqs_year+"month"+tqs_month+"Days"+tqs_day);
			
			if(isNaN(parseInt(tqs_year)))
				 {
				 tqs_year=0;
				 }
			 if(isNaN(parseInt(tqs_month)))
			 {
				 tqs_month=0;
			 }
			 
			 if(isNaN(parseInt(tqs_day)))
			 {
				 tqs_day=0;
			 }
			 
			 
			document.getElementById("tototdepyear1").value=parseInt(tqs_year);
			document.getElementById("tototdepmonth1").value=parseInt(tqs_month);
			document.getElementById("totothdeptday1").value=parseInt(tqs_day);
                 
  //alert("other service");

		}
		
		catch(e)
		{
			alert(e.message);
		}
		
		

	}
	}
	catch(e)
	{
		alert(e.message);
	}




}




function Addothdepartservice()
{
	
	

	tbodyvar=document.getElementById("othdeptser");
	if(deptrid>0&&!checkotherdeptdate(deptrid))
	{
		//alert("Inside checking");
		return false;
	}
	
	deptrid=deptrid+1;
	
		

	mycurrent_row=document.createElement("TR");	
	mycurrent_row.id=deptrid;
	//deptrid=mycurrent_row.id;

	cell1=document.createElement("TD");
	cell1.setAttribute("align","center");
	

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{
		
		hidden1=document.createElement("<input type='text' name='othdeptfromdate' id='othdeptfromdate"+deptrid+"'	onkeypress='javascript: return dtval(this,event);'   size='10' maxlength='10'  value=''  class='aetextbox' >");
		
		

	}
	else
	{       	  

		hidden1=document.createElement("input");
		hidden1.type="text";
		hidden1.size="10";
		hidden1.maxlength="10";
		hidden1.name="othdeptfromdate";
		hidden1.id="othdeptfromdate"+deptrid;
		hidden1.className="aetextbox";
		hidden1.setAttribute('onkeypress','dtval(this,event)');

		// hidden1.setAttribute('onblur','checkotherdeptdate(this.id)');
		//     hidden1.setAttribute('onkeypress','return dtval1("fromdate",deptrid,event);');
	}
	cell1.appendChild(hidden1);
	mycurrent_row.appendChild(cell1); 


	cell2=document.createElement("TD");
	cell2.setAttribute("align","center");


	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{
          
        	  
        	  hidden2=document.createElement("<input type='text' name='othdepttodate' id='othdepttodate"+deptrid+"'	onkeypress='javascript: return dtval(this,event);' onblur='javascript:checkotherdeptdate("+deptrid+");otherdepttotservice();'   size='10' maxlength='10'  value=''  class='aetextbox' >");
      		
		

	}
	else
	{
		hidden2=document.createElement("input");
		hidden2.type="text";
		hidden2.size="10";
		hidden2.maxlength="10";
		hidden2.name="othdepttodate";
		hidden2.setAttribute('onkeypress', 'dtval(this,event)');
		hidden2.id="othdepttodate"+deptrid;
		hidden2.onblur=function()
		{       			
			checkotherdeptdate(deptrid);
			otherdepttotservice();


		};
		hidden2.className="aetextbox";



	}

	cell2.appendChild(hidden2);
	mycurrent_row.appendChild(cell2); 


	cell3=document.createElement("TD");
	cell3.setAttribute("align","center");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{

		hidden3=document.createElement("<input type='text' name='otdepyear' id='otdepyear"+deptrid+"' size='4' maxlength='4'  readonly='true' style='background-color:#ececec' class='aetextboxmonth' >");        	   	

	}
	else
	{
		hidden3=document.createElement("input");
		hidden3.type="text";
		hidden3.size="4";
		hidden3.maxlength="4";
		hidden3.name="otdepyear";
		hidden3.id="otdepyear"+deptrid;
		hidden3.readOnly="true";
		hidden3.className="aetextboxmonth";
		hidden3.style.background="#ececec";


	}

	cell3.appendChild(hidden3);
	mycurrent_row.appendChild(cell3); 


	cell4=document.createElement("TD");
	cell4.setAttribute("align","center");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{

		hidden4=document.createElement("<input type='text'  name='otdepmonth' id='otdepmonth"+deptrid+"' size='4' maxlength='2' onkeypress='dtval(this,event)' readonly='true' style='background-color:#ececec' class='aetextboxmonth' >");        	   	

	}
	else
	{
		hidden4=document.createElement("input");
		hidden4.type="text";
		hidden4.size="4";
		hidden4.maxlength="2";
		hidden4.name="otdepmonth";
		hidden4.id="otdepmonth"+deptrid;
		hidden4.readOnly="true";
		hidden4.className="aetextboxmonth";
		hidden4.style.background="#ececec";

	}

	cell4.appendChild(hidden4);
	mycurrent_row.appendChild(cell4); 


	cell5=document.createElement("TD");
	cell5.setAttribute("align","center");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{

		hidden5=document.createElement("<input type='text' name='othdeptday' id='othdeptday"+deptrid+"' size='4' maxlength='2' readonly='true' style='background-color:#ececec' class='aetextboxmonth' >");        	   	

	}
	else
	{
		hidden5=document.createElement("input");
		hidden5.type="text";
		hidden5.size="4";
		hidden5.maxlength="2";
		hidden5.name="othdeptday";
		hidden5.id="othdeptday"+deptrid;
		hidden5.readOnly="true";
		hidden5.className="aetextboxmonth";
		hidden5.style.background="#ececec";

	}

	cell5.appendChild(hidden5);
	mycurrent_row.appendChild(cell5); 




	cell6=document.createElement("TD");
	cell6.setAttribute("align","center");


	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{

		hidden6=document.createElement("<input type='text'  name='Departmentname' id='Departmentname"+deptrid+"' size='10' class='recdescriptionbox' >");        	   	

	}
	else
	{
		hidden6=document.createElement("input");
		hidden6.type="text";
		hidden6.size="10";
		hidden6.name="Departmentname";
		hidden6.id="Departmentname"+deptrid;
		hidden6.className="recdescriptionbox";

	}

	cell6.appendChild(hidden6);
	mycurrent_row.appendChild(cell6); 


	cell7=document.createElement("TD");
	cell7.setAttribute("align","center");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{

		hidden7=document.createElement("<input type='text'  name='Remarks' id='Remarks"+deptrid+"' size='10'  class='recdescriptionbox' >");        	   	

	}
	else
	{
		hidden7=document.createElement("input");
		hidden7.type="text";
		hidden7.size="10";
		hidden7.name="Remarks";
		hidden7.id="Remarks"+deptrid;
		hidden7.className="recdescriptionbox";

	}

	cell7.appendChild(hidden7);
	mycurrent_row.appendChild(cell7); 


	cell8=document.createElement("TD");
	cell8.setAttribute("align","center");
	cell8.setAttribute("width","7%");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{  		 
		hidden8=document.createElement("<input type='button'  name='delete' id='delete' value='Delete'  onclick='deleteotherdpetrow("+deptrid+");'/>");			
	}
	else
	{		  
		hidden8=document.createElement("input");
		hidden8.type="button";
		hidden8.value="Delete";
		hidden8.name="delete";
		hidden8.id="delete";
		hidden8.setAttribute('onclick','deleteotherdpetrow('+deptrid+');');
		//hidden13.setAttribute('onclick','delrow(this);');		    
	}
	cell8.appendChild(hidden8);
	mycurrent_row.appendChild(cell8);


	tbodyvar.appendChild(mycurrent_row); 
	//deptrid++;
	//aid++;	
	


	return true;

}

function deleteotherdpetonload()
{	
	try
	{	

		try
		{
			// alert("checking delte function");
			for(i=1;i<=deptrid;i++)
			{
				tbody=document.getElementById(i).innerHTML="";
			}
			deptrid=0; 
			document.getElementById("othdeptsersubmit_addrow").disabled = true; 
			document.getElementById("tototdepyear1").value=0;
			document.getElementById("tototdepmonth1").value=0;
			document.getElementById("totothdeptday1").value=0;
		}
		catch(e)
		{

		}

	}
	catch(e)
	{
		alert(e.message);
	}

}



function deleteotherdpetrow(str)
{	

	// alert(str);
	var r=confirm("Are you sure want to delete this record.");
	if(r==true)
	{
		try
		{	

			try
			{
				// alert("deptrid value"+deptrid);

				if(deptrid==1)
				{
					deptrid=1;
					document.getElementById("tototdepyear1").value=0;
					document.getElementById("tototdepmonth1").value=0;
					document.getElementById("totothdeptday1").value=0;
				}

				tbody=document.getElementById(str).innerHTML="";
				deptrid--;


				otherdepttotservice();
			}
			catch(e)
			{

			}
		}
		catch(e)
		{
			alert(e.message);
		}

	}

}
