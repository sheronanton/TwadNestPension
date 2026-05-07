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
 
 function Exit()
 {
    window.open('','_parent','');
    window.close();
 }
 
// function to clear all
 function clearAll()
 {        
        document.frmMasterRolesMenu.txtCmbRId.selectedIndex=0;
        document.frmMasterRolesMenu.txtCmbMajId.selectedIndex=0;
        document.frmMasterRolesMenu.txtCmbMinorId.innerHTML="";
        document.frmMasterRolesMenu.txtCmbSubId.innerHTML="";
        document.frmMasterRolesMenu.txtCmbMenu.innerHTML="";
        document.frmMasterRolesMenu.cmdAdd.disabled=false;
        document.frmMasterRolesMenu.txtCmbRId.disabled=false;
         var minor=document.createElement("OPTION");
        minor.text="--Select Minor--";
        try
        {
        document.frmMasterRolesMenu.txtCmbMinorId.add(minor);
         }
         catch(e)
         {
         document.frmMasterRolesMenu.txtCmbMinorId.add(minor,null);
         }
         var sub=document.createElement("OPTION");
        sub.text="--Select Sub-System--";
        try
        {
        document.frmMasterRolesMenu.txtCmbSubId.add(sub);
        }
        catch(e)
        {
        document.frmMasterRolesMenu.txtCmbSubId.add(sub,null);
        }
        
        var menu=document.createElement("OPTION");
        menu.text="--Select Menu--";
        try
        {
        document.frmMasterRolesMenu.txtCmbMenu.add(menu);
        }
        catch(e)
        {
        document.frmMasterRolesMenu.txtCmbMenu.add(menu,null);
        }
        var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }
        
 }

//CODE TO POPULAT THE SUB SYSTEM COMBO ON CLICKING THE MAJOR SYSTEM COMBO
function combomajor(event)
{
//alert(req);
var sele=document.frmMasterRolesMenu.txtCmbMajId.value;//First Combo name
var url="../../../ServletRolesMenu.con?Type=major&First=" +sele;
req.open("GET",url,true);
req.onreadystatechange=callCombo2;
req.send(null);

}
function comboMinor(event)
{
//alert("minor");
var sele=document.frmMasterRolesMenu.txtCmbMajId.value;//First Combo name
var sele1=document.frmMasterRolesMenu.txtCmbMinorId.value;
var url="../../../ServletRolesMenu.con?Type=minor&First=" +sele+"&Second="+sele1;
req.open("GET",url,true);
req.onreadystatechange=callCombo1;
req.send(null);

}

function callCombo2()
{
//alert("req"+req);
if(req.readyState==4)
{
  if(req.status==200)
   {
   //alert("in side the if status"+req);
   //alert("response is : " + req.responseText);     
   var i;
   var j;
   var first=document.getElementById("txtCmbMinorId");//Second Combo name
   first.innerHTML="";
   
   var sel=req.responseXML.getElementsByTagName("select")[0];
   
   var options=sel.getElementsByTagName("option");
   var htop=document.createElement("OPTION");
    htop.text="--Select Minor--";
    try
    {
    first.add(htop);
    }
    catch(e)
    {
    first.add(htop,null);
    }
   for(i=0;i<options.length;i++)
   {
   
    var desc=options[i].getElementsByTagName("desc")[0].firstChild.nodeValue;
   var id=options[i].getElementsByTagName("id")[0].firstChild.nodeValue;
   var htoption=document.createElement("OPTION");
   htoption.text=desc;
   htoption.value=id;
   try
   {
    first.add(htoption);
   }
   catch(e)
   {
     first.add(htoption,null);
   }
  }
  Load2(event)
  } 
  
 }  
}

function callCombo1()
{
//alert("inner combo1");
if(req.readyState==4)
{
  if(req.status==200)
   {
     //alert("in side the if status"+req);
   //alert("response is : " + req.responseText);
   var i;
   var j;
   var first=document.getElementById("txtCmbSubId");//Second Combo name
   first.innerHTML="";
   //alert("innerhtml");
   var sel=req.responseXML.getElementsByTagName("select")[0];
   
   var options=sel.getElementsByTagName("option");
   var htop=document.createElement("OPTION");
   //alert("text");
    htop.text="--Select Sub-System--";
     try
    {
    first.add(htop);
    //alert("in try");
    }
    catch(e)
    {
    //alert("in catch");
    first.add(htop,null);
    }
  for(i=0;i<options.length;i++)
   {
   
    var desc=options[i].getElementsByTagName("desc")[0].firstChild.nodeValue;
   var id=options[i].getElementsByTagName("id")[0].firstChild.nodeValue;
   var htoption=document.createElement("OPTION");
   htoption.text=desc;
   htoption.value=id;
    try
    {
    first.add(htoption);
    }
    catch(e)
    {
    first.add(htoption,null);
    }
    
  }
  Load3(event)
   }
 }  
}
//CODE TO POPULATE THE MENU COMBO ON CLICKING THE SUB SYSTEM COMBO
function comboSub()
{ 
var RoleId=document.frmMasterRolesMenu.txtCmbRId.value;
var sele=sele=document.frmMasterRolesMenu.txtCmbMajId.value;
var sele1=document.frmMasterRolesMenu.txtCmbMinorId.value;//Second Combo name
var sele2=document.frmMasterRolesMenu.txtCmbSubId.value;
var url="../../../ServletRolesMenu.con?Type=SubSystem&First="+sele+"&Second=" +sele1+"&Third="+sele2+"&RoleId="+RoleId;

req.open("GET",url,true);
req.onreadystatechange=callComboMenu;
req.send(null);


}

function callComboMenu()
{
if(req.readyState==4)
{
  if(req.status==200)
   {
     
   var i;
   var second=document.getElementById("txtCmbMenu");//Third Combo name
   second.innerHTML="";
   var sel=req.responseXML.getElementsByTagName("select")[0];
   var options=sel.getElementsByTagName("option");
    var htop=document.createElement("OPTION");
    htop.text="--Select Menu--";
    try
    {
    second.add(htop);
    }
    catch(e)
    {
    second.add(htop,null);
    }
    
   for(i=0;i<options.length;i++)
   {
    var desc=options[i].getElementsByTagName("desc")[0].firstChild.nodeValue;
    var id=options[i].getElementsByTagName("id")[0].firstChild.nodeValue;
    var htoption=document.createElement("OPTION");
   htoption.text=desc;
   htoption.value=id;
   
    try
    {
    second.add(htoption);
    }
    catch(e)
    {
    second.add(htoption,null);
    } 
   }
     Load4(event);
  }

   }
 }  




//CODE TO ADD RECORDS

function callServer(command,param)
 {     
       
          var strRId;
          var strMajor;
          var strMinor;
          var strSub;
          var strMenu;  
          strRId=document.frmMasterRolesMenu.txtCmbRId.value;
                    strMajor=document.frmMasterRolesMenu.txtCmbMajId.value;
                    strMinor=document.frmMasterRolesMenu.txtCmbMinorId.value;
                    strSub=document.frmMasterRolesMenu.txtCmbSubId.value;
                   strMenu=document.frmMasterRolesMenu.txtCmbMenu.value;
          
          if(command=="Add")
          {           
                       url="../../../ServletRolesMenu1.con?command=Add&RId="+strRId+"&Major=" + strMajor+"&Minor=" + strMinor+"&SubSys="+strSub+"&Menu=" +strMenu;
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
            }
      else if(command=="Delete")
      {
        url="../../../ServletRolesMenu1.con?command=Delete&RId=" + strRId +"&Major=" + strMajor+ "&Minor=" + strMinor+"&SubSys="+strSub+"&Menu=" +param;        
        req.open("GET",url,true);        
        req.onreadystatechange=processResponse;
        req.send(null);
      }
}


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
                  addRow(baseResponse);                 
              }
              else if(command=="Delete")
              {
              deleteRow(baseResponse)
              }
              else if(command=="check")
              {
              checkRow(baseResponse);
              }
              else if(command=="Load")
              {
              loadRow(baseResponse);
              }
            else if(command=="Load1")
              {
              loadRow1(baseResponse);
              }
              else if(command=="Load2")
              {
              loadRow1(baseResponse);
              }
              else if(command=="Load3")
              {
              loadRow1(baseResponse);
              }
              else if(command=="Load4")
              {
              loadRow1(baseResponse);
              }

          }
        }
  }

function addRow(baseResponse)
    {
                       

              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                       
                      alert("Record inserted into the database successfully");
                      
                      //get the values from the combo text
                      
                      var items=new Array();
                      items[0]=document.frmMasterRolesMenu.txtCmbRId.options[document.frmMasterRolesMenu.txtCmbRId.selectedIndex].text;
                      items[1]=document.frmMasterRolesMenu.txtCmbMajId.options[document.frmMasterRolesMenu.txtCmbMajId.selectedIndex].text;
                      items[2]=document.frmMasterRolesMenu.txtCmbMinorId.options[document.frmMasterRolesMenu.txtCmbMinorId.selectedIndex].text;
                      items[3]=document.frmMasterRolesMenu.txtCmbSubId.options[document.frmMasterRolesMenu.txtCmbSubId.selectedIndex].text;
                      items[4]=document.frmMasterRolesMenu.txtCmbMenu.options[document.frmMasterRolesMenu.txtCmbMenu.selectedIndex].text;
                      
                      var elem=new Array();
                      elem[0]=document.frmMasterRolesMenu.txtCmbRId.value;
                      elem[1]=document.frmMasterRolesMenu.txtCmbMajId.value;
                      elem[2]=document.frmMasterRolesMenu.txtCmbMinorId.value;
                      elem[3]=document.frmMasterRolesMenu.txtCmbSubId.value;
                      elem[4]=document.frmMasterRolesMenu.txtCmbMenu.value;
                      
                      // append a row
                      
                     var tbody=document.getElementById("tblList");
                     
                     var mycurrent_row=document.createElement("TR");
                     mycurrent_row.id=elem[4];
                    
                     var cell=document.createElement("TD");
                     
                     var anc=document.createElement("A");       
                     //var url="javascript:loadValuesFromTable('" + elem[3] + "')"; 
                     var url="javascript:callServer('Delete','"+elem[4]+"')";
                     anc.href=url;
                     var txtedit=document.createTextNode("Revoke");
                     anc.appendChild(txtedit);
                     cell.appendChild(anc);
                     mycurrent_row.appendChild(cell);
                     
                         //var cell1=document.createElement("TD");                                     
                         var cell2=document.createElement("TD");                               
                         var cell3=document.createElement("TD"); 
                         var cell4=document.createElement("TD"); 
                         //var cell5=document.createElement("TD"); 
                         var cell6=document.createElement("TD"); 
                         //var cell7=document.createElement("TD"); 
                         var cell8=document.createElement("TD");
                         var cell9=document.createElement("TD"); 
                         var cell10=document.createElement("TD");                                     
                     
                         var rdesc=document.createTextNode(items[0]);                         
                         var majdesc=document.createTextNode(items[1]); 
                         var minordesc=document.createTextNode(items[2]);
                         var subdesc=document.createTextNode(items[3]); 
                         var menudesc=document.createTextNode(items[4]); 
                         
                         var rid=document.createTextNode(elem[0]);                         
                         var majid=document.createTextNode(elem[1]); 
                         var minorid=document.createTextNode(elem[2]);
                         var subid=document.createTextNode(elem[3]); 
                         var menuid=document.createTextNode(elem[4]); 
                         
                         //cell1.appendChild(rid);       
                         cell2.appendChild(rdesc);       
                         cell4.appendChild(majdesc);
                         //cell5.appendChild(subid);
                         cell6.appendChild(subdesc);
                         cell9.appendChild(menuid);
                         cell10.appendChild(menudesc);
                         //cell9.appendChild(minorid);
                         cell3.appendChild(minordesc);
                         
                         //mycurrent_row.appendChild(cell1);       
                         mycurrent_row.appendChild(cell2);       
                         mycurrent_row.appendChild(cell4);
                         mycurrent_row.appendChild(cell3);
                         //mycurrent_row.appendChild(cell5);
                         mycurrent_row.appendChild(cell6);
                         //mycurrent_row.appendChild(cell7);
                         //mycurrent_row.appendChild(cell8);
                         mycurrent_row.appendChild(cell9);
                         mycurrent_row.appendChild(cell10);
                     
                     tbody.appendChild(mycurrent_row); 
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
                      var rid=baseResponse.getElementsByTagName("Menu")[0].firstChild.nodeValue;
                      //alert("rid"+rid);
                      var tbody=document.getElementById("Existing"); 
                      //alert(tbody);
                      var r=document.getElementById(rid);    
                      //alert("r value"+r);
                      var ri=r.rowIndex;               
                      tbody.deleteRow(ri);  
                      alert("Permission Revoked.");                      
                  }
                  else
                  {
                      alert("Unable to Delete");
                  }
   
  }
 //This function is called when edit is clicked   
function loadValuesFromTable(rid) 
{
          var r=document.getElementById(rid); 
          var txtroleid=document.getElementById("txtCmbRId");
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          var option=document.createElement("OPTION");
          option.text=rcells.item(2).firstChild.nodeValue;
          option.value=rcells.item(1).firstChild.nodeValue;
          document.frmMasterRolesMenu.txtCmbRId.selectedIndex=document.frmMasterRolesMenu.txtCmbRId.length-1;
          
          var txtmajorid=document.getElementById("txtCmbMajId");
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          var option=document.createElement("OPTION");
          option.text=rcells.item(4).firstChild.nodeValue;
          option.value=rcells.item(3).firstChild.nodeValue;
          document.frmMasterRolesMenu.txtCmbMajId.selectedIndex=document.frmMasterRolesMenu.txtCmbMajId.length-1;
          
          var txtsubid=document.getElementById("txtCmbSubId");
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          var option=document.createElement("OPTION");
          option.text=rcells.item(6).firstChild.nodeValue;
          option.value=rcells.item(5).firstChild.nodeValue;
          document.frmMasterRolesMenu.txtCmbSubId.selectedIndex=document.frmMasterRolesMenu.txtCmbSubId.length-1;
          
          var txtmenuid=document.getElementById("txtCmbMenu");
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          var option=document.createElement("OPTION");
          option.text=rcells.item(8).firstChild.nodeValue;
          option.value=rcells.item(7).firstChild.nodeValue;
          document.frmMasterRolesMenu.txtCmbMenu.selectedIndex=document.frmMasterRolesMenu.txtCmbMenu.length-1;
         
      
      
}
//This Load() function is to select the records based on roleid,major id,sub id    
function Load(event)
{

                    var strRId=document.frmMasterRolesMenu.txtCmbRId.value;
                    var strMajor=document.frmMasterRolesMenu.txtCmbMajId.value;
                    var strMinor=document.frmMasterRolesMenu.txtCmbMinorId.value;
                    var strSub=document.frmMasterRolesMenu.txtCmbSubId.value;
                    url="../../../ServletRolesMenu1.con?command=Load&RId="+strRId+"&Major="+strMajor+"&Minor="+strMinor+"&Sub="+strSub;
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
                
}
 
 function Load1(event)
{

                    var strRId=document.frmMasterRolesMenu.txtCmbRId.value;
                    var strMajor=document.frmMasterRolesMenu.txtCmbMajId.value;
                    var strMinor=document.frmMasterRolesMenu.txtCmbMinorId.value;
                    var strSub=document.frmMasterRolesMenu.txtCmbSubId.value;
                    url="../../../ServletRolesMenu1.con?command=Load1&RId="+strRId;
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
                
}

function Load2(event)
{

                    var strRId=document.frmMasterRolesMenu.txtCmbRId.value;
                    var strMajor=document.frmMasterRolesMenu.txtCmbMajId.value;
                    url="../../../ServletRolesMenu1.con?command=Load2&RId="+strRId+"&Major="+strMajor;
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
                
}

function Load3(event)
{

                    var strRId=document.frmMasterRolesMenu.txtCmbRId.value;
                    var strMajor=document.frmMasterRolesMenu.txtCmbMajId.value;
                    var strMinor=document.frmMasterRolesMenu.txtCmbMinorId.value;
                    url="../../../ServletRolesMenu1.con?command=Load3&RId="+strRId+"&Major="+strMajor+"&Minor="+strMinor;
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
                
}

function Load4(event)
{

                    var strRId=document.frmMasterRolesMenu.txtCmbRId.value;
                    var strMajor=document.frmMasterRolesMenu.txtCmbMajId.value;
                    var strMinor=document.frmMasterRolesMenu.txtCmbMinorId.value;
                    var strSub=document.frmMasterRolesMenu.txtCmbSubId.value;
                    url="../../../ServletRolesMenu1.con?command=Load4&RId="+strRId+"&Major="+strMajor+"&Minor="+strMinor+"&Sub="+strSub;
                    req.open("GET",url,true);        
                    req.onreadystatechange=processResponse;
                    req.send(null);
                
}
 function loadRow(baseResponse)
 {
                
                
                var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                //alert("flag"+flag);        
                if(flag=="NoRecord")
                {
                var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                alert("Record Does't Exists For the Selected Sub-System");
                document.frmMasterRolesMenu.txtCmbMinorId.focus();
                
                }
                 else if(flag=="success")
                  {
                     var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                          var Roleid=baseResponse.getElementsByTagName("Idcode");
                          
                         for(j=0;j<Roleid.length;j++)
                          {
                           var items=new Array();
                            var Roledesc=baseResponse.getElementsByTagName("Iddesc"); 
                          var Majorid=baseResponse.getElementsByTagName("Majorcode");
                          var Majordesc=baseResponse.getElementsByTagName("Majordesc"); 
                          var Minorid=baseResponse.getElementsByTagName("Minorcode");
                          var Minordesc=baseResponse.getElementsByTagName("Minordesc"); 
                          var Subid=baseResponse.getElementsByTagName("Subcode");
                          var Subdesc=baseResponse.getElementsByTagName("Subdesc"); 
                           var Menuid=baseResponse.getElementsByTagName("Menucode");
                          var Menudesc=baseResponse.getElementsByTagName("Menudesc"); 
                            
                                                      // append a row
                              var tbody=document.getElementById("tblList");
                              var table=document.getElementById("Existing");

                            var comboRoleid=Roleid.item(j).firstChild.nodeValue;
                            var comboRoledesc=Roledesc.item(j).firstChild.nodeValue;
                            var comboMajorid=Majorid.item(j).firstChild.nodeValue;
                            var comboMajordesc=Majordesc.item(j).firstChild.nodeValue;
                            var comboMinorid=Minorid.item(j).firstChild.nodeValue;
                            var comboMinordesc=Minordesc.item(j).firstChild.nodeValue;
                            var comboSubid=Subid.item(j).firstChild.nodeValue;
                            var comboSubdesc=Subdesc.item(j).firstChild.nodeValue;
                             var comboMenuid=Menuid.item(j).firstChild.nodeValue;
                            var comboMenudesc=Menudesc.item(j).firstChild.nodeValue;
                         
                           var items=new Array();
                      items[0]=document.frmMasterRolesMenu.txtCmbRId.options[document.frmMasterRolesMenu.txtCmbRId.selectedIndex].text;
                      items[1]=document.frmMasterRolesMenu.txtCmbMajId.options[document.frmMasterRolesMenu.txtCmbMajId.selectedIndex].text;
                      items[2]=document.frmMasterRolesMenu.txtCmbMinorId.options[document.frmMasterRolesMenu.txtCmbMinorId.selectedIndex].text;
                      items[3]=document.frmMasterRolesMenu.txtCmbSubId.options[document.frmMasterRolesMenu.txtCmbSubId.selectedIndex].text;
                      for(j=0;j<Roleid.length;j++)
                          {
                          var comboRoleid=Roleid.item(j).firstChild.nodeValue;
                          var Menuid=baseResponse.getElementsByTagName("Menucode");
                          var Menudesc=baseResponse.getElementsByTagName("Menudesc");
                                   // append a row
                              var tbody=document.getElementById("tblList");
                              var table=document.getElementById("Existing");
                              
                               var comboMenuid=Menuid.item(j).firstChild.nodeValue;
                            var comboMenudesc=Menudesc.item(j).firstChild.nodeValue;
                          
                         var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                          var cell4=document.createElement("TD");
                          var cell5=document.createElement("TD");
                          var cell6=document.createElement("TD");
                          var cell7=document.createElement("TD");
                          var cell8=document.createElement("TD");
                          var cell9=document.createElement("TD");
                          var cell10=document.createElement("TD");
                          
                          
                          mycurrent_row.id=comboMenuid;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+comboRoleid;
                          //anc.href="javascript:loadValuesFromTable('"+comboMenuid+"')";
                          anc.href="javascript:getValuesFromGrid('"+comboMenuid+"')";
                          var edit=document.createTextNode("Revoke");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Rid=document.createTextNode(comboRoleid);
                         /* var Majorid=document.createTextNode(comboMajorid);
                          var Minorid=document.createTextNode(comboMinorid);
                          var Subid=document.createTextNode(comboSubid);
                         */ 
                          var Menuid=document.createTextNode(comboMenuid);
                          
                          var Rdesc=document.createTextNode(items[0]);
                          var Majordesc=document.createTextNode(items[1]);
                          var Minordesc=document.createTextNode(items[2]);
                          var Subdesc=document.createTextNode(items[3]);
                          var Menudesc=document.createTextNode(comboMenudesc);
                          
                          //cell1.appendChild(Rid);
                          cell2.appendChild(Rdesc);
                          
                          //cell3.appendChild(Majorid);
                          cell4.appendChild(Majordesc);
                           
                           //cell5.appendChild(Minorid);
                          cell6.appendChild(Minordesc);
                            
                            //cell7.appendChild(Subid);
                          cell8.appendChild(Subdesc);
                          
                            cell9.appendChild(Menuid);
                          cell10.appendChild(Menudesc);
                            
                          
                            mycurrent_row.appendChild(cell);
                            //mycurrent_row.appendChild(cell1);
                            mycurrent_row.appendChild(cell2);
                           // mycurrent_row.appendChild(cell3);
                            mycurrent_row.appendChild(cell4);
                            //mycurrent_row.appendChild(cell5);
                            mycurrent_row.appendChild(cell6);
                            //mycurrent_row.appendChild(cell7);
                            mycurrent_row.appendChild(cell8);
                            mycurrent_row.appendChild(cell9);
                            mycurrent_row.appendChild(cell10);
                          
                          tbody.appendChild(mycurrent_row);
                          table.appendChild(tbody);
                          }
                       }
                   }   
                     
                     else
                     {
                     alert("Record does not exist. Insert a new Record");
                      var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                     }
 
 }



//this is for the adding of menus for the particular role

function getValuesFromGrid(rid)
{
     var MenuId=rid;
    // alert("Menu id" + MenuId);
      var r=document.getElementById(rid); 
          var rcells=r.cells;
     var RoleId=rcells.item(1).firstChild.value;
     var MajorId=rcells.item(2).firstChild.value;
     var MinorId=rcells.item(3).firstChild.value;
     var SubId=rcells.item(4).firstChild.value;
     //alert(RoleId + MajorId + MinorId + SubId);
     url="../../../ServletRolesMenu1.con?command=Delete&RId=" + RoleId +"&Major=" + MajorId+ "&Minor=" + MinorId+"&SubSys="+SubId+"&Menu=" +MenuId;        
        req.open("GET",url,true);        
        req.onreadystatechange=processResponse;
        req.send(null);
     

}

 function loadRow1(baseResponse)
 {
                
                
                var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                //alert("flag"+flag);        
                if(flag=="NoRecord")
                {
                var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                alert("Record Does't Exists For the Selected Sub-System");
                document.frmMasterRolesMenu.txtCmbMinorId.focus();
                
                }
                 else if(flag=="success")
                  {
                     var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                          var Roleid=baseResponse.getElementsByTagName("Idcode");
                          
                         for(j=0;j<Roleid.length;j++)
                          {
                           var items=new Array();
                           var Roleid=baseResponse.getElementsByTagName("Idcode");
                            var Roledesc=baseResponse.getElementsByTagName("Iddesc"); 
                          var Majorid=baseResponse.getElementsByTagName("Majorcode");
                          var Majordesc=baseResponse.getElementsByTagName("Majordesc"); 
                          var Minorid=baseResponse.getElementsByTagName("Minorcode");
                          var Minordesc=baseResponse.getElementsByTagName("Minordesc"); 
                          var Subid=baseResponse.getElementsByTagName("Subcode");
                          var Subdesc=baseResponse.getElementsByTagName("Subdesc"); 
                           var Menuid=baseResponse.getElementsByTagName("Menucode");
                          var Menudesc=baseResponse.getElementsByTagName("Menudesc"); 
                            
                                                      // append a row
                              var tbody=document.getElementById("tblList");
                              var table=document.getElementById("Existing");

                            var comboRoleid=Roleid.item(j).firstChild.nodeValue;
                            var comboRoledesc=Roledesc.item(j).firstChild.nodeValue;
                            var comboMajorid=Majorid.item(j).firstChild.nodeValue;
                            var comboMajordesc=Majordesc.item(j).firstChild.nodeValue;
                            var comboMinorid=Minorid.item(j).firstChild.nodeValue;
                            var comboMinordesc=Minordesc.item(j).firstChild.nodeValue;
                            var comboSubid=Subid.item(j).firstChild.nodeValue;
                            var comboSubdesc=Subdesc.item(j).firstChild.nodeValue;
                             var comboMenuid=Menuid.item(j).firstChild.nodeValue;
                            var comboMenudesc=Menudesc.item(j).firstChild.nodeValue;
                         
                         var mycurrent_row=document.createElement("TR");
                        
                          mycurrent_row.id=comboMenuid;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+comboRoleid;
                          anc.href="javascript:getValuesFromGrid('"+comboMenuid+"')";
                          var edit=document.createTextNode("Revoke");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          
                           var rolecell=document.createElement("TD");
                     var sc=document.createElement("INPUT");
                     var sn=document.createTextNode(comboRoledesc);
                     sc.type="HIDDEN";
                     sc.name="sScode";
                     sc.text=comboRoleid;
                     sc.value=comboRoleid;
                     rolecell.appendChild(sc);
                     rolecell.appendChild(sn);
                     mycurrent_row.appendChild(rolecell);
                     
                      var majorcell=document.createElement("TD");
                     var sc=document.createElement("INPUT");
                     var sn=document.createTextNode(comboMajordesc);
                     sc.type="HIDDEN";
                     sc.name="sScode";
                     sc.text=comboMajorid;
                     sc.value=comboMajorid;
                     majorcell.appendChild(sc);
                     majorcell.appendChild(sn);
                     mycurrent_row.appendChild(majorcell);
                     
                     
                      var minorcell=document.createElement("TD");
                     var sc=document.createElement("INPUT");
                     var sn=document.createTextNode(comboMinordesc);
                     sc.type="HIDDEN";
                     sc.name="sScode";
                     sc.text=comboMinorid;
                     sc.value=comboMinorid;
                     minorcell.appendChild(sc);
                     minorcell.appendChild(sn);
                     mycurrent_row.appendChild(minorcell);
                     
                     
                      var subcell=document.createElement("TD");
                     var sc=document.createElement("INPUT");
                     var sn=document.createTextNode(comboSubdesc);
                     sc.type="HIDDEN";
                     sc.name="sScode";
                     sc.text=comboSubid;
                     sc.value=comboSubid;
                     subcell.appendChild(sc);
                     subcell.appendChild(sn);
                     mycurrent_row.appendChild(subcell);
                     
                     
                         var cell1 =document.createElement("TD");    
                         var Menuid=document.createTextNode(comboMenuid);                         
                         cell1.appendChild(Menuid);       
                         mycurrent_row.appendChild(cell1);  
                         
                         var cell2 =document.createElement("TD");    
                         var MenuDesc=document.createTextNode(comboMenudesc);                         
                         cell2.appendChild(MenuDesc);       
                         mycurrent_row.appendChild(cell2);  
                     
                          tbody.appendChild(mycurrent_row);
                          table.appendChild(tbody);
                          }
                       }
                      
                     
                     else
                     {
                     alert("Record does not exist. Insert a new Record");
                      var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                     }
 
} 


 
 //This is to check the Redundancy of the Existing Record
  function checkForRedundancy()
{
                    strRId=document.frmMasterRolesMenu.txtCmbRId.value;
                    strMajor=document.frmMasterRolesMenu.txtCmbMajId.value;
                    strMinor=document.frmMasterRolesMenu.txtCmbMinorId.value;
                    strSub=document.frmMasterRolesMenu.txtCmbSubId.value;
                    strMenu=document.frmMasterRolesMenu.txtCmbMenu.value;
   
   if((strRId=="")&&(strMajor=="")&&(strMinor=="")&&(strSub=="")&&(strMenu==""))
          {           
          
              alert("Select Role Id---It Shouldnt be empty");
                return true;
            }
            else 
            {
                   
                       url="../../../ServletRolesMenu1.con?command=check&RId="+strRId+"&Major=" + strMajor+"&Minor=" + strMinor+"&SubSys="+strSub +"&Menu="+strMenu;
                    req.open("GET",url,true);
                    req.onreadystatechange=processResponse;
                    req.send(null);
            }
}

function checkRow(baseResponse)
{ 
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="success")
                  {
                      alert("Record exists so Insertion is not possible");
                      
                  }
                  else
                  {
                  
                  callServer('Add','null');
                  }
 
}


 
 