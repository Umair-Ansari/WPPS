<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
   import = "com.manage_ad.hashim.Jsp_functions.AdManagementJSP"
    import= "javax.servlet.http.HttpSession" 
    import = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
     import  = "com.Utility.umair.WelcomeName"
      import = "com.Utility.umair.emailuser"
     import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
    
    %>
   <%
    String user = null;
	if (session.getAttribute("user") == null){
		//response.sendRedirect("../index.jsp");
		
	 }
	else{
		user = (String)session.getAttribute("user");
	}
	String email = emailuser.emailget(user);
    %>
    <%
String code = "";
if (request.getParameter("code") != null){
	code = request.getParameter("code");
}
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
						<li style='text-shadow: none;color:#e5e7ea;'>Agent</li>
						<li><a href="../wanted.jsp">Wanted</a></li>
						<li><a href="../about.jsp">About Us</a></li>
					</ul>
				</div><!-- top navigation -->
				<%
				if(session.getAttribute("user") != null){%>
				<div class='welcome_logout' style='margin-bottom: -62pt;'>
				<div class='text_welcome_logout'>
						<div class='upper_text_welcome_logout'>Welcome <%=WelcomeName.ViewNamejsp(user) %></div>
						<div class='lower_text_welcome_logout'><a href="../panel/index.jsp"  style='color: #E1E2E3;text-shadow: 0px 0px 3px #D2EBFA;float:left;margin-right:2pt;'>Dashbord</a>  <form action='../LogoutPath' method='post' style='float:left;margin-top: -2pt;'>|<input type='submit' style='cursor:pointer;background:none;border:none;color: #E1E2E3;text-shadow: 0px 0px 3px #D2EBFA;' value='Logout' ></form></div>
					</div>
				<div class='banner_welcome_logout' style=' margin-top: -6pt;'><%=BannerManagementJsp.ViewBannerHomeInJsp(email) %></div>
			</div>
				
				<%}else{%>
				<div class='login_signup'>
					<a href="../login.jsp">
						<div class='button'>
							<!-- <img src="images/login/user.png"> -->
							login
						</div><!-- login  -->
					</a>
					<span class='bar'>|</span>
					<a href="../signup.jsp">
						<div class='button'>
							<!-- <img src="images/login/user.png"> -->
							signup
						</div><!-- signup -->
					</a>
				</div><!-- login signup -->
				<%} %>
			</div><!-- header -->
		</div><!-- header container -->
		<div class='container' style='height: 645pt;'>

			<div class='search_area'>
				<img src="../images/agents.jpeg" style='width:100%;height:300pt;'>
				
					<h1 style='color:#800000;'>MEET &nbsp;&nbsp;YOUR&nbsp;&nbsp; PROPERTY &nbsp;&nbsp;AGENT</h1>
					<div class='search_buttons'>
					<center><table style='margin-top:30pt;'>
							<form method='get' action='#'>
								<tr>
									<td colspan='4'>
									<center><input type='text' placeholder="e.g umair" style='width:200pt;height:20pt;'></center><br>
									</td>
								</tr>
								<tr>
									<td colspan='4'>
										<center><input type='submit' value='Search' name='search_buttons' class='search_button'></center>
									</td>
								</tr>
							</form>
					</table>
					</center>
				</div><!-- search_buttons -->
			</div><!-- search_area -->
			<div class='search_result' style='height: 342pt;'>
				<%=BannerManagementJsp.GetUserBanner(code) %>
			</div><!-- search_result -->
		</div><!-- container -->
		<%=AccountManagementJsp.AdminFooter() %>
		
  </body>
</html>