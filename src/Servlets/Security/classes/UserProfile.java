package Servlets.Security.classes;

public class UserProfile
{
  private int Employee_Id;
  private String EmpInitial;
  private String Employee_Name;
  private String Employee_Prefix;
  private String Designation;
  private String Office_Level;
  private String Office_Short_Name;
  private String Office_Address;

  public UserProfile()
  {
      Employee_Id=0;
      EmpInitial="";
      Employee_Name="";
      Employee_Prefix="";
      Designation="";
      Office_Level="";
      Office_Short_Name="";
      Office_Address="";
  }

  public UserProfile(int id,String ini,String name,String prefix,String designation,String level,String sname,String address)
  {
    this.Employee_Id=id;
    this.EmpInitial=ini;
    this.Employee_Name=name;
    this.Employee_Prefix=prefix;
    this.Designation=designation;
    this.Office_Level=level;
    this.Office_Short_Name=sname;
    this.Office_Address=address;
  }

  public int getEmployeeId()
  {
    return this.Employee_Id;
  }
  
    public void setEmployeeId(int empid)
    {
      this.Employee_Id=empid;
    }

    public String getEmpInitial()
    {
      return this.EmpInitial;
    }

  public String getEmployeeName()
  {
    return this.Employee_Name;
  }

  public String getEmployeePrefix()
  {
    return this.Employee_Prefix;
  }

  public String getDesignation()
  {
    return this.Designation;
  }

  public String getOfficeLevel()
  {
    return this.Office_Level;
  }

  public String getOfficeShortName()
  {
    return this.Office_Short_Name;
  }

  public String getOfficeAddress()
  {
    return this.Office_Address;
  }
}