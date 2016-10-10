package com.manage_account.umair.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manage_account.umair.Dblayer.AccountManagementDb;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePasswordPath")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String result = null;
		String Message ="";
		String opassword = request.getParameter("opassword");
		String password = request.getParameter("password");
		String Cpassword = request.getParameter("Cpassword");
		String id = request.getParameter("user");
			
		try{
			result = AccountManagementDb.ChnagePassword(opassword, password, id);
		}
		catch(Exception e){
			System.out.println(e);
		}
		if(result != null)
		{
			Message = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "Password Chnaged"
					+ "</div>";	
			session.setAttribute("message2",Message);		
			response.sendRedirect("panel/profile.jsp");
		}
		else{
			Message = "<div style='background-color:#ffebe8;border:1px solid #dd3c10;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
					+ "Wrong Current Password!"
					+ "</div>";	
			session.setAttribute("message2",Message);		
			response.sendRedirect("panel/profile.jsp");
		}
		
	}

}
