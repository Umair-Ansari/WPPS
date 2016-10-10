package com.manage_banner.hashim.DbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Utility.umair.House;
import com.Utility.umair.User;
import com.Utility.umair.UserArea;
import com.Utility.umair.UserCity;
import com.create_agent.umair.DbLayer.ConnetDb;

public class BannerManagementDb {
	public static String email(String user) throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT email FROM user WHERE u_id='"+user+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("email");
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<User> User() throws SQLException
	{
		List<User> get_ad= new ArrayList<User>();
	 	List<User> result = new ArrayList<User>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM user";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				get_ad.add(new User(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<User> User(String u_id) throws SQLException
	{
		List<User> get_ad= new ArrayList<User>();
	 	List<User> result = new ArrayList<User>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM user WHERE u_id='"+u_id+"'";
		
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				get_ad.add(new User(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<UserCity> UserCityArea(String u_id) throws SQLException
	{
		List<UserCity> get_ad= new ArrayList<UserCity>();
	 	List<UserCity> result = new ArrayList<UserCity>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM user_city WHERE u_id='"+u_id+"'";
		System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				get_ad.add(new UserCity(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<UserArea> UserAreaCity(String city,String user) throws SQLException
	{
		List<UserArea> get_ad= new ArrayList<UserArea>();
	 	List<UserArea> result = new ArrayList<UserArea>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM user_area WHERE uc_id='"+city+"'AND u_id='"+user+"'";
		System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				get_ad.add(new UserArea(rs));
				result = get_ad;
			}
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	
}
