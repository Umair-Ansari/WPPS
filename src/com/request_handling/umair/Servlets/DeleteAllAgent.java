package com.request_handling.umair.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.request_handling.umair.DbLayer.RequestHandlingDb;

/**
 * Servlet implementation class DeleteAllAgent
 */
@WebServlet("/DeleteAllAgentPath")
public class DeleteAllAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String delete = null;
		if(request.getParameter("delete") != null){
			try{
				delete = RequestHandlingDb.DeleteAllAgent();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		if(delete != null){
			delete = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:5.5pt 0pt 2pt 0pt;padding-left:2pt;float:left;'>"
					+ "All Agent Request Deleted"
					+ "</div>";	
			session.setAttribute("message",delete);
			response.sendRedirect("panel/request.jsp");
		}
		else{
			delete = "<div style='border:1px solid #2cb649;color:#2cb649; width:131pt;margin:5.5pt 0pt 2pt 0pt;padding-left:2pt;float:left;'>"
					+ "Operation Failed"
					+ "</div>";	
			session.setAttribute("message",delete);
			response.sendRedirect("panel/request.jsp");
		}
		
	}

}
