package com.manage_account.umair.Jsp_functions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import com.Utility.umair.City;
import com.Utility.umair.User;
import com.Utility.umair.UserCity;
import com.create_agent.umair.DbLayer.ConnetDb;
import com.manage_account.umair.Dblayer.AccountManagementDb;
import com.manage_location.hashim.DbLayer.LocationManagementDb;

import java.util.List;
public class AccountManagementJsp {
	public static String ViewProfilejsp(String User){
		String f_name = "";
		String l_name = "";
		String contact = "";
		String organization = "";
		List<User> resutl = null;
		String Return = "";
		try{
			resutl = AccountManagementDb.ViewProfile(User);
			
		}
		catch(SQLException e)
		{
			System.out.println(e+"faild to call function pakage : com.manage_account.umair.Jsp_functions; method : profilejsp");
		}
		for(User req:resutl)
		   {
			String setCustomValidity = "setCustomValidity('must contain 3 or more letters only with no space')";
			String setCustomValidity2 = "setCustomValidity('must contain 11 characters that are srart with 03 and contain number only')";
			String onchange = "try{setCustomValidity('')}catch(e){}"; 
			   f_name = req.f_name;
			   l_name = req.l_name;
			   contact = req.contact;
			   organization = req.Organization;
			   Return = "<div class='form-style-2'>"
			   		+ "<table id='hide'>"
					   		+"<col width='150'>"
					   		+"<col width='200'>"
					   		+"<tr>"
					   			+"<td><b>First Name</b></td>"
					   			+"<td>"+f_name+"</td>"
					   		+"</tr>"
					   		+"<tr>"
					   			+"<td><b>Last Name</b></td>"
					   			+"<td>"+l_name+"</td>"
					   		+"</tr>"
					   		+"<tr>"
					   			+"<td><b>Contact</b></td>"	
					   			+"<td>"+contact+"</td>"
					   		+"</tr>"
					   		+"<tr>"
					   			+"<td><b>Oganization</b></td>"
					   			+"<td>"+organization+"</td>"
					   		+"</tr>"
					   		+"<tr>"
					   			+"<td colspan='2' style='padding-top:6pt;'>"
					   				+"<center><input class='myButton' type='button'id='update' value='update'></center>"
					   			+"</td>"
					   		+ "</tr>"
					   	+ "</table>"
					   	+ "<form method='post' action='../UpdateProfilePath'>"
					    +"<table hidden id='show'>"
				   		+"<col width='150'>"
				   		+"<col width='200'>"
				   		+"<tr>"
				   			+"<td><label for='field1'><span>First Name<span class='required'>*</span></span></td>"
				   			+"<td><input type='text' class='input-field' value='"+f_name+"' required name='f_name' pattern='[a-zA-Z]{3,}' oninvalid=\""+setCustomValidity+"\" onchange=\""+onchange+"\"></label></td>"
				   		+"</tr>"
				   		+"<tr>"
				   			+"<td><label for='field1'><span>Last Name<span class='required'>*</span></span></td>"
				   			+"<td><input type='text' class='input-field' value='"+l_name+"' required name='l_name' oninvalid=\""+setCustomValidity+"\" onchange=\""+onchange+"\"></label></td>"
				   		+"</tr>"
				   		+"<tr>"
				   			+"<td><label for='field1'><span>Contact<span class='required'>*</span></span></td>"	
				   			+"<td><input type='text' class='input-field' value='"+contact+"' required name='contact' pattern='[03]{2}[0-9]{9}' oninvalid=\""+setCustomValidity2+"\" onchange=\""+onchange+"\"></label></td>"
				   		+"</tr>"
				   		+"<tr>"
				   			+"<td><label for='field1'><span>Organization<span class='required'>*</span></span></td>"
				   			+"<td><input type='text' class='input-field' value='"+organization+"' required name='organization' pattern='[a-zA-Z]{3,}' oninvalid=\""+setCustomValidity+"\" onchange=\""+onchange+"\"></label></td>"
				   		+"</tr>"
				   		+"<tr>"
				   			+"<td colspan='2' style='padding-top:6pt;'>"
				   			+ "<input type='text' value='"+User+"' name='id' hidden>"
				   				+"<center><input class='myButton' type='submit'id='update' value='save' ></center>"
				   			+"</td>"
				   		+ "</tr>"
				   	+ "</form>"
				   	+ "</table>"
				   	+ "</div>";
		   }
		return Return;
	}
	public static String ChangePasswordJsp(String User){
		String setCustomValidity = "setCustomValidity('must contain 8 to 10 characters that are of at least one number, and one uppercase and lowercase letter')";
		String onchange = "try{setCustomValidity('')}catch(e){}";
		String onkeyup = "checkPasswordMatch();";
		String Resutl = ""
				
				+ "<div class='form-style-2'>"
				+ "<input type='button' value='Chnage Password' id='pass' id='hide_pass'>"
				+ "<form action='../ChangePasswordPath' method='post' onsubmit='return checkpass()'>"
					+ "<table hidden id='show_pass'>"
						+ "<col width='200' >"
						+ "<col width='200'>"
						+ "<tr>"
							+"<td><label for='field1'><span>Current Password<span class='required'>*</span></span></td>"
							+ "<td><input type='text' value='"+User+"' name='user' hidden><input type='text'  class='input-field' required pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}' placeholder='*********' name='opassword' oninvalid=\""+setCustomValidity+"\" onchange=\""+onchange+"\" /></label></td>"
						+ "</tr>"
						+ "<tr>"
							+"<td><label for='field1'><span>New Password<span class='required'>*</span></span></td><div id='a'></div>"
							+ "<td><input type='text' required  class='input-field' id='txtNewPassword' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}' placeholder='*********' name='password' oninvalid=\""+setCustomValidity+"\" onchange=\""+onchange+"\" /></label></td>"
						+ "</tr>"
						+ "<tr>"
							+"<td><label for='field1'><span>Confrm New Password<span class='required'>*</span></span></td><div id='b'></div>"
							+ "<td><input type='text' name='Cpassword'  class='input-field' id='txtConfirmPassword' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}'  required onkeyup=\""+onkeyup+"\" ></label></td>"
						+ "</tr>"
						+ "<tr>"
							+ "<td colspan='2' style=''><br><center><input class='myButton' type='submit' value='save'></center></td>"
						+ "</tr>"
					+ "</table>"
				+ "</form>"
				+ "</div>";
		return Resutl;
	}
	public static String ViewCityListJSP(String user){
		String c_id;
		String id;
		String city;
		String Print = "<span style='font-size:8pt;'>You are not inroled in any city</span>";
		/*
											Islamabad<a href="#"><span class='cross'></span></a><br>
											Lahore<a href="#"><span class='cross'></span></a><br>
											Peshawer<a href="#"><span class='cross'></span></a><br>
		 */ 
		List<UserCity> string  = null;
		try{
			string  = AccountManagementDb.ViewUserCity(user);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		if(string != null)
		{
			Print = "";
			for(UserCity ad:string)
			   {
				id = ad.id;
				c_id = ad.c_id;
				city = ad.city;
				    Print += "<input type='button' id='"+id+"' value='"+city+"' onclick='cityval("+id+")' style='background:none;border:none;'><a href='#'><span class='cross' onClick='toDelete("+id+");'></span></a><br>";
				//System.out.println(Print); 
			   }
			//System.out.println(Print);
			//return Print;
		}
		if(string == null)
		{
			Print = "<span style='font-size:8pt;'>You are not inroled in any city</span>";
		}
		return Print;
	}
	public static String DeleteArea(String area,String user) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		String query2 = "SELECT uc_id FROM user_area WHERE a_id='"+area+"'";
		try (
			Statement st2 = connection.createStatement();
			ResultSet rs = st2.executeQuery(query2);)
		{
			if (rs.next())
			{
				String User_city =  rs.getString("uc_id");
				String query3 = "SELECT COUNT(uc_id) AS uc_id FROM user_area WHERE uc_id='"+User_city+"'";
				try (
					Statement st3 = connection.createStatement();
					ResultSet r3 = st3.executeQuery(query3);)
				{
					if (r3.next())
					{
						int uc_id =  r3.getInt("uc_id");
						if(uc_id == 1)
						{
							String query = "DELETE FROM user_city WHERE uc_id='"+User_city+"'";
							try (
									Statement st = connection.createStatement();
									)	
							{
								if (st.executeUpdate(query) > 0) 
								{
									re = "true";
								}
								
							} catch (SQLException e) {
								System.out.println(e.getMessage()+"  Method : delete area not prepared in pakage :  com.manage_location.hashim.DbLayer");
								return re = null;
							}
						}
						
					}
				}
			}
		}
		String query = "DELETE FROM user_area WHERE a_id='"+area+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				re = "true";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : delete area not prepared in pakage :  com.manage_location.hashim.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static String ViewUserCityJSP(String user){
		String c_id;
		String id;
		String city;
		String Print = "<span style='font-size:8pt;'>You are not inroled in any city</span>";
		/*
											Islamabad<a href="#"><span class='cross'></span></a><br>
											Lahore<a href="#"><span class='cross'></span></a><br>
											Peshawer<a href="#"><span class='cross'></span></a><br>
		 */ 
		List<UserCity> string  = null;
		try{
			string  = AccountManagementDb.ViewUserCity(user);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		if(string != null)
		{
			Print = "";
			for(UserCity ad:string)
			   {
				id = ad.id;
				c_id = ad.c_id;
				city = ad.city;
				    Print += "<option value='"+id+"'>"+city+"</option>";
				//System.out.println(Print); 
			   }
			//System.out.println(Print);
			//return Print;
		}
		if(string == null)
		{
			Print = "<span style='font-size:8pt;'>You are not inroled in any city</span>";
		}
		return Print;
	}
	public static String Footer(){
		String print = "<div class='footer_container'>"
							+ "<div class='footer'>"
								+ "<div class='footer_ul'>"
									+ "<div class='footer_ul_list'>"
										+ "<ul>"
											+ "<li><h4>Company</h4></li>"
											+ "<li><a href='about.jsp'>About Us</a></li>"
											+ "<li><a href='wanted.jsp'>Contact Us</a></li>"
											+ "<li><a href='wanted.jsp'>Work With Us</a></li>"
											+ "<li><a href='#'>Help & Support</a></li>"
											+ "<li><a href='wanted.jsp'>Advertise on Waelth Pakistan</a></li>"
											+ "<li><a href='#'>Terms of Use</a></li>"
										+ "</ul>"
									+ "</div><!-- footer ul list -->"
								+ "</div><!-- footer ul ul -->"
							+ "<div class='footer_ul'>"
								+ "<li><h4>WPPS.com</h4></li>"
								+ "<div class='footer_ul_icons'>"
									+ "<span class='adrs'></span><br><br>"
									+ "<span class='phone'></span>"
									+ "<span class='email'></span>"
								+ "</div><!-- footer ul icons -->"
								+ "<div class='footer_ul_list'>"
									+ "<ul style='color:#F3F3F3;'>"
									+ "<li>G-11, Markaz,</li>"
									+ "<li>Islamabad, Pakistan</li><br>"
									+ "<li>(+92) 42 3835 4444</li>&nbsp;"
									+ "<li><a href='wanted.jsp'>Email Us</a></li>"
								+ "</ul>"
							+ "</div><!-- footer ul list -->"
						+ "</div><!-- footer ul -->"
						+ "<div class='footer_ul'>"
							+ "<li><h4>FOLLOW US</h4></li>"
							+ "<div class='footer_ul_icons'>"
								+ "<span class='facebook'></span>"
								+ "<span class='twitter'></span>"
								+ "<span class='google'></span>"
								+ "<span class='linkedin'></span>"
							+ "</div><!-- footer ul icons -->"
							+ "<div class='footer_ul_list'>"
								+ "<ul class='space'>"
									+ "<li><a href='https://www.facebook.com/wealthpakistan' target='_blank'>Like us on Facebook</a></li>"
									+ "<li><a href='#'>Follow us on Twitter</a></li>"
									+ "<li><a href='#'>Share us on Google+</a></li>"
									+ "<li><a href='#'>Consult us on Linkedin</a></li>"
								+ "</ul>"
							+ "</div><!-- footer ul list -->"
						+ "</div><!-- footer ul -->"
					+ "</div><!-- footer -->"
				+ "</div><!-- footer container -->";
			return print;
	}
	public static String AdminFooter(){
		String print = "<div class='footer_container'>"
							+ "<div class='footer'>"
								+ "<div class='footer_ul'>"
									+ "<div class='footer_ul_list'>"
										+ "<ul>"
											+ "<li><h4>Company</h4></li>"
											+ "<li><a href='../about.jsp'>About Us</a></li>"
											+ "<li><a href='../wanted.jsp'>Contact Us</a></li>"
											+ "<li><a href='../wanted.jsp'>Work With Us</a></li>"
											+ "<li><a href='#'>Help & Support</a></li>"
											+ "<li><a href='../wanted.jsp'>Advertise on Waelth Pakistan</a></li>"
											+ "<li><a href='#'>Terms of Use</a></li>"
										+ "</ul>"
									+ "</div><!-- footer ul list -->"
								+ "</div><!-- footer ul ul -->"
							+ "<div class='footer_ul'>"
								+ "<li><h4>WPPS.com</h4></li>"
								+ "<div class='footer_ul_icons'>"
									+ "<span class='adrs'></span><br><br>"
									+ "<span class='phone'></span>"
									+ "<span class='email'></span>"
								+ "</div><!-- footer ul icons -->"
								+ "<div class='footer_ul_list'>"
									+ "<ul style='color:#F3F3F3;'>"
									+ "<li>G-11, Markaz,</li>"
									+ "<li>Islamabad, Pakistan</li><br>"
									+ "<li>(+92) 42 3835 4444</li>&nbsp;"
									+ "<li><a href='../wanted.jsp'>Email Us</a></li>"
								+ "</ul>"
							+ "</div><!-- footer ul list -->"
						+ "</div><!-- footer ul -->"
						+ "<div class='footer_ul'>"
							+ "<li><h4>FOLLOW US</h4></li>"
							+ "<div class='footer_ul_icons'>"
								+ "<span class='facebook'></span>"
								+ "<span class='twitter'></span>"
								+ "<span class='google'></span>"
								+ "<span class='linkedin'></span>"
							+ "</div><!-- footer ul icons -->"
							+ "<div class='footer_ul_list'>"
								+ "<ul class='space'>"
									+ "<li><a href='https://www.facebook.com/wealthpakistan' target='_blank'>Like us on Facebook</a></li>"
									+ "<li><a href='#'>Follow us on Twitter</a></li>"
									+ "<li><a href='#'>Share us on Google+</a></li>"
									+ "<li><a href='#'>Consult us on Linkedin</a></li>"
								+ "</ul>"
							+ "</div><!-- footer ul list -->"
						+ "</div><!-- footer ul -->"
					+ "</div><!-- footer -->"
				+ "</div><!-- footer container -->";
			return print;
	}
	public static String Role(String user){
		String role = "Agent";
		try{
			role  = AccountManagementDb.role(user);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return role;
	}

}
