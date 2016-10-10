package com.Utility.umair;

import java.sql.ResultSet;

public class House {
	public String id;
	public String price;
	public String far;
	public String type;
	public String land;
	public String date_time;
	public String u_id;
	public String g_id;
	public String a_id;
	public String landtype;
	public String details;

public House(ResultSet rs)
	{
		try
		{
			id = rs.getString("p_id");
			price = (String)rs.getString("price");
			far = rs.getString("far");
			type = rs.getString("typee");
			land = rs.getString("land");
			date_time = rs.getString("date_time");
			u_id = rs.getString("u_id");
			g_id = rs.getString("g_id");
			a_id = rs.getString("a_id");
			landtype = rs.getString("land_type");
			details= rs.getString("details");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
