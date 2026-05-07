package Servlets.Security.classes;
import java.util.ArrayList;

public class MajorSystems
{
    public String Major_System_Id;
    public String Major_System_Desc;
    public ArrayList SubSystems;

    public MajorSystems()
    {
      Major_System_Id="";
      Major_System_Desc="";
      SubSystems=new ArrayList();
    }
}