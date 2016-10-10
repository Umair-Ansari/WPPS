package com.create_agent.umair.DbLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnetDb 
{
	private static Connection connection = null;
	private static boolean driverLoaded = false;
	private static String CONNECTION_URL = "jdbc:mysql://localhost:3306/wpps?user=root&password=admin";
	public static Connection getConnection() 
	{
		try {
			if(connection == null || connection.isClosed()) {
				if(!driverLoaded) {
					Class.forName("com.mysql.jdbc.Driver");
					driverLoaded = true;
				}
				connection = DriverManager.getConnection(CONNECTION_URL);
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage() + " in com.create_agent.umair.DbLayer");
		}
	return connection;
	}

}
