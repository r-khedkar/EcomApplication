package com.ecom_application.EcomApplication.controller;

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

import com.ecom_application.EcomApplication.entity.User;
import com.ecom_application.EcomApplication.service.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServices userServices;

	// @RequestMapping(value = "/userList", method = RequestMethod.GET)
	// @GetMapping("/userList")
	
	@GetMapping
	public ResponseEntity<List<User>> getUsersList() {
		return new ResponseEntity<>(userServices.fectUsersList(), HttpStatus.OK);
	}

	// @PostMapping("/addUser")
	
	@PostMapping
	public String addUser(@RequestBody User user) {
		userServices.createUser(user);
		return "User added successfully";
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userServices.getUserById(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
		boolean isUpdated = userServices.updateUser(id, updatedUser);
		if (isUpdated) {
			return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
