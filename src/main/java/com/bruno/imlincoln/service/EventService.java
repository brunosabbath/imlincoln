package com.bruno.imlincoln.service;

import java.util.List;

import com.bruno.imlincoln.builder.EventPojoBuilder;
import com.bruno.imlincoln.dao.repository.EventRepository;
import com.bruno.imlincoln.exception.NotFoundException;
import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.pojo.EventPojo;
import com.bruno.imlincoln.model.validation.EventValidation;

public class EventService {

	private EventRepository eventRepo;
	
	public EventService(EventRepository eventRepo){
		this.eventRepo = eventRepo;
	}
	
	public void save(Event event) throws RuntimeException{
		
		EventValidation.checkValidation(event);
		eventRepo.save(event);
	}
	
	public List<EventPojo> list(){
		
		List<EventPojo> list = EventPojoBuilder.build((List<Event>) eventRepo.findAll());
		
		if(list == null)
			throw new NotFoundException("No events");
		
		return list;
	}

	public EventPojo get(Long id) {
		Event event = eventRepo.findOne(id);
		
		if(event == null){
			throw new NotFoundException("Event not found");
		}
		return EventPojoBuilder.build(event);
	}

	public List<EventPojo> getByName(String name) {
		
		List<Event> list = eventRepo.findEventByNameLike(name);
		
		if(list == null)
			throw new NotFoundException("No events found");
		
		return EventPojoBuilder.build(list);
	}

}
