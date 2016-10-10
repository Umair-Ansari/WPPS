package com.manage_ad.hashim.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage_ad.hashim.DbLayer.AdManagementDb;

/**
 * Servlet implementation class DeleteAd
 */
@WebServlet("/DeleteAdPath")
public class DeleteAd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String user = request.getParameter("user");
		String result = null;
		String Message = "";
		String id = request.getParameter("id");
		try {
			result = AdManagementDb.DeleteAd(id, user);
		} catch (Exception e) {
			System.out.println(e);
		}
		if(result != null)
		{
			Message = "<div style='border:1px solid #f35118;color:#f35118; width:131pt;margin:5.5pt 0pt 2pt 8pt;padding-left:2pt;float:left;'>"
					+ "Ad Deleted"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/ad.jsp");
		}
		else
		{
			Message = "<div style='border:1px solid #f35118;color:#f35118; width:131pt;margin:5.5pt 0pt 2pt 8pt;padding-left:2pt;float:left;'>"
					+ "Faild to perform action"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/ad.jsp");
		}
	}

}
