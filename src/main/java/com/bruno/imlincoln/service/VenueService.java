package com.bruno.imlincoln.service;

import java.util.List;

import com.bruno.imlincoln.model.Venue;
import com.bruno.imlincoln.model.pojo.VenuePojo;

public interface VenueService {

	public void save(Venue venue);
	public List<VenuePojo> list();
	public VenuePojo get(Long id);
	public List<VenuePojo> getByName(String name);
	public void delete(Long id);
	public List<Venue> listSimpleVenues();
}
