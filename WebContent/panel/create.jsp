<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
   import="java.io.IOException"
import="javax.servlet.ServletException" 
import="javax.servlet.annotation.WebServlet"
import= "javax.servlet.http.HttpServlet"
import= "javax.servlet.http.HttpServletRequest"
 import= "com.Utility.umair.WelcomeName"
  import = "com.Utility.umair.emailuser"
    import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
      import  = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
     import  = "com.Utility.umair.WelcomeName"%>
	<%@ page import="java.io.*,java.util.*" %>
 <%@ page session="true" %>
	<%
	String result = "";
	if (null != session.getAttribute("message")){
		result = (String)session.getAttribute("message");	
	 session.removeAttribute("message");
	 }
	String user = null;
	if (session.getAttribute("user") == null){
		response.sendRedirect("../index.jsp");
	 }
	else{
		user = (String)session.getAttribute("user");
	}
	String email = emailuser.emailget(user);
	String role = "Agent";
	role = AccountManagementJsp.Role(user);
	if(role.equals("Agent")) {
		response.sendRedirect("index.jsp");
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<title>Wealth Pakistan</title>
		<link rel="shortcut icon" href="../images/logo.png">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/div_slide.css" />
		<style>
			.form-style-2 input.input-field {
   				 width: 100%;
		}
		.form-style-2 label > span {
    		width: 150px;
    		font-weight: bold;
    		float: left;
    		padding-top: 8px;
    		padding-right: 5px;
		}
		</style>
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
					<div class='nav_left'>
						<a href="index.jsp">
							<div class='item_nav_left'>Dashbord</div>
							<div class='icon_nav_left'><span class='dash'></span></div>
						</a>
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
					<div class='nav_left'  style='background-color: #E1E2E3;'>
						
						<div class='item_nav_left' style='background-color: #E1E2E3;'>Creat Agent</div>
						<div class='icon_nav_left'><span class='creat_agent'></span></div>
						
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
				</div><!-- left -->
				<div class='middle_right'>
					<div class='middle' style='width:100%;'>
						<div class='title_middle'><h2>Create Agent</h2></div>
						<div class='dash_ad' style='border:2px solid #E1E2E3;padding:20pt; margin-right:10pt;width:auto;'>
							<div class='title_middle'><h3>Create</h3></div>
							<%=result							
							
							 %>
							 <div class="form-style-2">
							<table>
							<form action='../CreatAgentPath' method='post'>
								<col width='200'>
								<col width='200'>
								<tr>
									<td><label for="field1"><span>Agent Email <span class="required">*</span></span></td>
									<td><input type='email' class="input-field" required name='email'></label></td>
								</tr>
								<tr>
									<td><label for="field1"><span>Temporary Password <span class="required">*</span></span></td>
									<td><input type='text' required class="input-field" name='password' oninvalid="setCustomValidity('must contain 8 to 10 characters that are of at least one number, and one uppercase and lowercase letter')"
    onchange="try{setCustomValidity('')}catch(e){}" /></label></td>
								</tr>

								<tr>
									<td colspan='2'><center><br><input type='submit' value='Creat' class="myButton"></center></td>
								</tr>
							
							</form>
							</table>
							</div>
						</div><!-- dash_ad -->
					</div><!-- middle -->
					<div class='right'>
						
					</div>
				</div><!-- middle_right -->
			</div>
		</div><!-- container -->
		<%=AccountManagementJsp.AdminFooter() %>
		
  </body>
</html>