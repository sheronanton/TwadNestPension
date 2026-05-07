//////////////   FOR EMPLOYEE POPUP WINDOW //////////////////////
var winemp;
//alert('kkk');
function servicepopup1()
{
    if (winemp && winemp.open && !winemp.closed) 
    {
       winemp.resizeTo(500,500);
       winemp.moveTo(250,250); 
       winemp.focus();
    }
    else
    {
        winemp=null
    }
        
    winemp= window.open("../../../org/HR/HR1/EmployeeMaster/jsps/EmpServicePopup.jsp","mywindow1","status=1,height=500,width=500,resizable=YES, scrollbars=yes"); 
    winemp.moveTo(250,250);  
    winemp.focus();
    
}

function doParentEmp(emp)
{
document.frmEmployee.txtEmpId1.value=emp;
callServer1('Load','null');

}



///////////////////////////////////////////////////////////////////////////////////


//////////////   FOR JOB POPUP WINDOW //////////////////////
var winjob;

function jobpopup1()
{
    if (winjob && winjob.open && !winjob.closed) 
    {
       winjob.resizeTo(500,500);
       winjob.moveTo(250,250); 
       winjob.focus();

    }
    else
    {
        winjob=null
    }
        
    winjob= window.open("../../../org/HR/HR1/OfficeMaster/jsps/JobPopupJSP.jsp","JobSearch","status=1,height=500,width=500,resizable=YES, scrollbars=yes"); 
    winjob.moveTo(250,250);  
 
    winjob.focus();
    
}

function forChildOption()
{

  if (winjob && winjob.open && !winjob.closed) 
         winjob.officeSelection(true,true,true,true);
}

function doParentJob(jobid,deptid)
{
//alert(deptid);
//if(deptid==null)
{
    document.frmEmployee.Office_Id.value=jobid;
    callServer1('ExistgOff','null');
    
    return true
}
/*else
{
        alert('Please select a TWAD Office');
        if (winjob && winjob.open && !winjob.closed) 
        {
           winjob.resizeTo(500,500);
           winjob.moveTo(250,250); 
           winjob.focus();
        }
        return false
}*/
}

window.onunload=function()
{
//alert('hello');
if (winemp && winemp.open && !winemp.closed) winemp.close();
if (winjob && winjob.open && !winjob.closed) winjob.close();
}

///////////////////////////////////////////////////////////////////////////////////

/*function getDesignation2()
    {
   
        var type=document.frmEmployee.cmbsgroup.options[document.frmEmployee.cmbsgroup.selectedIndex].value;
        if(type!=0)
        {
            var din=document.getElementById("divdes");
            din.style.visibility="visible";
            document.frmEmployee.cmbdes.style.visibility="visible";
            loadOfficesByType1(type);
        }
        else
        {
             var din=document.getElementById("divdes");
            din.style.visibility="hidden";
            document.frmEmployee.cmbdes.style.visibility="hidden";
        }
    }
    
      function loadOfficesByType2(type)
    {
        //alert(type);
        var type=document.frmEmployee.cmbsgroup.options[document.frmEmployee.cmbsgroup.selectedIndex].value;
       var url="../../../EmpServicePopupServ.view?Command=SGroup&cmbsgroup=" + type ;
        var req=getTransport();
        req.open("GET",url,false);        
        req.onreadystatechange=function()
        {
            
             loadDesignation1(req);
        }
        req.send(null);
    }*/

//***************************************************************************//
 function getDesignation1()
    {
   
        var type=document.frmEmployee.cmbsgroup.options[document.frmEmployee.cmbsgroup.selectedIndex].value;
        if(type!=0)
        {
            var din=document.getElementById("divdes");
            din.style.visibility="visible";
            document.frmEmployee.cmbdes.style.visibility="visible";
            loadOfficesByType1(type);
        }
        else
        {
             var din=document.getElementById("divdes");
            din.style.visibility="hidden";
            document.frmEmployee.cmbdes.style.visibility="hidden";
        }
    }
    
      function loadOfficesByType1(type)
    {
        //alert(type);
        var type=document.frmEmployee.cmbsgroup.options[document.frmEmployee.cmbsgroup.selectedIndex].value;
       var url="../../../EmpServicePopupServ.view?Command=SGroup&cmbsgroup=" + type ;
        var req=getTransport();
        req.open("GET",url,false);        
        req.onreadystatechange=function()
        {
            
             loadDesignation1(req);
        }
        req.send(null);
    }
    
function  loadDesignation1(req)
{
     if(req.readyState==4)
        {
          if(req.status==200)
          { 
                //alert(req);
                var des=document.getElementById("cmbdes");
                var i=0;
                var response=req.responseXML.getElementsByTagName("response")[0];
                var flag=response.getElementsByTagName("flag")[0].firstChild.nodeValue;
                des.innerHTML="";
                
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
                        var id=tmpoption.getElementsByTagName("id")[0].firstChild.nodeValue;
                        var name=tmpoption.getElementsByTagName("name")[0].firstChild.nodeValue;
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
    
    
    //***************************************************************************//

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
// function to clear all the combo and text fields and even the grid
 function clearAll()
 {        
        document.frmEmployee.txtEmpId1.value="";
        document.frmEmployee.txtEmpName.value="";
        document.frmEmployee.cmbsgroup.selectedIndex=0;
        document.frmEmployee.cmbdes.selectedIndex=0;
         document.frmEmployee.Office_Id.value="";
         document.frmEmployee.Office_Name.value="";
          document.frmEmployee.txtdtjoin.value="";
          document.frmEmployee.txtremarks.value="";
        
                       
       
 }
 
 //This is to check the Redundancy of the Existing Record
  function checkForRedundancy()
{
                        strEmpName=document.frmEmployee.txtEmpId1.value;
                         strDesig=document.frmEmployee.cmbdes.value;
                         strOffName=document.frmEmployee.Office_Id.value;
                         strDtjoin=document.frmEmployee.txtdtjoin.value;
                         strRemarks=document.frmEmployee.txtremarks.value;
   
   if((strEmpName=="")&&(strDesig=="")&&(strOffName=="")&&(strDtjoin=="")&&(strRemarks==""))
          {           
          
              alert("Enter Employee Id");
                return true;
            }
            else 
            {
                       url="../../../Current_Posting_Servlet.view?command=check&EName="+strEmpName;
                    //req.abort();
                    var req=getTransport();
                    req.open("GET",url,true);
                    req.onreadystatechange=function()
                    {
                    handleResponse(req);
                    }
                    req.send(null);
            }
}



function callServer1(command,param)
 {     
       
          var strEmpName;
          var strDesig;
          var strOffName;
          var strDtjoin;  
          var strRemarks;
             strEmpName=document.frmEmployee.txtEmpId1.value;
             strDesig=document.frmEmployee.cmbdes.value;
             strOffName=document.frmEmployee.Office_Id.value;
             strDtjoin=document.frmEmployee.txtdtjoin.value;
             strRemarks=document.frmEmployee.txtremarks.value;
          
          if(command=="Grant")
          {           
          
                       url="../../../Current_Posting_Servlet.view?command=Grant&EName="+strEmpName+"&Desig=" + strDesig+ "&OffName="+strOffName+"&Dtjoin=" +strDtjoin +"&Remarks="+strRemarks;
                       //alert("grant"+url);
                       //req.abort();
                       var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                    handleResponse(req);
                    }
                    req.send(null);
            }
         else if(command=="Load")
         { 
         //alert("before url");
         document.frmEmployee.txtEmpName.value="";
        document.frmEmployee.cmbsgroup.selectedIndex=0;
        document.frmEmployee.cmbdes.selectedIndex=0;
         document.frmEmployee.Office_Id.value="";
         document.frmEmployee.Office_Name.value="";
          document.frmEmployee.txtdtjoin.value="";
          document.frmEmployee.txtremarks.value="";
            url="../../../Current_Posting_Servlet.view?command=Load&EName=" + strEmpName;
           // alert(url);
           //req.abort();
           var req=getTransport();
            req.open("GET",url,true); 
            req.onreadystatechange=function()
            {
            handleResponse(req);
            }
            req.send(null);
        }
       else if(command=="Delete")
        {
           if(confirm("Do You Really want to Delete it"))
                        {
            url="../../../Current_Posting_Servlet.view?command=Delete&EName=" + strEmpName;
            //req.abort();
            var req=getTransport();
            req.open("GET",url,true);        
            req.onreadystatechange=function()
            {
            handleResponse(req);
            }
            req.send(null);
            }
        }
        else if(command=="Update")
        {
           
            url="../../../Current_Posting_Servlet.view?command=Update&EName="+strEmpName+"&Desig=" + strDesig+ "&OffName="+strOffName+"&Dtjoin=" +strDtjoin +"&Remarks="+strRemarks;
            //req.abort();
            var req=getTransport();
            req.open("GET",url,true);        
            req.onreadystatechange=function()
            {
            handleResponse(req);
            }
            req.send(null);
        }
        else if(command=="ExistgOff")
       {
        
           var strOffId=document.frmEmployee.Office_Id.value;
          //  alert("s com in" +strOffId);
          url="../../../Current_Posting_Servlet.view?command=ExistgOff&OffName=" + strOffName ;
                    var req=getTransport();
            req.open("GET",url,true);        
            req.onreadystatechange=function()
            {
            handleResponse(req);
            }
            req.send(null);
       }
}


function handleResponse(req)
    {   
    if(req.readyState==4)
        {
          if(req.status==200)
          {            
              var baseResponse=req.responseXML.getElementsByTagName("response")[0];
              var tagCommand=baseResponse.getElementsByTagName("command")[0];
              var command=tagCommand.firstChild.nodeValue; 
              if(command=="Grant")
              { 
              //alert("command"+command);
                  addRow(baseResponse);                 
              }
              else if(command=="check")
              {
              checkRow(baseResponse);
              }
              else if(command=="Delete")
              {
              deleteRow(baseResponse);
              }
              else if(command=="Load")
              {
              loadRow(baseResponse);
              }
              else if(command=="Update")
              {
              updateRow(baseResponse);
              }
              else if(command=="ExistgOff")
              {
                  existOffRow(baseResponse);                 
              }

          }
        }
  }
function checkRow(baseResponse)
{ 
var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                     var check=false;
                  check=nullCheck();
                  if(check==true)
                  {
                      callServer1('Update','null');
                   }   
                     
                     }
                    
                  else
                  {
                  var check=false;
                  check=nullCheck();
                  if(check==true)
                  {
                  callServer1('Grant','null');
                  }
                 
                  }
 
}


function addRow(baseResponse)
    {
                

              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
              
                  if(flag=="success")
                  {
                       
                      alert("Record inserted into the database successfully");
                      clearAll();
                     
                  }
                  
                  else
                  {
                      alert("Failed to Insert values");                     
                  }

    }

function deleteRow(baseResponse)
  {
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                      alert("Records are Deleted"); 
                       clearAll();
                  }
                  else
                  {
                      alert("Unable to Delete");
                  }
   
  }

function loadRow(baseResponse)
 {
                    
                    //alert("load");    
                        var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                   
                          var empid=baseResponse.getElementsByTagName("EMP_ID");
                          
                         for(j=0;j<empid.length;j++)
                          {
                              var items=new Array();
                              var empname=baseResponse.getElementsByTagName("EMPLOYEE_NAME"); 
                              var desig=baseResponse.getElementsByTagName("DESIGNATION");
                              var offid=baseResponse.getElementsByTagName("OFFICE_ID");
                              var offname=baseResponse.getElementsByTagName("OFFICE_NAME"); 
                              var jdate=baseResponse.getElementsByTagName("JDate"); 
                              var remarks=baseResponse.getElementsByTagName("Remarks"); 
                              var sgroup=baseResponse.getElementsByTagName("ServGroup");
                              var designId=baseResponse.getElementsByTagName("DesignId");
                                                      // append a row
                              var tbody=document.getElementById("tblList");
                              var table=document.getElementById("Existing");

                            var tempid=empid.item(j).firstChild.nodeValue;
                            var tempname=empname.item(j).firstChild.nodeValue;
                            var tdesig=desig.item(j).firstChild.nodeValue;
                            var toffid=offid.item(j).firstChild.nodeValue;
                            var toffname=offname.item(j).firstChild.nodeValue;
                            var tjdate=jdate.item(j).firstChild.nodeValue;
                            var tremarks=remarks.item(j).firstChild.nodeValue;
                            var servgrp=sgroup.item(j).firstChild.nodeValue;
                            var tdesignId=designId.item(j).firstChild.nodeValue;
                            
                            document.frmEmployee.txtEmpName.value=tempname;
                            document.frmEmployee.Office_Id.value=toffid;
                            document.frmEmployee.Office_Name.value=toffname;
                            document.frmEmployee.txtdtjoin.value=tjdate;
                            document.frmEmployee.txtremarks.value=tremarks;
                            
                            if(servgrp==0)
                       servgrp=0;
                    else   
                    document.frmEmployee.cmbsgroup.value =servgrp;
                     getDesignation1();
                   //alert("design id"+tdesignId);  
                    if (tdesignId==0)
                    {
                      // alert(tdesignId);
                        tdesignId=0;
                      }  
                     else
                     {
                     //alert( document.frmEmployee.cmbdes.value = tdesignId);
                      document.frmEmployee.cmbdes.value = tdesignId;
                      }
                            
                            
                          }
                          
                       }
                      
                     else if(flag=="NoRecord")
                     {
                    
                       // alert("No Record Exists for the given Employee Id - Insert New Record");
                        var tempname=baseResponse.getElementsByTagName("EMPLOYEE_NAME")[0].firstChild.nodeValue; 
                        //alert(tempname);
                        document.frmEmployee.txtEmpName.value=tempname;
                        
                       
                     }
                     else if(flag=="NoValue")
                    {
                      alert("Employee Id Does not Exists - Create Id for the Employee First");
                      document.frmEmployee.txtEmpId1.value="";
                      document.frmEmployee.txtEmpId1.focus();
                    }
                     else
                     {
                      alert("Record does not exist. Insert a new Record");
                     }
                     
 
} 
function updateRow(baseResponse)
{ 
var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                    alert("Records are updated successfully");
                    clearAll();
                  }
                  else
                  {
                    alert("Failed to update");
                  }
}   

function existOffRow(baseResponse)
    {
              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue; 
             
              if(flag=="success")
              { 
                    document.frmEmployee.Office_Name.value=baseResponse.getElementsByTagName("OffName")[0].firstChild.nodeValue; 
              }
              else if(flag=="NoValue")
              {
                 alert("No Office Exists - Give Some other Office Id");
                 document.frmEmployee.Office_Id.value="";
                 document.frmEmployee.Office_Id.focus();
                 
              }
              else
              {
                alert("Failed to load office details");
              }
   }


function disp()
{
   if(document.frmEmployee.Office_Id.value=="")
   {
     alert("Select Office Name - It should not be empty");
     document.frmEmployee.Office_Id.focus();
     return false;
   }
}




//To Check the null values
function nullCheck()
{
   if(document.frmEmployee.txtEmpId1.value=="")
   {
      alert("Select the Employee Name");
      document.frmEmployee.txtEmpId1.focus();
      return false;
   }
   
   else if(document.frmEmployee.cmbsgroup.value=="")
   {
     alert("Select Service Group Name to select Designation");
     document.frmEmployee.cmbsgroup.focus();
     return false;
   }
   else if(document.frmEmployee.cmbdes.value=="")
   {
     alert("Select Employee Designation");
     document.frmEmployee.cmbdes.focus();
     return false;
   }
   else if(document.frmEmployee.Office_Id.value=="")
   {
     alert("Select Office Name");
     document.frmEmployee.Office_Id.focus();
     return false;
   }
   else if(document.frmEmployee.txtdtjoin.value=="")
   {
      alert("Enter Date of Joining");
       document.frmEmployee.txtdtjoin.focus();
       return false;
   }
   else if(document.frmEmployee.txtremarks.value=="")
   {
     alert("Enter Remarks for the Employee Selected");
     document.frmEmployee.txtremarks.focus();
     return false;
   }
   return true;
}   

//Date validation
function validate_date(formName, textName)
 {
 
                var errMsg="", lenErr=false, dateErr=false;
                var testObj=eval('document.' + formName + '.' + textName + '.value');
                var testStr=testObj.split('/');
                if(testStr.length>3 || testStr.length<3)
                {
                    lenErr=true;
                    dateErr=true;
                    errMsg+="There is an error in the date format.";
                }
                var monthsArr = new Array("01", "02", "03", "04", "05", "06", "07", "08" ,"09", "10", "11", "12");
                var daysArr = new Array;
                for (var i=0; i<12; i++)
                {
                    if(i!=1)
                    {
                       if((i/2)==(Math.round(i/2)))
                       {
                          if(i<=6)
                          {
                              daysArr[i]="31";
                           }
                           else
                           {
                               daysArr[i]="30";
                           }
                        }
                       else
                       {
                          if(i<=6)
                          {
                                daysArr[i]="30";
                          }
                          else
                          {
                               daysArr[i]="31";
                          }
                       }
                    }
                    else
                    {
                        if((testStr[2]/4)==(Math.round(testStr[2]/4)))
                        {
                            daysArr[i]="29";
                        }
                        else
                        {
                            daysArr[i]="28";
                        }
                    }
                } 
                var monthErr=false, yearErr=false;
                if(testStr[2]<1000 && !lenErr)
                {
                    yearErr=true;
                    dateErr=true;
                    errMsg+="\nThe year \"" + testStr[2] + "\" is not correct.";
                }
                for(var i=0; i<12; i++)
                {
                    if(testStr[1]==monthsArr[i])
                    {
                      var setMonth=i;
                      break;
                    }
                }
                if(!lenErr && (setMonth==undefined))
                {
                    monthErr=true;
                    errMsg+="\nThe month \"" + testStr[1] + "\" is not correct.";
                    dateErr=true;
                }
                if(!monthErr && !yearErr && !lenErr)
                {
                    if(testStr[0]>daysArr[setMonth])
                    {
                        errMsg+=testStr[1] + ' ' + testStr[2] + ' does not have ' + testStr[0] + ' days.';
                        dateErr=true;
                    }
                }
                if(!dateErr)
                {
                    //eval('document.' + formName + '.' + 'submit()');
                }
                else
                {
                    alert(errMsg + '\n____________________________\n\nSample Date Format :\n dd/MM/yyyy');
                    eval('document.' + formName + '.' + textName + '.focus()');
                    eval('document.' + formName + '.' + textName + '.select()');
                    
                    return false;
                }
                
                 return true;  
                     
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