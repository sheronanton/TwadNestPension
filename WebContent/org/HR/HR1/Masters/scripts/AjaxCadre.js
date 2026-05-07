

/*  this file contains page specific ajax functions for FILE : MasterBenefit.jsp  */ 


// code for creating XMLHTTPREQUEST object
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
 
 // function to clear all
 function clearAll()
 {        
        document.frmCadre.txtCadreId.value="";
        document.frmCadre.txtCadreName.value="";
        document.frmCadre.txtCadreSName.value="";
        document.frmCadre.txtRemarks.value="";          
        document.frmCadre.txtCadreId.disabled=false;        
        document.frmCadre.cmdUpdate.disabled=true;
        document.frmCadre.cmdDelete.disabled=true;
        document.frmCadre.cmdSelect.disabled=true;
        document.frmCadre.cmdAdd.disabled=false; 
        document.frmCadre.cmdEdit.disabled=false;  
        document.frmCadre.cmdAdd.value="  Add  ";
        edit=false;
 }
 
 function addRecord()
 { 
    var strCaption=document.frmCadre.cmdAdd.value;
    if(strCaption=="  Add  ")
    {
        document.frmCadre.cmdAdd.value=" Save ";
        alert("Please Enter Cadre Details.");
        document.frmCadre.cmdEdit.disabled=true;                  
        document.frmCadre.txtCadreId.focus();        
    }
    else
    {
        callServer("Add","null");
    }
 }
 // function to call servlet 
 function callServer(command,param)
 {     
          var url="";
          var strCadreId;
          var strCadreName;
          var strCadreSName;
          var strRemarks;   
          
          if(command=="Add")
          {           
                var flag=nullCheck();    
                if(flag==true)
                {
                    strCadreId=document.frmCadre.txtCadreId.value;
                    strCadreName=document.frmCadre.txtCadreName.value;
                    strCadreSName=document.frmCadre.txtCadreSName.value;
                    strRemarks=document.frmCadre.txtRemarks.value;      
                    url="../../../../../ServletCadre.con?command=Add&Id=" + strCadreId + "&Name=" + strCadreName ;
                    url=url + "&SName=" + strCadreSName + "&Remarks=" + strRemarks;
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
                    strCadreId=document.frmCadre.txtCadreId.value;
                    strCadreName=document.frmCadre.txtCadreName.value;
                    strCadreSName=document.frmCadre.txtCadreSName.value;
                    strRemarks=document.frmCadre.txtRemarks.value;  
                    url="../../../../../ServletCadre.con?command=Update&Id=" + strCadreId + "&Name=" + strCadreName ;
                    url=url + "&SName=" + strCadreSName + "&Remarks=" + strRemarks;                    
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
                strCadreId=document.frmCadre.txtCadreId.value;
                url="../../../../../ServletCadre.con?command=Delete&Id=" + strCadreId;                    
                var req=getTransport();
                    req.open("GET",url,true);                    
                    req.onreadystatechange=function()
                    {
                      processResponse(req);
                    }
                    req.send(null);
                    //alert("called");
          }
     /*     else if(command=="Get")
          {
                url="/ajax/ServletCadre.con?command=Get&Id=" + param;
                req.open("GET",url,true);        
                req.onreadystatechange=processResponse;
                req.send(null);                  
          }     */
    }
    
    // code for processing the xml returned by servlet  
   
    function processResponse(req)
    {   
      if(req.readyState==4)
        {
          if(req.status==200)
          {              
              var baseResponse=req.responseXML.getElementsByTagName("response")[0];
              var tagCommand=baseResponse.getElementsByTagName("command")[0];
              var command=tagCommand.firstChild.nodeValue;             
              //alert("response : " + command);
              if(command=="Add")
              {
                 //alert("calling addRow");
                 addRow(baseResponse);                 
              }
              else if(command=="Delete")
              {                 
                  deleteRow(baseResponse);                             
              }
              else if(command=="Update")
              {              
                  updateRow(baseResponse);             
              }   
              else if(command=="Get")
              {             
                  //alert("process");
                  displayDetails(baseResponse);
              }
          }
        }
    }
    
    
    function deleteRow(baseResponse)
    {
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
      if(flag=="success")
      {
           alert("Record Deleted Successfully.");
           clearAll();
      }
      else
      {
          alert("unable to delete");
      }      
    }
    
    // function for updating 
    
    function updateRow(baseResponse)
    {
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       if(flag=="success")
       {   
           alert("Record Updated Successfully.");
           clearAll();
       }
       else
       {
           alert("failed to update values");
       }                                  
    }
    
    
    // function for displaying the servlet returned values 
    function displayDetails(baseResponse)
    {      
      //alert("display");
       var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       if(flag=="success")
       {                                        
          document.frmCadre.txtCadreId.value=baseResponse.getElementsByTagName("id")[0].firstChild.nodeValue;
          document.frmCadre.txtCadreName.value=baseResponse.getElementsByTagName("name")[0].firstChild.nodeValue;
          document.frmCadre.txtCadreSName.value=baseResponse.getElementsByTagName("sname")[0].firstChild.nodeValue;
          document.frmCadre.txtRemarks.value=baseResponse.getElementsByTagName("remark")[0].firstChild.nodeValue;          
          document.frmCadre.txtCadreId.disabled=true;
          document.frmCadre.txtCadreName.focus();          
          document.frmCadre.cmdUpdate.disabled=false;
          document.frmCadre.cmdDelete.disabled=false;
          document.frmCadre.cmdAdd.disabled=true;
          document.frmCadre.txtCadreId.onblur=Verification;
       }
       else
       {
           alert("Invalid Id,No Record Exist with this ID");
           document.frmCadre.txtCadreId.value="";
           document.frmCadre.txtCadreId.onblur=Verification;
           document.frmCadre.txtCadreId.focus();
       }                                  
    }
    
    // function to add a record
    function addRow(baseResponse)
    {
         var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
         //alert("called with " + flag);
         if(flag=="success")
         {                        
              alert("Record Inserted Into Database successfully.");
              clearAll(); 
         }
         else
         {
               alert("failed to insert values");
         }       
    }
    

// code to validate the ID
    
function Verification()
{
      //alert("verification called");
      var strCadreId=document.frmCadre.txtCadreId.value;
      if(strCadreId!="")
      {
        var strCaption=document.frmCadre.cmdAdd.value;
        if(strCaption=="  Add  " && edit==false)
        {
            document.frmCadre.cmdAdd.value=" Save ";
            document.frmCadre.cmdEdit.disabled=true;
        }   
        if(edit==false)
        {          
            if((strCadreId==""))
            {
                return;
            }
            var url="../../../../../ServletCadre.con?command=Verify&id="+escape(strCadreId);  
            
            var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                    updatePage(req);
                    }
                    req.send(null);
        }
        else
        {
              url="../../../../../ServletCadre.con?command=Get&Id=" + escape(strCadreId);
              //alert(url);
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


function updatePage(req)
{
        if(req.readyState==4)
        {
           if(req.status==200)
           {               
                var msg=req.responseXML.getElementsByTagName("message")[0].firstChild.nodeValue;
                if(msg=="valid")
                {
                    alert("Record with the given ID Already Exists");
                    document.frmCadre.txtCadreId.value="";
                    document.frmCadre.txtCadreId.focus();                    
                }
                else
                {//id does not exist
                }                     
            }
        }    
}