package com.bruno.imlincoln.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bruno.imlincoln.model.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long>{

	List<Venue> findVenueByName(String name);

}
