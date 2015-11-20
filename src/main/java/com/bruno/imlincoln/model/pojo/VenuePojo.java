package com.bruno.imlincoln.model.pojo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class VenuePojo {

	private Long id;
	private String address;
	private String addressComplement;
	private String city;
	private String description;
	private String email;
	private String facebook;
	private String name;
	private BigInteger telephone;
	private String twitter;
	private String website;
	private List<EventPojo> events;
	
	public VenuePojo(){
		this.events = new ArrayList<EventPojo>();
	}
	
	public Long getId() {
		return id;
	}
	
	public VenuePojo setId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getAddress() {
		return address;
	}
	
	public VenuePojo setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public String getAddressComplement() {
		return addressComplement;
	}
	
	public VenuePojo setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
		return this;
	}

	public String getCity() {
		return city;
	}
	
	public VenuePojo setCity(String city) {
		this.city = city;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public VenuePojo setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public VenuePojo setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getFacebook() {
		return facebook;
	}
	
	public VenuePojo setFacebook(String facebook) {
		this.facebook = facebook;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public VenuePojo setName(String name) {
		this.name = name;
		return this;
	}
	
	public BigInteger getTelephone() {
		return telephone;
	}
	
	public VenuePojo setTelephone(BigInteger telephone) {
		this.telephone = telephone;
		return this;
	}
	
	public String getTwitter() {
		return twitter;
	}
	
	public VenuePojo setTwitter(String twitter) {
		this.twitter = twitter;
		return this;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public VenuePojo setWebsite(String website) {
		this.website = website;
		return this;
	}
	
	public List<EventPojo> getEvents() {
		return events;
	}
	
	public void addEvents(EventPojo event) {
		this.events.add(event);
	}
	
	public VenuePojo setEvent(List<EventPojo> events){
		this.events = events;
		return this;
	}
	
}
