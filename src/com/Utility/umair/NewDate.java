package com.Utility.umair;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewDate {
	public static String get_date(int dates){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, dates);
		String date = sdf.format(c.getTime());
		return date;
	}
}
