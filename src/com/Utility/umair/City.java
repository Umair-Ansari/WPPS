package com.Utility.umair;

import java.sql.ResultSet;

public class City {
	public String id;
	public String city;
	

public City(ResultSet rs)
	{
		try
		{
			id = rs.getString("c_id");
			city = (String)rs.getString("city");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
