var wind=null;
function loadPage(url)
{    
    document.location=url;
 }



function loadPageInNewWindow(url)
{  


  var dt=new Date();
  var st="";
  st=dt.getHours()+"_"+dt.getMinutes()+"_"+dt.getSeconds();
 wind=window.open(url,"winName","status=no,location=no,menubar=no,resizable=1,scrollbars=yes,titlebar=yes,toolbar=no");  
  wind.focus();
 
}


window.onunload=function()
{
if(window.confirm("Do You confirm to close?"))
{
        // alert('hai yes');
         window.frames[0].myclose();
         if (wind && wind.open && !wind.closed) wind.close();
         window.open('Logout.jsp',"_parent","status=no,location=no,menubar=no,resizable=1,scrollbars=yes,titlebar=yes,toolbar=no");  
         self.close();
         return true;
}
else{
       // alert('hai no');
       
         return false;
         /*
         window.frames[0].myclose();
         if (wind && wind.open && !wind.closed) wind.close();
         window.open('Logout.jsp',"_parent","status=no,location=no,menubar=no,resizable=1,scrollbars=yes,titlebar=yes,toolbar=no");  
         self.close();
         return true;
         */
}

}

