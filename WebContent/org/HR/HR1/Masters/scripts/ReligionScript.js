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
 document.ReligForm.htxtReligCode.value="";
   document.ReligForm.txtReligName.value="";
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
          document.ReligForm.htxtReligCode.value=rcells.item(1).firstChild.nodeValue;
          document.ReligForm.txtReligName.value=rcells.item(2).firstChild.nodeValue;
        
    }
    
 function callServer(command,param)
 {
   
       var hstrReligCode=document.ReligForm.htxtReligCode.value;
       var strReligName=document.ReligForm.txtReligName.value;
       
        var url="";
       
       if(command=="Add")
        {              
                    if(document.ReligForm.txtReligName.value=="")
                    {
                       alert("Please Enter the Religion Description");
                    }
                    else
                    {
                    url="../../../../../ReligionServlet.view?command=Add&ReligName=" + strReligName;
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
                    
                    if(document.ReligForm.txtReligName.value=="")
                    {
                       alert("Please Enter the Religion Description");
                    }
                    else
                    {
                    url="../../../../../ReligionServlet.view?command=Update&ReligCode="+hstrReligCode+"&ReligName="+strReligName;
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
                    url="../../../../../ReligionServlet.view?command=Delete&ReligCode="+hstrReligCode;
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
               var hstrReligCode=document.ReligForm.htxtReligCode.value;
                            var items=new Array();
                            items[0]=hstrReligCode;
                            items[1]=document.ReligForm.txtReligName.value;
                              var r=document.getElementById(items[0]);    
                              var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1];
                       
                            document.ReligForm.txtReligName.value="";
                            document.ReligForm.htxtReligCode.value="";
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
                      var Religcode=baseResponse.getElementsByTagName("ReligCode")[0].firstChild.nodeValue;
                      var tbody=document.getElementById("Existing");     
                      var r=document.getElementById(Religcode);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                               document.ReligForm.txtReligName.value="";
                               document.ReligForm.htxtReligCode.value="";
                      alert("Selected Religion Code Details are Deleted");                      
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
                     rsid=baseResponse.getElementsByTagName("ReligCode")[0].firstChild.nodeValue; 
                      alert("Please Note Down Your Religion Code " +  rsid);
                     var items=new Array();                   
                    items[0]=baseResponse.getElementsByTagName("ReligCode")[0].firstChild.nodeValue;
                   items[1]=document.ReligForm.txtReligName.value;
              
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
                            document.ReligForm.txtReligName.value="";
                            document.ReligForm.htxtReligCode.value="";
             }
             else
             {
                     alert("Failed to Insert Values");
             }
    }
 
 