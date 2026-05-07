//alert("onload");
var seq =1;

String.prototype.trim = function() {
    a = this.replace(/^\s+/, '');
    return a.replace(/\s+$/, '');
    };

function getTransportWth()
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


function checkAvailForm1(empId2)
{
	var empId=empId2.trim();	

	if(empId!="" && empId.length>0)
		{
		var url="penAppChkForm1Available.html?chkavail.empId="+empId+"&rnd="+new Date().getTime();		
		var req2=getTransportWth();	    
		req2.open("GET",url,true);        
	    req2.onreadystatechange=function()
	       {
	         checkAvail1(req2);	    
	       };   
	        req2.send(null);
	     }		

}


function checkAvail1(req2)
{
	if(req2.readyState==4)
	  {
	      if(req2.status==200)
	      {  
	    	  
	    	  var baseResponse=req2.responseXML.getElementsByTagName("response")[0];	    	  	    	  
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var display=baseResponse.getElementsByTagName("record");   
	    	//alert("display----->"+display.length);
	    	  if(display.length >0)
	    		  {
	    		var empId=document.getElementById("empId").value;
	    	
	    		  fetchMstData(empId);
	    		  }
	    	  else
	    		  {
	    		  	alert('Please Enter Pension Application Form 1 Data');
	    		  	clearForm();
	    		  }

	      	}
	  }

}




function fetchMstData(objValue)
{
	var empId=objValue.trim();		
	if(empId!="" && empId.length>0)
		{
		var url="penAppFetchMstdata.html?penAppComm.empId="+empId+"&rnd="+new Date().getTime();
		var req=getTransportWth();	    
		req.open("GET",url,true);        
	    req.onreadystatechange=function()
	       {
	           penAppProcessResponse(req);
	       };   
	        req.send(null);
	     }		
	
	 
}


function penAppProcessResponse(req)
{
	 if(req.readyState==4)
	  {
	      if(req.status==200)
	      {  
	    	 
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];	    	  	    	  
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var display=baseResponse.getElementsByTagName("record");   
	    	
	    	  if(display.length <=0)
	    		  {
	    		  	alert('Record Not Found');	 
	    		  	clearForm();
	    		  }
	    	  
	    	
	    	  for(var i=0;i<display.length;i++)
	    	  {           

	    		  
	    		  document.getElementById("empNo").value=nullcheck(baseResponse.getElementsByTagName("empid")[i].firstChild.nodeValue);	  	    		  
	    		  alert("record exists"+nullcheck(baseResponse.getElementsByTagName("empid")[i].firstChild.nodeValue));  
	    		  document.getElementById("empNoLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("empid")[i].firstChild.nodeValue);	    		  
	    		  var pinit=nullcheck(baseResponse.getElementsByTagName("empinit")[i].firstChild.nodeValue);	
	    		  var pname=nullcheck(baseResponse.getElementsByTagName("empname")[i].firstChild.nodeValue); 
	    		  document.getElementById("gpfNo").value= nullcheck(baseResponse.getElementsByTagName("gpfno")[i].firstChild.nodeValue);
	    		  document.getElementById("gpfNoLabel").innerHTML= nullcheck(baseResponse.getElementsByTagName("gpfno")[i].firstChild.nodeValue);
	    			
	    		  var gen=nullcheck(baseResponse.getElementsByTagName("gender")[i].firstChild.nodeValue);	    		
	    		  document.getElementById("hiddengender").value=gen;	    	   
	    		  
	    		  if(gen=="M")
	    			{
	    			 	document.getElementById("genderM").checked='checked';
	    			 	document.getElementById("husbandName").readOnly=true;   			 
	    			}
	    	       if(gen=="F")
	    	    	{	
	    	    		 document.getElementById("genderF").checked='checked';
	    	    		 document.getElementById("husbandName").readOnly=false;
	    	    		 document.getElementById("fatherName").readOnly=false;
	    	    	}
	    		
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
	    		  
	    		  document.getElementById("office").innerHTML=nullcheck(baseResponse.getElementsByTagName("officename")[i].firstChild.nodeValue);
	    		  
	    		  document.getElementById("designation").innerHTML=nullcheck(baseResponse.getElementsByTagName("designation")[i].firstChild.nodeValue);
	    		  document.getElementById("officeId").value=nullcheck(baseResponse.getElementsByTagName("officeid")[i].firstChild.nodeValue);
	    		  document.getElementById("desigId").value=nullcheck(baseResponse.getElementsByTagName("desigid")[i].firstChild.nodeValue);
	    		  document.getElementById("desigServiceGrp").value=nullcheck(baseResponse.getElementsByTagName("desigservgrp")[i].firstChild.nodeValue);
	    		  
	    		  document.getElementById("grade").value=nullcheck(baseResponse.getElementsByTagName("grade")[i].firstChild.nodeValue);
	    		  document.getElementById("gradeLabel").innerHTML=nullcheck(baseResponse.getElementsByTagName("grade")[i].firstChild.nodeValue);

	    			  
	    		  checkAvailable(nullcheck(baseResponse.getElementsByTagName("empid")[i].firstChild.nodeValue));
		    	  
	    	  	}
	      }
	  }
}
	
function checkAvailable(empId1)
{
	
	var empId=empId1.trim();	
	if(empId!="" && empId.length>0)
		{
		var url="penAppChkAvailable.html?chkavail.empId="+empId+"&rnd="+new Date().getTime();
		var req=getTransportWth();	    
		req.open("GET",url,true);        
	    req.onreadystatechange=function()
	       {
	         checkAvail(req);	    
	       };   
	        req.send(null);
	     }		
}


function checkAvail(req)
{
	
	if(req.readyState==4)
	  {
	      if(req.status==200)
	      {  
	    	  
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];	    	  	    	  
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var display=baseResponse.getElementsByTagName("record");   
	    	//  alert("---------------->"+display.length);
	    	 if(display.length <=0)
	    		  {
	    		
	    		  	loadIndividualData();
	    		  }
	    	  else
	    		  {
	    		  	alert('Record Already Validated.');
	    		  	clearForm();
	    		  }

	      	}
	  }
}




function loadIndividualData()
{
	var empNo=document.getElementById("empId").value;	
	if(empNo!="" && empNo.length>0)
	{
		var url="loadIndividualDataForFieldOffice.html?loadindi.empId="+empNo+"&rnd="+new Date().getTime();
		var req1=getTransportWth();	    
		req1.open("GET",url,true);        
	    req1.onreadystatechange=function()
	       {
	         loadIndividualRecords(req1);	    
	       };   
	        req1.send(null);
     }		

	
}


function loadIndividualRecords(req1)
{
	
	if(req1.readyState==4)
	  {
	      if(req1.status==200)
	      {  
	    	  
	    	  var baseResponse=req1.responseXML.getElementsByTagName("response")[0];	    	  	    	  
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var display=baseResponse.getElementsByTagName("commondata");   
	    	  
	    	  if(display.length <=0)
	    		  {   	    	
	    		  	clearOthers();	    		  
	    		  }
	    	  else
	    		  {	    	
	    		  alert("data");
	    		  document.getElementById("fatherName").value=nullcheck(baseResponse.getElementsByTagName("fatherName")[0].firstChild.nodeValue);
	    		  document.getElementById("husbandName").value=nullcheck(baseResponse.getElementsByTagName("husbandName")[0].firstChild.nodeValue);
	    		  
	    		  document.getElementById("religion").value=nullcheck(baseResponse.getElementsByTagName("religion")[0].firstChild.nodeValue);
	    		  document.getElementById("nationality").value=nullcheck(baseResponse.getElementsByTagName("nationality")[0].firstChild.nodeValue);
	    		  document.getElementById("empHeight").value=nullcheck(baseResponse.getElementsByTagName("empHeight")[0].firstChild.nodeValue);
	    		  document.getElementById("idMark1").value=nullcheck(baseResponse.getElementsByTagName("id1")[0].firstChild.nodeValue);
	    		  document.getElementById("idMark2").value=nullcheck(baseResponse.getElementsByTagName("id2")[0].firstChild.nodeValue);
	    		  document.getElementById("presentAddress").value=nullcheck(baseResponse.getElementsByTagName("presentAddress")[0].firstChild.nodeValue);
	    		  document.getElementById("permanentAddress").value=nullcheck(baseResponse.getElementsByTagName("permanentAddress")[0].firstChild.nodeValue);
	    		  document.getElementById("addressAfterRetire").value=nullcheck(baseResponse.getElementsByTagName("addressAfterRetire")[0].firstChild.nodeValue);
	    		  document.getElementById("stateId").value=nullcheck(baseResponse.getElementsByTagName("state")[0].firstChild.nodeValue);
	    		  //alert(baseResponse.getElementsByTagName("state")[0].firstChild.nodeValue);
	    		  
	    		  var chFlag=nullcheck(baseResponse.getElementsByTagName("chargeFlag")[0].firstChild.nodeValue);
	    		  if(chFlag=='Yes')
	    		  {
	    			  document.getElementById("chargesFlagYes").checked=true;
	    		  }
	    		  else
	    		  {
	    			  document.getElementById("chargesFlagNo").checked=true;
	    		  }	    			  
	    				  
	    		  document.getElementById("chargeDetails").value=nullcheck(baseResponse.getElementsByTagName("chargeDesc")[0].firstChild.nodeValue);
	    		  document.getElementById("pensionPayOfficeId").value=nullcheck(baseResponse.getElementsByTagName("payOffice")[0].firstChild.nodeValue);
	    		  document.getElementById("appliedDate").value=nullcheck(baseResponse.getElementsByTagName("appDate")[0].firstChild.nodeValue);
	    		  document.getElementById("dcrgNomineeName").value=nullcheck(baseResponse.getElementsByTagName("dcrgNominName")[0].firstChild.nodeValue);
	    		  document.getElementById("dcrgNomineeDob").value=nullcheck(baseResponse.getElementsByTagName("dcrgNomineeDob")[0].firstChild.nodeValue);
	    		  document.getElementById("dcrgRelation").value=nullcheck(baseResponse.getElementsByTagName("dcrgNomineeRelation")[0].firstChild.nodeValue);
	    		  document.getElementById("dcrgAddress").value=nullcheck(baseResponse.getElementsByTagName("dcrgNomineeAddress")[0].firstChild.nodeValue);
	    		  document.getElementById("notVerifyServiceTotYears").value=nullcheck(baseResponse.getElementsByTagName("notVerTotYear")[0].firstChild.nodeValue);
	    		  document.getElementById("notVerifyServiceTotMonths").value=nullcheck(baseResponse.getElementsByTagName("notVerTotMonth")[0].firstChild.nodeValue);	    		  
	    		  document.getElementById("notVerifyServiceTotDays").value=nullcheck(baseResponse.getElementsByTagName("notVerTotDays")[0].firstChild.nodeValue);
	    		 	  

	    		  var display2=baseResponse.getElementsByTagName("nomindata");   
		    	  
		    	  if(display2.length <=0)
		    		  {	
		    		  
		    		  }
		    	  else
		    		  {
	    		  var nomId =nullcheck(baseResponse.getElementsByTagName("nominId")[0].firstChild.nodeValue);
	    		  var nomIntial=nullcheck(baseResponse.getElementsByTagName("nominInitial")[0].firstChild.nodeValue);
	    		  var nomName=nullcheck(baseResponse.getElementsByTagName("nominName")[0].firstChild.nodeValue);
	    		  var nomRel=nullcheck(baseResponse.getElementsByTagName("nominRelation")[0].firstChild.nodeValue);
	    		  var nomDob=nullcheck(baseResponse.getElementsByTagName("nominDob")[0].firstChild.nodeValue);
	    		  var nomAge=nullcheck(baseResponse.getElementsByTagName("nominAge")[0].firstChild.nodeValue);
	    		  var nomHandy=nullcheck(baseResponse.getElementsByTagName("nominHandy")[0].firstChild.nodeValue);
	    		  var nomMartial=nullcheck(baseResponse.getElementsByTagName("nominMartial")[0].firstChild.nodeValue);
	    		  var nomDate=nullcheck(baseResponse.getElementsByTagName("nominDate")[0].firstChild.nodeValue);
	    		  var nomStat=nullcheck(baseResponse.getElementsByTagName("nominStatus")[0].firstChild.nodeValue);
	    		  var nomReason=nullcheck(baseResponse.getElementsByTagName("nominReason")[0].firstChild.nodeValue);

	    		  loadNomineefrmXML(nomId,nomIntial,nomName,nomRel,nomDob,nomAge,nomHandy,nomMartial,nomDate,nomStat,nomReason);

		    		  }
		    	  
		    	 
	    		  var display3=baseResponse.getElementsByTagName("servicedata");   
		    	  
		    	  if(display3.length <=0)
		    		  {	
		    		  
		    		  }
		    	  else
		    		  {
	    		  var stDate =nullcheck(baseResponse.getElementsByTagName("startDate")[0].firstChild.nodeValue);
	    		  var endDate=nullcheck(baseResponse.getElementsByTagName("endDate")[0].firstChild.nodeValue);
	    		  var reason=nullcheck(baseResponse.getElementsByTagName("reason")[0].firstChild.nodeValue);
	    		  var totYear=nullcheck(baseResponse.getElementsByTagName("totYear")[0].firstChild.nodeValue);
	    		  var totMonth=nullcheck(baseResponse.getElementsByTagName("totMonth")[0].firstChild.nodeValue);
	    		  var totDays=nullcheck(baseResponse.getElementsByTagName("totDays")[0].firstChild.nodeValue);
	    		 
	    		  loadServicefrmXML(stDate,endDate,reason,totYear,totMonth,totDays);

	    		  


	    		
	    		  
		    		  }
		    	  
	    		  
	    		  }
}
	  }
}


//function loadNomineefrmXML(fMbr,NiTl,rltn,doB,Nid,agE,Hcpd,MrSts,Ndate,DreasoN)
function loadNomineefrmXML(nomId,nomIntial,nomName,nomRel,nomDob,nomAge,nomHandy,nomMartial,nomDate,nomStat,nomReason)
{
	//alert("test-"+nomName);
	var tbody1=document.getElementById("addNewNominee");	
	var tabletr=document.createElement("tr");	
	tabletr.id=seq+'r';
	
	var tabletd12=document.createElement("td");
	var initial=document.createElement("input");
	initial.name="nomineeInitial";
	initial.id="nomineeInitial";
	initial.type = 'text';
	initial.maxLength=5;
	initial.value=nomIntial;
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
	familyMembers.value=nomName;
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
	if(parseInt(nomRel)==1)
	{
	opt1.selected="selected";
	}
	
	var opt2 = document.createElement('option');
	opt2.value = '2';
	opt2.innerHTML = 'Mother';
	combo1.appendChild(opt2);
	if(parseInt(nomRel)==2)
	{
	opt2.selected="selected";
	}
	
	var opt3 = document.createElement('option');
	opt3.value = '3';
	opt3.innerHTML = 'Spouse';
	combo1.appendChild(opt3);
	if(parseInt(nomRel)==3)
	{
	opt3.selected="selected";
	}
	
	var opt4 = document.createElement('option');
	opt4.value = '4';
	opt4.innerHTML = 'Son';
	combo1.appendChild(opt4);
	if(parseInt(nomRel)==4)
	{
	opt4.selected="selected";
	}
	
	var opt5 = document.createElement('option');
	opt5.value = '5';
	opt5.innerHTML = 'Daughter';
	combo1.appendChild(opt5);
	if(parseInt(nomRel)==5)
	{
	opt5.selected="selected";
	}
	
	tabletd2.appendChild(combo1);
	tabletd2.align="center";	
	tabletr.appendChild(tabletd2);
	
    /////////////////Nominee DOB/////////////////nomDob,nomAge,nomHandy,nomMartial,nomDate,nomStat,nomReason
	
	var tabletd3=document.createElement("td");
	var dob=document.createElement("input");
	dob.type="text";
	dob.name="nomineeDob";
	dob.id="nomineeDob";
	dob.value=nomDob;
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
	nominAge.value=nomAge;
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
	if(nomHandy=='Y')
	{
		opt7.selected="selected";
	}
	
	var opt8= document.createElement('option');
	opt8.value = 'N';
	opt8.innerHTML ='No';
	opt8.selected='selected';	
	combo2.appendChild(opt8);
	if(nomHandy=='N')
	{
		opt8.selected="selected";
	}
	
	
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
	if(nomMartial=='Married')
	{
		opt11.selected="selected";
	}
	
	
	var opt12 = document.createElement('option');
	opt12.value = 'Unmarried';
	opt12.innerHTML = 'Unmarried';
	combo3.appendChild(opt12);
	if(nomMartial=='Unmarried')
	{
		opt12.selected="selected";
	}
	
	
	
	tabletd5.appendChild(combo3);
	tabletd5.align="center";
	tabletr.appendChild(tabletd5);
	
	
	
///////////////Nomination date/////////////////
	
	var tabletd9=document.createElement("td");
	var nominDate=document.createElement("input");
	nominDate.name="nominationDate";
	nominDate.id="nominationDate";
	nominDate.value=nomDate;
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
	if(nomStat=='Yes')
	{
		opt11.selected="selected";
	}
	
	var opt12 = document.createElement('option');
	opt12.value = 'No';
	opt12.innerHTML = 'No';
	combo4.appendChild(opt12);	
	if(nomStat=='No')
	{
		opt12.selected="selected";
	}
	
	tabletd6.appendChild(combo4);
	tabletd6.align="center";
	tabletr.appendChild(tabletd6);
	
    ///////////////Reason/////////////////
	
	var tabletd7=document.createElement("td");
	var nominReason=document.createElement("input");
	nominReason.name="nominReason";
	nominReason.id="nominReason";
	nominReason.type = 'text';	
	nominReason.value=nomReason;
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


function loadServicefrmXML(stDate,endDate,reason,totYear,totMonth,totDays)
{
	var tbody2=document.getElementById("notVerifyService");
	
	
	if(tbody2.rows.length==0)
	{

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
	text1.value=stDate;
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
	text2.value=endDate;
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
	//reason,totYear,totMonth,totDays
	var tabletd3=document.createElement("td");
	var text3=document.createElement("input");
	text3.name="notVerifyServiceReason";
	text3.id="notVerifyServiceReason";	
	text3.value=reason;
	text3.className="textbox";
	tabletd3.align="center";
	tabletd3.appendChild(text3);	
	tablerow.appendChild(tabletd3);
	
	var tabletd4=document.createElement("td");
	var text4=document.createElement("input");
	text4.name="notVerifyYear";
	text4.id="notVerifyYear";
	text4.type="text";
	text4.value=totYear;
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
	text5.value=totMonth;
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
	text6.value=totDays;
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



function clearReadOnly()
{
	
	document.getElementById("empId").value="";
  	document.getElementById("empNo").value="";
  	document.getElementById("empName").value="";
  	document.getElementById("designation").value="";
  	document.getElementById("grade").value="";	
  	document.getElementById("office").value="";
  	document.getElementById("gpfNo").value="";
  	document.getElementById("empNoLabel").innerHTML="";
  	document.getElementById("empNameLabel").innerHTML="";
  	document.getElementById("hiddengender").innerHTML="";
  	document.getElementById("designation").innerHTML="";
  	document.getElementById("gradeLabel").innerHTML="";
  	document.getElementById("gpfNoLabel").innerHTML="";
}

	     
function clearOthers()
{	
	document.getElementById("religion").selectedIndex=0;
  	document.getElementById("nationality").value="";
  	document.getElementById("empHeight").value="";
  	document.getElementById("idMark1").value="";
  	document.getElementById("idMark2").value="";
  	document.getElementById("presentAddress").value="";
  	document.getElementById("permanentAddress").value="";
  	
  	document.getElementById("addressAfterRetire").value="";
  	document.getElementById("chargeDetails").value="";
  	 document.getElementById("appliedDate").value="";
  	document.getElementById("dcrgNomineeName").value="";
  	document.getElementById("dcrgNomineeDob").value="";
  	document.getElementById("dcrgRelation").value="";
  	document.getElementById("dcrgAddress").value="";
  	document.getElementById("notVerifyServiceTotYears").value="";
  	document.getElementById("notVerifyServiceTotMonths").value="";
  	document.getElementById("notVerifyServiceTotDays").value="";
  	
  	//document.getElementById("hiddengender").value="";
  	//document.getElementById("desigServiceGrp").value="";
  	//document.getElementById("officeId").value="";

  	//document.getElementById("husbandNameLabel").style.display="none";
   	//document.getElementById("husbandNameText").style.display="none";
   	document.getElementById("fatherName").value="";
   	document.getElementById("husbandName").value="";
   	
  	document.getElementById("stateId").selectedIndex=0;
  	document.getElementById("pensionPayOfficeId").selectedIndex=0;	
}

function clearForm()
{
	      	
  	document.getElementById("empId").value="";
  	document.getElementById("empNo").value="";
  	document.getElementById("empName").value="";
  	document.getElementById("designation").value="";
  	document.getElementById("grade").value="";	
  	document.getElementById("office").value="";
  	document.getElementById("gpfNo").value="";
  	document.getElementById("religion").selectedIndex=0;
  	document.getElementById("nationality").value="";
  	document.getElementById("empHeight").value="";
  	document.getElementById("idMark1").value="";
  	document.getElementById("idMark2").value="";
  	document.getElementById("presentAddress").value="";
	document.getElementById("permanentAddress").value="";
  	document.getElementById("addressAfterRetire").value="";
  	document.getElementById("chargeDetails").value="";
  	 document.getElementById("appliedDate").value="";
  	document.getElementById("dcrgNomineeName").value="";
  	document.getElementById("dcrgNomineeDob").value="";
  	document.getElementById("dcrgRelation").value="";
  	document.getElementById("dcrgAddress").value="";
  	document.getElementById("notVerifyServiceTotYears").value="";
  	document.getElementById("notVerifyServiceTotMonths").value="";
  	document.getElementById("notVerifyServiceTotDays").value="";
  	
  	document.getElementById("hiddengender").value="";
  	document.getElementById("desigServiceGrp").value="";
  	document.getElementById("officeId").value="";

  	document.getElementById("stateId").selectedIndex=0;
  	document.getElementById("pensionPayOfficeId").selectedIndex=0;	
  	
  	document.getElementById("empNoLabel").innerHTML="";
  	document.getElementById("empNameLabel").innerHTML="";
  	document.getElementById("designation").innerHTML="";
  	document.getElementById("gradeLabel").innerHTML="";
  	document.getElementById("gpfNoLabel").innerHTML="";
  	document.getElementById("office").innerHTML="";
  	
  	
  	clearNomineeGrid();
  	clearServiceGrid();
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

function clearServiceGrid()
{
	tbodyvar=document.getElementById("notVerifyService");
		if(tbodyvar.rows.length>=0)
			{
				while (tbodyvar.rows.length > 0) 
				{
					tbodyvar.deleteRow(0);
				}
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


function freezcheck()
{

	var empId=document.getElementById("empNo").value;
	var url="penAppFreezeCheck.html?chkavail.empId="+empId;
//	alert(url);
	var req2=getTransportWth();	    
	req2.open("GET",url,true);        
    req2.onreadystatechange=function()
       {
    	checkreturns(req2);	    
       };   
        req2.send(null);
     }

function checkreturns(req2)
{
	if(req2.readyState==4)
	  {
	      if(req2.status==200)
	      {  
	    	  var frzchkId,frzchkName;
	    	  var baseResponse=req2.responseXML.getElementsByTagName("response")[0];	    	  	    	  
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var display=baseResponse.getElementsByTagName("record");   
	    	

	    	for(var i=0;i<display.length;i++)
	    	  {           
	    		   frzchkId=nullcheck(baseResponse.getElementsByTagName("empid")[i].firstChild.nodeValue);	  	    		  
	    		   frzchkName=nullcheck(baseResponse.getElementsByTagName("empname")[i].firstChild.nodeValue);	    		  
	    		 
	    	  	}
	    	// var frzchkName =null
	    	if( frzchkName ==null || frzchkName ==""){
	    		alert("Data not exists");
	    		
	    		let x = document.querySelector("#addNewNominee").getElementsByTagName("td")
	    		Array.from(x).forEach(i => {
	    			i.children[0].disabled = false
	    		})
	    		
	    		document.querySelector(".demo").querySelectorAll("textarea,select,textfield,input").forEach(i => i.disabled = false)
	    		
	    		    
	    	}
	    	else {
	    		alert("Data have already been Validated11");
	    		document.querySelector(".demo").querySelectorAll("textarea,select,textfield,input").forEach(i => i.disabled = true)
	    		
	    		document.querySelectorAll("#cal-button-10,#cal-button-4").forEach(i => {i.style.display = "none"})
	    		document.getElementById("freezebtn").disabled=true;
	    		
	    		
	    	}
	      	}
	  }
}
