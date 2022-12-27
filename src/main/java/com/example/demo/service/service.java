package com.example.demo.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.entity;
import com.example.demo.repository.repository;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class service {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	@Autowired
	private final RestHighLevelClient client ;
	
	public service (RestHighLevelClient client) {
		this.client = client ;
	}
	
	
	
//	public service(RestHighLevelClient client, repository repo) {
//		super();
//		this.client = client;
//		this.repo = repo;
//	}



	@Autowired
	public repository repo ;
	
	 public List<entity> search(String text) {
	        final SearchRequest request =repository.buildsearchrequest (text);
	        return searchInternal(request);
	    }

	private List<entity> searchInternal(final SearchRequest request) {
		if (request==null) {	
		return Collections.emptyList();
		}
		 try {
	            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);

	            final SearchHit[] searchHits = response.getHits().getHits();
	            final List<entity> entitys = new ArrayList<>(searchHits.length);
	            for (SearchHit hit : searchHits) {
	                entitys.add(
	                        MAPPER.readValue(hit.getSourceAsString(),entity.class)
	                );
	            }

	            return entitys;
	        } catch (Exception e) {
	           
	            return Collections.emptyList();
	        }
	}
	
	 public void saveentity(List<entity> entities)
	    {
	    	repo.saveAll(entities);
	    }

		public Iterable<entity> findAllentity() {
			
		return repo.findAll();
		}

}
