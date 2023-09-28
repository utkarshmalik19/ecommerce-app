package com.utkarsh.ecommercebackend.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utkarsh.ecommercebackend.pojo.User;
import com.utkarsh.ecommercebackend.pojo.UserLogin;
import com.utkarsh.ecommercebackend.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/user/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		userService.registerUser(user);
		return ResponseEntity.ok("Registered successfully");
	}
	@PostMapping("/user/login")
	public ResponseEntity<String> loginUser(@RequestBody UserLogin user){
		boolean isAuthenticated = userService.loginUser(user.getEmail(), user.getPassword());
		if(isAuthenticated) {
			return ResponseEntity.ok("{\"message\": \"Login Successful\"}");	
		}
		return ResponseEntity.ok("Login Unsucessful");
	}
}
