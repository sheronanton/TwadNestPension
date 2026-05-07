/*
 * This servlet is used for displaying the sub system description and menu description according to the
 * role assigned for the logged-in user.
 * */


package Servlets.Security.servlets;

import java.util.Random;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.PrintWriter;
import java.io.IOException;

//import Servlets.HR.HR1.EmployeeMaster.Model.LoadDriver;
import Servlets.Security.classes.UserProfile;
import Servlets.Security.classes.MenusAssigned;
import Servlets.Security.classes.Menus;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuGenerator extends HttpServlet {
    private static final String CONTENT_TYPE =
        "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,
                                                             IOException {


        response.setContentType(CONTENT_TYPE);
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter pw = response.getWriter();
        System.out.println("querry string :::::::::::" +
                           request.getQueryString());
        // getting employee profile from session
        HttpSession session = request.getSession(false);
         System.out.println("++++++++++++ session object created in MENU GENERATOR. it ID is :"+session.getId());
        UserProfile empProfile =
            (UserProfile)session.getAttribute("UserProfile");
        // int hisRoleId=0;
        String hisRoleId = "";

        /*
       * Role id,major system id, minor system id parameter value is received from url from servletlogin servlet.
       * */

        try {
            //hisRoleId=Integer.parseInt(request.getParameter("Role"));
            hisRoleId = request.getParameter("Role");
           //System.out.println(ma.Sub_System_Id);
        } catch (NumberFormatException nfe) {
            System.out.println("error in convertion  " + nfe);
        }
        String MajorSystemID = request.getParameter("Main");
        String SubSystemID = request.getParameter("Sub");
        System.out.println("Role  :" + hisRoleId +" major system ID : " + MajorSystemID + " sub : " + SubSystemID);

        /*
       * The following code represent if no data is found at UserProfile file then it will show need to sign in to access
       * this page and it will directed to index page.
       *
       * If any other user copy the url from the page and try to access the page then it will show the details.
       * */


        if (empProfile == null) {
            String logmessage =
                "<br><br><br><br><b>You need to Sign in for accessing this page,<br>please follow this link to <a href=\"index.jsp\" target='_parent'>Sign In</a></b>";
            response.setContentType("text/html");
            response.getWriter().write(logmessage);
            //session.removeAttribute("UserProfile");
            //System.out.println("session removed as empprofile is null");
            return;
        } else {
        	System.out.println("else");
           
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet results = null;
            int intEmployeeId = empProfile.getEmployeeId();
            System.out.println("object : " + intEmployeeId);

            // opening connection
            try {
            	 LoadDriver driver=new LoadDriver();
             	connection=driver.getConnection();

            } catch (Exception e) {
                //System.out.println("Exception in openeing connection ");
                return;
            }

            try {

                /*
                  * The following code for getting sub system id and sub system description from the database with the
                  * role id, major system id, minor system id
                  * */

            	 System.out.println("inside try");
                //String AssignedSubSystems="select distinct(Sub_System_Id) from SEC_MST_ROLE_MENUS where Role_Id=? and Major_System_Id=? and Minor_System_Id=?";
                String AssignedSubSystems =
                    "select distinct(Sub_System_Id) from SEC_MST_ROLE_MENUS where Role_Id in (" +
                    hisRoleId +
                    ") and Major_System_Id=? and Minor_System_Id=? order by sub_system_id";
                System.out.println("query : " + AssignedSubSystems);
                ps = connection.prepareStatement(AssignedSubSystems);
                //ps.setInt(1,hisRoleId);
                // ps.setString(1,"28,29");
                //System.out.println("RoleId"+hisRoleId);

                //session.setAttribute("Admin","YES");
                ps.setString(1, MajorSystemID);
                 System.out.println("Major"+MajorSystemID);
                ps.setString(2, SubSystemID);
                 System.out.println("Sub"+SubSystemID);
                results = ps.executeQuery();
                ArrayList menus = new ArrayList();

                 System.out.println("Menus"+menus);
                while (results.next()) {
                    MenusAssigned ma = new MenusAssigned();
                    ma.Major_System_Id = MajorSystemID;
                    ma.Minor_System_Id = SubSystemID;
                    ma.Sub_System_Id = results.getString("Sub_System_Id");
                     System.out.println("success subsystem : " + ma.Sub_System_Id);
                    menus.add(ma);
                }


                /*
                     * If the menus are not in the database for the logged-in user then it will show the message as
                     * 'currently u have no privilages to access this subsystem'. It means that the system administrator is not assigned any
                     * roles to the logged-in user.
                     *
                     * */

                if (menus.isEmpty()) {
                    results.close();
                    ps.close();
                    //******************
                    // no menus assigned
                    //******************
                    System.out.println("no sub system for this role");
                    pw.print("<br><br><br><br><center><b>Sorry, Currently You do not have any privilages to Access this Subsystem.<br>Please Contact your Office Administrator for futher queries.</b></center>");
                } else {
                    results.close();
                    ps.close();
                    // get sub system description
                    for (int i = 0; i <= menus.size() - 1; i++) {
                        MenusAssigned ma = (MenusAssigned)menus.get(i);
                        System.out.println(ma.Sub_System_Id + "  ");
                        String getSubSystemDesc =
                            "select Sub_System_Short_Desc from SEC_MST_SUBSYSTEMS where Major_System_Id=? and Minor_System_Id=? and Sub_System_Id=? ";
                      //  System.out.println("query : " + getSubSystemDesc);
                      /*  ps = connection.prepareStatement(getSubSystemDesc);
                        ps.setString(1, ma.Major_System_Id);
                        ps.setString(2, ma.Minor_System_Id);
                        ps.setString(3, ma.Sub_System_Id);
                        results = ps.executeQuery();
                        //pw.println("before");
                        results.next();
                        //pw.println("after");
                        ma.Sub_System_Desc =
                                results.getString("Sub_System_Short_Desc");
                        //pw.println(ma.Sub_System_Desc + "<br>");
                           results.close();
                    ps.close();*/
                       
                       
                    }
                   
                    System.out.println("after Close");
                    // from the menu ids get the menus and built a page**table::SECURITY_MST_INTRANET_MENUS


                    // get Major system description from ****************table::SECURITY_MST_INTRANET_MAJOR_SYSTEMS
                    // get the subsystem description from ***************table::SECURITY_MST_INTRANET_SUBSYSTEMS


                    /*
                        * The following code shows that after getting sub system id to get the menu id,menu description,
                        * file path and menu category from the database according to the role id, major system id,
                        * minor system id and sub system id for the corresponding logged-in user.
                        * */
                    System.out.println("B4 for ");
                    for (int i = 0; i <= menus.size() - 1; i++) {
                    	MenusAssigned  ma = (MenusAssigned)menus.get(i);
                        //pw.println(ma.Sub_System_Id + "  ");
                        //String getMenuDesc="select Menu_Id,Menu_Desc,File_Path,MENU_CATEGORY from SEC_MST_INTRANET_MENUS where Major_System_Id=? and Minor_System_Id=? and Sub_System_Id=? and Menu_Id in (select Menu_Id from SEC_MST_ROLE_MENUS where Major_System_Id=? and Minor_System_Id=? AND Sub_System_Id=? AND  Role_Id=?) order by category_seq_no,category_seq_no,order_seq_no";
                        System.out.println("B4 Execution "+ ma.Major_System_Id +"minior"+ma.Minor_System_Id+"sub"+ma.Sub_System_Id );
                        String getMenuDesc =
                            "select Menu_Id,Menu_Desc,File_Path,MENU_CATEGORY from SEC_MST_INTRANET_MENUS where Major_System_Id=? and Minor_System_Id=? and Sub_System_Id=? and Menu_Id in (select Menu_Id from SEC_MST_ROLE_MENUS where Major_System_Id=? and Minor_System_Id=? AND Sub_System_Id=? AND  Role_Id in(" +
                            hisRoleId +
                            ")  ) order by category_seq_no,order_seq_no";
                        ps = connection.prepareStatement(getMenuDesc);
                        ps.setString(1, ma.Major_System_Id);
                        ps.setString(2, ma.Minor_System_Id);
                        ps.setString(3, ma.Sub_System_Id);
                        ps.setString(4, ma.Major_System_Id);
                        ps.setString(5, ma.Minor_System_Id);
                        ps.setString(6, ma.Sub_System_Id);
                        // ps.setInt(7,hisRoleId);
                        //pw.println("<br> ids : " + ma.Major_System_Id + " " + ma.Sub_System_Id + " " +ma.Menu_Id + "<br>");
                         System.out.println("B after Execution "+ ma.Major_System_Id +"minior"+ma.Minor_System_Id+"sub"+ma.Sub_System_Id );
                        results = ps.executeQuery();
                        //pw.println("before");
                        while (results.next()) {
                               System.out.println("aftr  Execution --------------------");
                            Menus mn = new Menus();
                            mn.Menu_Id = results.getString("Menu_Id");
                            mn.Menu_Description =
                                    results.getString("Menu_Desc");
                            mn.File_Path = results.getString("File_Path");
                            //LINE TO INCLUDE MENU CATEGORY
                            mn.Menu_Category =
                                    results.getString("MENU_CATEGORY");
                            //System.out.println("getting values : " + ma.Sub_System_Desc + " menu : " + mn.Menu_Description );
                            ma.menus.add(mn);
                        }
                        results.close();
                        ps.close();
                    }
                    ArrayList AccessList = new ArrayList();
                    for (int i = 0; i <= menus.size() - 1; i++) {
                        MenusAssigned md = (MenusAssigned)menus.get(i);
                        for (int j = 0; j <= md.menus.size() - 1; j++) {
                            Menus mn = (Menus)md.menus.get(j);
                            AccessList.add(mn.File_Path);
                        }
                    }


                    /*
                      * Adding the file path of corresponding menu to the seesion attribute.
                      * */
                    // adding this to  the session
                    session.setAttribute("AccessList", AccessList);

                    // build a page on this
                    pw.print("<html><head><meta http-equiv='Content-Type' content='text/html; charset=windows-1252'>");
                    pw.print("<meta http-equiv='cache-control' content='no-cache'>");
                    pw.print("<script type='text/javascript' src='org/Security/scripts/twad.js'></script>");


                    // coding for drop down menu (including the js file)
                    //--------------------
                    pw.print("<script type='text/javascript' src='org/Security/scripts/chrome.js'></script>");
                    //--------------------

                    pw.print("<link href='css/index.css' rel='stylesheet' media='screen'/>");

                    // coding for drop down menu (including the css file)
                    //--------------------
                    pw.print("<link href='css/chromestyle.css' rel='stylesheet' media='screen'/>");
                    //--------------------

                    // pw.print("</head><body onunload=\"javascript:history.go(1)\" >");
                      
                    String menuPage = createMenu(menus);
                    pw.print(menuPage);
                    pw.print("</body></html>");
                    // return page
                }
            } catch (Exception e) {
                //System.out.println("error getting assigned menu options :" + e);
            }

        }
    }

    // function to create menu

    private String createMenu(ArrayList menus) {

        /*
     * This method is for displaying the menus assigned to the logged-in user.
     * */

        StringBuffer sb = new StringBuffer();
        int NoOfPertletsInARow = 3;

        try {
        	System.out.println("inside try");
            sb.append("<table cellspacing='0' border='0' width='100%'> ");
            int i;
            for (i = 0; i <= menus.size() - 1; i++) {
                MenusAssigned md = (MenusAssigned)menus.get(i);
                //System.out.println("sub system : " + md.Sub_System_Desc);
                if (i % NoOfPertletsInARow == 0)
                    sb.append("<tr>");

                sb.append("<td>&nbsp;</td>");
                sb.append("<td>");
                sb.append("<div id=login class='MenuWnd'>");
                sb.append("<table cellspacing='0' border='0' width='100%'>");
                sb.append("<tr><td>");

                sb.append("<div class='MenuHead'><table border='0'><tr><td>" +
                          md.Sub_System_Desc +
                          "</td><td align='right'><img src='images/help.png'></td></tr></table></div>");
                sb.append("</td></tr><tr><td>");
                sb.append("<div onmouseover=\"this.style.cursor='hand';status=' ';return true;\" onclick=\"status=' ';return true;\">");
                sb.append("<table cellspacing='0' border='0' width='100%'>");
                System.out.println("Menu Category :"+md.menus);
                String str = "";
                for (int k = 0; k <= md.menus.size() - 1; k++) {
                    int cnt = 0;
                    Menus mn = (Menus)md.menus.get(k);
                    System.out.println("Menu Category :"+mn.Menu_Category);
                    if (mn.Menu_Category != null) {
                        if ((str.equals("")) ||
                            (!str.equals(mn.Menu_Category))) {
                            sb.append("<tr><td>");
                            sb.append("<div align=\"left\" id=\"chromemenu" +
                                      mn.Menu_Category +
                                      "\" style=\"background: rgb(233,249,235);\" >");
                            //sb.append("<div id=\"fader"+k+"\"onmouseover=\"fadeIn(this);status='';return true;\" onmouseout=\"fadeOut(this)\" style=\" border-bottom: 1px solid rgb(51,102,102);\" > <a class='anchorcategory' href=\"#\" rel=\"dropmenu"+mn.Menu_Category+"\" style=\"text-decoration:none\" >"+mn.Menu_Category+"</a></div><br>");
                            sb.append("<div style=\" border-bottom: 1px solid rgb(51,102,102);\" onmouseout=\"this.style.background='rgb(233,249,235)';\" onmouseover=\"this.style.background='#cfdee1';\"><a rel=\"dropmenu" +
                                      mn.Menu_Category +
                                      "\" style=\"text-decoration:none;width=100%\" >" +
                                      mn.Menu_Category + "</a></div><br>");
                            sb.append("</div>");
                            sb.append("<script type=\"text/javascript\">cssdropdown.startchrome(\"chromemenu" +
                                      mn.Menu_Category + "\")</script>");
                            sb.append("<div id=\"dropmenu" + mn.Menu_Category +
                                      "\" class=\"dropmenudiv\" style=\"width: 160px;\" align=\"left\">");
                            str = mn.Menu_Category;
                            //  System.out.println("IN IF    ----Menu Category :"+mn.Menu_Description);

                            //Old code for file path
                            /*---------------------
                           if(mn.File_Path.equals("test.html"))
                                sb.append("<div class='ddisabled' onclick=\"loadPageInNewWindow('" + mn.File_Path + "')\" >");// onmouseover=\"highlite(this,'" + mn.File_Path + "')\" onmouseout=\"dontHighlite(this)\" >");
                           else
                                sb.append("<div class='eenabled' onclick=\"loadPageInNewWindow('" + mn.File_Path + "')\"  >");// onmouseover=\"highlite(this,'" + mn.File_Path + "')\" onmouseout=\"dontHighlite(this)\" >");
                           sb.append(mn.Menu_Description);
                       ------------------------
                       */

                            if (mn.File_Path.equals("test.html"))
                                sb.append("<a href=#  onclick=\"loadPageInNewWindow('" +
                                          mn.File_Path +
                                          "');status=' ';return true;\">" +
                                          "  " + mn.Menu_Description + "</a>");
                            else
                                sb.append("<a href=#  onclick=\"loadPageInNewWindow('" +
                                          mn.File_Path +
                                          "');status=' ';return true;\">" +
                                          mn.Menu_Description + "</a>");


                        } else {
                            //  System.out.println("IN ELSE    -----Menu Category :"+mn.Menu_Description);
                            if (mn.File_Path.equals("test.html"))
                                sb.append("<a href=# onclick=\"loadPageInNewWindow('" +
                                          mn.File_Path +
                                          "');status=' ';return true;\">" +
                                          mn.Menu_Description + "</a>");
                            else
                                sb.append("<a href=# onclick=\"loadPageInNewWindow('" +
                                          mn.File_Path +
                                          "');status=' ';return true;\">" +
                                          mn.Menu_Description + "</a>");
                        }
                        //System.out.println("IN OUTER   -----Menu Category :"+mn.Menu_Description);

                    } else {
                        sb.append("<tr><td>");

                        /* if(j%2==0)
                    sb.append("<div class='oddRow' onclick=\"loadPageInNewWindow('" + mn.File_Path + "')\" >");// onmouseover=\"highlite(this,'" + mn.File_Path + "')\" onmouseout=\"dontHighlite(this)\" >");
                  else
                    sb.append("<div class='evenRow' onclick=\"loadPageInNewWindow('" + mn.File_Path + "')\"  >");// onmouseover=\"highlite(this,'" + mn.File_Path + "')\" onmouseout=\"dontHighlite(this)\" >");*/

                        if (mn.File_Path.equals("test.html"))
                            sb.append("<div class='ddisabled' onclick=\"loadPageInNewWindow('" +
                                      mn.File_Path +
                                      "')\" >"); // onmouseover=\"highlite(this,'" + mn.File_Path + "')\" onmouseout=\"dontHighlite(this)\" >");
                        else
                            sb.append("<div class='eenabled' onclick=\"loadPageInNewWindow('" +
                                      mn.File_Path +
                                      "')\" onmouseout=\"this.style.background='rgb(233,249,235)';\" onmouseover=\"this.style.background='#cfdee1';\">"); // onmouseover=\"highlite(this,'" + mn.File_Path + "')\" onmouseout=\"dontHighlite(this)\" >");
                        sb.append(mn.Menu_Description);

                    }

                }
                sb.append("</div></td></tr>");
                sb.append("</table></div><tr><td>");
                sb.append("<div class='menuBottom' align='center'>");
                //sb.append("<img src='images/help.png'> &nbsp; Need Help ?</div></td></tr>");
                sb.append("</div></td></tr>");
                sb.append("</table></div></td>");
                sb.append("<td>&nbsp;</td>");


                if (i % NoOfPertletsInARow == NoOfPertletsInARow - 1) {
                    sb.append("</tr>");
                    sb.append("<tr><td colspan=3><div class='BodySpace'></div></td></tr>");
                }
            }

            sb.append("</tr></table>");
        } catch (Exception e) {
            //System.out.println("error in menu creation(createMenu)");
            sb.append("Error in menu creation : " + e.getMessage());
        }
        return sb.toString();

    }

}
