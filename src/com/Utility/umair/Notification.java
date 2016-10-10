package com.Utility.umair;

import java.sql.ResultSet;

public class Notification {
	public String id;
	public String name;
	public String email;
	public String contact;
	public String message;
	

public Notification(ResultSet rs)
	{
		try
		{
			id = rs.getString("n_id");
			name = (String)rs.getString("name");
			email = (String)rs.getString("email");
			contact = (String)rs.getString("contact");
			message = (String)rs.getString("message");
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
