<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
     import= "javax.servlet.http.HttpSession" %>
   <%@ page session="true" %>
	<%
		response.sendRedirect("index.jsp");
	
%>
<!DOCTYPE html>
<html>
<head>
	<title>Wealth Pakistan</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class='header_container'>
			<div class='header'>
				<div class='logo'>
					<a href="index.jsp">
						<img src='images/logo.png' alt='Waelth Pakistan' title='Wealth Pakistan'>
					</a>
				</div><!-- logo -->
				<div class='top_navigation'>
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="search/index.jsp">Search</a></li>
						<li><a href="agent/index.jsp">Agent</a></li>
						<li><a href="wanted.jsp">Wanted</a></li>
						<li style='text-shadow: none;color:#e5e7ea;'>Help</li>
						<li><a href="about.jsp">About Us</a></li>
					</ul>
				</div><!-- top navigation -->
				<div class='login_signup'>
					<a href="login.jsp">
						<div class='button'>
							<!-- <img src="images/login/user.png"> -->
							login
						</div><!-- login  -->
					</a>
					<span class='bar'>|</span>
					<a href="login.jsp">
						<div class='button'>
							<!-- <img src="images/login/user.png"> -->
							signup
						</div><!-- signup -->
					</a>
				</div><!-- login signup -->
			</div><!-- header -->
		</div><!-- header container -->
		<div class="container_help">
				<h1 style='color:white;'>SUBMIY &nbsp;&nbsp;YOUR&nbsp;&nbsp; QUERY &nbsp;&nbsp;HERE</h1>
				<div class="form">
					<form>
						<textarea name="help" rows="20" cols="100">
						</textarea><br><br>
					<input type="submit">
					</form>
			</div><!--form-->
		</div><!--container help-->
		<div class='footer_container'>
			<div class='footer'>
				<div class='footer_ul'>
					<div class='footer_ul_list'>
						<ul>
							<li><h4>Company</h4></li>
							<li><a href="#">About Us</a></li>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Work With Us</a></li>
							<li><a href="#">Help & Support</a></li>
							<li><a href="#">Advertise on Waelth Pakistan</a></li>
							<li><a href="#">Terms of Use</a></li>
						</ul>
					</div><!-- footer ul list -->
				</div><!-- footer ul ul -->
				<div class='footer_ul'>
					<li><h4>WPPS.com</h4></li>
					<div class='footer_ul_icons'>
						<span class='adrs'></span><br><br><br>
						<span class='phone'></span>
						<span class='email'></span>
					</div><!-- footer ul icons -->
					<div class='footer_ul_list'>
						<ul>
							
							<li><a href="#">42-A, Block XX,</a></li>
							<li><a href="#">Khayaban-e-Iqbal, Phase III,</a></li>
							<li><a href="#">DHA, Lahore, Pakistan</a></li><br>
							<li><a href="#">(+92) 42 3835 4444</a></li>&nbsp;
							<li><a href="#">Email Us</a></li>
						</ul>
					</div><!-- footer ul list -->
				</div><!-- footer ul -->
				<div class='footer_ul'>
					<li><h4>FOLLOW US</h4></li>
					<div class='footer_ul_icons'>
						<span class='facebook'></span>
						<span class='twitter'></span>
						<span class='google'></span>
						<span class='linkedin'></span>
					</div><!-- footer ul icons -->
					<div class='footer_ul_list'>
						<ul class='space'>
							<li><a href="#">Like us on Facebook</a></li>
							<li><a href="#">Follow us on Twitter</a></li>
							<li><a href="#">Share us on Google+</a></li>
							<li><a href="#">Consult us on Linkedin</a></li>
						</ul>
					</div><!-- footer ul list -->
				</div><!-- footer ul -->
			</div><!-- footer -->
		</div><!-- footer container -->
</body>
</html>