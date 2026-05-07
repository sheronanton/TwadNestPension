var flagg;
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

function toExit()
{
    var w=window.open(window.location.href,"_self");
    w.close();
}


function nullcheck()
{   
    //alert(document.dept_office.cmbOtherDept_Id.value);
    if(document.dept_office.cmbOtherDept_Id.value=="")
    {
        alert("Select Department Id");
        document.dept_office.cmbOtherDept_Id.focus();
        return false;
    }
   
    else if(document.dept_office.txtOtherDeptOff_Name.value.length==0)
    {
        alert("Blank Value not accepted for Office name");
        document.dept_office.txtOtherDeptOff_Name.focus();
        return false;
    }
     else if(!isNaN(document.dept_office.txtOtherDeptOff_Name.value))
    {
        alert("Enter Character Value for Office name");
        document.dept_office.txtOtherDeptOff_Name.value="";
        document.dept_office.txtOtherDeptOff_Name.focus();
        return false;
               
    }
    else if(document.dept_office.txtOtherDeptOff_SName.value.length==0)
    {
        alert("Blank Value not accepted for Office short name ");
        document.dept_office.txtOtherDeptOff_SName.focus();
        return false;
    }
    else if(!isNaN(document.dept_office.txtOtherDeptOff_SName.value))
    {
        alert("Enter Character value for Office short name");
        document.dept_office.txtOtherDeptOff_SName.value="";
        document.dept_office.txtOtherDeptOff_SName.focus();
        return false;
    }
    else if(document.dept_office.txtCity.value.length==0)
    {
        alert("Blank Value not accepted for city");
        document.dept_office.txtCity.focus();
        return false;
    }
    else if(!isNaN(document.dept_office.txtCity.value))
    {
        alert("Enter Character value for city");
        document.dept_office.txtCity.value="";
        document.dept_office.txtCity.focus();
        return false;
    }
    else if(document.dept_office.txtPincode.value!=0)
    {
        if((document.dept_office.txtPincode.value).length<6)
        {
        alert("PINCODE must be 6 digit number");
        document.dept_office.txtPincode.focus();
        return false;
        }
    }
    
return true;
}

function null_cmbDeptid()
{
 if(document.dept_office.cmbOtherDept_Id.value=="")
    {
        alert("Select Department Id");
        document.dept_office.cmbOtherDept_Id.focus();
        return false;
    }
    document.dept_office.txtOtherDeptOff_Name.focus();
    return true;
}

function null_offName()
{
     if(document.dept_office.txtOtherDeptOff_Name.value.length==0)
    {
        alert("Blank Value not accepted for Office name");
        document.dept_office.txtOtherDeptOff_Name.focus();
        return false;
    }
     else if(!isNaN(document.dept_office.txtOtherDeptOff_Name.value))
    {
        alert("Enter Character Value for Office name");
        document.dept_office.txtOtherDeptOff_Name.value="";
        document.dept_office.txtOtherDeptOff_Name.focus();
        return false;
               
    }
    return true;
}
function null_offSName()
{
 if(document.dept_office.txtOtherDeptOff_SName.value.length==0)
    {
        alert("Blank Value not accepted for Office short name");
        document.dept_office.txtOtherDeptOff_SName.focus();
        return false;
    }
    else if(!isNaN(document.dept_office.txtOtherDeptOff_SName.value))
    {
        alert("Enter Character value for Office short name");
        document.dept_office.txtOtherDeptOff_SName.value="";
        document.dept_office.txtOtherDeptOff_SName.focus();
        return false;
    }
    return true;
}
function null_city()
{
    if(document.dept_office.txtCity.value.length==0)
    {
        alert("Blank Value not accepted for city");
        document.dept_office.txtCity.focus();
        return false;
    }
    else if(!isNaN(document.dept_office.txtCity.value))
    {
        alert("Enter Character value for city");
        document.dept_office.txtCity.value="";
        document.dept_office.txtCity.focus();
        return false;
    }
    return true;
}
function pincode()
{
    if(document.dept_office.txtPincode.value!=0)
    {
        if((document.dept_office.txtPincode.value).length<6)
        {
        alert("PINCODE must be 6 digit number");
        document.dept_office.txtPincode.focus();
        return false;
        }
    }
    return true;
}

function loadTable(scod)
{
        //alert("load");
        clear();
        var r=document.getElementById(scod);
         // alert(r);
        var rcells=r.cells;
          //alert(rcells);
        var tbody=document.getElementById("tb");
        var table=document.getElementById("mytable");
        for(k=1;k<15;k++)
        {   
             //if(rcells.item(k).firstChild.nodeValue.charAt(0)==String.fromCharCode(160))
            // if(rcells.item(k).firstChild.nodeValue.length==1)
             if(rcells.item(k).firstChild.nodeValue=="Not Available")
             rcells.item(k).firstChild.nodeValue='';
        }
        var d=scod.lastIndexOf("-");
        var getcmbid=scod.substring(0,d)
        //alert(getcmbid);
        
       //try {document.dept_office.cmbOtherDept_Id.value=rcells.item(1).firstChild.nodeValue; }catch(e){}
       try {document.dept_office.cmbOtherDept_Id.value=getcmbid}catch(e){}
        try{document.dept_office.txtOtherDeptOff_Id.value=rcells.item(2).firstChild.nodeValue;  }catch(e){}
        try{ document.dept_office.txtOtherDeptOff_Name.value=rcells.item(3).firstChild.nodeValue;}catch(e){}
       try {document.dept_office.txtOtherDeptOff_SName.value=rcells.item(4).firstChild.nodeValue;}catch(e){}
      try { document.dept_office.txtAddress1.value=rcells.item(5).firstChild.nodeValue;}catch(e){}
      try { document.dept_office.txtAddress2.value=rcells.item(6).firstChild.nodeValue;}catch(e){}
       try {document.dept_office.txtCity.value=rcells.item(7).firstChild.nodeValue;}catch(e){}
       try {document.dept_office.txtPincode.value=rcells.item(8).firstChild.nodeValue;}catch(e){}
       try {document.dept_office.txtStd.value=rcells.item(9).firstChild.nodeValue;}catch(e){}
      try { document.dept_office.txtPhone1.value=rcells.item(10).firstChild.nodeValue;}catch(e){}
       try {document.dept_office.txtAPhone.value=rcells.item(11).firstChild.nodeValue;}catch(e){}
      try { document.dept_office.txtFax.value=rcells.item(12).firstChild.nodeValue;}catch(e){}
      try { document.dept_office.txtEmail.value=rcells.item(13).firstChild.nodeValue;}catch(e){}
      try { document.dept_office.txtHeadOfDept.value=rcells.item(14).firstChild.nodeValue;}catch(e){}
      
       
       
    //document.dept_office.cmdupdate.disabled=false;
    document.dept_office.cmdupdate.style.display='block';
    document.dept_office.cmddelete.disabled=false;
    document.dept_office.cmbOtherDept_Id.disabled=true;
    //document.dept_office.cmdadd.disabled=true;
    document.dept_office.cmdadd.style.display='none';
}

function doFunction(Command,param)
{
    var OtherDept_Id=document.dept_office.cmbOtherDept_Id.value
    var OtherDeptOff_Id=document.dept_office.txtOtherDeptOff_Id.value;
    var OtherDeptOff_Name=document.dept_office.txtOtherDeptOff_Name.value;
    var OtherDeptOff_SName=document.dept_office.txtOtherDeptOff_SName.value;
    var addr1=document.dept_office.txtAddress1.value;
    var addr2=document.dept_office.txtAddress2.value;
    var city=document.dept_office.txtCity.value;
    var pin=document.dept_office.txtPincode.value;
    var Std=document.dept_office.txtStd.value;
    var phone1=document.dept_office.txtPhone1.value;
    var add_phone=document.dept_office.txtAPhone.value;
    var fax=document.dept_office.txtFax.value;
    var email=document.dept_office.txtEmail.value.toLowerCase();
    var HoOffice=document.dept_office.txtHeadOfDept.value;
    
    var flag="";
    if(Command=="Add")
    {
        var flag=nullcheck();
        if(flag==true)
        {   
            var url="../../../../../HRM_OtherDept_offices.view?Command=Add&cmbOtherDept_Id="+OtherDept_Id+"&txtOtherDeptOff_Id="+OtherDeptOff_Id+
            "&txtOtherDeptOff_Name="+OtherDeptOff_Name+"&txtOtherDeptOff_SName="+OtherDeptOff_SName
            +"&txtAddress1="+addr1+"&txtAddress2="+addr2
            +"&txtCity="+city+"&txtPincode="+pin
            +"&txtStd="+Std+"&txtPhone1="+phone1+"&txtAPhone="+add_phone
            +"&txtFax="+fax+"&txtEmail="+email
            +"&txtHeadOfDept="+HoOffice;
            var req=getTransport();
            //alert(url);
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               handleResponse(req);
            }   
                    req.send(null);
        }
    }
    else if(Command=="Delete")
    {
    
        if(confirm("Do You Really want to Delete it?"))
        {
        var url="../../../../../HRM_OtherDept_offices.view?Command=Delete&cmbOtherDept_Id="+OtherDept_Id+"&txtOtherDeptOff_Id="+OtherDeptOff_Id;
         var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               handleResponse(req);
            }   
                    req.send(null);
        }
        else
        {
           alert("Records are not Deleted");
        }
   }
    
   else if(Command=="Update")
   {
        var flag=nullcheck();
        if(flag==true)
        {   
          var url="../../../../../HRM_OtherDept_offices.view?Command=Update&cmbOtherDept_Id="+OtherDept_Id+"&txtOtherDeptOff_Id="+OtherDeptOff_Id+
            "&txtOtherDeptOff_Name="+OtherDeptOff_Name+"&txtOtherDeptOff_SName="+OtherDeptOff_SName
            +"&txtAddress1="+addr1+"&txtAddress2="+addr2
            +"&txtCity="+city+"&txtPincode="+pin
            +"&txtStd="+Std+"&txtPhone1="+phone1+"&txtAPhone="+add_phone
            +"&txtFax="+fax+"&txtEmail="+email
            +"&txtHeadOfDept="+HoOffice;
         var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               handleResponse(req);
            }   
                    req.send(null);
        }
      }
    else if(Command=="loaddept")
    {  
      //if(document.dept_office.cmbOtherDept_Id.value!="")
      {
      var url="../../../../../HRM_OtherDept_offices.view?Command=loaddept&cmbOtherDept_Id="+OtherDept_Id;
      var req=getTransport();
      req.open("GET",url,true); 
      req.onreadystatechange=function()
      {
        handleResponse(req);
      }   
      req.send(null);
      }
    }
    else if(Command=="Clear")
     {
    clear();
    }
    
}

function handleResponse(req)
{   
    if(req.readyState==4)
    {
        if(req.status==200)
        {   
            var baseResponse=req.responseXML.getElementsByTagName("response")[0];
            var tagcommand=baseResponse.getElementsByTagName("command")[0];
            var Command=tagcommand.firstChild.nodeValue;
        
            if(Command=="Add")
            {
                addRow(baseResponse);
            }
            else if(Command=="Update")
            {
                UpdateRow(baseResponse);
            }
            
            else if(Command=="Delete")
            {
                deleteRow(baseResponse);
            }
            else if(Command=="loaddept")
            {
                load_grid(baseResponse);
            }
            
        }
    }
}

function load_grid(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    
    if(flag=="success")
    {   
                        var tbody=document.getElementById("tb");
                        var t=0;
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
        var depid=baseResponse.getElementsByTagName("depid");//[0].firstChild.nodeValue;
        //alert(depid+"length"+depid.length);
        var items=new Array();
        for(var k=0;k<depid.length;k++)
        {
        items[0]=baseResponse.getElementsByTagName("depid")[k].firstChild.nodeValue;   
         items[1]=baseResponse.getElementsByTagName("depname")[k].firstChild.nodeValue;
         items[2]=baseResponse.getElementsByTagName("offid")[k].firstChild.nodeValue;
        items[3] =baseResponse.getElementsByTagName("offname")[k].firstChild.nodeValue;
        items[4] =baseResponse.getElementsByTagName("offsname")[k].firstChild.nodeValue;
         items[5]=baseResponse.getElementsByTagName("add1")[k].firstChild.nodeValue;
         items[6]=baseResponse.getElementsByTagName("add2")[k].firstChild.nodeValue;
         items[7]=baseResponse.getElementsByTagName("town")[k].firstChild.nodeValue;
        // alert("i 7"+items[7]);
       items[8]=(baseResponse.getElementsByTagName("pinc")[k].firstChild.nodeValue)//==0)?' ':baseResponse.getElementsByTagName("pinc")[k].firstChild.nodeValue;
       //alert("i 7"+items[7]);
       //alert("i 8"+items[8]);
        items[9] =(baseResponse.getElementsByTagName("stdc")[k].firstChild.nodeValue)//==null)?' ':baseResponse.getElementsByTagName("stdc")[k].firstChild.nodeValue;
       // alert("i 8"+items[8]);
         items[10]=baseResponse.getElementsByTagName("pho")[k].firstChild.nodeValue;
         items[11]=baseResponse.getElementsByTagName("apho")[k].firstChild.nodeValue;
         items[12]=baseResponse.getElementsByTagName("faxno")[k].firstChild.nodeValue;
        items[13] =baseResponse.getElementsByTagName("mail")[k].firstChild.nodeValue;
        items[14] =baseResponse.getElementsByTagName("hof")[k].firstChild.nodeValue;
        
        
                
        tbody=document.getElementById("tb");
        var mycurrent_row=document.createElement("TR");
        mycurrent_row.id=items[0]+"-"+items[2];
        //alert(mycurrent_row.id);
        var cell=document.createElement("TD");
        var anc=document.createElement("A");
        var url="javascript:loadTable('"+items[0]+"-"+items[2]+"')";
        anc.href=url;
        var txtedit=document.createTextNode("Edit");
        anc.appendChild(txtedit);
        cell.appendChild(anc);
        mycurrent_row.appendChild(cell);
        var i=0;
        var cell2;
        
        for(i=1;i<15;i++)
        {   
            //if(i==1)
            //continue;
            cell2=document.createElement("TD");
            var currentText=document.createTextNode(items[i]);
            cell2.appendChild(currentText);
            mycurrent_row.appendChild(cell2);
            
        }
        tbody.appendChild(mycurrent_row);
        //document.dept_office.txtOtherDeptOff_Id.value=id2;
        //alert("Inserted Office Id :"+id2);
         //clear();
    }
    /* else if(duplicate=="yes")
    {
     alert("Programme  Desc already exists");
       document.dept_office.txtPrgName.value="";
      document.dept_office.txtPrgName.focus();
     }*/
     }
    else
    {
        alert("No records found");
    }

}

function addRow(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    
    if(flag=="success")
    {   
        var id2=baseResponse.getElementsByTagName("num")[0].firstChild.nodeValue;
        alert("Records inserted into DB");
        var items=new Array();
        items[0]=document.dept_office.cmbOtherDept_Id.options[document.dept_office.cmbOtherDept_Id.selectedIndex].text;//document.dept_office.cmbOtherDept_Id.value;
        items[1]=id2;//document.dept_office.txtPrgName.value.toUpperCase();
        try {items[2]=document.dept_office.txtOtherDeptOff_Name.value;}catch(e){}
        try {items[3]=document.dept_office.txtOtherDeptOff_SName.value;}catch(e){}
        try {  items[4]=document.dept_office.txtAddress1.value;}catch(e){}
        try {items[5]=document.dept_office.txtAddress2.value;}catch(e){}
        try { items[6]=document.dept_office.txtCity.value;}catch(e){}
        try {items[7]=document.dept_office.txtPincode.value;}catch(e){}
        try { items[8]=document.dept_office.txtStd.value;}catch(e){}
        try { items[9]=document.dept_office.txtPhone1.value;}catch(e){}
        try { items[10]=document.dept_office.txtAPhone.value;}catch(e){}
        try { items[11]=document.dept_office.txtFax.value;}catch(e){}
        try { items[12]=document.dept_office.txtEmail.value.toLowerCase();}catch(e){}
        try { items[13]=document.dept_office.txtHeadOfDept.value;}catch(e){}
    
        var tbody=document.getElementById("tb");
        var mycurrent_row=document.createElement("TR");
        //mycurrent_row.id=items[0]+"e"+items[1];
        mycurrent_row.id=document.dept_office.cmbOtherDept_Id.value+"-"+items[1];
        //alert(mycurrent_row.id);
        var cell=document.createElement("TD");
        var anc=document.createElement("A");
        
        //var url="javascript:loadTable('"+items[0]+"e"+items[1]+"')";
        var url="javascript:loadTable('"+document.dept_office.cmbOtherDept_Id.value+"-"+items[1]+"')";
        anc.href=url;
        var txtedit=document.createTextNode("Edit");
        anc.appendChild(txtedit);
        cell.appendChild(anc);
        mycurrent_row.appendChild(cell);
        var i=0;
        var cell2;
        
        for(i=0;i<14;i++)
        {
            cell2=document.createElement("TD");
            var currentText=document.createTextNode(items[i]);
            //alert
            cell2.appendChild(currentText);
            mycurrent_row.appendChild(cell2);
            
        }
        tbody.appendChild(mycurrent_row);
        document.dept_office.txtOtherDeptOff_Id.value=id2;
        alert("Inserted Office Id :"+id2);
         clear();
    }
    /* else if(duplicate=="yes")
    {
     alert("Programme  Desc already exists");
       document.dept_office.txtPrgName.value="";
      document.dept_office.txtPrgName.focus();
     }*/
    else
    {
        alert("Records r not inserted");
    }
}


function UpdateRow(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
     //var duplicate=baseResponse.getElementsByTagName("duplicate")[0].firstChild.nodeValue;
    var items=new Array();
    
    if(flag=="success")
    {
        //try { items[0]=document.dept_office.cmbOtherDept_Id.value;}catch(e){}
        try { items[0]=document.dept_office.cmbOtherDept_Id.options[document.dept_office.cmbOtherDept_Id.selectedIndex].text;}catch(e){} 
        try { items[1]=document.dept_office.txtOtherDeptOff_Id.value;}catch(e){}
        try { items[2]=document.dept_office.txtOtherDeptOff_Name.value;}catch(e){}
        try { items[3]=document.dept_office.txtOtherDeptOff_SName.value;}catch(e){}
       try {  items[4]=document.dept_office.txtAddress1.value;}catch(e){}
        try { items[5]=document.dept_office.txtAddress2.value;}catch(e){}
        try { items[6]=document.dept_office.txtCity.value;}catch(e){}
        try { items[7]=document.dept_office.txtPincode.value;}catch(e){}
        try { items[8]=document.dept_office.txtStd.value;}catch(e){}
        try { items[9]=document.dept_office.txtPhone1.value;}catch(e){}
        try { items[10]=document.dept_office.txtAPhone.value;}catch(e){}
        try { items[11]=document.dept_office.txtFax.value;}catch(e){}
        try { items[12]=document.dept_office.txtEmail.value.toLowerCase();}catch(e){}
        try { items[13]=document.dept_office.txtHeadOfDept.value;}catch(e){}

        var r=document.getElementById(document.dept_office.cmbOtherDept_Id.value+"-"+items[1]); 
        var rcells=r.cells;
        for(i=0,j=1;i<14;i++,j++)
        {
            try{
            rcells.item(j).firstChild.nodeValue=items[i];
            }
            catch(e){
            }
        }
        alert("Record Updated");
        clear();
    }
    
    else
    {
        alert("Record not Updated");
    }
    
}


function deleteRow(baseResponse)
{
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    
    if(flag=="success")
    {
        alert("Records deleted from DB");
        var sc=baseResponse.getElementsByTagName("scd")[0].firstChild.nodeValue;
        //alert(sc);
        var tbody=document.getElementById("mytable");
        var r=document.getElementById(sc);
        var ri=r.rowIndex;
        tbody.deleteRow(ri);
    }
    else
    {
        alert("Records r not deleted");
    }
    clear();
}

function clear()
{
       document.dept_office.cmbOtherDept_Id.value="";
       document.dept_office.txtOtherDeptOff_Id.value="";
       document.dept_office.txtOtherDeptOff_Name.value="";
       document.dept_office.txtOtherDeptOff_SName.value="";
       document.dept_office.txtAddress1.value="";
       document.dept_office.txtAddress2.value="";
       document.dept_office.txtCity.value="";
       document.dept_office.txtPincode.value="";
       document.dept_office.txtStd.value="";
       document.dept_office.txtPhone1.value="";
       document.dept_office.txtAPhone.value="";
       document.dept_office.txtFax.value="";
       document.dept_office.txtEmail.value="";
       document.dept_office.txtHeadOfDept.value="";
 document.dept_office.cmbOtherDept_Id.disabled=false;
  document.dept_office.cmdupdate.style.display='none';
 //document.dept_office.cmdadd.disabled=false;
 //document.dept_office.cmdupdate.disabled=true;
 document.dept_office.cmddelete.disabled=true;
 document.dept_office.cmdadd.style.display='block';
}

function numbersonly(e)
    {   
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8 )
        {
            if(unicode==9)
              return true
            else if (unicode<48||unicode>57) 
              return false 
             
        }
    }
    
 function valid_addphone(e)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8)
        {
            if ((unicode>=48 && unicode<=57) || unicode==45  || unicode==44 ||unicode==9)
                return true;
            else
                return false;
        }
    }
    
 function valid_fax(e)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8)
        {
            if ((unicode>=48 && unicode<=57) || unicode==45 ||unicode==9 )
                return true;
            else
                return false;
        }
    }
function valid_email()
{
if(document.dept_office.txtEmail.value!=" ")
{
    if(document.dept_office.txtEmail.value.length!=0)
    {
     var x = document.dept_office.txtEmail.value;
     var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
     if (!filter.test(x))
     {
        alert('Enter correct email address');
        document.dept_office.txtEmail.value="";
        document.dept_office.txtEmail.focus();
        return false;
        }
    }
}
}
 
