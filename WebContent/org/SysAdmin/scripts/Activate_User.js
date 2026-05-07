// code for creating XMLHTTPREQUEST object
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
 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 

// function to clear all
 function clearAll()
 { 
        document.getElementById("txtUserId").value="";
        document.getElementById("txtSysId").value=""; 
        document.getElementById("txtEmpName").value="";
        document.getElementById("txtUserStatus").value="";
        
        document.frmActivate_User.txtLEnable[0].checked=false
        document.frmActivate_User.txtLEnable[1].checked=false
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 

// function to call servlet 
 function callServer(command,param)
 {     
        if(command=="Login")
          {
            var txtUserId=document.getElementById("txtUserId").value;
            url="../../../Activate_User.con?command=LoginUid&txtUserId="+txtUserId;
            req.open("GET",url,true);        
            req.onreadystatechange=processResponse;
            req.send(null);    
          }
        else if(command=="Add")
          {
            var txtUserId=document.getElementById("txtUserId").value;
            if(document.frmActivate_User.txtLEnable[0].checked==true)
               var txtLEnable=1;
            else if(document.frmActivate_User.txtLEnable[1].checked==true)
               var txtLEnable=0;
            
            var urladd="../../../Activate_User.con?command=Add&txtUserId="+txtUserId+"&txtLEnable="+txtLEnable;
            req.open("GET",urladd,true);        
            req.onreadystatechange=processResponse;
            req.send(null);    
          }
          
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 

// code for processing the xml returned by servlet  
   
    function processResponse()
    {   
      if(req.readyState==4)
        {
          if(req.status==200)
          {               
              var baseResponse=req.responseXML.getElementsByTagName("response")[0];
              var tagCommand=baseResponse.getElementsByTagName("command")[0];
              var command=tagCommand.firstChild.nodeValue; 
              if(command=="LoginAdd")
              {   
                  LoginAdd(baseResponse);                 
              }
              else if(command=="LoginUid")
              {
                 login(baseResponse);
              }
          }
        }
    }
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 


 function login(baseResponse)
    {
     var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
     if(flag=='failure')
     {
            alert('Can not retrive the User Id');
            var tbody=document.getElementById("tblList");
             if(tbody.rows.length >0)
                {        
                         if(tbody.innerText !='undefined'  && tbody.innerText !=null  )
                                tbody.innerText='';
                        else 
                            tbody.innerHTML='';
                }
            document.frmActivate_User.reset();
            return;
      }
      else if(flag=='NoRecord')
      {
            alert('Invalid User Id');
             var tbody=document.getElementById("tblList");
             if(tbody.rows.length >0)
                {        
                         if(tbody.innerText !='undefined'  && tbody.innerText !=null  )
                                tbody.innerText='';
                        else 
                            tbody.innerHTML='';
                }
            document.frmMasterSub.reset();
            return;
      }
     
        var empid=baseResponse.getElementsByTagName("empid")[0].firstChild.nodeValue;
            if(empid==0)
              {
                 empid="";
                 alert("Employee doesn't have Login Account" );
              }
            document.getElementById("txtSysId").value=empid;
   
        var empname=baseResponse.getElementsByTagName("EmpName")[0].firstChild.nodeValue;
            document.getElementById("txtEmpName").value=empname;
        
        var user_status=baseResponse.getElementsByTagName("login_enabled")[0].firstChild.nodeValue;
            if(user_status==1)
              {
                  document.getElementById("txtUserStatus").value="ENABLED";
                  document.frmActivate_User.txtLEnable[0].checked=true
              }
            else if (user_status==0)
              {
                  document.getElementById("txtUserStatus").value="DISABLED";
                  document.frmActivate_User.txtLEnable[1].checked=true
              }
       //Clear Employee Name and User Status if there is no employee id       
       if(empid==0)
              {
              document.getElementById("txtEmpName").value="";
              document.getElementById("txtUserStatus").value="";
              }
  }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

function LoginAdd(baseResponse)
{
   var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
   if(flag=='success')
     {
     
     alert("Data Saved Successfully");
     clearAll();
     }
   else if(flag=='failure')
     {
     alert("Data Not Saved ");
     }
     
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

 function Exit()
 {
    window.open('','_parent','');
    window.close();
 }