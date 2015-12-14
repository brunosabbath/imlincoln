package com.bruno.imlincoln.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.imlincoln.builder.UserPojoBuilder;
import com.bruno.imlincoln.dao.repository.UserRepository;
import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.model.pojo.UserPojo;
import com.bruno.imlincoln.model.validation.UserValidation;
import com.bruno.imlincoln.service.UserService;
import com.bruno.imlincoln.utils.DateUtils;
import com.bruno.imlincoln.utils.EncryptPassword;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo){
		this.userRepo = userRepo;
	}
	
	@Override
	public List<User> list() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public void save(User user){
		
		UserValidation.checkValidation(user);
		String password = EncryptPassword.generate(user.getPassword());
		user.setPassword(password);
		userRepo.save(user);
		
	}
	
	@Override
	public void markEventAsFavorite(User user, Event event) throws Exception{
		
		try{
			user.addEvent(event);
			userRepo.save(user);
		}catch(RuntimeException e){
			throw new RuntimeException("Event already added");
		}
	}

	@Override
	public User getUserWithEvent(String email){
		User user = userRepo.findUserByEmail(email);
		user.setEvents(getAvailableEvents(user));
		return user;
	}
	
	private List<Event> getAvailableEvents(User user) {
		List<Event> events = new ArrayList<Event>();
		
		for(Event event : user.getEvents()){
			if(event.getEndDate().after(DateUtils.getToday()))
				events.add(event);
		}
		
		return events;
	}

	@Override
	public User get(Long id) {
		return userRepo.findUserById(id);
	}
	
	
	@Override
	public UserPojo toPojo(User user){

		return UserPojoBuilder.build(user);
	}

	@Override
	public void liked(User user, Event event) {
		user.updateEvent(event);
		userRepo.save(user);
		
	}
	
}
