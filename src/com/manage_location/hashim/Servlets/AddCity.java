package com.manage_location.hashim.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage_location.hashim.DbLayer.LocationManagementDb;

/**
 * Servlet implementation class AddCity
 */
@WebServlet("/AddCityPath")
public class AddCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String city = request.getParameter("city");
		String result = "";
		String Message = "";
		try
		{
			result = LocationManagementDb.AddCity(city);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(result == "true")
		{
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:5.5pt 0pt 2pt 0pt;padding-left:2pt;float:left;'>"
					+ "City Added"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/location.jsp");
		}
		else
		{
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:5.5pt 0pt 2pt 0pt;padding-left:2pt;float:left;'>"
					+ "Faild to perform action"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/location.jsp");
		}
	}

}
