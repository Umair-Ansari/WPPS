<%@page import="com.Utility.umair.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
  	import = "com.request_handling.umair.DbLayer.RequestHandlingDb" 
  	import = "java.io.IOException"
	import = "java.sql.SQLException"
	import = "java.util.ArrayList"
	import = "java.util.List" 
	 import  = "com.Utility.umair.WelcomeName"
	   import = "com.Utility.umair.emailuser"
    import  = "com.Utility.umair.WelcomeName" 
    import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
      import  = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
	 %>
   <%
   String Message = "";
   String user = "";
	if (null != session.getAttribute("message"))
	{
		Message = (String)session.getAttribute("message");
		session.removeAttribute("message");
	}
	if (session.getAttribute("user") == null){
		response.sendRedirect("../index.jsp");
	 }
	else{
		user = (String)session.getAttribute("user");
	}
	String mail = emailuser.emailget(user);
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
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://dinbror.dk/bpopup/assets/jquery.bpopup-0.9.4.min.js"></script>
		<script src="http://dinbror.dk/bpopup/assets/jquery.easing.1.3.js"></script>
		<script type="text/javascript">
		var email;
		var id;
		function toDelete(val){
			//alert(id);
			id = val;

			email = $('#'+id).text();
			$('#email').val(email);
			//alert(email);
   		// $('#popup').bPopup();
    	 	$('#popup').bPopup({
    			easing: 'easeOutBack', //uses jQuery easing plugin
    	    	speed: 450,
    	    	transition: 'slideDown'
    		});
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
					<div class='banner_welcome_logout' style=' margin-top: -6pt;'><%=BannerManagementJsp.ViewBannerJsp(mail) %></div>
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
					<div class='nav_left'>
						<a href="create.jsp">
						<div class='item_nav_left'>Creat Agent</div>
						<div class='icon_nav_left'><span class='creat_agent'></span></div>
						</a>
					</div>
					<div class='nav_left' style='background-color: #E1E2E3;'>
						
						<div class='item_nav_left' style='background-color: #E1E2E3;'>Agent Requests</div>
						<div class='icon_nav_left'><span class='agent_requests'></span></div>
						
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
						<div class='title_middle' style='margin-bottom: 10pt;'><h2>Agent Account Requests</h2></div>
						<div style='width:100%;border:2px solid #E1E2E3;height:30pt; margin-bottom:2pt;'>
							<form action='../DeleteAllAgentPath' method='post'>
								<input type='submit' value='Delete All' name='delete' style='float:right;margin:1pt;' class="myButton">
							</form>
							<div class="form-style-2" style='margin-top: -32.2pt;margin-left:-18pt;'>
							<form action="request.jsp" method='get' style=''>
								<label><input type='text'  class="input-field"  placeholder='Ali' style='float:left;margin:5pt;width: 110pt;margin-top:1pt;' pattern="[a-zA-Z]{3,}" required placeholder='umair' name='search' oninvalid="setCustomValidity('must contain 3 or more letters only')"  onchange="try{setCustomValidity('')}catch(e){}" />
								<input type='submit' value='Search' class="myButton" style='float:left;margin-top:1pt;'></label>
								
							</form><%=Message %></div>
						</div>
						<div style='width:100%;border:2px solid #E1E2E3;height:393pt;padding:6pt 0pt 6pt 6pt;margin-bottom: 7pt;'>
							
							<%
							 	List<Request> string = null;
							   	String id ="";
							   	String date = "";
								String f_name ="";
								String l_name ="";
								String email ="";
								String contact  ="";
								String Organization  ="";
								String CheckSearch = null;
								int Pagging = 0;
								try{
									Pagging  = Integer.parseInt(request.getParameter("page"));
								}
								catch(Exception e){
								
								}
								
								try{
									CheckSearch = request.getParameter("search");
								}
								catch(Exception e){
									
								}
								if(CheckSearch!=null)
								{
									string  = RequestHandlingDb.ViewRole(CheckSearch,Pagging);
								}
								else
								{
							   		string  = RequestHandlingDb.ViewRole(Pagging);
								}
							   for(Request req:string)
							   {
								   id = req.id;
								   date = req.date;
								   f_name = req.f_name;
								   l_name = req.l_name;
								   email = req.email;
								   contact = req.contact;
								   Organization = req.Organization;
								   String print = "";
								   print = "<div class='request_panel' style='height: 125pt;'><div style='float:right;'>"+date+"</div>"
									+"<table>"
										+"<col width='25%'>"
										+"<col width='75%'>"
										+"<tr>"
											+"<td>First Name</td>"
											+"<td>"+f_name+"</td>"
										+"</tr>"
										+"<tr>"
											+"<td>Last Name</td>"
											+"<td>"+l_name+"</td>"
										+"</tr>"
										+"<tr>"
											+"<td>Email</td>"
											+"<td id='"+id+"'>"+email+"</td>"
										+"</tr>"
										+"<tr>"
											+"<td>Contact</td>"
											+"<td>"+contact+"</td>"
										+"</tr>"
										+"<tr>"
											+"<td>Organization</td>"
											+"<td>"+Organization+"</td>"
										+"</tr>"
										+"<tr>"
											+"<td colspan='2' align='right'><div style='margin: 3pt 18%;'><form action='../AcceptAgentPath' method='POST'>"
												+"<input type='submit' value='Accept'style='float:left;' class='myButton' >"
												+"<input type='text' name='email' value='"+email+"' hidden>"
												+"</form>" 
											//+"<form action='../RejectAgentPath' method='POST'>"
													+"<input type='submit' id='pop' value='Reject' style='float:right;' onClick='toDelete("+id+");' class='myButton' >"
													+"<input type='text' name='id' value='"+id+"' hidden>"
											+"</div></td>"
										+"</tr>"
									+"</table>"
								+"</div>";%>
								<%=print%>
							   <% } %>
							   
							
							
							

						</div>
						<div style='width:100%;'><div style='float:left'>Page</div>
							<% 
							int pagging;
							int ShowPagging = 1;
							if(CheckSearch != null)
							{
								pagging = Integer.parseInt(RequestHandlingDb.PageNumberRequestAgent(CheckSearch));
								for(int i=0;i<pagging;i+=6)
								{%>
									<%="<div style='float:left'><form action='request.jsp' method='get'>"
									+"<input type='text' value='"+i+"' name='page' hidden>"
									+"<input type='text' value='"+CheckSearch+"' name='search' hidden>"
									+"<input type='submit' value='"+ShowPagging+"' style='border:none;background:none;cursor:pointer;'>"
									+"</form></div>"%>
									<% ShowPagging ++;
								}
							}
							else
							{
								pagging = Integer.parseInt(RequestHandlingDb.PageNumberRequestAgent());
								for(int i=0;i<pagging;i+=6)
								{%>
									<%="<div style='float:left'><form action='request.jsp' method='get'>"
									+"<input type='text' value='"+i+"' name='page' hidden>"
									+"<input type='submit' value='"+ShowPagging+"' style='border:none;background:none;cursor:pointer;'>"
									+"</form></div>"%>
									<% ShowPagging ++;
								} 
							}%>
						</div>
					</div><!-- middle -->
					
				</div><!-- middle_right -->
			</div>
		</div><!-- container -->
		<%=AccountManagementJsp.AdminFooter() %>
		<div id="popup" class='a' style="display:none; background:#F6F7F8; float:left;padding:6pt;">
		<div class='pop_header'></div>
					   	<form action='../RejectAgentPath' method='POST'>
					   		<table>
					   		<tr>
					   			<span id='spnmobileStatus'></span>
					   			<td>Sender</td>
					   			<td ><input type='text' value='Wealth Pakistan' required style='margin-left: 10px;' ></td>
					   			<td>Reciever</td>
					   			<td ><input type='text' id='email' required style='margin-left: 10px;' name='recive'></td>
					   		</tr>
					   		<tr>
					   			<td>Rejection Message</td>
					   			<td colspan='3'><textarea required rows="4" cols="41" style='margin-left: 10px;' name='reason'>unknowing</textarea></td>
					   		</tr>
					   		<tr>
					   			<td colspan='4'><center><input type='submit' value='Reject'></center></td>
					   		</tr>
					   		</table>
					   </form>
					   </div>
					
  </body>
</html>