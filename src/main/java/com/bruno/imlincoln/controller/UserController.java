package com.bruno.imlincoln.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.imlincoln.model.CurrentUser;
import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.model.pojo.UserPojo;
import com.bruno.imlincoln.roles.AdminUser;
import com.bruno.imlincoln.roles.RoleUser;
import com.bruno.imlincoln.service.EventService;
import com.bruno.imlincoln.service.UserService;
import com.bruno.imlincoln.utils.UserUtils;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService service;
	private final EventService eventService;
	
	@Autowired
	public UserController(UserService service, EventService eventService){
		this.service = service;
		this.eventService = eventService;
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public Principal user(Principal user) {
		return user;
	}
	
	@RequestMapping(value = "/event/{email}", method = RequestMethod.GET)
	public UserPojo get(@PathVariable String email){
		User user = service.getUserWithEvent(email);
		return service.toPojo(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserPojo get(@PathVariable Long id){
		User user = service.get(id);
		return service.toPojo(user);
	}
	
	@RequestMapping(value = "/liked", method = RequestMethod.POST)
	public void likeEvent(@RequestBody Long eventId ){
		Long userId = UserUtils.getCurrentUserId();
		
		User user = service.get(userId);
		Event event = eventService.getEvent(eventId);
		
		service.liked(user, event);
		
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