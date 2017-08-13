package org.pensions.md.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date toDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//String dateInString = "07/06/2013";
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

	
	public static String toString(Date dateInDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//String dateInString = "07/06/2013";
		String date = null;
		try {
			date = formatter.format(dateInDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static Date getDateWithoutTime(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}

	public static Date getTomorrowDate(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, 1);
	    return cal.getTime();
	}
	
	public static Date getTomorrow(Date today) {
		return new Date(today.getTime() + (1000 * 60 * 60 * 24));
	}
}
