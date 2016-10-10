package com.Utility.umair;

import java.sql.ResultSet;

public class Area {
	public String id;
	public String city;
	public String area;
	

public Area(ResultSet rs)
	{
		try
		{
			id = rs.getString("a_id");
			area = (String)rs.getString("area");
			city = (String)rs.getString("c_id");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
