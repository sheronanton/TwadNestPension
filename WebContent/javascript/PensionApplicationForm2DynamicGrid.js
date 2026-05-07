var seq=0;
var seq2=0;

function addNewNominee()
{
	
	var tbody1=document.getElementById("addNewNominee");	
	var tabletr=document.createElement("tr");	
	tabletr.id=seq+'r';
	
	var tabletd12=document.createElement("td");
	var initial=document.createElement("input");
	initial.name="nomineeInitial";
	initial.id="nomineeInitial";
	initial.type = 'text';
	initial.maxLength=5;
	initial.size=5;	
	initial.className="textbox";
	tabletd12.appendChild(initial);
	tabletd12.align="center";
	tabletr.appendChild(tabletd12);
	
	
	//////////////////// Family Members ////////////////////////
	var tabletd1=document.createElement("td");
	var familyMembers=document.createElement("input");
	familyMembers.name="familyMembers";
	familyMembers.id="familyMembers";
	familyMembers.type = 'text';
	familyMembers.className="textbox";
	familyMembers.maxLength=30;
	tabletd1.appendChild(familyMembers);
	tabletd1.align="center";
	tabletr.appendChild(tabletd1);
	
	
	//////////////////Family Members Relationship ////////////////////////
	var tabletd2=document.createElement("td");
	var combo1=document.createElement("select");
	combo1.name="relation";
	combo1.id="relation";

	/*var opt0= document.createElement('option');
	opt0.value ='0';
	opt0.innerHTML ='--Select--';
	combo1.appendChild(opt0);*/
	
	var opt1= document.createElement('option');
	opt1.value ='1';
	opt1.innerHTML ='Father';
	combo1.appendChild(opt1);
	
	var opt2 = document.createElement('option');
	opt2.value = '2';
	opt2.innerHTML = 'Mother';
	combo1.appendChild(opt2);
	
	var opt3 = document.createElement('option');
	opt3.value = '3';
	opt3.innerHTML = 'Spouse';
	combo1.appendChild(opt3);
	
	var opt4 = document.createElement('option');
	opt4.value = '5';
	opt4.innerHTML = 'Son';
	combo1.appendChild(opt4);

	var opt5 = document.createElement('option');
	opt5.value = '6';
	opt5.innerHTML = 'Daughter';
	combo1.appendChild(opt5);
	
	tabletd2.appendChild(combo1);
	tabletd2.align="center";	
	tabletr.appendChild(tabletd2);
	
    /////////////////Nominee DOB/////////////////
	
	var tabletd3=document.createElement("td");
	var dob=document.createElement("input");
	dob.type="text";
	dob.name="nomineeDob";
	dob.id="nomineeDob";
	dob.className="textbox";
	dob.maxLength=10;
	dob.size=10;
	dob.onkeyup = function() {			
		dtval(this,"event");
	};
	
	tabletd3.appendChild(dob);
	tabletd3.align="center";	
	tabletr.appendChild(tabletd3);
	/////////////////AGE/////////////////////////
	
	var tabletd8=document.createElement("td");
	var nominAge=document.createElement("input");
	nominAge.name="nomineeAge";
	nominAge.id="nomineeAge";
	nominAge.type = 'text';	
	nominAge.className="textbox";
	nominAge.maxLength=3;
	nominAge.size=3;
	
	tabletd8.appendChild(nominAge);
	tabletd8.align="center";
	tabletr.appendChild(tabletd8);
	
	/////////////////Handicapped/////////////////
	
	var tabletd4 = document.createElement('td');
	var combo2 = document.createElement('select');
	combo2.name="handicapped";
	combo2.id="handicapped";
	
	/*var opt6 = document.createElement('option');
	opt6.value = 'NS';
	opt6.innerHTML = '--Select--';
	combo2.appendChild(opt6);*/
	
	var opt7 = document.createElement('option');
	opt7.value = 'Y';
	opt7.innerHTML = 'Yes';
	combo2.appendChild(opt7);
	
	var opt8= document.createElement('option');
	opt8.value = 'N';
	opt8.innerHTML ='No';
	opt8.selected='selected';	
	combo2.appendChild(opt8);
	
	tabletd4.appendChild(combo2);
	tabletd4.align="center";	
	tabletr.appendChild(tabletd4);
	
	//////////////////Martial Status/////////////////
	
	var tabletd5 = document.createElement('td');
	var combo3 = document.createElement('Select');
	combo3.name="martialStatus";
	combo3.id="martialStatus";
	
	/*var opt10 = document.createElement('option');
	opt10.value = 'NS';
	opt10.innerHTML = '--Select--';
	combo3.appendChild(opt10);*/
			
	var opt11 = document.createElement('option');
	opt11.value = 'Married';
	opt11.innerHTML = 'Married';
	combo3.appendChild(opt11);

	var opt12 = document.createElement('option');
	opt12.value = 'Unmarried';
	opt12.innerHTML = 'Unmarried';
	combo3.appendChild(opt12);
	
	
	tabletd5.appendChild(combo3);
	tabletd5.align="center";
	tabletr.appendChild(tabletd5);
	
	
	
///////////////Nomination date/////////////////
	
	var tabletd9=document.createElement("td");
	var nominDate=document.createElement("input");
	nominDate.name="nominationDate";
	nominDate.id="nominationDate";
	nominDate.type = 'text';	
	nominDate.className="textbox";
	nominDate.maxLength=10;
	nominDate.size=10;
	nominDate.onkeyup = function() {			
		dtval(this,"event");
	};
	
	tabletd9.appendChild(nominDate);
	tabletd9.align="center";
	tabletr.appendChild(tabletd9);
	
/////////////////Active Status/////////////////
	
	var tabletd6 = document.createElement('td');
	var combo4 = document.createElement('Select');
	combo4.name="activeStatus";
	combo4.id="activeStatus";
	
/*	var opt10 = document.createElement('option');
	opt10.value = 'NS';
	opt10.innerHTML = '--Select--';
	combo4.appendChild(opt10);*/
			
	var opt11 = document.createElement('option');
	opt11.value = 'Yes';
	opt11.innerHTML = 'Yes';
	combo4.appendChild(opt11);

	var opt12 = document.createElement('option');
	opt12.value = 'No';
	opt12.innerHTML = 'No';
	combo4.appendChild(opt12);	
	
	tabletd6.appendChild(combo4);
	tabletd6.align="center";
	tabletr.appendChild(tabletd6);
	
    ///////////////Reason/////////////////
	
	var tabletd7=document.createElement("td");
	var nominReason=document.createElement("input");
	nominReason.name="nominReason";
	nominReason.id="nominReason";
	nominReason.type = 'text';	
	nominReason.className="textbox";
	nominReason.maxLength=10;
	tabletd7.appendChild(nominReason);
	tabletd7.align="center";
	tabletr.appendChild(tabletd7);
	

	var image2 = document.createElement('img');
	image2.src="../images/delete.png";
	image2.align="center";
	image2.border="0";
	image2.align="center";
	var tabletd11=document.createElement("td");
    var anc=document.createElement("A");
    var url="javascript:Delete('" +seq+ "r')";              
    anc.href = url;
    anc.appendChild(image2);
    tabletd11.appendChild(anc);
    tabletd11.align="center";
    tabletr.appendChild(tabletd11);
    	
	tbody1.appendChild(tabletr);	

	seq++;
}

function Delete(seq)
{	
	var opt1=confirm("Are you sure want to delete ?");
	if(opt1)
		{
			var tbody12=document.getElementById("addNewNominee");
			var r=document.getElementById(seq);   
			var ri=r.rowIndex;   
			tbody12.deleteRow(ri-1);	
		}
	else
		{
		
		}
}



function addNewNotVerify()
{
	var tbody2=document.getElementById("notVerifyService");
	
	
	/*if(!chkSubmit())
	{
		return false;
	}*/
	//else	
	if(chkSubmit() || tbody2.rows.length==0)
	{
	// var tbody2=document.getElementById("notVerifyService");
	
	if(tbody2.rows.length>0)
    {
    	var maxid=0;
    	var lenn=tbody2.rows.length;    	
    	try
    	{
    		maxid=parseInt(tbody2.rows[lenn-1].id)+1;
    	}
    	catch(e)
    	{
    		
    	}
    	seq2=maxid;
    }
	
	
	var tablerow=document.createElement("tr");	
	tablerow.id=seq2;
	
	var tabletd1=document.createElement("td");
	var text1=document.createElement("input");
	text1.name="notVerifyServFromDate";
	text1.id='notVerifyServFromDate';
	text1.type='text';
	text1.className="textbox";
	
	
	text1.onkeyup = function() {			
		dtval(this,"event");
	};	
	
	text1.onblur =function() {			
		checkValidDate(this);
	};
	
	text1.maxLength=10;
	tabletd1.align="center";
	tabletd1.appendChild(text1);
	tablerow.appendChild(tabletd1);
	
	var tabletd2=document.createElement("td");
	var text2=document.createElement("input");
	text2.name="notVerifyServToDate";
	text2.id="notVerifyServToDate";
	text2.className="textbox";
	
	text2.type="text";
	text2.maxLength=10;
	text2.onkeyup = function() {			
		dtval(this,"event");
	};
	
	/*text2.onblur =function() {			
		calculateService(tablerow.id);
	};*/
	text2.onblur =function() {			
		checkValidtoDate(this);
		calculateService(tablerow.id);
	};
	
	tabletd2.align="center";
	tabletd2.appendChild(text2);	
	tablerow.appendChild(tabletd2);
	
	var tabletd3=document.createElement("td");
	var text3=document.createElement("input");
	text3.name="notVerifyServiceReason";
	text3.id="notVerifyServiceReason";	
	text3.className="textbox";
	tabletd3.align="center";
	tabletd3.appendChild(text3);	
	tablerow.appendChild(tabletd3);
	
	var tabletd4=document.createElement("td");
	var text4=document.createElement("input");
	text4.name="notVerifyYear";
	text4.id="notVerifyYear";
	text4.type="text";
	text4.className="readonlytext";
	text4.maxLength=10;
	text4.readOnly=true;
	tabletd4.align="center";
	tabletd4.appendChild(text4);
	tablerow.appendChild(tabletd4);
	
	var tabletd5=document.createElement("td");
	var text5=document.createElement("input");
	text5.name="notVerifyMonth";
	text5.id="notVerifyMonth";
	text5.type="text";
	text5.className="readonlytext";
	text5.readOnly=true;
	text5.maxLength=10;
	tabletd5.align="center";
	tabletd5.appendChild(text5);	
	tablerow.appendChild(tabletd5);
	
	var tabletd6=document.createElement("td");
	var text6=document.createElement("input");
	text6.name="notVerifyDays";
	text6.id="notVerifyDays";
	text6.type="text";
	text6.readOnly=true;
	text6.className="readonlytext";	
	text6.maxLength=10;
	tabletd6.align="center";
	tabletd6.appendChild(text6);	
	tablerow.appendChild(tabletd6);
	
	
	var image3 = document.createElement('img');
	image3.src="../images/delete.png";
	image3.align="center";
	image3.border="0";
	image3.align="center";
	var tabletd7=document.createElement("td");
    var anc1=document.createElement("A");
    var url1="javascript:Delete1('"+seq2+"')";  
    anc1.href = url1;
    anc1.appendChild(image3);
    tabletd7.appendChild(anc1);
    tabletd7.align="center";
    tablerow.appendChild(tabletd7);
    
	tbody2.appendChild(tablerow);
	
	seq2++;
	
	}
	else
	{
		return false;
	}
	
}


function Delete1(seq)
{		
	alert("Deleting row Selected");
    var tbody13=document.getElementById("notVerifyService");
    var r=document.getElementById(seq);   
    var ri=r.rowIndex; 
    tbody13.deleteRow(ri-1);
    calculateService(ri); 
}




/*  function calculateService(rowid)
{	
var tbody2=document.getElementById("notVerifyService");
var leng=tbody2.rows.length;

alert(rowid);
	if(leng>1)
	{
		rowid=rowid-1;	
		
		try
		{
		var todate=document.forms[0].notVerifyServToDate[rowid].value;
		var fromdate=document.forms[0].notVerifyServFromDate[rowid].value;
		}
		catch(e){alert(e.message);}
		
		var datesSep=todate.split("/");
		var datesSep1=fromdate.split("/");
		
		var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);

		var dated = datediff(tdate,fdate);
		var yr=dated[0];
		var mon=dated[1];
		var day=dated[2]+1;

		document.forms[0].notVerifyYear[rowid].value=yr;
		document.forms[0].notVerifyMonth[rowid].value=mon;
		document.forms[0].notVerifyDays[rowid].value=day;
		
	}

	else
	{	
		
		var todate=document.forms[0].notVerifyServToDate.value;
		var fromdate=document.forms[0].notVerifyServFromDate.value;
		var datesSep=todate.split("/");
		var datesSep1=fromdate.split("/");
		var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);

		var dated = datediff(tdate,fdate);
		var yr=dated[0];
		var mon=dated[1];
		var day=dated[2]+1;

		document.forms[0].notVerifyYear.value=yr;
		document.forms[0].notVerifyMonth.value=mon;
		document.forms[0].notVerifyDays.value=day;
	}


	if(leng>0)
	{
		totSer();
	}
	if(leng==0)
		{
		document.forms[0].notVerifyServiceTotYears.value="";
		document.forms[0].notVerifyServiceTotMonths.value="";
		document.forms[0].notVerifyServiceTotDays.value="";
		}

}*/


function calculateService(rowid)
{	
var tbody2=document.getElementById("notVerifyService");
var leng=tbody2.rows.length;
	if(leng>1)
	{
		// rowid=rowid-1;	
		for(i=0; i<leng; i++)
		{
			
			var todate=document.forms[0].notVerifyServToDate[i].value;
			var fromdate=document.forms[0].notVerifyServFromDate[i].value;
			
			if(todate.trim()!="" && fromdate.trim()!="")
			{
				var datesSep=todate.split("/");
				var datesSep1=fromdate.split("/");
				var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
				var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);			
				
				if(isGreaterDate(datesSep[0],datesSep[1],datesSep[2],datesSep1[0],datesSep1[1],datesSep1[2]))
				{
					alert('Start Date is Greater than End Date');
					document.forms[0].notVerifyServToDate[i].value="";
					document.forms[0].notVerifyYear[i].value="";
		            document.forms[0].notVerifyMonth[i].value="";
		            document.forms[0].notVerifyDays[i].value="";
					return false;
				}
				
				var dated = datediff(tdate,fdate);
				var yr=dated[0];
				var mon=dated[1];
				var day=dated[2]+1;
		
				document.forms[0].notVerifyYear[i].value=yr;
				document.forms[0].notVerifyMonth[i].value=mon;
				document.forms[0].notVerifyDays[i].value=day;
				
			}
			
		}
		
	}

	else
	{	
		
		var todate=document.forms[0].notVerifyServToDate.value;
		var fromdate=document.forms[0].notVerifyServFromDate.value;
		
		if(todate.trim()!="" && fromdate.trim()!="")
		{
		
		var datesSep=todate.split("/");
		var datesSep1=fromdate.split("/");
		var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);

		var dated = datediff(tdate,fdate);
		var yr=dated[0];
		var mon=dated[1];
		var day=dated[2]+1;

		document.forms[0].notVerifyYear.value=yr;
		document.forms[0].notVerifyMonth.value=mon;
		document.forms[0].notVerifyDays.value=day;
		
		}
	}


	if(leng>0)
	{
		totSer();
	}
	if(leng==0)
		{
		document.forms[0].notVerifyServiceTotYears.value="";
		document.forms[0].notVerifyServiceTotMonths.value="";
		document.forms[0].notVerifyServiceTotDays.value="";
		}

	return true;
}





function totSer()
{
	
	var tbody2=document.getElementById("notVerifyService");
	var leng1=tbody2.rows.length;
	var totYr=0;
	var totMon=0;
	var totDay=0;
	
		if(leng1>1)
		{
			for(var i=0;i<leng1;i++)
			{
					if(document.forms[0].notVerifyYear[i].value!="")
					{
					totYr=parseInt(totYr)+parseInt(document.forms[0].notVerifyYear[i].value);
					}
					else
					{
					totYr=parseInt(totYr);
					}
					if(document.forms[0].notVerifyMonth[i].value!="")
					{
					totMon=parseInt(totMon)+parseInt(document.forms[0].notVerifyMonth[i].value);
					}
					else
					{
					totMon=parseInt(totMon);
					}
					if(document.forms[0].notVerifyDays[i].value!="")
					{
					totDay=parseInt(totDay)+parseInt(document.forms[0].notVerifyDays[i].value);
					}
					else
					{
					totDay=parseInt(totDay);
					}
			}
			
		
			var ch1=parseInt(totDay)/parseInt(30);
			var ch2=parseInt(totDay)%parseInt(30);
			
			var mon1=parseInt(totMon)/ parseInt(12);
			var mon2=parseInt(totMon)% parseInt(12);
			
			totDay=ch2;
			totMon=mon2;
			
			document.forms[0].notVerifyServiceTotYears.value=totYr;
			document.forms[0].notVerifyServiceTotMonths.value=totMon;			
			document.forms[0].notVerifyServiceTotDays.value=totDay;
			
		}
		else
		{
			document.forms[0].notVerifyServiceTotYears.value=document.forms[0].notVerifyYear.value;
			document.forms[0].notVerifyServiceTotMonths.value=document.forms[0].notVerifyMonth.value;
			document.forms[0].notVerifyServiceTotDays.value=document.forms[0].notVerifyDays.value;
		}
}



function chkSubmit()
{	
	 var row=0;
	 var flag=true;     
	 var colorBug="#F78181";
	 var colorOk="#FFFFFF";
	 var str="Not Verified Details \n";
	 var tbody2=document.getElementById("notVerifyService");
	 var leng1=tbody2.rows.length;
	 if(leng1>0)
	 {
		 if(document.forms[0].notVerifyServFromDate.length>0)
		 {
			 	for(var i=0;i<document.forms[0].notVerifyServFromDate.length;i++)
				{	     	
				row++;
					
						var fromDate=document.forms[0].notVerifyServFromDate[i];		
						 if(fromDate.value.trim().length==0)
				          {
							 fromDate.style.background=colorBug;
				             str+="Row-"+row+"."+" From Date should not be leave Empty!\n";
				             flag=false;
				           }
						 
						 else
							 {
							   fromDate.style.background=colorOk;
							 }
					
						var toDate=document.forms[0].notVerifyServToDate[i];		
						 if(toDate.value.trim().length==0)
				          {
							
							 
							 
							 
							 toDate.style.background=colorBug;
				             str+="Row-"+row+"."+" To Date should not be leave Empty!\n"; 
				             flag=false;
				           }
						 
						 else
							 {
							 toDate.style.background=colorOk;
							 }	
					
				}
		 }		 
		 else
		 {
			 	     	
				row++;
					
						var fromDate=document.forms[0].notVerifyServFromDate;		
						 if(fromDate.value.trim().length==0)
				          {
							 fromDate.style.background=colorBug;
				             str+="Row-"+row+"."+" From Date should not be leave Empty!\n";
				             flag=false;
				           }
						 
						 else
							 {
							   fromDate.style.background=colorOk;
							 }
					
						var toDate=document.forms[0].notVerifyServToDate;		
						 if(toDate.value.trim().length==0)
				          {
							
							 
							 
							 
							 toDate.style.background=colorBug;
				             str+="Row-"+row+"."+" To Date should not be leave Empty!\n"; 
				             flag=false;
				           }
						 
						 else
							 {
							 toDate.style.background=colorOk;
							 }	
					
				
		 }
		 
		 if(!flag)
	     {
			 alert(str); 
	     }
		 calculateService(0);
	 }
	return flag;
	
	  
}


/*function chkSubmit()
{	
	 var row=0;
	 var flag=true;     
	 var colorBug="#F78181";
	 var colorOk="#FFFFFF";
	 var str="Not Verified Details \n";	  
	for(var i=0;i<document.forms[0].elements.length;i++)
		{	     	
		row++;
			if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="notVerifyServFromDate")
			{
				
				//row++;
				var fromDate=document.forms[0].elements[i];		
				 if(fromDate.value.trim().length==0)
		          {
					 fromDate.style.background=colorBug;
		             str+="Row-"+row+"."+" From Date should not be leave Empty!\n";
		             flag=false;
		           }
				 
				 else
					 {
					   fromDate.style.background=colorOk;
					 }
			}
			
			if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="notVerifyServToDate")
			{
				
				//row++;
				var toDate=document.forms[0].elements[i];		
				 if(toDate.value.trim().length==0)
		          {
					
					 
					 
					 
					 toDate.style.background=colorBug;
		             str+="Row-"+row+"."+" To Date should not be leave Empty!\n"; 
		             flag=false;
		           }
				 
				 else
					 {
					 toDate.style.background=colorOk;
					 }
			}
			
			
				
			
}
	//alert(flag);
	 if(!flag)
     {
     alert(str); 
     }
	 calculateService(0);
	return flag;
	
	  
}*/


function chkSubmit2()
{
	var row=0;
	 var flag2=true;     
	 var colorBug="#F78181";
	 var colorOk="#FFFFFF";
	 var str="Nominee Details \n";	  
	 var relFlag=false;	    
	 var tmpFlg1=false;
	    
	    
	for(var i=0;i<document.forms[0].elements.length;i++)
		{    	
		
			if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="familyMembers")
			{
				
				row++;
				var famMem=document.forms[0].elements[i];		
				 if(famMem.value.trim().length==0)
		          {
					 famMem.style.background=colorBug;
		             str+="Row-"+row+"."+" Name of Family Members should not be leave Empty!\n";
		             flag2=false;
		           }
				 
				 else
					 {
					 famMem.style.background=colorOk;
					 }
			}
			
			
			if(document.forms[0].elements[i].type=="select-one" && document.forms[0].elements[i].id=="relation")
				{
					var relation=document.forms[0].elements[i];
					if(parseInt(relation.value)==0)
					{
						relation.style.background=colorBug;
						str+="Row-"+row+"."+" Please Select a Valid Relation!\n";
						flag2=false;
					}
				
					else if(parseInt(relation.value) > 3 ) 
					{
						relation.style.background=colorOk;
						tmpFlg1=true;
					}
				
					else
					{
						relation.style.background=colorOk;
						tmpFlg1=false;
					}
				}
			
			
		
			
			if(document.forms[0].elements[i].type=="select-one" && document.forms[0].elements[i].id=="martialStatus")
			{
			
			    var marStatus=document.forms[0].elements[i];
				if(!(tmpFlg1) && marStatus.value!="Married")
					{
					marStatus.style.background=colorBug;
					str+="Row-"+row+"."+" Marital Status is invalid for this relation!\n";
					flag2=false;
					}
				else
					{
					marStatus.style.background=colorOk;
					}
				
			
			}
		
	
			
			if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="nomineeDob")
			{
				var dobStr=document.forms[0].elements[i];
				if(dobStr.value.trim().length>0)
				{
					var datesSep=dobStr.value.split("/");	       
	        		
					if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
	        			{
	        				dobStr.style.background=colorBug;
	        				str+="Row-"+row+"."+" Date of birth Invalid!\n";
	        				flag2=false;
	        			}
	        
	        		else if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
	        			{
	        				dobStr.style.background=colorBug;
	        				str+="Row-"+row+"."+" Date of birth should not be Future date!\n";
	        				flag2=false;	        				
	        			}
	        		else
	        			{
	        				dobStr.style.background=colorOk;
	        			}
	        		
					relFlag=false;
	                    
	            }
				
				else if(tmpFlg1)
				{
					dobStr.style.background=colorBug;
					str+="Row-"+row+"."+" Date of Birth should not be Empty for this relation!\n";
					relFlag=false;
					flag2=false;
				 }
			 else
	           {
				 relFlag=true;
				 dobStr.style.background=colorOk;
	           }
			 
			}
			
			
			if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="nominationDate")
			{
			var dateOfNominee=document.forms[0].elements[i];
			if(dateOfNominee.value.trim().length>0)
		      {
		  		datesSep=dateOfNominee.value.split("/");
		  			if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
		  				{
		  				dateOfNominee.style.background=colorBug;
		  					str+="Row-"+row+"."+" Nomination Date Invalid!\n";
		  					flag2=false;
		  				}

		  			else if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
		  				{
		  					dobStr.style.background=colorBug;
		  					str+="Row-"+row+"."+" Nomination Date should not be Future date!\n";
		  					flag2=false;		  				
		  				}
		  			else
		  				{
		  				dateOfNominee.style.background=colorOk;
		  				}
		      }

		  else
		  	{
		  		dateOfNominee.style.background=colorBug;
		      	str+="Row-"+row+"."+" Nomination Date should not be Empty!\n";
		      	flag2=false;
		     
		  	}
			}
			
			if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="nomineeAge")
			{
			var age=document.forms[0].elements[i];
			 if(!(age.value >= 0))
		     	{
		     		age.style.background=colorBug;
		     		str+="Row-"+row+"."+" Age is not valid!\n";
		     		flag2=false;
		     	}
		 
		     else if(relFlag && age.value.trim().length==0) //This checking for 'Dob Mandatory if relation is son or daughter'
		     	{		     		
		         	str+="Row-"+row+"."+"Age or Date of birth should be filled  for this relation!\n";
		         	flag2=false;	                               
		     	}
		     
		     else
		     {
		         age.style.background=colorOk;
		     }
			}
			
			
			
		
		
}
	 if(!flag2)
     {
     alert(str); 
     }
	
	return flag2;
		
}

function datediff(date1, date2) {

   var y1 = date1.getFullYear(), m1 = date1.getMonth(), d1 = date1.getDate(),
        y2 = date2.getFullYear(), m2 = date2.getMonth(), d2 = date2.getDate();

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


function checkValidDate(obj)
{		
	var fromdate=obj.value;	
	if(fromdate.trim()!="")
		{	
			var datesSep1=fromdate.split("/");	
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
			
			if(!isValidDate(datesSep1[0],datesSep1[1],datesSep1[2]))
			{				
				alert('Invalid not Verify Service From Date');	
				obj.value="";
			}
			
		}
	

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

function checkValidtoDate(obj)
{		
	var todate=obj.value;	
	if(todate.trim()!="")
		{	
			var datesSep1=todate.split("/");	
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
			
			if(!isValidDate(datesSep1[0],datesSep1[1],datesSep1[2]))
			{				
				alert('Invalid not Verify Service To Date');
				obj.value="";
			}
			
		}
	

}
