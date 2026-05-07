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


function calins(e,t)
{
    var unicode=e.charCode? e.charCode : e.keyCode;
       
        
        if (unicode!=8 && unicode !=9 && unicode!=37 && unicode !=39 && unicode !=45 && unicode !=47    )
        {
           
             if (unicode<48||unicode>57  ) 
                return false 
        }
       
}



 
 function clearAll()
 {
   document.PayForm.txtPayScaleId.value="";
   document.PayForm.txtPayScale.value="";
   document.PayForm.CmdAdd.disabled=false;
   document.PayForm.CmdUpdate.disabled=true;
   document.PayForm.CmdDelete.disabled=true;
   document.PayForm.txtPayScaleId.disabled=false;
  /* var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }*/
 }
 
  function Exit()
 {
    window.open('','_parent','');
    window.close();
 }

 
  function loadValuesFromTable(rid)
    {      
          var r=document.getElementById(rid); 
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          document.PayForm.txtPayScaleId.value=rcells.item(1).firstChild.nodeValue;
          document.PayForm.htxtPayScaleId.value=rcells.item(1).firstChild.nodeValue;
          document.PayForm.txtPayScale.value=rcells.item(2).firstChild.nodeValue;
          document.PayForm.CmdAdd.disabled=true;
        document.PayForm.CmdUpdate.disabled=false;
        document.PayForm.CmdDelete.disabled=false;
        document.PayForm.txtPayScaleId.disabled=true;
          document.PayForm.CmdDelete.focus();
      
    }
    
 function nullCheck()
        {
                  
                  if((document.PayForm.txtPayScaleId.value=="") || (document.PayForm.txtPayScaleId.value<=0))
                  { 
                       alert("Please Enter the Pay Scale Id");
                       document.PayForm.txtPayScaleId.focus();
                       return false;
                  }
                else if((document.PayForm.txtPayScale.value=="") || (document.PayForm.txtPayScale.value<=0))
                  { 
                       alert("Please Enter the Pay Scale");
                       document.PayForm.txtPayScale.focus();
                       return false;
                  }
                  return true;
            }       

 function callServer(command,param)
 {
   
       var strPayScaleId=document.PayForm.txtPayScaleId.value;
       var hstrPayScaleId=document.PayForm.htxtPayScaleId.value;
       hstrPayScaleId=strPayScaleId;
       var strPayScale=document.PayForm.txtPayScale.value;
       
       var flag=nullCheck();
       if(command=="Add")
        {              
                    if(flag==true)
                    {
                    url="../../../../../PayScale_Servlet.view?command=Add&PayScaleId="+strPayScaleId+"&PayScale=" + strPayScale;
                    var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               processResponse(req);
            }   
                    req.send(null);
                    }
                    
        }
        else if(command=="Update")
        {
                    
                    if(flag==true)
                    {
                    url="../../../../../PayScale_Servlet.view?command=Update&PayScaleId="+hstrPayScaleId+"&PayScale="+strPayScale;
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
                    url="../../../../../PayScale_Servlet.view?command=Delete&&PayScaleId="+strPayScaleId;
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
              else if(command=="Update")
              {
              updateRow(baseResponse);
              }
          }
        }
  }

function updateRow(baseResponse)
    {
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       if(flag=="success")
       {   
           alert("Record Updated Successfully.");
               var strPayScaleId=document.PayForm.txtPayScaleId.value;
               var hstrPayScaleId=document.PayForm.htxtPayScaleId.value;
               hstrPayScaleId=strPayScaleId;
                            var items=new Array();
                            items[0]=hstrPayScaleId;
                            items[1]=document.PayForm.txtPayScale.value;
                              var r=document.getElementById(items[0]);    
                              var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1];
                       
                            document.PayForm.txtPayScaleId.value="";
                            document.PayForm.txtPayScale.value="";
                            document.PayForm.txtPayScaleId.disabled=false;
       }
       else
       {
           alert("failed to update values");
       }                                  
    }

function deleteRow(baseResponse)
  {
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  
                  if(flag=="success")
                  {
                      var PayScaleId=baseResponse.getElementsByTagName("PayScaleId")[0].firstChild.nodeValue;
                      var tbody=document.getElementById("Existing");     
                      var r=document.getElementById(PayScaleId);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                                document.PayForm.txtPayScaleId.value="";
                               document.PayForm.txtPayScale.value="";
                               document.PayForm.txtPayScaleId.disabled=false;
                      alert("Selected Pay Scale Details are Deleted");                      
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
                     alert("Record Inserted Into Database successfully.");
                     //get elements
                     var items=new Array();                   
                    items[0]=document.PayForm.txtPayScaleId.value;
                   items[1]=document.PayForm.txtPayScale.value;
              
                     var tbody=document.getElementById("tblList");
                    
                     var mycurrent_row=document.createElement("TR");
                     mycurrent_row.id=items[0];
                     var cell=document.createElement("TD");
                     
                     var anc=document.createElement("A");       
                     var url="javascript:loadValuesFromTable('" + items[0] + "')";              
                     anc.href=url;
                     var txtedit=document.createTextNode("Edit");
                     anc.appendChild(txtedit);
                     cell.appendChild(anc);
                     mycurrent_row.appendChild(cell);
                     var i=0;
                     var cell2;
                     for(i=0;i<2;i++)
                     {                                           
                         cell2=document.createElement("TD");                               
                         var currenttext=document.createTextNode(items[i]);                         
                         cell2.appendChild(currenttext);       
                         mycurrent_row.appendChild(cell2); 
                         document.PayForm.txtPayScaleId.value="";
                            document.PayForm.txtPayScale.value="";
                            document.PayForm.txtPayScaleId.disabled=false;
                     }  
                     
                     tbody.appendChild(mycurrent_row); 
                      
             }
             else
             {
                     alert("Failed to Insert Values");
             }
        
    }
    
    
    function checkForRedundancy()
{
                     var strPayScaleId=document.PayForm.txtPayScaleId.value;
                     var strPayScale=document.PayForm.txtPayScale.value;
   
   if((strPayScaleId=="")&&(strPayScale==""))
          {           
          
              alert("Enter Community Code---It Shouldnt be empty");
                return true;
            }
            else 
            {
                   
                       url="../../../../../PayScale_Servlet.view?command=check&PayScaleId="+strPayScaleId+"&PayScale="+strPayScale;
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
                    var ccode=document.PayForm.txtPayScaleId.value;
                      var hcode=document.PayForm.htxtPayScaleId.value;
                      hcode=ccode;
                      
                     document.PayForm.txtPayScaleId.disabled=true;
                       document.PayForm.CmdDelete.disabled=false;
                       document.PayForm.CmdUpdate.disabled=false;
                        document.PayForm.CmdAdd.disabled=true;
                      
                  }
                  else
                  {
                  
                  callServer('Add','null');
                  }
 
}