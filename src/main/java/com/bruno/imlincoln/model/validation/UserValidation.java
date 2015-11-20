package com.bruno.imlincoln.model.validation;

import com.bruno.imlincoln.exception.InvalidArgumentException;
import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.utils.EmailValidator;

public class UserValidation {

	public static void checkValidation(User user){
		
		if(user.getName() == null || user.getName().length() < 2)
			throw new InvalidArgumentException("Name can not be empty or less than 2 letters");
		
		if(user.getPassword() == null)
			throw new InvalidArgumentException("Password can not be empty");
		
		EmailValidator emailValidator = new EmailValidator();
		
		if(user.getEmail() == null || !emailValidator.validate(user.getEmail()))
			throw new InvalidArgumentException("Invalid email");
		
		if(user.getRole() == null)
			throw new InvalidArgumentException("Role can not be null");
		
	}
	
}
