package com.accountManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accountManager.model.User;
import com.accountManager.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getTestUser() {
		return "Hello World";
	}
	
	@RequestMapping(value="/account",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsersDetails(){
		return userService.fetchAll();
	}
	
	@RequestMapping(value="/account/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public User getSpecificUserDetail(@PathVariable("id") Long id){
		return userService.fetchOne(id);
	}
	
	@RequestMapping(value="/account/createUser",
			method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String CreateUser(@RequestBody User user){
		
		return null;
	}
	
	@RequestMapping(value="/account/updateUser",
			method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateUserDetail(@RequestBody User user){
		return null;
	}
	
	@RequestMapping(value="/account/deleteUser",
			method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String deleteUserDetail(@RequestBody User user){
		return null;
	}

}
