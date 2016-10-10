package com.manage_account.umair.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import com.Utility.umair.House;
import com.Utility.umair.UserArea;
import com.manage_account.umair.Dblayer.AccountManagementDb;
import com.manage_account.umair.Jsp_functions.AccountManagementJsp;
import com.manage_ad.hashim.DbLayer.AdManagementDb;
import com.manage_location.hashim.DbLayer.LocationManagementDb;

/**
 * Servlet implementation class DeleteUserCity
 */
@WebServlet("/DeleteUserCityPath")
public class DeleteUserCity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String Message = "";
		String user = request.getParameter("user");
		//String user = "5";
		String a_id;
		String result = null;
		String p_id;
		List<UserArea> string  = null;
		List<House> list  = null;
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
			for(UserArea ad:string)
			   {
				a_id = ad.a_id;
				try 
				{
					list = AdManagementDb.ViewAdUserArea(user, a_id);
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
				if(list != null)
				{
					for(House ad2:list)
					   {
							p_id = ad2.id;
							System.out.println(p_id);
							try 
							{
								result = AdManagementDb.DeleteAd(p_id, user);
							} catch (Exception e) {
								System.out.println(e);
							}
					   }
				}
				
					try {
						result = AccountManagementJsp.DeleteArea(a_id,user);
					} catch (Exception e) 
					{
						System.out.println(e);
					}
				
				if(result != null) //last row will automatically deleted
				{
					try {
						result = AccountManagementDb.DeleteUserCity(city);
					} catch (Exception e) 
					{
						System.out.println(e);
					}
				}
				
			   }
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:-17.5pt 157pt 2pt;padding-right:2pt;float:right;'>"
					+ "City Deleted"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/area.jsp");
		}
		
	}

}
