package com.restapi.onlinechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	public Contact addContact(Contact newContact) {
		return contactRepository.save(newContact);
	}
	
}
