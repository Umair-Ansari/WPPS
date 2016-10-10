package com.manage_account.umair.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage_account.umair.Dblayer.AccountManagementDb;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfilePath")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		String f_name = request.getParameter("f_name");
		String l_name = request.getParameter("l_name");
		String contact = request.getParameter("contact");
		String organization = request.getParameter("organization");
		String result = null;
		String Message = "";
		try{
			result = AccountManagementDb.UpdateProfile(f_name, l_name, contact, organization,id);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage()+" query , method :  VerifiedRegisterAgent not prepared in pakage : com.create_agent.umair.DbLayer");
		}
		if(result != null)
		{
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "<b>Profile Updated</b>"
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("panel/profile.jsp");
		}
		
	}

}
