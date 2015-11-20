package com.bruno.imlincoln.builder;


import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.model.pojo.UserPojo;

public class UserPojoBuilder {

	public static UserPojo build(User user){
		UserPojo pojo = new UserPojo();
		
		pojo.setEmail(user.getEmail()).setId(user.getId()).setName(user.getName())
		.setRole(user.getRole().getRole()).setEvent(EventPojoBuilder.buildSimpleWithoutVenue(user.getEvents()));
		
		return pojo;
	}
	
}
