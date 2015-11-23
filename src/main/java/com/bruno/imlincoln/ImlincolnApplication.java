package com.bruno.imlincoln;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.imlincoln.dao.repository.EventRepository;
import com.bruno.imlincoln.model.Event;
import com.bruno.imlincoln.service.EventService;

@SpringBootApplication
public class ImlincolnApplication{
	
	EventService service;
	@Autowired
	EventRepository repo;
	
    public static void main(String[] args) {
        SpringApplication.run(ImlincolnApplication.class, args);
    }
}