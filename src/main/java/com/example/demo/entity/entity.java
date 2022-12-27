package com.example.demo.entity;

//import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
//import org.elasticsearch.index.engine.Engine.Index;
//import org.elasticsearch.index.query.SearchIndexNameMatcher;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.example.demo.IndexName.IndexName;


@Document(indexName=IndexName.Index_name)
//@Data

public class entity {

	
	@Id
	private int id ;
	private String fname ;
	private String mname ;
	private String lname ;
	private String number ;
	private String age ;
	private String gender ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "entity [id=" + id + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", number=" + number
				+ ", age=" + age + ", gender=" + gender + "]";
	}
	public entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
