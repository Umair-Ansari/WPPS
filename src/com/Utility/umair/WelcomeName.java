package com.Utility.umair;

import java.sql.SQLException;
import java.util.List;

import com.manage_account.umair.Dblayer.AccountManagementDb;

public class WelcomeName 
{
	public static String ViewNamejsp(String User)
	{
		String f_name = "";
		String l_name = "";
		List<User> resutl = null;
		String Return = "";
		try
		{
			resutl = AccountManagementDb.ViewProfile(User);		
		}
		catch(SQLException e)
		{
			System.out.println(e+"faild to call function pakage : com.manage_account.umair.Jsp_functions; method : profilejsp");
		}
		for(User req:resutl)
		{	   
		  f_name = req.f_name;
		  l_name = req.l_name;
		  Return = f_name+" "+l_name ;
		}
		return Return;
	}
}
