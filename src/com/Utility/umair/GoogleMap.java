package com.Utility.umair;

import java.sql.ResultSet;

public class GoogleMap {
	public String longitude;
	public String latitude;
	

public GoogleMap(ResultSet rs)
	{
		try
		{
			longitude = rs.getString("longitude");
			latitude = (String)rs.getString("latitude");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
