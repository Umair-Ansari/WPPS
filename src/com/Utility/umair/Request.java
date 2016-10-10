package com.Utility.umair;
import java.sql.ResultSet;
public class Request {
	public String id;
	public String date;
	public String f_name;
	public String l_name;
	public String email;
	public String contact;
	public String Organization;
	public String status;
	public String created_on;
	

public Request(ResultSet rs)
	{
		try
		{
			id = rs.getString("re_id");
			date = (String)rs.getString("created_on");
			f_name = rs.getString("f_name");
			l_name = rs.getString("l_name");
			email = rs.getString("email");
			contact = rs.getString("contact");
			Organization = rs.getString("organization");
			status = rs.getString("status");
			created_on = rs.getString("created_on");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
