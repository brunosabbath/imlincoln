package com.bruno.imlincoln.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtils {

	public static Timestamp getToday(){
		return Timestamp.valueOf(LocalDateTime.now());
	}
	
}
