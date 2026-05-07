var role_value='';
var desigval='';

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

function getDesignation1()
{


  var type=document.frmValidationSummaryRep.cmbsgroup1.options[document.frmValidationSummaryRep.cmbsgroup1.selectedIndex].value;
  //alert(type);     
  if(type!=0)
  {
    loadOfficesByType1(type);
  }
  
}




 function loadOfficesByType1(type)
 {
        
        var type=document.frmValidationSummaryRep.cmbsgroup1.options[document.frmValidationSummaryRep.cmbsgroup1.selectedIndex].value;
        var url="../../../New_Role_Assigning.av?Command=Desig&cmbsgroup=" + type ;
      // alert(url);
        
       req.open("GET",url,true);   
           req.onreadystatechange=loadDesignation;
       
        req.send(null);
          
  }
           


 
    
function  loadDesignation()
{
	
     if(req.readyState==4)
        {
          if(req.status==200)
          { 
        	 
            
                var des=document.getElementById("Desig");
                while(des.length > 0) 
                {  
                des.remove(0);
                }
                var i=0;
                
                var response=req.responseXML.getElementsByTagName("response")[0];
                var flag=response.getElementsByTagName("flag")[0].firstChild.nodeValue;
                             
                // stopwaiting(document.frmValidationSummaryRep);
                if(flag=="failure")
                {
                    alert("No Designation exists under this level");
                }
                else
                {   
                 
                
                    var value=response.getElementsByTagName("option");
                    var option=document.createElement("OPTION");
                    option.text="--Select Designation--";
                    option.value="0";
                    try
                    {
                        des.add(option);
                    }catch(errorObject)
                    {
                        des.add(option,null);
                    }
                    for(var i=0;i<value.length;i++)
                    {
                        var tmpoption=value.item(i);
                        var id=tmpoption.getElementsByTagName("desig_id")[0].firstChild.nodeValue;
                        var name=tmpoption.getElementsByTagName("desig_name")[0].firstChild.nodeValue;
                        var option=document.createElement("OPTION");
                          option.text=name;
                          option.value=id;
                          //Making Browser Independent
                          try
                          {
                              des.add(option);
                          }
                          catch(errorObject)
                          {
                              des.add(option,null);
                          }
                    }
                
                }
        
        }
        
    }
    

}

function loademployee()
{
       
       var type=document.frmValidationSummaryRep.Desig.options[document.frmValidationSummaryRep.Desig.selectedIndex].value;
       var url="../../../Bulk_Userid_Create?command=get&desig=" + type ;
           
      req.open("GET",url,true);   
          req.onreadystatechange=employee;
      
       req.send(null);
         
 }
function  employee()
{
	
     if(req.readyState==4)
        {
          if(req.status==200)
          { 
        	  var response=req.responseXML.getElementsByTagName("response")[0];
              var flag=response.getElementsByTagName("flag")[0].firstChild.nodeValue;
              var command=response.getElementsByTagName("command")[0].firstChild.nodeValue;
        	
              
              var tlist=document.getElementById("tlist");
              while (tlist.childNodes.length > 0) {
             	 tlist.removeChild(tlist.firstChild);
              }
              var len=response.getElementsByTagName("emp_id").length;
              
              if(len<1){
            	  alert("All User Accounts are created for this Designation");
            	  document.frmValidationSummaryRep.subconfirm.disabled=true;
            	  }else{
            		  document.frmValidationSummaryRep.subconfirm.disabled=false;
            	  }
              
             var seq=0;
              for(var i=0;i<len;i++)
              {
              	
              var emp_id=response.getElementsByTagName("emp_id")[i].firstChild.nodeValue;
            
             var desig_id=response.getElementsByTagName("desig_id")[i].firstChild.nodeValue;
             var emp_name=response.getElementsByTagName("emp_name")[i].firstChild.nodeValue;
             var office_name=response.getElementsByTagName("office_name")[i].firstChild.nodeValue;
                                     
              
             var tr=document.createElement("TR");
              tr.id=seq;
              
              var tds=document.createElement("TD");
              var eid=document.createTextNode(emp_id);
              tds.appendChild(eid);
              tr.appendChild(tds);                            
               
              var td1=document.createElement("TD");
              var name=document.createTextNode(emp_name);
              td1.appendChild(name);
              tr.appendChild(td1);    
             
              var td2=document.createElement("TD");
              var des=document.createTextNode(desig_id);
              td2.appendChild(des);
              tr.appendChild(td2); 
              
              var td3=document.createElement("TD");
              var office=document.createTextNode(office_name);
              td3.appendChild(office);
              tr.appendChild(td3); 
                                                              
              tlist.appendChild(tr);             
              seq++;
              } 
              
              
              
              
          }
        }
}
function confirmlogin()
{
      
       var type=document.frmValidationSummaryRep.Desig.options[document.frmValidationSummaryRep.Desig.selectedIndex].value;
       var url="../../../Bulk_Userid_Create?command=create&desig=" + type ;
           
      req.open("GET",url,true);   
          req.onreadystatechange=loginsuccess;
      
       req.send(null);
         
 }

function  loginsuccess()
{
	
     if(req.readyState==4)
        {
          if(req.status==200)
          { 
        	  var response=req.responseXML.getElementsByTagName("response")[0];
              var flag=response.getElementsByTagName("flag")[0].firstChild.nodeValue;
              var command=response.getElementsByTagName("command")[0].firstChild.nodeValue;
              if(flag=="success")
              {
              alert("Successfully Users Account Created");
              }else
              {
            	  alert("Error in Users Account Create");  
              }
              clearAll();   
                                              
          }
        }
}
function clearAll()
{
	 document.frmValidationSummaryRep.subconfirm.disabled=true;
	
	 var tlist=document.getElementById("tlist");
     while (tlist.childNodes.length > 0) {
    	 tlist.removeChild(tlist.firstChild);
     }
     
	
      document.getElementById("cmbsgroup1").selectedIndex=0;
       var des=document.getElementById("Desig");
       var   length = des.options.length;
        for(i = 0; i < length; i++) 
            des.remove(1);
        
}