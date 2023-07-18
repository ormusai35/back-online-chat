package com.restapi.onlinechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.onlinechat.model.User;
import com.restapi.onlinechat.service.UserService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path="create-user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
	}
}
