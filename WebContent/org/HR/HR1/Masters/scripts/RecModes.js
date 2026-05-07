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
 
 
 function clearAll()
 {
 document.RecForm.htxtRecId.value="";
   document.RecForm.txtRecDesc.value="";
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
          document.RecForm.htxtRecId.value=rcells.item(1).firstChild.nodeValue;
          document.RecForm.txtRecDesc.value=rcells.item(2).firstChild.nodeValue;
         
    }
    
function nullCheck()
{

           if((document.RecForm.txtRecDesc.value=="") || (document.RecForm.txtRecDesc.value<=0))
                  { 
                       alert("Please Enter the Recruitment Mode Desc");
                       document.RecForm.txtRecDesc.focus();
                       return false;
                  }
                  return true;
}

 function callServer(command,param)
 {
   
       var hstrRecId=document.RecForm.htxtRecId.value;
       
       var strRecDesc=document.RecForm.txtRecDesc.value;
       if(command=="Add")
        {            var flag=nullCheck();  
                    if(flag==true)
                    {
                    url="../../../../../RecModes_Servlet.view?command=Add&RecDesc=" + strRecDesc;
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
                    url="../../../../../RecModes_Servlet.view?command=Update&RecId="+hstrRecId+"&RecDesc="+strRecDesc;
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
                    url="../../../../../RecModes_Servlet.view?command=Delete&RecId="+hstrRecId;
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
               var hstrRecId=document.RecForm.htxtRecId.value;
                            var items=new Array();
                            items[0]=hstrRecId;
                            items[1]=document.RecForm.txtRecDesc.value;
                              var r=document.getElementById(items[0]);    
                              var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1];
                       
                            document.RecForm.txtRecDesc.value="";
                             document.RecForm.htxtRecId.value="";
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
                      var RecId=baseResponse.getElementsByTagName("RecId")[0].firstChild.nodeValue;
                      var tbody=document.getElementById("Existing");     
                      var r=document.getElementById(RecId);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                               document.RecForm.txtRecDesc.value="";
                                document.RecForm.htxtRecId.value="";
                      alert("Selected Recruitment Mode Details are Deleted");                      
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
                    rrid=baseResponse.getElementsByTagName("RecId")[0].firstChild.nodeValue; 
                      alert("Please Note Down Your Recruitment Mode Id " +  rrid);
                     var items=new Array();                   
                    items[0]=baseResponse.getElementsByTagName("RecId")[0].firstChild.nodeValue;
                   items[1]=document.RecForm.txtRecDesc.value;
              
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
                     }  
                     
                     tbody.appendChild(mycurrent_row); 
                            document.RecForm.txtRecDesc.value="";
                             document.RecForm.htxtRecId.value="";
                      
             }
             else
             {
                     alert("Failed to Insert Values");
             }
        
    }
   