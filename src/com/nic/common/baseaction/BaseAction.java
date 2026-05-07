package com.nic.common.baseaction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements
ServletRequestAware,ServletResponseAware{


    public static String[] sqlInjection={"char(", "ascii(", " union", "having",
        "group by", "order by" , "xp_", "0x", "cast(", "insert into",
        "delete from", "delete ", "drop " , "exec(", "declare", "@@", "sp_","insert ",
        "update ", "select", "--" , "#" , "1=1" , "(", ")", "+", ",",
        "/*" , "*/" ,";" , ":" , "|", "&", "case", "%", "$", "'", "\"", "<", ">","!","script"};
   
    /*public static String[] address={"char(", "ascii(", " union", "having",
        "group by", "order by" , "xp_", "0x", "cast(", "insert into",
        "delete from", "delete", "drop" , "exec(", "declare", "@@", "sp_","insert",
        "update", "select","\"", "<", ">","!","script"};*/
   
    public static String[] address={"char", "ascii","union","having", 
		"insert","delete","update","select","script"};


    public static String patppono="[A-Z0-9a-z]*";
    public static boolean test_flag=false;
    public static String error1=null;
    public static String message="";
    public static boolean loopflag=false;
    public static final String letterno="[a-zA-Z0-9.,-/& ]*";
    public static String valid_Date1="\\d{1,2}[-/.]\\d{1,2}[-/.]\\d{4}";

    public static boolean ppo_check(String ppono)
    {
        String patppono_1="[0-9]*";
        if(!ppono.matches(patppono_1))
        {
            message="Invalid Pattern For PPO_NO";
            test_flag=false;
            System.out.println("Pattern:"+message);
        }
        else
        {
            test_flag=true;
        }
        return test_flag;
    }
    
    public static boolean ppono_validate(String ppo_no)     
    {
        System.out.println("Inside the SQL Injuction File"+ppo_no+"PPO_NO");
        test_flag=true;
        try
        {
            if(ppo_no!=null && ppo_no.trim().length()>0)
            {
                for(int i=0;i<sqlInjection.length;i++)
                {
                    if(ppo_no.toLowerCase().indexOf(sqlInjection[i]) != -1)
                    {
                        message="Invalid PPO No";
                        loopflag=true;
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
        System.out.println("login.java: The Value of the String---> test_flag is "+test_flag);
        return test_flag;
    }

    public static boolean numbersOnly(String des)
    {
        test_flag=true;
        try
        {
            int des1=Integer.parseInt(des);
            if(des1!=Double.NaN)
            {}
        }
        catch(Exception e){               
            message="Enter Numbers Only";
            test_flag=false;
        }
        return true;
    }

    public static boolean pdate_validate(String p_date)     
    {
        test_flag=false;

        if(p_date.matches(valid_Date1))
        {
            System.out.println("================"+p_date);
            test_flag=true;
        }
        else
        {
            test_flag=false;
            message="The Application Date pattern mismatch";
        }       
        System.out.println("login.java: p_date---> test_flag is "+test_flag);
        return test_flag;
    }
    public static boolean Description_address(String des)     
    {
        System.out.println("Inside the SQL Injuction File "+des+" PPO_NO");
        test_flag=true;
        try
        {
            if(des!=null && des.trim().length()>0)
            {
                for(int i=0;i<address.length;i++)
                {
                    if(des.toLowerCase().indexOf(address[i]) != -1)
                    {
                        message="Invalid Description";
                        test_flag=false;
                    }
                }
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("login.java: The Value of the String---> test_flag is "+test_flag);
        return test_flag;
    }
    public static boolean Description(String des)     
    {
        System.out.println("Inside the SQL Injuction File "+ des +" PPO_NO");
        test_flag=true;
        try
        {
            if(des!=null && des.trim().length()>0)
            {
                for(int i=0;i<sqlInjection.length;i++)
                {
                    if(des.toLowerCase().indexOf(sqlInjection[i]) != -1)
                    {
                        message="Invalid Description";
                        test_flag=false;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("login.java: The Value of the String---> test_flag is " + test_flag);
        return test_flag;
    }
    public  static boolean davalidate(String des)
    {
        boolean test_flag=true;   

        if(!des.matches(valid_Date1))
        {
            test_flag=false;
            message="Invalid Date Format";
            System.out.println(message);
        }
        else
        {
            System.out.println("Valid Format");
            test_flag=true;
        }
        return test_flag;
    }

    /*========RAJ=============*/
    public static boolean orderno(String ordernumber)     
    {
        System.out.println("Inside the SQL Injuction File"+ordernumber+"PPO_NO");
        test_flag=true;
        try
        {
            if(ordernumber!=null && ordernumber.trim().length()>0)
            {
                for(int i=0;i<sqlInjection.length;i++)
                {
                    if(ordernumber.toLowerCase().indexOf(sqlInjection[i]) != -1)
                    {
                        message="Invalid Order Number";
                        test_flag=false;
                    }
                }
            }
            else
            {
                test_flag=false;
            }
            if(!ordernumber.matches(letterno))
            {
                message="Pattern Mismatch Error";
                test_flag=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("login.java: The Value of the String---> test_flag"+test_flag);
        return test_flag;
    }

    public static boolean validationdate(String date)     
    {
        // System.out.println("Inside the SQL Injuction File"+date+"PPO_NO");
        test_flag=true;
        try
        {

            if(!date.matches(valid_Date1))
            {
                message="Invalid Date Format";
                test_flag=false;
            }

            else
            {
                test_flag=true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("login.java: The Value of the String---> test_flag"+test_flag);
        return test_flag;
    }

    ////////////////////Start Gopi Token Generation///////////////    
    
	public String generateToken()
	{
		HttpSession ses = getRequest().getSession(true);
    	//HttpSession ses = request.getSession(false);

		System.out.println("generateToken()'s session value is---"+ses);
		String token=null;
		try
		{
			SecureRandom prng;
			prng = SecureRandom.getInstance("SHA1PRNG");
			//generate a random number
			String randomNum = new Integer( prng.nextInt() ).toString();
			//get its digest
			MessageDigest sha;
			sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());
			token = hexEncode(result);
			System.out.println("Generated Token is-------"+token);
			ses.setAttribute("token",token);
		}
		catch (NoSuchAlgorithmException e)
		{			
			e.printStackTrace();
		}	
		
		return token;
	}
	public String generateToken(HttpServletRequest request)
	{
		HttpSession ses = request.getSession(true);
    	//HttpSession ses = request.getSession(false);

		System.out.println("generateToken()'s session value is---"+ses);
		String token=null;
		try
		{
			SecureRandom prng;
			prng = SecureRandom.getInstance("SHA1PRNG");
			//generate a random number
			String randomNum = new Integer( prng.nextInt() ).toString();
			//get its digest
			MessageDigest sha;
			sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());
			token = hexEncode(result);
			System.out.println("Generated Token is-------"+token);
			ses.setAttribute("token",token);
		}
		catch (NoSuchAlgorithmException e)
		{			
			e.printStackTrace();
		}	
		
		return token;
	}
    protected String hexEncode( byte[] aInput)
	{
		StringBuilder result = new StringBuilder();
		char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
		for ( int idx = 0; idx < aInput.length; ++idx)
		{
			byte b = aInput[idx];
			result.append( digits[ (b&0xf0) >> 4 ] );
			result.append( digits[ b&0x0f] );
		}
		return result.toString();
	}
	
    
    ////////////////////End Gopi Token Generation///////////////
    



    /*========RAJ=============*/

    private static final long serialVersionUID = -6367594501777586480L;
    private HttpServletRequest request;   
    private HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        // TODO Auto-generated method stub       
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
        // TODO Auto-generated method stub       
    }



    public static String[] getSqlInjection() {
        return sqlInjection;
    }

    public static void setSqlInjection(String[] sqlInjection) {
        BaseAction.sqlInjection = sqlInjection;
    }

    public static String getPatppono() {
        return patppono;
    }

    public static void setPatppono(String patppono) {
        BaseAction.patppono = patppono;
    }

    public static boolean isTest_flag() {
        return test_flag;
    }

    public static void setTest_flag(boolean test_flag) {
        BaseAction.test_flag = test_flag;
    }

    public static String getError1() {
        return error1;
    }

    public static void setError1(String error1) {
        BaseAction.error1 = error1;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        BaseAction.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}