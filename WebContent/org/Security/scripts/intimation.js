//			intimation			//


function AjaxFunction() {
	var xmlrequest = false;
	try {
		xmlrequest = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e1) {
		try {
			xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e2) {
			xmlrequest = false;
		}
	}
	if (!xmlrequest && typeof XMLHttpRequest != 'undefined') {
		xmlrequest = new XMLHttpRequest();
	}
	return xmlrequest;
}

function manipulate(xmlrequest) {

	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {

			var baseResponse = xmlrequest.responseXML
					.getElementsByTagName("response")[0];

			var tagCommand = baseResponse.getElementsByTagName("command")[0];

			var command = tagCommand.firstChild.nodeValue;

			if (command == "get") {
				intimate1(baseResponse);
			}
		}
	}
}

function intimate(path) {

	var url = path + "/IntimationServlet?command=get";
	//alert(url);
	var xmlrequest = AjaxFunction();
	xmlrequest.open("POST", url, true);
	xmlrequest.onreadystatechange = function() {
		manipulate(xmlrequest);
	};
	xmlrequest.send(null);
}

function intimate1(baseResponse) {
       
	//alert("response");
	
	var slno = 1;
	var s = "";
     var s1=""; 

     //var nn="New".blink();
     var nn='<img src="images/new.gif"/>';
   

  	var verify_a52_ce = baseResponse.getElementsByTagName("verify_a52_ce")[0].firstChild.nodeValue;
  	
  	if(verify_a52_ce=="verify")
  	{
  		
  		var verify_a52_ce_ss = baseResponse.getElementsByTagName("verify_a52_ce_status")[0].firstChild.nodeValue;
  		if(verify_a52_ce_ss=="fullverify"){
  			
  		}else if(verify_a52_ce_ss=="notfullverify"){
  			var Msg = slno + ". " +"Please Enter Civil Budget Reallocation Data and Freeze On or Before 31/10/2014 ";
  	     	 s = s + "<br>"+ ((Msg.fontcolor("green")).fontsize(1))+nn;
  	     	
  	 			slno = slno + 1;
  			
  		}
     	 
  	} 
 /* 	
  	var Msgs = slno + ". " +"Provision given to book the interest ín cash book and transfer the same to HO for NRDWP" +
		" Main and Support activity as per circular 4/F10542/Compilation/A1/2014 dt 04.04.2014  ";
		s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(1))+" "+nn;
		
		slno = slno + 1;
		
		
		var Msgs = slno + ". " +"GPF Related Payments should be done through Civil Bill Processing System only from 1.4.2014." +
 	 		" It will not be allowed from Payment Menu- HELP Document available in FAS Notice Board";
    s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(1))+" "+nn;
   
	slno = slno + 1;*/
  	
  	/* var Msgs = slno + ". " +"Create Journal for Advice from HO - vide Letter no 15124/A3/Bkg/2015 dated 11.05.2015 - using Adjustment memo - Accept Adjustment Memo ";
   	s = s + "<br>"+ ((Msgs.fontcolor("RED")).fontsize(2))+" "+nn;

   	slno = slno + 1;
   	*/
  	
  	
 
  	/*var Msgs = slno + ". " +"Generate Bank pass sheet as on 31.03.2016 in respect of all bank accounts operated by your office may be obtained  from Bank on 31-03-2016 itself ";
  	s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(2))+" "+nn;

  	slno = slno + 1;*/
  	
  	 
  	
	/*var Msgs = slno + ". " +" Bank Balance as per pass sheet as on 29.2.2016 in respect of all bank accounts operated by your office may be updated immediately .  ";*/
	
/*	
	" Recovery of One Day salary may be credited to the Head of Account "793199- Sy.Dr. Others - One Day Salary Contribution
	Under the Sub Ledger "Contribution of CMPRF - 2015"
	s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(2))+" "+nn;

  	slno = slno + 1;*/
  	
//  	var Msgs = slno + ". " +"'Please verify Scheme Expenditure every month before generating Trial Balance. Menu Available in Month End Operation (regular)->Verification of TDA/TCA register, GPF Payment, Scheme Expenditure'";
//	s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(1))+" "+nn;
//
//	slno = slno + 1;
  	
  	
  	
  	
//  	var Msgs = slno + ". " +"Payroll Journal to be automated from Payroll Summary displayed in PAYROLL Module-Please check for the correctness of HOA in payroll summary.";
//	s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;
//
//	slno = slno + 1;
  	
  	
  	var Msgs = slno + ". " +"'For TPA acceptance, Audit verification and Freeze for TPA  originating should have been done by respective Regional AO'";
	s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(1))+" "+nn;

	slno = slno + 1;
  	
  	
  	var Msgs = slno + ". " +"GPF Payment is to be entered from HRMS Sanction Proceeding only.";
	s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;

	slno = slno + 1;
  	
  	
//  	var Msgs = slno + ". " +"Please select  LIABILITY JOURNAL IN SUPPLEMENT as journal type in Create SJV, whenever  liability is created  for future payment  and  to ensure selection in payment against pending bill at a later date.";
//	s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;
//
//	slno = slno + 1;
  	
  	
//  	 var Msgs = slno + ". " +"As per DCAO's instruction it is informed that posting of single journal for multiple bills is to be avoided";
//		s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;
//
//	slno = slno + 1;

  	
  	
//  	 var Msgs = slno + ". " +"As per DCAO instruction all units are requested to freeze March'2017 Trial Balance on or before 20/04/2017";
//		s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;
//
//	slno = slno + 1;
  	
  	
  	 var Msgs = slno + ". " +"The users are requested to generate and print the required report from FAS and file it for future use";
		s = s + "<br>"+ ((Msgs.fontcolor("brown")).fontsize(1))+" "+nn;

	//slno = slno + 1;
	//var Msgs = slno + ". " +"Verification of Civil Expenditure against Civil Budget will be made mandatory shortly.Hence requested to make all necessary entries in online";
	//s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;

slno = slno + 1;
	
	
//	 var Msgs = slno + ". " +"Posting of pension Journal from Pension module will be made mandatory  from AUGUST-2016 and restricted in GJV. Please use Journal->Pension Journal instead of entering it in GJV";
//		s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;
//
//	slno = slno + 1;
  	
  
  	
//  	var Msgs = slno + ". " +" Please check head of account booked in Auto fund receipt and Fund transfer for correctness before freezing the Trial Balance.";
//	
//		s = s + "<br>"+ ((Msgs.fontcolor("Purple")).fontsize(1))+" "+nn;
//
//		slno = slno + 1;
		//-------------	*************   -----------------------------
  	//--------------- *************  --------------------------------
//		var Msgs = slno + ". " +" Check the already freezed Trialbalance of 2015-16 for correctness of the bank head of accounts.";
//			s = s + "<br>"+ ((Msgs.fontcolor("green")).fontsize(1))+" "+nn;
//
//			slno = slno + 1;
  	
//  	var Msgs = slno + ". " +"March-2016 Supplement Account No.1 is Opened for Entry ";   
//  	s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(1))+" "+nn;
//
//  	slno = slno + 1;
  	
  	/*var Msgs = slno + ". " +" Please Verify GPF Payment/Cheque memo before TB generate. It is  available in Month End Operations (regular). ";
   
  	s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(2))+" "+nn;

  	slno = slno + 1;*/
    	
  	
//	var Msgs = slno + ". " +" Account code No 487631 is old and hence it will be deleted shortly. "+
//  "	Please reclassify the transactions for this head in 2015-16 in to 483131,41,51,61 duly posting sub ledger. ";
//	s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(1))+" "+nn;
//
//	slno = slno + 1;
	
 	/*var Msgs = slno + ". " +" Use the New Contractor/Supplier/Firm/Other Department LJV Form for all Project Related LJVs.  Through Other Menu It will be restricted shortly ";
	s = s + "<br>"+ ((Msgs.fontcolor("RED")).fontsize(2))+" "+nn;

	slno = slno + 1;
  	*/

 	/*var Msgs = slno + ". " +" Create Civil Budget Proposal for 2015-16 using Online";
	s = s + "<br>"+ ((Msgs.fontcolor("brown")).fontsize(2))+" "+nn;

	slno = slno + 1;
	
	*/
	
 /* 	var Msgs = slno + ". " +"IMIS Expenditure should tally with FAS. Otherwise Dec'2014 Transactions cannot be entered in TWADNEST";
		s = s + "<br>"+ ((Msgs.fontcolor("brown")).fontsize(2))+" "+nn;

		slno = slno + 1;
  	*/
	/*var Msgs = slno + ". " +"IMIS Expenditure Should tally with FAS in TWADNEST";
	s = s + "<br>"+ ((Msgs.fontcolor("brown")).fontsize(2))+" "+nn;

	slno = slno + 1;*/
	/* var Msgs = slno + ". " +"As per DCAOs instruction, every month 391402 (credit) should tally with 391403 (debit) to Freeze TB";
		s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(2))+" "+nn;

		slno = slno + 1;
	*/
	
	
 	//added by Joan on 28/05/2015.........
	/*
	 var Msgs = slno + ". " +"As per the instruction, all sundry creditors head are restricted in Final head Payment from 1/4/2015";
s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(2))+" "+nn;

slno = slno + 1;*/
  /*	var Msgs = slno + ". " +"Pl Refer the Help Document under FAS Notice Board for using BRS..";
		s = s + "<br>"+ ((Msgs.fontcolor("brown")).fontsize(2))+" "+nn;

		slno = slno + 1;*/
	  	//added by sathya on 19/09/2014.........
  	/* var Msgs = slno + ". " +"Please see FAS Notice Board for Payment against Pending bill.";
  	 		s = s + "<br>"+ ((Msgs.fontcolor("brown")).fontsize(2))+" "+nn;

  	 		slno = slno + 1;*/

 /*	 var Msgs = slno + ". " +"Please enter GPF Related payments through Civil Bill Processing." +
 	 		"  It is restricted in Final Head Payment";
    s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(2))+" "+nn;
   
	slno = slno + 1;*/
	
	// joe Change on 23 Sep 2014
	/* var Msgs = slno + ". " +"As per DCAO’s Instruction Units are requested to Enter Bank Balance for each Account from Jan-2014 onwards.";
		s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(2))+" "+nn;

		slno = slno + 1;*/
	/* var Msgs = slno + ". " +"The amount deducted from Salary of Deputed Employees  and Cheque sent to TWAD may be entered in ‘Receipts from Other Departments for Deputationists";
		s = s + "<br>"+ ((Msgs.fontcolor("red")).fontsize(2))+" "+nn;

		slno = slno + 1;
	
  	*/
  	/* var Msgs = slno + ". " +"Please Enter Telephone number details, w.r.t to Civil Payment. The menu available in Civil Bills->Civil Bills Unit wise master";
     s = s + "<br>"+ ((Msgs.fontcolor("black")).fontsize(1))+" "+nn;
    
 	slno = slno + 1;*/
  	
 	var flag_offices = baseResponse.getElementsByTagName("flag_offices")[0].firstChild.nodeValue;
    
 	
 /*	
  * // joe change on 30Sep2014
  * 
  * if (flag_offices == "success") 
     {
    	 var off_level_id = baseResponse.getElementsByTagName("off_level_id")[0].firstChild.nodeValue;
    	 if(off_level_id=="CL" || off_level_id=="RN" || off_level_id=="HO")
    	 {
    	 var Msg = slno + ". " +"Verify A52 Registers For the Closing Balance (2012-13)";
    	
    	 s = s + "<br>" + ((Msg.fontcolor("orange")).fontsize(1))+" "+nn;
    	 slno = slno + 1;
    	 }
    	 else
    	 {
    		// var Msg = slno + ". " +"Verify Numerical Balance ASSETS";
    		 var Msg = slno + ". " +"Verify A52 Registers For the Closing Balance (2012-13)";
    		 s = s + "<br>" + ((Msg.fontcolor("orange")).fontsize(1))+" "+nn;
        	 slno = slno + 1;
    	 }
			
     }  
     
     *
     *
     *
     *
     *
     */
 	
 	
 	
    /* var Msgs_two = slno + ". " +"Please Prepare Civil Budget Proposal for the Year 2014-15 Through Online on Parallel Basis";
     s = s + "<br>"+ ((Msgs_two.fontcolor("green")).fontsize(1));
     slno = slno + 1;*/
     
    /* var Msgs_one = slno + ". " +"Generation of GPF bill and payment voucher from the proceeding validated in GPF Module is hosted in  CIVIL BILLS menu";
     s = s + "<br>"+ ((Msgs_one.fontcolor("brown")).fontsize(1));
     slno = slno + 1;*/
 
 	
 	/*
   * 
   * 
   *  // joe change on 30Sep2014
   * 
   * 
   * 	
     var Msgr = slno + ". " +"Please View AA52 Register Report(Detail & Abstract)/Edit & Freeze";
     s = s + "<br>"+ ((Msgr.fontcolor("blue")).fontsize(1));//  (((nn.fontcolor("brown")).fontsize(1)));//.backgroundColor("red");;
      slno = slno + 1;
      
      *
      */
      
      
      
      
      
    /*  var Msgr = slno + ". " +"Please enter payment for 550102 – sundry creditor Contractors in Payment against Pending bill. It is restricted in Final Head Payment";
      s = s + "<br>"+ ((Msgr.fontcolor("blue")).fontsize(2))+" "+nn;//  (((nn.fontcolor("brown")).fontsize(1)));//.backgroundColor("red");;
       slno = slno + 1;*/
     
//     var Msgs = slno + ". " +"Bank Balance Should be Updated with Actual PassSheet Balance Failing which the User is Responsible For the Entry";
//     s = s + "<br>"+ ((Msgs.fontcolor("Purple")).fontsize(1));
//    
// 	slno = slno + 1;
     
	
     var flag_adj = baseResponse.getElementsByTagName("flag_adj")[0].firstChild.nodeValue;
     if (flag_adj == "success") 
     {
    	 var no_adjust_memo = baseResponse.getElementsByTagName("no_adjust_memo")[0].firstChild.nodeValue;
    	 var Msg = slno + ". " +"No of Adjustment Memo(TFBR) Raised From HO " +
    	 		" To Your Unit is ";
    	 s = s + "<br>"+ ((Msg.fontcolor("green")).fontsize(1))+ no_adjust_memo.fontcolor("green").fontsize(1);
    	
			slno = slno + 1;
			
			
     }
     
//     var tda_error = baseResponse.getElementsByTagName("tda_error")[0].firstChild.nodeValue;
//     if (tda_error == "success") 
//     {
//    	 var Msg = slno + ". " +"PLEASE RECTIFY TDA/TCA ERRORS";
//    	 s = s + "<br>"+ ((Msg.fontcolor("blue")).fontsize(1));
//    	
//			slno = slno + 1;
//			
//			
//     }
     
    
	
		var office_id = baseResponse.getElementsByTagName("office_id")[0].firstChild.nodeValue;
		//alert("office_id >> "+office_id);
		/*if (office_id == 5015 ||office_id ==  5017 ||office_id ==  5019 ||office_id ==   5000 ||office_id ==  5009 ||office_id ==   5010  ||office_id ==   5011 ||office_id ==  5012 ||office_id ==  5007 ||office_id ==  5014 ||office_id ==  5013 ||office_id ==  6955) {                               
			 var Msgs = slno + ". " +"Automatic creation of pension journal from Monthly Pension processed in HRMS in Journal Module";
				s = s + "<br>"+ ((Msgs.fontcolor("blue")).fontsize(2))+" "+nn;

			slno = slno + 1;
			
			
		}*/
     
	var flag = baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;
    
	if (flag == "success") {
       
		var len = baseResponse.getElementsByTagName("No_of_proforma_raised").length;
        	if (len != 0) {
			for ( var k = 0; k < len; k++) {
				var No_of_proforma_raised = baseResponse
						.getElementsByTagName("No_of_proforma_raised")[k].firstChild.nodeValue;
				var TPA_Type = baseResponse.getElementsByTagName("TPA_Type")[k].firstChild.nodeValue;
                            if (TPA_Type == "TPAOC") {
					TPA_Type = "No of Proforma Transfers(CR) Raised is ";
				} else if (TPA_Type == "TPAOD") {
					TPA_Type = "No of Proforma Transfers(DR) Raised is ";
				}
				s = s + "<br>" + slno + ". " + TPA_Type + No_of_proforma_raised;
				slno = slno + 1;
			}
		}
	}
	if (flag != "failure") {
        
		var flag1 = baseResponse.getElementsByTagName("flag1")[0].firstChild.nodeValue;
               
		if (flag1 == "success") {
			var len = baseResponse
					.getElementsByTagName("No_of_proforma_status").length;
			if (len != 0) {
				for ( var k = 0; k < len; k++) {
					var No_of_proforma_status = baseResponse
							.getElementsByTagName("No_of_proforma_status")[k].firstChild.nodeValue;
					var TPA_Type1 = baseResponse
							.getElementsByTagName("TPA_Type1")[k].firstChild.nodeValue;
					var Acceptance_Status = baseResponse
							.getElementsByTagName("Acceptance_Status")[k].firstChild.nodeValue;

					if (TPA_Type1 == "TPAOC") {
						if (Acceptance_Status == "Y") {
							TPA_Type1 = "No of Proforma Transfers(CR) Accepted is ";
						} else if (Acceptance_Status == "N") {
							TPA_Type1 = "No of Proforma Transfers(CR) Rejected is ";
						}
					} else if (TPA_Type1 == "TPAOD") {
						if (Acceptance_Status == "Y") {
							TPA_Type1 = "No of Proforma Transfers(DR) Accepted is ";
						} else if (Acceptance_Status == "N") {
							TPA_Type1 = "No of Proforma Transfers(DR) Rejected is ";
						}
					}
					s = s + "<br>" + slno + ". " + TPA_Type1
							+ No_of_proforma_status;
					slno = slno + 1;
				}
			}
		}

		var flag22 = baseResponse.getElementsByTagName("flag22")[0].firstChild.nodeValue;
                
		if (flag22 == "success") {
			var len = baseResponse.getElementsByTagName("No_of_TDA_raised1").length;
			if (len != 0) {
				for ( var k = 0; k < len; k++) {
					var No_of_TDA_raised = baseResponse
							.getElementsByTagName("No_of_TDA_raised1")[k].firstChild.nodeValue;
					var TDA_OR_TCA = baseResponse
							.getElementsByTagName("TDA_OR_TCA1")[k].firstChild.nodeValue;
					//alert("TDA_OR_TCA------"+TDA_OR_TCA);
					TDA_OR_TCA = TDA_OR_TCA.substring(1, 2);
					// alert("TDA_OR_TCA------"+TDA_OR_TCA);
					if (TDA_OR_TCA == "D") {
						TDA_OR_TCA = "No of TDA Originated by You and JVR Posted is ";
					} else if (TDA_OR_TCA == "C") {
						TDA_OR_TCA = "No of TCA Originated by You and JVR Posted is ";
					}
					s = s + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  " +"<br>" + slno + ". " + TDA_OR_TCA
							+ No_of_TDA_raised;
					slno = slno + 1;
				}
			}
		}

		var flag2 = baseResponse.getElementsByTagName("flag2")[0].firstChild.nodeValue;
                
		if (flag2 == "success") {
			var len = baseResponse.getElementsByTagName("No_of_TDA_raised4").length;
			if (len != 0) {
				for ( var k = 0; k < len; k++) {
					var No_of_TDA_raised = baseResponse
							.getElementsByTagName("No_of_TDA_raised4")[k].firstChild.nodeValue;
					var TDA_OR_TCA = baseResponse
							.getElementsByTagName("TDA_OR_TCA4")[k].firstChild.nodeValue;

					TDA_OR_TCA = TDA_OR_TCA.substring(1, 2);

					if (TDA_OR_TCA == "D") {
						TDA_OR_TCA = "No of TDA Originated to You is ";
					} else if (TDA_OR_TCA == "C") {
						TDA_OR_TCA = "No of TCA Originated to You is ";
					}
					s = s +" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  "+ slno + ". " + TDA_OR_TCA
							+ No_of_TDA_raised;
					slno = slno + 1;
				}
			}
		}

		var flag33 = baseResponse.getElementsByTagName("flag33")[0].firstChild.nodeValue;
               
		if (flag33 == "success") {
			var len = baseResponse.getElementsByTagName("No_of_TDA_status3").length;
                      
			if (len != 0) {
				for ( var k = 0; k < len; k++) {
					var No_of_TDA_status = baseResponse
							.getElementsByTagName("No_of_TDA_status3")[k].firstChild.nodeValue;
					var TDA_OR_TCA = baseResponse
							.getElementsByTagName("TDA_OR_TCA3")[k].firstChild.nodeValue;
					var Acceptance_Status = baseResponse
							.getElementsByTagName("Acceptance_Status3")[k].firstChild.nodeValue;

					TDA_OR_TCA = TDA_OR_TCA.substring(1, 2);
					if (TDA_OR_TCA == "D") {
						if (Acceptance_Status == "Y") {
							TDA_OR_TCA = "No of TDA Originated by You and Accepted by Others is ";
						} else if (Acceptance_Status == "N") {
							TDA_OR_TCA = "No of TDA Originated by You and Rejected by Others is ";
						}
                                                 
                                                
					} else if (TDA_OR_TCA == "C") {
						if (Acceptance_Status == "Y") {
							TDA_OR_TCA = "No of TCA Originated by You and Accepted by Others is ";
						} else if (Acceptance_Status == "N") {
							TDA_OR_TCA = "No of TCA Originated by You and Rejected by Others is ";
						}
					}
                                     else{
                                     if(Acceptance_Status !="R")
                                     {
					s = s + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  " + slno + ". " + TDA_OR_TCA
							+ No_of_TDA_status;
					slno = slno + 1;
                                        }
                                        }
				}
			}
		}

		var flag3 = baseResponse.getElementsByTagName("flag3")[0].firstChild.nodeValue;
		if (flag3 == "success") {
			var len = baseResponse.getElementsByTagName("No_of_TDA_status").length;
			if (len != 0) {
				for ( var k = 0; k < len; k++) {
					var No_of_TDA_status = baseResponse
							.getElementsByTagName("No_of_TDA_status")[k].firstChild.nodeValue;
					var TDA_OR_TCA = baseResponse
							.getElementsByTagName("TDA_OR_TCA")[k].firstChild.nodeValue;
					var Acceptance_Status = baseResponse
							.getElementsByTagName("Acceptance_Status")[k].firstChild.nodeValue;

					TDA_OR_TCA = TDA_OR_TCA.substring(1, 2);
                                      //  alert("TDA_OR_TCA::"+TDA_OR_TCA);
					if (TDA_OR_TCA == "D") {
						if (Acceptance_Status == "Y") {
							TDA_OR_TCA = "No of TDA Originated to You and Accepted by You is ";
						} else if (Acceptance_Status == "N") {
							TDA_OR_TCA = "No of TDA Originated to You and Rejected by You is is ";
						}
					} else if (TDA_OR_TCA == "C") {
						if (Acceptance_Status == "Y") {
							TDA_OR_TCA = "No of TCA Originated to You and Accepted by You is ";
						} else if (Acceptance_Status == "N") {
							TDA_OR_TCA = "No of TCA Originated to You and Rejected by You is is ";
						}
					}
                                        else{
                                        if(TDA_OR_TCA!="R")
                                        {
                                            s = s + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  " + slno + ". " + TDA_OR_TCA
                                                            + No_of_TDA_status;
                                            slno = slno + 1;
                                        }
                                        }
				}
			}
		}

		var flag10 = baseResponse.getElementsByTagName("flag10")[0].firstChild.nodeValue;
             if (flag10 == "success") {
			var No_of_Transfers_to_Office_ID = baseResponse.getElementsByTagName("No_of_Transfers_to_Office_ID")[0].firstChild.nodeValue;                                     
                      if (No_of_Transfers_to_Office_ID != 0) {
				var office_id = baseResponse.getElementsByTagName("office_id")[0].firstChild.nodeValue;
				if (office_id != 5000) {                               
					var Msg = "No of Fund Transfer From HO to You is ";
					s = s + "<br>" + slno + ". " + Msg
							+ No_of_Transfers_to_Office_ID;
					slno = slno + 1;
				} else {
					var wing_id = baseResponse.getElementsByTagName("wing_id")[0].firstChild.nodeValue;
					if (wing_id == 2) {
						var Msg = "No of Fund Transfer From Unit to You is ";
						s = s + "<br>" + slno + ". " + Msg
								+ No_of_Transfers_to_Office_ID;
						slno = slno + 1;
					}
				}
			}

		}
           
          
    if (s != "") {
  		
  		$.prompt(s, {
  			  
  			//show : 'slideDown',fadeIn
  			show : 'slideDown',
  			buttons : {	Ok : true }
  		
  		}); 
  	
  		
  	}
	
	} 
	
	
	
}

