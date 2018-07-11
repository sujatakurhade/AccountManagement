package com.accountManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
	@GetMapping("/account")
	public List<User> getAllUsersDetails(){
		return userService.fetchAll();
	}
	
	@GetMapping("/account/{id}")
	public User getSpecificUserDetail(@PathVariable("id") Long id){
		return userService.fetchOne(id);
	}
	
	@PostMapping("/account/createUser")
	public User createUser(@RequestBody User user){
		User savedUser= userService.createUser(user);
		return savedUser;
	}
	
	@PutMapping("/account/updateUser")
	public User updateUserDetail(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		return updatedUser;
	}
	
	@DeleteMapping("/account/deleteUser/{id}")
	public void deleteUserDetail(@PathVariable("id") Long id){
		userService.removeUser(id);
	}

}
