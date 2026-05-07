var wind=new Array();
var i=0;
function loadPage(url)
{    
    document.location=url;
   // alert('loadpage');
}

function loadPageInNewWindow(url)
{  
	
 var dt=new Date();
  var st="";
  st=dt.getHours()+"_"+dt.getMinutes()+"_"+dt.getSeconds();
 wind[i]=window.open(url,"winName"+st,"status=no,location=no,menubar=no,resizable=1,scrollbars=yes,titlebar=yes,toolbar=no");  
 wind[i].focus();
 i=i+1;
 //alert(i);
  
}


function loadPageInWindow(url)
{  
	alert("123-"+url);
 var dt=new Date();
  var st="";
  st=dt.getHours()+"_"+dt.getMinutes()+"_"+dt.getSeconds();
 wind[i]=window.open(url,"winName"+st,"status=no,location=no,menubar=no,resizable=1,scrollbars=yes,titlebar=yes,toolbar=no");  
 wind[i].focus();
 i=i+1;
 //alert(i);
  
}
/*
function highlite(div,url)
{
    alert("called");
    div.style.text-decoration="underline";
}

function dontHighlite(div)
{
    alert("hide");
    div.style.text-decoration="none";
}*/

/*
window.onunload=function()
{
alert('unload');
if (wind && wind.open && !wind.closed) wind.close();
}

*/

function myclose()
{
    //alert("opened Windows:"+i);
    var j=0;
    for(j=0;j<i;j++)
    {
        //alert(wind[j]);
        if (wind[j] && wind[j].open && !wind[j].closed) wind[j].close();
    }
}