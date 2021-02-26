package com.company.yedam.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * String->Date SimpleDateFormat.parse
	 */
	public static java.sql.Date toDate(String date) {
		Date result = null;
		// to do
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			result = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(result.getTime());
	}

	/**
	 * Date->String SimpleDateFormat.format
	 */

	public static String toStr(Date date) {
		String result = null;
		// to do
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		result = dateFormat.format(date);
		return result;
	}

	/**
	 * Date를 주어진 포맷대로 String으로 변환 Date->String SimpleDateFormat.format
	 */

	public static String toStr(Date date, String format) {
		String result = null;
		// to do
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		result = dateFormat.format(date);

		return result;
	}

	public static Date addDay(Date date, int idx) {
		// to do
		Date meetDay = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 100);
		meetDay = c.getTime();

//		Date meetDay = new Date();
//		LocalDateTime.from(meetDay.toInstant()).plusDays(100);

		return meetDay;
	}
}
