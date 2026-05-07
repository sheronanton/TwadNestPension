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
 
 
 function combomajor(event)
{

var sele=document.MenuForm.CmbMajorId.value;
var url="../../../../../MenuServlet.view?Type=major&First=" +sele;
var req=getTransport();
req.open("GET",url,true);
req.onreadystatechange=function()
{
callCombo2(req);
}
req.send(null);

}
function callCombo2(req)
{

if(req.readyState==4)
{
  if(req.status==200)
   {
   var i;
   var j;
   var first=document.getElementById("CmbMinorId");
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
  } 
  
 }  
}

function comboMinor(event)
{
var sele=document.MenuForm.CmbMajorId.value;
var sele1=document.MenuForm.CmbMinorId.value;
var url="../../../../../MenuServlet.view?Type=minor&First=" +sele+"&Second="+sele1;
var req=getTransport();
req.open("GET",url,true);
req.onreadystatechange=function()
{
   callCombo1(req);
 }  
req.send(null);

}
function callCombo1(req)
{
if(req.readyState==4)
{
  if(req.status==200)
   {
   var i;
   var j;
   var first=document.getElementById("CmbSubId");
   first.innerHTML="";
   var sel=req.responseXML.getElementsByTagName("select")[0];
   var options=sel.getElementsByTagName("option");
   var htop=document.createElement("OPTION");
    htop.text="--Select Sub-System--";
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
   }
 }  
}
// loading of existing menu category combo

function comboMenuCategory(event)
{
var sele=document.MenuForm.CmbMajorId.value;
var sele1=document.MenuForm.CmbMinorId.value;
var sele2=document.MenuForm.CmbSubId.value;
var url="../../../../../MenuServlet.view?Type=menucat&First=" +sele+"&Second="+sele1+"&Third="+sele2;
var req=getTransport();
req.open("GET",url,true);
req.onreadystatechange=function()
{
   callCombo3(req);
 }  
req.send(null);

}
function callCombo3(req)
{
if(req.readyState==4)
{
  if(req.status==200)
   {
   var i;
   var j;
   var first=document.getElementById("CmbMenuCategory");
   first.innerHTML="";
   var sel=req.responseXML.getElementsByTagName("select")[0];
   var options=sel.getElementsByTagName("option");
   var htop=document.createElement("OPTION");
    htop.text="-- Select Menu Category --";
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
   }
 }  
}








//to load values from the database to the grid
 function loadRow(baseResponse)
 {
                var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                if(flag=="NoRecord")
                {
                var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
            //    alert("Record Does't Exists For the Selected Sub-System");
                document.MenuForm.CmbMinorId.focus();
                document.MenuForm.txtMenuId.value="";        
                document.MenuForm.txtMenuDesc.value="";
                document.MenuForm.txtMenuSDesc.value="";
                document.MenuForm.txtMenuFilePath.value="";
                 document.MenuForm.txtMenuId.disabled=false;
                 
                /* document.MenuForm.txtMenuCategory.value="";
                  document.MenuForm.txtMenuCategorySeq.value="";
                  document.MenuForm.txtMenuOrderSeq.value="";*/
                  
                  document.MenuForm.txtMenuCategorySeq.value="";
                  document.MenuForm.CmbMenuCategory.value="";
                
                }
                 else if(flag=="success")
                  {
                 
                     var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                          var Menuid=baseResponse.getElementsByTagName("Menucode");
                          var Menudesc=baseResponse.getElementsByTagName("Menudesc");
                          var Menusdesc=baseResponse.getElementsByTagName("MenuSDesc");
                          var Menupath=baseResponse.getElementsByTagName("Menupath");
                          
                          var MenuCategory=baseResponse.getElementsByTagName("MenuCategory");
                          var MenuCategorySeq=baseResponse.getElementsByTagName("MenuCatSeq");
                        //  var MenuOrderSeq=baseResponse.getElementsByTagName("MenuOrderSeq");
                          
                       /*   var menucatseq=baseResponse.getElementsByTagName("MenuCatSeq")[0].firstChild.nodeValue;
                          document.MenuForm.txtMenuCategorySeq.value=menucatseq;
                          document.MenuForm.txtMenuCategorySeq.disabled=true;*/
                       
                          
                           var items=new Array();
                      items[0]=document.MenuForm.CmbMajorId.options[document.MenuForm.CmbMajorId.selectedIndex].text;
                      items[1]=document.MenuForm.CmbMinorId.options[document.MenuForm.CmbMinorId.selectedIndex].text;
                      items[2]=document.MenuForm.CmbSubId.options[document.MenuForm.CmbSubId.selectedIndex].text;
                      var j=0;
                      var l=Menuid.length;
                      for(j=0;j<l;j++)
                          {
                          var Menuid=baseResponse.getElementsByTagName("Menucode");
                          var Menudesc=baseResponse.getElementsByTagName("Menudesc");
                          var Menusdesc=baseResponse.getElementsByTagName("MenuSDesc");
                          var Menupath=baseResponse.getElementsByTagName("Menupath");
                          
                          var MenuCategory=baseResponse.getElementsByTagName("MenuCategory");
                          var MenuCategorySeq=baseResponse.getElementsByTagName("MenuCatSeq");
                       //   var MenuOrderSeq=baseResponse.getElementsByTagName("MenuOrderSeq");
                          
                          
                            var comboMenuid=Menuid.item(j).firstChild.nodeValue;
                            var comboMenudesc=Menudesc.item(j).firstChild.nodeValue;
                            var comboMenusdesc=Menusdesc.item(j).firstChild.nodeValue;
                            var comboMenupath=Menupath.item(j).firstChild.nodeValue;
                            
                            var tMenuCategory=MenuCategory.item(j).firstChild.nodeValue;
                             var tMenuCategorySeq=MenuCategorySeq.item(j).firstChild.nodeValue;
                         // var tMenuOrderSeq=MenuOrderSeq.item(j).firstChild.nodeValue;

                         var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                         var cell4=document.createElement("TD");
                          
                          var cell5=document.createElement("TD");
                          var cell6=document.createElement("TD");
                         // var cell7=document.createElement("TD");
                          
                          mycurrent_row.id=comboMenuid;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+comboMenuid;
                          anc.href="javascript:loadValuesFromTable('"+comboMenuid+"')";
                          var edit=document.createTextNode("Edit");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Menuid=document.createTextNode(comboMenuid);
                          var Menudesc=document.createTextNode(comboMenudesc);
                          var Menusdesc=document.createTextNode(comboMenusdesc);
                          var Menupath=document.createTextNode(comboMenupath);
                          
                          
                          var cMenuCategory=document.createTextNode(tMenuCategory);
                          var cMenuCategorySeq=document.createTextNode(tMenuCategorySeq);
                         // var cMenuOrderSeq=document.createTextNode(tMenuOrderSeq);
                          
                          
                          cell1.appendChild(Menuid);
                          cell2.appendChild(Menudesc);
                          cell3.appendChild(Menusdesc);
                          cell4.appendChild(Menupath);
                            
                            cell5.appendChild(cMenuCategory);
                          cell6.appendChild(cMenuCategorySeq);
                         // cell7.appendChild(cMenuOrderSeq);
                          
                            mycurrent_row.appendChild(cell);
                            mycurrent_row.appendChild(cell1);
                            mycurrent_row.appendChild(cell2);
                            mycurrent_row.appendChild(cell3);
                            mycurrent_row.appendChild(cell4);
                            
                            mycurrent_row.appendChild(cell6);
                            mycurrent_row.appendChild(cell5);
                          //  mycurrent_row.appendChild(cell7);
                           
                          tbody.appendChild(mycurrent_row);
                          
                          }
                       }
                      
                     
                     else
                     {
                     alert("Record does not exist. Insert a new Record");
                     document.MenuForm.CmdAdd.disabled=false;
                      var tbody=document.getElementById("tblList");
                        var t=0;
                        
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
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
              else if(command=="check")
              {
              checkRow(baseResponse);
              }
              else if(command=="Load")
              {
              loadRow(baseResponse);
              }
              else if(command=="Get")
              {
              getRow(baseResponse);
              }
              else if(command=="Update")
              {
              updateRow(baseResponse);
              }


          }
        }
  }

function loadValuesFromTable(rid) 
{

              var d=document.getElementById("add");
                d.style.display="none";
                var d=document.getElementById("update");
                d.style.display="block";
                
          var r=document.getElementById(rid); 
          var txtMenuId=document.getElementById("txtMenuId");
          var txtMenuDesc=document.getElementById("txtMenuDesc");
          var txtMenuSDesc=document.getElementById("txtMenuSDesc");
          var txtMenuFilePath=document.getElementById("txtMenuFilePath");
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          document.MenuForm.txtMenuId.value=rcells.item(1).firstChild.nodeValue;
          document.MenuForm.htxtMenuId.value=rcells.item(1).firstChild.nodeValue;
          document.MenuForm.txtMenuDesc.value=rcells.item(2).firstChild.nodeValue;
          document.MenuForm.txtMenuSDesc.value=rcells.item(3).firstChild.nodeValue;
          document.MenuForm.txtMenuFilePath.value=rcells.item(4).firstChild.nodeValue;

          document.MenuForm.txtMenuCategorySeq.value=rcells.item(5).firstChild.nodeValue;
          document.MenuForm.CmbMenuCategory.value=rcells.item(6).firstChild.nodeValue;
        //  document.MenuForm.txtMenuOrderSeq.value=rcells.item(7).firstChild.nodeValue;
          
          document.MenuForm.txtMenuId.disabled=true;
          document.MenuForm.CmdDelete.disabled=false;
          document.MenuForm.CmdUpdate.disabled=false;
          document.MenuForm.CmdAdd.disabled=true;
      
}

function Exit()
 {
    window.open('','_parent','');
    window.close();
 }
 
 function clearAll()
 {        
        document.MenuForm.CmbMajorId.selectedIndex=0;
        document.MenuForm.CmbMinorId.innerHTML="";
        document.MenuForm.CmbSubId.innerHTML="";
       // document.MenuForm.CmbMenuCategory.innerHTML="";
         var minor=document.createElement("OPTION");
        minor.text="--Select Minor Id--";
        try
        {
        document.MenuForm.CmbMinorId.add(minor);
         }
         catch(e)
         {
         document.MenuForm.CmbMinorId.add(minor,null);
         }
         var sub=document.createElement("OPTION");
        sub.text="--Select Sub-System ID--";
        try
        {
        document.MenuForm.CmbSubId.add(sub);
        }
        catch(e)
        {
        document.MenuForm.CmbSubId.add(sub,null);
        }
       /* var menucat=document.createElement("OPTION");
        menucat.text="--Select Menu Category--";
        try
        {
        document.MenuForm.CmbMenuCategory.add(menucat);
        }
        catch(e)
        {
        document.MenuForm.CmbMenuCategory.add(menucat,null);
        }
        */
        document.MenuForm.txtMenuId.value="";        
        document.MenuForm.txtMenuDesc.value="";
        document.MenuForm.txtMenuSDesc.value="";
        document.MenuForm.txtMenuFilePath.value="";
        document.MenuForm.CmdUpdate.disabled=true;
         document.MenuForm.CmdDelete.disabled=true;
         document.MenuForm.CmdAdd.disabled=false;
         document.MenuForm.txtMenuId.disabled=false;
         
         document.MenuForm.CmbMenuCategory.value="";
          document.MenuForm.txtMenuCategorySeq.value="";
         // document.MenuForm.txtMenuOrderSeq.value="";
              //      document.MenuForm.SelectMenuCat[0].checked=true;
         
         var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }
        
        var d=document.getElementById("add");
                d.style.display="block";
                var d=document.getElementById("update");
                d.style.display="none";
        
    /*    var d=document.getElementById("New");
                d.style.display="block";
                var d=document.getElementById("Existg");
                d.style.display="none";*/
 }

function clearOnly()
{

   document.MenuForm.CmbMajorId.selectedIndex=0;
        document.MenuForm.CmbMinorId.innerHTML="";
        document.MenuForm.CmbSubId.innerHTML="";
        document.MenuForm.CmbMenuCategory.innerHTML="";
         var minor=document.createElement("OPTION");
        minor.text="--Select Minor Id--";
        try
        {
        document.MenuForm.CmbMinorId.add(minor);
         }
         catch(e)
         {
         document.MenuForm.CmbMinorId.add(minor,null);
         }
         var sub=document.createElement("OPTION");
        sub.text="--Select Sub-System ID--";
        try
        {
        document.MenuForm.CmbSubId.add(sub);
        }
        catch(e)
        {
        document.MenuForm.CmbSubId.add(sub,null);
        }
        var menucat=document.createElement("OPTION");
        menucat.text="--Select Menu Category--";
        try
        {
        document.MenuForm.CmbMenuCategory.add(menucat);
        }
        catch(e)
        {
        document.MenuForm.CmbMenuCategory.add(menucat,null);
        }

        document.MenuForm.txtMenuId.value="";        
        document.MenuForm.txtMenuDesc.value="";
        document.MenuForm.txtMenuSDesc.value="";
        document.MenuForm.txtMenuFilePath.value="";
        document.MenuForm.CmdUpdate.disabled=true;
         document.MenuForm.CmdDelete.disabled=true;
         document.MenuForm.CmdAdd.disabled=false;
         document.MenuForm.txtMenuId.disabled=false;
         
         document.MenuForm.CmbMenuCategory.value="";
          document.MenuForm.txtMenuCategorySeq.value="";
          document.MenuForm.txtMenuOrderSeq.value="";
          
          document.MenuForm.SelectMenuCat[0].checked=true;
          
          var d=document.getElementById("New");
                d.style.display="block";
                var d=document.getElementById("Existg");
                d.style.display="none";
         
      
          }      

function callServer(command,param)
 {     
                    
                    
                    if(command=="Load")
                    {
                      var strMajor=document.MenuForm.CmbMajorId.value;
                    var strMinor=document.MenuForm.CmbMinorId.value;
                    var strSub=document.MenuForm.CmbSubId.value;
                  //  var cmbMenuCategory=document.MenuForm.CmbMenuCategory.value;
                    var MenuDesc=document.MenuForm.txtMenuDesc.value;
                       url="../../../../../MenuServlet1.view?command=Load&Major="+strMajor+"&Minor="+strMinor+"&Sub="+strSub;//+"&MenuCat="+cmbMenuCategory;
                    var req=getTransport();
                    req.open("GET",url,true);  
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
                    }
                    
                    else if(command=="Get")
                    {
                       url="../../../../../MenuServlet1.view?command=Get&Major="+strMajor+"&Minor="+strMinor+"&Sub="+strSub+"&Menuid=" +strMenuId;
                    var req=getTransport();
                    req.open("GET",url,true);  
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
                    }
                    
          else if(command=="Add")
          {
             //  if(document.MenuForm.SelectMenuCat[0].checked)
                //  {
                     var strMajor=document.MenuForm.CmbMajorId.value;
                    var strMinor=document.MenuForm.CmbMinorId.value;
                    var strSub=document.MenuForm.CmbSubId.value;
                    
                    var strMenuId=document.MenuForm.txtMenuId.value;
                    var hstrMenuId=document.MenuForm.htxtMenuId.value;
                    hstrMenuId=strMenuId;
                    
                    var strMenuDesc=document.MenuForm.txtMenuDesc.value;
                    var strMenuSDesc=document.MenuForm.txtMenuSDesc.value;
                    var strMenuFilePath=document.MenuForm.txtMenuFilePath.value;
                    
                     var MenuCategory=document.MenuForm.CmbMenuCategory.value;
                     var MenuCategorySeq=document.MenuForm.txtMenuCategorySeq.value;
                   //  var MenuOrderSeq=document.MenuForm.txtMenuOrderSeq.value;      
                 
                     var flag=nullCheck();
                      if(flag==true)
                      {
                       url="../../../../../MenuServlet1.view?command=Add&Major=" + strMajor+ "&Minor=" + strMinor+"&SubSys="+strSub+"&Menuid=" +strMenuId+"&MenuDesc="+strMenuDesc+"&MenuSDesc="+strMenuSDesc+"&MenuFilePath="+strMenuFilePath+"&MenuCategory="+MenuCategory+"&MenuCategorySeq="+MenuCategorySeq;//+"&MenuOrderSeq="+MenuOrderSeq;
                    var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                      processResponse(req);
                    }
                    req.send(null);
                    }
            /*      }
                  else
                  {
                    var strMajor=document.MenuForm.CmbMajorId.value;
                    var strMinor=document.MenuForm.CmbMinorId.value;
                    var strSub=document.MenuForm.CmbSubId.value;
                    
                    var strMenuId=document.MenuForm.txtMenuId.value;
                    var hstrMenuId=document.MenuForm.htxtMenuId.value;
                    hstrMenuId=strMenuId;
                    
                    var strMenuDesc=document.MenuForm.txtMenuDesc.value;
                    var strMenuSDesc=document.MenuForm.txtMenuSDesc.value;
                    var strMenuFilePath=document.MenuForm.txtMenuFilePath.value;
                    
                     var MenuCategorySeq=document.MenuForm.txtMenuCategorySeq.value;
                     var MenuOrderSeq=document.MenuForm.txtMenuOrderSeq.value;      
                     var cmbMenuCategory=document.MenuForm.CmbMenuCategory.value;
                     
                     var flag=nullCheck();
                      if(flag==true)
                      {
                       url="../../../../../MenuServlet1.view?command=Add&Major=" + strMajor+ "&Minor=" + strMinor+"&SubSys="+strSub+"&Menuid=" +strMenuId+"&MenuDesc="+strMenuDesc+"&MenuSDesc="+strMenuSDesc+"&MenuFilePath="+strMenuFilePath+"&MenuCategory="+cmbMenuCategory+"&MenuCategorySeq="+MenuCategorySeq+"&MenuOrderSeq="+MenuOrderSeq;
                    var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                      processResponse(req);
                    }
                    req.send(null);
                    }
                     
                  }*/
            }
      else if(command=="Delete")
      {
      
                    var strMajor=document.MenuForm.CmbMajorId.value;
                    var strMinor=document.MenuForm.CmbMinorId.value;
                    var strSub=document.MenuForm.CmbSubId.value;
                    
                    var strMenuId=document.MenuForm.txtMenuId.value;
                    var hstrMenuId=document.MenuForm.htxtMenuId.value;
                    hstrMenuId=strMenuId;
                    
      if(confirm("Do You Really want to Delete the Selected Record"))
             {
        url="../../../../../MenuServlet1.view?command=Delete&Major=" + strMajor+ "&Minor=" + strMinor+"&SubSys="+strSub+"&Menuid=" +strMenuId;
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
      else if(command=="Update")
          {          
                  //  if(document.MenuForm.SelectMenuCat[0].checked)
                 // {
                     var strMajor=document.MenuForm.CmbMajorId.value;
                    var strMinor=document.MenuForm.CmbMinorId.value;
                    var strSub=document.MenuForm.CmbSubId.value;
                    
                    var strMenuId=document.MenuForm.txtMenuId.value;
                    var hstrMenuId=document.MenuForm.htxtMenuId.value;
                    hstrMenuId=strMenuId;
                    
                    var strMenuDesc=document.MenuForm.txtMenuDesc.value;
                    var strMenuSDesc=document.MenuForm.txtMenuSDesc.value;
                    var strMenuFilePath=document.MenuForm.txtMenuFilePath.value;
                    
                     var MenuCategory=document.MenuForm.CmbMenuCategory.value;
                     var MenuCategorySeq=document.MenuForm.txtMenuCategorySeq.value;
                    // var MenuOrderSeq=document.MenuForm.txtMenuOrderSeq.value;      
                     
                    var flag=nullCheck();
                          if(flag==true)
                          {
                       url="../../../../../MenuServlet1.view?command=Update&Major=" + strMajor+ "&Minor=" + strMinor+"&SubSys="+strSub+"&Menuid=" +hstrMenuId+"&MenuDesc="+strMenuDesc+"&MenuSDesc="+strMenuSDesc+"&MenuFilePath="+strMenuFilePath+"&MenuCategory="+MenuCategory+"&MenuCategorySeq="+MenuCategorySeq;//+"&MenuOrderSeq="+MenuOrderSeq;
                    var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
                    }
                /*  }
                  
                  else
                  {
                    var strMajor=document.MenuForm.CmbMajorId.value;
                    var strMinor=document.MenuForm.CmbMinorId.value;
                    var strSub=document.MenuForm.CmbSubId.value;
                    
                    var strMenuId=document.MenuForm.txtMenuId.value;
                    var hstrMenuId=document.MenuForm.htxtMenuId.value;
                    hstrMenuId=strMenuId;
                    
                    var strMenuDesc=document.MenuForm.txtMenuDesc.value;
                    var strMenuSDesc=document.MenuForm.txtMenuSDesc.value;
                    var strMenuFilePath=document.MenuForm.txtMenuFilePath.value;
                    
                     var MenuCategorySeq=document.MenuForm.txtMenuCategorySeq.value;
                     var MenuOrderSeq=document.MenuForm.txtMenuOrderSeq.value;      
                     var cmbMenuCategory=document.MenuForm.CmbMenuCategory.value;
                     
                     var flag=nullCheck();
                          if(flag==true)
                          {
                       url="../../../../../MenuServlet1.view?command=Update&Major=" + strMajor+ "&Minor=" + strMinor+"&SubSys="+strSub+"&Menuid=" +hstrMenuId+"&MenuDesc="+strMenuDesc+"&MenuSDesc="+strMenuSDesc+"&MenuFilePath="+strMenuFilePath+"&MenuCategory="+cmbMenuCategory+"&MenuCategorySeq="+MenuCategorySeq+"&MenuOrderSeq="+MenuOrderSeq;
                    var req=getTransport();
                    req.open("GET",url,true);        
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
                    }
                     
                  }*/
                  
                  
          } 
}

function getRow(baseResponse)
{
   var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
             alert( flag);    
                  if(flag=="Success")
                  {
                     alert("Given Menu Id exists in this sub system - Give some other Menu Id");
                     document.MenuForm.txtMenuId.value=""; 
                     document.MenuForm.txtMenuId.focus(); 
                  }
                 
}

function deleteRow(baseResponse)
  {
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  
                  if(flag=="success")
                  {
                     var Menuid=document.MenuForm.htxtMenuId.value
                      var tbody=document.getElementById("Existing"); 
                      var r=document.getElementById(Menuid);    
                      var ri=r.rowIndex;       
                      tbody.deleteRow(ri);
                        clearAll();
                        document.MenuForm.txtMenuId.disabled=false;
                      alert("Selected Menu Details are Deleted");                      
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
                       
                      alert("Record inserted into the database successfully");
                            var Menuid=document.MenuForm.txtMenuId.value;                     
                            var MenuDesc=document.MenuForm.txtMenuDesc.value;
                            var MenuSDesc=document.MenuForm.txtMenuSDesc.value;
                            var MenuFilepath=document.MenuForm.txtMenuFilePath.value;
                            
                            var MenuCategory=document.MenuForm.CmbMenuCategory.value;
                            var MenuCategorySeq=document.MenuForm.txtMenuCategorySeq.value;
                           // var MenuOrderSeq=document.MenuForm.txtMenuOrderSeq.value;
                     
                          var tbody=document.getElementById("tblList");
                              var table=document.getElementById("Existing");
                         var mycurrent_row=document.createElement("TR");
                          var cell1=document.createElement("TD");
                          var cell2=document.createElement("TD");
                          var cell3=document.createElement("TD");
                          var cell4=document.createElement("TD");
                          
                           var cell5=document.createElement("TD");
                          var cell6=document.createElement("TD");
                          //var cell7=document.createElement("TD");
                          
                          mycurrent_row.id=Menuid;                          
                          var cell=document.createElement("TD");
                          var anc=document.createElement("A");
                          anc.id="a"+Menuid;
                          anc.href="javascript:loadValuesFromTable('"+Menuid+"')";
                          var edit=document.createTextNode("Edit");
                          anc.appendChild(edit);
                          cell.appendChild(anc);
                          mycurrent_row.appendChild(cell);
                          
                          var Menuid=document.createTextNode(Menuid);
                          var Menudesc=document.createTextNode(MenuDesc);
                          var Menusdesc=document.createTextNode(MenuSDesc);
                          var Menupath=document.createTextNode(MenuFilepath);
                          
                          var tMenuCategory=document.createTextNode(MenuCategory);
                          var tMenuCategorySeq=document.createTextNode(MenuCategorySeq);
                         // var tMenuOrderSeq=document.createTextNode(MenuOrderSeq);
                          
                          cell1.appendChild(Menuid);
                          cell2.appendChild(Menudesc);
                          cell3.appendChild(Menusdesc);
                          cell4.appendChild(Menupath);
                            
                      /*    cell5.appendChild(tMenuCategory);
                          cell6.appendChild(tMenuCategorySeq);*/
                          
                          cell5.appendChild(tMenuCategorySeq);
                          cell6.appendChild(tMenuCategory);
                        
                        //  cell7.appendChild(tMenuOrderSeq);
                          
                            mycurrent_row.appendChild(cell);
                            mycurrent_row.appendChild(cell1);
                            mycurrent_row.appendChild(cell2);
                            mycurrent_row.appendChild(cell3);
                            mycurrent_row.appendChild(cell4);
                            
                            mycurrent_row.appendChild(cell5);
                            mycurrent_row.appendChild(cell6);
                          //  mycurrent_row.appendChild(cell7);
                           
                          tbody.appendChild(mycurrent_row);
                          document.MenuForm.txtMenuId.value="";
                            document.MenuForm.txtMenuDesc.value="";
                            document.MenuForm.txtMenuSDesc.value="";
                            document.MenuForm.txtMenuFilePath.value="";
                            document.MenuForm.CmbMenuCategory.value="";
                              document.MenuForm.txtMenuCategorySeq.value="";
                           //   document.MenuForm.txtMenuOrderSeq.value="";
                            document.MenuForm.txtMenuId.disabled=false;
                          
                          }
                       
                  
                  else
                  {
                      alert("Failed to Insert values");                     
                  }

    }
 
function updateRow(baseResponse)
    {
     
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       if(flag=="success")
       {   
           alert("Record Updated Successfully.");
           var strMenuId=document.MenuForm.txtMenuId.value;
                    var hstrMenuId=document.MenuForm.htxtMenuId.value;
                    hstrMenuId=strMenuId;
                            var items=new Array();
                            items[0]=hstrMenuId;
                            items[1]=document.MenuForm.txtMenuDesc.value;
                            items[2]=document.MenuForm.txtMenuSDesc.value;
                            items[3]=document.MenuForm.txtMenuFilePath.value;
                            
                            items[4]=document.MenuForm.CmbMenuCategory.value;
                            items[5]=document.MenuForm.txtMenuCategorySeq.value;
                            //items[6]=document.MenuForm.txtMenuOrderSeq.value;
                            
                      var r=document.getElementById(items[0]);    
                      var rcells=r.cells;
                        rcells.item(1).firstChild.nodeValue=items[0];
                        rcells.item(2).firstChild.nodeValue=items[1];
                        rcells.item(3).firstChild.nodeValue=items[2];
                        rcells.item(4).firstChild.nodeValue=items[3];
                        
                        rcells.item(6).firstChild.nodeValue=items[4];
                        rcells.item(5).firstChild.nodeValue=items[5];
                       // rcells.item(7).firstChild.nodeValue=items[6];
                        
                            document.MenuForm.txtMenuId.value="";
                            document.MenuForm.txtMenuDesc.value="";
                            document.MenuForm.txtMenuSDesc.value="";
                            document.MenuForm.txtMenuFilePath.value="";
                            document.MenuForm.CmbMenuCategory.value="";
                            document.MenuForm.txtMenuCategorySeq.value="";
                         //     document.MenuForm.txtMenuOrderSeq.value="";
                            document.MenuForm.txtMenuId.disabled=false;
                        
     
       }
       else
       {
           alert("failed to update values");
       }                                  
    }
    
    
function nullCheck()
        {
                  
                  if((document.MenuForm.CmbMajorId.value=="") || (document.MenuForm.CmbMajorId.value<=0))
                  { 
                       alert("Please Select the Major Id");
                       document.MenuForm.CmbMajorId.focus();
                       return false;
                  }
                                   else if((document.MenuForm.CmbMinorId.value=="") || (document.MenuForm.CmbMinorId.value<=0))
                    {
                       alert("Please Select the Minor Id");
                       document.MenuForm.CmbMinorId.focus();
                       return false;
                  }
                  else if((document.MenuForm.CmbSubId.value=="") || (document.MenuForm.CmbSubId.value<=0))
                  { 
                       alert("Please Select the Sub System Id");
                       document.MenuForm.CmbSubId.focus();
                       return false;
                  }
                  else if((document.MenuForm.txtMenuId.value=="") || (document.MenuForm.txtMenuId.value<=0))
                  { 
                       alert("Please Enter the Menu System Id");
                       document.MenuForm.txtMenuId.focus();
                       return false;
                  }

                  else if((document.MenuForm.txtMenuDesc.value=="") || (document.MenuForm.txtMenuDesc.value<=0))
                  { 
                       alert("Please Enter Menu System  Description");
                       document.MenuForm.txtMenuDesc.focus();
                       return false;
                  }
                 
                  else if((document.MenuForm.txtMenuSDesc.value=="") || (document.MenuForm.txtMenuSDesc.value<=0))
                  { 
                       alert("Please Enter The Menu System short Description");
                       document.MenuForm.txtMenuSDesc.focus();
                       return false;
                  }
                  return true;
            }           
            
            
            function checkForRedundancy()
{
                    var strMajor=document.MenuForm.CmbMajorId.value;
                    var strMinor=document.MenuForm.CmbMinorId.value;
                    var strSub=document.MenuForm.CmbSubId.value;
                    var strMenuId=document.MenuForm.txtMenuId.value;
                    var strMenuDesc=document.MenuForm.txtMenuDesc.value;
                    var strMenuSDesc=document.MenuForm.txtMenuSDesc.value;
                    var strMenuFilePath=document.MenuForm.txtMenuFilePath.value;
                   
   if((strMajor=="")&&(strMinor=="")&&(strSub=="")&&(strMenuId=="")&&(strMenuDesc=="")&&(strMenuSDesc=="")&&(strMenuFilePath==""))
          {           
          
              alert("Select Major Id---It Shouldnt be empty");
                return true;
            }
            else 
            {
                   
                       url="../../../../../MenuServlet1.view?command=check&Major=" + strMajor+ "&Minor=" + strMinor+"&SubSys="+strSub+"&Menuid=" +strMenuId+"&MenuDesc="+strMenuDesc;
                    var req=getTransport();
                    req.open("GET",url,true);
                    req.onreadystatechange=function()
                    {
                       processResponse(req);
                    }   
                    req.send(null);
            }
}

function checkRow(baseResponse)
{ 
                  var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
                  if(flag=="failure")
                  {
                      alert("Given Menu Id Exists for the Selected Sub System - Give Some Other Menu Id");
                       document.MenuForm.txtMenuId.value="";
                       document.MenuForm.txtMenuId.value="";
                      
                  }
                  if(flag=="failure1")
                  {
                     alert("Given Menu description exists in this sub system - Give some other Menu Desc");
                     document.MenuForm.txtMenuDesc.value=""; 
                     document.MenuForm.txtMenuDesc.focus(); 
                  
                  }


                  else
                  {
                  
                  callServer('Add','null');
                  }
 
}


// this is the function -- which is called when the menu category radio button is clicked

function toShowNewMenu()
{
                var d=document.getElementById("New");
                d.style.display="block";
                var d=document.getElementById("Existg");
                d.style.display="none";
}

function toShowExistgMenu()
{
            if((document.MenuForm.CmbMajorId.value=="") || (document.MenuForm.CmbMajorId.value<=0))
                  { 
                       alert("Please Select the Major Id");
                       document.MenuForm.CmbMajorId.focus();
                       return false;
                  }
                                   else if((document.MenuForm.CmbMinorId.value=="") || (document.MenuForm.CmbMinorId.value<=0))
                    {
                       alert("Please Select the Minor Id");
                       document.MenuForm.CmbMinorId.focus();
                       return false;
                  }
                  else if((document.MenuForm.CmbSubId.value=="") || (document.MenuForm.CmbSubId.value<=0))
                  { 
                       alert("Please Select the Sub System Id");
                       document.MenuForm.CmbSubId.focus();
                       return false;
                  }
               else
               {
                var d=document.getElementById("Existg");
                d.style.display="block";
                var d=document.getElementById("New");
                d.style.display="none";
               } 
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