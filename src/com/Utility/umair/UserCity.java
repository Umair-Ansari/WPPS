package com.Utility.umair;

import java.sql.ResultSet;

public class UserCity {
	public String id;
	public String city;
	public String c_id;
	

public UserCity(ResultSet rs)
	{
		try
		{
			id = rs.getString("uc_id");
			c_id = rs.getString("c_id");
			
			city = (String)rs.getString("city");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
