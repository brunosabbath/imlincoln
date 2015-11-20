package com.bruno.imlincoln.model.validation;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.bruno.imlincoln.exception.InvalidArgumentException;
import com.bruno.imlincoln.exception.InvalidDateException;
import com.bruno.imlincoln.model.Event;

public class EventValidation{

	public static void checkValidation(Event event){
	
		if(event.getName() == null)
			throw new InvalidArgumentException("Event name can not be empty");
		
		if(event.getStartDate() == null || event.getEndDate() == null)
			throw new InvalidDateException("Start date/end date can not be empty");
		
		if(event.getEndDate().before(Timestamp.valueOf(LocalDateTime.now())))
			throw new InvalidDateException("End date must be greater than now");
			
		if(event.getEndDate().before(event.getStartDate()))
			throw new InvalidDateException("End date is greater than start date");
		
	}

}
