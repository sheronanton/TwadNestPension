//alert('hai com js');
var __pagination=5;
//********************  Year Constant Range *****************************
var _Service_Period_Beg_Year=1966;

/*function mouseclick()
{
   if(event.button==2)
   {
     alert('Premission denied to right click');
        return false;
    }
}
window.onmousedown=mouseclick;
window.onmouseclick=mouseclick;
document.onmousedown=mouseclick;
document.onmouseclick=mouseclick;
*/

//***********************disable the right mouse click*****************************

//for temporary purpose it has been commented

var message="Permission denied to right click";

function clickIE4(){
if (event.button==2){
alert(message);
return false;
}
}

function clickNS4(e){
if (document.layers||document.getElementById&&!document.all){
if (e.which==2||e.which==3){
alert(message);
return false;
}
}
}


//upto these

if (document.layers){
document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS4;
}
else if (document.all&&!document.getElementById){
document.onmousedown=clickIE4;
}

document.oncontextmenu=new Function("alert(message);return false")
//***********************************************************************************

//****************************disable the content copy**********************
/*function onKeyDown(event) {
  // current pressed key
  var unicode=event.charCode? event.charCode : event.keyCode;
  var pressedKey = String.fromCharCode(unicode).toLowerCase();

  if (event.ctrlKey && (unicode == 67 || unicode == 99)) 
  {
    
    // disable key press porcessing
    alert("Permission denied to copy the content");
    typeof event.which == 'undefined' ? event.keyCode == 0 : event.which == 0;

    event.returnValue = false;
    
    //return false;
  }

} 

*/
//********************************************************************************
//*********************  change the cursor *************************************8
function mousewait()
{

    alert('please wait......');
    return false;
    //status="please wait...";
}
function mousewait1()
{

    status= 'please wait......';
    return false;
    //status="please wait...";
}

function startwaiting(frm)
{
    //alert(frm.elements);
    // if( frm.elements!=null)
     {
        
        for(i=0;i<frm.elements.length;i++)
       {
            if(frm.elements[i]!='undefined' && frm.elements[i]!=null)
                frm.elements[i].style.cursor='wait';
                //document.HRE_EmployeeServiceDetails.elements[i].onmousedown=function(){return false;}
        }
    }
    document.body.style.cursor='wait';
    
    //document.onmousedown=mousewait;
    //document.onclick=mousewait;
}

function statuswaiting(frm)
{
    //if(frm.elements!='undefined' && frm.elements!=null)
             for(i=0;i<frm.elements.length;i++)
           {
                    if(frm.elements[i]!='undefined' && frm.elements[i]!=null)
                        frm.elements[i].style.cursor='wait';
                    //document.HRE_EmployeeServiceDetails.elements[i].onmousedown=function(){return false;}
            }
    document.body.style.cursor='wait';
    
    //document.onmousedown=mousewait1;
    //document.onclick=mousewait1;
}


function stopwaiting(frm)
{
    //if( frm.elements!=null)
        for(i=0;i<frm.elements.length;i++)
        {
                if(frm.elements[i]!='undefined' && frm.elements[i]!=null)
                    frm.elements[i].style.cursor='default';
        }
    document.body.style.cursor='default';
    
    document.onmousedown=null;
    document.onclick=null;
    status= '';

}

//********************************************************************************

//This Coding for Date Validation and Checking     
function calins(e,t)
{
    var unicode=e.charCode? e.charCode : e.keyCode;
        //alert(unicode);
        //if(unicode !=8)
        
        if (unicode!=8 && unicode !=9 && unicode!=37 && unicode !=39 && unicode !=46  && unicode !=35 && unicode !=36 )
        {
            if(t.value.length==2 || t.value.length==5)
                t.value=t.value + '/';
             if (unicode<48||unicode>57 ) 
                return false 
        }
       

}



function checkdt(t)
{
  
    if(t.value.length==0)
        return false;
    if(t.value.length==10  && t.value.indexOf('/',0)==2 && t.value.indexOf('/',3)==5)
    {
      
       
        // var c=t.value.replace(/-/g,'/');
         var c=t.value;
        try{
        var f=DateFormat(t,c,event,true,'3');
        }catch(e){
        //exception  start
        
         t.value=c;
            var sc=t.value.split('/');
            var currenDay =sc[0];
            var currentMonth=sc[1];
            var currentYear=sc[2];
            //alert(currentYear == getCurrentYear()  && currentMonth == getCurrentMonth() && currenDay > getCurrentDay());
            if(currentYear<1970)
            {
            
                    alert('Entered date should be greater than or equal to '+_Service_Period_Beg_Year);
                    t.value="";
                    t.focus();
                    return false;
           } 
          
            t.value=c;
             if(err!=0)
                {
                    t.value="";
                    return false;
                }
            return true;
        
        
        //exception end
        
        }
        if( f==true)
        {
            //alert(f);
            //t.value=c.replace(/\//g,'-');
            t.value=c;
            var sc=t.value.split('/');
            var currenDay =sc[0];
            var currentMonth=sc[1];
            var currentYear=sc[2];
            //alert(currentYear == getCurrentYear()  && currentMonth == getCurrentMonth() && currenDay > getCurrentDay());
         
            if(currentYear<_Service_Period_Beg_Year)
            {
            
                    alert('Entered date should be greater than or equal to '+_Service_Period_Beg_Year);
                    t.value="";
                    t.focus();
                    return false;
           } 
                      
            t.value=c;
           
            return true;
            
        }
        else
        {
                if(err!=0)
                {
                    t.value="";
                    return false;
                }
        }
            
    }
    else
    {
            alert('Date format  should be (dd/mm/yyyy)');
            t.value="";
            //t.focus();
            return false
    }
    
}



function numonly(e)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode!=8)
        {
            if (unicode<48||unicode>57) 
                return false 
        }
    }
 
 
 
 function nonanum(e)
{
    var unicode=e.charCode? e.charCode : e.keyCode
    //alert(unicode);
    if (unicode!=8)
    {
        if (unicode==32 || (unicode>=65 && unicode<=90) || (unicode>=97 && unicode<=122) || unicode==45 || unicode==95 ||unicode==46 || unicode==9)
            return true;
        else
            return false;
    }
}

/*
body.onkeypress()= function ()
{
    var unicode=event.charCode? event.charCode : event.keyCode
    alert(unicode);
    if (unicode!=8)
    {
        if (unicode==32 || (unicode>=65 && unicode<=90) || (unicode>=97 && unicode<=122) || unicode==45 || unicode==95 ||unicode==46 || unicode==9)
            return true;
        else
            return false;
    }
}*/
