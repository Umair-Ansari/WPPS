package com.request_handling.umair.DbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Utility.umair.Directory;
import com.Utility.umair.NewDate;
import com.Utility.umair.Request;
import com.create_agent.umair.DbLayer.ConnetDb;

import java.util.ArrayList;
import java.util.List;
public class RequestHandlingDb {
	public static List<Request> ViewRole(int Pagging) throws SQLException{
	 	List<Request> get_request= new ArrayList<Request>();
	 	List<Request> result = new ArrayList<Request>();
		Connection connection = ConnetDb.getConnection();
		int lower = Pagging;
		int upper = lower + 6;
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.request_handling.umair.DbLayer method : RequestHandlingDb");
			//return result = null;	
		}
		String query = "SELECT * FROM request WHERE status='verified' ORDER BY created_on DESC LIMIT "+lower+","+upper+"";
		
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
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

	public static List<Request> ViewRole(String search,int Pagging) throws SQLException{
 	List<Request> get_request= new ArrayList<Request>();
 	List<Request> result = new ArrayList<Request>();
 	int lower= Pagging;
	int upper = lower + 6;
	Connection connection = ConnetDb.getConnection();
	if(connection == null) 
	{
		System.out.println("connection is null while preparing in pakage : com.request_handling.umair.DbLayer method : RequestHandlingDb");
		//return result = null;	
	}
	String query = "SELECT * FROM request WHERE status='verified' AND f_name='"+search+"'ORDER BY created_on DESC LIMIT "+lower+","+upper+"";
	try (
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);)
	{
		while (rs.next())
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
	public static String AcceptAgent(String email) throws SQLException
	{
		String id = null;
		String f_name = null;
		String l_nam = null;
		String password = null;
		String organization = null;
		String contact = null;
		String creator = null;
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing in pakahe : com.create_agent.umair.DbLayer, method : VerifiedRegisterAgent");
			return re = null;	
		}
		
		String date = NewDate.get_date(0);
		String query = "SELECT * FROM request WHERE email='"+email+"'";
		try(
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);) 	
		{
			if (rs.next()) 
			{	
				 id =  rs.getString("re_id");
				 f_name =  rs.getString("f_name");
				 l_nam = rs.getString("l_name");
				 email = rs.getString("email");
				 password = rs.getString("password");
				 organization = rs.getString("organization");
				 contact = rs.getString("contact");
				 creator = rs.getString("creator");
				 long contact_int = 0;
					try{
						contact_int = Long.parseLong(contact);
						
					}
					catch (NumberFormatException e){
						System.out.println( e.getMessage()+"parsing string to long faild in pakage : com.create_agent.umair.DbLayer, method : VerifiedRegisterAgent");
					}
				String query_1 = "INSERT INTO user (f_name,l_name,email,password,organization,contact,creator,created_on)values('"+f_name+"','"+l_nam+"','"+email+"','"+password+"','"+organization+"','"+contact_int+"','"+creator+"','"+date+"')";
				try 	
				{
					if (st.executeUpdate(query_1) > 0) 
					{
						String query_2 = "INSERT INTO role (u_id,role) VALUES ((SELECT u_id FROM USER WHERE email='"+email+"' LIMIT 1),'Agent')";
					
						try 	
						{
							if (st.executeUpdate(query_2) > 0) 
							{			
								//System.out.println(id);
								String query_3 = "DELETE FROM request WHERE re_id='"+id+"'";
								try 	
								{
									if (st.executeUpdate(query_3) > 0) 
									{	
										try{
											Directory.CreatDirectory(email);
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
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
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" query_3 , method :  VerifiedRegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
			return re = null;
		}
		finally{
			if(connection != null)
				connection.close();
		}
		return re;
	}
	public static String RejectAgent(String email) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.request_handling.umair.DbLayer , Method : RejectAgent");	
			return re = null;
		}
		String query = "DELETE FROM request WHERE email='"+email+"'";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				return re = "true";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : RejectAgent not prepared in pakage : com.request_handling.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
	public static String PageNumberRequestAgent() throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(re_id) FROM request WHERE status='notveirfied'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("COUNT(re_id)");
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
	public static String PageNumberRequestAgent(String CheckSearch) throws SQLException
	{
		String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT COUNT(re_id) FROM request WHERE status='notveirfied' AND f_name='"+CheckSearch+"'";
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			if (rs.next())
			{
				result = rs.getString("COUNT(re_id)");
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
	public static List<Request> PagingRequestAgent(int lower, int upper) throws SQLException{
	 	List<Request> get_request= new ArrayList<Request>();
	 	List<Request> result = new ArrayList<Request>();
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.request_handling.umair.DbLayer method : RequestHandlingDb");
			//return result = null;	
		}
		String query = "SELECT * FROM request WHERE status='notveirfied' ORDER BY created_on DESC LIMIT "+lower+","+upper+"";
		
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
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
	public static String DeleteAllAgent() throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.request_handling.umair.DbLayer , Method : DeleteAllAgent");	
			return re = null;
		}
		String query = "DELETE FROM request WHERE status='verified' ";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				return re = "true";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"  Method : DeleteAllAgent not prepared in pakage : com.request_handling.umair.DbLayer");
			return re = null;
		}
		
		finally{
			if(connection != null)
				connection.close();
		}
	return re;
	}
}