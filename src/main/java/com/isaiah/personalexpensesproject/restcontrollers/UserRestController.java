package com.isaiah.personalexpensesproject.restcontrollers;

import com.isaiah.personalexpensesproject.objects.User;
import com.isaiah.personalexpensesproject.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserRestController {
	
	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private UserService userService;
	
	//Get user by ID
	@GetMapping(value = "/id/{userid}", produces = "application/json")
	@CrossOrigin(origins = LOCALHOST)
	public User getUser(@PathVariable long userid) {
		return userService.readUserByUserid(userid);
	}
	
	
	//Get user by username
	@GetMapping(value = "/username/{username}", produces = "application/json")
	@CrossOrigin(origins = LOCALHOST)
	public User getUserByUsername(@PathVariable String username) {
		return userService.readUserByUsername(username);
	}
	
	//Post create a new user
	@PostMapping(value = "/create", consumes = JSON, produces = JSON) 
	@CrossOrigin(origins = LOCALHOST)
	public User createUser(@RequestBody User user) {
		user = userService.createUser(user);
		return user;
	}
	
	
	//Put update user
	@PutMapping(value = "/update/{userid}", consumes = JSON, produces = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public User updateUser(@PathVariable long userid, @RequestBody User user) {
		User existingUser = userService.readUserByUserid(userid);
		
		if(existingUser != null) {
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			existingUser.setEmail(user.getEmail());
			userService.updateUser(existingUser);
			return existingUser;
		} else {
			return null;
		}
	}
	
	//Delete a user by id
	@DeleteMapping(value = "/delete/{userid}")
	@CrossOrigin(origins = LOCALHOST)
	public void deleteUser(@PathVariable long userid) {
		userService.deleteUserByUserid(userid);
	}

}
