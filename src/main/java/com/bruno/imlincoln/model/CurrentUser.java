package com.bruno.imlincoln.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User{

	private User user;
	
	public CurrentUser(User user) {
		super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		user.setEvents(null);
		user.setRole(null);
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public Long getId(){
		return user.getId();
	}
	
	public Role getRole(){
		return user.getRole();
	}

}
