package Servlets.Security.servlets;



import java.security.MessageDigest; 
import java.io.UnsupportedEncodingException; 
 
import java.security.NoSuchAlgorithmException; 
//import java.security.NoSuchAlgorithmException;  
public class newmd5 { 

private static String convertToHex(byte[] data) { 
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < data.length; i++) { 
        int halfbyte = (data[i] >>> 4) & 0x0F;
        int two_halfs = 0;
        do { 
            if ((0 <= halfbyte) && (halfbyte <= 9)) 
                buf.append((char) ('0' + halfbyte));
            else 
                buf.append((char) ('a' + (halfbyte - 10)));
            halfbyte = data[i] & 0x0F;
        } while(two_halfs++ < 1);
    } 
    return buf.toString();
} 

public static String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 

    MessageDigest md;
    md = MessageDigest.getInstance("MD5");
    byte[] md5hash = new byte[32];
    md.update(text.getBytes("iso-8859-1"), 0, text.length());
    md5hash = md.digest();
    System.out.println(convertToHex(md5hash));
    return convertToHex(md5hash);
 } 
}  

  
/*public class MD5 {  
 public String getMD5(byte[] source)   
 {  
  String s = null;  
  char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
    'A', 'B', 'C', 'D', 'E', 'F' };// 16  
  try   
  {  
   MessageDigest md = MessageDigest.getInstance("MD5");  
   md.update(source);  
   byte tmp[] = md.digest();// MD5  128 ?  16   
   char str[] = new char[16 * 2];//  16 ? 32   
   int k = 0;  
   for (int i = 0; i < 16; i++) {  
    byte byte0 = tmp[i];  
    str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 4 ?  
    str[k++] = hexDigits[byte0 & 0xf];// 4   
   }  
   s = new String(str);//  
  } catch (NoSuchAlgorithmException e) {  
   e.printStackTrace();  
  }  
  return s;  
 }  
    //  
 public static void main(String[] args)   
 {  
  MD5 md5 = new MD5();  
  String test = md5.getMD5("Pwd".getBytes());  
  System.out.println(test);  
 }  
} */ 