package com.bruno.imlincoln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.imlincoln.dao.repository.VenueRepository;
import com.bruno.imlincoln.exception.NotFoundException;
import com.bruno.imlincoln.model.Venue;
import com.bruno.imlincoln.model.pojo.VenuePojo;
import com.bruno.imlincoln.service.VenueService;

@RestController
@RequestMapping("/venue")
public class VenueController {

	@Autowired
	private VenueRepository repo;
	
	private VenueService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<VenuePojo> list(){
		service = new VenueService(repo);
		return service.list();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public VenuePojo get(@PathVariable Long id){
		
		try {
			service = new VenueService(repo);
			return service.get(id);
		} catch (NotFoundException e) {
			throw e;
		}
		
	}
	
	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	public List<VenuePojo> get(@PathVariable String name){
		
		service = new VenueService(repo);
		return service.getByName(name);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Venue venue){
		service = new VenueService(repo);
		service.save(venue);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void update(@PathVariable Long id){
		service = new VenueService(repo);
		service.delete(id);
	}
	
}
