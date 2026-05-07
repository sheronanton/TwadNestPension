history.forward();
 
 function notNull()
    {       
        if((document.frmindex.txtID.value==null)||(document.frmindex.txtID.value.length==0))
        {
            alert("Enter User Name");
            document.frmindex.reset();
           
            return false;
        }
        else  if((document.frmindex.txtword.value==null)||(document.frmindex.txtword.value.length==0))
        {
            alert("Enter Password");
            document.frmindex.reset();
            
            return false;
        }
        else  if((document.frmindex.captchaval.value==null)||(document.frmindex.captchaval.value.length==0))
        {
            alert("Enter Above Code");
//            document.frmindex.reset();
            
            return false;
        }                
        /*
          If the username and password is not null and undefined then the cursor is made to Hour Glass in the sense
          that the username and password is passed to the Uservalidation servlet for authentication.        
        */                
        else
        {
        	
        	var ClientDate=new Date();
          //  document.getElementById("clientDate").value=ClientDate.getDate()+"/"+(ClientDate.getMonth()+1)+"/"+ClientDate.getFullYear();

             document.frmindex.action="UserValidation.ser";
             document.frmindex.method="POST";
             document.frmindex.submit();
        }
    }
    
    
    function Reload()
    {
//    	alert("HAI");
    	javascript:location.href="index.jsp?message=";
    }
    
    function buttonsubmit(e,t)
    {
        var unicode=e.charCode? e.charCode : e.keyCode
        if (unicode==13)
        {
            notNull();
        }
        else
        	{
        	var unicode=e.charCode? e.charCode : e.keyCode;
            if(unicode==13)
             {
               try{t.blur();}catch(e){}
               return true;             
             }
             if (unicode!=8 && unicode !=9  )
             {
                 if (unicode<48||unicode>57 ) 
                 return false; 
             }
        	}        
    }
    
    function stripQuotes(strWords)
    {
       
        strWords.value=strWords.value.replace( "'", "''");
   
    }
 

  function killChars(strWord)
  {
	var strWords=strWord.value;
    var badChars=new Array("*", "|", "()", ";", "%", "/..", "../", "=", "\\", "/*", "*/", "%1", "%2", "%3", ".htm", ".html", "--", "select", "drop", "insert", "delete", "xp_", "script", "alert");
    var newChars=null;

   //   badChars = array("*", "|", "()", ";", "%", "/..", "../", "=", "\\", "/*", "*/", "%1", "%2", "%3", ".htm", ".html", "--", "select", "drop", "insert", "delete", "xp_", "script", "alert")

    newChars = strWords;
     var len=badChars.length;
    for  (svr = 0;svr<len;svr++)
    {
        newChars=newChars.replace(badChars[svr], "");
    }

    strWord.value = newChars;

  }
  
/*   For New Menu -To logout */  
  
  function framesclear(){

      parent.menu.location.href = 'testmenufile.jsp';

}
  
  function numbersonly1(e,t)
  {
       var unicode=e.charCode? e.charCode : e.keyCode;
       if(unicode==13)
        {
          try{t.blur();}catch(e){}
          return true;
        
        }
        if (unicode!=8 && unicode !=9  )
        {
            if (unicode<48||unicode>57 ) 
                return false; 
        }
  }