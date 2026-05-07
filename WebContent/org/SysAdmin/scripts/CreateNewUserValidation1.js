var winemp;
var my_window;

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
 
 
 function servicepopup()
{
    if (winemp && winemp.open && !winemp.closed) 
    {
       winemp.resizeTo(500,600);
       winemp.moveTo(200,200); 
       winemp.focus();
       return ;
    }
    else
    {
        winemp=null
    }
   
    winemp= window.open("../../../org/HR/HR1/EmployeeMaster/jsps/EmpServicePopup.jsp","mywindow1","status=1,height=500,width=600,resizable=YES, scrollbars=yes"); 
    winemp.moveTo(250,250);  
    winemp.focus();
    
}

function doParentEmp(emp)
{
document.frmCreateUser.txtEmployeeId.value=emp;
callLogin('EmpName','null');

}
//this is the function to close the employee popup windows...
window.onunload=function()
{
if (winemp && winemp.open && !winemp.closed) winemp.close();
if (my_window && my_window.open && !my_window.closed) my_window.close();

}

function numbersonly1(e,t)
    {
       var unicode=e.charCode? e.charCode : e.keyCode;
       if(unicode==13)
        {
          try{t.blur();}catch(e){}
          return true;
        
        }
        if (unicode!=8 && unicode !=9  )
        {
            if (unicode<48||unicode>57 ) 
                return false 
        }
     }
     
     
      function Exit()
 {
    window.open('','_parent','');
    window.close();
 }
 
 



function callLogin(command,param)
{
//alert("hai");
//document.frmCreateUser.txtLoginId.value="twad"+document.frmCreateUser.txtEmployeeId.value;
//document.frmCreateUser.LoginId.value="twad"+document.frmCreateUser.txtEmployeeId.value;
document.frmCreateUser.txtLoginId.disabled=true;


                if(command=="EmpName")
                {
                    var strEmpId=document.frmCreateUser.txtEmployeeId.value;
                   // alert(strEmpId);
                   var  url="../../../CreateNewUser_EmpName.con?command=EmpName&EmpId="+strEmpId;
                  //  alert(url);
                    req.open("GET",url,true);        
                   // alert("1");
                    req.onreadystatechange=function()
                    {
                    processResponse(req);
                    }
                    req.send(null);
                  //  alert("2");
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
             // alert(command);
              if(command=="EmpName")
              {
                
                emprow(baseResponse);
                
              
              }
          }
        }
    }

function emprow(baseResponse)
{
  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
   if(flag=="success")
   {
     var EmployeeName=baseResponse.getElementsByTagName("EmpName")[0].firstChild.nodeValue;
      var empid=document.frmCreateUser.txtEmployeeId.value;  
      document.frmCreateUser.reset();
      document.frmCreateUser.txtEmployeeId.value=empid;
      document.frmCreateUser.txtEmpName.value=EmployeeName;
      document.frmCreateUser.txtLoginId.value="twad"+document.frmCreateUser.txtEmployeeId.value;
      document.frmCreateUser.LoginId.value="twad"+document.frmCreateUser.txtEmployeeId.value;
      document.frmCreateUser.txtLoginId.disabled=true;
      document.frmCreateUser.txtPassword.focus();
   }
   else if(flag=='exist')
   {
        alert('This employee already has User Id');
        document.frmCreateUser.reset();
         document.frmCreateUser.txtEmployeeId.focus();
   }
   else
   {
       alert('Employee Id does not exist');
        document.frmCreateUser.reset();
        document.frmCreateUser.txtEmployeeId.focus();
   }
}

function nullCheck()
{
//alert("hai");
        if((document.frmCreateUser.txtEmployeeId.value=="") || (document.frmCreateUser.txtEmployeeId.length<=0))
        {
            alert("Select EmployeeId");
            document.frmCreateUser.txtEmployeeId.focus();
            return false;
        }
        if((document.frmCreateUser.txtLoginId.value=="") || (document.frmCreateUser.txtLoginId.length<=0))
        {
            alert("Enter LoginId");
            document.frmCreateUser.txtLoginId.focus();
            return false;
        }
        if((document.frmCreateUser.txtPassword.value=="") || (document.frmCreateUser.txtPassword.length<=0))
        {
            alert("Enter Password");
            document.frmCreateUser.txtPassword.focus();
            return false;
        }
        if((document.frmCreateUser.txtConfirmPassword.value=="") || (document.frmCreateUser.txtConfirmPassword.length<=0))
        {
            alert("Enter Confirm Password");
            document.frmCreateUser.txtConfirmPassword.focus();
            return false;
        }
        //alert("
        var password=document.frmCreateUser.txtPassword.value;
        var confirm=document.frmCreateUser.txtConfirmPassword.value;
        //alert(password);
        //alert(confirm);
        if(password!=confirm)
        {
        alert("Both Passwords Should Be Same");
        document.frmCreateUser.txtPassword.value="";
        document.frmCreateUser.txtConfirmPassword.value="";
        document.frmCreateUser.txtPassword.focus();
        return false;
        
        }
        return true;

}


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