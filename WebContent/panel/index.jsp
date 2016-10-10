<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import= "javax.servlet.http.HttpSession" 
    import = "com.manage_account.umair.Dblayer.AccountManagementDb"
    import = "com.manage_account.umair.Jsp_functions.AccountManagementJsp"
    import = "com.Utility.umair.emailuser"
    import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
     import  = "com.Utility.umair.WelcomeName"
    %>
   <%@ page session="true" %>
   <%
	String user = null;
	if (session.getAttribute("user") == null){
		response.sendRedirect("../index.jsp");
	 }
	else{
		user = (String)session.getAttribute("user");
	}
	String email = emailuser.emailget(user);
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Wealth Pakistan</title>
		<link rel="shortcut icon" href="../images/logo.png">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/div_slide.css" />
	</head>
	<body>

		<div class='header_container'>
			<div class='header'>
				<div class='logo'>
					<a href='../index.jsp'>
						<img src='../images/logo.png' alt='Waelth Pakistan' title='Wealth Pakistan'>
					</a>
				</div><!-- logo -->
				<div class='top_navigation'>
					<ul>
						<li><a href="../index.jsp">Home</a></li>
						<li><a href="../search/index.jsp">Search</a></li>
						<li><a href="../agent/index.jsp">Agent</a></li>
						<li><a href="../wanted.jsp">Wanted</a></li>
						<li><a href="../about.jsp">About Us</a></li>
					</ul>
				</div><!-- top navigation -->
				<div class='welcome_logout'>
					<div class='text_welcome_logout'>
						<div class='upper_text_welcome_logout'>Welcome <%=WelcomeName.ViewNamejsp(user) %></div>
						<div class='lower_text_welcome_logout'><a href="index.jsp"  style='color: #E1E2E3;text-shadow: 0px 0px 3px #D2EBFA;float:left;margin-right:2pt;'>Dashbord</a>  <form action='../LogoutPath' method='post' style='float:left;margin-top: -2pt;'>|<input type='submit' style='background:none;border:none;color: #E1E2E3;text-shadow: 0px 0px 3px #D2EBFA;' value='Logout' ></form></div>
					</div>
					<div class='banner_welcome_logout' style=' margin-top: -6pt;'><%=BannerManagementJsp.ViewBannerJsp(email) %></div>
				</div>
			</div><!-- header -->
		</div><!-- header container -->
		<div class='container' style='height:auto;'>
			<div class='panel'>
				<div class='left' style='height:850pt;'>
					<div class='nav_left'  style='background-color: #E1E2E3;'>
						
							<div class='item_nav_left' style='background-color: #E1E2E3;'>Dashbord</div>
							<div class='icon_nav_left'><span class='dash'></span></div>
						
					</div>
					<div class='nav_left'>
						<a href="profile.jsp">
							<div class='item_nav_left'>Profile</div>
							<div class='icon_nav_left'><span class='profile'></span></div>
						</a>
					</div>
					<div class='nav_left'>
						<a href="new.jsp">
							<div class='item_nav_left' >Post Ad</div>
							<div class='icon_nav_left'><span class='post_ad'></span></div>
						</a>
					</div>
					<div class='nav_left'>
						<a href="ad.jsp">
						<div class='item_nav_left'>Manage Ad</div>
						<div class='icon_nav_left'><span class='manage_ad'></span></div>
						</a>
					</div>
					<div class='nav_left'>
						<a href="bnner.jsp">
						<div class='item_nav_left'>Manage Bannar</div>
						<div class='icon_nav_left'><span class='manage_banner'></span></div>
						</a>
					</div>
					<div class='nav_left'>
						<a href="area.jsp">
						<div class='item_nav_left'>Manage Area</div>
						<div class='icon_nav_left'><span class='manag_area'></span></div>
						</a>
					</div>
					<%
					String role = "Agent";
					role = AccountManagementJsp.Role(user);
					//System.out.print(role);
					if(!role.equals("Agent")) 
					{%>
					<div class='nav_left'>
						<a href="create.jsp">
						<div class='item_nav_left'>Creat Agent</div>
						<div class='icon_nav_left'><span class='creat_agent'></span></div>
						</a>
					</div>
					<div class='nav_left'>
						<a href="request.jsp">
						<div class='item_nav_left'>Agent Requests</div>
						<div class='icon_nav_left'><span class='agent_requests'></span></div>
						</a>
					</div>
					<div class='nav_left'>
						<a href="location.jsp">
						<div class='item_nav_left'>Manage Location</div>
						<div class='icon_nav_left'><span class='manage_location'></span></div>
						</a>
					</div>
					<div class='nav_left'>
						<a href="notification.jsp">
						<div class='item_nav_left'>Notification</div>
						<div class='icon_nav_left'><span class='notification'></span></div>
						</a>
					</div>
					<%} %>
				</div><!-- left -->
				<div class='middle_right'>
					<div class='middle'>
						<div class='title_middle'><h2>Dashbord</h2></div>
						<div class='dash_ad'>
							<table>
								<col width='130'>
								<col width='130'>
								<col width='130'>
								<tr>
									<td style="border-right: 2px solid #E1E2E3;border-bottom: 2px solid #E1E2E3;"><b>Ad's Posted</b></td>
									<td style="border-right: 2px solid #E1E2E3;border-bottom: 2px solid #E1E2E3;"><b>Last Post</b></td>
									<td style="border-bottom: 2px solid #E1E2E3;"><b>Areas</b></td>
								</tr>
								<tr>
									<td style="border-right: 2px solid #E1E2E3;"><%=AccountManagementDb.AdReport(user) %></td>
									<td style="border-right: 2px solid #E1E2E3;"><%=AccountManagementDb.LastReport(user) %></td>
									<td><%=AccountManagementDb.AreaReport(user) %> areas in <%=AccountManagementDb.CityReport(user) %> cities</td>
								</tr>
								<tr>
									<td style="border-right: 2px solid #E1E2E3; text-align: right;"><a href='ad.jsp'>view</a></td>
									<td style="border-right: 2px solid #E1E2E3;"></td>
									<td style="text-align: right;"><a href='area.jsp'>view</a></td>
								</tr>
							</table>
						</div><!-- dash_ad -->
							<% if(!role.equals("Agent")) 
							{%>
						<div class='dash_notification'>
							<table>
									<col width='200'>
									<tr>
										<td style="border-bottom: 2px solid #E1E2E3;"><b>Total Notification</b></td>
									</tr>
									<tr>
										<td><%=AccountManagementDb.NotificationReport() %></td>
										
									</tr>
									<tr>
										<td style=" text-align: right;"><a href='notification.jsp'>view</a></td>
										
									</tr>
								</table>
						</div><!-- dash_notification -->
						<div class='dash_agent'>
							<table>
									<col width='200'>
									<col width='200'>
									<tr>
										<td style="border-right: 2px solid #E1E2E3;border-bottom: 2px solid #E1E2E3;"><b>Agents Created</b></td>
										<td style="border-bottom: 2px solid #E1E2E3;"><b>Verified Agents</b></td>
									</tr>
									<tr>
										<td style="border-right: 2px solid #E1E2E3;"><%=AccountManagementDb.UserReport() %></td>
										<td><%=AccountManagementDb.AgentReport() %></td>
									</tr>
									<tr>
										<td style="border-right: 2px solid #E1E2E3; text-align: right;"><a href='create.jsp'>create</a></td>
										<td></td>
									</tr>
								</table>
						</div>
						<%} %>
					</div><!-- middle -->
					<div class='right'>
						<div class='dash_banner'>
							<%=BannerManagementJsp.ViewBannerJsp2(email) %>
							<a href='bnner.jsp'>manage</a>
						</div>
					</div>
				</div><!-- middle_right -->
			</div>
		</div><!-- container -->
		<%=AccountManagementJsp.AdminFooter() %>
		</body>
</html>