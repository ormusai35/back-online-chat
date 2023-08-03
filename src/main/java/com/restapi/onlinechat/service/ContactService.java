package com.restapi.onlinechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.model.User;
import com.restapi.onlinechat.repository.ContactRepository;
import com.restapi.onlinechat.repository.UserRepository;

@Service
public class ContactService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	public Contact addContact(Contact newContact, long userId) {
		User user = userRepository.findById(userId).get();
		newContact.setUser(user);
		return contactRepository.save(newContact);
	}

	public Contact getContactById(long contactId) {
		return contactRepository.findById(contactId).get();
	}
	
}
