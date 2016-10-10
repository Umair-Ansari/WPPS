package com.manage_notification.hashim.DbLayer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.create_agent.umair.DbLayer.ConnetDb;

public class NotificationManagementDb {
	public static String DeleteSubscriptionArea(String area) throws SQLException
	{ 
		String re = null;
		Connection connection = ConnetDb.getConnection();
		if(connection == null) {
			System.out.println("connection is null while preparing, pakage :com.create_agent.umair.DbLayer , Method : delete ad");	
			return re = null;
		}
		String query = "DELETE FROM subscription WHERE a_id='"+area+"'";
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
}
