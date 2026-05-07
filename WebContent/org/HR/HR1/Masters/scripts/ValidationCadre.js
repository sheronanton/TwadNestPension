
/*  this file contains page specific validation functions for FILE : MasterBenefit.jsp  */


// this function ensures that fields cannot be empty
function nullCheck()
{
    if((frmCadre.txtCadreId.value=="") || (frmCadre.txtCadreId.value.length<=0))
    {
         alert("Please Enter Cadre ID");
         frmCadre.txtCadreId.focus();
         return false;
    }  
   
    if((frmCadre.txtCadreName.value=="") || (frmCadre.txtCadreName.value.length<=0))
    {
         alert("Please Enter Cadre Name");
         frmCadre.txtCadreName.focus();
         return false;
    }
 
    if((frmCadre.txtCadreSName.value=="") || (frmCadre.txtCadreSName.value.length<=0))
    {
         alert("Please Enter Cadre Short Name");
         frmCadre.txtCadreSName.focus();
         return false;
    }
 
    if((frmCadre.txtRemarks.value=="") || (frmCadre.txtRemarks.value.length<=0))
    {
         alert("Please Enter Remarks");
         frmCadre.txtRemarks.focus();
         return false;
    }
    return true;
  
}
  
// this function checks that no alphabets cannot
//   be entered in a numeric field
function isInteger(param,e)
{     
       var nav4 = window.Event ? true : false;
       if (nav4)    // Navigator 4.0x
            var whichCode = e.which
       else         // Internet Explorer 4.0x
            var whichCode = e.keyCode            
      
      if((whichCode>=48 && whichCode<=57) || (whichCode>=97 && whichCode<=105))
      {
          return true;
      }
      if(whichCode==13)
          return true;
      var str=param.value;
      param.value=str.substring(0,str.length-1);
      return false;              
}  

function LoadCadreDetails(e) 
{
    var nav4 = window.Event ? true : false;
    if (nav4)    // Navigator 4.0x
        var whichCode = e.which
    else         // Internet Explorer 4.0x
        var whichCode = e.keyCode     
    if(whichCode==13)
    {
        //alert("you pressed : " + whichCode);
        document.frmCadre.txtCadreId.onblur="";
        Verification();
    }
}
   
// this function prompts for the id and calls the servlet
// that loads the values into the fields
function promptID()
{                 
      clearAll();      
      document.frmCadre.cmdEdit.disabled=true;
      document.frmCadre.cmdAdd.disabled=true;
      document.frmCadre.cmdSelect.disabled=false;
      edit=true; 
      alert("Please Type in or Select an Existing Cadre ID, then press <<Enter>>.");
      document.frmCadre.txtCadreId.focus(); 
}
    
// this function creates a popup window with BenefitListing.jsp page
// then positions the window 
function popupWindow()
{
      my_window= window.open("../jsps/LoadCadre.jsp","mywindow1","status=1,height=110,width=500"); 
      my_window.moveTo(250,250);    
}
