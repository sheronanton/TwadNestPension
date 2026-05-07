package Servlets.Security.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import java.util.ResourceBundle;

import javax.servlet.*;
import javax.servlet.http.*;

public class TWADSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println(":::::::::NEW SESSION IS CREATED:::::::");
       String strcount= (String)e.getSession().getServletContext().getAttribute("activecount");
       if(strcount==null) {
           e.getSession().getServletContext().setAttribute("activecount","1");
       }
       else {
           int count =Integer.parseInt(strcount);
           count++;
           System.out.println("After Increment::"+count);
           e.getSession().getServletContext().setAttribute("activecount",new String(Integer.toString(count)));
       }
       
       
    }
    public void sessionDestroyed(HttpSessionEvent e) {
       System.out.println(":::::::::NEW SESSION IS DELETED:::::::");
        String strcount= (String)e.getSession().getServletContext().getAttribute("activecount");
        System.out.println("In Delete count:"+strcount);
        if(strcount!=null) {
          
            int count =Integer.parseInt(strcount);
            count--;
            System.out.println("after decrement:"+count);
            e.getSession().getServletContext().setAttribute("activecount",new String(Integer.toString(count)));
        }
        
        
        Connection connection=null;
        ResourceBundle rs=ResourceBundle.getBundle("Servlets.Security.servlets.Config");
        String ConnectionString="";
        String strDriver=rs.getString("Config.DATA_BASE_DRIVER");
        String strdsn=rs.getString("Config.DSN");
        String strhostname=rs.getString("Config.HOST_NAME");
        String strportno=rs.getString("Config.PORT_NUMBER");
        String strsid=rs.getString("Config.SID");
        String strdbusername=rs.getString("Config.USER_NAME");
        String strdbpassword=rs.getString("Config.PASSWORD");

        ConnectionString=strdsn.trim()+"://"+strhostname.trim()+":"+strportno.trim()+"/"+strsid.trim();//PostgresDB Connection
        System.out.println(" connection string : " + ConnectionString);
        try
        {
            Class.forName(strDriver.trim());
            connection=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
        }
        catch(Exception e1){
            System.out.println("exception in logout procedure:"+e1);        
         return;
        }
        
        
        try{
        int accno=Integer.parseInt((String)e.getSession().getAttribute("accno"));
        String sql="update sec_mst_users_login_history set LOGGED_OUT_TIME=? where ACCESS_SEQ_NUM=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        Timestamp tms=new Timestamp(System.currentTimeMillis());
        ps.setTimestamp(1,tms);
        ps.setInt(2,accno);
        ps.executeUpdate();
        }catch(Exception e2){System.out.println("Error in log out updateion :"+e2);}
        
        try{
            int l=e.getSession().getId().length();
            l=l-10;
            String tablename="TEMPSR_"+e.getSession().getId().substring(l);
             //tablename="TEMPSR"+empid;
            System.out.println("Temp table Name:::"+tablename);
            String sql="drop table "+tablename;
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("table droped");
        }catch(Exception e3){System.out.println("Error in delete temp table :"+e3);}
        
        
    }
}
