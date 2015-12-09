package com.bruno.imlincoln.service;

import java.util.List;

import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.model.pojo.EventPojo;

public interface EventService {

	public void save(Event event) throws RuntimeException;
	public List<EventPojo> list();
	public EventPojo get(Long id);
	public List<EventPojo> getByName(String name);
	public List<EventPojo> findAvailableEvets();
	public List<EventPojo> findAvailableEvetsByName(String name);
	public List<EventPojo> listPage(int total);
	public List<EventPojo> findEventByVenueId(Long id);
	public void delete(Long id);
	
}
