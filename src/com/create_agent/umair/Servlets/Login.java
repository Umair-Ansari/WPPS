package com.create_agent.umair.Servlets;


import java.io.File;
import java.io.IOException;



import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.create_agent.umair.DbLayer.AgentCreationDb;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "Agent and admin will login from here", urlPatterns = { "/LoginPath" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String result = null;
		String role = null;
		String Message = null;
		try{
			result = AgentCreationDb.login(email,password);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage()+" pakage : com.create_agent.umair.Servlets , servlet : Login , Method : Login");
		}
		if (result != null)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("user",result);
			try
			{
				role = AgentCreationDb.role(result);
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage()+" pakage : com.create_agent.umair.Servlets , servlet : Login , Method : role");
			}
			if(role != null)
			session.setAttribute("role",role);
			response.sendRedirect("panel/index.jsp");
		}
		else
		{
			Message = "<div style='background-color:#ffebe8;border:1px solid #dd3c10;padding:7pt;margin: 0pt 6pt -31pt 6pt;'><b>Please re-enter your password</b><br><br>The password you entered is incorrect. Please try again (make sure your caps lock is off).<br><br>Forgot your password? <a href='forget.jsp' style='color:#6159b2;'>Request a new one</a>.</div>";
			HttpSession session = request.getSession(true);
			session.setAttribute("message",Message);
			response.sendRedirect("login.jsp");
					}
	}

}
