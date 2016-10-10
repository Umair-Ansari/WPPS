package com.create_agent.umair.Servlets;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Utility.umair.Directory;
import com.create_agent.umair.DbLayer.AgentCreationDb;

/**
 * Servlet implementation class VerifyAccount
 */
@WebServlet(description = "to verify agetn account", urlPatterns = { "/VerifyAccountPath" })
public class VerifyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		String result = null;
		try
		{
		
			result = AgentCreationDb.verify(email, code);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage()+" pakage : com.create_agent.umair.Servlets , servlet : VerifyAccount , Method : verify");
		}
		String Message = null;
		HttpSession session = request.getSession(true);
		if(result != null)
		{
			Directory.CreatDirectory(email);
			String return_email = result.split(",.,")[0];
			String id = result.split(",.,")[1];
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "<b>Account Veirfied</b>"
					+ "<br><br>"
					+ "Complete registration to continue"
					+ "</div>";	
			session.setAttribute("message",Message);
			session.setAttribute("email",return_email);
			session.setAttribute("id",id);
			response.sendRedirect("signup.jsp");
		}
		else
		{
			Message = "<div style='background-color:#ffebe8;border:1px solid #dd3c10;padding:7pt;margin: 0pt 6pt -22pt 6pt;'>"
					+ "<b>Account Veirification Failed</b>"
					+ "<br><br>"
					+ "<i>possible reasons</i><br>"
					+ "<i>1. you enter email that is no longer part of system</i><br>"
					+ "<i>2. you enter wrong code(recieved by email)</i>"
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("verify.jsp?id='998966447'");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String Message = "";
		String email=request.getParameter("email");
		String id = request.getParameter("token");
		String result =null;
		try{
			result = AgentCreationDb.RegisterAgentVerification(email, id);
		}catch(SQLException e){
			System.out.println(e);
		}
		if(result != null)
		{ 
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 9pt 0pt -136pt;'>"
					+ "<b>Account Veirfied</b>"
					+ "<br><br>"
					+ "Your Account Creation Request in Send to Admin for Review"
					+ "<br>"
					+ "Wait for Email"
					+ "</div>";
			session.setAttribute("message",Message);		
			response.sendRedirect("info.jsp");
		}
		else
		{
			Message = "<div style='background-color:#ffebe8;border:1px solid #dd3c10;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "<b>Account Verification Failed</b><br><br>"
					+ "<i>Possible Reasons</i><br>"
					+ "<i>1. you enter email that is no longer part of system</i><br>"
					+ "<i>2. you enter wrong code(recieved by email)</i>"
					+ "</div>";
			session.setAttribute("message",Message);		
			response.sendRedirect("signup.jsp");
		}
	}
}
