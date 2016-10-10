package com.request_handling.umair.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Utility.umair.Directory;
import com.Utility.umair.EmailUtility;
import com.request_handling.umair.DbLayer.RequestHandlingDb;

/**
 * Servlet implementation class AcceptAgent
 */
@WebServlet("/AcceptAgentPath")
public class AcceptAgent extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;
	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String email = request.getParameter("email");
		String Result =null;
		String Message = null;
		try
		{
			Result = RequestHandlingDb.AcceptAgent(email);
		}
		catch(SQLException e)
		{
			
		}
		if(Result!= null)
		{
		
			String subject = "Account Request Accepted";
			String content = "This email is to inform you that you account request is accepted by admin"
					+ "\n\n"
					+ "You are now part of Wealth Estate Pakistan Pvt."
					+ "**** Note ****\n"
					+ "-Please login to continue\n" 
					+ "\n\n"
					+ "**** Where to get help? ****\n"
					+ "Help : "+"wealthpakistan.comoj.com/help.html\n"
					+ "\n\n"
					+ "Thank You!\n"
					+ "wealthpakistan.comoj.com";
			try {
				EmailUtility.sendEmail(host, port, user, pass, email, subject,
						content);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Message = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:5.5pt 0pt 2pt 0pt;padding-left:2pt;float:left;'>"
					+ "Agent Request Accepted"
					+ "</div>";	
			session.setAttribute("message",Message);
			response.sendRedirect("panel/request.jsp");
		}
	}

}
