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

    function getOfficesByType()
    {
        var type=document.frmOffice.cmbOfficeType.options[document.frmOffice.cmbOfficeType.selectedIndex].value;
        if(type!=0)
        {
            var din=document.getElementById("divType2");
            din.style.visibility="visible";
            document.frmOffice.cmbSelectOffice.style.visibility="visible";
            loadOfficesByType(type);
        }
    }
    
    function getOfficesByLevel()
    {
        var level=document.frmOffice.cmbControllingLevel.options[document.frmOffice.cmbControllingLevel.selectedIndex].value;
        var levelt=document.frmOffice.cmbControllingLevel.options[document.frmOffice.cmbControllingLevel.selectedIndex].text;
        if(levelt=="Division" || levelt=="Sub-Division" || levelt=="Section" )
        {
            var din=document.getElementById("divType1");
            din.style.visibility="visible";
            document.frmOffice.cmbOfficeType.style.visibility="visible";
            var din=document.getElementById("divType2");
            din.style.visibility="hidden";
            document.frmOffice.cmbSelectOffice.style.visibility="hidden";
            try
            {
                document.frmOffice.cmbOfficeType.focus();
                document.frmOffice.cmbOfficeType.select();
            }catch(e){}
        }
        else
        {
            var din=document.getElementById("divType1");
            din.style.visibility="hidden";
            document.frmOffice.cmbOfficeType.style.visibility="hidden";
            var din=document.getElementById("divType2");
            din.style.visibility="visible";
            document.frmOffice.cmbSelectOffice.style.visibility="visible";
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
    
    function loadOfficesByType(type)
    {
        var level=document.frmOffice.cmbControllingLevel.options[document.frmOffice.cmbControllingLevel.selectedIndex].value;
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
                
                var option1=document.createElement("OPTION");
                option1.text="----Select Office----";
                option1.value="0";
                try
                {
                    cmboffices.add(option1);
                }
                catch(errorObject)
                {
                    cmboffices.add(option1,null);
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
    
    function selectControllineOffice()
    {
        var ctlOffice=document.frmOffice.cmbSelectOffice.options[document.frmOffice.cmbSelectOffice.selectedIndex].value;
        var ctlOfficetext=document.frmOffice.cmbSelectOffice.options[document.frmOffice.cmbSelectOffice.selectedIndex].text;
        
        if(ctlOffice!=0)
        {
            document.frmOffice.txtContrllingOfficeID.value=ctlOffice;
            document.frmOffice.txtHContrllingOfficeID.value=ctlOffice;
            document.frmOffice.txtconOfficeName.value=ctlOfficetext;
        }        
    }
    
    function SaveToHidden()
    {
        document.frmOffice.txtHContrllingOfficeID.value=document.frmOffice.txtContrllingOfficeID.value;
    }