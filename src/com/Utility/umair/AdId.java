package com.Utility.umair;

import java.sql.ResultSet;

public class AdId{
	public String id;
	

public AdId(ResultSet rs)
	{
		try
		{
			id = rs.getString("p_id");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
