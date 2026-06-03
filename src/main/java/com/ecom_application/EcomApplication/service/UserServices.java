package com.ecom_application.EcomApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom_application.EcomApplication.entity.User;
import com.ecom_application.EcomApplication.repository.UserRepository;

@Service
public class UserServices {

	private final UserRepository userRepository;
	
	// Notes :
	// Constructor injection of UserRepository
	// Constructor Injection (Recommended)
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public List<User> fectUsersList() {
		return userRepository.findAll();
	}

	public void createUser(User user) {
		userRepository.save(user);
	}

	public User getUserById(Long id) {
		// User user = usersList.stream()
		// .filter(u -> u.getId().equals(id))
		// .findFirst()
		// .orElse(null);
		// return user; // Return null if user not found
		return userRepository.findById(id).orElse(null);
	}

	public boolean updateUser(Long id, User updatedUser) {
		/*
		return usersList.stream().filter(u -> u.getId().equals(id)).findFirst().map(user -> {
			user.setFirstName(updatedUser.getFirstName());
			user.setLastName(updatedUser.getLastName());
			user.setEmail(updatedUser.getEmail());
			return true;
		}).orElse(false);
		*/
		return userRepository.findById(id).map(user -> {
			user.setFirstName(updatedUser.getFirstName());
			user.setLastName(updatedUser.getLastName());
			user.setEmail(updatedUser.getEmail());
			userRepository.save(user);
			return true;
		}).orElse(false);
	}
}
