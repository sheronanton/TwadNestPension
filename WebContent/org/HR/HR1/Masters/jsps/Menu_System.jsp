<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.*,java.util.*"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <script type="text/javascript" src="../scripts/MenuScript.js"></script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
    <title>Menu System Details</title>
  </head>
  <body class="table">
   <%
  Connection connection=null;
  Statement statement=null;
  ResultSet results=null;
  ResultSet results1=null;
          try
                  {
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
                         //ConnectionString = strdsn.trim() + "@" + strhostname.trim() + ":" + strportno.trim() + ":" +strsid.trim() ;

                          Class.forName(strDriver.trim());
                          connection=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());

    try
    {
      statement=connection.createStatement();
    }
    catch(SQLException e)
    {
    }
  }
  catch(Exception e)
  {
  }
  %>
  <form name="MenuForm" id="MenuForm">
      
     
      <table cellspacing="3" cellpadding="2" border="1" width="100%" align="center">
        <tr>
          <td colspan="2" class="tdH">
            <div align="center">
              <strong> Menu Details</strong>
            </div></td>
        </tr>
        <tr>
          <td class="table">Major System Id</td>
          <td class="table">
            <select size="1" name="CmbMajorId" onchange="combomajor(event)">
              <option value="">
                ---Select Major Id---
              </option>
              <%
                                        try
                                        {
                                            results1=statement.executeQuery("select Major_System_Id,Major_System_Desc from SEC_MST_MAJOR_SYSTEMS");
                                            while(results1.next())
                                            {
                                            String temp=results1.getString("Major_System_Id");
                                            System.out.println(temp);
                                              out.println("<option value='" + temp + "'>" + results1.getString("Major_System_Desc") + "</option>");
                                            
                                            }
                                            results1.close();
                                        }
                                        catch(Exception e)
                                        {}
                                      %>
              
            
            </select>
          </td>
        </tr>
        <tr>
          <td class="table">Minor System Id</td>
          <td class="table">
            <select size="1" name="CmbMinorId" id="CmbMinorId" onchange="comboMinor(event)">
              <option value="">
                ---Select Minor Id
              </option>
            </select>
          </td>
        </tr>
        <tr>
          <td class="table">Sub System Id</td>
          <td class="table">
            <select size="1" name="CmbSubId" id="CmbSubId" onchange="callServer('Load','null')">
              <option value="">
                --- Select Sub System Id
              </option>
            </select>
          </td>
        </tr>
       <!-- <tr>
          <td>Select Menu Category</td>
          <td> <input type="radio" name="SelectMenuCat" id="SelectMenuCat" value="New" checked="checked" onclick="toShowNewMenu()"> New Menu Category
          <input type="radio" name="SelectMenuCat" id="SelectMenuCat" value="Existg" onclick="toShowExistgMenu()"> Existing Menu Category</td>
        </tr>
        <tr id="Existg" style="display:none">
          <td class="table" >Existing Menu Category</td>
          <td class="table" >
            <select size="1" name="CmbMenuCategory" id="CmbMenuCategory" onchange="callServer('Load','null')">
              <option value="">
                --- Select Menu Category ---
              </option>
            </select>
          </td>
        </tr>
        <tr id="New" style="display:block">
          <td class="table" >New Menu Category</td>
          <td class="table" >
            <input type="text" name="txtMenuCategory" id="txtMenuCategory" size="45" value="new"/>
          </td>
        </tr>
        <tr>
          <td class="table">Menu Category Sequence Number</td>
          <td class="table">
            <input type="text" name="txtMenuCategorySeq" id="txtMenuCategorySeq" size="45" maxlength="3"/>
          </td>
        </tr>-->
        <tr>
          <td class="table">Menu Id</td>
          <td class="table">
            <input type="text" name="txtMenuId" id="txtMenuId" size="85" maxlength="5"/>
            <input type="HIDDEN" name="htxtMenuId" id="htxtMenuId"/>
          </td>
        </tr>
        <tr>
          <td class="table">Menu Description</td>
          <td class="table">
            <input type="text" name="txtMenuDesc" id="txtMenuDesc" size="85"/>
          </td>
        </tr>
        <tr>
          <td class="table">Menu Short Description</td>
          <td class="table">
            <input type="text" name="txtMenuSDesc" id="txtMenuSDesc" size="85"/>
          </td>
        </tr>
        <tr>
          <td class="table">Menu File Path</td>
          <td class="table">
            <input type="text" name="txtMenuFilePath" id="txtMenuFilePath" size="85"/>
          </td>
        </tr>
        
        <tr>
          <td class="table">Menu Category Sequence Number</td>
          <td class="table">
            <input type="text" name="txtMenuCategorySeq" id="txtMenuCategorySeqno" size="45" maxlength="3" onkeypress="return  numbersonly1(event,this)"/>
          </td>
          
          <tr>
          <td class="table">Menu Category Name</td>
          <td class="table">
            <input type="text" name="CmbMenuCategory" id="CmbMenuCategory" size="45" />
          </td>
          
      <!--  <tr>
          <td class="table">Menu Order Sequence Number</td>
          <td class="table">
            <input type="text" name="txtMenuOrderSeq" id="txtMenuOrderSeq" size="45" maxlength="3"/>
          </td>
        </tr>-->
        
        
        <tr>
          <td colspan="2" class="tdH" id="add" style="display:block">
            <input type="button" name="CmdAdd" value="SAVE" id="CmdAdd" onclick="checkForRedundancy()"/>
            <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
                   <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick="Exit()" align="middle"/>
           </td>
           <td colspan="2" class="tdH" id="update" style="display:none">
            <input type="button" name="CmdUpdate" value="UPDATE"
                   id="CmdUpdate" onclick="callServer('Update','null')"/>
            <input type="button" name="CmdDelete" value="DELETE"
                   id="CmdDelete" onclick="callServer('Delete','null')"/>
                   <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
                   <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick="Exit()" align="middle"/>
          </td>
        </tr>
        <tr>
        <td colspan="2" class="table">
              Existing Details
        </td>
      </table>
    <table id="Existing" cellspacing="2" cellpadding="3" border="1" width="100%" align="center">
      <tr class="tdH">
        <th>
          View
        </th>
        <th>
          Menu Id
        </th>
        <th>
          Menu Desc
        </th>
        <th>
          Menu Short Desc
        </th>
        <th>
          Menu File Path
        </th>
        <th>
          Menu Category Sequence Number
        </th>
        <th>
          Menu Category Sequence Name
        </th>
       <!-- <th>
          Menu Order Sequence Number
        </th>-->
        <tbody id="tblList" class="table"></tbody>
      </tr>
    </table><p>
      &nbsp;
    </p>
    </form>
    </body>
</html>