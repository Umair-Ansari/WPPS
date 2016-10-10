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
import com.Utility.umair.House;
import com.manage_account.umair.Dblayer.AccountManagementDb;
import com.manage_ad.hashim.DbLayer.AdManagementDb;
import com.manage_location.hashim.DbLayer.LocationManagementDb;
import com.manage_notification.hashim.DbLayer.NotificationManagementDb;

@WebServlet("/DeleteAreaPath")
public class DeleteArea extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session = request.getSession(true);
		String result = "";
		String Message = "";
		String id;
		String area = request.getParameter("area");
		List<AdId> list  = null;
		try
		{
			list  = AdManagementDb.GetAdId(area);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		if(list != null)
		{
			for(AdId ad:list)
			   {
					id = ad.id;
					try 
					{
						result =AdManagementDb.DeleteAdArea(id);
					} catch (Exception e) {
						System.out.println(e);
					}
			   }
		}
		
		if(result != null)
		{
			try 
			{
				result = NotificationManagementDb.DeleteSubscriptionArea(area);
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
				result = AccountManagementDb.DeleteUserArea(area);
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
				result = LocationManagementDb.DeleteArea(area);
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		
		
		
		
		
		
		
		
		
		if(result != null)
		{
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "<b>Location Deleted</b>"
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("panel/location.jsp");
		}
		else
		{
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "<b>Error</b>"
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("panel/location.jsp");
		}
	}

}
