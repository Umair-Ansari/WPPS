package com.manage_location.hashim.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Utility.umair.AdId;
import com.Utility.umair.AreaId;
import com.manage_account.umair.Dblayer.AccountManagementDb;
import com.manage_ad.hashim.DbLayer.AdManagementDb;
import com.manage_location.hashim.DbLayer.LocationManagementDb;
import com.manage_notification.hashim.DbLayer.NotificationManagementDb;

/**
 * Servlet implementation class DeleteCity
 */
@WebServlet("/DeleteCityPath")
public class DeleteCity extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String city = request.getParameter("city");
		HttpSession session = request.getSession(true);
		String result = "";
		String Message = "";
		List<AreaId> list1  = null;
		List<AdId> list  = null;
		String a_id;
		String p_id;
		try
		{
			list1  = LocationManagementDb.GetAreaId(city);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		if(list1 != null)
		{
			for(AreaId ad1:list1)
			   {
					a_id = ad1.id;
					try
					{
						list  = AdManagementDb.GetAdId(a_id);
					}
					catch(SQLException e)
					{
						System.out.println(e);
					}
					if(list != null)
					{
						for(AdId ad:list)
						   {
								p_id = ad.id;
								try 
								{
									result =AdManagementDb.DeleteAdArea(p_id);
								} catch (Exception e) {
									System.out.println(e);
								}
						   }
					}
					
					if(result != null)
					{
						try 
						{
							result = NotificationManagementDb.DeleteSubscriptionArea(a_id);
						} 
						catch (Exception e) 
						{
							System.out.println(e);
						}
					}
					if(result != null)
					{
						try 
						{
							result = AccountManagementDb.DeleteUserArea(a_id);
						} 
						catch (Exception e) 
						{
							System.out.println(e);
						}
					}
					if(result != null)
					{
						try 
						{
							result = LocationManagementDb.DeleteArea(a_id);
						} 
						catch (Exception e) 
						{
							System.out.println(e);
						}
					}
			   }
		}
		if(result != null)
		{
			try {
				result = AccountManagementDb.DeleteUserCity(city);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		if(result != null)
		{
			try {
				result = LocationManagementDb.DeleteCity(city);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		if(result != null)
		{
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "<b>City Deleted</b>"
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("panel/location.jsp");
		}
	}

}
