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
   document.CadreForm.htxtCadreId.value="";
   document.CadreForm.txtCadreName.value="";
   document.CadreForm.txtCadresName.value="";
  
   document.CadreForm.txtRemarks.value="";
   document.CadreForm.CmdAdd.disabled=false;
   document.CadreForm.CmdUpdate.disabled=true;
   document.CadreForm.CmdDelete.disabled=true;
   
  
 }
 
 function Exit()
 {
    self.close();
 }
 
  function loadValuesFromTable(rid)
    {      
          var r=document.getElementById(rid); 
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          
          document.CadreForm.htxtCadreId.value=rcells.item(1).firstChild.nodeValue;
          document.CadreForm.txtCadreName.value=rcells.item(2).firstChild.nodeValue;
          document.CadreForm.txtCadresName.value=rcells.item(3).firstChild.nodeValue;
    
          document.CadreForm.txtRemarks.value=rcells.item(4).firstChild.nodeValue;
          document.CadreForm.CmdAdd.disabled=true;
        document.CadreForm.CmdUpdate.disabled=false;
        document.CadreForm.CmdDelete.disabled=false;
        
          document.CadreForm.CmdDelete.focus();
      
    }
    
    
     function nullCheck()
        {
                  
                  if((document.CadreForm.txtCadreName.value=="") || (document.CadreForm.txtCadreName.value<=0))
                  { 
                       alert("Please Enter the Bank Name");
                       document.CadreForm.txtCadreName.focus();
                       return false;
                  }
                 else if((document.CadreForm.txtCadresName.value=="") || (document.CadreForm.txtCadresName.value<=0))
                  { 
                       alert("Please Enter the Bank Short Name");
                       document.CadreForm.txtCadresName.focus();
                       return false;
                  }
               
                  return true;
            } 
            
            
            
            
            
            
            
            
 function callServer(command,param)
 {
       var hstrCadreId=document.CadreForm.htxtCadreId.value;
      
       var strCadreName=document.CadreForm.txtCadreName.value;
       var strCadresName=document.CadreForm.txtCadresName.value;
      
       var strRemarks=document.CadreForm.txtRemarks.value;
        var url="";
        
       
       if(command=="Add")
        {              var flag=nullCheck();
                    if(flag==true)
                    {
                    url="../../../../../HRM_BankMasterServlet.view?command=Add&CadreName=" + strCadreName+"&CadresName=" + strCadresName+"&CadreRemarks="+strRemarks;
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
                    url="../../../../../HRM_BankMasterServlet.view?command=Update&CadreId="+hstrCadreId+"&CadreName="+strCadreName+"&CadresName=" + strCadresName+"&CadreRemarks="+strRemarks;
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
                    url="../../../../../HRM_BankMasterServlet.view?command=Delete&CadreId="+hstrCadreId;
                   var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
        }
        else if(command=="Get")
        {               
                          url="../../../../../HRM_BankMasterServlet.view?command=Get";
                         var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               processResponse(req);
            }   
                    req.send(null);
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
               else if(command=="Get")
              { 
              getRow(baseResponse);
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
               var items=new Array();
               items[0]=document.CadreForm.htxtCadreId.value;
               items[1]=document.CadreForm.txtCadreName.value;
               items[2]=document.CadreForm.txtCadresName.value;
               items[3]=document.CadreForm.txtRemarks.value;
              
                      
                            var r=document.getElementById(items[0]);    
                            var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1].toUpperCase();
                            rcells.item(3).firstChild.nodeValue=items[2].toUpperCase();
                            rcells.item(4).firstChild.nodeValue=items[3];
                                              
                            document.CadreForm.htxtCadreId.value="";
                            document.CadreForm.txtCadreName.value="";
                            document.CadreForm.txtCadresName.value="";
                            document.CadreForm.txtRemarks.value="";
                           
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
                      var CadreId=baseResponse.getElementsByTagName("CadreId")[0].firstChild.nodeValue;
                      var tbody=document.getElementById("Existing");     
                      var r=document.getElementById(CadreId);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                                document.CadreForm.htxtCadreId.value="";
                               document.CadreForm.txtCadreName.value="";
                               document.CadreForm.txtCadresName.value="";
                               document.CadreForm.txtRemarks.value="";
                               
                      alert("Selected Bank Id Details are Deleted");                      
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
                     did=baseResponse.getElementsByTagName("CadreId")[0].firstChild.nodeValue; 
                     var items=new Array();                                     
                     cadid=baseResponse.getElementsByTagName("CadreId")[0].firstChild.nodeValue;
                     cadn=document.CadreForm.txtCadreName.value;
                     cadsn=document.CadreForm.txtCadresName.value;                     
                     
                     cadn=cadn.toUpperCase();
                     cadsn =cadsn.toUpperCase();                     
                    
                     remark=document.CadreForm.txtRemarks.value;
              
                     var tbody=document.getElementById("tblList");
                     var mycurrent_row=document.createElement("TR");
                     mycurrent_row.id=cadid;
                     var cell=document.createElement("TD");
                     var anc=document.createElement("A");       
                     var url="javascript:loadValuesFromTable('" + cadid + "')";              
                     anc.href=url;
                     var txtedit=document.createTextNode("Edit");
                     anc.appendChild(txtedit);
                     cell.appendChild(anc);
                     mycurrent_row.appendChild(cell);
                     
                     var cell1=document.createElement("TD");  
                     var cdid=document.createTextNode(cadid);
                     cell1.appendChild(cdid);
                     mycurrent_row.appendChild(cell1);
                     
                     var cell2=document.createElement("TD");  
                     var cddesc=document.createTextNode(cadn);
                     cell2.appendChild(cddesc);
                     mycurrent_row.appendChild(cell2);
                     
                     var cell3=document.createElement("TD");  
                     var cdsdesc=document.createTextNode(cadsn);
                     cell3.appendChild(cdsdesc);
                     mycurrent_row.appendChild(cell3);
                                  
                     var cell6=document.createElement("TD");  
                     var crem=document.createTextNode(remark);
                     cell6.appendChild(crem);
                     mycurrent_row.appendChild(cell6);
                      tbody.appendChild(mycurrent_row); 
                     document.CadreForm.htxtCadreId.value="";
                               document.CadreForm.txtCadreName.value="";
                               document.CadreForm.txtCadresName.value="";
                      
                               document.CadreForm.txtRemarks.value="";
             }
             else if(flag=="failure")   
             {
                 alert("Failed to Insert Values");
             }
             else if(flag=="Already")
             {
                 alert("Bank Exist Already");
             }
             
             
   }
 
function getRow(baseResponse)
    {   
              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue; 
              
              if(flag=="success")
              {          
                       var tbody=document.getElementById("tblList");
                       var table=document.getElementById("Existing");
                        var t=0;
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }   
                                               
                            var DId=baseResponse.getElementsByTagName("CadreId");
                            
                     for(var k=0;k<DId.length;k++)
                        {
                           var DId=baseResponse.getElementsByTagName("CadreId");
                            var DDesc=baseResponse.getElementsByTagName("CadreName");
                            var DsDesc=baseResponse.getElementsByTagName("CadresName");
                         
                            var Rem=baseResponse.getElementsByTagName("Remarks");
                            
                        var cDId=DId.item(k).firstChild.nodeValue;
                        var cDDesc=DDesc.item(k).firstChild.nodeValue;
                        var cDsDesc=DsDesc.item(k).firstChild.nodeValue;
                                                  
                        var cRem=Rem.item(k).firstChild.nodeValue;
                    
                    
                       if(cRem=="UnDefined Record Found")
                              cRem=" ";
                       else
                            cRem=cRem;
                            
                       
                                
                      
                     var mycurrent_row=document.createElement("TR");
                     mycurrent_row.id=cDId;
                     var cell=document.createElement("TD");
                     var anc=document.createElement("A");       
                     var url="javascript:loadValuesFromTable('" + cDId + "')";              
                     anc.href=url;
                     var txtedit=document.createTextNode("Edit");
                     anc.appendChild(txtedit);
                     cell.appendChild(anc);
                     mycurrent_row.appendChild(cell);
                     
                         var cell2 =document.createElement("TD");    
                         var desid=document.createTextNode(cDId);                         
                         cell2.appendChild(desid);       
                         mycurrent_row.appendChild(cell2);       

                         var cell3 =document.createElement("TD");    
                         var desdesc=document.createTextNode(cDDesc);                         
                         cell3.appendChild(desdesc);       
                         mycurrent_row.appendChild(cell3);       
                         
                         var cell4 =document.createElement("TD");    
                         var dessdesc=document.createTextNode(cDsDesc);                         
                         cell4.appendChild(dessdesc);       
                         mycurrent_row.appendChild(cell4);       
                  
                      
                        var cell7 =document.createElement("TD");    
                         var rema=document.createTextNode(cRem);                         
                         cell7.appendChild(rema);       
                         mycurrent_row.appendChild(cell7); 
                         tbody.appendChild(mycurrent_row); 
                         
                         }
                     
             }
             else
             {
                     alert("Failed to Load Values");
             }
    }