function scroll_status (sval)
{
    var msg = "TWAD Board Online Services / version 1 - Release 1";
    var out = " ";
    var c = 1;
    if (150 < sval) {
       sval--;
       var cmd="scroll_status(" + sval + ")";
       tmx2 = window.setTimeout(cmd,100);
    }
    else if (sval <= 150 && 0 < sval) {
            for (c=0 ; c < sval ; c++) {
                    out+=" ";
            }
            out+=msg;
            sval--;
            var cmd="scroll_status(" + sval + ")";
                window.status=out;
            tmx2=window.setTimeout(cmd,100);
    }
    else if (sval <= 0) {
         if (-sval < msg.length) {
                 out+=msg.substring(-sval,msg.length);
                 sval--;
         var cmd="scroll_status(" + sval + ")";
                 window.status=out;
                 tmx2=window.setTimeout(cmd,100);
            }
            else {
               window.status=" ";
               tmx2=window.setTimeout("scroll_status(150)",100);
            }
    }
}