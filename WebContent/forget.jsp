<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
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
   <%@ page session="true" %>
   <%
   String message = "";
   if (null != session.getAttribute("message")){
		message = (String)session.getAttribute("message");
	 	session.removeAttribute("message");
	 	
	 }
   %>
<!DOCTYPE html>
<html>
	<head>
		<title>Wealth Pakistan</title>
		<link rel="shortcut icon" href="images/logo.png">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/div_slide.css" />
		<style>
		.form-style-2 label > span {
    		width: 130px;
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
						<img src='images/logo.png' alt='Waelth Pakistan' title='Wealth Pakistan'>
					</a>
				</div><!-- logo -->
				<div class='top_navigation'>
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="search/index.jsp">Search</a></li>
						<li><a href="agent/index.jsp">Agent</a></li>
						<li><a href="wanted.jsp">Wanted</a></li>
						<li><a href="about.jsp">About Us</a></li>
					</ul>
				</div><!-- top navigation -->
				<%
				if(session.getAttribute("user") != null){%>
				<div class='welcome_logout' style='margin-bottom: -62pt;'>
				<div class='text_welcome_logout'>
						<div class='upper_text_welcome_logout'>Welcome <%=WelcomeName.ViewNamejsp(user) %></div>
						<div class='lower_text_welcome_logout'><a href="panel/index.jsp"  style='color: #E1E2E3;text-shadow: 0px 0px 3px #D2EBFA;float:left;margin-right:2pt;'>Dashbord</a>  <form action='LogoutPath' method='post' style='float:left;margin-top: -2pt;'>|<input type='submit' style='cursor:pointer;background:none;border:none;color: #E1E2E3;text-shadow: 0px 0px 3px #D2EBFA;' value='Logout' ></form></div>
					</div>
				<div class='banner_welcome_logout' style=' margin-top: -6pt;'><%=BannerManagementJsp.ViewBannerHomeJsp(email) %></div>
			</div>
				
				<%}else{%>
				<div class='login_signup'>
					<a href="login.jsp">
						<div class='button'>
							<!-- <img src="images/login/user.png"> -->
							login
						</div><!-- login  -->
					</a>
					<span class='bar'>|</span>
					<a href="signup.jsp">
						<div class='button'>
							<!-- <img src="images/login/user.png"> -->
							signup
						</div><!-- signup -->
					</a>
				</div><!-- login signup -->
				<%} %>
			</div><!-- header -->
		</div><!-- header container -->
		<div class='container' style='height:400pt;'>
			<div class='login_area' style='height:400pt;'>
				<%=message %>
				<div class='login' style='margin-top:100pt;'>
					<div class="form-style-2">
					<form action='ForgetPasswordPath' method='post' name='forget' style='margin-left: -35pt;'>
						<table>
							<col width="80">
							<tr>
								<td  style="vertical-align:top;" colspan='2'>
									<center><div class="form-style-2-heading">Recover Lost Account</div></center><br>
								</td>
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field1"><span>Email <span class="required">*</span></span></td>
								<td  style="vertical-align:top"><input type='email' name='email' class="input-field" required placeholder='user@domain.com'></label><br><br></td>
							</tr>
							<tr>
								<td colspan='2'><center><input type='submit' class="myButton" value='Request'></center></td>
							</tr>
						</table>
					</form>
					</div><!-- form-style-2 -->
				</div>
				
			</div>
			
		</div><!-- container -->
		<%=AccountManagementJsp.Footer() %>
		
  </body>
</html>