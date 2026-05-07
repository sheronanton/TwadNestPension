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
   document.PostForm.htxtPRId.value="";
   document.PostForm.txtPRDesc.value="";
   document.PostForm.txtPRSDesc.value="";
   document.PostForm.txtORDSeq.value="";
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
          document.PostForm.htxtPRId.value=rcells.item(1).firstChild.nodeValue;
          document.PostForm.txtPRDesc.value=rcells.item(2).firstChild.nodeValue;
          document.PostForm.txtPRSDesc.value=rcells.item(3).firstChild.nodeValue;
          document.PostForm.txtORDSeq.value=rcells.item(4).firstChild.nodeValue;
    }
 
function nullCheck()
{
                    if((document.PostForm.txtPRDesc.value=="")||(document.PostForm.txtPRDesc.value.length<=0))
                    {
                       alert("Please Enter the Post Rank Name");
                       document.PostForm.txtPRDesc.focus();
                       return false;
                    }
                    else if((document.PostForm.txtPRSDesc.value=="") || (document.PostForm.txtPRSDesc.value.length<=0))
                    {
                        alert("Please Enter the Post Rank Short Name");
                        document.PostForm.txtPRSDesc.focus();
                        return false;
                    }
                    return true;

}
 function callServer(command,param)
 {
   
       var hstrPRId=document.PostForm.htxtPRId.value;
       var strPRDesc=document.PostForm.txtPRDesc.value;
       var strPRSDesc=document.PostForm.txtPRSDesc.value;
       var strPRORDseq=document.PostForm.txtORDSeq.value;
       var url="";
       
       if(command=="Add")
        {              
        
                    var flag=nullCheck();        
                    if(flag==true)
                    {
                    url="../../../../../PostRank_Servlet.view?command=Add&PRDesc=" + strPRDesc +"&PRSDesc="+ strPRSDesc+"&PRORDseq="+ strPRORDseq;
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
                    url="../../../../../PostRank_Servlet.view?command=Update&PRId="+hstrPRId+"&PRDesc="+strPRDesc+"&PRSDesc="+strPRSDesc+"&PRORDseq="+strPRORDseq;
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
                    url="../../../../../PostRank_Servlet.view?command=Delete&PRId="+hstrPRId;
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
               var hstrPRId=document.PostForm.htxtPRId.value;
                            var items=new Array();
                            items[0]=hstrPRId;
                            items[1]=document.PostForm.txtPRDesc.value;
                            items[2]=document.PostForm.txtPRSDesc.value;
                            items[3]=document.PostForm.txtORDSeq.value;
                            
                            
                              var r=document.getElementById(items[0]);    
                              var rcells=r.cells;
                            rcells.item(1).firstChild.nodeValue=items[0];
                            rcells.item(2).firstChild.nodeValue=items[1];
                            rcells.item(3).firstChild.nodeValue=items[2];
                            rcells.item(4).firstChild.nodeValue=items[3];
                       
                            document.PostForm.txtORDSeq.value="";
                            document.PostForm.txtPRDesc.value="";
                            document.PostForm.txtPRSDesc.value="";
                             document.PostForm.htxtPRId.value="";
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
                      var PRId=baseResponse.getElementsByTagName("PRId")[0].firstChild.nodeValue;
                      var tbody=document.getElementById("Existing");     
                      var r=document.getElementById(PRId);    
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri); 
                               document.PostForm.txtORDSeq.value="";
                               document.PostForm.txtPRDesc.value="";
                               document.PostForm.txtPRSDesc.value="";
                                document.PostForm.htxtPRId.value="";
                      alert("Selected Post Rank Id Details are Deleted");                      
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
                     pid=baseResponse.getElementsByTagName("PRId")[0].firstChild.nodeValue; 
                      alert("Please Note Down Your Post Rank Id " +  pid);
                     var items=new Array();                   
                    items[0]=baseResponse.getElementsByTagName("PRId")[0].firstChild.nodeValue;
                   items[1]=document.PostForm.txtPRDesc.value;
                    items[2]=document.PostForm.txtPRSDesc.value;
                    items[3]=document.PostForm.txtORDSeq.value;
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
                     for(i=0;i<4;i++)
                     {                                           
                         cell2=document.createElement("TD");                               
                         var currenttext=document.createTextNode(items[i]);                         
                         cell2.appendChild(currenttext);       
                         mycurrent_row.appendChild(cell2);       
                     }  
                     tbody.appendChild(mycurrent_row); 
                            document.PostForm.txtORDSeq.value="";
                            document.PostForm.txtPRDesc.value="";
                            document.PostForm.txtPRSDesc.value="";
                             document.PostForm.htxtPRId.value="";
             }
             else
             {
                     alert("Failed to Insert Values");
             }
    }
 