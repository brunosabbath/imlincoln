package com.bruno.imlincoln.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.imlincoln.dao.repository.UserRepository;
import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.model.pojo.UserPojo;
import com.bruno.imlincoln.roles.AdminUser;
import com.bruno.imlincoln.roles.RoleUser;
import com.bruno.imlincoln.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repo;
	private UserService service;
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public Principal user(Principal user) {
		System.out.println(user);
		return user;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserPojo get(@PathVariable Long id){
		service = new UserService(repo);
		User user = service.get(id);
		return service.toPojo(user);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveUser(@RequestBody User user){
		user.setRole(new RoleUser());
		service.save(user);
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public void saveAdmin(@RequestBody User user){
		user.setRole(new AdminUser());
		service.save(user);
	}
	
}
