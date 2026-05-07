package Servlets.Security.classes;

// generates a 12 digit code to represent the office hierarchy
// code contains onlu numeric characters
import java.util.StringTokenizer;
import java.sql.*;

public class CodeGenerator 
{    
    private int headCodeDigits=1;
    private int RegionCodeDigits=2;
    private int CircleCodeDigits=2;
    private int DivisionCodeDigits=3;
    private int SubDivisionCodeDigits=2;
    private int SectionCodeDigits=2;
    private int totalDigits=12;
    
    private String levelToWhichCodeIsGen="";
    private String hierarchyCode="";
    
    private Connection connection=null;
    private Statement statement=null;
    
    public CodeGenerator()
    {
    }
    
    public CodeGenerator(String level,String hcode)
    {
      this.levelToWhichCodeIsGen=level;
      this.hierarchyCode=hcode;
    }
    
    public String generateCode() throws CodeException
    {
            String strCode="";             
            StringTokenizer tokens= new StringTokenizer(this.hierarchyCode,"-");
            
            // opening database                         
          
            try
            {
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 connection=DriverManager.getConnection("Jdbc:Odbc:twad");
                 try
                 {
                      statement=connection.createStatement();
                      connection.clearWarnings();
                 }
                 catch(SQLException e)
                 {
                        //System.out.println("Exception in creating statement:"+e);
                 }          
            }
            catch(Exception e)
            {
                   //System.out.println("Exception in openeing connection:"+e);
            }
            
            if(levelToWhichCodeIsGen.equals("HO"))
            {
                strCode="1";
                for(int i=0;i<totalDigits-1;i++)
                  strCode=strCode + "0";
            }
            else if(levelToWhichCodeIsGen.equals("RN"))
            {
                try
                {
                  strCode=nextRegionCode();
                  strCode="1" + strCode;
                  for(int i=strCode.length();i<totalDigits;i++)
                    strCode=strCode + "0";
                }
                catch(CodeException ce)
                {
                  throw ce;
                }   
            }
            else if(levelToWhichCodeIsGen.equals("CL"))
            {
                try
                {
                  strCode=nextCircleCode();
                  strCode="1" + this.hierarchyCode + strCode;
                  for(int i=strCode.length();i<totalDigits;i++)
                    strCode=strCode + "0";
                }
                catch(CodeException ce)
                {
                  throw ce;
                }
            }
            else if(levelToWhichCodeIsGen.equals("DN"))
            {
                try
                {
                  strCode=nextDivisionCode();
                  StringBuffer sb=new StringBuffer(this.hierarchyCode);
                  int idx=0;
                  while((idx=sb.indexOf("-"))>-1)
                  {
                    sb.deleteCharAt(idx);
                  }
                  strCode="1" + sb.toString() + strCode;
                  for(int i=strCode.length();i<totalDigits;i++)
                    strCode=strCode + "0";
                }
                catch(CodeException ce)
                {
                  throw ce;
                }
            }
            else if(levelToWhichCodeIsGen.equals("LB"))
            {
                try
                {
                  strCode=nextLabCode();
                  StringBuffer sb=new StringBuffer(this.hierarchyCode);
                  int idx=0;
                  while((idx=sb.indexOf("-"))>-1)
                  {
                    sb.deleteCharAt(idx);
                  }
                  strCode="1" + sb.toString() + strCode;
                  for(int i=strCode.length();i<totalDigits;i++)
                    strCode=strCode + "0";
                }
                catch(CodeException ce)
                {
                  throw ce;
                }              
            }
            else if(levelToWhichCodeIsGen.equals("SD"))
            {
                try
                {
                  strCode=nextSubDivisionCode();
                  StringBuffer sb=new StringBuffer(this.hierarchyCode);
                  int idx=0;
                  while((idx=sb.indexOf("-"))>-1)
                  {
                    sb.deleteCharAt(idx);
                  }
                  strCode="1" + sb.toString() + strCode;
                  for(int i=strCode.length();i<totalDigits;i++)
                    strCode=strCode + "0";
                }
                catch(CodeException ce)
                {
                  throw ce;
                }
            }
            else if(levelToWhichCodeIsGen.equals("SN"))
            {
                try
                {
                  strCode=nextSectionCode();
                  StringBuffer sb=new StringBuffer(this.hierarchyCode);
                  int idx=0;
                  while((idx=sb.indexOf("-"))>-1)
                  {
                    sb.deleteCharAt(idx);
                  }
                                      
                  strCode="1" + sb.toString() + strCode;
                  for(int i=strCode.length();i<totalDigits;i++)
                    strCode=strCode + "0";
                }
                catch(CodeException ce)
                {
                  throw ce;
                }
            }       
            return strCode;
    }
    
    // function to generate next region code
    
    private String nextRegionCode() throws CodeException
    {
                String strrcode="",strCode="";
                String sql="SELECT Regions.Region_Code FROM Regions ORDER BY Regions.Region_Code";
                try
                {
                  // getting the max of all
                  
                  ResultSet rs=statement.executeQuery(sql);
                  while(rs.next())
                  {
                    strrcode=rs.getString("Region_Code");
                  }
                  rs.close();
                  
                  // converting to integer
                  int intrcode=-1;
                  try
                  {
                    intrcode=Integer.parseInt(strrcode);
                  }
                  catch(NumberFormatException nfe)
                  {
                    // no code assigned so far
                    for(int i=0;i<RegionCodeDigits-1;i++)
                      strCode=strCode + "0";
                    strCode=strCode + "1";
                    return strCode; 
                  } 
                  
                  // code already assigned
                  int max=generateMax(RegionCodeDigits);
                  intrcode++;  // increment
                  if(intrcode>max)
                  {
                    throw new CodeException("Code Exceeds The Limit.");
                  }
                  
                  // lies in the limit
                  // build string 
                  strCode=Integer.toString(intrcode);
                  while(strCode.length() < RegionCodeDigits)
                    strCode = "0" + strCode ;
                  return strCode;
                }
                catch(Exception e)
                {
                  System.out.println("error executing query : " +  e);
                  throw new CodeException("error :" + e);
                }
         // return "null";
    }
    
    // function to generate next circle code
    private String nextCircleCode() throws CodeException
    {
                String strccode="",strCode="";
                String sql="SELECT Circles.Circle_Code FROM Circles WHERE Circles.Region_Code='" + this.hierarchyCode + "' ORDER BY Circles.Circle_Code";
                try
                {
                  // getting the max of all
                  
                  ResultSet rs=statement.executeQuery(sql);
                  while(rs.next())
                  {
                    strccode=rs.getString("Circle_Code");
                  }
                  rs.close();
                  
                  // converting to integer
                  int intccode=-1;
                  try
                  {
                    intccode=Integer.parseInt(strccode);
                  }
                  catch(NumberFormatException nfe)
                  {
                    // no code assigned so far
                    for(int i=0;i<CircleCodeDigits-1;i++)
                      strCode=strCode + "0";
                    strCode=strCode + "1";
                    return strCode; 
                  } 
                  
                  // code already assigned
                  int max=generateMax(CircleCodeDigits);
                  intccode++;  // increment
                  if(intccode>max)
                  {
                    throw new CodeException("Code Exceeds The Limit.");
                  }
                  
                  // lies in the limit
                  // build string 
                  strCode=Integer.toString(intccode);
                  while(strCode.length() < CircleCodeDigits)
                    strCode = "0" + strCode ;
                  return strCode;
                }
                catch(Exception e)
                {
                  System.out.println("error executing query : " +  e);
                  throw new CodeException("error :" + e);
                }
         // return "null";
    }
    
    private String nextDivisionCode() throws CodeException
    {
                String strrcode="",strccode="",strdcode="",strCode="";
                StringTokenizer st=new StringTokenizer(this.hierarchyCode,"-");
                try
                {
                  strrcode=st.nextToken();
                  strccode=st.nextToken();
                }
                catch(Exception e)
                {
                  System.out.println("error while tokenizing code for division");
                  throw new CodeException("invalid hierarchy code");
                }
                
                String sql="SELECT Divisions.Division_Code FROM Divisions WHERE Divisions.Region_Code='" + strrcode + "' and Divisions.Circle_Code='" + strccode + "' ORDER BY Divisions.Division_Code";
                //System.out.println(sql);
                
                try
                {
                  // getting the max of all
                  
                  ResultSet rs=statement.executeQuery(sql);
                  while(rs.next())
                  {
                    strdcode=rs.getString("Division_Code");
                  }
                  rs.close();
                  
                  // converting to integer
                  int intdcode=-1;
                  try
                  {
                    intdcode=Integer.parseInt(strdcode);
                  }
                  catch(NumberFormatException nfe)
                  {
                    // no code assigned so far
                    for(int i=0;i<DivisionCodeDigits-1;i++)
                      strCode=strCode + "0";
                    strCode=strCode + "1";
                    return strCode; 
                  } 
                  
                  // code already assigned
                  int max=generateMax(DivisionCodeDigits-1);
                  intdcode++;  // increment
                  if(intdcode>max)
                  {
                    throw new CodeException("Code Exceeds The Limit.");
                  }
                  
                  // lies in the limit
                  // build string 
                  strCode=Integer.toString(intdcode);
                  while(strCode.length() < DivisionCodeDigits)
                    strCode = "0" + strCode ;
                  return strCode;
                }
                catch(Exception e)
                {
                  System.out.println("error executing query : " +  e);
                  throw new CodeException("error :" + e);
                }
         // return "null";
    }
    
    private String nextLabCode() throws CodeException
    {
                String strrcode="",strccode="",strlcode="",strCode="";
                StringTokenizer st=new StringTokenizer(this.hierarchyCode,"-");
                try
                {
                  strrcode=st.nextToken();
                  strccode=st.nextToken();
                }
                catch(Exception e)
                {
                  System.out.println("error while tokenizing code for Lab");
                  throw new CodeException("invalid hierarchy code");
                }
                
                String sql="SELECT Labs.Lab_Code FROM Labs WHERE Labs.Region_Code='" + strrcode + "' and Labs.Circle_Code='" + strccode + "' ORDER BY Labs.Lab_Code";
                //System.out.println(sql);
                
                try
                {
                  // getting the max of all
                  
                  ResultSet rs=statement.executeQuery(sql);
                  while(rs.next())
                  {
                    strlcode=rs.getString("Lab_Code");
                  }
                  rs.close();
                  
                  // converting to integer
                  int intlcode=-1;
                  try
                  {
                    strlcode=strlcode.substring(1);
                    intlcode=Integer.parseInt(strlcode);
                  }
                  catch(Exception nfe)
                  {
                    // no code assigned so far
                    for(int i=0;i<DivisionCodeDigits-2;i++)
                      strCode=strCode + "0";
                    strCode="1" + strCode + "1";
                    return strCode; 
                  } 
                  
                  // code already assigned
                  int max=generateMax(DivisionCodeDigits-1);
                  intlcode++;  // increment
                  if(intlcode>max)
                  {
                    throw new CodeException("Code Exceeds The Limit.");
                  }
                  
                  // lies in the limit
                  // build string 
                  strCode=Integer.toString(intlcode);
                  while(strCode.length() < DivisionCodeDigits-1)
                    strCode = "0" + strCode ;
                  return "1" + strCode;
                }
                catch(Exception e)
                {
                  System.out.println("error executing query : " +  e);
                  throw new CodeException("error :" + e);
                }
          //return "null";
    }
    
    private String nextSubDivisionCode() throws CodeException
    {
                String strrcode="",strccode="",strdcode="",strsdcode="",strCode="";
                StringTokenizer st=new StringTokenizer(this.hierarchyCode,"-");
                try
                {
                  strrcode=st.nextToken();
                  strccode=st.nextToken();
                  strdcode=st.nextToken();
                }
                catch(Exception e)
                {
                  System.out.println("error while tokenizing code for Lab");
                  throw new CodeException("invalid hierarchy code");
                }
                
                String sql="SELECT SubDivisions.SubDivision_Code FROM SubDivisions WHERE SubDivisions.Region_Code='" + strrcode + "' and SubDivisions.Circle_Code='" + strccode + "' and SubDivisions.Division_Code='" + strdcode + "' ORDER BY SubDivisions.SubDivision_Code";
                //System.out.println(sql);
                try
                {
                  // getting the max of all
                  
                  ResultSet rs=statement.executeQuery(sql);
                  while(rs.next())
                  {
                    strsdcode=rs.getString("Region_Code");
                  }
                  rs.close();
                  
                  // converting to integer
                  int intsdcode=-1;
                  try
                  {
                    intsdcode=Integer.parseInt(strsdcode);
                  }
                  catch(NumberFormatException nfe)
                  {
                    // no code assigned so far
                    for(int i=0;i<SubDivisionCodeDigits-1;i++)
                      strCode=strCode + "0";
                    strCode=strCode + "1";
                    return strCode; 
                  } 
                  
                  // code already assigned
                  int max=generateMax(SubDivisionCodeDigits);
                  intsdcode++;  // increment
                  if(intsdcode>max)
                  {
                    throw new CodeException("Code Exceeds The Limit.");
                  }
                  
                  // lies in the limit
                  // build string 
                  strCode=Integer.toString(intsdcode);
                  while(strCode.length() < SubDivisionCodeDigits)
                    strCode = "0" + strCode ;
                  return strCode;
                }
                catch(Exception e)
                {
                  System.out.println("error executing query : " +  e);
                  throw new CodeException("error :" + e);
                }
          //return "null";
    }
    
    private String nextSectionCode() throws CodeException
    {
                String strrcode="",strccode="",strdcode="",strsdcode="",strscode="",strCode="";
                StringTokenizer st=new StringTokenizer(this.hierarchyCode,"-");
                try
                {
                  strrcode=st.nextToken();
                  strccode=st.nextToken();
                  strdcode=st.nextToken();
                  strsdcode=st.nextToken();
                }
                catch(Exception e)
                {
                  System.out.println("error while tokenizing code for Lab");
                  throw new CodeException("invalid hierarchy code");
                }
                
                String sql="SELECT Sections.Section_Code FROM Sections WHERE Sections.Region_Code='" + strrcode + "' and Sections.Circle_Code='" + strccode + "' and Sections.Division_Code='" + strdcode + "' and Sections.SubDivision_Code='" + strsdcode + "' ORDER BY Sections.Section_Code";
                //System.out.println(sql);
                try
                {
                  // getting the max of all
                  
                  ResultSet rs=statement.executeQuery(sql);
                  while(rs.next())
                  {
                    strscode=rs.getString("Section_Code");
                  }
                  rs.close();
                  
                  // converting to integer
                  int intscode=-1;
                  try
                  {
                    intscode=Integer.parseInt(strscode);
                  }
                  catch(NumberFormatException nfe)
                  {
                    // no code assigned so far
                    for(int i=0;i<SectionCodeDigits-1;i++)
                      strCode=strCode + "0";
                    strCode=strCode + "1";
                    return strCode; 
                  } 
                  
                  // code already assigned
                  int max=generateMax(SectionCodeDigits);
                  intscode++;  // increment
                  if(intscode>max)
                  {
                    throw new CodeException("Code Exceeds The Limit.");
                  }
                  
                  // lies in the limit
                  // build string 
                  strCode=Integer.toString(intscode);
                  while(strCode.length() < SectionCodeDigits)
                    strCode = "0" + strCode ;
                  return strCode;
                }
                catch(Exception e)
                {
                  System.out.println("error executing query : " +  e);
                  throw new CodeException("error :" + e);
                }
          //return "null";
    }
    
    private int generateMax(int Digits)
    {
      String strmax="";
      for(int i=0;i<Digits;i++)
        strmax=strmax + "9";
      return Integer.parseInt(strmax);      
    }
    
}