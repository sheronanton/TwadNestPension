var __pagination=5;
var totalblock=0;
var sno=0;

String.prototype.trim = function() {
    a = this.replace(/^\s+/, '');
    return a.replace(/\s+$/, '');
    };

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


function loadDatas(command)
{	
  
	var url="loadHOEditData.html";
	 //alert(url);
	  var req=getTransport();
       req.open("GET",url,true);        
       req.onreadystatechange=function()
       {
           processResult(req);
        };   
        req.send(null);
}  
	

function searchOperation(command)
{
	var opt=document.getElementById("SearchOptions").value;
	var key=document.getElementById("SearchKeyword").value;
	
	
if(command.trim()=='HOSearch')
	{
	  var url="loadHOEditSearchData.html?penappho.searchKeyword="+key+"&penappho.searchOption="+opt;
	  var req=getTransport();
	  req.open("GET",url,true);        
	  req.onreadystatechange=function()
	  {
         processResult(req);
      };   
      req.send(null);
	}

}

function processResult(req)
{	   
      if(req.readyState==4)
	  {
	      if(req.status==200)
	      {  
	    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
	    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
	    	  var command=tagCommand.firstChild.nodeValue;
	         if(command=="PenAppValidate")
	         { 
	        	LoadData(baseResponse);  	        	
	         }    
	         if(command=="PenAppValidateSearch")
	         { 
	        	LoadData(baseResponse);  	        	
	         }    
	         
	  
	   }
	}

}



function LoadData(baseResponse)
{
	  
    var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;  
    var len=baseResponse.getElementsByTagName("record").length;
    if(len==0)
      {
	      alert("Pensioner details are not available");   
	      cleanTbody();
	    }
   if(flag=='success')
      {   
	  
  	    record1=new Array();
         record2=new Array();
         record3=new Array();
         record4=new Array();
         //record5=new Array();	                  
                    
         if(len>0)
      	  
          {
      	  var display=baseResponse.getElementsByTagName("employeeId");   
      	  for(var i=0;i<display.length;i++)
            {
                record1[i] = baseResponse.getElementsByTagName("employeeId")[i].firstChild.nodeValue;
                record2[i] = baseResponse.getElementsByTagName("employeeName")[i].firstChild.nodeValue;
                record3[i] = baseResponse.getElementsByTagName("design")[i].firstChild.nodeValue;
                record4[i] = baseResponse.getElementsByTagName("office")[i].firstChild.nodeValue;
                                                             
                
      	    }       
                            totalblock=0;
                            if(record1.length>0)
                              {
                          	  changepagesize();
                                  totalblock=parseInt(record1.length/__pagination);
                             
                                  if(record1.length%__pagination!=0)
                                  {
                                      totalblock=totalblock+1;
                                  }
                                  var cmbpage=document.getElementById("cmbpage");
                                  try
                                  { 
                                      cmbpage.innerHTML="";
                                  }
                                  catch(e){
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
                                      }
                                      catch(errorObject)
                                      {
                                      cmbpage.add(option,null);
                                      }
                                  }  
                            
                                  loadRecordVal(1);
                              }
         }
       }
         else
         {
             
             var tbody=document.getElementById("tblList");	               
             try
             {
          	   tbody.innerHTML="";
             }
             catch(e) 
             {
          	   tbody.innerText="";
            }
         }
}



function loadRecordVal(page)
{
 
    var i=0;
    var c=0;    
    var p=__pagination*(page-1);

    var tbody=document.getElementById("tblList");
    try{
    	tbody.innerHTML="";
    	
    }
    
    catch(e) {
    	tbody.innerText="";
    	
    }
    document.getElementById("cmbpage").selectedIndex=page-1;
    
    for(i=p;i<record1.length && c<__pagination;i++)
    {
            c++;
            sno++;
            var mycurrent_row=document.createElement("TR"); 
             mycurrent_row.id=p;
             var cell4 = document.createElement("TD");        
             var radioInput ="";   
            if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
            {
               radioInput = document.createElement("<input type=radio name=radios value="+sno+" onclick=javascript:set("+sno+")>");
            }
            else
            {
           	radioInput = document.createElement('input');
            radioInput.setAttribute('type', 'radio');
            radioInput.setAttribute('name', "radios");
            radioInput.setAttribute("value", sno);
            radioInput.setAttribute("onclick","javascript:set("+sno+")");  
			 
			}
			
            cell4.appendChild(radioInput);
            mycurrent_row.appendChild(cell4); 
             
            cell5=document.createElement("TD");	            
	        var currentText=document.createTextNode(record1[i]);
	        cell5.setAttribute("id", "employeeId"+sno);	     
	        cell5.appendChild(currentText);
	        mycurrent_row.appendChild(cell5);

	        cell1=document.createElement("TD");	            
            var currentText=document.createTextNode(record2[i]);
            cell1.setAttribute("id", "employeeName"+sno);	     
            cell1.appendChild(currentText);
            mycurrent_row.appendChild(cell1);
            
            cell2=document.createElement("TD");
            var currentText=document.createTextNode(record3[i]);
            cell2.setAttribute("id", "design"+sno);
            cell2.appendChild(currentText);
            mycurrent_row.appendChild(cell2);            
            
            cell3=document.createElement("TD");
            var currentText=document.createTextNode(record4[i]);
            cell3.setAttribute("id", "office"+sno);
            cell3.appendChild(currentText);
            mycurrent_row.appendChild(cell3);	            
            
        /*    cell7=document.createElement("TD");
            var currentText=document.createTextNode(record5[i]);
            cell7.setAttribute("id", "processStatus"+sno);
            cell7.appendChild(currentText);
            mycurrent_row.appendChild(cell7);
            */
            tbody.appendChild(mycurrent_row);
            
    }
    document.getElementById("rowcount").value=sno;
    sno=0;
    /*This Part Is Used To Move The Next Page Or The Previous Page In The Grid*/
        
    var cell=document.getElementById("divcmbpage");
    cell.style.display="block";
    var cell=document.getElementById("divpage");
    cell.style.display="block";
    try
    {
    	cell.innerHTML='/'+totalblock;
    }
    catch(e){
    	cell.innerText='/'+totalblock;
    }
    
    if(page<totalblock)
    {
        var cell=document.getElementById("divnext");
        cell.style.display="block";
        
        try
        {
            cell.innerHTML="";
        }
        
        catch(e)
        {
            cell.innerText="";
        }
        
        var anc=document.createElement("A");
        var url="javascript:loadRecordVal("+(page+1)+")";
        anc.href=url;
        var txtedit=document.createTextNode("<<Next>>");
        anc.appendChild(txtedit);
        cell.appendChild(anc);
    }
    else
    {
        
    	var cell=document.getElementById("divnext");
        cell.style.display="block";
        
        try{	        	
        cell.innerHTML="";
        
        }
        
        catch(e) {
        	cell.innerText="";
        	
        }
    }
    
    if(page>1)
    {
        var cell=document.getElementById("divpre");
        cell.style.display="block";
        try{
        	cell.innerHTML="";
        	
        }
        
        catch(e) {
        	cell.innerText="";
        	
        }
        
        var anc=document.createElement("A");
        var url="javascript:loadRecordVal("+(page-1)+")";
        anc.href=url;
        var txtedit=document.createTextNode("<<Previous>>");
        anc.appendChild(txtedit);
        cell.appendChild(anc);
    }
    else
    {
        var cell=document.getElementById("divpre");
        cell.style.display="block";
        
        try{
        	cell.innerHTML="";
        	}
        
        catch(e) {
        	cell.innerText="";
        	
        }
    }

}




function changepagesize()
{
	
	
    __pagination=document.getElementById("cmbpagination").value;
    
     totalblock=0;
     
        if(record1.length>0)
        {
            totalblock=parseInt(record1.length/__pagination);
            if(record1.length%__pagination!=0)
            {
                totalblock=totalblock+1;
            }
            var cmbpage=document.getElementById("cmbpage");
            try
            {
                cmbpage.innerHTML="";
            }
            catch(e)
            {
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
                }
                catch(errorObject)
                {
                    cmbpage.add(option,null);
                }
            } 
        }
        loadRecordVal(1);
        document.getElementById("Submit").disabled=true;
}

function changepage()
{
	var page=document.getElementById("cmbpage").value;
    loadRecordVal(parseInt(page));
    document.getElementById("Submit").disabled=true;
}


function cleanTbody()
{
	var tbody=document.getElementById("tblList");	               
    try
    {
 	   tbody.innerHTML="";
    }
    catch(e) 
    {
 	   tbody.innerText="";
     }    
     
    var celldivpre=document.getElementById("divpre");
    var celldivnext=document.getElementById("divnext");
    var celldivcmbpage=document.getElementById("divcmbpage");
    var celldivpage=document.getElementById("divpage");
     
    celldivpre.style.display="none";
    celldivnext.style.display="none";
    celldivcmbpage.style.display="none";
    celldivpage.style.display="none";
    
    document.getElementById("SearchKeyword").value="";
    
    var cellcmbpagination=document.getElementById("cmbpagination");
    cellcmbpagination.value=5; 
    document.getElementById("Submit").disabled=true;
}


