package com.manage_banner.hashim.Jap_Functions;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import com.Utility.umair.Connector;
import com.Utility.umair.Directory;
import com.Utility.umair.House;
import com.Utility.umair.User;
import com.Utility.umair.UserArea;
import com.Utility.umair.UserCity;
import com.manage_ad.hashim.DbLayer.AdManagementDb;
import com.manage_banner.hashim.DbLayer.BannerManagementDb;

public class BannerManagementJsp 
{
	public static String ViewBannerJsp(String email) throws SQLException
	{
		Directory.CreatDirectory(email);
		String img = "";
		//System.out.println(email);
		//email = "mumair1992@gmail.com";
		String path = Connector.ConnectorPath();
		File folder = new File(path+email);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				// System.out.println("File " + listOfFiles[i].getName());
				img = email+"/"+listOfFiles[i].getName();
			}
		}
		return "<a href='bnner.jsp'><img src='../images/Directory/"+img+"' style='width:100%; height:41pt;'></a>";
	}
	public static String ViewBannerJsp2(String email) throws SQLException
	{
		Directory.CreatDirectory(email);
		String img = "";
		//System.out.println(email);
		//email = "mumair1992@gmail.com";
		String path = Connector.ConnectorPath();
		File folder = new File(path+email);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				// System.out.println("File " + listOfFiles[i].getName());
				img = email+"/"+listOfFiles[i].getName();
			}
		}
		return "<a href='bnner.jsp'><img src='../images/Directory/"+img+"' style='width:100%; height:100%;'></a>";
	}
	public static String ViewBannerHomeJsp(String email) throws SQLException
	{
		Directory.CreatDirectory(email);
		String img = "";
		//System.out.println(email);
		//email = "mumair1992@gmail.com";
		String path = Connector.ConnectorPath();
		File folder = new File(path+email);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				// System.out.println("File " + listOfFiles[i].getName());
				img = email+"/"+listOfFiles[i].getName();
			}
		}
		return "<a href='panel/bnner.jsp'><img src='images/Directory/"+img+"' style='width:100%; height:41pt;'></a>";
	}
	public static String ViewBannerHomeInJsp(String email) throws SQLException
	{
		Directory.CreatDirectory(email);
		String img = "";
		//System.out.println(email);
		//email = "mumair1992@gmail.com";
		String path = Connector.ConnectorPath();
		File folder = new File(path+email);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				// System.out.println("File " + listOfFiles[i].getName());
				img = email+"/"+listOfFiles[i].getName();
			}
		}
		return "<a href='panel/bnner.jsp'><img src='../images/Directory/"+img+"' style='width:100%; height:41pt;'></a>";
	}
	public static String GetBanner(){
		String result = "";
		String Print = "";
		String email;
		String id;
		String img = "";
		List<User> string  = null;
		try{
			string  = BannerManagementDb.User();
		}
		catch(SQLException e){
			System.out.println(e);
		}
		if(string != null)
		{

			for(User ad:string)
			   {
				id = ad.id;
				email = ad.email;
				//System.out.println(email);
				String path = Connector.ConnectorPath();
				File folder = new File(path+email);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  img = email+"/"+listOfFiles[i].getName();
				      }
				    }
				   
				   Print +="<a href='profile.jsp?code="+id+"'><img src='../images/Directory/"+img+"' style='width:100pt; height:100pt;margin:2pt;'></a>";
			   }
			return Print;
		}
		return  result= "faild";
	}
	public static String GetUserBanner(String code){
		String result = "";
		String Print = "";
		String ads = "0";
		String email;
		String f_name;
		String l_name;
		String contact;
		String Organization;
		String img = "";
		String id = "";
		String city = "";
		String c_id = "";
		String area = "";
		List<User> string  = null;
		List<UserCity> UserCityArea = null;
		List<UserArea> UserArea = null;
		try{
			string  = BannerManagementDb.User(code);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		if(string != null)
		{

			for(User ad:string)
			   {
				id = ad.id;
				email = ad.email;
				f_name = ad.f_name;
				l_name = ad.l_name;
				contact = ad.contact;
				Organization = ad.Organization;
				//System.out.println(email);
				String path = Connector.ConnectorPath();
				File folder = new File(path+email);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  img = email+"/"+listOfFiles[i].getName();
				      }
				    }
				   
				  // Print +="<a href='profile.jsp?code="+id+"'><img src='../images/Directory/"+img+"' style='width:100pt; height:100pt;margin:2pt;'></a>";
				   Print +="<div class='agent_profile_top'>";
				   		Print +="<div class='agent_profile_top_logo'>";
						   Print +="<img src='../images/Directory/"+img+"' style='width:104pt; height:104pt;'>";
						Print +="</div><!-- agent_profile_top_logo -->";
						Print +="<div class='agent_profile_top_details'>";
						  	Print +="<div class='contact'>";
						  		Print +="<ul>";
						  			Print +="<li>";
						  				Print +="<table>";
						  					Print +="<tr>";
						  						Print +="<td>";
						  							Print +="<span class='phone'></span> <br>";
												Print +="</td>";
											    Print +="<td>";
													Print +=contact;
												Print +="</td>";
											Print +="<tr>";
											Print +="</tr>";
												Print +="<td>";
													Print +="<span class='email' style='margin-left:-1pt;'></span>";
												Print +="</td>";
												Print +="<td>";
													Print +=email;
												Print +="</td>";
											Print +="</tr>";
										Print +="</table>";
									Print +="</li>";
								Print +="</ul>";
							Print +="</div><!-- contact -->";
						Print +="</div><!-- agent_profile_top_details -->";
					Print +="</div><!-- agent_profile_top -->";
					Print +="<hr>";
					Print +="<div class='agent_profile'>";
						Print +="<table>";
							Print +="<col width='130'>";
								Print +="<tr>";
									Print +="<td  style='vertical-align:top'>";
										Print +="Name"; 
									Print +="</td>";
									Print +="<td  style='vertical-align:top'>";
										Print +=f_name+" "+l_name;
										Print +="<br><br>";
									Print +="</td>";
							Print +="</tr>";
							Print +="<tr>";
								Print +="<td  style='vertical-align:top'>";
									Print +="Organization ";
								Print +="</td>";
								Print +="<td  style='vertical-align:top'>";
									Print +=Organization;
									Print +="<br><br>";
								Print +="</td>";
							Print +="</tr>";
							Print +="<tr>";
								Print +="<td  style='vertical-align:top'>";
									Print +="Have Posted ";
								Print +="</td>";
								Print +="<td  style='vertical-align:top'>";
								try{
									ads =AdManagementDb.PageNumberAdNo(id);
								}
								catch(Exception e){
									
								}
									Print +=ads+" ad's so far";
									Print +="<br><br>";
								Print +="</td>";
							Print +="</tr>";
							Print +="<tr>";
								Print +="<td  style='vertical-align:top'>";
									Print +="Works in";
								Print +="</td>";
								Print +="<td  style='vertical-align:top'>";
									Print +="<table>";
										Print +="<col width='130'>";
										
											try {
												   UserCityArea = BannerManagementDb.UserCityArea(id);
											   } catch (Exception e) {
												// TODO: handle exception
											   }
											   for(UserCity add:UserCityArea)
											   {
												   city= add.city;
												   c_id = add.id;
												   Print +="<tr>";
													Print +="<td  style='vertical-align:top'>";
													Print +=city;
													Print +="</td>";
													Print +="<td  style='vertical-align:top'>";
												   try {
													   UserArea = BannerManagementDb.UserAreaCity(c_id,id);
												   } catch (Exception e) {
													// TODO: handle exception
												   }
												   for(UserArea addd:UserArea)
												   {
													   area = addd.area;
											
												Print +=area+",";
											
												   }
												   Print +="</td>";
													Print +="</tr>";
											   }
									Print +="</table>";
								Print +="</td>";
							Print +="</tr>";
							Print +="<tr>";
								
						Print +="</table>";
					Print +="</div>";
			   }
			   
			   
			return Print;
		}
		return  result= "faild";
	}
	public static String GetBanner(String user){
		String result = "";
		String Print = "";
		String email;
		String id;
		String img = "";
		List<User> string  = null;
		try{
			string  = BannerManagementDb.User(user);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		if(string != null)
		{

			for(User ad:string)
			   {
				id = ad.id;
				email = ad.email;
				//System.out.println(email);
				String path = Connector.ConnectorPath();
				File folder = new File(path+email);
				File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  img = email+"/"+listOfFiles[i].getName();
				      }
				    }
				   
				   Print +="<a href='profile.jsp?code="+id+"'><img src='../images/Directory/"+img+"' style='width:100pt; height:100pt;margin:2pt;'></a>";
			   }
			return Print;
		}
		return  result= "faild";
	}
}
