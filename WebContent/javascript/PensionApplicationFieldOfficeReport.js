
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
				alert("Please enter employee number.");
				return false;
			}
			if(selectedtext=="" || selectedtext=="--Select--")
			{
				alert("Please Select report form.");
				return false;
			}
			else
			{
				  var pensionType=document.getElementById("pensionType").value;
				  
					 
				  if(typeOfReportVal==1)
				  {
					  actionurl="pen_app_field_off_report_anxform5.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==2)
				  {
					  actionurl="pen_app_field_off_report_anxform5_1.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==3)
				  {
					  actionurl="pen_app_field_off_report_apppendcrg1.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==4)
				  {
					  actionurl="pen_app_field_off_report_apppendcrg2.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==5)
				  {
					  actionurl="pen_app_field_off_report_form_pen_gratuity1.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }					  
				  if(typeOfReportVal==6)
				  {
					  actionurl="pen_app_field_off_report_form_pen_gratuity2.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  if(typeOfReportVal==7)
				  {
					  actionurl="pen_app_field_off_report_form_pen_gratuity3.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==8)
				  {
					  actionurl="details_of_family.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }				  
				  if(typeOfReportVal==9)
				  {
					  if(pensionType==1 || pensionType==2)
					  {
						  actionurl="pension_cal_form1_report_val_action.html?empId="+empno+"&typeOfPen="+pensionType;
						 
						  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
					  }
					  if(pensionType==3)
					  {
						 
						  actionurl="pension_cal_form1_report_death_val_action.html?empId="+empno+"&typeOfPen="+pensionType;
						  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
					  }
				  }	
				  if(typeOfReportVal==10)
				  {
					  actionurl="pen_app_field_off_report_speci_sign.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  if(typeOfReportVal==11)
				  {
					  actionurl="pen_app_field_off_report_desc_roll.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==12)
				  {
					  actionurl="pen_app_field_off_report_att_joinphot.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }				  
				  if(typeOfReportVal==13)
				  {
					  actionurl="pen_app_field_off_report_cons_let.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==14)
				  {
					  actionurl="pen_app_field_off_report_cons_let_rec.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }					  
				  if(typeOfReportVal==15)
				  {
					  actionurl="pen_app_field_off_report_form_of_declaration.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==16)
				  {
					  actionurl="printPenAppFieldOffice.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }
				  if(typeOfReportVal==17)
				  {
					  actionurl="no_due_certificate.html?empId="+empno;
					  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
				  }	
				  if(typeOfReportVal==18)
				  {
					  if(pensionType==1 || pensionType==2)
					  {
						  actionurl="pension_cal_form1_report_working_sheet_val_action.html?empId="+empno+"&typeOfPen="+pensionType;
						  window.open(actionurl,'mywindow','scrollbars=yes,fullscreen=yes,location=no,menubar=yes');
					  }
					  if(pensionType==3)
					  {
						  actionurl="pension_cal_form1_report_death_working_sheet_val_action.html?empId="+empno+"&typeOfPen="+pensionType;
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




function penAppFeildOfficeReportSearch1(command)
{	
	var penappreportSearchKeyword=document.forms[0].empNo.value;
    if(command=="Search")
	  {
    	
    	
      var url="PenAppFieldOfficeReportSearch1.html?penappfieldofficereport.penappreportSearchKeyword="+penappreportSearchKeyword;
	  var req=getTransportPsfs();
       req.open("GET",url,true);        
       req.onreadystatechange=function()
       {
           processResponseDearnessSrch3(req);
        }   
        req.send(null);
        }  
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
       if(command=="PenAppFieldOfficeReportUserSearch1")
        {         	
    	      var flag=baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;  
    	      var len=baseResponse.getElementsByTagName("record").length;
    	      if(len==0)
    	      {
    	 	     alert("Not a valid employee no.");  
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


