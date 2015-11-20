package com.bruno.imlincoln.roles;

import com.bruno.imlincoln.model.Role;

public class AdminUser extends Role{
	private static final long serialVersionUID = 1L;

	public AdminUser(){
		super.setId(2);
		super.setRole("admin");
	}
	
}
