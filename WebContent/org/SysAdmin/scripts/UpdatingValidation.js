function comboCheck()
      {
      //alert("hai");
      if(document.frmMasterSub.txtSysId.selectedIndex!=0) 
    {
         //alert("Select Major System ID");
         
         document.frmMasterSub.txtName.disabled=false;
         document.frmMasterSub.txtDesc.disabled=false;
         
         //frmMasterSub.txtSubSysId.focus();
         return false;
    }  
      }
function nullCheck()
{
//alert("nullcheck");
  /*if(document.frmMasterSub.txtSysId.selectedIndex==0) 
    {
         alert("Select Employee Name");
         
         //document.frmMasterSub.txtName.disabled=true;
         //document.frmMasterSub.txtDesc.disabled=true;
         //document.frmMasterSub.txtSubSysShortDesc.disabled=true;
         frmMasterSub.txtSysId.focus();
         return false;
    }*/  
/*if(document.frmMasterSub.txtSysId.selectedIndex!=0)
{
          alert("else");
          document.frmMasterSub.txtSubSysId.disabled=false;
         document.frmMasterSub.txtSubSysDesc.disabled=false;
         document.frmMasterSub.txtSubSysShortDesc.disabled=false;
         frmMasterSub.txtSubSysId.focus();
         return true;
}*/
    
    if((frmMasterSub.txtName.value=="") || (frmMasterSub.txtName.value.length<=0))
    {
         alert("Please Select RoleName");
         frmMasterSub.txtName.focus();
         return false;
    }  
   
    if((frmMasterSub.txtOrderSeq.value=="") || (frmMasterSub.txtOrderSeq.value.length<=0))
    {
         alert("Please Enter Order Sequence Number");
         frmMasterSub.txtOrderSeq.focus();
         return false;
    }
 
   /* if((frmMasterSub.txtSubSysShortDesc.value=="") || (frmMasterSub.txtSubSysShortDesc.value.length<=0))
    {
         alert("Please Enter Sub-System Short Description");
         frmMasterSub.txtSubSysShortDesc.focus();
         return false;
    }*/
 
   
    return true;
  
}
  
// this function checks that no alphabets cannot
//   be entered in a numeric field
function isInteger(pincode,e)
{     
       var nav4 = window.Event ? true : false;
       if (nav4)    // Navigator 4.0x
            var whichCode = e.which
       else         // Internet Explorer 4.0x
            var whichCode = e.keyCode
      if(whichCode>=48 && whichCode<=57)
      {
          return true;
      }
      var str=pincode.value;
      pincode.value=str.substring(0,str.length-1);
      return false;              
}  
   
// this function prompts for the id and calls the servlet
// that loads the values into the fields
function promptID()
{      
      /*var id=prompt("Enter the ID : ","");
      
      if(id==null) // cancel pressed
      {
        return;
      }
      else
      {
            callServer("Get",id);
      } */ 
      //clearAll();      
      document.frmMasterSub.cmdEdit.disabled=true;
      document.frmMasterSub.cmdAdd.disabled=true;
      
      //document.frmMasterSub.cmdSelect.disabled=false;
      edit=true; 
      alert("Please  Select a Existing Major System-Id");
      document.frmMasterSub.txtSysId.focus();
      document.frmMasterSub.cmdUpdate.disabled=false;
      document.frmMasterSub.cmdDelete.disabled=false;
      
}
    
// this function creates a popup window with BenefitListing.jsp page
// then positions the window 
function popupWindow()
{
      var level=document.frmMasterSub.txtSysId.value;
      my_window= window.open("MasterSubChild.jsp?level="+level,"mywindow1","status=1,height=250,width=600,resizable,scrollbars"); 
      my_window.moveTo(250,250);
}