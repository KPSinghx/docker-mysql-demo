package com.portal.auto.controller;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.auto.bean.Person;
import com.portal.auto.repository.PersonRepository;

@RestController
@RequestMapping("/person")	
public class PersonController {

	@Autowired
	private PersonRepository repository;
	
	@RequestMapping("/list")
	public String list() {
	    //Person p = this.repository.findAll().iterator().next();
	    StringBuilder sb = new StringBuilder();
	    Iterator<Person> ip = this.repository.findAll().iterator();
	    while(ip.hasNext()){
	    	sb.append(ip.next());
	    }
	    return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/manual")
	public String manual() {
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("name", "Hello");
		arr.add(obj);
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "JSON");
		arr.add(obj1);
		return arr.toJSONString();
	}
}
