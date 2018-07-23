package com.accountManager.controller;

import java.util.List;

import com.accountManager.model.User_Account;
import com.accountManager.service.UserAccountService;
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

	@Autowired
	private UserAccountService userAccountService;

	@GetMapping("/")
	public void SayHi(){
		System.out.println("Hello");
	}
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

	@GetMapping("/account/getAllUserBalance")
	public List<User_Account> getAllUserBalances(){
		return userAccountService.findAll();
	}

	@GetMapping("/account/getBalance/{user_id}")
	public User_Account viewBalance(@PathVariable("user_id") Long user_id){
		return userAccountService.fetchBalance(user_id);
	}

	@PostMapping("/account/transferFund/sourceId/{1}/destinationId/{user_id}")
	public User_Account transferFund(@PathVariable("user_id")Long user_id){
		return userAccountService.transferFund(user_id);
	}
}
