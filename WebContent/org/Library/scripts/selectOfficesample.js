// code for selecting the controlling office
            ///888888888888888888888888888888888888888888
            
     //alert('hai');       
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

    function getOfficesByType(frmName)
    {
        var type=eval("document." + frmName + ".cmbOfficeType.options[document." + frmName + ".cmbOfficeType.selectedIndex].value");                    
        if(type!=0)
        {
            var din=document.getElementById("divType2");
            din.style.visibility="visible";
            eval("document." + frmName+".cmbSelectOffice.style.visibility='visible'");
            loadOfficesByType(type,frmName);
        }
    }
    
    function getOfficesByLevel(frmName)
    {
                
        var level=eval("document." + frmName + ".cmbOfficeLevel.options[document." + frmName + ".cmbOfficeLevel.selectedIndex].value");                    
        var levelt=eval("document." + frmName + ".cmbOfficeLevel.options[document." + frmName +  ".cmbOfficeLevel.selectedIndex].text");        
        if(levelt=="Division" || levelt=="Sub-Division" || levelt=="Section" )
        {
            var din=document.getElementById("divType1");
            din.style.visibility="visible";
            eval("document." + frmName+".cmbOfficeType.style.visibility='visible'");
            var din=document.getElementById("divType2");
            din.style.visibility="hidden";
            eval("document." + frmName+".cmbSelectOffice.style.visibility='hidden'");            
            try
            {
            eval("document." +frmName+".cmbOfficeType.focus()");
            eval("document." +frmName+".cmbOfficeType.select()");
            }catch(e){}
        }
        else
        {
            var din=document.getElementById("divType1");
            din.style.visibility="hidden";
            eval("document." +frmName+".cmbOfficeType.style.visibility='hidden'");
            var din=document.getElementById("divType2");
            din.style.visibility="visible";
            eval("document." + frmName+".cmbSelectOffice.style.visibility='visible'");
            if(level!="----Select OfficeLevel----")
            {
                loadOfficesByLevel(level);
            }
        }
    
    }
    
    function loadOfficesByLevel(level)
    {
        var url="../../../../../ServletGetOfficesByTypeOrLevel.con?command=level&level="+level;
        var req=getTransport();
        req.open("GET",url,true);        
        req.onreadystatechange=function()
        {
            loadOffices(req);
        }
        req.send(null);
    }
    
    function loadOfficesByType(type,frmName)
    {
        var level=eval("document." + frmName + ".cmbOfficeLevel.options[document." + frmName + ".cmbOfficeLevel.selectedIndex].value");                    
        var url="../../../../../ServletGetOfficesByTypeOrLevel.con?command=type&level=" + level + "&type="+type;
        var req=getTransport();
        req.open("GET",url,true);        
        req.onreadystatechange=function()
        {
            loadOffices(req);
        }
        req.send(null);
    }
    
    function loadOffices(req)
    {
        if(req.readyState==4)
        {
          if(req.status==200)
          {  
                var cmboffices=document.getElementById("cmbSelectOffice");
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
    
    function selectOffice(frmName,txtBoxName)
    {
        var ctlOffice=eval("document." + frmName + ".cmbSelectOffice.options[document." + frmName + ".cmbSelectOffice.selectedIndex].value");        
        var ctlOffice1=eval("document." + frmName + ".cmbSelectOffice.options[document." + frmName + ".cmbSelectOffice.selectedIndex].text");
        if(ctlOffice!=0)
        {
        //fundemo();
        var doc=window.opener.document;
        doc.prompt.txtOffice_Id.value=ctlOffice;
        doc.prompt.txtOffice_Name.value=ctlOffice1;
        window.open('','_parent','');
        window.close();
        window.opener.focus();
            //document.prompt.txtOffice_Id.value=ctlOffice;
            //eval("document." + frmName + "." + txtBoxName + ".value=ctlOffice");
        }        
    }
    