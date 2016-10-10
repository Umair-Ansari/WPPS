package com.create_agent.umair.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Utility.umair.EmailUtility;
import com.create_agent.umair.DbLayer.AgentCreationDb;
/**
 * Servlet implementation class RegisterAgent
 */
@WebServlet(description = "agent will register from here", urlPatterns = { "/RegisterAgentPath" })
public class RegisterAgent extends HttpServlet {
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
		
		String email;
		String result = null;
		String id =  null;
		String Message = null;
		String to = "signup.jsp";
		HttpSession session = request.getSession(true);
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		if(session.getAttribute("email") != null)
		{
			 email =  (String)session.getAttribute("email");
			 id =  (String)session.getAttribute("id");
			
		}
		else
		{
			 email= request.getParameter("email");
		}
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String organization = request.getParameter("organization");
		if(session.getAttribute("email") != null)
		{
			 
			try
			{
				result = AgentCreationDb.VerifiedRegisterAgent(fname,lname,email,password,contact,organization,id);
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage()+" pakage : com.create_agent.umair.Servlets , servlet : RegisterAgent , method : VerifiedRegisterAgent");
			}
			
		}
		else
		{
			try
			{
				result = AgentCreationDb.RegisterAgent(fname,lname,email,password,contact,organization);
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage()+" pakage : com.create_agent.umair.Servlets , servlet : RegisterAgent , Method : RegisterAgent");
			}
		}
		if(result != null)
		{
			if(session.getAttribute("id") != null)
			{
				Message =  "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt -19pt 6pt;'>"
						+ "<b>Account Registration Completed</b><br><br>"
						+ "<i>Please Login To Continue</i>"
						+ "</div>";	
				to = "login.jsp";
			}
			else
			{
				String subject = "Account Verification Required!";
				String content = "Welcome Agent to Wealth Estate Pakistan Pvt."
						+ "\n\n"
						+ "We recieved your account request"
						+ "\n\n"
						+ "**** Click link below to verify your account ****\n"
						+ "Link : http://localhost:8080/WPPS/VerifyAccountPath?token="+result+"&email="+email+""
						+ "\n\n"
						+ "**** Note ****\n"
						+ "-If you didnt verify account within 7 days, your account will be removed.\n"
						+ "\n\n"
						+ ""+ "**** Note ****\n"
						+ "-If you didnt ask for this accoount then ignor this email, your account will be removed from system after 7 days.\n"
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
					System.out.println(ex);
				}
				Message = "<div style='color:gray; width:500pt;margin:0.5pt 0pt 2pt -130pt;padding-left:2pt;'>"
						+ "<center><b><span style='color:black'>Account Registration Request Submited</span></b><br><br>"
						+ "Email Verification Is Required in order to complete you request<br>"
						+ "Verification link is send to your email address<br>"
						+ email
						+ "</center></div>";
				to = "info.jsp";
			}	
		}
		else
		{
			Message = "<div style='border:1px solid #f35118;color:#f35118; width:253pt;margin:0.5pt 0pt 2pt 7pt;padding-left:2pt;'>"
					+ "Account Registration Failed"
					+ "</div>";
			to = "signup.jsp";
		}
		
		session.removeAttribute("email");
		session.removeAttribute("id");
		session.setAttribute("message",Message);		
		response.sendRedirect(to);
	}

}
