package Servlets.Security.servlets;



import java.io.Serializable;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
//import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;


import Servlets.Security.classes.UserProfile;

//import com.opensymphony.oscache.util.StringUtil;

public class TwadUtil {
	private final static String ALGORITHM = "DES";
	private final static String HEX = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final static String TWADKEYS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final static String DATEFORMAT="dd/mm/yyyy";
	//Password Encryption
	public static String encryptPassword(String passwd)
	{
		String newpasswd = null;
		byte []b=passwd.getBytes();
        try{
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(b);
            byte messageDigest[] = algorithm.digest();                     
            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<messageDigest.length;i++) {
                 hexString.append(Integer.toHexString(0xFF & messageDigest[i]));                    
            }
            newpasswd=new String(hexString);
            }catch(NoSuchAlgorithmException nsae){
        }
		
		return newpasswd;
	}
	//Encryption for Secret key  
	
	 public static String cipher(String secretKey, String data) throws Exception {
	        // Key has to be of length 8
	        if (secretKey == null || secretKey.length() != 8)
	            throw new Exception("Invalid key length - 8 bytes key needed!");
	         
	        SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	         
	        return toHex(cipher.doFinal(data.getBytes()));
	    }
	     
	    /**
	     * Decrypt data
	     * @param secretKey -   a secret key used for decryption
	     * @param data      -   data to decrypt
	     * @return  Decrypted data
	     * @throws Exception
	     */
	    public static String decipher(String secretKey, String data) throws Exception {
	        // Key has to be of length 8
	    
	    		
	        if (secretKey == null || secretKey.length() != 8)
	            throw new Exception("Invalid key length - 8 bytes key needed!");
	         
	        SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        return new String(cipher.doFinal(toByte(data)));
	        
	    	
	    	
	    	
	    }
	     
	    // Helper methods
	     
	    private static byte[] toByte(String hexString) {
	        int len = hexString.length()/2;
	         
	        byte[] result = new byte[len];
	         
	        for (int i = 0; i < len; i++)
	            result[i] = Integer.valueOf(hexString.substring(2*i, 2*i+2), 16).byteValue();
	        return result;
	    }
	 
	    public static String toHex(byte[] stringBytes) {
	        StringBuffer result = new StringBuffer(2*stringBytes.length);
	         
	        for (int i = 0; i < stringBytes.length; i++) {
	            result.append(HEX.charAt((stringBytes[i]>>4)&0x0f)).append(HEX.charAt(stringBytes[i]&0x0f));
	        }
	         
	        return result.toString();
	    }
//Security Key generation  method
		public static String getSeckeys() {
				
			StringBuffer finalString = new StringBuffer();
			char[] chars = TWADKEYS.toCharArray();
			for ( int i = 0; i < 8; i++ ) {
			     double randomValue = Math.random();
			     int randomIndex = (int) Math.round(randomValue * (chars.length - 1));
			    // System.out.println("(chars.length - 1)="+ (chars.length - 1));
			   //  System.out.println("randomValue * (chars.length - 1)="+randomValue * (chars.length - 1));
			     char characterToShow = chars[randomIndex];
			     finalString.append(characterToShow);
			}
			return finalString.toString();
		}
		public static String getPath(String val)
		{
			try
			{
				
			String secretKey=TwadUtil.getSeckeys();
			String encryptSessionID=TwadUtil.cipher(secretKey, val);
		 	String securityPath="JSessionID="+encryptSessionID+"&TokenID="+secretKey;
		 	return securityPath;
			}
			catch(Exception e)
			{
				return null;
			}
		}
//Function which Checking token id length and SPL char , Checking session id and encrypted session id
		
		
		public static boolean isTrue(String secretKey, String encryptedSessionID,
				String sessionID) {
				
				if(StringUtils.isBlank(secretKey) || StringUtils.isBlank(encryptedSessionID) || StringUtils.isBlank(sessionID) )
				{
					System.out.println("here balnk");
				return true;
				}
				
				if(secretKey.length()!=8 || findSpecialCharacter(secretKey))
				{
					System.out.println("here secrest length");
					return true;
				}
				if(findSpecialCharacter(encryptedSessionID))
					return true;
				
				try {
				if(cipher(secretKey,sessionID).equals(encryptedSessionID))
					return false;
			} catch (Exception e) {
				System.out.println("True"+e);
				return true;
			}
			System.out.println("True");
			return true;
		}
		
//Date Validation (only with length)
		
		public static boolean isDate(String date)
		{
			if(StringUtils.isBlank(date))
				return false;
			else if(date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"))
				return true;
			
			return false;
		}
		
		public static boolean isDateonly(String date)
		{
			
			 if (!StringUtils.isBlank(date) &&(date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")))
					return true;
				 else if(StringUtils.isBlank(date))
					 return true;
				 else
				return false;
		}
		public static boolean isNumberonly(String number)
		{
			
			 if(!StringUtils.isBlank(number) && number.matches("[0-9]+"))
					return true;
				 else  if(StringUtils.isBlank(number))
					 return true;
					 
				 else
				return false;
		}
		public static boolean isNumber(String number)
		{
			if(StringUtils.isBlank(number))
				return false;
			else if(number.matches("[0-9]+"))
				return true;
			
			return false;
		}
		public static boolean checkLength(String val, int len)
		{
			if(StringUtils.isBlank(val) || len<=0)
				return false;
			else if(val.length()<=len)
				return true;
			
			return false;
		}
		
		public static boolean checkLengthonly(String val, int len)
		{
		
			if(!StringUtils.isBlank(val) &&(val.length()<=len))
				return true;
			
			if(StringUtils.isBlank(val))
				return true;
			else
				
			return false;
		}
		//Pattern matching for SPL char
		public static boolean findSpecialCharacter(String value) 
		{
			if(StringUtils.isBlank(value))
				return false;
			try
			{
			Pattern regex = Pattern.compile("[$&+:;`=?@#|'][/<>%\"]");
			Matcher matcher = regex.matcher(value);
			
			
			
			if(matcher.find())
			{
				
				return true;
			}
			else if(value.contains(".ini"))
				return true;
			else if(value.contains("alert("))
				return true;
			else if(value.contains("html"))
				return true;
			else if(value.contains("xml"))
				return true;
			else if(value.contains("script"))
				return true;
			else if(value.contains("%27"))
				return true;
			else if(value.contains("%20"))
				return true;
			else if(value.contains("'"))
			return true;
			else if(value.contains("%00"))
				return true;
			else if(value.contains("\'"))
				return true;
			else if(value.contains("\""))
				return true;
			else if(value.contains("eval"))
				return true;
			else if(value.contains("javascript"))
				return true;
			else if(value.contains("\""))
				return true;
			return false;
			}
			catch(Exception e)
			{
				System.out.println("ERROR in check: "+e);
				return true;
			}
		}
	//NEw Function for check hash code compare
		
		public static boolean check_hash(String TokenID,int empid,String data, String hash)
		{
		System.out.println("Token"+TokenID);
		System.out.println("empid"+empid);
		System.out.println("data"+data);
			try
			{
			 javax.crypto.Mac mac = null;
	          javax.crypto.spec.SecretKeySpec signingKey = null;

	          mac = Mac.getInstance("HmacSHA256");
	          byte[] keyBytes = (TokenID).getBytes("UTF8");
	          signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");
	          mac.init(signingKey);
	          //System.out.println("emp or InputVal========>  "+emp);
	          String finalVal = "";
	       
	          if(empid!=0)
	          {
	              finalVal = empid+data;
	              }
	         
	         
	         // System.out.println("final val in dofinal:"+finalVal);
	          byte[] signBytes = mac.doFinal(finalVal.getBytes("UTF8"));
	          String result = "";
	          for (final byte element : signBytes)
	          {
	             result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
	          }
	           System.out.println("Result :"+result);
	          // log.info("Result :"+result);
	        
	         if((hash).equals(result))
	         {
	             System.out.println("Inside If Flag");
	            // log.info("Inside If Flag");
	            return true;
	         }

			}
			catch(Exception e)
			{
				System.out.println("Exception xxxxx"+e);
			}
			
			
			 return false;
		}
		public  static  boolean parameterCheck_double(String value,int len)
		{	
			System.out.println("Input value" +value+"gfsg");
			boolean res=true;
			if( !isNumber(value) || !checkLength(value,len) || StringUtils.isBlank(value))
			{
				res=false;
			}
			
				System.out.println("res-------->"+res);	
			return res;
		}
		
		public  static  boolean parameterCheck_doubleonly(String value,int len)
		{	
			System.out.println("Input value" +value+"gfsg");
			boolean res=true;
			if( !isNumber(value) || !checkLength(value,len))
			{
				res=false;
			}
			
				System.out.println("res-------->"+res);	
			return res;
		}
		public static boolean isAlpha(String name) {
           if ((!StringUtils.isBlank(name))&& (name.matches("[a-zA-Z]+")))
			    return true;
          return false;
        }
		public static boolean isAlphaNum(String name) {
	           if (!StringUtils.isBlank(name))
	        	   System.out.println("trueeee");
	        		   if(name.matches("[a-zA-Z0-9]+"))
	           { System.out.println("trueeeeeeeeeeeeeeeeeeeee");
	        	   return true;
	          	           }
	          return false;
	        }
		public static boolean isNumber(String value,int process_flag)
		{
			boolean res=true;
			int flag=0;
			for(int i=0;i<value.length();i++)
			{
				int ascii=value.charAt(i);			
				if (ascii > 45 && ascii < 58 )
				{
					flag++;
				}
					else
				{
					res=false;
					break;
				}		
			}		
			return res;
		}
		public   static  boolean  parameterCheck_String(String value,int len)
		{
			boolean res=true;
			 
				
			System.out.println(" Before res" + res);
			if(findSpecialCharacter(value) || StringUtils.isBlank(value) || !TwadUtil.checkLength(value,len))
				{
					res=false;
				}
		
			System.out.println(" After res" + res);
			return res;
		}
		public   static  boolean  parameterCheck_SPLString(String value,int len)
		{
			boolean res=true;
			 
				
			System.out.println(" Before res" + res);
			if(StringUtils.isBlank(value) || !TwadUtil.checkLength(value,len))
				{
					res=false;
				}
			else
			{
				int index=0;
				if (!value.equalsIgnoreCase("0"))
				{
						index+=(value.indexOf("<")>=0)?1:0;
						index+=(value.indexOf(")")>=0)?1:0;
						index+=(value.indexOf("(")>=0)?1:0;
						index+=(value.indexOf(";")>=0)?1:0;
						index+=(value.indexOf(":")>=0)?1:0;			
						index+=(value.indexOf("\\")>=0)?1:0;
						index+=(value.indexOf("eval")>0)?1:0;
						index+=(value.indexOf("javascript")>0)?1:0;
						index+=(value.indexOf("script")>0)?1:0;
						index+=(value.indexOf('>')>0)?1:0;
						index+=(value.indexOf ('"')>0)?1:0;
					//	index+=(value.indexOf ('\'')>0)?1:0;
						index+=(value.indexOf ('%')>0)?1:0;
						index+=(value.indexOf (';')>0)?1:0;
						index+=(value.indexOf ('&')>0)?1:0;
						index+=(value.indexOf ('+')>0)?1:0;
						index+=(value.indexOf ('=')>0)?1:0;
						index+=(value.indexOf ('[')>0)?1:0;
						index+=(value.indexOf (']')>0)?1:0;		
						index+=(value.indexOf ('$')>0)?1:0;
						index+=(value.indexOf ('?')>0)?1:0;
						index+=(value.indexOf ('#')>0)?1:0;
						index+=(value.indexOf ('|')>0)?1:0;
					//	index+=(value.indexOf (',')>0)?1:0;
						index+=(value.indexOf (' ')>0)?1:0;
						index+=(value.indexOf (" ")>0)?1:0;
						
				}
				System.out.println("Index ----------------------------------------------" + index);
				
				if (index>0)
					res=false;
				else
					res=true;
			}
			System.out.println(" After res" + res);
			return res;
		}
		public   static  boolean  parameterCheck_RepString(String value,int len)
		{
			boolean res=true;
			 
				
			System.out.println(" Before res" + res);
			if( StringUtils.isBlank(value) || !TwadUtil.checkLength(value,len))
				{
					res=false;
				}
			else
			{
				int index=0;
				if (!value.equalsIgnoreCase("0"))
				{
						
						index+=(value.indexOf("eval")>0)?1:0;
						index+=(value.indexOf("javascript")>0)?1:0;
						index+=(value.indexOf("script")>0)?1:0;
						index+=(value.indexOf('>')>0)?1:0;
						index+=(value.indexOf ('"')>0)?1:0;
						index+=(value.indexOf ('\'')>0)?1:0;
						index+=(value.indexOf ('%')>0)?1:0;
						index+=(value.indexOf (';')>0)?1:0;
						index+=(value.indexOf ('&')>0)?1:0;
						index+=(value.indexOf ('+')>0)?1:0;
						index+=(value.indexOf ('=')>0)?1:0;
						index+=(value.indexOf ('[')>0)?1:0;
						index+=(value.indexOf (']')>0)?1:0;		
						index+=(value.indexOf ('$')>0)?1:0;
						index+=(value.indexOf ('?')>0)?1:0;
						index+=(value.indexOf ('#')>0)?1:0;
						index+=(value.indexOf ('|')>0)?1:0;
						index+=(value.indexOf (' ')>0)?1:0;
						index+=(value.indexOf (" ")>0)?1:0;
						
				}
				
				
				if (index>0)
					res=false;
				else
					res=true;
			}
			System.out.println(" After res" + res);
			return res;
		}
		public  static  boolean parameterCheck_Stringonly(String value,int len)
		{
			boolean res=true;
			 
				
			System.out.println(" Before res" + res);
			if(!value.equals(null))
			{
			if(!checkLengthonly(value,len)||findSpecialCharacter(value))
				{
					res=false;
				}
			}
			System.out.println(" After res" + res);
			return res;
		}
		public  static  boolean parameterCheck_int(String value,int len)
		{	
			System.out.println("Input value" +value+"gfsg");
			boolean res=true;
			if( !isNumber(value) || !checkLength(value,len) || StringUtils.isBlank(value))
			{
				res=false;
			}
			
				System.out.println("res-------->"+res);	
			return res;
		}
		public  static  boolean parameterCheck_intonly(String value,int len)
		{	
			System.out.println("Input value" +value);
			boolean res=true;
			if( !isNumberonly(value) || !checkLengthonly(value,len) )
			{
				res=false;
			}
			else
				res=true;
					
			return res;
		}
		public  static  boolean parameterCheck_date(String value)
		{	
			System.out.println("Input value" +value);
			boolean res=true;
			if(StringUtils.isBlank(value)||!checkLength(value, 10)||!isDate(value))
			{
				res=false;
			}
			
				
			 
			System.out.println("return value is " +res);
			return res;
		}
		public  static  boolean parameterCheck_dateonly(String value)
		{	
			System.out.println("Input value" +value);
			boolean res=true;
			if(StringUtils.isBlank(value)||!checkLengthonly(value, 10)||!isDateonly(value))
			{
				res=false;
			}
			
				
			 
			System.out.println("return value is " +res);
			return res;
		}
		public  static  boolean parameterCheck_Alphanum(String value,int len)
		{	
			System.out.println("Input value" +value.length());
			boolean res=true;
			if(StringUtils.isBlank(value)||!checkLengthonly(value, len)||!isAlphaNum(value))
			{
				res=false;
			}
			
				
			 
			System.out.println("return value is " +res);
			return res;
		}
		public static boolean chkSession(HttpServletRequest request,HttpSession session)
		{
		boolean valid=true;
		 String TokenID=request.getParameterMap().containsKey("TokenID")?request.getParameter("TokenID"):"#"; 
		  String JSessionID=request.getParameterMap().containsKey("JSessionID")?request.getParameter("JSessionID"):"#";
		  System.out.println(JSessionID.length());
		  System.out.println(TokenID.length());
		  if(TwadUtil.parameterCheck_Alphanum(JSessionID,80)&&(TwadUtil.parameterCheck_Alphanum(TokenID,8)))
		  {
			  System.out.println("inside");
			  
			  if(TwadUtil.isTrue(TokenID,JSessionID,session.getId().toString()))
			  valid=false;
		  else
               valid=true;
		  }
		else
			valid=false;
		System.out.println("valid value"+valid);
			  return valid;
		}
		public  static  String callhmac(HttpServletRequest request)
		{
			String querystring="",data="",hash="",xmlval=null;
			int empid=0;
			boolean f=true;
			 HttpSession session = request.getSession(false);
			String   TokenID=request.getParameterMap().containsKey("TokenID")?request.getParameter("TokenID"):"#";
			System.out.println("TokenID----->"+TokenID);
		    String   JSessionID=request.getParameterMap().containsKey("JSessionID")?request.getParameter("JSessionID"):"#";
		    System.out.println("JSessionID----->"+JSessionID);
		    if(!TwadUtil.parameterCheck_Alphanum(JSessionID,80)&&(!TwadUtil.parameterCheck_Alphanum(TokenID,8)))
		    	 xmlval="<response><command>Error</command></response>";
		    if (!TwadUtil.isTrue(TokenID,JSessionID,session.getId().toString()))
		    {
		    	querystring=request.getQueryString();
		 	    System.out.println(querystring);
		 	    querystring=querystring.replaceAll("%20", " ");
		 	   querystring=querystring.replaceAll("%27", "'");
		 		data=querystring.substring(0,querystring.indexOf("hash")-1);
		 		System.out.println("data**************>"+data);
		 		hash=request.getParameterMap().containsKey("hash")?request.getParameter("hash"):"#";
		          session=request.getSession(false);
		          UserProfile up = (UserProfile) session.getAttribute("UserProfile");
		  	   	empid = up.getEmployeeId();
		  	 
		     	System.out.println("TokenID in java"+TokenID);
		     	System.out.println("Employee id in java"+empid);
		     	System.out.println("data in java"+data);
		    	  f=TwadUtil.check_hash(TokenID,empid,data, hash);
		    	  System.out.println("f------------>"+f);
		    	  if(f)
		    		  xmlval="True";
		    	  else
		    	      xmlval="<response><command>Error</command></response>";
		    	  
		    }else
		    {
		    	System.out.println("here error");
		    	 xmlval="<response><command>Error</command></response>";
		    }
		    
		    return xmlval;
		}
		public static String paramaterName_CK(HttpServletRequest request,String name)
		{
			System.out.println("valueeeeeeeeeeeeeeeeee**"+name);
			String value = request.getParameterMap().containsKey(name)?request.getParameter(name):"#";
			System.out.println("valueeeeeeeeeeeeeeeeee**"+value);
			return value; 
		}
		public static String [] paramaterNamevalues_CK(HttpServletRequest request,String name)
		{
			String[] value = (String[]) (request.getParameterMap().containsKey(name)?request.getParameterValues(name):"#");
			return value; 
		}
		
	    public static void main(String args[])
	    {
	       	try {
	    		String val="ALL OFFICES ";
	    		int len =7;
	    		boolean f=TwadUtil.checkLengthonly(val, len);
	    		System.out.println(f);
			boolean	flag = TwadUtil.isAlpha(null);
				System.out.println(flag);
				System.out.println(parameterCheck_String(val,500));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 
		
}
