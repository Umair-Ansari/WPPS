package com.Utility.umair;

import java.io.File;
public class Directory
{

	public static void CreatDirectory(String ad)
	{
		String path = "C:\\Users\\Umair\\.eclipse\\WPPS\\WebContent\\images\\Directory";
		//String path = "C:\\Program Files\\Java\\apache-tomcat-8.0.18\\webapps\\WPPS\\images\\Directory";
		//String path = System.getProperty("catalina.base")+"\\webapps\\WPPS\\images\\Directory"; 
		File theDir = new File(path);
		if(!theDir.exists())
		{
			if(theDir.mkdir()){
				System.out.println("Directoty is created");
			}
			else{
			System.out.println("Failed to create dir");
			}
		}
		File addir = new File(path+"\\"+ad);
		if(!addir.exists())
		{
			if(addir.mkdir()){
				System.out.println("Directoty is created");
			}
			else{
			System.out.println("Failed to create dir");
			}
		}
	}
}
	