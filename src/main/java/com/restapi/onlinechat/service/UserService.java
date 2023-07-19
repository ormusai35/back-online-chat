package com.restapi.onlinechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restapi.onlinechat.model.User;
import com.restapi.onlinechat.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUserByUsername(String userName) {
		return userRepository.findByUserName(userName).stream().findFirst().orElse(null);
	}

	public boolean passwordMatches(String password, String userPassword) {
		return password.equals(userPassword);
	}
	
	

}
