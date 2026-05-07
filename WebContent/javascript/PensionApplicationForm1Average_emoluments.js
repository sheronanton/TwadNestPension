var aid=1;
var temp=0;
var tempto=0;
var tempflagvar=0;
var temp_var_check=0;
var flaginsert=0;
var check_var=0;
var max_flag_val=0;
var flagmaxcheck;
var flagalloted=0;
var flaginside=0;
function GetXmlHttpObject()
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
}


/*************************************Add row in grid function start*******************************************/

function changeIt()
{
	
	  var basic_payname=document.getElementById("avg_pay_name_basic").value;
	  var basic_include=document.getElementById("avg_include_basic").value;
	  var basic_da=document.getElementById("avg_da_basic").value;
	  var basic_display_description=document.getElementById("avg_display_caption_basic").value;


	  var grade_payname=document.getElementById("avg_pay_name_grade").value;
	  var grade_include=document.getElementById("avg_include_grade").value;
	  var grade_da=document.getElementById("avg_da_grade").value;
	  var grade_display_description=document.getElementById("avg_display_caption_grade").value;

	  var special_payname=document.getElementById("avg_pay_name_special").value;
	  var special_include=document.getElementById("avg_include_special").value;
	  var special_da=document.getElementById("avg_da_special").value;
	  var special_display_description=document.getElementById("avg_display_caption_special").value;

	  var other1_payname=document.getElementById("avg_pay_name_other1").value;
	  var other1_include=document.getElementById("avg_include_other1").value;
	  var other1_da=document.getElementById("avg_da_other1").value;
	  var other1_display_description=document.getElementById("avg_display_caption_other1").value;

	  var other2_payname=document.getElementById("avg_pay_name_other2").value;
	  var other2_include=document.getElementById("avg_include_other2").value;
	  var other2_da=document.getElementById("avg_da_other2").value;
	  var other2_display_description=document.getElementById("avg_display_caption_other2").value;

	  var other3_payname=document.getElementById("avg_pay_name_other3").value;
	  var other3_include=document.getElementById("avg_include_other3").value;
	  var other3_da=document.getElementById("avg_da_other3").value;
	  var other3_display_description=document.getElementById("avg_display_caption_other3").value;
	
	tbodyvar=document.getElementById("test");
	//alert(tbodyvar.rows.length);
	aid=1;
	if(tbodyvar.rows.length>0)
	{
		aid=tbodyvar.rows.length+1;
	}
	mycurrent_row=document.createElement("TR");	
    mycurrent_row.id=aid;
    rid=mycurrent_row.id;

    cellcheck=document.createElement("TD");
    cellcheck.setAttribute("align","center");
    //cellcheck.setAttribute("width","3%");
         
    if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{
         	
		hiddencheck_maxcheck_value=document.createElement("<input type='hidden' name='maxcheck_value' id='maxcheck_value' value='N'>");
     	cellcheck.appendChild(hiddencheck_maxcheck_value);
     	mycurrent_row.appendChild(cellcheck); 
	}
    else
    {
    	hiddencheck_maxcheck_value=document.createElement("input");
    	hiddencheck_maxcheck_value.type="hidden";
    	hiddencheck_maxcheck_value.value="N";
    	hiddencheck_maxcheck_value.size="10";
    	hiddencheck_maxcheck_value.name="maxcheck_value";
    	hiddencheck_maxcheck_value.id="maxcheck_value";    
     }
     cellcheck.appendChild(hiddencheck_maxcheck_value);
     mycurrent_row.appendChild(cellcheck); 
          
          
          
    if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{        	
		//hiddencheck=document.createElement("<input type='checkbox' name='maxcheck' id='maxcheck' value='"+rid+"' />");
		//hiddencheck=document.createElement("<input type='checkbox' name='maxcheck' id='maxcheck' value='Y' />");
		hiddencheck=document.createElement("<input type='checkbox' name='maxcheck' id='maxcheck' value='"+rid+"' onclick='checkfun1(this.value)' />");
		
    	cellcheck.appendChild(hiddencheck);
    	mycurrent_row.appendChild(cellcheck); 
	}
	else
	{
     	hiddencheck=document.createElement("input");
     	hiddencheck.type="checkbox";
     	hiddencheck.value=rid;
     	//hiddencheck.value="Y";
     	hiddencheck.size="10";
     	hiddencheck.name="maxcheck";
     	hiddencheck.id="maxcheck";         
     	hiddencheck.setAttribute('onclick','checkfun1(this.value)');
    }
    cellcheck.appendChild(hiddencheck);
    mycurrent_row.appendChild(cellcheck); 
         
    
    cell1=document.createElement("TD");
    cell1.setAttribute("align","center");
          
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{
		pretoval=parseInt(rid)-1;			
    		  
		if(rid==1)
		{
    			  	
			nextval=document.AEForm.todate.value;
			var datesplit=nextval.split("/");
			var dateday=datesplit[0];
			var datemonth=datesplit[1]-1;
			var dateyear=datesplit[2];
			var d1 = new Date(dateyear,datemonth,dateday);
				
			d1.setDate(d1.getDate() + 1);
			var dismonth=parseInt(d1.getMonth())+1;
			nextval=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();		

    				
		}
		if(rid>1)
		{
    			
			nextval=document.AEForm.todate[pretoval].value;	    				
			var datesplit=nextval.split("/");
			var dateday=datesplit[0];
			var datemonth=datesplit[1]-1;
			var dateyear=datesplit[2];
			var d1 = new Date(dateyear,datemonth,dateday);				
			d1.setDate(d1.getDate() + 1);
			var dismonth=parseInt(d1.getMonth())+1;
			nextval=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();

			document.AEForm.fromdate[pretoval].readOnly=true;    				
    				
		}    		

		hidden1=document.createElement("<input type='text'  name='fromdate' id='fromdate' size='10' maxlength='10' style='text-align: left;background-color: #ececec;' value='"+nextval+"' readOnly='true' class='aetextbox' onchange='javascript:return checkdate1("+rid+");'>");
		
	}
  	else
  	{       	  
        
  			hidden1=document.createElement("input");
            hidden1.type="text";
            hidden1.size="10";
            hidden1.maxlength="10";
            hidden1.name="fromdate";
            hidden1.id="fromdate";
            hidden1.readOnly="true";
            hidden1.style.backgroundColor = '#ececec';
            hidden1.className="aetextbox";
            hidden1.setAttribute('onchange','checkdate1('+rid+');');
            //pretoval=parseInt(rid)-1;
            //alert(document.AEForm.fromdate.length);
            pretoval=parseInt(document.AEForm.fromdate.length)-1;		
            if(rid==1)
            {
      			  	
      			nextval=document.AEForm.todate.value;
      			
      			var datesplit=nextval.split("/");
      			var dateday=datesplit[0];
      			var datemonth=datesplit[1]-1;
      			var dateyear=datesplit[2];
      			var d1 = new Date(dateyear,datemonth,dateday);
				
      			d1.setDate(d1.getDate() + 1);
      			var dismonth=parseInt(d1.getMonth())+1;
      			nextval=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();
            }
            if(rid>1)
            {
      			  	
      			nextval=document.AEForm.todate[pretoval].value;
      			var datesplit=nextval.split("/");
      			var dateday=datesplit[0];
      			var datemonth=datesplit[1]-1;
      			var dateyear=datesplit[2];
      			var d1 = new Date(dateyear,datemonth,dateday);
				
      			d1.setDate(d1.getDate() + 1);
      			var dismonth=parseInt(d1.getMonth())+1;
      			nextval=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();

      			document.AEForm.fromdate[pretoval].readOnly=true;      				
            }
      		 
			hidden1.value=nextval;
            hidden1.setAttribute('onkeypress','return dtval1("fromdate",rid,event);');
	}
	cell1.appendChild(hidden1);
	mycurrent_row.appendChild(cell1); 

       
	cell2=document.createElement("TD");
	cell2.setAttribute("align","center");
		
           
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{

		hidden2=document.createElement("<input type='text'  name='todate' id='todate' size='10' maxlength='10' style='text-align: left' class='aetextbox' onkeypress='javascript:return dtval1(\"todate\","+rid+",event);' onblur='javascript:return checkdate1("+rid+");'>");        	   	

	}
	else
	{
    	hidden2=document.createElement("input");
    	hidden2.type="text";
    	hidden2.size="10";
		hidden2.maxlength="10";
    	hidden2.name="todate";
    	hidden2.id="todate";
    	hidden2.className="aetextbox";
    	hidden2.setAttribute('onkeypress','dtval1_mozilla("todate",'+rid+',event);');
    	hidden2.setAttribute('onblur','checkdate1('+rid+');');
	}
        	 
	cell2.appendChild(hidden2);
	mycurrent_row.appendChild(cell2); 




	cell10=document.createElement("TD");
	cell10.setAttribute("align","center");		
           
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{
		hidden10=document.createElement("<input type='text'  name='tmonth' id='tmonth' size='4' maxlength='2' style='text-align: left;background-color: #ececec;' readonly='true' class='aetextboxmonth'>");		
	}
	else
	{
    	   hidden10=document.createElement("input");
    	   hidden10.type="text";
    	   hidden10.size="4";
		   hidden10.maxlength="2";
    	   hidden10.name="tmonth";
		   hidden10.style.backgroundColor = '#ececec';
		   hidden10.readOnly=true;
    	   hidden10.id="tmonth";
    	   hidden10.className="aetextboxmonth";        	   
	}        

	cell10.appendChild(hidden10);
	mycurrent_row.appendChild(cell10);        





	cell11=document.createElement("TD");
	cell11.setAttribute("align","center");
		
           
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{
		hidden11=document.createElement("<input type='text'  name='tday' id='tday' size='4' maxlength='2' style='text-align: left;background-color: #ececec;' readonly='true' class='aetextboxmonth'>");		
	}
	else
	{
    	hidden11=document.createElement("input");
    	hidden11.type="text";
    	hidden11.size="4";
		hidden11.maxlength="2";
    	hidden11.name="tday";
		hidden11.style.backgroundColor = '#ececec';
		hidden11.readOnly=true;
    	hidden11.id="tday";
    	hidden11.className="aetextboxmonth";        	   
	}       

	cell11.appendChild(hidden11);
	mycurrent_row.appendChild(cell11); 


   
   	  

	cell3=document.createElement("TD");
	cell3.setAttribute("align","center");
	if(basic_include=="N")
	{
		cell3.style.display="none";
	}
	
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{           	 
		hidden3=document.createElement("<input type='text'  name='basic_pay' id='basic_pay' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("+rid+")'>");
    	hidden3.onkeypress= function() 
    	{        		
    		return numonly(event);
		};
	}
    else
    {       	     		 
     		  
    	hidden3=document.createElement("input");
    	hidden3.type="text";
    	hidden3.size="10";
		hidden3.style.textAlign="right";
    	hidden3.name="basic_pay";
    	hidden3.id="basic_pay";
    	hidden3.className="aetextbox";
        	
    	hidden3.setAttribute('onkeypress','return numonly(event)');
    	hidden3.setAttribute('onchange','calctotamount1('+rid+')');
    }
    cell3.appendChild(hidden3);
    mycurrent_row.appendChild(cell3);
          

	cell4=document.createElement("TD");
    cell4.setAttribute("align","center");
    if(grade_include=="N")
	{
    	cell4.style.display="none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{          
		
		//alert("if");
		/*hidden4=document.createElement("<input type='text'  name='grade_pay' id='grade_pay' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("+rid+")'>");
    	hidden4.onkeypress= function() 
    	{        		
    		return numonly(event);
		};		*/
		
		
		//cell4.style.display="none";
	}
    else
    {    		  
    	
    	
    	/*hidden4=document.createElement("input");
    	hidden4.type="text";
    	hidden4.size="10";
		hidden4.style.textAlign="right";
    	hidden4.name="grade_pay";
    	hidden4.id="grade_pay";
    	hidden4.className="aetextbox";
        	
    	hidden4.setAttribute('onkeypress','return numonly(event)');
		hidden4.setAttribute('onchange','calctotamount1('+rid+')');*/
    }
  //  cell4.appendChild(hidden4);
   // mycurrent_row.appendChild(cell4);


	

	cell5=document.createElement("TD");
	cell5.setAttribute("align","center");
	if(special_include=="N")
	{
		cell5.style.display="none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{         	 
		hidden5=document.createElement("<input type='text'  name='special_pay' id='special_pay' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("+rid+")'>");
    	hidden5.onkeypress= function() 
    	{        		
    		return numonly(event);
		};		 
	}
    else
    {    		  
    	hidden5=document.createElement("input");
    	hidden5.type="text";
    	hidden5.size="10";
		hidden5.style.textAlign="right";
    	hidden5.name="special_pay";
    	hidden5.id="special_pay";
    	hidden5.className="aetextbox";
        	
    	hidden5.setAttribute('onkeypress','return numonly(event)');
		hidden5.setAttribute('onchange','calctotamount1('+rid+')');
    }
    cell5.appendChild(hidden5);
    mycurrent_row.appendChild(cell5);




	cell6=document.createElement("TD");
	cell6.setAttribute("align","center");
	if(other1_include=="N")
	{
		cell6.style.display="none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{         	 
    	hidden6=document.createElement("<input type='text'  name='optionpay1' id='optionpay1' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("+rid+")'>");
    	hidden6.onkeypress= function() 
    	{        		
    		return numonly(event);
		};		
	}
    else
    {
      	hidden6=document.createElement("input");
    	hidden6.type="text";
    	hidden6.size="10";
		hidden6.style.textAlign="right";
    	hidden6.name="optionpay1";
    	hidden6.id="optionpay1";
    	hidden6.className="aetextbox";
        	
    	hidden6.setAttribute('onkeypress','return numonly(event)');
		hidden6.setAttribute('onchange','calctotamount1('+rid+')');
    }
	cell6.appendChild(hidden6);
	mycurrent_row.appendChild(cell6);




	cell7=document.createElement("TD");
	cell7.setAttribute("align","center");
	if(other2_include=="N")
	{
		cell7.style.display="none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{       
		hidden7=document.createElement("<input type='text'  name='optionpay2' id='optionpay2' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("+rid+")'>");
    	hidden7.onkeypress= function() 
    	{
        		
    		return numonly(event);
		};		
	}
    else
    {
       	hidden7=document.createElement("input");
    	hidden7.type="text";
    	hidden7.size="10";
		hidden7.style.textAlign="right";
    	hidden7.name="optionpay2";
    	hidden7.id="optionpay2";
    	hidden7.className="aetextbox";
        	
    	hidden7.setAttribute('onkeypress','return numonly(event)');
		hidden7.setAttribute('onchange','calctotamount1('+rid+')');
    }
	cell7.appendChild(hidden7);
	mycurrent_row.appendChild(cell7);





	cell8=document.createElement("TD");
	cell8.setAttribute("align","center");
	if(other3_include=="N")
	{
		cell8.style.display="none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{          	 
		hidden8=document.createElement("<input type='text'  name='optionpay3' id='optionpay3' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("+rid+")'>");
    	hidden8.onkeypress= function() 
    	{        		
    		return numonly(event);
		}; 		
	}
    else
    {      		  
    	hidden8=document.createElement("input");
    	hidden8.type="text";
    	hidden8.size="10";
		hidden8.style.textAlign="right";
    	hidden8.name="optionpay3";
    	hidden8.id="optionpay3";
    	hidden8.className="aetextbox";
        	
    	hidden8.setAttribute('onkeypress','return numonly(event)');
		hidden8.setAttribute('onchange','calctotamount1('+rid+')');
    }
  	cell8.appendChild(hidden8);
  	mycurrent_row.appendChild(cell8);




	cell9=document.createElement("TD");
    cell9.setAttribute("align","center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{ 	 
		hidden9=document.createElement("<input type='text'  name='amount' id='amount' size='10' style='text-align:right;background-color:#ececec;' class='aetextbox' readonly='true'>");
		hidden9.onkeypress= function() 
		{				
			return numonly(event);
		}; 
	}
	else
	{		  
		hidden9=document.createElement("input");
		hidden9.type="text";
		hidden9.size="10";
		hidden9.style.textAlign="right";
		hidden9.name="amount";
		hidden9.id="amount";
		hidden9.readonly=true;
		hidden9.style.backgroundColor = '#ececec';
		hidden9.className="aetextbox";
			
		hidden9.setAttribute('onkeypress','return numonly(event)');
	}
  	cell9.appendChild(hidden9);
  	mycurrent_row.appendChild(cell9);



	cell12=document.createElement("TD");
    cell12.setAttribute("align","center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{			 
		hidden12=document.createElement("<input type='text'  name='ppamount' id='ppamount' size='10' style='text-align:right;background-color:#ececec;' class='aetextbox' readonly='true'>");
	}
	else
	{			  
		hidden12=document.createElement("input");
		hidden12.type="text";
		hidden12.size="10";
		hidden12.style.textAlign="right";
		hidden12.name="ppamount";
		hidden12.id="ppamount";
		hidden12.readonly=true;
		hidden12.style.backgroundColor = '#ececec';
		hidden12.className="aetextbox";		    
	}
  	cell12.appendChild(hidden12);
  	mycurrent_row.appendChild(cell12);



	cell13=document.createElement("TD");
    cell13.setAttribute("align","center");
	cell13.setAttribute("width","7%");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
	{  		 
		hidden13=document.createElement("<input type='button'  name='delete' id='delete' value='Delete'  onclick='deleterow("+rid+");'/>");			
	}
	else
	{		  
		hidden13=document.createElement("input");
		hidden13.type="button";
		hidden13.value="Delete";
		hidden13.name="delete";
		hidden13.id="delete";
		hidden13.setAttribute('onclick','delrow('+rid+');');
		//hidden13.setAttribute('onclick','delrow(this);');		    
	}
  	cell13.appendChild(hidden13);
  	mycurrent_row.appendChild(cell13);
  
   
  	tbodyvar.appendChild(mycurrent_row);    
  	aid++;	
	
}

/****************************************************************Add row in grid function end*******************************************/


















/****************************************************************Date field formate setter function start**********************************/


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


	
	function dtval1_mozilla(tname,rid,e) {	
	var namefield=tname;
	d=document.AEForm.todate[rid];
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





	function dtval1(tname,rid,e) {	
	var namefield=tname;	
	d=window.event.srcElement;	
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

	

/************************************************************Date field formate setter function end**********************************/





/****************************************************************Validate for Future Date function start**********************************/


function checkdatefirst(obj)
{		
	if(document.AEForm.fromdate.length>0)
	{
		var ids=document.AEForm.fromdate[0];	
		var datesSep1=ids.value.split("/");
		var dateofjoin=document.getElementById("twadDateofJoin").value;
		var dojdatesSep=dateofjoin.split("/");
		
		/*if(isFutureDate(datesSep1[0],datesSep1[1],datesSep1[2]))
		{
			alert("Choosen Date is Future !");
			ids.value="";							
		}*/
	
		if(!isValidDate(datesSep1[0],datesSep1[1],datesSep1[2]))
		{
			alert("Choosen Date is inValid !");
			ids.value="";
		}
		
				

		if(isGreaterDate(datesSep1[0],datesSep1[1],datesSep1[2],dojdatesSep[0],dojdatesSep[1],dojdatesSep[2]))
		{
			alert("Enter Date is Greater than Date of Joining date !");
			document.AEForm.fromdate[0].value="";			
			return false;
		}
		
		if(document.AEForm.todate[0].value!="")	
		{
			document.AEForm.todate[0].style.background="white";
			var datesSep=document.AEForm.todate[0].value.split("/");
			var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
			
			//var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
			//var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
	
			if(isGreaterDate(datesSep[0],datesSep[1],datesSep[2],datesSep1[0],datesSep1[1],datesSep1[2]))
			{
				alert("Enter Date is Greater than From date !");
				document.AEForm.todate[0].value="";	
				document.AEForm.tmonth[0].value="";
				//return fasle
				return false;
			}

			
			var dated = datediff(tdate,fdate);
			var fromtotday=DaysInMonth(datesSep1[2], datesSep1[1]);
			var totmonth=0;
			var totday=dated[2];	
			if(dated[0]>0)
			{
				totmonth=dated[0]*12;
			}
			if(dated[1]>0)
			{
				totmonth=totmonth+dated[1];
			}
			if(totday>=29)
			{
				totmonth=totmonth+1;
				totday=0;
			}
			/*if(totday>0)
			{
				totday=totday+1;
			}*/
			if(totday>0)
			{
				if(datesSep[0]==31 && fromtotday==30 && datesSep1[0]!=1)
				{
					totday=totday;			
				}
				else
				{
					totday=totday+1;				
				}
			}
			if(dated[2]==0)
			{
				totday=1;
			}
	
			document.AEForm.tmonth[0].value=totmonth;
			document.AEForm.tday[0].value=totday;

			ffdate=document.AEForm.fromdate[0].value;
			ttdate=document.AEForm.todate[0].value;
			tday=totday;
			tmon=totmonth;
			totalamount=document.AEForm.amount[0].value;
			if((ffdate!="") && (ttdate!="") && (tday!="") && (totalamount!=""))
			{					
			document.AEForm.ppamount[0].value=calcppamount(ffdate,ttdate,tday,totalamount,tmon);
			}
		}
		else
		{
			document.AEForm.tmonth[0].value="";
			document.AEForm.tday[0].value="";	
		}


	}
	else
	{
		var ids=obj.id;	
		var datesSep1=obj.value.split("/");
		var dateofjoin=document.getElementById("twadDateofJoin").value;
		var dojdatesSep=dateofjoin.split("/");
		/*if(isFutureDate(datesSep1[0],datesSep1[1],datesSep1[2]))
		{
			alert("Choosen Date is Future !");
			obj.value="";							
		}*/
	
		if(!isValidDate(datesSep1[0],datesSep1[1],datesSep1[2]))
		{
			alert("Choosen Date is inValid !");
			obj.value="";
		}
		if(isGreaterDate(datesSep1[0],datesSep1[1],datesSep1[2],dojdatesSep[0],dojdatesSep[1],dojdatesSep[2]))
		{
			alert("Enter Date is Greater than Date of Joining date !");
			document.AEForm.fromdate.value="";			
			return false;
		}
		if(document.AEForm.todate.value!="")	
		{
			document.AEForm.todate.style.background="white";
			var datesSep=document.AEForm.todate.value.split("/");
			var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
			//var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
			//var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
			
			if(isGreaterDate(datesSep[0],datesSep[1],datesSep[2],datesSep1[0],datesSep1[1],datesSep1[2]))
			{
				alert("Enter Date is Greater than From date !");
				document.AEForm.todate.value="";	
				document.AEForm.tmonth.value="";
				//return fasle
				return false;
			}


			var dated = datediff(tdate,fdate);
			var fromtotday=DaysInMonth(datesSep1[2], datesSep1[1]);
			var totmonth=0;
			var totday=dated[2];	
			if(dated[0]>0)
			{
				totmonth=dated[0]*12;
			}
			if(dated[1]>0)
			{
				totmonth=totmonth+dated[1];
			}
			if(totday>=29)
			{
				totmonth=totmonth+1;
				totday=0;
			}
			/*if(totday>0)
			{
				totday=totday+1;
			}*/
			if(totday>0)
			{
				if(datesSep[0]==31 && fromtotday==30 && datesSep1[0]!=1)
				{
					totday=totday;			
				}
				else
				{
					totday=totday+1;				
				}
			}
			if(dated[2]==0)
			{
				totday=1;
			}
	
			document.AEForm.tmonth.value=totmonth;
			document.AEForm.tday.value=totday;

			ffdate=document.AEForm.fromdate.value;
			ttdate=document.AEForm.todate.value;
			tday=totday;
			tmon=totmonth;
			totalamount=document.AEForm.amount.value;
			if((ffdate!="") && (ttdate!="") && (tday!="") && (totalamount!=""))
			{					
			document.AEForm.ppamount.value=calcppamount(ffdate,ttdate,tday,totalamount,tmon);
			}
		}
		else
		{
			document.AEForm.tmonth.value="";
			document.AEForm.tday.value="";	
		}
	}
}


function mindate(fromday,frommonth,fromyear,today,tomonth,toyear)
{
	var minday="";
	var minmonth="";
	var minyear="";
	if(fromyear!=toyear)
	{
				if(fromyear<toyear)
				{
					minyear=fromyear;
					minmonth=frommonth;
					minday=fromday;
				}
				else
					{
					minyear=toyear;
					minmonth=tomonth;
					minday=today;
					
					}
				
	}
else if(frommonth!=tomonth)
	{
			if(frommonth<tomonth)
			{
			minyear=fromyear;
			minmonth=frommonth;
			minday=fromday;
		    }
			else
			{
			
			minyear=toyear;
			minmonth=tomonth;
			minday=today;
			
			
			}
	
	}
	
else 
{
	if (fromday<today)
		{
		minyear=fromyear;
		minmonth=frommonth;
		minday=fromday;
		
		}
	
	else
	{
	
	minyear=toyear;
	minmonth=tomonth;
	minday=today;
	
	
	}
	
}
	
	return[minday,minmonth,minyear];

}

function checkdate(obj)
{		
	
	if(document.AEForm.fromdate.length>0)
	{
		checkdate1(0);
	}
	else
	{
		var ids=obj.id;	
		var fromobj=document.AEForm.fromdate;
		var datesSep=obj.value.split("/");
		var datesSep1=fromobj.value.split("/");
		var valflag=0;
		
		if(isGreaterDate(datesSep[0],datesSep[1],datesSep[2],datesSep1[0],datesSep1[1],datesSep1[2]))
		{
			alert("Enter Date is Greater than From date !");
			obj.value="";	
			document.AEForm.tmonth.value="";
			valflag=1;						
		}
		if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
		{
			alert("Choosen Date is inValid !");
			obj.value="";
			document.AEForm.tmonth.value="";
			valflag=1;
		}
		if(valflag==0)
		{
			var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
			//var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
			//var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
			var dated=datediff(tdate,fdate);
			var fromtotday=DaysInMonth(datesSep1[2], datesSep1[1]);
			var findday=DaysInMonth(datesSep[2], datesSep[1]);			
			var totmonth=0;
			var totday=dated[2];
			if(dated[0]>0)
			{
				totmonth=dated[0]*12;
			}
			if(dated[1]>0)
			{
				totmonth=totmonth+dated[1];
			}			
			/*if(totday>0)
			{
				totday=totday+1;
			}*/
			if(totday>0)
			{
				if(datesSep[0]==31 && fromtotday==30 && datesSep1[0]!=1)
				{
					totday=totday;			
				}
				else
				{
					totday=totday+1;				
				}
			}
			if(dated[2]==0)
			{
				totday=1;
			}			
			if(dated[2]>=29)
			{
				totday=0;
				totmonth=totmonth+1;
			}
			else if(parseInt(findday)==parseInt(totday))
			{
				totday=0;
				totmonth=totmonth+1;
			}
	
			document.AEForm.tmonth.value=totmonth;
			document.AEForm.tday.value=totday;			
			
			
			ffdate=fromobj.value;
			ttdate=obj.value;
			tday=totday;
			tmon=totmonth;
			totalamount=document.AEForm.amount.value;
			if((ffdate!="") && (ttdate!="") && (tday!="") && (totalamount!=""))
			{
				document.AEForm.ppamount.value=calcppamount(ffdate,ttdate,tday,totalamount,tmon);
			}

			
		}
		else
		{
			document.AEForm.tmonth.value="";
			document.AEForm.tday.value="";	
		}
	}
}


function checkdate1(did,e)
{		
	
	var ids=document.AEForm.todate[did];	
	var obj=document.AEForm.todate[did];

	var fromobj=document.AEForm.fromdate[did];
	
	var datesSep=obj.value.split("/");

	var datesSep1=fromobj.value.split("/");
	var valflag=0;	
	if(isGreaterDate(datesSep[0],datesSep[1],datesSep[2],datesSep1[0],datesSep1[1],datesSep1[2]))
	{
		alert("Enter Date is Greater than From date !");
		obj.value="";
		document.AEForm.tmonth[did].value="";
		valflag=1;							
	}
	if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
	{
		alert("Choosen Date is inValid !");
		obj.value="";
		document.AEForm.tmonth[did].value="";
		valflag=1;
		
	}
	
	if(valflag==0)	
	{
		document.AEForm.todate[did].style.background="white";
		var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
		//var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
		//var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
	
		var dated = datediff(tdate,fdate);
	
		var fromtotday=DaysInMonth(datesSep1[2], datesSep1[1]);
		var findday=DaysInMonth(datesSep[2], datesSep[1]);			
		
		var totmonth=0;
		var totday=dated[2];	
		if(dated[0]>0)
		{
			totmonth=dated[0]*12;
		}
		if(dated[1]>0)
		{
			totmonth=totmonth+dated[1];
		}	
		/*if(totday>0)
		{
			totday=totday+1;
		}*/
		if(totday>0)
		{
			if(datesSep[0]==31 && fromtotday==30 && datesSep1[0]!=1)
			{
				totday=totday;			
			}
			else
			{
				totday=totday+1;				
			}
		}
		if(dated[2]==0)
		{
			totday=1;
		}
		if(dated[2]>=29)
		{
			totday=0;
			totmonth=totmonth+1;
		}
		else if(parseInt(findday)==parseInt(totday))
		{
			totday=0;
			totmonth=totmonth+1;
		}
		
		document.AEForm.tmonth[did].value=totmonth;
		document.AEForm.tday[did].value=totday;
		
			
		ffdate=fromobj.value;
		ttdate=obj.value;
		tday=totday;
		tmon=totmonth;
		totalamount=document.AEForm.amount[did].value;
		if((ffdate!="") && (ttdate!="") && (tday!="") && (totalamount!=""))
		{	
			document.AEForm.ppamount[did].value=calcppamount(ffdate,ttdate,tday,totalamount,tmon);
		}

	}
	else
	{
		document.AEForm.tmonth[did].value="";
		document.AEForm.tday[did].value="";	
	}
	
	var reccount=document.AEForm.tmonth.length;
	
	var nextrowcount=parseInt(did)+1;
	var currowcount=did;	
	if(nextrowcount<reccount)
	{
			tval=document.AEForm.todate[did].value;	    				
			var datesplit=tval.split("/");
			var dateday=datesplit[0];
			var datemonth=datesplit[1]-1;
			var dateyear=datesplit[2];
			var d1 = new Date(dateyear,datemonth,dateday);				
			d1.setDate(d1.getDate() + 1);
			var dismonth=parseInt(d1.getMonth())+1;
			tval=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();
    		document.AEForm.fromdate[nextrowcount].value=tval;
	}
	
	
}


function isFutureDate(day,month,year)
{   
        month-=1;
        var dteDate;
        dteDate=new Date(year,month,day);
        return (dteDate.getTime()>new Date().getTime());   
}

function isGreaterDate(fromday,frommonth,fromyear,today,tomonth,toyear)
{   
        frommonth-=1;
        tomonth-=1;
        var fromdteDate;
        var todteDate;
        fromdteDate=new Date(fromyear,frommonth,fromday);
        todteDate=new Date(toyear,tomonth,today);
        //return (fromdteDate.getTime()<=todteDate.getTime());   
        return (fromdteDate.getTime()<todteDate.getTime());   
}


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


function isValidDate(day,month,year)
{
        month-=1;
        var dteDate;
        dteDate=new Date(year,month,day);
        return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
}



function datediff(date1, date2) {
	
    var y1 = date1.getFullYear();
    m1 = date1.getMonth();
    d1 = date1.getDate();
    y2 = date2.getFullYear();
    m2 = date2.getMonth();
    d2 = date2.getDate();

    if (d1 < d2) {
        m1--;
        d1 += DaysInMonth(y2, m2);
	
    }
    if (m1 < m2) {
        y1--;
        m1 += 12;
    }
    
    
    return [y1 - y2, m1 - m2, d1 - d2];


}


function DaysInMonth(Y, M) {
    with (new Date(Y, M, 1, 12)) {
        setDate(0);
        return getDate();
    }
}

/*************************************************************Validate for Future Date function end**********************************/






/*****************************************************************Calculation for Total amount start**********************************/

function calctotamount()
{
	tbodyvar=document.getElementById("test");
	if(tbodyvar.rows.length>0)	
	{
		calctotamount1(0);
	}
	else
	{
		try
		{
		var totalamount=0;
		var basicpay=0;
		var gradepay=0;
		var specialpay=0;
		var optionpay1=0;
		var optionpay2=0;
		var optionpay3=0;
	
		if(document.AEForm.basic_pay.value!="")
		{
			basicpay=document.AEForm.basic_pay.value;
		}
		if(document.AEForm.grade_pay.value!="")
		{
			gradepay=document.AEForm.grade_pay.value;
		}
		if(document.AEForm.special_pay.value!="")
		{
			specialpay=document.AEForm.special_pay.value;
		}
		if(document.AEForm.optionpay1.value!="")
		{
			optionpay1=document.AEForm.optionpay1.value;
		}
		if(document.AEForm.optionpay2.value!="")
		{
			optionpay2=document.AEForm.optionpay2.value;
		}
		if(document.AEForm.optionpay3.value!="")
		{
			optionpay3=document.AEForm.optionpay3.value;
		}
		//totalamount=parseInt(basicpay)+parseInt(gradepay)+parseInt(specialpay)+parseInt(optionpay1)+parseInt(optionpay2)+parseInt(optionpay3);
		totalamount=parseInt(basicpay)+parseInt(specialpay)+parseInt(optionpay1)+parseInt(optionpay2)+parseInt(optionpay3);
		document.AEForm.amount.value=totalamount;
	



		fdate=document.AEForm.fromdate.value;
		tdate=document.AEForm.todate.value;
		tday=document.AEForm.tday.value;
		tmon=document.AEForm.tmonth.value;
		
		document.AEForm.ppamount.value=calcppamount(fdate,tdate,tday,totalamount,tmon);
		
		refresh_totalppamount();
		
		}
		catch(e)
		{
		
		}

	}
	
	
}





function calctotamount1(cid)
{
	var totalamount=0;
	var basicpay=0;
	var gradepay=0;
	var specialpay=0;
	var optionpay1=0;
	var optionpay2=0;
	var optionpay3=0;
	try
	{
	if(document.AEForm.basic_pay[cid].value!="")
	{
		basicpay=document.AEForm.basic_pay[cid].value;
		document.AEForm.basic_pay[cid].style.background="white";
	}
	/*if(document.AEForm.grade_pay[cid].value!="")
	{
		gradepay=document.AEForm.grade_pay[cid].value;
		document.AEForm.grade_pay[cid].style.background="white";
	}*/
	if(document.AEForm.special_pay[cid].value!="")
	{
		specialpay=document.AEForm.special_pay[cid].value;
	}
	if(document.AEForm.optionpay1[cid].value!="")
	{
		optionpay1=document.AEForm.optionpay1[cid].value;
	}
	if(document.AEForm.optionpay2[cid].value!="")
	{
		optionpay2=document.AEForm.optionpay2[cid].value;
	}
	if(document.AEForm.optionpay3[cid].value!="")
	{
		optionpay3=document.AEForm.optionpay3[cid].value;
	}
	//totalamount=parseInt(basicpay)+parseInt(gradepay)+parseInt(specialpay)+parseInt(optionpay1)+parseInt(optionpay2)+parseInt(optionpay3);
	totalamount=parseInt(basicpay)+parseInt(specialpay)+parseInt(optionpay1)+parseInt(optionpay2)+parseInt(optionpay3);
	document.AEForm.amount[cid].value=totalamount;



	

	fdate=document.AEForm.fromdate[cid].value;
	tdate=document.AEForm.todate[cid].value;
	tday=document.AEForm.tday[cid].value;
	tmon=document.AEForm.tmonth[cid].value;
	document.AEForm.ppamount[cid].value=calcppamount(fdate,tdate,tday,totalamount,tmon);

	var fppamount=calcppamount(fdate,tdate,tday,totalamount,tmon);
	
	refresh_totalppamount();

	}
	catch(e)
	{
		
	}
	
}



/*******************************************Calculation for Total amount end**********************************/


/*******************************************Calculation for PP amount start**********************************/



function calcppamount(fdate,tdate,tday,totalamount,tmon)
{
	try
	{	

	var todateid=tdate;
	var fromdateid=fdate;
	
	
	var tdatesSep=todateid.split("/");

	var fdatesSep=fromdateid.split("/");

	var fdivider=DaysInMonth(fdatesSep[2], fdatesSep[1]);
	var tdivider=DaysInMonth(tdatesSep[2], tdatesSep[1]);
	var ppamount=0;	
	if((fdatesSep[2]==tdatesSep[2]) && (fdatesSep[1]==tdatesSep[1]))
	{	
		
		if(tday>0)
		{
			ppamount=totalamount*(parseInt(tday)/fdivider);
		}
		else
		{
			ppamount=totalamount*(parseInt(fdivider)/fdivider);
		}
		
	}
	if((fdatesSep[2]==tdatesSep[2]) && (fdatesSep[1]==tdatesSep[1]))
	{
		
		if((parseInt(fdatesSep[0])==1)&&(parseInt(fdatesSep[0])==tdivider))
		{
			ppamount=totalamount*1;
			
		}
	}
	if((fdatesSep[2]==tdatesSep[2]) && (fdatesSep[1]!=tdatesSep[1]))
	{
		
		var ystart=fdatesSep[2];
		var yend=tdatesSep[2];
		
		//var mstart=fdatesSep[1];
		
		//var mend=tdatesSep[1];
		
		var mstart=monthset(fdatesSep[1]);
		var mend=monthset(tdatesSep[1]);
		var rmcount=0;
		var rfdays=0;
		var rtdays=0;
		var rmppamount=0;
		var rfppamount=0;
		var rtppamount=0;
		var m=0;
		/*alert(mstart);
		alert(mend);*/
			for(m=mstart; m<=mend; m++)
			{
				
				
				if((m==mstart))
				{
					cdays=(fdivider-fdatesSep[0])+1;
					if(DaysInMonth(fdatesSep[2], fdatesSep[1])==cdays)
					{
							rmcount++;
					}
						
				}
				else if((m==mend))
				{
					ddays=tdatesSep[0];
					if(DaysInMonth(tdatesSep[2], tdatesSep[1])==ddays)
					{
						rmcount++;
					}
						
				}
				else
				{
					rmcount++;
				}
				
				
			}
			
		tbodyvar=document.getElementById("test");
		if((tbodyvar.rows.length<=0) && parseInt(tmon)>=10)		
		{
			rmppamount=10*totalamount;
		}
		else
		{
			if(parseInt(fdatesSep[0])!=1)
			{
				rfdays=(fdivider-fdatesSep[0])+1;
			}
			if(parseInt(tdatesSep[0])!=tdivider)
			{
				rtdays=tdatesSep[0];
			}
			
			rmppamount=rmcount*totalamount;	
			if(rfdays>0)
			{
				rfppamount=(rfdays/fdivider)*totalamount;
			}
			if(rtdays>0)
			{
				rtppamount=(rtdays/tdivider)*totalamount;
			}
			
		}
		
		ppamount=rmppamount+rfppamount+rtppamount;
		//alert(rmppamount);
		
	}	
	if((fdatesSep[2]!=tdatesSep[2]))
	{
		var ystart=fdatesSep[2];
		var yend=tdatesSep[2];
		//var mstart=fdatesSep[1];
		
		var mstart=monthset(fdatesSep[1]);
		
		
		var mend=12;
		var rmcount=0;
		var rfdays=0;
		var rtdays=0;
		var rmppamount=0;
		var rfppamount=0;
		var rtppamount=0;
		
		for(y=ystart; y<=yend; y++)
		{
			if(y==ystart)
			{
				mstart=monthset(fdatesSep[1]);
			}
			if(y==yend)
			{
				mend=monthset(tdatesSep[1]);
			}			
			for(m=mstart; m<=mend; m++)
			{
				

					if((m==mstart) && (y==ystart))
					{
						cdays=(fdivider-fdatesSep[0])+1;
						if(DaysInMonth(fdatesSep[2], fdatesSep[1])==cdays)
						{
							rmcount++;
						}
						
					}
					else if((m==mend) && (y==yend))
					{
						ddays=tdatesSep[0];
						if(DaysInMonth(tdatesSep[2], tdatesSep[1])==ddays)
						{
							rmcount++;
						}
						
					}
					else
					{
						rmcount++;
					}
				
				
				
				
				
			}
			mstart=1;
			
			
		}

		tbodyvar=document.getElementById("test");
		//alert(rmcount);
		if((tbodyvar.rows.length<=0) && parseInt(tmon)>=10)		
		{
			rmppamount=10*totalamount;
			
		}
		else
		{
			
			if(parseInt(fdatesSep[0])!=1)
			{
				rfdays=(fdivider-fdatesSep[0])+1;
			}
			if(parseInt(tdatesSep[0])!=tdivider)
			{
				rtdays=tdatesSep[0];
			}
		
		
			rmppamount=rmcount*totalamount;
			if(rfdays>0)
			{
				rfppamount=(rfdays/fdivider)*totalamount;
			}
			if(rtdays>0)
			{
				rtppamount=(rtdays/tdivider)*totalamount;
			}
		}
		
		ppamount=rmppamount+rfppamount+rtppamount;
		
	}
	
	
	return ppamount.toFixed(2);
	

	}
	catch(e)
	{
		//alert(e);
	}

}



/*
function calcppamount(fdate,tdate,tday,totalamount,tmon)
{
	try
	{	

	var todateid=tdate;
	var fromdateid=fdate;
	
	
	var tdatesSep=todateid.split("/");

	var fdatesSep=fromdateid.split("/");

	var fdivider=DaysInMonth(fdatesSep[2], fdatesSep[1]);
	var tdivider=DaysInMonth(tdatesSep[2], tdatesSep[1]);
	var ppamount=0;
			
	if((fdatesSep[2]==tdatesSep[2]) && (parseInt(fdatesSep[1])==parseInt(tdatesSep[1])))
	{	
		
		if(tday>0)
		{
			ppamount=totalamount*(parseInt(tday)/fdivider);
		}
		else
		{
			ppamount=totalamount*(parseInt(fdivider)/fdivider);
		}
		
	}
	if((fdatesSep[2]==tdatesSep[2]) && (parseInt(fdatesSep[1])==parseInt(tdatesSep[1])))
	{
		
		if((parseInt(fdatesSep[0])==1)&&(parseInt(fdatesSep[0])==tdivider))
		{
			ppamount=totalamount*1;	
		}
	}
	if((fdatesSep[2]==tdatesSep[2]) && (parseInt(fdatesSep[1])!=parseInt(tdatesSep[1])))
	{
		
		var ystart=fdatesSep[2];
		var yend=tdatesSep[2];
		
		//var mstart=fdatesSep[1];
		
		//var mend=tdatesSep[1];
		
		var mstart=monthset(fdatesSep[1]);
		var mend=monthset(tdatesSep[1]);
		var rmcount=0;
		var rfdays=0;
		var rtdays=0;
		var rmppamount=0;
		var rfppamount=0;
		var rtppamount=0;
		var m=0;
		
			for(m=mstart; m<=mend; m++)
			{
				
				
				if((m==mstart))
				{
					cdays=(fdivider-fdatesSep[0])+1;
					if(DaysInMonth(fdatesSep[2], fdatesSep[1])==cdays)
					{
							rmcount++;
					}
						
				}
				else if((m==mend))
				{
					ddays=tdatesSep[0];
					if(DaysInMonth(tdatesSep[2], tdatesSep[1])==ddays)
					{
						rmcount++;
					}
						
				}
				else
				{
					rmcount++;
				}
				
				
			}
			
		tbodyvar=document.getElementById("test");
		if((tbodyvar.rows.length<=0) && parseInt(tmon)>=10)		
		{
			rmppamount=10*totalamount;
		}
		else
		{
			if(parseInt(fdatesSep[0])!=1)
			{
				rfdays=(fdivider-fdatesSep[0])+1;
			}
			if(parseInt(tdatesSep[0])!=tdivider)
			{
				rtdays=tdatesSep[0];
			}
			
			rmppamount=rmcount*totalamount;	
			//alert("rmcount"+rmcount);
			//alert("totalamount"+totalamount);
			//alert("rmppamount"+rmppamount);
			if(rfdays>0)
			{
				rfppamount=(rfdays/fdivider)*totalamount;
			}
			if(rtdays>0)
			{
				rtppamount=(rtdays/tdivider)*totalamount;
			}
			//alert("rfppamount"+rfppamount);
			//alert("rtppamount"+rtppamount);
		}
		
		ppamount=rmppamount+rfppamount+rtppamount;
		//alert(rmppamount);
		
	}	
	if((fdatesSep[2]!=tdatesSep[2]))
	{
		var ystart=fdatesSep[2];
		var yend=tdatesSep[2];
		//var mstart=fdatesSep[1];
		
		var mstart=monthset(fdatesSep[1]);
		
		
		var mend=12;
		var rmcount=0;
		var rfdays=0;
		var rtdays=0;
		var rmppamount=0;
		var rfppamount=0;
		var rtppamount=0;
		
		for(y=ystart; y<=yend; y++)
		{
			if(y==ystart)
			{
				mstart=monthset(fdatesSep[1]);
			}
			if(y==yend)
			{
				mend=monthset(tdatesSep[1]);
			}			
			for(m=mstart; m<=mend; m++)
			{
				

					if((m==mstart) && (y==ystart))
					{
						cdays=(fdivider-fdatesSep[0])+1;
						if(DaysInMonth(fdatesSep[2], fdatesSep[1])==cdays)
						{
							rmcount++;
						}
						
					}
					else if((m==mend) && (y==yend))
					{
						ddays=tdatesSep[0];
						if(DaysInMonth(tdatesSep[2], tdatesSep[1])==ddays)
						{
							rmcount++;
						}
						
					}
					else
					{
						rmcount++;
					}
				
				
				
				
				
			}
			mstart=1;
			
			
		}

		tbodyvar=document.getElementById("test");
		//alert(rmcount);
		if((tbodyvar.rows.length<=0) && parseInt(tmon)>=10)		
		{
			rmppamount=10*totalamount;
			
		}
		else
		{
			
			if(parseInt(fdatesSep[0])!=1)
			{
				rfdays=(fdivider-fdatesSep[0])+1;
			}
			if(parseInt(tdatesSep[0])!=tdivider)
			{
				rtdays=tdatesSep[0];
			}
		
		
			rmppamount=rmcount*totalamount;
			if(rfdays>0)
			{
				rfppamount=(rfdays/fdivider)*totalamount;
			}
			if(rtdays>0)
			{
				rtppamount=(rtdays/tdivider)*totalamount;
			}
		}
		
		ppamount=rmppamount+rfppamount+rtppamount;
		
	}
	
	
	return ppamount.toFixed(2);
	

	}
	catch(e)
	{
		//alert(e);
	}

}
*/

/*******************************************Calculation for PP amount end**********************************/


function exitwindow()
{
    window.close();
}

/*******************************************form validation Other Department Service start************************************************/

function othdeptservcal()
{
 try
 {
	 
	 var othdeptserflag=document.getElementById("otherdepartmentserviceFlag").value;
	  	 
	 if(othdeptserflag=="Yes")
		 {
		 var tbodydeptvar=document.getElementById("othdeptser");
		 
					 if(tbodydeptvar.rows.length>0)
						 {
						 
						 }
		 
		 
		 }
	 
	 
 }
 catch(e)
 
 {
	 
	 
 }


}

/*******************************************form validation Other Department Service  End************************************************/




/*******************************************form validation start************************************************/

function validateform()
{
	alert("validateform");
	try
	{
	var counttotmonth=0;
	var counttotday=0;
	//var validmaxaemonths=10;
	var validmaxaemonths=parseInt(document.getElementById("Avg_total_months").value);
	tbodyvar=document.getElementById("test");	
	if(tbodyvar.rows.length>0)
	{
		var valfl=0;	
		for(i=0; i<document.AEForm.todate.length; i++)
		{
			if(document.AEForm.fromdate[i].value=="")
			{
				valfl=1;
				document.AEForm.fromdate[i].style.background="red";
			}
			if(document.AEForm.todate[i].value=="")
			{
				valfl=1;
				document.AEForm.todate[i].style.background="red";
			}
			if(document.AEForm.todate[i].value!="")
			{
			var tt=document.AEForm.todate[i].value;
			var ff=document.AEForm.fromdate[i].value;
			var datesSep=tt.split("/");
			var datesSep1=ff.split("/");
				if(isGreaterDate(datesSep[0],datesSep[1],datesSep[2],datesSep1[0],datesSep1[1],datesSep1[2]))
				{					
					document.AEForm.todate[i].style.background="red";
					valfl=1;							
				}
				else
				{	alert("vk 2");
					document.AEForm.todate[i].style.background="white";
					var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
					var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
					
					//var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
					//var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
					
					var dated = datediff(tdate,fdate);
					var fromtotday=DaysInMonth(datesSep1[2], datesSep1[1]);
					var findday=DaysInMonth(datesSep[2], datesSep[1]);
					var totmonth=0;
					var totday=dated[2];	
					if(dated[0]>0)
					{
						totmonth=dated[0]*12;
					}
					if(dated[1]>0)
					{
						totmonth=totmonth+dated[1];
					}	
					/*if(totday>0)
					{
						totday=totday+1;
					}*/
					if(totday>0)
					{
						if(datesSep[0]==31 && fromtotday==30 && datesSep1[0]!=1)
						{
							totday=totday;			
						}
						else
						{
							totday=totday+1;				
						}
					}
					if(dated[2]==0)
					{
						totday=1;
					}
					if(dated[2]>=29)
					{
						totday=0;
						totmonth=totmonth+1;
					}
					else if(parseInt(findday)==parseInt(totday))
					{
						totday=0;
						totmonth=totmonth+1;
					}
					document.AEForm.tmonth[i].value=totmonth;
					document.AEForm.tday[i].value=totday;
						
							
						ffdate=document.AEForm.fromdate[i].value;
						ttdate=document.AEForm.todate[i].value;
						tday=totday;
						tmon=totmonth;
						totalamount=document.AEForm.amount[i].value;
						if((ffdate!="") && (ttdate!="") && (tday!="") && (totalamount!=""))
						{	
							//document.AEForm.ppamount[i].value=calcppamount(ffdate,ttdate,tday,totalamount);
							document.AEForm.ppamount[i].value=calcppamount(ffdate,ttdate,tday,totalamount,tmon);
						}
				}
				
			}
			if((document.AEForm.maxcheck[i].checked==false))
			{
				if(document.AEForm.basic_pay[i].value=="")
				{
					valfl=1;
					document.AEForm.basic_pay[i].style.background="red";
				}
				/*if(document.AEForm.grade_pay[i].value=="")
				{
					valfl=1;
					document.AEForm.grade_pay[i].style.background="red";
				}*/
				

				counttotmonth=counttotmonth+parseInt(document.AEForm.tmonth[i].value);
				counttotday=counttotday+parseInt(document.AEForm.tday[i].value);
				
				
			}
			if((document.AEForm.maxcheck[i].checked==true) || (document.AEForm.maxcheck[i].checked=="true"))
			{
			
				document.AEForm.basic_pay[i].style.background="white";				
				//document.AEForm.grade_pay[i].style.background="white";
				
			}
			
			calctotamount1(i);
			
			fdate=document.AEForm.fromdate[i].value;
			tdate=document.AEForm.todate[i].value;
			tday=document.AEForm.tday[i].value;
			tmon=document.AEForm.tmonth.value;
			totalamount=document.AEForm.amount[i].value;
			if((fdate!="") && (tdate!="") && (tday!="") && (totalamount!=""))
			{
				//document.AEForm.ppamount[i].value=calcppamount(fdate,tdate,tday,totalamount);
				document.AEForm.ppamount[i].value=calcppamount(fdate,tdate,tday,totalamount,tmon);
			}
			
			if(document.AEForm.maxcheck_value[0].value=="")
			{
				document.AEForm.maxcheck_value[0].value="N";
			}

			
		}
		if(valfl==0)
		{
			
			//disabledaegrid();			
			
		}
		else
		{
			alert("Please Enter valid data.");
			return false;
		}
		
	
	}
	else
	{
		alert("vk 3");
		if(document.AEForm.fromdate.value=="")
		{
			alert("Enter from date");
			return false;
		}
		if(document.AEForm.todate.value=="")
		{
			alert("Enter to date");
			return false;
		}
		if((document.AEForm.maxcheck.checked==false) || (document.AEForm.maxcheck.checked=="false"))
		{
			if(document.AEForm.basic_pay.value=="")
			{
				alert("Enter basic pay");
				return false;
			}
		/*	if(document.AEForm.grade_pay.value=="")
			{
				alert("Enter grade pay");
				return false;
			}*/

			counttotmonth=counttotmonth+parseInt(document.AEForm.tmonth.value);
			counttotday=counttotday+parseInt(document.AEForm.tday.value);
		}
		//disabledaegrid();
		calctotamount();
		fdate=document.AEForm.fromdate.value;
		tdate=document.AEForm.todate.value;
		tday=document.AEForm.tday.value;
		tmon=document.AEForm.tmonth.value;
		totalamount=document.AEForm.amount.value;
		if((fdate!="") && (tdate!="") && (tday!="") && (totalamount!=""))
		{
			//document.AEForm.ppamount.value=calcppamount(fdate,tdate,tday,totalamount);
			document.AEForm.ppamount.value=calcppamount(fdate,tdate,tday,totalamount,tmon);
		}
		if(document.AEForm.maxcheck_value.value=="")
		{
			document.AEForm.maxcheck_value.value="N";
		}
		

	}
	alert("vk 3.5");
	var tdayremain=counttotday%30;
	var tda=counttotday/30;
	
	counttotmonth=counttotmonth+tda;
	//if(counttotmonth<10)
	if(counttotmonth<parseInt(validmaxaemonths))
	{
		alert("vk 4");
		changeIt();
	}
	else
	{
		//alert("Exceed 10 months");
		alert("Exceed "+validmaxaemonths+" months");
	}
	}
	catch(e)
	{
		//alert(e.message);
	}
	
}

/*******************************************************************form validation end**********************************************************/


/*******************************************Disable Grid start************************************************/

function disabledaegrid()
{
	if(document.AEForm.todate.length>0)
	{

		for(i=0; i<document.AEForm.todate.length; i++)
		{	
			
			document.AEForm.maxcheck[i].disabled=true;
			document.AEForm.fromdate[i].disabled=true;
			document.AEForm.todate[i].disabled=true;
			document.AEForm.tmonth[i].disabled=true;
			document.AEForm.tday[i].disabled=true;
			document.AEForm.basic_pay[i].disabled=true;
			document.AEForm.grade_pay[i].disabled=true;
			document.AEForm.special_pay[i].disabled=true;
			document.AEForm.optionpay1[i].disabled=true;
			document.AEForm.optionpay2[i].disabled=true;
			document.AEForm.optionpay3[i].disabled=true;
			document.AEForm.amount[i].disabled=true;
			document.AEForm.ppamount[i].disabled=true;
		}
	}
	else
	{
		document.AEForm.maxcheck.disabled=true;
		document.AEForm.fromdate.disabled=true;
		document.AEForm.todate.disabled=true;
		document.AEForm.tmonth.disabled=true;
		document.AEForm.tday.disabled=true;
		document.AEForm.basic_pay.disabled=true;
		document.AEForm.grade_pay.disabled=true;
		document.AEForm.special_pay.disabled=true;
		document.AEForm.optionpay1.disabled=true;
		document.AEForm.optionpay2.disabled=true;
		document.AEForm.optionpay3.disabled=true;
		document.AEForm.amount.disabled=true;
		document.AEForm.ppamount.disabled=true;
	}
	
}

/***********************************************************Disable Grid end***************************************************************/



/*******************************************Disable Grid start************************************************/

function enableaegrid()
{
	if(document.AEForm.todate.length>0)
	{

		for(i=0; i<document.AEForm.todate.length; i++)
		{
			document.AEForm.maxcheck[i].disabled=false;
			document.AEForm.fromdate[i].disabled=false;
			document.AEForm.todate[i].disabled=false;
			document.AEForm.tmonth[i].disabled=false;
			document.AEForm.tday[i].disabled=false;
			document.AEForm.basic_pay[i].disabled=false;
			//document.AEForm.grade_pay[i].disabled=false;
			document.AEForm.special_pay[i].disabled=false;
			document.AEForm.optionpay1[i].disabled=false;
			document.AEForm.optionpay2[i].disabled=false;
			document.AEForm.optionpay3[i].disabled=false;
			document.AEForm.amount[i].disabled=false;
			document.AEForm.ppamount[i].disabled=false;
		}
	}
	else
	{
		document.AEForm.maxcheck.disabled=false;
		document.AEForm.fromdate.disabled=false;
		document.AEForm.todate.disabled=false;
		document.AEForm.tmonth.disabled=false;
		document.AEForm.tday.disabled=false;
		document.AEForm.basic_pay.disabled=false;
		//document.AEForm.grade_pay.disabled=false;
		document.AEForm.special_pay.disabled=false;
		document.AEForm.optionpay1.disabled=false;
		document.AEForm.optionpay2.disabled=false;
		document.AEForm.optionpay3.disabled=false;
		document.AEForm.amount.disabled=false;
		document.AEForm.ppamount.disabled=false;
	}
	
}

/***********************************************************Disable Grid end***************************************************************/



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
	var splChar = /[a-zA-Z!@#$%&*()+-=|_'"`~:;<>?,\/\\\^\\{\}\[\]]/;
	
	return (!splChar.test(keychar));
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


/******************************************************Check All function start***************************************************************/

function checkallrow()
{	
	if(document.AEForm.fromdate.length>0)
	{
		for(i=0; i<document.AEForm.fromdate.length; i++)
		{
			document.AEForm.maxcheck[i].checked=true;
		}
		
	}
	else
	{
		document.AEForm.maxcheck.checked=true;	
	}
	
}

/******************************************************Check All function end***************************************************************/



/******************************************************Un Check All function start**********************************************************/

function uncheckallrow()
{
	if(document.AEForm.fromdate.length>0)
	{
		for(i=0; i<document.AEForm.fromdate.length; i++)
		{
			
			document.AEForm.maxcheck[i].checked=false;
		}
		
	}
	else
	{
		document.AEForm.maxcheck.checked=false;	
	}
}

/*************************************Un Check All function end**********************************************/



/*************************************Delete row function start**********************************************/


function deleterow(str)
  {
	
	var r=confirm("Are you sure want to delete this record.");
	if(r==true)
	{
		try
		{

    			var current = window.event.srcElement;			
    			while ( (current = current.parentElement)  && current.tagName !="TR");
        		current.parentElement.removeChild(current);
			
		
			/*str=parseInt(str)-1;
			var tbody=document.getElementById("test");
			tbody.deleteRow(str);*/
        		
        		refresh_totalppamount();
        		
		}
		catch(e)
		{
			alert(e.message);
		}
	}
	

  }

function delrow(str)
{	
	var r=confirm("Are you sure want to delete this record.");
	if(r==true)
	{
		try
		{	
			document.getElementById(str).innerHTML="";
			
			refresh_totalppamount();
		}
		catch(e)
		{
			alert(e.message);
		}
	}

}

/*************************************Delete row function end**********************************************/

function refresh_totalppamount()
{
	
	var ftotppamount=0;	
	var ftotamount=0;
	//var validmaxaemonths=10;
	var validmaxaemonths=parseInt(document.getElementById("Avg_total_months").value);
	tbodyvar=document.getElementById("test");
	
		//if(tbodyvar.rows.length>0)	
		if(document.AEForm.ppamount.length>0)
		{				
			var t=0;
			for(t=0; t<document.AEForm.ppamount.length; t++)
			{
				if((document.AEForm.maxcheck[t].checked==false))	
				{												
					ftotppamount=parseFloat(ftotppamount)+parseFloat(document.AEForm.ppamount[t].value);
					ftotamount=parseFloat(ftotamount)+parseFloat(document.AEForm.amount[t].value);
				}
				else
				{
					ftotppamount=parseFloat(ftotppamount)+parseFloat(0);
					ftotamount=parseFloat(ftotamount)+parseFloat(0);
				}
				
			}
			
			//document.AEForm.finaltotalppamount.value=(ftotppamount/10).toFixed(2);
			//document.AEForm.finaltotalppamount.value=(ftotppamount/parseInt(validmaxaemonths)).toFixed(2);
			//document.AEForm.finaltotalppamount.value=(ftotppamount/parseInt(validmaxaemonths));
			
			document.AEForm.finaltotalppamount.value=Math.round(ftotppamount/parseInt(validmaxaemonths));
			
			//document.AEForm.finaltotalamount.value=(ftotamount/10).toFixed(2);
		}
		else
		{
			if((document.AEForm.maxcheck.checked==false) || (document.AEForm.maxcheck.checked=="false"))
			{
				fppamount=document.AEForm.ppamount.value;
				famount=document.AEForm.amount.value;
				//document.AEForm.finaltotalppamount.value=(fppamount/parseInt(validmaxaemonths)).toFixed(2);
				
				//document.AEForm.finaltotalppamount.value=(fppamount/parseInt(validmaxaemonths));
				
				document.AEForm.finaltotalppamount.value=Math.round(fppamount/parseInt(validmaxaemonths));
				
				
				
				//document.AEForm.finaltotalppamount.value=(fppamount/10).toFixed(2);
				//document.AEForm.finaltotalamount.value=(famount/10).toFixed(2);
			}
			else
			{
				document.AEForm.finaltotalppamount.value="0";
				//document.AEForm.finaltotalamount.value="0.00";
			}
		}
}




function checkfun1(str)
{

	if(document.AEForm.maxcheck[str].checked==true)
	{	
		//alert("inside if");		
		document.AEForm.maxcheck_value[str].value='Y';    	
	}
	else
	{		
		//alert("inside else");		
		document.AEForm.maxcheck_value[str].value='N';		
	}
}

function checkfun_main(a)
{
//alert(document.AEForm.maxcheck.length);
	if(document.AEForm.maxcheck.checked==true)
	{
		
		document.AEForm.maxcheck_value.value='Y';
	}
	else
	{		
		document.AEForm.maxcheck_value.value='N';
	}
}

function monthset(str)
{
	var monthstr=1;
	if((str=="01") || (str=="1"))
	{
		monthstr=1;
	}
	if((str=="02") || (str=="2"))
	{
		monthstr=2;
	}
	if((str=="03") || (str=="3"))
	{
		monthstr=3;
	}
	if((str=="04") || (str=="4"))
	{
		monthstr=4;
	}
	if((str=="05") || (str=="5"))
	{
		monthstr=5;
	}
	if((str=="06") || (str=="6"))
	{
		monthstr=6;
	}
	if((str=="07") || (str=="7"))
	{
		monthstr=7;
	}
	if((str=="08") || (str=="8"))
	{
		monthstr=8;
	}
	if((str=="09") || (str=="9"))
	{
		monthstr=9;
	}
	if((str=="10"))
	{
		monthstr=10;
	}
	if((str=="11"))
	{
		monthstr=11;
	}
	if((str=="12"))
	{
		monthstr=12;
	}
	return monthstr;
}