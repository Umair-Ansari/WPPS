package com.manage_notification.hashim.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage_notification.hashim.DbLayer.NotificationManagement;

/**
 * Servlet implementation class DeleteAllNotification
 */
@WebServlet("/DeleteAllNotificationPath")
public class DeleteAllNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		//String id = request.getParameter("id");;
		String result = null;
		String Message = "";
		try {
			result = NotificationManagement.DeleteAllNotification();
		} catch (Exception e) {
			
		}if(result != null)
		{
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:5.5pt 0pt 2pt 2pt;padding-left:2pt;float:left;'>"
					+ "All Notification Deleted"
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("panel/notification.jsp");
		}
		
	}

}
