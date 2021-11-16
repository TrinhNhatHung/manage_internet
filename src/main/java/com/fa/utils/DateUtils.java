package com.fa.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static LocalDate convertStringToDate(String date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(date, formatter);
	}

	public static LocalTime convertStringToTime(String time, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalTime.parse(time, formatter);
	}
}
