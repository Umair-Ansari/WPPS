package com.manage_location.hashim.Jsp_Functions;

import java.sql.SQLException;
import java.util.List;
import com.Utility.umair.City;
import com.manage_location.hashim.DbLayer.LocationManagementDb;

public class LocationManagementJsp {
	public static String ViewCityJSP(){
		String id;
		String city;
		String Print = "<option>No city Found</option>";
		List<City> string  = null;
		try{
			string  = LocationManagementDb.ViewCity();
		}
		catch(SQLException e){
			
		}
		if(string != null)
		{
			Print = "";
			for(City ad:string)
			   {
				
				id = ad.id;
				city = ad.city;
				    Print += "<option value='"+id+"'>"+city+"</option>";
				//System.out.println(Print); 
			   }
			//System.out.println(Print);
			return Print;
		}
		return Print;
	}
	
}
