package Servlets.Security.servlets;


import java.sql.*;

import java.io.*;

import java.util.ResourceBundle;

public class LoadDriver {
    public Connection con = null;

    public Connection getConnection() {
        Connection con=null;
        try {
            
             ResourceBundle rsb=ResourceBundle.getBundle("Servlets.Security.servlets.Config");
             String ConnectionString="";

             String strDriver=rsb.getString("Config.DATA_BASE_DRIVER");
             String strdsn=rsb.getString("Config.DSN");
             String strhostname=rsb.getString("Config.HOST_NAME");
             String strportno=rsb.getString("Config.PORT_NUMBER");
             String strsid=rsb.getString("Config.SID");
             String strdbusername=rsb.getString("Config.USER_NAME");
             String strdbpassword=rsb.getString("Config.PASSWORD");
             ConnectionString=strdsn.trim()+"://"+strhostname.trim()+":"+strportno.trim()+"/"+strsid.trim();//PostgresDB Connection
            // ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

             Class.forName(strDriver.trim());
             con=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
              
        } catch (Exception e) {
            System.out.println("Exception*****1" + e.getMessage());
        }

        return con;
    }
}
