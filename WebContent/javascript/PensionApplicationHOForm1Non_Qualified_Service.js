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


function datediff(date1, date2) {
	var y1 = date1.getFullYear(), m1 = date1.getMonth(), d1 = date1.getDate(),
	y2 = date2.getFullYear(), m2 = date2.getMonth(), d2 = date2.getDate();    
	if (d1 < d2) {
		m1--;
		d1 += DaysInMonth(y2, m2);        
	}
	if (m1 < m2) {
		y1--;
		m1 += 12;
	}
	return [y1 - y2, m1 - m2, d1 - d2];
}

/*
function dtval(d,e) {
	var pK = e ? e.which : window.event.keyCode;
	if (pK == 8) {d.value = substr(0,d.value.length-1); return;}
	var dt = d.value;
	var da = dt.split('/');
	for (var a = 0; a < da.length; a++) {if (da[a] != +da[a]) da[a] = da[a].substr(0,da[a].length-1);}
	if (da[0] > 31) {da[1] = da[0].substr(da[0].length-1,1);da[0] = '0'+da[0].substr(0,da[0].length-1);}
	if (da[1] > 12) {da[2] = da[1].substr(da[1].length-1,1);da[1] = '0'+da[1].substr(0,da[1].length-1);}
	if (da[2] > 9999) da[1] = da[2].substr(0,da[2].length-1);
	dt = da.join('/');
	if (dt.length == 2 || dt.length == 5) dt += '/';
	d.value = dt;
}
*/





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

		var diff =  Date.UTC(curyear,curmon,curday,0,0,0)
		- Date.UTC(calyear,calmon,calday,0,0,0);

		var dife = datediff(curd,cald);
		document.cir.val.value=dife[0]+" years, "+dife[1]+" months, and "+dife[2]+" days";

		var secleft = diff/1000/60;
		document.cir.val3.value=secleft+" minutes since your service";

		var hrsleft = secleft/60;
		document.cir.val2.value=hrsleft+" hours since your service";

		var daysleft = hrsleft/24;
		document.cir.val1.value=daysleft+" days since your service";	

		//alert(""+parseInt(calyear)+"--"+dife[0]+"--"+1);
		var as = parseInt(calyear)+dife[0]+1;

		var diff =  Date.UTC(as,calmon,calday,0,0,0)
		- Date.UTC(curyear,curmon,curday,0,0,0);
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




/*************************************Number only function start*******************************************/
/*function numberOnly(e,oBj)
{
	var keynum;
	var keychar;
	var numcheck;

	if(window.event) //IE
	{
		keynum=e.keyCode;
	}
	if(e.which) //Netscape/Firefox/Opera
	{
		keynum=e.which;
	}
	keychar=String.fromCharCode(keynum);
	var splCharCheck = /[a-zA-Z!@#$%&*()+-=|_'"`~:;<>?,\/\\\^\\{\}\[\]]/;

	return (!splCharCheck.test(keychar));
}



function numonly(e)
{
	var flag=true;
    var unicode=e.charCode? e.charCode : e.keyCode;

    if (unicode!=8)//backspace
    { 
    	//alert(unicode);  	
        if (unicode<45||unicode>57||unicode==47||unicode==45) 
        	flag=false ;
    }

    return flag;

}*/ 

function numonlywithoutdot(e)
{
	var flag=true;
	var unicode=e.charCode? e.charCode : e.keyCode;

	if (unicode!=8)//backspace
	{ 
		//alert(unicode);  	
		if (unicode<45||unicode>57||unicode==47||unicode==45 || unicode==46) 
			flag=false ;
	}

	return flag;

} 



/*************************************Number only function end**********************************************/


function calctotalnqs()
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

	aws_year=document.getElementById("aws_year").value;
	aws_month=document.getElementById("aws_month").value;
	aws_day=document.getElementById("aws_day").value;

	/*aws_year=parseInt(aws_year)+parseInt(fs_year);
	aws_month=parseInt(aws_month)+parseInt(fs_month);
	aws_day=parseInt(aws_day)+parseInt(fs_day);*/


	if(aws_day>29)
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
	}	



	var disflag=0;
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

	if(disflag==0)
	{
		document.getElementById("tqs_year").value=tqs_year;
		document.getElementById("tqs_month").value=tqs_month;
		document.getElementById("tqs_day").value=tqs_day;

		document.getElementById("nonq_yeardis").value=tqs_year;
		document.getElementById("nonq_monthdis").value=tqs_month;
		document.getElementById("nonq_daydis").value=tqs_day;

	}	

	// if(aws_year!="" && aws_month!="" && aws_day!="")
		//{		
	nqs_year=parseInt(aws_year)-parseInt(tqs_year);
	nqs_month=parseInt(aws_month)-parseInt(tqs_month);
	nqs_day=parseInt(aws_day)-parseInt(tqs_day);


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
		document.getElementById("nqs_year").value=nqs_year;
		document.getElementById("nqs_month").value=nqs_month;
		document.getElementById("nqs_day").value=nqs_day;

		document.getElementById("netq_yeardis").value=nqs_year;
		document.getElementById("netq_monthdis").value=nqs_month;
		document.getElementById("netq_daydis").value=nqs_day;
	}
// }


// ARUN START HERE

var classPenId=document.getElementById("classPensionId").value
aws_year1=document.getElementById("aws_yeardis").value;
aws_month1=document.getElementById("aws_monthdis").value;
aws_day1=document.getElementById("aws_daydis").value;

non_year1=document.getElementById("nonq_yeardis").value;
non_month1=document.getElementById("nonq_monthdis").value;
non_day1=document.getElementById("nonq_daydis").value;
//alert(non_month1);


cony=document.getElementById("contingent_yeardis").value
conm=document.getElementById("contingent_monthdis").value
cond=document.getElementById("contingent_daydis").value

if(aws_day1>29)
{		
	awsdayremainer=aws_day1%30;
	awsdaydivident=aws_day1/30;		
	aws_month1=parseInt(aws_month1)+parseInt(awsdaydivident);
	aws_day1=awsdayremainer;
}
if((parseInt(aws_day1))<(parseInt(non_day1)))
{
	aws_day1=parseInt(aws_day1)+30;
	aws_month1=aws_month1-1;
}
if((parseInt(aws_month1))<(parseInt(non_month1)))
{
	aws_month1=(parseInt(aws_month1)+12);
	aws_year1=(parseInt(aws_year1)-1);
}



/*if(aws_month1>11)
{		
	awsmonthremainer=aws_month1%12;
	awsmonthdivident=aws_month1/12;
	aws_year1=parseInt(aws_year1)+parseInt(awsmonthdivident);
	aws_month1=awsmonthremainer;
}*/

/*if((parseInt(non_year1)>0) || (parseInt(non_month1)>0) || (parseInt(non_day1)>0))
	{
		if(non_day1>aws_day1)
			{
			aws_day1=(parseInt(aws_day1)+30);
			aws_month1=aws_month1-1;
			}
		
		if(non_month1>aws_month1)
			{
			aws_month1=aws_month1+12;
			aws_year1=aws_year1-1;
			}
	}*/

tqsyear=(parseInt(aws_year1)-parseInt(non_year1));
tqsmonth=(parseInt(aws_month1)-parseInt(non_month1));
tqsday=(parseInt(aws_day1)-parseInt(non_day1));

if(cony>0 ||conm>0 || cond>0)
{
	var x=(parseInt(non_day1)+parseInt(cond));
	var y=(parseInt(non_month1)+parseInt(conm));
	var z=(parseInt(non_year1)+parseInt(cony));
      //alert("days"+x);
      //alert("month"+y);
      //alert("year"+z);
      //alert("aws_day1"+aws_day1)
      //alert("aws_month1"+aws_month1)
     // alert("aws_year1"+aws_year1)
      
		if(x>parseInt(aws_day1))
		{
			aws_day1=parseInt(aws_day1)+30;
			aws_month1=aws_month1-1;
		}
	
		//alert("checkmonth"+y);
		//alert("aws_month1"+aws_month1);
		
		
		if(y>parseInt(aws_month1))
		{
			aws_month1=aws_month1+12;
			aws_year1=parseInt(aws_year1)-1;
		}
	tqsyear=(parseInt(aws_year1)-z);
	tqsmonth=(parseInt(aws_month1)-y);
	tqsday=(parseInt(aws_day1)-x);
	//alert("nqs:"+tqsyear+"-"+tqsmonth+"-"+tqsday);
}

if(aws_day<tqsday)
{
	aws_day=parseInt(aws_day)+30;
	aws_month=parseInt(aws_month)-1;
}
if(aws_month<tqsmonth)
{
	aws_month=parseInt(aws_month)+12;
	aws_year=parseInt(aws_year)-1;
}
	document.getElementById("fs_yeardis").value=tqsyear;
	document.getElementById("fs_monthdis").value=tqsmonth;
	document.getElementById("fs_daydis").value=tqsday;
	//alert("Qualified Service year "+document.getElementById("fs_yeardis").value);
	//alert("Qualified Service month "+document.getElementById("fs_monthdis").value);
	//alert("Qualified Service day "+document.getElementById("fs_daydis").value);

var weightcaly;
var weightcalm;
var weightcald;

if(parseInt(tqsyear)<30)
{
		if(parseInt(classPenId)==2){
		a=30;
		b=0;
		c=0;

		if(c<tqsday)
		{
			c=c+30;
			b=b-1;
		}
		if(b<tqsmonth)
		{
			b=b+12;
			a=c-1;
		}
		
		weightcaly=a-(parseInt(tqsyear));
		weightcalm=b-parseInt(tqsmonth);
		weightcald=c-parseInt(tqsday);

		var flag=0;
		
		if(weightcaly>4)
		{
			weightcalm=0;
			weightcaly=5;
			weightcald=0;
			flag=1;
		}

		document.getElementById("weigt_yeardis").value=weightcaly;
		document.getElementById("weigt_monthdis").value=weightcalm;
		document.getElementById("weigt_daydis").value=weightcald;
	}
}

weighty=document.getElementById("weigt_yeardis").value;
weightm=document.getElementById("weigt_monthdis").value;
weightd=document.getElementById("weigt_daydis").value;



tscy=parseInt(tqsyear)+parseInt(weighty);
tscm=parseInt(tqsmonth)+parseInt(weightm);
tscd=parseInt(tqsday)+parseInt(weightd);


if(flag==1)
{
	tscy=30;
	tscm=0;
	tscd=0;
}
if(tscd>29)
{
	tscm=tscm+1;
	tscd=0;
	if((parseInt(tscm))>=11)
	{
		tscy=tscy+1;
		tscm=0;
	}
}
 //alert("TQS YEAR::"+tqsyear+"-"+tqsmonth+"-"+tqsday);

 //alert("nqs:"+tscy+"-"+tscm+"-"+tscd);
document.getElementById("netq_yeardis").value=tscy;
document.getElementById("netq_monthdis").value=tscm;
document.getElementById("netq_daydis").value=tscd;

document.getElementById("nqs_year").value=tscy;
document.getElementById("nqs_month").value=tscm;
document.getElementById("nqs_day").value=tscd;



if(flag==1)
{
	tscy=parseInt(tqsyear)+parseInt(weighty);
	tscm=parseInt(tqsmonth)+parseInt(weightm);
	tscd=parseInt(tqsday)+parseInt(weightd);

	document.getElementById("netq_yeardis").value=tscy;
	document.getElementById("netq_monthdis").value=tscm;
	document.getElementById("netq_daydis").value=tscd;

	document.getElementById("nqs_year").value=tscy;
	document.getElementById("nqs_month").value=tscm;
	document.getElementById("nqs_day").value=tscd;

}

//ARUN START END

cal_number_of_half_year();


}









function calcworkservice()
{

	var tt=document.getElementById("dar").value;
	var vrs=document.getElementById("vrs_date").value;
	var death=document.getElementById("death_date").value;		
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

	if(vrs!="")
	{


		tt=vrs;
		/* ****************************************************** */


		var actdatesSep=tt.split("/");
		var actdatesSep1=dateofjoin.split("/");		
		var acttdate=new Date(actdatesSep[2],actdatesSep[1]-1,actdatesSep[0]);
		var actfdate=new Date(actdatesSep1[2],actdatesSep1[1]-1,actdatesSep1[0]);
		//alert(actfdate);
		//alert(acttdate);
		var actdated=datediff(acttdate,actfdate);

		actualserviceyear=actdated[0];
		actualservicemonth=actdated[1];
		var actdateofjoinsession=document.getElementById("twadDateofJoinsession").value;
		if(actdateofjoinsession=="FN")
		{
			actualserviceday=actdated[2]+1;
			//actualserviceday=actdated[2];
		}
		if(actdateofjoinsession=="AN")
		{
			actualserviceday=actdated[2];
		}	

		/*alert("actualserviceyear="+actualserviceyear);
		alert("actualservicemonth="+actualservicemonth);
			alert("actualserviceday="+actualserviceday);*/

		penserviceyear=Math.round((document.getElementById("Pension_half_yr_ceiling").value)/2);
		//penserviceyear=document.getElementById("Pension_half_yr_ceiling").value;

		/*alert("penserviceyear="+penserviceyear);
			alert("penservicemonth="+penservicemonth);
			alert("penserviceday="+penserviceday);*/

		reqserviceyear=parseInt(penserviceyear)-parseInt(actualserviceyear);
		reqservicemonth=parseInt(penservicemonth)-parseInt(actualservicemonth);
		reqserviceday=parseInt(penserviceday)-parseInt(actualserviceday);

		/*alert("reqserviceyear="+reqserviceyear);
			alert("reqservicemonth="+reqservicemonth);
			alert("reqserviceday="+reqserviceday);*/
		if(parseInt(reqserviceday)<0)
		{

			reqservicemonth=parseInt(reqservicemonth)-1;
			reqserviceday=30+parseInt(reqserviceday);
			//alert(reqservicemonth);
			//alert(reqserviceday);
		}
		if(parseInt(reqservicemonth)<0)
		{
			reqserviceyear=parseInt(reqserviceyear)-1;
			reqservicemonth=12+parseInt(reqservicemonth);
			//alert(reqserviceyear);
			//alert(reqservicemonth);
		}
		if(reqserviceyear<=0)
		{
			reqserviceyear=0;
			//reqservicemonth=0;
			//reqserviceday=0;
		}
		/*  alert("reqserviceyear="+reqserviceyear);
		alert("reqservicemonth="+reqservicemonth);
			alert("reqserviceday="+reqserviceday);*/

		/* ****************************************************** */





		weightage=document.getElementById("Weightage_max").value;

		weightageyear=weightage;


		var dateofret=document.getElementById("dar").value;
		var retdatesSep=dateofret.split("/");
		var retdatesSep1=tt.split("/");

		var rettdate=new Date(retdatesSep[2],retdatesSep[1]-1,retdatesSep[0]);
		var retfdate=new Date(retdatesSep1[2],retdatesSep1[1]-1,retdatesSep1[0]);

		var datedleftover=datediff(rettdate,retfdate);


		leftoverserviceyear=datedleftover[0];
		leftoverservicemonth=datedleftover[1];
		leftoverserviceday=datedleftover[2];

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
		// alert("actualserviceyear=="+actualserviceyear+"penserviceyear:::"+penserviceyear);
		//alert(document.getElementById("nqs_year").value);
		//alert("weightageyear="+weightageyear+"weightagemonth="+weightagemonth+"weightageday="+weightageday);
		if(actualserviceyear>=penserviceyear)
		{
			weightageyear=0;
			weightagemonth=0;
			weightageday=0;
		}
		if(actualserviceyear<penserviceyear)
		{
			if(reqserviceyear>leftoverserviceyear)
			{
				/*  alert("leftoverserviceyear="+leftoverserviceyear);
				alert("leftoverservicemonth="+leftoverservicemonth);
                    alert("leftoverserviceday="+leftoverserviceday);*/
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
				/* 
				alert("reqserviceyear1="+reqserviceyear);
				alert("reqservicemonth1="+reqservicemonth);
                    alert("reqserviceday1="+reqserviceday);
                    alert("leftoverserviceyear1="+leftoverserviceyear);
                    alert("leftoverservicemonth1="+leftoverservicemonth);
                    alert("leftoverserviceday1="+leftoverserviceday); 
                    */

				weightageyear=reqserviceyear;
				weightagemonth=reqservicemonth;
				weightageday=reqserviceday;
			}
		}



		/*if(parseInt(leftoverserviceyear)<parseInt(weightageyear))
		{
                weightageyear=leftoverserviceyear;
                weightagemonth=leftoverservicemonth;
                weightageday=leftoverserviceday;
            }*/


		if(parseInt(weightageyear)<parseInt(weightage))
		{
			weightageyear=weightageyear;
			weightagemonth=weightagemonth;
			weightageday=weightageday;
		}
		else if((parseInt(weightagemonth)>0) || (parseInt(weightageday)>0))
		{
			weightageyear=weightageyear;
			weightagemonth=weightagemonth;
			weightageday=weightageday;
		}
		else
		{
			weightageyear=weightage;
			weightagemonth=0;
			weightageday=0;
		}


	}
	//alert("Before Append::"+weightageyear+"/"+weightagemonth+"/"+weightageday);

	document.getElementById("weigt_yeardis").value=weightageyear;
	document.getElementById("weigt_monthdis").value=weightagemonth;
	document.getElementById("weigt_daydis").value=weightageday;

	if(death!="")
	{			
		tt=death;			
	}
	var ff=document.getElementById("twadDateofJoin").value;


	if(tt!="" && ff!="")
	{
		var datesSep=tt.split("/");
		var datesSep1=ff.split("/");
		var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
		//var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
		//var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
		//alert(fdate);
		//alert(tdate);
		var dated=datediff(tdate,fdate);

		aws_year=dated[0];
		aws_month=dated[1];
		var dateofjoinsession=document.getElementById("twadDateofJoinsession").value;
		if(dateofjoinsession=="FN")
		{
			aws_day=dated[2]+1;
		}
		if(dateofjoinsession=="AN")
		{
			aws_day=dated[2];
		}

		aws_day=parseInt(aws_day)+parseInt(weightageday);
		aws_month=parseInt(aws_month)+parseInt(weightagemonth);
		aws_year=parseInt(aws_year)+parseInt(weightageyear);

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


		var dobdate=document.getElementById("dateofBirth").value;
		var dobdatett=dobdate.split("/");
		var dobdatet=new Date(dobdatett[2],dobdatett[1]-1,dobdatett[0]);
		var agedated=datediff(tdate,dobdatet);
		var ageday=0
		var age=0;
		if(agedated[2]>0)
		{
			ageday=agedated[2]+1;
		}	
		if(agedated[0]>0)
		{
			age=agedated[0];
		}		
		
		if((parseInt(ageday)>0) || parseInt(agedated[1])>0)
		{
			age=age+1;
		}	
		document.getElementById("age").value=age;

		document.getElementById("aws_year").value=aws_year;
		document.getElementById("aws_month").value=aws_month;
		document.getElementById("aws_day").value=aws_day;
		

		/*alert("actualserviceyear="+aws_year);
			alert("actualservicemonth="+aws_month);
			alert("actualserviceday="+aws_day);*/

		//document.getElementById("aws_year1").value=aws_year;
		//document.getElementById("aws_month1").value=aws_month;
		//document.getElementById("aws_day1").value=aws_day;

	}
	calctotalnqs();
}













function calcworkservice_dupli()
{		

	var tt=document.getElementById("dar").value;
	var vrs=document.getElementById("vrs_date").value;
	var death=document.getElementById("death_date").value;

	var weightage=document.getElementById("Weightage_max").value;



	/*var weightageyear=0;
	var weightagemonth=0;
	var weightageday=0;
	var leftoverserviceyear=0;
	var leftoverservicemonth=0;
	var leftoverserviceday=0;
	var leftoverservice=0;
	if(vrs!="")
	{
		tt=vrs;
		weightage=document.getElementById("Weightage_max").value;

		weightageyear=weightage;

		var dateofret=document.getElementById("dar").value;
		var retdatesSep=dateofret.split("/");
		var retdatesSep1=tt.split("/");
		//var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		//var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
		var rettdate=new Date(retdatesSep[2],retdatesSep[1],retdatesSep[0]);
		var retfdate=new Date(retdatesSep1[2],retdatesSep1[1],retdatesSep1[0]);
		var datedleftover=datediff(rettdate,retfdate);

		leftoverserviceyear=datedleftover[0];
		leftoverservicemonth=datedleftover[1];
		leftoverserviceday=datedleftover[2];

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
		if(parseInt(leftoverserviceyear)<parseInt(weightageyear))
		{
			weightageyear=leftoverserviceyear;
			weightagemonth=leftoverservicemonth;
			weightageday=leftoverserviceday;
		}

		document.getElementById("weigtdislable").style.display="inline";
		document.getElementById("weigtyeardis").style.display="inline";
		document.getElementById("weigtmonthdis").style.display="inline";
		document.getElementById("weigtdaydis").style.display="inline";	



		document.getElementById("weigt_yeardis").value=weightageyear;
		document.getElementById("weigt_monthdis").value=weightagemonth;
		document.getElementById("weigt_daydis").value=weightageday;


	}*/





	var tt=document.getElementById("dar").value;
	var vrs=document.getElementById("vrs_date").value;
	var death=document.getElementById("death_date").value;		

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

	if(vrs!="")
	{


		tt=vrs;
		/* ****************************************************** */


		var actdatesSep=tt.split("/");
		var actdatesSep1=dateofjoin.split("/");		
		var acttdate=new Date(actdatesSep[2],actdatesSep[1]-1,actdatesSep[0]);
		var actfdate=new Date(actdatesSep1[2],actdatesSep1[1]-1,actdatesSep1[0]);
		var actdated=datediff(acttdate,actfdate);

		actualserviceyear=actdated[0];
		actualservicemonth=actdated[1];
		var actdateofjoinsession=document.getElementById("twadDateofJoinsession").value;
		if(actdateofjoinsession=="FN")
		{
			actualserviceday=actdated[2]+1;
		}
		if(actdateofjoinsession=="AN")
		{
			actualserviceday=actdated[2];
		}	

		/* alert("actualserviceyear="+actualserviceyear);
		alert("actualservicemonth="+actualservicemonth);
		alert("actualserviceday="+actualserviceday);*/

		penserviceyear=Math.round((document.getElementById("Pension_half_yr_ceiling").value)/2);
		//penserviceyear=document.getElementById("Pension_half_yr_ceiling").value;

		/*alert("penserviceyear="+penserviceyear);
		alert("penservicemonth="+penservicemonth);
		alert("penserviceday="+penserviceday);*/

		reqserviceyear=parseInt(penserviceyear)-parseInt(actualserviceyear);
		reqservicemonth=parseInt(penservicemonth)-parseInt(actualservicemonth);
		reqserviceday=parseInt(penserviceday)-parseInt(actualserviceday);


		if(parseInt(reqserviceday)<0)
		{
			reqservicemonth=parseInt(reqservicemonth)-1;
			reqserviceday=30+parseInt(reqserviceday);
		}
		if(parseInt(reqservicemonth)<0)
		{
			reqserviceyear=parseInt(reqserviceyear)-1;
			reqservicemonth=12+parseInt(reqservicemonth);
		}
		if(reqserviceyear<=0)
		{
			reqserviceyear=0;
			//reqservicemonth=0;
			//reqserviceday=0;
		}
		/*alert("reqserviceyear="+reqserviceyear);
		alert("reqservicemonth="+reqservicemonth);
		alert("reqserviceday="+reqserviceday);*/

		/* ****************************************************** */





		weightage=document.getElementById("Weightage_max").value;

		weightageyear=weightage;


		var dateofret=document.getElementById("dar").value;
		var retdatesSep=dateofret.split("/");
		var retdatesSep1=tt.split("/");

		var rettdate=new Date(retdatesSep[2],retdatesSep[1]-1,retdatesSep[0]);
		var retfdate=new Date(retdatesSep1[2],retdatesSep1[1]-1,retdatesSep1[0]);

		var datedleftover=datediff(rettdate,retfdate);


		leftoverserviceyear=datedleftover[0];
		leftoverservicemonth=datedleftover[1];
		leftoverserviceday=datedleftover[2];

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
		/*alert("leftoverserviceyear="+leftoverserviceyear);
		alert("lefoverservicemonth="+leftoverservicemonth);
		alert("lefoverserviceday="+leftoverserviceday);*/	


		if(actualserviceyear>=penserviceyear)
		{
			weightageyear=0;
			weightagemonth=0;
			weightageday=0;
		}
		if(actualserviceyear<penserviceyear)
		{
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
		}





		if(parseInt(weightageyear)<parseInt(weightage))
		{
			weightageyear=weightageyear;
			weightagemonth=weightagemonth;
			weightageday=weightageday;
		}
		else
		{
			weightageyear=weightage;
			weightagemonth=0;
			weightageday=0;
		}

		/*alert("weightageyear="+weightageyear);
		alert("weightagemonth="+weightagemonth);
		alert("weightageday="+weightageday);*/	


		document.getElementById("weigtdislable").style.display="inline";
		document.getElementById("weigtyeardis").style.display="inline";
		document.getElementById("weigtmonthdis").style.display="inline";
		document.getElementById("weigtdaydis").style.display="inline";	



		document.getElementById("weigt_yeardis").value=weightageyear;
		document.getElementById("weigt_monthdis").value=weightagemonth;
		document.getElementById("weigt_daydis").value=weightageday;

	}





	if(death!="")
	{		
		tt=death;			
	}
	var ff=document.getElementById("twadDateofJoin").value;


	if(tt!="" && ff!="")
	{
		var datesSep=tt.split("/");
		var datesSep1=ff.split("/");
		var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
		//var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
		//var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
		var dated=datediff(tdate,fdate);

		aws_year=dated[0];
		aws_month=dated[1];
		//alert("tdate"+tdate+"fdate"+fdate+"dated[0]"+dated[0]+"dated[1]"+dated[1]);
		var dateofjoinsession=document.getElementById("twadDateofJoinsession").value;
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



		var dobdate=document.getElementById("dateofBirth").value;
		var dobdatett=dobdate.split("/");
		var dobdatet=new Date(dobdatett[2],dobdatett[1]-1,dobdatett[0]);
		var agedated=datediff(tdate,dobdatet);
		var ageday=0,age=0;
		if(agedated[2]>0)
		{
			ageday=agedated[2]+1;
		}		
		if(agedated[0]>0)
		{
			age=agedated[0];
		}		
		if((parseInt(ageday)>0) || parseInt(agedated[1])>0)
		{
			age=age+1;
		}			
		document.getElementById("age").value=age;



		document.getElementById("aws_yeardis").value=aws_year;
		document.getElementById("aws_monthdis").value=aws_month;
		document.getElementById("aws_daydis").value=aws_day;

		aws_day=parseInt(aws_day)+parseInt(weightageday);
		aws_month=parseInt(aws_month)+parseInt(weightagemonth);
		aws_year=parseInt(aws_year)+parseInt(weightageyear);

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


		document.getElementById("aws_year1").value=aws_year;
		document.getElementById("aws_month1").value=aws_month;
		document.getElementById("aws_day1").value=aws_day;




	}
}










/* ************************** OLD WORK SERVICE CALCUATION WITH WEIGHTAGE START ********************************** */
/*function calcworkservice_dupli()
{		

	var tt=document.getElementById("dar").value;
	var vrs=document.getElementById("vrs_date").value;
	var death=document.getElementById("death_date").value;

	var weightage=document.getElementById("Weightage_max").value;



	var weightageyear=0;
	var weightagemonth=0;
	var weightageday=0;
	var leftoverserviceyear=0;
	var leftoverservicemonth=0;
	var leftoverserviceday=0;
	var leftoverservice=0;
	if(vrs!="")
	{
		tt=vrs;
		weightage=document.getElementById("Weightage_max").value;

		weightageyear=weightage;

		var dateofret=document.getElementById("dar").value;
		var retdatesSep=dateofret.split("/");
		var retdatesSep1=tt.split("/");
		//var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		//var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
		var rettdate=new Date(retdatesSep[2],retdatesSep[1],retdatesSep[0]);
		var retfdate=new Date(retdatesSep1[2],retdatesSep1[1],retdatesSep1[0]);
		var datedleftover=datediff(rettdate,retfdate);

		leftoverserviceyear=datedleftover[0];
		leftoverservicemonth=datedleftover[1];
		leftoverserviceday=datedleftover[2];

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
		if(parseInt(leftoverserviceyear)<parseInt(weightageyear))
		{
			weightageyear=leftoverserviceyear;
			weightagemonth=leftoverservicemonth;
			weightageday=leftoverserviceday;
		}

		document.getElementById("weigtdislable").style.display="inline";
		document.getElementById("weigtyeardis").style.display="inline";
		document.getElementById("weigtmonthdis").style.display="inline";
		document.getElementById("weigtdaydis").style.display="inline";	



		document.getElementById("weigt_yeardis").value=weightageyear;
		document.getElementById("weigt_monthdis").value=weightagemonth;
		document.getElementById("weigt_daydis").value=weightageday;


	}
	if(death!="")
	{		
		tt=death;			
	}
	var ff=document.getElementById("twadDateofJoin").value;


	if(tt!="" && ff!="")
	{
		var datesSep=tt.split("/");
		var datesSep1=ff.split("/");
		//var tdate=new Date(datesSep[2],datesSep[1]-1,datesSep[0]);
		//var fdate=new Date(datesSep1[2],datesSep1[1]-1,datesSep1[0]);
		var tdate=new Date(datesSep[2],datesSep[1],datesSep[0]);
		var fdate=new Date(datesSep1[2],datesSep1[1],datesSep1[0]);
		var dated=datediff(tdate,fdate);

		aws_year=dated[0];
		aws_month=dated[1];
		var dateofjoinsession=document.getElementById("twadDateofJoinsession").value;
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

		document.getElementById("aws_yeardis").value=aws_year;
		document.getElementById("aws_monthdis").value=aws_month;
		document.getElementById("aws_daydis").value=aws_day;

		aws_day=parseInt(aws_day)+parseInt(weightageday);
		aws_month=parseInt(aws_month)+parseInt(weightagemonth);
		aws_year=parseInt(aws_year)+parseInt(weightageyear);

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


		document.getElementById("aws_year1").value=aws_year;
		document.getElementById("aws_month1").value=aws_month;
		document.getElementById("aws_day1").value=aws_day;




	}
}
 */

/* ************************** OLD WORK SERVICE CALCUATION WITH WEIGHTAGE END ********************************** */


function cal_other_tot_net_qualified_service()
{

	if(document.getElementById("contingentserviceFlagYes").checked==true)
	{	

		var actualservice=contingent_return_value();

		var actualserviceyear=actualservice[0];
		var actualservicemonth=actualservice[1];
		var actualserviceday=actualservice[2];	

		var aws_year=parseInt(actualserviceyear);
		var aws_month=parseInt(actualservicemonth);
		var aws_day=parseInt(actualserviceday);

	}
	else
	{
		var aws_year=parseInt(document.getElementById("aws_year1").value);
		var aws_month=parseInt(document.getElementById("aws_month1").value);
		var aws_day=parseInt(document.getElementById("aws_day1").value);
	}

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

	if(document.getElementById("wcecountedFlagNo").checked==true)
	{	

		aws_day=parseInt(aws_day)-parseInt(wceday);
		aws_month=parseInt(aws_month)-parseInt(wcemonth);
		aws_year=parseInt(aws_year)-parseInt(wceyear);
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
	}
	/*if(document.getElementById("wcecountedFlagYes").checked==true)
	{
		aws_day=parseInt(aws_day)+parseInt(wceday);
		aws_month=parseInt(aws_month)+parseInt(wcemonth);
		aws_year=parseInt(aws_year)+parseInt(wceyear);
		if(aws_day>29)
		{
			var aws_dayrem=aws_day%30;
			aws_day=aws_dayrem;
			aws_month=parseInt(aws_month)+1;
		}		
		if(aws_month>11)
		{

			var aws_monrem=aws_month%12;
			aws_month=aws_monrem;
			aws_year=parseInt(aws_year)+1;			
		}		
	}*/
	document.getElementById("aws_year").value=aws_year;
	document.getElementById("aws_month").value=aws_month;
	document.getElementById("aws_day").value=aws_day;
	calctotalnqs();



	if((document.getElementById("wcecountedFlagNo").checked==true) && (document.getElementById("wceserviceFlagYes").checked==true))
	{
		document.getElementById("wcedislable").style.display="inline";
		document.getElementById("wceyeardis").style.display="inline";
		document.getElementById("wcemonthdis").style.display="inline";
		document.getElementById("wcedaydis").style.display="inline";

		document.getElementById("wce_yeardis").value=wceyear;
		document.getElementById("wce_monthdis").value=wcemonth;
		document.getElementById("wce_daydis").value=wceday;

		/*document.getElementById("serdislable").style.display="inline";
		document.getElementById("seryeardis").style.display="inline";
		document.getElementById("sermonthdis").style.display="inline";
		document.getElementById("serdaydis").style.display="inline";


		var aws_yeardis=parseInt(document.getElementById("aws_year1").value);
		var aws_monthdis=parseInt(document.getElementById("aws_month1").value);
		var aws_daydis=parseInt(document.getElementById("aws_day1").value);

		document.getElementById("aws_yeardis").value=aws_yeardis;
		document.getElementById("aws_monthdis").value=aws_monthdis;
		document.getElementById("aws_daydis").value=aws_daydis;


		document.getElementById("nonqdislable").style.display="inline";
		document.getElementById("nonqyeardis").style.display="inline";
		document.getElementById("nonqmonthdis").style.display="inline";
		document.getElementById("nonqdaydis").style.display="inline";


		var tqs_yeardis=document.getElementById("tqs_year").value;
		var tqs_monthdis=document.getElementById("tqs_month").value;
		var tqs_daydis=document.getElementById("tqs_day").value;

		document.getElementById("nonq_yeardis").value=tqs_yeardis;
		document.getElementById("nonq_monthdis").value=tqs_monthdis;
		document.getElementById("nonq_daydis").value=tqs_daydis;




		document.getElementById("fsdislable").style.display="inline";
		document.getElementById("fsyeardis").style.display="inline";
		document.getElementById("fsmonthdis").style.display="inline";
		document.getElementById("fsdaydis").style.display="inline";


		var fs_yeardis=document.getElementById("fs_year").value;
		var fs_monthdis=document.getElementById("fs_month").value;
		var fs_daydis=document.getElementById("fs_day").value;

		document.getElementById("fs_yeardis").value=fs_yeardis;
		document.getElementById("fs_monthdis").value=fs_monthdis;
		document.getElementById("fs_daydis").value=fs_daydis;


		document.getElementById("netqdislable").style.display="inline";
		document.getElementById("netqyeardis").style.display="inline";
		document.getElementById("netqmonthdis").style.display="inline";
		document.getElementById("netqdaydis").style.display="inline";


		var netq_yeardis=document.getElementById("nqs_year").value;
		var netq_monthdis=document.getElementById("nqs_month").value;
		var netq_daydis=document.getElementById("nqs_day").value;

		document.getElementById("netq_yeardis").value=netq_yeardis;
		document.getElementById("netq_monthdis").value=netq_monthdis;
		document.getElementById("netq_daydis").value=netq_daydis;*/



	}	
	if((document.getElementById("wcecountedFlagYes").checked==true) || (document.getElementById("wceserviceFlagNo").checked==true))
	{
		document.getElementById("wcedislable").style.display="none";
		document.getElementById("wceyeardis").style.display="none";
		document.getElementById("wcemonthdis").style.display="none";
		document.getElementById("wcedaydis").style.display="none";

		document.getElementById("wce_yeardis").value="";
		document.getElementById("wce_monthdis").value="";
		document.getElementById("wce_daydis").value="";


		/*document.getElementById("serdislable").style.display="none";
		document.getElementById("seryeardis").style.display="none";
		document.getElementById("sermonthdis").style.display="none";
		document.getElementById("serdaydis").style.display="none";			

		document.getElementById("aws_yeardis").value="";
		document.getElementById("aws_monthdis").value="";
		document.getElementById("aws_daydis").value="";


		document.getElementById("nonqdislable").style.display="none";
		document.getElementById("nonqyeardis").style.display="none";
		document.getElementById("nonqmonthdis").style.display="none";
		document.getElementById("nonqdaydis").style.display="none";			


		document.getElementById("nonq_yeardis").value="";
		document.getElementById("nonq_monthdis").value="";
		document.getElementById("nonq_daydis").value="";


		document.getElementById("fsdislable").style.display="none";
		document.getElementById("fsyeardis").style.display="none";
		document.getElementById("fsmonthdis").style.display="none";
		document.getElementById("fsdaydis").style.display="none";		



		document.getElementById("fs_yeardis").value="";
		document.getElementById("fs_monthdis").value="";
		document.getElementById("fs_daydis").value="";



		document.getElementById("netqdislable").style.display="none";
		document.getElementById("netqyeardis").style.display="none";
		document.getElementById("netqmonthdis").style.display="none";
		document.getElementById("netqdaydis").style.display="none";		



		document.getElementById("netq_yeardis").value="";
		document.getElementById("netq_monthdis").value="";
		document.getElementById("netq_daydis").value="";*/


	}	

}



function cal_other_tot_cont_net_qualified_service()
{
	/*var aws_year=parseInt(document.getElementById("aws_year1").value);
	var aws_month=parseInt(document.getElementById("aws_month1").value);
	var aws_day=parseInt(document.getElementById("aws_day1").value);*/

	var actualservice=wce_return_value();

	var actualserviceyear=actualservice[0];
	var actualservicemonth=actualservice[1];
	var actualserviceday=actualservice[2];	

	if(actualserviceyear==0 && actualservicemonth==0 && actualserviceday==0)
	{
		var aws_year=parseInt(document.getElementById("aws_year1").value);
		var aws_month=parseInt(document.getElementById("aws_month1").value);
		var aws_day=parseInt(document.getElementById("aws_day1").value);
	}
	else
	{
		var aws_year=parseInt(actualserviceyear);
		var aws_month=parseInt(actualservicemonth);
		var aws_day=parseInt(actualserviceday);
	}

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
			
			contingentserviceyear=parseInt((contingentyear-1)/2);
			contingentmonth=parseInt(contingentmonth+12);
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
			contingentservicemonth=parseInt((contingentmonth-1)/2);
			//var countday=parseInt(contingentmrem)*30;
			//contingentday=parseInt(contingentday)+parseInt(contingentmrem);
			contingentday=parseInt(contingentday)+ 30;
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

	if(document.getElementById("contingentserviceFlagYes").checked==true)
	{
		/*aws_day=parseInt(aws_day)+parseInt(contingentserviceday);
		aws_month=parseInt(aws_month)+parseInt(contingentservicemonth);
		aws_year=parseInt(aws_year)+parseInt(contingentserviceyear);	



		if(aws_day>29)
		{
			var aws_dayrem=aws_day%30;
			aws_day=aws_dayrem;
			aws_month=parseInt(aws_month)+1;
		}		
		if(aws_month>11)
		{			
			var aws_monrem=aws_month%12;
			aws_month=aws_monrem;
			aws_year=parseInt(aws_year)+1;			
		}
		*/

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

		/*alert("aws_day="+aws_day);
		alert("aws_month="+aws_month);
		alert("aws_year="+aws_year);*/


		document.getElementById("contingentdislable").style.display="inline";
		document.getElementById("contingentyeardis").style.display="inline";
		document.getElementById("contingentmonthdis").style.display="inline";
		document.getElementById("contingentdaydis").style.display="inline";

		document.getElementById("contingent_yeardis").value=contingentserviceyear;
		document.getElementById("contingent_monthdis").value=contingentservicemonth;
		document.getElementById("contingent_daydis").value=contingentserviceday;



		/*document.getElementById("serdislable").style.display="inline";
		document.getElementById("seryeardis").style.display="inline";
		document.getElementById("sermonthdis").style.display="inline";
		document.getElementById("serdaydis").style.display="inline";


		var aws_yeardis=parseInt(document.getElementById("aws_year1").value);
		var aws_monthdis=parseInt(document.getElementById("aws_month1").value);
		var aws_daydis=parseInt(document.getElementById("aws_day1").value);

		document.getElementById("aws_yeardis").value=aws_yeardis;
		document.getElementById("aws_monthdis").value=aws_monthdis;
		document.getElementById("aws_daydis").value=aws_daydis;


		document.getElementById("nonqdislable").style.display="inline";
		document.getElementById("nonqyeardis").style.display="inline";
		document.getElementById("nonqmonthdis").style.display="inline";
		document.getElementById("nonqdaydis").style.display="inline";


		var tqs_yeardis=document.getElementById("tqs_year").value;
		var tqs_monthdis=document.getElementById("tqs_month").value;
		var tqs_daydis=document.getElementById("tqs_day").value;

		document.getElementById("nonq_yeardis").value=tqs_yeardis;
		document.getElementById("nonq_monthdis").value=tqs_monthdis;
		document.getElementById("nonq_daydis").value=tqs_daydis;


		document.getElementById("fsdislable").style.display="inline";
		document.getElementById("fsyeardis").style.display="inline";
		document.getElementById("fsmonthdis").style.display="inline";
		document.getElementById("fsdaydis").style.display="inline";


		var fs_yeardis=document.getElementById("fs_year").value;
		var fs_monthdis=document.getElementById("fs_month").value;
		var fs_daydis=document.getElementById("fs_day").value;

		document.getElementById("fs_yeardis").value=fs_yeardis;
		document.getElementById("fs_monthdis").value=fs_monthdis;
		document.getElementById("fs_daydis").value=fs_daydis;


		document.getElementById("netqdislable").style.display="inline";
		document.getElementById("netqyeardis").style.display="inline";
		document.getElementById("netqmonthdis").style.display="inline";
		document.getElementById("netqdaydis").style.display="inline";


		var netq_yeardis=document.getElementById("nqs_year").value;
		var netq_monthdis=document.getElementById("nqs_month").value;
		var netq_daydis=document.getElementById("nqs_day").value;

		document.getElementById("netq_yeardis").value=netq_yeardis;
		document.getElementById("netq_monthdis").value=netq_monthdis;
		document.getElementById("netq_daydis").value=netq_daydis;*/



	}
	if(document.getElementById("contingentserviceFlagNo").checked==true)
	{
		document.getElementById("contingentdislable").style.display="none";
		document.getElementById("contingentyeardis").style.display="none";
		document.getElementById("contingentmonthdis").style.display="none";
		document.getElementById("contingentdaydis").style.display="none";

		document.getElementById("contingent_yeardis").value="";
		document.getElementById("contingent_monthdis").value="";
		document.getElementById("contingent_daydis").value="";



		/*document.getElementById("serdislable").style.display="none";
		document.getElementById("seryeardis").style.display="none";
		document.getElementById("sermonthdis").style.display="none";
		document.getElementById("serdaydis").style.display="none";		


		document.getElementById("aws_yeardis").value="";
		document.getElementById("aws_monthdis").value="";
		document.getElementById("aws_daydis").value="";



		document.getElementById("nonqdislable").style.display="none";
		document.getElementById("nonqyeardis").style.display="none";
		document.getElementById("nonqmonthdis").style.display="none";
		document.getElementById("nonqdaydis").style.display="none";



		document.getElementById("nonq_yeardis").value="";
		document.getElementById("nonq_monthdis").value="";
		document.getElementById("nonq_daydis").value="";


		document.getElementById("netqdislable").style.display="none";
		document.getElementById("netqyeardis").style.display="none";
		document.getElementById("netqmonthdis").style.display="none";
		document.getElementById("netqdaydis").style.display="none";	



		document.getElementById("netq_yeardis").value="";
		document.getElementById("netq_monthdis").value="";
		document.getElementById("netq_daydis").value="";*/



	}
	document.getElementById("aws_year").value=aws_year;
	document.getElementById("aws_month").value=aws_month;
	document.getElementById("aws_day").value=aws_day;

	calctotalnqs();

}







function wce_return_value()
{

	var aws_year=parseInt(document.getElementById("aws_year1").value);
	var aws_month=parseInt(document.getElementById("aws_month1").value);
	var aws_day=parseInt(document.getElementById("aws_day1").value);

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

	if(document.getElementById("wcecountedFlagNo").checked==true)
	{	

		aws_day=parseInt(aws_day)-parseInt(wceday);
		aws_month=parseInt(aws_month)-parseInt(wcemonth);
		aws_year=parseInt(aws_year)-parseInt(wceyear);
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
	}
	/*if(document.getElementById("wcecountedFlagYes").checked==true)
	{
			aws_day=parseInt(aws_day)+parseInt(wceday);
			aws_month=parseInt(aws_month)+parseInt(wcemonth);
			aws_year=parseInt(aws_year)+parseInt(wceyear);
			if(aws_day>29)
			{
				var aws_dayrem=aws_day%30;
				aws_day=aws_dayrem;
				aws_month=parseInt(aws_month)+1;
			}		
			if(aws_month>11)
			{

				var aws_monrem=aws_month%12;
				aws_month=aws_monrem;
				aws_year=parseInt(aws_year)+1;			
			}		
		}*/

	return [aws_year, aws_month, aws_day];	
}


function contingent_return_value()
{
	var aws_year=parseInt(document.getElementById("aws_year1").value);
	var aws_month=parseInt(document.getElementById("aws_month1").value);
	var aws_day=parseInt(document.getElementById("aws_day1").value);
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
			contingentserviceday=parseInt(contingentday/2);

		}

	}

	if(document.getElementById("contingentserviceFlagYes").checked==true)
	{
		/*aws_day=parseInt(aws_day)+parseInt(contingentserviceday);
		aws_month=parseInt(aws_month)+parseInt(contingentservicemonth);
		aws_year=parseInt(aws_year)+parseInt(contingentserviceyear);
		if(aws_day>29)
		{
			var aws_dayrem=aws_day%30;
			aws_day=aws_dayrem;
			aws_month=parseInt(aws_month)+1;
		}		
		if(aws_month>11)
		{			
			var aws_monrem=aws_month%12;
			aws_month=aws_monrem;
			aws_year=parseInt(aws_year)+1;			
		}*/


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


	}	
	/*document.getElementById("aws_year").value=aws_year;
	document.getElementById("aws_month").value=aws_month;
	document.getElementById("aws_day").value=aws_day;*/

	return [aws_year, aws_month, aws_day];
}


function cal_number_of_half_year()
{
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
		if(vday>=1)
		{
			vmonth=vmonth+1;
		}
		if(vmonth>9)
		{
			halfyear=halfyear+2;
		}
		else if(vmonth>3)
		{
			halfyear=halfyear+1;
		}


		/*halfyear=parseInt(nqs_year)*2;
		halfmonth=parseInt(nqs_month)*2;
		halfday=parseInt(nqs_day)*2;
		if(halfday>29)
		{
			halfmonth=parseInt(halfmonth)+1;
		}
		if((halfmonth>3) && (halfmonth<9))
		{
			halfyear=parseInt(halfyear)+1;
		}
		else if((halfmonth>=9))
		{
			halfyear=parseInt(halfyear)+2;
		}*/
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


	//document.getElementById("nohalf_month").value=halfmonth;
	//document.getElementById("nohalf_day").value=halfday;
}

