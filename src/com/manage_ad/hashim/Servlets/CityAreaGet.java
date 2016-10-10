package com.manage_ad.hashim.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Utility.umair.UserArea;
import com.manage_location.hashim.DbLayer.LocationManagementDb;

/**
 * Servlet implementation class CityAreaGet
 */
@WebServlet("/CityAreaGetPath")
public class CityAreaGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		//String user = "5";
		String a_id;
		String area;
		String Print = "not found";
		List<UserArea> string  = null;
		String city = request.getParameter("city");
		
		
		try
		{
			string  = LocationManagementDb.ViewUserArea(city,user);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(string != null)
		{
			Print = "";
			for(UserArea ad:string)
			   {
				
				a_id = ad.a_id;
				area = ad.area;
				    Print += "<option value='"+a_id+"'>"+area+"</option>"; 
				    		//System.out.println(Print); 
			   }
			//System.out.println(Print);
			response.getWriter().write(Print);
		}
	}

}
