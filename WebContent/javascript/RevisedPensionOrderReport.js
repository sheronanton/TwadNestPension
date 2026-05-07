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
		  	var reportform_onemanId=document.getElementById("reportform_onemanId");
		  	var selectedindex1=reportform_onemanId.selectedIndex;
		  	var selectedtext1=reportform_onemanId.options[selectedindex1].text;
		  	var typeOfReportVal_1=document.getElementById("reportform_onemanId").value;
		  	var typeOfReportVal=document.getElementById("reportformId").value;
		  	var selectedindex=reportformid.selectedIndex;
		  	var selectedtext=reportformid.options[selectedindex].text;	
		  	var typeOfReportVal_2=document.getElementById("reportform_SplGradeId").value;
		    var reportform_splgrade=document.getElementById("reportform_SplGradeId");
		    var selectedindex2=reportform_splgrade.selectedIndex;
		  	var selectedtext2=reportform_splgrade.options[selectedindex2].text;
		  	if(empno=="")
			{
				alert("You need fill the data on Authorization...");
				return false;
			}
		  	if(typeOfReportVal==1 || typeOfReportVal==2)
		  	{
		  	    if(selectedtext=="" || selectedtext=="--Select--")
			    {
				alert("Please Select pension order report.");
				return false;
		    	}
		  	 else
		  		{
		  		 if(typeOfReportVal==1)
				  {
					 //actionurl="RevisedPensionduetopaychange.html?empId="+empno;
					 actionurl="RevisedPensionOrderReport.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
		  		if(typeOfReportVal==2)
				  {
					  // actionurl="RevisedPensionduetopaychange1.html?empId="+empno;					  
					  actionurl="RevisedPensionDCRGReport.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
		  	    }
		  	}
		  	if(typeOfReportVal_1==1||typeOfReportVal_1==2)
		  	{
		  	   if(selectedtext1==""||selectedtext1=="--select--")
		  		{
		  	    alert("Please Select oneMan Commision order report.");
				return false;
		  		}
			else
			{									
				  /* 				   
				   if(typeOfReportVal==1)
				  {
					  // actionurl="Revisedpaypension.html?empId="+empno;	
					  actionurl="RevisedPensionNoteReport.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  */
				  if(typeOfReportVal_1==1)
				  {
					 //actionurl="duetopaychange.html?empId="+empno;
					 actionurl="OneManCommisionOrderReport.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  if(typeOfReportVal_1==2)
				  {
					 actionurl="OneManCommisionDCRGReport.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
			}
		  	}
		  if(typeOfReportVal_2==1||typeOfReportVal_2==2)
				  	{
				  	   if(selectedtext2==""||selectedtext2=="--select--")
				  		{
				  	    alert("Please Select Special Grade order report.");
						return false;
				  		}
					else
					{									
						  
						  if(typeOfReportVal_2==1)
						  {
							 //actionurl="duetopaychange.html?empId="+empno;
							 actionurl="SpecialGradeOrderReport.html?empId="+empno;
							  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
						  }
						  if(typeOfReportVal_2==2)
						  {
							 actionurl="SpecialGradeDCRGReport.html?empId="+empno;
							  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
						  }
					}
			}
		  }	  	
		catch(e)
		{
			//alert(e.message);
		}
		return true;	
}




function revPenOrderReportSearch(empId)
{	
	var url="RevPenOrderReportSearch.html?empId="+empId+"&rid="+Math.random();
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
       if(command=="RevPenOrderReportUserSearch")
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
    	    	  reason=baseResponse.getElementsByTagName("reason")[0].firstChild.nodeValue;
    	    	  document.getElementById("empNo").value=employeeId;
    	    	  document.getElementById("empName").value=employeeName;
    	    	  document.getElementById("pensionType").value=pensionType;
    	    	  document.getElementById("reportformId").value="";
    	    	  //alert(reason);
    	    	  if(reason=="DUE TO PAY ONEMAN COMMISION")
    	    		  {
    	    		  
    	    		  document.getElementById("Revised_pension").style.display="none";
    	    		  document.getElementById("showSpcial_grade").style.display="none";
    	    		  document.getElementById("showOneMan_Commision").style.display="block";
    	    		  }
    	    	  else if(reason=="DUE TO PAY REVISED PENSION")
    	    		 {
    	    		 // alert(reason+"------");
    	    			  document.getElementById("Revised_pension").style.display="block";
        	    		  document.getElementById("showOneMan_Commision").style.display="none";
        	    		  document.getElementById("showSpcial_grade").style.display="none";
    	    		 }
    	    	  else if(reason=="DUE TO PAY SPECIAL GRADE");
    	    	  {
    	    		  document.getElementById("showSpcial_grade").style.display="block";
    	    		  document.getElementById("Revised_pension").style.display="none";
    	    		  document.getElementById("showOneMan_Commision").style.display="none";
    	    	  }
    	    	  
    	      }
        }        
      }
   }
}


