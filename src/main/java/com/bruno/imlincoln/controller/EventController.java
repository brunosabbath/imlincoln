package com.bruno.imlincoln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.imlincoln.dao.repository.EventRepository;
import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.pojo.EventPojo;
import com.bruno.imlincoln.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventRepository eventRepo; 
	
	private EventService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EventPojo> list(){
	
		service = new EventService(eventRepo);
		return service.list();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public EventPojo get(@PathVariable Long id){
		service = new EventService(eventRepo);
		return service.get(id);
	}
	
	@RequestMapping(value = "name/{name}" ,method = RequestMethod.GET)
	public List<EventPojo> get(@PathVariable String name){
		service = new EventService(eventRepo);
		return service.getByName(name);
	}
	
}