package com.manage_notification.hashim.Jsp_Function;

import java.sql.SQLException;
import java.util.List;

import com.Utility.umair.Notification;
import com.Utility.umair.User;
import com.manage_notification.hashim.DbLayer.NotificationManagement;

public class NotificationManagementJsp {

	public static String view() throws SQLException
	{
		String print  = "";
		 String id;
		 String name;
		String email;
		 String contact;
		 String message;
		
		List<Notification> notification = null;
		try {
			notification = NotificationManagement.Notification();

		} catch (Exception e) {
					}
		for(Notification ad:notification)
		   {
			 id = ad.id;
			 name = ad.name;
			email = ad.email;
			contact = ad.contact;
			message = ad.message;
			print += "<div class='notification_panel'>"
					+ "<table>"
						+ "<col width='50%'>"
						+ "<col width='50%'>"
						+ "<tr>"
						+ "<td>Name</td>"
						+ "<td>"+name+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>Email</td>"
						+ "<td>"+email+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>Contact</td>"
						+ "<td>"+contact+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><br>Message</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td colspan='2'><p style='width:100%;height:auto;'>"+message+"</p></td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td colspan='2'><br><center><form action='../DeleteNotificationPath' method='post'><input type='text' name='id' value='"+id+"' hidden><input type='submit' class='myButton' value='Delete'></form></center></td>"
						+ "</tr>"
			+ "</table>"
		+ "</div>";
			
		   }
		return print;
	}
	
}
