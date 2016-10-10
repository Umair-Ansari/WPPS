<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import= "javax.servlet.http.HttpSession" 
    import = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
    %>
   <%@ page session="true" %>
	<%
	String message = "";
	if (null != session.getAttribute("message")){
		message = (String)session.getAttribute("message");
	 	session.removeAttribute("message");
	 	
	 }
	else
	{
		response.sendRedirect("index.jsp");
	}	
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Wealth Pakistan</title>
		<link rel="shortcut icon" href="images/logo.png">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/div_slide.css" />
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
			</div><!-- header -->
		</div><!-- header container -->
		<div class='container' style='height:400pt;'>
			<div class='login_area' style='height:400pt'>
			
				<div class='login' style='margin-top:100pt;margin-left:137pt;width:68%;' >
				<%=message %>
				
				</div>
			</div>
			
		</div><!-- container -->
		<%=AccountManagementJsp.Footer() %>
		
  </body>
</html>