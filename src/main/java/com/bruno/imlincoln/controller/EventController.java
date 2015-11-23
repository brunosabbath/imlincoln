package com.bruno.imlincoln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/pages/{total}" ,method = RequestMethod.GET)
	public List<EventPojo> pagination(@PathVariable int total){
		service = new EventService(eventRepo);
		return service.listPage(total);
	}
	
	@RequestMapping(value = "name/{name}" ,method = RequestMethod.GET)
	public List<EventPojo> get(@PathVariable String name){
		service = new EventService(eventRepo);
		return service.getByName(name);
	}
	
	@RequestMapping(value = "/available" ,method = RequestMethod.GET)
	public List<EventPojo> findAvailableEvets(){
		service = new EventService(eventRepo);
		return service.findAvailableEvets();
	}
	
	@RequestMapping(value = "/available/{name}" ,method = RequestMethod.GET)
	public List<EventPojo> findAvailableEvetsByName(@PathVariable String name){
		service = new EventService(eventRepo);
		return service.findAvailableEvetsByName(name);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
		service = new EventService(eventRepo);
		service.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void edit(@RequestBody Event event){
		service = new EventService(eventRepo);
		service.save(event);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Event event){
		service = new EventService(eventRepo);
		service.save(event);;
	}
	
}