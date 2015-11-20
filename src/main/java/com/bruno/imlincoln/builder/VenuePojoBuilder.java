package com.bruno.imlincoln.builder;

import java.util.ArrayList;

import java.util.List;

import com.bruno.imlincoln.model.Venue;
import com.bruno.imlincoln.model.pojo.VenuePojo;

public class VenuePojoBuilder {

	public static VenuePojo build(Venue venue){
		
		VenuePojo pojo = new VenuePojo();
		
		pojo.setAddress(venue.getAddress()).setAddressComplement(venue.getAddressComplement()).setCity(venue.getCity())
		.setDescription(venue.getDescription()).setEmail(venue.getEmail()).setFacebook(venue.getFacebook())
		.setId(venue.getId()).setName(venue.getName()).setTelephone(venue.getTelephone())
		.setTwitter(venue.getTwitter()).setWebsite(venue.getWebsite())
		.setEvent(EventPojoBuilder.buildSimpleWithoutVenue(venue.getEvents()));
		
		return pojo;
	}

	public static VenuePojo buildSimple(Venue venue) {
		VenuePojo pojo = new VenuePojo();
		pojo.setId(venue.getId()).setName(venue.getName());
		return pojo;
	}
	
	public static List<VenuePojo> buildSimple(List<Venue> list){
		List<VenuePojo> simpleList = new ArrayList<VenuePojo>();
		
		for(Venue venue : list)
			simpleList.add(buildSimple(venue));
		
		return simpleList;
	}
	
	
}
