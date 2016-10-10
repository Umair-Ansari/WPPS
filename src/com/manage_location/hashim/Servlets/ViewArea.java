package com.manage_location.hashim.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Utility.umair.Area;
import com.Utility.umair.City;
import com.manage_location.hashim.DbLayer.LocationManagementDb;

/**
 * Servlet implementation class ViewArea
 */
@WebServlet("/ViewAreaPath")
public class ViewArea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/plain");
		System.out.println("here");
		String id;
		String area;
		String Print = "<option>No city Found</option>";
		List<Area> string  = null;
		String city = request.getParameter("city");
		try
		{
			string  = LocationManagementDb.ViewArea(city);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(string != null)
		{
			Print = "";
			for(Area ad:string)
			   {
				
				id = ad.id;
				area = ad.area;
				    Print += "<option value='"+id+"'>"+area+"</option>";
				//System.out.println(Print); 
			   }
			//System.out.println(Print);
			response.getWriter().write(Print);
		}
		else{
			response.getWriter().write(Print);
		}
		
	}

}
