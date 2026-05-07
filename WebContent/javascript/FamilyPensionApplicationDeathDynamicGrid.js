var seq =0;

String.prototype.trim = function() {
        a = this.replace(/^\s+/, '');
        return a.replace(/\s+$/, '');
        };
        
function addDcrgNomineeGrid()
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
	cmb.appendChild(opt3);
	
	var opt2 = document.createElement('option');
	opt2.value = '2';
	opt2.innerHTML = 'Mother';
	cmb.appendChild(opt2);
	
	var opt4 = document.createElement('option');
	opt4.value = '3';
	opt4.innerHTML = 'Spouse';
	cmb.appendChild(opt4);
	
	var opt1 = document.createElement('option');
	opt1.value = '4';
	opt1.innerHTML = 'Son';
	cmb.appendChild(opt1);

	var opt6 = document.createElement('option');
	opt6.value = '5';
	opt6.innerHTML = 'Daughter';
	cmb.appendChild(opt6);
	
	
	td1.appendChild(cmb);
	td1.align="center";
	tr.appendChild(td1);
	
	var td2 = document.createElement('td');
	var dob = document.createElement('input');
	var event='event';
	dob.type = 'text';
	dob.name = 'nomineeDob';
	dob.className="textbox";
	dob.maxLength=10;
	dob.size=10;
	dob.id = 'nomineeDob'; 	
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
	age.maxLength=3;
	age.className="textbox";
	age.size=3;
	
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
	var opt8 = document.createElement('option');
	opt8.value = 'Y';
	opt8.innerHTML = 'Yes';
	cmb8.appendChild(opt8);
	
	var opt9= document.createElement('option');
	opt9.value = 'N';
	opt9.innerHTML ='No';
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
	cmb1.appendChild(opt1);

	var opt2 = document.createElement('option');
	opt2.value = 'Unmarried';
	opt2.innerHTML = 'Unmarried';
	cmb1.appendChild(opt2);
	
	
	td4.appendChild(cmb1);
	td4.align="center";
	tr.appendChild(td4);
	
	
	var td10 = document.createElement('td');
	var nomineeDate = document.createElement('input');
	var event='event';
	nomineeDate.type = 'text';
	nomineeDate.name = 'nominationDate';
	nomineeDate.maxLength=10;		
	nomineeDate.size=10;
	nomineeDate.id = 'nominationDate'; 	
	nomineeDate.className="textbox";
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
	opt20.selected='selected';
	cmb12.appendChild(opt20);
	
	var opt21= document.createElement('option');
	opt21.value = 'N';
	opt21.innerHTML ='No';
	
	
	cmb12.appendChild(opt21);
	td12.appendChild(cmb12);
	td12.align="center";
	tr.appendChild(td12);
	
	
	
	var td11 = document.createElement('td');
	var nomAddress = document.createElement('textarea');	
	nomAddress.name = 'address';		
	nomAddress.id = 'address';	
	nomAddress.rows=2;
	nomAddress.cols=16;
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
    var url="javascript:Delete('" +seq+ "r')";              
    anc.href = url;
    anc.appendChild(image2);
    td6.appendChild(anc);
    td6.align="center";
    tr.appendChild(td6);
    
	tbody.appendChild(tr);

	seq++;

}




function Delete(seq)
{	
	var opt=confirm("Are you sure want to delete ?");
	if(opt)
		{
			var tbody=document.getElementById("addNewNominee");
			var r=document.getElementById(seq);
			var ri=r.rowIndex;   
			tbody.deleteRow(ri);	
		}
	else
		{
		
		}
    	

}



function CheckSubmit()
{

	try
	{
	
    var flag=true;
          
    var colorBug="#F78181";
    var colorOk="#FFFFFF";
    var str="Nominee Details\n";
    var row=0;
    
    var relFlag=false;
    var nomDate=false;
    
    var tmpFlg1=false;
    
    for(var i=0;i<document.forms[0].elements.length;i++)
	{
    	
    	
	if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="familyMembers")
		{			
		row++;
		var familyMembers=document.forms[0].elements[i];
		 if(familyMembers.value.trim().length==0)
          {
         familyMembers.style.background=colorBug;
           str+="Row-"+row+"."+" Family Member should not be leave Empty!\n";
           flag=false;
           }
       else if(!isAlpha(familyMembers.value.trim()))
           {
           familyMembers.style.background=colorBug;
           str+="Row-"+row+"."+" Family Member should Contain only Alphas!\n";
           flag=false;
           }
       else
           {
           familyMembers.style.background=colorOk;
           }
		 
		}
	
	
	if(document.forms[0].elements[i].type=="select-one" && document.forms[0].elements[i].id=="relation")
		{
		var relation=document.forms[0].elements[i];
		if(parseInt(relation.value)==0)
			{
			relation.style.background=colorBug;
			str+="Row-"+row+"."+" Please select a valid relation!\n";
			flag=false;
			}
		else if(parseInt(relation.value) > 3 ) //This checking for 'Dob Mandatory if relation is son or daughter'
          {
              tmpFlg1=true;
          }
		else
		{
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
				flag=false;
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
        				flag=false;
        			}
        
        		else if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
        			{
        				dobStr.style.background=colorBug;
        				str+="Row-"+row+"."+" Date of birth should not be Future date!\n";
        				flag=false;
        				//dobStr.style.background=colorOk;
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
           flag=false;
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
  					flag=false;
  				}

  			else if(isFutureDate(datesSep[0],datesSep[1],datesSep[2]))
  				{
  					dobStr.style.background=colorBug;
  					str+="Row-"+row+"."+" Nomination Date should not be Future date!\n";
  					flag=false;
  					//dobStr.style.background=colorOk;
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
      	flag=false;
     
  	}
	}
	
	
	if(document.forms[0].elements[i].type=="text" && document.forms[0].elements[i].id=="nomineeAge")
	{
	var age=document.forms[0].elements[i];
	 if(!(age.value >= 0))
     	{
     		age.style.background=colorBug;
     		str+="Row-"+row+"."+" Age is not valid!\n";
     		flag=false;
     	}
 
     else if(relFlag && age.value.trim().length==0) //This checking for 'Dob Mandatory if relation is son or daughter'
     	{
     		//age.style.background=colorBug;
         	str+="Row-"+row+"."+"Age or Date of birth should be filled  for this relation!\n";
         	flag=false;	                               
     	}
     
     else
     {
         age.style.background=colorOk;
     }
	}
	
	
	}
    
          if(!flag)
                {
                alert(str);
                
                }
      
         return flag;
         
	}
	catch(e)
	{
		alert(e.message);
	}
}

function isAlpha(checkString) {
    var tempString="";
    var regExp = /^[A-Z. a-z]$/;
    if(checkString != null && checkString != "")
    {
      for(var i = 0; i < checkString.length; i++)
      {
        if (!checkString.charAt(i).match(regExp))
        {
          return false;
        }
      }
    }
    else
    {
      return false;
    }
    return true;
}


function dtval(d,e) 
{
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