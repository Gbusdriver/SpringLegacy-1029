package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController: @Controller + @ResponseBody(java -> json)
@RestController
public class HomeController {	
	
	@GetMapping(value = "/hello")
	public String home() {		
		return "hello, rest service!!!";//view name x, data
	}
	
	@GetMapping(value = "/hello2")
	public User home2() {		
		return new User("kim", "jane kim");//view name x, data
	}	
}


class User{
	String id, name;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
}






