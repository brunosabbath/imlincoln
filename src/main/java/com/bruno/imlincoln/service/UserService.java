package com.bruno.imlincoln.service;

import java.util.List;

import com.bruno.imlincoln.builder.UserPojoBuilder;
import com.bruno.imlincoln.dao.repository.UserRepository;
import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.model.pojo.UserPojo;
import com.bruno.imlincoln.model.validation.UserValidation;
import com.bruno.imlincoln.utils.EncryptPassword;

public class UserService{
	
	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo){
		this.userRepo = userRepo;
	}
	
	public List<User> list() {
		return (List<User>) userRepo.findAll();
	}

	public void save(User user){
		
		UserValidation.checkValidation(user);
		String password = EncryptPassword.generate(user.getPassword());
		user.setPassword(password);
		userRepo.save(user);
		
	}
	
	public void markEventAsFavorite(User user, Event event) throws Exception{
		
		try{
			user.addEvent(event);
			userRepo.save(user);
		}catch(RuntimeException e){
			throw new RuntimeException("Event already added");
		}
	}

	public User getUserWithEvent(Long id){
		return userRepo.getUserWithEvent(id);
	}
	
	public User get(Long id) {
		return userRepo.findUserById(id);
	}
	
	public UserPojo toPojo(User user){

		return UserPojoBuilder.build(user);
	}
	
}
