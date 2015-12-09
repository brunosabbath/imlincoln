package com.bruno.imlincoln.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.imlincoln.builder.VenuePojoBuilder;
import com.bruno.imlincoln.dao.repository.VenueRepository;
import com.bruno.imlincoln.exception.NotFoundException;
import com.bruno.imlincoln.model.Venue;
import com.bruno.imlincoln.model.pojo.VenuePojo;
import com.bruno.imlincoln.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService{

	private final VenueRepository venueRepo;
	
	@Autowired
	public VenueServiceImpl(VenueRepository venueRepo){
		this.venueRepo = venueRepo;
	}
	
	@Override
	public void save(Venue venue){
		
		venueRepo.save(venue);
	}
	
	@Override
	public List<VenuePojo> list(){
		
		List<Venue> list = (List<Venue>) venueRepo.findAll();
		List<VenuePojo> listPojo = new ArrayList<VenuePojo>();
		
		for(Venue venue : list)
			listPojo.add(VenuePojoBuilder.build(venue));
		
		return listPojo;
	}

	@Override
	public VenuePojo get(Long id) {

		Venue venue = venueRepo.findOne(id);
		
		if(venue == null)
			throw new NotFoundException("Venue not found");
		
		return VenuePojoBuilder.build(venue);
	}

	@Override
	public List<VenuePojo> getByName(String name) {
		
		List<Venue> list = venueRepo.findVenueByNameContaining(name);
		List<VenuePojo> listPojo = new ArrayList<VenuePojo>();
		
		if(list.isEmpty() || list == null)
			throw new NotFoundException("Venue not found");
		
		for(Venue venue : list)
			listPojo.add(VenuePojoBuilder.build(venue));
			
		return listPojo;
	}

	@Override
	public void delete(Long id) {
		venueRepo.delete(id);
	}
	
}
