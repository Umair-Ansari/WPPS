package com.manage_notification.hashim.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage_account.umair.Dblayer.AccountManagementDb;
import com.manage_notification.hashim.DbLayer.NotificationManagement;

/**
 * Servlet implementation class AddNotification
 */
@WebServlet("/AddNotificationPath")
public class AddNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String name = request.getParameter("name");
		//System.out.println(name);
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String mesg = request.getParameter("message");
		String result = null;
		String Message = "";
		try{
			result = NotificationManagement.AddNotification(name,email,contact, mesg);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage()+" query , method :  VerifiedRegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
		}
		if(result != null)
		{
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt -141pt;'>"
					+ "<b><center>Your Message Is Send To Wealth Estate Pakistan Pvt.</center></b><br>"
					+ "1. We will contact you by Email('"+email+"') you Provide"
					+ "<br><b>OR<b><br>"
					+ "2. We will contact youby contact('"+contact+"') you provide."
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("info.jsp");
		}
		
	}

}
