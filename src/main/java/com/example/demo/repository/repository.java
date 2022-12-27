package com.example.demo.repository;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.entity;


@Repository
public interface repository extends ElasticsearchRepository<entity, String> {

	@Bean
	public static SearchRequest buildsearchrequest (String text) {
		 QueryBuilder searchQuery=getQueryBuilder(text);
		  
		  final BoolQueryBuilder boolQuery = QueryBuilders.boolQuery().must(searchQuery);
		  SearchSourceBuilder builder = new SearchSourceBuilder().postFilter(boolQuery);
		  
		  final SearchRequest request = new SearchRequest("entity");
       request.source();

       return request;
	}
	 @Bean
		private static QueryBuilder getQueryBuilder(String text) {
		  
			final MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(text)
					.field("firstname").field("patientMob")
	              .type(MultiMatchQueryBuilder.Type.BEST_FIELDS);
			System.out.println(queryBuilder);
	              
			return queryBuilder;
			
		}
	
	
}
