
var my_window;
window.onunload=function()
{
if (my_window && my_window.open && !my_window.closed) my_window.close();
}

 function popwindow()
    {
        
        if (my_window && my_window.open && !my_window.closed) 
        {
          
           my_window.focus();
           return;
    
        }
        else
        {
            my_window=null
        }
       // var str="HRM_OtherDepts_ListAll.jsp?id="+document.HRM_OtherDepts.txtEmployeeid.value;
        my_window= window.open("HRM_Other_Depts_ListAll.jsp","mywindow1","status=1,height=400,width="+screen.availWidth+",resizable=yes, scrollbars=yes"); 
      
       // my_window= window.open(str,"mywindow1","status=1,height=400,width="+screen.availWidth+",resizable=yes, scrollbars=yes"); 
      my_window.moveTo(250,250);    
    }
var req=false;
try
{
    req=new ActiveXObject("Msxml2.XMLHTTP");
}
catch(e)
{
    try
    {
        req=new ActiveXObject("Microsoft.XMLHTTP");
    }
    catch(ee)
    {
        req=false;
    }
}

if(!req || typeof XMLHTTPRequest !='undefined')
{
    req=new XMLHttpRequest();
}

function toExit()
{
  //window.close();
var w=window.open(window.location.href,"_self");
w.close();
}

function loadfun()
{
   document.HRM_OtherDepts.txtOtherDept.focus();
}


function clr()
{
        document.HRM_OtherDepts.txtOtherDeptid.value="";
        document.HRM_OtherDepts.txtOtherDept.value="";
        document.HRM_OtherDepts.txtOtherDeptShortName.value="";
        document.HRM_OtherDepts.txtAddress1.value="";
        document.HRM_OtherDepts.txtAddress2.value="";
        document.HRM_OtherDepts.txtCity.value="";
        document.HRM_OtherDepts.txtPincode.value="";
        document.HRM_OtherDepts.txtStd.value="";
        document.HRM_OtherDepts.txtPhone.value="";
        document.HRM_OtherDepts.txtAPhone.value="";
        document.HRM_OtherDepts.txtFax.value="";
        document.HRM_OtherDepts.txtEmail.value="";
        document.HRM_OtherDepts.txtHeadOfDept.value="";
        document.HRM_OtherDepts.txtOtherDeptid.focus();
        
}

var f='';
var cf=0;

var edcode='';
var edtype='';

//String.prototype.trim = function() { return this.replace(/^\s+|\s+$/, ''); };

function checkdeptid()
{
    if((document.HRM_OtherDepts.txtOtherDeptid.value==null)||(document.HRM_OtherDepts.txtOtherDeptid.value.length==0))
    {
        alert("Enter Department Id");
        document.HRM_OtherDepts.txtOtherDeptid.focus();
        return false;
    }
    else if(!isNaN(document.HRM_OtherDepts.txtOtherDeptid.value))
    {
        alert("Enter String value");
        document.HRM_OtherDepts.txtOtherDeptid.value="";
        document.HRM_OtherDepts.txtOtherDeptid.focus();
        return false;
    }
    return true;

}

function checkdeptname()
{
    if((document.HRM_OtherDepts.txtOtherDept.value==null)||(document.HRM_OtherDepts.txtOtherDept.value.length==0))
    {
        alert("Enter Deptpartment Name");
        document.HRM_OtherDepts.txtOtherDept.focus();
        return false;
    }
    else if(!isNaN(document.HRM_OtherDepts.txtOtherDept.value))
    {
        alert("Enter String value");
        document.HRM_OtherDepts.txtOtherDept.value="";
        document.HRM_OtherDepts.txtOtherDept.focus();
        return false;
    }
    return true;

}


function checkshortname()
{
    if((document.HRM_OtherDepts.txtOtherDeptShortName.value==null)||(document.HRM_OtherDepts.txtOtherDeptShortName.length==0))
    {
        alert("Enter Dept. Short Name");
        document.HRM_OtherDepts.txtOtherDeptShortName.focus();
        return false;
    }
    else if(!isNaN(document.HRM_OtherDepts.txtOtherDeptShortName.value))
    {
        alert("Enter String value");
        document.HRM_OtherDepts.txtOtherDeptShortName.value="";
        document.HRM_OtherDepts.txtOtherDeptShortName.focus();
        return false;
    }
    return true;

}

function checkadd1()
{
 if((document.HRM_OtherDepts.txtAddress1.value.length!=0) && !( document.HRM_OtherDepts.txtAddress1.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtAddress1.value.length==1  ))
    {
         if(!isNaN(document.HRM_OtherDepts.txtAddress1.value))
        {
            alert("Enter String value");
            document.HRM_OtherDepts.txtAddress1.value="";
            document.HRM_OtherDepts.txtAddress1.focus();
            return false;
        }
    }
}

function checkadd2()
{
 if((document.HRM_OtherDepts.txtAddress2.value.length!=0) && !( document.HRM_OtherDepts.txtAddress2.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtAddress2.value.length==1  ))
    {
         if(!isNaN(document.HRM_OtherDepts.txtAddress2.value))
        {
            alert("Enter String value");
            document.HRM_OtherDepts.txtAddress2.value="";
            document.HRM_OtherDepts.txtAddress2.focus();
            return false;
        }
    }
}



function checkcity()
{
 if((document.HRM_OtherDepts.txtCity.value==null ||(document.HRM_OtherDepts.txtCity.value.length==0)) && !( document.HRM_OtherDepts.txtCity.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtAddress1.value.length==1  ))
    {
        alert("Null Value not accepted");
        document.HRM_OtherDepts.txtCity.value="";
        document.HRM_OtherDepts.txtCity.focus();
        return false;
    }
     else    if(!isNaN(document.HRM_OtherDepts.txtCity.value))
    {
            alert("Enter String value");
            document.HRM_OtherDepts.txtCity.value="";
            document.HRM_OtherDepts.txtCity.focus();
            return false;
    }
}

function checkpincode()
{

         if(isNaN(document.HRM_OtherDepts.txtPincode.value))
    {
            alert("Enter Numeric value");
            document.HRM_OtherDepts.txtPincode.value="";
            document.HRM_OtherDepts.txtPincode.focus();
            return false;
    }
     if((document.HRM_OtherDepts.txtPincode.value.length!=0) && !( document.HRM_OtherDepts.txtPincode.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtPincode.value.length==1  ))
    {
           if((document.HRM_OtherDepts.txtPincode.value.length!=6 || document.HRM_OtherDepts.txtPincode.value==0) && document.HRM_OtherDepts.txtPincode.value.length!=0 )
            {
                    alert("Pincode Length should be 6. Zero not allowed");
                    document.HRM_OtherDepts.txtPincode.focus();
                    return false;
            }
    }
    return true;

}

function checkstd()
{

    if(isNaN(document.HRM_OtherDepts.txtStd.value) && !( document.HRM_OtherDepts.txtStd.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtStd.value.length==1  ))
    {
            alert("Enter Numeric value");
            document.HRM_OtherDepts.txtStd.value="";
            document.HRM_OtherDepts.txtStd.focus();
            return false;
    }
     if((document.HRM_OtherDepts.txtStd.value.length!=0) && !( document.HRM_OtherDepts.txtStd.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtStd.value.length==1  ))
    {
        if((document.HRM_OtherDepts.txtStd.value.length <2 || document.HRM_OtherDepts.txtStd.value==0)  && document.HRM_OtherDepts.txtStd.value.length !=0)
        {
                    alert("STD Code Length should be between 2 and 5.  Zero not allowed");
                    document.HRM_OtherDepts.txtStd.focus();
                    return false;
        }
    }
    return true;

}

function checkphone()
{
    if(isNaN(document.HRM_OtherDepts.txtPhone.value))
    {
            alert("Enter Numeric value");
            document.HRM_OtherDepts.txtPhone.value="";
            document.HRM_OtherDepts.txtPhone.focus();
            return false;
    }
     if((document.HRM_OtherDepts.txtPhone.value.length!=0) && !( document.HRM_OtherDepts.txtPhone.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtPhone.value.length==1  ))
    {
        if(document.HRM_OtherDepts.txtPhone.value.length <6  || document.HRM_OtherDepts.txtPhone.value==0 )
        {
                    alert("Phone No. Length atleast 6.  Zero not allowed");
                    document.HRM_OtherDepts.txtPhone.focus();
                    return false;
        }
    }
    return true;
}


function checkaddphone()
{
   
     if((document.HRM_OtherDepts.txtAPhone.value.length!=0) && !( document.HRM_OtherDepts.txtAPhone.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtAPhone.value.length==1  ))
    {
        var no=document.HRM_OtherDepts.txtAPhone.value;
        var s=no.split(',');
        
        for(i=0;i<s.length;i++)
        {
        
            if(s[i].indexOf('-')!=-1)
            {
                
                var t=s[i].split('-');
                if(t[0].length<2 || t[0].length >5 || t[1].length<6 || t[0].value==0 || t[1].value==0)
                {
                    alert(s[i]+ " not a valid phone No.\n Phone No. Length atleast 6\nSTD Code Length should be between 2 and 5.\n  Zero not allowed.");
                    document.HRM_OtherDepts.txtAPhone.focus();
                    return false;
                }
                
            }
            else if(s[i].length <6 || s[i].value==0)
            {
                    alert(s[i]+ " not a valid phone No.\n Phone No. Length atleast 6\nSTD Code Length should be between 2 and 5.\n  Zero not allowed.");
                    document.HRM_OtherDepts.txtAPhone.focus();
                    return false;
            }
                    
        
        }
    }
    return true;
}

function checkfax()
{
    if(isNaN(document.HRM_OtherDepts.txtFax.value))
    {
            alert("Enter Numeric value");
            document.HRM_OtherDepts.txtFax.value="";
            document.HRM_OtherDepts.txtFax.focus();
            return false;
    }
     if((document.HRM_OtherDepts.txtFax.value.length!=0) && !( document.HRM_OtherDepts.txtFax.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtFax.value.length==1  ))
    {
        if(document.HRM_OtherDepts.txtFax.value.length <6  )
        {
                    alert("Phone No. Length atleast 6");
                    document.HRM_OtherDepts.txtFax.focus();
                    return false;
        }
    }
    return true;
}

function checkemail()
{
if((document.HRM_OtherDepts.txtEmail.value.length!=0) && !( document.HRM_OtherDepts.txtEmail.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtEmail.value.length==1  ))
    {
        var x = document.HRM_OtherDepts.txtEmail.value;
	var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!filter.test(x))
	 {alert('Enter correct email address');

        document.HRM_OtherDepts.txtEmail.value="";
        document.HRM_OtherDepts.txtEmail.focus();
        return false;
        }
    }
    return true;
}

function checkhead()
{
    if((document.HRM_OtherDepts.txtHeadOfDept.value.length!=0) && !( document.HRM_OtherDepts.txtHeadOfDept.value.charAt(0)==String.fromCharCode(160) && document.HRM_OtherDepts.txtHeadOfDept.value.length==1  ))
     {
            if(!isNaN(document.HRM_OtherDepts.txtHeadOfDept.value))
            {
                alert("Enter String value");
                document.HRM_OtherDepts.txtHeadOfDept.value="";
                document.HRM_OtherDepts.txtHeadOfDept.focus();
                return false;
            }
    }
}


function nullcheck()
{ 
    var c;
    c=checkdeptid();
   
    if(c==false) return false;
    c=checkdeptname();
   
    if(c==false) return false;
    var pscode=document.HRM_OtherDepts.txtOtherDeptid.value;
    document.HRM_OtherDepts.txtOtherDept.value=document.HRM_OtherDepts.txtOtherDept.value.replace(/\s+/g,' ');
    var psname=document.HRM_OtherDepts.txtOtherDept.value;
    pscode=pscode.toUpperCase();
    psname=psname;
   
    if(f=='add' )
    {
    if( !(document.HRM_OtherDepts.txtOtherDeptid.value==null)||(document.HRM_OtherDepts.txtOtherDeptid.value.length==0) )
    {
    startwaiting(document.HRM_OtherDepts) ;
     var url="../../../../../OtherDeptServ.view?Command=novali&txtOtherDeptid="+pscode;
     req.open("GET",url,false);
     req.onreadystatechange=handleResponse;
     if(window.XMLHttpRequest)  req.send(null);
     else req.send();
    } 
    startwaiting(document.HRM_OtherDepts) ;
    var url="../../../../../OtherDeptServ.view?Command=novalitype&txtOtherDeptid="+pscode+"&txtOtherDept="+psname;
    req.open("GET",url,false);
    req.onreadystatechange=handleResponse;
   if(window.XMLHttpRequest)  req.send(null);
     else req.send();
 

    }
    if(f=='update')
    {
        if(edtype!=document.HRM_OtherDepts.txtOtherDept.value)
        {
        startwaiting(document.HRM_OtherDepts) ;
            var url="../../../../../OtherDeptServ.view?Command=novalitype&txtOtherDeptid="+pscode+"&txtOtherDept="+psname;
            req.open("GET",url,false);
            req.onreadystatechange=handleResponse;
            if(window.XMLHttpRequest)  req.send(null);
            else req.send();
        }
    }
     f='';
     
    
    c=checkshortname();
    if(c==false) return false;
    
     c=checkadd1();
    if(c==false) return false;
      c=checkadd2();
    if(c==false) return false;
       
   
    
   
    
    c=checkcity();
    if(c==false) return false;
    c=checkpincode();
    if(c==false) return false;
    c=checkstd();
    if(c==false) return false;
    c=checkphone(); 
    if(c==false) return false;
     c=checkaddphone(); 
    if(c==false) return false;
    c=checkfax();
    if(c==false) return false;
    c=checkemail();
    if(c==false) return false;
    c=checkhead();
    if(c==false) return false;
    return true;
}

function loadTable(scod)
{
    clr();
    var r=document.getElementById(scod);
    var rcells=r.cells;
    var tbody=document.getElementById("tb");
    var table=document.getElementById("mytable");
    try{
    document.HRM_OtherDepts.txtOtherDeptid.value=rcells.item(1).firstChild.nodeValue;
      }catch(e){}try{
    document.HRM_OtherDepts.txtOtherDept.value=rcells.item(2).firstChild.nodeValue;
    }catch(e){}try{
    document.HRM_OtherDepts.txtOtherDeptShortName.value=rcells.item(3).firstChild.nodeValue;
      }catch(e){}try{
    document.HRM_OtherDepts.txtAddress1.value=rcells.item(4).firstChild.nodeValue;
      }catch(e){}try{
    document.HRM_OtherDepts.txtAddress2.value=rcells.item(5).firstChild.nodeValue;
   }catch(e){}try{
    document.HRM_OtherDepts.txtCity.value=rcells.item(6).firstChild.nodeValue;
   }catch(e){}try{
    document.HRM_OtherDepts.txtPincode.value=rcells.item(7).firstChild.nodeValue;
    
     }catch(e){}try{
    document.HRM_OtherDepts.txtStd.value=rcells.item(8).firstChild.nodeValue;
    }catch(e){}try{
     document.HRM_OtherDepts.txtPhone.value=rcells.item(9).firstChild.nodeValue;
     trm(document.HRM_OtherDepts.txtPhone);
    }catch(e){}try{
    document.HRM_OtherDepts.txtAPhone.value=rcells.item(10).firstChild.nodeValue;
      }catch(e){}try{
    document.HRM_OtherDepts.txtFax.value=rcells.item(11).firstChild.nodeValue;
      }catch(e){}try{
    document.HRM_OtherDepts.txtEmail.value=rcells.item(12).firstChild.nodeValue;
      }catch(e){}try{
    document.HRM_OtherDepts.txtHeadOfDept.value=rcells.item(13).firstChild.nodeValue;
      }catch(e){}
    
    
    edcode=document.HRM_OtherDepts.txtOtherDeptid.value;
    edtype=document.HRM_OtherDepts.txtOtherDept.value;
    document.HRM_OtherDepts.cmdadd.style.display="none";
    document.HRM_OtherDepts.cmdupdate.style.display="block";
    //document.HRM_OtherDepts.cmdupdate.disabled=false;
    document.HRM_OtherDepts.cmddelete.disabled=false;
   // document.HRM_OtherDepts.cmdadd.disabled=true;
}


function doFunction(Command,param)
{
    cf=0;
    var pscode=document.HRM_OtherDepts.txtOtherDeptid.value.replace(/\s+/g,' ');
    document.HRM_OtherDepts.txtOtherDept.value=document.HRM_OtherDepts.txtOtherDept.value.replace(/\s+/g,' ');
    var psname=document.HRM_OtherDepts.txtOtherDept.value;
    psname=psname;
    pscode=pscode.toUpperCase();
    var flag="";
    
    
    var deptsname=document.HRM_OtherDepts.txtOtherDeptShortName.value;
    var add1=document.HRM_OtherDepts.txtAddress1.value;
    var add2=document.HRM_OtherDepts.txtAddress2.value;
    var city=document.HRM_OtherDepts.txtCity.value;
    var pincode=document.HRM_OtherDepts.txtPincode.value;
    var std=document.HRM_OtherDepts.txtStd.value;
    var phone=document.HRM_OtherDepts.txtPhone.value;
    var addphone=document.HRM_OtherDepts.txtAPhone.value;
    var fax=document.HRM_OtherDepts.txtFax.value;
    var email=document.HRM_OtherDepts.txtEmail.value;
    var headofdept=document.HRM_OtherDepts.txtHeadOfDept.value;
   

     
    
    if(Command=="Add")
    {
        f='add';
        var flag=nullcheck();
        if(flag==true)
        {
            statuswaiting(document.HRM_OtherDepts) ;
            var url="../../../../../OtherDeptServ.view?Command=Add&txtOtherDeptid="+pscode+"&txtOtherDept="+psname;
             url= url+"&txtOtherDeptShortName="+deptsname+"&txtAddress1="+add1;
            url= url+"&txtAddress2="+add2+"&txtCity="+city;
            url= url+"&txtPincode="+pincode+"&txtStd="+std+"&txtPhone="+phone;
            url= url+"&txtAPhone="+addphone+"&txtFax="+fax;
            url= url+"&txtEmail="+email+"&txtHeadOfDept="+headofdept;
            //alert(url);
            req.open("GET",url,true);
            //req.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
            req.onreadystatechange=handleResponse;
            if(window.XMLHttpRequest)  req.send(null);
            else req.send();
                
        }
    }
    else if(Command=="Clear")
    {
        clr();
        document.HRM_OtherDepts.cmdadd.style.display="block";
         document.HRM_OtherDepts.cmdupdate.style.display="none";
       // document.HRM_OtherDepts.cmdadd.disabled=false;
       // document.HRM_OtherDepts.cmdupdate.disabled=true;
        document.HRM_OtherDepts.cmddelete.disabled=true;
    }
    else if(Command=="Delete")
    {
        //f="del";
       // var flag=nullcheck();
       // if(flag==true)
        {
            if(confirm("Do You Really want to Delete it?"))
            {
            statuswaiting(document.HRM_OtherDepts) ;
            var url="../../../../../OtherDeptServ.view?Command=Delete&txtOtherDeptid="+pscode+"&txtOtherDept="+psname;
            req.open("GET",url,true);
            req.onreadystatechange=handleResponse;
             if(window.XMLHttpRequest)  req.send(null);
            else req.send();
            }
            else
            {
               alert("Records are not Deleted");
            }
        }
   }
   else if(Command=="Update")
   {
        f='update';
        var flag=nullcheck();
        if(flag==true)
        { 
            statuswaiting(document.HRM_OtherDepts) ;
         var url="../../../../../OtherDeptServ.view?Command=Update&txtOtherDeptid="+pscode+"&txtOtherDept="+psname;
          url= url+"&txtOtherDeptShortName="+deptsname+"&txtAddress1="+add1;
            url= url+"&txtAddress2="+add2+"&txtCity="+city;
            url= url+"&txtPincode="+pincode+"&txtStd="+std+"&txtPhone="+phone;
            url= url+"&txtAPhone="+addphone+"&txtFax="+fax;
            url= url+"&txtEmail="+email+"&txtHeadOfDept="+headofdept;
           
        req.open("GET",url,true);
        req.onreadystatechange=handleResponse;
        if(window.XMLHttpRequest)  req.send(null);
            else req.send();
        }
   }
 }

function handleResponse()
{
    if(req.readyState==4)
    {
        if(req.status==200)
        {
            stopwaiting(document.HRM_OtherDepts);
            var baseResponse=req.responseXML.getElementsByTagName("response")[0];
            var tagcommand=baseResponse.getElementsByTagName("command")[0];
            var Command=tagcommand.firstChild.nodeValue;
            if(Command=="Add")
            {
                addRow(baseResponse);
            }
            
            else if(Command=="Delete")
            {
                deleteRow(baseResponse);
            }
            else if(Command=="Update")
            {
                UpdateRow(baseResponse);
            }
            else if(Command=="novali")
            {
                novaliRow(baseResponse);
            }
            else if(Command=="novalitype")
            {
                novaliRowType(baseResponse);
            }
            else if(Command=="clear")
            {
                ClearFun(baseResponse);
            }
        }
    }
}


function addRow(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       
    if(flag=="success")
    {
        //var id=baseResponse.getElementsByTagName("genid")[0].firstChild.nodeValue;
        //document.HRM_OtherDepts.txtOtherDeptid.value=id;
        alert("Records inserted into DB");
        var items=new Array();
        items[0]=document.HRM_OtherDepts.txtOtherDeptid.value.toUpperCase();
        items[1]=document.HRM_OtherDepts.txtOtherDept.value;
        
        items[2]=document.HRM_OtherDepts.txtOtherDeptShortName.value;
        items[3]=document.HRM_OtherDepts.txtAddress1.value;
        items[4]=document.HRM_OtherDepts.txtAddress2.value;
        items[5]=document.HRM_OtherDepts.txtCity.value;
        items[6]=document.HRM_OtherDepts.txtPincode.value;
        items[7]=document.HRM_OtherDepts.txtStd.value;
        items[8]=document.HRM_OtherDepts.txtPhone.value;
        items[9]=document.HRM_OtherDepts.txtAPhone.value;
        items[10]=document.HRM_OtherDepts.txtFax.value;
        items[11]=document.HRM_OtherDepts.txtEmail.value;
        items[12]=document.HRM_OtherDepts.txtHeadOfDept.value;
        
        
        var tbody=document.getElementById("tb");
        var mycurrent_row=document.createElement("TR");
      
        mycurrent_row.id=items[0];
        var cell=document.createElement("TD");
        var anc=document.createElement("A");
        var url="javascript:loadTable('"+items[0]+"')";
        anc.href=url;
        var txtedit=document.createTextNode("Edit");
        anc.appendChild(txtedit);
        cell.appendChild(anc);
        mycurrent_row.appendChild(cell);
        var i=0;
        var cell2;
    
        for(i=0;i<13;i++)
        {
            cell2=document.createElement("TD");
            cell2.setAttribute('align','left');
            var currentText=document.createTextNode(items[i]);
            cell2.appendChild(currentText);
            mycurrent_row.appendChild(cell2);
        }
            
        tbody.appendChild(mycurrent_row);
        clr();
    }
    else
    {
       if(cf==0) alert("Records r not inserted");
    }
}

function deleteRow(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    
    if(flag=="success")
    {
        alert("Records deleted from DB");
         var sc=baseResponse.getElementsByTagName("scd")[0].firstChild.nodeValue;
        var tbody=document.getElementById("mytable");
        var r=document.getElementById(sc);
        var ri=r.rowIndex;
        tbody.deleteRow(ri);
     
        clr();
        document.HRM_OtherDepts.cmdadd.style.display="block";
        document.HRM_OtherDepts.cmdupdate.style.display="none";
       // document.HRM_OtherDepts.cmdadd.disabled=false;
        //document.HRM_OtherDepts.cmdupdate.disabled=true;
        document.HRM_OtherDepts.cmddelete.disabled=true;
    }
    else
    {
        alert("Records r not deleted");
    }
}

function UpdateRow(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    var items=new Array();
    
    if(flag=="success")
    {
     edcode=document.HRM_OtherDepts.txtOtherDeptid.value;
    edtype=document.HRM_OtherDepts.txtOtherDept.value;
   
        items[0]=document.HRM_OtherDepts.txtOtherDeptid.value.toUpperCase();
        items[1]=document.HRM_OtherDepts.txtOtherDept.value;
        items[2]=document.HRM_OtherDepts.txtOtherDeptShortName.value;
        items[3]=document.HRM_OtherDepts.txtAddress1.value;
        items[4]=document.HRM_OtherDepts.txtAddress2.value;
        items[5]=document.HRM_OtherDepts.txtCity.value;
        items[6]=document.HRM_OtherDepts.txtPincode.value;
         items[7]=document.HRM_OtherDepts.txtStd.value;
        items[8]=document.HRM_OtherDepts.txtPhone.value;
        items[9]=document.HRM_OtherDepts.txtAPhone.value;
        items[10]=document.HRM_OtherDepts.txtFax.value;
        items[11]=document.HRM_OtherDepts.txtEmail.value;
        items[12]=document.HRM_OtherDepts.txtHeadOfDept.value;
        
        var r=document.getElementById(items[0]); 
        var rcells=r.cells;
       
         for(i=0;i<13;i++)
        {
            rcells.item(i+1).firstChild.nodeValue=items[i];
       
        }        
        //rcells.item(1).firstChild.nodeValue=items[0];
        //rcells.item(2).firstChild.nodeValue=items[1];
        alert("Record Updated");
        clr();
    }
    else
    {
      if(cf==0)  alert("Record not Updated");
    }
}



function novaliRow(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    if(flag=="success")
    {
       //alert("No Duplication ID..Can proceed");
    }
    else
    {
      alert("Treatmentplant Code already exists.");
      cf=1;
       document.HRM_OtherDepts.txtOtherDeptid.value="";
        document.HRM_OtherDepts.txtOtherDeptid.focus();
       //document.HRM_OtherDepts.cmdclear.focus();
        return false;
    }
}

function novaliRowType(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    if(flag=="success")
    {
      // alert("No Duplication Type..Can proceed");
    }
    else
    {
        if (cf==0)alert("Treatmentplant Type already exists");
       cf=1;
        document.HRM_OtherDepts.txtOtherDept.value="";
        document.HRM_OtherDepts.txtOtherDept.focus();
         return false;
    }
}


function ClearFun(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    var id=baseResponse.getElementsByTagName("genid")[0].firstChild.nodeValue;
    if(flag=="success")
    {
     document.HRM_OtherDepts.txtOtherDeptid.value=id;
    document.HRM_OtherDepts.txtOtherDept.focus();
    }
}

function numbersonly(e)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8)
        {
            if (unicode<48||unicode>57) 
                return false 
        }
    }
   
     function nonanumber(e)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8)
        {
            if ( unicode==32 || (unicode>=65 && unicode<=90) || (unicode>=97 && unicode<=122) || unicode==45 || unicode==95 )
                return true;
            else
                return false;
        }
    }
    
     function addphone(e)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8)
        {
            if ((unicode>=48 && unicode<=57) || unicode==45  || unicode==44   )
                return true;
            else
                return false;
        }
    }
    
     function fax(e)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8)
        {
            if ((unicode>=48 && unicode<=57) || unicode==45  )
                return true;
            else
                return false;
        }
    }
    
   
function trm(t)
{
//for(i=0;i<256;i++)if(t.value.charAt(0)==String.fromCharCode(i))   alert(i);

   if(t!=null)
   {
        if(t.value.charAt(0)==String.fromCharCode(160) || t.value.charAt(0)==String.fromCharCode(32)  )
        {
           // if(t.value.length==1)
               // t.value='';
               var i=0;
               while(t.value.charAt(i)==String.fromCharCode(160) || t.value.charAt(i)==String.fromCharCode(32) )
               {
                    t.value=t.value.substring(1);
               
               }
        }
     
    }
}