history.forward();

function notNull() {
	//alert("password----->"+document.frmindex.txtword.value);
	if ((document.frmindex.txtID.value == null)
			|| (document.frmindex.txtID.value.length == 0)) {
		alert("Enter User Name");
		document.frmindex.reset();

		return false;
	} else if ((document.frmindex.txtword.value == null)
			|| (document.frmindex.txtword.value.length == 0)) {
		alert("Enter Password");
		document.frmindex.reset();

		return false;
	} else if ((document.frmindex.captchaval.value == null)
			|| (document.frmindex.captchaval.value.length == 0)) {
		alert("Enter Above Code");
		//document.frmindex.reset();

		return false;
	}

	/*
	  If the username and password is not null and undefined then the cursor is made to Hour Glass in the sense
	  that the username and password is passed to the Uservalidation servlet for authentication.        
	 */
	else {
	//	alert(document.frmindex.txtID.value);
	  //   alert(document.frmindex.txtword.value);
    	var password = SHA256(document.frmindex.txtword.value);
    	// alert(password);
 		var passwd = md5_new(document.frmindex.txtword.value);
 		passwd = passwd + saltValue;
 		var newpass=SHA256(password+saltValue);
     	var pass_md5=md5(passwd);
     	
 		var strID = document.frmindex.txtID.value+saltValue;
     	var key = CryptoJS.enc.Hex.parse('000102030405060708090a0b0c0d0e0f');
     	var iv = CryptoJS.enc.Hex.parse('000102030405060708090a0b0c0d0e0f');
        document.frmindex.txtword.value=newpass+'$'+pass_md5; 
     	strID=padString(strID);
        document.frmindex.txtID.value=CryptoJS.AES.encrypt(strID, key, { iv: iv, padding: CryptoJS.pad.NoPadding, mode: CryptoJS.mode.CBC});
     // alert(document.frmindex.txtID.value);
    //  alert(document.frmindex.txtword.value);
 		
 		// var ClientDate=new Date();
 		// document.getElementById("clientDay").value=ClientDate.getDate();
 		// document.getElementById("clientMonth").value=ClientDate.getMonth()+1;
 		// document.getElementById("clientYear").value=ClientDate.getFullYear();
 		
 		document.frmindex.action = "UserValidation.ser";
 		document.frmindex.method = "POST";
 		document.frmindex.submit();
	}
}

function Reload() {
	//    	alert("HAI");
	javascript: location.href = "index.jsp?message=";
}

function buttonsubmit(e) {
	var unicode = e.charCode ? e.charCode : e.keyCode
	if (unicode == 13) {
		notNull();
	}  
}

function stripQuotes(strWords) {

	strWords.value = strWords.value.replace("'", "''");

}

function killChars(strWord) {
	var strWords = strWord.value;
	
	var badChars = new Array("|", "()", ";", "/..", "../", "=", "\\",
			  "%1", "%2", "%3", ".htm", ".html", "xp_", "alert",
			".HTM", ".HTML", "--", "XP_", "ALERT","char(", "ascii(", "union",
			"having", "group by", "order by", "xp_", "0x", "cast(",	"insert into", 
			"delete from", "delete", "drop", "exec(", "declare",  "sp_", "insert", 
			"update", "select", "1=1", "(",	")", "+", "or", ",", ":", "|",  "case", 
			  "'", "\"", "<", ">", "script", "UNION", "HAVING", "GROUP BY",
			"ORDER BY", "INSERT INTO", "DELETE FROM", "DELETE", "DROP", "DECLARE", 
			"INSERT", "UPDATE", "SELECT", "OR", "CASE", "SCRIPT","alert");
	
	var tStrWord = strWord.value.toString();
	var spliting = [];
	var spliting = tStrWord.split("");
	
	var newChars = null;
	newChars = strWords;
	
	for(j = 0; j < spliting.length; j++){
	for (i = 0; i < badChars.length; i++) {
		newChars = newChars.replace(badChars[i], "");
	}
		strWord.value = newChars;
  }
}

/*   For New Menu -To logout */

function framesclear() {
	parent.menu.location.href = 'testmenufile.jsp';
}

function numbersonly1(e, t) {
	var unicode = e.charCode ? e.charCode : e.keyCode;
	if (unicode == 13) {
		try {
			t.blur();
		} catch (e) {
		}
		return true;

	}
	if (unicode != 8 && unicode != 9) {
		if (unicode < 48 || unicode > 57)
			return false;
	}
}

function padString(source) {
	var paddingChar = ' ';
	var size = 16;
	var x = source.length % size;
	var padLength = size - x;
	for (var i = 0; i < padLength; i++) {
		source += paddingChar;
	}
	return source;
}

function responce(val) {
	
	  if(val == 'yes') {
		  alert('Invalid User name or Password');  
	  } else if(val =='noprofile') {
		  alert('Your profile has to be updated. \n Please contact System Administrator.');
	  } else if(val == 'retired') {
		  alert('Login is disabled based on Employee Retirement data.');
	  } else if(val == 'dbnill') {
		  alert('Database Service is not available.\n Please Contact System Administrator.');
	  } else if(val == 'logindisabled') {
		  alert('Login Disabled.');
	  } else if(val == 'captcha') {
		  alert('Please Enter the displayed code Correctly.');
	  } else if(val == 'invalidDate') {
		  alert('Please check your local system date.');
	  }  
	  
}

