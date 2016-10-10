package com.Utility.umair;

import java.sql.ResultSet;

public class UserArea {
	public String id;
	public String a_id;
	public String city;
	public String area;
	

public UserArea(ResultSet rs)
	{
		try
		{
			id = rs.getString("ua_id");
			a_id = rs.getString("a_id");
			area = (String)rs.getString("area");
			city = (String)rs.getString("uc_id");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
 
}
