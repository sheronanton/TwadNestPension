/*
 * The following code is for mainly used for validating the user using filter and authenticating the user.
 * 
 * This servlet name is used in Filter tag in web.xml file and the filter is applied to all jsp page
 * which is requested by user.
 * 
 * Using the requested menu file path, retrieving the major,minor,sub system and role id is
 * available to the particular user and for other users also.
 * 
 * If not the page is redirected to index.page.
 * */


package Servlets.Security.servlets;

import java.util.ArrayList;
import javax.servlet.ServletResponse;
import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Servlets.Security.servlets.LoadDriver;
import Servlets.Security.classes.*;
import java.sql.*;

import java.util.ResourceBundle;

public class AccessController implements Filter
{
  private FilterConfig _filterConfig = null;

  public void init(FilterConfig filterConfig) throws ServletException
  {
    _filterConfig = filterConfig;
  }

  public void destroy()
  {
    _filterConfig = null;
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
  {
    //  System.out.println("inside filter called");
      
       HttpServletRequest req = (HttpServletRequest)request;
      HttpServletResponse res = (HttpServletResponse)response;
      String url=new String(req.getRequestURL());
     // System.out.println("requested URL:"+url);
      String contextpath =req.getContextPath();
     // System.out.println("ContextPath of url:"+contextpath);
      int contextlength=contextpath.length();
    //  System.out.println("length of context length..."+contextlength);
      int indexOfSlash=url.indexOf(contextpath);
     // System.out.println("index of slash..."+indexOfSlash);
      String filepath=url.substring(contextlength+indexOfSlash);
    //  System.out.println("FilePath1:"+filepath);
      filepath=filepath.substring(1);
   //   System.out.println("FilePath2:"+filepath);
     
     
     
      Connection connection=null;
      PreparedStatement ps=null;
      ResultSet results=null;
        
        try{     
                      

		 if((filepath.equalsIgnoreCase("index.jsp")) || (filepath.equalsIgnoreCase("viewbirthday.jsp"))) {
                 chain.doFilter(req, res);
                 return;
              }

		 LoadDriver driver=new LoadDriver();
	    	connection=driver.getConnection();

        }
        catch(Exception e) {
           // System.out.println("Connection Error:"+e);
        }
        
        
        try{
            System.out.println("here is ok in filter");
            System.out.println("file path..."+filepath);
            ps=connection.prepareStatement("select MAJOR_SYSTEM_ID,MINOR_SYSTEM_ID,SUB_SYSTEM_ID,MENU_ID from SEC_MST_INTRANET_MENUS where FILE_PATH=?");
            ps.setString(1,filepath);
            results=ps.executeQuery();
            int flag=0;
            if(results.next()) {
            	flag=1;
              //  System.out.println("File found in intranet menus in filter");
                String MAJOR_SYSTEM_ID="",MINOR_SYSTEM_ID="",SUB_SYSTEM_ID="",MENU_ID="";
                MAJOR_SYSTEM_ID=results.getString("MAJOR_SYSTEM_ID");
                MINOR_SYSTEM_ID=results.getString("MINOR_SYSTEM_ID");
                SUB_SYSTEM_ID=results.getString("SUB_SYSTEM_ID");
                MENU_ID=results.getString("MENU_ID");
                
                HttpSession session=req.getSession(false);
                UserProfile empProfile=(UserProfile)session.getAttribute("UserProfile");
              //  System.out.println("user id::"+empProfile.getEmployeeId());
                int empid=empProfile.getEmployeeId();
                              
                //System.out.println(MAJOR_SYSTEM_ID);
                //System.out.println(MINOR_SYSTEM_ID);
                //System.out.println(SUB_SYSTEM_ID);
                //System.out.println(MENU_ID);
                
                 String profile="";
                String LoginId=(String)session.getAttribute("UserId");
                profile=(String)session.getAttribute("profile");
                 if(profile==null){
                    res.sendRedirect(req.getContextPath()+"/index.jsp");
                    return;
                }
                   
                 
               //  System.out.println("Profile::::::::::::::"+profile);
                 if(profile.equalsIgnoreCase("twad"))
                 {
                                ps=connection.prepareStatement("select a.EMPLOYEE_ID from SEC_MST_USER_ROLES a where a.EMPLOYEE_ID=? and a.ROLE_ID in (select b.ROLE_ID from SEC_MST_ROLE_MENUS b where b.MAJOR_SYSTEM_ID=? and b.MINOR_SYSTEM_ID=? and b.SUB_SYSTEM_ID=? and b.MENU_ID=?)");
                                ps.setInt(1,empid);               
                                ps.setString(2,MAJOR_SYSTEM_ID);
                                ps.setString(3,MINOR_SYSTEM_ID);
                                ps.setString(4,SUB_SYSTEM_ID);
                                ps.setString(5,MENU_ID);
                                results=ps.executeQuery();
                          //      System.out.println("select a.EMPLOYEE_ID from SEC_MST_USER_ROLES a where a.EMPLOYEE_ID="+empid+" and a.ROLE_ID in (select b.ROLE_ID from SEC_MST_ROLE_MENUS b where b.MAJOR_SYSTEM_ID="+MAJOR_SYSTEM_ID+" and b.MINOR_SYSTEM_ID="+MINOR_SYSTEM_ID+" and b.SUB_SYSTEM_ID="+SUB_SYSTEM_ID+" and b.MENU_ID="+MENU_ID);
                                if(results.next()) {
                                
                                       // System.out.println("Role id is found and Autherization is over in filter");
                                            chain.doFilter(request, response);
                                        
                                        }
                                       
                                else{
                                  //  System.out.println("Role id is  not found or Autherization is failure");
                                    res.sendRedirect(req.getContextPath()+"/index.jsp");
                                    return;
                                }
               
                 }
                else
                {
                               ps=connection.prepareStatement("select a.USER_ID	 from SEC_MST_OTHER_USER_ROLES a where a.USER_ID=? and a.ROLE_ID in (select b.ROLE_ID from SEC_MST_ROLE_MENUS b where b.MAJOR_SYSTEM_ID=? and b.MINOR_SYSTEM_ID=? and b.SUB_SYSTEM_ID=? and b.MENU_ID=?) ");
                               ps.setString(1,LoginId);               
                               ps.setString(2,MAJOR_SYSTEM_ID);
                               ps.setString(3,MINOR_SYSTEM_ID);
                               ps.setString(4,SUB_SYSTEM_ID);
                               ps.setString(5,MENU_ID);
                               results=ps.executeQuery();
                               if(results.next()) {
                               
                                  ///     System.out.println("Role id is found and Autherization is over in filter");
                                           chain.doFilter(request, response);
                                       
                                       }
                                      
                               else{
                                //   System.out.println("Role id is  not found or Autherization is failure");
                                   res.sendRedirect(req.getContextPath()+"/index.jsp");
                                   return;
                               }
                
                }
                
                
                //chain.doFilter(request, response);
            }
            if(flag==0)
             {
              //  System.out.println("File not found in intranet menus");
               // res.sendRedirect(req.getContextPath()+"/index.jsp");
                chain.doFilter(request, response);
            }
        }
        catch(Exception e){
          //  System.out.println("Error in autherization :"+e);
           // System.out.println("error should be redirected");
            res.sendRedirect(req.getContextPath()+"/index.jsp");
            return;
            //chain.doFilter(request, response);
        }
     
     
      
      
     
  }

  

}