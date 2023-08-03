package com.restapi.onlinechat.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.model.User;
import com.restapi.onlinechat.repository.ContactRepository;
import com.restapi.onlinechat.repository.UserRepository;

@Component
public class MainDataLoader implements CommandLineRunner {

	private UserRepository userRepository;
	private ContactRepository contactRepository;
	
	public MainDataLoader(UserRepository userRepository, ContactRepository contactRepository) {
		this.userRepository = userRepository;
		this.contactRepository = contactRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("or@gmail.com");
		user.setPassword("123");
		user.setUserName("ormusa");
		userRepository.save(user);
		
		Contact contact = new Contact("Asaf", "https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_01.jpg", "offline");
		contact.setUser(user);
		contactRepository.save(contact);
	}
}
