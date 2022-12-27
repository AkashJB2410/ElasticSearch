package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.entity;
import com.example.demo.repository.repository;
import com.example.demo.service.service;

@RestController
public class controller {

	@Autowired
	public repository repo ;
	
	@Autowired
	public service serv ;
	
	@GetMapping("/search/{text}")
	public List<entity> doMultimatchEntities(@PathVariable String text){
		return serv.search(text);
	}
	
	@RequestMapping("/saveentity")
	public int saveentity (@RequestBody List<entity> entity) {
		serv.saveentity(entity);
		return entity.size();
	}
	
	@GetMapping("/findAll")
	public Iterable<entity> fimdAllentity (){
		return serv.findAllentity();
	}
	
}
