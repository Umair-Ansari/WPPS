package com.manage_account.umair.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage_account.umair.Dblayer.AccountManagementDb;
import com.manage_location.hashim.DbLayer.LocationManagementDb;

/**
 * Servlet implementation class AddUserArea
 */
@WebServlet("/AddUserAreaPath")
public class AddUserArea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		String user = request.getParameter("user");
		String result = null;
		String Message = null;
		//System.out.println("city : "+city+"  area : "+area+"  user : "+user);
		try 
		{
			result = AccountManagementDb.AddUserCity(user, city);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}	
		try 
		{
			result = AccountManagementDb.AddUserArea(user,area,city);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		if(result != null)
		{
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:-17.5pt 157pt 2pt;padding-right:2pt;float:right;'>"
					+ "Area Aded"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/area.jsp");
		}
		else
		{
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:-17.5pt 157pt 2pt;padding-right:2pt;float:right;'>"
					+ "Faild to perform action"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/area.jsp");
		}
	}

}
