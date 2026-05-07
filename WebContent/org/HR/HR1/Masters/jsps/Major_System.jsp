<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page session="false" contentType="text/html;charset=windows-1252"%>
<%@ include file="//org/Security/jsps/Check_SessionJSPF.jspf" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Major System Details</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/org/Library/scripts/comJS.js"></script>
    <script type="text/javascript" src="../scripts/MajorScript1.js"></script>
    <link href="../../../../../css/Sample3.css" rel="stylesheet" media="screen"/>
  </head>
  <body class="table"><form name="MajorForm" id="MajorForm">
      <p>
        &nbsp;
      </p>
      
      <table cellspacing="3" cellpadding="2" border="1" width="75%" align="center">
        <tr>
          <td colspan="2" class="tdH">
            <div align="center">
              <strong>Major  System Details</strong>
            </div></td>
        </tr>
        <tr>
          <td width="39%" class="table">Major System Id</td>
          <td width="61%" class="table">
          <input type="text" name="txtMajorID" id="txtMajorID"  style="TEXT-TRANSFORM:UPPERCASE" onchange="return toCheckNumeric1()" onblur="callServer('Load','null')" />
          <input type="HIDDEN" name="htxtMajorID" id="htxtMajorID"/>
          </td>
        </tr>
        <tr>
          <td width="39%" class="table">Major System Description</td>
          <td width="61%" class="table">
            <input type="text" name="txtMajorDesc" id="txtMajorDesc" size="85" onchange="return toCheckNumeric2()"/>
          </td>
        </tr>
        <tr>
          <td width="39%" class="table">Major System Short Description</td>
          <td width="61%" class="table">
            <input type="text" name="txtMajorSDesc" id="txtMajorSDesc" size="85" onchange="return toCheckNumeric3()"/>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="table" id="add" style="display:block">
            <input type="button" name="CmdAdd" value="SAVE" id="CmdAdd" onclick="checkForRedundancy()"/>
            <input type="button" name="CmdClear" value="CLEAR ALL"
                   id="CmdClear" onclick="clearAll()"/>
                   <input type="button" name="CmdExit" value="EXIT"
                   id="CmdExit" onclick="Exit()" align="middle"/>
           </td>
           <td colspan="2" class="table" id="update" style="display:none">
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
      </table>
      <p>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Existing Details:
      </p>
      
      <table id="Existing" cellspacing="2" cellpadding="3" border="1" width="75%" align="center">
        <tr class="tdH">
          <th>
            View
          </th>
          <th>
            Major System Id
          </th>
          <th>
            Major System Desc
          </th>
          <th>
            Major System Short Desc
          </th>
          <tbody id="tblList" name="tblList" class="table"> </tbody>
        </tr>
      </table>
      <p>
        &nbsp;
      </p>
    </form></body>
</html>