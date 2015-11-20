package com.bruno.imlincoln.service;

import java.util.ArrayList;
import java.util.List;

import com.bruno.imlincoln.builder.VenuePojoBuilder;
import com.bruno.imlincoln.dao.repository.VenueRepository;
import com.bruno.imlincoln.exception.NotFoundException;
import com.bruno.imlincoln.model.Venue;
import com.bruno.imlincoln.model.pojo.VenuePojo;

public class VenueService {

	private VenueRepository venueRepo;
	
	public VenueService(VenueRepository venueRepo){
		this.venueRepo = venueRepo;
	}
	
	public void save(Venue venue){
		
		venueRepo.save(venue);
	}
	
	public List<VenuePojo> list(){
		
		List<Venue> list = (List<Venue>) venueRepo.findAll();
		List<VenuePojo> listPojo = new ArrayList<VenuePojo>();
		
		for(Venue venue : list)
			listPojo.add(VenuePojoBuilder.build(venue));
		
		return listPojo;
	}
	
	public List<Venue> listVenueByName(String name){
		return venueRepo.findVenueByName(name);
	}

	public VenuePojo get(Long id) {

		Venue venue = venueRepo.findOne(id);
		
		if(venue == null)
			throw new NotFoundException("Venue not found");
		
		return VenuePojoBuilder.build(venue);
	}

	public List<VenuePojo> getByName(String name) {
		
		List<Venue> list = venueRepo.findVenueByName(name);
		List<VenuePojo> listPojo = new ArrayList<VenuePojo>();
		
		if(list.isEmpty() || list == null)
			throw new NotFoundException("Venue not found");
		
		for(Venue venue : list)
			listPojo.add(VenuePojoBuilder.build(venue));
			
		return listPojo;
	}
	
}
