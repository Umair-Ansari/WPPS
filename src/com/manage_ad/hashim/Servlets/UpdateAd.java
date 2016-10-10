package com.manage_ad.hashim.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.Utility.umair.Connector;
import com.Utility.umair.Directory;
import com.Utility.umair.FileName;
import com.Utility.umair.WriteFile;
import com.manage_ad.hashim.DbLayer.AdManagementDb;

/**
 * Servlet implementation class UpdateAd
 */
@MultipartConfig
@WebServlet("/UpdateAdPath")
public class UpdateAd extends HttpServlet {
	String path = Connector.ConnectorPath();
	String saveFile= path;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Message = ""; 
		HttpSession session = request.getSession(true);
		response.setContentType("text/html;charset=UTF-8");
		String result = null;
		String price = request.getParameter("price");
		String p_id = request.getParameter("p_id");
		String landtype = request.getParameter("landtype");
		String g_id = request.getParameter("g_id");
		System.out.println(p_id);
		//System.out.println(price);
		String far = request.getParameter("far");
		String type = request.getParameter("type");
		String land = request.getParameter("land");
		String details = request.getParameter("details");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String a_id = "1";
		String user =  request.getParameter("user");
		try{
			result = AdManagementDb.UpdateAd(p_id,price,far,type,land,details, longitude, latitude, a_id,user,g_id,landtype);
		}catch (SQLException e) {
			System.out.println(e.getMessage()+" servlet : PostAd not prepared in pakage :  com.manage_ad");
		}
		if(result != null)
		{
			
			Directory.CreatDirectory(result);
			for(int i=1;i<=4;i++){
				Part filePart;
				filePart = request.getPart("filetouplaod"+i);
				String fileName = FileName.getFileName(filePart);
				if(!fileName.isEmpty())
				{
					String ext = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
					WriteFile.writeToFile(filePart.getInputStream(), saveFile+"\\"+result+"\\"+i+ext);
				}
			
			}
			
			
		}
		Message = "<div style='border:1px solid green;color:green; width:131pt;margin:-0.5pt 195pt 2pt 0pt;padding-left:2pt;float:right;font-size:13px;'>"
				+ "Ad Updated"
				+ "</div>";	
		session.setAttribute("message",Message);
		response.sendRedirect("panel/new.jsp");
	}

}
