package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserReopsitory extends CrudRepository<User, Integer>{

	public Iterable<User> deleteByUsername(String username);
	public User findByUsername(String username);
}
