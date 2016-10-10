package com.manage_account.umair.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Utility.umair.AdId;
import com.Utility.umair.House;
import com.manage_account.umair.Jsp_functions.AccountManagementJsp;
import com.manage_ad.hashim.DbLayer.AdManagementDb;

/**
 * Servlet implementation class DeleteUserArea
 */
@WebServlet("/DeleteUserAreaPath")
public class DeleteUserArea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<House> list = null;
		String result= null;
		String Message = "";
		String p_id;
		String a_id = request.getParameter("area");
		String u_id =  request.getParameter("user");
		try 
		{
			list = AdManagementDb.ViewAdUserArea(u_id, a_id);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		if(list != null)
		{
			for(House ad:list)
			   {
					p_id = ad.id;
					System.out.println(p_id);
					try 
					{
						result = AdManagementDb.DeleteAd(p_id, u_id);
					} catch (Exception e) {
						System.out.println(e);
					}
			   }
		}
			try {
				result = AccountManagementJsp.DeleteArea(a_id,u_id);
			} catch (Exception e) 
			{
				System.out.println(e);
			}
		
		if(result != null)
		{
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:-17.5pt 157pt 2pt;padding-right:2pt;float:right;'>"
					+ "Area Deleted"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/area.jsp");
		}
	}

}
