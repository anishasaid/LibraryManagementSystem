package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	//fetch all user
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	
	//save new user
	public User save(User user) {
		return userRepo.save(user);
	}
}











