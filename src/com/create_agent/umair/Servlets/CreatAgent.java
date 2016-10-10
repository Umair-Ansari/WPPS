package com.create_agent.umair.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

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
 * Servlet implementation class CreatAgent
 */
@WebServlet(description = "for agent creation frm admin panel", urlPatterns = { "/CreatAgentPath" })
public class CreatAgent extends HttpServlet {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String Result = null;
		try
		{
			Result = AgentCreationDb.CreatAgent(email,password);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage()+" pakage : com.create_agent.umair.Servlets , servlet : CreatAgent , Method : CreatAgent");
		}
		int id_val = new Random().nextInt(9000) + 1000;
		HttpSession session = request.getSession(true);
		String resultMessage = "";
		String subject = "Account Verification Required!";
		String content = "Welcome Agent to Wealth Estate Pakistan Pvt."
				+ "\n\n"
				+ "Admin have just setup your account at 'wealthpakistan.comoj.com'"
				+ "\n\n"
				+ "**** Account verification Information ****\n"
				+ "Email : "+email+"\n"
				+ "Code : "+password+"\n"
				+ "Login : 'http://localhost:8080/WPPS/verify.jsp?id='"+id_val+"\n"
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
		if(Result == "Agent Created!" ){
			try {
				EmailUtility.sendEmail(host, port, user, pass, email, subject,
						content);
				resultMessage = "<div style='background-color:#E2FFEB;;border:1px solid #B8FACC;padding:7pt;margin: 0pt 6pt 0pt 6pt;'>"
						+ "<b>Agent Created!<b></div>";
			} catch (Exception ex) {
				ex.printStackTrace();
				resultMessage = "There were an error: " + ex.getMessage();
			}
			session.setAttribute("message",resultMessage);		
			response.sendRedirect("panel/create.jsp");
		}
	}

}
