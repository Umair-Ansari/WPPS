package com.Utility.umair;
import java.sql.ResultSet;
public class User {
	public String id;
	public String f_name;
	public String l_name;
	public String email;
	public String contact;
	public String Organization;

public User(ResultSet rs)
	{
		try
		{
			id = rs.getString("u_id");
			f_name = rs.getString("f_name");
			l_name = rs.getString("l_name");
			email = rs.getString("email");
			contact = rs.getString("contact");
			Organization = rs.getString("organization");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
