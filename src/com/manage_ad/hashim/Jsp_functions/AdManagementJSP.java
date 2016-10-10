package com.manage_ad.hashim.Jsp_functions;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import com.Utility.umair.AreaCityName;
import com.Utility.umair.Connector;
import com.Utility.umair.House;
import com.manage_ad.hashim.DbLayer.AdManagementDb;

public class AdManagementJSP {
	public static String GetAdHouse(){
		String result = "";
		String Print = "<ul>";
		String id;
		String price;
		String far;
		String type;
		String land;
		String date_time;
		String u_id;
		String g_id;
		String a_id;
		String img = "";
		/*String id = "21";
		try
		{
			id = AdManagementDb.viewAd();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		File folder = new File("C:\\Directory\\"+id);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		       // System.out.println("File " + listOfFiles[i].getName());
		    	  return  result = id+"/"+listOfFiles[i].getName();
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    return result;*/
		String area = "";
		String city = "";
		List<AreaCityName> AreaCityName  = null;
		List<House> string  = null;
		try{
			string  = AdManagementDb.viewAd("House");
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{

			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;
				
					try {
						AreaCityName = AdManagementDb.AreaCityNames(a_id);
					} catch (Exception e) {
						System.out.println(e);
					}
					for(AreaCityName ad1:AreaCityName)
					   {
					area = ad1.area;
					city = ad1.city;
					String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				Print += "<li>";
					Print += "<a href='search/search.jsp?code="+id+"'>";
						Print += "<div class='wraper_details_ad_container'>";
							Print += "<div class='img_wraper_details_ad_container'>";
								Print += "<img src='images/Directory/"+img+"' style='height:50pt;'>";
								//Print += "<img src='images/1.png'>";
							Print += "</div><!-- img_wraper_details_ad_container -->";
							Print += "<div class='content_wraper_details_ad_container'>";		
								Print += "<h4>";
									Print += "Price : "+price+"rs <br>";
									Print += "Location : "+area+", "+city+"<br>";
									Print += "Type : "+type;
								Print += "</h4>";
							Print += "</div><!-- content_wraper_details_ad_container -->";
							Print += "<div class='button_wraper_details_ad_container'>";
								Print += "<span class='details'><center>Details</center></span>";
							Print += "</div><!-- button_wraper_details_ad_container -->";
						Print += "</div><!-- wraper_details_ad_container -->";
					Print += "</a>";
				Print += "</li>";
				   }
			   }
			Print += "</ul>";
			return Print;
		}
		return  result= "faild";
	}
	public static String GetAdPlot(){
		String result = "";
		String Print = "<ul>";
		String id;
		String price;
		String far;
		String type;
		String land;
		String date_time;
		String u_id;
		String g_id;
		String a_id;
		String img = "";
		/*String id = "21";
		try
		{
			id = AdManagementDb.viewAd();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		File folder = new File("C:\\Directory\\"+id);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		       // System.out.println("File " + listOfFiles[i].getName());
		    	  return  result = id+"/"+listOfFiles[i].getName();
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    return result;*/
		String area = "";
		String city = "";
		List<AreaCityName> AreaCityName  = null;
		List<House> string  = null;
		try{
			string  = AdManagementDb.viewAd("Plot");
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{

			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;

				try {
					AreaCityName = AdManagementDb.AreaCityNames(a_id);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
				area = ad1.area;
				city = ad1.city;
				String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				Print += "<li>";
					Print += "<a href='search/search.jsp?code="+id+"'>";
						Print += "<div class='wraper_details_ad_container'>";
							Print += "<div class='img_wraper_details_ad_container'>";
								Print += "<img src='images/Directory/"+img+"' style='height:50pt;'>";
								//Print += "<img src='images/1.png'>";
							Print += "</div><!-- img_wraper_details_ad_container -->";
							Print += "<div class='content_wraper_details_ad_container'>";		
								Print += "<h4>";
									Print += "Price : "+price+"rs <br>";
									Print += "Location : "+area+", "+city+"<br>";
									Print += "Type : "+type;
								Print += "</h4>";
							Print += "</div><!-- content_wraper_details_ad_container -->";
							Print += "<div class='button_wraper_details_ad_container'>";
								Print += "<span class='details'><center>Details</center></span>";
							Print += "</div><!-- button_wraper_details_ad_container -->";
						Print += "</div><!-- wraper_details_ad_container -->";
					Print += "</a>";
				Print += "</li>";
				   }
			   }
			Print += "</ul>";
			return Print;
		}
		return  result= "faild";
	}
	public static String GetAdBangla(){
		String result = "";
		String Print = "<ul>";
		String id;
		String price;
		String far;
		String type;
		String land;
		String date_time;
		String u_id;
		String g_id;
		String a_id;
		String img = "";
		/*String id = "21";
		try
		{
			id = AdManagementDb.viewAd();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		File folder = new File("C:\\Directory\\"+id);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		       // System.out.println("File " + listOfFiles[i].getName());
		    	  return  result = id+"/"+listOfFiles[i].getName();
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    return result;*/
		String area = "";
		String city = "";
		List<AreaCityName> AreaCityName  = null;
		List<House> string  = null;
		try{
			string  = AdManagementDb.viewAd("Bangla");
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{

			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;

				try {
					AreaCityName = AdManagementDb.AreaCityNames(a_id);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
				area = ad1.area;
				city = ad1.city;
				String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				Print += "<li>";
					Print += "<a href='search/search.jsp?code="+id+"'>";
						Print += "<div class='wraper_details_ad_container'>";
							Print += "<div class='img_wraper_details_ad_container'>";
								//Print += "<img src='C:/Users/Umair/.eclipse/Directory/"+img+"' style='height:50pt;'>";
								Print += "<img src='C:\\Users\\Umair\\.eclipse\\Directory\\68\\1.jpg'>";
							Print += "</div><!-- img_wraper_details_ad_container -->";
							Print += "<div class='content_wraper_details_ad_container'>";		
								Print += "<h4>";
									Print += "Price : "+price+"rs <br>";
									Print += "Location : "+area+", "+city+"<br>";
									Print += "Type : "+type;
								Print += "</h4>";
							Print += "</div><!-- content_wraper_details_ad_container -->";
							Print += "<div class='button_wraper_details_ad_container'>";
								Print += "<span class='details'><center>Details</center></span>";
							Print += "</div><!-- button_wraper_details_ad_container -->";
						Print += "</div><!-- wraper_details_ad_container -->";
					Print += "</a>";
				Print += "</li>";
				   }
			   }
			Print += "</ul>";
			return Print;
		}
		return  result= "faild";
	}
	public static String GetAdShop(){
		String result = "";
		String Print = "<ul>";
		String id;
		String price;
		String far;
		String type;
		String land;
		String date_time;
		String u_id;
		String g_id;
		String a_id;
		String img = "";
		/*String id = "21";
		try
		{
			id = AdManagementDb.viewAd();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		File folder = new File("C:\\Directory\\"+id);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		       // System.out.println("File " + listOfFiles[i].getName());
		    	  return  result = id+"/"+listOfFiles[i].getName();
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    return result;*/
		String area = "";
		String city = "";
		List<AreaCityName> AreaCityName  = null;
		List<House> string  = null;
		try{
			string  = AdManagementDb.viewAd("shop");
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{

			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;

				try {
					AreaCityName = AdManagementDb.AreaCityNames(a_id);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
				area = ad1.area;
				city = ad1.city;
				String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				Print += "<li>";
					Print += "<a href='search/search.jsp?code="+id+"'>";
						Print += "<div class='wraper_details_ad_container'>";
							Print += "<div class='img_wraper_details_ad_container'>";
								Print += "<img src='images/Directory/"+img+"' style='height:50pt;'>";
								//Print += "<img src='images/1.png'>";
							Print += "</div><!-- img_wraper_details_ad_container -->";
							Print += "<div class='content_wraper_details_ad_container'>";		
								Print += "<h4>";
									Print += "Price : "+price+"rs <br>";
									Print += "Location : "+area+", "+city+"<br>";
									Print += "Type : "+type;
								Print += "</h4>";
							Print += "</div><!-- content_wraper_details_ad_container -->";
							Print += "<div class='button_wraper_details_ad_container'>";
								Print += "<span class='details'><center>Details</center></span>";
							Print += "</div><!-- button_wraper_details_ad_container -->";
						Print += "</div><!-- wraper_details_ad_container -->";
					Print += "</a>";
				Print += "</li>";
				   }
			   }
			Print += "</ul>";
			return Print;
		}
		return  result= "faild";
	}
	public static String ViewAdPanel(String user,int add){
		//System.out.println(user);
		String result = "";
		String id;
		String price;
		String far;
		String type;
		String land;
		String date_time;
		String u_id;
		String g_id;
		String a_id;
		String img = "";
		String Print = "No Ads Found!";
		List<House> string  = null;
		try{
			string  = AdManagementDb.viewAdUser(user,add);
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{
			Print = "";
			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;
				String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) 
				    {
				      if (listOfFiles[i].isFile()) 
				      {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				    Print += "<div class='wrapper_search_manage_ad'>"
						+ "<div class='image_details_wrapper_search_manage_ad'>"
							+ "<div class='image_wrapper_search_manage_ad'>"
								+"<img src='../images/Directory/"+img+"' style='height:100%;width:100%'>"
							+ "</div><!-- image_wrapper_search_manage_ad -->"
							+ "<span style='float:right; font-size: 9pt;'><form action='new.jsp' method='get' style='float:left'><input type='text' name='p_id' value='"+id+"' hidden><input type='submit' value='Edit' name='update' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'> </form>| <form action='../DeleteAdPath' method='post' style='float:right'><input type='text' value='"+user+"' name='user' hidden><input type='text' value='"+id+"' name='id' hidden><input type='submit' value='Delete' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'></form></span>"
								+ "<div class='details_wrapper_search_manage_ad'>"
									+ "<ul>"
										+ "<li>Price : "+price+" rs</li>"
										+ "<li>Location : G7-1, Islamabad</li>"
										+ "<li>Type : "+type+"</li>"
										+ "<li>Land Area : "+land+"</li>"
									+ "</ul>"
									+date_time
								+ "</div><!-- details_wrapper_search_manage_ad -->"
							+ "</div><!-- image_details_wrapper_search_manage_ad -->"
							+ "<div class='google_map_wrapper_search_manage_ad'>"
						+ "</div>"
					+ "</div><!-- wrapper_search_manage_ad -->";
				//System.out.println(Print); 
			   }
			//System.out.println(Print);
			return Print;
		}
		return Print;
	}
	public static String GetAd(int add){
		String result = "";
		String Print = "";
		String id;
		String price;
		String far;
		String type;
		String land;
		String city;
		String area;
		String date_time;
		String g_id;
		String a_id;
		String img = "";
		List<House> string  = null;

		List<AreaCityName> AreaCityName  = null;
		try{
			string  = AdManagementDb.viewAd(add);
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{

			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				g_id = ad.g_id;
				a_id = ad.a_id;
				try {
					AreaCityName = AdManagementDb.AreaCityNames(a_id);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
					area = ad1.area;
					city = ad1.city;
					String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				    Print += "<a href='search.jsp?code="+id+"'>";
					
				    Print += "<div class='wraper_details_ad_container'>";
				    		Print += "<div class='img_wraper_details_ad_container'>";
				    			Print += "<img src='../images/Directory/"+img+"' height='75pt'>";
				    		Print += "</div><!-- img_wraper_details_ad_container -->";
							Print += "<div class='content_wraper_details_ad_container'>";			
				    			Print += "<h4>";
				    				Print += "Price : Rs "+price+" <br>";
				    				Print += "Location : "+area+", "+city+"<br>";
				    				Print += "Type : "+type+"";
				    			Print += "</h4>	";
				    		Print += "</div><!-- content_wraper_details_ad_container -->";
							Print += "<div class='button_wraper_details_ad_container'>";
								Print += "<span class='details'><center>Details</center></span>";
				    		Print += "</div><!-- button_wraper_details_ad_container -->";
					Print += "</div><!-- wraper_details_ad_container -->"
							+ "</a>";
				   }
			   }
			Print += "";
			return Print;
		}
		return  result= "faild";
	}
	public static String SearchResult(String code){
		String result = "";
		String Print = "";
		String id;
		String price;
		String far;
		String type;
		String land;
		String date_time;
		String g_id;
		String a_id;
		String city;
		String area;
		String img1 = "";
		String img2 = "";
		String img3 = "";
		String img4 = "";
		String landtype;
		String details;
		List<House> string  = null;
		List<AreaCityName> AreaCityName  = null;
		
		try{
			string  = AdManagementDb.SearchResult(code);
		}
		catch(SQLException e){
			
		}
		
		if(string != null)
		{

			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				String[] spliter = date_time.split(" 00:00:00.0");
				date_time = spliter[0];
				g_id = ad.g_id;
				a_id = ad.a_id;
				landtype = ad.landtype;
				details = ad.details;
				try {
					AreaCityName = AdManagementDb.AreaCityNames(a_id);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
					area = ad1.area;
					city = ad1.city;
					 Print+="<div class='ad_images_area'>"
					    		+ "<div id='wowslider-container0'>"
					    			+ "<div class='ws_images'>"
					    				+ "<ul>";
					 String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img1 = id+"/"+listOfFiles[i].getName();
				      
				   int a = i+1;
				    Print+= "<li><img src='../images/Directory/"+img1+"' alt='"+a+"' title='"+a+"' id='wows0_"+i+"'/></li>";
				      }
				    }
				    Print+= "</ul>"
				    		+ "</div>"
				    		+ "<div class='ws_thumbs'>"
				    		+ "<div>";
				    for (int i = 0; i < listOfFiles.length; i++) {
					      if (listOfFiles[i].isFile()) {
					       // System.out.println("File " + listOfFiles[i].getName());
					    	  img1 = id+"/"+listOfFiles[i].getName();
					      
					   int a = i+1;
				    Print+= "<a href='#wows0_"+i+"' title='"+a+"'><img src='../images/Directory/"+img1+"' alt='' /></a>";
				   }
			    }
			Print+= "</div>"
				    		+ "</div>"
				    		+ "<div class='ws_script' style='position:absolute;left:-99%'>"
				    				+ "<a href='http://wowslider.com'>jquery image slider</a> by WOWSlider.com v7.8</div>"
				    				+ "<div class='ws_shadow'></div>"
				    				+ "</div>"
				    				+ "<script type='text/javascript' src='engine0/wowslider.js'></script>"
				    						+ "<script type='text/javascript' src='engine0/script.js'></script>"
				    						+ "</div><!-- ad_images_area -->"
				    						+ "<div class='ad_details'>"
				    						+ "<div class='detsils'>"
					    						+ "<table>"
					    							+ "<col width='50'>"
					    							+ "<col width='130'>"
					    							+ "<col width='80'>"
					    							+ "<col width='100'>"
					    								+ "<tr>"
					    									+ "<td colspan='4' style='color:tomato;'><h1>Price : Rs "+price+"</h1></td>"
					    								+ "</tr>"
					    								+ "<tr>"
					    									+ "<td>For :</td>"
					    									+ "<td>"+far+"</td>"
					    									+ "<td>Type :</td>"
					    									+ "<td>"+type+"</td>"
					    								+ "</tr>"
					    								+ "<tr>"
					    									+ "<td>City :</td>"
					    									+ "<td>"+city+"</td>"
					    									+ "<td>Location :</td>"
					    									+ "<td>"+area+"</td>"
					    								+ "</tr>"
					    								+ "<tr>"
					    									+ "<td>Area :</td>"
					    									+ "<td>"+land+""+landtype+"</td>"
					    									+ "<td>Posted On :</td>"
					    									+ "<td>"+date_time+"</td>"
					    								+ "</tr>"
					    						+ "</table>"
				    							+ "</div>"
				    								+ "<div class='contact'>"
				    									+ "<ul>"
				    										+ "<li>"
				    											+ "<img src='../images/logo.png'></li>"
				    										+ "<li>"
				    										+ "<table>"
				    											+ "<tr>"
				    												+ "<td>"
				    													+ "<span class='phone'></span> <br>"
				    												+ "</td>"
				    												+ "<td>"
				    													+ "03205444004"
				    												+ "</td>"
				    											+ "<tr>"
				    											+ "</tr>"
				    												+ "<td>"
				    													+ "<span class='email' style='margin-left:-1pt;'></span>"
				    												+ "</td>"
				    												+ "<td>"
				    													+ "yasirali19@yahoo.com"
				    												+ "</td>"
				    												+ "</tr>"
				    										+ "</table>"
				    										+ "</li>"
				    									+ "</ul>"
				    									
				    								+ "</div>"
				    								+ "<div> <strong>Details:</strong> <br>"+details+"</div>"
				    							+ "</div>"
				    							
				    							+ "<div class='ad_map' id='googleMap' style='margin-top:21pt;'>"
				    							+ "</div>"
				    							+ "";
					
					
					
						
								
								
							
						
				   }	
				  
			   }
			Print += "";
			return Print;
		}
		return  result= "faild";
	}
	public static String GetAd(String price_range,String price_area,String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far,int add){
		String result = "";
		String Print = "";
		String id;
		String price;
		//String far;
		//String type;
		String land;
		String city_to_pass = city;
		String area_to_pass= area;
		//System.out.println(area);
		String landtype;
		String date_time;
		String g_id;
		String a_id;
		String img = "";
		List<House> string  = null;

		List<AreaCityName> AreaCityName  = null;
		try{
			string  = AdManagementDb.viewAd(upper_price,lower_price,upper_area,lower_area,city,area,type,far,add);
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{

			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				g_id = ad.g_id;
				a_id = ad.a_id;

				landtype = ad.landtype;
				try {
					AreaCityName = AdManagementDb.AreaCityNames(a_id);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
					area = ad1.area;
					city = ad1.city;
					String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				    Print += "<a href='search.jsp?code="+id+"&price_range="+price_range+"&price_area="+price_area+"&city="+city_to_pass+"&area="+area_to_pass+"&type="+type+"&far="+far+"&search_buttons=true'>";
					
				    Print += "<div class='wraper_details_ad_container'>";
				    		Print += "<div class='img_wraper_details_ad_container'>";
				    			Print += "<img src='../images/Directory/"+img+"' height='75pt'>";
				    		Print += "</div><!-- img_wraper_details_ad_container -->";
							Print += "<div class='content_wraper_details_ad_container'>";			
				    			Print += "<h4>";
				    				Print += "Price : Rs "+price+" <br>";
				    				Print += "Location : "+area+", "+city+"<br>";
				    				Print +=  "Land Area : "+land+landtype+"<br>";
				    			Print += "</h4>	";
				    		Print += "</div><!-- content_wraper_details_ad_container -->";
							Print += "<div class='button_wraper_details_ad_container'>";
								Print += "<span class='details'><center>Details</center></span>";
				    		Print += "</div><!-- button_wraper_details_ad_container -->";
					Print += "</div><!-- wraper_details_ad_container -->"
							+ "</a>";
				   }
			   }
			Print += "";
			return Print;
		}
		return  result= "faild";
	}
	public static String ViewAdPanelInt(int add){
		//System.out.println(user);
		String result = "";
		String id;
		String price;
		String far;
		String type;
		String land;
		String date_time;
		String landtype;
		String u_id;
		String g_id;
		String a_id;
		String area;
		String city;
		String img = "";
		String Print = "No Ads Found!";
		List<House> string  = null;
		List<AreaCityName> AreaCityName  = null;
		
		try{
			string  = AdManagementDb.viewAdUser(add);
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{
			Print = "";
			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				landtype = ad.landtype;
				String[] spliter = date_time.split(" 00:00:00.0");
				date_time = spliter[0];
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;
				try {
					AreaCityName = AdManagementDb.AreaCityNames(a_id);
				} catch (Exception e) {
					System.out.println(e);
				}
				for(AreaCityName ad1:AreaCityName)
				   {
				area = ad1.area;
				city = ad1.city;
				
				String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) 
				    {
				      if (listOfFiles[i].isFile()) 
				      {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				    Print += "<div class='wrapper_search_manage_ad'>"
						+ "<div class='image_details_wrapper_search_manage_ad'>"
							+ "<div class='image_wrapper_search_manage_ad'>"
								+"<img src='../images/Directory/"+img+"' style='height:100%;width:100%'>"
							+ "</div><!-- image_wrapper_search_manage_ad -->"
							+ "<span style='float:right; font-size: 9pt;'><form action='new.jsp' method='get' style='float:left'><input type='text' name='p_id' value='"+id+"' hidden><input type='submit' value='Edit' name='update' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'> </form>| <form action='../DeleteAdAdminPath' method='post' style='float:right'><input type='text' value='"+id+"' name='id' hidden><input type='submit' value='Delete' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'></form></span>"
								+ "<div class='details_wrapper_search_manage_ad'>"
									+ "<ul>"
										+ "<li>Price : "+price+" rs</li>"
										+ "<li>Location : "+area+","+city+"</li>"
										+ "<li>Type : "+type+"</li>"
										+ "<li>Land Area : "+land+landtype+"</li>"
									+ "</ul>"
									+date_time
								+ "</div><!-- details_wrapper_search_manage_ad -->"
							+ "</div><!-- image_details_wrapper_search_manage_ad -->"
							+ "<div class='google_map_wrapper_search_manage_ad'>"
						+ "</div>"
					+ "</div><!-- wrapper_search_manage_ad -->";
				//System.out.println(Print); 
			   }
			   }
			//System.out.println(Print);
			return Print;
		}
		return Print;
	}
	public static String ViewAdPanel(String price_range,String price_area,String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far,int add){
		//System.out.println(user);
		String result = "";
		String id;
		String price;
		//String far;
		String landtype;
		String land;
		String date_time;
		String u_id;
		String g_id;
		String a_id;
		String img = "";
		String Print = "No Ads Found!";
		List<House> string  = null;
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
		try{
			string  = AdManagementDb.viewAdUser(upper_price,lower_price,upper_area,lower_area,city,area,type,far,add);
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{
			Print = "";
			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				landtype = ad.landtype;
				land = ad.land;
				date_time = ad.date_time;

				String[] spliter = date_time.split(" 00:00:00.0");
				date_time = spliter[0];
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;
				String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) 
				    {
				      if (listOfFiles[i].isFile()) 
				      {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				    Print += "<div class='wrapper_search_manage_ad'>"
						+ "<div class='image_details_wrapper_search_manage_ad'>"
							+ "<div class='image_wrapper_search_manage_ad'>"
								+"<img src='../images/Directory/"+img+"' style='height:100%;width:100%'>"
							+ "</div><!-- image_wrapper_search_manage_ad -->"
							+ "<span style='float:right; font-size: 9pt;'><form action='new.jsp' method='get' style='float:left'><input type='text' name='p_id' value='"+id+"' hidden><input type='submit' value='Edit' name='update' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'> </form>| <form action='../DeleteAdAdminPath' method='post' style='float:right'><input type='text' value='"+id+"' name='id' hidden><input type='submit' value='Delete' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'></form></span>"
								+ "<div class='details_wrapper_search_manage_ad'>"
									+ "<ul>"
										+ "<li>Price : "+price+" rs</li>"
										+ "<li>Location : "+area+","+city+"</li>"
										+ "<li>Type : "+type+"</li>"
										+ "<li>Land Area : "+land+landtype+"</li>"
									+ "</ul>"
									+date_time
								+ "</div><!-- details_wrapper_search_manage_ad -->"
							+ "</div><!-- image_details_wrapper_search_manage_ad -->"
							+ "<div class='google_map_wrapper_search_manage_ad'>"
						+ "</div>"
					+ "</div><!-- wrapper_search_manage_ad -->";
				//System.out.println(Print); 
			   }
			//System.out.println(Print);
			return Print;
		}
		return Print;
	}
	public static String ViewAdPanelUser(String user,String price_range,String price_area,String upper_price,String lower_price,String upper_area,String lower_area,String city,String area,String type,String far,int add){
		//System.out.println(user);
		String result = "";
		String id;
		String price;
		//String far;
		//String type;
		String landtype;
		String land;
		String date_time;
		String u_id;
		String g_id;
		String a_id;
		String img = "";
		String Print = "No Ads Found!";
		List<House> string  = null;
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
		try{
			string  = AdManagementDb.viewAdUser(user,upper_price,lower_price,upper_area,lower_area,city,area,type,far,add);
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{
			Print = "";
			for(House ad:string)
			   {
				
				id = ad.id;
				price = ad.price;
				far = ad.far;
				type = ad.type;
				land = ad.land;
				date_time = ad.date_time;
				landtype = ad.landtype;
				String[] spliter = date_time.split(" 00:00:00.0");
				date_time = spliter[0];
				u_id = ad.u_id;
				g_id = ad.g_id;
				a_id = ad.a_id;
				String path = Connector.ConnectorPath();
				File folder = new File(path+id);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) 
				    {
				      if (listOfFiles[i].isFile()) 
				      {
				       // System.out.println("File " + listOfFiles[i].getName());
				    	  img = id+"/"+listOfFiles[i].getName();
				      }
				    }
				    Print += "<div class='wrapper_search_manage_ad'>"
						+ "<div class='image_details_wrapper_search_manage_ad'>"
							+ "<div class='image_wrapper_search_manage_ad'>"
								+"<img src='../images/Directory/"+img+"' style='height:100%;width:100%'>"
							+ "</div><!-- image_wrapper_search_manage_ad -->"
							+ "<span style='float:right; font-size: 9pt;'><form action='new.jsp' method='get' style='float:left'><input type='text' name='p_id' value='"+id+"' hidden><input type='submit' value='Edit' name='update' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'> </form>| <form action='../DeleteAdAdminPath' method='post' style='float:right'><input type='text' value='"+id+"' name='id' hidden><input type='submit' value='Delete' style='background:none;border:none;font-size: 9pt;cursor:pointer;color: #555;'></form></span>"
								+ "<div class='details_wrapper_search_manage_ad'>"
									+ "<ul>"
										+ "<li>Price : "+price+" rs</li>"
										+ "<li>Location : "+area+","+city+"</li>"
										+ "<li>Type : "+type+"</li>"
										+ "<li>Land Area : "+land+landtype+"</li>"
									+ "</ul>"
									+date_time
								+ "</div><!-- details_wrapper_search_manage_ad -->"
							+ "</div><!-- image_details_wrapper_search_manage_ad -->"
							+ "<div class='google_map_wrapper_search_manage_ad'>"
						+ "</div>"
					+ "</div><!-- wrapper_search_manage_ad -->";
				//System.out.println(Print); 
			   }
			//System.out.println(Print);
			return Print;
		}
		return Print;
	}
}