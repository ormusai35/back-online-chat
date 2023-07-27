package com.restapi.onlinechat.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.repository.ContactRepository;

@Component
public class MainDataLoader implements CommandLineRunner {

	private ContactRepository contactRepository;
	
	public MainDataLoader(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		contactRepository.save(new Contact("Asaf", "https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_01.jpg", "offline"));
	}
}
