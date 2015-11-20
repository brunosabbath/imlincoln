package com.bruno.imlincoln.builder;

import java.util.ArrayList;

import java.util.List;

import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.Tag;
import com.bruno.imlincoln.model.pojo.EventPojo;

public class EventPojoBuilder {

	public static EventPojo buildSimple(Event event){
		
		EventPojo eventPojo = new EventPojo();
		
		eventPojo.setId(event.getId()).setName(event.getName());
		
		if(event.getVenue() != null)
			eventPojo.setVenue(VenuePojoBuilder.buildSimple(event.getVenue()));
		
		return eventPojo;
	}
	
	public static EventPojo buildSimpleWithoutVenue(Event event){
		
		EventPojo eventPojo = new EventPojo();
		eventPojo.setId(event.getId()).setName(event.getName());
		return eventPojo;
	}
	
	public static List<EventPojo> buildSimple(List<Event> list){
		
		List<EventPojo> simpleList = new ArrayList<EventPojo>();
		
		for(Event event : list){
			simpleList.add(buildSimple(event));
		}
		
		return simpleList;
	}
	
	public static List<EventPojo> buildSimpleWithoutVenue(List<Event> list){
		List<EventPojo> simpleList = new ArrayList<EventPojo>();
		
		for(Event event : list){
			simpleList.add(buildSimpleWithoutVenue(event));
		}
		
		return simpleList;
	}
	
	public static EventPojo build(Event event){
		
		EventPojo pojo = buildPojo(event);
		return pojo;
	}
	
	public static List<EventPojo> build(List<Event> events){
		
		List<EventPojo> list = new ArrayList<EventPojo>();
		
		for(Event event : events){
			EventPojo pojo = buildPojo(event);
			list.add(pojo);
		}
		
		return list;
	}
	
	private static EventPojo buildPojo(Event event){
		
		EventPojo pojo = new EventPojo();
		
		pojo.setAddress(event.getAddress()).setDescription(event.getDescription())
		.setEndDate(event.getEndDate().toString()).setId(event.getId()).setName(event.getName())
		.setPrice(event.getPrice()).setStartDate(event.getStartDate().toString()).setTotalUsers(event.getUsers().size())
		.setId(event.getId());
		
		for(Tag tag : event.getTags()){
			pojo.addTags(tag.getName());
		}
		
		if(event.getVenue() != null)
			pojo.setVenue(VenuePojoBuilder.buildSimple(event.getVenue()));
		
		return pojo;
	}
	
}