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


// function to call servlet 
 function callServer(command,param)
 {     
        alert("hai");
          var strSysId;
          var strName;
          var strSysDesc;
          var strSysShortDesc;     
          
          if(command=="Add")
          {           
                
                var flag=nullCheck();
                
                if(flag==true)
                {
                    
                    strSysId=document.frmMasterSub.txtSysId.value;
                    strName=document.frmMasterSub.txtName.value;
                   //url="../../../ServletUpdatingRoles.con?command=Add&txtSysId="+strSysId+"&txtName=" + strName + "&txtDesc=" + strDesc;
                    url="../../../ServletUpdatingRoles.con?command=Add&txtSysId="+strSysId+"&txtName=" + strName;
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
                }         
                
          }      
          
          else if(command=="Delete")
          {
                strSysId=document.frmMasterSub.txtSysId.value;
                strName=document.frmMasterSub.txtName.value;
                //url="../../../ServletUpdatingRoles.con?command=Delete&txtSysId="+strSysId+"&txtName=" + strName+"&txtDesc="+strDesc;    
                url="../../../ServletUpdatingRoles.con?command=Delete&txtSysId="+strSysId+"&txtName=" + strName;    
                req.open("GET",url,true);        
                req.onreadystatechange=processResponse;
                req.send(null);
          }
         
          else if(command=="combo")
          {
               url="../../../ServletUpdatingRoles.con?command=combo";
                req.open("GET",url,true);        
                req.onreadystatechange=processResponse;
                req.send(null);          
                
          }   
          else if(command=="Minor")
          {
            var txtMajorId=document.frmAddingMenus.txtMajorId.value;
            var txtMinorId=document.frmAddingMenus.txtMinorId.value;
            alert(txtMajorId);
            alert(txtMinorId);
            url="../../../ServletAssigningMenus.con?command=Minor&txtMajorId="+escape(txtMajorId)+"&txtMinorId="+escape(txtMinorId);
            var req=getTransport();
            req.open("GET",url,true);        
            req.onreadystatechange=function()
            {
            processResponse(req);
            }
            req.send(null);    
          }  
          
          else if(command=="Major")
          {
            
            var txtMajorId=document.frmAddingMenus.txtMajorId.value;
            
            alert(txtMajorId);
            url="../../../ServletAssigningMenus.con?command=Major&txtMajorId="+escape(txtMajorId);
            var req=getTransport();
            req.open("GET",url,true);        
            req.onreadystatechange=function()
            {
            processResponse(req);
            }
            req.send(null);    
          }
          
    }
    
    
    // code for processing the xml returned by servlet  
   
    function processResponse(req)
    {   
      
      if(req.readyState==4)
        {
          if(req.status==200)
          {         
          
          alert("****"+req.responseTEXT);
              var baseResponse=req.responseXML.getElementsByTagName("response")[0];
              var tagCommand=baseResponse.getElementsByTagName("command")[0];
              var command=tagCommand.firstChild.nodeValue; 
              if(command=="Add")
              {
                  addRow(baseResponse);                 
              }
              else if(command=="Delete")
              {                 
                  deleteRow(baseResponse);                             
              }
                          
              else if(command=="Major")
              {
                 FillMinor(baseResponse);
              }
              else if(command=="Minor")
              {
                  FillSubSys(baseResponse);
              
              }
          }
        }
    }
    
    
    
    function FillMinor(baseResponse)
    {
    var txtMinorId=document.getElementById("txtMinorId");
          var value=baseResponse.getElementsByTagName("option");
          var option=document.createElement("OPTION");
          for(var i=0;i<value.length;i++)
          {
              var item=value.item(i);
              var comboval=item.getElementsByTagName("MinorId")[0].firstChild.nodeValue;
              var combotxt=item.getElementsByTagName("MinorName")[0].firstChild.nodeValue;
              var option=document.createElement("OPTION");
              option.text=combotxt;
              option.value=comboval;
              //Making Browser Independent
              try
              {
                  txtMinorId.add(option);
              }
              catch(errorObject)
              {
                  txtMinorId.add(option,null);
              }
          }
   
    }
    
    function FillSubSys(baseResponse)
    {
    var txtSubSysId=document.getElementById("txtSubSysId");
          var value=baseResponse.getElementsByTagName("option");
          var option=document.createElement("OPTION");
          for(var i=0;i<value.length;i++)
          {
              var item=value.item(i);
              var comboval=item.getElementsByTagName("SubSysId")[0].firstChild.nodeValue;
              var combotxt=item.getElementsByTagName("SubSysName")[0].firstChild.nodeValue;
              var option=document.createElement("OPTION");
              option.text=combotxt;
              option.value=comboval;
              //Making Browser Independent
              try
              {
                  txtSubSysId.add(option);
              }
              catch(errorObject)
              {
                  txtSubSysId.add(option,null);
              }
          }
   
    }