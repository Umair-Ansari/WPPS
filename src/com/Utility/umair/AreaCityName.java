package com.Utility.umair;

import java.sql.ResultSet;

public class AreaCityName {
	public String id;
	public String a_id;
	public String city;
	public String area;
	

public AreaCityName(ResultSet rs)
	{
		try
		{
			area = rs.getString("area.area");
			city = (String)rs.getString("city.city");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
