package com.manage_notification.hashim.DbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Utility.umair.Directory;
import com.Utility.umair.NewDate;
import com.Utility.umair.Notification;
import com.Utility.umair.UserCity;
import com.create_agent.umair.DbLayer.ConnetDb;

public class NotificationManagement {
	public static String AddNotification(String name,String email,String contact,String message) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage : com.create_agent.umair.DbLayer , Method : RegisterAgent");	
			return re = null;
		}
		String date = NewDate.get_date(0);
		String query = "INSERT INTO notification (name,email,contact,message,date_time)values('"+name+"','"+email+"','"+contact+"','"+message+"','"+date+"')";
		try (
				Statement st = connection.createStatement();
				)	
		{
			if (st.executeUpdate(query) > 0) 
			{
				re = "true";
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
	public static List<Notification> Notification() throws SQLException
	{
		List<Notification> get_ad= new ArrayList<Notification>();
	 	List<Notification> result = new ArrayList<Notification>();
		//String result = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) 
		{
			System.out.println("connection is null while preparing in pakage : com.create_agent.umair.DbLayer");
			return result = null;	
		}
		String query = "SELECT * FROM notification";
		System.out.println(query);
		try (
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);)
		{
			while (rs.next())
			{
				get_ad.add(new Notification(rs));
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
	public static String DeleteNotification(String id) throws SQLException
	{
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		String query = "DELETE FROM notification WHERE n_id='"+id+"'";
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
	public static String DeleteAllNotification() throws SQLException
	{
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		String query = "DELETE FROM notification";
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
}
