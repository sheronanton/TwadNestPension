var winemp;
var my_window;
/*  this file contains page specific ajax functions for FILE : UpdatingRoles.jsp  */ 


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
 
 
 // function to clear all
 function clearAll()
 {        
        document.frmMasterSub.txtName.selectedIndex=0;
        document.frmMasterSub.txtSysId.disabled=false;
        document.frmMasterSub.txtSysId.selectedIndex=0;
        document.frmMasterSub.Grant.disabled=false;
        document.frmMasterSub.Revoke.disabled=true;
        document.frmMasterSub.txtOrderSeq.value="";
        document.frmMasterSub.txtEmpName.value="";
      
        document.frmMasterSub.txtUserId.value="";
        document.frmMasterSub.txtSysId.value="";
      
        var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }
        
 }
 
 function addRecord()
 {
  var strCaption=document.frmMasterSub.cmdAdd.value;
    if(strCaption=="  Add  ")
    {
        document.frmMasterSub.cmdAdd.value=" Save ";
        alert("Please Select Master Major Details.");
        document.frmMasterSub.cmdEdit.disabled=true;                  
        document.frmMasterSub.txtSysId.focus();        
    }
    else
    {
        callServer("Add","null");
    }
 
 }
 
 // function to call servlet 
 function callServer(command,param)
 {     
        
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
                    Orderseq=document.frmMasterSub.txtOrderSeq.value;
                     var txtUserId=document.frmMasterSub.txtUserId.value;
                     startwaiting(document.frmMasterSub) ;
                   //url="../../../ServletUpdatingRoles.con?command=Add&txtSysId="+strSysId+"&txtName=" + strName + "&txtDesc=" + strDesc;
                    url="../../../ServletUpdatingRoles.con?command=Add&txtSysId="+strSysId+"&txtName=" + strName + "&Orderseq=" + Orderseq;
                    url=url+"&txtUserId="+txtUserId;
                    //alert(url);
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
                }         
                
          }      
          
          else if(command=="Delete")
          {
                strSysId=document.frmMasterSub.txtSysId.value;
                strName=document.frmMasterSub.txtName.value;
                var txtUserId=document.frmMasterSub.txtUserId.value;
                startwaiting(document.frmMasterSub) ;
                //url="../../../ServletUpdatingRoles.con?command=Delete&txtSysId="+strSysId+"&txtName=" + strName+"&txtDesc="+strDesc;    
                url="../../../ServletUpdatingRoles.con?command=Delete&txtSysId="+strSysId+"&txtName=" + strName;    
                url=url+"&txtUserId="+txtUserId;
                //alert(url);
                req.open("GET",url,true);        
                req.onreadystatechange=processResponse;
                req.send(null);
          }
         
          else if(command=="combo")
          {
            startwaiting(document.frmMasterSub) ;
               url="../../../ServletUpdatingRoles.con?command=combo";
                req.open("GET",url,true);        
                req.onreadystatechange=processResponse;
                req.send(null);          
                
          }   
          else if(command=="Login")
          {
            var txtUserId=document.frmMasterSub.txtUserId.value;
            //var EmpId=document.frmMasterSub.EmpUserId.value;
           // alert(txtUserId);
            //startwaiting(document.frmMasterSub);
            url="../../../ServletUpdatingRoles.con?command=LoginUid&txtUserId="+txtUserId;
            //alert(url);
            req.open("GET",url,true);        
            req.onreadystatechange=processResponse;
            req.send(null);    
          }
          /*
          
           else if(command="Login")
          {
            var txtSysId=document.frmMasterSub.txtSysId.value;
            var EmpId=document.frmMasterSub.EmpId.value;
            startwaiting(document.frmMasterSub) ;
            url="../../../ServletUpdatingRoles.con?command=Login&txtEmpId="+escape(txtSysId);
            req.open("GET",url,true);        
            req.onreadystatechange=processResponse;
            req.send(null);    
          }
          */
          
    }
    
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
              if(command=="Add")
              {
                stopwaiting(document.frmMasterSub) ;
                  addRow(baseResponse);                 
              }
              else if(command=="Delete")
              {    
                stopwaiting(document.frmMasterSub) ;
                  deleteRow(baseResponse);                             
              }
                          
              else if(command=="combo")
              {
                stopwaiting(document.frmMasterSub) ;
                  combo(baseResponse);
              
              }
              else if(command=="Login")
              {
                stopwaiting(document.frmMasterSub) ;
                 login(baseResponse);
              }
              else if(command=="LoginUid")
              {
                stopwaiting(document.frmMasterSub) ;
                 login(baseResponse);
              }
          }
        }
    }
    
    
    function deleteRow(baseResponse)
    {
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
      stopwaiting(document.frmMasterSub) ;
      if(flag=="success")
      {
           alert("Record Deleted Successfully.");
           var RoleId=baseResponse.getElementsByTagName("RoleId")[0].firstChild.nodeValue;
           var tbody=document.getElementById("Existing");                      
           var r=document.getElementById(RoleId);  
           var ri=r.rowIndex;               
           tbody.deleteRow(ri);
           
           document.frmMasterSub.Grant.disabled=false;
           document.frmMasterSub.Revoke.disabled=true;
      }
      else
      {
          alert("Unable to Delete The Record");
          alert("Please Select Employee Name");
      }      
    }
    
   // function to add a record
    function addRow(baseResponse)
    {
            
              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;          
              stopwaiting(document.frmMasterSub) ;
              if(flag=="success")
              {                        
                     alert("Record Inserted Into Database successfully.");
                     //get elements
                     var items=new Array();                   
                     items[0]=document.frmMasterSub.txtName.value;
                     items[1]=document.frmMasterSub.txtName.options[document.frmMasterSub.txtName.selectedIndex].text;
                     items[2]=document.frmMasterSub.txtOrderSeq.value;                  
                     
                     //append a row
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
                     // for including date and bywhom replace 4 by 6
                     var cell2;
                     for(i=0;i<3;i++)
                     {                                           
                         cell2=document.createElement("TD");                               
                         var currenttext=document.createTextNode(items[i]);                         
                         cell2.appendChild(currenttext);       
                         mycurrent_row.appendChild(cell2);       
                     }  
                     
                     tbody.appendChild(mycurrent_row); 
                      
             }
             else
             {
                      alert("RoleName Already Exists");
                      alert("Failed to Insert Values");
             }
        
    }
    function combo(baseResponse)
    {
          var txtSysId=document.getElementById("txtSysId");
          var value=baseResponse.getElementsByTagName("value");
          var EmpName=baseResponse.getElementsByTagName("EmpName");
          //var option=document.createElement("OPTION");
          for(var i=0;i<value.length;i++)
          {
              var comboValue=value.item(i).firstChild.nodeValue;
              var comboValue1=EmpName.item(i).firstChild.nodeValue;
              var option=document.createElement("OPTION");
              option.text=comboValue1;
              option.value=comboValue;
              //Making Browser Independent
              try
              {
                  txtSysId.add(option);
              }
              catch(errorObject)
              {
                  txtSysId.add(option,null);
              }
          }
          
   
    }
   function login(baseResponse)
    {
    stopwaiting(document.frmMasterSub) ;
    //alert('hai');
    
     var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
     if(flag=="failure")
     {
            alert('Cannot retrive the User Id');
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
     else if(flag=="NoRecord")
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
     else
     {
      var empid=baseResponse.getElementsByTagName("empid")[0].firstChild.nodeValue;
      if(empid==0)
      {
        empid="";
        alert("Employee doesn't have login account" );
        var tbody=document.getElementById("tblList");
       // document.frmMasterSub.txtSysId.value="";
      //  document.frmMasterSub.txtEmpName.value="";
       // document.frmMasterSub.txtOrderSeq.value="";
       document.frmMasterSub.txtUserId.value='';
                document.frmMasterSub.reset();
         var t=0;
        for(t=tbody.rows.length-1;t>=0;t--)
        {
            
            tbody.deleteRow(0);
        }
        document.frmMasterSub.txtUserId.focus();

      }
      else
      {
      document.frmMasterSub.txtSysId.value=empid;
      
      document.frmMasterSub.EmpId.value=empid;
      
       var EmpName=baseResponse.getElementsByTagName("EmpName")[0].firstChild.nodeValue;
        
        document.frmMasterSub.txtEmpName.value=EmpName;
        var txtName=document.getElementById("txtName");
        txtName.innerHTML="";
        var option=document.createElement("OPTION");
        
        option.text="--Select Role--";
        try
                {
                txtName.add(option);                
                }catch(errorObject)
                {
                txtName.add(option,null);
                }
        
        var items=new Array();
        var Role=baseResponse.getElementsByTagName("RoleId");
        var RoleName=baseResponse.getElementsByTagName("RoleName");
        
        var OrderSeqNO=baseResponse.getElementsByTagName("OrderSeqNO");
      /* alert(OrderSeqNO.length);
       var len=OrderSeqNO.length;
       for(var s=0;s<len;s++)
        {
            var tOrderSeqNO=OrderSeqNO.item(s).firstChild.nodeValue;
            alert(tOrderSeqNO);
            
        }*/
        
        
        //Getting RoleValue here
        var RoleValue=baseResponse.getElementsByTagName("RoleValue");
        var RoleName1=baseResponse.getElementsByTagName("RoleName1");
        
        for(var k=0;k<RoleValue.length;k++)
        {
        var comboRole=RoleValue.item(k).firstChild.nodeValue;
        var comboName1=RoleName1.item(k).firstChild.nodeValue;
        
        
        var option=document.createElement("OPTION");
        
        option.text=comboName1;
        option.value=comboRole;
                try
                {
                txtName.add(option);                
                }catch(errorObject)
                {
                txtName.add(option,null);
                }
        }
        
        var j=1;
       
         var tbody=document.getElementById("tblList");
        var table=document.getElementById("Existing");
       
        
        // code for clearing the table
     /*   var t=0;
        for(t=tbody.rows.length-1;t>=0;t--)
        {
            
            tbody.deleteRow(0);
        }
       */ 
       
         if(tbody.rows.length >0)
            {        
                     if(tbody.innerText !='undefined'  && tbody.innerText !=null  )
                            tbody.innerText='';
                    else 
                        tbody.innerHTML='';
            }
        
        for(var i=0;i<Role.length;i++)
        {
         var mycurrent_row=document.createElement("TR");
        var tOrderSeqNO=OrderSeqNO.item(i).firstChild.nodeValue;
     //   var EmpName=baseResponse.getElementsByTagName("EmpName")[0].firstChild.nodeValue;
        
      //  document.frmMasterSub.txtEmpName.value=EmpName;
        var cell1=document.createElement("TD");
        var cell2=document.createElement("TD");
        var cell3=document.createElement("TD");
        var comboValue=Role.item(i).firstChild.nodeValue;
        var comboValue1=RoleName.item(i).firstChild.nodeValue;
        mycurrent_row.id=comboValue;
        var cell=document.createElement("TD");
        var anc=document.createElement("A");
        anc.id="a"+comboValue;
        anc.href="javascript:loadValuesFromTable('"+comboValue+"')";
        var edit=document.createTextNode("Edit");
        anc.appendChild(edit);
        cell.appendChild(anc);
        mycurrent_row.appendChild(cell);
        
        //var cell=document.createElement("TD");
      //  alert(tOrderSeqNO);
        var textnode=document.createTextNode(comboValue);
        var textnode1=document.createTextNode(comboValue1);
        var ctOrderSeqNO=document.createTextNode(tOrderSeqNO);
        
        cell1.appendChild(textnode);
        cell2.appendChild(textnode1);
         cell3.appendChild(ctOrderSeqNO);
         
        mycurrent_row.appendChild(cell);
        mycurrent_row.appendChild(cell1);
        mycurrent_row.appendChild(cell2);
        mycurrent_row.appendChild(cell3);
        
        tbody.appendChild(mycurrent_row);
        table.appendChild(tbody);
         j++;
        }
        document.frmMasterSub.txtOrderSeq.value="";
        //document.frmMasterSub.txtEmpName.value="";
        
       }
       }
  }

// code for loading the values from the table to the input boxes
    // functionality for edit anchor
    function loadValuesFromTable(rid)
    {      
          var r=document.getElementById(rid); 
          var txtName=document.getElementById("txtName");
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          var option=document.createElement("OPTION");
          option.text=rcells.item(2).firstChild.nodeValue;
          option.value=rcells.item(1).firstChild.nodeValue;
          //alert(rcells.item(3).firstChild.nodeValue);
          //alert(option.value);
          try
          {
          txtName.add(option);
          }catch(errorObject)
          {
          txtName.add(option,null);
          }
          //alert(document.frmMasterSub.txtName.length);
          document.frmMasterSub.txtName.selectedIndex=document.frmMasterSub.txtName.length-1;//rcells.item(1).firstChild.nodeValue;
          document.frmMasterSub.txtOrderSeq.value=rcells.item(3).firstChild.nodeValue;
          document.frmMasterSub.Revoke.disabled=false;
          document.frmMasterSub.Grant.disabled=true;
          document.frmMasterSub.Revoke.focus();
      
    }
    function fun1()
    {
    alert("hai");
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
document.frmMasterSub.txtSysId.value=emp;
callServer('Login','null');

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