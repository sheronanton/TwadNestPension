/*

 *  This servlet is mainly used for validating the logged-in user details and the necessary details are added in the session
 *  attributes.
 * */

package Servlets.Security.servlets;

import Servlets.Security.classes.UserProfile;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.Date;
import java.util.ResourceBundle;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Servlets.Security.servlets.sha256_injava;

public class UserValidation_chgpass extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
	Connection connection = null;
	int _clientDate = 0, _clientMonth = 0, _clientYear = 0;
	int _serverDate = 0, _serverMonth = 0, _serverYear = 0;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Pragma","no-cache"); 
		response.setDateHeader ("Expires", 0); 
		try {

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
            
            Class.forName(strDriver.trim());
            connection=DriverManager.getConnection(ConnectionString,strdbusername.trim(),strdbpassword.trim());
		} catch (Exception e) {
			 System.out.println("Connection e"+e);
			// RequestDispatcher
			// rd=config.getServletContext().getNamedDispatcher("/index.jsp?message=yes");
			response.sendRedirect("index.jsp?message=dbnill");

			return;
		}
		// System.out.println("---------------------------------User Validation new called-------------------");
		boolean loginflag = false;
		ResultSet results = null;
		PreparedStatement statement = null;
		HttpSession session = null;
		int empid = 0;
		String strID = "";
		String strPassword = "", enterpass = "", captchaval = "";
		String status = "";
		String Remote_host = "";
		ResultSet resultset = null,rs=null;
		java.sql.Date retiredate = null;
		java.sql.Date currentdate = null;
		String passwd[]=new String[2];
        String Password=null;
		try {
			strID = request.getParameterMap().containsKey("txtID")?request.getParameter("txtID"):"#"; 
			strPassword = request.getParameterMap().containsKey("txtword")?request.getParameter("txtword"):"#"; 
			AesCipher aes = new AesCipher();
			strID = aes.decrypt(strID).trim();
				
//			captchaval = request.getParameter("captchaval");
			_clientDate = 0;
			_clientMonth = 0;
			_clientYear = 0;
			_serverDate = 0;
			_serverMonth = 0;
			_serverYear = 0;
			session = request.getSession(false);
			String saltValue = (String) session.getAttribute("saltValue");
           
			 captchaval = request.getParameter("captchaval");
	     	 String captcha = (String)session.getAttribute("captcha");
	     	 
			strID=strID.replaceAll(saltValue, "").trim();
			strPassword=strPassword.replaceAll(saltValue, "").trim();
			System.out.println(strPassword);
			System.out.println(strID);
			enterpass = strPassword;
		    int index = strPassword.indexOf("$");
		    System.out.println("index------>"+index);
		    
		    passwd[0]= strPassword.substring(0,64);
		    passwd[1]= strPassword.substring(65);
			sha256_injava sha256=new sha256_injava();
			newmd5 new_md5=new newmd5();
		//	System.out.println(new_md5.MD5("test"));
//			_clientDate = Integer.parseInt(request.getParameter("clientDay"));
//			_clientMonth = Integer.parseInt(request.getParameter("clientMonth"));
//			_clientYear = Integer.parseInt(request.getParameter("clientYear"));
			
			
			System.out.println(session);
//			String captcha = (String) session.getAttribute("captcha");
			//
//			System.out.println("captcha " + captcha);
//			System.out.println("captchaval " + captchaval);

//			String qry = "SELECT EXTRACT(DAY FROM SYSDATE) AS SERVERDATE,EXTRACT(MONTH FROM SYSDATE) AS SERVERMONTH,EXTRACT(YEAR FROM SYSDATE) AS SERVERYEAR FROM DUAL";
//			PreparedStatement pst = connection.prepareStatement(qry);
//			ResultSet rst = pst.executeQuery();
//			if (rst.next()) {
//				_serverDate = rst.getInt("SERVERDATE");
//				_serverMonth = rst.getInt("SERVERMONTH");
//				_serverYear = rst.getInt("SERVERYEAR");
//			}

		
//			Cookie[] cookies = request.getCookies();
//	        for(int i = 0; i < cookies.length; i++) {
//	            if (cookies[i].getName().equals("citizen")) {
//	             cookies[i].setMaxAge(0);
//	            response.addCookie(cookies[i]);
//	            }
//	        }
//			if (_clientDate == _serverDate && _clientMonth == _serverMonth					&& _clientYear == _serverYear) {
			 if(captcha.equals(captchaval))
	     	 {	
				Remote_host = request.getRemoteHost();
				
				String path = "";

				PrintWriter pw = response.getWriter();
				request.getSession().invalidate();
				session = null;
				String pass="";
				 String   md5="";
				if (session == null) {
					if (strID != null && strPassword != null) {
						System.out.println("before try-------->");
						try {
							System.out.println("after-------->");
							String sql1="";
							sql1 = "select * from SEC_MST_USERS where USER_ID=? ";
							statement = connection.prepareStatement(sql1);
							statement.setString(1, strID);
						
                            
							results = statement.executeQuery();
							if(results.next())
							{
								
								sql1 = "select * from SEC_MST_USERS where USER_ID=? and NEW_PASSWORD is not null ";
								statement = connection.prepareStatement(sql1);
								statement.setString(1, strID);
							
	                            
								rs = statement.executeQuery(); 
								if(rs.next())
								{
								pass=results.getString("NEW_PASSWORD");
								System.out.println("new_pass-------->"+pass.length());
							        if(pass.length()>0||!pass.equals(null)||!pass.equals("null"))
							        {
									pass=pass.toLowerCase()+saltValue;
									System.out.println("DB pass+salt-------->"+pass);
								    Password =sha256.getSHA256Hash(pass);
							        }
							        else
							        	{System.out.println("No new password");
							        	
							        	Password="nopwd";	
							        	}
								
								}
								else
								{Password="nopwd";
									pass=results.getString("USER_PASSWORD");
								pass=pass+saltValue;
								System.out.println("pass--------->"+pass);
								strPassword=new_md5.MD5(pass);
								md5=strPassword;
								System.out.println("pass--------->"+md5);
							/*	byte b[]=pass.getBytes();
								MessageDigest algorithm = MessageDigest
										.getInstance("MD5");
								algorithm.reset();
								algorithm.update(b);
					
							       
							           md5 = new BigInteger(1, algorithm.digest()).toString(16);

								System.out.println(md5);*/

								//strPassword = new String(md5);
								}

							}
							
						} catch (Exception nsae) {
							System.out.println("exception in calc block in user validation--------->"+nsae);

						}

						
						
						
						try {

							String sql = null;
							System.out.println("before");
							for(int i=0;i<passwd.length;i++)
							{
								System.out.println("passwd00000000  "+passwd[i]);
							}
							System.out.println("psw 1----->"+passwd[1]);
							System.out.println("psw 0----->"+passwd[0]);
							System.out.println("md5-------->"+md5);
							System.out.println(" "+Password);
                            if(!md5.equalsIgnoreCase(passwd[1]) && !Password.equalsIgnoreCase(passwd[0]))
                            {
                           	 System.out.println("doesnt match");
                         	 response.sendRedirect("index.jsp?message=yes");
                           	 return;
							}

                             else
                             {
							sql = "select Employee_Id,CHANGE_PASSWORD,USER_CATEGORY_ID,LOGIN_ENABLED  from SEC_MST_USERS where USER_ID=? ";
							statement = connection.prepareStatement(sql);
							statement.setString(1, strID);
							//statement.setString(2, md5);

							results = statement.executeQuery();

							if (results.next()) // login was successful
							{
								 System.out.println("login success");

								String active = results
										.getString("LOGIN_ENABLED");
								if (active == null
										|| active.equalsIgnoreCase("0")) {
									response.sendRedirect("index.jsp?message=logindisabled");
									return;
								}

								loginflag = true;
								empid = results.getInt("Employee_Id");
								status = results.getString("CHANGE_PASSWORD");
								 System.out.println("status of pass change:"+status);
								int categoryid = 1;
								try {
									categoryid = results
											.getInt("USER_CATEGORY_ID");
								} catch (Exception e) {
									 System.out.println("Error in category id:"+e);
								}

								results.close();
								statement.close();

								// System.out.println("Login part is ok");

								UserProfile up = null;
								ResultSet profile = null;

								if (categoryid == 1) {
									sql = "SELECT a.EMPLOYEE_ID, " +
											"  a.EMPLOYEE_INITIAL, " +
											"  a.EMPLOYEE_NAME , " +
											"  a.EMPLOYEE_PREFIX , " +
											"  office_name AS OFFICE_SHORT_NAME, " +
											"  c.OFFICE_ADDRESS1 " +
											"  ||',' " +
											"  ||c.OFFICE_ADDRESS2 " +
											"  ||',' " +
											"  ||c.CITY_TOWN_NAME OFFICE_ADDRESS, " +
											"  d.DESIGNATION , " +
											"  COALESCE(e.OFFICE_LEVEL_NAME,NULL,'Other Dept',e.OFFICE_LEVEL_NAME) AS OFFICE_LEVEL " +
											"FROM Hrm_Mst_Employees A " +
											"LEFT OUTER JOIN HRM_EMP_CURRENT_POSTING b " +
											"ON a.EMPLOYEE_ID=b.EMPLOYEE_ID " +
											"LEFT OUTER JOIN COM_MST_OFFICES c " +
											"ON c.OFFICE_ID = b.OFFICE_ID " +
											"LEFT OUTER JOIN HRM_MST_DESIGNATIONS d " +
											"ON d.DESIGNATION_ID =b.DESIGNATION_ID " +
											"LEFT OUTER JOIN COM_MST_OFFICE_LEVELS e " +
											"ON e.OFFICE_LEVEL_ID=c.OFFICE_LEVEL_ID " +
											"LEFT OUTER JOIN " +
											"  ( SELECT 'TWAD' AS dept_id, office_id, office_name FROM com_mst_offices " +
											"  UNION " +
											"  SELECT other_dept_id     AS dept_id, " +
											"    other_dept_office_id   AS office_id, " +
											"    other_dept_office_name AS office_name " +
											"  FROM hrm_mst_other_dept_offices " +
											"  ) d1 " +
											"ON B.Department_Id = D1.Dept_Id " +
											"AND b.office_id    = d1.office_id " +
											"WHERE a.employee_id=?";
									statement = connection
											.prepareStatement(sql);
									statement.setInt(1, empid);
									System.out.print("employee id : " + empid);

									try {

										profile = statement.executeQuery();
										// creating user profile object
										if (!profile.next()) {
											response.sendRedirect("index.jsp?message=noprofile");
											return;
										}

										// System.out.println("empid:"+profile.getInt("Employee_Id"));
										up = new UserProfile(
												profile.getInt("Employee_Id"),
												(profile.getString("Employee_Initial") == null) ? ""
														: profile
																.getString("Employee_Initial"),
												profile.getString("Employee_Name"),
												profile.getString("Employee_Prefix"),
												profile.getString("Designation"),
												profile.getString("Office_Level"),
												profile.getString("Office_Short_Name"),
												profile.getString("Office_Address"));
										// System.out.println("Employee sucessfully loaded");
										// System.out.println("Employee Name : "
										// + up.getEmployeeName());

										profile.close();
										statement.close();
										
										session = request.getSession(true);
										// session.setMaxInactiveInterval(5);
										// System.out.println("New session id:"+session.getId());

										sql = "select max(ACCESS_SEQ_NUM)  acc_seq from SEC_MST_USERS_LOGIN_HISTORY";
										PreparedStatement ps = connection
												.prepareStatement(sql);
										ResultSet rset = ps.executeQuery();
										rset.next();
										int accno = rset.getInt("acc_seq");
										if (accno > 0) {
											accno += 1;
										} else {
											accno = 1;
										}

										// System.out.println("Acc No:"+accno);
										sql = "insert into sec_mst_users_login_history(USER_ID,LOGGED_IN_TIME,IP_ADDRESS,SESSION_ID,ACCESS_SEQ_NUM) values(?,?,?,?,?)";
										ps = connection.prepareStatement(sql);
										ps.setString(1, strID);
										java.sql.Date dt = new java.sql.Date(
												System.currentTimeMillis());
										Timestamp tms = new Timestamp(
												System.currentTimeMillis());
										ps.setTimestamp(2, tms);
										ps.setString(3, Remote_host);
										ps.setString(4, session.getId());
										ps.setInt(5, accno);
										ps.executeUpdate();

										session.setAttribute("accno",
												String.valueOf(accno));

										session.setAttribute("UserProfile", up);
										session.setAttribute("UserId", strID);

										// System.out.println("profile from VIEW TWAD");
										session.setAttribute("profile", "twad");
										
										int office = 0;
										StringBuilder sqlQuery = new StringBuilder();
										sqlQuery.append("SELECT A.OFFICE_ID,CAST(B.OFFICE_LEVEL_ID AS VARCHAR2(20)) AS OFFICE_LEVEL_ID, C.CONTROLLING_OFFICE_ID as CONTROLLING_OFFICE_ID");
										sqlQuery.append(" FROM HRM_EMP_CURRENT_POSTING A");
										sqlQuery.append(" INNER JOIN COM_MST_OFFICES_VIEW B ON A.OFFICE_ID=B.OFFICE_ID");
										sqlQuery.append(" LEFT JOIN COM_MST_SUBDIVISIONS C ON C.SUBDIVISION_OFFICE_ID=A.OFFICE_ID");
										sqlQuery.append(" WHERE A.EMPLOYEE_ID="	+ up.getEmployeeId()+ " AND B.OFFICE_LEVEL_ID IN('HO','RN','CL','DN','SD','AW')");

										System.out.println("\nTWAD user login :::: "+ sqlQuery.toString());
										ps = connection.prepareStatement(sqlQuery.toString());
										// statement.setInt(1,up.getEmployeeId());
										rset = ps.executeQuery();
										if (rset.next()) {
											// SD for sub division
											if (rset.getString("OFFICE_LEVEL_ID").equalsIgnoreCase("SD")) {
												office = Integer.parseInt(rset.getString("CONTROLLING_OFFICE_ID"));
											}
											// HO,RN and CL
											else {
												office = Integer.parseInt(rset.getString("OFFICE_ID"));
											}
										}
										if (office == 0) {
											System.out.println("office not found...");
											response.sendRedirect("index.jsp?message=otherUsrOffice");
										} else {
											session.setAttribute("LOGIN_OFFICE_ID", office);
										}
										

									} catch (Exception e) {
										 System.out.println(e);
										
										
										System.out.println("error came here....sagar");
										response.sendRedirect("index.jsp?message=noprofile");
										return;
									}

									try {

										
									//	strID = request.getParameterMap().containsKey("txtID")?request.getParameter("txtID"):"#"; 
										 System.out.println("User id is.............."+strID);
										String strempid = strID.substring(4);
										int intempid = Integer
												.parseInt(strempid);
										// System.out.println("sub string of user id is------------------"+strempid);
//										sql = "select retiredate,(select sysdate from dual) as currentdate from allretirementview where employee_id=?";
										sql = "select retiredate, now() as currentdate from allretirementview where employee_id=?";
										statement = connection
												.prepareStatement(sql);
										statement.setInt(1, intempid);
										resultset = statement.executeQuery();
										while (resultset.next()) {
											retiredate = resultset
													.getDate("retiredate");
											currentdate = resultset
													.getDate("currentdate");
											if (currentdate
													.compareTo(retiredate) > 0) {
												// do not allow to login the
												// retired employee
												response.sendRedirect("index.jsp?message=retired");
												return;
											} else {
												// System.out.println("Not a retired employee");
											}

										}
									} catch (Exception e) {
										// System.out.println("Exception in retirement date verifications ");
									}
								} else {

									// sql="select SEC_MST_OTHER_USERS_PROFILE.* from SEC_MST_OTHER_USERS_PROFILE, where USER_ID=?";
									sql = "select SEC_MST_OTHER_USERS_PROFILE.*,SEC_MST_USER_CATEGORY.USER_CATEGORY_DESC"
											+ " from SEC_MST_OTHER_USERS_PROFILE,SEC_MST_USER_CATEGORY "
											+ " where SEC_MST_OTHER_USERS_PROFILE.USER_ID=? "
											+ " and SEC_MST_USER_CATEGORY.USER_CATEGORY_ID =?";
									statement = connection.prepareStatement(sql);
									statement.setString(1, strID);
									statement.setInt(2, categoryid);
									// System.out.print("employee id : " +
									// empid);

									try {

										profile = statement.executeQuery();
										// creating user profile object
										if (!profile.next()) {
											response.sendRedirect("index.jsp?message=noprofile");
											return;
										}

										// System.out.println("empid:"+profile.getInt("Employee_Id"));
										up = new UserProfile(
												0,
												(profile.getString("USER_INITIAL") == null) ? ""
														: profile.getString("USER_INITIAL"),
												profile.getString("USER_NAME"),
												profile.getString("USER_PREFIX"),
												profile.getString("DESIGNATION"),
												profile.getString("USER_CATEGORY_DESC"),
												profile.getString("OFFICE_NAME"),
												profile.getString("OFFICE_ADDRESS"));
										// System.out.println("Employee sucessfully loaded");
										// System.out.println("Employee Name : "
										// + up.getEmployeeName());

										profile.close();
										statement.close();

										session = request.getSession(true);
										// session.setMaxInactiveInterval(5);
										// System.out.println("New session id:"+session.getId());

										sql = "select max(ACCESS_SEQ_NUM)  acc_seq from SEC_MST_USERS_LOGIN_HISTORY";
										PreparedStatement ps = connection.prepareStatement(sql);
										ResultSet rset = ps.executeQuery();
										rset.next();
										int accno = rset.getInt("acc_seq");
										if (accno > 0) {
											accno += 1;
										} else {
											accno = 1;
										}

										// System.out.println("Acc No:"+accno);
										sql = "insert into sec_mst_users_login_history(USER_ID,LOGGED_IN_TIME,IP_ADDRESS,SESSION_ID,ACCESS_SEQ_NUM) values(?,?,?,?,?)";
										ps = connection.prepareStatement(sql);
										ps.setString(1, strID);
										java.sql.Date dt = new java.sql.Date(
												System.currentTimeMillis());
										Timestamp tms = new Timestamp(
												System.currentTimeMillis());
										ps.setTimestamp(2, tms);
										ps.setString(3, Remote_host);
										ps.setString(4, session.getId());
										ps.setInt(5, accno);
										ps.executeUpdate();

										session.setAttribute("accno",
												String.valueOf(accno));

										session.setAttribute("UserProfile", up);
										session.setAttribute("UserId", strID);

										// System.out.println("profile from SEC_MST_OTHER_USERS_PROFILE");
										session.setAttribute("profile", "other");

									} catch (Exception e) {
										// System.out.println(e);
										response.sendRedirect("index.jsp?message=noprofile");
										return;
									}

								}
                  System.out.println("md5.length()---------------->"+md5.length());
							
								if (strID.equalsIgnoreCase(enterpass)||(md5.length()>0)) {
									path = "/ChangePasswordJSP.jsp?"+TwadUtil.getPath(session.getId().toString());
									//path = response.encodeRedirectURL(path);
									path = response.encodeRedirectURL(path+TwadUtil.getPath(session.getId().toString()));


									try {
										// System.out.println("--------path:"+path);
//										response.sendRedirect(request
//												.getContextPath() + path);

										//request.getRequestDispatcher(path).forward(request, response);
										
										response.sendRedirect(request.getContextPath() + path);
										
										
										// System.out.println("After redirect");

										return;
									} catch (Exception e) {
										// System.out.println("Redirect Error:"+e);
									}
								}
								// path="/menuchecknew.jsp?session="+session.getId()+"&empid="+empid+"&status="+status;
								
//								path = "menuchecknew.jsp?"+TwadUtil.getPath(session.getId().toString());
//								path = response.encodeRedirectURL(path);
								path = "/menuchecknew.jsp?"+ TwadUtil.getPath(session.getId().toString());
								path = response.encodeRedirectURL(request.getContextPath()+path);
							
								try {
									
									
//									request.getRequestDispatcher(path).forward(request, response);
									response.sendRedirect(path);
									return;
									
								} catch (Exception e) {
									// System.out.println("Redirect Error:"+e);}
								}

								

								return;

							} else {
								// System.out.println("Login failure");
								response.sendRedirect(request.getContextPath()
										+ "/index.jsp?message=yes");
								// System.out.println("ok");
								// System.out.println("After Dispatching");
								return;
							}
                             }
						} catch (Exception e) {
							 System.out.println("authentication_error:"+e);
							response.sendRedirect(request.getContextPath()
									+ "/index.jsp?message=dbnill");
							return;
						}
					} else {
						response.sendRedirect(request.getContextPath()
								+ "/index.jsp?message=yes");
						return;

					}
				} else {
					session.invalidate();
					// System.out.println("session is invalidated in uservalidation form");
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
					return;
				}
				
				 }
				 else
				 {
				 response.sendRedirect(request.getContextPath()+"/index.jsp?message=captcha");
				 return;
				 }
//			} else {
//				response.sendRedirect(request.getContextPath()
//						+ "/index.jsp?message=invalidDate");
//				return;
//			}
		} catch (Exception e) {
			// e.printStackTrace();
//			response.sendRedirect(request.getContextPath() + "/index.jsp");
//			return;
		}
	}
}