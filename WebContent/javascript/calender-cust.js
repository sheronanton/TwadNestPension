var oldLink = null;
function setActiveStyleSheet(link, title) { var i, a, main;
  for(i=0; (a = document.getElementsByTagName("link")[i]); i++) {
    if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title")) {a.disabled = true;
      if(a.getAttribute("title") == title) a.disabled = false;}}
    if (oldLink) oldLink.style.fontWeight = 'normal'; oldLink = link; link.style.fontWeight = 'bold'; return false;
}
function selected(cal, date) {cal.sel.value = date; afterDateChange(cal.sel); if (cal.dateClicked) //&& (cal.sel.id == "sel1" || cal.sel.id == "sel3"))
    cal.callCloseHandler(); }
function closeHandler(cal) {cal.hide(); /*cal.destroy();*/_dynarch_popupCalendar = null;}
function showCalendar(id, format, hideWeekday, hideFutureDays, hidePastDays, showsTime, showsOtherMonths) {

if(format=='date'){ format="%m/%d/%Y";} else if (format=='monthyear'){format="%m/%Y"; }
  var el = document.getElementById(id);
  if (_dynarch_popupCalendar != null) {_dynarch_popupCalendar.hide();} else {
    var cal = new Calendar(1, null, selected, closeHandler);
    if (typeof showsTime == "string") {cal.showsTime = true;cal.time24 = (showsTime == "24");}
	if (showsOtherMonths) {cal.showsOtherMonths = true;}
    _dynarch_popupCalendar = cal; cal.setRange(1900, 2070); 
	cal.setDateStatusHandler(function (date) { // disable weekend days (Saturdays == 6 and Subdays == 0)
						  	if(hideWeekday && (date.getDay() == 6 || date.getDay() == 0))  return true;
							if(hideFutureDays && date > new Date()) return true;
							//if(hidePastDays && date < new Date()) return true;
							return false;});
	cal.create();
  }
  _dynarch_popupCalendar.setDateFormat(format); _dynarch_popupCalendar.parseDate(el.value);
  _dynarch_popupCalendar.sel = el;  _dynarch_popupCalendar.showAtElement(el.nextSibling, "Br");
  return false;}
var MINUTE = 60 * 1000; var HOUR = 60 * MINUTE; var DAY = 24 * HOUR; var WEEK = 7 * DAY;
function isDisabled(date) { var today = new Date(); return (Math.abs(date.getTime() - today.getTime()) / DAY) > 10;}
function flatSelected(cal, date) { var el = document.getElementById("preview"); el.innerHTML = date;}
function showFlatCalendar() {var parent = document.getElementById("display"); var cal = new Calendar(0, null, flatSelected);
  cal.weekNumbers = false; cal.setDisabledHandler(isDisabled); cal.setDateFormat("%A, %B %e"); cal.create(parent); cal.show();}
function afterDateChange(calObj){
	if(calObj.onchange)
		calObj.onchange();
	return;
}

