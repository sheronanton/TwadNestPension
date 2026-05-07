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


function toCheckNumeric1()
{
          if(!isNaN(document.MinorForm.txtMinorId.value))
                  { 
                       alert("Please Enter the Minor Id - in Characters - Numeric not allowed");
                       document.MinorForm.txtMinorId.value="";
                       document.MinorForm.txtMinorId.focus();
                       return false;
                  }
                  return true;
}  
function toCheckNumeric2()
{
                  if(!isNaN(document.MinorForm.txtMinorDesc.value))
                  { 
                       alert("Please Enter the Minor System Description in character");
                       document.MinorForm.txtMinorDesc.value="";
                       document.MinorForm.txtMinorDesc.focus();
                       return false;
                  }
                  return true;
}
function toCheckNumeric3()
{
                  if(!isNaN(document.MinorForm.txtMinorSDesc.value))
                  { 
                       alert("Please Enter the Minor System Short Description in charaters");
                       document.MinorForm.txtMinorSDesc.value="";
                       document.MinorForm.txtMinorSDesc.focus();
                       return false;
                  }
                   return true;
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
              else if(command=="check")
              {
              checkRow(baseResponse);
              }
              else if(command=="Delete")
              {
              deleteRow(baseResponse);
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


function loadRow(baseResponse)
 {
                        var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                        if(flag=="NoRecord")
                {
                var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                      //  alert("Record Does't Exists For the Selected Major-System-Id");
                document.MinorForm.CmbMajorId.focus();
                
                }
                  else if(flag=="success")
                  {
                   // alert("Record exists");
                      //document.MinorForm.CmdAdd.disabled=true;
                     // document.MinorForm.CmdUpdate.disabled=false;
                     // document.MinorForm.CmdDelete.disabled=false;
                     var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                          var items=new Array();
                              var majorid=baseResponse.getElementsByTagName("MAJOR_ID"); 
                              var minorid=baseResponse.getElementsByTagName("MINOR_ID"); 
                              var minordesc=baseResponse.getElementsByTagName("MINOR_DESC");
                              var minorsdesc=baseResponse.getElementsByTagName("MINOR_SDESC"); 
                              var j=0;
                              var l=minorid.length;
                          
                         for(j=0;j<l;j++)
                          {
                             var majorid=baseResponse.getElementsByTagName("MAJOR_ID"); 
                              var minorid=baseResponse.getElementsByTagName("MINOR_ID"); 
                              var minordesc=baseResponse.getElementsByTagName("MINOR_DESC");
                              var minorsdesc=baseResponse.getElementsByTagName("MINOR_SDESC"); 
                              
                            var tmajorid=majorid.item(j).firstChild.nodeValue;
                            var tminorid=minorid.item(j).firstChild.nodeValue;
                            var tminordesc=minordesc.item(j).firstChild.nodeValue;
                            var tminorsdesc=minorsdesc.item(j).firstChild.nodeValue;
                            
                          var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                          
                          mycurrent_row.id=tminorid;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+tminorid;
                          anc.href="javascript:loadValuesFromTable('"+tminorid+"')";
                          var edit=document.createTextNode("EDIT");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Minorid=document.createTextNode(tminorid);
                          var MinorDesc=document.createTextNode(tminordesc);
                          var MinorSDesc=document.createTextNode(tminorsdesc);
                          
                          cell1.appendChild(Minorid);
                          cell2.appendChild(MinorDesc);
                          cell3.appendChild(MinorSDesc);
                          
                            mycurrent_row.appendChild(cell);
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


function loadValuesFromTable(rid)
{  
var d=document.getElementById("add");
                d.style.display="none";
                var d=document.getElementById("update");
                d.style.display="block";


          var r=document.getElementById(rid); 
          var txtMinorId=document.getElementById("txtMinorId");
          var txtMinorDesc=document.getElementById("txtMinorDesc");
          var txtMinorSDesc=document.getElementById("txtMinorSDesc");
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          document.MinorForm.txtMinorId.value=rcells.item(1).firstChild.nodeValue;
          document.MinorForm.htxtMinorId.value=rcells.item(1).firstChild.nodeValue;
          document.MinorForm.txtMinorDesc.value=rcells.item(2).firstChild.nodeValue;
          document.MinorForm.txtMinorSDesc.value=rcells.item(3).firstChild.nodeValue;
          document.MinorForm.txtMinorId.disabled=true;
           document.MinorForm.CmdUpdate.disabled=false;
          document.MinorForm.CmdDelete.disabled=false;
		document.MinorForm.CmdAdd.disabled=true;

          
      
    }

function clearAll()
 {        
        document.MinorForm.CmbMajorId.selectedIndex=0;
        document.MinorForm.txtMinorId.value="";        
        document.MinorForm.txtMinorDesc.value="";
        document.MinorForm.txtMinorSDesc.value="";
         document.MinorForm.CmdUpdate.disabled=true;
         document.MinorForm.CmdDelete.disabled=true;
         document.MinorForm.CmdAdd.disabled=false;
         document.MinorForm.txtMinorId.disabled=false;
         
        var d=document.getElementById("add");
                d.style.display="block";
                var d=document.getElementById("update");
                d.style.display="none";
                
                var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }

        
 }
 function Exit()
 {
    window.open('','_parent','');
    window.close();
 }


function callServer(command,param)
 {     
             strMajorId=document.MinorForm.CmbMajorId.value;
             strMinorId=document.MinorForm.txtMinorId.value.replace('&','and');
             strhMinorId=document.MinorForm.htxtMinorId.value;
             strMinorDesc=document.MinorForm.txtMinorDesc.value.replace('&','and');
             strMinorSDesc=document.MinorForm.txtMinorSDesc.value.replace('&','and');

          
          if(command=="Load")
          {
              url="../../../../../MinorServlet.view?command=Load&MajorId=" + strMajorId;
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
                       url="../../../../../MinorServlet.view?command=Add&MajorId=" + strMajorId+ "&MinorId=" + strMinorId+"&MinorDesc="+strMinorDesc+"&MinorSDesc="+strMinorSDesc;
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
        
        url="../../../../../MinorServlet.view?command=Delete&MajorId=" + strMajorId+ "&MinorId=" + strMinorId+"&MinorDesc="+strMinorDesc+"&MinorSDesc="+strMinorSDesc;
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
        url="../../../../../MinorServlet.view?command=Update&MajorId=" + strMajorId+ "&MinorId=" + strhMinorId+"&MinorDesc="+strMinorDesc+"&MinorSDesc="+strMinorSDesc;
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
                      var Minorid=baseResponse.getElementsByTagName("Minorid")[0].firstChild.nodeValue;
                      var tbody=document.getElementById("Existing"); 
                      var r=document.getElementById(Minorid);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                      document.MinorForm.txtMinorId.value="";        
        document.MinorForm.txtMinorDesc.value="";
        document.MinorForm.txtMinorSDesc.value="";
        document.MinorForm.txtMinorId.disabled=false;
                      alert("Minor System Details are Deleted");                      
                  }
                  else
                  {
                      alert("Unable to Delete");
                  }
   
  }

function updateRow(baseResponse)
    {
     
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       if(flag=="success")
       {   
           alert("Record Updated Successfully.");
                             var items=new Array();
                            items[0]=document.MinorForm.htxtMinorId.value;
                            items[1]=document.MinorForm.txtMinorDesc.value;
                            items[2]=document.MinorForm.txtMinorSDesc.value;
                            var r=document.getElementById(items[0]);    
                           var rcells=r.cells;
                        rcells.item(1).firstChild.nodeValue=items[0];
                        rcells.item(2).firstChild.nodeValue=items[1];
                        rcells.item(3).firstChild.nodeValue=items[2];
                            document.MinorForm.txtMinorId.value="";
                            document.MinorForm.txtMinorDesc.value="";
                            document.MinorForm.txtMinorSDesc.value="";
                            document.MinorForm.txtMinorId.disabled=false;
          
                      
     
       }
       else
       {
           alert("failed to update values");
       }                                  
    }
    

function checkForRedundancy()
{
                    strMajorId=document.MinorForm.CmbMajorId.value;
             strMinorId=document.MinorForm.txtMinorId.value;
             strMinorDesc=document.MinorForm.txtMinorDesc.value;
             strMinorSDesc=document.MinorForm.txtMinorSDesc.value;
   
   if((strMajorId=="")&&(strMinorId=="")&&(strMinorDesc=="")&&(strMinorSDesc==""))
          {           
          
              alert("Select Major Id---It Shouldnt be empty");
                return true;
            }
            else 
            {
                       url="../../../../../MinorServlet.view?command=check&MajorId=" + strMajorId+ "&MinorId=" + strMinorId+"&MinorDesc="+strMinorDesc+"&MinorSDesc="+strMinorSDesc;
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
                       document.MinorForm.CmdDelete.disabled=false;
                       document.MinorForm.CmdUpdate.disabled=false;
                        document.MinorForm.CmdAdd.disabled=true;
                      
                  }
                  else
                  {
                  
                  callServer('Add','null');
                  }
 
}
    
    
function addRow(baseResponse)
    {
                       

              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                       
                      alert("Record inserted into the database successfully");
                      strMajorId=document.MinorForm.CmbMajorId.value;
             strMinorId=document.MinorForm.txtMinorId.value.toUpperCase();
             strMinorDesc=document.MinorForm.txtMinorDesc.value;
             strMinorSDesc=document.MinorForm.txtMinorSDesc.value;
             
             var tbody=document.getElementById("tblList");
                              var table=document.getElementById("Existing");
                         var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                          
                         
                          
                          mycurrent_row.id=strMinorId;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+strMinorId;
                          anc.href="javascript:loadValuesFromTable('"+strMinorId+"')";
                          var edit=document.createTextNode("EDIT");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Minorid=document.createTextNode(strMinorId);
                          var MinorDesc=document.createTextNode(strMinorDesc);
                          var MinorSDesc=document.createTextNode(strMinorSDesc);
                          
                          cell1.appendChild(Minorid);
                          cell2.appendChild(MinorDesc);
                          cell3.appendChild(MinorSDesc);
                          
                            mycurrent_row.appendChild(cell);
                            mycurrent_row.appendChild(cell1);
                            mycurrent_row.appendChild(cell2);
                            mycurrent_row.appendChild(cell3);
                          
                          tbody.appendChild(mycurrent_row);
                          document.MinorForm.txtMinorId.value="";
                            document.MinorForm.txtMinorDesc.value="";
                            document.MinorForm.txtMinorSDesc.value="";
                            document.MinorForm.txtMinorId.disabled=false;
                          
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
                          

function nullCheck()
        {
                  
                  if((document.MinorForm.CmbMajorId.value=="") || (document.MinorForm.CmbMajorId.value<=0))
                  { 
                       alert("Please Select the Major Id");
                       document.MinorForm.CmbMajorId.focus();
                       return false;
                  }
                else if((document.MinorForm.txtMinorId.value=="") || (document.MinorForm.txtMinorId.value<=0))
                  { 
                       alert("Please Enter the Minor Id");
                       document.MinorForm.txtMinorId.focus();
                       return false;
                  }

                  else if((document.MinorForm.txtMinorDesc.value=="") || (document.MinorForm.txtMinorDesc.value<=0))
                  { 
                       alert("Please Enter Minor Id Description");
                       document.MinorForm.txtMinorDesc.focus();
                       return false;
                  }
                 
                  else if((document.MinorForm.txtMinorSDesc.value=="") || (document.MinorForm.txtMinorSDesc.value<=0))
                  { 
                       alert("Please Enter The Minor System short Description");
                       document.MinorForm.txtMinorSDesc.focus();
                       return false;
                  }
                  return true;
            }                          