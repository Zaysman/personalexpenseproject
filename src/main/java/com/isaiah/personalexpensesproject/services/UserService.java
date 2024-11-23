package com.isaiah.personalexpensesproject.services;

import com.isaiah.personalexpensesproject.objects.User;
import com.isaiah.personalexpensesproject.repositories.UserRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User createUser(User user) {
		Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser.isPresent()) {
			throw new RuntimeException("Username already exists");
		}
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	public User readUserByUserid(long userid) {
		return userRepository.findByid(userid).orElse(null);
	}
	
	public User readUserByUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	
	@Transactional
	public void deleteUserByUserid(long userid) {
		userRepository.deleteByid(userid);
	}

}
