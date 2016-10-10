package com.manage_account.umair.Dblayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Utility.umair.AdId;
import com.Utility.umair.City;
import com.Utility.umair.Request;
import com.Utility.umair.User;
import com.Utility.umair.UserCity;
import com.create_agent.umair.DbLayer.ConnetDb;

public class AccountManagementDb {
	
	public static List<User> ViewProfile(String user) throws SQLException{
	 	List<User> get_request= new ArrayList<User>();
	 	List<User> result = new ArrayList<User>();
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.request_handling.umair.DbLayer method : RequestHandlingDb");
			//return result = null;	
		}
		String query = "SELECT * FROM user WHERE u_id='"+user+"'";
		
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				get_request.add(new User(rs));
				result = get_request;
			} 
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : RequestHandlingDb is not prepared in pakage :  com.manage_account.umair.Dblayer method : password");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String UpdateProfile(String fname,String lname,String contact,String organization,String id) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :  com.manage_account.umair.Dblayer , Method : passowrd");	
			return re = null;
		}
		String query = "UPDATE user SET f_name='"+fname+"',l_name='"+lname+"',contact='"+contact+"',organization='"+organization+"' WHERE u_id='"+id+"' ";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				return re = "true";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : UpdateProfile not prepared in pakage : com.manage_account.umair.Dblayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static String ForgetPassword(String email) throws SQLException{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT password FROM user WHERE email='"+email+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("password");
			}
			else
			{
				String query2 = "SELECT * FROM request WHERE email='"+email+"'";
				try (
					Statement st2 = connection.createStatement();
					ResultSet rs2 = st.executeQuery(query2);)
				{
					if (rs2.next())
					{
						
						result = "Request";
						
					}
				}
				catch(Exception e){
					System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
					return result = null;
				}
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
	
		return result;
	}
	public static List<Request> RequestForget(String email) throws SQLException{
	 	List<Request> get_request= new ArrayList<Request>();
	 	List<Request> result = new ArrayList<Request>();
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.request_handling.umair.DbLayer method : RequestHandlingDb");
			//return result = null;	
		}
		String query = "SELECT * FROM request WHERE email='"+email+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				get_request.add(new Request(rs));
				result = get_request;
			} 
		}
		catch(Exception e){
				e.printStackTrace();
				System.out.println( e.getMessage()+" : method : RequestHandlingDb is not prepared in pakage : com.request_handling.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
		}
	public static String ChnagePassword(String opassword,String password,String id) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :  com.manage_account.umair.Dblayer , Method : passowrd");	
			return re = null;
		}
		String query = "SELECT password FROM user WHERE u_id='"+id+"'";
		try (
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);)	
		{
			if (rs.next())
			{
				if(rs.getString("password").equals(opassword)){
					String query2 = "UPDATE user SET password='"+password+"' WHERE u_id='"+id+"' ";
					try (
							Statement st2 = connection.createStatement();
							)	
					{
						if (st2.executeUpdate(query2) > 0) 
						{
							return re = "true";
						}
						
					} catch (SQLException e) {
						System.out.println(e.getMessage()+"  Method : UpdateProfile not prepared in pakage : com.manage_account.umair.Dblayer");
						return re = null;
					}
					
					return re = "pass";
					
				}
				else{
					return re = null;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : UpdateProfile not prepared in pakage : com.manage_account.umair.Dblayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static String DeleteUserArea(String area) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		
		
		String query = "DELETE FROM user_area WHERE a_id='"+area+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			st.executeUpdate(query);
			re = "true";
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : delete area not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static String DeleteUserCity(String city) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		
		String query = "DELETE FROM user_city WHERE c_id='"+city+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			st.executeUpdate(query);
			re = "true";
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : delete area not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static String AddUserCity(String user,String c_id) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.create_agent.umair.DbLayer , Method : RegisterAgent");	
			return re = null;
		}
		String query = "SELECT city FROM city WHERE c_id='"+c_id+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				String city = rs.getString("city");
				String query2 = "INSERT INTO user_city (u_id,city,c_id)values('"+user+"','"+city+"','"+c_id+"')";
				try (
						Statement st2 = connection.createStatement();
						)	
				{
					if (st2.executeUpdate(query2) > 0) 
					{
						re = "true";
					}
				}
				catch (SQLException e) {
					System.out.println(e.getMessage()+"  Method : RegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
					return re = null;
				}
			}
					
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : RegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static String AddUserArea(String user,String a_id, String c_id) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.create_agent.umair.DbLayer , Method : RegisterAgent");	
			return re = null;
		}
		String query = "SELECT uc_id FROM user_city WHERE c_id='"+c_id+"' AND u_id='"+user+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				String uc_id = rs.getString("uc_id");
				String query2 = "SELECT area FROM area WHERE a_id='"+a_id+"'";
				try (
					Statement st2 = connection.createStatement();
					ResultSet rs2 = st.executeQuery(query2);)
				{
					if (rs2.next())
					{
						String area = rs2.getString("area");
						String query3 = "INSERT INTO user_area (u_id,a_id,area,uc_id)values('"+user+"','"+a_id+"','"+area+"','"+uc_id+"')";
						try (
								Statement st3 = connection.createStatement();
								)	
						{
							if (st3.executeUpdate(query3) > 0) 
							{
								re = "true";
							}
						}
						catch (SQLException e) {
							System.out.println(e.getMessage()+"  Method : RegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
							return re = null;
						}
					}
							
				} catch (SQLException e) {
					System.out.println(e.getMessage()+"  Method : RegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
					return re = null;
				}
			}
					
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : RegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static List<City> ViewCity(String u_id) throws SQLException
	{
		List<City> get_city= new ArrayList<City>();
		List<City> result = new ArrayList<City>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM user_city WHERE u_id='"+u_id+"' ORDER BY city";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_city.add(new City(rs));
				result = get_city;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static List<UserCity> ViewUserCity(String user) throws SQLException
	{
		List<UserCity> get_city= new ArrayList<UserCity>();
		List<UserCity> result = new ArrayList<UserCity>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM user_city WHERE u_id='"+user+"'ORDER BY city";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				get_city.add(new UserCity(rs));
				result = get_city;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	
	public static String AdReport(String user) throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(p_id) As p_id FROM ad WHERE u_id='"+user+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				result =  rs.getString("p_id");
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String LastReport(String user) throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT date_time FROM ad WHERE p_id= (SELECT MAX(p_id) FROM ad WHERE u_id='"+user+"')";
		//System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				String date_time = rs.getString("date_time");
				String[] spliter = date_time.split(" 00:00:00.0");
				date_time = spliter[0];
				result = date_time;
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	
	public static String AreaReport(String user) throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(ua_id) AS area FROM user_area WHERE u_id='"+user+"'";
		//System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				result = rs.getString("area");
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String CityReport(String user) throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(uc_id) AS city FROM user_city WHERE u_id='"+user+"'";
		//System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				result = rs.getString("city");
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String NotificationReport() throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(n_id) AS notification FROM notification";
		//System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				result = rs.getString("notification");
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String UserReport() throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(u_id) AS user FROM user";
		//System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				result = rs.getString("user");
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String AgentReport() throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(re_id) AS user FROM request WHERE status='verified'";
		//System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				
				result = rs.getString("user");
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String role(String user) throws SQLException
	{
		//List<AdId> get_city= new ArrayList<AdId>();
		//List<AdId> result = new ArrayList<AdId>();
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT role FROM role WHERE u_id='"+user+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				//System.out.println(rs.getString("p_id"));
				//result = rs.getString("p_id");
				//get_city.add(new AdId(rs));
				result =  rs.getString("role");
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : method : view ad is not prepared in pakage : com.create_agent.umair.DbLayer");
				//return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
}