package com.bruno.imlincoln.dao.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.bruno.imlincoln.model.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long>{

	public List<Event> findEventByNameContaining(String name);
	@Query("SELECT e FROM Event AS e WHERE e.endDate >= :today ORDER BY e.endDate")
	public List<Event> findAvailableEvets(@Param("today") Timestamp today);
	//@Query("SELECT e FROM Event AS e WHERE e.endDate >= :today AND e.name LIKE :name ORDER BY e.endDate")
	public List<Event> findEventByEndDateGreaterThanAndNameContainingIgnoreCase(Timestamp today, String name);
	public Page<Event> findEventByEndDateGreaterThan(Timestamp today, Pageable pageable);
	public List<Event> findEventByVenueId(Long id);
}
