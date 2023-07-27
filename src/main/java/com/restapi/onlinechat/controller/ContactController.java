package com.restapi.onlinechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.service.ContactService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService; 
	
	@GetMapping(path="get-all-contacts")
	public ResponseEntity<List<Contact>> getAll(){
		return ResponseEntity.ok(this.contactService.getAllContacts());
	}
	
	@PostMapping(path="add-contact")
	public ResponseEntity<Contact> addContact(@RequestBody Contact newContact){
		Contact contact = this.contactService.addContact(newContact);
		System.out.println(contact);
		if(contact != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(contact);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(contact);
		}
		
	}
	
}
