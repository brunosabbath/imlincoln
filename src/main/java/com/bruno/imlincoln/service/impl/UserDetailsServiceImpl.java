package com.bruno.imlincoln.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bruno.imlincoln.model.CurrentUser;
import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserService service;
	
	@Autowired
	public UserDetailsServiceImpl(UserService service) {
		this.service = service;
	}
	
	@Override
	public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = service.getUserWithEvent(email);
		
		if(user == null)
			throw new UsernameNotFoundException("user not found");
		
		CurrentUser currentUser = new CurrentUser(user);
		
		return currentUser;
		
	}

}
