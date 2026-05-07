
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
               // alert("Record Does't Exists For the Given Major System");
                document.MajorForm.txtMajorDesc.focus();
               // document.MajorForm.CmdUpdate.disabled=true;
                   //   document.MajorForm.CmdDelete.disabled=true;
                
                }
                  else if(flag=="success")
                  {
                      alert("Record exists so Insertion is not possible");
                      var strmajid=document.MajorForm.txtMajorID.value;
                       var hstrmajid=document.MajorForm.htxtMajorID.value;
                       hstrmajid=strmajid;
                      document.MajorForm.txtMajorID.disabled=true;
                      document.MajorForm.CmdAdd.disabled=true;
                      document.MajorForm.CmdUpdate.disabled=false;
                      document.MajorForm.CmdDelete.disabled=false;
                      var tbody=document.getElementById("tblList");
                        var t=0;
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                        
                        var Majorid=baseResponse.getElementsByTagName("majid");
                          var Majordesc=baseResponse.getElementsByTagName("majordesc"); 
                          var MajorSdesc=baseResponse.getElementsByTagName("majsdesc");
                         var items=new Array(); 
                         var j=0;
                         var l=Majorid.length;
                         for(j=0;j<l;j++)
                          {
                               var txtMajorid=Majorid.item(j).firstChild.nodeValue;
                            var txtMajordesc=Majordesc.item(j).firstChild.nodeValue;
                            var txtMajorsdesc=MajorSdesc.item(j).firstChild.nodeValue;
                            
                            var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                          
                          mycurrent_row.id=txtMajorid;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+txtMajorid;
                          anc.href="javascript:loadValuesFromTable('"+txtMajorid+"')";
                          var edit=document.createTextNode("EDIT");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Majid=document.createTextNode(txtMajorid);
                          var Majdesc=document.createTextNode(txtMajordesc);
                          var Majsdesc=document.createTextNode(txtMajorsdesc);
                          
                          cell1.appendChild(Majid);
                          cell2.appendChild(Majdesc);
                          cell3.appendChild(Majsdesc);
                          
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
                     document.MajorForm.CmdAdd.disabled=false;
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
          var txtMajorID=document.getElementById("txtMajorID");
          var txtMajorDesc=document.getElementById("txtMajorDesc");
          var txtMajorSDesc=document.getElementById("txtMajorSDesc");
          
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          document.MajorForm.txtMajorID.value=rcells.item(1).firstChild.nodeValue;
          document.MajorForm.htxtMajorID.value=rcells.item(1).firstChild.nodeValue;
          document.MajorForm.txtMajorDesc.value=rcells.item(2).firstChild.nodeValue;
          document.MajorForm.txtMajorSDesc.value=rcells.item(3).firstChild.nodeValue;
          document.MajorForm.txtMajorID.disabled=true;
          
          document.MajorForm.CmdDelete.disabled=false;
          document.MajorForm.CmdUpdate.disabled=false;
		document.MajorForm.CmdAdd.disabled=true;

}    

function nullCheck()
        {
                  
                  if((document.MajorForm.txtMajorID.value=="") || (document.MajorForm.txtMajorID.value<=0))
                  { 
                       alert("Please Enter the Major Id");
                       document.MajorForm.txtMajorID.value="";
                       document.MajorForm.txtMajorID.focus();
                       return false;
                  }
                  
                else if((document.MajorForm.txtMajorDesc.value=="") || (document.MajorForm.txtMajorDesc.value<=0))
                  { 
                       alert("Please Enter the Major System Description");
                       document.MajorForm.txtMajorDesc.value=="";
                       document.MajorForm.txtMajorDesc.focus();
                       return false;
                  }
                  else if((document.MajorForm.txtMajorSDesc.value=="") || (document.MajorForm.txtMajorSDesc.value<=0))
                  { 
                       alert("Please Enter the Major System Short Description");
                       document.MajorForm.txtMajorSDesc.value=="";
                       document.MajorForm.txtMajorSDesc.focus();
                       return false;
                  }
                  
                  return true;
            }     
            
function toCheckNumeric1()
{
          if(!isNaN(document.MajorForm.txtMajorID.value))
                  { 
                       alert("Please Enter the Major Id - in Characters - Numeric not allowed");
                       document.MajorForm.txtMajorID.value="";
                       document.MajorForm.txtMajorID.focus();
                       return false;
                  }
                  return true;
}  
function toCheckNumeric2()
{
                  if(!isNaN(document.MajorForm.txtMajorDesc.value))
                  { 
                       alert("Please Enter the Major  System Description in character");
                       document.MajorForm.txtMajorDesc.value="";
                       document.MajorForm.txtMajorDesc.focus();
                       return false;
                  }
                  return true;
}
function toCheckNumeric3()
{
                  if(!isNaN(document.MajorForm.txtMajorSDesc.value))
                  { 
                       alert("Please Enter the Major System Short Description in charaters");
                       document.MajorForm.txtMajorSDesc.value="";
                       document.MajorForm.txtMajorSDesc.focus();
                       return false;
                  }
                   return true;
}

function callServer(command,param)
 {
   
       var strmajid=document.MajorForm.txtMajorID.value;
       var hstrmajid=document.MajorForm.htxtMajorID.value;
       hstrmajid=strmajid;
       hstrmajid=hstrmajid.toUpperCase();
       var strmajdesc=document.MajorForm.txtMajorDesc.value.replace('&','and');
       var strmajsdesc=document.MajorForm.txtMajorSDesc.value.replace('&','and');
      
       if(command=="Load")
        {
                    var strmajid=document.MajorForm.txtMajorID.value;
                    url="../../../../../MajorServlet1.view?command=Load&MajorId="+hstrmajid;
                    //alert(url);
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
                    url="../../../../../MajorServlet1.view?command=Add&MajorId="+strmajid+"&MajorDesc=" + strmajdesc+ "&MajorSDesc="+strmajsdesc;
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
                    url="../../../../../MajorServlet1.view?command=Update&MajorId="+hstrmajid+"&MajorDesc=" + strmajdesc+ "&MajorSDesc="+strmajsdesc;
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
                    url="../../../../../MajorServlet1.view?command=Delete&MajorId="+strmajid+"&MajorDesc=" + strmajdesc+ "&MajorSDesc="+strmajsdesc;
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


function addRow(baseResponse)
    {
                       

              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                       
                      alert("Record inserted into the database successfully");
                      
                      var Majorid=document.MajorForm.txtMajorID.value.toUpperCase();
                      var Majordesc=document.MajorForm.txtMajorDesc.value;
                      var Majorsdesc=document.MajorForm.txtMajorSDesc.value;
                      var tbody=document.getElementById("tblList");
                         var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                          
                          mycurrent_row.id=Majorid;
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+Majorid;
                          anc.href="javascript:loadValuesFromTable('"+Majorid+"')";
                          var edit=document.createTextNode("EDIT");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                     
                         var majid=document.createTextNode(Majorid);                         
                         var majdesc=document.createTextNode(Majordesc); 
                         var majsdesc=document.createTextNode(Majorsdesc);
                         
                         cell1.appendChild(majid);       
                         cell2.appendChild(majdesc);       
                         cell3.appendChild(majsdesc);
                         
                         mycurrent_row.appendChild(cell1);       
                         mycurrent_row.appendChild(cell2);       
                         mycurrent_row.appendChild(cell3);
                         
                     tbody.appendChild(mycurrent_row); 
                     document.MajorForm.txtMajorID.value="";
                            document.MajorForm.txtMajorDesc.value="";
                            document.MajorForm.txtMajorSDesc.value="";
                            document.MajorForm.txtMajorID.disabled=false;
                  }
                  
                  else
                  {
                      alert("Failed to Insert values");                     
                  }

    }

function clearAll()
 {        
        document.MajorForm.txtMajorID.value="";
        document.MajorForm.txtMajorDesc.value="";
         document.MajorForm.txtMajorSDesc.value="";
          document.MajorForm.txtMajorID.disabled=false;
          document.MajorForm.CmdAdd.disabled=false;
          document.MajorForm.CmdUpdate.disabled=true;
          document.MajorForm.CmdDelete.disabled=true;
          
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

 function deleteRow(baseResponse)
  {
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                      clearAll();
                      var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }
                      alert("Major System Details are Deleted");                      
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
           var strmajid=document.MajorForm.txtMajorID.value;
       var hstrmajid=document.MajorForm.htxtMajorID.value;
       hstrmajid=strmajid;
       
                            var items=new Array();
                            items[0]=hstrmajid;
                            items[1]=document.MajorForm.txtMajorDesc.value;
                            items[2]=document.MajorForm.txtMajorSDesc.value;
                            
                      var r=document.getElementById(items[0]);    
                      var rcells=r.cells;
                        rcells.item(1).firstChild.nodeValue=items[0];
                        rcells.item(2).firstChild.nodeValue=items[1];
                        rcells.item(3).firstChild.nodeValue=items[2];
                        
                            document.MajorForm.txtMajorID.value="";
                            document.MajorForm.txtMajorDesc.value="";
                            document.MajorForm.txtMajorSDesc.value="";
                            document.MajorForm.txtMajorID.disabled=false;
                        
                        
     
       }
       else
       {
           alert("failed to update values");
       }                                  
    }
 
 function checkForRedundancy()
{
                    var strMajorID=document.MajorForm.txtMajorID.value;
                    var strMajorDesc=document.MajorForm.txtMajorDesc.value;
                    var strMajorSDesc=document.MajorForm.txtMajorSDesc.value;
   
   if((strMajorID=="")&&(strMajorDesc=="")&&(strMajorSDesc==""))
          {           
          
              alert("Enter Major Id---It Shouldnt be empty");
                return true;
            }
            else 
            {  
                   
                       url="../../../../../MajorServlet1.view?command=check&MajorId="+strMajorID+"&MajorDesc=" + strMajorDesc+ "&MajorSDesc="+strMajorSDesc;
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
                     // alert("Record exists so Insertion is not possible");
                      var strmajid=document.MajorForm.txtMajorID.value;
                       var hstrmajid=document.MajorForm.htxtMajorID.value;
                       hstrmajid=strmajid;
                      document.MajorForm.txtMajorID.disabled=true;
                     document.MajorForm.CmdDelete.disabled=false;
                       document.MajorForm.CmdUpdate.disabled=false;
                        document.MajorForm.CmdAdd.disabled=true;
                        alert("Record exists so Insertion is not possible");
                        
                      
                  }
                  else
                  {
                  
                  callServer('Add','null');
                  }
 
}
