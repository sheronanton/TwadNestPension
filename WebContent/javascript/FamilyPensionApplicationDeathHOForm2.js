

var seq =1;

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


function setRadioButtons()
{
	document.getElementById("typeUserEmployee").checked=true;
}


function fetchMstData(val2)
{
	if(val2!="")
	{
		var url="famPenAppHoLoadMstDataChk.html?fpenho3.empId="+val2+"&rnd="+new Date().getTime();
		var ajaxObj=getReq();			
		ajaxObj.open("GET", url, true);
		ajaxObj.onreadystatechange=function()
		{
			processResponse(ajaxObj);
		};
		    ajaxObj.send(null);
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
	    	  if(command=="famPenAppMstData")
	    		  {	    		
	    		  	var display=baseResponse.getElementsByTagName("record");	  
	    		  
	    		  	
	    		  	if(display.length <=0)
	    			  {
	    			  	alert('Record Not Found');	
	    			  	clearAllData();		  			  	
	    			  }
	    		  	
	    			if(display.length > 0)
	    		  		{
	    				  for(var i=0;i<display.length;i++)
	    				  {           	  
	    					  
	    					  document.getElementById("penEmpNo").value=nullcheck(baseResponse.getElementsByTagName("empId")[i].firstChild.nodeValue);	  
	    					  document.getElementById("empNo").value=nullcheck(baseResponse.getElementsByTagName("empId")[i].firstChild.nodeValue);	  	    		  

	    					  document.getElementById("empNoLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("empId")[i].firstChild.nodeValue);	    		  
	    					  var pinit=nullcheck(baseResponse.getElementsByTagName("empInit")[i].firstChild.nodeValue);	
	    					  var pname=nullcheck(baseResponse.getElementsByTagName("empName")[i].firstChild.nodeValue); 
	    					 
	    					  
	    					  if(pinit!="" || pinit.length>0)
	    					  {
	    					  		document.getElementById("empName").value=pinit+' '+pname;
	    					  		document.getElementById("empNameLabel").innerHTML=pinit+' '+pname;
	    					  }
	    					  else
	    					  {
	    					  		document.getElementById("empName").value=pname;
	    					  		document.getElementById("empNameLabel").innerHTML=pname;
	    					  }
	    					
	    					  var gen=nullcheck(baseResponse.getElementsByTagName("gender")[i].firstChild.nodeValue);			 
	    					  if(gen=="M")
	    						{
	    						 	document.getElementById("genderM").checked='checked';
	    						 			 
	    						}
	    				       if(gen=="F")
	    				    	{	
	    				    		 document.getElementById("genderF").checked='checked';	    		
	    				    	}
	    					
	    				       var dob=nullcheck(baseResponse.getElementsByTagName("dob")[i].firstChild.nodeValue);
	    				       document.getElementById("dobLabel").innerHTML=dob;
	    				       document.getElementById("dob").value=dob;
	    				 		 
	    				       var doj=nullcheck(baseResponse.getElementsByTagName("doj")[i].firstChild.nodeValue);
	    				       document.getElementById("dojLabel").innerHTML=doj;
	    				       document.getElementById("doj").value=doj;
	    				 	
	    				     
	    				       document.getElementById("designation").innerHTML=nullcheck(baseResponse.getElementsByTagName("desigStr")[i].firstChild.nodeValue);
	    				 	   document.getElementById("desigId").value=nullcheck(baseResponse.getElementsByTagName("desigId")[i].firstChild.nodeValue);
	    				 	   document.getElementById("desigServiceGrp").value=nullcheck(baseResponse.getElementsByTagName("desigSerGrpId")[i].firstChild.nodeValue);
	    				 		 
	    				 	   document.getElementById("grade").value=nullcheck(baseResponse.getElementsByTagName("grade")[i].firstChild.nodeValue);
	    				 	   document.getElementById("gradeLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("grade")[i].firstChild.nodeValue);

	    				 	   document.getElementById("officeId").value=nullcheck(baseResponse.getElementsByTagName("officeId")[i].firstChild.nodeValue);
	    				 	   document.getElementById("office").innerHTML=nullcheck(baseResponse.getElementsByTagName("officeName")[i].firstChild.nodeValue);

	    				  }
	    				  var empno=document.getElementById("penEmpNo").value;
	    				  fetchHeadOfficeData(empno);
	    				  
	    		  		}
	    		  }
	    	  
	    	  else
	    		  {
	    		  
	    		  
	    		  }
	      }
	  }
}


function fetchHeadOfficeData(val1)
{	
	if(val1!="")
	{
		var url="famPenAppHoEditLoadHOData.html?fpenho2.empId="+val1+"&rnd="+new Date().getTime();	
		var ajaxObj=getReq();			
		ajaxObj.open("GET", url, true);
		ajaxObj.onreadystatechange=function()
		{
			processResult(ajaxObj);
		};
		    ajaxObj.send(null);
	}

}

function fetchFieldOfficeData(val)
{
	if(val!="")
		{			
			var url="famPenAppHoEditLoadFieldData.html?fpenho1.empId="+val+"&rnd="+new Date().getTime();					
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
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var command=tagCommand.firstChild.nodeValue;	    	
	    	  if(command=="famPenAppForm2HOData")
		         { 
		    		 loadHOData(baseResponse);  	        	
		         }	
	    	  
	    	  if(command=="famPenAppForm2FieldData")
	    	  { 
	    		  loadFieldData(baseResponse);  	        	
	    	  }	   
	    	
	      }
	  }
	 	
}



function loadHOData(baseResponse)
{		
	  var display=baseResponse.getElementsByTagName("record");	  
	  var empno=document.getElementById("penEmpNo").value;	 
	  if(display.length <=0)
		  {
		  	alert('Record Not Found in Head Office');	 
		  	fetchFieldOfficeData(empno);		  			  	
		  }
	  
	  if(display.length >0)
		  {
		  	loadData(baseResponse);
		  }
	  
}

function loadFieldData(baseResponse)
{
	  var display=baseResponse.getElementsByTagName("record");	
	  if(display.length <=0)
		  {
		  	alert('Record Not Found in Field Office');		  	  			  	
		  }
	  
	  if(display.length>0)
		  {
		  	loadData(baseResponse);
		  }
		  
}


function loadData(baseResponse)
{
	
	
	  var display=baseResponse.getElementsByTagName("record");
	  
	  for(var i=0;i<display.length;i++)
	  {  
	 	 if(nullcheck(baseResponse.getElementsByTagName("religionID")[i].firstChild.nodeValue)!="")
	 	 {
	 		 document.getElementById("religionId").value=baseResponse.getElementsByTagName("religionID")[i].firstChild.nodeValue;
	 	 }
	 	 else
	 	 {
	 		document.getElementById("religionId").selectedIndex=0;
	 	 }
	 	 
	 	 document.getElementById("nationality").value=nullcheck(baseResponse.getElementsByTagName("nation")[i].firstChild.nodeValue);
	 	 document.getElementById("idMark1").value=nullcheck(baseResponse.getElementsByTagName("id1")[i].firstChild.nodeValue);
	 	 document.getElementById("idMark2").value=nullcheck(baseResponse.getElementsByTagName("id2")[i].firstChild.nodeValue);
	 	 document.getElementById("presentAddress").value=nullcheck(baseResponse.getElementsByTagName("presentAddress")[i].firstChild.nodeValue);
	 	 
	 	if(nullcheck(baseResponse.getElementsByTagName("stateId")[i].firstChild.nodeValue)!="")
	 	 {
	 		 document.getElementById("stateId").value=baseResponse.getElementsByTagName("stateId")[i].firstChild.nodeValue;
	 	 }
	 	 else
	 	 {
	 		document.getElementById("stateId").selectedIndex=0;
	 	 }
	 	 
	 	 
	  	if(nullcheck(baseResponse.getElementsByTagName("paymentOfficeId")[i].firstChild.nodeValue)!="")
	 	 {
	 		 document.getElementById("paymentOfficeId").value=baseResponse.getElementsByTagName("paymentOfficeId")[i].firstChild.nodeValue;
	 	 }
	 	 else
	 	 {
	 		document.getElementById("paymentOfficeId").selectedIndex=0;
	 	 }
	 	 
	  		  	
	  	
	  //	alert(baseResponse.getElementsByTagName("guardName")[i].firstChild.nodeValue);
	 	try
	 	{
	 	 document.getElementById("claimentName").value=nullcheck(baseResponse.getElementsByTagName("claimentName")[i].firstChild.nodeValue);
	 	 document.getElementById("claimentDob").value=nullcheck(baseResponse.getElementsByTagName("claimentDob")[i].firstChild.nodeValue);
	 	 document.getElementById("claimentAge").value=nullcheck(baseResponse.getElementsByTagName("claimentAge")[i].firstChild.nodeValue);
	 	 document.getElementById("guardianName").value=nullcheck(baseResponse.getElementsByTagName("guardName")[i].firstChild.nodeValue);
	 	 document.getElementById("guardianDob").value=nullcheck(baseResponse.getElementsByTagName("guardDob")[i].firstChild.nodeValue);
	 	 document.getElementById("guardianRelationMinor").value=nullcheck(baseResponse.getElementsByTagName("guardRelMinor")[i].firstChild.nodeValue);
	 	 document.getElementById("guardianRelationEmp").value=nullcheck(baseResponse.getElementsByTagName("guardRelEmp")[i].firstChild.nodeValue);
	 	 document.getElementById("employeeDeathDate").value=nullcheck(baseResponse.getElementsByTagName("empDeath")[i].firstChild.nodeValue);
	 	 document.getElementById("address").value=nullcheck(baseResponse.getElementsByTagName("address")[i].firstChild.nodeValue);
	 	}
	 	catch(e)
	 	{
	 		
	 	}
	 	 loadNomineeDetails(baseResponse);
	 	
	 	
	 	   
	  }	

}

function loadNomineeDetails(baseResponse)
{

	  var display=baseResponse.getElementsByTagName("NomineeDetails");   
		
	  if(display.length <=0)
		  {
			
		  }
	  
	  for(var i=0;i<display.length;i++)
	  {       	 
			
		 var nomId=nullcheck(baseResponse.getElementsByTagName("nomId")[i].firstChild.nodeValue);	  
		 var nomInit=nullcheck(baseResponse.getElementsByTagName("nomInit")[i].firstChild.nodeValue);	 
		 var nomName=nullcheck(baseResponse.getElementsByTagName("nomName")[i].firstChild.nodeValue);			 
		 var nomRel=nullcheck(baseResponse.getElementsByTagName("relation")[i].firstChild.nodeValue);
		 var nomDob=nullcheck(baseResponse.getElementsByTagName("nomDob")[i].firstChild.nodeValue);		 
		 var nomAge=nullcheck(baseResponse.getElementsByTagName("nomAge")[i].firstChild.nodeValue);
		 var handy=nullcheck(baseResponse.getElementsByTagName("handy")[i].firstChild.nodeValue);
		 var marStatus=nullcheck(baseResponse.getElementsByTagName("martialStatus")[i].firstChild.nodeValue);
		 var nomDate=nullcheck(baseResponse.getElementsByTagName("nomDate")[i].firstChild.nodeValue);
		 var nomStatus=nullcheck(baseResponse.getElementsByTagName("nomStatus")[i].firstChild.nodeValue);
		 var nomAdd=nullcheck(baseResponse.getElementsByTagName("nomAddress")[i].firstChild.nodeValue);
		 setNomineeDetails(nomId,nomInit,nomName,nomRel,nomDob,nomAge,handy,marStatus,nomDate,nomStatus,nomAdd);
	  }

}

function setNomineeDetails(nomId,nomInit,nomName,nomRel,nomDob,nomAge,handy,marStatus,nomDate,nomStatus,nomAdd)
{		
	var tbody = document.getElementById('addNewNominee');
	tbody.align='center';
	var tr = document.createElement('tr');
	tr.id=seq+'r';

	var td9 = document.createElement('td');		
	var rln9 = document.createElement('input');
	rln9.type = 'text';
	rln9.name = 'nomineeInitial';
	rln9.id='nomineeInitial';
	rln9.className="textbox";
	rln9.value=nomInit;
	rln9.size=5;	
	rln9.maxLength=5;
	
	td9.appendChild(rln9);
	tr.appendChild(td9);
	
	
	var td = document.createElement('td');		
	var rln = document.createElement('input');
	rln.type = 'text';
	rln.name = 'familyMembers';
	rln.id='familyMembers';
	rln.className="textbox";
	rln.value=nomName;
	rln.maxLength=50;
	td.appendChild(rln);
	tr.appendChild(td);
	
	
	var td1 = document.createElement('td');
	var cmb = document.createElement('select');
	cmb.name='relation';
	cmb.id='relation';
	
	
	var opt0= document.createElement('option');
	opt0.value ='0';
	opt0.innerHTML ='--Select--';
	cmb.appendChild(opt0);
	
	
	var opt3= document.createElement('option');
	opt3.value ='1';
	opt3.innerHTML ='Father';
	if(nomRel=='1')
	{
		opt3.selected='true';
	}

	cmb.appendChild(opt3);
	
	var opt2 = document.createElement('option');
	opt2.value = '2';
	opt2.innerHTML = 'Mother';
	if(nomRel=='2')
	{
		opt2.selected='true';
	}	
	cmb.appendChild(opt2);
	
	var opt4 = document.createElement('option');
	opt4.value = '3';
	opt4.innerHTML = 'Spouse';
	if(nomRel=='3')
	{
		opt4.selected='true';
	}
	cmb.appendChild(opt4);
	
	
	var opt1 = document.createElement('option');
	opt1.value = '4';
	opt1.innerHTML = 'Son';
	if(nomRel=='4')
	{
		opt1.selected='true';
	}
	cmb.appendChild(opt1);

	var opt6 = document.createElement('option');
	opt6.value = '5';
	opt6.innerHTML = 'Daughter';
	if(nomRel=='5')
	{
		opt6.selected='true';
	}
	
	cmb.appendChild(opt6);
	
	
	td1.appendChild(cmb);
	td1.align="center";
	tr.appendChild(td1);
	
	var td2 = document.createElement('td');
	var dob = document.createElement('input');
	var event='event';
	dob.type = 'text';
	dob.name = 'nomineeDob';
	dob.maxLength=10;
	dob.size=10;
	dob.className="textbox";
	dob.id = 'nomineeDob'; 
	dob.value=nomDob;
	dob.onkeyup = function() {			
		dtval(this,event);
	};
	
	
    td2.appendChild(dob);  
    td2.align="center";
	tr.appendChild(td2);
	//////////////////////////////////////////////////////////////old nomineedate
			

	//////////////////////////////////////////////////////////////old nominee date
	
	var td3 = document.createElement('td');
	var age = document.createElement('input');
	age.type = 'text';
	age.name = 'nomineeAge';
	age.id = 'nomineeAge';
	age.className="textbox";
	age.maxLength=3;
	age.size=3;
	age.value=nomAge;
	age.onchange=function(){
		numchk(this);
	};
	
	td3.appendChild(age);
	td3.align="center";
	tr.appendChild(td3);
	
	////////////////////////////////////////////////////////////////
	
	var td5 = document.createElement('td');
	var cmb8 = document.createElement('select');
	cmb8.name="handicapped";
	cmb8.id="handicapped";
	
	var opt8 = document.createElement('option');
	opt8.value = 'Y';
	opt8.innerHTML = 'Yes';
	if(handy=='Y')
		{
		opt8.selected='true';
		}
	cmb8.appendChild(opt8);
	
	var opt9= document.createElement('option');
	opt9.value = 'N';
	opt9.innerHTML ='No';
	if(handy=='N')
	{
	opt9.selected='true';

	}
	opt9.selected='selected';
	
	cmb8.appendChild(opt9);
	td5.appendChild(cmb8);
	td5.align="center";
	tr.appendChild(td5);
	
	
	var td4 = document.createElement('td');
	var cmb1 = document.createElement('Select');
	cmb1.name="martialStatus";
	cmb1.id="martialStatus";
	
	var opt1 = document.createElement('option');
	opt1.value = 'Married';
	opt1.innerHTML = 'Married';
	if(marStatus=='Married')
	{
		opt1.selected='true';
	}
	cmb1.appendChild(opt1);

	var opt2 = document.createElement('option');
	opt2.value = 'Unmarried';
	opt2.innerHTML = 'Unmarried';
	if(marStatus=='Unmarried')
	{
		opt2.selected='true';
	}
	cmb1.appendChild(opt2);
	
	
	td4.appendChild(cmb1);
	td4.align="center";
	tr.appendChild(td4);
	
	
	var td10 = document.createElement('td');
	var nomineeDate = document.createElement('input');
	var event='event';
	nomineeDate.type = 'text';
	nomineeDate.name = 'nominationDate';
	nomineeDate.className="textbox";
	nomineeDate.maxLength=10;		
	nomineeDate.size=10;
	nomineeDate.value=nomDate;
	nomineeDate.id = 'nominationDate'; 	
	nomineeDate.onkeyup= function() {
		dtval(this,event);
		}; 	
	td10.appendChild(nomineeDate);  
	td10.align="center";
	tr.appendChild(td10);
	
	
	
	var td12 = document.createElement('td');
	var cmb12 = document.createElement('select');
	cmb12.name="activeStatus";
	cmb12.id="activeStatus";
	
	var opt20 = document.createElement('option');
	opt20.value = 'Y';
	opt20.innerHTML = 'Yes';	
	if(nomStatus=='Y')
	{		
		opt20.selected='true';
	}		
	cmb12.appendChild(opt20);
	
	var opt21= document.createElement('option');
	opt21.value = 'N';
	opt21.innerHTML ='No';	
	if(nomStatus=='N')
	{
		opt21.selected='true';
	}
	cmb12.appendChild(opt21);
	td12.appendChild(cmb12);
	td12.align="center";
	tr.appendChild(td12);
	
	
	
	var td11 = document.createElement('td');
	var nomAddress = document.createElement('textarea');	
	nomAddress.name = 'address';		
	nomAddress.id = 'address'; 	
	//nomAddress.style="border:#ffba14 1.5px solid"; 
	nomAddress.value=nomAdd;
	nomAddress.className="textbox";
	td11.appendChild(nomAddress);  
	td11.align="center";
	tr.appendChild(td11);
	
	
	
	var image2 = document.createElement('img');
	image2.src="../images/delete.png";
	image2.align="center";
	image2.border="0";
	image2.align="center";
	var td6=document.createElement("td");
    var anc=document.createElement("A");
    var url="javascript:DeleteGrid1('" +seq+"r')";              
    anc.href = url;
    anc.appendChild(image2);
    td6.appendChild(anc);
    td6.align="center";
    tr.appendChild(td6);
    
	tbody.appendChild(tr);

	
	seq++;
}


function DeleteGrid1(seq)
{		
	var opt=confirm("Are you sure want to delete ?");
	if(opt)
		{
			var tbody=document.getElementById("addNewNominee");
			var r=document.getElementById(seq);
			var ri=r.rowIndex;    
			tbody.deleteRow(ri-1);	
		}
	else
		{
		
		}
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


function clearAllData()
{
	document.getElementById("penEmpNo").value="";
	document.getElementById("empNo").value="";
	document.getElementById("empNoLabel").innerHTML="";
	document.getElementById("empName").value="";
	document.getElementById("empNameLabel").innerHTML="";
	document.getElementById("genderM").checked=true;
	document.getElementById("hiddengender").value="";
	document.getElementById("dobLabel").innerHTML="";
	document.getElementById("dob").value="";
	document.getElementById("dojLabel").innerHTML="";
	document.getElementById("doj").value="";
	document.getElementById("designation").innerHTML="";
	document.getElementById("desigId").value="";
	document.getElementById("desigServiceGrp").value="";
	document.getElementById("gradeLabel").innerHTML="";
	document.getElementById("grade").value="";
	document.getElementById("office").innerHTML="";
	document.getElementById("officeId").value="";
	document.getElementById("religionId").selectedIndex=0;
	document.getElementById("nationality").value="";
	document.getElementById("idMark1").value="";
	document.getElementById("idMark2").value="";
	document.getElementById("presentAddress").value="";
	document.getElementById("stateId").selectedIndex=0;
	document.getElementById("paymentOfficeId").selectedIndex=0;
	document.getElementById("claimentName").value="";
	document.getElementById("claimentDob").value="";
	document.getElementById("claimentAge").value="";
	document.getElementById("guardianName").value="";
	document.getElementById("guardianDob").value="";
	document.getElementById("guardianRelationMinor").value="";
	document.getElementById("guardianRelationEmp").value="";
	document.getElementById("employeeDeathDate").value="";
	document.getElementById("address").value="";

	clearNomineeGrid();
}


function clearNomineeGrid()
{	
	tbodyvar=document.getElementById("addNewNominee");
		if(tbodyvar.rows.length>=0)
		{
			while (tbodyvar.rows.length > 0) 
				{
					tbodyvar.deleteRow(0);
				}
		}	   
}
