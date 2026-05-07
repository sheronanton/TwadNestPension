String.prototype.trim = function() {
	a = this.replace(/^\s+/, '');
	return a.replace(/\s+$/, '');
};

function getTransportWth() {
	var req = false;
	try {
		req = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e2) {
			req = false;
		}
	}
	{
		req = new XMLHttpRequest();
	}
	return req;
}




function fetchMstSettingData() {
	
	var url = "penAppForm1FetchSettingdata.html";
	var req = getTransportWth();
	req.open("GET", url, true);
	req.onreadystatechange = function() {
		penAppSettingProcessResponse(req);
	};
	req.send(null);
}

function penAppSettingProcessResponse(req) {
	if (req.readyState == 4) {
		if (req.status == 200) {
			var baseResponse = req.responseXML.getElementsByTagName("response")[0];
			var tagCommand = baseResponse.getElementsByTagName("command")[0];
			var display = baseResponse.getElementsByTagName("record");

			if (display.length <= 0) {
				alert('Record Not Found');
				defaultselection();
			} else {

				for ( var i = 0; i < display.length; i++) {

					document.getElementById("Min_quali_wce_service").value = nullcheck(baseResponse
							.getElementsByTagName("Min_quali_wce_service")[i].firstChild.nodeValue);
					document.getElementById("Selection_grade_gap").value = nullcheck(baseResponse
							.getElementsByTagName("Selection_grade_gap")[i].firstChild.nodeValue);
					document.getElementById("Spl_grade_gap").value = nullcheck(baseResponse
							.getElementsByTagName("Spl_grade_gap")[i].firstChild.nodeValue);
					document.getElementById("Vrs_eligible_yrs").value = nullcheck(baseResponse
							.getElementsByTagName("Vrs_eligible_yrs")[i].firstChild.nodeValue);
					document.getElementById("Pension_eligible_yrs").value = nullcheck(baseResponse
							.getElementsByTagName("Pension_eligible_yrs")[i].firstChild.nodeValue);
					document.getElementById("Family_pension_ceiling_yrs").value = nullcheck(baseResponse
							.getElementsByTagName("Family_pension_ceiling_yrs")[i].firstChild.nodeValue);
					document.getElementById("Family_pension_ceiling_percent").value = nullcheck(baseResponse
							.getElementsByTagName("Family_pension_ceiling_percent")[i].firstChild.nodeValue);
					document.getElementById("Family_pension_after_percent").value = nullcheck(baseResponse
							.getElementsByTagName("Family_pension_after_percent")[i].firstChild.nodeValue);
					document.getElementById("Pension_half_yr_ceiling").value = nullcheck(baseResponse
							.getElementsByTagName("Pension_half_yr_ceiling")[i].firstChild.nodeValue);
					document.getElementById("Dcrg_half_yr_celing").value = nullcheck(baseResponse
							.getElementsByTagName("Dcrg_half_yr_celing")[i].firstChild.nodeValue);
					document.getElementById("Max_dcrg_amt").value = nullcheck(baseResponse
							.getElementsByTagName("Max_dcrg_amt")[i].firstChild.nodeValue);
					document.getElementById("Avg_total_months").value = nullcheck(baseResponse
							.getElementsByTagName("Avg_total_months")[i].firstChild.nodeValue);
					document.getElementById("Retirement_celing_yrs").value = nullcheck(baseResponse
							.getElementsByTagName("Retirement_celing_yrs")[i].firstChild.nodeValue);
					document.getElementById("Weightage_max").value = nullcheck(baseResponse
							.getElementsByTagName("Weightage_max")[i].firstChild.nodeValue);
					document.getElementById("Family_pension_ceiling_age").value = nullcheck(baseResponse
							.getElementsByTagName("Family_pension_ceiling_age")[i].firstChild.nodeValue);
					document.getElementById("da_percentage").value = nullcheck(baseResponse
							.getElementsByTagName("da_percentage")[i].firstChild.nodeValue);
                    
					document.getElementById("Min_pension_amt").value = nullcheck(baseResponse
							.getElementsByTagName("Min_pension_amt")[i].firstChild.nodeValue);
					document.getElementById("Max_pension_amt").value = nullcheck(baseResponse
							.getElementsByTagName("Max_pension_amt")[i].firstChild.nodeValue);
					document.getElementById("Min_fam_pension_amt").value = nullcheck(baseResponse
							.getElementsByTagName("Min_fam_pension_amt")[i].firstChild.nodeValue);
					document.getElementById("Max_fam_pension_amt").value = nullcheck(baseResponse
							.getElementsByTagName("Max_fam_pension_amt")[i].firstChild.nodeValue);

					var avgdisplay = baseResponse
							.getElementsByTagName("averagerecord");
					var payname;
					var include;
					var da;
					var display_description;
					for ( var ai = 0; ai < avgdisplay.length; ai++) {
						payname = nullcheck(baseResponse
								.getElementsByTagName("PAY_NAME")[ai].firstChild.nodeValue);
						
						include = nullcheck(baseResponse
								.getElementsByTagName("INCLUDE")[ai].firstChild.nodeValue);
						da = nullcheck(baseResponse.getElementsByTagName("DA")[ai].firstChild.nodeValue);
						display_description = nullcheck(baseResponse
								.getElementsByTagName("DISPLAY_CAPTION")[ai].firstChild.nodeValue);
						var imgcon = '&nbsp;&nbsp;<img src="../images/rupeessymbol.png" width="10" height="15" />';
						if (payname == "BASIC") {
							document.getElementById("avg_pay_name_basic").value = payname;
							document.getElementById("avg_include_basic").value = include;
							document.getElementById("avg_da_basic").value = da;
							document
									.getElementById("avg_display_caption_basic").value = display_description
									+ imgcon;

						}
						if (payname == "GRADE PAY") {
							document.getElementById("avg_pay_name_grade").value = payname;
							document.getElementById("avg_include_grade").value = include;
							document.getElementById("avg_da_grade").value = da;
							document
									.getElementById("avg_display_caption_grade").value = display_description
									+ imgcon;
						}
						if (payname == "SPECIAL PAY") {
							document.getElementById("avg_pay_name_special").value = payname;
							document.getElementById("avg_include_special").value = include;
							document.getElementById("avg_da_special").value = da;
							document
									.getElementById("avg_display_caption_special").value = display_description
									+ imgcon;
						}
						if (payname == "OTHER PAY1") {
							document.getElementById("avg_pay_name_other1").value = payname;
							document.getElementById("avg_include_other1").value = include;
							document.getElementById("avg_da_other1").value = da;
							document
									.getElementById("avg_display_caption_other1").value = display_description
									+ imgcon;
						}
						if (payname == "OTHER PAY2") {
							document.getElementById("avg_pay_name_other2").value = payname;
							document.getElementById("avg_include_other2").value = include;
							document.getElementById("avg_da_other2").value = da;
							document
									.getElementById("avg_display_caption_other2").value = display_description
									+ imgcon;
						}
						if (payname == "OTHER PAY3") {
							document.getElementById("avg_pay_name_other3").value = payname;
							document.getElementById("avg_include_other3").value = include;
							document.getElementById("avg_da_other3").value = da;
							document
									.getElementById("avg_display_caption_other3").value = display_description
									+ imgcon;
						}
						
						  //alert("otherpay");
		    			  if(payname=="LEVEL OF PAY")
		    			  {
		    				  
		    				  document.getElementById("avg_pay_name_level").value=payname;
		    				  
		    				  document.getElementById("avg_include_level").value=include;
		    				  
		    				  document.getElementById("avg_da_level").value=da;
		    				  
		    				  document.getElementById("avg_display_caption_level").value=display_description+imgcon;
		    				 // alert("levelofpay"+payname);
		    			
		    				  
		    			  }
		    			  

					}

				}
				try {

					defaultselection();

				} catch (e) {
					// alert(e.message);
				}
			}
		}
	}
}

function fetchMstDataCheckVal(empNo) {
	
	
	
	var empId = empNo.trim();
	if (empId != "" && empId.length > 0) {
		var url = "penAppForm1FetchMstCheckValdata.html?pensionAppCalcForm1.empNo="
				+ empId;
		var chvalreq = getTransportWth();
		chvalreq.open("GET", url, true);
		chvalreq.onreadystatechange = function() {
			penAppProcessResponseCheckVal(chvalreq);
		};
		chvalreq.send(null);
	}
}
function penAppProcessResponseCheckVal(chvalreq) {
	if (chvalreq.readyState == 4) {
		if (chvalreq.status == 200) {

			try {
				var displayflag = 0;
				var baseResponse = chvalreq.responseXML
						.getElementsByTagName("response")[0];
				var display = baseResponse.getElementsByTagName("record");
				var flag = baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;

			} catch (e) {
				// alert(e.message);
				displayflag = 1;
				display = 0;
			}
			if ((display.length <= 0) || flag == "false" || flag == false
					|| displayflag == 1) {

				var emp_no = document.getElementById("empNo").value;
				fetchMstData(emp_no);
			} else {
				
				alert('Record Already Exist');
				window.location.reload();
			}
		}
	}
}

function fetchMstData(empNo) {
	var empId = empNo.trim();
	if (empId != "" && empId.length > 0) {
		var url = "penAppForm1FetchMstdata.html?pensionAppCalcForm1.empNo="
				+ empId;
		var req = getTransportWth();
		req.open("GET", url, true);
		req.onreadystatechange = function() {
			penAppProcessResponse(req);
		};
		req.send(null);
	}
}
function penAppProcessResponse(req) {
	if (req.readyState == 4) {
		if (req.status == 200) {

			try {
				var displayflag = 0;
				var baseResponse = req.responseXML
						.getElementsByTagName("response")[0];
				var tagCommand = baseResponse.getElementsByTagName("command")[0];
				var display = baseResponse.getElementsByTagName("record");
				var flag = baseResponse.getElementsByTagName("flag")[0].firstChild.nodeValue;

			} catch (e) {
				// alert(e.message);
				displayflag = 1;
				display = 0;
			}
			if ((display.length <= 0) || flag == "false" || flag == false
					|| displayflag == 1) {
				alert('Record Not Found');
				// defaultselection();
				window.location.reload();
			} else {

				for ( var i = 0; i < display.length; i++) {
					document.getElementById("empNo").value = nullcheck(baseResponse
							.getElementsByTagName("empid")[i].firstChild.nodeValue);
					var pinit = nullcheck(baseResponse
							.getElementsByTagName("empinit")[i].firstChild.nodeValue);
					document.getElementById("empInitial").value = pinit;
					var pname = nullcheck(baseResponse
							.getElementsByTagName("empname")[i].firstChild.nodeValue);
					document.getElementById("gpfNo").value = nullcheck(baseResponse
							.getElementsByTagName("gpfno")[i].firstChild.nodeValue);
					document.getElementById("dateofBirth").value = nullcheck(baseResponse
							.getElementsByTagName("dob")[i].firstChild.nodeValue);
					if (pinit != "" || pinit.length > 0) {
						document.getElementById("empName").value = pinit + '.'
								+ pname;
					} else {
						document.getElementById("empName").value = pname;
					}
					document.getElementById("office").value = nullcheck(baseResponse
							.getElementsByTagName("officename")[i].firstChild.nodeValue);
					document.getElementById("designation").value = nullcheck(baseResponse
							.getElementsByTagName("designation")[i].firstChild.nodeValue);
					var doj = nullcheck(baseResponse
							.getElementsByTagName("doj")[i].firstChild.nodeValue);
					var doj1 = nullcheck(baseResponse
							.getElementsByTagName("doj1")[i].firstChild.nodeValue);
					if (doj1 != "") {
						document.getElementById("twadDateofJoin").value = doj1;
					} else {
						document.getElementById("twadDateofJoin").value = doj;
					}
					var dojsession = nullcheck(baseResponse
							.getElementsByTagName("fromsession")[i].firstChild.nodeValue);
					var dojsession1 = nullcheck(baseResponse
							.getElementsByTagName("fromsession1")[i].firstChild.nodeValue);
					if (dojsession1 != "") {
						document.getElementById("twadDateofJoinsession").value = dojsession1
								+ "N";
					} else {
						document.getElementById("twadDateofJoinsession").value = dojsession;

					}
					var retiredate = nullcheck(baseResponse
							.getElementsByTagName("retiredate")[i].firstChild.nodeValue);
					document.getElementById("dar").value = retiredate;
					document.getElementById("gradeId").value = nullcheck(baseResponse
							.getElementsByTagName("grade")[i].firstChild.nodeValue);
					document.getElementById("officeId").value = nullcheck(baseResponse
							.getElementsByTagName("officeid")[i].firstChild.nodeValue);
					document.getElementById("desigId").value = nullcheck(baseResponse
							.getElementsByTagName("desigid")[i].firstChild.nodeValue);
					document.getElementById("desigServiceGrp").value = nullcheck(baseResponse
							.getElementsByTagName("desigservgrp")[i].firstChild.nodeValue);
					var empolyeestatus = nullcheck(baseResponse
							.getElementsByTagName("empStatusId")[i].firstChild.nodeValue);
					 //alert(empolyeestatus);
					if (empolyeestatus != "") {
						if ((empolyeestatus.toLowerCase() == "san")) {
                                    // alert("empolyeestatus::"+empolyeestatus);
							document.getElementById("classPensionId").selectedIndex = '1';
							document.getElementById("classPensionId").disabled = true;
							document.getElementById("classPensionId").style.background = '#dddddf';

						}
						if (empolyeestatus.toLowerCase() == "vrs") {
							document.getElementById("classPensionId").selectedIndex = '2';
							document.getElementById("vrs_date").value = doj;
							document.getElementById("classPensionId").disabled = true;
							document.getElementById("classPensionId").style.background = '#dddddf';

						}
						if (empolyeestatus.toLowerCase() == "dth") {
							document.getElementById("classPensionId").selectedIndex = '3';
							document.getElementById("death_date").value = doj;
							document.getElementById("vrs_date").disabled = true;
							document.getElementById("classPensionId").disabled = true;
							document.getElementById("classPensionId").style.background = '#dddddf';

						}

						if (empolyeestatus.toLowerCase() == "CMR") {
							alert("Compulsory Retirement Wont Support.");
							document.getElementById("classPensionId").value = "";
							document.getElementById("dar").value = "";
							document.getElementById("vrs_date").value = "";
							document.getElementById("death_date").value = "";
						}

						if (empolyeestatus.toLowerCase() == "MEV") {
							alert("Medical Invalidation Wont Support.");
							document.getElementById("classPensionId").value = "";
							document.getElementById("dar").value = "";
							document.getElementById("vrs_date").value = "";
							document.getElementById("death_date").value = "";
						}

						if (empolyeestatus.toLowerCase() == "DIS") {
							alert("Dismissal Wont Support.");
							document.getElementById("classPensionId").value = "";
							document.getElementById("dar").value = "";
							document.getElementById("vrs_date").value = "";
							document.getElementById("death_date").value = "";
						}
						if (empolyeestatus.toLowerCase() == "RES") {
							alert("Resignation Wont Support.");
							document.getElementById("classPensionId").value = "";
							document.getElementById("dar").value = "";
							document.getElementById("vrs_date").value = "";
							document.getElementById("death_date").value = "";
						}

					} else {
						alert("UPDATE THE CURRENT POSTING IN PHASE I.");
						document.getElementById("classPensionId").value = "";
						window.closed;
					}

					fetchEmployeeStatusData();
					typeofpension_selection();

				}
				try {

					fetchCalcOldData();
					fetchCommutedvalueData();

					// defaultselection();
				} catch (e) {
					// alert(e.message);
				}
			}
		}
	}
}

function fetchCalcOldData() {
	var empNo = document.getElementById("empNo").value;
	var url = "penAppForm1CalcFetchOldMstdata.html?pensionAppCalcForm1.empNo="
			+ empNo;
	var oldreq = getTransportWth();
	document.getElementById("empNo").value = empNo;
	oldreq.open("GET", url, true);
	oldreq.onreadystatechange = function() {
		penAppProcessCalcOldResponse(oldreq);
	};
	oldreq.send(null);
}

function penAppProcessCalcOldResponse(oldreq) {
	if (oldreq.readyState == 4) {
		if (oldreq.status == 200) {
			var oldflagcheck = 0;
			try {
				var oldbaseResponse = oldreq.responseXML
						.getElementsByTagName("oldresponse")[0];

				var tagCommand = oldbaseResponse
						.getElementsByTagName("oldcommand")[0];
				var olddisplay = oldbaseResponse
						.getElementsByTagName("oldrecord");
				var oldflag = oldbaseResponse.getElementsByTagName("oldflag")[0].firstChild.nodeValue;
			} catch (e) {
				olddisplay = "";
			}
			if (olddisplay.length <= 0 || oldflag == "false") {

				defaultselection();
				cleanPEN_DETAILS();
				cleanNON_QUAL_SER();
				cleanLPD();
				loadOldAE();
				loadOldRecovery();
			} else {
				for ( var j = 0; j < olddisplay.length; j++) {
					document.getElementById("scaleOfPay").value = nullcheck(oldbaseResponse
							.getElementsByTagName("SCALE_OF_PAY")[j].firstChild.nodeValue);
					document.getElementById("classPensionId").value = nullcheck(oldbaseResponse
							.getElementsByTagName("PENSION_TYPE")[j].firstChild.nodeValue);
					document.getElementById("province_date").value = nullcheck(oldbaseResponse
							.getElementsByTagName("DATE_OF_PROVINC")[j].firstChild.nodeValue);
					var doreges = nullcheck(oldbaseResponse
							.getElementsByTagName("DATE_OF_REG_ESTAB")[j].firstChild.nodeValue);
					if (doreges != "") {
						document.getElementById("regualr_estab_date").value = doreges;
						document.getElementById("regualr_estab_date").disabled = false;
						document.getElementById("regualr_estab_date").style.background = "#ffffff";
						document.getElementById("cal-button-10").style.display = "inline";
					} else {
						document.getElementById("regualr_estab_date").value = "";
					}

					var dosel = nullcheck(oldbaseResponse
							.getElementsByTagName("DATE_OF_SELECTION")[j].firstChild.nodeValue);
					if (dosel != "") {
						document.getElementById("selection_grade_date").value = dosel;
						document.getElementById("selection_grade_date").disabled = false;
						document.getElementById("selection_grade_date").style.background = "#ffffff";
						document.getElementById("cal-button-11").style.display = "inline";
					} else {
						document.getElementById("selection_grade_date").value = "";
					}

					var dospl = nullcheck(oldbaseResponse
							.getElementsByTagName("DATE_OF_SPECIAL")[j].firstChild.nodeValue);
					if (dospl != "") {
						document.getElementById("special_grade_date").value = dospl;
						document.getElementById("special_grade_date").disabled = false;
						document.getElementById("special_grade_date").style.background = "#ffffff";
						document.getElementById("cal-button-12").style.display = "inline";
					} else {
						document.getElementById("special_grade_date").value = "";
					}
					var dovrs = nullcheck(oldbaseResponse
							.getElementsByTagName("DATE_OF_VRS")[j].firstChild.nodeValue);

					if (dovrs != "") {
						document.getElementById("vrs_date").value = dovrs;
						/*
						 * document.getElementById("vrs_date").disabled=false;
						 * document.getElementById("vrs_date").style.background="#ffffff";
						 * document.getElementById("cal-button-7").style.display="inline";
						 */

						vrs_date_calc();

					} else {
						document.getElementById("vrs_date").value = "";
					}

					var dodeath = nullcheck(oldbaseResponse
							.getElementsByTagName("DEATH_DATE")[j].firstChild.nodeValue);
					if (dodeath != "") {
						document.getElementById("death_date").value = dodeath;
						/*
						 * document.getElementById("death_date").disabled=false;
						 * document.getElementById("death_date").style.background="#ffffff";
						 * document.getElementById("cal-button-13").style.display="inline";
						 */
						document.getElementById("pensionCommutedFlagYes").disabled = true;
						document.getElementById("pensionCommutedFlagNo").disabled = true;
						document.getElementById("pensionpertFlagonethird").disabled = true;
						document.getElementById("pensionpertFlagpert").disabled = true;
						death_date_calc();
						disabledaegrid();
					} else {
						document.getElementById("death_date").value = "";
						document.getElementById("pensionCommutedFlagYes").disabled = false;
						document.getElementById("pensionCommutedFlagNo").disabled = false;
						document.getElementById("pensionpertFlagonethird").disabled = false;
						document.getElementById("pensionpertFlagpert").disabled = false;
						enableaegrid();
					}

					var comopted = nullcheck(oldbaseResponse
							.getElementsByTagName("COMM_OPTED")[j].firstChild.nodeValue);
					if (comopted == "Yes") {
						document.getElementById("pensionCommutedFlagYes").checked = true;
					}
					if (comopted == "No") {
						document.getElementById("pensionCommutedFlagNo").checked = true;
					}
					var comfactoronethird = nullcheck(oldbaseResponse
							.getElementsByTagName("COMM_FACTOR_ONRTHIRD")[j].firstChild.nodeValue);
					if (comfactoronethird == "onethird") {
						document.getElementById("pensionpertFlagonethird").checked = true;
					}
					if (comfactoronethird == "pert") {
						document.getElementById("pensionpertFlagpert").checked = true;
					}
					var comfactorpert = nullcheck(oldbaseResponse
							.getElementsByTagName("COM_FACTOR_PERT")[j].firstChild.nodeValue);
					if (comfactorpert != "") {
						document.getElementById("commPert").value = comfactorpert;
						document.getElementById("commPert").disabled = false;
						document.getElementById("commPert").style.background = "#ffffff";
					} else {
						document.getElementById("commPert").value = "";
						document.getElementById("commPert").disabled = true;
						document.getElementById("commPert").style.background = "#dddddf";
					}

					var wcedays = nullcheck(oldbaseResponse
							.getElementsByTagName("WCE_SERV_DAYS")[j].firstChild.nodeValue);
					var wcemonth = nullcheck(oldbaseResponse
							.getElementsByTagName("WCE_SERV_MONTH")[j].firstChild.nodeValue);
					var wceyear = nullcheck(oldbaseResponse
							.getElementsByTagName("WCE_SERV_YEAR")[j].firstChild.nodeValue);
					if ((wcedays != "") || (wcemonth != "") || (wceyear != "")) {
						document.getElementById("wceday").value = wcedays;
						document.getElementById("wceday").disabled = false;
						document.getElementById("wceday").style.background = "#ffffff";

						document.getElementById("wcemonth").value = wcemonth;
						document.getElementById("wcemonth").disabled = false;
						document.getElementById("wcemonth").style.background = "#ffffff";

						document.getElementById("wceyear").value = wceyear;
						document.getElementById("wceyear").disabled = false;
						document.getElementById("wceyear").style.background = "#ffffff";
						wceserviceChange();
					} else {
						document.getElementById("wceday").value = "";
						document.getElementById("wceday").disabled = true;
						document.getElementById("wceday").style.background = "#dddddf";

						document.getElementById("wcemonth").value = "";
						document.getElementById("wcemonth").disabled = true;
						document.getElementById("wcemonth").style.background = "#dddddf";

						document.getElementById("wceyear").value = "";
						document.getElementById("wceyear").disabled = true;
						document.getElementById("wceyear").style.background = "#dddddf";
					}
					var wceserflag = nullcheck(oldbaseResponse
							.getElementsByTagName("WCE_SERV_FLAG")[j].firstChild.nodeValue);
					if (wceserflag == "Yes") {
						document.getElementById("wceserviceFlagYes").checked = true;
					}
					if (wceserflag == "No") {
						document.getElementById("wceserviceFlagNo").checked = true;
					}
					var wcesercountflag = nullcheck(oldbaseResponse
							.getElementsByTagName("WCE_SERV_COUNT_FLAG")[j].firstChild.nodeValue);
					if (wcesercountflag == "Yes") {
						document.getElementById("wcecountedFlagYes").checked = true;
					}
					if (wcesercountflag == "No") {
						document.getElementById("wcecountedFlagNo").checked = true;
					}
					calcwce();
					//cal_other_tot_net_qualified_service();

					var contingentdays = nullcheck(oldbaseResponse
							.getElementsByTagName("CONTINGENT_SERV_DAYS")[j].firstChild.nodeValue);
					var contingentmonth = nullcheck(oldbaseResponse
							.getElementsByTagName("CONTINGENT_SERV_MONTH")[j].firstChild.nodeValue);
					var contingentyear = nullcheck(oldbaseResponse
							.getElementsByTagName("CONTINGENT_SERV_YEAR")[j].firstChild.nodeValue);
					if ((contingentdays != "") || (contingentmonth != "")
							|| (contingentyear != "")) {
						document.getElementById("contingentday").value = contingentdays;
						document.getElementById("contingentday").disabled = false;
						document.getElementById("contingentday").style.background = "#ffffff";

						document.getElementById("contingentmonth").value = contingentmonth;
						document.getElementById("contingentmonth").disabled = false;
						document.getElementById("contingentmonth").style.background = "#ffffff";

						document.getElementById("contingentyear").value = contingentyear;
						document.getElementById("contingentyear").disabled = false;
						document.getElementById("contingentyear").style.background = "#ffffff";
						contingent_service_validation();
					} else {
						document.getElementById("contingentday").value = "";
						document.getElementById("contingentday").disabled = true;
						document.getElementById("contingentday").style.background = "#dddddf";

						document.getElementById("contingentmonth").value = "";
						document.getElementById("contingentmonth").disabled = true;
						document.getElementById("contingentmonth").style.background = "#dddddf";

						document.getElementById("contingentyear").value = "";
						document.getElementById("contingentyear").disabled = true;
						document.getElementById("contingentyear").style.background = "#dddddf";
					}
					var contingentserflag = nullcheck(oldbaseResponse
							.getElementsByTagName("CONTINGENT_SERV_FLAG")[j].firstChild.nodeValue);
					if (contingentserflag == "Yes") {
						document.getElementById("contingentserviceFlagYes").checked = true;
					}
					if (contingentserflag == "No") {
						document.getElementById("contingentserviceFlagNo").checked = true;
					}
					calccontingent();
					//cal_other_tot_cont_net_qualified_service();
					/**
					 * ********************************PENSION DETAILS
					 * END*****************************************************
					 */

					/**
					 * ********************************SERVICE DETAILS
					 * START*****************************************************
					 */

					document.getElementById("npp_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NON_PROV_SERV_DAYS")[j].firstChild.nodeValue);
					document.getElementById("npp_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NON_PROV_SERV_MONTH")[j].firstChild.nodeValue);
					document.getElementById("npp_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NON_PROV_SERV_YEAR")[j].firstChild.nodeValue);

					document.getElementById("ewm_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("EOL_DAYS")[j].firstChild.nodeValue);
					document.getElementById("ewm_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("EOL_MONTH")[j].firstChild.nodeValue);
					document.getElementById("ewm_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("EOL_YEAR")[j].firstChild.nodeValue);

					document.getElementById("s_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("SUSPENSION_DAYS")[j].firstChild.nodeValue);
					document.getElementById("s_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("SUSPENSION_MONTH")[j].firstChild.nodeValue);
					document.getElementById("s_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("SUSPENSION_YEAR")[j].firstChild.nodeValue);

					document.getElementById("bs_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("BOY_SERV_DAYS")[j].firstChild.nodeValue);
					document.getElementById("bs_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("BOY_SERV_MONTH")[j].firstChild.nodeValue);
					document.getElementById("bs_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("BOY_SERV_YEAR")[j].firstChild.nodeValue);

					document.getElementById("ol_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("OVERSTAY_LEAVE_DAYS")[j].firstChild.nodeValue);
					document.getElementById("ol_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("OVERSTAY_LEAVE_MONTH")[j].firstChild.nodeValue);
					document.getElementById("ol_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("OVERSTAY_LEAVE_YEAR")[j].firstChild.nodeValue);

					document.getElementById("lnr_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NOT_REG_LEAVE_DAYS")[j].firstChild.nodeValue);
					document.getElementById("lnr_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NOT_REG_LEAVE_MONTH")[j].firstChild.nodeValue);
					document.getElementById("lnr_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NOT_REG_LEAVE_YEAR")[j].firstChild.nodeValue);

					document.getElementById("as_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("APPRENTICE_DAYS")[j].firstChild.nodeValue);
					document.getElementById("as_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("APPRENTICE_MONTH")[j].firstChild.nodeValue);
					document.getElementById("as_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("APPRENTICE_YEAR")[j].firstChild.nodeValue);

					document.getElementById("svnd_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NOT_SERV_VERIFY_DAYS")[j].firstChild.nodeValue);
					document.getElementById("svnd_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NOT_SERV_VERIFY_MONTH")[j].firstChild.nodeValue);
					document.getElementById("svnd_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("NOT_SERV_VERIFY_YEAR")[j].firstChild.nodeValue);

					document.getElementById("fs_day").value = nullcheck(oldbaseResponse
							.getElementsByTagName("FOREIGN_SERV_DAYS")[j].firstChild.nodeValue);
					document.getElementById("fs_month").value = nullcheck(oldbaseResponse
							.getElementsByTagName("FOREIGN_SERV_MONTH")[j].firstChild.nodeValue);
					document.getElementById("fs_year").value = nullcheck(oldbaseResponse
							.getElementsByTagName("FOREIGN_SERV_YEAR")[j].firstChild.nodeValue);
					//calctotalnqs();
					// call the function calcworkservice()
					//calcworkservice();
					
					calcservice();

					/**
					 * ********************************SERVICE DETAILS
					 * END*****************************************************
					 */

					/**
					 * ********************************LAST PAY DRAWN DETAILS
					 * START*****************************************************
					 */

					var lastbasic = nullcheck(oldbaseResponse
							.getElementsByTagName("LAST_BASIC_PAY")[j].firstChild.nodeValue);
					var lastgrade = nullcheck(oldbaseResponse
							.getElementsByTagName("LAST_GRADE_PAY")[j].firstChild.nodeValue);
					var lastspecial = nullcheck(oldbaseResponse
							.getElementsByTagName("LAST_SPECIAL_PAY")[j].firstChild.nodeValue);
					var lastother1 = nullcheck(oldbaseResponse
							.getElementsByTagName("LAST_OTHER_PAY1")[j].firstChild.nodeValue);
					var lastother2 = nullcheck(oldbaseResponse
							.getElementsByTagName("LAST_OTHER_PAY2")[j].firstChild.nodeValue);
					var lastother3 = nullcheck(oldbaseResponse
							.getElementsByTagName("LAST_OTHER_PAY3")[j].firstChild.nodeValue);
					var lastlevel= nullcheck(oldbaseResponse.getElementsByTagName("LEVEL_OF_PAY")[j].firstChild.nodeValue);
                  //  alert("lastlevel::"+lastlevel);
					if (lastbasic == "") {
						lastbasic = 0;
					}
					if (lastgrade == "") {
						lastgrade = 0;
					}
					if (lastspecial == "") {
						lastspecial = 0;
					}
					if (lastother1 == "") {
						lastother1 = 0;
					}
					if (lastother2 == "") {
						lastother2 = 0;
					}
					if (lastother3 == "") {
						lastother3 = 0;
					}
					
					if(lastlevel=="")
	           		{
	           			lastlevel=0;
	           		}

					document.getElementById("lastbasic").value = lastbasic;
					document.getElementById("lastgrade").value = lastgrade;
					document.getElementById("lastspecial").value = lastspecial;
					document.getElementById("lastother1").value = lastother1;
					document.getElementById("lastother2").value = lastother2;
					document.getElementById("lastother3").value = lastother3;
					document.getElementById("lastlevel").value=lastlevel;
					
					/*var lasttotal = parseInt(lastbasic) + parseInt(lastgrade)
							+ parseInt(lastspecial) + parseInt(lastother1)
							+ parseInt(lastother2) + parseInt(lastother3);*/
					
					var lasttotal = parseInt(lastbasic) 
					+ parseInt(lastspecial) + parseInt(lastother1)
					+ parseInt(lastother2) + parseInt(lastother3);
					document.getElementById("lasttotal").value = lasttotal;

					/**
					 * ********************************LAST PAY DRAWN DETAILS
					 * END*****************************************************
					 */
														
					/*Other Department Service Details*/
					//alert("Flage details"+nullcheck(oldbaseResponse.getElementsByTagName("OTHDEPTSERVICE")[j].firstChild.nodeValue));
					var serflag=nullcheck(oldbaseResponse.getElementsByTagName("OTHDEPTSERVICE")[j].firstChild.nodeValue);
					if(serflag=="Yes")
						{
						document.getElementById("otherdeparmentserviceFlagYes").checked = true;
						try
						{
						loadOldOtherDeptService();
						enableDisableotherdepartmentDetails();
						}
						catch(e)
						{
							
						}
						// otherdepttotservice();
						
						}
					else if(serflag=="No")
						{
						//alert("else if checking"+serflag);
						document.getElementById("otherdeparmentserviceFlagNo").checked = true;
						enableDisableotherdepartmentDetails();
						}
					else
						{
						//alert("if checking"+serflag);
						document.getElementById("otherdeparmentserviceFlagNo").checked = true;
						enableDisableotherdepartmentDetails();
						}

				}
				
				
				
				
				
				

				try {
					loadOldAE();
				} catch (e) {

				}
				try {
					loadOldRecovery();
				} catch (e) {

				}
			}
			fetchCommutedvalueData();
		} else {
			defaultselection();

		}
	} else {
		defaultselection();
	}

}




function loadOldOtherDeptService()
{
	var empNo = document.getElementById("empNo").value;
	var url = 'penAppForm1CalcFetchOldOthDeptSerdata.html?pensionAppCalcForm1.empNo=' + empNo;
	var HttpAERequest = getTransportWth();
	HttpAERequest.open("GET", url, true);
	HttpAERequest.onreadystatechange = function() {
		if (HttpAERequest.readyState == 4) {

			var othdeptresponse = HttpAERequest.responseXML.getElementsByTagName("othdeptserviceresponse")[0];

			// Clearing the Existing data

			var othdeptservice =othdeptresponse.getElementsByTagName("othdeptrecord");
			deptrid=othdeptservice.length;
			/*try
			{
			alert(othdeptresponse.length);
			}
			catch(e)
			{
			alert(e.message);
			}*/
			
			//alert(othdeptservice.length);
			if (deptrid == 0)
			{
				//alert("Departmentidvalue"+deptrid);
				deleteotherdpetonload();
				
				document.getElementById("othdeptfromdate1").value = "";
				document.getElementById("othdepttodate1").value = "";
				document.getElementById("otdepyear1").value = "";
				document.getElementById("otdepmonth1").value = "";
				document.getElementById("othdeptday1").value = "";
				document.getElementById("Departmentname1").value = "";
				document.getElementById("Remarks1").value = "";
				
				/*tbodyvar = document.getElementById("othdeptser");
				if (tbodyvar.rows.length > 0) 
				{
					while (tbodyvar.rows.length > 0)
					{
						tbodyvar.deleteRow(0);
					}
				}*/
			} 
			else {
				
				
				
				for ( var i = 0; i < deptrid; i++)
				{
					

					
					var fromdate = nullcheck(othdeptservice[i]
							.getElementsByTagName("fromdate")[0].firstChild.nodeValue);
					
					var todate = nullcheck(othdeptservice[i]
							.getElementsByTagName("todate")[0].firstChild.nodeValue);
					var totyear = nullcheck(othdeptservice[i]
					            							.getElementsByTagName("totyear")[0].firstChild.nodeValue);
					var totmonth = nullcheck(othdeptservice[i]
							.getElementsByTagName("totmonth")[0].firstChild.nodeValue);
					var totdays = nullcheck(othdeptservice[i]
							.getElementsByTagName("totdays")[0].firstChild.nodeValue);
					var deptname = nullcheck(othdeptservice[i]
							.getElementsByTagName("deptname")[0].firstChild.nodeValue);
					var remark = nullcheck(othdeptservice[i]
							.getElementsByTagName("remark")[0].firstChild.nodeValue);
					
					tbodyvar=document.getElementById("othdeptser");
					//alert(tbodyvar.rows.length);
					/*
					if(tbodyvar.rows.length>0)
					{
						aid=tbodyvar.rows.length+1;
					}*/
					rid=i+1;
				//alert(rid);
					mycurrent_row=document.createElement("TR");	
				    mycurrent_row.id=rid;
				    //rid=mycurrent_row.id;
				   
				    cell1=document.createElement("TD");
				    cell1.setAttribute("align","center");
				          
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{
							hidden1=document.createElement("<input type='text'  name='othdeptfromdate' onkeypress='dtval(this,event)' id='othdeptfromdate"+rid+"' size='10' maxlength='10'  value='"+fromdate+"'  class='aetextbox' >");
						
					}
				  	else
				  	{       	  
				        
				  			hidden1=document.createElement("input");
				            hidden1.type="text";
				            hidden1.size="10";
				            hidden1.maxlength="10";
				            hidden1.name="othdeptfromdate";
				            hidden1.id="othdeptfromdate"+rid;
				            hidden1.className="aetextbox";
				            hidden1.value=fromdate;
				            hidden1.setAttribute('onkeypress', 'dtval(this,event)');
				           // hidden1.setAttribute('onblur','checkotherdeptdate(this.id)');
				         //     hidden1.setAttribute('onkeypress','return dtval1("fromdate",rid,event);');
					}
					cell1.appendChild(hidden1);
					mycurrent_row.appendChild(cell1); 

				       
					cell2=document.createElement("TD");
					cell2.setAttribute("align","center");
						
				           
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{

						hidden2=document.createElement("<input type='text'  name='othdepttodate' id='othdepttodate"+rid+"' onblur='javascript:checkotherdeptdate("+rid+");' size='10' maxlength='10' value='"+todate+"' onkeypress='dtval(this,event)' class='aetextbox' >");        	   	

					}
					else
					{
				    	hidden2=document.createElement("input");
				    	hidden2.type="text";
				    	hidden2.size="10";
						hidden2.maxlength="10";
				    	hidden2.name="othdepttodate";
				    	hidden2.setAttribute('onkeypress', 'dtval(this,event)');
				       	hidden2.id="othdepttodate"+rid;
				    	hidden2.onblur=function()
				       	{       			
				       		checkotherdeptdate(rid);
				       	};
				    	hidden2.className="aetextbox";
				    	hidden2.value=todate;
				    	
					}
				        	 
					cell2.appendChild(hidden2);
					mycurrent_row.appendChild(cell2); 
					
					
					cell3=document.createElement("TD");
					cell3.setAttribute("align","center");
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{

						hidden3=document.createElement("<input type='text'  name='otdepyear' id='otdepyear"+rid+"' size='4' maxlength='4' value='"+totyear+"'   readonly='true' style='background-color:#ececec' class='aetextboxmonth' >");        	   	

					}
					else
					{
						hidden3=document.createElement("input");
						hidden3.type="text";
						hidden3.size="4";
						hidden3.maxlength="4";
						hidden3.name="otdepyear";
						hidden3.id="otdepyear"+rid;
						hidden3.readOnly="true";
						hidden3.value=totyear;
						hidden3.className="aetextboxmonth";
						hidden3.style.background="#ececec";
				    	
					}
				        	 
					cell3.appendChild(hidden3);
					mycurrent_row.appendChild(cell3); 
					
					
					cell4=document.createElement("TD");
					cell4.setAttribute("align","center");
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{

						hidden4=document.createElement("<input type='text'  name='otdepmonth' id='otdepmonth"+rid+"' value='"+totmonth+"' size='4' maxlength='2' onkeypress='dtval(this,event)'  readonly='true' style='background-color:#ececec' class='aetextboxmonth' >");        	   	

					}
					else
					{
						hidden4=document.createElement("input");
						hidden4.type="text";
						hidden4.size="4";
						hidden4.maxlength="2";
						hidden4.name="otdepmonth";
						hidden4.id="otdepmonth"+rid;
						hidden4.value=totmonth;
						hidden4.readOnly="true";
						hidden4.className="aetextboxmonth";
						hidden4.style.background="#ececec";
				    	
					}
				        	 
					cell4.appendChild(hidden4);
					mycurrent_row.appendChild(cell4); 
					
					
					cell5=document.createElement("TD");
					cell5.setAttribute("align","center");
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{

						hidden5=document.createElement("<input type='text'  name='othdeptday' id='othdeptday"+rid+"' value='"+totdays+"' size='4' maxlength='2' readonly='true' style='background-color:#ececec' class='aetextboxmonth' >");        	   	

					}
					else
					{
						hidden5=document.createElement("input");
						hidden5.type="text";
						hidden5.size="4";
						hidden5.maxlength="2";
						hidden5.name="othdeptday";
						hidden5.id="othdeptday"+rid;
						hidden5.value=totdays;
						hidden5.readOnly="true";
						hidden5.className="aetextboxmonth";
						hidden5.style.background="#ececec";
				    	
					}
				        	 
					cell5.appendChild(hidden5);
					mycurrent_row.appendChild(cell5); 




					cell6=document.createElement("TD");
					cell6.setAttribute("align","center");
						
				           
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{

						hidden6=document.createElement("<input type='text'  name='Departmentname' id='Departmentname"+rid+"'  value='"+deptname+"' size='10'   class='recdescriptionbox' >");        	   	

					}
					else
					{
						hidden6=document.createElement("input");
						hidden6.type="text";
						hidden6.size="10";
						hidden6.name="Departmentname";
						hidden6.value=deptname;
						hidden6.id="Departmentname"+rid;
						hidden6.className="recdescriptionbox";
				    	
					}
				        	 
					cell6.appendChild(hidden6);
					mycurrent_row.appendChild(cell6); 
					
					
					cell7=document.createElement("TD");
					cell7.setAttribute("align","center");
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{

						hidden7=document.createElement("<input type='text'  name='Remarks' id='Remarks"+rid+"' value='"+remark+"' size='10'  class='recdescriptionbox' >");        	   	

					}
					else
					{
						hidden7=document.createElement("input");
						hidden7.type="text";
						hidden7.size="10";
						hidden7.name="Remarks";
						hidden7.id="Remarks"+rid;
						hidden7.value=remark;
						hidden7.className="recdescriptionbox";
				    	
					}
				        	 
					cell7.appendChild(hidden7);
					mycurrent_row.appendChild(cell7); 
					

					cell8=document.createElement("TD");
					cell8.setAttribute("align","center");
					cell8.setAttribute("width","7%");
					if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1)
					{  		 
						hidden8=document.createElement("<input type='button'  name='delete' id='delete' value='Delete'  onclick='deleteotherdpetrow("+rid+");'/>");			
					}
					else
					{		  
						hidden8=document.createElement("input");
						hidden8.type="button";
						hidden8.value="Delete";
						hidden8.name="delete";
						hidden8.id="delete";
						hidden8.setAttribute('onclick','deleteotherdpetrow('+rid+');');
						//hidden13.setAttribute('onclick','delrow(this);');		    
					}
				  	cell8.appendChild(hidden8);
				  	mycurrent_row.appendChild(cell8);
				  
				   
				  	tbodyvar.appendChild(mycurrent_row);    
				  	
				  	
				}
				  		
					try
					{
					otherdepttotservice();
					}
					catch(e)
					{
						alert(e.message);
					}
                  
						
					}
			
			
			
				}
				
			

	

	};
	HttpAERequest.send(null);


}

function loadOldAE() {

	var empNo = document.getElementById("empNo").value;
	var url = 'penAppForm1CalcFetchOldAEdata.html?pensionAppCalcForm1.empNo=' + empNo;
	//alert("url"+url);
	var HttpAERequest = getTransportWth();
	HttpAERequest.open("GET", url, true);
	HttpAERequest.onreadystatechange = function() {
		if (HttpAERequest.readyState == 4) {

			var aeresponse = HttpAERequest.responseXML
					.getElementsByTagName("aeresponse")[0];

			// Clearing the Existing data
           //  alert("aeresponce::"+aeresponse);
			var aeservice = aeresponse.getElementsByTagName("aerecord");
            
			if (aeservice.length == 0) {
				document.getElementById("maxcheck").checked = false;
				document.getElementById("maxcheck_value").value = "";
				document.getElementById("fromdate").value = "";
				document.getElementById("todate").value = "";
				document.getElementById("tmonth").value = "";
				document.getElementById("tday").value = "";
				document.getElementById("basic_pay").value = "";
				document.getElementById("grade_pay").value = "";
				document.getElementById("special_pay").value = "";
				document.getElementById("optionpay1").value = "";
				document.getElementById("optionpay2").value = "";
				document.getElementById("optionpay3").value = "";
				document.getElementById("ppamount").value = "";
				document.getElementById("amount").value = "";
				document.getElementById("finaltotalppamount").value = "";
				tbodyvar = document.getElementById("test");
				if (tbodyvar.rows.length > 0) {
					while (tbodyvar.rows.length > 0) {
						tbodyvar.deleteRow(0);
					}
				}
			} else {
				
				var aetotppamount = 0;
				for ( var i = 0; i < aeservice.length; i++) {

					var nc = nullcheck(aeservice[i].getElementsByTagName("nc")[0].firstChild.nodeValue);
					var fromdate = nullcheck(aeservice[i]
							.getElementsByTagName("fromdate")[0].firstChild.nodeValue);
					var todate = nullcheck(aeservice[i]
							.getElementsByTagName("todate")[0].firstChild.nodeValue);
					var totmonth = nullcheck(aeservice[i]
							.getElementsByTagName("totmonth")[0].firstChild.nodeValue);
					var totdays = nullcheck(aeservice[i]
							.getElementsByTagName("totdays")[0].firstChild.nodeValue);
					var basic = nullcheck(aeservice[i]
							.getElementsByTagName("basic")[0].firstChild.nodeValue);
					
					var grade = nullcheck(aeservice[i]
							.getElementsByTagName("grade")[0].firstChild.nodeValue);
					
					var special = nullcheck(aeservice[i]
							.getElementsByTagName("special")[0].firstChild.nodeValue);
					var other1 = nullcheck(aeservice[i]
							.getElementsByTagName("other1")[0].firstChild.nodeValue);
					var other2 = nullcheck(aeservice[i]
							.getElementsByTagName("other2")[0].firstChild.nodeValue);
					var other3 = nullcheck(aeservice[i]
							.getElementsByTagName("other3")[0].firstChild.nodeValue);
					var ppamount = nullcheck(aeservice[i]
							.getElementsByTagName("ppamount")[0].firstChild.nodeValue);
					

					aetotppamount = parseInt(aetotppamount)
							+ parseInt(ppamount);

					var totalamount = 0;
					var basicpay = 0;
					var gradepay = 0;
					var specialpay = 0;
					var optionpay1 = 0;
					var optionpay2 = 0;
					var optionpay3 = 0;
					var levelofpay=0;

					if (basic != "") {
						basicpay = basic;
					}
					if (grade != "") {
						gradepay = grade;
					}
					if (special != "") {
						specialpay = special;
					}
					if (other1 != "") {
						optionpay1 = other1;
					}
					if (other2 != "") {
						optionpay2 = other2;
					}
					if (other3 != "") {
						optionpay3 = other3;
					}
					/*totalamount = parseInt(basicpay) + parseInt(gradepay)
							+ parseInt(specialpay) + parseInt(optionpay1)
							+ parseInt(optionpay2) + parseInt(optionpay3);*/
					
					totalamount = parseInt(basicpay)
					+ parseInt(specialpay) + parseInt(optionpay1)
					+ parseInt(optionpay2) + parseInt(optionpay3);
				

					if ((aeservice.length) == 1) {

						document.getElementById("maxcheck_value").value = nc;
						document.getElementById("fromdate").value = fromdate;
						document.getElementById("todate").value = todate;
						document.getElementById("tmonth").value = totmonth;
						document.getElementById("tday").value = totdays;
						document.getElementById("basic_pay").value = basic;
						document.getElementById("grade_pay").value = grade;
						document.getElementById("special_pay").value = special;
						document.getElementById("optionpay1").value = other1;
						document.getElementById("optionpay2").value = other2;
						document.getElementById("optionpay3").value = other3;
						document.getElementById("ppamount").value = ppamount;
						document.getElementById("amount").value = totalamount;
						document.getElementById("levelofpay").value = level;

					} else {
						if (i >= 1) {
							try {
								ChangeAeGrid(nc, fromdate, todate, totmonth,
										totdays, basic, grade, special, other1,
										other2, other3, totalamount, ppamount);
							} catch (e) {
								alert(e.message);
							}
						}
						if (i == 0) {
							if (nc == "Y") {
								document.getElementById("maxcheck").checked = 'checked';
							}
							document.getElementById("maxcheck_value").value = nc;
							document.getElementById("fromdate").value = fromdate;
							document.getElementById("todate").value = todate;
							document.getElementById("tmonth").value = totmonth;
							document.getElementById("tday").value = totdays;
							document.getElementById("basic_pay").value = basic;
							document.getElementById("grade_pay").value = grade;
							document.getElementById("special_pay").value = special;
							document.getElementById("optionpay1").value = other1;
							document.getElementById("optionpay2").value = other2;
							document.getElementById("optionpay3").value = other3;
							document.getElementById("ppamount").value = ppamount;
							document.getElementById("amount").value = totalamount;
							/*document.getElementById("levelofpay").value = level;
							alert("level");*/
							
						}
					}
				}
				var aetotmonth = document.getElementById("Avg_total_months").value;
				aetotppamount = Math.round(aetotppamount / aetotmonth);
				document.getElementById("finaltotalppamount").value = aetotppamount;
			}

		}

	};
	HttpAERequest.send(null);
}

function nullcheck1() {
	// alert("Inside Null Check");
	document.getElementById("maxcheck").checked = false;
	document.getElementById("dar").value = "";
	document.getElementById("maxcheck_value").value = "";
	document.getElementById("fromdate").value = "";
	document.getElementById("todate").value = "";
	document.getElementById("tmonth").value = "";
	document.getElementById("tday").value = "";
	document.getElementById("basic_pay").value = "";
	document.getElementById("grade_pay").value = "";
	document.getElementById("special_pay").value = "";
	document.getElementById("optionpay1").value = "";
	document.getElementById("optionpay2").value = "";
	document.getElementById("optionpay3").value = "";
	document.getElementById("ppamount").value = "";
	document.getElementById("amount").value = "";
	document.getElementById("finaltotalppamount").value = "";
	document.getElementById("maxcheck_value").value = "";
	document.getElementById("fromdate").value = "";
	document.getElementById("todate").value = "";
	document.getElementById("tmonth").value = "";
	document.getElementById("tday").value = "";
	document.getElementById("basic_pay").value = "";
	document.getElementById("grade_pay").value = "";
	document.getElementById("special_pay").value = "";
	document.getElementById("optionpay1").value = "";
	document.getElementById("optionpay2").value = "";
	document.getElementById("optionpay3").value = "";
	document.getElementById("ppamount").value = "";
	document.getElementById("amount").value = "";
	document.getElementById("maxcheck_value").value = "";
	document.getElementById("fromdate").value = "";
	document.getElementById("todate").value = "";
	document.getElementById("tmonth").value = "";
	document.getElementById("tday").value = "";
	document.getElementById("basic_pay").value = "";
	document.getElementById("grade_pay").value = "";
	document.getElementById("special_pay").value = "";
	document.getElementById("optionpay1").value = "";
	document.getElementById("optionpay2").value = "";
	document.getElementById("optionpay3").value = "";
	document.getElementById("ppamount").value = "";
	document.getElementById("amount").value = "";
}
/**
 * ***********************************Change row in grid function
 * start******************************************
 */

// function ChangeAeGrid()
function ChangeAeGrid(nc, fromdate, todate, totmonth, totdays, basic, grade,
		special, other1, other2, other3, totalamount, ppamount) {

	var basic_payname = document.getElementById("avg_pay_name_basic").value;
	var basic_include = document.getElementById("avg_include_basic").value;
	var basic_da = document.getElementById("avg_da_basic").value;
	var basic_display_description = document
			.getElementById("avg_display_caption_basic").value;

	var grade_payname = document.getElementById("avg_pay_name_grade").value;
	var grade_include = document.getElementById("avg_include_grade").value;
	var grade_da = document.getElementById("avg_da_grade").value;
	var grade_display_description = document
			.getElementById("avg_display_caption_grade").value;

	var special_payname = document.getElementById("avg_pay_name_special").value;
	var special_include = document.getElementById("avg_include_special").value;
	var special_da = document.getElementById("avg_da_special").value;
	var special_display_description = document
			.getElementById("avg_display_caption_special").value;

	var other1_payname = document.getElementById("avg_pay_name_other1").value;
	var other1_include = document.getElementById("avg_include_other1").value;
	var other1_da = document.getElementById("avg_da_other1").value;
	var other1_display_description = document
			.getElementById("avg_display_caption_other1").value;

	var other2_payname = document.getElementById("avg_pay_name_other2").value;
	var other2_include = document.getElementById("avg_include_other2").value;
	var other2_da = document.getElementById("avg_da_other2").value;
	var other2_display_description = document
			.getElementById("avg_display_caption_other2").value;

	var other3_payname = document.getElementById("avg_pay_name_other3").value;
	var other3_include = document.getElementById("avg_include_other3").value;
	var other3_da = document.getElementById("avg_da_other3").value;
	var other3_display_description = document
			.getElementById("avg_display_caption_other3").value;
	
	
	var level_payname = document.getElementById("avg_pay_name_level").value;
	var level_include = document.getElementById("avg_include_level").value;
	var level_da = document.getElementById("avg_da_level").value;
	var level_display_description = document
			.getElementById("avg_display_caption_level").value;
	

	tbodyvar = document.getElementById("test");
	aid = 1;
	if (tbodyvar.rows.length > 0) {
		aid = tbodyvar.rows.length + 1;
	}
	mycurrent_row = document.createElement("TR");
	mycurrent_row.id = aid;
	rid = mycurrent_row.id;

	cellcheck = document.createElement("TD");
	cellcheck.setAttribute("align", "center");
	// cellcheck.setAttribute("width","3%");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {

		hiddencheck_maxcheck_value = document
				.createElement("<input type='hidden' name='maxcheck_value' id='maxcheck_value' value='"
						+ nc + "'>");
		cellcheck.appendChild(hiddencheck_maxcheck_value);
		mycurrent_row.appendChild(cellcheck);
	} else {
		hiddencheck_maxcheck_value = document.createElement("input");
		hiddencheck_maxcheck_value.type = "hidden";
		hiddencheck_maxcheck_value.value = nc;
		hiddencheck_maxcheck_value.size = "10";
		hiddencheck_maxcheck_value.name = "maxcheck_value";
		hiddencheck_maxcheck_value.id = "maxcheck_value";
	}
	cellcheck.appendChild(hiddencheck_maxcheck_value);
	mycurrent_row.appendChild(cellcheck);

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		if (nc == 'Y') {
			hiddencheck = document
					.createElement("<input type='checkbox' name='maxcheck' id='maxcheck' checked='checked' value='"
							+ rid + "' onclick='checkfun1(this.value)' />");
		} else {
			hiddencheck = document
					.createElement("<input type='checkbox' name='maxcheck' id='maxcheck' value='"
							+ rid + "' onclick='checkfun1(this.value)' />");
		}
		cellcheck.appendChild(hiddencheck);
		mycurrent_row.appendChild(cellcheck);
	} else {
		hiddencheck = document.createElement("input");
		hiddencheck.type = "checkbox";
		hiddencheck.value = rid;
		hiddencheck.size = "10";
		hiddencheck.name = "maxcheck";
		hiddencheck.id = "maxcheck";
		hiddencheck.setAttribute('onclick', 'checkfun1(this.value)');
		if (nc == 'Y') {
			hiddencheck.checked = "checked";
		}
	}
	cellcheck.appendChild(hiddencheck);
	mycurrent_row.appendChild(cellcheck);

	cell1 = document.createElement("TD");
	cell1.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		pretoval = parseInt(rid) - 1;

		if (rid == 1) {

			nextval = document.AEForm.todate.value;
			var datesplit = nextval.split("/");
			var dateday = datesplit[0];
			var datemonth = datesplit[1] - 1;
			var dateyear = datesplit[2];
			var d1 = new Date(dateyear, datemonth, dateday);

			d1.setDate(d1.getDate() + 1);
			var dismonth = parseInt(d1.getMonth()) + 1;
			nextval = d1.getDate() + "/" + dismonth + "/" + d1.getFullYear();

		}
		if (rid > 1) {

			nextval = document.AEForm.todate[pretoval].value;
			var datesplit = nextval.split("/");
			var dateday = datesplit[0];
			var datemonth = datesplit[1] - 1;
			var dateyear = datesplit[2];
			var d1 = new Date(dateyear, datemonth, dateday);
			d1.setDate(d1.getDate() + 1);
			var dismonth = parseInt(d1.getMonth()) + 1;
			nextval = d1.getDate() + "/" + dismonth + "/" + d1.getFullYear();

			document.AEForm.fromdate[pretoval].readOnly = true;

		}

		hidden1 = document
				.createElement("<input type='text'  name='fromdate' id='fromdate' size='10' maxlength='10' style='text-align: left;background-color: #ececec;' value='"
						+ fromdate
						+ "' readOnly='true' class='aetextbox' onchange='javascript:return checkdate1("
						+ rid + ");'>");

	} else {

		hidden1 = document.createElement("input");
		hidden1.type = "text";
		hidden1.size = "10";
		hidden1.maxlength = "10";
		hidden1.name = "fromdate";
		hidden1.id = "fromdate";
		hidden1.readOnly = "true";
		hidden1.style.backgroundColor = '#ececec';
		hidden1.className = "aetextbox";
		hidden1.setAttribute('onchange', 'checkdate1(' + rid + ');');
		// pretoval=parseInt(rid)-1;
		// alert(document.AEForm.fromdate.length);
		pretoval = parseInt(document.AEForm.fromdate.length) - 1;
		if (rid == 1) {

			nextval = document.AEForm.todate.value;

			var datesplit = nextval.split("/");
			var dateday = datesplit[0];
			var datemonth = datesplit[1] - 1;
			var dateyear = datesplit[2];
			var d1 = new Date(dateyear, datemonth, dateday);

			d1.setDate(d1.getDate() + 1);
			var dismonth = parseInt(d1.getMonth()) + 1;
			nextval = d1.getDate() + "/" + dismonth + "/" + d1.getFullYear();
		}
		if (rid > 1) {

			nextval = document.AEForm.todate[pretoval].value;
			var datesplit = nextval.split("/");
			var dateday = datesplit[0];
			var datemonth = datesplit[1] - 1;
			var dateyear = datesplit[2];
			var d1 = new Date(dateyear, datemonth, dateday);

			d1.setDate(d1.getDate() + 1);
			var dismonth = parseInt(d1.getMonth()) + 1;
			nextval = d1.getDate() + "/" + dismonth + "/" + d1.getFullYear();

			document.AEForm.fromdate[pretoval].readOnly = true;
		}

		hidden1.value = fromdate;
		hidden1.setAttribute('onkeypress',
				'return dtval1("fromdate",rid,event);');
	}
	cell1.appendChild(hidden1);
	mycurrent_row.appendChild(cell1);

	cell2 = document.createElement("TD");
	cell2.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {

		hidden2 = document
				.createElement("<input type='text'  name='todate' id='todate' value='"
						+ todate
						+ "' size='10' maxlength='10' style='text-align: left' class='aetextbox' onkeypress='javascript:return dtval1(\"todate\","
						+ rid
						+ ",event);' onblur='javascript:return checkdate1("
						+ rid + ");'>");

	} else {
		hidden2 = document.createElement("input");
		hidden2.type = "text";
		hidden2.size = "10";
		hidden2.maxlength = "10";
		hidden2.name = "todate";
		hidden2.id = "todate";
		hidden2.value = todate;
		hidden2.className = "aetextbox";
		hidden2.setAttribute('onkeypress',
				'dtval1_mozilla("todate",' + rid + ',event);');
		hidden2.setAttribute('onblur', 'checkdate1(' + rid + ');');
	}

	cell2.appendChild(hidden2);
	mycurrent_row.appendChild(cell2);

	cell10 = document.createElement("TD");
	cell10.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden10 = document
				.createElement("<input type='text'  name='tmonth' id='tmonth' value='"
						+ totmonth
						+ "' size='4' maxlength='2' style='text-align: left;background-color: #ececec;' readonly='true' class='aetextboxmonth'>");
	} else {
		hidden10 = document.createElement("input");
		hidden10.type = "text";
		hidden10.size = "4";
		hidden10.maxlength = "2";
		hidden10.name = "tmonth";
		hidden10.value = totmonth;
		hidden10.style.backgroundColor = '#ececec';
		hidden10.readOnly = true;
		hidden10.id = "tmonth";
		hidden10.className = "aetextboxmonth";
	}

	cell10.appendChild(hidden10);
	mycurrent_row.appendChild(cell10);

	cell11 = document.createElement("TD");
	cell11.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden11 = document
				.createElement("<input type='text'  name='tday' id='tday' value='"
						+ totdays
						+ "' size='4' maxlength='2' style='text-align: left;background-color: #ececec;' readonly='true' class='aetextboxmonth'>");
	} else {
		hidden11 = document.createElement("input");
		hidden11.type = "text";
		hidden11.size = "4";
		hidden11.maxlength = "2";
		hidden11.name = "tday";
		hidden11.value = totdays;
		hidden11.style.backgroundColor = '#ececec';
		hidden11.readOnly = true;
		hidden11.id = "tday";
		hidden11.className = "aetextboxmonth";
	}

	cell11.appendChild(hidden11);
	mycurrent_row.appendChild(cell11);

	cell3 = document.createElement("TD");
	cell3.setAttribute("align", "center");
	if (basic_include == "N") {
		cell3.style.display = "none";
	}

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden3 = document
				.createElement("<input type='text'  name='basic_pay' id='basic_pay' value='"
						+ basic
						+ "' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("
						+ rid + ")'>");
		hidden3.onkeypress = function() {
			return numonly(event);
		};
	} else {

		hidden3 = document.createElement("input");
		hidden3.type = "text";
		hidden3.size = "10";
		hidden3.style.textAlign = "right";
		hidden3.name = "basic_pay";
		hidden3.id = "basic_pay";
		hidden3.value = basic;
		hidden3.className = "aetextbox";

		hidden3.setAttribute('onkeypress', 'return numonly(event)');
		hidden3.setAttribute('onchange', 'calctotamount1(' + rid + ')');
	}
	cell3.appendChild(hidden3);
	mycurrent_row.appendChild(cell3);

	cell4 = document.createElement("TD");
	cell4.setAttribute("align", "center");
	if (grade_include == "N") {
		cell4.style.display = "none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		/*hidden4 = document
				.createElement("<input type='text'  name='grade_pay' id='grade_pay' value='"
						+ grade
						+ "' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("
						+ rid + ")'>");
		hidden4.onkeypress = function() {
			return numonly(event);
		};*/
	} else {
		/*hidden4 = document.createElement("input");
		hidden4.type = "text";
		hidden4.size = "10";
		hidden4.style.textAlign = "right";
		hidden4.name = "grade_pay";
		hidden4.id = "grade_pay";
		hidden4.value = grade;
		hidden4.className = "aetextbox";

		hidden4.setAttribute('onkeypress', 'return numonly(event)');
		hidden4.setAttribute('onchange', 'calctotamount1(' + rid + ')');*/
	}
	//alert("cell");
	//cell4.appendChild(hidden4);
//	mycurrent_row.appendChild(cell4);

	cell5 = document.createElement("TD");
	cell5.setAttribute("align", "center");
	if (special_include == "N") {
		cell5.style.display = "none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden5 = document
				.createElement("<input type='text'  name='special_pay' id='special_pay' value='"
						+ special
						+ "' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("
						+ rid + ")'>");
		hidden5.onkeypress = function() {
			return numonly(event);
		};
	} else {
		hidden5 = document.createElement("input");
		hidden5.type = "text";
		hidden5.size = "10";
		hidden5.style.textAlign = "right";
		hidden5.name = "special_pay";
		hidden5.id = "special_pay";
		hidden5.value = special;
		hidden5.className = "aetextbox";

		hidden5.setAttribute('onkeypress', 'return numonly(event)');
		hidden5.setAttribute('onchange', 'calctotamount1(' + rid + ')');
	}
	cell5.appendChild(hidden5);
	mycurrent_row.appendChild(cell5);

	cell6 = document.createElement("TD");
	cell6.setAttribute("align", "center");
	if (other1_include == "N") {
		cell6.style.display = "none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden6 = document
				.createElement("<input type='text'  name='optionpay1' id='optionpay1' value='"
						+ other1
						+ "' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("
						+ rid + ")'>");
		hidden6.onkeypress = function() {
			return numonly(event);
		};
	} else {
		hidden6 = document.createElement("input");
		hidden6.type = "text";
		hidden6.size = "10";
		hidden6.style.textAlign = "right";
		hidden6.name = "optionpay1";
		hidden6.id = "optionpay1";
		hidden6.value = other1;
		hidden6.className = "aetextbox";

		hidden6.setAttribute('onkeypress', 'return numonly(event)');
		hidden6.setAttribute('onchange', 'calctotamount1(' + rid + ')');
	}
	cell6.appendChild(hidden6);
	mycurrent_row.appendChild(cell6);

	cell7 = document.createElement("TD");
	cell7.setAttribute("align", "center");
	if (other2_include == "N") {
		cell7.style.display = "none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden7 = document
				.createElement("<input type='text'  name='optionpay2' id='optionpay2' value='"
						+ other2
						+ "' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("
						+ rid + ")'>");
		hidden7.onkeypress = function() {

			return numonly(event);
		};
	} else {
		hidden7 = document.createElement("input");
		hidden7.type = "text";
		hidden7.size = "10";
		hidden7.style.textAlign = "right";
		hidden7.name = "optionpay2";
		hidden7.id = "optionpay2";
		hidden7.className = "aetextbox";
		hidden7.value = other2;
		hidden7.setAttribute('onkeypress', 'return numonly(event)');
		hidden7.setAttribute('onchange', 'calctotamount1(' + rid + ')');
	}
	cell7.appendChild(hidden7);
	mycurrent_row.appendChild(cell7);

	cell8 = document.createElement("TD");
	cell8.setAttribute("align", "center");
	if (other3_include == "N") {
		cell8.style.display = "none";
	}
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden8 = document
				.createElement("<input type='text'  name='optionpay3' id='optionpay3' value='"
						+ other3
						+ "' size='10' style='text-align:right;' class='aetextbox' onchange='javascript:calctotamount1("
						+ rid + ")'>");
		hidden8.onkeypress = function() {
			return numonly(event);
		};
	} else {
		hidden8 = document.createElement("input");
		hidden8.type = "text";
		hidden8.size = "10";
		hidden8.style.textAlign = "right";
		hidden8.name = "optionpay3";
		hidden8.id = "optionpay3";
		hidden8.value = other3;
		hidden8.className = "aetextbox";

		hidden8.setAttribute('onkeypress', 'return numonly(event)');
		hidden8.setAttribute('onchange', 'calctotamount1(' + rid + ')');
	}
	cell8.appendChild(hidden8);
	mycurrent_row.appendChild(cell8);

	cell9 = document.createElement("TD");
	cell9.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden9 = document
				.createElement("<input type='text'  name='amount' id='amount' value='"
						+ totalamount
						+ "' size='10' style='text-align:right;background-color:#ececec;' class='aetextbox' readonly='true'>");
		hidden9.onkeypress = function() {
			return numonly(event);
		};
	} else {
		hidden9 = document.createElement("input");
		hidden9.type = "text";
		hidden9.size = "10";
		hidden9.style.textAlign = "right";
		hidden9.name = "amount";
		hidden9.id = "amount";
		hidden9.value = totalamount;
		hidden9.readonly = true;
		hidden9.style.backgroundColor = '#ececec';
		hidden9.className = "aetextbox";

		hidden9.setAttribute('onkeypress', 'return numonly(event)');
	}
	cell9.appendChild(hidden9);
	mycurrent_row.appendChild(cell9);

	cell12 = document.createElement("TD");
	cell12.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden12 = document
				.createElement("<input type='text'  name='ppamount' id='ppamount' value='"
						+ ppamount
						+ "' size='10' style='text-align:right;background-color:#ececec;' class='aetextbox' readonly='true'>");
	} else {
		hidden12 = document.createElement("input");
		hidden12.type = "text";
		hidden12.size = "10";
		hidden12.style.textAlign = "right";
		hidden12.name = "ppamount";
		hidden12.id = "ppamount";
		hidden12.value = ppamount;
		hidden12.readonly = true;
		hidden12.style.backgroundColor = '#ececec';
		hidden12.className = "aetextbox";
	}
	cell12.appendChild(hidden12);
	mycurrent_row.appendChild(cell12);

	cell13 = document.createElement("TD");
	cell13.setAttribute("align", "center");
	cell13.setAttribute("width", "7%");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		hidden13 = document
				.createElement("<input type='button'  name='delete' id='delete' value='Delete'  onclick='deleterow("
						+ rid + ");'/>");
	} else {
		hidden13 = document.createElement("input");
		hidden13.type = "button";
		hidden13.value = "Delete";
		hidden13.name = "delete";
		hidden13.id = "delete";
		hidden13.setAttribute('onclick', 'delrow(' + rid + ');');
		// hidden13.setAttribute('onclick','delrow(this);');
	}
	cell13.appendChild(hidden13);
	mycurrent_row.appendChild(cell13);

	tbodyvar.appendChild(mycurrent_row);
	aid++;

}

/**
 * **************************************************************Change row in
 * grid function end******************************************
 */

function loadOldRecovery() {
	var empNo = document.getElementById("empNo").value;
	var url = 'penAppForm1CalcFetchOldRecdata.html?pensionAppCalcForm1.empNo='
			+ empNo + "&rid=" + Math.random();
	var HttpRecRequest = getTransportWth();
	HttpRecRequest.open("GET", url, true);
	HttpRecRequest.onreadystatechange = function() {
		if (HttpRecRequest.readyState == 4) {

			var recresponse = HttpRecRequest.responseXML
					.getElementsByTagName("recresponse")[0];

			var recservice = recresponse.getElementsByTagName("recrecord");
			if (recservice.length == 0) {

				document.getElementById("rec_description").value = "";
				document.getElementById("rec_amount").value = "";
				document.getElementById("finaltotalrecamount").value = "";

				tbodyvar = document.getElementById("rectest");
				if (tbodyvar.rows.length > 0) {
					while (tbodyvar.rows.length > 0) {
						tbodyvar.deleteRow(0);
					}
				}

			} else {
				var rectotalamount = 0;
				for ( var i = 0; i < recservice.length; i++) {

					var recdescription = nullcheck(recservice[i]
							.getElementsByTagName("recdescription")[0].firstChild.nodeValue);
					var amount = nullcheck(recservice[i]
							.getElementsByTagName("recamount")[0].firstChild.nodeValue);

					var recamount = 0;
					var gradepay = 0;
					var specialpay = 0;
					var optionpay1 = 0;
					var optionpay2 = 0;
					var optionpay3 = 0;

					if (amount != "") {
						recamount = amount;
						rectotalamount = parseInt(rectotalamount)
								+ parseInt(recamount);
					}

					if ((recservice.length) == 1) {

						document.getElementById("rec_description").value = recdescription;
						document.getElementById("rec_amount").value = recamount;

					} else {
						if (i >= 1) {
							try {
								ChangeRecGrid(recdescription, recamount);
							} catch (e) {
								// alert(e.message);
							}
						}
						if (i == 0) {
							document.getElementById("rec_description").value = recdescription;
							document.getElementById("rec_amount").value = recamount;
						}
					}
				}
				document.getElementById("finaltotalrecamount").value = rectotalamount;
			}

		}

	};
	HttpRecRequest.send(null);
}

/**
 * ***********************************Change row in grid function
 * start******************************************
 */

function ChangeRecGrid(recdescription, recamount) {

	tbodyvar = document.getElementById("rectest");
	recaid = 1;
	if (tbodyvar.rows.length > 0) {
		recaid = tbodyvar.rows.length + 1;
	}
	mycurrent_recrow = document.createElement("TR");
	mycurrent_recrow.id = "rec" + recaid;
	rid = mycurrent_recrow.id;

	reccell1 = document.createElement("TD");
	reccell1.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		rechidden1 = document
				.createElement("<input type='text'  name='rec_description' id='rec_description' value='"
						+ recdescription + "' class='recdescriptionbox'>");
	} else {
		rechidden1 = document.createElement("input");
		rechidden1.type = "text";
		rechidden1.style.textAlign = "left";
		rechidden1.name = "rec_description";
		rechidden1.id = "rec_description";
		rechidden1.value = recdescription;
		rechidden1.className = "recdescriptionbox";
	}
	reccell1.appendChild(rechidden1);
	mycurrent_recrow.appendChild(reccell1);

	reccell2 = document.createElement("TD");
	reccell2.setAttribute("align", "center");

	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		rechidden2 = document
				.createElement("<input type='text'  name='rec_amount' id='rec_amount' value='"
						+ recamount
						+ "' style='text-align:right;' onkeypress='return numonly(event);' onchange='refresh_totalrecamount();' class='recamountbox'>");
	} else {
		rechidden2 = document.createElement("input");
		rechidden2.type = "text";
		rechidden2.style.textAlign = "right";
		rechidden2.name = "rec_amount";
		rechidden2.id = "rec_amount";
		rechidden2.value = recamount;
		rechidden2.className = "recamountbox";
		rechidden2.setAttribute('onkeypress', 'return numonly(event);');
		rechidden2.setAttribute('onchange', 'refresh_totalrecamount();');
	}
	reccell2.appendChild(rechidden2);
	mycurrent_recrow.appendChild(reccell2);

	reccell3 = document.createElement("TD");
	reccell3.setAttribute("align", "center");
	reccell3.setAttribute("width", "10%");
	if (window.navigator.appName.toLowerCase().indexOf("netscape") == -1) {
		rechidden3 = document.createElement("<input type='button'  name='"
				+ rid + "' id='" + rid
				+ "' value='Delete'  onclick='deleterecrow(this);'/>");
	} else {
		rechidden3 = document.createElement("input");
		rechidden3.type = "button";
		rechidden3.value = "Delete";
		rechidden3.name = rid;
		rechidden3.id = rid;
		rechidden3.setAttribute('onclick', 'delrecrow(this);');
	}
	reccell3.appendChild(rechidden3);
	mycurrent_recrow.appendChild(reccell3);

	tbodyvar.appendChild(mycurrent_recrow);
	recaid++;

}

/**
 * **************************************************************Change row in
 * grid function end******************************************
 */

function fetchCommutedvalueData() {
//alert("age check");
	var age = 0;
	var dob = document.getElementById("dateofBirth").value;

	var retirementdate = document.getElementById("dar").value;
	var vrs_date = document.getElementById("vrs_date").value;
	var death_date = document.getElementById("death_date").value;
	if (vrs_date != "") {
		retirementdate = vrs_date;
	}
	if (death_date != "") {
		retirementdate = death_date;
	}
	var today = new Date();
	var datesSep1 = dob.split("/");
	var datesSep = retirementdate.split("/");
	var curdate = today.getDate();
	var curmonth = today.getMonth();
	var curyear = today.getFullYear();

	var fdate = new Date(datesSep1[2], datesSep1[1] - 1, datesSep1[0]);
	var tdate = new Date(datesSep[2], datesSep[1] - 1, datesSep[0]);
	if (datesSep1[0] == 1 || datesSep1[0] == 01 || datesSep1[0] == "1"
			|| datesSep1[0] == "01") {
		nextval = dob;
		var datesplit = nextval.split("/");
		var dateday = datesplit[0];
		var datemonth = datesplit[1] - 1;
		var dateyear = datesplit[2];
		var d1 = new Date(dateyear, datemonth, dateday);

		d1.setDate(d1.getDate());
		var dismonth = parseInt(d1.getMonth()) + 1;

		fdate = new Date(d1.getFullYear(), d1.getMonth(), d1.getDate());

		var typeofpensionid = document.getElementById("classPensionId");
		var selectedindex = typeofpensionid.selectedIndex;
		var selectedtext = typeofpensionid.options[selectedindex].text;
		if (selectedtext == "Super Annuation") {
			var d2 = new Date(datesSep[2], datesSep[1] - 1, datesSep[0]);
			// d2.setDate(d2.getDate() + 1);
			d2.setFullYear(d2.getFullYear() + 1);
			tdate = new Date(d2.getFullYear(), d2.getMonth(), d2.getDate());
		}
	}

	var dated = datediff(tdate, fdate);

	var age = 0;
	var totmonth = dated[1];
	var totday = 0;
	if (dated[0] > 0) {
		age = dated[0];
	}

	age = age + 1;
	document.getElementById("age").value = age;
	//alert(age);
	var url = "compenAppForm1CalcFetchMstdata.html?pensionAppCalcForm1.age="
			+ age;
	var comreq = getTransportWth();
	comreq.open("GET", url, true);
	comreq.onreadystatechange = function() {
		compenAppProcessResponse(comreq);
	};
	comreq.send(null);

}

function compenAppProcessResponse(comreq) {
	if (comreq.readyState == 4) {
		if (comreq.status == 200) {

			var combaseResponse = comreq.responseXML
					.getElementsByTagName("comresponse")[0];
			var tagCommand = combaseResponse.getElementsByTagName("comcommand")[0];
			var comdisplay = combaseResponse.getElementsByTagName("comrecord");
			if (comdisplay.length <= 0) {
				// alert('Commuted value Not Found');
			}

			for ( var i = 0; i < comdisplay.length; i++) {

				document.getElementById("commuted_val").value = nullcheck(combaseResponse
						.getElementsByTagName("commuted_val")[i].firstChild.nodeValue);
				// alert(nullcheck(combaseResponse.getElementsByTagName("commuted_val")[i].firstChild.nodeValue));
			}

		}
	}
}

function fetchEmployeeStatusData() {

	var typepension = document.getElementById("classPensionId").value;
	var empNo = document.getElementById("empNo").value;
	if (typepension != "" && empNo != "") {
		var url = "empStatusAppForm1CalcFetchMstdata.html?pensionAppCalcForm1.classPensionId="
				+ typepension + "&pensionAppCalcForm1.empNo=" + empNo;
		var empstatreq = getTransportWth();
		empstatreq.open("GET", url, true);
		empstatreq.onreadystatechange = function() {
			empStatusProcessResponse(empstatreq);
		};
		empstatreq.send(null);
	}

}

function empStatusProcessResponse(empstatreq) {

	if (empstatreq.readyState == 4) {
		if (empstatreq.status == 200) {

			var empstatbaseResponse = empstatreq.responseXML
					.getElementsByTagName("empstatresponse")[0];
			var tagCommand = empstatbaseResponse
					.getElementsByTagName("empstatcommand")[0];
			var empstatdisplay = empstatbaseResponse
					.getElementsByTagName("empstatrecord");

			var effectdate = "";
			var employeestatus = "";
			var typeofpension = document.getElementById("classPensionId").value;
			var typeofpensionid = document.getElementById("classPensionId");
			var selectedindex = typeofpensionid.selectedIndex;
			var selectedtext = typeofpensionid.options[selectedindex].text;
			if (empstatdisplay.length <= 0) {
				// alert('Commuted value Not Found');
			}

			for ( var i = 0; i < empstatdisplay.length; i++) {
				effectdate = nullcheck(empstatbaseResponse
						.getElementsByTagName("effectdate")[i].firstChild.nodeValue);
				employeestatus = nullcheck(empstatbaseResponse
						.getElementsByTagName("employeestatus")[i].firstChild.nodeValue);
				if (employeestatus.toLowerCase() == "vrs") {
					if (selectedtext.toLowerCase() == "vrs") {
						document.getElementById("vrs_date").value = effectdate;
						vrs_date_calc();
					} else {
						alert("Type of pension is invalid.");
						document.getElementById("classPensionId").value = "";
					}
				} else if (employeestatus.toLowerCase() == "dth") {
					if (selectedtext.toLowerCase() == "death") {
						document.getElementById("death_date").value = effectdate;
						death_date_calc();
					} else {
						alert("Type of pension is invalid.");

					}

				}
				// else if((employeestatus.toLowerCase()=="wkg") ||
				// (employeestatus.toLowerCase()=="san"))
				else if ((employeestatus.toLowerCase() != "vrs")
						&& (employeestatus.toLowerCase() != "dth")) {
					if (selectedtext.toLowerCase() == "super annuation") {
						document.getElementById("vrs_date").readonly = true;
						document.getElementById("vrs_date").style.backgroundColor = '#dddddf';
						document.getElementById("cal-button-7").style.display = 'none';
					} else if (selectedtext.toLowerCase() == "vrs") {
						document.getElementById("vrs_date").value = "";
						document.getElementById("vrs_date").readonly = false;
						// document.getElementById("vrs_date").style.backgroundColor
						// = '#dddddf';
						document.getElementById("vrs_date").style.backgroundColor = '#ffffff';
						document.getElementById("cal-button-7").style.display = 'inline';

					} else {
						alert("Type of pension is invalid.");
						document.getElementById("death_date").value = "";
						document.getElementById("vrs_date").value = "";
						document.getElementById("classPensionId").value = "";

						document.getElementById("vrs_date").readonly = true;
						document.getElementById("vrs_date").style.backgroundColor = '#dddddf';
						document.getElementById("cal-button-7").style.display = 'none';

					}

				} else {
					alert("Type of pension is invalid.");
					document.getElementById("death_date").value = "";
					document.getElementById("vrs_date").value = "";
					document.getElementById("classPensionId").value = "";
				}

			}

		}
	}
}

/* 
 * function empStatusProcessResponse(empstatreq) {
 * 
 * if(empstatreq.readyState==4) { if(empstatreq.status==200) {
 * 
 * var
 * empstatbaseResponse=empstatreq.responseXML.getElementsByTagName("empstatresponse")[0];
 * var tagCommand=empstatbaseResponse.getElementsByTagName("empstatcommand")[0];
 * var empstatdisplay=empstatbaseResponse.getElementsByTagName("empstatrecord");
 * 
 * var effectdate=""; var employeestatus=""; var
 * typeofpension=document.getElementById("classPensionId").value; var
 * typeofpensionid=document.getElementById("classPensionId"); var
 * selectedindex=typeofpensionid.selectedIndex; var
 * selectedtext=typeofpensionid.options[selectedindex].text;
 * if(empstatdisplay.length <=0) { // alert('Commuted value Not Found'); }
 * 
 * for(var i=0;i<empstatdisplay.length;i++) {
 * effectdate=nullcheck(empstatbaseResponse.getElementsByTagName("effectdate")[i].firstChild.nodeValue);
 * employeestatus=nullcheck(empstatbaseResponse.getElementsByTagName("employeestatus")[i].firstChild.nodeValue);
 * 
 * if(employeestatus.toLowerCase()=="vrs") {
 * if(selectedtext.toLowerCase()=="vrs") {
 * document.getElementById("vrs_date").value=effectdate; vrs_date_calc(); } else {
 * alert("Type of pension is invalid.");
 * document.getElementById("classPensionId").value=""; } } else
 * if(employeestatus.toLowerCase()=="dth") {
 * if(selectedtext.toLowerCase()=="death") {
 * document.getElementById("death_date").value=effectdate; death_date_calc(); }
 * else { alert("Type of pension is invalid.");
 *  }
 *  } else if((employeestatus.toLowerCase()=="wkg") ||
 * (employeestatus.toLowerCase()=="san")) {
 * if(selectedtext.toLowerCase()=="super annuation") {
 *  } else { alert("Type of pension is invalid.");
 * 
 * document.getElementById("death_date").value="";
 * document.getElementById("vrs_date").value="";
 * document.getElementById("classPensionId").value=""; }
 *  } else { alert("Type of pension is invalid.");
 * document.getElementById("death_date").value="";
 * document.getElementById("vrs_date").value="";
 * document.getElementById("classPensionId").value=""; }
 *  }
 *  } } }
 * 
 * 
 * 
 */

function defaultselection() {

	document.getElementById("wceserviceFlagNo").checked = 'checked';
	document.getElementById("wcecountedFlagNo").checked = 'checked';
	document.getElementById("contingentserviceFlagNo").checked = 'checked';
	document.getElementById("pensionCommutedFlagYes").checked = 'checked';
	document.getElementById("pensionpertFlagonethird").checked = 'checked';
	document.getElementById("pensionpertFlagonethird").disabled = false;
	document.getElementById("pensionpertFlagpert").disabled = false;
	document.getElementById("wcecountedFlagYes").disabled = true;
	document.getElementById("wcecountedFlagNo").disabled = true;
	document.getElementById("commPert").disabled = true;
	document.getElementById("commPert").style.backgroundColor = '#dddddf';
	document.getElementById("regualr_estab_date").disabled = true;
	document.getElementById("regualr_estab_date").style.backgroundColor = '#dddddf';
	document.getElementById("cal-button-10").style.display = "none";
	
	

	// document.getElementById("vrs_date").disabled=true;
	document.getElementById("vrs_date").readonly = true;
	document.getElementById("vrs_date").style.backgroundColor = '#dddddf';
	document.getElementById("cal-button-7").style.display = "none";

	// document.getElementById("death_date").value="";
	// document.getElementById("death_date").disabled=true;
	document.getElementById("death_date").readonly = true;
	document.getElementById("death_date").style.backgroundColor = '#dddddf';
	document.getElementById("cal-button-13").style.display = "none";

	var grade = document.getElementById("gradeId").value;
	if (grade == "Selection") {
		document.getElementById("special_grade_date").disabled = true;
		document.getElementById("special_grade_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-12").style.display = "none";
	}
	if ((grade == "Special") || (grade == "Super Grade") || (grade == "Super")) {

	}
	if (grade == "Normal") {
		document.getElementById("selection_grade_date").disabled = true;
		document.getElementById("selection_grade_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-11").style.display = "none";

		document.getElementById("special_grade_date").disabled = true;
		document.getElementById("special_grade_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-12").style.display = "none";
	}
		aedefaultsetting();
	if (document.getElementById("empNo").value != "") 
	{
		
		calcservice();
		/*calcworkservice();
		calcworkservice_dupli();
		calctotalnqs();*/
	}
	enableDisableotherdepartmentDetails();
}
function aedefaultsetting() {

	var totaltd = 14;
	var finalpptd = 12;
	var basic_payname = document.getElementById("avg_pay_name_basic").value;
	var basic_include = document.getElementById("avg_include_basic").value;
	var basic_da = document.getElementById("avg_da_basic").value;
	var basic_display_description = document
			.getElementById("avg_display_caption_basic").value;

	var grade_payname = document.getElementById("avg_pay_name_grade").value;
	var grade_include = document.getElementById("avg_include_grade").value;
	var grade_da = document.getElementById("avg_da_grade").value;
	var grade_display_description = document
			.getElementById("avg_display_caption_grade").value;

	var special_payname = document.getElementById("avg_pay_name_special").value;
	var special_include = document.getElementById("avg_include_special").value;
	var special_da = document.getElementById("avg_da_special").value;
	var special_display_description = document
			.getElementById("avg_display_caption_special").value;

	var other1_payname = document.getElementById("avg_pay_name_other1").value;
	var other1_include = document.getElementById("avg_include_other1").value;
	var other1_da = document.getElementById("avg_da_other1").value;
	var other1_display_description = document
			.getElementById("avg_display_caption_other1").value;

	var other2_payname = document.getElementById("avg_pay_name_other2").value;
	var other2_include = document.getElementById("avg_include_other2").value;
	var other2_da = document.getElementById("avg_da_other2").value;
	var other2_display_description = document
			.getElementById("avg_display_caption_other2").value;

	var other3_payname = document.getElementById("avg_pay_name_other3").value;
	var other3_include = document.getElementById("avg_include_other3").value;
	var other3_da = document.getElementById("avg_da_other3").value;
	var other3_display_description = document
			.getElementById("avg_display_caption_other3").value;
	
	
	var level_payname=document.getElementById("avg_pay_name_level").value;
	  var level_include=document.getElementById("avg_include_level").value;
	  var level_da=document.getElementById("avg_da_level").value;
	  var level_display_description=document.getElementById("avg_display_caption_level").value;
 
	// document.getElementById("aegradetitle").innerHTML=grade_display_description;
	// document.getElementById("aespecialtitle").innerHTML=special_display_description;

	if (basic_include == "Y") {
		document.getElementById("aebasictitle").innerHTML = basic_display_description;
		document.getElementById("lastbasictitle").innerHTML = basic_display_description;
	}
	if (basic_include == "N") {
		totaltd = parseInt(totaltd) - 1;
		finalpptd = parseInt(finalpptd) - 1;
		document.getElementById("aebasiccol").style.display = "none";
		document.getElementById("aebasictcol").style.display = "none";
		document.getElementById("aebasictitle").innerHTML = "";

		document.getElementById("lastbasiccol").style.display = "none";
		document.getElementById("lastbasictcol").style.display = "none";
		document.getElementById("lastbasictitle").innerHTML = "";
	}
	if (grade_include == "Y") {
		document.getElementById("aegradetitle").innerHTML = grade_display_description;
		document.getElementById("lastgradetitle").innerHTML = grade_display_description;
	}
	if (grade_include == "N") {
		totaltd = parseInt(totaltd) - 1;
		finalpptd = parseInt(finalpptd) - 1;
		document.getElementById("aegradecol").style.display = "none";
		document.getElementById("aegradetcol").style.display = "none";
		document.getElementById("aegradetitle").innerHTML = "";

		document.getElementById("lastgradecol").style.display = "none";
		document.getElementById("lastgradetcol").style.display = "none";
		document.getElementById("lastgradetitle").innerHTML = "";
	}

	if (special_include == "Y") {
		document.getElementById("aespecialtitle").innerHTML = special_display_description;
		document.getElementById("lastspecialtitle").innerHTML = special_display_description;
	}
	if (special_include == "N") {
		totaltd = parseInt(totaltd) - 1;
		finalpptd = parseInt(finalpptd) - 1;
		document.getElementById("aespecialcol").style.display = "none";
		document.getElementById("aespecialtcol").style.display = "none";
		document.getElementById("aespecialtitle").innerHTML = "";

		document.getElementById("lastspecialcol").style.display = "none";
		document.getElementById("lastspecialtcol").style.display = "none";
		document.getElementById("lastspecialtitle").innerHTML = "";
	}

	if (other1_include == "Y") {
		document.getElementById("aeother1title").innerHTML = other1_display_description;
		document.getElementById("lastother1title").innerHTML = other1_display_description;
	}
	if (other1_include == "N") {
		totaltd = parseInt(totaltd) - 1;
		finalpptd = parseInt(finalpptd) - 1;
		document.getElementById("aeother1col").style.display = "none";
		document.getElementById("aeother1tcol").style.display = "none";
		document.getElementById("aeother1title").innerHTML = "";

		document.getElementById("lastother1col").style.display = "none";
		document.getElementById("lastother1tcol").style.display = "none";
		document.getElementById("lastother1title").innerHTML = "";
	}
	if (other2_include == "Y") {
		document.getElementById("aeother2title").innerHTML = other2_display_description;
		document.getElementById("lastother2title").innerHTML = other2_display_description;
	}
	if (other2_include == "N") {
		totaltd = parseInt(totaltd) - 1;
		finalpptd = parseInt(finalpptd) - 1;
		document.getElementById("aeother2col").style.display = "none";
		document.getElementById("aeother2tcol").style.display = "none";
		document.getElementById("aeother2title").innerHTML = "";

		document.getElementById("lastother2col").style.display = "none";
		document.getElementById("lastother2tcol").style.display = "none";
		document.getElementById("lastother2title").innerHTML = "";
	}
	if (other3_include == "Y") {
		document.getElementById("aeother3title").innerHTML = other3_display_description;
		document.getElementById("lastother3title").innerHTML = other3_display_description;
	}
	if (other3_include == "N") {
		totaltd = parseInt(totaltd) - 1;
		finalpptd = parseInt(finalpptd) - 1;
		document.getElementById("aeother3col").style.display = "none";
		document.getElementById("aeother3tcol").style.display = "none";
		document.getElementById("aeother3title").innerHTML = "";

		document.getElementById("lastother3col").style.display = "none";
		document.getElementById("lastother3tcol").style.display = "none";
		document.getElementById("lastother3title").innerHTML = "";
	}
	
	
	 if(level_include=="Y")
	  {			  
		  
		  
		  document.getElementById("aeleveltitle").innerHTML=level_display_description;
		  document.getElementById("lastleveltitle").innerHTML=level_display_description;
		  
	  }
	
	

	// document.getElementById("aetoptitle").innerHTML='<tr
	// style="color:#000000;" align="center"><th colspan="'+totaltd+'">Average
	// Emoluments</th></tr>';

	// document.getElementById("finalpptd").innerHTML='<tr><td
	// colspan="'+finalpptd+'" align="right">Average PP amount</td><td
	// style="border-right:none;" align="center"><input
	// name="finaltotalppamount" id="finaltotalppamount" type="text"
	// style="text-align:right;background-color:#ececec;" class="aetextbox"
	// readonly="true" /></td><td>&nbsp;</td></tr>';
	// document.getElementById("addaebuttonid").innerHTML='<tr><td
	// colspan="'+totaltd+'" align="center"><input name="aesubmit_addrow"
	// value="Add New" id="aesubmit_addrow" onclick="validateform();"
	// type="button"></td></tr>';

}

function wceserviceChange() {
	var wceyear = parseInt(document.getElementById("wceyear").value);
	var wcemonth = parseInt(document.getElementById("wcemonth").value);
	var wceday = parseInt(document.getElementById("wceday").value);
	var totalwceservice = wceyear;

	var yearmax = 42;
	var monthmax = 11;
	var daymax = 29;

	var wcemaxservice = parseInt(document
			.getElementById("Min_quali_wce_service").value);

	if (document.getElementById("wceyear").value != "") {
		if (parseInt(document.getElementById("wceyear").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("wceyear").value = "";
		} else {
			wceyear = document.getElementById("wceyear").value;
		}
	}
	if (document.getElementById("wcemonth").value != "") {
		if (parseInt(document.getElementById("wcemonth").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("wcemonth").value = "";
		} else {
			wcemonth = document.getElementById("wcemonth").value;
		}

	}
	if (document.getElementById("wceday").value != "") {

		if (parseInt(document.getElementById("wceday").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("wceday").value = "";
		} else {
			wceday = document.getElementById("wceday").value;
		}

	}
	// demo
	// alert(wceyear+">="+wcemaxservice);
	if (wceyear >= wcemaxservice) {
		document.getElementById("wcecountedFlagYes").checked = 'checked';
		document.getElementById("wcecountedFlagYes").disabled = true;
		document.getElementById("wcecountedFlagNo").disabled = true;
	}
	if (wceyear < wcemaxservice) {
		document.getElementById("wcecountedFlagNo").checked = 'checked';
		document.getElementById("wcecountedFlagYes").disabled = false;
		document.getElementById("wcecountedFlagNo").disabled = false;
	}
	if (wceyear == wcemaxservice) {
		if (wcemonth != 0 || wceday != 0) {
			document.getElementById("wcecountedFlagYes").checked = 'checked';
			document.getElementById("wcecountedFlagYes").disabled = true;
			document.getElementById("wcecountedFlagNo").disabled = true;
		} else {
			document.getElementById("wcecountedFlagNo").checked = 'checked';
			document.getElementById("wcecountedFlagYes").disabled = false;
			document.getElementById("wcecountedFlagNo").disabled = false;
		}
	}

	//cal_other_tot_net_qualified_service();

}

function contingent_service_validation() {
	var contingentyear = parseInt(document.getElementById("contingentyear").value);
	var contingentmonth = parseInt(document.getElementById("contingentmonth").value);
	var contingentday = parseInt(document.getElementById("contingentday").value);

	var yearmax = 42;
	var monthmax = 11;
	var daymax = 29;

	if (document.getElementById("contingentyear").value != "") {
		if (parseInt(document.getElementById("contingentyear").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("contingentyear").value = "";
		} else {
			contingentyear = document.getElementById("contingentyear").value;
		}
	}
	if (document.getElementById("contingentmonth").value != "") {
		if (parseInt(document.getElementById("contingentmonth").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("contingentmonth").value = "";
		} else {
			contingentmonth = document.getElementById("contingentmonth").value;
		}

	}
	if (document.getElementById("contingentday").value != "") {

		if (parseInt(document.getElementById("contingentday").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("contingentday").value = "";
		} else {
			contingentday = document.getElementById("contingentday").value;
		}

	}

	//cal_other_tot_cont_net_qualified_service();
}

function province_date_validation() {
	province_date = document.getElementById("province_date").value;
	join_date = document.getElementById("twadDateofJoin").value;

	var datesplit = join_date.split("/");
	var dateday = datesplit[0];
	var datemonth = datesplit[1] - 1;
	var dateyear = datesplit[2];
	var d1 = new Date(dateyear, datemonth, dateday);

	// d1.setFullYear(d1.getFullYear() + 20);
	var valdate = d1.getDate();
	var valmonth = parseInt(d1.getMonth()) + 1;
	maxprovince_date = d1.getDate() + "/" + valmonth + "/" + d1.getFullYear();

	datesSep1 = maxprovince_date.split("/");
	datesSep = province_date.split("/");

	retirement_date = document.getElementById("dar").value;
	vrs_date = document.getElementById("vrs_date").value;
	death_date = document.getElementById("death_date").value;
	if (vrs_date != "") {
		retirement_date = vrs_date;
	}
	if (death_date != "") {
		retirement_date = death_date;
	}
	datesSep2 = retirement_date.split("/");
	if (isGreaterDate_1(datesSep2[0], datesSep2[1], datesSep2[2], datesSep[0],
			datesSep[1], datesSep[2])) {
		alert("Entered Date should not be Greater than retirement date !");
		document.getElementById("province_date").value = "";
	}

	if (isFutureDate(datesSep[0], datesSep[1], datesSep[2])) {
		alert("Choosen Date is Future !");
		document.getElementById("province_date").value = "";
	}

	if (isGreaterDate_1(datesSep[0], datesSep[1], datesSep[2], datesSep1[0],
			datesSep1[1], datesSep1[2])) {
		alert("Entered Date should be Greater than joining date !");
		document.getElementById("province_date").value = "";
	}

}

function regular_est_date_validation() {
	regualr_estab_date = document.getElementById("regualr_estab_date").value;
	join_date = document.getElementById("twadDateofJoin").value;

	var datesplit = join_date.split("/");
	var dateday = datesplit[0];
	var datemonth = datesplit[1] - 1;
	var dateyear = datesplit[2];
	var d1 = new Date(dateyear, datemonth, dateday);

	var valdate = d1.getDate();
	var valmonth = parseInt(d1.getMonth()) + 1;
	maxregualr_estab_date = d1.getDate() + "/" + valmonth + "/"
			+ d1.getFullYear();

	datesSep1 = maxregualr_estab_date.split("/");
	datesSep = regualr_estab_date.split("/");

	retirement_date = document.getElementById("dar").value;
	vrs_date = document.getElementById("vrs_date").value;
	death_date = document.getElementById("death_date").value;
	if (vrs_date != "") {
		retirement_date = vrs_date;
	}
	if (death_date != "") {
		retirement_date = death_date;
	}
	datesSep2 = retirement_date.split("/");
	if (isGreaterDate_1(datesSep2[0], datesSep2[1], datesSep2[2], datesSep[0],
			datesSep[1], datesSep[2])) {
		alert("Entered Date should not be Greater than retirement date !");
		document.getElementById("regualr_estab_date").value = "";
	}

	if (isFutureDate(datesSep[0], datesSep[1], datesSep[2])) {
		alert("Choosen Date is Future !");
		document.getElementById("regualr_estab_date").value = "";
	}

	if (isGreaterDate_1(datesSep[0], datesSep[1], datesSep[2], datesSep1[0],
			datesSep1[1], datesSep1[2])) {
		alert("Entered Date should be Greater than joining date !");
		document.getElementById("regualr_estab_date").value = "";
	}

}

function selection_grade() {
	slectin_grade_date = document.getElementById("selection_grade_date").value;
	join_date = document.getElementById("twadDateofJoin").value;

	var Selection_grade_gap = parseInt(document
			.getElementById("Selection_grade_gap").value);

	var datesplit = join_date.split("/");
	var dateday = datesplit[0];
	var datemonth = datesplit[1] - 1;
	var dateyear = datesplit[2];
	var d1 = new Date(dateyear, datemonth, dateday);

	// d1.setFullYear(d1.getFullYear() + 10);
	d1.setFullYear(d1.getFullYear() + Selection_grade_gap);
	var valdate = d1.getDate();
	var valmonth = parseInt(d1.getMonth()) + 1;
	maxslectin_grade_date = d1.getDate() + "/" + valmonth + "/"
			+ d1.getFullYear();

	datesSep1 = maxslectin_grade_date.split("/");
	datesSep = slectin_grade_date.split("/");

	retirement_date = document.getElementById("dar").value;
	vrs_date = document.getElementById("vrs_date").value;
	death_date = document.getElementById("death_date").value;
	if (vrs_date != "") {
		retirement_date = vrs_date;
	}
	if (death_date != "") {
		retirement_date = death_date;
	}
	datesSep2 = retirement_date.split("/");
	if (isGreaterDate_1(datesSep2[0], datesSep2[1], datesSep2[2], datesSep[0],
			datesSep[1], datesSep[2])) {
		alert("Entered Date should not be Greater than retirement date !");
		document.getElementById("selection_grade_date").value = "";
	}
	if (isFutureDate(datesSep[0], datesSep[1], datesSep[2])) {
		alert("Choosen Date is Future !");
		document.getElementById("selection_grade_date").value = "";
	}

	if (isGreaterDate_1(datesSep[0], datesSep[1], datesSep[2], datesSep1[0],
			datesSep1[1], datesSep1[2])) {
		alert("Entered Date should be Greater than " + Selection_grade_gap
				+ " years from joining date !");
		document.getElementById("selection_grade_date").value = "";
	}
}

function special_grade() {
	special_grade_date = document.getElementById("special_grade_date").value;
	join_date = document.getElementById("twadDateofJoin").value;

	var Spl_grade_gap = parseInt(document.getElementById("Spl_grade_gap").value);

	var datesplit = join_date.split("/");
	var dateday = datesplit[0];
	var datemonth = datesplit[1] - 1;
	var dateyear = datesplit[2];
	var d1 = new Date(dateyear, datemonth, dateday);

	// d1.setFullYear(d1.getFullYear() + 20);
	d1.setFullYear(d1.getFullYear() + Spl_grade_gap);

	var valdate = d1.getDate();
	var valmonth = parseInt(d1.getMonth()) + 1;
	maxspecial_grade_date = d1.getDate() + "/" + valmonth + "/"
			+ d1.getFullYear();

	datesSep1 = maxspecial_grade_date.split("/");
	datesSep = special_grade_date.split("/");

	retirement_date = document.getElementById("dar").value;
	vrs_date = document.getElementById("vrs_date").value;
	death_date = document.getElementById("death_date").value;
	if (vrs_date != "") {
		retirement_date = vrs_date;
	}
	if (death_date != "") {
		retirement_date = death_date;
	}
	datesSep2 = retirement_date.split("/");
	if (isGreaterDate_1(datesSep2[0], datesSep2[1], datesSep2[2], datesSep[0],
			datesSep[1], datesSep[2])) {
		alert("Entered Date should not be Greater than retirement date !");
		document.getElementById("special_grade_date").value = "";
	}
	if (isFutureDate(datesSep[0], datesSep[1], datesSep[2])) {
		alert("Choosen Date is Future !");
		document.getElementById("special_grade_date").value = "";
	}

	if (isGreaterDate_1(datesSep[0], datesSep[1], datesSep[2], datesSep1[0],
			datesSep1[1], datesSep1[2])) {
		alert("Entered Date should be Greater than " + Spl_grade_gap
				+ " years from joining date !");
		document.getElementById("special_grade_date").value = "";
	}
}

function isGreaterDate_1(fromday, frommonth, fromyear, today, tomonth, toyear) {
	frommonth -= 1;
	tomonth -= 1;
	var fromdteDate;
	var todteDate;
	fromdteDate = new Date(fromyear, frommonth, fromday);
	todteDate = new Date(toyear, tomonth, today);
	// return (fromdteDate.getTime()<=todteDate.getTime());
	return (fromdteDate.getTime() < todteDate.getTime());
}

function typeofpension_selection() {
	var typeofpensionid = document.getElementById("classPensionId");
	var selectedindex = typeofpensionid.selectedIndex;
	var selectedtext = typeofpensionid.options[selectedindex].text;
	if (selectedtext == "Super Annuation") {
		var dateofbirth = document.getElementById("dateofBirth").value;

		var datesplit = dateofbirth.split("/");
		var dateday = datesplit[0];
		var datemonth = datesplit[1] - 1;
		var dateyear = datesplit[2];
		var d1 = new Date(dateyear, datemonth, dateday);

		d1.setFullYear(d1.getFullYear() + 60);
		var valdate = d1.getDate();
		var valmonth = parseInt(d1.getMonth()) + 1;
		var actualretiementdate = d1.getDate() + "/" + valmonth + "/"
				+ d1.getFullYear();
		// alert("actualretiementdate"+actualretiementdate);
		var retiredate = DaysInMonth(d1.getFullYear(), valmonth);
		var finalretiredate = retiredate + "/" + valmonth + "/"
				+ d1.getFullYear();
		// document.getElementById("dar").value=finalretiredate;
		// alert("retiredate"+retiredate);

		document.getElementById("vrs_date").value = "";
		// document.getElementById("vrs_date").disabled=true;
		document.getElementById("vrs_date").readonly = true;
		document.getElementById("vrs_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-7").style.display = "none";

		document.getElementById("death_date").value = "";
		// document.getElementById("death_date").disabled=true;
		document.getElementById("death_date").readonly = true;
		document.getElementById("death_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-13").style.display = "none";

		document.getElementById("pensionCommutedFlagYes").checked = 'checked';
		document.getElementById("pensionCommutedFlagYes").disabled = false;
		document.getElementById("pensionCommutedFlagNo").disabled = false;
		document.getElementById("pensionpertFlagonethird").disabled = false;
		document.getElementById("pensionpertFlagpert").disabled = false;
		/*
		 * document.getElementById("commPert").disabled=false;
		 * document.getElementById("commPert").style.backgroundColor =
		 * '#ffffff';
		 */

		if (document.getElementById("empNo").value != "") {
			calcservice();
			/*calcworkservice();
			calctotalnqs();
			calcworkservice_dupli();*/
		}
		enableaegrid();

	} else if (selectedtext == "VRS") {
		/*
		 * document.getElementById("vrs_date").disabled=false;
		 * document.getElementById("vrs_date").style.backgroundColor =
		 * '#ffffff';
		 * document.getElementById("cal-button-7").style.display="inline";
		 */

		document.getElementById("death_date").value = "";
		// document.getElementById("death_date").disabled=true;
		document.getElementById("death_date").readonly = true;
		document.getElementById("death_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-13").style.display = "none";

		document.getElementById("aws_year").value = "";
		document.getElementById("aws_month").value = "";
		document.getElementById("aws_day").value = "";

		document.getElementById("pensionCommutedFlagYes").checked = 'checked';
		document.getElementById("pensionCommutedFlagYes").disabled = false;
		document.getElementById("pensionCommutedFlagNo").disabled = false;
		document.getElementById("pensionpertFlagonethird").disabled = false;
		document.getElementById("pensionpertFlagpert").disabled = false;
		/*
		 * document.getElementById("commPert").disabled=false;
		 * document.getElementById("commPert").style.backgroundColor =
		 * '#ffffff';
		 */

		if (document.getElementById("empNo").value != "") {
			calcservice();
			/*calcworkservice();
			calctotalnqs();*/
		}
		enableaegrid();

	} else if (selectedtext == "Death") {
		/*
		 * document.getElementById("death_date").disabled=false;
		 * document.getElementById("death_date").style.backgroundColor =
		 * '#ffffff';
		 * document.getElementById("cal-button-13").style.display="inline";
		 */

		document.getElementById("vrs_date").value = "";
		// document.getElementById("vrs_date").disabled=true;
		document.getElementById("vrs_date").readonly = true;
		document.getElementById("vrs_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-7").style.display = "none";

		document.getElementById("aws_year").value = "";
		document.getElementById("aws_month").value = "";
		document.getElementById("aws_day").value = "";

		document.getElementById("pensionCommutedFlagNo").checked = 'checked';
		document.getElementById("pensionCommutedFlagYes").disabled = true;
		document.getElementById("pensionCommutedFlagNo").disabled = true;
		document.getElementById("pensionpertFlagonethird").disabled = true;
		document.getElementById("pensionpertFlagonethird").checked = 'checked';
		document.getElementById("pensionpertFlagpert").disabled = true;
		document.getElementById("commPert").value = "";
		document.getElementById("commPert").disabled = true;
		document.getElementById("commPert").style.backgroundColor = '#dddddf';

		if (document.getElementById("empNo").value != "") {
			calcservice();
			/*calcworkservice();
			calctotalnqs();*/
		}
		disabledaegrid();

	} else {
		document.getElementById("vrs_date").value = "";
		// document.getElementById("vrs_date").disabled=true;
		document.getElementById("vrs_date").readonly = true;
		document.getElementById("vrs_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-7").style.display = "none";

		document.getElementById("death_date").value = "";
		// document.getElementById("death_date").disabled=true;
		document.getElementById("death_date").readonly = true;
		document.getElementById("death_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-13").style.display = "none";

		document.getElementById("pensionCommutedFlagYes").checked = 'checked';
		document.getElementById("pensionCommutedFlagYes").disabled = false;
		document.getElementById("pensionCommutedFlagNo").disabled = false;
		document.getElementById("pensionpertFlagonethird").disabled = false;
		document.getElementById("pensionpertFlagpert").disabled = false;
		/*
		 * document.getElementById("commPert").disabled=false;
		 * document.getElementById("commPert").style.backgroundColor =
		 * '#ffffff';
		 */
		enableaegrid();

	}
}

function vrs_date_calc() {
	if (document.getElementById("vrs_date").value != "") {
		var flag = 0;
		vrs_date = document.getElementById("vrs_date").value;
		join_date = document.getElementById("twadDateofJoin").value;
		dar = document.getElementById("dar").value;

		var Vrs_eligible_yrs = parseInt(document
				.getElementById("Vrs_eligible_yrs").value);
		// alert(Vrs_eligible_yrs)
		var datesplit = join_date.split("/");
		var dateday = datesplit[0];
		var datemonth = datesplit[1] - 1;
		var dateyear = datesplit[2];
		var d1 = new Date(dateyear, datemonth, dateday);

		// d1.setFullYear(d1.getFullYear() + 20);
		d1.setFullYear(d1.getFullYear() + Vrs_eligible_yrs);
		var valdate = d1.getDate();
		var valmonth = parseInt(d1.getMonth()) + 1;
		maxvrs_date = d1.getDate() + "/" + valmonth + "/" + d1.getFullYear();

		datesSep1 = maxvrs_date.split("/");
		datesSep = vrs_date.split("/");
		superdatesSep = dar.split("/");

		if (isGreaterDate_1(datesSep[0], datesSep[1], datesSep[2],
				datesSep1[0], datesSep1[1], datesSep1[2])) {
			alert("Entered Date should be Greater than " + Vrs_eligible_yrs
					+ " years from joining date !");
			document.getElementById("vrs_date").value = "";
			flag = 1;
		}
		if (isGreaterDate_1(superdatesSep[0], superdatesSep[1],
				superdatesSep[2], datesSep[0], datesSep[1], datesSep[2])) {
			alert("Entered Date should be less than super annuation !");
			document.getElementById("vrs_date").value = "";
			flag = 1;
		}
		if (flag == 0) {
			calcservice();
			/*calcworkservice();
			calctotalnqs();
			calcworkservice_dupli();*/
		}
	}
}

function death_date_calc() {
	if (document.getElementById("death_date").value != "") {
		var flag = 0;
		death_date = document.getElementById("death_date").value;
		join_date = document.getElementById("twadDateofJoin").value;
		dar = document.getElementById("dar").value;

		var Vrs_eligible_yrs = parseInt(document
				.getElementById("Vrs_eligible_yrs").value);
		// alert(Vrs_eligible_yrs)
		var datesplit = join_date.split("/");
		var dateday = datesplit[0];
		var datemonth = datesplit[1] - 1;
		var dateyear = datesplit[2];
		var d1 = new Date(dateyear, datemonth, dateday);

		d1.setFullYear(d1.getFullYear() + Vrs_eligible_yrs);
		var valdate = d1.getDate();
		var valmonth = parseInt(d1.getMonth()) + 1;
		maxvrs_date = d1.getDate() + "/" + valmonth + "/" + d1.getFullYear();

		// datesSep1=maxvrs_date.split("/");
		datesSep1 = join_date.split("/");
		datesSep = death_date.split("/");
		superdatesSep = dar.split("/");

		
		if (isGreaterDate_1(datesSep[0], datesSep[1], datesSep[2],
				datesSep1[0], datesSep1[1], datesSep1[2])) {
			alert("Entered Date should be Greater than joining date !");
			document.getElementById("death_date").value = "";
			flag = 1;
		}
		if (isGreaterDate_1(superdatesSep[0], superdatesSep[1],
				superdatesSep[2], datesSep[0], datesSep[1], datesSep[2])) {
			alert("Entered Date should be less than super annuation !");
			document.getElementById("death_date").value = "";
			flag = 1;
		}
		if (isFutureDate(datesSep[0], datesSep[1], datesSep[2])) {
			alert("Choosen Date is Future !");
			document.getElementById("death_date").value = "";
			flag = 1;
		}
		if (flag == 0) {
			calcservice();
			/*calcworkservice();
			calctotalnqs();
			calcworkservice_dupli();*/
		}
	}
}

function compert_validation() {
	var com_pert = parseInt(document.getElementById("commPert").value);
	if (com_pert > 33) {
		alert("Enter less than 33 percentage.");
		document.getElementById("commPert").value = "";
	}
}

function nullcheck(checkstring) {
	var printstring;
	if ((checkstring == "null") || (checkstring == null)) {
		printstring = "";
	} else {
		printstring = checkstring;
	}
	return printstring;
}

function validation_final() 
{
	
	var penvalflag = 0;
	//var totservalflag = 0;
	var lastvalflag = 0;
	var aevalflag = 0;
	var recvalflag = 0;
	var eligiblevalflag = 0;
	
	
	
		

	// retflag=pensioner_detail_validation();
	fetchCommutedvalueData();
	var dedate = document.getElementById("death_date").value;
	//alert("dedate::"+dedate);
	if (!pensioner_detail_validation()) {
		penvalflag = 1;
		//alert("pensioner_detail_validation");
		return false;
	}
	/*if (!total_service_validation()) {
		totservalflag = 1;
		return false;
	}*/
	if (!eligible_pension_validation()) {
		eligiblevalflag = 1;
		//alert("eligible_pension_validation");
		return false;
	}
	if (!last_pay_drawn_validation()) {
		lastvalflag = 1;
		//alert("last_pay_drawn_validation");
		return false;
	}
	if (dedate != "") {

	} else {
		if (!ae_form_final_validation()) {
			aevalflag = 1;
			//alert("ae_form_final_validation");
			return false;
		}
	}
	if (!rec_form_final_validation()) {
		recvalflag = 1;
		//alert("rec_form_final_validation");
		return false;
	}
	//alert("full");
	if(document.getElementById("otherdeparmentserviceFlagYes").checked)
	{
		//alert("yes:::"+deptrid);
		if(deptrid==0)
		{
			alert("Enter the Department Service Details");
			return false;
		}
	}
	
	
	
	
	/*if ((penvalflag == 1) || (totservalflag == 1) || (lastvalflag == 1)
			|| (aevalflag == 1) || (recvalflag == 1) || (eligiblevalflag == 1)) {
		return false;
	} */
	
	if ((penvalflag == 1) ||  (lastvalflag == 1)
			|| (aevalflag == 1) || (recvalflag == 1) || (eligiblevalflag == 1)) {
		return false;
	} else {
		
		try
		{
			calcservice();
		}
		catch(e)
		{
			
		}
		//alert("basi_payname::")
		var basic_payname = document.getElementById("avg_pay_name_basic").value;
		var basic_include = document.getElementById("avg_include_basic").value;
		var basic_da = document.getElementById("avg_da_basic").value;
		var basic_display_description = document
		.getElementById("avg_display_caption_basic").value;
 
		/*var grade_payname = document.getElementById("avg_pay_name_grade").value;
		var grade_include = document.getElementById("avg_include_grade").value;
		var grade_da = document.getElementById("avg_da_grade").value;
		var grade_display_description = document
		.getElementById("avg_display_caption_grade").value;*/

		var special_payname = document.getElementById("avg_pay_name_special").value;
		var special_include = document.getElementById("avg_include_special").value;
		var special_da = document.getElementById("avg_da_special").value;
		var special_display_description = document
		.getElementById("avg_display_caption_special").value;

		var other1_payname = document.getElementById("avg_pay_name_other1").value;
		var other1_include = document.getElementById("avg_include_other1").value;
		var other1_da = document.getElementById("avg_da_other1").value;
		var other1_display_description = document
		.getElementById("avg_display_caption_other1").value;

		var other2_payname = document.getElementById("avg_pay_name_other2").value;
		var other2_include = document.getElementById("avg_include_other2").value;
		var other2_da = document.getElementById("avg_da_other2").value;
		var other2_display_description = document
		.getElementById("avg_display_caption_other2").value;

		var other3_payname = document.getElementById("avg_pay_name_other3").value;
		var other3_include = document.getElementById("avg_include_other3").value;
		var other3_da = document.getElementById("avg_da_other3").value;
		var other3_display_description = document
		.getElementById("avg_display_caption_other3").value;
		
		 var level_payname=document.getElementById("avg_pay_name_level").value;
		  var level_include=document.getElementById("avg_include_level").value;
		  var level_da=document.getElementById("avg_da_level").value;
		  var level_display_description=document.getElementById("avg_display_caption_level").value;

		var lasttotal = document.getElementById("lasttotal").value;

		var finaltotalppamount = document.getElementById("finaltotalppamount").value;
		document.getElementById("finaltotppamount").value = finaltotalppamount;
		var lastbasic = document.getElementById("lastbasic").value;
		//var lastgrade = document.getElementById("lastgrade").value;
		var lastspecial = document.getElementById("lastspecial").value;
		var lastother1 = document.getElementById("lastother1").value;
		var lastother2 = document.getElementById("lastother2").value;
		var lastother3 = document.getElementById("lastother3").value;
//		var lastlevel=document.getElementById("lastlevel").value;
		var lastlevel=document.getElementById("lastlevel").value;
		var scale=document.getElementById("scaleOfPay").value;
	//	alert(lastlevel+" "+"scale::"+scale);

		var lasttotalforda = 0;
		var pensionamount = 0;
		var fampesnionamount = 0;
		var fampensionamountafter = 0;
		var pencalamount = 0;
		var commutedpensionamount = 0;
		var commutedamount = 0;
		var reducedpensionamount = 0;
		var commutedval = document.getElementById("commuted_val").value;
		// alert(commutedval);
		// commutedval=8.287;
		var fampensionamountbeforceiling = document
		.getElementById("Family_pension_ceiling_percent").value;
		var fampensionamountafterceiling = document
		.getElementById("Family_pension_after_percent").value;
		var pensionhalfyearceiling = document
		.getElementById("Pension_half_yr_ceiling").value;
		var maxdcrgamount = document.getElementById("Max_dcrg_amt").value;
		var minpensionamount = document.getElementById("Min_pension_amt").value;
		var maxpensionamount = document.getElementById("Max_pension_amt").value;
		var minfampensionamount = document
		.getElementById("Min_fam_pension_amt").value;
		var maxfampensionamount = document
		.getElementById("Max_fam_pension_amt").value;

		var dcrghalfyear = document.getElementById("nohalfyeardcrg").value;
		var nohalfyearpen = document.getElementById("nohalfyearpen").value;

		var dapercentage = document.getElementById("da_percentage").value;
          //alert(dapercentage);
		if ((basic_include == "Y") && (basic_da == "Y")) {
			lasttotalforda = parseInt(lasttotalforda) + parseInt(lastbasic);
		}
	/*	if ((grade_include == "Y") && (grade_da == "Y")) {
			lasttotalforda = parseInt(lasttotalforda) + parseInt(lastgrade);
		}*/
		if ((special_include == "Y") && (special_da == "Y")) {
			lasttotalforda = parseInt(lasttotalforda) + parseInt(lastspecial);
		}
		if ((other1_include == "Y") && (other1_da == "Y")) {
			lasttotalforda = parseInt(lasttotalforda) + parseInt(lastother1);
		}
		if ((other2_include == "Y") && (other2_da == "Y")) {
			lasttotalforda = parseInt(lasttotalforda) + parseInt(lastother2);
		}
		if ((other3_include == "Y") && (other3_da == "Y")) {
			lasttotalforda = parseInt(lasttotalforda) + parseInt(lastother3);
		}
		if (parseInt(lasttotal) >= parseInt(finaltotalppamount)) {
			pencalamount = lasttotal;
		} else {
			pencalamount = finaltotalppamount;
		}
		var pensionyearcal = parseFloat((nohalfyearpen)	/ pensionhalfyearceiling);
		pensionamount =Math.round((pencalamount)*(parseFloat(fampensionamountbeforceiling) / 100)*pensionyearcal);
		fampesnionamount =Math.round((pencalamount)*parseFloat((fampensionamountbeforceiling) / 100));
		fampensionamountafter =Math.round((pencalamount)*parseFloat((fampensionamountafterceiling) / 100));
		var damount = Math.round((lasttotalforda)*parseFloat((dapercentage) / 100));
		// dcrgpensionamuont=parseInt(lasttotal+damount)*(0.25)*parseInt(dcrghalfyear);
		// alert("dcrghalfyear"+dcrghalfyear);

		dcrgpensionamuont = (parseInt(lasttotal) + parseInt(damount)) * (0.25)
		* (dcrghalfyear);

		if (parseInt(nohalfyearpen) <= pensionhalfyearceiling) {
			fampesnionamount = pensionamount;
		}

		if (parseInt(dcrgpensionamuont) >= parseInt(maxdcrgamount)) {
			dcrgpensionamuont = maxdcrgamount;
		}

		if ((document.getElementById("pensionpertFlagpert").checked == true)&& (document.getElementById("commPert").value != "")&& (document.getElementById("pensionCommutedFlagYes").checked == true)) 
		{
			var compert = document.getElementById("commPert").value;
			if(Math.round(pensionamount) < minpensionamount)
			  {
				  pensionamount=minpensionamount;			  
			  }
			commutedamount = Math.round(parseInt((parseInt(pensionamount) * parseFloat(compert / 100))));

		}
		if ((document.getElementById("pensionpertFlagonethird").checked == true)&& (document.getElementById("pensionCommutedFlagYes").checked == true)) 
		{
			if(Math.round(pensionamount) < minpensionamount)
			  {
				  pensionamount=minpensionamount;			  
			  }
			commutedamount = Math.round(parseInt(parseFloat((pensionamount) / 3)));
		}
		commutedpensionamount = (commutedamount) * 12 * (commutedval);
		reducedpensionamount = parseInt(pensionamount)-parseInt(commutedamount);

		var typeofpension = document.getElementById("classPensionId").value;
		var typeofpensionid = document.getElementById("classPensionId");
		var selectedindex = typeofpensionid.selectedIndex;
		var selectedtext = typeofpensionid.options[selectedindex].text;

		if (typeofpension != "" && typeofpensionid.disabled == true) {
			typeofpensionid.disabled = false;
		}

		if (typeofpension != "" && selectedtext == "Death") {
			document.getElementById("pensionCommutedFlagYes").disabled = false;
			document.getElementById("pensionCommutedFlagNo").disabled = false;
			document.getElementById("pensionpertFlagonethird").disabled = false;
			document.getElementById("pensionpertFlagpert").disabled = false;
			pensionamount = 0;
			commutedamount = 0;
			commutedpensionamount = 0;
			reducedpensionamount = 0;
			var nqs_year = document.getElementById("nqs_year").value;
			var multvar_dcrg = 1;
			if (nqs_year < 1) {
				multvar_dcrg = 2;
				dcrgpensionamuont = (parseInt(lasttotal) + parseInt(damount)) * 2;
			}
			if ((nqs_year >= 1) && (nqs_year < 5)) {
				multvar_dcrg = 6;
				dcrgpensionamuont = (parseInt(lasttotal) + parseInt(damount)) * 6;
			}
			if ((nqs_year >= 5) && (nqs_year < 20)) {
				multvar_dcrg = 12;
				dcrgpensionamuont = (parseInt(lasttotal) + parseInt(damount)) * 12;
			}
			if (nqs_year >= 20) {
				// multvar_dcrg=2;
				dcrgpensionamuont = (parseInt(lasttotal) + parseInt(damount))
				* (dcrghalfyear) * (1 / 2);
			}
			// dcrgpensionamuont=(parseInt(lasttotal)+parseInt(damount))*(0.25)*(dcrghalfyear);

			fampesnionamount = (lasttotal)
			* parseFloat((fampensionamountbeforceiling) / 100);
			fampensionamountafter = (lasttotal)
			* parseFloat((fampensionamountafterceiling) / 100);

		}

		if (Math.round(pensionamount) < minpensionamount) {
			pensionamount = minpensionamount;
		}
		/*
		* if(Math.round(pensionamount) > maxpensionamount) {
		* pensionamount=maxpensionamount; }
		*/
		if (Math.round(fampesnionamount) < minfampensionamount) {
			fampesnionamount = minfampensionamount;
		}
		if (Math.round(fampensionamountafter) < minfampensionamount) {
			fampensionamountafter = minfampensionamount
		}
		if (Math.round(fampesnionamount) > maxfampensionamount) {
			fampesnionamount = maxfampensionamount;
		}
		if (Math.round(fampensionamountafter) > maxfampensionamount) {
			fampensionamountafter = maxfampensionamount;
		}

		document.getElementById("pensionamount").value = Math
		.round(pensionamount);
		document.getElementById("fampensionamount").value = Math
		.round(fampesnionamount);
		document.getElementById("famafterpensionamount").value = Math
		.round(fampensionamountafter);
		document.getElementById("commutedamount").value = parseInt(commutedamount);
		document.getElementById("damount").value = parseInt(damount);
		dcrgpensionamuont = dcrgpensionamuont;

		document.getElementById("dcrgamount").value = Math
		.round(dcrgpensionamuont);
		document.getElementById("totcommutedamount").value = Math.round(
				commutedpensionamount, 3);
		document.getElementById("reducedpensionamount").value = Math
		.round(reducedpensionamount);
		try
		{
			//alert(deptrid);
			if(parseInt(deptrid)>0 && !checkotherdeptdate(deptrid))
				{
				return false;
				}
		}
		catch(e)
		{
			
		}
		
		try
		{
		otherdepttotservice();
		}
		catch(e)
		{
			//alert(e.message);
		}
		try
		{
			calcservice();
		}
		catch(e)
		{
			
		}

		/* 
		 * alert("pensionamount="+Math.round(pensionamount));
		 * alert("fampesnionamount="+Math.round(fampesnionamount));
		 * alert("fampensionamountafter="+Math.round(fampensionamountafter));
		 * alert("dcrgpensionamuont="+Math.round(dcrgpensionamuont));
		 * alert("commutedamount="+Math.round(commutedamount));
		 * alert("commutedpensionamount="+Math.round(commutedpensionamount,3));
		 * alert("reducedpensionamount="+Math.round(reducedpensionamount));
		 */

		/*
		 * alert("pensionamount="+pensionamount);
		 * alert("fampesnionamount="+fampesnionamount);
		 * alert("fampensionamountafter="+fampensionamountafter);
		 * alert("dcrgpensionamuont="+dcrgpensionamuont);
		 * alert("commutedamount="+commutedamount);
		 * alert("commutedpensionamount="+Math.round(commutedpensionamount,3));
		 * alert("reducedpensionamount="+Math.round(reducedpensionamount));
		 */
//alert("true");


		return true;
		// return false;
	}
	//alert("inside validation");

}

function pensioner_detail_validation() {
	var grade = document.getElementById("gradeId").value;
	var typeofpension = document.getElementById("classPensionId").value;
	var typeofpensionid = document.getElementById("classPensionId");
	var selectedindex = typeofpensionid.selectedIndex;
	var selectedtext = typeofpensionid.options[selectedindex].text;
	var dar = document.getElementById("dar").value;
	var vrs_date = document.getElementById("vrs_date").value;
	var death_date = document.getElementById("death_date").value;
	var wceserviceFlagYes = document.getElementById("wceserviceFlagYes");
	var wceserviceFlagNo = document.getElementById("wceserviceFlagNo");
	var wceyear = document.getElementById("wceyear").value;
	var wcemonth = document.getElementById("wcemonth").value;
	var wceday = document.getElementById("wceday").value;
	var wcecountedFlagYes = document.getElementById("wcecountedFlagYes");
	var wcecountedFlagNo = document.getElementById("wcecountedFlagNo");
	var contingentserviceFlagYes = document
			.getElementById("contingentserviceFlagYes");
	var contingentserviceFlagNo = document
			.getElementById("contingentserviceFlagNo");
	var contingentyear = document.getElementById("contingentyear").value;
	var contingentmonth = document.getElementById("contingentmonth").value;
	var contingentday = document.getElementById("contingentday").value;

	var province_date = document.getElementById("province_date").value;
	var regualr_estab_date = document.getElementById("regualr_estab_date").value;
	var selection_grade_date = document.getElementById("selection_grade_date").value;
	var special_grade_date = document.getElementById("special_grade_date").value;

	var pensionCommutedFlagYes = document
			.getElementById("pensionCommutedFlagYes");
	var pensionCommutedFlagNo = document
			.getElementById("pensionCommutedFlagNo");
	var pensionpertFlagonethird = document
			.getElementById("pensionpertFlagonethird");
	var pensionpertFlagpert = document.getElementById("pensionpertFlagpert");

	var commPert = document.getElementById("commPert").value;

	var dob = document.getElementById("dateofBirth").value;
	if (typeofpension == "") {
		alert("Please select type of pension.")
		return false;
	}
	if (typeofpension != "" && selectedtext == "VRS") {
		if (vrs_date == "") {
			alert("Please enter vrs date.")
			return false;
		}
	}
	if (typeofpension != "" && selectedtext == "Death") {
		if (death_date == "") {
			alert("Please enter death date.")
			return false;
		}
	}
	if (wceserviceFlagYes.checked == true) {
		var wceflag = 0;
		if (wceyear != "") {
			wceflag = 1;
		}
		if (wcemonth != "") {
			wceflag = 1;
		}
		if (wceday != "") {
			wceflag = 1;
		}
		if (wceflag == 0) {
			alert("Please enter WCE service.");
			return false;
		}

	}
	if (contingentserviceFlagYes.checked == true) {
		var contingentflag = 0;
		if (contingentyear != "") {
			contingentflag = 1;
		}
		if (contingentmonth != "") {
			contingentflag = 1;
		}
		if (contingentday != "") {
			contingentflag = 1;
		}
		if (contingentflag == 0) {
			alert("Please enter contingent service.");
			return false;
		}
	}

	/*
	 * if(province_date=="") { alert("Please enter date of Provincialisation");
	 * return false; }
	 */
	if (province_date != "") {
		province_date_validation();
	}
	if (wceserviceFlagYes.checked == true) {
		if (regualr_estab_date != "") {
			regular_est_date_validation();
		}
		if (regualr_estab_date == "") {
			alert("Please enter Regular establishment date.");
			return false;
		}
	}
	if (grade == "Selection") {
		if (selection_grade_date != "") {
			selection_grade();
		}
		if (selection_grade_date == "") {
			alert("Please enter selection grade date.");
			return false;
		}
	}
	if ((grade == "Special") || (grade == "Super") || (grade == "Super Grade")) {
		if (selection_grade_date != "") {
			selection_grade();
		}
		if (selection_grade_date == "") {
			alert("Please enter selection grade date.");
			return false;
		}
		if (special_grade_date != "") {
			special_grade();
		}
		if (special_grade_date == "") {
			alert("Please enter special grade date");
			return false;
		}
	}

	if ((pensionCommutedFlagYes.checked == true)
			&& (pensionpertFlagpert.checked == true)) {
		if (commPert == "") {
			alert("Please enter commutation percentage.");
			return false;
		}
		if ((commPert != "") && (parseInt(commPert) > 33)) {
			alert("Please enter commutation percentage less than 33.");
			return false;
		}
	}
	
	
	/*Rajasekar Modification on 08-08-2012*/
	var Family_pension_ceiling_age=document.getElementById("Family_pension_ceiling_age").value;
	var Family_pension_ceiling_yrs=document.getElementById("Family_pension_ceiling_yrs").value;
	if(dar!="")
	{
	var retirementdate=dar;
	var dobdatesplit=dob.split("/");
	var dobdateday=dobdatesplit[0];
	var dobdatemonth=dobdatesplit[1]-1;
	var dobdateyear=dobdatesplit[2];
	var dobdate=new Date(dobdateyear,dobdatemonth,dobdateday);
	var sixfivedateyear=parseInt(dobdatesplit[2])+parseInt(Family_pension_ceiling_age);
	var d1 = new Date(sixfivedateyear,dobdatemonth,dobdateday);
	
	
	d1.setDate(d1.getDate());
	var dismonth=parseInt(d1.getMonth())+1;
	afterseven=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();
	
	d1.setDate(d1.getDate()-1);
	var dismonth=parseInt(d1.getMonth())+1;
	uptoseven=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();
	
	document.getElementById("fam_pen_upto_seven_date").value=uptoseven;
	document.getElementById("fam_pen_after_seven_date").value=afterseven;
	}
	if(vrs_date!="")
	{
		retirementdate=vrs_date;
		
		var dobdatesplit=dob.split("/");
		var dobdateday=dobdatesplit[0];
		var dobdatemonth=dobdatesplit[1]-1;
		var dobdateyear=dobdatesplit[2];
		var dobdate=new Date(dobdateyear,dobdatemonth,dobdateday);
		var sixfivedateyear=parseInt(dobdatesplit[2])+parseInt(Family_pension_ceiling_age);
		var d1 = new Date(sixfivedateyear,dobdatemonth,dobdateday);
		
		
		d1.setDate(d1.getDate());
		var dismonth=parseInt(d1.getMonth())+1;
		afterseven=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();
		
		d1.setDate(d1.getDate()-1);
		var dismonth=parseInt(d1.getMonth())+1;
		uptoseven=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();
		
		document.getElementById("fam_pen_upto_seven_date").value=uptoseven;
		document.getElementById("fam_pen_after_seven_date").value=afterseven;
	}	
	if( (dar!="") && (death_date!="") )
	{
		retirementdate=death_date;
		var datesplit=retirementdate.split("/");
		var dateday=datesplit[0];
		var datemonth=datesplit[1]-1;
		var dateyear=parseInt(datesplit[2])+parseInt(Family_pension_ceiling_yrs);
		//alert("Family_pension_ceiling_yrs"+Family_pension_ceiling_yrs);
		
		var d1 = new Date(dateyear,datemonth,dateday);	
		//alert("Death date"+retirementdate);
		//alert("adding seven years after death"+d1);
	//	var d2 = new Date(dateyear,datemonth,dateday);
		//alert("Date of birth"+dob);
		
		var dobdatesplit=dob.split("/");
		var dobdateday=dobdatesplit[0];
		var dobdatemonth=dobdatesplit[1]-1;
		var dobdateyear=parseInt(dobdatesplit[2])+parseInt(Family_pension_ceiling_age);
		var dobdate=new Date(dobdateyear,dobdatemonth,dobdateday);
		
		//alert("adding 65 age  of dob "+dobdate);
		
		var fromday=d1.getDate();
		var frommonth=parseInt(d1.getMonth())+1;
		var fromyear=d1.getFullYear();
		
		
		var today=dobdate.getDate();
		var tomonth=parseInt(dobdate.getMonth())+1;
		var toyear=dobdate.getFullYear();
		
		//alert("adding seven years after death"+fromday+"-"+frommonth+"-"+fromyear);
		
		//alert("adding 65 years after birth"+today+"-"+tomonth+"-"+toyear);
		
		//Find out the Minimum Date 
		
		var mindated=mindate(fromday,frommonth,fromyear,today,tomonth,toyear);
		
		
		//alert("minimum date"+mindated[0]+"-"+mindated[1]+"-"+mindated[2]);
		var minday=mindated[0];
		var minmonth=mindated[1];
		var minyear=mindated[2];
		uptoseven=minday+"/"+minmonth+"/"+minyear;
		afterseven=parseInt(minday)+parseInt(1)+"/"+minmonth+"/"+minyear;
		document.getElementById("fam_pen_upto_seven_date").value=uptoseven;
		document.getElementById("fam_pen_after_seven_date").value=afterseven;
		
		
		
		/*alert("Todate"+today+"-"+tomonth+"-"+toyear+"From Date"+fromday+"-"+frommonth+"-"+fromyear);
		
		if(isMinimumDate(today,tomonth,toyear,fromday,frommonth,fromyear)<0)
			{
			uptoseven=fromday+"/"+frommonth+"/"+fromyear;
			afterseven=parseInt(fromday)+parseInt(1) +"/"+frommonth+"/"+fromyear;
			alert("if condition"+uptoseven+"afterseven"+afterseven);
			document.getElementById("fam_pen_upto_seven_date").value=uptoseven;
			document.getElementById("fam_pen_after_seven_date").value=afterseven;
			}
		else
			{
			
			uptoseven=today+"/"+tomonth+"/"+toyear;
			afterseven=parseInt(today)+parseInt(1) +"/"+tomonth+"/"+toyear;
			alert("else condition"+uptoseven+"afterseven"+afterseven);
			document.getElementById("fam_pen_upto_seven_date").value=uptoseven;
			document.getElementById("fam_pen_after_seven_date").value=afterseven;
			
			}*/
		
	}
	/*Rajasekar Modification on 08-08-2012 End*/
	
	
	/*
	 * var retirementdate = dar;
	if (vrs_date != "") {
		retirementdate = vrs_date;
	}
	if (death_date != "") {
		retirementdate = death_date;
	}
	 * var
	 * Family_pension_ceiling_yrs=document.getElementById("Family_pension_ceiling_yrs").value;
	 * var
	 * Family_pension_ceiling_age=document.getElementById("Family_pension_ceiling_age").value;
	 * var datesplit=retirementdate.split("/"); var dateday=datesplit[0]; var
	 * datemonth=datesplit[1]-1; var
	 * dateyear=parseInt(datesplit[2])+parseInt(Family_pension_ceiling_yrs); var
	 * d1 = new Date(dateyear,datemonth,dateday); var d2 = new
	 * Date(dateyear,datemonth,dateday);
	 * 
	 * var dobdatesplit=dob.split("/"); var dobdateday=dobdatesplit[0]; var
	 * dobdatemonth=dobdatesplit[1]-1; var dobdateyear=dobdatesplit[2]; var
	 * dobdate=new Date(dobdateyear,dobdatemonth,dobdateday);
	 * 
	 * var dobdated=datediff(d1,dobdate); //alert(dobdated[0]); var
	 * penmaxvalyear=dobdated[0]; var penmaxvalmonth=dobdated[1]; var
	 * penmaxvalday=dobdated[2]; if(penmaxvalyear>Family_pension_ceiling_age) {
	 * //var dateyear=parseInt(datesplit[2])+parseInt(5); var
	 * dateyear=parseInt(dobdated[2])+parseInt(Family_pension_ceiling_age); var
	 * d1 = new Date(dateyear,datemonth,dateday); var d2 = new
	 * Date(dateyear,datemonth,dateday); } //d1.setDate(d1.getDate() - 1);
	 * 
	 * d1.setDate(d1.getDate()); var dismonth=parseInt(d1.getMonth())+1;
	 * uptoseven=d1.getDate()+"/"+dismonth+"/"+d1.getFullYear();
	 * 
	 * d2.setDate(d2.getDate() + 1); var dismonth=parseInt(d2.getMonth())+1;
	 * afterseven=d2.getDate()+"/"+dismonth+"/"+d2.getFullYear();
	 */

	// after demo

	/*var Family_pension_ceiling_age = document
			.getElementById("Family_pension_ceiling_age").value;
	var dobdatesplit = dob.split("/");
	var dobdateday = dobdatesplit[0];
	var dobdatemonth = dobdatesplit[1] - 1;
	var dobdateyear = dobdatesplit[2];
	var dobdate = new Date(dobdateyear, dobdatemonth, dobdateday);
	var sixfivedateyear = parseInt(dobdatesplit[2])
			+ parseInt(Family_pension_ceiling_age);
	var d1 = new Date(sixfivedateyear, dobdatemonth, dobdateday);

	d1.setDate(d1.getDate());
	var dismonth = parseInt(d1.getMonth()) + 1;
	afterseven = d1.getDate() + "/" + dismonth + "/" + d1.getFullYear();

	d1.setDate(d1.getDate() - 1);
	var dismonth = parseInt(d1.getMonth()) + 1;
	uptoseven = d1.getDate() + "/" + dismonth + "/" + d1.getFullYear();

	document.getElementById("fam_pen_upto_seven_date").value = uptoseven;
	document.getElementById("fam_pen_after_seven_date").value = afterseven;*/
	/*
	 * alert("uptoseven="+uptoseven); alert("afterseven="+afterseven);
	 * alert("Family_pension_ceiling_yrs="+Family_pension_ceiling_yrs);
	 * alert("Family_pension_ceiling_age="+Family_pension_ceiling_age);
	 */

	return true;
}

function total_service_validation() {
	var npp_year = 0;
	var npp_month = 0;
	var npp_day = 0;

	var ewm_year = 0;
	var ewm_month = 0;
	var ewm_day = 0;

	var s_year = 0;
	var s_month = 0;
	var s_day = 0;

	var bs_year = 0;
	var bs_month = 0;
	var bs_day = 0;

	var ol_year = 0;
	var ol_month = 0;
	var ol_day = 0;

	var lnr_year = 0;
	var lnr_month = 0;
	var lnr_day = 0;

	var as_year = 0;
	var as_month = 0;
	var as_day = 0;

	var svnd_year = 0;
	var svnd_month = 0;
	var svnd_day = 0;

	var tqs_year = 0;
	var tqs_month = 0;
	var tqs_day = 0;

	var fs_year = 0;
	var fs_month = 0;
	var fs_day = 0;

	var nqs_year = 0;
	var nqs_month = 0;
	var nqs_day = 0;

	var yearmax = 42;
	var monthmax = 11;
	var daymax = 29;

	if (document.getElementById("npp_year").value != "") {
		if (parseInt(document.getElementById("npp_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("npp_year").value = "";
		} else {
			npp_year = document.getElementById("npp_year").value;
		}
	}
	if (document.getElementById("npp_month").value != "") {
		if (parseInt(document.getElementById("npp_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("npp_month").value = "";
		} else {
			npp_month = document.getElementById("npp_month").value;
		}

	}
	if (document.getElementById("npp_day").value != "") {

		if (parseInt(document.getElementById("npp_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("npp_day").value = "";
		} else {
			npp_day = document.getElementById("npp_day").value;
		}

	}

	if (document.getElementById("ewm_year").value != "") {
		if (parseInt(document.getElementById("ewm_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("ewm_year").value = "";
		} else {
			ewm_year = document.getElementById("ewm_year").value;
		}
	}
	if (document.getElementById("ewm_month").value != "") {
		if (parseInt(document.getElementById("ewm_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("ewm_month").value = "";
		} else {
			ewm_month = document.getElementById("ewm_month").value;
		}
	}
	if (document.getElementById("ewm_day").value != "") {
		if (parseInt(document.getElementById("ewm_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("ewm_day").value = "";
		} else {
			ewm_day = document.getElementById("ewm_day").value;
		}
	}

	if (document.getElementById("s_year").value != "") {
		if (parseInt(document.getElementById("s_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("s_year").value = "";
		} else {
			s_year = document.getElementById("s_year").value;
		}
	}
	if (document.getElementById("s_month").value != "") {
		if (parseInt(document.getElementById("s_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("s_month").value = "";
		} else {
			s_month = document.getElementById("s_month").value;
		}
	}
	if (document.getElementById("s_day").value != "") {
		if (parseInt(document.getElementById("s_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("s_day").value = "";
		} else {
			s_day = document.getElementById("s_day").value;
		}
	}

	if (document.getElementById("bs_year").value != "") {
		if (parseInt(document.getElementById("bs_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("bs_year").value = "";
		} else {
			bs_year = document.getElementById("bs_year").value;
		}
	}
	if (document.getElementById("bs_month").value != "") {
		if (parseInt(document.getElementById("bs_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("bs_month").value = "";
		} else {
			bs_month = document.getElementById("bs_month").value;
		}
	}
	if (document.getElementById("bs_day").value != "") {
		if (parseInt(document.getElementById("bs_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("bs_day").value = "";
		} else {
			bs_day = document.getElementById("bs_day").value;
		}
	}

	if (document.getElementById("ol_year").value != "") {
		if (parseInt(document.getElementById("ol_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("ol_year").value = "";
		} else {
			ol_year = document.getElementById("ol_year").value;
		}
	}
	if (document.getElementById("ol_month").value != "") {
		if (parseInt(document.getElementById("ol_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("ol_month").value = "";
		} else {
			ol_month = document.getElementById("ol_month").value;
		}
	}
	if (document.getElementById("ol_day").value != "") {
		if (parseInt(document.getElementById("ol_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("ol_day").value = "";
		} else {
			ol_day = document.getElementById("ol_day").value;
		}
	}

	if (document.getElementById("lnr_year").value != "") {
		if (parseInt(document.getElementById("lnr_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("lnr_year").value = "";
		} else {
			lnr_year = document.getElementById("lnr_year").value;
		}
	}
	if (document.getElementById("lnr_month").value != "") {
		if (parseInt(document.getElementById("lnr_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("lnr_month").value = "";
		} else {
			lnr_month = document.getElementById("lnr_month").value;
		}
	}
	if (document.getElementById("lnr_day").value != "") {
		if (parseInt(document.getElementById("lnr_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("lnr_day").value = "";
		} else {
			lnr_day = document.getElementById("lnr_day").value;
		}
	}

	if (document.getElementById("as_year").value != "") {
		if (parseInt(document.getElementById("as_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("as_year").value = "";
		} else {
			as_year = document.getElementById("as_year").value;
		}
	}
	if (document.getElementById("as_month").value != "") {
		if (parseInt(document.getElementById("as_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("as_month").value = "";
		} else {
			as_month = document.getElementById("as_month").value;
		}
	}
	if (document.getElementById("as_day").value != "") {
		if (parseInt(document.getElementById("as_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("as_day").value = "";
		} else {
			as_day = document.getElementById("as_day").value;
		}
	}

	if (document.getElementById("svnd_year").value != "") {
		if (parseInt(document.getElementById("svnd_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("svnd_year").value = "";
		} else {
			svnd_year = document.getElementById("svnd_year").value;
		}
	}
	if (document.getElementById("svnd_month").value != "") {
		if (parseInt(document.getElementById("svnd_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("svnd_month").value = "";
		} else {
			svnd_month = document.getElementById("svnd_month").value;
		}
	}
	if (document.getElementById("svnd_day").value != "") {
		if (parseInt(document.getElementById("svnd_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("svnd_day").value = "";
		} else {
			svnd_day = document.getElementById("svnd_day").value;
		}
	}

	if (document.getElementById("fs_year").value != "") {
		if (parseInt(document.getElementById("fs_year").value) > parseInt(yearmax)) {
			alert("Enter year between 0 to " + yearmax);
			document.getElementById("fs_year").value = "";
		} else {
			fs_year = document.getElementById("fs_year").value;
		}
	}
	if (document.getElementById("fs_month").value != "") {
		if (parseInt(document.getElementById("fs_month").value) > parseInt(monthmax)) {
			alert("Enter month between 0 to " + monthmax);
			document.getElementById("fs_month").value = "";
		} else {
			fs_month = document.getElementById("fs_month").value;
		}
	}
	if (document.getElementById("fs_day").value != "") {
		if (parseInt(document.getElementById("fs_day").value) > parseInt(daymax)) {
			alert("Enter days between 0 to " + daymax);
			document.getElementById("fs_day").value = "";
		} else {
			fs_day = document.getElementById("fs_day").value;
		}
	}

	tqs_year = parseInt(npp_year) + parseInt(ewm_year) + parseInt(s_year)
			+ parseInt(bs_year) + parseInt(ol_year) + parseInt(lnr_year)
			+ parseInt(as_year) + parseInt(svnd_year);

	tqs_month = parseInt(npp_month) + parseInt(ewm_month) + parseInt(s_month)
			+ parseInt(bs_month) + parseInt(ol_month) + parseInt(lnr_month)
			+ parseInt(as_month) + parseInt(svnd_month);

	tqs_day = parseInt(npp_day) + parseInt(ewm_day) + parseInt(s_day)
			+ parseInt(bs_day) + parseInt(ol_day) + parseInt(lnr_day)
			+ parseInt(as_day) + parseInt(svnd_day);

	if (tqs_day > 29) {

		tqs_dayremainer = tqs_day % 30;
		tqs_daydivident = tqs_day / 30;

		tqs_month = parseInt(tqs_month) + parseInt(tqs_daydivident);
		tqs_day = tqs_dayremainer;
	}
	if (tqs_month > 11) {

		tqs_monthremainer = tqs_month % 12;
		tqs_monthdivident = tqs_month / 12;

		tqs_year = parseInt(tqs_year) + parseInt(tqs_monthdivident);
		tqs_month = tqs_monthremainer;

	}

	aws_year = document.getElementById("aws_year").value;
	aws_month = document.getElementById("aws_month").value;
	aws_day = document.getElementById("aws_day").value;

	/*
	 * aws_year=parseInt(aws_year)+parseInt(fs_year);
	 * aws_month=parseInt(aws_month)+parseInt(fs_month);
	 * aws_day=parseInt(aws_day)+parseInt(fs_day);
	 */

	if (aws_day > 29) {
		aws_dayremainer = aws_day % 30;
		aws_daydivident = aws_day / 30;
		aws_month = parseInt(aws_month) + parseInt(aws_daydivident);
		aws_day = aws_dayremainer;
	}
	if (aws_month > 11) {
		aws_monthremainer = aws_month % 12;
		aws_monthdivident = aws_month / 12;

		aws_year = parseInt(aws_year) + parseInt(aws_monthdivident);
		aws_month = aws_monthremainer;

	}

	var disflag = 0;
	if (tqs_year > aws_year) {
		alert("Please Enter valid services");
		disflag = 1;
	} else if (tqs_year == aws_year) {
		if (tqs_month > aws_month) {
			alert("Please Enter valid services");
			disflag = 1;
		} else if (tqs_month == aws_month) {
			if (tqs_day > aws_day) {
				alert("Please Enter valid services");
				disflag = 1;
			}
		}
	}
	if (disflag == 1) {
		return false;
	}
	if (disflag == 0) {
		if (disflag == 0) {
			document.getElementById("tqs_year").value = tqs_year;
			document.getElementById("tqs_month").value = tqs_month;
			document.getElementById("tqs_day").value = tqs_day;
		}

		nqs_year = parseInt(aws_year) - parseInt(tqs_year);
		nqs_month = parseInt(aws_month) - parseInt(tqs_month);
		nqs_day = parseInt(aws_day) - parseInt(tqs_day);

		if (parseInt(nqs_day) < 0) {
			nqs_month = parseInt(nqs_month) - 1;
			nqs_day = 30 + parseInt(nqs_day);
		}
		if (parseInt(nqs_month) < 0) {
			nqs_year = parseInt(nqs_year) - 1;
			nqs_month = 12 + parseInt(nqs_month);
		}

		if (disflag == 0) {
			document.getElementById("nqs_year").value = nqs_year;
			document.getElementById("nqs_month").value = nqs_month;
			document.getElementById("nqs_day").value = nqs_day;
		}

		cal_number_of_half_year();
		return true;
	}
	// return true;
}

function last_pay_drawn_validation() {
	var lastbasic = document.getElementById("lastbasic").value;
	if (lastbasic == "") {
		alert("Please enter basic pay of last pay drawn.");
		return false;
	}
	return true;
}

function ae_form_final_validation() {
	try {
		var counttotmonth = 0;
		var counttotday = 0;
		var validmaxaemonths = parseInt(document
				.getElementById("Avg_total_months").value);
		tbodyvar = document.getElementById("test");
		if (tbodyvar.rows.length > 0) {
			var valfl = 0;
			for (i = 0; i < document.AEForm.todate.length; i++) {
				if (document.AEForm.fromdate[i].value == "") {
					valfl = 1;
					document.AEForm.fromdate[i].style.background = "red";
				}
				if (document.AEForm.todate[i].value == "") {
					valfl = 1;
					document.AEForm.todate[i].style.background = "red";
				}
				if (document.AEForm.todate[i].value != "") {
					var tt = document.AEForm.todate[i].value;
					var ff = document.AEForm.fromdate[i].value;
					var datesSep = tt.split("/");
					var datesSep1 = ff.split("/");
					if (isGreaterDate(datesSep[0], datesSep[1], datesSep[2],
							datesSep1[0], datesSep1[1], datesSep1[2])) {
						document.AEForm.todate[i].style.background = "red";
						valfl = 1;
					} else {
						document.AEForm.todate[i].style.background = "white";

						var tdate = new Date(datesSep[2], datesSep[1] - 1,
								datesSep[0]);
						var fdate = new Date(datesSep1[2], datesSep1[1] - 1,
								datesSep1[0]);

						var dated = datediff(tdate, fdate);
						var fromtotday = DaysInMonth(datesSep1[2], datesSep1[1]);
						var findday = DaysInMonth(datesSep[2], datesSep[1]);
						var totmonth = 0;
						var totday = dated[2];
						if (dated[0] > 0) {
							totmonth = dated[0] * 12;
						}
						if (dated[1] > 0) {
							totmonth = totmonth + dated[1];
						}
						/*
						 * if(totday>0) { totday=totday+1; }
						 */
						if (totday > 0) {
							if (datesSep[0] == 31 && fromtotday == 30
									&& datesSep1[0] != 1) {
								totday = totday;
							} else {
								totday = totday + 1;
							}
						}
						if (dated[2] == 0) {
							totday = 1;
						}
						if (dated[2] >= 29) {
							totday = 0;
							totmonth = totmonth + 1;
						} else if (parseInt(findday) == parseInt(totday)) {
							totday = 0;
							totmonth = totmonth + 1;
						}
						document.AEForm.tmonth[i].value = totmonth;
						document.AEForm.tday[i].value = totday;

						ffdate = document.AEForm.fromdate[i].value;
						ttdate = document.AEForm.todate[i].value;
						tday = totday;
						tmon = totmonth;
						totalamount = document.AEForm.amount[i].value;
						if ((ffdate != "") && (ttdate != "") && (tday != "")
								&& (totalamount != "")) {
							document.AEForm.ppamount[i].value = calcppamount(
									ffdate, ttdate, tday, totalamount, tmon);
						}

						if (i == parseInt(document.AEForm.todate.length) - 1) {
							var finaltodate = document.AEForm.todate[i].value;

							var finalbasicpay = 0;
							var finalgradepay = 0;
							var finalspecialpay = 0;
							var finaloptionpay1 = 0;
							var finaloptionpay2 = 0;
							var finaloptionpay3 = 0;
							//var finallevelofpay=0;

							if (document.AEForm.basic_pay[i].value != "") {
								finalbasicpay = parseInt(document.AEForm.basic_pay[i].value);
							}
							/*if (document.AEForm.grade_pay[i].value != "") {
								finalgradepay = parseInt(document.AEForm.grade_pay[i].value);
							}*/
							if (document.AEForm.special_pay[i].value != "") {
								finalspecialpay = parseInt(document.AEForm.special_pay[i].value);
							}
							if (document.AEForm.optionpay1[i].value != "") {
								finaloptionpay1 = parseInt(document.AEForm.optionpay1[i].value);
							}
							if (document.AEForm.optionpay2[i].value != "") {
								finaloptionpay2 = parseInt(document.AEForm.optionpay2[i].value);
							}
							if (document.AEForm.optionpay3[i].value != "") {
								finaloptionpay3 = parseInt(document.AEForm.optionpay3[i].value);
							}
							

						}

					}

				}
				if ((document.AEForm.maxcheck[i].checked == false)) {
					if (document.AEForm.basic_pay[i].value == "") {
						valfl = 1;
						document.AEForm.basic_pay[i].style.background = "red";
					}
				/*	if (document.AEForm.grade_pay[i].value == "") {
						valfl = 1;
						document.AEForm.grade_pay[i].style.background = "red";
					}*/

					counttotmonth = counttotmonth
							+ parseInt(document.AEForm.tmonth[i].value);
					counttotday = counttotday
							+ parseInt(document.AEForm.tday[i].value);

				}
				if ((document.AEForm.maxcheck[i].checked == true)
						|| (document.AEForm.maxcheck[i].checked == "true")) {

					document.AEForm.basic_pay[i].style.background = "white";
					document.AEForm.grade_pay[i].style.background = "white";

				}

				calctotamount1(i);

				fdate = document.AEForm.fromdate[i].value;
				tdate = document.AEForm.todate[i].value;
				tday = document.AEForm.tday[i].value;
				tmon = document.AEForm.tmonth.value;
				totalamount = document.AEForm.amount[i].value;
				if ((fdate != "") && (tdate != "") && (tday != "")
						&& (totalamount != "")) {
					document.AEForm.ppamount[i].value = calcppamount(fdate,
							tdate, tday, totalamount, tmon);
				}

				// alert(document.AEForm.maxcheck_value[i].value);
				if (document.AEForm.maxcheck_value[0].value == "") {
					document.AEForm.maxcheck_value[0].value = "N";
				}

			}
			if (valfl == 0) {

				// disabledaegrid();
				// return true;

			} else {
				alert("Please Enter valid data in average emoluments form.");
				return false;
			}

		} else {

			if (document.AEForm.fromdate.value == "") {
				alert("Enter from date in average emoluments form.");
				return false;
			}
			if (document.AEForm.todate.value == "") {
				alert("Enter to date in average emoluments form.");
				return false;
			}
			if ((document.AEForm.maxcheck.checked == false)
					|| (document.AEForm.maxcheck.checked == "false")) {
				if (document.AEForm.basic_pay.value == "") {
					alert("Enter basic pay in average emoluments form.");
					return false;
				}
				/*if (document.AEForm.grade_pay.value == "") {
					alert("Enter grade pay in average emoluments form.");
					return false;
				}*/

				counttotmonth = counttotmonth
						+ parseInt(document.AEForm.tmonth.value);
				counttotday = counttotday
						+ parseInt(document.AEForm.tday.value);
			}
			calctotamount();
			fdate = document.AEForm.fromdate.value;
			tdate = document.AEForm.todate.value;
			var finaltodate = tdate;
			tday = document.AEForm.tday.value;
			tmon = document.AEForm.tmonth.value;
			totalamount = document.AEForm.amount.value;
			if ((fdate != "") && (tdate != "") && (tday != "")
					&& (totalamount != "")) {
				document.AEForm.ppamount.value = calcppamount(fdate, tdate,
						tday, totalamount, tmon);
			}

			var finalbasicpay = 0;
			var finalgradepay = 0;
			var finalspecialpay = 0;
			var finaloptionpay1 = 0;
			var finaloptionpay2 = 0;
			var finaloptionpay3 = 0;

			if (document.AEForm.basic_pay.value != "") {
				finalbasicpay = parseInt(document.AEForm.basic_pay.value);
			}
			/*if (document.AEForm.grade_pay.value != "") {
				finalgradepay = parseInt(document.AEForm.grade_pay.value);
			}*/
			if (document.AEForm.special_pay.value != "") {
				finalspecialpay = parseInt(document.AEForm.special_pay.value);
			}
			if (document.AEForm.optionpay1.value != "") {
				finaloptionpay1 = parseInt(document.AEForm.optionpay1.value);
			}
			if (document.AEForm.optionpay2.value != "") {
				finaloptionpay2 = parseInt(document.AEForm.optionpay2.value);
			}
			if (document.AEForm.optionpay3.value != "") {
				finaloptionpay3 = parseInt(document.AEForm.optionpay3.value);
			}

			if (document.AEForm.maxcheck_value.value == "") {
				document.AEForm.maxcheck_value.value = "N";
			}

		}

		var tdayremain = counttotday % 30;
		var tda = counttotday / 30;

		counttotmonth = counttotmonth + tda;

		if (counttotmonth == parseInt(validmaxaemonths)) {
			var superanuation_date = document.getElementById("dar").value;
			var vrs_date = document.getElementById("vrs_date").value;
			var death_date = document.getElementById("death_date").value;
			var valid_reitirementdate = superanuation_date;
			var lastbasicpay = 0;
			var lastgradepay = 0;
			var lastspecialpay = 0;
			var lastother1pay = 0;
			var lastother2pay = 0;
			var lastother3pay = 0;
			if (document.getElementById("lastbasic").value != "") {
				var lastbasicpay = parseInt(document
						.getElementById("lastbasic").value);
			}
			/*if (document.getElementById("lastgrade").value != "") {
				var lastgradepay = parseInt(document
						.getElementById("lastgrade").value);
			}*/
			if (document.getElementById("lastspecial").value != "") {
				var lastspecialpay = parseInt(document
						.getElementById("lastspecial").value);
			}
			if (document.getElementById("lastother1").value != "") {
				var lastother1pay = parseInt(document
						.getElementById("lastother1").value);
			}
			if (document.getElementById("lastother2").value != "") {
				var lastother2pay = parseInt(document
						.getElementById("lastother2").value);
			}
			if (document.getElementById("lastother3").value != "") {
				var lastother3pay = parseInt(document
						.getElementById("lastother3").value);
			}

			if (vrs_date != "") {
				valid_reitirementdate = vrs_date;
			}
			if (death_date != "") {
				valid_reitirementdate = death_date;
			}
			// alert(finaltodate);
			// alert(valid_reitirementdate);
			if (finaltodate != valid_reitirementdate) {
				alert("Last pay to date is should be equal to your retirement date.");
				return false;
			}
			if ((finalbasicpay != lastbasicpay)
					//|| (finalgradepay != lastgradepay)
					|| (finalspecialpay != lastspecialpay)
					|| (finaloptionpay1 != lastother1pay)
					|| (finaloptionpay2 != lastother2pay)
					|| (finaloptionpay3 != lastother3pay)) {
				alert("Last pay entry should be equal to LPD entry.");
				return false;
			}
			return true;
		} else {
			alert("Enter Maximum " + validmaxaemonths + " months");
			return false;
		}

	} catch (e) {
		// alert(e.message);
	}

}

function rec_form_final_validation() {
	try {

		tbodyvar = document.getElementById("rectest");
		var recdescriptionEntity = document.AEForm.rec_description;
		var recamountEntity = document.AEForm.rec_amount;
		if (tbodyvar.rows.length > 0) {
			var valfl = 0;
			for (i = 0; i < recdescriptionEntity.length; i++) {
				if (recdescriptionEntity[i].value == "") {
					valfl = 1;
					recdescriptionEntity[i].style.background = "red";
				} else if (recdescriptionEntity[i].value != "") {
					recdescriptionEntity[i].style.background = "white";
				}
				if (recamountEntity[i].value == "") {
					valfl = 1;
					recamountEntity[i].style.background = "red";
				} else if (recamountEntity[i].value != "") {
					recamountEntity[i].style.background = "white";
				}

			}
			if (valfl == 0) {
				refresh_totalrecamount();
			} else {
				alert("Please Enter valid data in recoveries.");
				return false;
			}

		} else {
			/*
			 * if(recdescriptionEntity.value=="") { alert("Enter recovery
			 * description"); return false; } if(recamountEntity.value=="") {
			 * alert("Enter recovery amount"); return false; }
			 */
			refresh_totalrecamount();
		}
		// addRecoveries();
		return true;

	} catch (e) {
		alert(e.message);
	}

}
function eligible_pension_validation() {
	var gpf = document.getElementById("gpfNo").value;
	var eligiblequalservice = 0;
	var typeofpension = document.getElementById("classPensionId").value;
	var typeofpensionid = document.getElementById("classPensionId");
	var selectedindex = typeofpensionid.selectedIndex;
	var selectedtext = typeofpensionid.options[selectedindex].text;

	var nqs_year = document.getElementById("nqs_year").value;
	var nqs_month = document.getElementById("nqs_month").value;
	var nqs_day = document.getElementById("nqs_day").value;

	if (selectedtext == "VRS") {
		eligiblequalservice = 20;
	}
	if (selectedtext == "Super Annuation") {
		eligiblequalservice = 10;
	}

	if (gpf == "") {
		alert("No GPF number.so pension not eligible.");
		return false;
	}
	if (parseInt(eligiblequalservice) > parseInt(nqs_year)) {
		alert("Pension not eligible. Need minimum " + eligiblequalservice
				+ " year for " + selectedtext);
		return false;
	}
	return true;
}

function lastcalc() {

	var lastbasic = document.getElementById("lastbasic").value;
	//var lastgrade = document.getElementById("lastgrade").value;
	var lastspecial = document.getElementById("lastspecial").value;
	var lastother1 = document.getElementById("lastother1").value;
	var lastother2 = document.getElementById("lastother2").value;
	var lastother3 = document.getElementById("lastother3").value;
	var lastlevel = document.getElementById("lastlevel").value;
	
	if (lastlevel >32)
	{
	alert("Please Enter Correct value");
	document.getElementById("lastlevel").value="";
	document.getElementById("lastlevel").focus();
	
	}

	if (lastbasic == "") {
		lastbasic = 0;
	}
	/*if (lastgrade == "") {
		lastgrade = 0;
	}*/
	if (lastspecial == "") {
		lastspecial = 0;
	}
	if (lastother1 == "") {
		lastother1 = 0;
	}
	if (lastother2 == "") {
		lastother2 = 0;
	}
	if (lastother3 == "") {
		lastother3 = 0;
	}

	if (lastlevel == "") {
		lastlevel = 0;
	}
/*
	var lasttotal = parseInt(lastbasic) + parseInt(lastgrade)
			+ parseInt(lastspecial) + parseInt(lastother1)
			+ parseInt(lastother2) + parseInt(lastother3);*/
	var lasttotal = parseInt(lastbasic) 
	+ parseInt(lastspecial) + parseInt(lastother1)
	+ parseInt(lastother2) + parseInt(lastother3);

	document.getElementById("lasttotal").value = lasttotal;

}

function cleanPEN_DETAILS() {

	document.getElementById("wceserviceFlagNo").checked = 'checked';
	document.getElementById("wcecountedFlagNo").checked = 'checked';
	document.getElementById("contingentserviceFlagNo").checked = 'checked';
	document.getElementById("pensionCommutedFlagYes").checked = 'checked';
	document.getElementById("pensionpertFlagonethird").checked = 'checked';
	document.getElementById("pensionpertFlagonethird").disabled = false;
	document.getElementById("pensionpertFlagpert").disabled = false;
	document.getElementById("wcecountedFlagYes").disabled = true;
	document.getElementById("wcecountedFlagNo").disabled = true;

	document.getElementById("commPert").value = "";
	document.getElementById("commPert").disabled = true;
	document.getElementById("commPert").style.backgroundColor = '#dddddf';
	document.getElementById("regualr_estab_date").disabled = true;
	document.getElementById("regualr_estab_date").style.backgroundColor = '#dddddf';
	document.getElementById("cal-button-10").style.display = "none";

	// document.getElementById("vrs_date").value="";
	document.getElementById("vrs_date").readonly = true;
	document.getElementById("vrs_date").style.backgroundColor = '#dddddf';
	document.getElementById("cal-button-7").style.display = "none";

	// document.getElementById("death_date").value="";
	document.getElementById("death_date").readonly = true;
	document.getElementById("death_date").style.backgroundColor = '#dddddf';
	document.getElementById("cal-button-13").style.display = "none";

	var grade = document.getElementById("gradeId").value;
	if (grade == "Selection") {
		document.getElementById("special_grade_date").value = "";
		document.getElementById("special_grade_date").disabled = true;
		document.getElementById("special_grade_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-12").style.display = "none";

		document.getElementById("selection_grade_date").value = "";
		document.getElementById("selection_grade_date").disabled = false;
		document.getElementById("selection_grade_date").style.backgroundColor = '#ffffff';
		document.getElementById("cal-button-11").style.display = "inline";
	}
	if ((grade == "Special") || (grade == "Super Grade") || (grade == "Super")) {
		document.getElementById("special_grade_date").value = "";
		document.getElementById("special_grade_date").disabled = false;
		document.getElementById("special_grade_date").style.backgroundColor = '#ffffff';
		document.getElementById("cal-button-12").style.display = "inline";

		document.getElementById("selection_grade_date").value = "";
		document.getElementById("selection_grade_date").disabled = false;
		document.getElementById("selection_grade_date").style.backgroundColor = '#ffffff';
		document.getElementById("cal-button-11").style.display = "inline";

	}
	if (grade == "Normal") {
		document.getElementById("selection_grade_date").value = "";
		document.getElementById("selection_grade_date").disabled = true;
		document.getElementById("selection_grade_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-11").style.display = "none";

		document.getElementById("special_grade_date").value = "";
		document.getElementById("special_grade_date").disabled = true;
		document.getElementById("special_grade_date").style.backgroundColor = '#dddddf';
		document.getElementById("cal-button-12").style.display = "none";
	}
	// document.getElementById("classPensionId").value="";
	// document.getElementById("vrs_date").value="";

	document.getElementById("wceyear").value = "";
	document.getElementById("wcemonth").value = "";
	document.getElementById("wceday").value = "";

	document.getElementById("wceyear").disabled = true;
	document.getElementById("wceyear").style.backgroundColor = '#dddddf';
	document.getElementById("wcemonth").disabled = true;
	document.getElementById("wcemonth").style.backgroundColor = '#dddddf';
	document.getElementById("wceday").disabled = true;
	document.getElementById("wceday").style.backgroundColor = '#dddddf';

	document.getElementById("contingentyear").value = "";
	document.getElementById("contingentmonth").value = "";
	document.getElementById("contingentday").value = "";

	document.getElementById("contingentyear").disabled = true;
	document.getElementById("contingentyear").style.backgroundColor = '#dddddf';
	document.getElementById("contingentmonth").disabled = true;
	document.getElementById("contingentmonth").style.backgroundColor = '#dddddf';
	document.getElementById("contingentday").disabled = true;
	document.getElementById("contingentday").style.backgroundColor = '#dddddf';

	document.getElementById("province_date").value = "";
	document.getElementById("regualr_estab_date").value = "";
	document.getElementById("selection_grade_date").value = "";
	document.getElementById("special_grade_date").value = "";

	document.getElementById("commPert").value = "";
}
function cleanLPD() {
	document.getElementById("lastbasic").value = "";
	document.getElementById("lastgrade").value = "";
	document.getElementById("lastspecial").value = "";
	document.getElementById("lastother1").value = "";
	document.getElementById("lastother2").value = "";
	document.getElementById("lastother3").value = "";
	document.getElementById("lasttotal").value = "";
}
function cleanNON_QUAL_SER() {
	document.getElementById("npp_year").value = "";
	document.getElementById("npp_month").value = "";
	document.getElementById("npp_day").value = "";

	document.getElementById("ewm_year").value = "";
	document.getElementById("ewm_month").value = "";
	document.getElementById("ewm_day").value = "";

	document.getElementById("s_year").value = "";
	document.getElementById("s_month").value = "";
	document.getElementById("s_day").value = "";

	document.getElementById("bs_year").value = "";
	document.getElementById("bs_month").value = "";
	document.getElementById("bs_day").value = "";

	document.getElementById("ol_year").value = "";
	document.getElementById("ol_month").value = "";
	document.getElementById("ol_day").value = "";

	document.getElementById("lnr_year").value = "";
	document.getElementById("lnr_month").value = "";
	document.getElementById("lnr_day").value = "";

	document.getElementById("as_year").value = "";
	document.getElementById("as_month").value = "";
	document.getElementById("as_day").value = "";

	document.getElementById("svnd_year").value = "";
	document.getElementById("svnd_month").value = "";
	document.getElementById("svnd_day").value = "";

	document.getElementById("fs_year").value = "";
	document.getElementById("fs_month").value = "";
	document.getElementById("fs_day").value = "";

	document.getElementById("tqs_year").value = "";
	document.getElementById("tqs_month").value = "";
	document.getElementById("tqs_day").value = "";

	document.getElementById("fs_yeardis").value = "";
	document.getElementById("fs_monthdis").value = "";
	document.getElementById("fs_daydis").value = "";

	document.getElementById("contingent_yeardis").value = "";
	document.getElementById("contingent_monthdis").value = "";
	document.getElementById("contingent_daydis").value = "";
	document.getElementById("contingentdislable").style.display = "none";
	document.getElementById("contingentyeardis").style.display = "none";
	document.getElementById("contingentmonthdis").style.display = "none";
	document.getElementById("contingentdaydis").style.display = "none";

	document.getElementById("wce_yeardis").value = "";
	document.getElementById("wce_monthdis").value = "";
	document.getElementById("wce_daydis").value = "";

	document.getElementById("wcedislable").style.display = "none";
	document.getElementById("wceyeardis").style.display = "none";
	document.getElementById("wcemonthdis").style.display = "none";
	document.getElementById("wcedaydis").style.display = "none";
	try
	{
	calcservice();
	}
	catch(e)
	{
		//alert(e.message);
	}

	/*calcworkservice();
	calcworkservice_dupli();
	calctotalnqs();*/
}

function numberwithhibenOnly(e, oBj) {
	var keynum
	var keychar
	var numcheck

	if (window.event) // IE
	{
		keynum = e.keyCode
	} else if (e.which) // Netscape/Firefox/Opera
	{
		keynum = e.which
	}
	var keychar = String.fromCharCode(keynum)
	// var splCharCheck = /[0-9!@#$%&*()+=|_"'`~:;<>?,.\/\\\^\\{\}\[\]]/;
	var splCharCheck = /[a-zA-Z!@#$%&*()+=|_"'`~:;<>?,.\/\\\^\\{\}\[\]]/;
	return (!splCharCheck.test(keychar))
}