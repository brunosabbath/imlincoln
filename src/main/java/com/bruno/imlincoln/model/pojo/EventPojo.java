package com.bruno.imlincoln.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class EventPojo {

	private Long id;
	private String address;
	private String description;
	private String endDate;
	private String name;
	private String price;
	private String startDate;
	private VenuePojo venue;
	private List<String> tags;
	private int totalUsers;
	
	public EventPojo(){
		tags = new ArrayList<String>();
	}
	
	public Long getId() {
		return id;
	}
	public EventPojo setId(Long id) {
		this.id = id;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public EventPojo setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public EventPojo setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getEndDate() {
		return endDate;
	}
	public EventPojo setEndDate(String endDate) {
		this.endDate = endDate;
		return this;
	}
	public String getName() {
		return name;
	}
	public EventPojo setName(String name) {
		this.name = name;
		return this;
	}
	public String getPrice() {
		return price;
	}
	public EventPojo setPrice(String price) {
		this.price = price;
		return this;
	}
	public String getStartDate() {
		return startDate;
	}
	public EventPojo setStartDate(String startDate) {
		this.startDate = startDate;
		return this;
	}
	public VenuePojo getVenue() {
		return venue;
	}
	public EventPojo setVenue(VenuePojo venue) {
		this.venue = venue;
		return this;
	}
	public List<String> getTags() {
		return tags;
	}
	public EventPojo addTags(String tag) {
		tags.add(tag);
		return this;
	}
	public int getTotalUsers() {
		return totalUsers;
	}
	public EventPojo setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
		return this;
	}
	
}
