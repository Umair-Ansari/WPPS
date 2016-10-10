<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import= "javax.servlet.http.HttpSession" 
    import= "java.io.File"
	import= "java.sql.SQLException"
	import= "java.util.List"
 import  = "com.Utility.umair.WelcomeName"
	import= "com.Utility.umair.House"
	import= "com.manage_ad.hashim.DbLayer.AdManagementDb"
	import = "com.Utility.umair.Connector"
    import = "com.manage_account.umair.Jsp_functions.AccountManagementJsp" 
      import = "com.manage_banner.hashim.Jap_Functions.BannerManagementJsp"
     import  = "com.Utility.umair.WelcomeName"
     import = "com.Utility.umair.emailuser"
     import = "com.Utility.umair.AreaCityName"
	%>
   <%@ page session="true" %>
  	 <%
  	 String message = "";
  	 String u = "";
	if (null != session.getAttribute("message")){
		message = (String)session.getAttribute("message");
	 	session.removeAttribute("message");
	 	
	 }
	if (session.getAttribute("user") == null){
		response.sendRedirect("../index.jsp");
	 }
	else{
		u = (String)session.getAttribute("user");
	}
	String email = emailuser.emailget(u);
   String method = "Post";
   String nav = "<div class='nav_left' style='background-color: #E1E2E3;'>"
		   	+"<div class='item_nav_left' style='background-color: #E1E2E3;'>Post Ad</div>"
			+"<div class='icon_nav_left'><span class='post_ad'></span></div>"
			+"</div>";
   String user= "";
   String img1 = "";
   String img2 = "";
   String img3 = "";
   String img4 = "";
   String p_id= "";
   String price= "";
   String far= "";
   String typee = "";
   String landtype = "";
   String land = "";
   String date_time = "";
   String details = "";
   String g_id = "";
   String area = "";
   String city = "";
   String longitude = "73.093146100000010000";
   String lateitude = "33.729388200000000000";
   String action = "../PostAdPath";
   if (null != session.getAttribute("user")){
		user = (String)session.getAttribute("user");
	 	
	 }
   if (null != request.getParameter("update")){
	   method = "Update";
	   nav = "<div class='nav_left'>"
			   +"<a href='new.jsp'>"
					+"<div class='item_nav_left' >Post Ad</div>"
					+"<div class='icon_nav_left'><span class='post_ad'></span></div>"
				+"</a>"
			 +"</div>";
	   p_id = request.getParameter("p_id");
	   List<House> string  = null;
		try{
			string  = AdManagementDb.GetUpdateAD(p_id,user);
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{

			for(House ad:string)
			   {
				
				price = ad.price;
				far = "<option>"+ad.far+"<option>";
				typee = "<option>"+ad.type+"</option>";
				landtype = "<option>"+ad.landtype+"</option>";
				land = ad.land;
				date_time = ad.date_time;
				g_id = ad.g_id;
				area = ad.a_id;
				details = ad.details;
				List<AreaCityName> AreaCityName  = null;
				try {
					AreaCityName = AdManagementDb.AreaCityNames(area);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
				area = ad1.area;
				city = ad1.city;
				}
				action = "../UpdateAdPath";
				String path = Connector.ConnectorPath();
				String saveFile= path;
				File folder = new File(path+p_id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				       if(i==0)
				       {
				    	img1   = p_id+"/"+listOfFiles[i].getName();
				       }
				       if(i==1)
				       {
				    	img2   = p_id+"/"+listOfFiles[i].getName();
				       }
				       if(i==2)
				       {
				    	img3   = p_id+"/"+listOfFiles[i].getName();
				       }
				       if(i==3)
				       {
				    	img4   = p_id+"/"+listOfFiles[i].getName();
				       }
				      }
				    }
				   longitude = "73.093146100000010000";
				   lateitude = "33.729388200000000000";
			   }
		}
	 	
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
		<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
		<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
		<script
src="http://maps.googleapis.com/maps/api/js">
</script>

<script>
var map;
var myCenter=new google.maps.LatLng(<%=lateitude%>,<%=longitude%>);
var lat;
var log;
function initialize()
{
var mapProp = {
  center:myCenter,
  zoom:15,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

  map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

  google.maps.event.addListener(map, 'click', function(event) {
    placeMarker(event.latLng);
  });
}

function placeMarker(location) {
  var marker = new google.maps.Marker({
    position: location,
    map: map,
  });
  lat = location.lat();
  log = location.lng();
  var infowindow = new google.maps.InfoWindow({
    content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
  });
  infowindow.open(map,marker);
}
function myFunction() {
	   document.getElementById("lat").value = lat;
	   document.getElementById("log").value = log;
	}

google.maps.event.addDomListener(window, 'load', initialize);
$(document).ready(function() 
		{
		    $('#search').click(function()
		    {
		        var address = $('#location').val();
		        var geocoder = new google.maps.Geocoder();
		        geocoder.geocode({
		            "address": address
		        }, function(results) {
		            map.setCenter(results[0].geometry.location); 
		        });
		     });
		});
</script>
		<style>
		  article, aside, figure, footer, header, hgroup, 
		  menu, nav, section { display: block; }
		</style>
		<script type="text/javascript">
		function readURL1(input) {
		        if (input.files && input.files[0]) {
		            var reader = new FileReader();

		            reader.onload = function (e) {
		                $('#blah1')
		                    .attr('src', e.target.result)
		                    .width(150)
		                    .height(200);
		            };

		            reader.readAsDataURL(input.files[0]);
		        }
		    }
		function readURL2(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah2')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
    function readURL3(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah3')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
    function readURL4(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah4')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
    $(document).ready(function()
			{
				$("#area").change(function() 
				{ 
					var user = "<%=user%>";
					var city = $('#area').val();
					if(city=="")
					{
						//$("#disp").html("");
					}
					else
					{
					
						$.ajax(
						{
							type: "post",
							url: "../CityAreaGetPath",
							data: "city="+ city+"&user="+ user ,
							success: function(html)
							{
							
								$("#areauser").html(html);
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
			<div class='panel' style='height:907pt;'>
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
					
							<%=nav %>
					
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
				<div class="form-style-2" style='max-width:none;'>
				<form action="<%=action %>" method='post'  enctype="multipart/form-data" >
				<input type='text' value='<%=g_id %>' name='g_id' hidden>
				<input type='text' value='<%=user %>' name='user' hidden>
				<input type='text' value='<%=p_id %>' name='p_id' hidden>
				
				<div class='middle_right' style='margin-top: 0pt;'>
					<div class='middle' style='width:75%;'>
						<div class='title_middle'><h2><%=method %> Ad<%=message %></h2></div>
						<div class='new_details'>
						
							<input type='text' name='user' value='<%=user %>' hidden>
								<h3><div class="form-style-2-heading">1- Ad Details</div></h3><br>
								<div class='new_details_input'>
									<table>
										<col width='90'>
										<col width='130'>
										<col width='90'>
										<col width='130'>
										<tr>
											<td><label for="field1"><span>Price <span class="required">*</span></span></td>
											<td><input type='text' style='width:130pt;' class="input-field" name='price' value='<%=price%>' pattern='[1-9]{1}[0-9]{3,}'  oninvalid="setCustomValidity('must contain atleast 4 characters that can not srart with 0 and contain number only')"
    onchange="try{setCustomValidity('')}catch(e){}" required /> Rs</label></td>
											<td><label for="field1"><span>Type <span class="required">*</span></span></td>
											<td><select style='width:145pt;' class="select-field" name='type'><%=typee %><option>House</option><option>Bangla</option><option>Shop</option><option>Plot</option></select></label></td>
										</tr>
										<tr>
											<td><label for="field1"><span>For <span class="required">*</span></span></td>
											<td><select style='width:145pt;' class="select-field" name='far'><%=far %><option>Sale</option><option>Rent</option></select></label></td>
											<td><label for="field1"><span>Land Area <span class="required">*</span></span></td>
											<td><input type='text' name='land' class="input-field" value='<%=land%>'pattern='[1-9]{1}[0-9]{0,2}'  oninvalid="setCustomValidity('must contain maximun 3 and atleast 1 characters that can not srart with 0 and contain number only')"
    onchange="try{setCustomValidity('')}catch(e){}" required style='width: 94pt;'/><select class="select-field" name='landtype'><%=landtype%><option>Marla</option><option>Kanal</option></select></label></td>
										</tr>
										<tr>
											<td><br><label for="field1"><span>City <span class="required">*</span></span></td>
											<td><select style='width:145pt;' class="select-field" id='area' required oninvalid="setCustomValidity('Please Select City')"
    onchange="try{setCustomValidity('')}catch(e){}" ><option><%=city %></option><%=AccountManagementJsp.ViewUserCityJSP(user) %></select></label></td>
											<td><label for="field1"><span>Area <span class="required">*</span></span></td>
											<td><select style='width:145pt;' class="select-field" id='areauser' name='a_id' required oninvalid="setCustomValidity('Please Select City')"
    onchange="try{setCustomValidity('')}catch(e){}" ><option><%=area %></option></select></label></td>
										</tr>
										<tr>
										<td colspan='4'>
											<br><textarea rows="4" cols="85" name='details' class="textarea-field" style='width:none;'><%=details %></textarea>
										</td>
										</tr>
									</table>
								</div><!-- new_details_input -->
								<br><h3><div class="form-style-2-heading">2- Ad Pictures</div></h3><br>
								<div class='wrapper_new_details_img'> 
									<div class='new_details_img'>
										<img id="blah1" src="../images/Directory/<%=img1 %>" alt="no image selected" style='height: 100%;width: 100%;' /><br>
									</div>
									<input type='file' onchange="readURL1(this);" accept="image/gif, image/jpeg, image/png" name="filetouplaod1">
							</div>
							<div class='wrapper_new_details_img'> 
								<div class='new_details_img'>
									<img id="blah2" src="../images/Directory/<%=img2 %>" alt="no image selected" style='height: 100%;width: 100%;' /><br>
								</div>
									<input type='file' onchange="readURL2(this);" accept="image/gif, image/jpeg, image/png" name="filetouplaod2">
							</div>
							<div class='wrapper_new_details_img'> 
								<div class='new_details_img'>
									<img id="blah3" src="../images/Directory/<%=img3 %>" alt="no image selected" style='height: 100%;width: 100%;' /><br>
								</div>
									<input type='file' onchange="readURL3(this);" accept="image/gif, image/jpeg, image/png"  name="filetouplaod3">
							</div>
							<div class='wrapper_new_details_img'> 
								<div class='new_details_img'>
									<img id="blah4" src="../images/Directory/<%=img4 %>" alt="no image selected" style='height: 100%;width: 100%;' /><br>
								</div>
									<input type='file' onchange="readURL4(this);" accept="image/gif, image/jpeg, image/png" name="filetouplaod4">
							</div>
						</div><!-- new_details -->
						<div class='google_map'>
							<br><br><h3><div class="form-style-2-heading">3- Google Map Markar</div></h3>
							<div class="searchMap">
    <label for="field1"><span>Search </span><input id="location" class="input-field" style='width:380pt;'/>
    <input type="button" id="search" value="Search" /></label>
</div>
							<div id="googleMap" style="width:100%;height:380px;margin-top: 20pt;"></div>
							<input type="text" id="log" value="umair" name='longitude' hidden><input type="text" id="lat" value="umair" name='latitude' hidden>
							<center><input type='submit' onclick="myFunction()" value='<%=method %>' style='margin-top:5pt;' class="myButton" ></center>
						</div>
					</div><!-- middle -->
					
				</div><!-- middle_right -->
			</div>
			</form>
			</div>
		</div><!-- container -->
		<%=AccountManagementJsp.AdminFooter() %>
		
  </body>
</html>