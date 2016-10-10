package com.manage_banner.hashim.Servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

import org.apache.commons.io.FileUtils;
/**
 * Servlet implementation class PostBanner
 */
@MultipartConfig
@WebServlet("/PostBannerPath")
public class PostBanner extends HttpServlet {
	String path = Connector.ConnectorPath();
	String saveFile= path;
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		//String img = "";
		//File folder = new File(path+email);
		//String dir = path+email;
		//System.out.println(dir);
		
		try{
			
		FileUtils.deleteDirectory(new File(path+email));
		System.out.println("done");
		}
		catch(Exception e){}
		Directory.CreatDirectory(email);
		//File[] listOfFiles = folder.listFiles();
		/*for (int i = 0; i < listOfFiles.length; i++) 
		{
		      if (listOfFiles[i].isFile()) 
		      {
		       // System.out.println("File " + listOfFiles[i].getName());
		    	  img = email+"/"+listOfFiles[i].getName();
		    	  System.out.println(img);
		    	  FileUtils.deleteDirectory(new File(img));
		      }
		     
		}
		*/
		response.setContentType("text/html;charset=UTF-8");
		String Message = "";
		HttpSession session = request.getSession(true);
		
		
		
		
		//Directory.CreatDirectory(email);
		Part filePart;
		filePart = request.getPart("filetouplaod");
		String fileName = FileName.getFileName(filePart);
		if(!fileName.isEmpty())
		{
			String ext = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
			WriteFile.writeToFile(filePart.getInputStream(), saveFile+"\\"+email+"\\banner"+ext);
		}
		Message = "<div style='border:1px solid green;color:green; width:131pt;margin:5.5pt 280pt 2pt 0pt;padding-left:2pt;float:right;font-size:13px;'>"
				+ "Banner Updated"
				+ "</div>";	
		session.setAttribute("message",Message);
		
		response.sendRedirect("panel/bnner.jsp");
	}

}
