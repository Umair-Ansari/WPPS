package com.create_agent.umair.DbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Utility.umair.Directory;
import com.Utility.umair.NewDate;



public class AgentCreationDb 
{
	public static String RegisterAgent(String fname,String lname,String email,String password,String contact,String organization) throws SQLException
	{ 
		String re = null;
		String creator = "Agent";
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.create_agent.umair.DbLayer , Method : RegisterAgent");	
			return re = null;
		}
		String date = NewDate.get_date(7);
		String query = "INSERT INTO request (f_name,l_name,email,password,organization,contact,creator,created_on)values('"+fname+"','"+lname+"','"+email+"','"+password+"','"+organization+"','"+contact+"','"+creator+"','"+date+"')";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				String query2 = "SELECT re_id FROM request WHERE email='"+email+"'";
				try (
					Statement st2 = connection.createStatement();
					ResultSet rs2 = st2.executeQuery(query2);)
				{
					if (rs2.next())
					{
						re = rs2.getString("re_id");
					}
				}
				catch(Exception e){
						System.out.println( e.getMessage()+" : method : Login Agent is not prepared in pakage : com.create_agent.umair.DbLayer");
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

	public static String login(String email,String password) throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT u_id FROM user WHERE email='"+email+"' AND password='"+password+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("u_id");
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
	public static String role(String user) throws SQLException{
		String role = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer, method : role");
			return role = null;	
		}
		String query = "SELECT role FROM role WHERE u_id='"+user+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				role = rs.getString("role");
				
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" : Login Agent not prepared in com.create_agent.umair.DbLayer");
				return role = null;	
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return role;
	}
	public static String CreatAgent(String email, String password) throws SQLException{
		String Resutl = null;
		String organization = "Wealth Estate Pakistan";
		String Status ="Verified";
		String date = NewDate.get_date(7);
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer, method : CreatAgent");
			return Resutl = null;	
		}
		String query = "INSERT INTO request (email,password,status,organization,created_on)values('"+email+"','"+password+"','"+Status+"','"+organization+"','"+date+"')";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				return Resutl = "Agent Created!";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" : Creat Agent not prepared in com.create_agent.umair.DbLayer");
			return Resutl = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return Resutl;
		
	}
	public static String verify(String email,String code) throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer, method : verify");
			return result = null;	
		}
		String query = "SELECT re_id,email FROM request WHERE email='"+email+"' AND password='"+code+"' AND status ='verified' ";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				
				String id = rs.getString("re_id");
				String return_email = rs.getString("email");
				result = (return_email+",.,"+id);
				
			}
		}
		catch(Exception e){
				System.out.println( e.getMessage()+" method : verify not prepared in pakege : com.create_agent.umair.DbLayer");
				return result = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return result;
	}
	public static String VerifiedRegisterAgent(String fname,String lname,String email,String password,String contact,String organization,String id) throws SQLException
	{
		String re = null;
		String creator = "Admin";
		long contact_int = 0;
		try{
			contact_int = Long.parseLong(contact);
			
		}
		catch (NumberFormatException e){
			System.out.println( e.getMessage()+"parsing string to long faild in pakage : com.create_agent.umair.DbLayer, method : VerifiedRegisterAgent");
		}
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing in pakahe : com.create_agent.umair.DbLayer, method : VerifiedRegisterAgent");
			return re = null;	
		}
		
		String date = NewDate.get_date(0);
		String query = "INSERT INTO user (f_name,l_name,email,password,organization,contact,creator,created_on)values('"+fname+"','"+lname+"','"+email+"','"+password+"','"+organization+"','"+contact_int+"','"+creator+"','"+date+"')";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				String query_2 = "INSERT INTO role (u_id,role) VALUES ((SELECT u_id FROM USER WHERE email='"+email+"' LIMIT 1),'Agent')";
			
				try 	
				{
					if (st.executeUpdate(query_2) > 0) 
					{			
						String query_3 = "DELETE FROM request WHERE re_id='"+id+"'";
						try 	
						{
							if (st.executeUpdate(query_3) > 0) 
							{			
								Directory.CreatDirectory(email);
								return re = "true";
							}
							
						} catch (SQLException e) {
							System.out.println(e.getMessage()+" query_3 , method :  VerifiedRegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
							return re = null;
						}
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage()+" query_2 , method :  VerifiedRegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
					return re = null;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" query , method :  VerifiedRegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return re;
	}
	public static String RegisterAgentVerification(String email,String re_id) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.create_agent.umair.DbLayer , Method : RegisterAgent");	
			return re = null;
		}
		String query = "UPDATE request SET status='verified' where email='"+email+"' AND  re_id='"+re_id+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				re= "success";
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
}
