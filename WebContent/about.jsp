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
						<li ><a href="wanted.jsp">Wanted</a></li>
						<li style='text-shadow: none;color:#e5e7ea;'>About Us</li>
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
		<div class='container' style='height:550px; margin-top:10pt;' >

			<div class="info">
				<p>
					<u><b>WHAT IS WPPS.COM?</b></u><br><br>
We find that we're being asked this question less and less as time goes on, and we attribute that to the fact that WPPS.com has become a household name. Nevertheless, if by some strange and unfortunate twist of fate you are still unaware of what WPPS.com is, let us enlighten you.<br>
WPPS.com is Pakistan's leading real estate portal. We connect buyers with sellers and owners with renters across the country, and we do a darn fine job of it, if we may say so ourselves. We are quickly becoming a central online hub for all things real estate in the country, one that everyone can use with ease and get value out of-be it a university student renting a room or a property investor looking for a new project to buy into.<br>
In WPPS admin will be able to post ad(s) and also help him in his general routine work and able him to do all necessary tasks of daily life in property arena like sale, purchase and rent out property of clients and also provide him facility to register further agents and these agents works under the supervision of admin. These agents post their ad(s) on the behalf of wealth estate Pakistan. Admin manage registered agents and posting of ad(s) etc.<br>
Behind WPPS.com is a team of two dedicated and talented individuals <a href="https://www.facebook.com/umair.ansari.1004?fref=ts">Umair</a> and <a href="https://www.facebook.com/hashhem.dar">Hashim</a> with a lot of experience in creating easy-to-use platforms for all manner of online transactions.<br>
We bring to our users only the most innovative and useful of features - as evidenced by our extensive and still-growing Maps Section and in-sha-ALLAH in future Urdu version of our website - and we love working off of our users' feedback to ensure the perfect product.<br><br>
<u><b>HOW WE STARTED OUT</b></u><br><br>
WPPS.com is developed by two students as their final year project of bachelors degree by co-ordinated with yasir Ali warraich(owner of wealth Estate Pakistan).<br>
Riding that wave of success, in-sha-ALLAH in future we are planning the Urdu version of our website, launched our mobile website, and started publishing a dedicated monthly property magazine. The WPPS App will be available for download on the App Store soon.<br><br>
<b><u>OUR CORE PRINCIPLES</u></b><br><br>
One should not have to motor around the entire town, sweating under the fierce sun of our beautiful country, to find the right bit of property.<br>
Essential real estate information should be available to everyone at the click of a button, in their preferred language.
Certified professionals make everything considerably easier for all involved.
Having fun.
				</p>
			</div><!--info-->
		</div><!-- container -->
		<%=AccountManagementJsp.Footer() %>		
  </body>
</html>