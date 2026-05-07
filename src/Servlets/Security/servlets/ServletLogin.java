package Servlets.Security.servlets;



//import Servlets.HR.HR1.EmployeeMaster.Model.LoadDriver;
import Servlets.Security.classes.MajorSystems;
import Servlets.Security.classes.MinorSystems;
import Servlets.Security.classes.UserProfile;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
	ServletConfig config = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config = this.config;

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in Get Method");
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		} else {
			String sessionid = request.getParameter("session");

			if (sessionid.equals(session.getId())) {
				doPost(request, response);
			}
		}
		System.out.println("End of Get method...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PreparedStatement ps = null;
		Statement state = null;
		boolean loginflag = false;
		Connection connection = null;
		ResultSet results = null;
		PreparedStatement statement = null;
		HttpSession session = null;
		int empid = 0;
		String status = "";
		String Remote_host = "";
		String sess_id = "";

		boolean flag_chk = true;
		response.setContentType(CONTENT_TYPE);
		System.out.println("querry string :::in servlet log::::::::"
				+ request.getQueryString());
		PrintWriter pw = response.getWriter();

		
		try {
			 LoadDriver driver=new LoadDriver();
		    	connection=driver.getConnection();
		} catch (Exception e) {
			System.out.println("Connection e" + e);
		}

		try {
			flag_chk = request.isRequestedSessionIdFromCookie();
			System.out.println("from cookie : " + flag_chk);
			// Getting Remote host IP
			Remote_host = request.getRemoteHost();
			System.out.println("Remote Host is :" + Remote_host);
			session = request.getSession(false);
			System.out.println("::Session:: " + session);
			if (session != null) {

				String sessionid = request.getParameter("session");
				System.out.println("session id:" + session.getId());
				empid = Integer.parseInt(request.getParameter("empid"));
				status = request.getParameter("status");
				System.out.println("empid:---------" + empid);
				System.out.println("status:---------" + status);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// checking for authentication
		try {
			try {
				session = request.getSession(false);
				// session.setMaxInactiveInterval(60);
				System.out.println("session id:" + session.getId());
				System.out.println("check for new session isnew::::::"
						+ session.isNew());
				System.out.println("Request value:"
						+ request.getParameter("empid"));
				System.out.println("ses parameter :"
						+ request.getParameter("session"));
				if (session == null) {
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
					return;
				}
				if (!session.isNew()) {

					if (session.getAttribute("UserProfile") == null) {
						session.invalidate();
						session = null;
						System.out.println(request.getContextPath()
								+ "/index.jsp");
						response.sendRedirect(request.getContextPath()
								+ "/index.jsp");
					}
				}

				try {
					try {
						{

							try // load employee profile
							{

								sess_id = session.getId();
								System.out
										.println("------------------- session object created in SERVLET LOGIN.Session Id is  :"
												+ sess_id);
								UserProfile up = null;
								try {
									up = (UserProfile) session
											.getAttribute("UserProfile");
									try {
										ArrayList sys = new ArrayList();

										String profile = (String) session
												.getAttribute("profile");

										String sqlGetRoleId = "";

										if (profile.equalsIgnoreCase("twad")) {
											sqlGetRoleId = "select Role_Id from SEC_MST_USER_ROLES where Employee_Id=? order by List_Seq_No";
											System.out.println("query : "
													+ sqlGetRoleId);
											ps = connection
													.prepareStatement(sqlGetRoleId);
											ps.setInt(1, up.getEmployeeId());
										} else {
											String userid = (String) session
													.getAttribute("UserId");
											sqlGetRoleId = "select Role_Id from SEC_MST_OTHER_USER_ROLES where USER_ID=? order by List_Seq_No";
											System.out.println("query : "
													+ sqlGetRoleId);
											ps = connection
													.prepareStatement(sqlGetRoleId);
											ps.setString(1, userid);
										}

										/**
										 * Set ContextPath
										 */
										/*
										 * try { String
										 * userid=(String)session.getAttribute
										 * ("UserId"); String s =
										 * getServletConfig
										 * ().getServletContext()
										 * .getRealPath("");System.out.println(
										 * "kv-->bfr context path set -> "+s);
										 * ContextPath cp = new ContextPath();
										 * cp.push(s, userid); } catch
										 * (Exception e) {System.out.println(
										 * "KV-->Context Path not set-->Error");
										 * }
										 */

										System.out
												.println("kv--> Context path set successfully.");

										results = ps.executeQuery();
										ArrayList roles = new ArrayList();
										while (results.next()) // Role exsist
										{
											Integer ii = new Integer(results
													.getInt("Role_Id"));

											roles.add(ii);

											if (results.getInt("Role_Id") == 9)
												session.setAttribute("Admin",
														"YES");
											if (results.getInt("Role_Id") == 7)
												session.setAttribute("FAS_SU",
														"YES");

											if (results.getInt("Role_Id") == 98)
												session.setAttribute(
														"FAS_SU_REGION", "YES");

											if (results.getInt("Role_Id") == 99)
												session.setAttribute(
														"FAS_SU_CIRCLE", "YES");

											if (results.getInt("Role_Id") == 97)
												session.setAttribute(
														"FAS_SU_ALL", "YES");

											if (results.getInt("Role_Id") == 96)
												session.setAttribute("FAS_CAO",
														"YES");

										}
										results.close();
										ps.close();
										if (roles.isEmpty()) {
											// System.out.println("No roles assigned");
										} else {
											System.out.println("Role Size:"
													+ roles.size());
											for (int j = 0; j <= roles.size() - 1; j++) {
												Integer rl = (Integer) roles
														.get(j);
												// System.out.println(" roles assigned : "
												// + rl.intValue());
												try {
													String MajorSystems = "select distinct(Major_System_Id) from SEC_MST_ROLE_MENUS where Role_Id=?";
													// System.out.println("query : "
													// + MajorSystems);
													ps = connection
															.prepareStatement(MajorSystems);
													ps.setInt(1, rl.intValue());
													results = ps.executeQuery();
													while (results.next()) {

														String tempID = results
																.getString("Major_System_Id");
														System.out
																.println(tempID);
														boolean alreadythere = false;
														System.out
																.println("sys size:"
																		+ sys
																				.size());
														for (int j3 = 0; j3 < sys
																.size(); j3++) {
															MajorSystems maj = (MajorSystems) sys
																	.get(j3);
															if (maj.Major_System_Id
																	.equals(tempID)) {
																alreadythere = true;
																break;
															}
														}
														if (!alreadythere) {
															MajorSystems ms = new MajorSystems();
															ms.Major_System_Id = tempID;
															sys.add(ms);
														}

														/*
														 * MajorSystems ms=new
														 * MajorSystems();
														 * ms.Major_System_Id
														 * =tempID; sys.add(ms);
														 */

													}
													results.close();
													ps.close();
													for (int j2 = 0; j2 < sys
															.size(); j2++) {
														MajorSystems ms = (MajorSystems) sys
																.get(j2);
														String MajorSystemDesc = "select Major_System_Short_Desc from SEC_MST_MAJOR_SYSTEMS where Major_System_Id=?";
														ps = connection
																.prepareStatement(MajorSystemDesc);
														ps
																.setString(
																		1,
																		ms.Major_System_Id);
														results = ps
																.executeQuery();
														while (results.next()) {
															ms.Major_System_Desc = results
																	.getString("Major_System_Short_Desc");
															// System.out.println(" major system ID : "
															// +
															// ms.Major_System_Id
															// );
															// System.out.println(" major system Desc : "
															// +
															// ms.Major_System_Desc
															// );
														}
														results.close();
														ps.close();
														// ********* getting
														// minor systems

														try {
															String MinorSystems = "select distinct(Minor_System_Id) from SEC_MST_ROLE_MENUS where Role_Id=? and Major_System_Id=?";
															// System.out.println("query : "
															// + MinorSystems);
															ps = connection
																	.prepareStatement(MinorSystems);
															ps
																	.setInt(
																			1,
																			rl
																					.intValue());
															ps
																	.setString(
																			2,
																			ms.Major_System_Id);
															results = ps
																	.executeQuery();
															while (results
																	.next()) {
																String tempID = results
																		.getString("Minor_System_Id");
																boolean alreadythere = false;
																/*
																 * for(int
																 * j3=0;j3
																 * <ms.SubSystems
																 * .size();j3++)
																 * {
																 * MinorSystems
																 * mins
																 * =(MinorSystems
																 * )
																 * ms.SubSystems
																 * .get(j3);
																 * if(mins
																 * .Minor_System_Id
																 * .
																 * equals(tempID
																 * )) {
																 * alreadythere
																 * =true; break;
																 * } }
																 * if(!alreadythere
																 * ) {
																 * MinorSystems
																 * mins=new
																 * MinorSystems
																 * ();mins.
																 * Minor_System_Id
																 * =tempID;
																 * mins.
																 * Role=rl.intValue
																 * ();
																 * ms.SubSystems
																 * .add(mins); }
																 */
																MinorSystems mins = new MinorSystems();
																mins.Minor_System_Id = tempID;
																mins.Role = rl
																		.intValue();
																ms.SubSystems
																		.add(mins);
															}
															results.close();
															ps.close();
															for (int j3 = 0; j3 < ms.SubSystems
																	.size(); j3++) {
																MinorSystems mins = (MinorSystems) ms.SubSystems
																		.get(j3);
																String MinorSystemDesc = "select Minor_System_Short_Desc from SEC_MST_MINOR_SYSTEMS where Major_System_Id=? and Minor_System_Id=?";
																ps = connection
																		.prepareStatement(MinorSystemDesc);
																ps
																		.setString(
																				1,
																				ms.Major_System_Id);
																ps
																		.setString(
																				2,
																				mins.Minor_System_Id);
																results = ps
																		.executeQuery();
																if (results
																		.next()) {
																	mins.Minor_System_Desc = results
																			.getString("Minor_System_Short_Desc");
																	// System.out.println(" minor system ID : "
																	// +
																	// mins.Minor_System_Id
																	// );
																	// System.out.println(" minor system Desc : "
																	// +
																	// mins.Minor_System_Desc
																	// );
																}
																results.close();
																ps.close();
															}

														} catch (Exception e) {
															// error while
															// reading major
															// systems
															System.out
																	.println("error while reading minor systems"
																			+ e);
															return;
														}

														// minor systems ends
													}
												} catch (Exception e) {
													// error while reading major
													// systems
													System.out
															.println("error while reading major systems"
																	+ e);

													return;
												}
											}

											// *********create tab and
											// subsystems automatically
											pw
													.print("<html><head><meta http-equiv='Content-Type' content='text/html; charset=windows-1252'>");
											// pw.print("<meta http-equiv='cache-control' content='no-cache'>");

											pw
													.print("<title>Twad Board Intranet Services</title>");
											pw
													.print("<script language='javascript' src='org/Security/scripts/intimation.js'></script>");

											pw
													.print("<script type='text/javascript' src='org/Security/scripts/jquery-1.js'></script>");
											pw
													.print("<script type='text/javascript' src='org/Security/scripts/jquery.js'></script>");
											pw
													.print("<script type='text/javascript' src='org/Security/scripts/jquery-impromptu.js'></script>");
											pw
													.print("<script type='text/javascript' src='org/Security/scripts/common.js'></script>");

											pw
													.print("<script language='javascript' src='org/Security/scripts/twadNew.js'></script>");
											pw
													.print("<script language='javascript' src='org/Security/scripts/tabpane.js'></script>");

											// coding for status bar
											// scrolling(including the js file)
											// --------------------
											pw
													.print("<script type='text/javascript' src='org/Security/scripts/StatusBarScrollText.js'></script>");
											// --------------------

											pw
													.print("<script language='javascript'>function call(url){");
											pw
													.print("var ifa=document.getElementsByTagName('iframe')[0];ifa.src=url;}");
											pw.print("</script>");

											System.out
													.println("user_ password status :"
															+ status);
											if (status.equalsIgnoreCase("1")) {
												System.out
														.println("it is set to 1");
												pw
														.print("<script language='javascript'>loadPageInNewWindow('"
																+ request
																		.getContextPath()
																+ "/org/HR/HR1/EmployeeMaster/jsps/ChangePasswordJSP.jsp"
																+ "');</script>");
											}
											String s = request.getContextPath();
											pw
													.print("<link href='css/index.css' rel='stylesheet' media='screen'/>");
											pw
													.print("<link href='css/doubletab2.css' rel='stylesheet' media='screen'/>");
											pw
													.print("<link rel='stylesheet' media='screen' type='text/css' href='css/examples.css'>");
											pw
													.print("</head><body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0' OnLoad=\"tmx1a=window.setTimeout('scroll_status(100)',50);intimate('"
															+ s + "');\" >");
											pw
													.print("<table cellspacing='0' border='0' width='100%'>");

											pw
													.print("<tr  height='89' style='background:images/top_sub_banner.jpg'><td height='89' background='images/top_sub_banner.jpg' colspan=3 align='right'><div><table border='0'><tr style=\"color:'#ffffff'\"><td ><div id='divpre' onclick=\"loadPageInNewWindow('"
															+ request
																	.getContextPath()
															+ "/org/HR/HR1/EmployeeMaster/jsps/EmployeeOptionJSP.jsp')\" align='right' onmouseover=\"this.style.cursor='pointer';this.style.color='#000000';divpre.style.background='#cfdee1';\" onmouseout=\"this.style.cursor='default';this.style.color='#ffffff'; this.style.background='#006D8A'\"> <a>Preferences</a> </div></td><td >&nbsp;</td><td><!--<div id='divhelp' onclick=\"loadPage('Helpindex.jsp')\" align='right' onmouseover=\"this.style.cursor='pointer';this.style.color='#000000';divhelp.style.background='#cfdee1';\" onmouseout=\"this.style.cursor='default';this.style.color='#000000';divhelp.style.background='#ffffff';\"><a> Help</a> </div>--></td>");
											pw
													.print("<td>&nbsp;</td><td ><div id='divlogout' onclick=loadPage('Logout.jsp') align='right' onmouseover=\"this.style.cursor='pointer';this.style.color='#000000';divlogout.style.background='#cfdee1';\" onmouseout=\"this.style.cursor='default';this.style.color='#ffffff';this.style.background='#006D8A'\"><a>Logout</a> </div></td></tr><tr></tr></div></td>");
											pw
													.print("<table  align='right' cellspacing=0 cellpadding=0><tr><td></td></tr><tr><td>        </td></tr></table>");

											// pw.print("<table align='right'><tr><td></td></tr><tr><td><div class='activeUsers'><a ></a><div></td><td><div class='activeUsers'>"+"</div></td></tr></table>");

											pw.print("</tr>");
											pw.print("<tr>");

											/*
											 * pw.print("<tr><td> <table cellpadding='0' cellspacing='0' border='0'><tr><td  align='left' rowspan='3'><img src='images\\twad_logo2.gif'></img></td> <td align='right'><img src=\"images\\twadhead.gif\"></img></td></tr><tr><td  align='right'><img src=\"images\\twadanimat.gif\"></img></td> </tr><tr><td>&nbsp;</td></tr></table></td>"
											 * );pw.print(
											 * "<td colspan=2 align='right'><div><table><tr><td>&nbsp</td></tr><tr><td ><div id='divpre' onclick=\"loadPageInNewWindow('"
											 * +request.getContextPath()+
											 * "/org/HR/HR1/EmployeeMaster/jsps/EmployeeOptionJSP.jsp')\" align='right' onmouseover=\"this.style.cursor='hand';this.style.color='#000000';divpre.style.background='#cfdee1';\" onmouseout=\"this.style.cursor='default';this.style.color='#000000';divpre.style.background='#ffffff';\"> <a>Preferences</a> </div></td><td >&nbsp;</td><td><!--<div id='divhelp' onclick=\"loadPage('Helpindex.jsp')\" align='right' onmouseover=\"this.style.cursor='hand';this.style.color='#000000';divhelp.style.background='#cfdee1';\" onmouseout=\"this.style.cursor='default';this.style.color='#000000';divhelp.style.background='#ffffff';\"><a> Help</a> </div>--></td>"
											 * );pw.print(
											 * "<td>&nbsp;</td><td><div id='divlogout' onclick=loadPage('Logout.jsp') align='right' onmouseover=\"this.style.cursor='hand';this.style.color='#000000';divlogout.style.background='#cfdee1';\" onmouseout=\"this.style.cursor='default';this.style.color='#000000';divlogout.style.background='#ffffff';\"><a>Logout</a> </div></td></tr><tr></tr></div></td>"
											 * );pw.print(
											 * "<table align='right' cellspacing=0 cellpadding=0><tr><td></td></tr><tr><td>       <!--    <div class='activeUsers'><a >Active Users : </a><div></td><td><div class='activeUsers'>"
											 * +
											 * getServletContext().getAttribute(
											 * "activecount")+
											 * "</div>   -->      </td></tr></table>"
											 * );
											 * 
											 * //pw.print(
											 * "<table align='right'><tr><td></td></tr><tr><td><div class='activeUsers'><a ></a><div></td><td><div class='activeUsers'>"
											 * +"</div></td></tr></table>");
											 * 
											 * pw.print("</tr>");
											 * pw.print("<tr class='ProfileBand'>"
											 * );
											 */

											pw
													.print(createProfileBar(up)
															+ "</tr><tr><td colspan=3>");
											pw
													.print("<table cellspacing='0' width='100%'><tr> <td width='100%'>");
											pw
													.print("<div class='tab-pane' id='tab-pane-1'>");

											String defaultPage = "userWelcome.jsp";

											for (int t1 = 0; t1 < sys.size(); t1++) {

												MajorSystems mjr = (MajorSystems) sys
														.get(t1);
												// System.out.println("Major System : "
												// + mjr.Major_System_Desc);
												pw
														.print("<div class='tab-page'>");
												pw.print("<h2 class='tab'>"
														+ mjr.Major_System_Desc
														+ "</h2><div>");
												ArrayList al = new ArrayList();
												ArrayList major = new ArrayList();
												ArrayList minor = new ArrayList();
												ArrayList rollid = new ArrayList();
												ArrayList minordesc = new ArrayList();

												for (int t2 = 0; t2 < mjr.SubSystems
														.size(); t2++) {

													MinorSystems min = (MinorSystems) mjr.SubSystems
															.get(t2);
													System.out
															.println("\t Sub system : "
																	+ min.Minor_System_Desc);

													/*
													 * if(t2==0)pw.print(
													 * "<input type='BUTTON' value='"
													 * + min.Minor_System_Desc +
													 * "' onclick=\"call('MenuGenerator.con?Role="
													 * + min.Role + "&Main=" +
													 * mjr.Major_System_Id +
													 * "&Sub=" +
													 * min.Minor_System_Id +
													 * "')\">"); elsepw.print(
													 * "&nbsp;&nbsp;<input type='BUTTON' value='"
													 * + min.Minor_System_Desc +
													 * "' onclick=\"call('MenuGenerator.con?Role="
													 * + min.Role + "&Main=" +
													 * mjr.Major_System_Id +
													 * "&Sub=" +
													 * min.Minor_System_Id +
													 * "')\">"); if(t1==0 &&
													 * t2==0) {defaultPage=
													 * "MenuGenerator.con?Role="
													 * + min.Role + "&Main=" +
													 * mjr.Major_System_Id +
													 * "&Sub=" +
													 * min.Minor_System_Id ; }
													 */

													/*****************/
													boolean b = false;
													if (minor.size() == 0) {
														minor
																.add(min.Minor_System_Id);
														major
																.add(mjr.Major_System_Id);
														rollid
																.add(String
																		.valueOf(min.Role));
														minordesc
																.add(min.Minor_System_Desc);
														// System.out.println("MenuGenerator.con?Role="
														// +
														// (String)rollid.get(0)
														// + "&Main=" +
														// (String)mjr.Major_System_Id
														// + "&Sub=" +
														// (String)minor.get(t2));
													} else {
														int no = minor.size();
														boolean mm = false;
														for (int k = 0; k < no; k++) {
															String strminor = (String) minor
																	.get(k);
															String strmajor = (String) major
																	.get(k);
															String strminordesc = (String) minordesc
																	.get(k);
															// if(strminor.equalsIgnoreCase(min.Minor_System_Id)
															// &&
															// strmajor.equalsIgnoreCase(mjr.Major_System_Id)
															// )
															if (strminordesc
																	.equalsIgnoreCase(min.Minor_System_Desc)) {
																String rid = (String) rollid
																		.get(k);
																System.out
																		.println("rids ........."
																				+ rid);
																rid += ","
																		+ min.Role;
																rollid
																		.remove(k);
																rollid.add(k,
																		rid);
																// System.out.println("MenuGenerator.con?Role="
																// +
																// (String)rollid.get(t2)
																// + "&Main=" +
																// (String)mjr.Major_System_Id
																// + "&Sub=" +
																// (String)minor.get(t2));
																mm = true;
																break;
															}
														}
														if (!mm) {
															minor
																	.add(min.Minor_System_Id);
															major
																	.add(mjr.Major_System_Id);
															rollid
																	.add(String
																			.valueOf(min.Role));
															minordesc
																	.add(min.Minor_System_Desc);
															// System.out.println("MenuGenerator.con?Role="
															// +
															// (String)rollid.get(t2)
															// + "&Main=" +
															// (String)mjr.Major_System_Id
															// + "&Sub=" +
															// (String)minor.get(t2));
														}
													}
													/*********************/

												}

												/***********/
												for (int t2 = 0; t2 < minor
														.size(); t2++) {
													// System.out.println("MenuGenerator.con?Role="
													// + (String)rollid.get(t2)
													// + "&Main=" +
													// (String)major.get(t2) +
													// "&Sub=" +
													// (String)minor.get(t2));
													if (t2 == 0)
														pw
																.print("<input type='BUTTON' value='"
																		+ (String) minordesc
																				.get(t2)
																		+ "' onclick=\"call('MenuGenerator.con?Role="
																		+ (String) rollid
																				.get(t2)
																		+ "&Main="
																		+ (String) major
																				.get(t2)
																		+ "&Sub="
																		+ (String) minor
																				.get(t2)
																		+ "')\">");
													else
														pw
																.print("&nbsp;&nbsp;<input type='BUTTON' value='"
																		+ (String) minordesc
																				.get(t2)
																		+ "' onclick=\"call('MenuGenerator.con?Role="
																		+ (String) rollid
																				.get(t2)
																		+ "&Main="
																		+ (String) major
																				.get(t2)
																		+ "&Sub="
																		+ (String) minor
																				.get(t2)
																		+ "')\">");
													if (t1 == 0 && t2 == 0) {
														defaultPage = "MenuGenerator.con?Role="
																+ (String) rollid
																		.get(t2)
																+ "&Main="
																+ (String) major
																		.get(t2)
																+ "&Sub="
																+ (String) minor
																		.get(t2);
													}
												}
												/**********/

												pw.print("</div></div>");
											}

											// pw.print("<div class='tab-page'>");
											// pw.print("<h2 class='tab'>Documentation</h2></div>");

											pw.print("</div>");

											pw.print("</td></tr><tr><td>");
											pw
													.print("<iframe id='mydiv' name='menuPane' src='"
															+ defaultPage
															+ "' height='600px' width='100%'>");
											pw.print("</td></tr></table>");

											pw.print("</td></tr></table>");
											// *********tabs creation ends here
											pw.flush();
											// System.out.println("here is ok1");
										}

									} catch (Exception e) {
										System.out
												.println("exception while reading roles : "
														+ e);
									}
									// code to generate main page ends here
									// return;

								}
								// catch(SQLException e)
								catch (Exception e) {
									// session.invalidate();
									System.out.println("Result set : " + e);
								}

							}
							// catch(SQLException e)
							catch (Exception e) {
								session.invalidate();
								pw
										.print("<script>document.location=\"index.jsp?message=yes\";</script>");
							}
						}

					}
					// catch(SQLException e)
					catch (Exception e) {
						session.invalidate();
						pw
								.print("<script>document.location=\"index.jsp?message=yes\";</script>");
					}

				}
				// catch(SQLException e)
				catch (Exception e) {
					session.invalidate();
					pw
							.print("<script>document.location=\"index.jsp?message=yes\";</script>");
				}

			}
			// catch(SQLException e)
			catch (Exception e) {
				System.out.println("in catch1");

				pw
						.print("<script>document.location=\"index.jsp?message=yes\";</script>");
				// System.out.println("Exception in connection:"+e);
			}

		} catch (Exception e) {
			System.out.println("in catch2");
			pw
					.print("<script>document.location=\"index.jsp?message=yes\";</script>");
		}

	}

	private String createProfileBar(UserProfile up) {
		String prf = "";
		prf = "<td><div align='left'>";
		prf = prf
				+ "<b> Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</b> "
				+ up.getEmployeePrefix() + " " + up.getEmpInitial() + "."
				+ up.getEmployeeName() + "</div></td>";
		prf = prf
				+ "<td align='right' ><div align='right'><b>Office Level :</b></td><td align='left' ><div align='left'> "
				+ up.getOfficeLevel() + "</div></td>";
		prf = prf
				+ "</tr><tr class='ProfileBand'><td><div align='left'><b>Designation :</b> "
				+ up.getDesignation() + "</div></td>";
		prf = prf
				+ "<td align='right'><div align='right'><b>Office Name :</b></div></td><td align='left' ><div align='left'>"
				+ up.getOfficeShortName() + "</div></td>";

		return prf;
	}

}