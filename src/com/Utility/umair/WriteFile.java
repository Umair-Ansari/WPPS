package com.Utility.umair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteFile {
	public static void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) 
	{
	 
			try 
			{
				File file = new File(uploadedFileLocation);
				OutputStream out = new FileOutputStream(file);
				int read = 0;
				byte[] bytes = new byte[1024];

				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) 
				{
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}

	}
}
