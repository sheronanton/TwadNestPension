// code for selecting the controlling office
            ///888888888888888888888888888888888888888888
            
            
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

    function getOfficesByType_two(frmName)
    {
        var type=eval("document." + frmName + ".cmbOfficeType_two.options[document." + frmName + ".cmbOfficeType_two.selectedIndex].value");                    
        if(type!=0)
        {
            loadOfficesByType_two(type,frmName);
        }
    }
    
    function getOfficesByLevel_two(frmName)
    {
                
        var level=eval("document." + frmName + ".cmbOfficeLevel_two.options[document." + frmName + ".cmbOfficeLevel_two.selectedIndex].value");                    
        var levelt=eval("document." + frmName + ".cmbOfficeLevel_two.options[document." + frmName +  ".cmbOfficeLevel_two.selectedIndex].text");        
        if(levelt=="Division" || levelt=="Sub-Division" || levelt=="Section" )
        {
            var din=document.getElementById("divType3");
             var din1=document.getElementById("divType4");
            din.style.visibility="visible";
            din1.style.visibility="visible";
            eval("document." + frmName+".cmbOfficeType_two.style.visibility='visible'");
             eval("document." + frmName+".cmbSelectOffice_two.style.visibility='visible'");
            
            try
            {
            eval("document." +frmName+".cmbOfficeType_two.focus()");
            eval("document." +frmName+".cmbOfficeType_two.select()");
            }catch(e){}
        }
        else
        {
            var din=document.getElementById("divType3");
            din.style.visibility="hidden";
            
            var din1=document.getElementById("divType4");
            din1.style.visibility="visible";
            eval("document." + frmName+".cmbSelectOffice_two.style.visibility='visible'");
            
            eval("document." +frmName+".cmbOfficeType_two.style.visibility='hidden'");
            if(level!="----Select OfficeLevel----")
            {
                loadOfficesByLevel_two(level);
            }
        }
    
    }
    
    function loadOfficesByLevel_two(level)
    {
        var url="../../../../../ServletGetOfficesByTypeOrLevel.con?command=level&level="+level;
        var req=getTransport();
        req.open("GET",url,true);        
        req.onreadystatechange=function()
        {
            loadOffices_two(req);
        }
        req.send(null);
    }
    
    function loadOfficesByType_two(type,frmName)
    {
        var level=eval("document." + frmName + ".cmbOfficeLevel_two.options[document." + frmName + ".cmbOfficeLevel_two.selectedIndex].value");                    
        var url="../../../../../ServletGetOfficesByTypeOrLevel.con?command=type&level=" + level + "&type="+type;
        var req=getTransport();
        req.open("GET",url,true);        
        req.onreadystatechange=function()
        {
            loadOffices_two(req);
        }
        req.send(null);
    }
    
    function loadOffices_two(req)
    {
        if(req.readyState==4)
        {
          if(req.status==200)
          {  
                var cmboffices=document.getElementById("cmbSelectOffice_two");
                var i=0;
                var response=req.responseXML.getElementsByTagName("response")[0];
                var flag=response.getElementsByTagName("flag")[0].firstChild.nodeValue;
                cmboffices.innerHTML="";
                var optionf=document.createElement("OPTION");
                optionf.text="----select an Office----";
                optionf.value="0";
                try
                {
                    cmboffices.add(optionf);
                }
                catch(errorObject)
                {
                    cmboffices.add(optionf,null);
                }
                
                if(flag=="failure")
                {
                    alert("No Offices exists under this level");
                }
                else
                {                    
                    var value=response.getElementsByTagName("options");
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
                              cmboffices.add(option);
                          }
                          catch(errorObject)
                          {
                              cmboffices.add(option,null);
                          }
                    }
                }
            }
        }
    }
    
    function selectOffice_two(frmName,txtBoxName)
    {
        var ctlOffice=eval("document." + frmName + ".cmbSelectOffice_two.options[document." + frmName + ".cmbSelectOffice_two.selectedIndex].value");        
        if(ctlOffice!=0)
        {
            eval("document." + frmName + "." + txtBoxName + ".value=ctlOffice");
        }        
    }