/*
   The following function is used to create new XMLHttpRequest object.
   creating two types of objects for browser version difference.
*/

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
 document.DesigForm.htxtDesigId.value="";
   document.DesigForm.txtDesigDesc.value="";
   document.DesigForm.txtDesigsDesc.value="";
   document.DesigForm.cmbPayId.value="";
   document.DesigForm.cmbCadreId.selectedIndex=0;
   document.DesigForm.cmbPostId.selectedIndex=0;
   document.DesigForm.cmbSerId.selectedIndex=0;
   document.DesigForm.txtRemarks.value="";
   
   document.DesigForm.CmdAdd.disabled=false;
   document.DesigForm.CmdUpdate.disabled=true;
   document.DesigForm.CmdDelete.disabled=true;
   
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
    
        /*
           This function is used to load the corresponding row clicked for editing.
           
           The row id is passed as an argument to this function to load the grid values to
           the text box and other components.
        */
    
          var r=document.getElementById(rid); 
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
        // alert(rcells.item(1).firstChild.nodeValue);
          document.DesigForm.htxtDesigId.value=rcells.item(1).firstChild.nodeValue;
          document.DesigForm.txtDesigDesc.value=rcells.item(2).firstChild.nodeValue;
           document.DesigForm.cmbCadreId.value=rcells.item(3).firstChild.value;
         // document.DesigForm.cmbPayId.value=rcells.item(4).firstChild.nodeValue;
          document.DesigForm.cmbSerId.value=rcells.item(5).firstChild.value;
           document.DesigForm.txtDesigsDesc.value=rcells.item(6).firstChild.nodeValue;
          document.DesigForm.txtRemarks.value=rcells.item(7).firstChild.nodeValue;
          document.DesigForm.cmbPostId.value=rcells.item(4).firstChild.value;
          
          document.DesigForm.CmdAdd.disabled=true;
        document.DesigForm.CmdUpdate.disabled=false;
        document.DesigForm.CmdDelete.disabled=false;
          document.DesigForm.CmdDelete.focus();
      
    }
    function nullCheck()
    {
       if((document.DesigForm.txtDesigDesc.value=="") || (document.DesigForm.txtDesigDesc.value<=0))
                  { 
                       alert("Please Enter the Designation Desc");
                       document.DesigForm.txtDesigDesc.focus();
                       return false;
                  }
                else if((document.DesigForm.txtDesigsDesc.value=="") || (document.DesigForm.txtDesigsDesc.value<=0))
                  { 
                       alert("Please Enter the Designation Short Desc");
                       document.DesigForm.txtDesigsDesc.focus();
                       return false;
                  }
                  else if((document.DesigForm.cmbPayId.value=="") || (document.DesigForm.cmbPayId.value<=0))
                  { 
                       alert("Please Select the Pay Scale Id");
                       document.DesigForm.cmbPayId.focus();
                       return false;
                  }
                  else if((document.DesigForm.cmbCadreId.value=="") || (document.DesigForm.cmbCadreId.value<=0))
                  { 
                       alert("Please Select the Cadre Id");
                       document.DesigForm.cmbCadreId.focus();
                       return false;
                  }
                  
                  else if((document.DesigForm.cmbPostId.value=="") || (document.DesigForm.cmbPostId.value<=0))
                  { 
                       alert("Please Select the Post Rank Id");
                       document.DesigForm.cmbPostId.focus();
                       return false;
                  }

                  else if((document.DesigForm.cmbSerId.value=="") || (document.DesigForm.cmbSerId.value<=0))
                  { 
                       alert("Please Select the Service Group Id");
                       document.DesigForm.cmbSerId.focus();
                       return false;
                  }
                 
                  else if((document.DesigForm.txtRemarks.value=="") || (document.DesigForm.txtRemarks.value<=0))
                  { 
                       alert("Please Enter The Remarks");
                       document.DesigForm.txtRemarks.focus();
                       return false;
                  }
                  return true;
    
    }
    
 function callServer(command,param)
 {
 
     /*
        Getting the values from jsp page and stored in a variable. 
     */
   
       var hstrDesigId=document.DesigForm.htxtDesigId.value;
       var strDesigDesc=document.DesigForm.txtDesigDesc.value;
       var strDesigsDesc=document.DesigForm.txtDesigsDesc.value;
       var strPayId=document.DesigForm.cmbPayId.value;
          var strCadreId=document.DesigForm.cmbCadreId.value;
          var strPostId=document.DesigForm.cmbPostId.value;
           var strSerId=document.DesigForm.cmbSerId.value;
          var strRemarks=document.DesigForm.txtRemarks.value;
        var url="";
        var flag="";
       
       if(command=="Add")
        {           /* flag=nullCheck();  
                    if(flag==true)
                    {*/
                    
                    /*
                      Setting the destination servlet url in a variable.
                      Getting the XMLHttpRequest object in a variable.
                      Opening the object and assigning service method,url and true value.
                      true is for asynchronous calling and false is for synchronous calling.
                      Assigning method in anonymous function to send the request to destination servlet.
                    */
                    
                    
                    url="../../../../../Designation_Servlet_New.view?command=Add&DesigDesc=" + strDesigDesc+"&DesigsDesc="+strDesigsDesc+"&CadreId="+strCadreId+"&SerId="+strSerId+"&Remarks="+strRemarks+"&Rank="+strPostId;
                    //alert(url);
                    var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               processResponse(req);
            }   
                    req.send(null);
                   // }
                   
                    
        }
        else if(command=="Update")
        {
                    
                    /* flag=nullCheck();  
                    if(flag==true)
                    {*/
                    url="../../../../../Designation_Servlet_New.view?command=Update&DesigId="+hstrDesigId+"&DesigDesc="+strDesigDesc+"&DesigsDesc="+strDesigsDesc+"&CadreId="+strCadreId+"&SerId="+strSerId+"&Remarks="+strRemarks+"&Rank="+strPostId;
                   var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               processResponse(req);
            }   
                    req.send(null);
                  //  }

        }
        
        else if(command=="Delete")
        {  
          if(confirm("Do You Really want to Delete the Selected Record"))
             {
        
                    url="../../../../../Designation_Servlet_New.view?command=Delete&DesigId="+hstrDesigId;
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
        else if(command=="Get")
        {               
                          url="../../../../../Designation_Servlet_New.view?command=Get";
                         var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
               processResponse(req);
            }   
                    req.send(null);
        }
        else if(command=="Pay")
        {               
                          url="../../../../../Designation_Servlet_New.view?command=Pay&CadreId="+strCadreId;
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
    
    
     /*
       If the readystate is 4 and the status is 200 (it means success)
       
       Getting the response parent tag from the xml formed in servlet and the command tag value is retrieved from
       the xml.
       
       Forwading the baseresponse object to another function.
     */
     
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
              else if(command=="Pay")
              { 
              payRow(baseResponse);
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
               var hstrDesigId=document.DesigForm.htxtDesigId.value;
                            var items=new Array();
                            items[0]=hstrDesigId;
                            items[1]=document.DesigForm.txtDesigDesc.value;
                            items[2]=document.DesigForm.cmbCadreId.value;
                           items[3]=document.DesigForm.cmbCadreId.options[document.DesigForm.cmbCadreId.selectedIndex].text;
                          // items[4]=document.DesigForm.cmbPayId.value;
                            items[5]=document.DesigForm.cmbSerId.value;
                           items[6]=document.DesigForm.cmbSerId.options[document.DesigForm.cmbSerId.selectedIndex].text;
                            items[7]=document.DesigForm.txtDesigsDesc.value;
                            items[8]=document.DesigForm.txtRemarks.value;
                            items[9]=document.DesigForm.cmbPostId.value;
                            items[10]=document.DesigForm.cmbPostId.options[document.DesigForm.cmbPostId.selectedIndex].text;
                            
                              var r=document.getElementById(items[0]);    
                              var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1];
                            
                            rcells.item(3).firstChild.value=items[2];
                            rcells.item(3).lastChild.nodeValue=items[3];
                            
                            rcells.item(4).firstChild.value=items[9];
                            rcells.item(4).lastChild.nodeValue=items[10];
                            
                           // rcells.item(4).firstChild.nodeValue=items[4];
                            
                            rcells.item(5).firstChild.value=items[5];
                            rcells.item(5).lastChild.nodeValue=items[6];
                            
                            rcells.item(6).firstChild.nodeValue=items[7];
                            rcells.item(7).lastChild.nodeValue=items[8];
                            
                            
                            
                            
                               document.DesigForm.htxtDesigId.value="";
                               document.DesigForm.txtDesigDesc.value="";
                               document.DesigForm.txtDesigsDesc.value="";
                               document.DesigForm.cmbPayId.value="";
                               document.DesigForm.cmbCadreId.selectedIndex=0;
                               document.DesigForm.cmbPostId.selectedIndex=0;
                               document.DesigForm.cmbSerId.selectedIndex=0;
                               document.DesigForm.txtRemarks.value="";
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
                      var DesigId=document.DesigForm.htxtDesigId.value;
                      var tbody=document.getElementById("Existing");     
                      var r=document.getElementById(DesigId);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                      document.DesigForm.htxtDesigId.value="";
                               document.DesigForm.txtDesigDesc.value="";
                               document.DesigForm.txtDesigsDesc.value="";
                               document.DesigForm.cmbPayId.value="";
                               document.DesigForm.cmbCadreId.selectedIndex=0;
                               document.DesigForm.cmbPostId.selectedIndex=0;
                               document.DesigForm.cmbSerId.selectedIndex=0;
                               document.DesigForm.txtRemarks.value="";
                      alert("Selected Designation Id Details are Deleted");                      
                  }
                  else
                  {
                      alert("Unable to Delete");
                  }
   
  }
  
   

 function addRow(baseResponse)
    {
    
           /*
              Getting the flag value from the xml and if it is success means to add the new designation name and id and
              other parameter into grid in jsp.
           */
    
              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue; 
              if(flag=="success")
              {                        
                     alert("Record Inserted Into Database successfully.");
                     did=baseResponse.getElementsByTagName("DesigId")[0].firstChild.nodeValue; 
                      alert("Please Note Down Your Designation Id " +  did);
                     var items=new Array();                   
                    var did=baseResponse.getElementsByTagName("DesigId")[0].firstChild.nodeValue;
                   var ddesc=document.DesigForm.txtDesigDesc.value;
                   var dsdesc=document.DesigForm.txtDesigsDesc.value;
                   var rem=document.DesigForm.txtRemarks.value;
                    
                   
                   var cadname=document.DesigForm.cmbCadreId.options[document.DesigForm.cmbCadreId.selectedIndex].text;
                   var postname=document.DesigForm.cmbPostId.options[document.DesigForm.cmbPostId.selectedIndex].text;
                   var servname=document.DesigForm.cmbSerId.options[document.DesigForm.cmbSerId.selectedIndex].text;
                    
                    var payid=document.DesigForm.cmbPayId.value;
                    var cadid=document.DesigForm.cmbCadreId.value;
                    var posid=document.DesigForm.cmbPostId.value;
                    var servid=document.DesigForm.cmbSerId.value;
                    
                    
                    /*
                      steps to add value in the grid are
                      
                      Getting the tbody id from the jsp.
                      One new row is created using create element and assign it to variable.
                      After that cells to be added for that row.
                      Each cell is added to the row.
                      Finally row is added to the tbody id.
                      
                      A link is displayed in the grid cell named 'Edit'.
                      
                      If we click the link it is directed to another function.
                    */
                    
                     var tbody=document.getElementById("tblList");
                     var mycurrent_row=document.createElement("TR");
                     mycurrent_row.id=did;
                     var cell=document.createElement("TD");
                     var anc=document.createElement("A");       
                     var url="javascript:loadValuesFromTable('" + did + "')";              
                     anc.href=url;
                     var txtedit=document.createTextNode("Edit");
                     anc.appendChild(txtedit);
                     cell.appendChild(anc);
                     mycurrent_row.appendChild(cell);
                     
                     var cell1=document.createElement("TD");  
                     var cdid=document.createTextNode(did);
                     cell1.appendChild(cdid);
                     mycurrent_row.appendChild(cell1);
                     
                     var cell2=document.createElement("TD");  
                     var cddesc=document.createTextNode(ddesc);
                     cell2.appendChild(cddesc);
                     mycurrent_row.appendChild(cell2);
                     
                    
                    
                     var cell4=document.createElement("TD");
                     var cid=document.createElement("INPUT");
                     var cname=document.createTextNode(cadname);
                     cid.type="HIDDEN";
                     cid.name="cadreid";
                     cid.text=cadid;
                     cid.value=cadid;
                     cell4.appendChild(cid);
                     cell4.appendChild(cname);
                     mycurrent_row.appendChild(cell4);
                     
                     var cell5=document.createElement("TD");
                     var pid=document.createElement("INPUT");
                     var pname=document.createTextNode(postname);
                     pid.type="HIDDEN";
                     pid.name="postid";
                     pid.text=posid;
                     pid.value=posid;
                     cell5.appendChild(pid);
                     cell5.appendChild(pname);
                     mycurrent_row.appendChild(cell5);
                     
                    /*  var Paycell=document.createElement("TD");  
                     var pid=document.createTextNode(payid);
                     Paycell.appendChild(pid);
                     mycurrent_row.appendChild(Paycell);*/
                     
                     
                     var cell6=document.createElement("TD");
                     var sid=document.createElement("INPUT");
                     var sname=document.createTextNode(servname);
                     sid.type="HIDDEN";
                     sid.name="servid";
                     sid.text=servid;
                     sid.value=servid;
                     cell6.appendChild(sid);
                     cell6.appendChild(sname);
                     mycurrent_row.appendChild(cell6);
                     
                     var cell3=document.createElement("TD");  
                     var cdsdesc=document.createTextNode(dsdesc);
                     cell3.appendChild(cdsdesc);
                     mycurrent_row.appendChild(cell3);
                     
                     var cell7=document.createElement("TD");  
                     var crem=document.createTextNode(rem);
                     cell7.appendChild(crem);
                     mycurrent_row.appendChild(cell7);
                     
                                tbody.appendChild(mycurrent_row); 
                                document.DesigForm.htxtDesigId.value="";
                               document.DesigForm.txtDesigDesc.value="";
                               document.DesigForm.txtDesigsDesc.value="";
                               document.DesigForm.cmbPayId.value="";
                               document.DesigForm.cmbCadreId.selectedIndex=0;
                               document.DesigForm.cmbPostId.selectedIndex=0;
                               document.DesigForm.cmbSerId.selectedIndex=0;
                               document.DesigForm.txtRemarks.value="";
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
                    
                                
                 /*  THIS CODE WILL ADD THE RESPECTIVE VALUES INTO THE COMBO AGAIN AND AGAIN SO AVOID THIS
                 var cmbCadreId=document.getElementById("cmbCadreId");
                        cmbCadreId.innerHTML="";
                        var option=document.createElement("OPTION");
                        option.text="--Select Cadre Id--";
                        try
                                {
                                cmbCadreId.add(option);                
                                }catch(errorObject)
                                {
                                cmbCadreId.add(option,null);
                                }
                       var cmbSerId=document.getElementById("cmbSerId");
                        cmbSerId.innerHTML="";
                        var option=document.createElement("OPTION");
                        option.text="--Select Service Group Id--";
                       try
                                {
                                cmbSerId.add(option);                
                                }catch(errorObject)
                                {
                                cmbSerId.add(option,null);
                                }*/
                              
                            var DId=baseResponse.getElementsByTagName("DesigId");
                            
                     for(var k=0;k<DId.length;k++)
                        {
                           var DId=baseResponse.getElementsByTagName("DesigId");
                            var DDesc=baseResponse.getElementsByTagName("DesigDesc");
                            var DsDesc=baseResponse.getElementsByTagName("DesigsDesc");
                           // var PId=baseResponse.getElementsByTagName("PayId");
                           // var PName=baseResponse.getElementsByTagName("PayName");
                            var CId=baseResponse.getElementsByTagName("CadreId");
                            var CName=baseResponse.getElementsByTagName("CadreName");
                            var PId=baseResponse.getElementsByTagName("PostId");
                            var PName=baseResponse.getElementsByTagName("PostName");
                            var SId=baseResponse.getElementsByTagName("ServId");
                            var SName=baseResponse.getElementsByTagName("ServName");
                            var Rem=baseResponse.getElementsByTagName("Remarks");
                            
                        var cDId=DId.item(k).firstChild.nodeValue;
                        var cDDesc=DDesc.item(k).firstChild.nodeValue;
                        var cDsDesc=DsDesc.item(k).firstChild.nodeValue;
                        var cCId=CId.item(k).firstChild.nodeValue;
                       // var cPId=PId.item(k).firstChild.nodeValue;
                       // var cPName=PName.item(k).firstChild.nodeValue;
                        var cCName=CName.item(k).firstChild.nodeValue;
                        var cPId=PId.item(k).firstChild.nodeValue;
                        var cPName=PName.item(k).firstChild.nodeValue;
                        var cSId=SId.item(k).firstChild.nodeValue;
                        var cSName=SName.item(k).firstChild.nodeValue;
                        var cRem=Rem.item(k).firstChild.nodeValue;
                    
                         if(cRem=="UnDefined Record Found")
                              cRem=" ";
                       else
                            cRem=cRem;
                                
                   /*  THIS IS ALSO ---- THIS CODE WILL ADD THE RESPECTIVE VALUES INTO THE COMBO AGAIN AND AGAIN SO AVOID THIS
                   var option=document.createElement("OPTION");
                        option.text=cCName;
                        option.value=cCId;
                                try
                                {
                                cmbCadreId.add(option);                
                                }catch(errorObject)
                                {
                                cmbCadreId.add(option,null);
                                }
                     var option=document.createElement("OPTION");
                        option.text=cSName;
                        option.value=cSId;
                                try
                                {
                                cmbSerId.add(option);                
                                }catch(errorObject)
                                {
                                cmbSerId.add(option,null);
                                }
                                */
                               
                       
                        
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
                         
                        
                     
                     
                     var cell5=document.createElement("TD");
                     var cid=document.createElement("INPUT");
                     var cname=document.createTextNode(cCName);
                     cid.type="HIDDEN";
                     cid.name="cadreid";
                     cid.text=cCId;
                     cid.value=cCId;
                     cell5.appendChild(cid);
                     cell5.appendChild(cname);
                     mycurrent_row.appendChild(cell5);
                     
                     var cell6=document.createElement("TD");
                     var pid=document.createElement("INPUT");
                     var pname=document.createTextNode(cPName);
                     pid.type="HIDDEN";
                     pid.name="Rank";
                     pid.text=cPId;
                     pid.value=cPId;
                     cell6.appendChild(pid);
                     cell6.appendChild(pname);
                     mycurrent_row.appendChild(cell6);
                     
                  /*    var Paycell =document.createElement("TD");    
                         var pname=document.createTextNode(cPName);                         
                         Paycell.appendChild(pname);       
                         mycurrent_row.appendChild(Paycell);     */  
                       
                     
                     var cell7=document.createElement("TD");
                     var sid=document.createElement("INPUT");
                     var sname=document.createTextNode(cSName);
                     sid.type="HIDDEN";
                     sid.name="servid";
                     sid.text=cSId;
                     sid.value=cSId;
                     //alert(sid.value);
                     cell7.appendChild(sid);
                     cell7.appendChild(sname);
                     mycurrent_row.appendChild(cell7);
                     
                      var cell4 =document.createElement("TD");    
                         var dessdesc=document.createTextNode(cDsDesc);                         
                         cell4.appendChild(dessdesc);       
                         mycurrent_row.appendChild(cell4);    
                     
                        var cell8 =document.createElement("TD");    
                         var rema=document.createTextNode(cRem);                         
                         cell8.appendChild(rema);       
                         mycurrent_row.appendChild(cell8); 
                         tbody.appendChild(mycurrent_row); 
                         
                         }
                     
             }
             else
             {
                     alert("Failed to Load Values");
             }
    }
    
    
    function payRow(baseResponse)
    {
        var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue; 
             //alert(flag); 
              if(flag=="success")
              {
                 //var PId=baseResponse.getElementsByTagName("PayId")[0].firstChild.nodeValue;
                 var PName=baseResponse.getElementsByTagName("PayName")[0].firstChild.nodeValue;
                 
                 document.DesigForm.cmbPayId.value=PName;
              }
              else
              {
                 alert("No Pay Scale Specified for the Selected Cadre");
                 document.DesigForm.cmbPayId.value="Undefined Record Found";
                 //document.DesigForm.cmbCadreId.focus();
              }
    }