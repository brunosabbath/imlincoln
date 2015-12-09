package com.bruno.imlincoln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.imlincoln.dao.repository.EventRepository;
import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.UserPrincipal;
import com.bruno.imlincoln.model.pojo.EventPojo;
import com.bruno.imlincoln.service.EventService;
import com.bruno.imlincoln.service.impl.EventServiceImpl;

@RestController
@RequestMapping("/event")
public class EventController {
	
	private final EventService service;
	
	@Autowired
	public EventController(EventService service){
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EventPojo> list(){
	
		return service.list();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public EventPojo get(@PathVariable Long id){
		return service.get(id);
	}
	
	@RequestMapping(value = "/pages/{total}" ,method = RequestMethod.GET)
	public List<EventPojo> pagination(@PathVariable int total){
		return service.listPage(total);
	}
	
	@RequestMapping(value = "name/{name}" ,method = RequestMethod.GET)
	public List<EventPojo> get(@PathVariable String name){
		return service.getByName(name);
	}
	
	@RequestMapping(value = "/available" ,method = RequestMethod.GET)
	public List<EventPojo> findAvailableEvets(){
		return service.findAvailableEvets();
	}
	
	@RequestMapping(value = "/available/{name}" ,method = RequestMethod.GET)
	public List<EventPojo> findAvailableEvetsByName(@PathVariable String name){
		return service.findAvailableEvetsByName(name);
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(){
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//User user = ((UserPrincipal) principal).getUser();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user);
	}
	
	@RequestMapping(value = "/venue/{id}" ,method = RequestMethod.GET)
	public List<EventPojo> findEventsFromVenue(@PathVariable Long id){
		return service.findEventByVenueId(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
		service.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void edit(@RequestBody Event event){
		service.save(event);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Event event){
		service.save(event);;
	}
	
}