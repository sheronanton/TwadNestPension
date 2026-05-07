var __pagination=5;
    var items1;
    var items2;
    var items3;
    var totalblock=0;


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
        document.frmMasterRoles.txtRId.value="";
        document.frmMasterRoles.txtRName.value="";
        document.frmMasterRoles.txtRId.disabled=false;
        document.frmMasterRoles.cmdAdd.disabled=false;
        document.frmMasterRoles.cmdUpdate.disabled=true;
        document.frmMasterRoles.cmdDelete.disabled=true;
     /*   var tbody=document.getElementById("tblList");
        var t=0;
        
        for(t=tbody.rows.length-1;t>=0;t--)
        {
           tbody.deleteRow(0);
        }*/
        
 }

 function Exit()
 {
    window.open('','_parent','');
    window.close();
 }
 
function callServer(command,param)
 {     
        //alert("within call server");
          var strRId;
          var strRName;
         var category;     
          
          if(command=="Add")
          {           
           
                  if(document.frmMasterRoles.txtRName.value=="")
                  {
                     alert("Role Name Should Not be Empty -- Please Enter the Role Name");
                     document.frmMasterRoles.txtRName.focus();
                  }
                  else
                  {
                    strRId=document.frmMasterRoles.htxtRId.value;
                    strRName=document.frmMasterRoles.txtRName.value;
                    
                    if (document.frmMasterRoles.category[0].checked)
                    {
                    	category=document.frmMasterRoles.category[0].value;
                    }
                    else
                     {
                    	category=document.frmMasterRoles.category[1].value;
                     }
                    
                    
                    
                    var url="../../../ServletRoles.con?command=Add&txtRName="+strRName+"&category="+category;
                    req.open("GET",url,true);   
                    req.onreadystatechange=processResponse;
                    req.send(null);
                   }  
                
          }   
          
           else if(command=="Delete")
          {
                
                strRId=document.frmMasterRoles.txtRId.value;
                url="../../../ServletRoles.con?command=Delete&txtRId="+strRId;    
                req.open("GET",url,true);        
                req.onreadystatechange=processResponse;
                req.send(null);
                
          }
          
           else if(command=="Update")
          {
               if(document.frmMasterRoles.txtRName.value=="")
                  {
                     alert("Role Name Should Not be Empty -- Please Enter the Role Name");
                     document.frmMasterRoles.txtRName.focus();
                  }
                  else
                  {
                	  
                	  
                	  
                	  
                strRId=document.frmMasterRoles.txtRId.value;
                strRName=document.frmMasterRoles.txtRName.value;
                
                if (document.frmMasterRoles.category[0].checked)
                {
                	category=document.frmMasterRoles.category[0].value;
                }
                else
                 {
                	category=document.frmMasterRoles.category[1].value;
                 }
                
               
                url="../../../ServletRoles.con?command=Update&txtRId="+strRId+"&category="+category+"&txtRName=" + strRName;    
                req.open("GET",url,true);        
                req.onreadystatechange=processResponse;
                req.send(null);
                }
          }
          
           else if(command=="Load")
          {
                 items1=null;
                 items2=null;
                 items3=null;
                url="../../../ServletRoles.con?command=Load";
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
                  deleteRow(baseResponse);                             
              }
              else if(command=="Update")
              {             
                  updateRow(baseResponse);             
              }   
              else if(command=="Load")
              {             
                  loadRow(baseResponse);             
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
           var RoleId=baseResponse.getElementsByTagName("RoleId")[0].firstChild.nodeValue;
           var tbody=document.getElementById("Existing");                      
           var r=document.getElementById(RoleId);  
           var ri=r.rowIndex;               
           tbody.deleteRow(ri);
          clearAll();
          document.frmMasterRoles.cmdAdd.disabled=false;
        document.frmMasterRoles.cmdUpdate.disabled=true;
        document.frmMasterRoles.cmdDelete.disabled=true;
      }
      else
      {
          alert("Unable to Delete The Record");
         
      }      
    }
    
    // function for updating 
    
    function updateRow(baseResponse)
    {
     
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
       if(flag=="success")
       {   
           alert("Record Updated Successfully.");
                     var items=new Array();
                      items[0]=document.frmMasterRoles.txtRId.value;
                     items[1]=document.frmMasterRoles.txtRName.value;  
                     if (document.frmMasterRoles.category[0].checked)
                     {
                    	 items[2]=document.frmMasterRoles.category[0].value;
                     }
                     else
                      {
                    	 items[2]=document.frmMasterRoles.category[1].value;
                      }
                      // update the row
                      var r=document.getElementById(items[0]);      
                      var rcells=r.cells;
                      rcells.item(1).firstChild.nodeValue=items[0];
                      rcells.item(2).firstChild.nodeValue=items[1];
                      rcells.item(3).firstChild.nodeValue=items[2];
                      clearAll();

     
       }
       else
       {
           alert("failed to update values");
       }                                  
    }

// function to add a record
    function addRow(baseResponse)
    {
              var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue; 
              if(flag=="success")
              {                        
                     alert("Record Inserted Into Database successfully.");
                     rid=baseResponse.getElementsByTagName("RoleId")[0].firstChild.nodeValue; 
                      alert("Created Role Id is: " +  rid);
                      
                     var items=new Array();    
                     document.frmMasterRoles.txtRId.value=rid;
                     items[0]=rid;
                     items[1]=document.frmMasterRoles.txtRName.value;
                                       
                     if (document.frmMasterRoles.category[0].checked)
                     {
                    	 items[2]=document.frmMasterRoles.category[0].value;
                     }
                     else
                      {
                    	 items[2]=document.frmMasterRoles.category[1].value;
                      }
                     
                     
                     
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
                      alert("Failed to Insert Values");
             }
        
    }
    
    // code for loading the values from the table to the input boxes
    // functionality for edit anchor
    function loadValuesFromTable(rid)
    {      
          var r=document.getElementById(rid); 
          var rcells=r.cells;
          var tbody=document.getElementById("tblList");
          var table=document.getElementById("Existing");
          document.frmMasterRoles.txtRId.value=rcells.item(1).firstChild.nodeValue;
          document.frmMasterRoles.txtRName.value=rcells.item(2).firstChild.nodeValue;
          var cat=rcells.item(3).firstChild.nodeValue;
        
          if(cat=="Individual")
          {
        	  cat="I";  
          }else if(cat=="Common")
          {
        	  cat="C";    
          }
          
          if (document.frmMasterRoles.category[0].value==cat)
          {
        	  document.frmMasterRoles.category[0].checked=true;
         	 
          }
          else if (document.frmMasterRoles.category[1].value==cat)
           {
        	  document.frmMasterRoles.category[1].checked=true;
           }else{
        	   document.frmMasterRoles.category[0].checked=false; 
        	   document.frmMasterRoles.category[1].checked=false; 
           }  
         
          document.frmMasterRoles.cmdAdd.disabled=true;
        document.frmMasterRoles.cmdUpdate.disabled=false;
        document.frmMasterRoles.cmdDelete.disabled=false;
        document.frmMasterRoles.txtRId.disabled=true;
          document.frmMasterRoles.cmdDelete.focus();
      
    }
 /*   for paginazion   and load grid         */
 
 function loadRow(baseResponse)
 {
   var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue; 
   
              if(flag=="success")
              {         
                        var tbody=document.getElementById("tblList");
                        var t=0;
                        for(t=tbody.rows.length-1;t>=0;t--)
                        {
                           tbody.deleteRow(0);
                        }
                            var Role_Id=baseResponse.getElementsByTagName("Role_Id");
                            
                            items1=new Array();
                            items2=new Array();
                            items3=new Array();
                     for(var k=0;k<Role_Id.length;k++)
                    {
                            var Role_Id=baseResponse.getElementsByTagName("Role_Id");
                            var Role_Name=baseResponse.getElementsByTagName("Role_Name");
                           var category1=baseResponse.getElementsByTagName("category");
                            items1[k]=Role_Id.item(k).firstChild.nodeValue;
                            items2[k]=Role_Name.item(k).firstChild.nodeValue;
                            items3[k]=category1.item(k).firstChild.nodeValue;
                    }
                    
                    totalblock=0;
                    if(items1.length>0)
                    {
                            totalblock=parseInt(items1.length/__pagination);
                            if(items1.length%__pagination!=0)
                            {
                                    totalblock=totalblock+1;
                            }
                            
                            
                            var cmbpage=document.getElementById("cmbpage");
                           
                           try{ cmbpage.innerHTML="";
                           }catch(e){
                            cmbpage.innerText="";
                           }
                             
                            
                            for(i=1;i<=totalblock;i++)
                            {
                                    var option=document.createElement("OPTION");
                                    option.text=i;
                                    option.value=i;
                                    try
                                    {
                                        cmbpage.add(option);
                                    }catch(errorObject)
                                    {
                                    cmbpage.add(option,null);
                                    }
                            }                                 
                            loadPage(1);
                    }
             }
             else
             {
                     alert("Failed to Load Values");
             }       
 }  
 
 function loadPage(page)
{
            var i=0;
            var c=0;
            var p=__pagination*(page-1);
            //alert(page);
             var tbody=document.getElementById("tblList");
                      try{tbody.innerHTML="";}
                  catch(e) {tbody.innerText="";}
           // document.frmMasterRoles.cmbpagination.selectedIndex=page-1;
           document.frmMasterRoles.cmbpage.selectedIndex=page-1;
            for(i=p;i<items1.length && c<__pagination;i++)
            {
                        c++;
                        
                        
                    var tbody=document.getElementById("tblList");
                     var mycurrent_row=document.createElement("TR");
                     mycurrent_row.id=items1[i];
                     var cell=document.createElement("TD");
                     var anc=document.createElement("A");       
                     var url="javascript:loadValuesFromTable('" + items1[i] + "')";              
                     anc.href=url;
                     var txtedit=document.createTextNode("Edit");
                     anc.appendChild(txtedit);
                     cell.appendChild(anc);
                     mycurrent_row.appendChild(cell);
                     
                        var rollidcell =document.createElement("TD");    
                         var RollId=document.createTextNode(items1[i]);                         
                         rollidcell.appendChild(RollId);       
                         mycurrent_row.appendChild(rollidcell);  
                     
                         var rollnamecell =document.createElement("TD");    
                         var RollName=document.createTextNode(items2[i]);                         
                         rollnamecell.appendChild(RollName);       
                         mycurrent_row.appendChild(rollnamecell);  
                         
                         var rollcatcell =document.createElement("TD");    
                         var cat=document.createTextNode(items3[i]);                         
                         rollcatcell.appendChild(cat);       
                         mycurrent_row.appendChild(rollcatcell); 
                         
                         tbody.appendChild(mycurrent_row); 
                         
            }
           var cell=document.getElementById("divcmbpage");
                cell.style.display="block";
           var cell=document.getElementById("divpage");
                cell.style.display="block";
                cell.innerText= ' / ' +totalblock;
            if(page<totalblock)
            {
                var cell=document.getElementById("divnext");
                cell.style.display="block";
                try{cell.innerHTML="";}
                  catch(e) {cell.innerText="";}
                 var anc=document.createElement("A");
                var url="javascript:loadPage("+(page+1)+")";
                anc.href=url;
                var txtedit=document.createTextNode("<<Next>>");
                anc.appendChild(txtedit);
                cell.appendChild(anc);
            }
            else
            {
                var cell=document.getElementById("divnext");
                cell.style.display="none";
                try{cell.innerHTML="";}
                  catch(e) {cell.innerText="";}
            
            }
             if(page>1)
            {
                var cell=document.getElementById("divpre");
                cell.style.display="block";
                try{cell.innerHTML="";}
                  catch(e) {cell.innerText="";}
                 var anc=document.createElement("A");
                var url="javascript:loadPage("+(page-1)+")";
                anc.href=url;
                var txtedit=document.createTextNode("<<Previous>>");
                anc.appendChild(txtedit);
                cell.appendChild(anc);
            }
            else
            {
                var cell=document.getElementById("divpre");
                cell.style.display="none";
                try{cell.innerHTML="";}
                  catch(e) {cell.innerText="";}
            
            }
}
 
 
 function changepage()
{
var page=document.frmMasterRoles.cmbpage.value;
loadPage(parseInt(page));
}



function changepagesize()
{

           __pagination=document.frmMasterRoles.cmbpagination.value;
            var v=document.getElementsByName("sel");
        if(v && items2)
        {
                            totalblock=0;
                            if(items1.length>0)
                            {
                                    totalblock=parseInt(items1.length/__pagination);
                                    if(items1.length%__pagination!=0)
                                    {
                                            totalblock=totalblock+1;
                                    }
                                /*    var cmbpage=document.getElementById("cmbpage");
                                   
                                   try{ cmbpage.innerHTML="";
                                   }catch(e){
                                    cmbpage.innerText="";
                                   }
                                     
                                    
                                    for(i=1;i<=totalblock;i++)
                                    {
                                            var option=document.createElement("OPTION");
                                            option.text=i;
                                            option.value=i;
                                            try
                                            {
                                                cmbpage.add(option);
                                            }catch(errorObject)
                                            {
                                            cmbpage.add(option,null);
                                            }
                                    } */
                            }
                             loadPage(1);
        }
           
}
 
/*   for paginazion           */




