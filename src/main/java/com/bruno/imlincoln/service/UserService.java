package com.bruno.imlincoln.service;

import java.util.List;

import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.User;
import com.bruno.imlincoln.model.pojo.UserPojo;

public interface UserService {

	public List<User> list();
	public void save(User user);
	public void markEventAsFavorite(User user, Event event) throws Exception;
	public User getUserWithEvent(String email);
	public User get(Long id);
	public UserPojo toPojo(User user);
	public void liked(User user, Event event);
}
