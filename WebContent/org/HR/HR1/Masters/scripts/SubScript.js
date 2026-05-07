//alert(escape('&'));
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

 function toWork()
 {
 document.SubForm.CmbMajorId.focus();
 }
 function combomajor(event)
{
var sele=document.SubForm.CmbMajorId.value;
var url="../../../../../SubServlet.view?command=major&First=" +sele;
var req=getTransport();
req.open("GET",url,true);
req.onreadystatechange=function()
{
   callCombo2(req);
}   
req.send(null);

}
function callCombo2(req)
{
if(req.readyState==4)
{
  if(req.status==200)
   {
   var i;
   var j;
   var first=document.getElementById("CmbMinorId");
   first.innerHTML="";
   
   var sel=req.responseXML.getElementsByTagName("select")[0];
   
   var options=sel.getElementsByTagName("option");
   var htop=document.createElement("OPTION");
    htop.text="--Select Minor Id--";
    try
    {
    first.add(htop);
    }
    catch(e)
    {
    first.add(htop,null);
    }
   for(i=0;i<options.length;i++)
   {
   
    var desc=options[i].getElementsByTagName("desc")[0].firstChild.nodeValue;
   var id=options[i].getElementsByTagName("id")[0].firstChild.nodeValue;
   var htoption=document.createElement("OPTION");
   htoption.text=desc;
   htoption.value=id;
   try
   {
    first.add(htoption);
   }
   catch(e)
   {
     first.add(htoption,null);
   }
  }
  } 
  
 }  
}

 
 function loadRow(baseResponse)
 {
 //alert('hai');
                var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                if(flag=="NoRecord")
                {
                var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
               // alert("Record Does't Exists For the Selected Sub-System");
                document.SubForm.CmbMajorId.focus();
                
                }
                 else if(flag=="success")
                  {
                     //alert("Record exists");
                    //  document.SubForm.CmdAdd.disabled=true;
                      //document.SubForm.CmdUpdate.disabled=false;
                      //document.SubForm.CmdDelete.disabled=false;
                     var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                                                
                          var Subid=baseResponse.getElementsByTagName("Subcode");
                          var j=0;
                          var l=Subid.length;
                      for(j=0;j<l;j++)
                          {   
                         
                           var Subid=baseResponse.getElementsByTagName("Subcode");
                          var Subdesc=baseResponse.getElementsByTagName("Subdesc");
                          var Subsdesc=baseResponse.getElementsByTagName("SubSDesc"); 
                            var comboSubid=Subid.item(j).firstChild.nodeValue;
                            var comboSubdesc=Subdesc.item(j).firstChild.nodeValue;
                            var comboSubsdesc=Subsdesc.item(j).firstChild.nodeValue;
                            
                         var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                         
                          
                          mycurrent_row.id=comboSubid;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+comboSubid;
                          anc.href="javascript:loadValuesFromTable('"+comboSubid+"')";
                          var edit=document.createTextNode("Edit");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Subid=document.createTextNode(comboSubid);
                          var Subdesc=document.createTextNode(comboSubdesc);
                          var Subsdesc=document.createTextNode(comboSubsdesc);
                          
                          cell1.appendChild(Subid);
                          cell2.appendChild(Subdesc);
                          cell3.appendChild(Subsdesc);
           
                            mycurrent_row.appendChild(cell1);
                            mycurrent_row.appendChild(cell2);
                            mycurrent_row.appendChild(cell3);
                          
                           
                          tbody.appendChild(mycurrent_row);                          
                          }
                       }
                      
                     
                     else
                     {
                     alert("Record does not exist. Insert a new Record");
                      var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
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
             //  alert('ok');
              var command=tagCommand.firstChild.nodeValue; 
              if(command=="Add")
              {
                  addRow(baseResponse);                 
              }
              else if(command=="Delete")
              {
              deleteRow(baseResponse)
              }
              else if(command=="check")
              {
              checkRow(baseResponse);
              }
              else if(command=="Load")
              {
              loadRow(baseResponse);
              }
              else if(command=="Update")
              {
              updateRow(baseResponse);
              }


          }
        }
  }

function loadValuesFromTable(rid) 
{

           var d=document.getElementById("add");
                d.style.display="none";
                var d=document.getElementById("update");
                d.style.display="block";

          var r=document.getElementById(rid); 
          var txtSubId=document.getElementById("txtSubId");
          var txtSubDesc=document.getElementById("txtSubDesc");
          var txtSubSDesc=document.getElementById("txtSubSDesc");
          
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          document.SubForm.txtSubId.value=rcells.item(1).firstChild.nodeValue;
          document.SubForm.htxtSubId.value=rcells.item(1).firstChild.nodeValue;
          document.SubForm.txtSubDesc.value=rcells.item(2).firstChild.nodeValue;
          document.SubForm.txtSubSDesc.value=rcells.item(3).firstChild.nodeValue;
          document.SubForm.txtSubId.disabled=true;
          document.SubForm.CmdUpdate.disabled=false;
          document.SubForm.CmdDelete.disabled=false;
		document.SubForm.CmdAdd.disabled=true;

      
}

 function clearAll()
 {        
        document.SubForm.CmbMajorId.selectedIndex=0;
        document.SubForm.CmbMinorId.innerHTML="";
        
         var minor=document.createElement("OPTION");
        minor.text="--Select Minor Id--";
        try
        {
        document.SubForm.CmbMinorId.add(minor);
         }
         catch(e)
         {
         document.SubForm.CmbMinorId.add(minor,null);
         }
        
        document.SubForm.txtSubId.value="";        
        document.SubForm.txtSubDesc.value="";
        document.SubForm.txtSubSDesc.value="";
         document.SubForm.CmdUpdate.disabled=true;
         document.SubForm.CmdDelete.disabled=true;
         document.SubForm.CmdAdd.disabled=false;
         document.SubForm.txtSubId.disabled=false;
         var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }
        
         var d=document.getElementById("add");
                d.style.display="block";
                var d=document.getElementById("update");
                d.style.display="none";
 }
 function Exit()
 {
    window.open('','_parent','');
    window.close();
 }


function callServer(command,param)
 {     
                    var strMajor=document.SubForm.CmbMajorId.value;
                    var strMinor=document.SubForm.CmbMinorId.value;
                    var strSubId=document.SubForm.txtSubId.value;
                    var hstrSubId=document.SubForm.htxtSubId.value;
                    hstrSubId=strSubId;
                    var strSubDesc=document.SubForm.txtSubDesc.value;
                    var strSubSDesc=document.SubForm.txtSubSDesc.value.replace('&','and');
                    if(command=="Load")
                    {
                    url="../../../../../SubServlet.view?command=Load&Major="+strMajor+"&Minor="+strMinor;
                    var req=getTransport();
                    req.open("GET",url,true);  
                    req.onreadystatechange=function()
                    {
                        processResponse(req);
                     }   
                    req.send(null);
                    }
                    
              else if(command=="Add")
              {         
                    var flag=nullCheck();
                if(flag==true)
                        {
                       url="../../../../../SubServlet.view?command=Add&Major=" + strMajor+ "&Minor=" + strMinor+"&Subid=" +strSubId+"&SubDesc="+strSubDesc+"&SubSDesc="+strSubSDesc;
                     var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
                    }
            }
      else if(command=="Delete")
      {
      if(confirm("Do You Really want to Delete the Selected Record"))
             {
        url="../../../../../SubServlet.view?command=Delete&Major=" + strMajor+ "&Minor=" + strMinor+"&Subid=" +strSubId+"&SubDesc="+strSubDesc+"&SubSDesc="+strSubSDesc;
        var req=getTransport();
        req.open("GET",url,true);        
        req.onreadystatechange=function()
        { 
            processResponse(req);
        }    
        req.send(null);
        }
                    
                    else
                    {
                      alert("Records are not Deleted ");
                    }
      }
      
      else if(command=="Update")
      {
            var flag=nullCheck();
             if(flag==true)
             {  
        url="../../../../../SubServlet.view?command=Update&Major=" + strMajor+ "&Minor=" + strMinor+"&Subid=" +hstrSubId+"&SubDesc="+strSubDesc+"&SubSDesc="+strSubSDesc;
        var req=getTransport();
        req.open("GET",url,true);        
        req.onreadystatechange=function()
        {
           processResponse(req);
         }  
        req.send(null);
        }
      }
}

function deleteRow(baseResponse)
  {
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                      var Subid=baseResponse.getElementsByTagName("Subid")[0].firstChild.nodeValue;
                      var tbody=document.getElementById("Existing"); 
                      var r=document.getElementById(Subid);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                                document.SubForm.txtSubId.value="";        
                                document.SubForm.txtSubDesc.value="";
                                document.SubForm.txtSubSDesc.value="";
                                document.SubForm.txtSubId.disabled=true;

                      alert("Selected Sub System Details are Deleted");                      
                  }
                  else
                  {
                      alert("Unable to Delete");
                  }
   
  }

function addRow(baseResponse)
    {
                       

              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                       
                      alert("Record inserted into the database successfully");
                            var SubId=document.SubForm.txtSubId.value;
                            var SubDesc=document.SubForm.txtSubDesc.value;
                            var SubSDesc=document.SubForm.txtSubSDesc.value;
                    
                          var tbody=document.getElementById("tblList");
                              var table=document.getElementById("Existing");
                         var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                          
                          
                          mycurrent_row.id=SubId;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+SubId;
                          anc.href="javascript:loadValuesFromTable('"+SubId+"')";
                          var edit=document.createTextNode("Edit");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Subid=document.createTextNode(SubId);
                          var Subdesc=document.createTextNode(SubDesc);
                          var Subsdesc=document.createTextNode(SubSDesc);
                          
                          
                          cell1.appendChild(Subid);
                          cell2.appendChild(Subdesc);
                          cell3.appendChild(Subsdesc);
                          
                          
                            mycurrent_row.appendChild(cell);
                            mycurrent_row.appendChild(cell1);
                            mycurrent_row.appendChild(cell2);
                            mycurrent_row.appendChild(cell3);
                           
                          tbody.appendChild(mycurrent_row);
                          table.appendChild(tbody);
                          document.SubForm.txtSubId.value="";
                            document.SubForm.txtSubDesc.value="";
                            document.SubForm.txtSubSDesc.value="";
                            document.SubForm.txtSubId.disabled=false;
                          }
                       
                  
                  else
                  {
                      alert("Failed to Insert values");                     
                  }

    }

  function checkForRedundancy()
{
                    var strMajor=document.SubForm.CmbMajorId.value;
                    var strMinor=document.SubForm.CmbMinorId.value;
                    var strSubId=document.SubForm.txtSubId.value;
                    var strSubDesc=document.SubForm.txtSubDesc.value;
                    var strSubSDesc=document.SubForm.txtSubSDesc.value;
   
   if((strMajor=="")&&(strMinor=="")&&(strSub=="")&&(strMenuId=="")&&(strMenuDesc=="")&&(strMenuSDesc==""))
          {           
          
              alert("Select Major Id---It Shouldnt be empty");
                return true;
            }
            else 
            {
                   
                       url="../../../../../SubServlet.view?command=check&Major=" + strMajor+ "&Minor=" + strMinor+"&Subid=" +strSubId+"&SubDesc="+strSubDesc+"&SubSDesc="+strSubSDesc;
                    var req=getTransport();
                    req.open("GET",url,true);
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
            }
}

function checkRow(baseResponse)
{ 
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                      alert("Record exists so Insertion is not possible");
                       document.SubForm.CmdDelete.disabled=false;
                       document.SubForm.CmdUpdate.disabled=false;
                        document.SubForm.CmdAdd.disabled=true;
                      
                  }
                  else
                  {
                  
                  callServer('Add','null');
                  }
 
}

function updateRow(baseResponse)
    {
     
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       if(flag=="success")
       {   
           alert("Record Updated Successfully.");
           var strSubId=document.SubForm.txtSubId.value;
                    var hstrSubId=document.SubForm.htxtSubId.value;
                    hstrSubId=strSubId;
                             var items=new Array();
                            items[0]=hstrSubId;
                            items[1]=document.SubForm.txtSubDesc.value;
                            items[2]=document.SubForm.txtSubSDesc.value;
                      var r=document.getElementById(items[0]);    
                      var rcells=r.cells;
                        rcells.item(1).firstChild.nodeValue=items[0];
                        rcells.item(2).firstChild.nodeValue=items[1];
                        rcells.item(3).firstChild.nodeValue=items[2];
                            document.SubForm.txtSubId.value="";
                            document.SubForm.txtSubDesc.value="";
                            document.SubForm.txtSubSDesc.value="";
                            document.SubForm.txtSubId.disabled=false;
                      
     
       }
       else
       {
           alert("failed to update values");
       }                                  
    }
    
    
function nullCheck()
        {
                  
                  if((document.SubForm.CmbMajorId.value=="") || (document.SubForm.CmbMajorId.value<=0))
                  { 
                       alert("Please Select the Major Id");
                       document.SubForm.CmbMajorId.focus();
                       return false;
                  }
                else if((document.SubForm.CmbMinorId.value=="") || (document.SubForm.CmbMinorId.value<=0))
                  { 
                       alert("Please Enter the Minor Id");
                       document.SubForm.CmbMinorId.focus();
                       return false;
                  }
                  else if((document.SubForm.txtSubId.value=="") || (document.SubForm.txtSubId.value<=0))
                  { 
                       alert("Please Enter the Sub System Id");
                       document.SubForm.txtSubId.focus();
                       return false;
                  }

                  else if((document.SubForm.txtSubDesc.value=="") || (document.SubForm.txtSubDesc.value<=0))
                  { 
                       alert("Please Enter Sub System Id Description");
                       document.SubForm.txtSubDesc.focus();
                       return false;
                  }
                 
                  else if((document.SubForm.txtSubSDesc.value=="") || (document.SubForm.txtSubSDesc.value<=0))
                  { 
                       alert("Please Enter The Sub System short Description");
                       document.SubForm.txtSubSDesc.focus();
                       return false;
                  }
                  return true;
            }                              