package com.manage_account.umair.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Utility.umair.EmailUtility;
import com.Utility.umair.Request;
import com.manage_account.umair.Dblayer.AccountManagementDb;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPasswordPath")
public class ForgetPassword extends HttpServlet {
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
		String result = null;
		String created_on = "";
		String status = ""; 
		String Message = "";
		List<Request> string = null;
		try{
			result = AccountManagementDb.ForgetPassword(email);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		if(result == null)
		{
			Message = "<div style='background-color:#ffebe8;border:1px solid #dd3c10;padding:7pt;margin: 0pt 6pt -31pt 6pt;'>"
					+ "<b>Account No Longer Exists</b><br><br>"
					+ "<i>Possible Reasons</i><br>"
					+ "<i>1. You didnt verify you account within 7 days</i><br>"
					+ "<i>2. Admin reject you account request</i>"
					+ "<br><a href='signup.jsp' style='color:#6159b2;'>Request Again for account</a>"
					+ "</div>";	
			session.setAttribute("message",Message);		
			response.sendRedirect("forget.jsp");
			
		}
		else if(result == "Request")
		{
			try
			{
				string = AccountManagementDb.RequestForget(email);
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
			 for(Request req:string)
			{
				 created_on = req.created_on;
				 status = req.status;
				 Message =  "<div style='background-color:#eef6fa;border:1px solid #d1e6f1;padding:7pt;margin: 0pt 6pt -31pt 6pt;'>"
				 		+ "Admin didn't respond to your Account request!"
				 		+ "<br><br>"
				 		+ "<i>Other Details<i>"
				 		+ "<br><i>1. Created On : "+created_on+"</i><br>"
						+ "<i>2.  Email Status : "+status+"</i>"
							+ "</div>";	
					session.setAttribute("message",Message);		
					response.sendRedirect("forget.jsp");
			 }
		}
		else
		{
			String subject = "Forget Password!";
			String content = "Wealth Estate Pakistan Pvt."
					+ "\n\n"
					+ "We have recieved password forget request"
					+ "\n\n"
					+ "\n\n"
					+ "**** Account Information ****\n"
					+ "Email : "+email+"\n"
					+ "Password : "+result+"\n"
					+ "\n\n"
					+"**** Note ****\n"
					+ "-If you didnt make request then ignor this email.\n"
					+ "\n\n"
					+ "**** Where to get help? ****\n"
					+ "Help : "+"wealthpakistan.comoj.com/help.html\n"
					+ "\n\n"
					+ "Thank You!\n"
					+ "wealthpakistan.comoj.com";
			 Message =  "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt -31pt 6pt;'>"
						+ "<b>Details send to you email</b>"
						+ "<br><br>"
						+ "<i>Contains</i>"
						+ "<br><i>1.Your Password</i>"
						+ "</div>";	
			 try {
					EmailUtility.sendEmail(host, port, user, pass, email, subject,
							content);
				} catch (Exception ex) {
					ex.printStackTrace();
					 System.out.println(ex.getMessage());
				}
				session.setAttribute("message",Message);		
				response.sendRedirect("login.jsp");
		 }
	}

}
