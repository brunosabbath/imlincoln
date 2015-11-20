package com.bruno.imlincoln.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserPojo {
	
	private Long id;
	private String email;
	private String name;
	private String role;
	private List<EventPojo> events;

	public UserPojo(){
		events = new ArrayList<EventPojo>();
	}

	public Long getId() {
		return id;
	}

	public UserPojo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserPojo setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserPojo setName(String name) {
		this.name = name;
		return this;
	}

	public String getRole() {
		return role;
	}

	public UserPojo setRole(String role) {
		this.role = role;
		return this;
	}

	public List<EventPojo> getEvents() {
		return events;
	}

	public UserPojo addEvent(EventPojo event) {
		events.add(event);
		return this;
	}
	
	public UserPojo setEvent(List<EventPojo> events){
		this.events = events;
		return this;
	}
	
}
