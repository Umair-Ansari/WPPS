package com.Utility.umair;

import java.sql.ResultSet;

public class Shopes {
	public String id;
	public String price;
	public String far;
	public String type;
	public String land;
	public String date_time;
	public String u_id;
	public String g_id;
	public String a_id;
	

public Shopes(ResultSet rs)
	{
		try
		{
			id = rs.getString("re_id");
			price = (String)rs.getString("price");
			far = rs.getString("far");
			type = rs.getString("type");
			land = rs.getString("land");
			date_time = rs.getString("date_time");
			u_id = rs.getString("u_id");
			g_id = rs.getString("g_id");
			a_id = rs.getString("a_id");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
