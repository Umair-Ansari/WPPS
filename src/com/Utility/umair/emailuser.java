package com.Utility.umair;

import java.sql.SQLException;

import com.manage_banner.hashim.DbLayer.BannerManagementDb;

public class emailuser {
	public static String emailget(String User)
	{
	
		String result = "";
		try
		{
			result = BannerManagementDb.email(User);		
		}
		catch(SQLException e)
		{
			System.out.println(e+"faild to call function pakage : com.manage_account.umair.Jsp_functions; method : profilejsp");
		}
		
		return result;
	}
}
