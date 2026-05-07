package com.nic.common.baseaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import com.nic.common.baseaction.BaseAction;
//import Servlets.Security.servlets.UserValidation;

public class Constants {
	
	public static final String[] sqlInjection={"char(", "ascii(", " union ", "having ", 
    	" group by", " order by", "xp_", "0x", "cast(", "insert into", 
    	"delete from", "delete ", "drop ", "exec(", "declare", "@@", "sp_", 
    	"update ", "select ", "--", "#", "1=1", " or ", "(", ")", "+",
    	"/*" , "*/" ,"*/*", ";" , ":" , "|", "&", "case ", "%", "$", "'", "\"", "<", ">","!","script"};
	
	 public static final String TOKEN="[a-z0-9]{1,40}";
	 public static boolean test_flag=false;
	 public static final String login_Id="[A-Z0-9]*";
	 public static final String password="[a-z0-9]*";
	 HttpSession session=null;
	//=====================================================detailsValidation==================================
	 public static boolean detailsValidation(String details)      
	  {
	  test_flag=false;
	   try
	   {
	       if(details!=null && details.trim().length()>0)
	        {
	          for(int i=0;i<Constants.sqlInjection.length;i++)
	          {
	                     if(details.toLowerCase().indexOf(Constants.sqlInjection[i]) != -1)
	                     {
	                       test_flag=false;
	                     }
	                     else
	                        test_flag=true;
	           }
//	          if(test_flag)
//	          {
//	              if(details.matches(Constants.details))
//	              {
//	                 System.out.println("================"+details);
//	               }
//	              else
//	              {
//	                 test_flag=false;
//	               }
//	           }
	        }
	        else
	        {
	           test_flag=false;
	         }
	    }
	    catch(Exception e)
	    {
	    System.out.println(e.getMessage());
	    }
	  System.out.println("details---> test_flag"+test_flag); 
	   return test_flag;
	  }
	 
	/* public boolean csrfCheck(HttpSession session,HttpServletRequest request)
	 {
	 	
	 	return false;
	 }*/

	public boolean csrfCheck(HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub
		session = request.getSession();
		String token = request.getParameter("token");
		System.out.println("token check----"+token);
		System.out.println("token check session----"+session.getAttribute("token"));
	 	if(token == null || token.trim().length() == 0 || session==null || session.getAttribute("token")==null || !session.getAttribute("token").toString().equals(token))
	 	{
	 		token = ""; 
	 		return true;
	 	} 
		return false;
	}

	//-------------------------------------------loginvalidation---------------------------------------
	
	public static boolean loginidValidation(String loginid)      
	  {
	  test_flag=false;
	   try
	   {
	     if(loginid!=null && loginid.trim().length()>0)
	        {
	          for(int i=0;i<Constants.sqlInjection.length;i++)
	                 {
	                     if(loginid.toLowerCase().indexOf(Constants.sqlInjection[i]) != -1)
	                     {
	                          test_flag=false;
	                          
	                     }
	                     else
	                     {
	                        test_flag=true;
	                     }
	                 }
	                 if(test_flag)
	                 {
	                      if(loginid.matches(Constants.login_Id))
	                      {
//	                          System.out.println("================"+loginid);
	                      }
	                      else
	                      {
	                          test_flag=false;
	                          
	                      }
	                   }
	        }
	        else
	        {
	              test_flag=false;
	           
	        }
	    }
	    catch(Exception e) {
	    System.out.println(e.getMessage());
	    }
	  System.out.println("login.java: loginid---> test_flag"+test_flag); 
	  
	  return test_flag;
	  }
	  
	//---------------------------------------------password validation---------------------------
	
	public static boolean passwordValidation(String p_code)      
	  {
	  test_flag=false;
	   try
	   {
//	      System.out.println("================"+p_code);
	     if(p_code!=null && p_code.trim().length()>0)
	        {
	          for(int i=0;i<Constants.sqlInjection.length;i++)
	                 {
	                     if(p_code.toLowerCase().indexOf(Constants.sqlInjection[i]) != -1)
	                     {
	                         
	                          test_flag=false;
	                        }
	                     else
	                     {
	                        test_flag=true;
	                      }
	                 }
	                 if(test_flag)
	                 {
	                    
	                      if(p_code.matches(Constants.password))
	                      {
//	                          System.out.println("================"+p_code);
	                      }
	                      else
	                      {
	                          test_flag=false;
	                        
	                      }
	                   }
	        }
	        else
	        {
	              test_flag=false;
	              
	        }
	    }
	    catch(Exception e) 
	    {
	    System.out.println(e.getMessage());
	    }
	  System.out.println("login.java: p_code---> test_flag"+test_flag); 
	  
	  return test_flag;
	  }
	
}

