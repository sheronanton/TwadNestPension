var aws_year=0;
var aws_month=0;
var aws_day=0;
var weightage_year=0;
var weightage_month=0;
var weightage_day=0;
var totnetnqsyear=0;
var disflag=0;

//var count=0;
//var flag_weightage=0;
//var flag_duplicate=0;

function isNum(arg)
{
	var args = arg;

	if (args == "" || args == null || args.length == 0)
	{
		return false;
	}

	args = args.toString();

	for (var i = 0;  i<args.length;  i++)
	{
		if ((args.substring(i,i+1) < "0" || args.substring(i, i+1) > "9") && args.substring(i, i+1) != ".")
		{
			return false;
		}
	}
	return true;
}

function checkday(aa)
{
	var val = aa.value;
	var valc = val.substring(0,1);

	if(val.length>0 && val.length<3)
	{
		if(!isNum(val) || val == 0)
		{
			aa.value="";
		}
		else if( val < 1 || val > 31)
		{
			aa.value=valc;
		}
	}
	else if(val.length>2)
	{
		val = val.substring(0, 2);
		aa.value=val;
	}
}

function checkmon(aa)
{
	var val = aa.value;
	var valc = val.substring(0,1);

	if(val.length>0 && val.length<3)
	{
		if(!isNum(val) || val == 0)
		{
			aa.value="";
		}
		else if(val < 1 || val > 12)
		{
			aa.value=valc;
		}
	}
	else if(val.length>2)
	{
		val = val.substring(0, 2);
		aa.value=val;
	}
}

function checkyear(aa)
{
	var val = aa.value;
	var valc = val.substring(0,(val.length-1));

	if(val.length>0 && val.length<7)
	{
		if(!isNum(val) || val == 0)
		{
			aa.value=valc;
		}
		else if(val < 1 || val>275759)
		{
			aa.value="";
		}
	}
	else if(val.length>4)
	{
		aa.value=valc;
	}
}

function checkleapyear(datea)
{
	if(datea.getYear()%4 == 0)
	{
		if(datea.getYear()% 10 != 0)
		{
			return true;
		}
		else
		{
			if(datea.getYear()% 400 == 0)
				return true;
			else
				return false;
		}
	}
	return false;
}


function DaysInMonth(Y, M) {
	with (new Date(Y, M, 1, 12)) {
		setDate(0);
		return getDate();
	}
}


function datediff(date1, date2)
{
	var y1 = date1.getFullYear();
	var m1 = date1.getMonth();
	var d1 = date1.getDate();
	var y2 = date2.getFullYear();
	var m2 = date2.getMonth();
	var d2 = date2.getDate();    
	if (d1 < d2) {
		m1--;
		//	d1 += DaysInMonth(y2, m2);
		d1 += 30;
	}
	if (m1 < m2) {
		y1--;
		m1 += 12;
	}    
	return [y1 - y2, m1 - m2, d1 - d2];
}

function calage()
{
	var curday = document.cir.len11.value;
	var curmon = document.cir.len12.value;
	var curyear = document.cir.len13.value;
	var calday = document.cir.len21.value;
	var calmon = document.cir.len22.value;
	var calyear = document.cir.len23.value;
	if(curday == "" || curmon=="" || curyear=="" || calday=="" || calmon=="" || calyear=="")
	{
		alert("please fill all the values and click go -");
	}	
	else
	{
		var curd = new Date(curyear,curmon-1,curday);
		var cald = new Date(calyear,calmon-1,calday);

		var diff =  Date.UTC(curyear,curmon,curday,0,0,0) - Date.UTC(calyear,calmon,calday,0,0,0);

		var dife = datediff(curd,cald);
		document.cir.val.value=dife[0]+" years, "+dife[1]+" months, and "+dife[2]+" days";

		var secleft = diff/1000/60;
		document.cir.val3.value=secleft+" minutes since your service";

		var hrsleft = secleft/60;
		document.cir.val2.value=hrsleft+" hours since your service";

		var daysleft = hrsleft/24;
		document.cir.val1.value=daysleft+" days since your service";	

		var as = parseInt(calyear)+dife[0]+1;

		var diff =  Date.UTC(as,calmon,calday,0,0,0) - Date.UTC(curyear,curmon,curday,0,0,0);
		var datee = diff/1000/60/60/24;
		document.cir.val4.value=datee+" days left for your next serviceday";	
	}
}

function color(test)
{

	for(var j=7; j<12; j++)
	{
		var myI=document.getElementsByTagName("input").item(j);
		//myI.setAttribute("style",ch);
		myI.style.backgroundColor=test;
	}
}

function color1(test)
{
	var myI=document.getElementsByTagName("table").item(0);
//	myI.setAttribute("style",ch);
	myI.style.backgroundColor=test;
}

function numonlywithoutdot(e)
{
	var flag=true;
	var unicode=e.charCode? e.charCode : e.keyCode;

	if (unicode!=8)//backspace
	{ 
		// alert(unicode);  	
		if (unicode<45||unicode>57||unicode==47||unicode==45 || unicode==46) 
			flag=false ;
	}

	return flag;

} 

/*************************************Number only function end**********************************************/

function calcservice()
{	
	calcts();
	calcnon_qs();

	// Starts Wce 

	if((document.getElementById("wceserviceFlagYes").checked==true))
	{ 	
		if((document.getElementById("wceyear").value==NaN)||(document.getElementById("wceyear").value=="") || (document.getElementById("wceyear").value==null))
		{
			document.getElementById("wceyear").value=0;
		}	

		if((parseInt(document.getElementById("wceyear").value)<5) && (document.getElementById("wcecountedFlagNo").checked==true))
		{
			calcwce();

		}



	}


	if((document.getElementById("wcecountedFlagYes").checked==true) || (document.getElementById("wceserviceFlagNo").checked==true))
	{
		document.getElementById("wcedislable").style.display="none";
		document.getElementById("wceyeardis").style.display="none";
		document.getElementById("wcemonthdis").style.display="none";
		document.getElementById("wcedaydis").style.display="none";

		document.getElementById("wce_yeardis").value=0;
		document.getElementById("wce_monthdis").value=0;
		document.getElementById("wce_daydis").value=0;
	}	


	// Contingent Service Calculation Starts
	if(document.getElementById("contingentserviceFlagYes").checked==true)
	{
		calccontingent();
		//calcts();
		//calcnon_qs();

	}
	else if(document.getElementById("contingentserviceFlagNo").checked==true)
	{
		document.getElementById("contingentdislable").style.display="none";
		document.getElementById("contingentyeardis").style.display="none";
		document.getElementById("contingentmonthdis").style.display="none";
		document.getElementById("contingentdaydis").style.display="none";

		document.getElementById("contingent_yeardis").value=0;
		document.getElementById("contingent_monthdis").value=0;
		document.getElementById("contingent_daydis").value=0;
	}
	//Contingent Service Calculation End


	if ((document.getElementById("vrs_date").value!=""))
	{
		var dar=document.getElementById("dar").value;
		var dateofjoin=document.getElementById("twadDateofJoin").value;
		var datesSep=dar.split("/");
		var datesSep1=dateofjoin.split("/");
		var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
		var dated=datediff(tdate,fdate);
		if ((document.getElementById("nqs_year").value!=NaN)&&(document.getElementById("nqs_year").value!="")&&(document.getElementById("nqs_year").value!=null ))
		{			
			totnetnqsyear=document.getElementById("nqs_year").value;
			//alert("if nqs year service"+totnetnqsyear);

		}

		// alert("if nqs year service"+totnetnqsyear);

		if (totnetnqsyear<30)
		{
			calcweightage();

		}
		else{

			//alert("checking");
			document.getElementById("weigtdislable").style.display="none";
			/*			document.getElementById("weigt_yeardis").style.display="none";
			document.getElementById("weigt_monthdis").style.display="none";
			document.getElementById("weigt_daydis").style.display="none";	
			 */			document.getElementById("weigtyeardis").style.display="none";
			 document.getElementById("weigtmonthdis").style.display="none";
			 document.getElementById("weigtdaydis").style.display="none";	


			 document.getElementById("weigt_yeardis").value=0;
			 document.getElementById("weigt_monthdis").value=0;
			 document.getElementById("weigt_daydis").value=0;
		}
	} 
	try
	{
	cal_number_of_half_year();
	}
	catch(e)
	{
		
	}

}

// To finding Total Non Qualified Services
function calcnon_qs()
{
	var npp_year=0;
	var npp_month=0;
	var npp_day=0;

	var ewm_year=0;
	var ewm_month=0;
	var ewm_day=0;

	var s_year=0;
	var s_month=0;
	var s_day=0;

	var bs_year=0;
	var bs_month=0;
	var bs_day=0;

	var ol_year=0;
	var ol_month=0;
	var ol_day=0;

	var lnr_year=0;
	var lnr_month=0;
	var lnr_day=0;

	var as_year=0;
	var as_month=0;
	var as_day=0;

	var svnd_year=0;
	var svnd_month=0;
	var svnd_day=0;

	var tqs_year=0;
	var tqs_month=0;
	var tqs_day=0;

	var fs_year=0;
	var fs_month=0;
	var fs_day=0;

	var nqs_year=0;
	var nqs_month=0;
	var nqs_day=0;

	var yearmax=42;
	var monthmax=11;
	var daymax=29;


	if(document.getElementById("npp_year").value!="")
	{
		if(parseInt(document.getElementById("npp_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("npp_year").value="";
		}
		else
		{
			npp_year=document.getElementById("npp_year").value;
		}
	}
	if(document.getElementById("npp_month").value!="")
	{
		if(parseInt(document.getElementById("npp_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("npp_month").value="";
		}
		else
		{
			npp_month=document.getElementById("npp_month").value;
		}

	}
	if(document.getElementById("npp_day").value!="")
	{

		if(parseInt(document.getElementById("npp_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("npp_day").value="";
		}
		else
		{
			npp_day=document.getElementById("npp_day").value;
		}

	}

	if(document.getElementById("ewm_year").value!="")
	{
		if(parseInt(document.getElementById("ewm_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("ewm_year").value="";
		}
		else
		{
			ewm_year=document.getElementById("ewm_year").value;
		}
	}
	if(document.getElementById("ewm_month").value!="")
	{
		if(parseInt(document.getElementById("ewm_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("ewm_month").value="";
		}
		else
		{
			ewm_month=document.getElementById("ewm_month").value;
		}
	}
	if(document.getElementById("ewm_day").value!="")
	{
		if(parseInt(document.getElementById("ewm_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("ewm_day").value="";
		}
		else
		{
			ewm_day=document.getElementById("ewm_day").value;
		}
	}

	if(document.getElementById("s_year").value!="")
	{
		if(parseInt(document.getElementById("s_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("s_year").value="";
		}
		else
		{
			s_year=document.getElementById("s_year").value;
		}
	}
	if(document.getElementById("s_month").value!="")
	{
		if(parseInt(document.getElementById("s_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("s_month").value="";
		}
		else
		{
			s_month=document.getElementById("s_month").value;
		}
	}
	if(document.getElementById("s_day").value!="")
	{
		if(parseInt(document.getElementById("s_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("s_day").value="";
		}
		else
		{
			s_day=document.getElementById("s_day").value;
		}
	}

	if(document.getElementById("bs_year").value!="")
	{
		if(parseInt(document.getElementById("bs_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("bs_year").value="";
		}
		else
		{
			bs_year=document.getElementById("bs_year").value;
		}
	}
	if(document.getElementById("bs_month").value!="")
	{
		if(parseInt(document.getElementById("bs_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("bs_month").value="";
		}
		else
		{
			bs_month=document.getElementById("bs_month").value;
		}
	}
	if(document.getElementById("bs_day").value!="")
	{
		if(parseInt(document.getElementById("bs_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("bs_day").value="";
		}
		else
		{
			bs_day=document.getElementById("bs_day").value;
		}
	}


	if(document.getElementById("ol_year").value!="")
	{
		if(parseInt(document.getElementById("ol_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("ol_year").value="";
		}
		else
		{
			ol_year=document.getElementById("ol_year").value;
		}
	}
	if(document.getElementById("ol_month").value!="")
	{
		if(parseInt(document.getElementById("ol_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("ol_month").value="";
		}
		else
		{
			ol_month=document.getElementById("ol_month").value;
		}
	}
	if(document.getElementById("ol_day").value!="")
	{
		if(parseInt(document.getElementById("ol_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("ol_day").value="";
		}
		else
		{
			ol_day=document.getElementById("ol_day").value;
		}
	}


	if(document.getElementById("lnr_year").value!="")
	{
		if(parseInt(document.getElementById("lnr_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("lnr_year").value="";
		}
		else
		{
			lnr_year=document.getElementById("lnr_year").value;
		}
	}
	if(document.getElementById("lnr_month").value!="")
	{
		if(parseInt(document.getElementById("lnr_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("lnr_month").value="";
		}
		else
		{
			lnr_month=document.getElementById("lnr_month").value;
		}
	}
	if(document.getElementById("lnr_day").value!="")
	{
		if(parseInt(document.getElementById("lnr_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("lnr_day").value="";
		}
		else
		{
			lnr_day=document.getElementById("lnr_day").value;
		}
	}

	if(document.getElementById("as_year").value!="")
	{
		if(parseInt(document.getElementById("as_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("as_year").value="";
		}
		else
		{
			as_year=document.getElementById("as_year").value;
		}
	}
	if(document.getElementById("as_month").value!="")
	{
		if(parseInt(document.getElementById("as_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("as_month").value="";
		}
		else
		{
			as_month=document.getElementById("as_month").value;
		}
	}
	if(document.getElementById("as_day").value!="")
	{
		if(parseInt(document.getElementById("as_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("as_day").value="";
		}
		else
		{
			as_day=document.getElementById("as_day").value;
		}
	}

	if(document.getElementById("svnd_year").value!="")
	{
		if(parseInt(document.getElementById("svnd_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("svnd_year").value="";
		}
		else
		{
			svnd_year=document.getElementById("svnd_year").value;
		}
	}
	if(document.getElementById("svnd_month").value!="")
	{
		if(parseInt(document.getElementById("svnd_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("svnd_month").value="";
		}
		else
		{
			svnd_month=document.getElementById("svnd_month").value;
		}
	}
	if(document.getElementById("svnd_day").value!="")
	{
		if(parseInt(document.getElementById("svnd_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("svnd_day").value="";
		}
		else
		{
			svnd_day=document.getElementById("svnd_day").value;
		}
	}


	if(document.getElementById("fs_year").value!="")
	{
		if(parseInt(document.getElementById("fs_year").value)>parseInt(yearmax))
		{
			alert("Enter year between 0 to "+yearmax);
			document.getElementById("fs_year").value="";
			document.getElementById("fs_yeardis").value="";
		}
		else
		{
			fs_year=document.getElementById("fs_year").value;
			document.getElementById("fs_yeardis").value=fs_year;
		}
	}
	if(document.getElementById("fs_month").value!="")
	{
		if(parseInt(document.getElementById("fs_month").value)>parseInt(monthmax))
		{
			alert("Enter month between 0 to "+monthmax);
			document.getElementById("fs_month").value="";
			document.getElementById("fs_monthdis").value="";
		}
		else
		{
			fs_month=document.getElementById("fs_month").value;
			document.getElementById("fs_monthdis").value=fs_month;
		}
	}
	if(document.getElementById("fs_day").value!="")
	{
		if(parseInt(document.getElementById("fs_day").value)>parseInt(daymax))
		{
			alert("Enter days between 0 to "+daymax);
			document.getElementById("fs_day").value="";
			document.getElementById("fs_daydis").value="";
		}
		else
		{
			fs_day=document.getElementById("fs_day").value;
			document.getElementById("fs_daydis").value=fs_day;
		}
	}

	// Calcauation for finding total non qualified service(tqs)

	tqs_year=parseInt(npp_year)+parseInt(ewm_year)+parseInt(s_year)+parseInt(bs_year)+parseInt(ol_year)+parseInt(lnr_year)+parseInt(as_year)+parseInt(svnd_year);
	tqs_month=parseInt(npp_month)+parseInt(ewm_month)+parseInt(s_month)+parseInt(bs_month)+parseInt(ol_month)+parseInt(lnr_month)+parseInt(as_month)+parseInt(svnd_month);
	tqs_day=parseInt(npp_day)+parseInt(ewm_day)+parseInt(s_day)+parseInt(bs_day)+parseInt(ol_day)+parseInt(lnr_day)+parseInt(as_day)+parseInt(svnd_day);

	if(tqs_day>29)
	{
		tqs_dayremainer=tqs_day%30;
		tqs_daydivident=tqs_day/30;
	
		tqs_month=parseInt(tqs_month)+parseInt(tqs_daydivident);
		tqs_day=tqs_dayremainer;
	}
	if(tqs_month>11)
	{
		tqs_monthremainer=tqs_month%12;
		tqs_monthdivident=tqs_month/12;

		tqs_year=parseInt(tqs_year)+parseInt(tqs_monthdivident);
		tqs_month=tqs_monthremainer;
	}	

	aws_year=parseInt(document.getElementById("aws_year").value);	
	aws_month=parseInt(document.getElementById("aws_month").value);
	aws_day=parseInt(document.getElementById("aws_day").value);

	/*aws_year=parseInt(aws_year)+parseInt(fs_year);
	aws_month=parseInt(aws_month)+parseInt(fs_month);
	aws_day=parseInt(aws_day)+parseInt(fs_day);
	 */
	//alert(aws_year);

	/*if(aws_day>29)
	{		
		aws_dayremainer=aws_day%30;
		aws_daydivident=aws_day/30;		
		aws_month=parseInt(aws_month)+parseInt(aws_daydivident);
		//aws_month=parseInt(aws_month)+1;
		//alert(aws_month);
		aws_day=aws_dayremainer;
	}
	if(aws_month>11)
	{		
		aws_monthremainer=aws_month%12;
		aws_monthdivident=aws_month/12;
		aws_year=parseInt(aws_year)+parseInt(aws_monthdivident);
		//aws_year=parseInt(aws_year)+1;
		aws_month=aws_monthremainer;
		//alert(aws_monthremainer);
	}	*/

	if(tqs_year>aws_year)
	{
		alert("Please Enter valid services");
		disflag=1;
	}
	else if(tqs_year==aws_year)
	{
		if(tqs_month>aws_month)
		{
			alert("Please Enter valid services");
			disflag=1;
		}
		else if(tqs_month==aws_month)
		{
			if(tqs_day>aws_day)
			{
				alert("Please Enter valid services");
				disflag=1;
			}
		}
	}
	//Asssignment for total non qualified service and non qualified service
	if(disflag==0)
	{
		document.getElementById("tqs_year").value=tqs_year;
		document.getElementById("tqs_month").value=tqs_month;
		document.getElementById("tqs_day").value=tqs_day;

		document.getElementById("nonq_yeardis").value=tqs_year;
		document.getElementById("nonq_monthdis").value=tqs_month;
		document.getElementById("nonq_daydis").value=tqs_day;

	}

	nqs_year=parseInt(aws_year)-parseInt(tqs_year);
	nqs_month=parseInt(aws_month)-parseInt(tqs_month);
	nqs_day=parseInt(aws_day)-parseInt(tqs_day);
	/*alert("year"+nqs_year);
	alert("month"+nqs_month);
	alert("days"+nqs_day);*/


	if(parseInt(nqs_day)<0)
	{
		nqs_month=parseInt(nqs_month)-1;
		nqs_day=30+parseInt(nqs_day);
	}
	if(parseInt(nqs_month)<0)
	{
		nqs_year=parseInt(nqs_year)-1;
		nqs_month=12+parseInt(nqs_month);
	}





	if(disflag==0)
	{			
		/*		
		alert("year"+nqs_year);
		alert("month"+nqs_month);
		alert("days"+nqs_day);
		*/
		document.getElementById("nqs_year").value=nqs_year;
		document.getElementById("nqs_month").value=nqs_month;
		document.getElementById("nqs_day").value=nqs_day;

		document.getElementById("netq_yeardis").value=nqs_year;
		document.getElementById("netq_monthdis").value=nqs_month;
		document.getElementById("netq_daydis").value=nqs_day;
		
	}

}

//To finding Total Service of the employee
function calcts()
{

	var dar=document.getElementById("dar").value;
	//alert('dar-------------'+dar);
	var vrs=document.getElementById("vrs_date").value;
	var death=document.getElementById("death_date").value;		
	var dateofjoin=document.getElementById("twadDateofJoin").value;
	//alert('dateofjoin-------------'+dateofjoin);

	var dated=0;
	//alert(vrs+"   "+death+"  "+dar);

	if (document.getElementById("classPensionId").value != "0")
	{
		if (document.getElementById("classPensionId").value == "2")
		{
			// alert("VRS");
			var datesSep=vrs.split("/");
			var datesSep1=dateofjoin.split("/");
			var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
			//alert("todate="+tdate+"fromdate="+fdate);
			dated=datediff(tdate,fdate);


		} else if (document.getElementById("classPensionId").value =="3")
		{
			//alert("Death");
			var datesSep=death.split("/");
			var datesSep1=dateofjoin.split("/");
			var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
			dated=datediff(tdate,fdate);


		}
		else if (document.getElementById("classPensionId").value =="1")
		{
			//alert("Super");
			var datesSep=dar.split("/");
			var datesSep1=dateofjoin.split("/");
			var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
			var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);			
			dated=datediff(tdate,fdate);
			
			

		}

		aws_year=dated[0];
		aws_month=dated[1];
		aws_day=dated[2];

			//alert("Year "+ aws_year+"  MOnth "+aws_month + "-"+aws_day);


		var dateofjoinsession=document.getElementById("twadDateofJoinsession").value;
		//alert(dateofjoinsession);
		if(dateofjoinsession=="FN")
		{
			aws_day=dated[2]+1;			
		}
		if(dateofjoinsession=="AN")
		{
			aws_day=dated[2];
		}

		if(parseInt(aws_day)>29)
		{
			aws_day=0;
			aws_month=parseInt(aws_month)+1;		

		}
		if(parseInt(aws_month)>11)
		{
			aws_month=0;
			aws_year=parseInt(aws_year)+1;
		}
		
		//alert("after Year "+ aws_year+"  MOnth "+aws_month + "-"+aws_day);
	//Rajasekar modification on 27-sep-2012
		/*var dobdate=document.getElementById("dateofBirth").value;
		var dobdatett=dobdate.split("/");
		var dobdatet=new Date(dobdatett[2],dobdatett[1]-1,dobdatett[0]);
		var agedated=datediff(tdate,dobdatet);
		alert("day"+agedated[2]+"month"+agedated[1]+"year"+agedated[0]);
		if(agedated[2]>0)
		{
			ageday=agedated[2]+1;
		}	
		else
		{
			ageday=agedated[2];
		}
		if(agedated[0]>0)
		{
			age=agedated[0];
		}	
		if((parseInt(ageday)>0) || parseInt(agedated[1])>0)
		{
			age=age+1;
		}		

		alert("calcserviceage"+age);
		document.getElementById("age").value=age;*/
		

		//alert(aws_year);
		try
		{
			fetchCommutedvalueData();
		}
		catch(e)
		{
			
		}
		document.getElementById("aws_yeardis").value=aws_year;
		document.getElementById("aws_monthdis").value=aws_month;
		document.getElementById("aws_daydis").value=aws_day;

		document.getElementById("aws_year").value=aws_year;
		document.getElementById("aws_month").value=aws_month;
		document.getElementById("aws_day").value=aws_day;
	}
}

// To find the WCE 
function calcwce()
{
	var wceyear=0;
	var wcemonth=0;
	var wceday=0;
	var wceserviceyear=0;
	var wceservicemonth=0;
	var wceserviceday=0;


	if(document.getElementById("wceyear").value!="")
	{
		wceyear=parseInt(document.getElementById("wceyear").value);
	}
	if(document.getElementById("wcemonth").value!="")
	{
		wcemonth=parseInt(document.getElementById("wcemonth").value);
	}
	if(document.getElementById("wceday").value!="")
	{
		wceday=parseInt(document.getElementById("wceday").value);
	}
	var wcemaxservice=parseInt(document.getElementById("Min_quali_wce_service").value);	

	aws_year = parseInt(document.getElementById("aws_year").value);
	aws_month = parseInt(document.getElementById("aws_month").value);
	aws_day = parseInt(document.getElementById("aws_day").value);


	aws_day=parseInt(aws_day)-parseInt(wceday);
	aws_month=parseInt(aws_month)-parseInt(wcemonth);
	aws_year=parseInt(aws_year)-parseInt(wceyear);



	//alert("wceyear"+wceyear);
	if(aws_day<0)
	{
		aws_month=parseInt(aws_month)-1;
		aws_day=30+parseInt(aws_day);
	}		
	if(aws_month<0)
	{
		aws_year=parseInt(aws_year)-1;
		aws_month=12+parseInt(aws_month);
	}		

	document.getElementById("aws_year").value=aws_year;
	document.getElementById("aws_month").value=aws_month;
	document.getElementById("aws_day").value=aws_day;


	nqs_year=parseInt(document.getElementById("nqs_year").value);
	nqs_month=parseInt(document.getElementById("nqs_month").value);
	nqs_day=parseInt(document.getElementById("nqs_day").value);

	nqs_day=parseInt(nqs_day)-parseInt(wceday);
	nqs_month=parseInt(nqs_month)-parseInt(wcemonth);
	nqs_year=parseInt(nqs_year)-parseInt(wceyear);



	//alert("wceyear"+wceyear);
	if(nqs_day<0)
	{
		nqs_month=parseInt(nqs_month)-1;
		nqs_day=30+parseInt(nqs_day);
	}		
	if(nqs_month<0)
	{
		nqs_year=parseInt(nqs_year)-1;
		nqs_month=12+parseInt(nqs_month);
	}		


	//alert("nqsyear"+nqs_year+"-"+nqs_month+"-"+nqs_day);
	document.getElementById("nqs_year").value = nqs_year;
	document.getElementById("nqs_month").value = nqs_month;
	document.getElementById("nqs_day").value = nqs_day;


	document.getElementById("netq_yeardis").value = nqs_year;
	document.getElementById("netq_monthdis").value = nqs_month;
	document.getElementById("netq_daydis").value = nqs_day;


	document.getElementById("wcedislable").style.display="inline";
	document.getElementById("wceyeardis").style.display="inline";
	document.getElementById("wcemonthdis").style.display="inline";
	document.getElementById("wcedaydis").style.display="inline";

	document.getElementById("wce_yeardis").value=wceyear;
	document.getElementById("wce_monthdis").value=wcemonth;
	document.getElementById("wce_daydis").value=wceday;



}

//To find the contingent service
function calccontingent()
{
	var contingentyear=0;
	var contingentmonth=0;
	var contingentday=0;
	var contingentserviceyear=0;
	var contingentservicemonth=0;
	var contingentserviceday=0;

	if(document.getElementById("contingentyear").value!="")
	{
		contingentyear=parseInt(document.getElementById("contingentyear").value);
	}
	if(document.getElementById("contingentmonth").value!="")
	{
		contingentmonth=parseInt(document.getElementById("contingentmonth").value);
	}
	if(document.getElementById("contingentday").value!="")
	{
		contingentday=parseInt(document.getElementById("contingentday").value);
	}	
	if(contingentyear>0)
	{
		var contingentyrem=contingentyear%2;
		if(contingentyrem==0)
		{
			contingentserviceyear=contingentyear/2;
		}
		if(contingentyrem!=0)
		{
			contingentserviceyear=parseInt(contingentyear/2);
			contingentmonth=parseInt(contingentmonth)+(parseInt(contingentyrem)*12);
		}
	}
	if(contingentmonth>0)
	{
		var contingentmrem=contingentmonth%2;
		if(contingentmrem==0)
		{
			contingentservicemonth=contingentmonth/2;
		}
		if(contingentmrem!=0)
		{
			contingentservicemonth=parseInt(contingentmonth/2);
			var countday=parseInt(contingentmrem)*30;
			//contingentday=parseInt(contingentday)+parseInt(contingentmrem);
			contingentday=parseInt(contingentday)+parseInt(countday);
		}
	}

	if(contingentday>0)
	{
		var contingentdrem=contingentday%2;
		if(contingentdrem==0)
		{
			contingentserviceday=contingentday/2;
		}
		if(contingentdrem!=0)
		{
			contingentserviceday=parseInt(contingentday/2)+1;

		}
	}


	aws_year = parseInt(document.getElementById("aws_year").value);
	aws_month = parseInt(document.getElementById("aws_month").value);
	aws_day = parseInt(document.getElementById("aws_day").value);


	aws_day=parseInt(aws_day)-parseInt(contingentserviceday);
	aws_month=parseInt(aws_month)-parseInt(contingentservicemonth);
	aws_year=parseInt(aws_year)-parseInt(contingentserviceyear);



	if(aws_day<0)
	{
		aws_month=parseInt(aws_month)-1;
		aws_day=30+parseInt(aws_day);
	}		
	if(aws_month<0)
	{
		aws_year=parseInt(aws_year)-1;
		aws_month=12+parseInt(aws_month);
	}	


	document.getElementById("aws_year").value=aws_year;
	document.getElementById("aws_month").value=aws_month;
	document.getElementById("aws_day").value=aws_day;


	nqs_year = parseInt(document.getElementById("nqs_year").value);
	nqs_month = parseInt(document.getElementById("nqs_month").value);
	nqs_day = parseInt(document.getElementById("nqs_day").value);

	nqs_day=parseInt(nqs_day)-parseInt(contingentserviceday);
	nqs_month=parseInt(nqs_month)-parseInt(contingentservicemonth);
	nqs_year=parseInt(nqs_year)-parseInt(contingentserviceyear);



	//alert("wceyear"+wceyear);
	if(nqs_day<0)
	{
		nqs_month=parseInt(nqs_month)-1;
		nqs_day=30+parseInt(nqs_day);
	}		
	if(nqs_month<0)
	{
		nqs_year=parseInt(nqs_year)-1;
		nqs_month=12+parseInt(nqs_month);
	}		

	document.getElementById("nqs_year").value = nqs_year;
	document.getElementById("nqs_month").value = nqs_month;
	document.getElementById("nqs_day").value = nqs_day;


	document.getElementById("netq_yeardis").value = nqs_year;
	document.getElementById("netq_monthdis").value = nqs_month;
	document.getElementById("netq_daydis").value = nqs_day;


	document.getElementById("contingentdislable").style.display="inline";
	document.getElementById("contingentyeardis").style.display="inline";
	document.getElementById("contingentmonthdis").style.display="inline";
	document.getElementById("contingentdaydis").style.display="inline";

	document.getElementById("contingent_yeardis").value=contingentserviceyear;
	document.getElementById("contingent_monthdis").value=contingentservicemonth;
	document.getElementById("contingent_daydis").value=contingentserviceday;


}

// To find the Weightage for VRS Employee
function calcweightage()
{

	var vrs=document.getElementById("vrs_date").value;

	var weightage=document.getElementById("Weightage_max").value;

	var dateofjoin=document.getElementById("twadDateofJoin").value;

	var weightageyear=0;
	var weightagemonth=0;
	var weightageday=0;

	var leftoverserviceyear=0;
	var leftoverservicemonth=0;
	var leftoverserviceday=0;
	var leftoverservice=0;

	var actualserviceyear=0;
	var actualservicemonth=0;
	var actualserviceday=0;


	var penserviceyear=0;
	var penservicemonth=0;
	var penserviceday=0;


	var reqserviceyear=0;
	var reqservicemonth=0;
	var reqserviceday=0;


	/*var actdatesSep=vrs.split("/");
	var actdatesSep1=dateofjoin.split("/");		
	var acttdate=new Date(actdatesSep[2],actdatesSep[1]-1,actdatesSep[0]);
	var actfdate=new Date(actdatesSep1[2],actdatesSep1[1]-1,actdatesSep1[0]);
	var actdated=datediff(acttdate,actfdate);

	actualserviceyear=actdated[0];
	actualservicemonth=actdated[1];
	 */
	actualserviceyear=parseInt(document.getElementById("nqs_year").value);
	actualservicemonth=parseInt(document.getElementById("nqs_month").value);
	actualserviceday=parseInt(document.getElementById("nqs_day").value);

	//alert("actualserviceyear "+actualserviceyear + " actualservicemonth "+ actualservicemonth+ " actualserviceday "+actualserviceday);

	/*var actdateofjoinsession=document.getElementById("twadDateofJoinsession").value;
	if(actdateofjoinsession=="FN")
	{
		actualserviceday=actualserviceday+1;
	}


	 */

	//alert("actualserviceyear "+actualserviceyear + " actualservicemonth "+ actualservicemonth+ " actualserviceday "+actualserviceday);

	penserviceyear=Math.round((document.getElementById("Pension_half_yr_ceiling").value)/2);

	//alert("checking condition"+penserviceyear);

	//alert("actual"+ actualserviceyear+"-"+actualservicemonth+"-"+actualserviceday);

	if(actualserviceyear>=penserviceyear)
	{
		weightageyear=0;
		weightagemonth=0;
		weightageday=0;
		//alert("if actual"+ actualserviceyear+"-"+actualservicemonth+"-"+actualserviceday);
		document.getElementById("weigtdislable").style.display="none";
		document.getElementById("weigtyeardis").style.display="none";
		document.getElementById("weigtmonthdis").style.display="none";
		document.getElementById("weigtdaydis").style.display="none";	

		document.getElementById("weigt_yeardis").value="";
		document.getElementById("weigt_monthdis").value="";
		document.getElementById("weigt_daydis").value="";

	}
	else
	{
		//alert("checking condition");
		//alert("else  actual"+ actualserviceyear+"-"+actualservicemonth+"-"+actualserviceday);
		reqserviceyear=parseInt(penserviceyear)-parseInt(actualserviceyear);
		reqservicemonth=parseInt(penservicemonth)-parseInt(actualservicemonth);
		reqserviceday=parseInt(penserviceday)-parseInt(actualserviceday);

		//alert("reqserviceyear "+reqserviceyear + " reqservicemonth "+ reqservicemonth+ " reqserviceday "+reqserviceday)
//		alert("reqserviceday"+reqserviceday);
		if(parseInt(reqserviceday)<0)
		{
			reqservicemonth=parseInt(reqservicemonth)-1;
			reqserviceday=30+parseInt(reqserviceday);
			//alert("reqserviceday"+reqserviceday);
		}
		if(parseInt(reqservicemonth)<0)
		{
			reqserviceyear=parseInt(reqserviceyear)-1;
			reqservicemonth=12+parseInt(reqservicemonth);
		}
		if(reqserviceyear<=0)
		{
			reqserviceyear=0;
		}


		//	alert("reqserviceyear "+reqserviceyear + " reqservicemonth "+ reqservicemonth+ " reqserviceday "+reqserviceday);

		/* ****************************************************** */

		weightage=parseInt(document.getElementById("Weightage_max").value);

		weightageyear=weightage;

		var dateofret=document.getElementById("dar").value;
		var retdatesSep=dateofret.split("/");
		var retdatesSep1=vrs.split("/");

		var rettdate=new Date(retdatesSep[2],retdatesSep[1]-1,retdatesSep[0]);
		var retfdate=new Date(retdatesSep1[2],retdatesSep1[1]-1,retdatesSep1[0]);

		var datedleftover=datediff(rettdate,retfdate);


		leftoverserviceyear=datedleftover[0];
		leftoverservicemonth=datedleftover[1];
		leftoverserviceday=datedleftover[2];
		//	alert("leftoverservice"+ leftoverserviceyear+"-"+leftoverservicemonth+"-"+leftoverserviceday);
		if(leftoverserviceday>29)
		{
			var leftdaydiv=leftoverserviceday/30;
			var leftdayrem=leftoverserviceday%30;
			leftoverservicemonth=parseInt(leftoverservicemonth)+parseInt(leftdaydiv);
			leftoverserviceday=leftdayrem;
		}
		if(leftoverservicemonth>11)
		{
			var leftmondiv=leftoverserviceday/12;
			var leftmonrem=leftoverserviceday%12;
			leftoverserviceyear=parseInt(leftoverserviceyear)+parseInt(leftmondiv);
			leftoverservicemonth=leftmonrem;
		}

		if (leftoverserviceyear >= weightageyear)
		{
			leftoverservicceyear = weightageyear;
			leftoverservicemonth = 0;
			leftoverserviceday = 0;

		}


		if(reqserviceyear>leftoverserviceyear)
		{
			weightageyear=leftoverserviceyear;
			weightagemonth=leftoverservicemonth;
			weightageday=leftoverserviceday;
		}
		else if(reqserviceyear==leftoverserviceyear)
		{                   
			if(reqservicemonth>leftoverservicemonth)
			{
				weightageyear=leftoverserviceyear;
				weightagemonth=leftoverservicemonth;
				weightageday=leftoverserviceday;
			}
			else if(reqservicemonth==leftoverservicemonth)
			{
				if(reqserviceday>leftoverserviceday)
				{
					weightageyear=leftoverserviceyear;
					weightagemonth=leftoverservicemonth;
					weightageday=leftoverserviceday;
				}
				else
				{
					weightageyear=reqserviceyear;
					weightagemonth=reqservicemonth;
					weightageday=reqserviceday;
				}
			}
			else
			{
				weightageyear=reqserviceyear;
				weightagemonth=reqservicemonth;
				weightageday=reqserviceday;
			}
		}
		else
		{
			weightageyear=reqserviceyear;
			weightagemonth=reqservicemonth;
			weightageday=reqserviceday;
		}

          
		if (weightageyear>=5)
		{
		weightageyear=5;
		weightagemonth=0;
		weightageday=0;
		}
		
		document.getElementById("weigtdislable").style.display="inline";
		document.getElementById("weigtyeardis").style.display="inline";
		document.getElementById("weigtmonthdis").style.display="inline";
		document.getElementById("weigtdaydis").style.display="inline";	

		document.getElementById("weigt_yeardis").value=weightageyear;
		document.getElementById("weigt_monthdis").value=weightagemonth;
		document.getElementById("weigt_daydis").value=weightageday;

	}


	nqs_year = parseInt(document.getElementById("nqs_year").value);
	nqs_month = parseInt(document.getElementById("nqs_month").value);
	nqs_day = parseInt(document.getElementById("nqs_day").value);

	//alert("reqserviceyear "+weightageyear + "- "+ weightagemonth+ "- "+weightageday);
	//alert("nqs "+nqs_year + "- "+ nqs_month+ "- "+nqs_day);


	nqs_year= parseInt(weightageyear)+parseInt(nqs_year);
	nqs_month=parseInt(weightagemonth)+parseInt(nqs_month);
	nqs_day=parseInt(weightageday) +parseInt(nqs_day);
	//alert(nqs_year+nqs_month+nqs_day)



	if(nqs_day>29)
	{		
		nqs_dayremainer=nqs_day%30;
		nqs_daydivident=nqs_day/30;		
		nqs_month=parseInt(nqs_month)+parseInt(nqs_daydivident);
		//aws_month=parseInt(aws_month)+1;
		//alert(aws_month);
		nqs_day=nqs_dayremainer;
	}
	if(nqs_month>11)
	{		
		nqs_monthremainer=nqs_month%12;
		nqs_monthdivident=nqs_month/12;

		nqs_year=parseInt(nqs_year)+parseInt(nqs_monthdivident);
		//aws_year=parseInt(aws_year)+1;
		nqs_month=nqs_monthremainer;
		//alert(aws_monthremainer);
	}	

	document.getElementById("nqs_year").value=nqs_year;
	document.getElementById("nqs_month").value=nqs_month;
	document.getElementById("nqs_day").value=nqs_day;

	document.getElementById("netq_yeardis").value=nqs_year;
	document.getElementById("netq_monthdis").value=nqs_month;
	document.getElementById("netq_daydis").value=nqs_day;




}

// To find half year
function cal_number_of_half_year()
{
	//alert("here-------->");
	var halfyear=0;
	var vmonth=0;
	var vday=0;
	var othdeptyear=0;
	var othdeptmonth=0;
	var othdeptday=0;
	var othdepthalfflag=0;
	
	
	var nqs_year=parseInt(document.getElementById("nqs_year").value);
	var nqs_month=parseInt(document.getElementById("nqs_month").value);
	var nqs_day=parseInt(document.getElementById("nqs_day").value);
		
	var maxnumhalfyear=document.getElementById("Pension_half_yr_ceiling").value;
	var maxnumdcrghalfyear=document.getElementById("Dcrg_half_yr_celing").value;
	
	if(nqs_year!="" || nqs_month!="" || nqs_day!="")
	{
		//alert("Entered at "+count +"position");

		vday=parseInt(nqs_day);//10
		vmonth=parseInt(nqs_month);//4
		vyear=parseInt(nqs_year);//10
		
		
		
		if(vday>=30)
		{
			vmonth=vmonth+1;
			vday=vday-30;
		}
		

		if(vmonth>=12)
		{

			vyear=vyear+1;
			vmonth=vmonth-12;

		}
		halfyear=vyear*2;//62

		/*if(vday>=1)
		{
			vmonth=vmonth+1;
		}*/

		if(vmonth>9)
		{

			halfyear=halfyear+2;
		}
		else if ((vmonth==9) && (vday > 0))
		{

			halfyear=halfyear+2;
		}
		else if(vmonth>3)
		{

			halfyear=halfyear+1;
		}
		else if ((vmonth==3) && (vday > 0))
		{

			halfyear=halfyear+1;
		}
	}	

	
	document.getElementById("nohalf_year").value=halfyear;
	document.getElementById("nohalfyearpen").value=halfyear;
	document.getElementById("nohalfyeardcrg").value=halfyear;

	document.getElementById("nohalf_yeardis").value=halfyear;
	document.getElementById("nohalf_year_dcrg_dis").value=halfyear;
	if(parseInt(halfyear)>parseInt(maxnumhalfyear))
	{
		document.getElementById("nohalfyearpen").value=maxnumhalfyear;
		document.getElementById("nohalf_yeardis").value=maxnumhalfyear;
	}
	
	if(parseInt(halfyear)>parseInt(maxnumdcrghalfyear))
	{
		document.getElementById("nohalfyeardcrg").value=maxnumdcrghalfyear;
		document.getElementById("nohalf_year_dcrg_dis").value=maxnumdcrghalfyear;
	}
	
	//alert("Checking the value"+parseInt(document.getElementById("nohalfyearpen").value));

	if(parseInt(document.getElementById("nohalfyearpen").value)<60)
	{
		//alert("calling other department service...")
		addotherdeptserviceforpension();
				
	}

        
	
	

	//document.getElementById("nohalf_month").value=halfmonth;
	//document.getElementById("nohalf_day").value=halfday;
}


function addotherdeptserviceforpension()
{
	//alert('checking');
	var deptflag=document.getElementById("otherdeparmentserviceFlagYes").checked;
	if(deptflag==true)
	{
		
		var tqs_year=0;
		var tqs_month=0;
		var tqs_day=0;
		var othdeptyear=0;
		var othdeptmonth=0;
		var othdeptday=0;
		
		
		othdeptyear=parseInt(document.getElementById("tototdepyear1").value);
		othdeptmonth=parseInt(document.getElementById("tototdepmonth1").value);
		othdeptday=parseInt(document.getElementById("totothdeptday1").value);

		nqs_year=parseInt(document.getElementById("nqs_year").value);
		nqs_month=parseInt(document.getElementById("nqs_month").value);
		nqs_day=parseInt(document.getElementById("nqs_day").value);

		 
		 tqs_year=nqs_year+othdeptyear;
		 tqs_month=nqs_month+othdeptmonth;
		 tqs_day=nqs_day+othdeptday;	 
		 
		if(tqs_day>29)
		{
			tqs_dayremainer=tqs_day%30;
			tqs_daydivident=tqs_day/30;

			tqs_month=parseInt(tqs_month)+parseInt(tqs_daydivident);
			tqs_day=tqs_dayremainer;
		}
		if(tqs_month>11)
		{
			tqs_monthremainer=tqs_month%12;
			tqs_monthdivident=tqs_month/12;

			tqs_year=parseInt(tqs_year)+parseInt(tqs_monthdivident);
			tqs_month=tqs_monthremainer;
		}	
		// gopi changes start
		/*if(tqs_year>=30)
			{
			tqs_year=30;
			tqs_month=0;
			tqs_day=0;
			}*/
		//gopi changes end
		
		document.getElementById("nqs_year").value=tqs_year;
		document.getElementById("nqs_month").value=tqs_month;
		document.getElementById("nqs_day").value=tqs_day;
		
		document.getElementById("aws_year").value=tqs_year;
		document.getElementById("aws_month").value=tqs_month;
		document.getElementById("aws_day").value=tqs_day;
		
		document.getElementById("netq_yeardis").value=tqs_year;
		document.getElementById("netq_monthdis").value=tqs_month;
		document.getElementById("netq_daydis").value=tqs_day;
		
		
		var nqs_year=document.getElementById("nqs_year").value;
		var nqs_month=document.getElementById("nqs_month").value;
		var nqs_day=document.getElementById("nqs_day").value;	
		
		
		
		
		var halfyear=0;
		var vmonth=0;
		var vday=0;
		var maxnumhalfyear=document.getElementById("Pension_half_yr_ceiling").value;
		var maxnumdcrghalfyear=document.getElementById("Dcrg_half_yr_celing").value;
		if(nqs_year!="" || nqs_month!="" || nqs_day!="")
		{
			

			vday=parseInt(nqs_day);//10
			vmonth=parseInt(nqs_month)//4
			vyear=parseInt(nqs_year)//10
			if(vday>=30)
			{
				vmonth=vmonth+1;
				vday=vday-30;
			}
			

			if(vmonth>=12)
			{

				vyear=vyear+1;
				vmonth=vmonth-12;

			}
			halfyear=vyear*2;//62

			

			if(vmonth>9)
			{

				halfyear=halfyear+2;
			}
			else if ((vmonth==9) && (vday > 0))
			{

				halfyear=halfyear+2;
			}
			else if(vmonth>3)
			{

				halfyear=halfyear+1;
			}
			else if ((vmonth==3) && (vday > 0))
			{

				halfyear=halfyear+1;
			}
		}
	//	alert("max half--->"+maxnumdcrghalfyear);
//alert(halfyear);
		document.getElementById("nohalf_year").value=halfyear;
		document.getElementById("nohalfyearpen").value=halfyear;
		

		document.getElementById("nohalf_yeardis").value=halfyear;
		
		if(parseInt(halfyear)>parseInt(maxnumdcrghalfyear))
			halfyear=parseInt(maxnumdcrghalfyear);
		document.getElementById("nohalf_year_dcrg_dis").value=halfyear;
		document.getElementById("nohalfyeardcrg").value=halfyear;
		//alert(halfyear+">"+maxnumhalfyear);
		if(parseInt(halfyear)>parseInt(maxnumhalfyear))
		{
			document.getElementById("nohalfyearpen").value=maxnumhalfyear;
			document.getElementById("nohalf_yeardis").value=maxnumhalfyear;
		}
		
		/*if(parseInt(halfyear)>parseInt(maxnumdcrghalfyear))
		{
			document.getElementById("nohalfyeardcrg").value=maxnumdcrghalfyear;
			document.getElementById("nohalf_year_dcrg_dis").value=maxnumdcrghalfyear;
		}*/

		
		
	}


}



