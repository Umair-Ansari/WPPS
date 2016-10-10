<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.manage_location.hashim.Jsp_Functions.LocationManagementJsp"
    import = "com.manage_account.umair.Jsp_functions.AccountManagementJsp"  
    import = "com.Utility.umair.emailuser"
    import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
     import  = "com.Utility.umair.WelcomeName"
     %>
 <%
   String Message = "";
	if (null != session.getAttribute("message"))
	{
		Message = (String)session.getAttribute("message");
		session.removeAttribute("message");
	}
	 
   %>
   <%@ page session="true" %>
   <%
	String user = null;
	if (session.getAttribute("user") == null){
		response.sendRedirect("../index.jsp");
	 }
	else
	{
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
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="http://dinbror.dk/bpopup/assets/jquery.bpopup-0.9.4.min.js"></script>
		<script src="http://dinbror.dk/bpopup/assets/jquery.easing.1.3.js"></script>
		<script type="text/javascript">
		var city;
		function toDelete(val){
			//alert(id);
			city = val;
			$("#getcityid").val(city);
			//$('#email').val(city);
			//alert(email);
   		// $('#popup').bPopup();
    	 	$('#popup').bPopup({
    			easing: 'easeOutBack', //uses jQuery easing plugin
    	    	speed: 450,
    	    	transition: 'slideDown'
    		});
		}
		 
		</script>
		<script type="text/javascript">
		var area;
		function toDeletea(val){
			//alert(id);
			area = val;
			$("#getareaid").val(area);
			//$('#email').val(city);
			//alert(email);
   		// $('#popup').bPopup();
    	 	$('#popupa').bPopup({
    			easing: 'easeOutBack', //uses jQuery easing plugin
    	    	speed: 450,
    	    	transition: 'slideDown'
    		});
		}
		 
		</script>
		<script>
		//var city;
		function cityval(city){
			//city = e;
			var user = <%=user%>;
						//var city2 = $('#'+city).val();
						//alert(city);
						if(city =="")
						{
							$("#areauser").html("");
						}
						else
						{
							
							$.ajax(
							{
								
								type: "POST",
								url: "../ViewUserAreaPath",
								data: "city="+ city+"&user="+ user ,
								success: function(html)
								{
									$("#areauser").html(html);
								}
							});
						return false;
						}
					
			
		}
		
		$(document).ready(function()
			{
				
			
				
				$("#area").change(function() 
						{ 
							var city = $('#area').val();
							if(city=="")
							{
								//$("#disp").html("");
							}
							else
							{
								$.ajax(
								{
									type: "POST",
									url: "../ViewAreaPath",
									data: "city="+ city ,
									success: function(html)
									{
										$("#disp").html(html);
									}
								});
							return false;
							}
						});
			});
		$(document).ready(function(){

		    $("#hide").click(function(){
		    	var r = confirm("conform Remove Area");
		    	if (r == true) {
		    	     $("#hide").hide();
		    	}
		    	   
		    	});
			});
		$(document).ready(function(){

		    $("#checkboxc").click(function(){
		    	if( $(this).is(':checked')) {
		    	     $("#deletec").show();
		    	     
		    	}
		    	else
		    	{
		    		 $("#deletec").hide();
		    	}
		    	});

		    $("#checkboxa").click(function(){
		    	if( $(this).is(':checked')) {
		    	     $("#deletea").show();
		    	     
		    	    
		    	}
		    	else
		    	{
		    		 $("#deletea").hide();
		    	}
		    	});
		});
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
			<div class='panel' style='height:850pt;'>
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
					<div class='nav_left'  style='background-color: #E1E2E3;'>
						<div class='item_nav_left' style='background-color: #E1E2E3;'>Manage Area</div>
						<div class='icon_nav_left'><span class='manag_area'></span></div>
						
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
				<div class='middle_right' style='margin-top: 0pt;'>
					<div class='middle'>
						<div class='title_middle'><h2>Manage Area</h2><%=Message %></div>
						<div class='dash_agent' style='margin-top: -10pt;' >
							<div class='title_middle' style='margin-bottom:4pt;'><h3>Add New Area</h3></div>
							<div class="form-style-2"><table>
									<col width='100'>
									<col width='200'>
									<tr>
										<td><b>City</b></td>
										<td>
										
											<form action='../AddUserAreaPath' method='post'>
											<label for="field4"><select style='width:103pt;' id='area' name='city' class="select-field">
											<option>No City Selected</option>
											<%=LocationManagementJsp.ViewCityJSP() %>
										</select></label>
										</td>
									</tr>
									<tr>
										<td><b>Area</b></td>
										<td>
											<label for="field4"><select style='width:103pt;' id='disp' name='area' class="select-field" >
												<option>No Area Selected</option>
											</select></label>
										</td>
									</tr>
									<tr>
										<td colspan='2'><br><center><input type='text' value='<%=user %>' name='user' hidden> <input type='submit' value='Add' class="myButton"></center></td>
									</tr>
									</form>
									
								</table></div>
						</div><!-- dash_agent -->
						<div class='dash_agent' style='margin-top: 20pt;' >
							<div class='title_middle' style='margin-bottom:4pt;'><h3>Your Area</h3></div>
							<table>
									<col width='200'>
									<col width='200'>
									<tr>
										<td style="border-right: 2px solid #E1E2E3;border-bottom: 2px solid #E1E2E3;"><b>City</b></td>
										<td style="border-bottom: 2px solid #E1E2E3;"><b>Areas</b></td>
									</tr>
									<tr>
										<td style="border-right: 2px solid #E1E2E3;vertical-align: top;" >
											<%=AccountManagementJsp.ViewCityListJSP(user) %>
										<td style='vertical-align:top;'>
											<!--  <div  id='hide' >G7-1<a href="#" id="hide" ><span class='cross'></span></a></div>
											 -->
											
												<div id='areauser'></div>
											
											
									</tr>
								</table>
						</div><!-- dash_agent -->
					</div><!-- middle -->
					<div class='right'></div>
				</div><!-- middle_right -->
			</div>
		</div><!-- container -->
		<%=AccountManagementJsp.AdminFooter() %>
		<div id="popup" class='a' style="display:none; background:#F6F7F8; float:left;padding:20pt;">
		<div class='pop_header'></div>
					  
					  
					   			
					   			<center><h1 style='color:red;'>Warnning!</h1></center><br>
					   		<b>This operation can't undo</b><br>
					   		<b>You Are About To Delete Following</b>
					   		<ol style='font-size:10pt;margin-left:10pt;'>
					   			<li>Agents Area's associated with this city</li>
					   			<li>Ad's that are associated with this city</li>
					   		</ol>
					   		<br>
					   		<b>Are you still wish to continue?</b>
					   		<br>
					   		Yes! I understand the risk and wish to continue  <input type='checkbox' id='checkboxc'><br><br>
					   		<center>
					   			<form action='../DeleteUserCityPath' method='post'>
					   			<input type='text' id='getcityid' hidden name='city'>
					   				<input type='text' value='<%=user %>' hidden name='user'>
					   			<input type='submit' id='deletec' hidden value='Delete City' class="myButton" style='display: none;'></form>
					   		</center>
					  
					   </div>
		<div id="popupa" class='a' style="display:none; background:#F6F7F8; float:left;padding:20pt;">
		<div class='pop_header'></div>
					   	
					  
					   			
					   			<center><h1 style='color:red;'>Warnning!</h1></center><br>
					   		<b>This operation can't undo</b><br>
					   		<b>You Are About To Delete Following</b>
					   		<ol style='font-size:10pt;margin-left:10pt;'>
					   			<li>Ad's that are associated with this area</li>
					   		</ol>
					   		<br>
					   		<b>Are you still wish to continue?</b>
					   		<br>
					   		Yes! I understand the risk and wish to continue  <input type='checkbox' id='checkboxa'><br><br>
					   		<center>
					   			<form action='../DeleteUserAreaPath' method='post'>
					   				<input type='text' id='getareaid'  hidden name='area'>
					   				<input type='text' value='<%=user %>' hidden name='user'>
					   				<input type='submit' id='deletea' hidden value='Delete Area' class="myButton" style='display: none;'>
					   			</form>
					   		</center>
					   
					   </div>
  </body>
</html>