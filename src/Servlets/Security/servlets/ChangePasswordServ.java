package Servlets.Security.servlets;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Servlets.HR.HR1.EmployeeMaster.Model.LoadDriver;
import Servlets.Security.servlets.sha256_injava;
import Servlets.Security.servlets.TwadUtil;
import java.util.regex.*;  

public class ChangePasswordServ extends HttpServlet {


    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }
  /*  public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }*/

   /* public static void infoBox(String infoMessage, String titleBar)
    {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
      //  infoBox(infoMessage, titleBar, null);
//    }*/

    /*public static void infoBox(String infoMessage, String titleBar)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
       // alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }*/
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        Connection con = null;
        try {

            File f = new File("");
            f.deleteOnExit();


            LoadDriver driver=new LoadDriver();
            con=driver.getConnection();

        } catch (Exception e) {
            System.out.println("Exception in connection..." + e);
        }
        ResultSet rs = null;
        PreparedStatement ps = null;
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        String oldpass = null, newpass = "", strCommand = null,confirmPassword=null;
        String strPassword = null;
        int empid = 0,result=0,result1=1;
        sha256_injava sha256;
        HttpSession session = request.getSession(false);
        try {
            strCommand = request.getParameter("Command");
            System.out.println("assign....." + strCommand);
            oldpass = request.getParameter("txtoldPassword");
            System.out.println("assign..... old pass::" + oldpass);
            newpass = request.getParameter("txtnewPassword");
            System.out.println("assign..... new pass::" + newpass);
            confirmPassword = request.getParameter("txtconfirmPassword");
        /*  if(oldpass.length()<1)
           {
        	   infoBox("Enter old Password","Ok");
        	   result=0;
           }
           if(newpass.length()<1)
           {
        	   infoBox("Enter New Password","Ok");
        	   result=0;
           }
           if(confirmPassword.length()<1)
           {
        	   infoBox("Enter confirm Password","Ok");
        	   result=0;
           }*/
            
           if(confirmPassword.equals(newpass))
           {
               System.out.println("confirmPassword!.......>"+confirmPassword);    
               System.out.println("newpass!.......>"+newpass);    
               
              
               
//        	   if(confirmPassword.matches("/^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?/!@$%^&*-]).{8,}$/"))
               
               if(confirmPassword.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[#?/!@$%^&*-]).{8,}$"))
        	   {
                   System.out.println("inside=====>"); 	
        		   
        		   result=1;
        	   }
                     else 
                     {
                    	 System.out.println("result!....else...>");  
                    	
                     	result=0;
                     	
                     }
        	   
        	   
        	   System.out.println("result!....inside...>"+result);     
           }
//           else
//           {
//        	  // infoBox("new password and confirm Password should be same","Ok");
//        	   out.println("<HTML>");
//            	out.println("<head>");
//            	
//            	response.setContentType("text/html");  
//            	out.println("<script type=\"text/javascript\">");  
//            	out.println("alert('new password and confirm Password should be same!!------>');");  
//            	out.println("document.location='ChangePasswordJSP.jsp'");  
//            	out.println("</script>");
//            	out.println("</head>");
//            	out.println("</HTML>");
//            	 result=0;
//           }
          //  UserProfile empProfile =       (UserProfile)session.getAttribute("UserProfile");

            System.out.println("result" + result);
            System.out.println("result1 is" + result1);
            
            //empid = empProfile.getEmployeeId();


        } catch (Exception e) {
            System.out.println("Exception in assigning..." + e);
        }
        String xml = null;
     //  if (strCommand.equalsIgnoreCase("test")) {
        
        System.out.println("result------------->" + result);
        System.out.println("result1 is------------------>" + result1);
        
        
        
        if(result>0)
        {
            xml = "<response><command>test</command>";
            try {
                sha256=new sha256_injava();
               
                try {
                	 byte []b=oldpass.getBytes();
                     try{
                         MessageDigest algorithm = MessageDigest.getInstance("MD5");
                         algorithm.reset();
                         algorithm.update(b);
                         byte messageDigest[] = algorithm.digest();
//                         System.out.println("actual encrypt::"+messageDigest);                            
                         StringBuffer hexString = new StringBuffer();
                         for (int i=0;i<messageDigest.length;i++) {
                              hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
                             
                         }
//                             System.out.println("After appending :"+hexString);
                         strPassword=new String(hexString);
//                         System.out.println(strPassword);
                         }catch(NoSuchAlgorithmException nsae){
                          //    System.out.println(nsae); 
                     }
                	
                } catch (Exception nsae) {
                    System.out.println("first MD5::" + nsae);
                }
               // HttpSession session = request.getSession(false);
                String userid = (String)session.getAttribute("UserId");
                System.out.println("userid---------->----"+userid);
                System.out.println("strPassword---------->----"+strPassword);
                ps = con.prepareStatement("select USER_ID from SEC_MST_USERS  where USER_PASSWORD=? and USER_ID=? ");
                ps.setString(1, strPassword);
                ps.setString(2, userid);
                rs = ps.executeQuery();
                System.out.println("first check is ok");
                if (rs.next()) {
                    String username = rs.getString("USER_ID");
                   
                   System.out.println("nside----------->"+username);
                 //   b = newpass.getBytes();
                    try {
                      

                        strPassword =sha256.getSHA256Hash(newpass);
                        System.out.println("strPassword-------------->"+strPassword);
                    } catch (Exception nsae) {
                        System.out.println("Second MD5::" + nsae);
                    }

                    ps =
  con.prepareStatement("update  SEC_MST_USERS set new_password=?,CHANGE_PASSWORD='0'  where USER_ID=?");
                    System.out.println("sec_mst_users");
                    ps.setString(1, strPassword);
                    ps.setString(2, username);
                    System.out.println("sec_mst_userssssssssssssd------------->"+username);
                    int i=ps.executeUpdate();
                    System.out.println("i-------------->"+i);
                    if(i>0)
                    {
                    	//infoBox("Password changed","ok");
                    	//String pwd ="Password changed ";
                    	                    	
                    	
                    	
                    	out.println("<HTML>");
                    	out.println("<head>");
                    	
                    	response.setContentType("text/html");  
                    	out.println("<script type=\"text/javascript\">");  
                    	out.println("alert('Password changed!!')");  
                    	out.println("document.location='index.jsp'");  
                    	out.println("</script>");
                    	out.println("</head>");
                    	out.println("</HTML>");
                    	
                    	// System.out.println("second check ok");
                   // xml = xml + "<flag>success</flag>";
                    	//response.sendRedirect("index.jsp");	
                   
                    	
                    }

                } else {
                   // xml = xml + "<flag>failure</flag>";
                	 out.println("<HTML>");
                 	out.println("<head>");
                 	
                 	response.setContentType("text/html");  
                 	out.println("<script type=\"text/javascript\">");  
                 	out.println("alert('Old password is wrong,unable to change password!!')");  
                 	out.println("document.location='ChangePasswordJSP.jsp'");  
                 	out.println("</script>");
                 	out.println("</head>");
                 	out.println("</HTML>");
                }
                rs.close();
                ps.close();  
            }

            catch (Exception e) {

                System.out.println("catch........" + e);
              //  xml = xml + "<flag>failure</flag>";
              //  infoBox("Password not changed","ok");
                
                out.println("<HTML>");
            	out.println("<head>");
            	
            	response.setContentType("text/html");  
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Password not changed!!');");  
            	out.println("document.location='ChangePasswordJSP.jsp'");  
            	out.println("</script>");
            	out.println("</head>");
            	out.println("</HTML>");
               String path = "ChangePasswordJSP.jsp?" + TwadUtil.getPath(session.getId().toString());
				path = response.encodeRedirectURL(path);

				
					request.getRequestDispatcher(path).forward(request, response);
															return;
				
            }
            finally
            {
            	
            }

            xml = xml + "</response>";
          //  out.println(xml);
            System.out.println(xml);

        }
        else
        {
        	
         	
        	out.println("<HTML>");
         	out.println("<head>");
         	
         	response.setContentType("text/html");  
         	out.println("<script type=\"text/javascript\">");  
         	out.println("alert('your password does not match with the password policy!!')");  
         	out.println("document.location='ChangePasswordJSP.jsp'");  
         	out.println("</script>");
         	out.println("</head>");
         	out.println("</HTML>");
         	
        }
        


    }
    private void sendMessage(HttpServletResponse response, String msg,
            String bType) {
try {
		String url =
		"org/Library/jsps/Messenger_chgpwd.jsp?message=" + msg + "&button=" +
		bType;
		response.sendRedirect(url);
} catch (IOException e) {
System.out.println(e);
}
}
}
