package com.restapi.onlinechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.onlinechat.model.User;
import com.restapi.onlinechat.service.UserService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping(path="login")
	public ResponseEntity<User> login(@RequestParam String userName, @RequestParam String password){
		User user = userService.getUserByUsername(userName);
		System.out.println(user);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
        }

        if (userService.passwordMatches(password, user.getPassword())) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
        }
	}
	
	@PostMapping(path="create-user")
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		System.out.println(newUser);
		User user = userService.saveUser(newUser);
		if(user != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(user);
		}
		
	}
}
