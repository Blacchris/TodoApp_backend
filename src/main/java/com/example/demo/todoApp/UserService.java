package com.example.demo.todoApp;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	List<User> getUsers () {
		return userRepository.findAll();
	}
	
	User addUser (User user) {
		return userRepository.save(user);
	}
}
