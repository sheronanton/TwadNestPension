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
 
 function togetFocus()
 {
 document.BenForm.txtBenId.focus();
 }
 
 function clearAll()
 {
  document.BenForm.htxtBenId.value="";
   document.BenForm.txtBenDesc.value="";
   document.BenForm.txtBensDesc.value="";
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

 
  function loadValuesFromTable(rid)
    {      
    
        var d=document.getElementById("add");
                d.style.display="none";
                var d=document.getElementById("update");
                d.style.display="block";
                
          var r=document.getElementById(rid); 
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          document.BenForm.htxtBenId.value=rcells.item(1).firstChild.nodeValue;
          document.BenForm.txtBenDesc.value=rcells.item(2).firstChild.nodeValue;
          document.BenForm.txtBensDesc.value=rcells.item(3).firstChild.nodeValue;
          
          
      
    }
   
   function nullCheck()
        {
                  
                  if((document.BenForm.txtBenDesc.value=="") || (document.BenForm.txtBenDesc.value<=0))
                  { 
                     alert("Please Enter the Benfit Fund Description");
                       document.BenForm.txtBenDesc.focus();
                       return false;
                  }
                else if((document.BenForm.txtBensDesc.value=="") || (document.BenForm.txtBensDesc.value<=0))
                  { 
                       alert("Please Enter the Fund Short Description");
                       document.BenForm.txtBensDesc.focus();
                       return false;
                  }
                  return true;
            }    
 function callServer(command,param)
 {
   
       var hstrBenId=document.BenForm.htxtBenId.value;
       var strBenDesc=document.BenForm.txtBenDesc.value;
       var strBensDesc=document.BenForm.txtBensDesc.value;
        var url="";
       
       
       if(command=="Add")
        {               var flag=nullCheck();
                    if(flag==true)
                    {
                    url="../../../../../BenFunds_Servlet.view?command=Add&BenDesc=" + strBenDesc+"&BensDesc="+strBensDesc;
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
                    var flag=nullCheck();
                    if(flag==true)
                    {
                    url="../../../../../BenFunds_Servlet.view?command=Update&BenId="+hstrBenId+"&BenDesc="+strBenDesc+"&BensDesc="+strBensDesc;
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
                    url="../../../../../BenFunds_Servlet.view?command=Delete&BenId="+hstrBenId;
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
               var hstrBenId=document.BenForm.htxtBenId.value;
                            var items=new Array();
                            items[0]=hstrBenId;
                            items[1]=document.BenForm.txtBenDesc.value;
                            items[2]=document.BenForm.txtBensDesc.value;
                              var r=document.getElementById(items[0]);    
                              var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1];
                            rcells.item(3).firstChild.nodeValue=items[2];
                       
                            document.BenForm.txtBenDesc.value="";
                            document.BenForm.txtBensDesc.value="";
                            document.BenForm.htxtBenId.value="";
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
                      var BenId=document.BenForm.htxtBenId.value;
                      var tbody=document.getElementById("Existing");     
                      var r=document.getElementById(BenId);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                               document.BenForm.txtBenDesc.value="";
                               document.BenForm.txtBensDesc.value="";
                               document.BenForm.htxtBenId.value="";
                      alert("Selected Benefit Funds Details are Deleted");                      
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
              var BenId=baseResponse.getElementsByTagName("BenId")[0].firstChild.nodeValue;
                     alert("Record Inserted Into Database successfully.");
                     alert("Please Note Your Benefit Fund Id : " + BenId);
                     var items=new Array();                   
                    items[0]=baseResponse.getElementsByTagName("BenId")[0].firstChild.nodeValue;
                   items[1]=document.BenForm.txtBenDesc.value;
                   items[2]=document.BenForm.txtBenDesc.value;
              
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
                     for(i=0;i<3;i++)
                     {                                           
                         cell2=document.createElement("TD");                               
                         var currenttext=document.createTextNode(items[i]);                         
                         cell2.appendChild(currenttext);       
                         mycurrent_row.appendChild(cell2);       
                     }  
                     tbody.appendChild(mycurrent_row); 
                            document.BenForm.txtBenDesc.value="";
                            document.BenForm.txtBensDesc.value="";
                            document.BenForm.htxtBenId.value="";
             }
             else
             {
                     alert("Failed to Insert Values");
             }
    }
 
 