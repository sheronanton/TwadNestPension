	
String.prototype.trim = function() {
	        a = this.replace(/^\s+/, '');
	        return a.replace(/\s+$/, '');
	        };
	        
	        
function checkSaveStatus()
	{	
		
		var flag1=true;
		
		var checkStatusLen=document.PensionCutOffEntry.checkStatus.length;
		var checkStatus;		
		
		for(var i=0;i<checkStatusLen;i++)
			{
			if (document.PensionCutOffEntry.checkStatus[i].checked)
		      {
				checkStatus=document.PensionCutOffEntry.checkStatus[i].value;			
		      } 
			}
		
		
		if(checkStatus=='yes')  
			{
				flag1=partialSaveNull();
			}
		
		
		else if(checkStatus=='no') 
			{
				flag1=fullSaveNull();
			}
			
		
		return flag1;
	}

	function partialSaveNull()
		{
		
			
			var flag2=true;			
			
			var payOffId=document.getElementById("paymentOfficeId");
			
			var selectedpayoffindex=payOffId.selectedIndex;
			//alert('selectedpayoffindex  '+selectedpayoffindex);
		    var selectedpayofftext=payOffId.options[selectedpayoffindex].text;
			//alert('selectedpayofftext   '+selectedpayofftext);
			
			var ppoNo=document.getElementById('ppoNo').value.trim();			
			var pensionerName=document.getElementById("pensionerName").value.trim();
			
			var originalPensionAmt=document.getElementById("originalPensionAmt").value.trim();
			var reducedPensionAmt=document.getElementById("reducedPensionAmt").value.trim();
			if(reducedPensionAmt=="")
			{
				reducedPensionAmt=0;
			}
			if(originalPensionAmt=="")
			{
				originalPensionAmt=0;
			}
			
			
			var commAmt=document.getElementById("commAmt").value.trim();
			var commPayDate=document.getElementById("commPayDate").value.trim();			
			
			var yr=document.getElementById('grossServiceYrs').value.trim();
			var mo=document.getElementById('grossServiceMonth').value.trim();
			var da=document.getElementById('grossServiceDays').value.trim();
			var t1=((yr * 365)+(mo*30)+(da*1));

			var yr2=document.getElementById('totServiceYrs').value.trim();
			var mo2=document.getElementById('totServiceMonths').value.trim();
			var da2=document.getElementById('totServiceDays').value.trim();
			var t2=((yr2 * 365)+(mo2*30)+(da2*1));

			var yr3=document.getElementById('quaServiceYrs').value.trim();
			var mo3=document.getElementById('quaServiceMonths').value.trim();
			var da3=document.getElementById('quaServiceDays').value.trim();
			var t3=((yr3 * 365)+(mo3*30)+(da3*1));

			var yr4=document.getElementById('nonquaServiceYrs').value.trim();
			var mo4=document.getElementById('nonquaServiceMonths').value.trim();
			var da4=document.getElementById('nonquaServiceDays').value.trim();
			var t4=((yr4 * 365)+(mo4*30)+(da4*1));

			var yr5=document.getElementById('netquaServiceYrs').value.trim();
			var mo5=document.getElementById('netquaServiceMonths').value.trim();
			var da5=document.getElementById('netquaServiceDays').value.trim();
			var t5=((yr5 * 365)+(mo5*30)+(da5*1));
			
			var familyPenTillDateAmt=document.getElementById('familyPensionTillDateAmt').value;
			var familyPenAfterDateAmt=document.getElementById('familyPensionAtferDateAmt').value;
			
			
			var chkj=document.getElementById("commReceived1");
			var commOpted=chkj.checked?chkj.value:document.getElementById("commReceived2").value;

			var optChk=document.getElementById("commOpted1");
			var optChkVal=optChk.checked?optChk.value:document.getElementById("commOpted2").value;
		
			
			var lastSignatureDate=document.getElementById('lastSignatureDate').value.trim();
			var dY1=lastSignatureDate.split("/")[2];
			
			var dateOfBirth=document.getElementById("dateOfBirth").value.trim();			
			var dobSplit=dateOfBirth;
			var dateOfRetirement=document.getElementById("dateOfRetirement").value.trim();
						
			var chkjSta=document.getElementById("pensionStatus1");
			var pensionStatus=chkjSta.checked?chkjSta.value:document.getElementById("pensionStatus2").value;
			
			var pensionNotPaidFrmMon=document.getElementById("pensionNotPaidFrmMon");
			var pensionNotPaidFrmYear=document.getElementById("pensionNotPaidFrmYear").value.trim();
	
					
			var weightageServiceYrs=document.getElementById("weightageServiceYrs").value.trim();
			var weightageServiceMonths=document.getElementById("weightageServiceMonths").value.trim();
			var weightageServiceDays=document.getElementById("weightageServiceDays").value.trim();
			
			
			
			var datesSep=dateOfBirth.split("/");
			var datesretire=dateOfRetirement.split("/");
			var cutOfEntryDate=document.getElementById("cutOfEntryDate").value.trim();
			var datecut=cutOfEntryDate.split("/");
			var datecompay=commPayDate.split("/");
			var familyPensionTillDate=document.getElementById("familyPensionTillDate").value.trim();
			var datefpentill=familyPensionTillDate.split("/");
			
			var nominationDate=document.getElementById("nominationDate").value.trim();
			var datenomin=nominationDate.split("/");
			var datelastsig=lastSignatureDate.split("/");
			
			var classPensionId=document.getElementById("classPensionId");
			var selectedindex=classPensionId.selectedIndex;
		    var selectedtext=classPensionId.options[selectedindex].text;
		      
		   //var maxt5=t5+(5*365);
		    
			if(ppoNo==null || ppoNo=="")
			{
				alert('Please Enter PPO No .');				
				
				return false;					
			}
		
			 if(pensionerName==null || pensionerName=="")
			{
				alert('Please Enter Pensioner Name');				
				
				return false;		
			}				
			
			 if((!isValidDate(datesSep[0],datesSep[1],datesSep[2])) && (dateOfBirth.length!=0))
			{
				alert('Invalid Date of Birth');
				
				return false;	
			}
			
			 if((!isValidDate(datesretire[0],datesretire[1],datesretire[2])) && (dateOfRetirement.length!=0))
			{
				alert('Invalid Retirement Date');
				
				return false;
			}

			
			 if(dobDorCheck(dateOfBirth,dateOfRetirement))
			{					
				
					return false;
			}
			
			 if((!isValidDate(datecut[0],datecut[1],datecut[2])) && (cutOfEntryDate.length!=0))
			{
				alert('Invalid Cut Off Entry Date');
				
				return false;	
			}
			
			 if(parseInt(reducedPensionAmt)!=0)
			{					
				if(parseInt(originalPensionAmt) <= parseInt(reducedPensionAmt))
				{
				alert('Reduced Pension Amount should be Lesser than Original Pension Amount.');				
				
				return false;	
				}
			}		
			 if(familyPenTillDateAmt!="")
			{
					if(parseInt(originalPensionAmt) < parseInt(familyPenTillDateAmt)) 
					{				
						alert('Family Pension Till Date Amount Greater than Original Pension Amount.');						
						
						return false;
					}
			}
			
			
			
			 if((commOpted=="Yes") && (commAmt==null || commAmt=="")) 
			{			
				alert('Please Enter Commutation Amount.');			
				
				return false;		
			}
				
		    if((commOpted=="Yes") &&(commPayDate==null || commPayDate==""))
			{
				alert('Please Enter Commutation Payment Date.');				
				
				return false;			
			}				
						
		
		    if(optChkVal=="N" && (reducedPensionAmt!=0))
		   {
			   alert('Please Make it Zero in Reduced Pension Amount');
			   document.getElementById("reducedPensionAmt").value="";
			 
				return false;
		   }
			
		    if((commPayDate.length!=0) && (!isValidDate(datecompay[0],datecompay[1],datecompay[2]) ))
		   {			  
		   		alert('Invalid Commutation Payment Date');
		   	
				return false;				
		   }
		
			
			 if((!isValidDate(datefpentill[0],datefpentill[1],datefpentill[2])) && (familyPensionTillDate.length!=0))
			{
				alert('Invalid Family Pension Till Date');
				
				return false;
			}
			
			 if(familyPenAfterDateAmt!="")
			{
			   		if(familyPenTillDateAmt=="")
			   		{
					alert('Family Pension Till Date Amount must be Greater than Family Pension After Date Amount.');					
					
					return false;
			   		}
				
			}
			
			if(familyPenAfterDateAmt!="" && familyPenTillDateAmt!="")
			{
				if(parseInt(familyPenTillDateAmt) < parseInt(familyPenAfterDateAmt)) 
				{				
					alert('Family Pension Till Date Amount must be Greater than Family Pension After Date Amount.');					
					
					return false;
				}
			}
			
		
			if(t2<t3) 
			{
				alert('Qualified Service is Greater than Total Service');			
				
				return false;
			}

			if(t2<t4) 
			{
				alert('Non Qualified Service is Greater than Total Service');			
				
				return false;
			}
			
			
			if((t2<t5) && selectedtext.toLowerCase()!="vrs") 
			{
				alert('Net Qualified Service is Greater than Total Service');						
				return false;
			}
			
			
			if(weightageServiceYrs==5 && (weightageServiceMonths >0 || weightageServiceDays >0 ))
			{
				alert('Weightage Service should be With in (5 Years : 0 Month : 0 Day) ');			
				return false;	
			}
			
		
			if(((t1>0) || (t2>0)) && (yr3=="" && mo3=="" && da3==""))
			{
					alert('Please Enter Qualified Service ');				
					return false;				
			}
			
			if((!isValidDate(datenomin[0],datenomin[1],datenomin[2])) && (nominationDate.length!=0))
			{
					alert('Invalid Nomination Date');
					
					return false;
			}

			
			if((pensionStatus=="true") && (pensionNotPaidFrmMon.selectedIndex==0)) 
			{							
				alert('Please Select Pension Not Paid From Month');			
				
				return false;		
			}
				
			if((pensionStatus=="true") && (pensionNotPaidFrmYear==null || pensionNotPaidFrmYear=="")) 
			{			
				alert('Please Enter Pension Not Paid From Year');	
				
				return false;		
			}
			
			if(dY1<2000)
			{
				alert('Last Signature Date should be Greater than 2000.');								
				
				return false;				
			}
			
			if((!isValidDate(datelastsig[0],datelastsig[1],datelastsig[2])) && (lastSignatureDate.length!=0))
			{
					alert('Invalid Last Signature Date');					
					return false;
			}
			
			if(selectedpayoffindex==0 || selectedpayoffindex==null || selectedpayoffindex.equals('--Select--'))
			{
				alert('Select Pension Payment Office');					
				return false;
			}
			
				
			flag2=CheckSubmit();
				
			if(!flag2)
			{
				return false;
			}
			
			return true;	
		}

	
	function isValidDate(day,month,year)
	{
		month-=1;
		var dteDate;
		dteDate=new Date(year,month,day);
		return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
	}

	
	function fullSaveNull()
		{
		
				
			
			var flag3=true;			
			var ppoNo=document.getElementById('ppoNo').value.trim();		
			var pensionerName=document.getElementById("pensionerName").value.trim();
					
			var dateOfBirth=document.getElementById("dateOfBirth").value.trim();
			var dateOfRetirement=document.getElementById("dateOfRetirement").value.trim();
			
			var cutOfEntryDate=document.getElementById("cutOfEntryDate").value.trim();
			var OfficeId=document.getElementById("OfficeId").value.trim();

			var classPensionId=document.getElementById("classPensionId");
			
			var originalPensionAmt=document.getElementById("originalPensionAmt").value.trim();
			var reducedPensionAmt=document.getElementById("reducedPensionAmt").value.trim();
						
			var paymentOfficeId=document.getElementById("paymentOfficeId");
					
			var address=document.getElementById("address").value.trim();
			var district=document.getElementById("district").value.trim();
			var state=document.getElementById("state");
			
			var pensionNotPaidFrmMon=document.getElementById("pensionNotPaidFrmMon");
			var pensionNotPaidFrmYear=document.getElementById("pensionNotPaidFrmYear").value.trim();
			var lastSignatureDate=document.getElementById("lastSignatureDate").value.trim();
			var dY1=lastSignatureDate.split("/")[2];
			
			var bankId=document.getElementById("bankId");
			var branchId=document.getElementById("branchId");
			var bankAcNo=document.getElementById("bankAcNo").value.trim();

						
			var commAmt=document.getElementById("commAmt").value.trim();
			var commPayDate=document.getElementById("commPayDate").value.trim();
		
			
			var chkj=document.getElementById("commReceived1");
			var commOpted=chkj.checked?chkj.value:document.getElementById("commReceived2").value;

			
			var yr=document.getElementById('grossServiceYrs').value.trim();
			var mo=document.getElementById('grossServiceMonth').value.trim();
			var da=document.getElementById('grossServiceDays').value.trim();
			var t1=((yr * 365)+(mo*30)+(da*1));

			var yr2=document.getElementById('totServiceYrs').value.trim();
			var mo2=document.getElementById('totServiceMonths').value.trim();
			var da2=document.getElementById('totServiceDays').value.trim();
			var t2=((yr2 * 365)+(mo2*30)+(da2*1));

			var yr3=document.getElementById('quaServiceYrs').value.trim();
			var mo3=document.getElementById('quaServiceMonths').value.trim();
			var da3=document.getElementById('quaServiceDays').value.trim();
			var t3=((yr3 * 365)+(mo3*30)+(da3*1));

			var yr4=document.getElementById('nonquaServiceYrs').value.trim();
			var mo4=document.getElementById('nonquaServiceMonths').value.trim();
			var da4=document.getElementById('nonquaServiceDays').value.trim();
			var t4=((yr4 * 365)+(mo4*30)+(da4*1));

			var yr5=document.getElementById('netquaServiceYrs').value.trim();
			var mo5=document.getElementById('netquaServiceMonths').value.trim();
			var da5=document.getElementById('netquaServiceDays').value.trim();
			var t5=((yr5 * 365)+(mo5*30)+(da5*1));
			
			var weightageServiceYrs=document.getElementById("weightageServiceYrs").value.trim();
			var weightageServiceMonths=document.getElementById("weightageServiceMonths").value.trim();
			var weightageServiceDays=document.getElementById("weightageServiceDays").value.trim();
			

			var familyPenTillDateAmt=document.getElementById('familyPensionTillDateAmt').value.trim();
			var familyPenAfterDateAmt=document.getElementById('familyPensionAtferDateAmt').value.trim();
			
			var chkjSta=document.getElementById("pensionStatus1");
			var pensionStatus=chkjSta.checked?chkjSta.value:document.getElementById("pensionStatus2").value;
								
			var optChk=document.getElementById("commOpted1");
			var optChkVal=optChk.checked?optChk.value:document.getElementById("commOpted2").value;
	
			var ddob=document.getElementById("dateOfBirth").value.trim();
			var datesSep=ddob.split("/");
			var datretire=dateOfRetirement.split("/"); 
			var datecut=cutOfEntryDate.split("/");
			var datecompay=commPayDate.split("/");
			var familyPensionTillDate=document.getElementById("familyPensionTillDate").value.trim();
			var datefpentill=familyPensionTillDate.split("/");
			
			var nominationDate=document.getElementById("nominationDate").value.trim();
			var datenomin=nominationDate.split("/");
			
			var datelastsig=lastSignatureDate.split("/");

			var currAcOfficeId=document.getElementById("currAccountOfficeId");
			
			var classPensionId=document.getElementById("classPensionId");
			var selectedindex=classPensionId.selectedIndex;
		    var selectedtext=classPensionId.options[selectedindex].text;
			
			
			if(ppoNo==null || ppoNo=="")
			{
				alert('Please Enter PPO No .');				
				return false;			
			}
		 
				
		   if(pensionerName==null || pensionerName=="")
			{
				alert('Please Enter Pensioner Name');				
				return false;		
			}									
			
			
		   if(dateOfBirth==null || dateOfBirth=="")
			{
				alert('Please Enter Date Of Birth');			
				return false;		
			}
			
			
		   if(!isValidDate(datesSep[0],datesSep[1],datesSep[2]))
			{
				alert('Invalid Date of Birth');
				return false;
			}
			
		    if(dateOfRetirement==null || dateOfRetirement=="")
			{
				alert('Please Enter Date Of Retirement');				
				return false;
			}
			
			
			 if(!isValidDate(datretire[0],datretire[1],datretire[2]))
			{
					alert('Invalid Date of Retirement');
					return false;
			}
			
			 if(dobDorCheck(dateOfBirth,dateOfRetirement))
			{					
				 return false;
			}
									
			 if(OfficeId==null || OfficeId=="")
			{
				alert('Please Enter Last Woking Office.');				
				return false;				
			}
			
			 if(currAcOfficeId.disabled==false && currAcOfficeId.selectedIndex==0)
			{
				alert('Please Select Current Accounts Maintaining Office');
				return false;
			}

			 if(cutOfEntryDate==null || cutOfEntryDate=="")
			{
				alert('Please Enter CutOffEntry Date.');				
				return false;							
			}
			
			 if(!isValidDate(datecut[0],datecut[1],datecut[2]))
			{
					alert('Invalid Cut of Entry Date');
					return false;
			}
						
			 if(classPensionId.selectedIndex==0)
			{
				alert('Please Select Class of Pension.');				
				return false;				
			}
			
			 if(originalPensionAmt==null || originalPensionAmt=="")
			{
				alert('Please Enter Original Pension Amount.');			
				return false;				
			}
			
			 if((parseInt(originalPensionAmt)!=0 && parseInt(reducedPensionAmt)!=0) && (parseInt(originalPensionAmt) <= parseInt(reducedPensionAmt)))
			{
				alert('Reduced Pension Amount is should be Lesser than Original Pension Amount.');			
				return false;				
			}		
		
			 if(parseInt(originalPensionAmt) < parseInt(familyPenTillDateAmt)) 
			{
				alert('Family Pension Till Date Amount is Greater than Original Pension Amount.');			
				return false;
			}
						
			 if((commOpted=="Yes") && (commAmt==null || commAmt=="")) 
			{			
				alert('Please Enter Commutation Amount.');			
				return false;	
			}
				
		    if((commOpted=="Yes") &&(commPayDate==null || commPayDate==""))
			{
				alert('Please Enter Commutation Payment Date.');				
				return false;			
			}				
			
			
		    if((commPayDate.length==10) && (!isValidDate(datecompay[0],datecompay[1],datecompay[2]) ))
			   {			  
			   		alert('Invalid Commutation Payment Date');
			   		return false;				
			   }
			
			
		    if(optChkVal=="N" && (reducedPensionAmt!="" ||reducedPensionAmt.length>0 ))
		   {
			   alert('Please Make it Zero in Reduced Pension Amount');			
			   document.getElementById("reducedPensionAmt").value="";
			   return false;
		   }
			
		
			 if((!isValidDate(datefpentill[0],datefpentill[1],datefpentill[2])) && (familyPensionTillDate.length==10))
			{
				alert('Invalid Family Pension Till Date');
				return false;
			}

			
			
			 if(familyPenAfterDateAmt!="")
			{
			   		if(familyPenTillDateAmt=="")
			   		{
					alert('Family Pension Till Date Amount must be Greater than Family Pension After Date Amount.');					
					
					return false;
			   		}
				
			}
			
			if(familyPenAfterDateAmt!="" && familyPenTillDateAmt!="")
			{
				if(parseInt(familyPenTillDateAmt) < parseInt(familyPenAfterDateAmt)) 
				{				
					alert('Family Pension Till Date Amount must be Greater than Family Pension After Date Amount.');		
					
					return false;
				}
			}
			
			 
			
			 if(t2<t3) 
			{
				alert('Qualified Service is Greater than Total Service');				
				return false;
			}

			 if(t2<t4) 
			{
				alert('Non Qualified Service is Greater than Total Service');				
				return false;
			}
			
			if((t2<t5) && selectedtext.toLowerCase()!="vrs") 
			{
				alert('Net Qualified Service is Greater than Total Service');				
				return false;
			}

			 if(weightageServiceYrs==5 && (weightageServiceMonths >0 || weightageServiceDays >0 ))
			{
				alert('Weightage Service should be With in (5 Years : 0 Month : 0 Day) ');
				return false;
			}
			
			if(((t1>0) || (t2>0)) && (yr3=="" && mo3=="" && da3==""))
			{
				alert('Please Enter Qualified Service ');				
				return false;				
			}
				
		    if(address==null || address=="")
			{
				alert('Please Enter Address.');					
				return false;
			
			}

			 if(district==null || district=="")
			{
				alert('Please Enter District.');				
				return false;
			
			}

			 if(state.selectedIndex==0)
			{
				alert('Please Select State');			
				return false;				
			}
			
		
			if((!isValidDate(datenomin[0],datenomin[1],datenomin[2])) && (nominationDate.length==10))
			{
				alert('Invalid Nomination Date');
				return false;
			}

			
			if((pensionStatus=="true") && (pensionNotPaidFrmMon.selectedIndex==0)) 
			{							
				alert('Please Select Pension Not Paid From Month');			
				return false;		
			}
				
			if((pensionStatus=="true") && (pensionNotPaidFrmYear==null || pensionNotPaidFrmYear=="")) 
			{			
				alert('Please Select Pension Not Paid From Year');			
				return false;		
			}			
					  
			if(lastSignatureDate==null || lastSignatureDate=="")
			{
				alert('Please Enter Last Signature Date.');				
				return false;
			
			}
			
					
			if((!isValidDate(datelastsig[0],datelastsig[1],datelastsig[2])) && (lastSignatureDate.length==10))
			{
				alert('Invalid Last Signature Date');
				return false;
			}
			
			if(dY1<2000)
			{
				alert('Last Signature Date should be Greater than 2000.');
				document.getElementById("lastSignatureDate").value="";			
				return false;
			
			}
			
			if(bankId.selectedIndex==0)
			{
				alert('Please Select Bank Name');			
				return false;
				
			}
			
			if(branchId.selectedIndex==0)
			{
				alert('Please Select Branch Name');					
				return false;
				
			}

			if(bankAcNo==null || bankAcNo=="")
			{
				alert('Please Enter Account No.');			
				return false;
				
			}			
				
						
				flag3=CheckSubmit();
			
			if(!flag3)
			{
				return false;
			}
				
			return true;
	
}

	
	function dobDorCheck(dObs,dOrs)
	{
		
		var f=false;
		var dB=dObs.split("/");
		var dR=dOrs.split("/");
		var yr1=31536000000;
		var dy1=86400000;
		
		var DdB=new Date();
		DdB.setFullYear(dB[2],parseInt(dB[1])-1,dB[0]);
		
		var DdR=new Date();
		DdR.setFullYear(dR[2],parseInt(dR[1])-1,dR[0]);
		
		var chk40=new Date(DdB.getTime()+(yr1*40)+(dy1*10));
					
		if((chk40.getTime() > DdR.getTime()))
			{
				alert("Minimum Difference Between Date of Birth & Date of Retirement should be 40 Yrs");
				f=true;
			}		
		
		return f;
	}

	
	

	 function netQualifiedCalc()
     {
   	    var netYear=0;
			var netMonth=0;
			var netDays=0;
			var yr3=0;
			var mo3=0;
			var da3=0;
			var weightageServiceYrs=0;
			var weightageServiceMonths=0;
			var weightageServiceDays=0;
			if(document.getElementById('quaServiceYrs').value.trim()!="")
			{
				yr3=document.getElementById('quaServiceYrs').value.trim();
			}
			if(document.getElementById('quaServiceMonths').value.trim()!="")
			{
				mo3=document.getElementById('quaServiceMonths').value.trim();
			}
			if(document.getElementById('quaServiceDays').value.trim()!="")
			{
				da3=document.getElementById('quaServiceDays').value.trim();
			}				
			if(document.getElementById('weightageServiceYrs').value.trim()!="")
			{
			weightageServiceYrs=document.getElementById("weightageServiceYrs").value.trim();
			}
			if(document.getElementById('weightageServiceMonths').value.trim()!="")
			{
			weightageServiceMonths=document.getElementById("weightageServiceMonths").value.trim();
			}
			if(document.getElementById('weightageServiceDays').value.trim()!="")
			{
			 weightageServiceDays=document.getElementById("weightageServiceDays").value.trim();
			}
			
			 netYear=parseInt(yr3)+parseInt(weightageServiceYrs);
			 netMonth=parseInt(mo3)+parseInt(weightageServiceMonths);
			 netDays=parseInt(da3)+parseInt(weightageServiceDays);
			
			if(netDays>29)
			{
				netMonth=netMonth+1;
				netDays=netDays%30;
			}
			if(netMonth>11)
			{
				netYear=netYear+1;
				netMonth=netMonth%12;
			}
			document.getElementById("netquaServiceYrs").value=netYear;
			document.getElementById("netquaServiceMonths").value=netMonth;
			document.getElementById("netquaServiceDays").value=netDays;
     }
     
     
     

     function valqualifiedCalc()
     {
   	    var qualYear=0;
			var qualMonth=0;
			var qualDays=0;
			var yr3=0;
			var mo3=0;
			var da3=0;
			var nonquaServiceYrs=0;
			var nonquaServiceMonths=0;
			var nonquaServiceDays=0;
			
			
			var yr2=document.getElementById('totServiceYrs').value.trim();
			var mo2=document.getElementById('totServiceMonths').value.trim();
			var da2=document.getElementById('totServiceDays').value.trim();
			var t2=((yr2 * 365)+(mo2*30)+(da2*1));
			var qualservice=0;
			
			
			if(document.getElementById('quaServiceYrs').value.trim()!="")
			{
				yr3=document.getElementById('quaServiceYrs').value.trim();
			}
			if(document.getElementById('quaServiceMonths').value.trim()!="")
			{
				mo3=document.getElementById('quaServiceMonths').value.trim();
			}
			if(document.getElementById('quaServiceDays').value.trim()!="")
			{
				da3=document.getElementById('quaServiceDays').value.trim();
			}				
			if(document.getElementById('nonquaServiceYrs').value.trim()!="")
			{
				nonquaServiceYrs=document.getElementById("nonquaServiceYrs").value.trim();
			}
			if(document.getElementById('nonquaServiceMonths').value.trim()!="")
			{
				nonquaServiceMonths=document.getElementById("nonquaServiceMonths").value.trim();
			}
			if(document.getElementById('nonquaServiceDays').value.trim()!="")
			{
				nonquaServiceDays=document.getElementById("nonquaServiceDays").value.trim();
			}
			
			qualYear=parseInt(yr3)+parseInt(nonquaServiceYrs);
			qualMonth=parseInt(mo3)+parseInt(nonquaServiceMonths);
			qualDays=parseInt(da3)+parseInt(nonquaServiceDays);				
			if(qualDays>29)
			{
				qualMonth=qualMonth+1;
				qualDays=qualDays%30;
			}
			if(qualMonth>11)
			{
				qualYear=qualYear+1;
				qualMonth=qualMonth%12;
			}
			
			qualservice=((qualYear * 365)+(qualMonth*30)+(qualDays*1));				
			if(qualservice!=t2)
			{					
				return false;
			}
			return true;
			
			
     }
