package com.bruno.imlincoln.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.bruno.imlincoln.model.CurrentUser;
import com.bruno.imlincoln.model.User;

public class UserUtils {

	public static CurrentUser getCurrentUser(){
		return (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public static Long getCurrentUserId(){
		return getCurrentUser().getId();
	}
	
	public static User buildOwner(){
		User owner = new User();
		owner.setId(getCurrentUserId());
		return owner;
	}
	
}
