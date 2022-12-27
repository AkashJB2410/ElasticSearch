package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.controller.controller;
import com.example.demo.entity.entity;
import com.example.demo.repository.repository;
import com.example.demo.service.service;


//@ComponentScan(basePackages = "com.example.demo.service")
@SpringBootApplication
@EnableElasticsearchRepositories
@RestController
public class ElasticSearchDemoApplication {
//	
//	@Autowired 
//	public entity ent ;
	
//	@Autowired
//	public controller cont ;
	
	@Autowired
	public service serv ;
	
	@Autowired
	public repository repo ;
	
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

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDemoApplication.class, args);
	}

}
