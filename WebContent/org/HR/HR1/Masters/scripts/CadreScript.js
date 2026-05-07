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
   document.CadreForm.cmbPayId.selectedIndex=0;
   document.CadreForm.txtRemarks.value="";
   document.CadreForm.CmdAdd.disabled=false;
   document.CadreForm.CmdUpdate.disabled=true;
   document.CadreForm.CmdDelete.disabled=true;
   
  /* var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }*/
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
          document.CadreForm.cmbPayId.value=rcells.item(4).firstChild.value;
          document.CadreForm.txtRemarks.value=rcells.item(5).firstChild.nodeValue;
          document.CadreForm.CmdAdd.disabled=true;
        document.CadreForm.CmdUpdate.disabled=false;
        document.CadreForm.CmdDelete.disabled=false;
        
          document.CadreForm.CmdDelete.focus();
      
    }
    
    
     function nullCheck()
        {
                  
                  if((document.CadreForm.txtCadreName.value=="") || (document.CadreForm.txtCadreName.value<=0))
                  { 
                       alert("Please Enter the Cadre Name");
                       document.CadreForm.txtCadreName.focus();
                       return false;
                  }
                 else if((document.CadreForm.txtCadresName.value=="") || (document.CadreForm.txtCadresName.value<=0))
                  { 
                       alert("Please Enter the Cadre Short Name");
                       document.CadreForm.txtCadresName.focus();
                       return false;
                  }
                  else if((document.CadreForm.cmbPayId.value=="") || (document.CadreForm.cmbPayId.value<=0))
                  { 
                       alert("Please Enter the Pay  Scale Id");
                       document.CadreForm.cmbPayId.focus();
                       return false;
                  }
                /*else if((document.CadreForm.txtRemarks.value=="") || (document.CadreForm.txtRemarks.value<=0))
                  { 
                       alert("Please Enter the Cadre Remarks");
                       document.CadreForm.txtRemarks.focus();
                       return false;
                  }*/
                  return true;
            }   
 function callServer(command,param)
 {
   
       
       var hstrCadreId=document.CadreForm.htxtCadreId.value;
      
       var strCadreName=document.CadreForm.txtCadreName.value;
       var strCadresName=document.CadreForm.txtCadresName.value;
       var strPayId=document.CadreForm.cmbPayId.value;
       var strRemarks=document.CadreForm.txtRemarks.value;
        var url="";
        
       
       if(command=="Add")
        {              var flag=nullCheck();
                    if(flag==true)
                    {
                    url="../../../../../CadreServlet.view?command=Add&CadreName=" + strCadreName+"&CadresName=" + strCadresName+"&PayId=" + strPayId+"&CadreRemarks="+strRemarks;
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
                    url="../../../../../CadreServlet.view?command=Update&CadreId="+hstrCadreId+"&CadreName="+strCadreName+"&CadresName=" + strCadresName+"&PayId=" + strPayId+"&CadreRemarks="+strRemarks;
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
                    url="../../../../../CadreServlet.view?command=Delete&CadreId="+hstrCadreId;
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
                          url="../../../../../CadreServlet.view?command=Get";
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
               items[3]=document.CadreForm.cmbPayId.value;
               items[4]=document.CadreForm.txtRemarks.value;
              
                      
                              var r=document.getElementById(items[0]);    
                              var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1];
                            rcells.item(3).firstChild.nodeValue=items[2];
                            rcells.item(4).firstChild.nodeValue=items[3];
                            rcells.item(5).firstChild.nodeValue=items[4];
                       
                            document.CadreForm.htxtCadreId.value="";
                            document.CadreForm.txtCadreName.value="";
                            document.CadreForm.txtCadresName.value="";
                            document.CadreForm.cmbPayId.selectedIndex=0;
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
                                 document.CadreForm.cmbPayId.selectedIndex=0;
                               document.CadreForm.txtRemarks.value="";
                               
                      alert("Selected Cadre Id Details are Deleted");                      
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
                      alert("Please Note Down Your Cadre Id " +  did);
                     var items=new Array();                                     
                   cadid=baseResponse.getElementsByTagName("CadreId")[0].firstChild.nodeValue;
               cadn=document.CadreForm.txtCadreName.value;
               cadsn=document.CadreForm.txtCadresName.value;
               payid=document.CadreForm.cmbPayId.value;
              // alert(payid);
               var payname=document.CadreForm.cmbPayId.options[document.CadreForm.cmbPayId.selectedIndex].text;
              // alert(payname);
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
                     
                     var Paycell=document.createElement("TD");
                     var pid=document.createElement("INPUT");
                     var pname=document.createTextNode(payname);
                     pid.type="HIDDEN";
                     pid.name="cadreid";
                     pid.text=payid;
                     pid.value=payid;
                     Paycell.appendChild(pid);
                     Paycell.appendChild(pname);
                     mycurrent_row.appendChild(Paycell);
                     
                     var cell6=document.createElement("TD");  
                     var crem=document.createTextNode(remark);
                     cell6.appendChild(crem);
                     mycurrent_row.appendChild(cell6);
                      tbody.appendChild(mycurrent_row); 
                     document.CadreForm.htxtCadreId.value="";
                               document.CadreForm.txtCadreName.value="";
                               document.CadreForm.txtCadresName.value="";
                                 document.CadreForm.cmbPayId.selectedIndex=0;
                               document.CadreForm.txtRemarks.value="";
             }
             else
             {
                     alert("Failed to Insert Values");
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
                    // alert("Record Loaded from the Database successfully.");
                        
                      /*var cmbPayId=document.getElementById("cmbPayId");
                        cmbPayId.innerHTML="";
                        var option=document.createElement("OPTION");
                        option.text="--Select Pay Id--";
                        try
                                {
                                cmbPayId.add(option);                
                                }catch(errorObject)
                                {
                                cmbPayId.add(option,null);
                                }
                                */
                              
                            var DId=baseResponse.getElementsByTagName("CadreId");
                            
                     for(var k=0;k<DId.length;k++)
                        {
                           var DId=baseResponse.getElementsByTagName("CadreId");
                            var DDesc=baseResponse.getElementsByTagName("CadreName");
                            var DsDesc=baseResponse.getElementsByTagName("CadresName");
                            var PId=baseResponse.getElementsByTagName("PayId");
                           // var PName=baseResponse.getElementsByTagName("PayName");
                            var Rem=baseResponse.getElementsByTagName("Remarks");
                            
                        var cDId=DId.item(k).firstChild.nodeValue;
                        var cDDesc=DDesc.item(k).firstChild.nodeValue;
                        var cDsDesc=DsDesc.item(k).firstChild.nodeValue;
                        
                        var cPId=PId.item(k).firstChild.nodeValue;
                      //  var cPName=PName.item(k).firstChild.nodeValue;
                        
                        
                        if(cPId=="NoVal")
                              cPId=" ";
                       else
                            cPId=cPId;
                            
                        var cRem=Rem.item(k).firstChild.nodeValue;
                    
                    
                       if(cRem=="UnDefined Record Found")
                              cRem=" ";
                       else
                            cRem=cRem;
                            
                       /* var option=document.createElement("OPTION");
                        option.text=cPId;
                        option.value=cPId;
                                try
                                {
                                cmbPayId.add(option); 
                                
                                }catch(errorObject)
                                {
                                cmbPayId.add(option,null);
                                }*/
                                
                      
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
                         
                         var Paycell=document.createElement("TD");
                     var pid=document.createElement("INPUT");
                     var pname=document.createTextNode(cPId);
                     pid.type="HIDDEN";
                     pid.name="cadreid";
                     pid.text=cPId;
                     pid.value=cPId;
                     Paycell.appendChild(pid);
                     Paycell.appendChild(pname);
                     mycurrent_row.appendChild(Paycell);
                     
                      
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