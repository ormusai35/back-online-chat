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
		User user1 = new User();
		user1.setEmail("or@gmail.com");
		user1.setUserName("or");
		user1.setPassword("12345678");
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setEmail("s@gmail.com");
		user2.setUserName("s");
		user2.setPassword("11111111");
		userRepository.save(user2);
		
		Contact contact = new Contact("Asaf", "https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_01.jpg", "offline");
		contact.setUser(user1);
		contactRepository.save(contact);
	}
}
