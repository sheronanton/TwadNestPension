package Servlets.Security.classes;
import java.util.ArrayList;

public class MenusAssigned
{
  public String Major_System_Id;
  public String Minor_System_Id;
  public String Sub_System_Id;
  public String Sub_System_Desc;
  public ArrayList menus;
  //public boolean menuCreated;
  public MenusAssigned()
  {
    Major_System_Id="";
    Minor_System_Id="";
    Sub_System_Id="";
    Sub_System_Desc="";
    menus=new ArrayList();
    //menuCreated=false;
  }
}