
function getTransport()
   {
	var req=false;
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


function callServer(command)
{
	
		var options=document.forms[0].options.value;
		var searchText1 =document.forms[0].searchText.value;
		var searchText=searchText1.toLowerCase();
		 if(command=="Search")
		  {
		   alert("inside search");
		  	
		  	if(options==1)
		  	{
		  	   var url="../searchMenu1.html?objsearchpojo.searchText="+searchText;
		  		alert("url is"+url+options);
		  	}
		  	else if(options==2)
		  	  {
		  		var url="../searchMenu2.html?objsearchpojo.searchText="+searchText;
		  		alert("url is"+url+options);
		  		
		  	  }
		  	else if(options==3)
		  	  {
		  		var url="../searchMenu3.html?objsearchpojo.searchText="+searchText;
		  		alert("url is"+url+options);
		  		
		  	  }
		  	else if(options==4)
		  	  {
		  		alert("valuee for options is >>"+options);
		  		var url="../searchMenu4.html?objsearchpojo.searchText="+searchText;
		  		alert("url is"+url+options);
		  		
		  	  }
		
		   	var req=getTransport();
            req.open("GET",url,true);        
            req.onreadystatechange=function()
            {
               processResponse(req);
            }   
            req.send(null);
            }
               
        }
  


function processResponse(req)
{   

  if(req.readyState==4)
  {
      if(req.status==200)
      {  
    	  alert("flow complete"+req.status);
    	  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
          var command=tagCommand.firstChild.nodeValue;
        if(command=="search")
        {
             
              addRow(baseResponse);                 
         }
          
         
    	  
      }
   }
}



function addRow(baseResponse)
{   
      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue; 
      
      if(flag=="success")
      {     
    	  alert("success");
    	  	var tbody = document.getElementById("tblList");
			var table = document.getElementById("Existing");
			var t=0;
			var l=tbody.rows.length-1;
			for(t=l;t>=0;t--)
			{
			   tbody.deleteRow(0);
			}   
			 
			                     
			var len=baseResponse.getElementsByTagName("record").length;
                alert("RECORD LENGTH IS : "+len);
                if (len==0){alert("THERE IS NO RECORD TO SEARCH....");}
			for(var k=0;k<len;k++)
				
            {
             
             var ppoNo = baseResponse.getElementsByTagName("ppoNo")[k].firstChild.nodeValue;
             var employeeId = baseResponse.getElementsByTagName("employeeId")[k].firstChild.nodeValue;
             var pensionerName = baseResponse.getElementsByTagName("pensionerName")[k].firstChild.nodeValue
             var classDescription = baseResponse.getElementsByTagName("classDescription")[k].firstChild.nodeValue
             var processStatus = baseResponse.getElementsByTagName("processStatus")[k].firstChild.nodeValue
            
             
             var mycurrent_row=document.createElement("TR");
             mycurrent_row.id=ppoNo;
             
             var cell7=document.createElement("TD");
             var anc=document.createElement("A");       
             var url="javascript:loadValuesFromEdit('" +ppoNo + "')";              
             anc.href = url;
             var txtedit=document.createTextNode("Edit");
             anc.appendChild(txtedit);
             cell7.appendChild(anc);
             mycurrent_row.appendChild(cell7);    
             
             
             
             var cell =document.createElement("TD");    
             var ppoNo=document.createTextNode(ppoNo);
             cell.appendChild(ppoNo);  
             mycurrent_row.appendChild(cell);       
        
             
             var cell2 =document.createElement("TD");    
             var employeeId=document.createTextNode(employeeId);
             cell2.appendChild(employeeId);       
             mycurrent_row.appendChild(cell2); 
             
             var cell3 =document.createElement("TD");    
             var pensionerName=document.createTextNode(pensionerName);
             cell3.appendChild(pensionerName);       
             mycurrent_row.appendChild(cell3); 
             
             var cell4 =document.createElement("TD");    
             var classDescription=document.createTextNode(classDescription);
             cell4.appendChild(classDescription);       
             mycurrent_row.appendChild(cell4); 
             
             var cell5 =document.createElement("TD");    
             var processStatus=document.createTextNode(processStatus);
             cell5.appendChild(processStatus);       
             mycurrent_row.appendChild(cell5); 
             
             tbody.appendChild(mycurrent_row);
           
            
            }
      }
      else
      {
        alert("Failed to Load Values");
      }
}

function loadValuesFromEdit(rid)
{     
	 
      var r=document.getElementById(rid); 
      var rcells=r.cells;
     document.forms[0].ppText.value=rcells.item(1).firstChild.nodeValue;
     var edtppono=document.forms[0].ppText.value
	 alert("??????"+edtppono);
      
  	editData(edtppono);
      

}


function editData(edtppono){
	alert("INSIDE EDIT FUNCTION");
	 alert("--------->"+edtppono);
	var url;
	url = "editCutOfEntryPension.html";
	alert("url="+url);
	var HttpRequest = getTransport();
    HttpRequest.open("GET", url, true);
    HttpRequest.send(null);
	
}
















