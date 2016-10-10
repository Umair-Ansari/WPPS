package com.manage_ad.hashim.Servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.sql.SQLException;

import com.manage_ad.hashim.DbLayer.AdManagementDb;
import com.Utility.umair.Connector;
import com.Utility.umair.Directory;
import com.Utility.umair.FileName;
import com.Utility.umair.WriteFile;


@MultipartConfig
@WebServlet("/PostAdPath")
public class PostAd extends HttpServlet {
	String path = Connector.ConnectorPath();
	String saveFile= path;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=UTF-8");
				HttpSession session = request.getSession(true);
				String result = null;
				String Message = "";
				String price = request.getParameter("price");
				//System.out.println(price);
				String far = request.getParameter("far");
				String type = request.getParameter("type");
				String land = request.getParameter("land");
				String details = request.getParameter("details");
				String longitude = request.getParameter("longitude");
				String latitude = request.getParameter("latitude");
				String landtype = request.getParameter("landtype");
				String a_id = request.getParameter("a_id");
				String user = request.getParameter("user");
				try{
					result = AdManagementDb.PostAd(price, far, type, land, details, longitude, latitude, a_id, user,landtype);
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
				Message = "<div style='border:1px solid green;color:green; width:131pt;margin:1.5pt 196pt 2pt 0pt;padding-left:2pt;float:right;font-size:13px;'>"
						+ "Ad Posted"
						+ "</div>";	
				session.setAttribute("message",Message);
				response.sendRedirect("panel/new.jsp");
			}
}



