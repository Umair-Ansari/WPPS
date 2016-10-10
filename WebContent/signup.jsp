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
	String email2 = emailuser.emailget(user);
    %>
   <%@ page session="true" %>
	<%
	String disabled= "";
	String message = "";
	String email = "";
	String hidden = "";
	String verified = "";
	String height = "400pt";
	String margin = "0pt";
	if (null != session.getAttribute("message")){
		message = (String)session.getAttribute("message");
	 	session.removeAttribute("message");
	 	height = "454pt";
	 	margin = "55pt";
	 }
	if (null != session.getAttribute("email")){
		email = (String)session.getAttribute("email");
		disabled = "disabled='true'";
		hidden = "<input type='email' value='"+email+"' required name='email' hidden>";
		
		//verified = "<Div style='border 1pt solid #2cb649;padding:2pt;font-size:7pt;color:#2cb649;'>Verified</div>";
	 }
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Wealth Pakistan</title>
		
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script type="text/javascript">
		
		 
		</script>	
		<link rel="shortcut icon" href="images/logo.png">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/div_slide.css" />
		<style>
			.form-style-2 input.input-field {
   				 width: 100%;
		}
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
				<div class='banner_welcome_logout' style=' margin-top: -6pt;'><%=BannerManagementJsp.ViewBannerHomeJsp(email2) %></div>
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
			<div class='login_area' style='height:<%=height%>;'>
				<%=message %>
				<div class='login' style='margin-top:14pt;width:68%;margin-left:120pt;' >
				
					<div class="form-style-2">
					
					<form action='RegisterAgentPath' method='post' style="margin-bottom: 11pt;margin-left:-26pt;" >
						<table>
							<col width="160">
							<tr>
								<td  style="vertical-align:top;text-align:center;" colspan='2'>
									<h1><div class="form-style-2-heading">Provide your information</div></h1><br>
								</td>
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field1"><span>First Name <span class="required">*</span></span></td>
								<td  style="vertical-align:top"><input type='text' class="input-field" pattern="[a-zA-Z]{3,}" required placeholder='umair' name='fname' oninvalid="setCustomValidity('must contain 3 or more letters only with no space')"  onchange="try{setCustomValidity('')}catch(e){}" /></label></td>
						
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field2"><span>Last Name <span class="required">*</span></span></td>
								<td  style="vertical-align:top"><input type='text' class="input-field" pattern="[a-zA-Z]{3,}" required placeholder='ansari' name='lname'oninvalid="setCustomValidity('must contain 3 or more letters only with no space')"  onchange="try{setCustomValidity('')}catch(e){}" /></label></td>
								
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field3"><span>Email <span class="required">*</span></span></td>
								<%=hidden %>
								<td  style="vertical-align:top"><input type='email' class="input-field" required value='<%=email %>' <%=disabled %> placeholder='user@domain.com' name='email'><%=verified %></label></td>
								
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field3"><span>Password <span class="required">*</span></span></td>
								<td  style="vertical-align:top"><input type='password' id="txtNewPassword" class="input-field" required pattern='(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}' placeholder='*********' name='password' oninvalid="setCustomValidity('must contain 8 to 10 characters that are of at least one number, and one uppercase and lowercase letter')"
    onchange="try{setCustomValidity('')}catch(e){}" /></label></td>
								
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field3"><span>Confrm Password <span class="required">*</span></span></td>
								<td  style="vertical-align:top"><input type='password' id="divCheckPasswordMatch" class="input-field"  required pattern='(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}' placeholder='**********' name='cpassword' 
      /></label></td>
								
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field3"><span>Organization <span class="required">*</span></span></td>
								<td  style="vertical-align:top"><input type='text'class="input-field" required placeholder='Wealth pakistan' name='organization'></label></td>
								
							</tr>
							<tr>
								<td  style="vertical-align:top"><label for="field3"><span>Contact <span class="required">*</span></span></td>
								<td  style="vertical-align:top"><input type='text' class="input-field" required placeholder='03425643227' pattern='[03]{2}[0-9]{9}' name='contact' oninvalid="setCustomValidity('must contain 11 characters that are srart with 03 and contain number only')"
    onchange="try{setCustomValidity('')}catch(e){}" /></label></td>
								
							</tr>
							<tr>
								<br><br><td colspan='2' style='text-align:center;'><br><input type='submit' class="myButton" value='Signup'></td>
							</tr>
						</table>
					</form>
					</div><!--  form-style-2 -->
				</div>
			</div>
			
		</div><!-- container -->
		<%=AccountManagementJsp.Footer() %>
		
  </body>
</html>