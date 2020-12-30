package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@Transactional

public class FirstRestController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/save-user")
	@Transactional
	@CrossOrigin
	public String registerUser(@RequestBody User user) {
		userservice.saveMyUser(user);
		return "Hello ! "+user.getFirstname()+" "+user.getLastname()+" , "+" your registration is succesful!";
	}
	
	@GetMapping("/all-users")
	@CrossOrigin
	public Iterable<User> showAllUsers(){
		return userservice.getAllUser();
	}
	
	@GetMapping("/delete/{username}")
	@Transactional
	@CrossOrigin
	public Iterable<User> deleteUser(@PathVariable String username){
		return userservice.deleteUserByUsername(username);
	}
	
	@GetMapping("/search/{username}")
	@CrossOrigin
	public User searchUser(@PathVariable String username) {
		return userservice.findByUsername(username);
	}
}
