package com.bruno.imlincoln.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bruno.imlincoln.model.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

	public List<Event> findEventByNameLike(String name);
	
}
