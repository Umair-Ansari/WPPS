<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import= "javax.servlet.http.HttpSession" 
    import  = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
     import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
    import = "com.Utility.umair.emailuser"
    import  = "com.Utility.umair.WelcomeName" %>
    <!-- import  = "com.manage_ad.Jap_function.ViewAd"
      -->
   <%@ page session="true" %>
   <%
	String user = null;
   String message = "";
   String message2 = "";
	if (session.getAttribute("user") == null){
		response.sendRedirect("../index.jsp");
	 }
	else{
		user = (String)session.getAttribute("user");
	}
	if (null != session.getAttribute("message")){
		message = (String)session.getAttribute("message");
	 	session.removeAttribute("message");
	 	
	 }
	if (null != session.getAttribute("message2")){
		message2 = (String)session.getAttribute("message2");
	 	session.removeAttribute("message2");
	 	
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
		<style>
			.form-style-2 input.input-field {
   				 width: 100%;
		}
		.form-style-2 label > span {
    		width: 153px;
    		font-weight: bold;
    		float: left;
    		padding-top: 8px;
    		padding-right: 5px;
		}
		</style>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script>
		$(document).ready(function(){

		    $("#update").click(function(){
		    	var r = true;
		    	if (r == true) {
		    	     $("#show").show();
		    	     $("#hide").hide();
		    	}
		    	   
		    	});
			
		$("#pass").click(function(){
	    	var r = true;
	    	if (r == true) {
	    	     $("#show_pass").show();
	    	     $("#pass").hide();
	    	}
	    	   
	    	});
		});
		
					    function checkpass()
					    {
					    	$(".error").hide();
					    	var hasError = false;
					    	var passwordVal = $("#txtNewPassword").val();
					    	var checkVal = $("#txtConfirmPassword").val();
					    	if (passwordVal == '') 
					    	{
					    		$("#a").html("<span style='color:red;'>Please enter a password.</span>");
					    		hasError = true;
					    	}
					    	else if (checkVal == '') 
					    	{
					    		$("#b").html("<span style='color:red;'>Please enter a password.</span>");
					    		
					    		hasError = true;
					    	} 
					    	else if (passwordVal != checkVal ) 
					    	{
					    		$("#a").html("<div style='background-color:#ffebe8;border:1px solid #dd3c10;padding:7pt;margin: -28pt 6pt 5pt -6pt;width: 298pt;'>Password missmatch.</div>");
					    		
					    		hasError = true;
					    	}
					    	if(hasError == true) 
					    	{
					    		//alert("here");
					    		return false;
					    	}
					   
					    }
		
		
		</script>
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
					<div class='nav_left' style='background-color: #E1E2E3;'>
						
							<div class='item_nav_left' style='background-color: #E1E2E3;'>Profile</div>
							<div class='icon_nav_left'><span class='profile'></span></div>
						
					</div>
					<div class='nav_left' >
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
						<div class='title_middle'><h2>Profile</h2></div>
						<div class='profile_about'>
							<%=message %>
							<%=AccountManagementJsp.ViewProfilejsp(user) %>
							
						</div><!-- profile_about -->
						<div class='profile_areas'>
						<div class='title_middle' style='margin-top:10pt;'><h2>Change Password</h2></div>
							<%=message2 %>
							<%=AccountManagementJsp.ChangePasswordJsp(user) %>
						</div>
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