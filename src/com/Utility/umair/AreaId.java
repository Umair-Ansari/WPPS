package com.Utility.umair;

import java.sql.ResultSet;

public class AreaId{
	public String id;
	

public AreaId(ResultSet rs)
	{
		try
		{
			id = rs.getString("a_id");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
