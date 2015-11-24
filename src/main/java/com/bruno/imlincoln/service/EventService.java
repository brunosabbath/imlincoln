package com.bruno.imlincoln.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
		
		List<Event> list = eventRepo.findEventByNameContaining(name);
		
		if(list == null)
			throw new NotFoundException("No events found");
		
		return EventPojoBuilder.build(list);
	}

	public List<EventPojo> findAvailableEvets() {
		Timestamp today = Timestamp.valueOf(LocalDateTime.now());
		List<Event> list = eventRepo.findAvailableEvets(today);
		
		if(list == null || list.isEmpty())
			throw new NotFoundException("No event available");
		
		return EventPojoBuilder.build(list);
		
	}

	public List<EventPojo> findAvailableEvetsByName(String name) {
		
		Timestamp today = Timestamp.valueOf(LocalDateTime.now());
		List<Event> list = eventRepo.findEventByEndDateGreaterThanAndNameContainingIgnoreCase(today,name);
		
		if(list == null || list.isEmpty())
			throw new NotFoundException("No event available");
		
		return EventPojoBuilder.build(list);
	}

	public void delete(Long id) {
		
		eventRepo.delete(id);
	}

	public List<EventPojo> listPage(int total) {
		PageRequest request = new PageRequest(total, 2);
		Page<Event> listOldPage = eventRepo.findAll(request);
		List<Event> listEvent = new ArrayList<Event>();
		
		for(Event e : listOldPage)
			listEvent.add(e);
		
		List<EventPojo> listEventPojo = EventPojoBuilder.build(listEvent);
		
		return listEventPojo;
	}

	public List<EventPojo> findEventByVenueId(Long id) {
		List<Event> list = eventRepo.findEventByVenueId(id);
		return EventPojoBuilder.buildSimpleWithoutVenue(list);
	}

}
