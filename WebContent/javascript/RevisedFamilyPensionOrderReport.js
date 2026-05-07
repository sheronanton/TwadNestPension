function getTransportPsfs()
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



function GenReport()
{
		try
	  	{
		  	var empno=document.getElementById("empNo").value;
		  	var reportformid=document.getElementById("reportformId");
		  	var typeOfReportVal=document.getElementById("reportformId").value;
		  	var selectedindex=reportformid.selectedIndex;
		  	var selectedtext=reportformid.options[selectedindex].text;		  
		  	if(empno=="")
			{
				alert("You need fill the data on Authorization.");
				return false;
			}
		  	if(selectedtext=="" || selectedtext=="--Select--")
			{
				alert("Please Select pension order report.");
				return false;
			}
			else
			{									
				  if(typeOfReportVal==1)
				  {
					  actionurl="RevisedpayFamilypension.html?empId="+empno;					  
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  if(typeOfReportVal==2)
				  {
					  actionurl="RevisedFamilyPensionduetopaychange.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  if(typeOfReportVal==3)
				  {
					  actionurl="RevisedFamilyPensionduetopaychange1.html?empId="+empno;					  
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
			}			  
		}
		catch(e)
		{
			//alert(e.message);
		}
		return true;	
}




function revFamPenOrderReportSearch(empId)
{	
	var url="RevFamPenOrderReportSearch.html?empId="+empId+"&rid="+Math.random();
	var req=getTransportPsfs();
	req.open("GET",url,true);        
	req.onreadystatechange=function()
	{
		processResponseDearnessSrch3(req);
	}   
	req.send(null);
}


function processResponseDearnessSrch3(req)
{   
  if(req.readyState==4)
  {
     if(req.status==200)
      {  
		  var baseResponse=req.responseXML.getElementsByTagName("response")[0];
    	  var tagCommand=baseResponse.getElementsByTagName("command")[0];
    	  var command=tagCommand.firstChild.nodeValue;
       if(command=="RevFamPenOrderReportUserSearch")
        {         	
    	      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;  
    	      var len=baseResponse.getElementsByTagName("record").length;
    	      if(len==0)
    	      {
    	 	     alert("You need fill the data on Authorization.");  
    	 	     document.getElementById("empNo").value="";
    	 	     document.getElementById("empName").value="";
    	 	     document.getElementById("pensionType").value="";
    	 	     document.getElementById("reportformId").value="";
    		  }
    	      else
    	      {
    	    	  employeeId = baseResponse.getElementsByTagName("employeeId")[0].firstChild.nodeValue;
    	    	  employeeName = baseResponse.getElementsByTagName("employeeName")[0].firstChild.nodeValue;
    	    	  pensionType = baseResponse.getElementsByTagName("pensionType")[0].firstChild.nodeValue;
    	    	  document.getElementById("empNo").value=employeeId;
    	    	  document.getElementById("empName").value=employeeName;
    	    	  document.getElementById("pensionType").value=pensionType;
    	    	  document.getElementById("reportformId").value="";
    	      }
        }        
      }
   }
}


