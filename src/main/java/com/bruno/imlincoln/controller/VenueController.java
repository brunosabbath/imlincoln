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
import com.bruno.imlincoln.service.impl.VenueServiceImpl;

@RestController
@RequestMapping("/venue")
public class VenueController {
	
	private final VenueService service;
	
	@Autowired
	public VenueController(VenueService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<VenuePojo> list(){
		return service.list();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public VenuePojo get(@PathVariable Long id){
		
		try {
			return service.get(id);
		} catch (NotFoundException e) {
			throw e;
		}
		
	}
	
	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	public List<VenuePojo> get(@PathVariable String name){
		
		return service.getByName(name);
	}
	
	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public List<Venue> listSimpleVenues(){
		
		return service.listSimpleVenues();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Venue venue){
		service.save(venue);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void update(@PathVariable Long id){
		service.delete(id);
	}
	
}
