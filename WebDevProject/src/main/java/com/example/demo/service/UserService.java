package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserReopsitory;

@Service
public class UserService {

	@Autowired
	private UserReopsitory repo;

	public UserService() {}
	
	public UserService(UserReopsitory repo) {
		super();
		this.repo = repo;
	}
	
	public void saveMyUser(User user) {
		
		repo.save(user);
	}
	
	public Iterable<User> getAllUser(){
		return repo.findAll();
	}
	public Iterable<User> deleteUserByUsername(String username){
		repo.deleteByUsername(username);
		return repo.findAll();
	}
	public User findByUsername(String username) {
		return repo.findByUsername(username);
		
	}
}
