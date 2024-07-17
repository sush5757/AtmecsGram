package com.atmecsgram.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmecsgram.user.dto.LoginDto;
import com.atmecsgram.user.dto.UserDto;
import com.atmecsgram.user.model.User;
import com.atmecsgram.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	 @PostMapping("/login")
	    public ResponseEntity<User> login(@RequestBody LoginDto loginRequest) {
	        User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
	        if (user != null) {
	            return new ResponseEntity<>(user, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	        }
	    }
	
	@PostMapping("/signup")
	public ResponseEntity<User> createUser(@RequestBody UserDto userdto) {
		User createdUser = userService.createUser(userdto);
		return ResponseEntity.ok(createdUser);

	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allusers = userService.getAllUsers();
		return ResponseEntity.ok(allusers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
		User updateUser = userService.updateUser(id, userDto);
		
		return ResponseEntity.ok(updateUser);
	}
	

}
