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
		<meta charset="UTF-8" />
		<link rel="shortcut icon" href="images/logo.png">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="Simple Multi-Item Slider: Category slider with CSS animations" />
		<meta name="keywords" content="jquery plugin, item slider, categories, apple slider, css animation" />
		<meta name="author" content="Codrops" />
		<link rel="stylesheet" type="text/css" href="css/div_slide.css" />
		<script src="js/modernizr.custom.63321.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" href="cssslider_files/csss_engine1/style.css">
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
						<li style='text-shadow: none;color:#e5e7ea;'>Home</li>
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
		<div class='container' style='height: 719pt;'>
			<div class='image_area'>
					<div class='csslider1 autoplay '>
					<input name="cs_anchor1" id='cs_slide1_0' type="radio" class='cs_anchor slide' >
					<input name="cs_anchor1" id='cs_slide1_1' type="radio" class='cs_anchor slide' >
					<input name="cs_anchor1" id='cs_slide1_2' type="radio" class='cs_anchor slide' >
					<input name="cs_anchor1" id='cs_slide1_3' type="radio" class='cs_anchor slide' >
					<input name="cs_anchor1" id='cs_play1' type="radio" class='cs_anchor' checked>
					<input name="cs_anchor1" id='cs_pause1_0' type="radio" class='cs_anchor pause'>
					<input name="cs_anchor1" id='cs_pause1_1' type="radio" class='cs_anchor pause'>
					<input name="cs_anchor1" id='cs_pause1_2' type="radio" class='cs_anchor pause'>
					<input name="cs_anchor1" id='cs_pause1_3' type="radio" class='cs_anchor pause'>
					<ul>
						<li class="cs_skeleton"><img src="cssslider_files/csss_images1/001__yicisrg.png" style="width: 100%;"></li>
						<li class='num0 img slide'> <img src='images/slider/1.png' alt='Home' title='Home' /></li>
						<li class='num1 img slide'> <img src='images/slider/2.png' alt='Bangla' title='Bangla' /></li>
						<li class='num2 img slide'> <img src='images/slider/3.png' alt='Makan' title='Makan' /></li>
						<li class='num3 img slide'> <img src='images/slider/4.png' alt='Ghar' title='Ghar' /></li>
					</ul><div class="cs_engine"><a href="http://cssslider.com">jquery carousel</a> by cssSlider.com v1.9</div>
					<div class='cs_description'>
						<label class='num0'><span class="cs_title"><span class="cs_wrapper">House</span></span></label>
						<label class='num1'><span class="cs_title"><span class="cs_wrapper">Shop</span></span></label>
						<label class='num2'><span class="cs_title"><span class="cs_wrapper">Bangla</span></span></label>
						<label class='num3'><span class="cs_title"><span class="cs_wrapper">Plot</span></span></label>
					</div>
					<div class='cs_play_pause'>
						<label class='cs_play' for='cs_play1'><span><i></i><b></b></span></label>
						<label class='cs_pause num0' for='cs_pause1_0'><span><i></i><b></b></span></label>
						<label class='cs_pause num1' for='cs_pause1_1'><span><i></i><b></b></span></label>
						<label class='cs_pause num2' for='cs_pause1_2'><span><i></i><b></b></span></label>
						<label class='cs_pause num3' for='cs_pause1_3'><span><i></i><b></b></span></label>
						</div>
					<div class='cs_arrowprev'>
						<label class='num0' for='cs_slide1_0'><span><i></i><b></b></span></label>
						<label class='num1' for='cs_slide1_1'><span><i></i><b></b></span></label>
						<label class='num2' for='cs_slide1_2'><span><i></i><b></b></span></label>
						<label class='num3' for='cs_slide1_3'><span><i></i><b></b></span></label>
					</div>
					<div class='cs_arrownext'>
						<label class='num0' for='cs_slide1_0'><span><i></i><b></b></span></label>
						<label class='num1' for='cs_slide1_1'><span><i></i><b></b></span></label>
						<label class='num2' for='cs_slide1_2'><span><i></i><b></b></span></label>
						<label class='num3' for='cs_slide1_3'><span><i></i><b></b></span></label>
					</div>
					<div class='cs_bullets'>
						<label class='num0' for='cs_slide1_0'> <span class='cs_point'></span>
							<span class='cs_thumb'><img src='images/slider/01.png' alt='Home' title='Home' /></span></label>
						<label class='num1' for='cs_slide1_1'> <span class='cs_point'></span>
							<span class='cs_thumb'><img src='images/slider/02.png' alt='Bangla' title='Shop' /></span></label>
						<label class='num2' for='cs_slide1_2'> <span class='cs_point'></span>
							<span class='cs_thumb'><img src='images/slider/03.png' alt='Makan' title='Bangla' /></span></label>
						<label class='num3' for='cs_slide1_3'> <span class='cs_point'></span>
							<span class='cs_thumb'><img src='images/slider/04.png' alt='Ghar' title='Plot' /></span></label>
					</div>
					</div>		
			</div><!-- image area -->
			<div class='ad_container'>
				<div class='buttons_ad_container'>
					<a href="#" style='display:none;'>
						<div class='search_buttons_ad_container' style='color:tomato;'><span class='new'></span>New</div>
					</a>
					<a href="#" style='display:none;'>
						<div class='search_buttons_ad_container' style='color:red;'><span class='hot'></span>Hot</div>
					</a>
				</div><!-- buttons_ad_container -->
				<div class='details_ad_container' style='height: 363pt;'>
					<div id="mi-slider" class="mi-slider">
					
						<%=AdManagementJSP.GetAdHouse() %>
						<%=AdManagementJSP.GetAdShop() %>
						<%=AdManagementJSP.GetAdBangla() %>
						<%=AdManagementJSP.GetAdPlot() %>
						
						
					
					<nav>
						<a href="#">House</a>
						<a href="#">Shop</a>
						<a href="#">Bangla</a>
						<a href="#">Plot</a>
					</nav>
				</div>
				</div><!-- details_ad_container -->
				<div class='view_ad_container'></div><!-- view_ad_container -->
			</div><!-- ad_container -->
		</div><!-- container -->
		<%=AccountManagementJsp.Footer() %>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="js/jquery.catslider.js"></script>
		<script>
			$(function() {

				$( '#mi-slider' ).catslider();

			});
		</script>
  </body>
</html>