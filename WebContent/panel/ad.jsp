<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import= "javax.servlet.http.HttpSession" 
    import = "com.manage_ad.hashim.Jsp_functions.AdManagementJSP"
    import = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
     import  = "com.Utility.umair.WelcomeName"
      import = "com.Utility.umair.emailuser"
    import = "java.util.List" 
    import = "com.Utility.umair.AreaCityName" 
    import = "com.manage_ad.hashim.DbLayer.AdManagementDb"
    import = "com.Utility.umair.GoogleMap"
    import = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
     import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
     
    import = "com.manage_location.hashim.Jsp_Functions.LocationManagementJsp"  
      %>
<%
    String user = null;
	if (session.getAttribute("user") == null){
		response.sendRedirect("../index.jsp");
		
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
   <%
    String price_range = "";
    String upper_price = "200000";
    String lower_price = "35000";
    String upper_area = "60";
    String lower_area = "20";
    String price_area = "";
    String price_area_type = "Any";
    String city = "<option>Any</option>";
    String area = "<option>Any</option>";
    String type = "Any";
    String far = "Any";
    if (request.getParameter("search_buttons") != null){
    	price_range = request.getParameter("price_range");
    	String[] spliter = price_range.split(" - Rs ");
    	upper_price = spliter[1];
    	lower_price = spliter[0]; 
    	lower_price = lower_price.substring(lower_price.lastIndexOf(' ')+1);
    	price_area = request.getParameter("price_area");
    	String[] spliter_area = price_area.split(" - ");
    	upper_area = spliter_area[1];
    	lower_area = spliter_area[0];
    	price_area_type = request.getParameter("price_area_type");

		List<AreaCityName> AreaCityName  = null;
    	if(!request.getParameter("city").equals("Any"))
    	{
    		try 
    		{
				AreaCityName = AdManagementDb.AreaCityNames(request.getParameter("area"));
			} catch (Exception e) 
    		{
				System.out.println(e);
			}
			for(AreaCityName ad1:AreaCityName)
			   {
				area = ad1.area;
				city = ad1.city;
    			city = "<option value='"+request.getParameter("city")+"'>"+city+"</option>";
    			area = "<option value='"+request.getParameter("area")+"'>"+area+"</option>";
			   }
    	}
		else
		{
			city = "<option>"+request.getParameter("city")+"</option>";	
			area = "<option>"+request.getParameter("area")+"</option>";	
			
		}
    	
    	type = request.getParameter("type");
    	far = request.getParameter("far");
	
	 }
    String CheckSearch = null;
    int ad = 0;
    if (request.getParameter("ad") != null)
    {
    	ad = Integer.parseInt(request.getParameter("ad"));
    }
    
    %>
<!DOCTYPE html>
<html>
	<head>
		<title>Wealth Pakistan</title>
		<link rel="shortcut icon" href="../images/logo.png">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/div_slide.css" />
		<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
		<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
      	<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
		
 <script>
         $(function() {
            $( "#range" ).slider({
               range:true,
               min: 1000,
               max: 500000,
               values: [ <%=lower_price%>, <%=upper_price%> ],
               slide: function( event, ui ) {
                  $( "#price_range" ).val("Rs "+ui.values[ 0 ] + " - Rs " + ui.values[ 1 ] );
               }
           });
         $( "#price_range" ).val("Rs "+ $( "#range" ).slider( "values", 0 ) +  " - Rs "
             + $( "#range" ).slider( "values", 1 ) + " " );
         });
      </script>
       <script>
         $(function() {
            $( "#area" ).slider({
               range:true,
               min: 1,
               max: 200,
               values: [ <%=lower_area%> , <%=upper_area%> ],
               slide: function( event, ui ) {
                  $( "#price_area" ).val(ui.values[ 0 ] + " - " + ui.values[ 1 ]  );
               }
           });
         $( "#price_area" ).val( $( "#area" ).slider( "values", 0 ) +  " - "
             + $( "#area" ).slider( "values", 1 ) );
         });
         $(document).ready(function()
      			{
      				$("#area_city").change(function() 
      				{ 
      					var city = $('#area_city').val();
      					//alert("hjere");
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
					<div class='nav_left' style='background-color: #E1E2E3;'>
						
						<div class='item_nav_left' style='background-color: #E1E2E3;'>Manage Ad</div>
						<div class='icon_nav_left'><span class='manage_ad'></span></div>
						
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
				<div class='middle_right' style='margin-top: 0pt;'>
					<div class='middle' style='width:100%;'>
						<div class='title_middle'><h2 style='float:left;'>Manage Ad's</h2><%=message%></div>
						<div class='search_manage_ad'>
							<div class='title_middle'><h3>Search Your Posted Ad's</h3></div>
							<div class='search_buttons' style='margin:-35pt 0pt 0pt -21pt; background:none;height:135pt;'>
					<table>
						<col width='110'>
						<col width='110'>
						<col width='110'>
						<col width='110'>
						<col width='110'>
						<col width='110'>
							<form method='get' action='ad.jsp'>
								<tr>
									<td colspan='3' style='padding-right: 6pt;'>	
										<label for="price" style=" font-weight: bold;style=' padding-right: 6pt;' " >Price range:</label>
										<input type="text" id="price_range" name='price_range'  value="<%=price_range %>" margin-bottom:5pt; style="border:0; font-weight: bold; background:none; font-weight:bold;">
										<div id="range"></div>
									</td>
									<td colspan='2' style='    padding-left: 6pt;'>	
										<label for="price" style="font-weight: bold;">Area:</label>
										<input type="text" id="price_area" name='price_area' value="<%=price_area %>" style="border:0; font-weight:bold; background:none;">
										<div id="area"></div>

									</td>
									<td>
										<select name='price_area_type' style='height: 14pt;margin-bottom: 0pt;margin-left: 2pt;'>
											<option><%=price_area_type %></option>
											<option>Marla</option>
											<option>Kanal</option>
										</select>
									</td>
									
								</tr>
								<tr>
										<td>City</td>
										<td colspan='2' >
											<select id="area_city" name='city' style='width: 150pt;'>
												<%=city %>
												<%=LocationManagementJsp.ViewCityJSP() %>
											</select>
										</td>
										<td style='padding-left: 6pt;'>Area</td>
										<td colspan='2'>
											<select name='area' style='width: 178pt;' id='disp'>
											<%=area %>
											</select>
										</td>									
								</tr>
								<tr>
									<td>Type</td>
									<td colspan='2'>
										<select name='type' style='width: 150pt;'>
										<option><%=type %></option>
											<option>House</option>
											<option>Bangla</option>
											<option>Shop</option>
											<option>plot</option>
										</select>
									</td>
									<td style='padding-left: 6pt;'>For</td>
									<td colspan='2'>
										<select name='far' style='width: 178pt;'>
										<option><%=far %></option>
											<option>Sale</option>
											<option>Rent</option>
										</select>
									</td>
								</tr>
								<tr>
									
									<td colspan='9'>
										<center><input type='submit' value='Search' name='search_buttons' class='search_button' style='margin:0pt;width: 117pt;height: 26pt;'></center>
									</td>
								</tr>
							</form>
					</table>
				</div><!-- search_buttons -->
						</div><!-- <div class='search_manage_ad' -->
						<div class='resutl_search_manage_ad'>
						<%if(!role.equals("Agent"))  
						{
							if (request.getParameter("search_buttons") != null){
						%>
							<%=AdManagementJSP.ViewAdPanel(price_range,price_area,upper_price,lower_price,upper_area,lower_area,request.getParameter("city"),request.getParameter("area"),type,far,ad) %>
						<%}else{%>
							<%=AdManagementJSP.ViewAdPanelInt(ad) %>
						<%}
							}
						else 
						{	if (request.getParameter("search_buttons") != null){
							%>
								<%=AdManagementJSP.ViewAdPanelUser(user,price_range,price_area,upper_price,lower_price,upper_area,lower_area,request.getParameter("city"),request.getParameter("area"),type,far,ad) %>
							<%}else{%>
							<%=AdManagementJSP.ViewAdPanel(user,ad) %>
						<%}
						}%>
						<div class='paging_search'>
				<div style='position: absolute;bottom:20px;margin-left:250pt;'>
					<% 
					if(!role.equals("Agent"))  
					{
							int pagging;
							int ShowPagging = 1;
							if (request.getParameter("search_buttons") != null){
								pagging = Integer.parseInt(AdManagementDb.PageNumberAd(upper_price,lower_price,upper_area,lower_area,request.getParameter("city"),request.getParameter("area"),type,far));
								for(int i=0;i<pagging;i+=15)
								{%>
									<%="<form action='ad.jsp' method='get'>"
									+"<input type='text' value='"+i+"' name='ad' hidden>"
									+"<input type='text' value='"+upper_price+"' name='upper_price' hidden>"
									+"<input type='text' value='"+lower_price+"' name='lower_price' hidden>"
									+"<input type='text' value='"+upper_area+"' name='upper_area' hidden>"
									+"<input type='text' value='"+lower_area+"' name='lower_area' hidden>"
									+"<input type='text' value='"+request.getParameter("city")+"' name='city' hidden>"
									+"<input type='text' value='"+request.getParameter("area")+"' name='area' hidden>"
									+"<input type='text' value='"+type+"' name='type' hidden>"
									+"<input type='text' value='"+far+"' name='far' hidden>"
									+"<input type='text' value='"+price_range+"' name='price_range' hidden>"
									+"<input type='text' value='"+price_area+"' name='price_area' hidden>"
									+"<input type='submit' value='"+ShowPagging+"' name='search_buttons' style='border:none;background:none;cursor:pointer;'>"
									+"</form>"%>
									<% ShowPagging ++;
								}
							}
							else{
							
								pagging = Integer.parseInt(AdManagementDb.PageNumberAd());
								for(int i=0;i<pagging;i+=10)
								{%>
									<%="<form action='ad.jsp' method='get'>"
									+"<input type='text' value='"+i+"' name='ad' hidden>"
									+"<input type='submit' value='"+ShowPagging+"' style='border:none;background:none;cursor:pointer;'>"
									+"</form>"%>
									<% ShowPagging ++;
								}
							}
						}else{
							int pagging;
							int ShowPagging = 1;
							if (request.getParameter("search_buttons") != null){
								pagging = Integer.parseInt(AdManagementDb.PageNumberAd(user,upper_price,lower_price,upper_area,lower_area,request.getParameter("city"),request.getParameter("area"),type,far));
								for(int i=0;i<pagging;i+=15)
								{%>
									<%="<form action='ad.jsp' method='get'>"
									+"<input type='text' value='"+i+"' name='ad' hidden>"
									+"<input type='text' value='"+upper_price+"' name='upper_price' hidden>"
									+"<input type='text' value='"+lower_price+"' name='lower_price' hidden>"
									+"<input type='text' value='"+upper_area+"' name='upper_area' hidden>"
									+"<input type='text' value='"+lower_area+"' name='lower_area' hidden>"
									+"<input type='text' value='"+request.getParameter("city")+"' name='city' hidden>"
									+"<input type='text' value='"+request.getParameter("area")+"' name='area' hidden>"
									+"<input type='text' value='"+type+"' name='type' hidden>"
									+"<input type='text' value='"+far+"' name='far' hidden>"
									+"<input type='text' value='"+price_range+"' name='price_range' hidden>"
									+"<input type='text' value='"+price_area+"' name='price_area' hidden>"
									+"<input type='submit' value='"+ShowPagging+"' name='search_buttons' style='border:none;background:none;cursor:pointer;'>"
									+"</form>"%>
									<% ShowPagging ++;
								}
							}
							else{
							
								pagging = Integer.parseInt(AdManagementDb.PageNumberAdNo(user));
								for(int i=0;i<pagging;i+=10)
								{%>
									<%="<form action='ad.jsp' method='get'>"
									+"<input type='text' value='"+i+"' name='ad' hidden>"
									+"<input type='submit' value='"+ShowPagging+"' style='border:none;background:none;cursor:pointer;'>"
									+"</form>"%>
									<% ShowPagging ++;
								}
							}
							
						}%>	
				</div>			
				</div>		</div><!-- resutl_search_manage_ad -->
					</div><!-- middle -->
				</div><!-- middle_right -->
			</div>
		</div><!-- container -->
		<%=AccountManagementJsp.AdminFooter() %>
		
  </body>
</html>