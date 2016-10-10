package com.Utility.umair;

import javax.servlet.http.Part;

public class FileName {

	public static String getFileName(Part part) 
	{
	    for (String cd : part.getHeader("content-disposition").split(";")) 
	    {
	        if (cd.trim().startsWith("filename")) 
	        {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;	
	 }
}
